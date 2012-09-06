package com.roscopeco.deelang.runtime;


public abstract class CompiledScript implements Runnable {
  protected final Binding binding;
  
  public CompiledScript(Binding binding) {
    this.binding = binding;
  }
  
  public Binding getBinding() {
    return binding;
  }
}
