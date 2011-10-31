/* DeeLangObject.java
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

import com.roscopeco.deelang.vm.Context;

/**
 * <p>Base-class for objects within the DeeLang VM.</p>
 * 
 * <p>This class provides the standard DeeLang runtime methods,
 * as well as the functionality for calling out to blocks.</p>
 * @author rosco
 * @created 21 Oct 2011
 *
 */
public class DeeLangObject {
  private final Context context;
  
  public DeeLangObject(Context context) {
    this.context = context;
  }
  
  /* **** DROIDLANG API **** */
  /**
   * Get the {@link Context} to which this Object belongs.
   * 
   * @return This object's context.
   */
  protected Context getContext() {
    return context;
  }
  
  /**
   * Determine whether or not the current method call has an attached
   * block in the DeeLang code.
   * 
   * @return <code>true</code> if a block was supplied, <code>false</code> otherwise.
   */
  protected boolean hasBlock() {
    return context.isBlockNext();
  }
  
  /**
   * Call out to the attached block, and return when it is done.
   * 
   * @return <code>true</code> if a block was executed, <code>false</code> otherwise.
   */
  protected boolean callBlock() {
    return context.runBlock();
  }
  
  /* **** DROIDLANG RUNTIME **** */
  /**
   * Print the supplied string to STDOUT.
   * 
   * @param s The string to print.
   */
  public void puts(DeeLangString s) {
    System.out.println(s);
  }
  
  /**
   * Print the supplied string to STDOUT.
   * 
   * @param s The string to print.
   */
  public void puts(String s) {
    System.out.println(s);
  }
  
  /**
   * <p>Implements the 'or' construct in DeeLang code. This 
   * implementation calls out to the attached block if the
   * context's errorFlag is set.</p>
   * 
   * <p>The errorFlag is usually reset after each instruction,
   * but the VM implements special handling such that this 
   * method will always see the errorFlag as it was at the end
   * of the previous instruction.</p>
   */
  public void or() {
    if (context.isErrorFlagSet()) {
      callBlock();
    }
  }
  
  public DeeLangObject __opADD(DeeLangObject other) {
    throw new UnsupportedOperationException("Plus not implemented for object");
  }
  
  public DeeLangObject __opSUB(DeeLangObject other) {
    throw new UnsupportedOperationException("Plus not implemented for object");
  }
  
  public DeeLangObject __opMUL(DeeLangObject other) {
    throw new UnsupportedOperationException("Plus not implemented for object");
  }
  
  public DeeLangObject __opDIV(DeeLangObject other) {
    throw new UnsupportedOperationException("Plus not implemented for object");
  }
  
  public DeeLangObject __opMOD(DeeLangObject other) {
    throw new UnsupportedOperationException("Plus not implemented for object");
  }
  
  public DeeLangObject __opPOW(DeeLangObject other) {
    throw new UnsupportedOperationException("Plus not implemented for object");
  }
}
