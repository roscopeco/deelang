package com.roscopeco.deelang.parser;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.Tree;
import org.junit.Test;

import com.roscopeco.deelang.parser.DeeLangParser;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class FuncTestParserVarAccess extends ParserFuncTestBase {
  @Test
  public void testBasicVarAccess() throws RecognitionException {
    Tree tree = runTest("qix");
    
    assertThat(tree.getText(), is("qix"));
    assertThat(tree.getType(), is(DeeLangParser.IDENTIFIER));
    assertThat(tree.getChildCount(), is(0));
  }
}
