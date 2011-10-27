/* UnexpectedInputException.java
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
package com.roscopeco.deelang.parser;

import org.antlr.runtime.IntStream;
import org.antlr.runtime.RecognitionException;

/**
 * <p>Thrown to indicate the parser encountered unexpected input.</p>
 * 
 * <p><strong>This is currently unused</strong> pending development of a proper
 * parser error exception hierarchy.
 * 
 * @deprecated To be removed.
 * @author rosco
 * @created 18 Oct 2011
 *
 */
@Deprecated
public class UnexpectedInputException extends RecognitionException {
  
  private String message = null;

  /**
   * 
   */
  private static final long serialVersionUID = -1422236123280130849L;

  public UnexpectedInputException() {
    super();
  }

  public UnexpectedInputException(IntStream input) {
    super(input);
  }

  public UnexpectedInputException(String message) {
    this.message = message;
  }

  public UnexpectedInputException(String message, IntStream input) {
    super(input);
    this.message = message;
  }
  
  @Override
  public String getMessage() {
    return message;
  }
}
