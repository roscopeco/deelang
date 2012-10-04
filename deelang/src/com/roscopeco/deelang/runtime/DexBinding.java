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
