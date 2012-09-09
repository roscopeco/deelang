package com.roscopeco.deelang.compiler.dex;

import org.junit.Test;

public class FuncTestCompilerVarsAndFields extends CompilerFuncTestBase {
  
  @Test
  public void testPlainIdentifier() throws Throwable {
    runCodeComparisonTest("a", 
        "extends com.roscopeco.deelang.runtime.CompiledScript",
        "public V run(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.Binding)\n"+
        "                this:v0   //DexCompiledScript__UUID__\n"+
        "                    :v1   //dee.lang.DeelangObject\n"+
        "                    :v2   //com.roscopeco.deelang.runtime.Binding\n"+
        // Should generate no code.
        "RETURN_VOID         |     |return");
  }
}
