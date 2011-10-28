package com.roscopeco.deelang.parser;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertNull;

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
public class FuncTestParserMethodCalls extends ParserFuncTestBase {
  @Test
  public void testBasicMethCallNoArgs() throws RecognitionException {
    CommonTree tree = runTest("foo.bar()");

    assertThat(tree.getText(), is("METHOD_CALL"));
    assertThat(tree.getType(), is(DeeLangParser.METHOD_CALL));
    assertThat(tree.getChildCount(), is(2));

    assertThat(tree.getChild(0).getText(), is("foo"));
    assertThat(tree.getChild(0).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(1).getText(), is("bar"));
    assertThat(tree.getChild(1).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(1).getChildCount(), is(0));
  }

  @Test
  public void testBasicMethCallToMethCall() throws RecognitionException {
    CommonTree tree = runTest("foo.bar(baz.quux())");

    assertThat(tree.getText(), is("METHOD_CALL"));
    assertThat(tree.getType(), is(DeeLangParser.METHOD_CALL));
    assertThat(tree.getChildCount(), is(2));

    assertThat(tree.getChild(0).getText(), is("foo"));
    assertThat(tree.getChild(0).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(1).getText(), is("bar"));
    assertThat(tree.getChild(1).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(1).getChildCount(), is(1));

    assertThat(tree.getChild(1).getChild(0).getText(), is("ARGS"));
    assertThat(tree.getChild(1).getChild(0).getType(), is(DeeLangParser.ARGS));
    assertThat(tree.getChild(1).getChild(0).getChildCount(), is(1));

    assertThat(tree.getChild(1).getChild(0).getChild(0).getText(), is("METHOD_CALL"));
    assertThat(tree.getChild(1).getChild(0).getChild(0).getType(), is(DeeLangParser.METHOD_CALL));
    assertThat(tree.getChild(1).getChild(0).getChild(0).getChildCount(), is(2));

    assertThat(tree.getChild(1).getChild(0).getChild(0).getChild(0).getText(), is("baz"));
    assertThat(tree.getChild(1).getChild(0).getChild(0).getChild(0).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(1).getChild(0).getChild(0).getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(1).getChild(0).getChild(0).getChild(1).getText(), is("quux"));
    assertThat(tree.getChild(1).getChild(0).getChild(0).getChild(1).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(1).getChild(0).getChild(0).getChild(1).getChildCount(), is(0));
  }
  
  @Test(expected = RecognitionException.class)
  public void testChokesOnInitialDot() throws RecognitionException {
    runTest(".bar()");
  }
  
  @Test
  public void testStringLiteralMethodCall() throws RecognitionException {
    CommonTree tree = runTest("\"one\".bar()");
    
    assertThat(tree.getText(), is("METHOD_CALL"));
    assertThat(tree.getType(), is(DeeLangParser.METHOD_CALL));
    assertThat(tree.getChildCount(), is(2));

    assertThat(tree.getChild(0).getText(), is("\"one\""));
    assertThat(tree.getChild(0).getType(), is(DeeLangParser.STRING_LITERAL));
    assertThat(tree.getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(1).getText(), is("bar"));
    assertThat(tree.getChild(1).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(1).getChildCount(), is(0));
  }

  @Test
  public void testIntLiteralMethodCall() throws RecognitionException {
    CommonTree tree = runTest("1.bar()");
    
    assertThat(tree.getText(), is("METHOD_CALL"));
    assertThat(tree.getType(), is(DeeLangParser.METHOD_CALL));
    assertThat(tree.getChildCount(), is(2));

    assertThat(tree.getChild(0).getText(), is("1"));
    assertThat(tree.getChild(0).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(1).getText(), is("bar"));
    assertThat(tree.getChild(1).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(1).getChildCount(), is(0));
  }

  @Test
  public void testHexLiteralMethodCall() throws RecognitionException {
    CommonTree tree = runTest("0x1.bar()");
    
    assertThat(tree.getText(), is("METHOD_CALL"));
    assertThat(tree.getType(), is(DeeLangParser.METHOD_CALL));
    assertThat(tree.getChildCount(), is(2));

    assertThat(tree.getChild(0).getText(), is("0x1"));
    assertThat(tree.getChild(0).getType(), is(DeeLangParser.HEX_LITERAL));
    assertThat(tree.getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(1).getText(), is("bar"));
    assertThat(tree.getChild(1).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(1).getChildCount(), is(0));
  }

  @Test
  public void testOctalLiteralMethodCall() throws RecognitionException {
    CommonTree tree = runTest("007.bar()");
    
    assertThat(tree.getText(), is("METHOD_CALL"));
    assertThat(tree.getType(), is(DeeLangParser.METHOD_CALL));
    assertThat(tree.getChildCount(), is(2));

    assertThat(tree.getChild(0).getText(), is("007"));
    assertThat(tree.getChild(0).getType(), is(DeeLangParser.OCTAL_LITERAL));
    assertThat(tree.getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(1).getText(), is("bar"));
    assertThat(tree.getChild(1).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(1).getChildCount(), is(0));
  }

