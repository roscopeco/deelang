package com.roscopeco.deelang.parser;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.junit.Test;

import com.roscopeco.deelang.parser.DeeLangParser;

/* ********** METHOD CALLS ************* 
 * 
 * Method calls are parsed out into a METHOD_CALL tree, which has two
 * immediate children - the first being the class IDENTIFIER and
 * the second being the method IDENTIFIER. 
 * 
 * Children of the method id are the argument parse tree.
 * 
 * Since the parser's meth_call_expr builds on the func_call_expr
 * production, we shouldn't need to repeat all the function call tests
 * here - argument handling and so on is tested in FuncTestParserFunctionCalls.
 * 
 * We'll just test the class-specific cases...
 */
public class FuncTestParserAssignment extends ParserFuncTestBase {
  @Test
  public void testBasicAssignment() throws RecognitionException {
    CommonTree tree = runTest("a=b");

    assertThat(tree.getText(), is("="));
    assertThat(tree.getType(), is(DeeLangParser.ASSIGN));
    assertThat(tree.getChildCount(), is(3));

    assertThat(tree.getChild(0).getText(), is("ASSIGN_LOCAL"));
    assertThat(tree.getChild(0).getType(), is(DeeLangParser.ASSIGN_LOCAL));
    assertThat(tree.getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(1).getText(), is("a"));
    assertThat(tree.getChild(1).getType(), is(DeeLangParser.LVALUE));
    assertThat(tree.getChild(1).getChildCount(), is(0));

    assertThat(tree.getChild(2).getText(), is("b"));
    assertThat(tree.getChild(2).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(2).getChildCount(), is(0));
  }

  @Test
  public void testAssignmentToAssign() throws RecognitionException {
    CommonTree tree = runTest("a=b=c");

    assertThat(tree.getText(), is("="));
    assertThat(tree.getType(), is(DeeLangParser.ASSIGN));
    assertThat(tree.getChildCount(), is(3));

    assertThat(tree.getChild(0).getText(), is("ASSIGN_LOCAL"));
    assertThat(tree.getChild(0).getType(), is(DeeLangParser.ASSIGN_LOCAL));
    assertThat(tree.getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(1).getText(), is("a"));
    assertThat(tree.getChild(1).getType(), is(DeeLangParser.LVALUE));
    assertThat(tree.getChild(1).getChildCount(), is(0));

    assertThat(tree.getChild(2).getText(), is("="));
    assertThat(tree.getChild(2).getType(), is(DeeLangParser.ASSIGN));
    assertThat(tree.getChild(2).getChildCount(), is(3));

    assertThat(tree.getChild(2).getChild(0).getText(), is("ASSIGN_LOCAL"));
    assertThat(tree.getChild(2).getChild(0).getType(), is(DeeLangParser.ASSIGN_LOCAL));
    assertThat(tree.getChild(2).getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(2).getChild(1).getText(), is("b"));
    assertThat(tree.getChild(2).getChild(1).getType(), is(DeeLangParser.LVALUE));
    assertThat(tree.getChild(2).getChild(1).getChildCount(), is(0));

    assertThat(tree.getChild(2).getChild(2).getText(), is("c"));
    assertThat(tree.getChild(2).getChild(2).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(2).getChild(2).getChildCount(), is(0));
  }

  @Test
  public void testAssignmentInExpressionWithLiteralFirst() throws RecognitionException {
    CommonTree tree = runTest("1+(b=2)");
    
    assertThat(tree.getText(), is("+"));
    assertThat(tree.getType(), is(DeeLangParser.ADD));
    assertThat(tree.getChildCount(), is(2));
    
    assertThat(tree.getChild(0).getText(), is("1"));
    assertThat(tree.getChild(0).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(1).getText(), is("="));
    assertThat(tree.getChild(1).getType(), is(DeeLangParser.ASSIGN));
    assertThat(tree.getChild(1).getChildCount(), is(3));

    assertThat(tree.getChild(1).getChild(0).getText(), is("ASSIGN_LOCAL"));
    assertThat(tree.getChild(1).getChild(0).getType(), is(DeeLangParser.ASSIGN_LOCAL));
    assertThat(tree.getChild(1).getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(1).getChild(1).getText(), is("b"));
    assertThat(tree.getChild(1).getChild(1).getType(), is(DeeLangParser.LVALUE));
    assertThat(tree.getChild(1).getChild(1).getChildCount(), is(0));
    
    assertThat(tree.getChild(1).getChild(2).getText(), is("2"));
    assertThat(tree.getChild(1).getChild(2).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(1).getChild(2).getChildCount(), is(0));
  }

