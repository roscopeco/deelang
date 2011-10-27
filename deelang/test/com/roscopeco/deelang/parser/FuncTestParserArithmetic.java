package com.roscopeco.deelang.parser;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.junit.Test;

import com.roscopeco.deelang.parser.DeeLangParser;

public class FuncTestParserArithmetic extends ParserFuncTestBase {
  /* ********** BASIC - ARITHMETIC ETC ************* */
  @Test
  public void testBasicAddExpr() throws RecognitionException {
    CommonTree tree = runTest("1+2");

    assertThat(tree.getText(), is("+"));
    assertThat(tree.getType(), is(DeeLangParser.ADD));
    assertThat(tree.getChildCount(), is(2));
    
    assertThat(tree.getChild(0).getText(), is("1"));
    assertThat(tree.getChild(0).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(1).getText(), is("2"));
    assertThat(tree.getChild(1).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(1).getChildCount(), is(0));
  }

  @Test
  public void testBasicSubExpr() throws RecognitionException {
    CommonTree tree = runTest("1-2");

    assertThat(tree.getText(), is("-"));
    assertThat(tree.getType(), is(DeeLangParser.SUB));
    assertThat(tree.getChildCount(), is(2));
    
    assertThat(tree.getChild(0).getText(), is("1"));
    assertThat(tree.getChild(0).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(1).getText(), is("2"));
    assertThat(tree.getChild(1).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(1).getChildCount(), is(0));
  }
  
  @Test
  public void testBasicMulExpr() throws RecognitionException {
    CommonTree tree = runTest("1*2");

    assertThat(tree.getText(), is("*"));
    assertThat(tree.getType(), is(DeeLangParser.MUL));
    assertThat(tree.getChildCount(), is(2));
    
    assertThat(tree.getChild(0).getText(), is("1"));
    assertThat(tree.getChild(0).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(1).getText(), is("2"));
    assertThat(tree.getChild(1).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(1).getChildCount(), is(0));
  }
  
  @Test
  public void testBasicDivExpr() throws RecognitionException {
    CommonTree tree = runTest("1/2");

    assertThat(tree.getText(), is("/"));
    assertThat(tree.getType(), is(DeeLangParser.DIV));
    assertThat(tree.getChildCount(), is(2));
    
    assertThat(tree.getChild(0).getText(), is("1"));
    assertThat(tree.getChild(0).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(1).getText(), is("2"));
    assertThat(tree.getChild(1).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(1).getChildCount(), is(0));
  }
  
  @Test
  public void testBasicPowExpr() throws RecognitionException {
    CommonTree tree = runTest("1^2");

    assertThat(tree.getText(), is("^"));
    assertThat(tree.getType(), is(DeeLangParser.POW));
    assertThat(tree.getChildCount(), is(2));
    
    assertThat(tree.getChild(0).getText(), is("1"));
    assertThat(tree.getChild(0).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(1).getText(), is("2"));
    assertThat(tree.getChild(1).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(1).getChildCount(), is(0));
  }

  @Test
  public void testBasicModExpr() throws RecognitionException {
    CommonTree tree = runTest("1%2");

    assertThat(tree.getText(), is("%"));
    assertThat(tree.getType(), is(DeeLangParser.MOD));
    assertThat(tree.getChildCount(), is(2));
    
    assertThat(tree.getChild(0).getText(), is("1"));
    assertThat(tree.getChild(0).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(1).getText(), is("2"));
    assertThat(tree.getChild(1).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(1).getChildCount(), is(0));
  }

  
  /* ********** BASIC - ARITHMETIC OP ASSOC ETC ************* */
  public void genericBinOpLeftAssocTest(String expr, String op, int tokenType) 
      throws RecognitionException {
    CommonTree tree = runTest(expr);  // should be equiv to ((1 op 2) op 3)

    assertThat(tree.getText(), is(op));
    assertThat(tree.getType(), is(tokenType));
    assertThat(tree.getChildCount(), is(2));
    
    assertThat(tree.getChild(0).getText(), is(op));
    assertThat(tree.getChild(0).getType(), is(tokenType));
    assertThat(tree.getChild(0).getChildCount(), is(2));

    assertThat(tree.getChild(0).getChild(0).getText(), is("1"));
    assertThat(tree.getChild(0).getChild(0).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(0).getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(0).getChild(1).getText(), is("2"));
    assertThat(tree.getChild(0).getChild(1).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(0).getChild(1).getChildCount(), is(0));

    assertThat(tree.getChild(1).getText(), is("3"));
    assertThat(tree.getChild(1).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(1).getChildCount(), is(0));
  }

