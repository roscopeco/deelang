package com.roscopeco.deelang.runtime;

import dee.lang.DeelangObject;


public abstract class CompiledScript implements Runnable {
  protected final Binding binding;
  
  public CompiledScript(Binding binding) {
    this.binding = binding;
  }
  
  public Binding getBinding() {
    return binding;
  }
  
  public void run() {
    run(binding.getSelf(), binding);    
  }
  
  protected abstract void run(DeelangObject self, Binding binding);
}
