package com.roscopeco.deelang.compiler.dex;

import org.junit.Test;

import com.roscopeco.deelang.compiler.CompilerError;
import com.roscopeco.deelang.parser.ParserError;
import com.roscopeco.deelang.runtime.CompiledScript;

import dee.lang.Binding;

public class FuncTestCompilerCustomSuperclass extends CompilerFuncTestBase {
  public static abstract class CustomSuperclass extends CompiledScript {
    public CustomSuperclass(Binding binding) {
      super(binding);
    }
  }

  @Test
  public void testCustomSuperclass() throws ParserError, CompilerError {
    runCodeComparisonTest("", null, CustomSuperclass.class, 
        "extends com.roscopeco.deelang.compiler.dex.FuncTestCompilerCustomSuperclass$CustomSuperclass");
  }
}
