package com.roscopeco.deelang.parser;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.junit.Test;

import com.roscopeco.deelang.parser.DeeLangParser;

/* ********** FUNCTION CALLS ************* 
 *
 * It should be noted that function calls are actually just method calls,
 * with the implicit SELF receiver. They parse out as a METHOD_CALL with
 * a the receiver (first child token) as a SELF token.
 */
public class FuncTestParserFunctionCalls extends ParserFuncTestBase {
  @Test
  public void testBasicFuncCallNoArgs() throws RecognitionException {
    CommonTree tree = runTest("foo()");

    assertThat(tree.getText(), is("METHOD_CALL"));
    assertThat(tree.getType(), is(DeeLangParser.METHOD_CALL));
    assertThat(tree.getChildCount(), is(2));

    assertThat(tree.getChild(0).getText(), is("SELF"));
    assertThat(tree.getChild(0).getType(), is(DeeLangParser.SELF));
    assertThat(tree.getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(1).getText(), is("foo"));
    assertThat(tree.getChild(1).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(1).getChildCount(), is(0));
  }

  @Test
  public void testBasicFuncCallOneArgWithParens() throws RecognitionException {
    CommonTree tree = runTest("foo(1)");

    assertThat(tree.getText(), is("METHOD_CALL"));
    assertThat(tree.getType(), is(DeeLangParser.METHOD_CALL));
    assertThat(tree.getChildCount(), is(2));

    assertThat(tree.getChild(0).getText(), is("SELF"));
    assertThat(tree.getChild(0).getType(), is(DeeLangParser.SELF));
    assertThat(tree.getChild(0).getChildCount(), is(0));
    
    assertThat(tree.getChild(1).getText(), is("foo"));
    assertThat(tree.getChild(1).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(1).getChildCount(), is(1));
    
    assertThat(tree.getChild(1).getChild(0).getText(), is("ARGS"));
    assertThat(tree.getChild(1).getChild(0).getType(), is(DeeLangParser.ARGS));
    assertThat(tree.getChild(1).getChild(0).getChildCount(), is(1));

    assertThat(tree.getChild(1).getChild(0).getChild(0).getText(), is("1"));
    assertThat(tree.getChild(1).getChild(0).getChild(0).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(1).getChild(0).getChild(0).getChildCount(), is(0));
  }
/*
  @Test
  public void testBasicFuncCallOneArgWithoutParens() throws RecognitionException {
    CommonTree tree = runTest("foo 1");

    assertThat(tree.getText(), is("METHOD_CALL"));
    assertThat(tree.getType(), is(DeeLangParser.METHOD_CALL));
    assertThat(tree.getChildCount(), is(1));

    assertThat(tree.getChild(0).getText(), is("foo"));
    assertThat(tree.getChild(0).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(0).getChildCount(), is(1));
    
    assertThat(tree.getChild(0).getChild(0).getText(), is("1"));
    assertThat(tree.getChild(0).getChild(0).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(0).getChild(0).getChildCount(), is(0));
  }
*/
  @Test
  public void testBasicFuncCallTwoArgsWithParens() throws RecognitionException {
    CommonTree tree = runTest("foo(1, 2)");

    assertThat(tree.getText(), is("METHOD_CALL"));
    assertThat(tree.getType(), is(DeeLangParser.METHOD_CALL));
    assertThat(tree.getChildCount(), is(2));
    
    assertThat(tree.getChild(0).getText(), is("SELF"));
    assertThat(tree.getChild(0).getType(), is(DeeLangParser.SELF));
    assertThat(tree.getChild(0).getChildCount(), is(0));
    
    assertThat(tree.getChild(1).getText(), is("foo"));
    assertThat(tree.getChild(1).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(1).getChildCount(), is(1));
    
    assertThat(tree.getChild(1).getChild(0).getText(), is("ARGS"));
    assertThat(tree.getChild(1).getChild(0).getType(), is(DeeLangParser.ARGS));
    assertThat(tree.getChild(1).getChild(0).getChildCount(), is(2));

    assertThat(tree.getChild(1).getChild(0).getChild(0).getText(), is("1"));
    assertThat(tree.getChild(1).getChild(0).getChild(0).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(1).getChild(0).getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(1).getChild(0).getChild(1).getText(), is("2"));
    assertThat(tree.getChild(1).getChild(0).getChild(1).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(1).getChild(0).getChild(1).getChildCount(), is(0));
  }
/*  
  @Test
  public void testBasicFuncCallTwoArgsWithoutParens() throws RecognitionException {
    CommonTree tree = runTest("foo 1, 2");

    assertThat(tree.getText(), is("METHOD_CALL"));
    assertThat(tree.getType(), is(DeeLangParser.METHOD_CALL));
    assertThat(tree.getChildCount(), is(1));
    
    assertThat(tree.getChild(0).getText(), is("foo"));
    assertThat(tree.getChild(0).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(0).getChildCount(), is(2));
    
    assertThat(tree.getChild(0).getChild(0).getText(), is("1"));
    assertThat(tree.getChild(0).getChild(0).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(0).getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(0).getChild(1).getText(), is("2"));
    assertThat(tree.getChild(0).getChild(1).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(0).getChild(1).getChildCount(), is(0));
  }
*/
  @Test(expected = RecognitionException.class)
  public void testBasicFuncCallTwoArgsNoCommaWithParensChokes() throws RecognitionException {
    runTest("foo(1 2)");
  }
/*
  @Test(expected = RecognitionException.class)
  public void testBasicFuncCallTwoArgsNoCommaWithoutParensChokes() throws RecognitionException {
    runTest("foo 1 2");
  }
*/
/*
  @Test
  public void testBasicFuncCallTwoArgsNoCommaWithoutParensExplicitSeparatorDoesntChoke() throws RecognitionException {
    CommonTree tree = runTest("foo 1; 2");

    assertNull(tree.getText());
    assertThat(tree.getType(), is(0));
    assertThat(tree.getChildCount(), is(2));

    assertThat(tree.getChild(0).getText(), is("METHOD_CALL"));
    assertThat(tree.getChild(0).getType(), is(DeeLangParser.METHOD_CALL));
    assertThat(tree.getChild(0).getChildCount(), is(1));
    
    assertThat(tree.getChild(0).getChild(0).getText(), is("foo"));
    assertThat(tree.getChild(0).getChild(0).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(0).getChild(0).getChildCount(), is(1));

    assertThat(tree.getChild(0).getChild(0).getChild(0).getText(), is("1"));
    assertThat(tree.getChild(0).getChild(0).getChild(0).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(0).getChild(0).getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(1).getText(), is("2"));
    assertThat(tree.getChild(1).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(1).getChildCount(), is(0));
  }
*/
  @Test
  public void testNestedFuncCallOneArgWithAllParens() throws RecognitionException {
    CommonTree tree = runTest("foo(bar(1))");

    assertThat(tree.getText(), is("METHOD_CALL"));
    assertThat(tree.getType(), is(DeeLangParser.METHOD_CALL));
    assertThat(tree.getChildCount(), is(2));
        
    assertThat(tree.getChild(0).getText(), is("SELF"));
    assertThat(tree.getChild(0).getType(), is(DeeLangParser.SELF));
    assertThat(tree.getChild(0).getChildCount(), is(0));
    
    assertThat(tree.getChild(1).getText(), is("foo"));
    assertThat(tree.getChild(1).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(1).getChildCount(), is(1));
    
    assertThat(tree.getChild(1).getChild(0).getText(), is("ARGS"));
    assertThat(tree.getChild(1).getChild(0).getType(), is(DeeLangParser.ARGS));
    assertThat(tree.getChild(1).getChild(0).getChildCount(), is(1));

    assertThat(tree.getChild(1).getChild(0).getChild(0).getText(), is("METHOD_CALL"));
    assertThat(tree.getChild(1).getChild(0).getChild(0).getType(), is(DeeLangParser.METHOD_CALL));
    assertThat(tree.getChild(1).getChild(0).getChild(0).getChildCount(), is(2));
        
    assertThat(tree.getChild(1).getChild(0).getChild(0).getChild(0).getText(), is("SELF"));
    assertThat(tree.getChild(1).getChild(0).getChild(0).getChild(0).getType(), is(DeeLangParser.SELF));
    assertThat(tree.getChild(1).getChild(0).getChild(0).getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(1).getChild(0).getChild(0).getChild(1).getText(), is("bar"));
    assertThat(tree.getChild(1).getChild(0).getChild(0).getChild(1).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(1).getChild(0).getChild(0).getChild(1).getChildCount(), is(1));

    assertThat(tree.getChild(1).getChild(0).getChild(0).getChild(1).getChild(0).getText(), is("ARGS"));
    assertThat(tree.getChild(1).getChild(0).getChild(0).getChild(1).getChild(0).getType(), is(DeeLangParser.ARGS));
    assertThat(tree.getChild(1).getChild(0).getChild(0).getChild(1).getChild(0).getChildCount(), is(1));

    assertThat(tree.getChild(1).getChild(0).getChild(0).getChild(1).getChild(0).getChild(0).getText(), is("1"));
    assertThat(tree.getChild(1).getChild(0).getChild(0).getChild(1).getChild(0).getChild(0).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(1).getChild(0).getChild(0).getChild(1).getChild(0).getChild(0).getChildCount(), is(0));
  }
/*
  @Test
  public void testNestedFuncCallOneArgWithoutOuterParens() throws RecognitionException {
    CommonTree tree = runTest("foo bar(1)");

    assertThat(tree.getText(), is("METHOD_CALL"));
    assertThat(tree.getType(), is(DeeLangParser.METHOD_CALL));
    assertThat(tree.getChildCount(), is(1));
        
    assertThat(tree.getChild(0).getText(), is("foo"));
    assertThat(tree.getChild(0).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(0).getChildCount(), is(1));
    
    assertThat(tree.getChild(0).getChild(0).getText(), is("METHOD_CALL"));
    assertThat(tree.getChild(0).getChild(0).getType(), is(DeeLangParser.METHOD_CALL));
    assertThat(tree.getChild(0).getChild(0).getChildCount(), is(1));
        
    assertThat(tree.getChild(0).getChild(0).getChild(0).getText(), is("bar"));
    assertThat(tree.getChild(0).getChild(0).getChild(0).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(0).getChild(0).getChild(0).getChildCount(), is(1));

    assertThat(tree.getChild(0).getChild(0).getChild(0).getChild(0).getText(), is("1"));
    assertThat(tree.getChild(0).getChild(0).getChild(0).getChild(0).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(0).getChild(0).getChild(0).getChild(0).getChildCount(), is(0));
  }

  @Test
  public void testNestedFuncCallOneArgWithoutInnerParens() throws RecognitionException {
    CommonTree tree = runTest("foo(bar 1)");

    assertThat(tree.getText(), is("METHOD_CALL"));
    assertThat(tree.getType(), is(DeeLangParser.METHOD_CALL));
    assertThat(tree.getChildCount(), is(1));
        
    assertThat(tree.getChild(0).getText(), is("foo"));
    assertThat(tree.getChild(0).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(0).getChildCount(), is(1));
    
    assertThat(tree.getChild(0).getChild(0).getText(), is("METHOD_CALL"));
    assertThat(tree.getChild(0).getChild(0).getType(), is(DeeLangParser.METHOD_CALL));
    assertThat(tree.getChild(0).getChild(0).getChildCount(), is(1));
        
    assertThat(tree.getChild(0).getChild(0).getChild(0).getText(), is("bar"));
    assertThat(tree.getChild(0).getChild(0).getChild(0).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(0).getChild(0).getChild(0).getChildCount(), is(1));

    assertThat(tree.getChild(0).getChild(0).getChild(0).getChild(0).getText(), is("1"));
    assertThat(tree.getChild(0).getChild(0).getChild(0).getChild(0).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(0).getChild(0).getChild(0).getChild(0).getChildCount(), is(0));
  }
  
  @Test
  public void testNestedFuncCallOneArgWithoutAnyParens() throws RecognitionException {
    CommonTree tree = runTest("foo bar 1");

    assertThat(tree.getText(), is("METHOD_CALL"));
    assertThat(tree.getType(), is(DeeLangParser.METHOD_CALL));
    assertThat(tree.getChildCount(), is(1));
        
    assertThat(tree.getChild(0).getText(), is("foo"));
    assertThat(tree.getChild(0).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(0).getChildCount(), is(1));
    
    assertThat(tree.getChild(0).getChild(0).getText(), is("METHOD_CALL"));
    assertThat(tree.getChild(0).getChild(0).getType(), is(DeeLangParser.METHOD_CALL));
    assertThat(tree.getChild(0).getChild(0).getChildCount(), is(1));
        
    assertThat(tree.getChild(0).getChild(0).getChild(0).getText(), is("bar"));
    assertThat(tree.getChild(0).getChild(0).getChild(0).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(0).getChild(0).getChild(0).getChildCount(), is(1));

    assertThat(tree.getChild(0).getChild(0).getChild(0).getChild(0).getText(), is("1"));
    assertThat(tree.getChild(0).getChild(0).getChild(0).getChild(0).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(0).getChild(0).getChild(0).getChild(0).getChildCount(), is(0));
  }
  
  @Test
  public void testNestedFuncCallInnerTwoArgsWithoutOuterParens() throws RecognitionException {
    CommonTree tree = runTest("foo bar(1, 2)");

    assertThat(tree.getText(), is("METHOD_CALL"));
    assertThat(tree.getType(), is(DeeLangParser.METHOD_CALL));
    assertThat(tree.getChildCount(), is(1));
        
    assertThat(tree.getChild(0).getText(), is("foo"));
    assertThat(tree.getChild(0).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(0).getChildCount(), is(1));
    
    assertThat(tree.getChild(0).getChild(0).getText(), is("METHOD_CALL"));
    assertThat(tree.getChild(0).getChild(0).getType(), is(DeeLangParser.METHOD_CALL));
    assertThat(tree.getChild(0).getChild(0).getChildCount(), is(1));
        
    assertThat(tree.getChild(0).getChild(0).getChild(0).getText(), is("bar"));
    assertThat(tree.getChild(0).getChild(0).getChild(0).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(0).getChild(0).getChild(0).getChildCount(), is(2));

    assertThat(tree.getChild(0).getChild(0).getChild(0).getChild(0).getText(), is("1"));
    assertThat(tree.getChild(0).getChild(0).getChild(0).getChild(0).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(0).getChild(0).getChild(0).getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(0).getChild(0).getChild(0).getChild(1).getText(), is("2"));
    assertThat(tree.getChild(0).getChild(0).getChild(0).getChild(1).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(0).getChild(0).getChild(0).getChild(1).getChildCount(), is(0));
  }

  @Test
  public void testNestedFuncCallInnerTwoArgsWithoutInnerParens() throws RecognitionException {
    CommonTree tree = runTest("foo(bar 1, 2)");

    assertThat(tree.getText(), is("METHOD_CALL"));
    assertThat(tree.getType(), is(DeeLangParser.METHOD_CALL));
    assertThat(tree.getChildCount(), is(1));
        
    assertThat(tree.getChild(0).getText(), is("foo"));
    assertThat(tree.getChild(0).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(0).getChildCount(), is(1));
    
    assertThat(tree.getChild(0).getChild(0).getText(), is("METHOD_CALL"));
    assertThat(tree.getChild(0).getChild(0).getType(), is(DeeLangParser.METHOD_CALL));
    assertThat(tree.getChild(0).getChild(0).getChildCount(), is(1));
        
    assertThat(tree.getChild(0).getChild(0).getChild(0).getText(), is("bar"));
    assertThat(tree.getChild(0).getChild(0).getChild(0).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(0).getChild(0).getChild(0).getChildCount(), is(2));

    assertThat(tree.getChild(0).getChild(0).getChild(0).getChild(0).getText(), is("1"));
    assertThat(tree.getChild(0).getChild(0).getChild(0).getChild(0).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(0).getChild(0).getChild(0).getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(0).getChild(0).getChild(0).getChild(1).getText(), is("2"));
    assertThat(tree.getChild(0).getChild(0).getChild(0).getChild(1).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(0).getChild(0).getChild(0).getChild(1).getChildCount(), is(0));
  }

  @Test
  public void testNestedFuncCallInnerTwoArgsWithoutAnyParens() throws RecognitionException {
    CommonTree tree = runTest("foo bar 1, 2");

    assertThat(tree.getText(), is("METHOD_CALL"));
    assertThat(tree.getType(), is(DeeLangParser.METHOD_CALL));
    assertThat(tree.getChildCount(), is(1));
        
    assertThat(tree.getChild(0).getText(), is("foo"));
    assertThat(tree.getChild(0).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(0).getChildCount(), is(1));
    
    assertThat(tree.getChild(0).getChild(0).getText(), is("METHOD_CALL"));
    assertThat(tree.getChild(0).getChild(0).getType(), is(DeeLangParser.METHOD_CALL));
    assertThat(tree.getChild(0).getChild(0).getChildCount(), is(1));
        
    assertThat(tree.getChild(0).getChild(0).getChild(0).getText(), is("bar"));
    assertThat(tree.getChild(0).getChild(0).getChild(0).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(0).getChild(0).getChild(0).getChildCount(), is(2));

    assertThat(tree.getChild(0).getChild(0).getChild(0).getChild(0).getText(), is("1"));
    assertThat(tree.getChild(0).getChild(0).getChild(0).getChild(0).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(0).getChild(0).getChild(0).getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(0).getChild(0).getChild(0).getChild(1).getText(), is("2"));
    assertThat(tree.getChild(0).getChild(0).getChild(0).getChild(1).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(0).getChild(0).getChild(0).getChild(1).getChildCount(), is(0));
  }

  @Test
  public void testDoubleNestedFuncCallInnerTwoArgsWithoutAnyParens() throws RecognitionException {
    CommonTree tree = runTest("foo bar 1, baz");

    assertThat(tree.getText(), is("METHOD_CALL"));
    assertThat(tree.getType(), is(DeeLangParser.METHOD_CALL));
    assertThat(tree.getChildCount(), is(1));
        
    assertThat(tree.getChild(0).getText(), is("foo"));
    assertThat(tree.getChild(0).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(0).getChildCount(), is(1));
    
    assertThat(tree.getChild(0).getChild(0).getText(), is("METHOD_CALL"));
    assertThat(tree.getChild(0).getChild(0).getType(), is(DeeLangParser.METHOD_CALL));
    assertThat(tree.getChild(0).getChild(0).getChildCount(), is(1));
        
    assertThat(tree.getChild(0).getChild(0).getChild(0).getText(), is("bar"));
    assertThat(tree.getChild(0).getChild(0).getChild(0).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(0).getChild(0).getChild(0).getChildCount(), is(2));

    assertThat(tree.getChild(0).getChild(0).getChild(0).getChild(0).getText(), is("1"));
    assertThat(tree.getChild(0).getChild(0).getChild(0).getChild(0).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(0).getChild(0).getChild(0).getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(0).getChild(0).getChild(0).getChild(1).getText(), is("METHOD_CALL"));
    assertThat(tree.getChild(0).getChild(0).getChild(0).getChild(1).getType(), is(DeeLangParser.METHOD_CALL));
    assertThat(tree.getChild(0).getChild(0).getChild(0).getChild(1).getChildCount(), is(1));
        
    assertThat(tree.getChild(0).getChild(0).getChild(0).getChild(1).getChild(0).getText(), is("baz"));
    assertThat(tree.getChild(0).getChild(0).getChild(0).getChild(1).getChild(0).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(0).getChild(0).getChild(0).getChild(1).getChild(0).getChildCount(), is(0));
  }

  @Test
  public void testDoubleNestedFuncCallInnerTwoArgsInnerInnerOneArgWithoutAnyParens() throws RecognitionException {
    CommonTree tree = runTest("foo bar 1, baz 2");

    assertThat(tree.getText(), is("METHOD_CALL"));
    assertThat(tree.getType(), is(DeeLangParser.METHOD_CALL));
    assertThat(tree.getChildCount(), is(1));
        
    assertThat(tree.getChild(0).getText(), is("foo"));
    assertThat(tree.getChild(0).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(0).getChildCount(), is(1));
    
    assertThat(tree.getChild(0).getChild(0).getText(), is("METHOD_CALL"));
    assertThat(tree.getChild(0).getChild(0).getType(), is(DeeLangParser.METHOD_CALL));
    assertThat(tree.getChild(0).getChild(0).getChildCount(), is(1));
        
    assertThat(tree.getChild(0).getChild(0).getChild(0).getText(), is("bar"));
    assertThat(tree.getChild(0).getChild(0).getChild(0).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(0).getChild(0).getChild(0).getChildCount(), is(2));

    assertThat(tree.getChild(0).getChild(0).getChild(0).getChild(0).getText(), is("1"));
    assertThat(tree.getChild(0).getChild(0).getChild(0).getChild(0).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(0).getChild(0).getChild(0).getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(0).getChild(0).getChild(0).getChild(1).getText(), is("METHOD_CALL"));
    assertThat(tree.getChild(0).getChild(0).getChild(0).getChild(1).getType(), is(DeeLangParser.METHOD_CALL));
    assertThat(tree.getChild(0).getChild(0).getChild(0).getChild(1).getChildCount(), is(1));
        
    assertThat(tree.getChild(0).getChild(0).getChild(0).getChild(1).getChild(0).getText(), is("baz"));
    assertThat(tree.getChild(0).getChild(0).getChild(0).getChild(1).getChild(0).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(0).getChild(0).getChild(0).getChild(1).getChild(0).getChildCount(), is(1));

    assertThat(tree.getChild(0).getChild(0).getChild(0).getChild(1).getChild(0).getChild(0).getText(), is("2"));
    assertThat(tree.getChild(0).getChild(0).getChild(0).getChild(1).getChild(0).getChild(0).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(0).getChild(0).getChild(0).getChild(1).getChild(0).getChild(0).getChildCount(), is(0));
  }
*/
  @Test
  public void testDoubleNestedFuncCallInnerTwoArgsInnerInnerOneArg() throws RecognitionException {
    CommonTree tree = runTest("foo(bar(1, baz(2)))");

    assertThat(tree.getText(), is("METHOD_CALL"));
    assertThat(tree.getType(), is(DeeLangParser.METHOD_CALL));
    assertThat(tree.getChildCount(), is(2));
        
    assertThat(tree.getChild(0).getText(), is("SELF"));
    assertThat(tree.getChild(0).getType(), is(DeeLangParser.SELF));
    assertThat(tree.getChild(0).getChildCount(), is(0));
    
    assertThat(tree.getChild(1).getText(), is("foo"));
    assertThat(tree.getChild(1).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(1).getChildCount(), is(1));
    
    assertThat(tree.getChild(1).getChild(0).getText(), is("ARGS"));
    assertThat(tree.getChild(1).getChild(0).getType(), is(DeeLangParser.ARGS));
    assertThat(tree.getChild(1).getChild(0).getChildCount(), is(1));

    assertThat(tree.getChild(1).getChild(0).getChild(0).getText(), is("METHOD_CALL"));
    assertThat(tree.getChild(1).getChild(0).getChild(0).getType(), is(DeeLangParser.METHOD_CALL));
    assertThat(tree.getChild(1).getChild(0).getChild(0).getChildCount(), is(2));
        
    assertThat(tree.getChild(1).getChild(0).getChild(0).getChild(0).getText(), is("SELF"));
    assertThat(tree.getChild(1).getChild(0).getChild(0).getChild(0).getType(), is(DeeLangParser.SELF));
    assertThat(tree.getChild(1).getChild(0).getChild(0).getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(1).getChild(0).getChild(0).getChild(1).getText(), is("bar"));
    assertThat(tree.getChild(1).getChild(0).getChild(0).getChild(1).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(1).getChild(0).getChild(0).getChild(1).getChildCount(), is(1));

    assertThat(tree.getChild(1).getChild(0).getChild(0).getChild(1).getChild(0).getText(), is("ARGS"));
    assertThat(tree.getChild(1).getChild(0).getChild(0).getChild(1).getChild(0).getType(), is(DeeLangParser.ARGS));
    assertThat(tree.getChild(1).getChild(0).getChild(0).getChild(1).getChild(0).getChildCount(), is(2));

    assertThat(tree.getChild(1).getChild(0).getChild(0).getChild(1).getChild(0).getChild(0).getText(), is("1"));
    assertThat(tree.getChild(1).getChild(0).getChild(0).getChild(1).getChild(0).getChild(0).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(1).getChild(0).getChild(0).getChild(1).getChild(0).getChild(0).getChildCount(), is(0));
        
    assertThat(tree.getChild(1).getChild(0).getChild(0).getChild(1).getChild(0).getChild(1).getText(), is("METHOD_CALL"));
    assertThat(tree.getChild(1).getChild(0).getChild(0).getChild(1).getChild(0).getChild(1).getType(), is(DeeLangParser.METHOD_CALL));
    assertThat(tree.getChild(1).getChild(0).getChild(0).getChild(1).getChild(0).getChild(1).getChildCount(), is(2));
        
    assertThat(tree.getChild(1).getChild(0).getChild(0).getChild(1).getChild(0).getChild(1).getChild(0).getText(), is("SELF"));
    assertThat(tree.getChild(1).getChild(0).getChild(0).getChild(1).getChild(0).getChild(1).getChild(0).getType(), is(DeeLangParser.SELF));
    assertThat(tree.getChild(1).getChild(0).getChild(0).getChild(1).getChild(0).getChild(1).getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(1).getChild(0).getChild(0).getChild(1).getChild(0).getChild(1).getChild(1).getText(), is("baz"));
    assertThat(tree.getChild(1).getChild(0).getChild(0).getChild(1).getChild(0).getChild(1).getChild(1).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(1).getChild(0).getChild(0).getChild(1).getChild(0).getChild(1).getChild(1).getChildCount(), is(1));

    assertThat(tree.getChild(1).getChild(0).getChild(0).getChild(1).getChild(0).getChild(1).getChild(1).getChild(0).getText(), is("ARGS"));
    assertThat(tree.getChild(1).getChild(0).getChild(0).getChild(1).getChild(0).getChild(1).getChild(1).getChild(0).getType(), is(DeeLangParser.ARGS));
    assertThat(tree.getChild(1).getChild(0).getChild(0).getChild(1).getChild(0).getChild(1).getChild(1).getChild(0).getChildCount(), is(1));

    assertThat(tree.getChild(1).getChild(0).getChild(0).getChild(1).getChild(0).getChild(1).getChild(1).getChild(0).getChild(0).getText(), is("2"));
    assertThat(tree.getChild(1).getChild(0).getChild(0).getChild(1).getChild(0).getChild(1).getChild(1).getChild(0).getChild(0).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(1).getChild(0).getChild(0).getChild(1).getChild(0).getChild(1).getChild(1).getChild(0).getChild(0).getChildCount(), is(0));
    
    // TODO test blocks
  }
}
