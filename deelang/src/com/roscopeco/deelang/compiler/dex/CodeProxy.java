/* CodeProxy.java
 *
 * Copyright 2012 Ross Bamford (roscopeco AT gmail DOT com)
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
package com.roscopeco.deelang.compiler.dex;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import com.google.dexmaker.BinaryOp;
import com.google.dexmaker.Code;
import com.google.dexmaker.Comparison;
import com.google.dexmaker.FieldId;
import com.google.dexmaker.Label;
import com.google.dexmaker.Local;
import com.google.dexmaker.MethodId;
import com.google.dexmaker.TypeId;
import com.google.dexmaker.UnaryOp;
import com.roscopeco.deelang.compiler.CompilerBug;
import com.roscopeco.deelang.compiler.dex.DexCompilationUnit.BlockBpd;
import com.roscopeco.deelang.runtime.DexBinding;

import dee.lang.DeelangObject;

/**
 * Proxy over the Dexmaker Code class. This simply caches all code generation
 * calls, while passing through all local allocation calls. Once the compile
 * pass is complete, the doGenerate method can be called to actually 
 * generate the code using the underlying Code instance.
 * 
 * This class encapsulates a 'scope' during code generation. As well as 
 * actual code generation it also handles local variables, chain receivers
 * and convenience registers (e.g. the type-cast 'self' register) for it's
 * given scope. Blocks 'invoke' methods are generated in separate proxies
 * to the main 'run' method, and have their own set of locals etc.
 * 
 * Please note that this class implements only a subset of the Dexmaker
 * 'Code' methods. Those that are unimplemented will throw an 
 * UnsupportedOperationException (and will be removed entirely eventually).
 * 
 * @author Rosco
 */ 
 /* This would subclass Code, but that class is final. This does just as well. */
final class CodeProxy {
  interface Instruction {
    public void generate();
  }

  // TODO remove all the toString methods in here. They're for debugging,
  //      and are never used at runtime, so they're just unnecessary bloat
  //      in the dex once debugging is done...
  
  final class ReturnVoid implements Instruction {
    public final void generate() {
      code.returnVoid();
    }
    
    public String toString() {
      return "RETURNVOID []";
    }
  }
  
  final class LoadConstant<T> implements Instruction {
    final Local<T> target;
    final T value;
    
    LoadConstant(Local<T> target, T value) {
      this.target = target;
      this.value = value;
    }

    @Override
    public final void generate() {
      code.loadConstant(target, value);
    }
    
    public String toString() {
      return "LOADCONSTANT [" + target + " = " + value + "]";
    }
  }
  
  final class Iget<D, V> implements Instruction {
    final FieldId<D, V> fieldId;
    final Local<V> target;
    final  Local<D> instance;
    
    Iget(FieldId<D, V> fieldId, Local<V> target, Local<D> instance) {
      this.fieldId = fieldId;
      this.target = target;
      this.instance = instance;
    }

    @Override
    public final void generate() {
      code.iget(fieldId, target, instance);
    }
    
    public String toString() {
      return "IGET [" + target + " = " + instance + "." + fieldId + "]";
    }
  }
  
  final class Iput<D, V> implements Instruction {
    final FieldId<D, V> fieldId;
    final Local<D> instance;
    final  Local<V> source;
    
    Iput(FieldId<D, V> fieldId, Local<D> instance, Local<V> source) {
      this.fieldId = fieldId;
      this.instance = instance;
      this.source = source;
    }

    @Override
    public final void generate() {
      code.iput(fieldId, instance, source);
    }
    
    public String toString() {
      return "IPUT [" + instance + "." + fieldId + " = " + source + "]";
    }
  }
  
  final class NewInstance<T> implements Instruction {
    final Local<T> target;
    final MethodId<T, Void> constructor;
    final Local<?>[] args;
    
    NewInstance(Local<T> target, MethodId<T, Void> constructor, Local<?>... args) {
      this.target = target;
      this.constructor = constructor;
      this.args = args;      
    }
    
    @Override
    public final void generate() {
      code.newInstance(target, constructor, args);
    }
    
