package com.roscopeco.deelang.compiler.dex;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import com.roscopeco.deelang.compiler.Compiler;
import com.roscopeco.deelang.compiler.CompilerError;
import com.roscopeco.deelang.parser.Parser;
import com.roscopeco.deelang.parser.ParserError;

public class CompilerFuncTestBase {
  DexCompilationUnit runTest(String code) throws ParserError, CompilerError {
    return (DexCompilationUnit) new Compiler().compile(
        new DexCompilationUnit("UNITTESTS"), Parser.staticParse(code));
  }

  void runCodeComparisonTest(String code, byte[] expected) throws ParserError, CompilerError {
    byte[] bcode = runTest(code).getCode();
    
    assertThat("Incorrect code length", bcode.length, is(expected.length));
    assertEquals("Code doesn't match", Arrays.toString(bcode), Arrays.toString(expected));
  }
}
