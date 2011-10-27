package com.roscopeco.deelang.parser;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.junit.Test;

import com.roscopeco.deelang.parser.DeeLangParser;

public class FuncTestParserLiterals extends ParserFuncTestBase {

  /* ********** BASIC - VARIOUS LITERAL TYPES ************* */
  @Test
  public void testUnderstandDecimalLiterals() throws RecognitionException {
    CommonTree tree = runTest("7");
    
    assertThat(tree.getText(), is("7"));
    assertThat(tree.getType(), is(DeeLangParser.DECIMAL_LITERAL));
    assertThat(tree.getChildCount(), is(0));
  }
  
  @Test
  public void testUnderstandOctalLiterals() throws RecognitionException {
    CommonTree tree = runTest("007");
    
    assertThat(tree.getText(), is("007"));
    assertThat(tree.getType(), is(DeeLangParser.OCTAL_LITERAL));
    assertThat(tree.getChildCount(), is(0));
  }
  
  @Test
  public void testUnderstandHexLiterals() throws RecognitionException {
    CommonTree tree = runTest("0x7");
    
    assertThat(tree.getText(), is("0x7"));
    assertThat(tree.getType(), is(DeeLangParser.HEX_LITERAL));
    assertThat(tree.getChildCount(), is(0));
  }
  
  @Test
  public void testUnderstandFloatLiterals() throws RecognitionException {
    CommonTree tree = runTest("7.2");
    
    assertThat(tree.getText(), is("7.2"));
    assertThat(tree.getType(), is(DeeLangParser.FLOATING_POINT_LITERAL));
    assertThat(tree.getChildCount(), is(0));
  }
  
  @Test
  public void testUnderstandCharLiterals() throws RecognitionException {
    CommonTree tree = runTest("'f'");
    
    assertThat(tree.getText(), is("'f'"));
    assertThat(tree.getType(), is(DeeLangParser.CHARACTER_LITERAL));
    assertThat(tree.getChildCount(), is(0));
  }

  @Test
  public void testUnderstandStringLiterals() throws RecognitionException {
    CommonTree tree = runTest("\"foo\"");
    
    assertThat(tree.getText(), is("\"foo\""));
    assertThat(tree.getType(), is(DeeLangParser.STRING_LITERAL));
    assertThat(tree.getChildCount(), is(0));
  }

  @Test
  public void testDontChokeOnCharLiteralEscapes() throws RecognitionException {
    CommonTree tree = runTest("'\\''");
    
    assertThat(tree.getText(), is("'\\''"));
    assertThat(tree.getType(), is(DeeLangParser.CHARACTER_LITERAL));
    assertThat(tree.getChildCount(), is(0));
  }

  @Test
  public void testDontChokeOnStringLiteralEscapes() throws RecognitionException {
    CommonTree tree = runTest("\"foo\\\" \"");
    
    assertThat(tree.getText(), is("\"foo\\\" \""));
    assertThat(tree.getType(), is(DeeLangParser.STRING_LITERAL));
    assertThat(tree.getChildCount(), is(0));
  }

  /*
  @Test
  public void testUnderstandRegexpLiterals() throws RecognitionException {
    CommonTree tree = runTest("/foo/");
    
    assertThat(tree.getText(), is("/foo/"));
    assertThat(tree.getType(), is(DeeLangParser.REGEXP_LITERAL));
    assertThat(tree.getChildCount(), is(0));
  }

  @Test
  public void testDontChokeOnRegexpLiteralEscapes() throws RecognitionException {
    CommonTree tree = runTest("/foo\\/ /");
    
    assertThat(tree.getText(), is("/foo\\/ /"));
    assertThat(tree.getType(), is(DeeLangParser.REGEXP_LITERAL));
    assertThat(tree.getChildCount(), is(0));
  }
  */
}
