package com.roscopeco.deelang.compiler.dex;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
  FuncTestCompilerLiterals.class,
  FuncTestCompilerVarsAndFields.class,
  FuncTestCompilerMethodCalls.class,
  FuncTestCompilerCustomSuperclass.class
})
public class FunctionalTests {}
