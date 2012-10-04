/* Block.java
 *
 * Copyright 2012 Ross Bamford (roscopeco AT gmail DOT com)
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
 * <p>A runtime code block. Blocks are passed to compatible methods
 * at runtime by Deelang.</p>
 * 
 * <p>When defining an extension point in Java, if the first argument
 * type is {@code Block}, Deelang will accept pass in the attached block
 * from the Deelang code when the method is called. The method may then
 * invoke the block at any point (and any number of times) by calling
 * {@link #invoke()}.</p>
 *  
 * @author Ross Bamford
 */
public interface Block {  
  public void invoke();
}
