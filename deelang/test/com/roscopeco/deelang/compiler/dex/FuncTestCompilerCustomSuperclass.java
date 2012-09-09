package com.roscopeco.deelang.compiler.dex;

import org.junit.Test;

import com.roscopeco.deelang.compiler.CompilerError;
import com.roscopeco.deelang.parser.ParserError;
import com.roscopeco.deelang.runtime.Binding;
import com.roscopeco.deelang.runtime.CompiledScript;

public class FuncTestCompilerCustomSuperclass extends CompilerFuncTestBase {
  public static abstract class CustomSuperclass extends CompiledScript {
    public CustomSuperclass(Binding binding) {
      super(binding);
    }
  }

  @Test
  public void testCustomSuperclass() throws ParserError, CompilerError {
    runCodeComparisonTest("", null, CustomSuperclass.class, 
        "extends com.roscopeco.deelang.compiler.dex.FuncTestCompilerCustomSuperclass$CustomSuperclass",
        "public V run(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.Binding)\n" +
        "                this:v0   //DexCompiledScript__UUID__\n"+
        "                    :v1   //dee.lang.DeelangObject\n"+
        "                    :v2   //com.roscopeco.deelang.runtime.Binding\n"+
        "RETURN_VOID         |     |return");
  }
}
