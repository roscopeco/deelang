package com.roscopeco.deelang.compiler.deevm;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import com.roscopeco.deelang.compiler.Compiler;
import com.roscopeco.deelang.compiler.CompilerError;
import com.roscopeco.deelang.compiler.deevm.CompiledScript;
import com.roscopeco.deelang.compiler.deevm.DVMCompilationUnit;
import com.roscopeco.deelang.parser.ParserError;
import com.roscopeco.deelang.runtime.deevm.ScriptDumper;

public class CompilerFuncTestBase {
  Compiler compiler = new Compiler();
  
  CompiledScript runTest(String code) throws ParserError, CompilerError {
    return compiler.compile(new DVMCompilationUnit(), code).buildScript();
  }
  
  void runCodeComparisonTest(String code, byte[] expected) throws ParserError, CompilerError {
    CompiledScript script = runTest(code);
    byte[] bcode = script.getCode();
    
    try {
      assertThat("Incorrect code length", bcode.length, is(expected.length));
      assertEquals("Code doesn't match", Arrays.toString(bcode), Arrays.toString(expected));
    } catch (AssertionError e) {
      System.err.println(ScriptDumper.dumpScript(script));
      throw(e);
    }      
  }
  
  void runCodeAndPoolComparisonTest(String code, 
                                    byte[] expectedCode, 
                                    CompiledScript.ConstPoolEntry[] expectedPool)
      throws ParserError, CompilerError {
    CompiledScript script = runTest(code);

    try {
      assertThat("Incorrect code length", script.getCode().length, is(expectedCode.length));
      assertThat("Incorrect constpool length", script.getConstPool().length, is(expectedPool.length));
      
      assertEquals("Code doesn't match", Arrays.toString(expectedCode), Arrays.toString(script.getCode()));
      assertEquals("Pool doesn't match", Arrays.toString(expectedPool), Arrays.toString(script.getConstPool()));
    } catch (AssertionError e) {
      System.err.println(ScriptDumper.dumpScript(script));
      throw(e);
    }      
  }

  void runCodeLocalsAndPoolComparisonTest(String code, 
                                          byte[] expectedCode,
                                          String[] expectedLocals,
                                          CompiledScript.ConstPoolEntry[] expectedPool)
          throws ParserError, CompilerError {
    CompiledScript script = runTest(code);
    
    try {
      assertThat("Incorrect code length", script.getCode().length, is(expectedCode.length));
      assertThat("Incorrect locals length", script.getLocalsTable().length, is(expectedLocals.length));
      assertThat("Incorrect constpool length", script.getConstPool().length, is(expectedPool.length));
      
      assertEquals("Code doesn't match", Arrays.toString(expectedCode), Arrays.toString(script.getCode()));
      assertEquals("LocalsTable doesn't match", Arrays.toString(expectedLocals), Arrays.toString(script.getLocalsTable()));
      assertEquals("Pool doesn't match", Arrays.toString(expectedPool), Arrays.toString(script.getConstPool()));
    } catch (AssertionError e) {
      System.err.println(ScriptDumper.dumpScript(script));
      throw(e);
    }
  }
}
