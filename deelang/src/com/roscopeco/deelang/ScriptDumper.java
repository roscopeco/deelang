/* ScriptDumper.java - Dump a Dee script in human-readable format.
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
package com.roscopeco.deelang;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

import com.roscopeco.deelang.compiler.CompiledScript;

/**
 * Dumps compiled scripts to strings.
 * 
 * @author rosco
 * @created 16 Oct 2011
 *
 */
public class ScriptDumper {
  
  public static final String constPoolToString(CompiledScript.ConstPoolEntry[] pool) {
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < pool.length; i++) {
      sb.append(String.format("0x%08x - %s\n", i, pool[i]));
    }
    return sb.toString();
  }
  
  public static final String localsTableToString(String[] localsTable) {
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < localsTable.length; i++) {
      sb.append(String.format("0x%02x - %s\n", i, localsTable[i]));
    }
    return sb.toString();
  }
  
  @SuppressWarnings("deprecation")
  public static final String codeToString(byte[] code) {
    StringBuffer sb = new StringBuffer();
    ByteArrayInputStream bais = new ByteArrayInputStream(code);
    DataInputStream strm = new DataInputStream(bais);
    
    try {
      while (strm.available() > 0) {
        switch (strm.readByte()) {
        case Opcodes.NOP:
          sb.append("[NOP]\n");
          break;
        case Opcodes.IPUSH:
          sb.append("[IPUSH            " + strm.readInt() + "]\n");
          break;
        case Opcodes.FPUSH:
          sb.append("[FPUSH            " + strm.readDouble() + "]\n");
          break;
        case Opcodes.SPUSH:
          sb.append("[SPUSH            " + strm.readUTF() + "]\n");
          break;
        case Opcodes.IPUSHCONST:
          sb.append("[IPUSHCONST       " + strm.readInt() + "]\n");
          break;
        case Opcodes.FPUSHCONST:
          sb.append("[FPUSHCONST       " + strm.readInt() + "]\n");
          break;
        case Opcodes.SPUSHCONST:
          sb.append("[SPUSHCONST       " + strm.readInt() + "]\n");
          break;
        case Opcodes.STORE:
          sb.append("[STORE            " + strm.readByte() + "]\n");
          break;
        case Opcodes.LOAD:
          sb.append("[LOAD             " + strm.readByte() + "]\n");
          break;
        case Opcodes.PUTFIELD:
          sb.append("[PUTFIELD         " + strm.readInt() + "]\n");
          break;
        case Opcodes.GETFIELD:
          sb.append("[GETFIELD         " + strm.readInt() + "]\n");
          break;
        case Opcodes.INVOKEDYNAMIC:
          sb.append("[INVOKEDYNAMIC    " + strm.readInt() + ", " + strm.readByte() + "]\n");
          break;
        case Opcodes.INVOKESTATIC:
          sb.append("[INVOKESTATIC     " + strm.readInt() + ", " + strm.readByte() + "]\n");
          break;
        case Opcodes.INVOKESELF:
          sb.append("[INVOKESELF       " + strm.readInt() + ", " + strm.readByte() + "]\n");
          break;
        case Opcodes.BLOCKRETURN:
          sb.append("[BLOCKRETURN]\n");
          break;
        case Opcodes.ENTERBLOCK_B:
          sb.append("[ENTERBLOCK_B     " + strm.readByte() + "]\n");
          break;
        case Opcodes.ENTERBLOCK_W:
          sb.append("[ENTERBLOCK_W     " + strm.readShort() + "]\n");
          break;
        case Opcodes.ENTERBLOCK_L:
          sb.append("[ENTERBLOCK_L     " + strm.readLong() + "]\n");
          break;
        case Opcodes.JUMP_B:
          sb.append("[JUMP_B           " + strm.readByte() + "]\n");
          break;
        case Opcodes.JUMP_W:
          sb.append("[JUMP_W           " + strm.readShort() + "]\n");
          break;
        case Opcodes.JUMP_L:
          sb.append("[JUMP_L           " + strm.readInt() + "]\n");
          break;
        case Opcodes.ADD:
          sb.append("[ADD]\n");
          break;
        case Opcodes.SUB:
          sb.append("[SUB]\n");
          break;
        case Opcodes.MUL:
          sb.append("[MUL]\n");
          break;
        case Opcodes.DIV:
          sb.append("[DIV]\n");
          break;
        case Opcodes.MOD:
          sb.append("[MOD]\n");
          break;
        case Opcodes.POW:
          sb.append("[POW]\n");
          break;
        default:
          sb.append("[UNKNOWN]");
        }
      }
    } catch (IOException e) {
      throw new RuntimeException("Invalid script bytecode format", e);
    }
    
    return sb.toString();
  }
  
  public static final String dumpScript(CompiledScript script) {
    return "Constant pool:\n" + 
           constPoolToString(script.getConstPool()) + "\n" +
           "Local variable table:\n" +
           localsTableToString(script.getLocalsTable()) + "\n" +
           "Code:\n" +
           codeToString(script.getCode()); 
  }
}
