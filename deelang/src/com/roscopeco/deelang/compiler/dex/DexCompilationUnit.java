package com.roscopeco.deelang.compiler.dex;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

import org.antlr.runtime.tree.Tree;

import com.google.dexmaker.Code;
import com.google.dexmaker.DexMaker;
import com.google.dexmaker.Label;
import com.google.dexmaker.Local;
import com.google.dexmaker.MethodId;
import com.google.dexmaker.TypeId;
import com.roscopeco.deelang.compiler.ASTVisitor;
import com.roscopeco.deelang.compiler.CompilerBug;
import com.roscopeco.deelang.compiler.CompilerError;
import com.roscopeco.deelang.compiler.StringEscapeUtils;
import com.roscopeco.deelang.compiler.UnsupportedError;
import com.roscopeco.deelang.parser.DeeLangParser;
import com.roscopeco.deelang.runtime.Binding;
import com.roscopeco.deelang.runtime.Block;
import com.roscopeco.deelang.runtime.CompiledScript;

import dee.lang.DeelangFloat;
import dee.lang.DeelangInteger;
import dee.lang.DeelangObject;
import dee.lang.DeelangString;

public class DexCompilationUnit extends ASTVisitor {
  private DexMaker dexMaker;
  CodeProxy codeProxy;
  final Binding binding;
  private final String sourceName;
  private final TypeId<? extends CompiledScript> compiledScriptTypeId;
  private final String compiledScriptName;
  private final Class<? extends DeelangObject> selfClz;

  /* PUBLIC API */
  
  public DexCompilationUnit(String sourceName, Class<? extends CompiledScript> superClass, Binding binding) {
    dexMaker = new DexMaker();
    
    // TODO UUID is probably overkill here, and may not be performant enough on Android?
    compiledScriptName = "DexCompiledScript" + UUID.randomUUID();
    compiledScriptTypeId = TypeId.get("L" + compiledScriptName + ";");
    
    this.binding = binding;
    this.selfClz = binding.getSelf().getClass();
    this.sourceName = sourceName;
    
    dexMaker.declare(compiledScriptTypeId, sourceName, Modifier.PUBLIC, TypeId.get(superClass));
    
    // Generate constructor
    MethodId<?, Void> init = compiledScriptTypeId.getConstructor(TYPEID_BINDING);
    Code initCode = dexMaker.declare(init, Modifier.PUBLIC);
    initCode.invokeDirect(COMPILEDSCRIPT_INIT, null, initCode.getThis(compiledScriptTypeId), initCode.getParameter(0, TYPEID_BINDING));
    initCode.returnVoid();
    
    // Declare run method and get a code proxy
    MethodId<?, Void> run = compiledScriptTypeId.getMethod(TypeId.VOID, "run", TYPEID_DL_OBJECT, TYPEID_BINDING);
    codeProxy = new CodeProxy(this, dexMaker.declare(run, Modifier.PUBLIC));
  }
  
  public DexCompilationUnit(String sourceName, Binding binding) {
    this(sourceName, CompiledScript.class, binding);
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
    return getScript(getClass().getClassLoader(), null);
  }
  
  public Class<? extends CompiledScript> getScript(ClassLoader loader) {
    return getScript(loader, null);
  }
  
