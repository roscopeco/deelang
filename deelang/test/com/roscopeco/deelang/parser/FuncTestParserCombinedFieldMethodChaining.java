package com.roscopeco.deelang.parser;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.Tree;
import org.junit.Test;

public class FuncTestParserCombinedFieldMethodChaining extends
    ParserFuncTestBase {
  @Test
  public void testMemberAccessAfterMethod() throws RecognitionException {
    Tree tree = runTest("Quux.qix().baz");
    
    assertNull(tree.getText());
    assertThat(tree.getType(), is(0));
    assertThat(tree.getChildCount(), is(2));

    assertThat(tree.getChild(0).getText(), is("METHOD_CALL"));
    assertThat(tree.getChild(0).getType(), is(DeeLangParser.METHOD_CALL));
    assertThat(tree.getChild(0).getChildCount(), is(2));

    assertThat(tree.getChild(0).getChild(0).getText(), is("Quux"));
    assertThat(tree.getChild(0).getChild(0).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(0).getChild(0).getChildCount(), is(0));
    
    assertThat(tree.getChild(0).getChild(1).getText(), is("qix"));
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
  }

  @Test
  public void testMethodAfterMemberAccess() throws RecognitionException {
    Tree tree = runTest("Quux.baz.qix()");
    
    assertNull(tree.getText());
    assertThat(tree.getType(), is(0));
    assertThat(tree.getChildCount(), is(2));

    assertThat(tree.getChild(0).getText(), is("FIELD_ACCESS"));
    assertThat(tree.getChild(0).getType(), is(DeeLangParser.FIELD_ACCESS));
    assertThat(tree.getChild(0).getChildCount(), is(2));

    assertThat(tree.getChild(0).getChild(0).getText(), is("Quux"));
    assertThat(tree.getChild(0).getChild(0).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(0).getChild(0).getChildCount(), is(0));
    
    assertThat(tree.getChild(0).getChild(1).getText(), is("baz"));
    assertThat(tree.getChild(0).getChild(1).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(0).getChild(1).getChildCount(), is(0));

    assertThat(tree.getChild(1).getText(), is("METHOD_CALL"));
    assertThat(tree.getChild(1).getType(), is(DeeLangParser.METHOD_CALL));
    assertThat(tree.getChild(1).getChildCount(), is(2));

    assertThat(tree.getChild(1).getChild(0).getText(), is("CHAIN"));
    assertThat(tree.getChild(1).getChild(0).getType(), is(DeeLangParser.CHAIN));
    assertThat(tree.getChild(1).getChild(0).getChildCount(), is(0));
    
    assertThat(tree.getChild(1).getChild(1).getText(), is("qix"));
    assertThat(tree.getChild(1).getChild(1).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(1).getChild(1).getChildCount(), is(0));
  }

  @Test
  public void testMethodAfterMemberAccessAfterMethod() throws RecognitionException {
    Tree tree = runTest("Quux.qix().baz.beez()");
    
    assertNull(tree.getText());
    assertThat(tree.getType(), is(0));
    assertThat(tree.getChildCount(), is(3));

    assertThat(tree.getChild(0).getText(), is("METHOD_CALL"));
    assertThat(tree.getChild(0).getType(), is(DeeLangParser.METHOD_CALL));
    assertThat(tree.getChild(0).getChildCount(), is(2));

    assertThat(tree.getChild(0).getChild(0).getText(), is("Quux"));
    assertThat(tree.getChild(0).getChild(0).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(0).getChild(0).getChildCount(), is(0));
    
    assertThat(tree.getChild(0).getChild(1).getText(), is("qix"));
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

    assertThat(tree.getChild(2).getText(), is("METHOD_CALL"));
    assertThat(tree.getChild(2).getType(), is(DeeLangParser.METHOD_CALL));
    assertThat(tree.getChild(2).getChildCount(), is(2));

    assertThat(tree.getChild(2).getChild(0).getText(), is("CHAIN"));
    assertThat(tree.getChild(2).getChild(0).getType(), is(DeeLangParser.CHAIN));
    assertThat(tree.getChild(2).getChild(0).getChildCount(), is(0));
    
    assertThat(tree.getChild(2).getChild(1).getText(), is("beez"));
    assertThat(tree.getChild(2).getChild(1).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(2).getChild(1).getChildCount(), is(0));
  }
}
