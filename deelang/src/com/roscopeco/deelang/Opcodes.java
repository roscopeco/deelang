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
 * @author rosco
 * @created 19 Oct 2011
 */
public final class Opcodes {
  private Opcodes() {
    throw new java.lang.UnsupportedOperationException("Please don't do that... :|");
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
   * @deprecated The compiler never generates this instruction, and the VM does not support it - <code>@link IPUSHCONST</code> is used instead.
   */
  public static final byte IPUSH            = 0x01;     /* push - data follows in byte stream */

  /**
   * <p><strong>FPUSH (b1, b2, b3, b4, b5, b6, b7, b8, b9)</strong> - Push an inline float onto the stack.</i>
   * <p><i> ... -> ..., FLOAT</i></p>
   * 
   * @deprecated The compiler never generates this instruction, and the VM does not support it - <code>@link FPUSHCONST</code> is used instead.
   */
  public static final byte FPUSH            = 0x02;

  /**
   * <p><strong>SPUSH (lenb1, lenb2, (data_byte * len))</strong> - Push an inline mUTF string onto the stack.</i>
   * <p><i> ... -> ..., STRING</i></p>
   * 
   * @deprecated The compiler never generates this instruction, and the VM does not support it - <code>SPUSHCONST</code> is used instead.
   */
  public static final byte SPUSH            = 0x03;

  /**
   * <p><strong>IPUSHCONST(idx_b1, idx_b2, idx_b3, idx_b4)</strong> - Push an integer constant from the constant pool onto the stack.</p>
   * <p><i> ... -> ..., INT</i></p>
   */
  public static final byte IPUSHCONST       = 0x10;     /* push - data is in const pool */

  /**
   * <p><strong>FPUSHCONST(idx_b1, idx_b2, idx_b3, idx_b4)</strong> - Push a float constant from the constant pool onto the stack.</p>
   * <p><i> ... -> ..., FLOAT</i></p>
   */
  public static final byte FPUSHCONST       = 0x11;

  /**
   * <p><strong>SPUSHCONST(idx_b1, idx_b2, idx_b3, idx_b4)</strong> - Push a string constant from the constant pool onto the stack</p>
   * <p><i> ... -> ..., STRING</i></p>
   */
  public static final byte SPUSHCONST       = 0x12;

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
   * <p><strong>PUTFIELD(idx_b1, idx_b2, idx_b3, idx_b4)</strong> - Store the top object from the stack in field at constant pool index <i>idx</i> in the object at the second-top stack.</p>
   * <p><i> ..., RECEIVER, VALUE -> ...</i></p>
   */
  public static final byte PUTFIELD         = 0x28;

  /**
   * <p><strong>GETFIELD(idx_b1, idx_b2, idx_b3, idx_b4)</strong> - Retrieve the value of the field at constant pool index <i>idx</i> in the object on top of the stack, and push it to the stack.</p>
   * <p><i> ..., RECEIVER -> ..., VALUE</i></p>
   */
  public static final byte GETFIELD         = 0x29;

  /**
   * <p><strong>ADD</strong> - Pop the top two values from the stack, add them, and push the result back onto the stack.</p>
   * <p><i> ..., V1, V2 -> ..., VALUE(V1+V2)</i></p>
   * 
   * @deprecated The compiler never generates this instruction, and the VM does not support it - Arithmetic operators are implemented as method calls.
   */
  public static final byte ADD              = 0x30;

  /**
   * <p><strong>SUB</strong> - Pop the top two values from the stack, subtract V2 from V1, and push the result back onto the stack.</p>
   * <p><i> ..., V1, V2 -> ..., VALUE(V1-V2)</i></p>
   * 
   * @deprecated The compiler never generates this instruction, and the VM does not support it - Arithmetic operators are implemented as method calls.
   */
  public static final byte SUB              = 0x31;
  
  /**
   * <p><strong>MUL</strong> - Pop the top two values from the stack, multiply V1 by V2, and push the result back onto the stack.</p>
   * <p><i> ..., V1, V2 -> ..., VALUE(V1*V2)</i></p>
   * 
   * @deprecated The compiler never generates this instruction, and the VM does not support it - Arithmetic operators are implemented as method calls.
   */
  public static final byte MUL              = 0x32;

  /**
   * <p><strong>DIV</strong> - Pop the top two values from the stack, divide V1 by V2, and push the result back onto the stack.</p>
   * <p><i> ..., V1, V2 -> ..., VALUE(V1/V2)</i></p>
   * 
   * @deprecated The compiler never generates this instruction, and the VM does not support it - Arithmetic operators are implemented as method calls.
   */
  public static final byte DIV              = 0x33;

  /**
   * <p><strong>MOD</strong> - Pop the top two values from the stack, divide V1 by V2, and push the <strong>remainder</strong> back onto the stack.</p>
   * <p><i> ..., V1, V2 -> ..., VALUE(V1%V2)</i></p>
   * 
   * @deprecated The compiler never generates this instruction, and the VM does not support it - Arithmetic operators are implemented as method calls.
   */
  public static final byte MOD              = 0x34;

  /**
   * <p><strong>POW</strong> - Pop the top two values from the stack, raise V1 to the power V2, and push the result back onto the stack.</p>
   * <p><i> ..., V1, V2 -> ..., VALUE(V1^V2)</i></p>
   * 
   * @deprecated The compiler never generates this instruction, and the VM does not support it - Arithmetic operators are now implemented as method calls.
   */
  public static final byte POW              = 0x35;

  /**
   * <p><strong>INVOKESTATIC(idx_b1, idx_b2, idx_b3, idx_b4, argc)</strong> - Invoke the method referenced at constant pool <i>idx</i> with <i>argc</i> arguments, using static dispatch.</p>
   * <p><i> ..., (VALUE * argc) -> ...</i></p>
   * 
   * @deprecated The compiler never generates this instruction, and the VM does not support it - static dispatch is no longer used in DeeLang.
   */
  public static final byte INVOKESTATIC     = 0x50;

  /**
   * <p><strong>INVOKEDYNAMIC(idx_b1, idx_b2, idx_b3, idx_b4, argc)</strong> - Invoke the method referenced at constant pool <i>idx</i> with <i>argc</i> arguments, using dynamic dispatch.</p>
   * <p><i> ..., RECEIVER, (VALUE * argc) -> ...</i></p>
   */
  public static final byte INVOKEDYNAMIC    = 0x51;

  /**
   * <p><strong>INVOKESELF(idx_b1, idx_b2, idx_b3, idx_b4, argc)</strong> - Invoke the method referenced at constant pool <i>idx</i> with <i>argc</i> arguments directly on the current context's <i>SELF</i>.</p>
   * <p><i> ..., (VALUE * argc) -> ...</i></p>
   */
  public static final byte INVOKESELF       = 0x52;
  
  /**
   * <p><strong>BLOCKRETURN</strong> - Return from block execution.</p>
   * <p><i> ... -> ...</i></p>
   * 
   * @deprecated The compiler never generates this instruction, and the VM does not support it - Blocks are fixed length and begin with an <code>ENTERBLOCK_x</code> instruction.
   */
  @Deprecated
  public static final byte BLOCKRETURN      = 0x5a;
  
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

  /**
   * <p><strong>JUMP(ofs_b1, ofs_b2, ofs_b3, ofs_b4)</strong> - Jump to the specified offset in the bytecode. Offset is relative to pc following JUMP insn, and can be forward only.</p>
   * <p><i> ... -> ...</i></p>
   * 
   * @deprecated This is the same opcode as JUMP_L 
   */
  @Deprecated
  public static final byte JUMP             = 0x6f;
}