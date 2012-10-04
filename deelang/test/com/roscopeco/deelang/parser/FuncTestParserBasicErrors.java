package com.roscopeco.deelang.parser;

import org.junit.Test;

public class FuncTestParserBasicErrors extends ParserFuncTestBase {
  @Test(expected = ParserError.class)
  public void testChokesOnUnfinishedAdd() throws Throwable {
    runTest("1+");
  }
  @Test(expected = ParserError.class)
  public void testChokesOnUnfinishedMul() throws Throwable {
    runTest("1*");
  }
  @Test(expected = ParserError.class)
  public void testChokesOnUnfinishedDiv() throws Throwable {
    runTest("1/");
  }
  @Test(expected = ParserError.class)
  public void testChokesOnUnfinishedSub() throws Throwable {
    runTest("1-");
  }
  @Test(expected = ParserError.class)
  public void testChokesOnUnfinishedMultiSum() throws Throwable {
    runTest("1-2/");
  }
}
