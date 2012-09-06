/* DeeLangFloat.java
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
package dee.vm.lang;

import com.roscopeco.deelang.vm.RuntimeContext;

/**
 * A float within the Dee VM.
 * 
 * @author rosco
 * @created 27 Oct 2011
 *
 */
public class DeeLangFloat extends DeeLangObject {
  private static final Double ZERO = new Double(0);
  
  Double dbl;

  public DeeLangFloat(RuntimeContext context) {
    super(context);
    this.dbl = ZERO;
  }
  
  public DeeLangFloat(RuntimeContext context, Double dbl) {
    super(context);
    this.dbl = dbl;
  }
  
  public Double getDouble() {
    return dbl;
  }
  
  @Override
  public String toString() {
    return dbl.toString();
  }
  
  @Override
  public DeeLangObject __opADD(DeeLangObject other) {
    if (other instanceof DeeLangInteger) {
      return new DeeLangFloat(getContext(), this.dbl + ((DeeLangInteger)other).integer);      
    } else if (other instanceof DeeLangFloat) {
      return new DeeLangFloat(getContext(), this.dbl + ((DeeLangFloat)other).dbl);
    } else {
      // TODO more type coercion...
      throw new ArithmeticException();
    }
  }
  
  @Override
  public DeeLangObject __opSUB(DeeLangObject other) {
    if (other instanceof DeeLangInteger) {
      return new DeeLangFloat(getContext(), this.dbl - ((DeeLangInteger)other).integer);      
    } else if (other instanceof DeeLangFloat) {
      return new DeeLangFloat(getContext(), this.dbl - ((DeeLangFloat)other).dbl);
    } else {
      // TODO more type coercion...
      throw new ArithmeticException();
    }
  }
  
  @Override
  public DeeLangObject __opMUL(DeeLangObject other) {
    if (other instanceof DeeLangInteger) {
      return new DeeLangFloat(getContext(), this.dbl * ((DeeLangInteger)other).integer);      
    } else if (other instanceof DeeLangFloat) {
      return new DeeLangFloat(getContext(), this.dbl * ((DeeLangFloat)other).dbl);
    } else {
      // TODO more type coercion...
      throw new ArithmeticException();
    }
  }

  @Override
  public DeeLangObject __opDIV(DeeLangObject other) {
    if (other instanceof DeeLangInteger) {
      return new DeeLangFloat(getContext(), this.dbl / ((DeeLangInteger)other).integer);      
    } else if (other instanceof DeeLangFloat) {
      return new DeeLangFloat(getContext(), this.dbl / ((DeeLangFloat)other).dbl);
    } else {
      // TODO more type coercion...
      throw new ArithmeticException();
    }
  }
  
  @Override
  public DeeLangObject __opMOD(DeeLangObject other) {
    if (other instanceof DeeLangInteger) {
      return new DeeLangFloat(getContext(), this.dbl % ((DeeLangInteger)other).integer);      
    } else if (other instanceof DeeLangFloat) {
      return new DeeLangFloat(getContext(), this.dbl % ((DeeLangFloat)other).dbl);
    } else {
      // TODO more type coercion...
      throw new ArithmeticException();
    }
  }
  
  @Override
  public DeeLangObject __opPOW(DeeLangObject other) {
    if (other instanceof DeeLangInteger) {
      return new DeeLangFloat(getContext(), Math.pow(this.dbl, ((DeeLangInteger)other).integer));      
    } else if (other instanceof DeeLangFloat) {
      return new DeeLangFloat(getContext(), Math.pow(this.dbl, ((DeeLangFloat)other).dbl));
    } else {
      // TODO more type coercion...
      throw new ArithmeticException();
    }
  }
  
  /**
   * <p>Coerce this <code>DeeLangFloat</code> to a {@link DeeLangInteger}.</p>
   * 
   * <p>This implementation returns a new {@link DeeLangInteger} containing
   * an integer representation of this <code>DeeLangFloat</code>. This is
   * obtained internally by calling {@link Double#intValue}.</p>
   * 
   * @return An integer representation of this floating-point value.
   */
  @Override
  public DeeLangInteger toI() {
    return new DeeLangInteger(context, this.dbl.intValue());
  }
  
  /**
   * <p>Coerce this <code>DeeLangFloat</code> to itself.</p>
   * 
   * <p>Simply returns <code>this</code>.</p>
   * 
   * @return This DeeLangFloat.
   */
  @Override
  public DeeLangFloat toF() {
    return this;
  }
}
