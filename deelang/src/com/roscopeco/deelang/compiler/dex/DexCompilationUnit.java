package com.roscopeco.deelang.compiler.dex;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Modifier;

import org.antlr.runtime.tree.Tree;

import com.google.dexmaker.Code;
import com.google.dexmaker.DexMaker;
import com.google.dexmaker.MethodId;
import com.google.dexmaker.TypeId;
import com.roscopeco.deelang.compiler.ASTVisitor;
import com.roscopeco.deelang.compiler.CompilerError;
import com.roscopeco.deelang.compiler.UnsupportedError;

public class DexCompilationUnit extends ASTVisitor {
  private final DexMaker dexMaker;
  private final Code code;
  
  public DexCompilationUnit(String source) {
    dexMaker = new DexMaker();
    
    // TODO randomise the class name...
    TypeId<?> dexCompiledScript = TypeId.get("LDexCompiledScript;");
    TypeId<CompiledScript> compiledScript = TypeId.get(CompiledScript.class);
    
    dexMaker.declare(dexCompiledScript, source, Modifier.PUBLIC, compiledScript);
    MethodId<?, Void> run = dexCompiledScript.getMethod(TypeId.VOID, "run");
    code = dexMaker.declare(run, Modifier.PUBLIC);
  }
  
  public byte[] getCode() {
    return dexMaker.generate();    
  }
  
  public Class<? extends CompiledScript> getScript() {
    return getScript(null, null);
  }
  
  public Class<? extends CompiledScript> getScript(ClassLoader loader) {
    return getScript(loader, null);
  }
  
  @SuppressWarnings("unchecked")
  public Class<? extends CompiledScript> getScript(ClassLoader loader, File dexDir) {
    try {
      return (Class<? extends CompiledScript>)
          dexMaker.generateAndLoad(loader, dexDir).loadClass("DexCompiledScript");
    } catch (IOException e) {
      throw new RuntimeException("IOException while loading generated class", e);
    } catch (ClassNotFoundException e) {
      throw new RuntimeException("[BUG] Generated class not found in classloader : " + loader.toString(), e);
    }
  }
  
  public DexMaker getDexMaker() {
    return dexMaker;
  }

  @Override
  protected void visitDecimalLiteral(Tree ast)
      throws CompilerError {
    // TODO Auto-generated method stub
    
  }

  @Override
  protected void visitHexLiteral(Tree ast)
      throws CompilerError {
    // TODO Auto-generated method stub
    
  }

  @Override
  protected void visitOctalLiteral(Tree ast)
      throws CompilerError {
    // TODO Auto-generated method stub
    
  }

  @Override
  protected void visitFloatLiteral(Tree ast)
      throws CompilerError {    
    // TODO Auto-generated method stub
    
  }

  @Override
  protected void visitCharacterLiteral(Tree ast)
      throws CompilerError {
    visitStringLiteral(ast);
    // TODO Auto-generated method stub
    
  }
  

  @Override
  protected void visitStringLiteral(Tree ast)
      throws CompilerError {
    // TODO Auto-generated method stub
    
  }

  @Override
  protected void visitRegexpLiteral(Tree ast)
      throws CompilerError {
    throw new UnsupportedError("Regular expressions are not yet implemented");
  }

  @Override
  protected void visitChain(Tree ast)
      throws CompilerError {
    // TODO Auto-generated method stub
    
  }

  @Override
  protected void visitAssignLocal(Tree ast)
      throws CompilerError {
    // TODO Auto-generated method stub
    
  }

  @Override
  protected void visitIdentifier(Tree ast)
      throws CompilerError {
    // TODO Auto-generated method stub
    
  }

  @Override
  protected void visitAssignField(Tree ast)
      throws CompilerError {
    // TODO Auto-generated method stub
    
  }

  @Override
  protected void visitFieldAccess(Tree ast)
      throws CompilerError {
    // TODO Auto-generated method stub
    
  }

  @Override
  protected void visitMethodCall(Tree ast)
      throws CompilerError {
    // TODO Auto-generated method stub
    
  }

  @Override
  protected void visitSelf(Tree ast)
      throws CompilerError {
    // TODO Auto-generated method stub
    
  }

  @Override
  protected void visitArgs(Tree ast)
      throws CompilerError {
    // TODO Auto-generated method stub
    
  }

  @Override
  protected void visitBlock(Tree ast)
      throws CompilerError {
    // TODO Auto-generated method stub
    
  }

  @Override
  protected void visitOrBlock(Tree ast)
      throws CompilerError {
    // TODO Auto-generated method stub
    
  }

  @Override
  protected void visitAdd(Tree ast) throws CompilerError {
    // TODO Auto-generated method stub
    
  }

  @Override
  protected void visitSub(Tree ast) throws CompilerError {
    // TODO Auto-generated method stub
    
  }

  @Override
  protected void visitMul(Tree ast) throws CompilerError {
    // TODO Auto-generated method stub
    
  }

  @Override
  protected void visitDiv(Tree ast) throws CompilerError {
    // TODO Auto-generated method stub
    
  }

  @Override
  protected void visitMod(Tree ast) throws CompilerError {
    // TODO Auto-generated method stub
    
  }

  @Override
  protected void visitPow(Tree ast) throws CompilerError {
    // TODO Auto-generated method stub
    
  }
}
