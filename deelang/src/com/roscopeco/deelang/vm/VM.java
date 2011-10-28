/* VM.java - The DeeLang Virtual Machine.
 *
 * Copyright 2011 Ross Bamford (roscopeco AT gmail DOT com)
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.roscopeco.deelang.vm;

import java.io.DataInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.NoSuchElementException;

import com.roscopeco.deelang.Opcodes;
import com.roscopeco.deelang.compiler.CompiledScript;
import com.roscopeco.deelang.runtime.DeeLangInteger;
import com.roscopeco.deelang.runtime.DeeLangString;

/**
 * The DeeLang Virtual Machine. 
 * 
 * @author rosco
 * @created 16 Oct 2011
 *
 */
public class VM {  
  public VM() { }
  
  public Context createContext(CompiledScript script) {
    return new Context(this, script);
  }
  
  private Method findMethodForArgs(Object receiver, String name, Object[] args) {
    Method[] methods = receiver.getClass().getMethods();
    methodLoop: for (Method m : methods) {
      Class<?>[] argtypes = m.getParameterTypes();
      if (m.getName().equals(name) && argtypes.length == args.length) {
        // possible...
        for (int i = 0; i < argtypes.length; i++) {
          if (!argtypes[i].isAssignableFrom(args[i].getClass())) {
            continue methodLoop;
          }
        }
        return m;
      }
    }
    return null;
  }
  
  boolean debug(String s) {
    System.out.println(s);
    return true;
  }
  
  /**
   * Single-step the VM. 
   * 
   * @param ctx The Context.
   * 
   * @throws RuntimeError
   */
  public void step(Context ctx) throws RuntimeError {
    step(ctx, ctx.codeStrm);
  }

  @SuppressWarnings("deprecation")
  /**
   * Single-step the VM, using the specified input stream for the code.
   * This allows us to run blocks from a different stream.
   * 
   * @param ctx The context.
   * @param strm The code stream.
   * 
   * @throws RuntimeError
   */
  void step(Context ctx, DataInputStream strm) throws UnsupportedOperationError, 
                                                      NoSuchMethodError,
                                                      JavaMethodError,
                                                      ReflectiveAccessError,
                                                      CodeUnderflowError,
                                                      InputError {
    try {
      // This needs to be cleared, unless the current op is invokeself on 
      // 'or' - this is how the compiler handles the or construct, so we
      // handle it specially. If the flag was set and this turns out to be
      // such an invocation, we'll set it again before we call out to the
      // method.
      boolean errorWasSet = ctx.errorFlag;
      ctx.errorFlag = false;
      
      if (strm.available() > 0) {
        byte op = strm.readByte();
        int intOper;
        byte byteOper;
        
        switch (op) {
        case Opcodes.NOP:
          return;
        case Opcodes.IPUSH:
        case Opcodes.FPUSH:
        case Opcodes.SPUSH:
          throw new UnsupportedOperationError("IPUSH is no longer supported");
        case Opcodes.IPUSHCONST:
          intOper = strm.readInt();
          ctx.stack.addFirst(new DeeLangInteger(ctx, (Integer)ctx.pool[intOper].getValue()));
          return;
        case Opcodes.FPUSHCONST:
          intOper = strm.readInt();
          ctx.stack.addFirst(ctx.pool[intOper].getValue());
          return;
        case Opcodes.SPUSHCONST:
          intOper = strm.readInt();
          ctx.stack.addFirst(new DeeLangString(ctx, (String)ctx.pool[intOper].getValue()));
          return;
        case Opcodes.POP:
          ctx.stack.removeFirst();
          return;
        case Opcodes.STORE:
          intOper = strm.readByte();
          ctx.locals[intOper] = ctx.stack.removeFirst();
          return;
        case Opcodes.LOAD:
          intOper = strm.readByte();
          ctx.stack.addFirst(ctx.locals[intOper]);
          return;
        case Opcodes.PUTFIELD:
          intOper = strm.readInt();
          Object value = ctx.stack.removeFirst();
          Object receiver = ctx.stack.removeFirst();
          try {
            Field f = receiver.getClass().getDeclaredField((String)ctx.pool[intOper].getValue());
            f.set(receiver, value);
          } catch (NoSuchFieldException e) {
            throw new NoSuchFieldError("No such field '" + ctx.pool[intOper].getValue() + "' on object '" + receiver + "'");
          } catch (IllegalAccessException e) {
            throw new ReflectiveAccessError(e);
          }
          return;
        case Opcodes.GETFIELD:
          intOper = strm.readInt();
          receiver = ctx.stack.removeFirst();
          try {
            Field f = receiver.getClass().getDeclaredField((String)ctx.pool[intOper].getValue());
            ctx.stack.addFirst(f.get(receiver));
          } catch (NoSuchFieldException e) {
            throw new NoSuchFieldError("No such field '" + ctx.pool[intOper].getValue() + "' on object '" + receiver + "'");
          } catch (IllegalAccessException e) {
            throw new ReflectiveAccessError(e);
          }
          return;
        case Opcodes.ADD:
        case Opcodes.SUB:
        case Opcodes.MUL:
        case Opcodes.DIV:
        case Opcodes.MOD:
        case Opcodes.POW:
          throw new UnsupportedOperationError("Static arithmetic is not supported");
        case Opcodes.INVOKESTATIC:
          throw new UnsupportedOperationError("Static dispatch is no longer supported");
        case Opcodes.INVOKESELF:
        case Opcodes.INVOKEDYNAMIC:
          intOper = strm.readInt();     // index of method name
          byteOper = strm.readByte();   // argc
          
          Object args[] = new Object[byteOper];
          
          for (int i = byteOper - 1; i > -1; i--) {
            args[i] = ctx.stack.removeFirst();
          }
          
          String name = (String)ctx.pool[intOper].getValue();
          receiver = (op == Opcodes.INVOKESELF) ? ctx.self : ctx.stack.removeFirst();
          
          // special handling for 'or' - put errorFlag value back
          if ("or".equals(name)) {
            ctx.errorFlag = errorWasSet;
          }

          assert debug("Invoking method '" + name + "' on " + receiver);
          
          Method m = findMethodForArgs(receiver, name, args);
          if (m == null) {
            String argTypes;
            if (args.length > 0) {
              StringBuffer sb = new StringBuffer();
              for (Object arg : args) {
                sb.append(arg.getClass());
                sb.append(", ");
              }
              argTypes = sb.toString();
            } else {
              argTypes = "<void>";
            }
            throw new NoSuchMethodError("Method '" + receiver.getClass().getSimpleName() + '.' + name + "' not found for these argument types: (" + argTypes + ")");
          } else {
            Object retval;
            
            try {
              retval = m.invoke(receiver, args);
              assert debug("Method '" + name + "' returned '" + retval + "'");
            } catch (InvocationTargetException e) {
              throw new JavaMethodError(e);              
            } catch (IllegalAccessException e) {
              throw new ReflectiveAccessError(e);
            }
            if (!m.getReturnType().equals(void.class)) {
              ctx.stack.addFirst(retval);
            }
          }
          return;
        case Opcodes.BLOCKRETURN:
          throw new UnsupportedOperationError("BLOCKRETURN is no longer supported");
        case Opcodes.JUMP_B:
          strm.skip(strm.readByte());
          break;
        case Opcodes.JUMP_W:
          strm.skip(strm.readShort());
          break;
        case Opcodes.JUMP_L:
          strm.skip(strm.readInt());
          break;
        default:
          throw new UnsupportedOperationError(String.format("Unrecognized opcode: 0x%02x", op));
        }
      } else {
        throw new CodeUnderflowError();
      }
    } catch (IOException e) {
      throw new InputError(e);
    } catch (NoSuchElementException e) {
      throw new StackUnderflowError();
    }
  }
  
