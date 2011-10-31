/* DeeLangObject.java
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
package com.roscopeco.deelang.runtime;

import com.roscopeco.deelang.vm.Context;
import com.roscopeco.deelang.vm.UnsupportedOperationError;

/**
 * <p>Base-class for objects within the DeeLang VM.</p>
 * 
 * <p>This class provides the standard DeeLang runtime methods,
 * as well as the functionality for calling out to blocks.</p>
 * @author rosco
 * @created 21 Oct 2011
 *
 */
public class DeeLangObject {
  final Context context;
  
  public DeeLangObject(Context context) {
    this.context = context;
  }
  
  /* **** DROIDLANG API **** */
  /**
   * Get the {@link Context} to which this Object belongs.
   * 
   * @return This object's context.
   */
  protected Context getContext() {
    return context;
  }
  
  /**
   * Determine whether or not the current method call has an attached
   * block in the DeeLang code.
   * 
   * @return <code>true</code> if a block was supplied, <code>false</code> otherwise.
   */
  protected boolean hasBlock() {
    return context.isBlockNext();
  }
  
  /**
   * Call out to the attached block, and return when it is done.
   * 
   * @return <code>true</code> if a block was executed, <code>false</code> otherwise.
   */
  protected boolean callBlock() {
    return context.runBlock();
  }
  
  /**
   * Set the error flag in the current context. This simply calls
   * through to <code>getContext().setErrorFlag()</code>.
   */
  protected void setErrorFlag() {
    context.setErrorFlag();
  }
  
  /* **** DROIDLANG RUNTIME **** */
  /**
   * <p>Print the supplied <code>DeeLangObject</code> to STDOUT.</p>
   * 
   * <p>This coerces the object to a {@link DeeLangString} via 
   * the <code>toS()</code> method.</p> 
   * 
   * @param s The string to print.
   */
  public void puts(DeeLangObject s) {
    System.out.println(s.toS());
  }
  
  /**
   * Print the supplied string to STDOUT.
   * 
   * @param s The string to print.
   */
  public void puts(DeeLangString s) {
    System.out.println(s);
  }
  
  /**
   * Print the supplied string to STDOUT.
   * 
   * @param s The string to print.
   */
  public void puts(String s) {
    System.out.println(s);
  }
  
  /**
   * <p>Implements the 'or' construct in DeeLang code. This 
   * implementation calls out to the attached block if the
   * context's errorFlag is set.</p>
   */
  public void or() {
    if (context.isErrorFlagSet()) {
      callBlock();
    }
  }
  
  /**
   * <p>Implements the plus operator in DeeLang. E.g DeeLang code
   * such as 'a + b' is actually compiled to a.__opADD(b).</p>
   * 
   * <p>Since this operation makes no sense for <code>DeeLangObject</code>,
   * this implementation throws an {@link UnsupportedOperationError}.</p>
   * 
   * @param other The other operand ('b' in the above example)
   * @return The result of the addition.
   */
  public DeeLangObject __opADD(DeeLangObject other) {
    throw new UnsupportedOperationException("Plus not implemented for object");
  }
  
  /**
   * Implements the minus operator in DeeLang. E.g DeeLang code
   * such as 'a - b' is actually compiled to a.__opSUB(b).
   * 
   * <p>Since this operation makes no sense for <code>DeeLangObject</code>,
   * this implementation throws an {@link UnsupportedOperationError}.</p>
   * 
   * @param other The other operand ('b' in the above example)
   * @return The result of the subtraction.
   */
  public DeeLangObject __opSUB(DeeLangObject other) {
    throw new UnsupportedOperationException("Plus not implemented for object");
  }
  
  /**
   * Implements the multiply operator in DeeLang. E.g DeeLang code
   * such as 'a * b' is actually compiled to a.__opMUK(b).
   * 
   * <p>Since this operation makes no sense for <code>DeeLangObject</code>,
   * this implementation throws an {@link UnsupportedOperationError}.</p>
   * 
   * @param other The other operand ('b' in the above example)
   * @return The result of the multiplication.
   */
  public DeeLangObject __opMUL(DeeLangObject other) {
    throw new UnsupportedOperationException("Plus not implemented for object");
  }
  
  /**
   * Implements the division operator in DeeLang. E.g DeeLang code
   * such as 'a / b' is actually compiled to a.__opDIV(b).
   * 
   * <p>Since this operation makes no sense for <code>DeeLangObject</code>,
   * this implementation throws an {@link UnsupportedOperationError}.</p>
   * 
   * @param other The other operand ('b' in the above example)
   * @return The result of the division.
   */  
  public DeeLangObject __opDIV(DeeLangObject other) {
    throw new UnsupportedOperationException("Plus not implemented for object");
  }
  
  /**
   * Implements the modulo operator in DeeLang. E.g DeeLang code
   * such as 'a % b' is actually compiled to a.__opMOD(b).
   * 
   * <p>Since this operation makes no sense for <code>DeeLangObject</code>,
   * this implementation throws an {@link UnsupportedOperationError}.</p>
   * 
   * @param other The other operand ('b' in the above example)
   * @return The result of the operation.
   */
  public DeeLangObject __opMOD(DeeLangObject other) {
    throw new UnsupportedOperationException("Plus not implemented for object");
  }
  
  /**
   * Implements the power operator in DeeLang. E.g DeeLang code
   * such as 'a ^ b' is actually compiled to a.__opPOW(b).
   * 
   * <p>Since this operation makes no sense for <code>DeeLangObject</code>,
   * this implementation throws an {@link UnsupportedOperationError}.</p>
   * 
   * @param other The other operand ('b' in the above example)
   * @return The result of the operation.
   */
  public DeeLangObject __opPOW(DeeLangObject other) {
    throw new UnsupportedOperationException("Plus not implemented for object");
  }
  
  /* ** Type coercion ** */
  /**
   * <p>Coerce this <code>DeeLangObject</code> to a {@link DeeLangString}.</p>
   * 
   * <p>This implementation returns a new <code>DeeLangString</code>
   * containing the result of Java's <code>toString()</code>. Thus,
   * subclasses can get toS functionality for free by implementing
   * <code>toString()</code>.</p>
   * 
   * @return A coercion of this object to a <code>DeeLangString</code>.
   */
  public DeeLangString toS() {
    return new DeeLangString(context, toString());
  }
  
  /**
   * <p>Coerce this <code>DeeLangObject</code> to a {@link DeeLangInteger}.</p>
   * 
   * <p>This implementation always returns zero (specifically,
   * getContext().ZERO).</p>
   * 
   * @return A coercion of this object to a <code>DeeLangInteger</code>.
   */
  public DeeLangInteger toI() {
    return context.ZERO;
  }
  
  /**
   * <p>Coerce this <code>DeeLangObject</code> to a {@link DeeLangFloat}.</p>
   * 
   * <p>This implementation always returns zero (specifically,
   * getContext().FZERO).</p>
   * 
   * @return A coercion of this object to a <code>DeeLangFloat</code>.
   */
  public DeeLangFloat toF() {
    return context.FZERO;
  }
}
