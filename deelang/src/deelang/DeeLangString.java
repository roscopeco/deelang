/* DeeLangString.java
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
package deelang;

import com.roscopeco.deelang.vm.RuntimeContext;

/**
 * A String in the Dee VM. As in Java, strings are immutable.
 * 
 * @author rosco
 * @created 27 Oct 2011
 *
 */
public class DeeLangString extends DeeLangObject {
  private String string;
  
  public DeeLangString(RuntimeContext context) {
    super(context);
    this.string = "";
  }
  
  public DeeLangString(RuntimeContext context, String string) {
    super(context);
    this.string = string;
  }
  
  public String getString() {
    return string;
  }
  
  public void setString(String string) {
    this.string = string;
  }
  
  @Override
  public String toString() {
    return string;
  }
  
  /**
   * Performs string concatenation. Coerces the <code>other</code>
   * parameter to a DeeLangString via the {@link DeeLangObject#toS()}
   * method.
   */
  @Override
  public DeeLangObject __opADD(DeeLangObject other) {
    return new DeeLangString(getContext(), string + other.toS());
  }

  /**
   * <p>"Multiplies" the string by the given number. For example,
   * <code>"one".__opMUL(2)</code> returns "oneone".</p>
   * 
   * <p><code>other</code> is coerced to an integer using the 
   * {@link DeeLangObject#toI()} method.</p>
   */
  @Override
  public DeeLangObject __opMUL(DeeLangObject other) {
    StringBuffer buf = new StringBuffer();
    int num = other.toI().integer;
    String s = toS().string;
    
    for (int i = 0; i < num; i++) {
      buf.append(s);
    }
    
    return new DeeLangString(getContext(), s);
  }
  
  /**
   * Attempts to coerce this string to an integer, specifically
   * using Java's <code>Integer.parseInt</code>.
   */
  @Override
  public DeeLangInteger toI() {
    return new DeeLangInteger(getContext(), Integer.parseInt(string));
  }

  /**
   * Attempts to coerce this string to an integer, specifically
   * using Java's <code>Double.parseDouble</code>.
   */
  @Override
  public DeeLangFloat toF() {
    return new DeeLangFloat(getContext(), Double.parseDouble(string));
  }
  
  /**
   * Returns <code>this</code>.
   */
  @Override
  public DeeLangString toS() {
    return this;
  }
  
}
