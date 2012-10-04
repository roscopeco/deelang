package com.roscopeco.deelang.runtime;

import dee.lang.Block;
import dee.lang.DeelangObject;

public abstract class DexBlock implements Block {  
  final DexBinding binding;
  final Object[] closedLocals;  
  public boolean inScope;
  
  protected DexBlock(DeelangObject self, DexBinding binding, Object[] locals) {
    this.binding = binding;
    this.closedLocals = locals;
    this.inScope = true;
  }
  
  public void invoke() {
    if (!inScope) {
      throw new IllegalStateException("Block called when out of scope");
    }
    invoke(binding.getSelf(), binding, closedLocals, null);
  }
  
  // N.B. Args is not currently used, but may in future support block args
  /* N.B. Various things rely on this method signature's argument order! */
  protected abstract void invoke(DeelangObject self, DexBinding binding, Object[] locals, Object[] args);
}
