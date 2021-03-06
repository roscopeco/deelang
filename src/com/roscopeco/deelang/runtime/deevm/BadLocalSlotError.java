/* BadLocalSlotError.java
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
package com.roscopeco.deelang.runtime.deevm;

import com.roscopeco.deelang.runtime.RuntimeError;

public class BadLocalSlotError extends RuntimeError {

  /**
   * 
   */
  private static final long serialVersionUID = -1092804884195874695L;

  public BadLocalSlotError() {
  }

  public BadLocalSlotError(String arg0, Throwable arg1) {
    super(arg0, arg1);
  }

  public BadLocalSlotError(String arg0) {
    super(arg0);
  }

  public BadLocalSlotError(Throwable arg0) {
    super(arg0);
  }

}
