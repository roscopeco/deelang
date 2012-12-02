package com.roscopeco.deelang.compiler.deevm;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.junit.Test;

import com.roscopeco.deelang.compiler.Compiler;
import com.roscopeco.deelang.compiler.deevm.CompiledScript;
import com.roscopeco.deelang.compiler.deevm.DVMCompilationUnit;

import static org.junit.Assert.*;

public class FuncTestCompiledScript {
  @Test
  public void testStoreLoadRoundTrip() throws Exception {
    CompiledScript script = new Compiler().compile(new DVMCompilationUnit(), "foo(a+b)").buildScript();
    
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
    CompiledScript script = new Compiler().compile(new DVMCompilationUnit(), "foo(a+b)").buildScript();
    CompiledScript other = new Compiler().compile(new DVMCompilationUnit(), "foo(a+b)").buildScript();
    
    assertTrue(script.equals(other));
  }
}
