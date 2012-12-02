/* RuntimeError.java
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
package com.roscopeco.deelang.runtime;

/**
 * <p>Base-class for Errors thrown by the VM at runtime to indicate
 * abnormal low-level conditions.</p>
 * 
 * <p>Note that this class subclasses <code>java.lang.Error</code>, so
 * these errors are unchecked. Most exceptions thrown at runtime will
 * be subclasses of {@link dee.vm.lang.DeeLangException}.</p>
 * 
 * @author rosco
 * @created 27 Oct 2011
 *
 */
public class RuntimeError extends Error {

  /**
   * 
   */
  private static final long serialVersionUID = 7203811400226307616L;

  public RuntimeError() {
  }

  public RuntimeError(String arg0) {
    super(arg0);
  }

  public RuntimeError(Throwable arg0) {
    super(arg0);
  }

  public RuntimeError(String arg0, Throwable arg1) {
    super(arg0, arg1);
  }

}
