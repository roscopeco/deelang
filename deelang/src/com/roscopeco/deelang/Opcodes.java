/* Opcodes.java - VM Opcodes for DeeVM.
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

/**
 * <p>All opcodes recognised by the Dee Virtual Machine.</p>
 * 
 * <p>The comments on the individual opcodes define the bytecode format for
 * that opcode, as well as it's effect on the stack. The format of these
 * comments is:</p>
 * 
 * <ul>
 * <p><strong>OPCODE (operand byte(s))</strong> - Description<br/></p>
 * <p><i>stack_before -> stack_after</i></p>
 * </ul>
 * 
 * <p>Many of the opcodes have three variants, denoted by the suffixes
 * <code>_B</code>, <code>_W</code> and <code>_L</code>. These variants
 * operate in exactly the same way, but expect their immediately following
 * operand to be one, two and four bytes, respectively. The compiler always
 * tries to generate the shortest possible variant.</p>
 * 
 * <p>In all cases, this operand encodes either a JUMP target, code offset or 
 * constant-pool index, and for short scripts will almost always be a single byte. 
 * Where longer variants are used, the storage format is that used by the Java
 * <code>DataOutputStream</code> methods <code>readShort()</code> and 
 * <code>readInt()</code> respectively - i.e. two or four bytes, signed, 
 * in network byte order.</p>
 * 
 * <p>It is important to note that these operands are signed, stored as 
 * twos-complement integers. Although this is not optimal from a storage 
 * point of view, it does work as a performance design decision as it 
 * enables the VM to use the native Java types without an additional conversion
 * step.</p>
 *  
 * @author rosco
 * @created 19 Oct 2011
 */
public final class Opcodes {
  private Opcodes() throws UnsupportedOperationException {
    throw new UnsupportedOperationException("Please don't do that... :|");
  }
  
  /**
   * <p><strong>NOP</strong> - Waste one VM cycle</p>
   * <p><i> ... -> ...</i></p>
   */
  public static final byte NOP              = 0x00;

  /**
   * <p><strong>IPUSH (b1, b2, b3, b4)</strong> - Push an inline integer onto the stack.</i>
   * <p><i> ... -> ..., INT</i></p>
   * 
   * <p><strong>Note:</strong> The standard compiler never generates this instruction, although it is supported by the VM.
   * In this implementation, <code>IPUSHCONST_x</code> is used instead.</p>
   */
  public static final byte IPUSH            = 0x01;     /* push - data follows in byte stream */

  /**
   * <p><strong>FPUSH (b1, b2, b3, b4, b5, b6, b7, b8, b9)</strong> - Push an inline double onto the stack.</i>
   * <p><i> ... -> ..., FLOAT</i></p>
   * 
   * <p><strong>Note:</strong> The standard compiler never generates this instruction, although it is supported by the VM.
   * In this implementation, <code>FPUSHCONST_x</code> is used instead.</p>
   */
  public static final byte FPUSH            = 0x02;

  /**
   * <p><strong>SPUSH (lenb1, lenb2, (data_byte * len))</strong> - Push an inline mUTF string onto the stack.</i>
   * <p><i> ... -> ..., STRING</i></p>
   * 
   * <p><strong>Note:</strong> The standard compiler never generates this instruction, although it is supported by the VM.
   * In this implementation, <code>SPUSHCONST_x</code> is used instead.</p>
   */
  public static final byte SPUSH            = 0x03;

  /**
   * <p><strong>IPUSHCONST_B(idx)</strong> - Push an integer constant from the constant pool onto the stack.</p>
   * <p><i> ... -> ..., INT</i></p>
   */
  public static final byte IPUSHCONST_B     = 0x10;     /* push - data is in const pool */

  /**
   * <p><strong>FPUSHCONST_B(idx)</strong> - Push a float constant from the constant pool onto the stack.</p>
   * <p><i> ... -> ..., FLOAT</i></p>
   */
  public static final byte FPUSHCONST_B     = 0x11;

  /**
   * <p><strong>SPUSHCONST_B(idx)</strong> - Push a string constant from the constant pool onto the stack</p>
   * <p><i> ... -> ..., STRING</i></p>
   */
  public static final byte SPUSHCONST_B     = 0x12;

