package com.roscopeco.deelang.compiler.deevm;

import org.junit.Before;
import org.junit.Test;

import com.roscopeco.deelang.compiler.CompilerError;
import com.roscopeco.deelang.compiler.deevm.CompiledScript;
import com.roscopeco.deelang.parser.ParserError;
import com.roscopeco.deelang.runtime.deevm.Opcodes;

public class FuncTestCompilerArithmetic extends CompilerFuncTestBase {

  @Before
  public void setUp() throws Exception {
  }
  
  private void runComparison(String sumCode, String expMethod) throws ParserError, CompilerError {
    runCodeAndPoolComparisonTest(sumCode, new byte[] {
        Opcodes.IPUSHCONST_B, 0,
        Opcodes.IPUSHCONST_B, 1,
        Opcodes.INVOKEDYNAMIC_B, 2, 1
    }, new CompiledScript.ConstPoolEntry[] {
        new CompiledScript.ConstPoolInt(1),
        new CompiledScript.ConstPoolInt(2),
        new CompiledScript.ConstPoolMethod(expMethod)
    });

  }

  @Test
  public void testLiteralLiteralAdd() throws ParserError, CompilerError {
    runComparison("1+2", "__opADD");
  }
  
  @Test
  public void testLiteralLiteralSub() throws ParserError, CompilerError {
    runComparison("1-2", "__opSUB");
  }
  
  @Test
  public void testLiteralLiteralMul() throws ParserError, CompilerError {
    runComparison("1*2", "__opMUL");
  }
  
  @Test
  public void testLiteralLiteralDiv() throws ParserError, CompilerError {
    runComparison("1/2", "__opDIV");
  }

  @Test
  public void testLiteralLiteralMod() throws ParserError, CompilerError {
    runComparison("1%2", "__opMOD");
  }

  @Test
  public void testLiteralLiteralPow() throws ParserError, CompilerError {
    runComparison("1^2", "__opPOW");
  }

  @Test
  public void testLiteralLiteralLiteralSum() throws ParserError, CompilerError {
    runCodeAndPoolComparisonTest("1+2-3", new byte[] {
        Opcodes.IPUSHCONST_B, 0,
        Opcodes.IPUSHCONST_B, 1,
        Opcodes.INVOKEDYNAMIC_B, 2, 1,
        Opcodes.IPUSHCONST_B, 3,
        Opcodes.INVOKEDYNAMIC_B, 4, 1
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
  public void testLiteralLiteralLiteralMulAddSum() throws ParserError, CompilerError {
    runCodeAndPoolComparisonTest("1+2*3", new byte[] {
        Opcodes.IPUSHCONST_B, 0,
        Opcodes.IPUSHCONST_B, 1,
        Opcodes.IPUSHCONST_B, 2,
        Opcodes.INVOKEDYNAMIC_B, 3, 1,
        Opcodes.INVOKEDYNAMIC_B, 4, 1
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
  public void testLiteralLiteralLiteralMulAddSumExplicitPrecedence() throws ParserError, CompilerError {
    runCodeAndPoolComparisonTest("(1+2)*3", new byte[] {
        Opcodes.IPUSHCONST_B, 0,
        Opcodes.IPUSHCONST_B, 1,
        Opcodes.INVOKEDYNAMIC_B, 2, 1,
        Opcodes.IPUSHCONST_B, 3,
        Opcodes.INVOKEDYNAMIC_B, 4, 1
    },
    new CompiledScript.ConstPoolEntry[] {
        new CompiledScript.ConstPoolInt(1),
        new CompiledScript.ConstPoolInt(2),
        new CompiledScript.ConstPoolMethod("__opADD"),
        new CompiledScript.ConstPoolInt(3),
        new CompiledScript.ConstPoolMethod("__opMUL")
    });
  }
  
  public void doChainedFieldSumTest(String code, String op) throws ParserError, CompilerError {
    runCodeAndPoolComparisonTest(code,
    new byte[] {
        Opcodes.IPUSHCONST_B, 0,
        Opcodes.INVOKESELF_B, 1, 0,
        Opcodes.GETFIELD_B, 2,
        Opcodes.INVOKEDYNAMIC_B, 3, 0,
        Opcodes.GETFIELD_B, 4,
        Opcodes.INVOKEDYNAMIC_B, 5, 1,
    },
    new CompiledScript.ConstPoolEntry[] {
        new CompiledScript.ConstPoolInt(1),
        new CompiledScript.ConstPoolMethod("boo"),
        new CompiledScript.ConstPoolField("bar"),
        new CompiledScript.ConstPoolMethod("boo2"),
        new CompiledScript.ConstPoolField("a"),
        new CompiledScript.ConstPoolMethod(op),
    });
  }
  
  @Test
  public void REGRESSIONtestAddWithChainedField() throws ParserError, CompilerError{
    doChainedFieldSumTest("1+boo().bar.boo2().a", "__opADD");
  }

  @Test
  public void REGRESSIONtestSubWithChainedField() throws ParserError, CompilerError{
    doChainedFieldSumTest("1-boo().bar.boo2().a", "__opSUB");
  }

  @Test
  public void REGRESSIONtestMulWithChainedField() throws ParserError, CompilerError{
    doChainedFieldSumTest("1*boo().bar.boo2().a", "__opMUL");
  }

  @Test
  public void REGRESSIONtestDivWithChainedField() throws ParserError, CompilerError{
    doChainedFieldSumTest("1/boo().bar.boo2().a", "__opDIV");
  }
  
  @Test
  public void REGRESSIONtestModWithChainedField() throws ParserError, CompilerError{
    doChainedFieldSumTest("1%boo().bar.boo2().a", "__opMOD");
  }

  @Test
  public void REGRESSIONtestPowWithChainedField() throws ParserError, CompilerError{
    doChainedFieldSumTest("1^boo().bar.boo2().a", "__opPOW");
  }
}
