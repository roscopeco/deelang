package com.roscopeco.deelang.parser;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import org.antlr.runtime.tree.CommonTree;
import org.junit.Test;

public class RegressionTests extends ParserFuncTestBase {
  @Test
  public void BUG0002_testContinueParsingAfterBlankLine() throws Throwable {
    CommonTree tree = runTest("1\n2\n\n3");

    assertThat(tree.getText(), is(nullValue()));
    assertThat(tree.getType(), is(0));
    assertThat(tree.getChildCount(), is(3));
    
    assertThat(tree.getChild(0).getText(), is("1"));
    assertThat(tree.getChild(0).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(0).getChildCount(), is(0));
    
    assertThat(tree.getChild(1).getText(), is("2"));
    assertThat(tree.getChild(1).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(1).getChildCount(), is(0));
    
    assertThat(tree.getChild(2).getText(), is("3"));
    assertThat(tree.getChild(2).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(2).getChildCount(), is(0));    
  }
}
