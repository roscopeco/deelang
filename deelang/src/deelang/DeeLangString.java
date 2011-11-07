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

import com.roscopeco.deelang.vm.Context;

/**
 * A String in the Dee VM. 
 * 
 * @author rosco
 * @created 27 Oct 2011
 *
 */
public class DeeLangString extends DeeLangObject {
  private String string;
  
  public DeeLangString(Context context) {
    super(context);
    this.string = "";
  }
  
  public DeeLangString(Context context, String string) {
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
  
  @Override
  public DeeLangObject __opADD(DeeLangObject other) {
    return new DeeLangString(getContext(), string + other.toString());
  }  
}