  @Test
  public void testBasicAddLeftAssocExpr() throws RecognitionException {
    genericBinOpLeftAssocTest("1+2+3", "+", DeeLangParser.ADD);
  }

  @Test
  public void testBasicSubLeftAssocExpr() throws RecognitionException {
    genericBinOpLeftAssocTest("1-2-3", "-", DeeLangParser.SUB);
  }

  @Test
  public void testBasicDivLeftAssocExpr() throws RecognitionException {
    genericBinOpLeftAssocTest("1/2/3", "/", DeeLangParser.DIV);
  }

  @Test
  public void testBasicMulLeftAssocExpr() throws RecognitionException {
    genericBinOpLeftAssocTest("1*2*3", "*", DeeLangParser.MUL);
  }

  @Test
  public void testBasicPowLeftAssocExpr() throws RecognitionException {
    genericBinOpLeftAssocTest("1^2^3", "^", DeeLangParser.POW);
  }

  @Test
  public void testBasicModLeftAssocExpr() throws RecognitionException {
    genericBinOpLeftAssocTest("1%2%3", "%", DeeLangParser.MOD);
  }

  /* ********** BASIC - ARITHMETIC OP PRECEDENCE ETC ************* */
  @Test
  public void testBasicMulAddPrecedenceExpr() throws RecognitionException {
    CommonTree tree = runTest("1*2+3");  // should be equiv to ((1*2) + 3)

    assertThat(tree.getText(), is("+"));
    assertThat(tree.getType(), is(DeeLangParser.ADD));
    assertThat(tree.getChildCount(), is(2));
    
    assertThat(tree.getChild(0).getText(), is("*"));
    assertThat(tree.getChild(0).getType(), is(DeeLangParser.MUL));
    assertThat(tree.getChild(0).getChildCount(), is(2));

    assertThat(tree.getChild(0).getChild(0).getText(), is("1"));
    assertThat(tree.getChild(0).getChild(0).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(0).getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(0).getChild(1).getText(), is("2"));
    assertThat(tree.getChild(0).getChild(1).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(0).getChild(1).getChildCount(), is(0));

    assertThat(tree.getChild(1).getText(), is("3"));
    assertThat(tree.getChild(1).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(1).getChildCount(), is(0));
  }
  
  @Test
  public void testBasicMulAddReversedPrecedenceExpr() throws RecognitionException {
    CommonTree tree = runTest("1+2*3");  // should be equiv to (1 + (2 * 3))

    assertThat(tree.getText(), is("+"));
    assertThat(tree.getType(), is(DeeLangParser.ADD));
    assertThat(tree.getChildCount(), is(2));

    assertThat(tree.getChild(0).getText(), is("1"));
    assertThat(tree.getChild(0).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(1).getText(), is("*"));
    assertThat(tree.getChild(1).getType(), is(DeeLangParser.MUL));
    assertThat(tree.getChild(1).getChildCount(), is(2));

    assertThat(tree.getChild(1).getChild(0).getText(), is("2"));
    assertThat(tree.getChild(1).getChild(0).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(1).getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(1).getChild(1).getText(), is("3"));
    assertThat(tree.getChild(1).getChild(1).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(1).getChild(1).getChildCount(), is(0));
  }
  