    public String toString() {
      return "NEWINSTANCE [" + target + " = " + constructor + "(" + Arrays.toString(args) + ")]";
    }
  }
  
  final class Invoke<D, R> implements Instruction {
    public static final int KIND_DIRECT = 0;
    public static final int KIND_STATIC = 1;
    public static final int KIND_SUPER = 2;
    public static final int KIND_VIRTUAL = 3;
    public static final int KIND_INTERFACE = 4;
    
    final int kind;
    final MethodId<D, R> method;
    final Local<? super R> target;
    final Local<? extends D> instance;
    final Local<?>[] args;
    
    Invoke(int kind, MethodId<D, R> method, Local<? super R> target, Local<? extends D> instance, Local<?>... args) {
      this.kind = kind;
      this.method = method;
      this.target = target;
      this.instance = instance;
      this.args = args;
    }
    
    @Override
    public final void generate() {
      switch (kind) {
      case KIND_DIRECT:
        code.invokeDirect(method, target, instance, args);      
        break;
      case KIND_STATIC:
        code.invokeStatic(method, target, args);      
        break;
      case KIND_VIRTUAL:
        code.invokeVirtual(method, target, instance, args);      
        break;
      case KIND_INTERFACE:
        code.invokeInterface(method, target, instance, args);      
        break;
      case KIND_SUPER:
        code.invokeSuper(method, target, instance, args);      
        break;
      }
    }
    
    public String toString() {
      return "INVOKE("+kind+") [" + target + " = " + instance + "." + method + "(" + Arrays.toString(args) + ")]";
    }
  }
  
  final class Cast implements Instruction {
    final Local<?> target;
    final Local<?> source;
    
    Cast(Local<?> target, Local<?> source) {
      this.target = target;
      this.source = source;      
    }

    @Override
    public void generate() {
      code.cast(target, source);
    }
    
    public String toString() {
      return "CAST [" + target + " = (" + target.getType() + ")" + source + "]";
    }
  }
  
  final class Move<T> implements Instruction {
    final Local<T> target;
    final Local<T> source;
    
    Move(Local<T> target, Local<T> source) {
      this.target = target;
      this.source = source;
    }

    @Override
    public void generate() {
      code.move(target, source);
    }
  }
  
  final class Mark implements Instruction {
    final Label label;
    
    Mark(Label label) {
      this.label = label;
    }

    @Override
    public void generate() {
      code.mark(label);
    }
  }
  
  final class Jump implements Instruction {
    final Label label;
    
    Jump(Label label) {
      this.label = label;
    }

    @Override
    public void generate() {
      code.jump(label);
    }
  }
  
  final class NewArray implements Instruction {
    final Local<?> target;
    final Local<Integer> length;
    
    NewArray(Local<?> target, Local<Integer> length) {
      this.target = target;
      this.length = length;
    }

    @Override
    public void generate() {
      code.newArray(target, length);
    }
  }
  
  final class Aget implements Instruction {
    final Local<?> target;
    final Local<?> array;
    final Local<Integer> index;
    
    Aget(Local<?> target, Local<?> array, Local<Integer> index) {
      this.target = target;
      this.array = array;
      this.index = index;
    }

    @Override
    public void generate() {
      code.aget(target, array, index);
    }
  }
  
  final class Aput implements Instruction {
    final Local<?> array;
    final Local<Integer> index;
    final Local<?> source;
    
    Aput(Local<?> array, Local<Integer> index, Local<?> source) {
      this.array = array;
      this.index = index;
      this.source = source;
    }

    @Override
    public void generate() {
      code.aput(array, index, source);
    }
  }
  
  final class Compare<T> implements Instruction {
    final Comparison comparison;
    final Label trueLabel;
    final Local<T> a;
    final Local<T> b;
    
    Compare(Comparison comparison, Label trueLabel, Local<T> a, Local<T> b) {
      this.comparison = comparison;
      this.trueLabel = trueLabel;
      this.a = a;
      this.b = b;
    }

