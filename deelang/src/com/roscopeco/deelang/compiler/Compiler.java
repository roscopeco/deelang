/* Compiler.java - The DeeLang compiler.
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
package com.roscopeco.deelang.compiler;

import org.antlr.runtime.tree.Tree;

import com.roscopeco.deelang.parser.Parser;
import com.roscopeco.deelang.parser.ParserError;

/**
 * The DeeLang compiler. This class takes an AST output by
 * the DeeLang Parser and transforms it to a fully resolved,
 * compiled script in the format supported by the supplied
 * {@link ASTVisitor}.
 * 
 * @author rosco
 * @created 16 Oct 2011
 */
public class Compiler {  
  public Compiler() { }  
  
  /**
   * Compile the script in the supplied String by parsing it with {@link Parser}
   * and then compiling with the supplied {@link ASTVisitor}.  This is a 
   * convenience method that calls through to {@link #compile(ASTVisitor, Tree)},
   * parsing the code with {@link Parser#staticParse(String)}. 
   * 
   * @param unit An implementation of {@link ASTVisitor} to use during compilation.
   * @param code The Deelang code to compile.
   * 
   * @return The visitor supplied to the method, for convenience.
   * 
   * @throws ParserError if an error occurs during parsing.
   * @throws CompilerError If an error occurs during compilation.
   */
  public <T extends ASTVisitor> T compile(T unit, String code) throws ParserError, CompilerError {
    return compile(unit, Parser.staticParse(code));    
  }
  
  /**
   * Compile the script in the supplied String by parsing it with {@link Parser}
   * and then compiling with the supplied {@link ASTVisitor}.
   * 
   * @param unit An implementation of {@link ASTVisitor} to use during compilation.
   * @param ast The AST to compile.
   * 
   * @return The visitor supplied to the method, for convenience.
   * 
   * @throws CompilerError If an error occurs during compilation.
   */
  public <T extends ASTVisitor> T compile(T unit, Tree ast) throws CompilerError {
    if (ast != null) {
      if (ast.getType() == 0) {
        // is multiple statement script
        for (int i = 0; i < ast.getChildCount(); i++) {
          unit.visit(ast.getChild(i));
        }
      } else {
        // is single statement script
        unit.visit(ast);
      }
    }
    return unit;
  }  
}
