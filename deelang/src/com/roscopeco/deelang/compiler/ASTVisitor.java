/* ASTVisitor.java - AST Visitor base-class.
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

import com.roscopeco.deelang.compiler.deevm.DVMCompilationUnit;
import com.roscopeco.deelang.parser.DeeLangParser;

/**
 * <p>Abstract base-class to be implemented by classes that are 
 * capable of visiting a DeeLang abstract syntax tree.</p>
 * 
 * <p>Implementations of this interface can be used with 
 * {@link Compiler} to perform actual compilation. The default
 * implementation is {@link DVMCompilationUnit}, which
 * creates the compiled script in the callback methods defined 
 * here.</p>
 * 
 * <p><strong>Note</strong>: Running this class with assertions enabled
 * will make it print debugging information!</p>
 * 
 * @author rosco
 * @created 19 Oct 2011
 *
 */
public abstract class ASTVisitor {
  protected abstract void visitDecimalLiteral(Tree ast) throws CompilerError;
  protected abstract void visitHexLiteral(Tree ast) throws CompilerError;
  protected abstract void visitOctalLiteral(Tree ast) throws CompilerError;
  protected abstract void visitFloatLiteral(Tree ast) throws CompilerError;
  protected abstract void visitCharacterLiteral(Tree ast) throws CompilerError;
  protected abstract void visitStringLiteral(Tree ast) throws CompilerError;
  protected abstract void visitRegexpLiteral(Tree ast) throws CompilerError;
  
  protected abstract void visitChain(Tree ast) throws CompilerError;

  protected abstract void visitAssignLocal(Tree ast) throws CompilerError;
  protected abstract void visitIdentifier(Tree ast) throws CompilerError;

  protected abstract void visitAssignField(Tree ast) throws CompilerError;
  protected abstract void visitFieldAccess(Tree ast) throws CompilerError;
  
  protected abstract void visitMethodCall(Tree ast) throws CompilerError;
  protected abstract void visitSelf(Tree ast) throws CompilerError;
  protected abstract void visitArgs(Tree ast) throws CompilerError;
  protected abstract void visitBlock(Tree ast) throws CompilerError;
  protected abstract void visitOrBlock(Tree ast) throws CompilerError;
  
  protected abstract void visitAdd(Tree ast) throws CompilerError;
  protected abstract void visitSub(Tree ast) throws CompilerError;
  protected abstract void visitMul(Tree ast) throws CompilerError;
  protected abstract void visitDiv(Tree ast) throws CompilerError;
  protected abstract void visitMod(Tree ast) throws CompilerError;
  protected abstract void visitPow(Tree ast) throws CompilerError;
  
  /* Helper to print debug info when assertions are on */
  private boolean debug(String log) {
    System.out.println(log);
    return true;
  }
  
  /* Helper to print debug info for visitor when assertions are on */
  private boolean debugVisitor(ASTVisitor unit, Tree ast) {
    return debug(" - VISIT: " + ast.toString() + " [" + DeeLangParser.tokenNames[ast.getType()] + "]");
  }
   
  /**
   * Cause this visitor to visit the specified AST node. 
   * 
   * @param ast
   * @throws CompilerError
   */
  public void visit(Tree ast) throws CompilerError {
    assert debugVisitor(this, ast);
    
    switch (ast.getType()) {
    /* ********** LITERALS ********** */
    case DeeLangParser.DECIMAL_LITERAL:
      visitDecimalLiteral(ast);
      return;
    case DeeLangParser.HEX_LITERAL:
      visitHexLiteral(ast);
      return;
    case DeeLangParser.OCTAL_LITERAL:
      visitOctalLiteral(ast);
      return;
    case DeeLangParser.FLOATING_POINT_LITERAL:
      visitFloatLiteral(ast);
      return;
    case DeeLangParser.CHARACTER_LITERAL:
      visitCharacterLiteral(ast);
      return;
    case DeeLangParser.STRING_LITERAL:
      visitStringLiteral(ast);
      return;
      
      
    /* ********** SPECIAL TOKEN FOR VAR AND METHOD ******* */
    case DeeLangParser.CHAIN:
      visitChain(ast);
      return;
      
      
    /* ********** VARIABLES ********** */
    case DeeLangParser.ASSIGN_FIELD:
      visitAssignField(ast);
      return;
      
    case DeeLangParser.ASSIGN_LOCAL:
      visitAssignLocal(ast);
      return;
      
    case DeeLangParser.IDENTIFIER:
      // var access
      visitIdentifier(ast);
      return;
      
    case DeeLangParser.FIELD_ACCESS:
      // member access
      visitFieldAccess(ast);
      return;

    /* ********** METHODS ********** */
    case DeeLangParser.METHOD_CALL:
      visitMethodCall(ast);
      return;
      
    case DeeLangParser.SELF:
      visitSelf(ast);
      return;

    case DeeLangParser.ARGS:
      visitArgs(ast);
      return;
      
    case DeeLangParser.BLOCK:
      visitBlock(ast);
      return;
      
    case DeeLangParser.ORBLOCK:
      visitOrBlock(ast);
      return;
      
      
    /* ********** ARITHMETIC ********** */
    case DeeLangParser.ADD:
      visitAdd(ast);
      return;
    case DeeLangParser.SUB:
      visitSub(ast);
      return;
    case DeeLangParser.MUL:
      visitMul(ast);
      return;
    case DeeLangParser.DIV:
      visitDiv(ast);
      return;
    case DeeLangParser.MOD:
      visitMod(ast);
      return;
    case DeeLangParser.POW:
      visitPow(ast);
      return;
    default:
      throw(new UnsupportedError("Unknown AST type: " + ast.getType()));
    }
  }
}
