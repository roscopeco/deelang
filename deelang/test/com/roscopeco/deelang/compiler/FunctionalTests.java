package com.roscopeco.deelang.compiler;

import org.junit.runners.Suite;

import org.junit.runner.RunWith;

@RunWith(Suite.class)
@Suite.SuiteClasses({
  FuncTestCompiledScript.class,
  
  FuncTestCompilerLiterals.class,
  FuncTestCompilerArithmetic.class,
  FuncTestCompilerAssignment.class,
  FuncTestCompilerMethodCalls.class,
  FuncTestCompilerCombinedFieldMethodChaining.class,
  FuncTestCompilerSizedInstructions.class
})
public class FunctionalTests { }
