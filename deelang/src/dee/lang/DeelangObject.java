package dee.lang;

import com.roscopeco.deelang.runtime.Binding;
import com.roscopeco.deelang.runtime.Block;
import com.roscopeco.deelang.vm.UnsupportedOperationError;

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
    // TODO implement this
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
    throw new UnsupportedOperationException("Plus not implemented for object");
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
    throw new UnsupportedOperationException("Plus not implemented for object");
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
    throw new UnsupportedOperationException("Plus not implemented for object");
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
    throw new UnsupportedOperationException("Plus not implemented for object");
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
    throw new UnsupportedOperationException("Plus not implemented for object");
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
    throw new UnsupportedOperationException("Plus not implemented for object");
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
}