  /**
   * <p><strong>IPUSHCONST_W(idx_b1, idx_b2)</strong> - Push an integer constant from the constant pool onto the stack.</p>
   * <p><i> ... -> ..., INT</i></p>
   */
  public static final byte IPUSHCONST_W     = 0x13;

  /**
   * <p><strong>FPUSHCONST_W(idx_b1, idx_b2)</strong> - Push a float constant from the constant pool onto the stack.</p>
   * <p><i> ... -> ..., FLOAT</i></p>
   */
  public static final byte FPUSHCONST_W     = 0x14;

  /**
   * <p><strong>SPUSHCONST_W(idx_b1, idx_b2)</strong> - Push a string constant from the constant pool onto the stack</p>
   * <p><i> ... -> ..., STRING</i></p>
   */
  public static final byte SPUSHCONST_W     = 0x15;

  /**
   * <p><strong>IPUSHCONST_L(idx_b1, idx_b2, idx_b3, idx_b4)</strong> - Push an integer constant from the constant pool onto the stack.</p>
   * <p><i> ... -> ..., INT</i></p>
   */
  public static final byte IPUSHCONST_L     = 0x16;

  /**
   * <p><strong>FPUSHCONST_L(idx_b1, idx_b2, idx_b3, idx_b4)</strong> - Push a float constant from the constant pool onto the stack.</p>
   * <p><i> ... -> ..., FLOAT</i></p>
   */
  public static final byte FPUSHCONST_L     = 0x17;

  /**
   * <p><strong>SPUSHCONST_L(idx_b1, idx_b2, idx_b3, idx_b4)</strong> - Push a string constant from the constant pool onto the stack</p>
   * <p><i> ... -> ..., STRING</i></p>
   */
  public static final byte SPUSHCONST_L     = 0x18;

  /**
   * <p><strong>POP</strong> - Pop the top value from the stack, and discard it.</p>
   * <p><i> ..., VALUE -> ...</i></p>
   */
  public static final byte POP              = 0x1F;
  
  /**
   * <p><strong>STORE(idx)</strong> - Pop the top value from the stack, and store it in local slot <i>idx</i>.</p>
   * <p><i> ..., VALUE -> ...</i></p>
   */
  public static final byte STORE            = 0x20;

  /**
   * <p><strong>LOAD(idx)</strong> - Push the contents of local slot <i>idx</i> onto the stack.</p>
   * <p><i> ... -> ..., VALUE(locals[idx])</i></p>
   */
  public static final byte LOAD             = 0x21;
  
  /**
   * <p><strong>PUTFIELD_B(idx)</strong> - Store the top object from the stack in field at constant pool index <i>idx</i> in the object at the second-top stack.</p>
   * <p><i> ..., RECEIVER, VALUE -> ...</i></p>
   */
  public static final byte PUTFIELD_B       = 0x2a;

  /**
   * <p><strong>GETFIELD_B(idx)</strong> - Retrieve the value of the field at constant pool index <i>idx</i> in the object on top of the stack, and push it to the stack.</p>
   * <p><i> ..., RECEIVER -> ..., VALUE</i></p>
   */
  public static final byte GETFIELD_B       = 0x2b;

  /**
   * <p><strong>PUTFIELD_W(idx_b1, idx_b2)</strong> - Store the top object from the stack in field at constant pool index <i>idx</i> in the object at the second-top stack.</p>
   * <p><i> ..., RECEIVER, VALUE -> ...</i></p>
   */
  public static final byte PUTFIELD_W       = 0x2c;

  /**
   * <p><strong>GETFIELD_W(idx_b1, idx_b2)</strong> - Retrieve the value of the field at constant pool index <i>idx</i> in the object on top of the stack, and push it to the stack.</p>
   * <p><i> ..., RECEIVER -> ..., VALUE</i></p>
   */
  public static final byte GETFIELD_W       = 0x2d;

  /**
   * <p><strong>PUTFIELD_L(idx_b1, idx_b2, idx_b3, idx_b4)</strong> - Store the top object from the stack in field at constant pool index <i>idx</i> in the object at the second-top stack.</p>
   * <p><i> ..., RECEIVER, VALUE -> ...</i></p>
   */
  public static final byte PUTFIELD_L       = 0x2e;

  /**
   * <p><strong>GETFIELD_L(idx_b1, idx_b2, idx_b3, idx_b4)</strong> - Retrieve the value of the field at constant pool index <i>idx</i> in the object on top of the stack, and push it to the stack.</p>
   * <p><i> ..., RECEIVER -> ..., VALUE</i></p>
   */
  public static final byte GETFIELD_L       = 0x2f;