  @SuppressWarnings("unchecked")
  public Class<? extends CompiledScript> getScript(ClassLoader loader, File dexDir) {
    // TODO revisit this, needs to be unified between getCode and getScript
    if (codeCache == null) {
      codeProxy.returnVoid();
      codeProxy.doGenerate();
      
      codeCache = dexMaker.generate();
    }
    
    try {
      return (Class<? extends CompiledScript>)
          dexMaker.generateAndLoad(loader, dexDir).loadClass(compiledScriptName);
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
  
  protected Binding getBinding() {
    return binding;
  }

  protected Class<? extends DeelangObject> getSelfClz() {
    return selfClz;
  }

  protected static final TypeId<Binding> TYPEID_BINDING = TypeId.get(Binding.class);
  protected static final TypeId<CompiledScript> TYPEID_COMPILEDSCRIPT = TypeId.get(CompiledScript.class);
  protected static final TypeId<Object[]> TYPEID_OBJECT_A = TypeId.get(Object[].class);
  protected static final TypeId<Block> TYPEID_BLOCK = TypeId.get(Block.class);
  
  protected static final TypeId<DeelangObject> TYPEID_DL_OBJECT = TypeId.get(DeelangObject.class);
  protected static final TypeId<DeelangInteger> TYPEID_DL_INTEGER = TypeId.get(DeelangInteger.class);
  protected static final TypeId<DeelangFloat> TYPEID_DL_FLOAT = TypeId.get(DeelangFloat.class);
  protected static final TypeId<DeelangString> TYPEID_DL_STRING = TypeId.get(DeelangString.class);

  protected static final MethodId<Binding, Object> BINDING_GET_LOCAL = TYPEID_BINDING.getMethod(TypeId.OBJECT, "getLocal", TypeId.STRING);
  protected static final MethodId<Binding, Void> BINDING_SET_LOCAL = TYPEID_BINDING.getMethod(TypeId.VOID, "getLocal", TypeId.STRING, TypeId.OBJECT);
  
  protected static final MethodId<CompiledScript, Void> COMPILEDSCRIPT_INIT = TYPEID_COMPILEDSCRIPT.getConstructor(TYPEID_BINDING);
  protected static final MethodId<Block, Void> BLOCK_INIT = TYPEID_BLOCK.getConstructor(TYPEID_DL_OBJECT, TYPEID_BINDING, TYPEID_OBJECT_A);
  
  protected static final MethodId<DeelangInteger, Void> DL_INTEGER_INIT = TYPEID_DL_INTEGER.getConstructor(TYPEID_BINDING, TypeId.INT);
  protected static final MethodId<DeelangFloat, Void> DL_FLOAT_INIT = TYPEID_DL_FLOAT.getConstructor(TYPEID_BINDING, TypeId.DOUBLE);
  protected static final MethodId<DeelangString, Void> DL_STRING_INIT = TYPEID_DL_STRING.getConstructor(TYPEID_BINDING, TypeId.STRING);

  protected static MethodId<DeelangObject, DeelangObject> DL_OBJECT_OPADD = TYPEID_DL_OBJECT.getMethod(TYPEID_DL_OBJECT, "__opADD", TYPEID_DL_OBJECT);
  protected static MethodId<DeelangObject, DeelangObject> DL_OBJECT_OPSUB = TYPEID_DL_OBJECT.getMethod(TYPEID_DL_OBJECT, "__opSUB", TYPEID_DL_OBJECT);
  protected static MethodId<DeelangObject, DeelangObject> DL_OBJECT_OPMUL = TYPEID_DL_OBJECT.getMethod(TYPEID_DL_OBJECT, "__opMUL", TYPEID_DL_OBJECT);
  protected static MethodId<DeelangObject, DeelangObject> DL_OBJECT_OPDIV = TYPEID_DL_OBJECT.getMethod(TYPEID_DL_OBJECT, "__opDIV", TYPEID_DL_OBJECT);
  protected static MethodId<DeelangObject, DeelangObject> DL_OBJECT_OPMOD = TYPEID_DL_OBJECT.getMethod(TYPEID_DL_OBJECT, "__opMOD", TYPEID_DL_OBJECT);
  protected static MethodId<DeelangObject, DeelangObject> DL_OBJECT_OPPOW = TYPEID_DL_OBJECT.getMethod(TYPEID_DL_OBJECT, "__opPOW", TYPEID_DL_OBJECT);
    
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
  protected static abstract class BackPassFrame { }
    
  /**
   * A generic backpass frame that gets the target register for something.
   *
   * TODO Currently, only used for binary ops, but could replace some other
   * backpass frames and other messy ways of tracking targets across
   * expressions...
   */
  protected final class TargetRegBackPassData extends BackPassFrame {
    @SuppressWarnings("rawtypes")
    public TypeRegisterMapping reg;
  }
  
  /**
   * BackPassFrame for METH_CALL processing.
   */
  protected final class MethCallBackPassData extends BackPassFrame {    
    protected final class Argument<T> {
      protected Class<T> jtype;
      protected TypeId<T> type;
      protected Local<T> reg;
      
      // Setting isTransient allows this register to be freed at the
      // end of the method call. Don't set this true for any args 
      // that are locals, or must otherwise be kept hanging around...
      protected boolean isTransient = false;
      
      /**
       * Used for non-transient register args (where we're supplying
       * the register).
       */
      public Argument(Class<T> jtype, Local<T> reg) {
        this.jtype = jtype;
        this.type = TypeId.get(jtype);
        this.reg = reg;
      }
                  
      /**
       * Used for transient-register args (i.e. literals etc) where
       * we'll allocate the register later, and can safely free it
       * after the method call.
       */
      public Argument(Class<T> jtype) {
        this(jtype, null);
        isTransient = true;
      }
                  
      public final String toString() {
        return type.toString();
      }
      
      public final Local<T> getArgRegister() {
        if (reg == null) {
          reg = codeProxy.newLocal(type);
        }
        
        return reg;
      }
    }
    
    String methName;
    int argc;   // arg count
    int argi;   // current arg, -1 for none.
    Argument<?>[] args;
    BlockBpd block;
    BlockBpd orBlock;
    
    protected MethCallBackPassData(String name) { 
      this.methName = name; 
      this.args = EMPTY_ARGS;
    }
  }

  /**
   * BackPassFrame for ASSIGN_LOCAL processing.
   * 
   * TODO merge this with TargetRegBackPassData
   */
  protected final class AssignLocalBackPassData extends BackPassFrame {
    TypeRegisterMapping<?> src;
  }
  
  /*
   * This is used when we're processing a block, to put a bit of
   * space between the calling MethCallBPD and anything that is done
   * in the block. It's effectively a marker for a 'new scope'.
   * 
   * It just gives the block a clean slate to work to, so e.g. 
   * method call arg types aren't checked against the calling method
   * etc.
   *
   * A better way to do this might be to put the backpass stack on
   * CodeProxy, and make CodeProxy a fully-fledged 'scope' object...
   */
  private static final class BackPassDataSpacer extends BackPassFrame { }
  
  private static final BackPassDataSpacer BACKPASSDATASPACER = new BackPassDataSpacer();
  
  private static final MethCallBackPassData.Argument<?>[] EMPTY_ARGS = new MethCallBackPassData.Argument[0];

  /**
   * Stack of BackPassFrames used by the visitor implementation to 
   * pass data back from children to parents. 
   */
  protected ArrayDeque<BackPassFrame> backPassData = new ArrayDeque<BackPassFrame>();
  
  // TODO These two methods should be rolled into one, this way of doing
  //      things isn't efficient...
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
  
  /**
   * Return the current AssignLocalBackPassData on top of the backpass
   * stack, or null if there is no frame/it isn't an AssignLocalBackPassData.
   */
  protected AssignLocalBackPassData getAssignLocalBackPassData() {
    BackPassFrame frame = backPassData.peekFirst();
    if (frame == null) {
      return null;
    } else {
      if (frame instanceof AssignLocalBackPassData) {
        return (AssignLocalBackPassData)frame;
      } else {
        return null;
      }
    }
  }
  
  /**
   * Return the current TargetRegBackPassData on top of the backpass
   * stack, or null if there is no frame/it isn't an TargetRegBackPassData.
   */
  protected TargetRegBackPassData getTargetRegBackPassData() {
    BackPassFrame frame = backPassData.peekFirst();
    if (frame == null) {
      return null;
    } else {
      if (frame instanceof TargetRegBackPassData) {
        return (TargetRegBackPassData)frame;
      } else {
        return null;
      }
    }
  }
  
  /**
   * Utility method to set the target register in the 
   * TargetRegBackPassData at the top of the backpass stack,
   * if there is one. 
   * 
   * Call this to inform any higher up expression that needs to
   * know the target register you're using.
   */
  protected <T> boolean setTargetReg(Local<T> reg, Class<T> jtype) {
    BackPassFrame f = backPassData.peekFirst();    
    if (f != null && f instanceof TargetRegBackPassData) {
      TargetRegBackPassData tr = (TargetRegBackPassData)f;
      tr.reg = new TypeRegisterMapping<T>(jtype, reg);      
      return true;
    }
    return false;
  }
  
  /**
   * Utility method to set the target register in the 
   * TargetRegBackPassData at the top of the backpass stack,
   * if there is one. 
   * 
   * Call this to inform any higher up expression that needs to
   * know the target register you're using.
   */
  protected <T> boolean setTargetReg(TypeRegisterMapping<T> mapping) {
    BackPassFrame f = backPassData.peekFirst();    
    if (f != null && f instanceof TargetRegBackPassData) {
      TargetRegBackPassData tr = (TargetRegBackPassData)f;
      tr.reg = mapping;
      return true;
    }
    return false;
  }
  
  private void generateIntLiteral(int value) {
    Local<DeelangInteger> ldl = null;
    
    MethCallBackPassData mcbpd = getMethCallBackPassData();
    if (mcbpd == null) {
      AssignLocalBackPassData albpd = getAssignLocalBackPassData();
      if (albpd != null) {
        // is RHS in an assignment
        // TODO this is a bit wasteful, the correct way to do this would be
        //      to initialize the literal directly in the local's register.
        //      Currently we initialize in a temp register, then visitAssignLocal
        //      generates a move instruction...
        ldl = codeProxy.newLocal(TYPEID_DL_INTEGER);
        albpd.src = new TypeRegisterMapping<DeelangInteger>(DeelangInteger.class, ldl);
      } else {
        TargetRegBackPassData trbpd = getTargetRegBackPassData();
        if (trbpd != null) {
          // Create the local. It actually gets notified to the TRBPD below...
          ldl = codeProxy.newLocal(TYPEID_DL_INTEGER);          
        } else {
          //      this is just a literal that gets created
          //      and never assigned or used. In that case, we 
          //      simply optimise it away...
        }
      }      
    } else {
      MethCallBackPassData.Argument<DeelangInteger> arg = mcbpd.new Argument<DeelangInteger>(DeelangInteger.class);
      mcbpd.args[mcbpd.argi] = arg;
      ldl = arg.getArgRegister();
    }
    
    if (ldl != null) {
      Local<Integer> li = codeProxy.newLocal(TypeId.INT);
      Local<Binding> binding = codeProxy.getRuntimeBindingRegister();
      
      codeProxy.loadConstant(li, value);
      codeProxy.newInstance(ldl, DL_INTEGER_INIT, binding, li);
      codeProxy.freeLocal(li);
      
      setTargetReg(ldl, DeelangInteger.class);
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
    Local<DeelangFloat> ldl = null;
    
    MethCallBackPassData mcbpd = getMethCallBackPassData();
    if (mcbpd == null) {
      AssignLocalBackPassData albpd = getAssignLocalBackPassData();
      if (albpd != null) {
        // is RHS in an assignment
        // TODO this is a bit wasteful, the correct way to do this would be
        //      to initialize the literal directly in the local's register.
        //      Currently we initialize in a temp register, then visitAssignLocal
        //      generates a move instruction...
        ldl = codeProxy.newLocal(TYPEID_DL_FLOAT);
        albpd.src = new TypeRegisterMapping<DeelangFloat>(DeelangFloat.class, ldl);
      } else {
        TargetRegBackPassData trbpd = getTargetRegBackPassData();
        if (trbpd != null) {
          // Create the local. It actually gets notified to the TRBPD below...
          ldl = codeProxy.newLocal(TYPEID_DL_FLOAT);          
        } else {
          //      this is just a literal that gets created
          //      and never assigned or used. In that case, we 
          //      simply optimise it away...
        }
      }      
    } else {
      MethCallBackPassData.Argument<DeelangFloat> arg = mcbpd.new Argument<DeelangFloat>(DeelangFloat.class);
      mcbpd.args[mcbpd.argi] = arg;
      ldl = arg.getArgRegister();
    }
    
    if (ldl != null) {
      Local<Double> ld = codeProxy.newLocal(TypeId.DOUBLE);
      Local<Binding> binding = codeProxy.getRuntimeBindingRegister();
      
      codeProxy.loadConstant(ld, Double.parseDouble(ast.getText()));
      codeProxy.newInstance(ldl, DL_FLOAT_INIT, binding, ld);
      codeProxy.freeLocal(ld);
      
      setTargetReg(ldl, DeelangFloat.class);
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
    Local<DeelangString> ldl = null;
    
    MethCallBackPassData mcbpd = getMethCallBackPassData();
    if (mcbpd == null) {
      AssignLocalBackPassData albpd = getAssignLocalBackPassData();
      if (albpd != null) {
        // is RHS in an assignment
        // TODO this is a bit wasteful, the correct way to do this would be
        //      to initialize the literal directly in the local's register.
        //      Currently we initialize in a temp register, then visitAssignLocal
        //      generates a move instruction...
        ldl = codeProxy.newLocal(TYPEID_DL_STRING);
        albpd.src = new TypeRegisterMapping<DeelangString>(DeelangString.class, ldl);
      } else {
        TargetRegBackPassData trbpd = getTargetRegBackPassData();
        if (trbpd != null) {
          // Create the local. It actually gets notified to the TRBPD below...
          ldl = codeProxy.newLocal(TYPEID_DL_STRING);          
        } else {
          //      this is just a literal that gets created
          //      and never assigned or used. In that case, we 
          //      simply optimise it away...
        }
      }      
    } else {
      MethCallBackPassData.Argument<DeelangString> arg = mcbpd.new Argument<DeelangString>(DeelangString.class);
      mcbpd.args[mcbpd.argi] = arg;
      ldl = arg.getArgRegister();
    }
    
    if (ldl != null) {
      Local<Object> ld = codeProxy.newLocal(TypeId.OBJECT);
      Local<Binding> binding = codeProxy.getRuntimeBindingRegister();
  
      String value = ast.getText();
      codeProxy.loadConstant(ld, StringEscapeUtils.unescapeJava(value.substring(1,value.length()-1)));
      codeProxy.newInstance(ldl, DL_STRING_INIT, binding, ld);
      codeProxy.freeLocal(ld);
      
      setTargetReg(ldl, DeelangString.class);
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
    throw new CompilerBug("CHAIN visited");
  }
  
  /**
   * Holds a type and a register. Used to track types through
   * the compiler (mostly types of locals).
   */
  protected final class TypeRegisterMapping<T> {
    protected Local<T> reg;
    protected Class<T> jtype;
    protected TypeId<T> type;
    
    /**
     * Used when just using this as a type/register mapping. 
     * Doesn't allocate any registers.
     */
    protected TypeRegisterMapping(Class<T> jtype, Local<T> reg) {
      this.jtype = jtype;
      this.reg = reg;
      this.type = TypeId.get(jtype);
    }
    
    /**
     * Used when mapping locals. Automatically allocates
     * the register.
     */
    protected TypeRegisterMapping(Class<T> jtype) {
      this.jtype = jtype;
      this.reg = codeProxy.newLocal(this.type = TypeId.get(jtype));
    }
  }
    
  @SuppressWarnings({ "unchecked", "rawtypes" })
  @Override
  protected void visitAssignLocal(Tree ast)
      throws CompilerError {
    String name = ast.getChild(0).getText();
    Tree expr = ast.getChild(1);
    TypeRegisterMapping lhs;
    
    // If we're in a block, we need to know that we've modified this
    // local if it's closed from the caller.
    BlockBpd bbpd;
    if ((bbpd = getBlockBpd()) != null) {
      // We need to do this if the name is valid, not only if it's mapped.
      // If it's valid but not loaded from the binding yet, we'll just have
      // to set it when we get back to the caller, without loading it
      // from the binding.
      if (bbpd.callerProxy.isLocalNameValid(name)) {
        // TODO this is pretty inefficient.....
        if (!bbpd.closedLocals.contains(name)) {
          bbpd.closedLocals.add(name);
        }
        bbpd.modifiedLocals.add(name);
      }
    }
    
    // Set up back pass data, then visit kids to get expression
    AssignLocalBackPassData bpd;
    backPassData.addFirst(bpd = new AssignLocalBackPassData());
    visit(expr);
    bpd = (AssignLocalBackPassData)backPassData.removeFirst();
    
    if (bpd.src == null) {
      throw new CompilerBug("No RHS in local assignment");
    } else {
      lhs = codeProxy.getOrAllocLocalRegister(bpd.src.jtype, name);
      codeProxy.move(lhs.reg, bpd.src.reg);
      codeProxy.freeLocal(bpd.src.reg);
    }
    
    MethCallBackPassData callermcbpd;
    if ((callermcbpd = getMethCallBackPassData()) != null) {
      // Assignment being used as method arg, so set that up...
      callermcbpd.args[callermcbpd.argi] = callermcbpd.new Argument(lhs.jtype, lhs.reg);
    } else if ((bpd = getAssignLocalBackPassData()) != null) {
      // Assignment is being chained with another assignment, set that up...
      bpd.src = lhs;
    }
    
    setTargetReg(lhs);
  }
  
  @SuppressWarnings({"rawtypes", "unchecked"})
  @Override
  protected void visitIdentifier(Tree ast)
      throws CompilerError {
    String name = ast.getText();
        
    // process the var load
    MethCallBackPassData mcbpd = getMethCallBackPassData();
    if (mcbpd == null) {
      AssignLocalBackPassData albpd = getAssignLocalBackPassData();
      if (albpd != null) {
        // is RHS in an assignment
        TypeRegisterMapping reg = codeProxy.getLocalRegister(name);
        
        if (reg != null) {
          albpd.src = reg;
        } else {
          throw new UnknownVariableException(ast.getText());
        }
      } else {
        TargetRegBackPassData trbpd = getTargetRegBackPassData();
        if (trbpd != null) {
          // someone higher up needs the reg (e.g. this is arithmetic expr)
          trbpd.reg = codeProxy.getLocalRegister(name);          
        } else {
          if (!codeProxy.isLocalNameValid(name)) {
            throw new UnknownVariableException(ast.getText());
          }
        }
      }
      
      // Local read but unused - generate nothing.
    } else {
      // method arg
      TypeRegisterMapping reg = codeProxy.getLocalRegister(name);
      
      if (reg != null) {
        MethCallBackPassData.Argument arg = mcbpd.new Argument(reg.jtype, reg.reg);
        mcbpd.args[mcbpd.argi] = arg;
      } else {
        throw new UnknownVariableException(ast.getText());
      }
    }
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

  private Method findMethodWithBlock(Class<?> clz, String name, MethCallBackPassData.Argument<?>[] args) {
    do {      
      outer: for (Method m : clz.getMethods()) {
        Class<?>[] paramTypes = m.getParameterTypes();
        if (m.getName().equals(name) && paramTypes.length == args.length + 1) {
          if (!paramTypes[0].equals(Block.class)) {
            // not a block for first arg
            continue outer;
          }
          
          for (int i = 0; i < args.length; i++) {
            if (!paramTypes[i+1].isAssignableFrom(args[i].jtype)) {
              // can't satisfy; loop again
              continue outer;            
            }
          }
          
          // if here, we got a match...
          return m;
        }
      }
      
      clz = clz.getSuperclass();

      // TODO eventually will support boxing to allow calling any method
      //      via type coercion. When that happens, this will need to continue
      //      until clz == null.
    } while (!clz.equals(Object.class));  // reached Object    
    
    return null;    
  }

  private static final TypeId<?>[] EMPTY_TIDS = new TypeId<?>[0]; 
  private static final Local<?>[] EMPTY_LOCALS = new Local<?>[0]; 
  
  private TypeId<?>[] mapClassesToTypes(MethCallBackPassData.Argument<?>[] clzs, boolean hasBlock) {
    int len = clzs.length;
    if (len == 0 && !hasBlock) {
      return EMPTY_TIDS;
    } else {
      TypeId<?>[] tids;
      if (!hasBlock) {
        tids = new TypeId<?>[len];
        for (int i = 0; i < len; i++) {
          tids[i] = TypeId.get(clzs[i].jtype);
        }
      } else {
        tids = new TypeId<?>[len+1];
        tids[0] = TYPEID_BLOCK;
        for (int i = 1; i <= len; i++) {
          tids[i] = TypeId.get(clzs[i-1].jtype);
        }
      }
      return tids;
    }
  }
  
  private Local<?>[] mapBpdArgsToLocals(MethCallBackPassData.Argument<?>[] args, Local<? extends Block> blockReg) {
    int len = args.length;
    if (len == 0 && blockReg == null) {
      return EMPTY_LOCALS;
    } else {
      Local<?>[] locs;
      if (blockReg == null) {
        locs = new Local<?>[len];
        for (int i = 0; i < len; i++) {
          locs[i] = args[i].getArgRegister();
        }
      } else {
        locs = new Local<?>[len+1];
        locs[0] = blockReg;
        for (int i = 1; i <= len; i++) {
          locs[i] = args[i-1].getArgRegister();
        }
      }
      return locs;
    }    
  }
  
  // NOTE: Any methods that make use of this field MUST make sure
  //       they unconditionally clear it to prevent stale references
  //       hanging around!
  private TypeRegisterMapping<?> lastChainReceiver;
  
  @SuppressWarnings({ "rawtypes", "unchecked" })
  @Override
  protected void visitMethodCall(Tree ast)
      throws CompilerError {
    String method;
    Tree methodAST = ast.getChild(1);
    Tree receiverAST = ast.getChild(0);
    method = methodAST.getText();
    Class<?> receiverClz; 
    Local receiverReg;    

    // Determine whether this is a self, chained or explicit receiver call
    if (receiverAST.getType() == DeeLangParser.SELF) {
      receiverClz = selfClz;
      receiverReg = codeProxy.getSelf();
    } else if (receiverAST.getType() == DeeLangParser.CHAIN) {
      if (lastChainReceiver == null) {
        throw new CompilerError("Cannot chain void method"); 
      } else {
        receiverReg = lastChainReceiver.reg;
        receiverClz = lastChainReceiver.jtype;
      }
    } else {
      String varName = receiverAST.getText();
      TypeRegisterMapping loc = codeProxy.getLocalRegister(varName);
      
      if (loc == null) {
        throw new UnknownVariableException(varName);
      }
      
      receiverClz = loc.jtype;
      receiverReg = loc.reg;            
    }
        
    // Set up back pass data, then visit kids to collate arg info
    MethCallBackPassData bpd;
    backPassData.addFirst(bpd = new MethCallBackPassData(method));
    for (int i = 0; i < methodAST.getChildCount(); i++) {
      visit(methodAST.getChild(i));
    }
    bpd = (MethCallBackPassData)backPassData.removeFirst();
    boolean hasBlock = (bpd.block != null);
    MethCallBackPassData callerbpd = getMethCallBackPassData();
    
    // Find method to call
    Method bindMethod;
    if (hasBlock) {
      bindMethod = findMethodWithBlock(receiverClz, method, bpd.args);
    } else {
      bindMethod = findMethod(receiverClz, method, bpd.args);
    }
    if (bindMethod == null) {
      if (hasBlock) {
        throw new CompilerError("Cannot bind method call '" + receiverClz.getName() + "." + method + "' with block and arguments " + Arrays.toString(bpd.args));
      } else {
        throw new CompilerError("Cannot bind method call '" + receiverClz.getName() + "." + method + "' and arguments " + Arrays.toString(bpd.args));        
      }
    }
    
    // Set up declaring class and return type
    Class<?> retClz;
    TypeId<?> decType = TypeId.get(bindMethod.getDeclaringClass());
    TypeId<?> retType = TypeId.get(retClz = bindMethod.getReturnType());
    
    // If we have a block, allocate it's register
    Local blockReg = null;
    if (hasBlock) {
      blockReg = codeProxy.newLocal(bpd.block.blockTypeId);
    }
    
    // Map arguments
    // TODO looping twice here through same data... 
    TypeId<?>[] argTypes = mapClassesToTypes(bpd.args, hasBlock);
    Local<?>[] args = mapBpdArgsToLocals(bpd.args, blockReg);
    
    MethodId mid = decType.getMethod(retType, method, argTypes);
    
    // Sort out where method return is going to go
    Local target;
    if (callerbpd != null) {
      if (void.class.equals(retClz)) {
        throw new IllegalMethodCallException("Void method '"+method+"' passed as argument to '"+callerbpd.methName+"'");
      } else {
        MethCallBackPassData.Argument arg = callerbpd.args[callerbpd.argi] = callerbpd.new Argument(retClz);
        target = arg.getArgRegister();
      }
    } else {
      AssignLocalBackPassData calleralbpd = getAssignLocalBackPassData();
      if (calleralbpd != null) {
        if (void.class.equals(retClz)) {
          throw new IllegalMethodCallException("Void method '"+method+"' called as RHS of assignment");
        } else {
          // Set up the target but don't return it to the pool yet.
          // The next insn generated should be the move done by AssignLocal,
          // which might realloc registers. After that, this target 
          // can safely be reused and will be freed in visitAssignLocal.
          //
          // TODO this is inefficient. Should really be returning directly to the
          //      LHS's register.
          target = codeProxy.newLocal(retType);
          calleralbpd.src = new TypeRegisterMapping(retClz, target);
        }
      } else {
        if (void.class.equals(retClz)) {
          target = null;
        } else {
          // Just transient (probably chained) so immediately return the target to the pool.
          // we cant ignore the return in case its part of a call chain...
          target = codeProxy.newLocal(retType);
          codeProxy.freeLocal(target);
        }
      }
    }
    setTargetReg(target, retClz);
    
    // Save the register and type in case the next instruction is chained.
    // TODO don't think this will always work. Need to get test coverage on this...
    //      We may need a stack, or stash it somewhere else or something...
    if (target != null) {
      lastChainReceiver = new TypeRegisterMapping(retClz, target);
    } else {
      lastChainReceiver = null;
    }
    
    // Generate code to initialize Block instance if needed
    if (hasBlock) {
      ArrayList<String> closedLocals = bpd.block.closedLocals; 
      int locsize = closedLocals.size();
      Local<Integer> bllen = codeProxy.newLocal(TypeId.INT);
      codeProxy.loadConstant(bllen, locsize);
      codeProxy.newArray(codeProxy.blockLocalsLocal(), bllen);
      for (int i = 0; i < locsize; i++) {
        codeProxy.loadConstant(bllen, i);
        codeProxy.aput(codeProxy.blockLocalsLocal(), bllen, codeProxy.getLocalRegister(closedLocals.get(i)).reg);        
      }
      codeProxy.newInstance(blockReg, bpd.block.blockTypeId.getConstructor(TYPEID_DL_OBJECT, TYPEID_BINDING, TYPEID_OBJECT_A), 
          codeProxy.getParameter(0, TYPEID_DL_OBJECT), 
          codeProxy.getParameter(1, TYPEID_BINDING), 
          codeProxy.blockLocalsLocal());
      codeProxy.freeLocal(bllen);
    }
    
    // Generate call insn
    codeProxy.invokeVirtual(mid, target, receiverReg, args);
    
    // Free arg registers for reuse
    // Return locals to the pool for reuse
    for (int i = 0; i < bpd.args.length; i++) {
      if (bpd.args[i].isTransient) {
        codeProxy.freeLocal(bpd.args[i].getArgRegister());
      }
    }
    
    // Unmarshal modified locals back into locals
    if (hasBlock) {
      ArrayList<String> modLocals = bpd.block.modifiedLocals; 
      int locsize = modLocals.size();
      if (locsize > 0) {
        Local<Integer> tempi = codeProxy.newLocal(TypeId.INT);
        Local<Object> tempo = codeProxy.newLocal(TypeId.OBJECT);
        for (int i = 0; i < locsize; i++) {
          codeProxy.loadConstant(tempi, i);
          codeProxy.aget(tempo, codeProxy.blockLocalsLocal(), tempi);
          codeProxy.cast(codeProxy.getLocalRegister(modLocals.get(i)).reg, tempo);
        }
        codeProxy.freeLocal(tempi);
        codeProxy.freeLocal(tempo);
      }
    }
    
    // TODO Or block support
   
  }

  @Override
  protected void visitSelf(Tree ast)
      throws CompilerError {
    throw new CompilerBug("SELF visited");
  }

  @Override
  protected void visitArgs(Tree ast)
      throws CompilerError {
    MethCallBackPassData mcbpd = (MethCallBackPassData)backPassData.getFirst();
    int argc = mcbpd.argc = ast.getChildCount();
    mcbpd.args = new MethCallBackPassData.Argument[argc];
    
    for (int i = 0; i < argc; i++) {
      mcbpd.argi = i;
      visit(ast.getChild(i));      
    }
  }
  
  // Keeps track of generated block numbers (incremental)
  private int blockNum = 0;
  
  // Special back pass stack for Block gen.
  // We can't use the same stack as for method call/assignment because
  // we need the enclosing block to always be at the top of the stack,
  // no matter what we're doing inside the block at the present time.
  // (e.g. var could be accessed during assignment).
  protected final class BlockBpd {
    public final CodeProxy callerProxy;
    public final ArrayList<String> closedLocals = new ArrayList<String>();
    public final ArrayList<String> modifiedLocals = new ArrayList<String>();
    public final TypeId<? extends Block> blockTypeId;
    
    protected BlockBpd(CodeProxy proxy, TypeId<? extends Block> blkTypeId) {
      this.callerProxy = proxy;
      this.blockTypeId = blkTypeId;
    }    
  }
  
  protected final ArrayDeque<BlockBpd> blockBackPassData = new ArrayDeque<BlockBpd>();
  
  protected BlockBpd getBlockBpd() {
    return blockBackPassData.peekFirst();
  }

  private BlockBpd generateBlock(Tree ast) throws CompilerError {
    backPassData.push(BACKPASSDATASPACER);
    
    TypeId<? extends Block> blkType = TypeId.get("Lcom/roscopeco/deelang/runtime/" + compiledScriptName + "$block" + blockNum++ + ";");
    dexMaker.declare(blkType, sourceName, Modifier.PUBLIC | Modifier.FINAL, TYPEID_BLOCK);

    blockBackPassData.push(new BlockBpd(codeProxy, blkType));
    
    // Generate constructor
    Code initCode = dexMaker.declare(blkType.getConstructor(TYPEID_DL_OBJECT, TYPEID_BINDING, TYPEID_OBJECT_A), Modifier.PUBLIC);
    initCode.invokeDirect(BLOCK_INIT, null, initCode.getThis(blkType), 
        initCode.getParameter(0, TYPEID_DL_OBJECT),
        initCode.getParameter(1, TYPEID_BINDING),
        initCode.getParameter(2, TYPEID_OBJECT_A));
    initCode.returnVoid();
    
    MethodId<?, Void> invoke = blkType.getMethod(TypeId.VOID, "invoke", TYPEID_DL_OBJECT, TYPEID_BINDING, TYPEID_OBJECT_A, TYPEID_OBJECT_A);
    codeProxy = new CodeProxy(this, dexMaker.declare(invoke, Modifier.PUBLIC | Modifier.FINAL));

    // generate method code with suitable jump to preload
    Label methStart = new Label();
    Label preloadStart = new Label();
    codeProxy.jump(preloadStart);
    codeProxy.mark(methStart);
    
    int ccount = ast.getChildCount();
    for (int i = 0; i < ccount; i++) {
      visit(ast.getChild(i));
    }
    BlockBpd blbpd = blockBackPassData.pop();
    
    // We will use the same array we were provided as a parameter with
    // the input locals, just overwriting the first N values with
    // whatever was modified. When breaking these parameters back out
    // into the callers locals, we'll know how many to do based on
    // the blbpd.modifiedLocals size...
    //
    // It is possible that the array isn't big enough (e.g. locals
    // passed in were bound but not loaded from binding), so we need
    // to check that and possibly realloc.    
    ArrayList<String> modLocals = blbpd.modifiedLocals;
    int len = modLocals.size();
    Local<Integer> aidx = codeProxy.newLocal(TypeId.INT);
    Local<Object[]> clAry = codeProxy.getParameter(2, TYPEID_OBJECT_A);
    
    if (len > blbpd.closedLocals.size()) {
      // Array won't be big enough. Realloc it.
      codeProxy.loadConstant(aidx, len);
      codeProxy.newArray(clAry, aidx);
    }
    
    for (int i = 0; i < len; i++) {
      codeProxy.loadConstant(aidx, i);
      codeProxy.aput(clAry, aidx, codeProxy.getLocalRegisterForUnmarshalling(modLocals.get(i)).reg);      
    }
    
    codeProxy.returnVoid();
    
    // preload locals at start of method
    // TODO there must be a better way to handle this...
    // Generate code to preload the closed locals
    
    // TODO this is gonna go wrong if the local's type is changed in the block!
    Local<Object> temp = null;
    codeProxy.mark(preloadStart);
    ArrayList<String> closedLocals = blbpd.closedLocals;
    len = closedLocals.size();
    if (len > 0) {
      temp = codeProxy.newLocal(TypeId.OBJECT);
    }
    for (int i = 0; i < len; i++) {
      codeProxy.loadConstant(aidx, i);
      codeProxy.aget(temp, clAry, aidx);
      codeProxy.cast(codeProxy.getLocalRegister(closedLocals.get(i)).reg, temp);
    }    
    if (temp != null) {
      codeProxy.freeLocal(temp);
    }
    codeProxy.freeLocal(aidx);
    codeProxy.freeLocal(clAry);
    codeProxy.jump(methStart);
    
    codeProxy.doGenerate();    
    codeProxy = blbpd.callerProxy;
    
    // remove spacer
    backPassData.pop();
    
    return blbpd;
  }
  
  @Override
  protected void visitBlock(Tree ast)
      throws CompilerError {
    MethCallBackPassData bpd = getMethCallBackPassData();
    if (bpd == null) {
      throw new CompilerBug("Block without method call");
    }
    bpd.block = generateBlock(ast);
  }
  
  @Override
  protected void visitOrBlock(Tree ast)
      throws CompilerError {
    MethCallBackPassData bpd = getMethCallBackPassData();
    if (bpd == null) {
      throw new CompilerBug("Block without method call");
    }
    bpd.orBlock = generateBlock(ast);
  }
    
  @SuppressWarnings("unchecked")
  protected void visitArithmeticExpression(Tree ast, MethodId<DeelangObject, DeelangObject> op) 
    throws CompilerError {
    @SuppressWarnings("rawtypes")
    TypeRegisterMapping lhs, rhs;
    TargetRegBackPassData trbpd = new TargetRegBackPassData();
    backPassData.push(trbpd);
    visit(ast.getChild(0));
    lhs = trbpd.reg;
    visit(ast.getChild(1));
    rhs = trbpd.reg;
    backPassData.removeFirst();
    
    // find target register
    MethCallBackPassData callerMcbpd;
    AssignLocalBackPassData callerAlbpd;
    Local<DeelangObject> target;
    if ((callerMcbpd = getMethCallBackPassData()) != null) {
      target = (Local<DeelangObject>)callerMcbpd.args[callerMcbpd.argi].reg;      
    } else {
      if ((callerAlbpd = getAssignLocalBackPassData()) != null) {
        target = (Local<DeelangObject>)callerAlbpd.src.reg;        
      } else {
        // just assign a new local
        trbpd = getTargetRegBackPassData();
        if (trbpd != null) {
          // someone higher up wants our target reg...
          target = codeProxy.newLocal(TYPEID_DL_OBJECT);
          setTargetReg(target, DeelangObject.class);
        } else {
          // don't store result anywhere, no-one's interested in it...
          // We can't optimise it away, in case the expression contained
          // method calls with side-effects...
          target = null;
        }
      }
    }
    
    codeProxy.invokeVirtual(op, target, lhs.reg, rhs.reg);
  }

  @Override
  protected void visitAdd(Tree ast) throws CompilerError {
    visitArithmeticExpression(ast, DL_OBJECT_OPADD);
  }
  
  @Override
  protected void visitSub(Tree ast) throws CompilerError {
    visitArithmeticExpression(ast, DL_OBJECT_OPSUB);
  }

  @Override
  protected void visitMul(Tree ast) throws CompilerError {
    visitArithmeticExpression(ast, DL_OBJECT_OPMUL);
  }

  @Override
  protected void visitDiv(Tree ast) throws CompilerError {
    visitArithmeticExpression(ast, DL_OBJECT_OPDIV);
  }

  @Override
  protected void visitMod(Tree ast) throws CompilerError {
    visitArithmeticExpression(ast, DL_OBJECT_OPMOD);
  }

  @Override
  protected void visitPow(Tree ast) throws CompilerError {
    visitArithmeticExpression(ast, DL_OBJECT_OPPOW);
  }
}
