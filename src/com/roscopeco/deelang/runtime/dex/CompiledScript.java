/* CompiledScript.java
 *
 * Copyright 2012 Ross Bamford (roscopeco AT gmail DOT com)
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
package com.roscopeco.deelang.runtime.dex;

import java.lang.reflect.InvocationTargetException;

import com.roscopeco.deelang.compiler.CompilerBug;

import dee.lang.Binding;
import dee.lang.DeelangObject;
import dee.lang.DeelangRuntimeException;

public abstract class CompiledScript implements Runnable {
  protected final DexBinding binding;
  
  public static <T extends CompiledScript> T newInstance(Class<T> clz, Binding b) {
    try {
      return clz.getConstructor(DexBinding.class).newInstance(b);
    } catch (InvocationTargetException e) {
      throw new DeelangRuntimeException(new CompilerBug("Exception thrown by generated <init>", e));
    } catch (IllegalAccessException e) {
      throw new DeelangRuntimeException(new CompilerBug("Generated <init> is not accessible", e));
    } catch (NoSuchMethodException e) {
      throw new DeelangRuntimeException(new CompilerBug("<init> was not generated", e));
    } catch (InstantiationException e) {
      throw new DeelangRuntimeException("Cannot instantiate script class", e);
    }    
  }
  
  public CompiledScript(DexBinding binding) {
    this.binding = binding;
  }
  
  public DexBinding getBinding() {
    return binding;
  }
  
  public void run() {
    run(binding.getSelf(), binding);    
  }
  
  /**
   * The script implementation.
   * 
   * The compiler creates an implementation of this method with the
   * compiled script code. 
   * 
   * @param self The <code>self</code> object (should be <code>binding.getSelf()</code>). 
   * @param binding The {@link Binding} to use for the run.
   */
  /* N.B. Various things rely on this method signature's argument order! */
  protected abstract void run(DeelangObject self, DexBinding binding);
}
