/* UnknownVariableException.java
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
package com.roscopeco.deelang.compiler;


/**
 * <p>Thrown to indicate that the script attempted to access a local variable
 * that has not been previously assigned to.</p>
 * 
 * <p><strong>This is currently unused</strong> since we do load-time linking
 * within the VM now.</p>
 * 
 * @deprecated To be removed.
 * @author rosco
 * @created 19 Oct 2011
 *
 */
public class UnknownVariableException extends CompilerError {

  /**
   * 
   */
  private static final long serialVersionUID = -3872310037337653004L;

  public UnknownVariableException() {
  }

  public UnknownVariableException(String arg0, Throwable arg1) {
    super(arg0, arg1);
  }

  public UnknownVariableException(String arg0) {
    super(arg0);
  }

  public UnknownVariableException(Throwable arg0) {
    super(arg0);
  }

}
