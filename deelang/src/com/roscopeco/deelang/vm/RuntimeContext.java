/* RuntimeContext.java - RuntimeContext within which the VM runs scripts.
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
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.HashMap;

import com.roscopeco.deelang.vm.compiler.CompiledScript;

import dee.lang.Binding;
import dee.lang.DeelangFloat;
import dee.lang.DeelangInteger;
import dee.lang.DeelangObject;

/**
 * <p>RuntimeContext within which the VM runs scripts. The context
 * contains the code, bindings, outer-scope SELF object,
 * state and variables for the script's execution.</p>
 *   
 * @author rosco
 * @created 16 Oct 2011
 */
public class RuntimeContext implements Binding {
  // TODO don't like this, highly couples vm and runtime...
  
  public final DeelangInteger ZERO = new DeelangInteger(this, 0);
  public final DeelangFloat FZERO = new DeelangFloat(this, 0d);
  
  final VM vm;
  final CompiledScript script;
  final byte[] code;
  final CompiledScript.ConstPoolEntry[] pool;
  final BytecodeInputStream bcis;
  final DataInputStream codeStrm;
  final Object locals[];
  final ArrayDeque<Object> stack = new ArrayDeque<Object>();
  boolean errorFlag = false;
  
  // any set of locals not used by the script will result in that local being
  // stored here, just in case user asks for it back later via getLocal(name).
  final HashMap<String, Object> unusedLocals = new HashMap<String, Object>();
  
  DeelangObject self;
  
  protected RuntimeContext(VM vm, CompiledScript script) {
    this.vm = vm;
    this.script = script;
    this.locals = new Object[script.getLocalsTable().length];
    this.code = script.getCode();
    codeStrm = new DataInputStream(bcis = new BytecodeInputStream(code));
    this.pool = script.getConstPool();
  }

  public DeelangObject getSelf() {
    return self;
  }

  public void setSelf(DeelangObject self) {
    this.self = self;
  }

  public CompiledScript getScript() {
    return script;
  }

  public Object[] getLocals() { return locals; }
  
  byte findLocalSlot(String name) {
    String[] localTable = script.getLocalsTable();
    
    for (byte i =0; i < localTable.length; i++) {
      if (localTable[i].equals(name)) {
        return i;
      }
    }
    
    return -1;
  }
  
  public Object getLocal(byte slot) throws BadLocalSlotError { 
    if ((slot < 0) || (slot >= locals.length)) {
      throw new BadLocalSlotError("" + slot);
    }
    return locals[slot]; 
  }
  
  public Object getLocal(String name) throws UnknownVariableError { 
    byte slot = findLocalSlot(name);
    
    if (slot != -1) {
      return locals[slot]; 
    } else {
      return unusedLocals.get(name);
    }    
  }
  
  public void setLocal(byte slot, Object value) throws BadLocalSlotError {
    if ((slot < 0) || (slot >= locals.length)) {
      throw new BadLocalSlotError("" + slot);
    }
    locals[slot] = value; 
  }
  
  public void setLocal(String name, Object value) {
    byte slot = findLocalSlot(name);
    
    // if slot is -1, var is not found in locals table - unused
    if (slot != -1) {
      locals[slot] = value;
    } else {
      // store it in the map in case user asks for it back later in getLocal(name)...
      unusedLocals.put(name, value);
    }
  }

  public VM getVm() {
    return vm;
  }

  public byte[] getCode() {
    return code;
  }

  public CompiledScript.ConstPoolEntry[] getPool() {
    return pool;
  }

  public DataInputStream getCodeStrm() {
    return codeStrm;
  }
  
  public void setErrorFlag() {
    this.errorFlag = true;
  }
  
  public void clearErrorFlag() {
    this.errorFlag = false;
  }
  
  public boolean isErrorFlagSet() {
    return this.errorFlag;
  }
  
  public boolean isBlockNext() throws InputError {
    DataInputStream strm = codeStrm;
    
    try {
      strm.mark(6);

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
        // no jump means no block - return false
        strm.reset();
        return false;
      }
      
      // still need to check if there's a block insn, in case we just
      // happen to have a JUMP after a method call... 
      if ((strm.readByte() == Opcodes.ENTERBLOCK_B) ||
          (strm.readByte() == Opcodes.ENTERBLOCK_W) ||
          (strm.readByte() == Opcodes.ENTERBLOCK_L)) {
        strm.reset();
        return true;        
      } else {
        strm.reset();
        return false;
      }
    } catch (EOFException e) {
      // no block, got EOF - return false
      return false;
    } catch (IOException e) {
      // General IOE - throw
      throw new InputError(e);
    }    
  }
    
  public boolean runBlock() throws UnsupportedOperationError, 
                                   NoSuchMethodError,
                                   JavaMethodError,
                                   ReflectiveAccessError,
                                   CodeUnderflowError,
                                   InputError {
    return vm.runBlock(this);
  }
}
