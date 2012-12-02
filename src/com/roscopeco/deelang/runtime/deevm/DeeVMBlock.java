package com.roscopeco.deelang.runtime.deevm;

import dee.lang.Block;

public class DeeVMBlock implements Block {
  private final RuntimeContext ctx;
  
  public DeeVMBlock(RuntimeContext ctx) {
    this.ctx = ctx;    
  }
  
  @Override
  public void invoke() {
    ctx.runBlock();    
  }
}
