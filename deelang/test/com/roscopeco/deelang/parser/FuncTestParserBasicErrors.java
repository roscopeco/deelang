package com.roscopeco.deelang.parser;

import org.antlr.runtime.RecognitionException;
import org.junit.Test;

public class FuncTestParserBasicErrors extends ParserFuncTestBase {
  @Test(expected = RecognitionException.class)
  public void testChokesOnUnfinishedAdd() throws RecognitionException {
    runTest("1+");
  }
  @Test(expected = RecognitionException.class)
  public void testChokesOnUnfinishedMul() throws RecognitionException {
    runTest("1*");
  }
  @Test(expected = RecognitionException.class)
  public void testChokesOnUnfinishedDiv() throws RecognitionException {
    runTest("1/");
  }
  @Test(expected = RecognitionException.class)
  public void testChokesOnUnfinishedSub() throws RecognitionException {
    runTest("1-");
  }
  @Test(expected = RecognitionException.class)
  public void testChokesOnUnfinishedMultiSum() throws Throwable {
    runTest("1-2/");
  }
}
