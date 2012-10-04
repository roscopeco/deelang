package com.roscopeco.deelang.parser;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertNull;

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
  public void testBasicAssignment() throws Throwable {
    CommonTree tree = runTest("a=b");

    assertThat(tree.getText(), is("ASSIGN_LOCAL"));
    assertThat(tree.getType(), is(DeeLangParser.ASSIGN_LOCAL));
    assertThat(tree.getChildCount(), is(2));

    assertThat(tree.getChild(0).getText(), is("a"));
    assertThat(tree.getChild(0).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(1).getText(), is("b"));
    assertThat(tree.getChild(1).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(1).getChildCount(), is(0));
  }

  @Test
  public void testAssignmentToAssign() throws Throwable {
    CommonTree tree = runTest("a=b=c");

    assertThat(tree.getText(), is("ASSIGN_LOCAL"));
    assertThat(tree.getType(), is(DeeLangParser.ASSIGN_LOCAL));
    assertThat(tree.getChildCount(), is(2));

    assertThat(tree.getChild(0).getText(), is("a"));
    assertThat(tree.getChild(0).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(1).getText(), is("ASSIGN_LOCAL"));
    assertThat(tree.getChild(1).getType(), is(DeeLangParser.ASSIGN_LOCAL));
    assertThat(tree.getChild(1).getChildCount(), is(2));

    assertThat(tree.getChild(1).getChild(0).getText(), is("b"));
    assertThat(tree.getChild(1).getChild(0).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(1).getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(1).getChild(1).getText(), is("c"));
    assertThat(tree.getChild(1).getChild(1).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(1).getChild(1).getChildCount(), is(0));
  }

  @Test
  public void testAssignmentInExpressionWithLiteralFirst() throws Throwable {
    CommonTree tree = runTest("1+(b=2)");
    
    assertThat(tree.getText(), is("+"));
    assertThat(tree.getType(), is(DeeLangParser.ADD));
    assertThat(tree.getChildCount(), is(2));
    
    assertThat(tree.getChild(0).getText(), is("1"));
    assertThat(tree.getChild(0).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(1).getText(), is("ASSIGN_LOCAL"));
    assertThat(tree.getChild(1).getType(), is(DeeLangParser.ASSIGN_LOCAL));
    assertThat(tree.getChild(1).getChildCount(), is(2));

    assertThat(tree.getChild(1).getChild(0).getText(), is("b"));
    assertThat(tree.getChild(1).getChild(0).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(1).getChild(0).getChildCount(), is(0));
    
    assertThat(tree.getChild(1).getChild(1).getText(), is("2"));
    assertThat(tree.getChild(1).getChild(1).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(1).getChild(1).getChildCount(), is(0));
  }

  @Test
  public void testAssignmentInExpressionWithIdentifierFirst() throws Throwable {
    CommonTree tree;
    try {
      tree = runTest("a+(b=2)");
    } catch (ParserError t) {
      System.out.println(t);
      throw(t);
    }

    assertThat(tree.getText(), is("+"));
    assertThat(tree.getType(), is(DeeLangParser.ADD));
    assertThat(tree.getChildCount(), is(2));
    
    assertThat(tree.getChild(0).getText(), is("a"));
    assertThat(tree.getChild(0).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(1).getText(), is("ASSIGN_LOCAL"));
    assertThat(tree.getChild(1).getType(), is(DeeLangParser.ASSIGN_LOCAL));
    assertThat(tree.getChild(1).getChildCount(), is(2));
    
    assertThat(tree.getChild(1).getChild(0).getText(), is("b"));
    assertThat(tree.getChild(1).getChild(0).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(1).getChild(0).getChildCount(), is(0));
    
    assertThat(tree.getChild(1).getChild(1).getText(), is("2"));
    assertThat(tree.getChild(1).getChild(1).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(1).getChild(1).getChildCount(), is(0));
  }

  @Test(expected = ParserError.class)
  public void testAssignmentInExpressionWithAllIdentifiersNoParensChokes() throws Throwable {
    runTest("a+b=c");
  }
  
  @Test
  public void testAssignmentInExpressionWithAllIdentifiersAndParens() throws Throwable {
    CommonTree tree = runTest("1+(b=c)");
    
    assertThat(tree.getText(), is("+"));
    assertThat(tree.getType(), is(DeeLangParser.ADD));
    assertThat(tree.getChildCount(), is(2));
    
    assertThat(tree.getChild(0).getText(), is("1"));
    assertThat(tree.getChild(0).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(1).getText(), is("ASSIGN_LOCAL"));
    assertThat(tree.getChild(1).getType(), is(DeeLangParser.ASSIGN_LOCAL));
    assertThat(tree.getChild(1).getChildCount(), is(2));
    
    assertThat(tree.getChild(1).getChild(0).getText(), is("b"));
    assertThat(tree.getChild(1).getChild(0).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(1).getChild(0).getChildCount(), is(0));
    
    assertThat(tree.getChild(1).getChild(1).getText(), is("c"));
    assertThat(tree.getChild(1).getChild(1).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(1).getChild(1).getChildCount(), is(0));
  }
  
  @Test(expected=ParserError.class)
  public void testAssignToExprChokes() throws Throwable {
    runTest("(a+b)=c");
  }
  
  @Test
  public void testAssignToExprResultAndChained() throws Throwable {
    CommonTree tree = runTest("(a+b).c=d");

    assertNull(tree.getText());
    assertThat(tree.getType(), is(0));
    assertThat(tree.getChildCount(), is(2));

    assertThat(tree.getChild(0).getText(), is("+"));
    assertThat(tree.getChild(0).getType(), is(DeeLangParser.ADD));
    assertThat(tree.getChild(0).getChildCount(), is(2));
    
    assertThat(tree.getChild(0).getChild(0).getText(), is("a"));
    assertThat(tree.getChild(0).getChild(0).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(0).getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(0).getChild(1).getText(), is("b"));
    assertThat(tree.getChild(0).getChild(1).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(0).getChild(1).getChildCount(), is(0));

    assertThat(tree.getChild(1).getText(), is("ASSIGN_FIELD"));
    assertThat(tree.getChild(1).getType(), is(DeeLangParser.ASSIGN_FIELD));
    assertThat(tree.getChild(1).getChildCount(), is(3));
    
    assertThat(tree.getChild(1).getChild(0).getText(), is("CHAIN"));
    assertThat(tree.getChild(1).getChild(0).getType(), is(DeeLangParser.CHAIN));
    assertThat(tree.getChild(1).getChild(0).getChildCount(), is(0));
    
    assertThat(tree.getChild(1).getChild(1).getText(), is("c"));
    assertThat(tree.getChild(1).getChild(1).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(1).getChild(1).getChildCount(), is(0));
    
    assertThat(tree.getChild(1).getChild(2).getText(), is("d"));
    assertThat(tree.getChild(1).getChild(2).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(1).getChild(2).getChildCount(), is(0));
  }
  
  @Test
  public void testChainedLValueAllFieldsAssignment() throws Throwable {
    CommonTree tree = runTest("foo.bar.baz = 2");

    assertNull(tree.getText());
    assertThat(tree.getType(), is(0));
    assertThat(tree.getChildCount(), is(2));

    assertThat(tree.getChild(0).getText(), is("FIELD_ACCESS"));
    assertThat(tree.getChild(0).getType(), is(DeeLangParser.FIELD_ACCESS));
    assertThat(tree.getChild(0).getChildCount(), is(2));
    
    assertThat(tree.getChild(0).getChild(0).getText(), is("foo"));
    assertThat(tree.getChild(0).getChild(0).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(0).getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(0).getChild(1).getText(), is("bar"));
    assertThat(tree.getChild(0).getChild(1).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(0).getChild(1).getChildCount(), is(0));

    assertThat(tree.getChild(1).getText(), is("ASSIGN_FIELD"));
    assertThat(tree.getChild(1).getType(), is(DeeLangParser.ASSIGN_FIELD));
    assertThat(tree.getChild(1).getChildCount(), is(3));
    
    assertThat(tree.getChild(1).getChild(0).getText(), is("CHAIN"));
    assertThat(tree.getChild(1).getChild(0).getType(), is(DeeLangParser.CHAIN));
    assertThat(tree.getChild(1).getChild(0).getChildCount(), is(0));
    
    assertThat(tree.getChild(1).getChild(1).getText(), is("baz"));
    assertThat(tree.getChild(1).getChild(1).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(1).getChild(1).getChildCount(), is(0));
    
    assertThat(tree.getChild(1).getChild(2).getText(), is("2"));
    assertThat(tree.getChild(1).getChild(2).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(1).getChild(2).getChildCount(), is(0));
  }

  @Test
  public void testChainedLValueWithMethodsAssignment() throws Throwable {
    runTest("foo.bar().baz = 2");
    
    // TODO implement this
  }

  @Test
  public void testChainedLValueFieldsMethodsAssignmentMoreThanThreeChains() throws Throwable {
    CommonTree tree = runTest("Foo.bar.baz.quux = 2");

    assertNull(tree.getText());
    assertThat(tree.getType(), is(0));
    assertThat(tree.getChildCount(), is(3));

    assertThat(tree.getChild(0).getText(), is("FIELD_ACCESS"));
    assertThat(tree.getChild(0).getType(), is(DeeLangParser.FIELD_ACCESS));
    assertThat(tree.getChild(0).getChildCount(), is(2));
    
    assertThat(tree.getChild(0).getChild(0).getText(), is("Foo"));
    assertThat(tree.getChild(0).getChild(0).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(0).getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(0).getChild(1).getText(), is("bar"));
    assertThat(tree.getChild(0).getChild(1).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(0).getChild(1).getChildCount(), is(0));

    assertThat(tree.getChild(1).getText(), is("FIELD_ACCESS"));
    assertThat(tree.getChild(1).getType(), is(DeeLangParser.FIELD_ACCESS));
    assertThat(tree.getChild(1).getChildCount(), is(2));
    
    assertThat(tree.getChild(1).getChild(0).getText(), is("CHAIN"));
    assertThat(tree.getChild(1).getChild(0).getType(), is(DeeLangParser.CHAIN));
    assertThat(tree.getChild(1).getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(1).getChild(1).getText(), is("baz"));
    assertThat(tree.getChild(1).getChild(1).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(1).getChild(1).getChildCount(), is(0));

    assertThat(tree.getChild(2).getText(), is("ASSIGN_FIELD"));
    assertThat(tree.getChild(2).getType(), is(DeeLangParser.ASSIGN_FIELD));
    assertThat(tree.getChild(2).getChildCount(), is(3));
    
    assertThat(tree.getChild(2).getChild(0).getText(), is("CHAIN"));
    assertThat(tree.getChild(2).getChild(0).getType(), is(DeeLangParser.CHAIN));
    assertThat(tree.getChild(2).getChild(0).getChildCount(), is(0));
    
    assertThat(tree.getChild(2).getChild(1).getText(), is("quux"));
    assertThat(tree.getChild(2).getChild(1).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(2).getChild(1).getChildCount(), is(0));
    
    assertThat(tree.getChild(2).getChild(2).getText(), is("2"));
    assertThat(tree.getChild(2).getChild(2).getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChild(2).getChild(2).getChildCount(), is(0));
  }

  @Test(expected=ParserError.class)
  public void testChainedAssignWithMethodAtEndChokes() throws Throwable {
    runTest("foo.bar().baz() = 2");
  }
}
