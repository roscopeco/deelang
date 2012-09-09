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

import com.roscopeco.deelang.compiler.dvm.DVMCompilationUnit;
import com.roscopeco.deelang.compiler.dvm.CompiledScript;
import com.roscopeco.deelang.parser.DeeLangParser;
import com.roscopeco.deelang.parser.Parser;
import com.roscopeco.deelang.parser.ParserError;


/**
 * The DeeLang compiler. This class takes an AST output by
 * the DeeLang Parser and transforms it to a fully resolved,
 * compiled script in the format supported by the supplied
 * {@link ASTVisitor}.
 * <br/>
 * <strong>Note</strong>: Running this class with assertions enabled
 * will make it print debugging information!
 * 
 * @author rosco
 * @created 16 Oct 2011
 *
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
  
  /* Helper to print debug info when assertions are on */
  private boolean debug(String log) {
    System.out.println(log);
    return true;
  }
  
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
    return ((DVMCompilationUnit) compile(new DVMCompilationUnit(this), ast)).buildScript();
  }
  
  /**
   * Compile the script in the parsed AST (output from {@link Parser})
   * to a {@link CompiledScript}, using a custom {@link ASTVisitor}. This
   * allows you to hook into various stages of the compilation by overriding
   * methods by providing your own state subclass.
   * 
   * @param unit An implementation of {@link ASTVisitor} to use during compilation.
   * @param ast The AST to compile.
   * 
   * @return The visitor supplied to the method, for convenience.
   * 
   * @throws CompilerError If an error occurs during compilation.
   */
  public ASTVisitor compile(ASTVisitor unit, Tree ast) throws CompilerError {
    if (ast != null) {
      if (ast.getType() == 0) {
        // is multiple statement script
        assert debug("Compiling multi-line script");
        for (int i = 0; i < ast.getChildCount(); i++) {
          visit(unit, ast.getChild(i));
        }
      } else {
        // is single statement script
        assert debug("Compiling single line script");
        visit(unit, ast);
      }
    }
    return unit;
  }
  
  /* Helper to print debug info for visitor when assertions are on */
  private boolean debugVisitor(ASTVisitor unit, Tree ast) {
    return debug(" - VISIT: " + ast.toString() + " [" + DeeLangParser.tokenNames[ast.getType()] + "]");
  }
    
  public void visit(ASTVisitor unit, Tree ast) throws CompilerError {
    assert debugVisitor(unit, ast);
    
    switch (ast.getType()) {
    /* ********** LITERALS ********** */
    case DeeLangParser.DECIMAL_LITERAL:
      unit.visitDecimalLiteral(ast);
      return;
    case DeeLangParser.HEX_LITERAL:
      unit.visitHexLiteral(ast);
      return;
    case DeeLangParser.OCTAL_LITERAL:
      unit.visitOctalLiteral(ast);
      return;
    case DeeLangParser.FLOATING_POINT_LITERAL:
      unit.visitFloatLiteral(ast);
      return;
    case DeeLangParser.CHARACTER_LITERAL:
      unit.visitCharacterLiteral(ast);
      return;
    case DeeLangParser.STRING_LITERAL:
      unit.visitStringLiteral(ast);
      return;
      
      
    /* ********** SPECIAL TOKEN FOR VAR AND METHOD ******* */
    case DeeLangParser.CHAIN:
      unit.visitChain(ast);
      return;
      
      
    /* ********** VARIABLES ********** */
    case DeeLangParser.ASSIGN_FIELD:
      unit.visitAssignField(ast);
      return;
      
    case DeeLangParser.ASSIGN_LOCAL:
      unit.visitAssignLocal(ast);
      return;
      
    case DeeLangParser.IDENTIFIER:
      // var access
      unit.visitIdentifier(ast);
      return;
      
    case DeeLangParser.FIELD_ACCESS:
      // member access
      unit.visitFieldAccess(ast);
      return;

    /* ********** METHODS ********** */
    case DeeLangParser.METHOD_CALL:
      unit.visitMethodCall(ast);
      return;
      
    case DeeLangParser.SELF:
      unit.visitSelf(ast);
      return;

    case DeeLangParser.ARGS:
      unit.visitArgs(ast);
      return;
      
    case DeeLangParser.BLOCK:
      unit.visitBlock(ast);
      return;
      
    case DeeLangParser.ORBLOCK:
      unit.visitOrBlock(ast);
      return;
      
      
    /* ********** ARITHMETIC ********** */
    case DeeLangParser.ADD:
      unit.visitAdd(ast);
      return;
    case DeeLangParser.SUB:
      unit.visitSub(ast);
      return;
    case DeeLangParser.MUL:
      unit.visitMul(ast);
      return;
    case DeeLangParser.DIV:
      unit.visitDiv(ast);
      return;
    case DeeLangParser.MOD:
      unit.visitMod(ast);
      return;
    case DeeLangParser.POW:
      unit.visitPow(ast);
      return;
    default:
      throw(new UnsupportedError("Unknown AST type: " + ast.getType()));
    }
  }
}
