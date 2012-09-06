package com.roscopeco.deelang.compiler.dex;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;

import org.antlr.runtime.tree.Tree;

import com.google.dexmaker.DexMaker;
import com.google.dexmaker.FieldId;
import com.google.dexmaker.Local;
import com.google.dexmaker.MethodId;
import com.google.dexmaker.TypeId;
import com.roscopeco.deelang.compiler.ASTVisitor;
import com.roscopeco.deelang.compiler.Compiler;
import com.roscopeco.deelang.compiler.CompilerError;
import com.roscopeco.deelang.compiler.StringEscapeUtils;
import com.roscopeco.deelang.compiler.UnsupportedError;
import com.roscopeco.deelang.runtime.Binding;
import com.roscopeco.deelang.runtime.CompiledScript;

import dee.lang.DeelangFloat;
import dee.lang.DeelangInteger;
import dee.lang.DeelangObject;
import dee.lang.DeelangString;

public class DexCompilationUnit extends ASTVisitor {
  private final Compiler compiler;
  
  private DexMaker dexMaker;
  private CodeProxy codeProxy;
  private final TypeId<?> compiledScriptTypeId;
  
  @SuppressWarnings("rawtypes")
  private final FieldId compiledScriptBindingFieldId;

  /* PUBLIC API */
  
  public DexCompilationUnit(Compiler compiler, String source) {
    this.compiler = compiler;
    dexMaker = new DexMaker();
    
    // TODO randomise the class name...
    compiledScriptTypeId = TypeId.get("LDexCompiledScript;");
    compiledScriptBindingFieldId = compiledScriptTypeId.getField(TYPEID_BINDING, "binding");
    
    dexMaker.declare(compiledScriptTypeId, source, Modifier.PUBLIC, TYPEID_COMPILEDSCRIPT);
    MethodId<?, Void> run = compiledScriptTypeId.getMethod(TypeId.VOID, "run");
    codeProxy = new CodeProxy(dexMaker.declare(run, Modifier.PUBLIC));
  }
  
  private byte[] codeCache;
  
