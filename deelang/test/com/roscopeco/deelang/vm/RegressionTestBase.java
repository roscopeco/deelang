package com.roscopeco.deelang.vm;

import com.roscopeco.deelang.compiler.Compiler;
import com.roscopeco.deelang.compiler.CompilerError;

public class RegressionTestBase {
  
  public Context createContext(String code) throws CompilerError {
    VM vm = new VM();
    return vm.createContext(Compiler.staticCompile(code));
  }
  
  public Context runTest(Context ctx) {
    ctx.getVm().run(ctx);
    return ctx;
  }

  public Context runTest(String code) throws CompilerError {
    return runTest(createContext(code));
  }
  
  public Context runTestDoesntThrowException(Context ctx) throws CompilerError {
    try {
      return runTest(ctx);
    } catch (RuntimeError e) {
      throw new AssertionError("Regression test failure - Unwanted RuntimeError");
    }
  }

  public Context runTestDoesntThrowException(String code) throws CompilerError {
    try {
      return runTest(code);
    } catch (RuntimeError e) {
      throw new AssertionError("Regression test failure - '" + code + "' resulted in RuntimeError");
    }
  }
}
