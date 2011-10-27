/* Parser.java - Facade for the generated DeeLangParser.
 *
 * Copyright 2011 Ross Bamford (roscopeco AT gmail DOT com)
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License. 
 */
package com.roscopeco.deelang.parser;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;

import com.roscopeco.deelang.parser.DeeLangLexer;
import com.roscopeco.deelang.parser.DeeLangParser;

/**
 * <p>Facade class for the ANTLR generated DeeLangParser, providing a 
 * more convenient interface for parsing DeeLang code.</p>
 * 
 * <p><strong>This class is not thread safe!</strong></p>
 * 
 * @author rosco
 * @created 23 Oct 2011
 *
 */
public class Parser {
  private static final Parser staticParser = new Parser();
  
  /* Simple facade to parse a string... */
  public static CommonTree staticParse(String code) throws RecognitionException {
    return staticParser.parse(code);
  }
  
  public Parser() { };
  
  public CommonTree parse(String code) throws RecognitionException {
    DeeLangLexer lexer = new DeeLangLexer(new ANTLRStringStream(code));
    DeeLangParser parser = new DeeLangParser(new CommonTokenStream(lexer));
    return (CommonTree)parser.script().getTree();
  }
}
