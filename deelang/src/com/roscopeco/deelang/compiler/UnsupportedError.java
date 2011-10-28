/* UnsupportedError.java
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
 * Thrown to indicate that an unsupported AST type was
 * encountered during compilation, or that the AST 
 * uses features not implemented in this version of the
 * compiler.
 *  
 * @author rosco
 * @created 19 Oct 2011
 */
public class UnsupportedError extends CompilerError {
  private static final long serialVersionUID = -7653790812759943842L;

  public UnsupportedError() {
    // TODO Auto-generated constructor stub
  }

  public UnsupportedError(String arg0, Throwable arg1) {
    super(arg0, arg1);
    // TODO Auto-generated constructor stub
  }

  public UnsupportedError(String arg0) {
    super(arg0);
    // TODO Auto-generated constructor stub
  }

  public UnsupportedError(Throwable arg0) {
    super(arg0);
    // TODO Auto-generated constructor stub
  }

}