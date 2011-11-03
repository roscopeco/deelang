package com.roscopeco.deelang.parser;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

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
  public void testBasicFuncCallNoArgs() throws Throwable {
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
  public void testBasicFuncCallOneArgWithParens() throws Throwable {
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
  public void testBasicFuncCallOneArgWithoutParens() throws Throwable {
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
  public void testBasicFuncCallTwoArgsWithParens() throws Throwable {
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
  public void testBasicFuncCallTwoArgsWithoutParens() throws Throwable {
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
  @Test(expected = ParserError.class)
  public void testBasicFuncCallTwoArgsNoCommaWithParensChokes() throws Throwable {
    runTest("foo(1 2)");
  }
/*
  @Test(expected = RecognitionException.class)
  public void testBasicFuncCallTwoArgsNoCommaWithoutParensChokes() throws Throwable {
    runTest("foo 1 2");
  }
*/
/*
  @Test
  public void testBasicFuncCallTwoArgsNoCommaWithoutParensExplicitSeparatorDoesntChoke() throws Throwable {
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
  public void testNestedFuncCallOneArgWithAllParens() throws Throwable {
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
  public void testNestedFuncCallOneArgWithoutOuterParens() throws Throwable {
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
  public void testNestedFuncCallOneArgWithoutInnerParens() throws Throwable {
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
  public void testNestedFuncCallOneArgWithoutAnyParens() throws Throwable {
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
  public void testNestedFuncCallInnerTwoArgsWithoutOuterParens() throws Throwable {
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
  public void testNestedFuncCallInnerTwoArgsWithoutInnerParens() throws Throwable {
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
  public void testNestedFuncCallInnerTwoArgsWithoutAnyParens() throws Throwable {
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
  public void testDoubleNestedFuncCallInnerTwoArgsWithoutAnyParens() throws Throwable {
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
  public void testDoubleNestedFuncCallInnerTwoArgsInnerInnerOneArgWithoutAnyParens() throws Throwable {
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
  public void testDoubleNestedFuncCallInnerTwoArgsInnerInnerOneArg() throws Throwable {
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
  }
  
  /* ******** BLOCKS ******* */
  @Test
  public void testBasicFuncCallNoArgsWithEmptyBlock() throws Throwable {
    CommonTree tree = runTest("foo() { }");

    assertThat(tree.getText(), is("METHOD_CALL"));
    assertThat(tree.getType(), is(DeeLangParser.METHOD_CALL));
    assertThat(tree.getChildCount(), is(2));

    assertThat(tree.getChild(0).getText(), is("SELF"));
    assertThat(tree.getChild(0).getType(), is(DeeLangParser.SELF));
    assertThat(tree.getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(1).getText(), is("foo"));
    assertThat(tree.getChild(1).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(1).getChildCount(), is(1));

    assertThat(tree.getChild(1).getChild(0).getText(), is("BLOCK"));
    assertThat(tree.getChild(1).getChild(0).getType(), is(DeeLangParser.BLOCK));
    assertThat(tree.getChild(1).getChild(0).getChildCount(), is(0));
  }

  @Test
  public void testBasicFuncCallNoArgsWithEmptyBlockNewline() throws Throwable {
    CommonTree tree = runTest("foo() {\n}");

    assertThat(tree.getText(), is("METHOD_CALL"));
    assertThat(tree.getType(), is(DeeLangParser.METHOD_CALL));
    assertThat(tree.getChildCount(), is(2));

    assertThat(tree.getChild(0).getText(), is("SELF"));
    assertThat(tree.getChild(0).getType(), is(DeeLangParser.SELF));
    assertThat(tree.getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(1).getText(), is("foo"));
    assertThat(tree.getChild(1).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(1).getChildCount(), is(1));

    assertThat(tree.getChild(1).getChild(0).getText(), is("BLOCK"));
    assertThat(tree.getChild(1).getChild(0).getType(), is(DeeLangParser.BLOCK));
    assertThat(tree.getChild(1).getChild(0).getChildCount(), is(0));
  }

  @Test
  public void testBasicFuncCallOneArgWithEmptyBlock() throws Throwable {
    CommonTree tree = runTest("foo(1) { }");

    assertThat(tree.getText(), is("METHOD_CALL"));
    assertThat(tree.getType(), is(DeeLangParser.METHOD_CALL));
    assertThat(tree.getChildCount(), is(2));

    assertThat(tree.getChild(0).getText(), is("SELF"));
    assertThat(tree.getChild(0).getType(), is(DeeLangParser.SELF));
    assertThat(tree.getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(1).getText(), is("foo"));
    assertThat(tree.getChild(1).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(1).getChildCount(), is(2));

    assertThat(tree.getChild(1).getChild(0).getText(), is("ARGS"));
    assertThat(tree.getChild(1).getChild(0).getType(), is(DeeLangParser.ARGS));
    assertThat(tree.getChild(1).getChild(0).getChildCount(), is(1));

    assertThat(tree.getChild(1).getChild(0).getChild(0).getText(), is("1"));
    assertThat(tree.getChild(1).getChild(0).getChild(0).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(1).getChild(0).getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(1).getChild(1).getText(), is("BLOCK"));
    assertThat(tree.getChild(1).getChild(1).getType(), is(DeeLangParser.BLOCK));
    assertThat(tree.getChild(1).getChild(1).getChildCount(), is(0));
  }

  @Test
  public void testBasicFuncCallOneArgWithSingleInstructionNoNewline() throws Throwable {
    CommonTree tree = runTest("foo(1) { bee }");

    assertThat(tree.getText(), is("METHOD_CALL"));
    assertThat(tree.getType(), is(DeeLangParser.METHOD_CALL));
    assertThat(tree.getChildCount(), is(2));

    assertThat(tree.getChild(0).getText(), is("SELF"));
    assertThat(tree.getChild(0).getType(), is(DeeLangParser.SELF));
    assertThat(tree.getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(1).getText(), is("foo"));
    assertThat(tree.getChild(1).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(1).getChildCount(), is(2));

    assertThat(tree.getChild(1).getChild(0).getText(), is("ARGS"));
    assertThat(tree.getChild(1).getChild(0).getType(), is(DeeLangParser.ARGS));
    assertThat(tree.getChild(1).getChild(0).getChildCount(), is(1));

    assertThat(tree.getChild(1).getChild(0).getChild(0).getText(), is("1"));
    assertThat(tree.getChild(1).getChild(0).getChild(0).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(1).getChild(0).getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(1).getChild(1).getText(), is("BLOCK"));
    assertThat(tree.getChild(1).getChild(1).getType(), is(DeeLangParser.BLOCK));
    assertThat(tree.getChild(1).getChild(1).getChildCount(), is(1));

    assertThat(tree.getChild(1).getChild(1).getChild(0).getText(), is("bee"));
    assertThat(tree.getChild(1).getChild(1).getChild(0).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(1).getChild(1).getChild(0).getChildCount(), is(0));
  }

  @Test
  public void testBasicFuncCallOneArgWithSingleInstructionWithNewlines() throws Throwable {
    CommonTree tree = runTest("foo(1) { bee\n }");

    assertThat(tree.getText(), is("METHOD_CALL"));
    assertThat(tree.getType(), is(DeeLangParser.METHOD_CALL));
    assertThat(tree.getChildCount(), is(2));

    assertThat(tree.getChild(0).getText(), is("SELF"));
    assertThat(tree.getChild(0).getType(), is(DeeLangParser.SELF));
    assertThat(tree.getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(1).getText(), is("foo"));
    assertThat(tree.getChild(1).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(1).getChildCount(), is(2));

    assertThat(tree.getChild(1).getChild(0).getText(), is("ARGS"));
    assertThat(tree.getChild(1).getChild(0).getType(), is(DeeLangParser.ARGS));
    assertThat(tree.getChild(1).getChild(0).getChildCount(), is(1));

    assertThat(tree.getChild(1).getChild(0).getChild(0).getText(), is("1"));
    assertThat(tree.getChild(1).getChild(0).getChild(0).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(1).getChild(0).getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(1).getChild(1).getText(), is("BLOCK"));
    assertThat(tree.getChild(1).getChild(1).getType(), is(DeeLangParser.BLOCK));
    assertThat(tree.getChild(1).getChild(1).getChildCount(), is(1));

    assertThat(tree.getChild(1).getChild(1).getChild(0).getText(), is("bee"));
    assertThat(tree.getChild(1).getChild(1).getChild(0).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(1).getChild(1).getChild(0).getChildCount(), is(0));

    tree = runTest("foo(1) { \nbee\n }");

    assertThat(tree.getText(), is("METHOD_CALL"));
    assertThat(tree.getType(), is(DeeLangParser.METHOD_CALL));
    assertThat(tree.getChildCount(), is(2));

    assertThat(tree.getChild(0).getText(), is("SELF"));
    assertThat(tree.getChild(0).getType(), is(DeeLangParser.SELF));
    assertThat(tree.getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(1).getText(), is("foo"));
    assertThat(tree.getChild(1).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(1).getChildCount(), is(2));

    assertThat(tree.getChild(1).getChild(0).getText(), is("ARGS"));
    assertThat(tree.getChild(1).getChild(0).getType(), is(DeeLangParser.ARGS));
    assertThat(tree.getChild(1).getChild(0).getChildCount(), is(1));

    assertThat(tree.getChild(1).getChild(0).getChild(0).getText(), is("1"));
    assertThat(tree.getChild(1).getChild(0).getChild(0).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(1).getChild(0).getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(1).getChild(1).getText(), is("BLOCK"));
    assertThat(tree.getChild(1).getChild(1).getType(), is(DeeLangParser.BLOCK));
    assertThat(tree.getChild(1).getChild(1).getChildCount(), is(1));

    assertThat(tree.getChild(1).getChild(1).getChild(0).getText(), is("bee"));
    assertThat(tree.getChild(1).getChild(1).getChild(0).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(1).getChild(1).getChild(0).getChildCount(), is(0));
  }
  
  @Test
  public void testBasicFuncCallOneArgWithTwoInstructionsNewlines() throws Throwable {
    CommonTree tree = runTest("foo(1) { \nbee\nbar\n }");

    assertThat(tree.getText(), is("METHOD_CALL"));
    assertThat(tree.getType(), is(DeeLangParser.METHOD_CALL));
    assertThat(tree.getChildCount(), is(2));

    assertThat(tree.getChild(0).getText(), is("SELF"));
    assertThat(tree.getChild(0).getType(), is(DeeLangParser.SELF));
    assertThat(tree.getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(1).getText(), is("foo"));
    assertThat(tree.getChild(1).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(1).getChildCount(), is(2));

    assertThat(tree.getChild(1).getChild(0).getText(), is("ARGS"));
    assertThat(tree.getChild(1).getChild(0).getType(), is(DeeLangParser.ARGS));
    assertThat(tree.getChild(1).getChild(0).getChildCount(), is(1));

    assertThat(tree.getChild(1).getChild(0).getChild(0).getText(), is("1"));
    assertThat(tree.getChild(1).getChild(0).getChild(0).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(1).getChild(0).getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(1).getChild(1).getText(), is("BLOCK"));
    assertThat(tree.getChild(1).getChild(1).getType(), is(DeeLangParser.BLOCK));
    assertThat(tree.getChild(1).getChild(1).getChildCount(), is(2));

    assertThat(tree.getChild(1).getChild(1).getChild(0).getText(), is("bee"));
    assertThat(tree.getChild(1).getChild(1).getChild(0).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(1).getChild(1).getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(1).getChild(1).getChild(1).getText(), is("bar"));
    assertThat(tree.getChild(1).getChild(1).getChild(1).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(1).getChild(1).getChild(1).getChildCount(), is(0));
  }
  
  @Test
  public void testBasicFuncCallOneArgWithTwoInstructionsSeparator() throws Throwable {
    CommonTree tree = runTest("foo(1) { \nbee; bar\n }");

    assertThat(tree.getText(), is("METHOD_CALL"));
    assertThat(tree.getType(), is(DeeLangParser.METHOD_CALL));
    assertThat(tree.getChildCount(), is(2));

    assertThat(tree.getChild(0).getText(), is("SELF"));
    assertThat(tree.getChild(0).getType(), is(DeeLangParser.SELF));
    assertThat(tree.getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(1).getText(), is("foo"));
    assertThat(tree.getChild(1).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(1).getChildCount(), is(2));

    assertThat(tree.getChild(1).getChild(0).getText(), is("ARGS"));
    assertThat(tree.getChild(1).getChild(0).getType(), is(DeeLangParser.ARGS));
    assertThat(tree.getChild(1).getChild(0).getChildCount(), is(1));

    assertThat(tree.getChild(1).getChild(0).getChild(0).getText(), is("1"));
    assertThat(tree.getChild(1).getChild(0).getChild(0).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(1).getChild(0).getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(1).getChild(1).getText(), is("BLOCK"));
    assertThat(tree.getChild(1).getChild(1).getType(), is(DeeLangParser.BLOCK));
    assertThat(tree.getChild(1).getChild(1).getChildCount(), is(2));

    assertThat(tree.getChild(1).getChild(1).getChild(0).getText(), is("bee"));
    assertThat(tree.getChild(1).getChild(1).getChild(0).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(1).getChild(1).getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(1).getChild(1).getChild(1).getText(), is("bar"));
    assertThat(tree.getChild(1).getChild(1).getChild(1).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(1).getChild(1).getChild(1).getChildCount(), is(0));
  }

  @Test
  public void testBasicFuncCallOneArgWithMoreThanTwoInstructionsMixedNewlineAndSeparator() throws Throwable {
    CommonTree tree = runTest("foo(1) { \nbee; bar\nbaz\nquux;qix }");

    assertThat(tree.getText(), is("METHOD_CALL"));
    assertThat(tree.getType(), is(DeeLangParser.METHOD_CALL));
    assertThat(tree.getChildCount(), is(2));

    assertThat(tree.getChild(0).getText(), is("SELF"));
    assertThat(tree.getChild(0).getType(), is(DeeLangParser.SELF));
    assertThat(tree.getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(1).getText(), is("foo"));
    assertThat(tree.getChild(1).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(1).getChildCount(), is(2));

    assertThat(tree.getChild(1).getChild(0).getText(), is("ARGS"));
    assertThat(tree.getChild(1).getChild(0).getType(), is(DeeLangParser.ARGS));
    assertThat(tree.getChild(1).getChild(0).getChildCount(), is(1));

    assertThat(tree.getChild(1).getChild(0).getChild(0).getText(), is("1"));
    assertThat(tree.getChild(1).getChild(0).getChild(0).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(1).getChild(0).getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(1).getChild(1).getText(), is("BLOCK"));
    assertThat(tree.getChild(1).getChild(1).getType(), is(DeeLangParser.BLOCK));
    assertThat(tree.getChild(1).getChild(1).getChildCount(), is(5));

    assertThat(tree.getChild(1).getChild(1).getChild(0).getText(), is("bee"));
    assertThat(tree.getChild(1).getChild(1).getChild(0).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(1).getChild(1).getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(1).getChild(1).getChild(1).getText(), is("bar"));
    assertThat(tree.getChild(1).getChild(1).getChild(1).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(1).getChild(1).getChild(1).getChildCount(), is(0));

    assertThat(tree.getChild(1).getChild(1).getChild(2).getText(), is("baz"));
    assertThat(tree.getChild(1).getChild(1).getChild(2).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(1).getChild(1).getChild(2).getChildCount(), is(0));

    assertThat(tree.getChild(1).getChild(1).getChild(3).getText(), is("quux"));
    assertThat(tree.getChild(1).getChild(1).getChild(3).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(1).getChild(1).getChild(3).getChildCount(), is(0));

    assertThat(tree.getChild(1).getChild(1).getChild(4).getText(), is("qix"));
    assertThat(tree.getChild(1).getChild(1).getChild(4).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(1).getChild(1).getChild(4).getChildCount(), is(0));
  }
}
