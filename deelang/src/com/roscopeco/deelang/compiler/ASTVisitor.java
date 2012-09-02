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

/**
 * <p>Abstract base-class to be implemented by classes that are 
 * capable of visiting a DeeLang abstract syntax tree.</p>
 * 
 * <p>Implementations of this interface can be used with 
 * {@link Compiler} to perform actual compilation. The default
 * implementation is {@link Compiler.CompilationUnit}, which
 * creates the compiled script in the callback methods defined 
 * here.</p>
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
}
