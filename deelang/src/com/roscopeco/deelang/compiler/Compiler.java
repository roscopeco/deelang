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

import com.roscopeco.deelang.compiler.deevm.CompiledScript;
import com.roscopeco.deelang.compiler.deevm.DVMCompilationUnit;
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
  /**
   * Convenience method to just compile an AST to DVM Bytecode
   * and return the compiled script.
   * 
   * @param ast The AST to compile.
   * @return The compiled script.
   * @throws CompilerError If a compilation error occurs.
   */
  public static CompiledScript staticCompileDVM(Tree ast) throws CompilerError {
    return new Compiler().compileDVM(ast);
  }
  
  /**
   * Convenience method to just parse and compile a string to DVM Bytecode
   * and return the compiled script. This method uses the parser with 
   * default options.
   * 
   * @param code The code to compile.
   * @return The compiled script.
   * @throws ParserError If a parse error occurs.
   * @throws CompilerError If a compilation error occurs.
   */
  public static CompiledScript staticCompileDVM(String code) 
      throws ParserError, CompilerError {
    return staticCompileDVM(Parser.staticParse(code));
  }
  
  public Compiler() { }  
  
  /**
   * Compile the script in the supplied String by parsing it with {@link Parser}
   * and then compiling to a {@link CompiledScript}.  This is a convenience method 
   * that calls through to {@link #compile(ASTVisitor, Tree)} with a 
   * {@link DVMCompilationUnit}, and simply returns the compiled script.
   * 
   * @param code The Deelang code to compile.
   * @return The compiled script
   * @throws ParserError if an error occurs during parsing.
   * @throws CompilerError If an error occurs during compilation.
   */
  public CompiledScript compileDVM(String code) throws ParserError, CompilerError {
    return compileDVM(Parser.staticParse(code));
  }
  
  /**
   * Compile the script in the parsed AST (output from {@link Parser})
   * to a DVM {@link CompiledScript}. This is a convenience method that calls
   * through to {@link #compile(ASTVisitor, Tree)} with a 
   * {@link DVMCompilationUnit}, and simply returns the compiled script.
   * 
   * @param ast The AST to compile.
   * 
   * @return The compiled script
   * 
   * @throws CompilerError If an error occurs during compilation.
   */
  public CompiledScript compileDVM(Tree ast) throws CompilerError {
    return compile(new DVMCompilationUnit(), ast).buildScript();
  }
  
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
