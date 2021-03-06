/* DeelangString.java
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


/**
 * A Deelang String. As in Java, strings are immutable.
 * 
 * @author rosco
 * @created 3 September 2012
 *
 */
public class DeelangString extends DeelangObject {
  private final String string;
  
  public DeelangString(Binding binding) {
    super(binding);
    this.string = "";
  }
  
  public DeelangString(Binding binding, String string) {
    super(binding);
    this.string = string;
  }
  
  public String getString() {
    return string;
  }
  
  @Override
  public String toString() {
    return string;
  }
  
  /**
   * Performs string concatenation. Coerces the <code>other</code>
   * parameter to a DeelangString via the {@link DeelangObject#toS()}
   * method.
   */
  @Override
  public DeelangObject __opADD(DeelangObject other) {
    return new DeelangString(binding, string + other.toS());
  }

  /**
   * <p>"Multiplies" the string by the given number. For example,
   * <code>"one".__opMUL(2)</code> returns "oneone".</p>
   * 
   * <p><code>other</code> is coerced to an integer using the 
   * {@link DeelangObject#toI()} method.</p>
   */
  @Override
  public DeelangObject __opMUL(DeelangObject other) {
    StringBuffer buf = new StringBuffer();
    int num = other.toI().integer;
    String s = string;
    
    for (int i = 0; i < num; i++) {
      buf.append(s);
    }
    
    return new DeelangString(binding, s);
  }

  /**
   * Override equality. This implements the equals operator
   * in Deelang.
   */
  @Override
  public boolean equals(Object other) {
    if (other instanceof DeelangString) {
      return this.string.equals(((DeelangString) other).string);
    } else if (other instanceof DeelangObject) {
      return this.string.equals(((DeelangObject) other).toS().string);
    } else {
      return this.string.equals(other);
    } 
  }
  
  /**
   * Attempts to coerce this string to an integer, specifically
   * using Java's <code>Integer.parseInt</code>.
   */
  @Override
  public DeelangInteger toI() {
    return new DeelangInteger(binding, Integer.parseInt(string));
  }

  /**
   * Attempts to coerce this string to an integer, specifically
   * using Java's <code>Double.parseDouble</code>.
   */
  @Override
  public DeelangFloat toF() {
    return new DeelangFloat(binding, Double.parseDouble(string));
  }
  
  /**
   * Returns <code>this</code>.
   */
  @Override
  public DeelangString toS() {
    return this;
  }

  @Override
  public DeelangBoolean toB() {
    return "true".equals(string) ? binding.TRUE : binding.FALSE; 
  }
}