  /**
   * <p><strong>INVOKEDYNAMIC_B(idx, argc)</strong> - Invoke the method referenced at constant pool <i>idx</i> with <i>argc</i> arguments, using dynamic dispatch.</p>
   * <p><i> ..., RECEIVER, (VALUE * argc) -> ...</i></p>
   */
  public static final byte INVOKEDYNAMIC_B  = 0x51;

  /**
   * <p><strong>INVOKESELF_B(idx, argc)</strong> - Invoke the method referenced at constant pool <i>idx</i> with <i>argc</i> arguments directly on the current context's <i>SELF</i>.</p>
   * <p><i> ..., (VALUE * argc) -> ...</i></p>
   */
  public static final byte INVOKESELF_B     = 0x52;
  
  /**
   * <p><strong>INVOKEDYNAMIC_W(idx_b1, idx_b2, argc)</strong> - Invoke the method referenced at constant pool <i>idx</i> with <i>argc</i> arguments, using dynamic dispatch.</p>
   * <p><i> ..., RECEIVER, (VALUE * argc) -> ...</i></p>
   */
  public static final byte INVOKEDYNAMIC_W  = 0x53;

  /**
   * <p><strong>INVOKESELF_W(idx_b1, idx_b2, argc)</strong> - Invoke the method referenced at constant pool <i>idx</i> with <i>argc</i> arguments directly on the current context's <i>SELF</i>.</p>
   * <p><i> ..., (VALUE * argc) -> ...</i></p>
   */
  public static final byte INVOKESELF_W     = 0x54;
  
  /**
   * <p><strong>INVOKEDYNAMIC_L(idx_b1, idx_b2, idx_b3, idx_b4, argc)</strong> - Invoke the method referenced at constant pool <i>idx</i> with <i>argc</i> arguments, using dynamic dispatch.</p>
   * <p><i> ..., RECEIVER, (VALUE * argc) -> ...</i></p>
   */
  public static final byte INVOKEDYNAMIC_L    = 0x55;

  /**
   * <p><strong>INVOKESELF_L(idx_b1, idx_b2, idx_b3, idx_b4, argc)</strong> - Invoke the method referenced at constant pool <i>idx</i> with <i>argc</i> arguments directly on the current context's <i>SELF</i>.</p>
   * <p><i> ..., (VALUE * argc) -> ...</i></p>
   */
  public static final byte INVOKESELF_L       = 0x56;

  /**
   * <p><strong>ENTERBLOCK_B(len)</strong> - Enter a block with the given length.</p>
   * <p><i> ... -> ...</i></p>
   */
  public static final byte ENTERBLOCK_B     = 0x5d;

  /**
   * <p><strong>ENTERBLOCK_W(len_b1, len_b2)</strong> - Enter a block with the given length.</p>
   * <p><i> ... -> ...</i></p>
   */
  public static final byte ENTERBLOCK_W     = 0x5e;
  
  /**
   * <p><strong>ENTERBLOCK_L(len_b1, len_b2, len_b3, len_b4)</strong> - Enter a block with the given length.</p>
   * <p><i> ... -> ...</i></p>
   */
  public static final byte ENTERBLOCK_L     = 0x5f;
  
  /**
   * <p><strong>JUMP_B(ofs_b1)</strong> - Jump to the specified offset in the bytecode. Offset is relative to pc following JUMP insn, and can be forward only.</p>
   * <p><i> ... -> ...</i></p>
   */
  public static final byte JUMP_B           = 0x6d;

  /**
   * <p><strong>JUMP_W(ofs_b1, ofs_b2)</strong> - Jump to the specified offset in the bytecode. Offset is relative to pc following JUMP insn, and can be forward only.</p>
   * <p><i> ... -> ...</i></p>
   */
  public static final byte JUMP_W           = 0x6e;

  /**
   * <p><strong>JUMP_L(ofs_b1, ofs_b2, ofs_b3, ofs_b4)</strong> - Jump to the specified offset in the bytecode. Offset is relative to pc following JUMP insn, and can be forward only.</p>
   * <p><i> ... -> ...</i></p>
   */
  public static final byte JUMP_L           = 0x6f;
}
