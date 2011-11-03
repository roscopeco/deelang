package com.roscopeco.deelang.parser;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.antlr.runtime.tree.CommonTree;
import org.junit.Test;

import com.roscopeco.deelang.parser.DeeLangParser;

public class FuncTestParserMemberAssignment extends ParserFuncTestBase {
  @Test
  public void testBasicMemberAssignment() throws Throwable {
    CommonTree tree = runTest("Foo.a=b");

    assertNull(tree.getText());
    assertThat(tree.getType(), is(0));
    assertThat(tree.getChildCount(), is(2));

    assertThat(tree.getChild(0).getText(), is("Foo"));
    assertThat(tree.getChild(0).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(1).getText(), is("ASSIGN_FIELD"));
    assertThat(tree.getChild(1).getType(), is(DeeLangParser.ASSIGN_FIELD));
    assertThat(tree.getChild(1).getChildCount(), is(2));

    assertThat(tree.getChild(1).getChild(0).getText(), is("a"));
    assertThat(tree.getChild(1).getChild(0).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(1).getChild(0).getChildCount(), is(0));

    assertThat(tree.getChild(1).getChild(1).getText(), is("b"));
    assertThat(tree.getChild(1).getChild(1).getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChild(1).getChild(1).getChildCount(), is(0));
  }
}
