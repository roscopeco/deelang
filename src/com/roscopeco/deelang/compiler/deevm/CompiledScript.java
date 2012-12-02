/* CompiledScript.java - A script compiled for the Dee VM.
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
package com.roscopeco.deelang.compiler.deevm;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

import com.roscopeco.deelang.compiler.Compiler;

/**
 * A compiled script. Encapsulates a fully compiled and resolved
 * script, with bytecode and constant pool, together with the 
 * logic to read and write to a stream.
 * <br/>
 * This class cannot be instantiated directly - instances of it can
 * be obtained either by loading a compiled script from a file via
 * the {@link #load} method, or by compiling a new
 * script with {@link Compiler}. 
 * 
 * @author rosco
 * @created 16 Oct 2011
 *
 */
public class CompiledScript {
  /** 4-byte signature that begins every compiled DeeLang script file */
  public static final byte[] SCRIPT_SIGNATURE = new byte[] { 'D', 'L', 0, 2 };
  
  /** Constant-pool type for a FIELD reference. */
  public static final byte CONST_POOL_FIELD = 0x02;
  
  /** Constant-pool type for a METHOD reference. */
  public static final byte CONST_POOL_METHOD = 0x03;
  
  /** Constant-pool type for an INT reference. */
  public static final byte CONST_POOL_INT = 0x10;
  
  /** Constant-pool type for a FLOAT reference. */
  public static final byte CONST_POOL_FLOAT = 0x11;
  
  /** Constant-pool type for a STRING reference. */
  public static final byte CONST_POOL_STRING = 0x12;
  
  /**
   * Encapsultes an individual constant pool entry.
   * 
   * @author rosco
   * @created 16 Oct 2011
   *
   */
  public static abstract class ConstPoolEntry {
    /**
     * Get the type of this entry (one of the CONST_POOL_XXXX constants
     * from {@link CompiledScript}.
     * 
     * @return The type of this entry.
     */
    public abstract int getType();
    
    /**
     * Get the value of this entry. If this is a primitive typed
     * entry (int or float) then this will return a suitable
     * boxed object for the type.
     * 
     * @return The value of this entry.
     */
    public abstract Object getValue();
    
    /**
     * Write this pool entry to the specified data stream.
     * Implementations of this method are responsible for writing the
     * appropriate TYPE byte followed by the actual data storage.
     * 
     * @param os The output stream.
     * 
     * @throws IOException If an IO error occurs.
     */
    abstract void store(DataOutputStream os) throws IOException;
    
    /**
     * Read a const pool entry and return the correct subclass for it's type.
     * 
     * @param di DataInputStream. Next byte should be the pool entry's TYPE
     * @return A new ConstPoolEntry implementation for the entry type.
     * @throws IOException 
     * @throws UnknownConstPoolTypeException
     */
    static ConstPoolEntry readEntry(DataInputStream di) throws IOException, UnknownConstPoolTypeException {
      byte type = di.readByte();
      switch (type) {
      case CONST_POOL_FIELD:
        return new ConstPoolField(di);
      case CONST_POOL_METHOD:
        return new ConstPoolMethod(di);
      case CONST_POOL_INT:
        return new ConstPoolInt(di);
      case CONST_POOL_FLOAT:
        return new ConstPoolFloat(di);
      case CONST_POOL_STRING:
        return new ConstPoolString(di);
      default:
        throw new UnknownConstPoolTypeException("Unknown constant pool entry type: " + type);
      }
    }
    
    @Override
    public boolean equals(Object other) {
      if (other instanceof ConstPoolEntry) {
        ConstPoolEntry e = (ConstPoolEntry)other;
        return ((e.getType() == getType()) && (e.getValue().equals(getValue())));
      }
      return false;
    }
  }
  
  /* 
   * A FIELD entry in the constant pool.
   */
  static final class ConstPoolField extends ConstPoolEntry {
    private final String value;
    ConstPoolField(String value) { this.value = value; }
    ConstPoolField(DataInputStream strm) throws IOException { this.value = strm.readUTF(); }
    public final int getType() { return CONST_POOL_FIELD; }
    public final Object getValue() { return value; }
    final void store(DataOutputStream os) throws IOException { os.writeByte(getType()); os.writeUTF(value); }
    public final String toString() { return "[CONST_POOL_FIELD  " + value + "]"; }
  }
  
  /* 
   * A METHOD entry in the constant pool.
   */
  static final class ConstPoolMethod extends ConstPoolEntry {
    private final String value;
    ConstPoolMethod(String value) { this.value = value; }
    ConstPoolMethod(DataInputStream strm) throws IOException { this.value = strm.readUTF(); }
    public final int getType() { return CONST_POOL_METHOD; }
    public final Object getValue() { return value; }
    final void store(DataOutputStream os) throws IOException { os.writeByte(getType()); os.writeUTF(value); }
    public final String toString() { return "[CONST_POOL_METHOD " + value + "]"; }
  }
  
