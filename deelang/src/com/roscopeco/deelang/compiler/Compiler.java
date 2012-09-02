/* Compiler.java - The DeeLang compiler.
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
package com.roscopeco.deelang.compiler;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Set;

import com.roscopeco.deelang.Opcodes;
import com.roscopeco.deelang.parser.DeeLangParser;
import com.roscopeco.deelang.parser.Parser;
import com.roscopeco.deelang.parser.ParserError;

import org.antlr.runtime.tree.Tree;


/**
 * The DeeLang compiler. This class takes an AST output by
 * the DeeLangParser and transforms it to a fully resolved
 * {@link CompiledScript}.
 * <br/>
 * <strong>Note</strong>: Running this class with assertions enabled
 * will make it print debugging information!
 * 
 * @author rosco
 * @created 16 Oct 2011
 *
 */
public class Compiler {
  private static final byte[] EMPTY_ARRAY = new byte[0];
  
  /**
   * Convenience method to just compile an AST and return the compiled script.
   * 
   * @param ast The AST to compile.
   * @return The compiled script.
   * @throws CompilerError If a compilation error occurs.
   */
  public static CompiledScript staticCompile(Tree ast) throws CompilerError {
    return new Compiler().compile(ast);
  }
  
  /**
   * Convenience method to just parse and compile a string and return the compiled
   * script. This method uses the parser with default options.
   * 
   * @param code The code to compile.
   * @return The compiled script.
   * @throws ParserError If a parse error occurs.
   * @throws CompilerError If a compilation error occurs.
   */
  public static CompiledScript staticCompile(String code) 
      throws ParserError, CompilerError {
    return staticCompile(Parser.staticParse(code));
  }
  
  /**
   * <p>A compilation unit. This encapsulates all data and visitor logic
   * for the script being compiled.</p>
   * 
   * <p>The DeeLang compiler uses the visitor pattern to compile the
   * AST into a compiled script, driving the actual visiting and calling
   * back to this class for each tree node. This class is responsible
   * for maintaining state as needed and generating the actual code 
   * (in the <code>visitXXX</code> methods). Once the compile is 
   * complete, the {@link #buildScript} method is called to generate
   * the final {@link CompiledScript} object containing the code,
   * constant pool and locals table.</p>
   */
  public class CompilationUnit extends ASTVisitor {
    /** key class for the constpool hash. Type is
     * the type from CompiledScript. Constant
     * is the actual constant value.
     */
    protected class ConstPoolKey {
      byte type;
      Object constant;
      
      ConstPoolKey(Object constant, byte type) {
        this.constant = constant;
        this.type = type;
      }
      
      @Override
      public boolean equals(Object other) {
        return (other instanceof CompilationUnit.ConstPoolKey) &&
               ((CompilationUnit.ConstPoolKey)other).type == type && 
               ((CompilationUnit.ConstPoolKey)other).constant.equals(constant);
      }
      
      @Override
      public int hashCode() {
        return constant.hashCode() & type;
      }
    }
    
    /**
     * Holds the current constant pool entry count. Used to allocate the next
     * pool index during compilation.
     */
    protected int poolEntryCount = 0;
    
    /** holds the const pool, and is converted to a final const pool array with
     * indices matching those in the bytecode by the buildConstPool method.
     * Key is a ConstPoolKey object, and value is the
     * numeric index that was assigned to this const
     * during compilation (it's position in the
     * final output const pool array as referenced
     * from the bytecode).
     */
    protected final HashMap<CompilationUnit.ConstPoolKey, Integer> constPoolEntries = new HashMap<CompilationUnit.ConstPoolKey, Integer>(); 
    
    /** 
     * Holds the local var name to slot mappings.
     */
    protected final HashMap<String, Byte> locals = new HashMap<String, Byte>();
    
    /**
     * The current number of locals. Used to calculate the next available local slot.
     */
    protected byte localCount = 0;
    