  @Test
  public void testBasicDivSubPrecedenceExpr() throws RecognitionException {
    CommonTree tree = runTest("1/2-3");  // should be equiv to ((1/2) - 3)

    assertThat(tree.getText(), is("-"));
    assertThat(tree.getType(), is(DeeLangParser.SUB));
    assertThat(tree.getChildCount(), is(2));
    
    assertThat(tree.getChild(0).getText(), is("/"));
    assertThat(tree.getChild(0).getType(), is(DeeLangParser.DIV));
    assertThat(tree.getChild(0).getChildCount(), is(2));

    assertThat(tree.getChild(0).getChild(0).getText(), is("1"));
    assertThat(tree.getChild(0).getChild(0).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(0).getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(0).getChild(1).getText(), is("2"));
    assertThat(tree.getChild(0).getChild(1).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(0).getChild(1).getChildCount(), is(0));

    assertThat(tree.getChild(1).getText(), is("3"));
    assertThat(tree.getChild(1).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(1).getChildCount(), is(0));
  }

  @Test
  public void testBasicDivSubReversedPrecedenceExpr() throws RecognitionException {
    CommonTree tree = runTest("1-2/3");  // should be equiv to (1 - (2 / 3))

    assertThat(tree.getText(), is("-"));
    assertThat(tree.getType(), is(DeeLangParser.SUB));
    assertThat(tree.getChildCount(), is(2));
    
    assertThat(tree.getChild(0).getText(), is("1"));
    assertThat(tree.getChild(0).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(1).getText(), is("/"));
    assertThat(tree.getChild(1).getType(), is(DeeLangParser.DIV));
    assertThat(tree.getChild(1).getChildCount(), is(2));

    assertThat(tree.getChild(1).getChild(0).getText(), is("2"));
    assertThat(tree.getChild(1).getChild(0).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(1).getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(1).getChild(1).getText(), is("3"));
    assertThat(tree.getChild(1).getChild(1).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(1).getChild(1).getChildCount(), is(0));
  }

  @Test
  public void testBasicPowModAddPrecedenceExpr() throws RecognitionException {
    CommonTree tree = runTest("1^2%3+4");  // should be equiv to (((1^2) % 3) + 4)

    assertThat(tree.getText(), is("+"));
    assertThat(tree.getType(), is(DeeLangParser.ADD));
    assertThat(tree.getChildCount(), is(2));
    
    assertThat(tree.getChild(0).getText(), is("%"));
    assertThat(tree.getChild(0).getType(), is(DeeLangParser.MOD));
    assertThat(tree.getChild(0).getChildCount(), is(2));

    assertThat(tree.getChild(0).getChild(0).getText(), is("^"));
    assertThat(tree.getChild(0).getChild(0).getType(), is(DeeLangParser.POW));
    assertThat(tree.getChild(0).getChild(0).getChildCount(), is(2));

    assertThat(tree.getChild(0).getChild(0).getChild(0).getText(), is("1"));
    assertThat(tree.getChild(0).getChild(0).getChild(0).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(0).getChild(0).getChild(0).getChildCount(), is(0));
    
    assertThat(tree.getChild(0).getChild(0).getChild(1).getText(), is("2"));
    assertThat(tree.getChild(0).getChild(0).getChild(1).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(0).getChild(0).getChild(1).getChildCount(), is(0));

    assertThat(tree.getChild(0).getChild(1).getText(), is("3"));
    assertThat(tree.getChild(0).getChild(1).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(0).getChild(1).getChildCount(), is(0));

    assertThat(tree.getChild(1).getText(), is("4"));
    assertThat(tree.getChild(1).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(1).getChildCount(), is(0));
  }
  
  @Test
  public void testBasicMulAddExplicitPrecedenceExpr() throws RecognitionException {
    CommonTree tree = runTest("1*(2+3)");  // should be equiv to (1 * (2 + 3))

    assertThat(tree.getText(), is("*"));
    assertThat(tree.getType(), is(DeeLangParser.MUL));
    assertThat(tree.getChildCount(), is(2));

    assertThat(tree.getChild(0).getText(), is("1"));
    assertThat(tree.getChild(0).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(1).getText(), is("+"));
    assertThat(tree.getChild(1).getType(), is(DeeLangParser.ADD));
    assertThat(tree.getChild(1).getChildCount(), is(2));

    assertThat(tree.getChild(1).getChild(0).getText(), is("2"));
    assertThat(tree.getChild(1).getChild(0).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(1).getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(1).getChild(1).getText(), is("3"));
    assertThat(tree.getChild(1).getChild(1).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(1).getChild(1).getChildCount(), is(0));
  }
}
