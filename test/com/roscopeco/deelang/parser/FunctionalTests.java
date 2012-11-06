package com.roscopeco.deelang.parser;

import org.junit.runners.Suite;

import org.junit.runner.RunWith;

@RunWith(Suite.class)
@Suite.SuiteClasses({
  FuncTestParserBasics.class,
  FuncTestParserBasicErrors.class,
  FuncTestParserLiterals.class,
  FuncTestParserVarAccess.class,
  FuncTestParserMemberAccess.class,
  FuncTestParserArithmetic.class,
  FuncTestParserAssignment.class,
  FuncTestParserComparison.class,
  FuncTestParserMemberAssignment.class,
  FuncTestParserFunctionCalls.class,
  FuncTestParserMethodCalls.class,
  FuncTestParserCombinedFieldMethodChaining.class
})
public class FunctionalTests { }