    /** 
     * The byte array stream used to generate code. Writes don't go directly,
     * but always through strm instead.
     */
    ByteArrayOutputStream code = new ByteArrayOutputStream();    
    
    /** 
     * The DataOutputStream that code is generated to.
     */
    protected DataOutputStream codeStrm = new DataOutputStream(code);
    
    /**
     * <p>Used to pass data back to higher tree nodes during the compile.
     * This is used in different ways for different AST types, for example
     * the METHOD_CALL handler pushes an object that is then populated with
     * the arg count and blocks by the child ARGS, BLOCK and ORBLOCK nodes.
     * This object is then popped back in METHOD_CALL after children have
     * been visited, and used to write the count and fill in the relocations
     * for the blocks to the stream.</p>
     * 
     * <p>These are used with the <code>backPassData</code> stack. To 
     * maintain consistency of this stack during compilation, every 
     * visit call that pushes a frame to the stack before visiting 
     * children <strong>must</strong> pop that frame before it returns.
     */
    protected class BackPassFrame {
      /**
       * The data being passed back. What this contains is specific
       * to the opcode being processed.
       */
      public Object data;

      protected BackPassFrame() { }
      protected BackPassFrame(Object data) {
        this.data = data;
      }
    }
    
    /**
     * BackPassData for METH_CALL opcode processing.
     */
    final class MethCallBackPassData {
      String methName;
      byte argc;
      byte[] block = EMPTY_ARRAY;
      byte[] orBlock = EMPTY_ARRAY;
      boolean selfCall;
      MethCallBackPassData(String name) { this.methName = name; }
    }
    
    /**
     * Stack of BackPassFrames used by the visitor implementation to 
     * pass data back from children to parents. 
     */
    protected ArrayDeque<CompilationUnit.BackPassFrame> backPassData = new ArrayDeque<CompilationUnit.BackPassFrame>();
    
    /**
     * Called at the end of compilation to get the generated code.
     * 
     * @return The compiled code.
     */
    protected byte[] getCode() {
      return code.toByteArray();
    }
    
    /**
     * Called at the end of compilation to build the correctly-ordered
     * constant pool for storage with the script.
     * 
     * @return The resolved and ordered constant pool.
     */
    protected CompiledScript.ConstPoolEntry[] buildConstPool() throws IllegalConstPoolTypeBug {
      HashMap<CompilationUnit.ConstPoolKey, Integer> entries = constPoolEntries;
      Set<CompilationUnit.ConstPoolKey> keys = entries.keySet();
      int entryCount = poolEntryCount;
      CompiledScript.ConstPoolEntry[] pool = new CompiledScript.ConstPoolEntry[entryCount];
      
      for (CompilationUnit.ConstPoolKey k : keys) {
        int index = entries.get(k);
        byte type = k.type;
        
        switch (type) {
        case CompiledScript.CONST_POOL_FIELD:
          pool[index] = new CompiledScript.ConstPoolField((String)k.constant);
          break;
        case CompiledScript.CONST_POOL_METHOD:
          pool[index] = new CompiledScript.ConstPoolMethod((String)k.constant);
          break;
        case CompiledScript.CONST_POOL_INT:
          pool[index] = new CompiledScript.ConstPoolInt((Integer)k.constant);
          break;
        case CompiledScript.CONST_POOL_FLOAT:
          pool[index] = new CompiledScript.ConstPoolFloat((Double)k.constant);
          break;
        case CompiledScript.CONST_POOL_STRING:
          pool[index] = new CompiledScript.ConstPoolString((String)k.constant);
          break;
        default:
          throw new IllegalConstPoolTypeBug("Unknown constant pool type: " + type);
        }
      }
      
      return pool;
    }
    
    /**
     * Called at the end of compilation to get the correctly-ordered
     * local variable table for storage with the scipt.
     * 
     * @return The local variable table, in the order expected by the bytecode.
     */
    protected String[] buildLocalsTable() {
      HashMap<String, Byte> locals = this.locals;
      
      String[] r = new String[localCount];
      for (String local : locals.keySet()) {
        r[locals.get(local)] = local;
      }
      return r;
    }
    
