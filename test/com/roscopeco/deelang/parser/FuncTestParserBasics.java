package com.roscopeco.deelang.parser;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import org.antlr.runtime.tree.CommonTree;
import org.junit.Test;

import com.roscopeco.deelang.parser.DeeLangParser;

public class FuncTestParserBasics extends ParserFuncTestBase {
  /* ********** VERY BASIC - EMPTY STRINGS, WHITESPACE HANDLING, ETC ************* */
  @Test
  public void testWithEmptyString() throws Throwable {
    CommonTree tree = runTest("");
    assertNull(tree);
  }

  @Test
  public void testIsIgnoringWhiteSpace() throws Throwable {
    CommonTree tree = runTest("                ");
    assertNull(tree);
  }
  
  @Test
  public void testWithSingleIntegerAndNewline() throws Throwable {
    CommonTree tree = runTest("1\n");
    
    assertThat(tree.getText(), is("1"));
    assertThat(tree.getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChildCount(), is(0));
  }
  
  /* Following test makes sure we don't require newline at end of input */
  @Test
  public void testWithSingleIntegerButNoNewline() throws Throwable {
    CommonTree tree = runTest("1");
    
    assertThat(tree.getText(), is("1"));
    assertThat(tree.getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChildCount(), is(0));
  }
  
  @Test
  public void testIsStillIgnoringWhiteSpace() throws Throwable {
    CommonTree tree = runTest("      1\n");

    assertThat(tree.getText(), is("1"));
    assertThat(tree.getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChildCount(), is(0));
  }
}
