package com.roscopeco.deelang.runtime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import dee.lang.DeelangInteger;

public class FuncTestHashBinding {
  @Test
  public void testGetSetLocal() {
    DexBinding b = new DexBinding();

    assertNull(b.getLocal("TEST"));
    
    b.setLocal("TEST", 42);    
    assertEquals(42, b.getLocal("TEST"));
    assertNull(b.getLocal("TEST2"));
  }

  @Test
  public void testGetSetSelf() {
    DexBinding b = new DexBinding();

    assertNull(b.getSelf());
    
    DeelangInteger dli = new DeelangInteger(b, 42);
    b.setSelf(dli);    
    assertEquals(dli, b.getSelf());
  }
}
