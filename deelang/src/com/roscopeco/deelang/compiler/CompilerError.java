/* CompilerError.java - Base-class for all compiler exceptions.
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
 * <p>Base-class for errors thrown by the compiler.</p>
 * 
 * @author rosco
 * @created 9 Oct 2011
 *
 */
public class CompilerError extends Exception {
  private static final long serialVersionUID = -3227586422196534024L;

  public CompilerError() {
    super();
  }

  public CompilerError(String arg0, Throwable arg1) {
    super(arg0, arg1);
  }

  public CompilerError(String arg0) {
    super(arg0);
  }

  public CompilerError(Throwable arg0) {
    super(arg0);
  }
}