    /**
     * Get the const pool index for the specified const, or allocate the
     * next available if it's not in there.
     * 
     * @param constant The constant to allocate an index for.
     * @param type The type of the constant.
     * @return The allocated constant-pool index.
     */
    protected int getOrAllocConstPoolIndex(Object constant, byte type) {
      CompilationUnit.ConstPoolKey k = new ConstPoolKey(constant, type);
      Integer index;
      if ((index = constPoolEntries.get(k)) == null) {
        // alloc next constant index to it...
        index = poolEntryCount;
        constPoolEntries.put(k, poolEntryCount++);
      }
      
      return index;
    }
    
    /**
     * Get the local variable slot number for the specified var,
     * or alloc the next available if it's not in there.
     * 
     * @param varName The name of the local variable.
     * @return The allocated local slot number.
     * @throws CompilerError to indicate that the maximum number of locals (255) has been exceeded.
     */
    protected byte getOrAllocLocalSlot(String varName) throws CompilerError {
      Byte slot;
      if ((slot = locals.get(varName)) == null) {
        // new local var
        if (localCount == 255) {
          throw new MaxLocalsExceededException("Local variable limit exceeded");
        } else {
          locals.put(varName, (slot = localCount++));
        }
      }
      return slot;
    }
    
    /**
     * Called at the end of compilation to get the compiled script.
     * 
     * @return The {@link CompiledScript} resulting from the compilation.
     */
    public CompiledScript buildScript() throws CompilerError {
      return new CompiledScript(buildConstPool(), buildLocalsTable(), getCode());
    }

    /* ********************************* */
    /* * VISITOR METHODS               * */
    /* ********************************* */
    private void writeSizedNoExtra(DataOutputStream strm, byte byteSize, byte wordSize, byte longSize, int index) throws IOException, CompilerError {
      if (index <= Integer.MAX_VALUE) {
        if (index <= Short.MAX_VALUE) {
          if (index <= Byte.MAX_VALUE) {
            strm.writeByte(byteSize);
            strm.writeByte(index);
          } else {
            strm.writeByte(wordSize);
            strm.writeShort(index);
          }
        } else {
          strm.writeByte(longSize);
          strm.writeInt(index);
        }
      } else {
        throw new MaxConstPoolSizeExceededException("Constant pool cannot contain more than " + Integer.MAX_VALUE + " entries!");
      }      
    }
    
    private void writeSizedOneExtra(DataOutputStream strm, byte byteSize, byte wordSize, byte longSize, int index, byte extra) throws IOException, CompilerError {
      if (index <= Integer.MAX_VALUE) {
        if (index <= Short.MAX_VALUE) {
          if (index <= Byte.MAX_VALUE) {
            strm.writeByte(byteSize);
            strm.writeByte(index);
            strm.writeByte(extra);
          } else {
            strm.writeByte(wordSize);
            strm.writeShort(index);
            strm.writeByte(extra);
          }
        } else {
          strm.writeByte(longSize);
          strm.writeInt(index);
          strm.writeByte(extra);
        }
      } else {
        throw new MaxConstPoolSizeExceededException("Constant pool cannot contain more than " + Integer.MAX_VALUE + " entries!");
      }      
    }
    
    @Override
    protected void visitDecimalLiteral(DataOutputStream strm, Tree ast) throws CompilerError {
      int index = getOrAllocConstPoolIndex(Integer.parseInt(ast.getText()), CompiledScript.CONST_POOL_INT);
      try {
        writeSizedNoExtra(strm, Opcodes.IPUSHCONST_B, Opcodes.IPUSHCONST_W, Opcodes.IPUSHCONST_L, index);
      } catch (IOException e) {
        throw new OutputError(e);
      }
    }