  @Test
  public void testFloatLiteralMethodCall() throws RecognitionException {
    CommonTree tree = runTest("1.2.bar()");
    
    assertThat(tree.getText(), is("METHOD_CALL"));
    assertThat(tree.getType(), is(DeeLangParser.METHOD_CALL));
    assertThat(tree.getChildCount(), is(2));

    assertThat(tree.getChild(0).getText(), is("1.2"));
    assertThat(tree.getChild(0).getType(), is(DeeLangParser.FLOATING_POINT_LITERAL));
    assertThat(tree.getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(1).getText(), is("bar"));
    assertThat(tree.getChild(1).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(1).getChildCount(), is(0));
  }
  
  @Test
  public void testChainedMethodCall() throws RecognitionException {
    CommonTree tree = runTest("Foo.bar().baz()");

    assertNull(tree.getText());
    assertThat(tree.getType(), is(0));
    assertThat(tree.getChildCount(), is(2));

    assertThat(tree.getChild(0).getText(), is("METHOD_CALL"));
    assertThat(tree.getChild(0).getType(), is(DeeLangParser.METHOD_CALL));
    assertThat(tree.getChild(0).getChildCount(), is(2));

    assertThat(tree.getChild(0).getChild(0).getText(), is("Foo"));
    assertThat(tree.getChild(0).getChild(0).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(0).getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(0).getChild(1).getText(), is("bar"));
    assertThat(tree.getChild(0).getChild(1).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(0).getChild(1).getChildCount(), is(0));

    assertThat(tree.getChild(1).getText(), is("METHOD_CALL"));
    assertThat(tree.getChild(1).getType(), is(DeeLangParser.METHOD_CALL));
    assertThat(tree.getChild(1).getChildCount(), is(2));

    assertThat(tree.getChild(1).getChild(0).getText(), is("CHAIN"));
    assertThat(tree.getChild(1).getChild(0).getType(), is(DeeLangParser.CHAIN));
    assertThat(tree.getChild(1).getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(1).getChild(1).getText(), is("baz"));
    assertThat(tree.getChild(1).getChild(1).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(1).getChild(1).getChildCount(), is(0));
  }

  @Test
  public void testChainedMethodCallWithArgs() throws RecognitionException {
    CommonTree tree = runTest("Foo.bar(1,2).baz(3)");

    assertNull(tree.getText());
    assertThat(tree.getType(), is(0));
    assertThat(tree.getChildCount(), is(2));

    assertThat(tree.getChild(0).getText(), is("METHOD_CALL"));
    assertThat(tree.getChild(0).getType(), is(DeeLangParser.METHOD_CALL));
    assertThat(tree.getChild(0).getChildCount(), is(2));

    assertThat(tree.getChild(0).getChild(0).getText(), is("Foo"));
    assertThat(tree.getChild(0).getChild(0).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(0).getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(0).getChild(1).getText(), is("bar"));
    assertThat(tree.getChild(0).getChild(1).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(0).getChild(1).getChildCount(), is(1));

    assertThat(tree.getChild(0).getChild(1).getChild(0).getText(), is("ARGS"));
    assertThat(tree.getChild(0).getChild(1).getChild(0).getType(), is(DeeLangParser.ARGS));
    assertThat(tree.getChild(0).getChild(1).getChild(0).getChildCount(), is(2));

    assertThat(tree.getChild(0).getChild(1).getChild(0).getChild(0).getText(), is("1"));
    assertThat(tree.getChild(0).getChild(1).getChild(0).getChild(0).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(0).getChild(1).getChild(0).getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(0).getChild(1).getChild(0).getChild(1).getText(), is("2"));
    assertThat(tree.getChild(0).getChild(1).getChild(0).getChild(1).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(0).getChild(1).getChild(0).getChild(1).getChildCount(), is(0));

    assertThat(tree.getChild(1).getText(), is("METHOD_CALL"));
    assertThat(tree.getChild(1).getType(), is(DeeLangParser.METHOD_CALL));
    assertThat(tree.getChild(1).getChildCount(), is(2));

    assertThat(tree.getChild(1).getChild(0).getText(), is("CHAIN"));
    assertThat(tree.getChild(1).getChild(0).getType(), is(DeeLangParser.CHAIN));
    assertThat(tree.getChild(1).getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(1).getChild(1).getText(), is("baz"));
    assertThat(tree.getChild(1).getChild(1).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(1).getChild(1).getChildCount(), is(1));

    assertThat(tree.getChild(1).getChild(1).getChild(0).getText(), is("ARGS"));
    assertThat(tree.getChild(1).getChild(1).getChild(0).getType(), is(DeeLangParser.ARGS));
    assertThat(tree.getChild(1).getChild(1).getChild(0).getChildCount(), is(1));

    assertThat(tree.getChild(1).getChild(1).getChild(0).getChild(0).getText(), is("3"));
    assertThat(tree.getChild(1).getChild(1).getChild(0).getChild(0).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(1).getChild(1).getChild(0).getChild(0).getChildCount(), is(0));
  }

