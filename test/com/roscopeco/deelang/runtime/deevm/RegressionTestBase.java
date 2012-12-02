package com.roscopeco.deelang.runtime.deevm;

import com.roscopeco.deelang.compiler.Compiler;
import com.roscopeco.deelang.compiler.CompilerError;
import com.roscopeco.deelang.compiler.deevm.DVMCompilationUnit;
import com.roscopeco.deelang.parser.ParserError;
import com.roscopeco.deelang.runtime.RuntimeError;
import com.roscopeco.deelang.runtime.deevm.RuntimeContext;
import com.roscopeco.deelang.runtime.deevm.VM;

public class RegressionTestBase {
  
  final Compiler compiler = new Compiler();
  
  public RuntimeContext createContext(String code) throws ParserError, CompilerError {
    VM vm = new VM();
    return vm.createContext(compiler.compile(new DVMCompilationUnit(), code).buildScript());
  }
  
  public RuntimeContext runTest(RuntimeContext ctx) {
    ctx.getVm().run(ctx);
    return ctx;
  }

  public RuntimeContext runTest(String code) throws ParserError, CompilerError {
    return runTest(createContext(code));
  }
  
  public RuntimeContext runTestDoesntThrowException(RuntimeContext ctx) throws CompilerError {
    try {
      return runTest(ctx);
    } catch (RuntimeError e) {
      throw new AssertionError("Regression test failure - Unwanted RuntimeError");
    }
  }

  public RuntimeContext runTestDoesntThrowException(String code) throws ParserError, CompilerError {
    try {
      return runTest(code);
    } catch (RuntimeError e) {
      throw new AssertionError("Regression test failure - '" + code + "' resulted in RuntimeError");
    }
  }
}
