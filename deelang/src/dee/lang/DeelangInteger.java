package dee.lang;


/**
 * A Deelang Integer. 
 * 
 * @author rosco
 * @created 3 September 2012
 *
 */
public class DeelangInteger extends DeelangObject {
  final int integer;
  
  public DeelangInteger(Binding binding, int integer) {
    super(binding);
    this.integer = integer;
  }
  
  public int getInteger() {
    return integer;
  }
  
  @Override
  public String toString() {
    return Integer.toString(integer);
  }
  
  public void times(Block block) {
    int t = integer;
    for (int i = 0; i < t; i++) {
      block.invoke();
    }
  }

  /* ****** ARITHMETIC OPERATORS ****** */
  @Override
  public DeelangObject __opADD(DeelangObject other) {
    if (other instanceof DeelangInteger) {
      return new DeelangInteger(getBinding(), this.integer + ((DeelangInteger)other).integer);      
    } else if (other instanceof DeelangFloat) {
      return new DeelangFloat(getBinding(), this.integer + ((DeelangFloat)other).dbl);
    } else {
      // TODO more type coercion...
      throw new ArithmeticException();
    }
  }
  
  @Override
  public DeelangObject __opSUB(DeelangObject other) {
    if (other instanceof DeelangInteger) {
      return new DeelangInteger(getBinding(), this.integer - ((DeelangInteger)other).integer);      
    } else if (other instanceof DeelangFloat) {
      return new DeelangFloat(getBinding(), this.integer - ((DeelangFloat)other).dbl);
    } else {
      // TODO more type coercion...
      throw new ArithmeticException();
    }
  }
  
  @Override
  public DeelangObject __opMUL(DeelangObject other) {
    if (other instanceof DeelangInteger) {
      return new DeelangInteger(getBinding(), this.integer * ((DeelangInteger)other).integer);      
    } else if (other instanceof DeelangFloat) {
      return new DeelangFloat(getBinding(), this.integer * ((DeelangFloat)other).dbl);
    } else {
      // TODO more type coercion...
      throw new ArithmeticException();
    }
  }

  @Override
  public DeelangObject __opDIV(DeelangObject other) {
    if (other instanceof DeelangInteger) {
      return new DeelangInteger(getBinding(), this.integer / ((DeelangInteger)other).integer);      
    } else if (other instanceof DeelangFloat) {
      return new DeelangFloat(getBinding(), this.integer / ((DeelangFloat)other).dbl);
    } else {
      // TODO more type coercion...
      throw new ArithmeticException();
    }
  }
  
  @Override
  public DeelangObject __opMOD(DeelangObject other) {
    if (other instanceof DeelangInteger) {
      return new DeelangInteger(getBinding(), this.integer % ((DeelangInteger)other).integer);      
    } else if (other instanceof DeelangFloat) {
      return new DeelangFloat(getBinding(), this.integer % ((DeelangFloat)other).dbl);
    } else {
      // TODO more type coercion...
      throw new ArithmeticException();
    }
  }
  
  @Override
  public DeelangObject __opPOW(DeelangObject other) {
    if (other instanceof DeelangInteger) {
      return new DeelangInteger(getBinding(), this.integer ^ ((DeelangInteger)other).integer);      
    } else {
      // TODO more type coercion...
      throw new ArithmeticException();
    }
  }

  /**
   * <p>Coerce this <code>DeelangInteger</code> to itself.</p>
   * 
   * <p>Simply returns <code>this</code>.</p>
   * 
   * @return This DeelangInteger.
   */
  @Override
  public DeelangInteger toI() {
    return this;
  }
  
  /**
   * <p>Coerce this <code>DeelangInteger</code> to a {@link DeelangFloat}.</p>
   * 
   * <p>This implementation returns a new {@link DeelangFloat} containing a
   * double-precision floating point representation of this integer.</p>
   * 
   * @return A floating-point representation of this integer.
   */
  @Override
  public DeelangFloat toF() {
    return new DeelangFloat(getBinding(), new Integer(integer).doubleValue());
  }
}
