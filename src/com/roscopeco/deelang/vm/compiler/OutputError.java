/* OutputError.java
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
package com.roscopeco.deelang.vm.compiler;

import com.roscopeco.deelang.compiler.CompilerError;

/**
 * Thrown to indicate that the compiler could not write it's output
 * to an OutputStream.
 *  
 * @author rosco
 * @created 19 Oct 2011
 */
public class OutputError extends CompilerError {

  /**
   * 
   */
  private static final long serialVersionUID = -5843388492617198308L;

  public OutputError() {
  }

  public OutputError(String arg0, Throwable arg1) {
    super(arg0, arg1);
  }

  public OutputError(String arg0) {
    super(arg0);
  }

  public OutputError(Throwable arg0) {
    super(arg0);
  }

}