    @Override
    protected void visitHexLiteral(DataOutputStream strm, Tree ast) throws CompilerError {
      String value = ast.getText();
      // Lexer handles this now...
      //value = value.substring(2, value.length());
      int index = getOrAllocConstPoolIndex(Integer.parseInt(value, 16), CompiledScript.CONST_POOL_INT);
      
      try {
        writeSizedNoExtra(strm, Opcodes.IPUSHCONST_B, Opcodes.IPUSHCONST_W, Opcodes.IPUSHCONST_L, index);
      } catch (IOException e) {
        throw new OutputError(e);
      } 
    }

    @Override
    protected void visitOctalLiteral(DataOutputStream strm, Tree ast) throws CompilerError {
      int index = getOrAllocConstPoolIndex(Integer.parseInt(ast.getText(), 8), CompiledScript.CONST_POOL_INT);
      
      try {
        writeSizedNoExtra(strm, Opcodes.IPUSHCONST_B, Opcodes.IPUSHCONST_W, Opcodes.IPUSHCONST_L, index);
      } catch (IOException e) {
        throw new OutputError(e);
      }
    }

    @Override
    protected void visitFloatLiteral(DataOutputStream strm, Tree ast) throws CompilerError {
      int index = getOrAllocConstPoolIndex(Double.parseDouble(ast.getText()), CompiledScript.CONST_POOL_FLOAT);
      
      try {
        writeSizedNoExtra(strm, Opcodes.FPUSHCONST_B, Opcodes.FPUSHCONST_W, Opcodes.FPUSHCONST_L, index);
      } catch (IOException e) {
        throw new OutputError(e);
      }
    }

    @Override
    protected void visitCharacterLiteral(DataOutputStream strm, Tree ast) throws CompilerError {
      visitStringLiteral(strm, ast);
    }

    @Override
    protected void visitStringLiteral(DataOutputStream strm, Tree ast) throws CompilerError {
      String value = ast.getText();
      value = StringEscapeUtils.unescapeJava(value.substring(1,value.length()-1));
      int index = getOrAllocConstPoolIndex(value, CompiledScript.CONST_POOL_STRING);
      
      try {
        writeSizedNoExtra(strm, Opcodes.SPUSHCONST_B, Opcodes.SPUSHCONST_W, Opcodes.SPUSHCONST_L, index);
      } catch (IOException e) {
        throw new OutputError(e);
      }
    }

    @Override
    protected void visitRegexpLiteral(DataOutputStream strm, Tree ast) throws CompilerError {
      throw new UnsupportedError("Regular expressions are not yet implemented");
    }

    @Override
    protected void visitChain(DataOutputStream strm, Tree ast) throws CompilerError {
      // Do nothing - receiver is already on stack
    }

    @Override
    protected void visitAssignLocal(DataOutputStream strm, Tree ast) throws CompilerError {
      String name = ast.getChild(0).getText();
      visit(strm, this, ast.getChild(1));
      try {
        strm.write(new byte[] { Opcodes.STORE, getOrAllocLocalSlot(name) });
      } catch (IOException e) {
        throw new OutputError(e);
      }
    }

    @Override
    protected void visitIdentifier(DataOutputStream strm, Tree ast) throws CompilerError {
      byte slot = getOrAllocLocalSlot(ast.getText());
      try {
        strm.write(new byte[] { Opcodes.LOAD, slot });
      } catch (IOException e) {
        throw new OutputError(e);
      }
    }
    
    @Override
    protected void visitAssignField(DataOutputStream strm, Tree ast) throws CompilerError {
      String name = ast.getChild(0).getText();
      visit(strm, this, ast.getChild(1));
      try {
        writeSizedNoExtra(strm, Opcodes.PUTFIELD_B, Opcodes.PUTFIELD_W, Opcodes.PUTFIELD_L, 
            getOrAllocConstPoolIndex(name, CompiledScript.CONST_POOL_FIELD));
      } catch (IOException e) {
        throw new OutputError(e);
      }
    }
    