  /* 
   * An INT entry in the constant pool.
   */
  static final class ConstPoolInt extends ConstPoolEntry {
    private final Integer value;
    ConstPoolInt(int value) { this.value = value; }
    ConstPoolInt(DataInputStream strm) throws IOException { this.value = strm.readInt(); }
    public final int getType() { return CONST_POOL_INT; }
    public final Object getValue() { return value; }
    final void store(DataOutputStream os) throws IOException { os.writeByte(getType()); os.writeInt(value); }
    public final String toString() { return "[CONST_POOL_INT    " + value + "]"; }
  }
  
  /* 
   * A FLOAT entry in the constant pool.
   */
  static final class ConstPoolFloat extends ConstPoolEntry {
    private final Double value;
    ConstPoolFloat(double value) { this.value = value; }
    ConstPoolFloat(DataInputStream strm) throws IOException { this.value = strm.readDouble(); }
    public final int getType() { return CONST_POOL_FLOAT; }
    public final Object getValue() { return value; }
    final void store(DataOutputStream os) throws IOException { os.writeByte(getType()); os.writeDouble(value); }
    public final String toString() { return "[CONST_POOL_FLOAT  " + value + "]"; }
  }
  
  /* 
   * A STRING entry in the constant pool.
   */
  static final class ConstPoolString extends ConstPoolEntry {
    private final String value;
    ConstPoolString(String value) { this.value = value; }
    ConstPoolString(DataInputStream strm) throws IOException { this.value = strm.readUTF(); }
    public final int getType() { return CONST_POOL_STRING; }
    public final Object getValue() { return value; }
    final void store(DataOutputStream os) throws IOException { os.writeByte(getType()); os.writeUTF(value); }
    public final String toString() { return "[CONST_POOL_STRING \"" + value + "\"]"; }
  }
  
  /**
   * Load a previously compiled script from the specified <code>InputStream</code>.
   * <br/>
   * The supplied stream must contain a saved compiled script in the
   * format output by the {@link #store} method.
   * <br/>
   * See the README for details of the script file format.
   * 
   * @param strm The stream containing the script data.
   * @return The new <code>CompiledScript</code>. 
   * 
   * @throws IOException If an IO error occurs.
   * @throws ScriptLoaderException If the specified stream does not contain a valid script.
   */
  public static CompiledScript load(InputStream strm) 
      throws IOException, ScriptLoaderException {
    DataInputStream di = new DataInputStream(strm);
    CompiledScript script;
    byte[] buf = new byte[4];
    
    di.read(buf, 0, 4);
    if (Arrays.equals(SCRIPT_SIGNATURE, buf)) {
      // is a script!      
      int constPoolLen = di.readInt();
      
      script = new CompiledScript(constPoolLen);

      for (int i = 0; i < constPoolLen; i++) {
        script.constPool[i] = ConstPoolEntry.readEntry(di);
      }
        
      byte numLocals = di.readByte();
      script.localsTable = new String[numLocals];
      for (int j = 0; j < numLocals; j++) {
        script.localsTable[j] = di.readUTF();
      }
      
      int codeLen = di.readInt();
      script.code = new byte[codeLen];
      
      if (di.read(script.code, 0, codeLen) != codeLen) {
        throw(new CodeUnderflowException("Code array length doesn't match reported length in script file"));
      };
    } else {
      throw new BadScriptSignatureException("Unknown script signature: " + Arrays.toString(buf));
    }
    
    return script;
  }
  
  private ConstPoolEntry[] constPool;
  private byte[] code;
  private String[] localsTable;
  
  /* Used by the loader */
  CompiledScript(int constPoolLen) {
    constPool = new ConstPoolEntry[constPoolLen];
  }
  
  /* Used by the compiler */
  CompiledScript(ConstPoolEntry[] constPool, String[] localTable, byte[] code) {
    this.constPool = constPool;
    this.localsTable = localTable;
    this.code = code;
  }
  
  /**
   * Get the bytecode for this compiled script.
   * 
   * @return This script's bytecode.
   */
  public byte[] getCode() {
    return code;
  }
  
  /**
   * Get the constant pool for this compiled script.
   *   
   * @return This script's constant pool. 
   */
  public ConstPoolEntry[] getConstPool() {
    return constPool;
  }
  
  /**
   * Get the local variable table for this compiled script.
   * 
   * @return This script's local variable table.
   */
  public String[] getLocalsTable() {
    return localsTable;
  }
  
  /**
   * Store this compiled script to the specified <code>InputStream</code>.
   * <br/>
   * See the README for details of the script file format.
   * 
   * @param strm The stream to write script data to.
   * 
   * @throws IOException If an IO error occurs.
   */
  public void store(OutputStream strm) throws IOException {
    DataOutputStream os = new DataOutputStream(strm);
    os.write(SCRIPT_SIGNATURE);
    os.writeInt(constPool.length);
    for (ConstPoolEntry e : constPool) {
      e.store(os);
    }
    os.writeByte(localsTable.length);
    for (String s : localsTable) {
      os.writeUTF(s);
    }
    os.writeInt(code.length);
    os.write(code);
  }
  
  @Override
  public boolean equals(Object other) {
    return ((other instanceof CompiledScript) &&
            (Arrays.equals(constPool, ((CompiledScript)other).constPool)) &&
            (Arrays.equals(this.localsTable, ((CompiledScript)other).localsTable)) &&
            (Arrays.equals(this.code, ((CompiledScript)other).code)));
  }
}
