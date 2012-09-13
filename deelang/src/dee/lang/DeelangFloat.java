/* DeelangFloat.java
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
package dee.lang;

import com.roscopeco.deelang.runtime.Binding;

/**
 * A Deelang floating-point number (equivalent to a Java Double).
 * 
 * @author rosco
 * @created 3 September 2012
 *
 */
public class DeelangFloat extends DeelangObject {
  double dbl;

  public DeelangFloat(Binding binding, double dbl) {
    super(binding);
    this.dbl = dbl;
  }
  
  public Double getDouble() {
    return dbl;
  }
  
  @Override
  public String toString() {
    return Double.toString(dbl);
  }
  
  @Override
  public DeelangObject __opADD(DeelangObject other) {
    if (other instanceof DeelangInteger) {
      return new DeelangFloat(getBinding(), this.dbl + ((DeelangInteger)other).integer);      
    } else if (other instanceof DeelangFloat) {
      return new DeelangFloat(getBinding(), this.dbl + ((DeelangFloat)other).dbl);
    } else {
      // TODO more type coercion...
      throw new ArithmeticException();
    }
  }
  
  @Override
  public DeelangObject __opSUB(DeelangObject other) {
    if (other instanceof DeelangInteger) {
      return new DeelangFloat(getBinding(), this.dbl - ((DeelangInteger)other).integer);      
    } else if (other instanceof DeelangFloat) {
      return new DeelangFloat(getBinding(), this.dbl - ((DeelangFloat)other).dbl);
    } else {
      // TODO more type coercion...
      throw new ArithmeticException();
    }
  }
  
  @Override
  public DeelangObject __opMUL(DeelangObject other) {
    if (other instanceof DeelangInteger) {
      return new DeelangFloat(getBinding(), this.dbl * ((DeelangInteger)other).integer);      
    } else if (other instanceof DeelangFloat) {
      return new DeelangFloat(getBinding(), this.dbl * ((DeelangFloat)other).dbl);
    } else {
      // TODO more type coercion...
      throw new ArithmeticException();
    }
  }

  @Override
  public DeelangObject __opDIV(DeelangObject other) {
    if (other instanceof DeelangInteger) {
      return new DeelangFloat(getBinding(), this.dbl / ((DeelangInteger)other).integer);      
    } else if (other instanceof DeelangFloat) {
      return new DeelangFloat(getBinding(), this.dbl / ((DeelangFloat)other).dbl);
    } else {
      // TODO more type coercion...
      throw new ArithmeticException();
    }
  }
  
  @Override
  public DeelangObject __opMOD(DeelangObject other) {
    if (other instanceof DeelangInteger) {
      return new DeelangFloat(getBinding(), this.dbl % ((DeelangInteger)other).integer);      
    } else if (other instanceof DeelangFloat) {
      return new DeelangFloat(getBinding(), this.dbl % ((DeelangFloat)other).dbl);
    } else {
      // TODO more type coercion...
      throw new ArithmeticException();
    }
  }
  
  @Override
  public DeelangObject __opPOW(DeelangObject other) {
    if (other instanceof DeelangInteger) {
      return new DeelangFloat(getBinding(), Math.pow(this.dbl, ((DeelangInteger)other).integer));      
    } else if (other instanceof DeelangFloat) {
      return new DeelangFloat(getBinding(), Math.pow(this.dbl, ((DeelangFloat)other).dbl));
    } else {
      // TODO more type coercion...
      throw new ArithmeticException();
    }
  }
  
  /**
   * <p>Coerce this <code>DeelangFloat</code> to a {@link DeelangInteger}.</p>
   * 
   * <p>This implementation returns a new {@link DeelangInteger} containing
   * an integer representation of this <code>DeelangFloat</code>. This is
   * obtained internally by calling {@link Double#intValue}.</p>
   * 
   * @return An integer representation of this floating-point value.
   */
  @Override
  public DeelangInteger toI() {
    return new DeelangInteger(getBinding(), new Double(dbl).intValue());
  }
  
  /**
   * <p>Coerce this <code>DeelangFloat</code> to itself.</p>
   * 
   * <p>Simply returns <code>this</code>.</p>
   * 
   * @return This DeelangFloat.
   */
  @Override
  public DeelangFloat toF() {
    return this;
  }
}
