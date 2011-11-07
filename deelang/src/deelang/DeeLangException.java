/* DeeLangException.java
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

/**
 * Base-class for check DeeLang runtime exceptions.
 * 
 * @author rosco
 * @created 26 Oct 2011
 *
 */
public class DeeLangException extends Exception {

  /**
   * 
   */
  private static final long serialVersionUID = 6789381977097026652L;

  public DeeLangException() {
    // TODO Auto-generated constructor stub
  }

  public DeeLangException(String message) {
    super(message);
    // TODO Auto-generated constructor stub
  }

  public DeeLangException(Throwable cause) {
    super(cause);
    // TODO Auto-generated constructor stub
  }

  public DeeLangException(String message, Throwable cause) {
    super(message, cause);
    // TODO Auto-generated constructor stub
  }

}
