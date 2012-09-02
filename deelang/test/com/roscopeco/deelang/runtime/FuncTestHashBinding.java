package com.roscopeco.deelang.runtime;

import static org.junit.Assert.*;

import org.junit.Test;

public class FuncTestHashBinding {
  @Test
  public void testGetSetLocal() {
    HashBinding b = new HashBinding();

    assertNull(b.getLocal("TEST"));
    
    b.setLocal("TEST", 42);    
    assertEquals(42, b.getLocal("TEST"));
    assertNull(b.getLocal("TEST2"));
  }
}
