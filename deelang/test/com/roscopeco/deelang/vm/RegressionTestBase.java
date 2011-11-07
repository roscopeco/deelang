package com.roscopeco.deelang.vm;

import com.roscopeco.deelang.compiler.Compiler;
import com.roscopeco.deelang.compiler.CompilerError;

public class RegressionTestBase {
  
  public RuntimeContext createContext(String code) throws CompilerError {
    VM vm = new VM();
    return vm.createContext(Compiler.staticCompile(code));
  }
  
  public RuntimeContext runTest(RuntimeContext ctx) {
    ctx.getVm().run(ctx);
    return ctx;
  }

  public RuntimeContext runTest(String code) throws CompilerError {
    return runTest(createContext(code));
  }
  
  public RuntimeContext runTestDoesntThrowException(RuntimeContext ctx) throws CompilerError {
    try {
      return runTest(ctx);
    } catch (RuntimeError e) {
      throw new AssertionError("Regression test failure - Unwanted RuntimeError");
    }
  }

  public RuntimeContext runTestDoesntThrowException(String code) throws CompilerError {
    try {
      return runTest(code);
    } catch (RuntimeError e) {
      throw new AssertionError("Regression test failure - '" + code + "' resulted in RuntimeError");
    }
  }
}