    @Override
    protected void visitFieldAccess(DataOutputStream strm, Tree ast)
        throws CompilerError {
      visit(strm, this, ast.getChild(0));
      try {
        writeSizedNoExtra(strm, Opcodes.GETFIELD_B, Opcodes.GETFIELD_W, Opcodes.GETFIELD_L, 
            getOrAllocConstPoolIndex(ast.getChild(1).getText(), CompiledScript.CONST_POOL_FIELD));
      } catch (IOException e) {
        throw new OutputError(e);
      }
    }

    private void writeBlock(DataOutputStream strm, byte[] bpdblock) throws CompilerError, IOException {
      if (bpdblock.length > 0) {
        int bpdblocklen = bpdblock.length;
        
        if (bpdblocklen > Byte.MAX_VALUE - 2) {
          if (bpdblocklen > Short.MAX_VALUE - 3) {
            if (bpdblocklen > Integer.MAX_VALUE - 5) {
              throw new MaxBlockSizeExceededException("Compiled block cannot be more than " + Integer.MAX_VALUE / 1024 / 1024 + " MB in size!");
            } else {
              strm.writeByte(Opcodes.JUMP_L);
              strm.writeInt(bpdblocklen + 5); // also skipping 5-byte ENTERBLOCK_L... 
              strm.writeByte(Opcodes.ENTERBLOCK_L);
              strm.writeInt(bpdblocklen);
            }
          } else {
            // TODO should be doing this unsigned really...
            strm.writeByte(Opcodes.JUMP_W);
            strm.writeShort(bpdblocklen + 3); // also skipping 3-byte ENTERBLOCK_W... 
            strm.writeByte(Opcodes.ENTERBLOCK_W);
            strm.writeShort((short)bpdblocklen);
          }
        } else {
          strm.writeByte(Opcodes.JUMP_B);
          strm.writeByte(bpdblocklen + 2); // also skipping 2-byte ENTERBLOCK_B... 
          strm.writeByte(Opcodes.ENTERBLOCK_B);
          strm.writeByte((byte)bpdblocklen);
        }
        
        for (int i = 0; i < bpdblocklen; i++) {
          strm.writeByte(bpdblock[i]);
        }
      }      
    }

    @Override
    protected void visitMethodCall(DataOutputStream strm, Tree ast) throws CompilerError {
      String method;
      Tree methodAST = ast.getChild(1);
      Tree receiverAST = ast.getChild(0);
      int index;
      
      method = methodAST.getText();
      index = getOrAllocConstPoolIndex(method, CompiledScript.CONST_POOL_METHOD);

      backPassData.addFirst(new BackPassFrame(new MethCallBackPassData(method)));
      visit(strm, this, receiverAST);
      for (int i = 0; i < methodAST.getChildCount(); i++) {
        visit(strm, this, methodAST.getChild(i));
      }
      BackPassFrame kidData = backPassData.removeFirst();
      MethCallBackPassData bpd = (MethCallBackPassData)kidData.data;
      
      try {
        if (bpd.selfCall) {
          writeSizedOneExtra(strm, Opcodes.INVOKESELF_B, Opcodes.INVOKESELF_W, Opcodes.INVOKESELF_L,
              index, bpd.argc);
        } else {
          writeSizedOneExtra(strm, Opcodes.INVOKEDYNAMIC_B, Opcodes.INVOKEDYNAMIC_W, Opcodes.INVOKEDYNAMIC_L,
              index, bpd.argc);
        }
       
        writeBlock(strm, bpd.block);
        
        byte[] orblock;
        if ((orblock = bpd.orBlock).length > 0) {
          writeSizedOneExtra(strm, Opcodes.INVOKESELF_B, Opcodes.INVOKESELF_W, Opcodes.INVOKESELF_L,
              getOrAllocConstPoolIndex("or", CompiledScript.CONST_POOL_METHOD), (byte)0);
          writeBlock(strm, orblock);
        }
      } catch (IOException e) {
        throw new OutputError(e);
      }
      
      return;
    }
    
