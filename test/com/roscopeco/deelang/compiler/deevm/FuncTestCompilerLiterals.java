package com.roscopeco.deelang.compiler.deevm;

import org.junit.Before;
import org.junit.Test;

import com.roscopeco.deelang.compiler.CompilerError;
import com.roscopeco.deelang.compiler.deevm.CompiledScript;
import com.roscopeco.deelang.parser.ParserError;
import com.roscopeco.deelang.runtime.deevm.Opcodes;

public class FuncTestCompilerLiterals extends CompilerFuncTestBase {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void testIntegerLiteral() throws ParserError, CompilerError {
    runCodeAndPoolComparisonTest("1", new byte[] {
        Opcodes.IPUSHCONST_B, 0
    }, 
    new CompiledScript.ConstPoolEntry[] {
        new CompiledScript.ConstPoolInt(1)
    });
  }

  @Test
  public void testHexLiteral() throws ParserError, CompilerError {
    runCodeAndPoolComparisonTest("0xF", new byte[] {
        Opcodes.IPUSHCONST_B, 0
    }, 
    new CompiledScript.ConstPoolEntry[] {
        new CompiledScript.ConstPoolInt(15)
    });
  }

  @Test
  public void testOctalLiteral() throws ParserError, CompilerError {
    runCodeAndPoolComparisonTest("010", new byte[] {
        Opcodes.IPUSHCONST_B, 0
    }, 
    new CompiledScript.ConstPoolEntry[] {
        new CompiledScript.ConstPoolInt(8)
    });
  }

  @Test
  public void testFloatLiteral() throws ParserError, CompilerError {
    runCodeAndPoolComparisonTest("1.2", new byte[] {
        Opcodes.FPUSHCONST_B, 0
    }, 
    new CompiledScript.ConstPoolEntry[] {
        new CompiledScript.ConstPoolFloat(1.2)
    });
  }

  @Test
  public void testCharLiteral() throws ParserError, CompilerError {
    // treated as a string...
    runCodeAndPoolComparisonTest("'o'", new byte[] {
        Opcodes.SPUSHCONST_B, 0
    }, 
    new CompiledScript.ConstPoolEntry[] {
        new CompiledScript.ConstPoolString("o")
    });
  }
  
  @Test
  public void testStringLiteral() throws ParserError, CompilerError {
    runCodeAndPoolComparisonTest("\"onetwothree\"", new byte[] {
        Opcodes.SPUSHCONST_B, 0
    }, 
    new CompiledScript.ConstPoolEntry[] {
        new CompiledScript.ConstPoolString("onetwothree")
    });
  }

  @Test
  public void testStringLiteralEscapes() throws ParserError, CompilerError {
    runCodeAndPoolComparisonTest("\"\\\\ \\\" \\b \\t \\n \\f \\r \\' \\u0001\"", new byte[] {
        Opcodes.SPUSHCONST_B, 0
    }, 
    new CompiledScript.ConstPoolEntry[] {
        new CompiledScript.ConstPoolString("\\ \" \b \t \n \f \r ' \u0001")
    });
  }
}
