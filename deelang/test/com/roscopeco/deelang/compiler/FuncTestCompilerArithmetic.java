package com.roscopeco.deelang.compiler;

import org.antlr.runtime.RecognitionException;
import org.junit.Before;
import org.junit.Test;

import com.roscopeco.deelang.Opcodes;
import com.roscopeco.deelang.compiler.CompiledScript;
import com.roscopeco.deelang.compiler.CompilerError;

public class FuncTestCompilerArithmetic extends CompilerFuncTestBase {

  @Before
  public void setUp() throws Exception {
  }
  
  private void runComparison(String sumCode, String expMethod) throws RecognitionException, CompilerError {
    runCodeAndPoolComparisonTest(sumCode, new byte[] {
        Opcodes.IPUSHCONST, 0, 0, 0, 0,
        Opcodes.IPUSHCONST, 0, 0, 0, 1,
        Opcodes.INVOKEDYNAMIC, 0, 0, 0, 2, 1
    }, new CompiledScript.ConstPoolEntry[] {
        new CompiledScript.ConstPoolInt(1),
        new CompiledScript.ConstPoolInt(2),
        new CompiledScript.ConstPoolMethod(expMethod)
    });

  }

  @Test
  public void testLiteralLiteralAdd() throws RecognitionException, CompilerError {
    runComparison("1+2", "__opADD");
  }
  
  @Test
  public void testLiteralLiteralSub() throws RecognitionException, CompilerError {
    runComparison("1-2", "__opSUB");
  }
  
  @Test
  public void testLiteralLiteralMul() throws RecognitionException, CompilerError {
    runComparison("1*2", "__opMUL");
  }
  
  @Test
  public void testLiteralLiteralDiv() throws RecognitionException, CompilerError {
    runComparison("1/2", "__opDIV");
  }

  @Test
  public void testLiteralLiteralMod() throws RecognitionException, CompilerError {
    runComparison("1%2", "__opMOD");
  }

  @Test
  public void testLiteralLiteralPow() throws RecognitionException, CompilerError {
    runComparison("1^2", "__opPOW");
  }

  @Test
  public void testLiteralLiteralLiteralSum() throws RecognitionException, CompilerError {
    runCodeAndPoolComparisonTest("1+2-3", new byte[] {
        Opcodes.IPUSHCONST, 0, 0, 0, 0,
        Opcodes.IPUSHCONST, 0, 0, 0, 1,
        Opcodes.INVOKEDYNAMIC, 0, 0, 0, 2, 1,
        Opcodes.IPUSHCONST, 0, 0, 0, 3,
        Opcodes.INVOKEDYNAMIC, 0, 0, 0, 4, 1
    },
    new CompiledScript.ConstPoolEntry[] {
        new CompiledScript.ConstPoolInt(1),
        new CompiledScript.ConstPoolInt(2),
        new CompiledScript.ConstPoolMethod("__opADD"),
        new CompiledScript.ConstPoolInt(3),
        new CompiledScript.ConstPoolMethod("__opSUB"),
    });
  }

  @Test
  public void testLiteralLiteralLiteralMulAddSum() throws RecognitionException, CompilerError {
    runCodeAndPoolComparisonTest("1+2*3", new byte[] {
        Opcodes.IPUSHCONST, 0, 0, 0, 0,
        Opcodes.IPUSHCONST, 0, 0, 0, 1,
        Opcodes.IPUSHCONST, 0, 0, 0, 2,
        Opcodes.INVOKEDYNAMIC, 0, 0, 0, 3, 1,
        Opcodes.INVOKEDYNAMIC, 0, 0, 0, 4, 1
    },
    new CompiledScript.ConstPoolEntry[] {
        new CompiledScript.ConstPoolInt(1),
        new CompiledScript.ConstPoolInt(2),
        new CompiledScript.ConstPoolInt(3),
        new CompiledScript.ConstPoolMethod("__opMUL"),
        new CompiledScript.ConstPoolMethod("__opADD"),
    });
  }

  @Test
  public void testLiteralLiteralLiteralMulAddSumExplicitPrecedence() throws RecognitionException, CompilerError {
    runCodeAndPoolComparisonTest("(1+2)*3", new byte[] {
        Opcodes.IPUSHCONST, 0, 0, 0, 0,
        Opcodes.IPUSHCONST, 0, 0, 0, 1,
        Opcodes.INVOKEDYNAMIC, 0, 0, 0, 2, 1,
        Opcodes.IPUSHCONST, 0, 0, 0, 3,
        Opcodes.INVOKEDYNAMIC, 0, 0, 0, 4, 1
    },
    new CompiledScript.ConstPoolEntry[] {
        new CompiledScript.ConstPoolInt(1),
        new CompiledScript.ConstPoolInt(2),
        new CompiledScript.ConstPoolMethod("__opADD"),
        new CompiledScript.ConstPoolInt(3),
        new CompiledScript.ConstPoolMethod("__opMUL")
    });
  }
}
