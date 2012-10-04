/* DexBinding.java
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
package com.roscopeco.deelang.runtime;

import java.util.HashMap;

import dee.lang.Binding;
import dee.lang.DeelangObject;

public class DexBinding implements Binding {
  private final HashMap<String, Object> binding = new HashMap<String, Object>();
  private DeelangObject self;
  
  /* public to allow direct access from compiled scripts */
  public boolean errorFlag;
  
  @Override
  public Object getLocal(String name) {
    return binding.get(name);
  }

  @Override
  public void setLocal(String name, Object value) {
    binding.put(name, value);
  }

  @Override
  public DeelangObject getSelf() {
    return self;
  }
  
  public void setSelf(DeelangObject self) {
    this.self = self;
  }

  @Override
  public void setErrorFlag() {
    errorFlag = true;
  }
  
  public void clearErrorFlag() {
    errorFlag = false;
  }
  
  public boolean checkAndClearErrorFlag() {
    boolean r = errorFlag;
    errorFlag = false;
    return r;
  }
}
