package com.roscopeco.deelang.runtime;

import java.util.HashMap;

import dee.lang.DeelangObject;

public class HashBinding implements Binding {
  private final HashMap<String, Object> binding = new HashMap<String, Object>();
  private final DeelangObject self;
  
  public HashBinding(DeelangObject self) {
    this.self = self;
  }

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
}
