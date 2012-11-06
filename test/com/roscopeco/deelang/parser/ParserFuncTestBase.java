package com.roscopeco.deelang.parser;

import org.antlr.runtime.tree.CommonTree;

import com.roscopeco.deelang.parser.DeeLangLexer;
import com.roscopeco.deelang.parser.DeeLangParser;
import com.roscopeco.deelang.parser.Parser;

public class ParserFuncTestBase {
  protected DeeLangLexer mLexer;
  protected DeeLangParser mParser;

  protected CommonTree runTest(String testCode) throws ParserError {
    return Parser.staticParse(testCode);
  }
}
