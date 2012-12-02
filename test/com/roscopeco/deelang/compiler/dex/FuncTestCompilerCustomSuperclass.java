package com.roscopeco.deelang.compiler.dex;

import org.junit.Test;

import com.roscopeco.deelang.compiler.CompilerError;
import com.roscopeco.deelang.parser.ParserError;
import com.roscopeco.deelang.runtime.dex.CompiledScript;
import com.roscopeco.deelang.runtime.dex.DexBinding;

public class FuncTestCompilerCustomSuperclass extends CompilerFuncTestBase {
  public static abstract class CustomSuperclass extends CompiledScript {
    public CustomSuperclass(DexBinding binding) {
      super(binding);
    }
  }

  @Test
  public void testCustomSuperclass() throws ParserError, CompilerError {
    runCodeComparisonTest("", null, CustomSuperclass.class, 
        "extends com.roscopeco.deelang.compiler.dex.FuncTestCompilerCustomSuperclass$CustomSuperclass");
  }
}
