package com.roscopeco.deelang.runtime;

import java.util.HashMap;

public class HashBinding implements Binding {
  private final HashMap<String, Object> binding = new HashMap<String, Object>();

  @Override
  public Object getLocal(String name) {
    return binding.get(name);
  }

  @Override
  public void setLocal(String name, Object value) {
    binding.put(name, value);
  }
}
