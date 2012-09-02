package com.roscopeco.deelang.compiler.dex;

import com.roscopeco.deelang.runtime.Binding;

public abstract class CompiledScript implements Runnable {
  private final Binding binding;
  
  public CompiledScript(Binding binding) {
    this.binding = binding;
  }
  
  public Binding getBinding() {
    return binding;
  }
}