  @Test
  public void testChainedMethodCallWithBlock() throws RecognitionException {
    CommonTree tree = runTest("Foo.bar() { bee }.baz()");

    assertNull(tree.getText());
    assertThat(tree.getType(), is(0));
    assertThat(tree.getChildCount(), is(2));

    assertThat(tree.getChild(0).getText(), is("METHOD_CALL"));
    assertThat(tree.getChild(0).getType(), is(DeeLangParser.METHOD_CALL));
    assertThat(tree.getChild(0).getChildCount(), is(2));

    assertThat(tree.getChild(0).getChild(0).getText(), is("Foo"));
    assertThat(tree.getChild(0).getChild(0).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(0).getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(0).getChild(1).getText(), is("bar"));
    assertThat(tree.getChild(0).getChild(1).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(0).getChild(1).getChildCount(), is(1));

    assertThat(tree.getChild(0).getChild(1).getChild(0).getText(), is("BLOCK"));
    assertThat(tree.getChild(0).getChild(1).getChild(0).getType(), is(DeeLangParser.BLOCK));
    assertThat(tree.getChild(0).getChild(1).getChild(0).getChildCount(), is(1));

    assertThat(tree.getChild(0).getChild(1).getChild(0).getChild(0).getText(), is("bee"));
    assertThat(tree.getChild(0).getChild(1).getChild(0).getChild(0).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(0).getChild(1).getChild(0).getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(1).getText(), is("METHOD_CALL"));
    assertThat(tree.getChild(1).getType(), is(DeeLangParser.METHOD_CALL));
    assertThat(tree.getChild(1).getChildCount(), is(2));

    assertThat(tree.getChild(1).getChild(0).getText(), is("CHAIN"));
    assertThat(tree.getChild(1).getChild(0).getType(), is(DeeLangParser.CHAIN));
    assertThat(tree.getChild(1).getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(1).getChild(1).getText(), is("baz"));
    assertThat(tree.getChild(1).getChild(1).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(1).getChild(1).getChildCount(), is(0));
  }
  
  @Test
  public void testChainedMethodCallMoreThanThreeChain() throws RecognitionException {
    CommonTree tree = runTest("Foo.bar().baz().bee().quux()");

    assertNull(tree.getText());
    assertThat(tree.getType(), is(0));
    assertThat(tree.getChildCount(), is(4));

    assertThat(tree.getChild(0).getText(), is("METHOD_CALL"));
    assertThat(tree.getChild(0).getType(), is(DeeLangParser.METHOD_CALL));
    assertThat(tree.getChild(0).getChildCount(), is(2));

    assertThat(tree.getChild(0).getChild(0).getText(), is("Foo"));
    assertThat(tree.getChild(0).getChild(0).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(0).getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(0).getChild(1).getText(), is("bar"));
    assertThat(tree.getChild(0).getChild(1).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(0).getChild(1).getChildCount(), is(0));

    assertThat(tree.getChild(1).getText(), is("METHOD_CALL"));
    assertThat(tree.getChild(1).getType(), is(DeeLangParser.METHOD_CALL));
    assertThat(tree.getChild(1).getChildCount(), is(2));

    assertThat(tree.getChild(1).getChild(0).getText(), is("CHAIN"));
    assertThat(tree.getChild(1).getChild(0).getType(), is(DeeLangParser.CHAIN));
    assertThat(tree.getChild(1).getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(1).getChild(1).getText(), is("baz"));
    assertThat(tree.getChild(1).getChild(1).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(1).getChild(1).getChildCount(), is(0));

    assertThat(tree.getChild(2).getText(), is("METHOD_CALL"));
    assertThat(tree.getChild(2).getType(), is(DeeLangParser.METHOD_CALL));
    assertThat(tree.getChild(2).getChildCount(), is(2));

    assertThat(tree.getChild(2).getChild(0).getText(), is("CHAIN"));
    assertThat(tree.getChild(2).getChild(0).getType(), is(DeeLangParser.CHAIN));
    assertThat(tree.getChild(2).getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(2).getChild(1).getText(), is("bee"));
    assertThat(tree.getChild(2).getChild(1).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(2).getChild(1).getChildCount(), is(0));

    assertThat(tree.getChild(3).getText(), is("METHOD_CALL"));
    assertThat(tree.getChild(3).getType(), is(DeeLangParser.METHOD_CALL));
    assertThat(tree.getChild(3).getChildCount(), is(2));

    assertThat(tree.getChild(3).getChild(0).getText(), is("CHAIN"));
    assertThat(tree.getChild(3).getChild(0).getType(), is(DeeLangParser.CHAIN));
    assertThat(tree.getChild(3).getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(3).getChild(1).getText(), is("quux"));
    assertThat(tree.getChild(3).getChild(1).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(3).getChild(1).getChildCount(), is(0));
    
  }

}
