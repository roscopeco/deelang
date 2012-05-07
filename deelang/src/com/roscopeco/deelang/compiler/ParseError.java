/* ParseError.java
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

// TODO get rid of this...

/**
 * Wraps a {@link com.roscopeco.deelang.parser.ParserError}, for some bizarre reason. No longer
 * used.
 * 
 * @deprecated To be removed.
 * @author rosco
 */
public class ParseError extends CompilerError {

  /**
   * 
   */
  private static final long serialVersionUID = 1206152605300785415L;

  public ParseError() {
  }

  public ParseError(String arg0, Throwable arg1) {
    super(arg0, arg1);
  }

  public ParseError(String arg0) {
    super(arg0);
  }

  public ParseError(Throwable arg0) {
    super(arg0);
  }

}
