package com.roscopeco.deelang.compiler.dex;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.UUID;

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
  private final Class<? extends DeelangObject> selfClz;

  /* PUBLIC API */
  
  public DexCompilationUnit(Compiler compiler, String sourceName, Class<? extends CompiledScript> superClass, Class<? extends DeelangObject> selfClz) {
    this.compiler = compiler;
    dexMaker = new DexMaker();
    
    // TODO UUID is probably overkill here, and may not be performant enough on Android?
    compiledScriptTypeId = TypeId.get("LDexCompiledScript" + UUID.randomUUID() + ";");
    
    this.selfClz = selfClz;
    
    dexMaker.declare(compiledScriptTypeId, sourceName, Modifier.PUBLIC, TypeId.get(superClass));
    MethodId<?, Void> run = compiledScriptTypeId.getMethod(TypeId.VOID, "run", TYPEID_DL_OBJECT, TYPEID_BINDING);
    codeProxy = new CodeProxy(dexMaker.declare(run, Modifier.PUBLIC));
  }
  
  public DexCompilationUnit(Compiler compiler, String sourceName, Class<? extends DeelangObject> selfClz) {
    this(compiler, sourceName, CompiledScript.class, selfClz);    
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
  
  /* PROTECTED & INTERNAL API */
  protected DexMaker getDexMaker() {
    return dexMaker;
  }

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
  protected static final MethodId<DeelangString, Void> DL_STRING_INIT = TYPEID_DL_STRING.getConstructor(TYPEID_BINDING, TypeId.STRING);
      
  /** 
   * Holds the local var name to slot mappings.
   */
  /*protected final HashMap<String, Local<?>> locals = new HashMap<String, Local<?>>();*/

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
  protected abstract class BackPassFrame { }
    
  /**
   * BackPassFrame for METH_CALL processing.
   */
  protected class MethCallBackPassData extends BackPassFrame {    
    protected class Argument<T> {
      Class<T> jtype;
      TypeId<T> type;
      
      public Argument(Class<T> jtype) {
        this.jtype = jtype;
        this.type = TypeId.get(jtype);
      }
      
      public String toString() {
        return type.toString();
      }
      
      @SuppressWarnings("unchecked")
      public Local<T> getArgRegister(int argi) {
        // TODO this is a complete mess. There are better ways to do this than the sparse array thing...
        SparseArrayList<Local<?>> typeRegs = argRegisters.get(type);
        Local<T> reg;
        
        if (typeRegs == null) {
          typeRegs = new SparseArrayList<Local<?>>();
          typeRegs.set(argi, reg = codeProxy.newLocal(type));
          argRegisters.put(type, typeRegs);
        } else {
          if ((argi >= typeRegs.size()) || (reg = (Local<T>)typeRegs.get(argi)) == null) {
            typeRegs.set(argi, reg = codeProxy.newLocal(type));
          }
        }
        
        return reg;
      }
    }
    
    private HashMap<TypeId<?>, SparseArrayList<Local<?>>> argRegisters = 
        new HashMap<TypeId<?>, SparseArrayList<Local<?>>>();
    
    String methName;
    int argc;   // arg count
    int argi;   // current arg, -1 for none.
    Argument<?>[] args;
    boolean selfCall;
    protected MethCallBackPassData(String name) { 
      this.methName = name; 
      this.args = EMPTY_ARGS;
    }
  }

  private static final MethCallBackPassData.Argument<?>[] EMPTY_ARGS = new MethCallBackPassData.Argument[0];

  /**
   * Stack of BackPassFrames used by the visitor implementation to 
   * pass data back from children to parents. 
   */
  protected ArrayDeque<BackPassFrame> backPassData = new ArrayDeque<BackPassFrame>();

  /**
   * Return the current MethCallBackPassData on top of the backpass
   * stack, or null if there is no frame/it isn't a MethCallBackPassData.
   */
  protected MethCallBackPassData getMethCallBackPassData() {
    BackPassFrame frame = backPassData.peekFirst();
    if (frame == null) {
      return null;
    } else {
      if (frame instanceof MethCallBackPassData) {
        return (MethCallBackPassData)frame;
      } else {
        return null;
      }
    }
  }
  
  protected Local<? extends DeelangObject> getSelf() {
    return codeProxy.getParameter(0, TYPEID_DL_OBJECT);
  }
  
  /** 
   * Get the Binding parameter. 
   */
  protected Local<Binding> getBinding() {
    return codeProxy.getParameter(1, TYPEID_BINDING);
  }
  
  private void generateIntLiteral(int value) {
    Local<DeelangInteger> ldl;
    boolean transientLocal = false;
    
    MethCallBackPassData mcbpd = getMethCallBackPassData();
    if (mcbpd == null) {
      // TODO check if is assignment or whatever...
      
      // TODO once we've checked if this is an assignment or
      //      whatever else might need this literal, we will
      //      know if it's just a literal that gets created
      //      and never assigned or used. In that case, we 
      //      could simply optimise it away...
      transientLocal = true;
      ldl = codeProxy.newLocal(TYPEID_DL_INTEGER);
    } else {
      MethCallBackPassData.Argument<DeelangInteger> arg = mcbpd.new Argument<DeelangInteger>(DeelangInteger.class);
      mcbpd.args[mcbpd.argi] = arg;
      ldl = arg.getArgRegister(mcbpd.argi);
    }
    
    Local<Integer> li = codeProxy.newLocal(TypeId.INT);
    Local<Binding> binding = getBinding();
    
    codeProxy.loadConstant(li, value);
    codeProxy.newInstance(ldl, DL_INTEGER_INIT, binding, li);
    codeProxy.freeLocal(li);
    if (transientLocal) {
      codeProxy.freeLocal(ldl);
    }
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

  @Override
  protected void visitFloatLiteral(Tree ast)
      throws CompilerError {    
    Local<DeelangFloat> ldl;
    boolean transientLocal = false;
    
    MethCallBackPassData mcbpd = getMethCallBackPassData();
    if (mcbpd == null) {
      // TODO See comments in visitIntLiteral
      transientLocal = true;
      ldl = codeProxy.newLocal(TYPEID_DL_FLOAT);      
    } else {
      MethCallBackPassData.Argument<DeelangFloat> arg = mcbpd.new Argument<DeelangFloat>(DeelangFloat.class);
      mcbpd.args[mcbpd.argi] = arg;
      ldl = arg.getArgRegister(mcbpd.argi);
    }
    
    Local<Double> ld = codeProxy.newLocal(TypeId.DOUBLE);
    Local<Binding> binding = getBinding();
    
    codeProxy.loadConstant(ld, Double.parseDouble(ast.getText()));
    codeProxy.newInstance(ldl, DL_FLOAT_INIT, binding, ld);
    codeProxy.freeLocal(ld);
    if (transientLocal) {
      codeProxy.freeLocal(ldl);
    }
  }

  @Override
  protected void visitCharacterLiteral(Tree ast)
      throws CompilerError {
    visitStringLiteral(ast);
  }
  

  @Override
  protected void visitStringLiteral(Tree ast)
      throws CompilerError {
    Local<DeelangString> ldl;
    boolean transientLocal = false;
    
    MethCallBackPassData mcbpd = getMethCallBackPassData();
    if (mcbpd == null) {
      // TODO use accumulator??!?
      transientLocal = true;
      ldl = codeProxy.newLocal(TYPEID_DL_STRING);
    } else {
      MethCallBackPassData.Argument<DeelangString> arg = mcbpd.new Argument<DeelangString>(DeelangString.class);
      mcbpd.args[mcbpd.argi] = arg;
      ldl = arg.getArgRegister(mcbpd.argi);
    }
    
    Local<Object> ld = codeProxy.newLocal(TypeId.OBJECT);
    Local<Binding> binding = getBinding();

    String value = ast.getText();
    codeProxy.loadConstant(ld, StringEscapeUtils.unescapeJava(value.substring(1,value.length()-1)));
    codeProxy.newInstance(ldl, DL_STRING_INIT, binding, ld);
    codeProxy.freeLocal(ld);
    if (transientLocal) {
      codeProxy.freeLocal(ldl);
    }
  }

  @Override
  protected void visitRegexpLiteral(Tree ast)
      throws CompilerError {
    throw new UnsupportedError("Regular expressions are not yet implemented");
  }

  @Override
  protected void visitChain(Tree ast)
      throws CompilerError {
    throw new UnsupportedError("Not yet implemented");
  }

  @Override
  protected void visitAssignLocal(Tree ast)
      throws CompilerError {
    throw new UnsupportedError("Not yet implemented");    
  }

  @Override
  protected void visitIdentifier(Tree ast)
      throws CompilerError {
    throw new UnsupportedError("Not yet implemented");
  }

  @Override
  protected void visitAssignField(Tree ast)
      throws CompilerError {
    throw new UnsupportedError("Not yet implemented");
  }

  @Override
  protected void visitFieldAccess(Tree ast)
      throws CompilerError {
    throw new UnsupportedError("Not yet implemented");
  }

  // TODO this is only returning FIRST match, not necessarily BEST match!
  private Method findMethod(Class<?> clz, String name, MethCallBackPassData.Argument<?>[] args) {
    do {
      outer: for (Method m : clz.getMethods()) {
        Class<?>[] paramTypes = m.getParameterTypes();
        if (m.getName().equals(name) && paramTypes.length == args.length) {
          for (int i = 0; i < args.length; i++) {
            if (!paramTypes[i].isAssignableFrom(args[i].jtype)) {
              // can't satisfy; loop again
              continue outer;            
            }
          }
          
          // if here, we got a match...
          return m;
        }
      }
      
      clz = clz.getSuperclass();
    } while (clz != null);  // reached Object
    
    return null;    
  }

  private static final TypeId<?>[] EMPTY_TIDS = new TypeId<?>[0]; 
  private static final Local<?>[] EMPTY_LOCALS = new Local<?>[0]; 
  
  private TypeId<?>[] mapClassesToTypes(MethCallBackPassData.Argument<?>[] clzs) {
    int len = clzs.length;
    if (len == 0) {
      return EMPTY_TIDS;
    } else {
      TypeId<?>[] tids = new TypeId<?>[len];
      for (int i = 0; i < len; i++) {
        tids[i] = TypeId.get(clzs[i].jtype);
      }
      return tids;
    }
  }
  
  private Local<?>[] mapBpdArgsToLocals(MethCallBackPassData.Argument<?>[] args) {
    int len = args.length;
    if (len == 0) {
      return EMPTY_LOCALS;
    } else {
      Local<?>[] locs = new Local<?>[len];
      for (int i = 0; i < len; i++) {
        locs[i] = args[i].getArgRegister(i);
      }
      return locs;
    }    
  }
  
  @SuppressWarnings({ "rawtypes", "unchecked" })
  @Override
  protected void visitMethodCall(Tree ast)
      throws CompilerError {
    String method;
    Tree methodAST = ast.getChild(1);
    Tree receiverAST = ast.getChild(0);
    
    method = methodAST.getText();
    MethCallBackPassData bpd;
    backPassData.addFirst(bpd = new MethCallBackPassData(method));
    this.compiler.visit(this, receiverAST);
    for (int i = 0; i < methodAST.getChildCount(); i++) {
      this.compiler.visit(this, methodAST.getChild(i));
    }
    bpd = (MethCallBackPassData)backPassData.removeFirst();
    MethCallBackPassData callerbpd = getMethCallBackPassData();
        
    if (bpd.selfCall) {
      Method bindMethod = findMethod(selfClz, method, bpd.args);
      if (bindMethod == null) {
        throw new CompilerError("Cannot bind method call '" + selfClz.getName() + "." + method + "' with arguments " + Arrays.toString(bpd.args));
      }
      
      Class<?> retClz;
      TypeId<?> decType = TypeId.get(bindMethod.getDeclaringClass());
      TypeId<?> retType = TypeId.get(retClz = bindMethod.getReturnType());
      
      // TODO looping twice here through same data... 
      TypeId<?>[] argTypes = mapClassesToTypes(bpd.args);
      Local<?>[] args = mapBpdArgsToLocals(bpd.args);
      
      MethodId mid = decType.getMethod(retType, method, argTypes);
      
      Local target;
      if (callerbpd != null) {
        if (void.class.equals(retClz)) {
          throw new CompilerError("Void method '"+method+"' passed as argument to '"+callerbpd.methName+"'");
        } else {
          MethCallBackPassData.Argument arg = callerbpd.args[callerbpd.argi] = callerbpd.new Argument(retClz);
          target = arg.getArgRegister(callerbpd.argi);
        }
      } else {
        if (void.class.equals(retClz)) {
          target = null;
        } else {
          target = codeProxy.newLocal(retType);
        }
      }
      codeProxy.invokeVirtual(mid, target, getSelf(), args);
    } else {
      // TODO generate invokeVirtual
      throw new UnsupportedError("Explicit receiver not yet supported");
    }
    
    // TODO could probably get rid of indexed arg map now?
    //      Failing that, copy args into a local before looping...
    // Return locals to the pool for reuse
    for (int i = 0; i < bpd.args.length; i++) {
      codeProxy.freeLocal(bpd.args[i].getArgRegister(i));
    }
    
    // TODO block support
   
  }

  @Override
  protected void visitSelf(Tree ast)
      throws CompilerError {
    MethCallBackPassData mcbpd = (MethCallBackPassData)backPassData.getFirst();
    mcbpd.selfCall = true;    
  }

  @Override
  protected void visitArgs(Tree ast)
      throws CompilerError {
    MethCallBackPassData mcbpd = (MethCallBackPassData)backPassData.getFirst();
    int argc = mcbpd.argc = ast.getChildCount();
    mcbpd.args = new MethCallBackPassData.Argument[argc];
    
    for (int i = 0; i < argc; i++) {
      mcbpd.argi = i;
      compiler.visit(this, ast.getChild(i));      
    }
  }

  @Override
  protected void visitBlock(Tree ast)
      throws CompilerError {
    throw new UnsupportedError("Not yet implemented");
  }

  @Override
  protected void visitOrBlock(Tree ast)
      throws CompilerError {
    throw new UnsupportedError("Not yet implemented");
  }

  @Override
  protected void visitAdd(Tree ast) throws CompilerError {
    throw new UnsupportedError("Not yet implemented");
  }

  @Override
  protected void visitSub(Tree ast) throws CompilerError {
    throw new UnsupportedError("Not yet implemented");
  }

  @Override
  protected void visitMul(Tree ast) throws CompilerError {
    throw new UnsupportedError("Not yet implemented");
  }

  @Override
  protected void visitDiv(Tree ast) throws CompilerError {
    throw new UnsupportedError("Not yet implemented");
  }

  @Override
  protected void visitMod(Tree ast) throws CompilerError {
    throw new UnsupportedError("Not yet implemented");
  }

  @Override
  protected void visitPow(Tree ast) throws CompilerError {
    throw new UnsupportedError("Not yet implemented");
  }
}