  @Test
  public void testAssignmentInExpressionWithIdentifierFirst() throws RecognitionException {
    CommonTree tree;
    try {
      tree = runTest("a+(b=2)");
    } catch (RecognitionException t) {
      System.out.println(t);
      throw(t);
    }

    assertThat(tree.getText(), is("+"));
    assertThat(tree.getType(), is(DeeLangParser.ADD));
    assertThat(tree.getChildCount(), is(2));
    
    assertThat(tree.getChild(0).getText(), is("a"));
    assertThat(tree.getChild(0).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(1).getText(), is("="));
    assertThat(tree.getChild(1).getType(), is(DeeLangParser.ASSIGN));
    assertThat(tree.getChild(1).getChildCount(), is(3));

    assertThat(tree.getChild(1).getChild(0).getText(), is("ASSIGN_LOCAL"));
    assertThat(tree.getChild(1).getChild(0).getType(), is(DeeLangParser.ASSIGN_LOCAL));
    assertThat(tree.getChild(1).getChild(0).getChildCount(), is(0));
    
    assertThat(tree.getChild(1).getChild(1).getText(), is("b"));
    assertThat(tree.getChild(1).getChild(1).getType(), is(DeeLangParser.LVALUE));
    assertThat(tree.getChild(1).getChild(1).getChildCount(), is(0));
    
    assertThat(tree.getChild(1).getChild(2).getText(), is("2"));
    assertThat(tree.getChild(1).getChild(2).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(1).getChild(2).getChildCount(), is(0));
  }

  @Test(expected = RecognitionException.class)
  public void testAssignmentInExpressionWithAllIdentifiersNoParensChokes() throws RecognitionException {
    runTest("a+b=c");
  }
  
  @Test
  public void testAssignmentInExpressionWithAllIdentifiersAndParens() throws RecognitionException {
    CommonTree tree = runTest("1+(b=c)");
    
    assertThat(tree.getText(), is("+"));
    assertThat(tree.getType(), is(DeeLangParser.ADD));
    assertThat(tree.getChildCount(), is(2));
    
    assertThat(tree.getChild(0).getText(), is("1"));
    assertThat(tree.getChild(0).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(1).getText(), is("="));
    assertThat(tree.getChild(1).getType(), is(DeeLangParser.ASSIGN));
    assertThat(tree.getChild(1).getChildCount(), is(3));

    assertThat(tree.getChild(1).getChild(0).getText(), is("ASSIGN_LOCAL"));
    assertThat(tree.getChild(1).getChild(0).getType(), is(DeeLangParser.ASSIGN_LOCAL));
    assertThat(tree.getChild(1).getChild(0).getChildCount(), is(0));
    
    assertThat(tree.getChild(1).getChild(1).getText(), is("b"));
    assertThat(tree.getChild(1).getChild(1).getType(), is(DeeLangParser.LVALUE));
    assertThat(tree.getChild(1).getChild(1).getChildCount(), is(0));
    
    assertThat(tree.getChild(1).getChild(2).getText(), is("c"));
    assertThat(tree.getChild(1).getChild(2).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(1).getChild(2).getChildCount(), is(0));
  }
  
  @Test(expected = RecognitionException.class)
  public void testChokesWhenNotLValue() throws RecognitionException {
    runTest("(a+b)=c");
  }
  
  @Test
  public void testChainedLValueAllFieldsAssignment() throws RecognitionException {
    runTest("foo.bar.baz = 2");
  }

  @Test
  public void testChainedLValueWithMethodsAssignment() throws RecognitionException {
    runTest("foo.bar().baz = 2");
  }

  @Test(expected = RecognitionException.class)
  public void testChainedLValueWithoutFieldAtEndChokesAssignment() throws RecognitionException {
    runTest("foo.bar().baz() = 2");
  }
}
