package com.roscopeco.deelang.parser;

import org.antlr.runtime.tree.Tree;
import org.junit.Test;

import com.roscopeco.deelang.parser.DeeLangParser;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class FuncTestParserMemberAccess extends ParserFuncTestBase {
  @Test
  public void testBasicMemberAccess() throws Throwable {
    Tree tree = runTest("Quux.qix");
    
    assertThat(tree.getText(), is("FIELD_ACCESS"));
    assertThat(tree.getType(), is(DeeLangParser.FIELD_ACCESS));
    assertThat(tree.getChildCount(), is(2));

    assertThat(tree.getChild(0).getText(), is("Quux"));
    assertThat(tree.getChild(0).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(0).getChildCount(), is(0));
    
    assertThat(tree.getChild(1).getText(), is("qix"));
    assertThat(tree.getChild(1).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(1).getChildCount(), is(0));
  }

  @Test
  public void testChainedMemberAccess() throws Throwable {
    Tree tree = runTest("Quux.qix.baz");
    
    assertNull(tree.getText());
    assertThat(tree.getType(), is(0));
    assertThat(tree.getChildCount(), is(2));

    assertThat(tree.getChild(0).getText(), is("FIELD_ACCESS"));
    assertThat(tree.getChild(0).getType(), is(DeeLangParser.FIELD_ACCESS));
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
}
