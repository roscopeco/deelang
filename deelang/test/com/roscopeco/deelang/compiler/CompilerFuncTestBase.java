package com.roscopeco.deelang.compiler;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import com.roscopeco.deelang.compiler.CompiledScript;
import com.roscopeco.deelang.compiler.Compiler;
import com.roscopeco.deelang.compiler.CompilerError;

public class CompilerFuncTestBase {
  CompiledScript runTest(String code) throws CompilerError {
    return Compiler.staticCompile(code);
  }
  
  void runCodeComparisonTest(String code, byte[] expected) throws CompilerError {
    byte[] bcode = runTest(code).getCode();
    
    assertThat(bcode.length, is(expected.length));
    assertEquals(Arrays.toString(bcode), Arrays.toString(expected));
  }
  
  void runCodeAndPoolComparisonTest(String code, 
                                    byte[] expectedCode, 
                                    CompiledScript.ConstPoolEntry[] expectedPool)
      throws CompilerError {
    CompiledScript script = Compiler.staticCompile(code);
    
    assertThat(script.getCode().length, is(expectedCode.length));
    assertThat(script.getConstPool().length, is(expectedPool.length));
    
    assertEquals(Arrays.toString(expectedCode), Arrays.toString(script.getCode()));
    assertEquals(Arrays.toString(expectedPool), Arrays.toString(script.getConstPool()));
  }
}
