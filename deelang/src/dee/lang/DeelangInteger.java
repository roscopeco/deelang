/* DeelangInteger.java
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
      return new DeelangInteger(binding, this.integer + ((DeelangInteger)other).integer);      
    } else if (other instanceof DeelangFloat) {
      return new DeelangFloat(binding, this.integer + ((DeelangFloat)other).dbl);
    } else {
      // TODO more type coercion...
      throw new ArithmeticException();
    }
  }
  
  @Override
  public DeelangObject __opSUB(DeelangObject other) {
    if (other instanceof DeelangInteger) {
      return new DeelangInteger(binding, this.integer - ((DeelangInteger)other).integer);      
    } else if (other instanceof DeelangFloat) {
      return new DeelangFloat(binding, this.integer - ((DeelangFloat)other).dbl);
    } else {
      // TODO more type coercion...
      throw new ArithmeticException();
    }
  }
  
  @Override
  public DeelangObject __opMUL(DeelangObject other) {
    if (other instanceof DeelangInteger) {
      return new DeelangInteger(binding, this.integer * ((DeelangInteger)other).integer);      
    } else if (other instanceof DeelangFloat) {
      return new DeelangFloat(binding, this.integer * ((DeelangFloat)other).dbl);
    } else {
      // TODO more type coercion...
      throw new ArithmeticException();
    }
  }

  @Override
  public DeelangObject __opDIV(DeelangObject other) {
    if (other instanceof DeelangInteger) {
      return new DeelangInteger(binding, this.integer / ((DeelangInteger)other).integer);      
    } else if (other instanceof DeelangFloat) {
      return new DeelangFloat(binding, this.integer / ((DeelangFloat)other).dbl);
    } else {
      // TODO more type coercion...
      throw new ArithmeticException();
    }
  }
  
  @Override
  public DeelangObject __opMOD(DeelangObject other) {
    if (other instanceof DeelangInteger) {
      return new DeelangInteger(binding, this.integer % ((DeelangInteger)other).integer);      
    } else if (other instanceof DeelangFloat) {
      return new DeelangFloat(binding, this.integer % ((DeelangFloat)other).dbl);
    } else {
      // TODO more type coercion...
      throw new ArithmeticException();
    }
  }
  
  @Override
  public DeelangObject __opPOW(DeelangObject other) {
    if (other instanceof DeelangInteger) {
      return new DeelangInteger(binding, this.integer ^ ((DeelangInteger)other).integer);      
    } else {
      // TODO more type coercion...
      throw new ArithmeticException();
    }
  }

  @Override
  public DeelangBoolean __opLT(DeelangObject other) {
    // TODO Auto-generated method stub
    return super.__opLT(other);
  }

  @Override
  public DeelangBoolean __opGT(DeelangObject other) {
    // TODO Auto-generated method stub
    return super.__opGT(other);
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
    return new DeelangFloat(binding, new Integer(integer).doubleValue());
  }

  @Override
  public DeelangBoolean toB() {
    return (integer == 0) ? binding.FALSE : binding.TRUE;
  }

  /**
   * Override equality. This implements the equals operator
   * in Deelang.
   */
  @Override
  public boolean equals(Object other) {
    if (other instanceof DeelangInteger) {
      return this.integer == ((DeelangInteger) other).integer;
    } else if (other instanceof DeelangObject) {
      return this.integer == ((DeelangObject) other).toI().integer;
    } else {
      return false;
    } 
  }  
}