    @Override
    protected void visitSelf(DataOutputStream strm, Tree ast) throws CompilerError {
      MethCallBackPassData mcbpd = ((MethCallBackPassData)backPassData.peekFirst().data);
      mcbpd.selfCall = true;
    }
    
    @Override
    protected void visitArgs(DataOutputStream strm, Tree ast) throws CompilerError {
      /* method args - put count in backpass data and visit kids... */  
      MethCallBackPassData mcbpd = ((MethCallBackPassData)backPassData.peekFirst().data);
      int argc = ast.getChildCount();
      if (argc > 255) {
        throw(new TooManyArgsError("Too many arguments to method " + mcbpd.methName));
      }
      mcbpd.argc = (byte)ast.getChildCount();
      for (int i = 0; i < ast.getChildCount(); i++) {
        visit(strm, this, ast.getChild(i));
      }
    }

    @Override
    protected void visitBlock(DataOutputStream strm, Tree ast) throws CompilerError {
      // generate the bytecode to the same unit (to make sure locals are allocated correctly
      // and const pool is kept up to date) but use a different stream for the block code.
      // we can then return the code in the backpass data and use it to calculate our
      // goto targets etc.
      MethCallBackPassData mcbpd = ((MethCallBackPassData)backPassData.peekFirst().data);
      ByteArrayOutputStream bas = new ByteArrayOutputStream();
      DataOutputStream dos = new DataOutputStream(bas);
      for (int i = 0; i < ast.getChildCount(); i++) {
        visit(dos, this, ast.getChild(i));
      }
      mcbpd.block = bas.toByteArray();
    }

    @Override
    protected void visitOrBlock(DataOutputStream strm, Tree ast) throws CompilerError {
      MethCallBackPassData mcbpd = ((MethCallBackPassData)backPassData.peekFirst().data);
      ByteArrayOutputStream bas = new ByteArrayOutputStream();
      DataOutputStream dos = new DataOutputStream(bas);
      for (int i = 0; i < ast.getChildCount(); i++) {
        visit(dos, this, ast.getChild(i));
      }
      mcbpd.orBlock = bas.toByteArray();
    }

    @Override
    protected void visitAdd(DataOutputStream strm, Tree ast) throws CompilerError {
      visit(strm, this, ast.getChild(0));
      visit(strm, this, ast.getChild(1));
      
      try {
        writeSizedOneExtra(strm, Opcodes.INVOKEDYNAMIC_B, Opcodes.INVOKEDYNAMIC_W, Opcodes.INVOKEDYNAMIC_L, 
            getOrAllocConstPoolIndex("__opADD", CompiledScript.CONST_POOL_METHOD), (byte)1);
      } catch (IOException e) {
        throw new OutputError(e);
      }
      
    }

    @Override
    protected void visitSub(DataOutputStream strm, Tree ast) throws CompilerError {
      visit(strm, this, ast.getChild(0));
      visit(strm, this, ast.getChild(1));
      
      try {
        writeSizedOneExtra(strm, Opcodes.INVOKEDYNAMIC_B, Opcodes.INVOKEDYNAMIC_W, Opcodes.INVOKEDYNAMIC_L, 
            getOrAllocConstPoolIndex("__opSUB", CompiledScript.CONST_POOL_METHOD), (byte)1);
      } catch (IOException e) {
        throw new OutputError(e);
      }
    }

    @Override
    protected void visitMul(DataOutputStream strm, Tree ast) throws CompilerError {
      visit(strm, this, ast.getChild(0));
      visit(strm, this, ast.getChild(1));
      
      try {
        writeSizedOneExtra(strm, Opcodes.INVOKEDYNAMIC_B, Opcodes.INVOKEDYNAMIC_W, Opcodes.INVOKEDYNAMIC_L, 
            getOrAllocConstPoolIndex("__opMUL", CompiledScript.CONST_POOL_METHOD), (byte)1);
      } catch (IOException e) {
        throw new OutputError(e);
      }
    }

