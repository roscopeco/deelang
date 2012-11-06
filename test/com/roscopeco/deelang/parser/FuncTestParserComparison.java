package com.roscopeco.deelang.parser;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.antlr.runtime.tree.CommonTree;
import org.junit.Test;

import com.roscopeco.deelang.parser.DeeLangParser;

public class FuncTestParserComparison extends ParserFuncTestBase {
  @Test
  public void testBasicLTExpr() throws Throwable {
    CommonTree tree = runTest("1<2");

    assertThat(tree.getText(), is("<"));
    assertThat(tree.getType(), is(DeeLangParser.LT));
    assertThat(tree.getChildCount(), is(2));
    
    assertThat(tree.getChild(0).getText(), is("1"));
    assertThat(tree.getChild(0).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(1).getText(), is("2"));
    assertThat(tree.getChild(1).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(1).getChildCount(), is(0));
  }
  
  @Test
  public void testBasicGTExpr() throws Throwable {
    CommonTree tree = runTest("1>2");

    assertThat(tree.getText(), is(">"));
    assertThat(tree.getType(), is(DeeLangParser.GT));
    assertThat(tree.getChildCount(), is(2));
    
    assertThat(tree.getChild(0).getText(), is("1"));
    assertThat(tree.getChild(0).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(1).getText(), is("2"));
    assertThat(tree.getChild(1).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(1).getChildCount(), is(0));
  }
  
  @Test
  public void testBasicEQExpr() throws Throwable {
    CommonTree tree = runTest("1==2");

    assertThat(tree.getText(), is("=="));
    assertThat(tree.getType(), is(DeeLangParser.EQ));
    assertThat(tree.getChildCount(), is(2));
    
    assertThat(tree.getChild(0).getText(), is("1"));
    assertThat(tree.getChild(0).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(1).getText(), is("2"));
    assertThat(tree.getChild(1).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(1).getChildCount(), is(0));
  }
  
  @Test
  public void testBasicNEQExpr() throws Throwable {
    CommonTree tree = runTest("1!=2");

    assertThat(tree.getText(), is("!="));
    assertThat(tree.getType(), is(DeeLangParser.NEQ));
    assertThat(tree.getChildCount(), is(2));
    
    assertThat(tree.getChild(0).getText(), is("1"));
    assertThat(tree.getChild(0).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(1).getText(), is("2"));
    assertThat(tree.getChild(1).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(1).getChildCount(), is(0));
  }
  
  @Test
  public void testBasicCmpPrecedenceExpr() throws Throwable {
    CommonTree tree = runTest("a == c < 1*2+3");  // should be equiv to a == (c < ((1*2) + 3))

    assertThat(tree.getChild(0).getText(), is("a"));
    assertThat(tree.getChild(0).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(0).getChildCount(), is(0));
    
    assertThat(tree.getText(), is("=="));
    assertThat(tree.getType(), is(DeeLangParser.EQ));
    assertThat(tree.getChildCount(), is(2));
    
    assertThat(tree.getChild(1).getText(), is("<"));
    assertThat(tree.getChild(1).getType(), is(DeeLangParser.LT));
    assertThat(tree.getChild(1).getChildCount(), is(2));

    assertThat(tree.getChild(1).getChild(0).getText(), is("c"));
    assertThat(tree.getChild(1).getChild(0).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(1).getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(1).getChild(1).getText(), is("+"));
    assertThat(tree.getChild(1).getChild(1).getType(), is(DeeLangParser.ADD));
    assertThat(tree.getChild(1).getChild(1).getChildCount(), is(2));
    
    assertThat(tree.getChild(1).getChild(1).getChild(0).getText(), is("*"));
    assertThat(tree.getChild(1).getChild(1).getChild(0).getType(), is(DeeLangParser.MUL));
    assertThat(tree.getChild(1).getChild(1).getChild(0).getChildCount(), is(2));
    
    assertThat(tree.getChild(1).getChild(1).getChild(0).getChild(0).getText(), is("1"));
    assertThat(tree.getChild(1).getChild(1).getChild(0).getChild(0).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(1).getChild(1).getChild(0).getChild(0).getChildCount(), is(0));
    
    assertThat(tree.getChild(1).getChild(1).getChild(0).getChild(1).getText(), is("2"));
    assertThat(tree.getChild(1).getChild(1).getChild(0).getChild(1).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(1).getChild(1).getChild(0).getChild(1).getChildCount(), is(0));
    
    assertThat(tree.getChild(1).getChild(1).getChild(1).getText(), is("3"));
    assertThat(tree.getChild(1).getChild(1).getChild(1).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(1).getChild(1).getChild(1).getChildCount(), is(0));
  }

  @Test
  public void testBasicCmpPrecedenceExpr2() throws Throwable {
    CommonTree tree = runTest("a == c > 1*2+3");  // should be equiv to a == (c > ((1*2) + 3))

    assertThat(tree.getChild(0).getText(), is("a"));
    assertThat(tree.getChild(0).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(0).getChildCount(), is(0));
    
    assertThat(tree.getText(), is("=="));
    assertThat(tree.getType(), is(DeeLangParser.EQ));
    assertThat(tree.getChildCount(), is(2));
    
    assertThat(tree.getChild(1).getText(), is(">"));
    assertThat(tree.getChild(1).getType(), is(DeeLangParser.GT));
    assertThat(tree.getChild(1).getChildCount(), is(2));

    assertThat(tree.getChild(1).getChild(0).getText(), is("c"));
    assertThat(tree.getChild(1).getChild(0).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(1).getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(1).getChild(1).getText(), is("+"));
    assertThat(tree.getChild(1).getChild(1).getType(), is(DeeLangParser.ADD));
    assertThat(tree.getChild(1).getChild(1).getChildCount(), is(2));
    
    assertThat(tree.getChild(1).getChild(1).getChild(0).getText(), is("*"));
    assertThat(tree.getChild(1).getChild(1).getChild(0).getType(), is(DeeLangParser.MUL));
    assertThat(tree.getChild(1).getChild(1).getChild(0).getChildCount(), is(2));
    
    assertThat(tree.getChild(1).getChild(1).getChild(0).getChild(0).getText(), is("1"));
    assertThat(tree.getChild(1).getChild(1).getChild(0).getChild(0).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(1).getChild(1).getChild(0).getChild(0).getChildCount(), is(0));
    
    assertThat(tree.getChild(1).getChild(1).getChild(0).getChild(1).getText(), is("2"));
    assertThat(tree.getChild(1).getChild(1).getChild(0).getChild(1).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(1).getChild(1).getChild(0).getChild(1).getChildCount(), is(0));
    
    assertThat(tree.getChild(1).getChild(1).getChild(1).getText(), is("3"));
    assertThat(tree.getChild(1).getChild(1).getChild(1).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(1).getChild(1).getChild(1).getChildCount(), is(0));
  }
}
