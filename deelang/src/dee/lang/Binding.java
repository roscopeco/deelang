/* Binding.java
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
 * <p>Binding used to initialize the Deelang environment when
 * scripts are run. Implementations of this class are
 * used by the appropriate compiler and runtime to initialize
 * the environment (local variables, self reference, and so on).</p>
 * 
 * <p>Note the <em>initialize</em> in the previous paragraph - 
 * no guarantees are made that the variables in the binding will
 * be kept up to date with the actual variables at runtime, nor
 * that after a script is run they will reflect updated values.</p>
 * 
 * <p>If you wish to obtain information back from Deelang code, 
 * you may use fields on bound objects, or store information 
 * during method calls (for example).</p>
 * 
 * @author Ross Bamford
 */
public interface Binding {
  public Object getLocal(String name);
  public void setLocal(String name, Object value);
  public DeelangObject getSelf();
  
  /**
   * Set the runtime error flag. If this is set, and the current
   * method has an attached <em>or</em>-block, that block will
   * be executed when the method returns.
   */
  public void setErrorFlag();  
}
