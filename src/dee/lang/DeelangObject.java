/* DeelangObject.java
 *
 * Copyright 2011-12 Ross Bamford (roscopeco AT gmail DOT com)
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
package dee.lang;

import com.roscopeco.deelang.runtime.UnsupportedOperationError;

/**
 * <p>Base-class for Deelang objects.</p>
 * 
 * <p>This class provides the standard DeeLang runtime methods,
 * as well as the functionality for calling out to blocks.</p>
 * 
 * @author rosco
 * @created 3 September 2012
 *
 */
public class DeelangObject {
  final Binding binding;
  
  public DeelangObject(Binding binding) {
    this.binding = binding;    
  }
  
  /* **** DEELANG API **** */
  /**
   * Get the {@link Binding} for this object.
   * 
   * @return This object's binding;
   */
  protected Binding getBinding() {
    return binding;
  }
  
  /* **** DEELANG RUNTIME **** */
  /**
   * <p>Print the supplied <code>DeelangObject</code> to STDOUT.</p>
   * 
   * <p>This coerces the object to a {@link DeelangString} via 
   * the <code>toS()</code> method.</p> 
   * 
   * @param s The string to print.
   */
  public void puts(DeelangObject s) {
    System.out.println(s.toS());
  }
  
  /**
   * Print the supplied string to STDOUT.
   * 
   * @param s The string to print.
   */
  public void puts(DeelangString s) {
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
   * <p>Implements the 'or' construct in Deelang code.</p>
   */
  public void or(Block block) {
    // TODO this needs some kind of error flag support in the compiler.
    //      (specifically, error flag can be supported in DeelangObject,
    //      but we must *reset* it after the method invocation in the
    //      compiler).
    throw new DeelangRuntimeException("'or' blocks not yet supported");
  }
  
  /**
   * <p>Implements the plus operator in Deelang. E.g Deelang code
   * such as 'a + b' is actually compiled to a.__opADD(b).</p>
   * 
   * <p>Since this operation makes no sense for <code>DeelangObject</code>,
   * this implementation throws an {@link UnsupportedOperationError}.</p>
   * 
   * @param other The other operand ('b' in the above example)
   * @return The result of the addition.
   */
  public DeelangObject __opADD(DeelangObject other) {
    throw new UnsupportedOperationException("Arithmetic on non-numeric type");
  }
  
  /**
   * Implements the minus operator in Deelang. E.g Deelang code
   * such as 'a - b' is actually compiled to a.__opSUB(b).
   * 
   * <p>Since this operation makes no sense for <code>DeelangObject</code>,
   * this implementation throws an {@link UnsupportedOperationError}.</p>
   * 
   * @param other The other operand ('b' in the above example)
   * @return The result of the subtraction.
   */
  public DeelangObject __opSUB(DeelangObject other) {
    throw new UnsupportedOperationException("Arithmetic on non-numeric type");
  }
  
  /**
   * Implements the multiply operator in Deelang. E.g Deelang code
   * such as 'a * b' is actually compiled to a.__opMUK(b).
   * 
   * <p>Since this operation makes no sense for <code>DeelangObject</code>,
   * this implementation throws an {@link UnsupportedOperationError}.</p>
   * 
   * @param other The other operand ('b' in the above example)
   * @return The result of the multiplication.
   */
  public DeelangObject __opMUL(DeelangObject other) {
    throw new UnsupportedOperationException("Arithmetic on non-numeric type");
  }
  
  /**
   * Implements the division operator in Deelang. E.g Deelang code
   * such as 'a / b' is actually compiled to a.__opDIV(b).
   * 
   * <p>Since this operation makes no sense for <code>DeelangObject</code>,
   * this implementation throws an {@link UnsupportedOperationError}.</p>
   * 
   * @param other The other operand ('b' in the above example)
   * @return The result of the division.
   */  
  public DeelangObject __opDIV(DeelangObject other) {
    throw new UnsupportedOperationException("Arithmetic on non-numeric type");
  }
  
  /**
   * Implements the modulo operator in Deelang. E.g Deelang code
   * such as 'a % b' is actually compiled to a.__opMOD(b).
   * 
   * <p>Since this operation makes no sense for <code>DeelangObject</code>,
   * this implementation throws an {@link UnsupportedOperationError}.</p>
   * 
   * @param other The other operand ('b' in the above example)
   * @return The result of the operation.
   */
  public DeelangObject __opMOD(DeelangObject other) {
    throw new UnsupportedOperationException("Arithmetic on non-numeric type");
  }
  
  /**
   * Implements the power operator in Deelang. E.g Deelang code
   * such as 'a ^ b' is actually compiled to a.__opPOW(b).
   * 
   * <p>Since this operation makes no sense for <code>DeelangObject</code>,
   * this implementation throws an {@link UnsupportedOperationError}.</p>
   * 
   * @param other The other operand ('b' in the above example)
   * @return The result of the operation.
   */
  public DeelangObject __opPOW(DeelangObject other) {
    throw new UnsupportedOperationException("Arithmetic on non-numeric type");
  }

  /**
   * Compares this DeelangObject to {@code other} for equality. 
   * By default, comparison is performed via the {@code equals} method.
   * 
   * @param other The object to compare to.
   * @return DeelangBoolean {@code true} or {@code false}. 
   */
  public DeelangBoolean __opEQL(DeelangObject other) {
    return binding.wrapBool(this.equals(other));
  }
  
  /**
   * Compares this DeelangObject to {@code other} for inequality. 
   * By default, comparison is performed via the {@code equals} method.
   * 
   * @param other The object to compare to.
   * @return DeelangBoolean {@code true} or {@code false}. 
   */
  public DeelangBoolean __opNEQ(DeelangObject other) {
    return (DeelangBoolean)__opEQL(other).__opNOT();
  }
  
  /**
   * Determines whether this object is 'less-than' {@code other}. 
   * Subclasses implement this in various ways. For {@code DeelangObject},
   * this comparison always throws an {@code UnsupportedOperationException}.
   * 
   * @param other The object to compare to.
   * @return DeelangBoolean {@code true} or {@code false}. 
   */
  public DeelangBoolean __opLT(DeelangObject other) {
    throw new UnsupportedOperationException("Cannot compare DeelangObject");
  }
  
  /**
   * Determines whether this object is 'greater-than' {@code other}. 
   * Subclasses implement this in various ways. For {@code DeelangObject},
   * this comparison always throws an {@code UnsupportedOperationException}.
   * 
   * @param other The object to compare to.
   * @return DeelangBoolean {@code true} or {@code false}. 
   */
  public DeelangBoolean __opGT(DeelangObject other) {
    throw new UnsupportedOperationException("Cannot compare DeelangObject");
  }
  
  /**
   * Logically negate this object. The default implementation coerces the
   * object to a boolean (using {@link #toB()}), and negates the result.
   * <br/>
   * For {@code DeelangObject} this operation always returns true. This
   * may be somewhat unexpected - but since DeelangObject's {@code toB()}
   * returns FALSE, the negation will always be TRUE. 
   * 
   * @param other The object to compare to.
   * @return DeelangBoolean {@code true} or {@code false}. 
   */
  public DeelangObject __opNOT() {
    return toB().__opNOT();
  }
  
  /* ** Type coercion ** */
  /**
   * <p>Coerce this <code>DeelangObject</code> to a {@link DeelangString}.</p>
   * 
   * <p>This implementation returns a new <code>DeelangString</code>
   * containing the result of Java's <code>toString()</code>. Thus,
   * subclasses can get toS functionality for free by implementing
   * <code>toString()</code>.</p>
   * 
   * @return A coercion of this object to a <code>DeelangString</code>.
   */
  public DeelangString toS() {
    return new DeelangString(getBinding(), toString());
  }
  
  /**
   * <p>Coerce this <code>DeelangObject</code> to a {@link DeelangInteger}.</p>
   * 
   * <p>This implementation always returns zero.</p>
   * 
   * @return A coercion of this object to a <code>DeelangInteger</code>.
   */
  public DeelangInteger toI() {
    return new DeelangInteger(getBinding(), 0);
  }
  
  /**
   * <p>Coerce this <code>DeelangObject</code> to a {@link DeelangFloat}.</p>
   * 
   * <p>This implementation always returns zero.</p>
   * 
   * @return A coercion of this object to a <code>DeelangFloat</code>.
   */
  public DeelangFloat toF() {
    return new DeelangFloat(getBinding(), 0.0);
  }  
  
  public DeelangBoolean toB() {
    return binding.FALSE;
  }
  
  /**
   * Coerces this DeelangObject to a DeelangString, then returns
   * it's Java String representation.
   */
  public String toString() {
    return toS().getString();
  }
}
