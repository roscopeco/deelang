package com.roscopeco.deelang.compiler.deevm;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.junit.Test;

import com.roscopeco.deelang.compiler.Compiler;
import com.roscopeco.deelang.compiler.deevm.CompiledScript;

import static org.junit.Assert.*;

public class FuncTestCompiledScript {
  @Test
  public void testStoreLoadRoundTrip() throws Exception {
    CompiledScript script = Compiler.staticCompileDVM("foo(a+b)");
    
    ByteArrayOutputStream os = new ByteArrayOutputStream();
    script.store(os);
    
    ByteArrayInputStream is = new ByteArrayInputStream(os.toByteArray());
    CompiledScript loaded = CompiledScript.load(is);
    
    assertArrayEquals("Const pool is not equal", script.getConstPool(), loaded.getConstPool());
    assertArrayEquals("Locals are not equal", script.getLocalsTable(), loaded.getLocalsTable());
    assertArrayEquals("Code is not equal", script.getCode(), loaded.getCode());
  }

  @Test
  public void testEquals() throws Exception {
    CompiledScript script = Compiler.staticCompileDVM("foo(a+b)");
    CompiledScript other = Compiler.staticCompileDVM("foo(a+b)");
    
    assertTrue(script.equals(other));
  }
}
