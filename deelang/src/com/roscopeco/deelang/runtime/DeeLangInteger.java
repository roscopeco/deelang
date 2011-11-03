/* DeeLangInteger.java
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

/**
 * An Integer within the Dee VM.
 * @author rosco
 * @created 27 Oct 2011
 *
 */
public class DeeLangInteger extends DeeLangObject {
  private static final Integer ZERO = new Integer(0);
  
  Integer integer;

  public DeeLangInteger(Context context) {
    super(context);
    this.integer = ZERO;
  }
  
  public DeeLangInteger(Context context, Integer integer) {
    super(context);
    this.integer = integer;
  }
  
  public Integer getInteger() {
    return integer;
  }
  
  @Override
  public String toString() {
    return integer.toString();
  }
  
  public void times() {
    if (hasBlock()) {
      int t = integer;
      for (int i = 0; i < t; i++) {
        callBlock();
      }
    }
  }

  /* ****** ARITHMETIC OPERATORS ****** */
  @Override
  public DeeLangObject __opADD(DeeLangObject other) {
    if (other instanceof DeeLangInteger) {
      return new DeeLangInteger(getContext(), this.integer + ((DeeLangInteger)other).integer);      
    } else if (other instanceof DeeLangFloat) {
      return new DeeLangFloat(getContext(), this.integer + ((DeeLangFloat)other).dbl);
    } else {
      // TODO more type coercion...
      throw new ArithmeticException();
    }
  }
  
  @Override
  public DeeLangObject __opSUB(DeeLangObject other) {
    if (other instanceof DeeLangInteger) {
      return new DeeLangInteger(getContext(), this.integer - ((DeeLangInteger)other).integer);      
    } else if (other instanceof DeeLangFloat) {
      return new DeeLangFloat(getContext(), this.integer - ((DeeLangFloat)other).dbl);
    } else {
      // TODO more type coercion...
      throw new ArithmeticException();
    }
  }
  
  @Override
  public DeeLangObject __opMUL(DeeLangObject other) {
    if (other instanceof DeeLangInteger) {
      return new DeeLangInteger(getContext(), this.integer * ((DeeLangInteger)other).integer);      
    } else if (other instanceof DeeLangFloat) {
      return new DeeLangFloat(getContext(), this.integer * ((DeeLangFloat)other).dbl);
    } else {
      // TODO more type coercion...
      throw new ArithmeticException();
    }
  }

  @Override
  public DeeLangObject __opDIV(DeeLangObject other) {
    if (other instanceof DeeLangInteger) {
      return new DeeLangInteger(getContext(), this.integer / ((DeeLangInteger)other).integer);      
    } else if (other instanceof DeeLangFloat) {
      return new DeeLangFloat(getContext(), this.integer / ((DeeLangFloat)other).dbl);
    } else {
      // TODO more type coercion...
      throw new ArithmeticException();
    }
  }
  
  @Override
  public DeeLangObject __opMOD(DeeLangObject other) {
    if (other instanceof DeeLangInteger) {
      return new DeeLangInteger(getContext(), this.integer % ((DeeLangInteger)other).integer);      
    } else if (other instanceof DeeLangFloat) {
      return new DeeLangFloat(getContext(), this.integer % ((DeeLangFloat)other).dbl);
    } else {
      // TODO more type coercion...
      throw new ArithmeticException();
    }
  }
  
  @Override
  public DeeLangObject __opPOW(DeeLangObject other) {
    if (other instanceof DeeLangInteger) {
      return new DeeLangInteger(getContext(), this.integer ^ ((DeeLangInteger)other).integer);      
    } else {
      // TODO more type coercion...
      throw new ArithmeticException();
    }
  }

  @Override
  public DeeLangInteger toI() {
    return this;
  }
  
  @Override
  public DeeLangFloat toF() {
    return new DeeLangFloat(context, this.integer.doubleValue());
  }
}
