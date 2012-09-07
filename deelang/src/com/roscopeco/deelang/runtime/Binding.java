package com.roscopeco.deelang.runtime;

import dee.lang.DeelangObject;

public interface Binding {
  public Object getLocal(String name);
  public void setLocal(String name, Object value);
  public DeelangObject getSelf();
}
