package com.roscopeco.deelang.vm.compiler;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.roscopeco.deelang.vm.compiler.CompiledScript;

public class UnitTestCompiledScript {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void testCompiledScriptInt() {
    CompiledScript s = new CompiledScript(10);
    assertThat(s.getConstPool().length, is(10));
  }

  @Test
  public void testCompiledScriptConstPoolEntryArrayByteArray() {
    byte[] b = new byte[1];
    CompiledScript.ConstPoolEntry[] p = new CompiledScript.ConstPoolEntry[2]; 
    String[] l = new String[3];
    
    CompiledScript s = new CompiledScript(p,l,b);
    
    assertArrayEquals(b, s.getCode());
    assertArrayEquals(p, s.getConstPool());
    assertArrayEquals(l, s.getLocalsTable());
  }
}