    @Override
    protected void visitDiv(DataOutputStream strm, Tree ast) throws CompilerError {
      visit(strm, this, ast.getChild(0));
      visit(strm, this, ast.getChild(1));
      
      try {
        writeSizedOneExtra(strm, Opcodes.INVOKEDYNAMIC_B, Opcodes.INVOKEDYNAMIC_W, Opcodes.INVOKEDYNAMIC_L, 
            getOrAllocConstPoolIndex("__opDIV", CompiledScript.CONST_POOL_METHOD), (byte)1);
      } catch (IOException e) {
        throw new OutputError(e);
      }
    }

    @Override
    protected void visitMod(DataOutputStream strm, Tree ast) throws CompilerError {
      visit(strm, this, ast.getChild(0));
      visit(strm, this, ast.getChild(1));
      
      try {
        writeSizedOneExtra(strm, Opcodes.INVOKEDYNAMIC_B, Opcodes.INVOKEDYNAMIC_W, Opcodes.INVOKEDYNAMIC_L, 
            getOrAllocConstPoolIndex("__opMOD", CompiledScript.CONST_POOL_METHOD), (byte)1);
      } catch (IOException e) {
        throw new OutputError(e);
      }
    }

    @Override
    protected void visitPow(DataOutputStream strm, Tree ast) throws CompilerError {
      visit(strm, this, ast.getChild(0));
      visit(strm, this, ast.getChild(1));
      
      try {
        writeSizedOneExtra(strm, Opcodes.INVOKEDYNAMIC_B, Opcodes.INVOKEDYNAMIC_W, Opcodes.INVOKEDYNAMIC_L, 
            getOrAllocConstPoolIndex("__opPOW", CompiledScript.CONST_POOL_METHOD), (byte)1);
      } catch (IOException e) {
        throw new OutputError(e);
      }
    }  
  }
  
  public Compiler() { }  
  
  /* Helper to print debug info when assertions are on */
  private boolean debug(String log) {
    System.out.println(log);
    return true;
  }
  
  /**
   * Compile the script in the supplied String by parsing it with {@link DeeLangParser}
   * and then compiling to a {@link CompiledScript}. This is a convenience method that calls
   * through to {@link #compile(CompilationUnit, Tree)} with the default
   * state, and simply returns the compiled script.
   * 
   * @param code The Deelang code to compile.
   * @return The compiled script
   * @throws ParserError if an error occurs during parsing.
   * @throws CompilerError If an error occurs during compilation.
   */
  public CompiledScript compile(String code) throws ParserError, CompilerError {
    return compile(Parser.staticParse(code));
  }
  
  /**
   * Compile the script in the parsed AST (output from {@link DeeLangParser})
   * to a {@link CompiledScript}. This is a convenience method that calls
   * through to {@link #compile(CompilationUnit, Tree)} with the default
   * state, and simply returns the compiled script.
   * 
   * @param ast The AST to compile.
   * 
   * @return The compiled script
   * 
   * @throws CompilerError If an error occurs during compilation.
   */
  public CompiledScript compile(Tree ast) throws CompilerError {
    return compile(new CompilationUnit(), ast).buildScript();
  }
  
