package com.roscopeco.deelang.compiler;

import org.junit.Before;
import org.junit.Test;

import com.roscopeco.deelang.Opcodes;

public class FuncTestCompilerAssignment extends CompilerFuncTestBase {
  

  @Before
  public void setUp() throws Exception {
  }

  @Test // (expected = UnknownVariableException.class)
  public void testPlainIdentifier() throws Throwable {
    runCodeComparisonTest("a", new byte[] {
        Opcodes.LOAD,       0
    });
  }
  
  @Test
  public void testLiteralAssignment() throws Throwable {
    runCodeComparisonTest("a=1", new byte[] {
        Opcodes.IPUSHCONST, 0, 0, 0, 0,
        Opcodes.STORE,      0
    });
  }

}