    @Override
    public void generate() {
      code.compare(comparison, trueLabel, a, b);
    }
  }
  
  private final ReturnVoid RETURNVOID = new ReturnVoid();
  
  final DexCompilationUnit unit;
  final Code code;
  final ArrayList<Instruction> insns = new ArrayList<Instruction>();
  TypeRegisterMapping<?> lastChainReceiver;
  
  private Local<? extends DeelangObject> actualSelfReg = null; 
  
  public CodeProxy(DexCompilationUnit unit, Code code) {
    this.unit = unit;
    this.code = code;    
  }
  
  public final void doGenerate() {
    for (Instruction insn : insns) {
      insn.generate();
    }    
  }
  
  /* General scope-related api */
  
  /**
   * Holds a type and a register. Used to track types through
   * the compiler (mostly types of locals).
   */
  public final class TypeRegisterMapping<T> {
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
      this.reg = newLocal(this.type = TypeId.get(jtype));
    }
  }
  
  /**
   * Save the given target as the receiver for future chained calls.
   * NOTE: Any methods that make use of this field MUST make sure
   * they unconditionally clear it to prevent stale references
   * hanging around!
   */
  public <T> void saveChainReceiver(Local<T> target, Class<T> clz) {
    // Save the register and type in case the next instruction is chained.
    if (target != null) {
      lastChainReceiver = new TypeRegisterMapping<T>(clz, target);
    } else {
      lastChainReceiver = null;
    }
  }
  
  public void clearChainReceiver() {
    lastChainReceiver = null;
  }
  
  public TypeRegisterMapping<?> getChainReceiver() {
    return lastChainReceiver;
  }  

  // LOCAL VAR MAPPING
  // *****************
  
  private final HashMap<String, TypeRegisterMapping<?>> localsMap = new HashMap<String, TypeRegisterMapping<?>>();
  
  /**
   * Returns true if the given name is actually mapped to a local register.
   */
  public boolean isLocalNameMapped(String name) {
    return localsMap.containsKey(name);    
  }
  
  /**
   * Returns true if the given name is valid (i.e. it is mapped to a 
   * register, or it exists in the binding).
   */
  public boolean isLocalNameValid(String name) {
    return (isLocalNameMapped(name) || (unit.getBinding().getLocal(name) != null));
  }

  /**
   * Get the register for the named local. If this local has not
   * previously been assigned, this method will look in the supplied
   * binding for it. If found there, code will be generated to allocate
   * a local register, and fetch the initial value from the binding.
   * 
   * @param dexCompilationUnit TODO
   * @param name The local name.
   * @return The register for the local.
   */
  @SuppressWarnings({"rawtypes"}) 
  public TypeRegisterMapping<?> getLocalRegister(String name) {
    TypeRegisterMapping loc = localsMap.get(name);
    
    if (loc == null) {
      /*
       * mark this as used if we have a block bpd, and it's
       * actually mapped in the caller. That way, we won't
       * waste time preloading vars that could be loaded
       * from the binding at the actual call-site.
       */
      BlockBpd blkbpd;
      if ((blkbpd = unit.getBlockBpd()) != null) {
        if (blkbpd.callerProxy.isLocalNameMapped(name)) {
          blkbpd.closedLocals.add(name);
          return getOrAllocLocalRegister(blkbpd.callerProxy.localsMap.get(name).jtype, name);
        }
      }    
      
      // nothing... try to get from the binding.
      Object o;
      if ((o = unit.binding.getLocal(name)) != null) {
        // first use of binding var - we need alloc it a register and copy it in...
        Local<String> temp = newLocal(TypeId.STRING);
        Local<Object> tempObj = newLocal(TypeId.OBJECT);
        loc = getOrAllocLocalRegister(o.getClass(), name);
        loadConstant(temp, name);
        invokeInterface(DexCompilationUnit.BINDING_GET_LOCAL, tempObj, getRuntimeBindingRegister(), temp);
        
        // TODO this is using registers inefficiently...
        cast(loc.reg, tempObj);
        freeLocal(tempObj);
        freeLocal(temp);          
      }         
    }
    
    return loc;
  }

  /**
   * Get the register for the named local. If the local does not have
   * a register, this method will allocate one. It's intended ONLY
   * for cases where we know a variable is valid, but may not have
   * been loaded from the binding yet, and where we don't actually
   * want to generate code to load it.
   * 
   * Note that this method <em>will</em> examine the binding for the
   * type of the variable if it has to allocate the register, but
   * will not generate any runtime code to load anything from the
   * binding.
   * 
   * This is generally useful in cases where we just want a register
   * for a known-valid variable, e.g. when unmarshalling modified 
   * locals back from a block. It is important that the executed 
   * block has been popped from the stack <em>before</em> calling
   * this method, to allow filtering up of any modified locals.
   * 
   * Package private because of it's specific use and potentially
   * unclear side effects :/ 
   */
  TypeRegisterMapping<?> getLocalRegisterForUnmarshalling(String name) {
    @SuppressWarnings("rawtypes")
    TypeRegisterMapping loc = localsMap.get(name);
    
    if (loc == null) {
      /*
       * mark this as used if we have a block bpd, and it's
       * actually mapped in the caller. That way, we won't
       * waste time preloading vars that could be loaded
       * from the binding at the actual call-site.
       */
      BlockBpd blkbpd;
      if ((blkbpd = unit.getBlockBpd()) != null) {
        if (blkbpd.callerProxy.isLocalNameMapped(name)) {
          blkbpd.modifiedLocals.add(name);
          return getOrAllocLocalRegister(blkbpd.callerProxy.localsMap.get(name).jtype, name);
        }
      }    
      
      // nothing... try to get from the binding.
      Object o;
      if ((o = unit.binding.getLocal(name)) != null) {
        loc = getOrAllocLocalRegister(o.getClass(), name);
      }        
    }
    
    return loc;
  }

  /**
   * Get the register for the named local. If this local does not
   * have a register, one will be allocated. This does not look
   * in the binding for the local - it is intended for use when
   * assigning locals.
   * 
   * @param dexCompilationUnit TODO
   * @param type The local's type
   * @param name The local's name
   * @return The register for the local.
   */
  @SuppressWarnings("unchecked")
  public <T> TypeRegisterMapping<T> getOrAllocLocalRegister(Class<T> type, String name) {
    TypeRegisterMapping<T> localMap;
    if ((localMap = (TypeRegisterMapping<T>)localsMap.get(name)) == null) {
      localsMap.put(name, localMap = new TypeRegisterMapping<T>(type));
    } else {
      // Make sure register can hold this type. Allocate a new register and ditch
      // the old one if not. 
      // Although we might be able to just reuse the register, this seems to generate
      // problems when generating certain dex instructions if the local type doesn't
      // match the actual type...
      if (!localMap.jtype.isAssignableFrom(type)) {
        localsMap.put(name, localMap = new TypeRegisterMapping<T>(type));
      }
    }
    return localMap;
  }

  public Local<? extends DeelangObject> getSelf() {
    return getParameter(0, DexCompilationUnit.TYPEID_DL_OBJECT);
  }

  /** 
   * Get the runtime Binding parameter. 
   */
  public Local<DexBinding> getRuntimeBindingRegister() {
    return getParameter(1, DexCompilationUnit.TYPEID_DEXBINDING);
  }

  /**
   * Get (or allocate) a register for the 'actual' self reference.
   * This is a reference to the self object that is type-casted to
   * it's actual type, rather than a generic DeelangObject.
   * 
   * This is necessary to allow method calls on the self object
   * that aren't defined by DeelangObject. Without it, loaded 
   * classes will not verify (as they are not strictly type-safe).
   * 
   * If this has not been previous allocated, a new register will
   * will be allocated, and code generated to cast the 'self' 
   * parameter into it.
   * 
   * @return
   */
  public Local<? extends DeelangObject> getTypeCastSelfReg(Class<? extends DeelangObject> selfClz) {
    // If we've not already generated a cast for the self object, we
    // need to do that now.
    if (actualSelfReg == null) {
      if (!DeelangObject.class.equals(selfClz)) {
        actualSelfReg = newLocal(TypeId.get(selfClz));
        cast(actualSelfReg, getSelf());
      } else {
        // No cast necessary, self is a straight DeelangObject anyway.
        actualSelfReg = getSelf();
      }        
    }
    
    return actualSelfReg;
  }

  
  /* * CODE API * */

  /* throw an UnsupportedOperationException. All code methods
   * that aren't implemented use this, in case we start using 
   * them in future and forget to implement the method...
   */
  private Object unimpl(String method) {
    throw new UnsupportedOperationException("'" + method + "' is not implemented on CodeProxy");
  }
  
  /* 
   * NOTE: Had to move back to a typed locals pool here, because 
   * dx doesn't like it when we reuse locals with different types,
   * as we were doing earlier. The platform seems to have no issue
   * with it, but certain operations (e.g. loadconst) cannot be
   * generated if we're trying to load e.g. an int into a register
   * that's typed for Object.
   * 
   * This does have the effect of upping the number of registers
   * in our generated methods. We may need to revisit this in order
   * to deal with that...
   */
  final HashMap<TypeId<?>, ArrayDeque<Local<?>>> localsPool = new HashMap<TypeId<?>, ArrayDeque<Local<?>>>();
  
  @SuppressWarnings("unchecked")
  public final <T> Local<T> newLocal(TypeId<T> type) {
    ArrayDeque<Local<?>> typedPool = localsPool.get(type);
    if (typedPool == null || typedPool.isEmpty()) {
      return code.newLocal(type);
    } else {
      return (Local<T>)typedPool.removeFirst();
    }
  }
  
  public final void freeLocal(Local<?> l) {
    ArrayDeque<Local<?>> typedPool = localsPool.get(l.getType());
    if (typedPool == null) {
      typedPool = new ArrayDeque<Local<?>>();
      localsPool.put(l.getType(), typedPool);
    }
    typedPool.addFirst(l);
  }
  
  private Local<Object[]> blockLocalsLocal;
  
  /**
   * Special case of newLocal that always returns the same local
   * (after allocating it first time). This is used for block method
   * arguments, of which there will only ever be one in any given
   * scope at any given time. Therefore, it's safe to keep it and
   * reuse it. 
   */
  public final Local<Object[]> blockLocalsLocal() {
    if (blockLocalsLocal == null) {
      blockLocalsLocal = newLocal(DexCompilationUnit.TYPEID_OBJECT_A);
    }
    return blockLocalsLocal;
  }

  public final <T> Local<T> getParameter(int index, TypeId<T> type) {
    return code.getParameter(index, type);
  }

  public final <T> Local<T> getThis(TypeId<T> type) {
    return code.getThis(type);
  }

  public final void mark(Label label) {
    insns.add(new Mark(label));
  }

  public final void jump(Label target) {
    insns.add(new Jump(target));
  }

  public final void addCatchClause(TypeId<? extends Throwable> toCatch, Label catchClause) {
    unimpl("addCatchClause");
  }

  public final Label removeCatchClause(TypeId<? extends Throwable> toCatch) {
    unimpl("removeCatchClause");
    return null;
  }

  public final void throwValue(Local<? extends Throwable> toThrow) {
    unimpl("addCatchClause");
  }

  public final <T> void loadConstant(Local<T> target, T value) {
    insns.add(new LoadConstant<T>(target, value));
  }

  public final <T> void move(Local<T> target, Local<T> source) {
    // Generating move instructions where source and target are equal
    // indicates we've messed up somewhere. It usually results in locals
    // being overwritten or other wierd behaviour later in the code.
    // For this reason, let's fail fast.
    if (target.equals(source)) {
      throw new CompilerBug("Won't generate move with same source and destination");
    }
    insns.add(new Move<T>(target, source));
  }

  // instructions: unary and binary

  public final <T> void op(UnaryOp op, Local<T> target, Local<T> source) {
    unimpl("op");
  }

  public final <T> void op(BinaryOp op, Local<T> target, Local<T> a, Local<T> b) {
    unimpl("op");
  }

  // instructions: branches

  public final <T> void compare(Comparison comparison, Label trueLabel, Local<T> a, Local<T> b) {
    insns.add(new Compare<T>(comparison, trueLabel, a, b));
  }

  public final <T extends Number> void compareFloatingPoint(Local<Integer> target, 
                                                      Local<T> a, 
                                                      Local<T> b, 
                                                      int nanValue) {
    unimpl("compareFloatingPoint");
  }

  public final void compareLongs(Local<Integer> target, Local<Long> a, Local<Long> b) {
    unimpl("compareLongs");
  }

  // instructions: fields

  public final <D, V> void iget(FieldId<D, V> fieldId, Local<V> target, Local<D> instance) {
    insns.add(new Iget<D,V>(fieldId, target, instance));    
  }

  public final <D, V> void iput(FieldId<D, V> fieldId, Local<D> instance, Local<V> source) {
    insns.add(new Iput<D,V>(fieldId, instance, source));
  }

  public final <V> void sget(FieldId<?, V> fieldId, Local<V> target) {
    unimpl("sget");
  }

  public final <V> void sput(FieldId<?, V> fieldId, Local<V> source) {
    unimpl("sput");
  }

  // instructions: invoke

  public final <T> void newInstance(Local<T> target, MethodId<T, Void> constructor, Local<?>... args) {
    insns.add(new NewInstance<T>(target, constructor, args));    
  }

  @SuppressWarnings({ "rawtypes", "unchecked" })
  public final <R> void invokeStatic(MethodId<?, R> method, Local<? super R> target, Local<?>... args) {
    insns.add(new Invoke(Invoke.KIND_STATIC, method, target, null, args));
  }

  public final <D, R> void invokeVirtual(MethodId<D, R> method, Local<? super R> target,
          Local<? extends D> instance, Local<?>... args) {
    insns.add(new Invoke<D, R>(Invoke.KIND_VIRTUAL, method, target, instance, args));
  }

  public final <D, R> void invokeDirect(MethodId<D, R> method, Local<? super R> target,
          Local<? extends D> instance, Local<?>... args) {
    insns.add(new Invoke<D, R>(Invoke.KIND_DIRECT, method, target, instance, args));
  }

  public final <D, R> void invokeSuper(MethodId<D, R> method, Local<? super R> target,
          Local<? extends D> instance, Local<?>... args) {
    insns.add(new Invoke<D, R>(Invoke.KIND_SUPER, method, target, instance, args));
  }

  public final <D, R> void invokeInterface(MethodId<D, R> method, Local<? super R> target,
          Local<? extends D> instance, Local<?>... args) {
    insns.add(new Invoke<D, R>(Invoke.KIND_INTERFACE, method, target, instance, args));
  }

  // instructions: types

  public final void instanceOfType(Local<?> target, Local<?> source, TypeId<?> type) {
    unimpl("instanceOfType");
  }

  public final void cast(Local<?> target, Local<?> source) {
    insns.add(new Cast(target, source));
  }

  // instructions: arrays

  public final <T> void arrayLength(Local<Integer> target, Local<T> array) {
    unimpl("arrayLength");
  }

  public final <T> void newArray(Local<T> target, Local<Integer> length) {
    insns.add(new NewArray(target, length));
  }

  public final void aget(Local<?> target, Local<?> array, Local<Integer> index) {
    insns.add(new Aget(target, array, index));
  }

  public final void aput(Local<?> array, Local<Integer> index, Local<?> source) {
    insns.add(new Aput(array, index, source));
  }

  // instructions: return

  public final void returnVoid() {
    insns.add(RETURNVOID);
  }

  public final void returnValue(Local<?> result) {
    unimpl("returnValue");
  }

  // instructions; synchronized

  public final void monitorEnter(Local<?> monitor) {
    unimpl("monitorEnter");
  }

  public final void monitorExit(Local<?> monitor) {
    unimpl("monitorExit");
  }  
}