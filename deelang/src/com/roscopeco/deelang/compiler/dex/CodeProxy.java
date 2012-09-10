package com.roscopeco.deelang.compiler.dex;

import java.util.ArrayDeque;
import java.util.ArrayList;

import com.google.dexmaker.BinaryOp;
import com.google.dexmaker.Code;
import com.google.dexmaker.Comparison;
import com.google.dexmaker.FieldId;
import com.google.dexmaker.Label;
import com.google.dexmaker.Local;
import com.google.dexmaker.MethodId;
import com.google.dexmaker.TypeId;
import com.google.dexmaker.UnaryOp;

/**
 * Proxy over the Dexmaker Code class. This simply caches all code generation
 * calls, while passing through all local allocation calls. Once the compile
 * pass is complete, the doGenerate method can be called to actually 
 * generate the code using the underlying Code instance.
 * 
 * This abstraction is necessary to allow easier allocation of locals during
 * the compile (since all locals must be allocated before any code generation
 * is performed on the Code object).
 * 
 * This would subclass Code, but that class is final. This does just as well.
 * 
 * @author Rosco
 */
final class CodeProxy {
  interface Instruction {
    public void generate();
  }
  
  
  final class ReturnVoid implements Instruction {
    public final void generate() {
      code.returnVoid();
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
  }
  
  private final ReturnVoid RETURNVOID = new ReturnVoid();
  
  Code code;
  final ArrayList<Instruction> insns = new ArrayList<Instruction>();
  
  public CodeProxy(Code code) {
    this.code = code;    
  }
  
  public final void doGenerate() {
    for (Instruction insn : insns) {
      insn.generate();
    }    
  }
  
  /* * CODE API * */
  final ArrayDeque<Local<?>> localsPool = new ArrayDeque<Local<?>>();
  
  @SuppressWarnings("unchecked")
  public final <T> Local<T> newLocal(TypeId<T> type) {
    if (localsPool.isEmpty()) {
      return code.newLocal(type);
    } else {
      return (Local<T>)localsPool.removeFirst();
    }
  }
  
  public final void freeLocal(Local<?> l) {
    localsPool.addFirst(l);
  }

  public final <T> Local<T> getParameter(int index, TypeId<T> type) {
    return code.getParameter(index, type);
  }

  public final <T> Local<T> getThis(TypeId<T> type) {
    return code.getThis(type);
  }

  public final void mark(Label label) {
  }

  public final void jump(Label target) {
  }

  public final void addCatchClause(TypeId<? extends Throwable> toCatch, Label catchClause) {
  }

  public final Label removeCatchClause(TypeId<? extends Throwable> toCatch) {
    // TODO implement this (LabelProxy?)
    return null;
  }

  public final void throwValue(Local<? extends Throwable> toThrow) {
  }

  public final <T> void loadConstant(Local<T> target, T value) {
    insns.add(new LoadConstant<T>(target, value));
  }

  public final <T> void move(Local<T> target, Local<T> source) {
  }

  // instructions: unary and binary

  public final <T> void op(UnaryOp op, Local<T> target, Local<T> source) {
  }

  public final <T> void op(BinaryOp op, Local<T> target, Local<T> a, Local<T> b) {
  }

  // instructions: branches

  public final <T> void compare(Comparison comparison, Label trueLabel, Local<T> a, Local<T> b) {
  }

  public final <T extends Number> void compareFloatingPoint(Local<Integer> target, 
                                                      Local<T> a, 
                                                      Local<T> b, 
                                                      int nanValue) {    
  }

  public final void compareLongs(Local<Integer> target, Local<Long> a, Local<Long> b) {
  }

  // instructions: fields

  public final <D, V> void iget(FieldId<D, V> fieldId, Local<V> target, Local<D> instance) {
    insns.add(new Iget<D,V>(fieldId, target, instance));    
  }

  public final <D, V> void iput(FieldId<D, V> fieldId, Local<D> instance, Local<V> source) {
  }

  public final <V> void sget(FieldId<?, V> fieldId, Local<V> target) {
  }

  public final <V> void sput(FieldId<?, V> fieldId, Local<V> source) {
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
  }

  public final void cast(Local<?> target, Local<?> source) {
    insns.add(new Cast(target, source));
  }

  // instructions: arrays

  public final <T> void arrayLength(Local<Integer> target, Local<T> array) {
  }

  public final <T> void newArray(Local<T> target, Local<Integer> length) {
  }

  public final void aget(Local<?> target, Local<?> array, Local<Integer> index) {
  }

  public final void aput(Local<?> array, Local<Integer> index, Local<?> source) {
  }

  // instructions: return

  public final void returnVoid() {
    insns.add(RETURNVOID);
  }

  public final void returnValue(Local<?> result) {
  }

  // instructions; synchronized

  public final void monitorEnter(Local<?> monitor) {
  }

  public final void monitorExit(Local<?> monitor) {
  }
}