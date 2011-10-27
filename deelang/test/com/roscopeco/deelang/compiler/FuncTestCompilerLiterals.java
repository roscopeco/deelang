package com.roscopeco.deelang.compiler;

import org.antlr.runtime.RecognitionException;
import org.junit.Before;
import org.junit.Test;

import com.roscopeco.deelang.Opcodes;
import com.roscopeco.deelang.compiler.CompiledScript;
import com.roscopeco.deelang.compiler.CompilerError;

public class FuncTestCompilerLiterals extends CompilerFuncTestBase {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void testIntegerLiteral() throws RecognitionException, CompilerError {
    runCodeAndPoolComparisonTest("1", new byte[] {
        Opcodes.IPUSHCONST, 0, 0, 0, 0
    }, 
    new CompiledScript.ConstPoolEntry[] {
        new CompiledScript.ConstPoolInt(1)
    });
  }

  @Test
  public void testHexLiteral() throws RecognitionException, CompilerError {
    runCodeAndPoolComparisonTest("0xF", new byte[] {
        Opcodes.IPUSHCONST, 0, 0, 0, 0
    }, 
    new CompiledScript.ConstPoolEntry[] {
        new CompiledScript.ConstPoolInt(15)
    });
  }

  @Test
  public void testOctalLiteral() throws RecognitionException, CompilerError {
    runCodeAndPoolComparisonTest("010", new byte[] {
        Opcodes.IPUSHCONST, 0, 0, 0, 0
    }, 
    new CompiledScript.ConstPoolEntry[] {
        new CompiledScript.ConstPoolInt(8)
    });
  }

  @Test
  public void testFloatLiteral() throws RecognitionException, CompilerError {
    runCodeAndPoolComparisonTest("1.2", new byte[] {
        Opcodes.FPUSHCONST, 0, 0, 0, 0
    }, 
    new CompiledScript.ConstPoolEntry[] {
        new CompiledScript.ConstPoolFloat(1.2)
    });
  }

  @Test
  public void testCharLiteral() throws RecognitionException, CompilerError {
    // treated as a string...
    runCodeAndPoolComparisonTest("'o'", new byte[] {
        Opcodes.SPUSHCONST, 0, 0, 0, 0
    }, 
    new CompiledScript.ConstPoolEntry[] {
        new CompiledScript.ConstPoolString("o")
    });
  }
  
  @Test
  public void testStringLiteral() throws RecognitionException, CompilerError {
    runCodeAndPoolComparisonTest("\"onetwothree\"", new byte[] {
        Opcodes.SPUSHCONST, 0, 0, 0, 0
    }, 
    new CompiledScript.ConstPoolEntry[] {
        new CompiledScript.ConstPoolString("onetwothree")
    });
  }

  @Test
  public void testStringLiteralEscapes() throws RecognitionException, CompilerError {
    runCodeAndPoolComparisonTest("\"\\\\ \\\" \\b \\t \\n \\f \\r \\' \\u0001 \\/\"", new byte[] {
        Opcodes.SPUSHCONST, 0, 0, 0, 0
    }, 
    new CompiledScript.ConstPoolEntry[] {
        new CompiledScript.ConstPoolString("\\ \" \b \t \n \f \r ' \u0001 /")
    });
  }
}