  /**
   * Run the script associated in the supplied context.
   * 
   * @param ctx The context.
   * 
   * @throws RuntimeError
   */
  public void run(Context ctx) throws RuntimeError {
    try {
      while (ctx.codeStrm.available() > 0) {
        step(ctx);
      }
    } catch (IOException e) {
      throw new InputError(e);
    }
  }
  
  private boolean skipJump(DataInputStream strm) throws InputError {
    try {
      switch (strm.readByte()) {
      case Opcodes.JUMP_B:
        strm.skip(1);
        break;
      case Opcodes.JUMP_W:
        strm.skip(2);
        break;
      case Opcodes.JUMP_L:
        strm.skip(4);
        break;
      default:
        return false;
      }
    } catch (IOException e) {
      throw new InputError(e);
    }
    return true;
  }
  
  /**
   * Used by the runtime to execute method blocks. This expects
   * that the next instruction is a JUMP_x followed by an appropriate
   * ENTERBLOCK_x instruction.
   * 
   * @param ctx The context
   * @return True if a block was executed, false otherwise.
   * @throws RuntimeError
   */
  public boolean runBlock(Context ctx) throws UnsupportedOperationError, 
                                              NoSuchMethodError,
                                              JavaMethodError,
                                              ReflectiveAccessError,
                                              CodeUnderflowError,
                                              InputError {
    try {
      int len;
      BytecodeInputStream bcis = ctx.bcis;
      DataInputStream codeStrm = ctx.codeStrm;
      int jumpPC = bcis.getPc();
      codeStrm.mark(10);

      // skip JUMP insn
      if (!skipJump(codeStrm)) {
        codeStrm.reset();
        return false;       // no jump = no block
      }
      
      switch (codeStrm.readByte()) {
      case Opcodes.ENTERBLOCK_B:
        len = codeStrm.readByte();
        break;
      case Opcodes.ENTERBLOCK_W:
        len = codeStrm.readShort();
        break;
      case Opcodes.ENTERBLOCK_L:
        len = codeStrm.readInt();
        break;
      default:
        codeStrm.reset();
        return false;
      }
      
      int endpc = bcis.getPc() + len;
      while (bcis.getPc() < endpc) {
        step(ctx, codeStrm);
      }
      
      // rewind stream, so we can have multiple invocations of the same block...
      bcis.setPc(jumpPC);
      
      return true;
    } catch (IOException e) {
      throw new InputError(e);
    }
  }
}
 