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

import java.io.DataOutputStream;

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
  protected abstract void visitDecimalLiteral(DataOutputStream strm, Tree ast) throws CompilerError;
  protected abstract void visitHexLiteral(DataOutputStream strm, Tree ast) throws CompilerError;
  protected abstract void visitOctalLiteral(DataOutputStream strm, Tree ast) throws CompilerError;
  protected abstract void visitFloatLiteral(DataOutputStream strm, Tree ast) throws CompilerError;
  protected abstract void visitCharacterLiteral(DataOutputStream strm, Tree ast) throws CompilerError;
  protected abstract void visitStringLiteral(DataOutputStream strm, Tree ast) throws CompilerError;
  protected abstract void visitRegexpLiteral(DataOutputStream strm, Tree ast) throws CompilerError;
  
  protected abstract void visitChain(DataOutputStream strm, Tree ast) throws CompilerError;

  protected abstract void visitAssignLocal(DataOutputStream strm, Tree ast) throws CompilerError;
  protected abstract void visitIdentifier(DataOutputStream strm, Tree ast) throws CompilerError;

  protected abstract void visitAssignField(DataOutputStream strm, Tree ast) throws CompilerError;
  protected abstract void visitFieldAccess(DataOutputStream strm, Tree ast) throws CompilerError;
  
  protected abstract void visitMethodCall(DataOutputStream strm, Tree ast) throws CompilerError;
  protected abstract void visitSelf(DataOutputStream strm, Tree ast) throws CompilerError;
  protected abstract void visitArgs(DataOutputStream strm, Tree ast) throws CompilerError;
  protected abstract void visitBlock(DataOutputStream strm, Tree ast) throws CompilerError;
  protected abstract void visitOrBlock(DataOutputStream strm, Tree ast) throws CompilerError;
  
  protected abstract void visitAdd(DataOutputStream strm, Tree ast) throws CompilerError;
  protected abstract void visitSub(DataOutputStream strm, Tree ast) throws CompilerError;
  protected abstract void visitMul(DataOutputStream strm, Tree ast) throws CompilerError;
  protected abstract void visitDiv(DataOutputStream strm, Tree ast) throws CompilerError;
  protected abstract void visitMod(DataOutputStream strm, Tree ast) throws CompilerError;
  protected abstract void visitPow(DataOutputStream strm, Tree ast) throws CompilerError;
}