  /**
   * Compile the script in the parsed AST (output from {@link DeeLangParser})
   * to a {@link CompiledScript}, using a custom {@link CompilationUnit}. This
   * allows you to hook into various stages of the compilation by overriding
   * methods by providing your own state subclass.
   * 
   * @param unit A (subclass of) {@link CompilationUnit} to use during compilation.
   * @param ast The AST to compile.
   * 
   * @return The state supplied to the method, for convenience. You can obtain the script
   *         from this object by calling {@link CompilationUnit#buildScript}.
   * 
   * @throws CompilerError If an error occurs during compilation.
   */
  public CompilationUnit compile(CompilationUnit unit, Tree ast) throws CompilerError {
    try {
      if (ast != null) {
        if (ast.getType() == 0) {
          // is multiple statement script
          assert debug("Compiling multi-line script");
          for (int i = 0; i < ast.getChildCount(); i++) {
            visit(unit.codeStrm, unit, ast.getChild(i));
          }
        } else {
          // is single statement script
          assert debug("Compiling single line script");
          visit(unit.codeStrm, unit, ast);
        }
      }
    } catch (Exception t) {
      throw new CompilerError(t);
    }
    return unit;
  }
  
  /* Helper to pring debug info for visitor when assertions are on */
  private boolean debugVisitor(CompilationUnit unit, Tree ast) {
    return debug(" - VISIT: " + ast.toString() + " [" + DeeLangParser.tokenNames[ast.getType()] + "]");
  }
    
  protected void visit(DataOutputStream strm, CompilationUnit unit, Tree ast) throws CompilerError {
    assert debugVisitor(unit, ast);
    
    switch (ast.getType()) {
    /* ********** LITERALS ********** */
    case DeeLangParser.DECIMAL_LITERAL:
      unit.visitDecimalLiteral(strm, ast);
      return;
    case DeeLangParser.HEX_LITERAL:
      unit.visitHexLiteral(strm, ast);
      return;
    case DeeLangParser.OCTAL_LITERAL:
      unit.visitOctalLiteral(strm, ast);
      return;
    case DeeLangParser.FLOATING_POINT_LITERAL:
      unit.visitFloatLiteral(strm, ast);
      return;
    case DeeLangParser.CHARACTER_LITERAL:
      unit.visitCharacterLiteral(strm, ast);
      return;
    case DeeLangParser.STRING_LITERAL:
      unit.visitStringLiteral(strm, ast);
      return;
      
      
    /* ********** SPECIAL TOKEN FOR VAR AND METHOD ******* */
    case DeeLangParser.CHAIN:
      unit.visitChain(strm, ast);
      return;
      
      
    /* ********** VARIABLES ********** */
    case DeeLangParser.ASSIGN_FIELD:
      unit.visitAssignField(strm, ast);
      return;
      
    case DeeLangParser.ASSIGN_LOCAL:
      unit.visitAssignLocal(strm, ast);
      return;
      
    case DeeLangParser.IDENTIFIER:
      // var access
      unit.visitIdentifier(strm, ast);
      return;
      
    case DeeLangParser.FIELD_ACCESS:
      // member access
      unit.visitFieldAccess(strm, ast);
      return;

    /* ********** METHODS ********** */
    case DeeLangParser.METHOD_CALL:
      unit.visitMethodCall(strm, ast);
      return;
      
    case DeeLangParser.SELF:
      unit.visitSelf(strm, ast);
      return;

    case DeeLangParser.ARGS:
      unit.visitArgs(strm, ast);
      return;
      
    case DeeLangParser.BLOCK:
      unit.visitBlock(strm, ast);
      return;
      
    case DeeLangParser.ORBLOCK:
      unit.visitOrBlock(strm, ast);
      return;
      
      
    /* ********** ARITHMETIC ********** */
    case DeeLangParser.ADD:
      unit.visitAdd(strm, ast);
      return;
    case DeeLangParser.SUB:
      unit.visitSub(strm, ast);
      return;
    case DeeLangParser.MUL:
      unit.visitMul(strm, ast);
      return;
    case DeeLangParser.DIV:
      unit.visitDiv(strm, ast);
      return;
    case DeeLangParser.MOD:
      unit.visitMod(strm, ast);
      return;
    case DeeLangParser.POW:
      unit.visitPow(strm, ast);
      return;
    default:
      throw(new UnsupportedError("Unknown AST type: " + ast.getType()));
    }
  }
}