  /**
   * Get the generated code for this compilation unit.
   * <br/>
   * This method generates the Dex bytecode for the compiled script. If the
   * code has already been generated, a cached copy is returned instead.
   * <br/>
   * Once this method has been called, the code will not be regenerated
   * by subsequent calls, and further calls to any of the ASTVisitor 
   * methods will have no effect.
   * 
   * @return The DEX bytecode.
   */
  public byte[] getCode() {
    if (codeCache == null) {
      codeProxy.returnVoid();
      codeProxy.doGenerate();
      
      codeCache = dexMaker.generate();

      // orphan all the generating stuff...
      codeProxy = null;
      dexMaker = null;
    }
    
    return codeCache;
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

  /* PROTECTED & INTERNAL API */
  protected static final TypeId<Binding> TYPEID_BINDING = TypeId.get(Binding.class);
  protected static final TypeId<CompiledScript> TYPEID_COMPILEDSCRIPT = TypeId.get(CompiledScript.class);
  
  protected static final TypeId<DeelangObject> TYPEID_DL_OBJECT = TypeId.get(DeelangObject.class);
  protected static final TypeId<DeelangInteger> TYPEID_DL_INTEGER = TypeId.get(DeelangInteger.class);
  protected static final TypeId<DeelangFloat> TYPEID_DL_FLOAT = TypeId.get(DeelangFloat.class);
  protected static final TypeId<DeelangString> TYPEID_DL_STRING = TypeId.get(DeelangString.class);
  
  protected static final FieldId<CompiledScript, Binding> FIELDID_COMPILEDSCRIPT_BINDING = 
      TYPEID_COMPILEDSCRIPT.getField(TYPEID_BINDING, "binding");
  
  protected static final MethodId<DeelangInteger, Void> DL_INTEGER_INIT = TYPEID_DL_INTEGER.getConstructor(TYPEID_BINDING, TypeId.INT);
  protected static final MethodId<DeelangFloat, Void> DL_FLOAT_INIT = TYPEID_DL_FLOAT.getConstructor(TYPEID_BINDING, TypeId.DOUBLE);
      
  /** 
   * Holds the local var name to slot mappings.
   */
  protected final HashMap<String, Local<?>> locals = new HashMap<String, Local<?>>();

  /**
   * <p>Used to pass data back to higher tree nodes during the compile.
   * This is used in different ways for different AST types, for example
   * the METHOD_CALL handler pushes an object that is then populated with
   * the arg count and blocks by the child ARGS, BLOCK and ORBLOCK nodes.
   * This object is then popped back in METHOD_CALL after children have
   * been visited, and used to write the count and fill in the relocations
   * for the blocks to the stream.</p>
   * 
   * <p>These are used with the <code>backPassData</code> stack. To 
   * maintain consistency of this stack during compilation, every 
   * visit call that pushes a frame to the stack before visiting 
   * children <strong>must</strong> pop that frame before it returns.
   */
  /* Implementation note: This way of passing data back to higher levels
   * was chosen over e.g. node-specific visitors to avoid the creation of
   * a potentially large number of throwaway visitor objects when 
   * compiling e.g. METHOD_CALL nodes.
   */
  protected abstract class BackPassFrame {
  }
    
  /**
   * BackPassFrame for METH_CALL opcode processing.
   */
  protected class MethCallBackPassData extends BackPassFrame {
    String methName;
    int argc;   // arg count
    int argi;   // current arg, -1 for none. 
    boolean selfCall;
    protected MethCallBackPassData(String name) { 
      this.methName = name; 
    }
  }
  
  /**
   * Stack of BackPassFrames used by the visitor implementation to 
   * pass data back from children to parents. 
   */
  protected ArrayDeque<BackPassFrame> backPassData = new ArrayDeque<BackPassFrame>();

  /**
   * Get the register for the specified var, or alloc the next available
   * if it's not in there.
   * 
   * @param varName The name of the local variable.
   * @return The allocated register.
   * @throws CompilerError to indicate that the maximum number of locals (255) has been exceeded.
   */
  protected Local<?> getOrAllocRegister(String varName) throws CompilerError {
    Local<?> reg;
    if ((reg = locals.get(varName)) == null) {
      // new register
      // What is max number of registers in Dex?
      //if (localCount == 255) {
      //  throw new MaxLocalsExceededException("Local variable limit exceeded");
      //} else {
        locals.put(varName, (reg = codeProxy.newLocal(TypeId.OBJECT)));
      //}
    }
    return reg;
  }
  
  private Local<Integer> accInt;
  private Local<Double> accDbl;
  private Local<Object> accObj;
  
  // This is commonly enough used that it gets is own register.
  private Local<Binding> accBinding;
  
  /**
   *  Get the 'accumulator' for int types, or create if not previously used 
   */
  protected Local<Integer> getAccInt() {
    if (accInt == null) {
      return accInt = codeProxy.newLocal(TypeId.INT);
    } else {
      return accInt;
    }
  }
  
  /** 
   * Get the 'accumulator' for double types, or create if not previously used 
   */
  protected Local<Double> getAccDbl() {
    if (accDbl == null) {
      return accDbl = codeProxy.newLocal(TypeId.DOUBLE);
    } else {
      return accDbl;
    }
  }
  
  /** 
   * Get the 'accumulator' for int types, or create if not previously used 
   */
  protected Local<Object> getAccObj() {
    if (accObj == null) {
      return accObj = codeProxy.newLocal(TypeId.OBJECT);
    } else {
      return accObj;
    }
  }
  
  /** 
   * Get the 'accumulator' for bindings, or create if not previously used 
   */
  protected Local<Binding> getAccBinding() {
    if (accBinding == null) {
      return accBinding = codeProxy.newLocal(TYPEID_BINDING);
    } else {
      return accBinding;
    }
  }
  
  private ArrayList<Local<Object>> argRegisters = new ArrayList<Local<Object>>();
  
  /**
   * Get the register for the specified method argument.
   */
  protected Local<Object> getArgRegister(int argi) {
    Local<Object> reg;
    
    if ((reg = argRegisters.get(argi)) == null) {
      argRegisters.add(reg = codeProxy.newLocal(TypeId.OBJECT));
    }
    
    return reg;
  }
  
  @SuppressWarnings("unchecked")
  private void generateIntLiteral(int value) {
    Local<Integer> li = getAccInt();
    Local<DeelangInteger> ldl = codeProxy.newLocal(TYPEID_DL_INTEGER);
    Local<Binding> binding = getAccBinding();
    
    codeProxy.loadConstant(li, value);
    
    // TODO should move this to start of method, since we're always gonna need it...
    // It can just stay in the binding register for the duration.
    codeProxy.iget(compiledScriptBindingFieldId, binding, codeProxy.getThis(compiledScriptTypeId));
    
    codeProxy.newInstance(ldl, DL_INTEGER_INIT, binding, li);
  }
  
  @Override
  protected void visitDecimalLiteral(Tree ast)
      throws CompilerError {   
    generateIntLiteral(Integer.parseInt(ast.getText()));
  }

  @Override
  protected void visitHexLiteral(Tree ast)
      throws CompilerError {
    generateIntLiteral(Integer.parseInt(ast.getText(), 16));
  }

  @Override
  protected void visitOctalLiteral(Tree ast)
      throws CompilerError {
    generateIntLiteral(Integer.parseInt(ast.getText(), 8));
  }

  @SuppressWarnings("unchecked")
  @Override
  protected void visitFloatLiteral(Tree ast)
      throws CompilerError {    
    Local<Double> ld = codeProxy.newLocal(TypeId.DOUBLE);
    Local<DeelangFloat> ldl = codeProxy.newLocal(TYPEID_DL_FLOAT);
    Local<Binding> binding = codeProxy.newLocal(TYPEID_BINDING);
    
    codeProxy.loadConstant (ld, Double.parseDouble(ast.getText()));
    codeProxy.iget(compiledScriptBindingFieldId, binding, codeProxy.getThis(compiledScriptTypeId));
    codeProxy.newInstance(ldl, DL_FLOAT_INIT, binding, ld);
  }

  @Override
  protected void visitCharacterLiteral(Tree ast)
      throws CompilerError {
    visitStringLiteral(ast);
  }
  

  @Override
  protected void visitStringLiteral(Tree ast)
      throws CompilerError {
    String value = ast.getText();
    codeProxy.loadConstant(codeProxy.newLocal(TypeId.STRING), 
        StringEscapeUtils.unescapeJava(value.substring(1,value.length()-1)));
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
    String method;
    Tree methodAST = ast.getChild(1);
    Tree receiverAST = ast.getChild(0);
    
    method = methodAST.getText();
    backPassData.addFirst(new MethCallBackPassData(method));
    this.compiler.visit(this, receiverAST);
    for (int i = 0; i < methodAST.getChildCount(); i++) {
      this.compiler.visit(this, methodAST.getChild(i));
    }
    MethCallBackPassData bpd = (MethCallBackPassData)backPassData.removeFirst();
    
    if (bpd.selfCall) {
      // TODO generate invokeSelf
    } else {
      // TODO generate invokeVirtual
    }
   
    /*
    writeBlock(strm, bpd.block);
    
    byte[] orblock;
    if ((orblock = bpd.orBlock).length > 0) {
      writeSizedOneExtra(strm, Opcodes.INVOKESELF_B, Opcodes.INVOKESELF_W, Opcodes.INVOKESELF_L,
          getOrAllocConstPoolIndex("or", CompiledScript.CONST_POOL_METHOD), (byte)0);
      writeBlock(strm, orblock);
    }*/
  }

  @Override
  protected void visitSelf(Tree ast)
      throws CompilerError {
    // TODO Auto-generated method stub
    
  }

  @Override
  protected void visitArgs(Tree ast)
      throws CompilerError {
    MethCallBackPassData mcbpd = (MethCallBackPassData)backPassData.getFirst();
    int argc = mcbpd.argc = ast.getChildCount();
    
    for (int i = 0; i < argc; i++) {
      mcbpd.argi = i;
      
    }
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
