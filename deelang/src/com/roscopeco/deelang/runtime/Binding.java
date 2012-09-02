package com.roscopeco.deelang.runtime;

public interface Binding {
  public Object getLocal(String name);
  public void setLocal(String name, Object value);
}
