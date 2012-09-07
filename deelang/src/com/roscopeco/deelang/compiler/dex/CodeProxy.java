package com.roscopeco.deelang.compiler.dex;

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
  
  
  class ReturnVoid implements Instruction {
    public void generate() {
      code.returnVoid();
    }
  }
  
  class LoadConstant<T> implements Instruction {
    final Local<T> target;
    final T value;
    
    LoadConstant(Local<T> target, T value) {
      this.target = target;
      this.value = value;
    }

    @Override
    public void generate() {
      code.loadConstant(target, value);
    }
  }
  
  class Iget<D, V> implements Instruction {
    final FieldId<D, V> fieldId;
    final Local<V> target;
    final  Local<D> instance;
    
    Iget(FieldId<D, V> fieldId, Local<V> target, Local<D> instance) {
      this.fieldId = fieldId;
      this.target = target;
      this.instance = instance;
    }

    @Override
    public void generate() {
      code.iget(fieldId, target, instance);
    }
  }
  
  class NewInstance<T> implements Instruction {
    final Local<T> target;
    final MethodId<T, Void> constructor;
    final Local<?>[] args;
    
    NewInstance(Local<T> target, MethodId<T, Void> constructor, Local<?>... args) {
      this.target = target;
      this.constructor = constructor;
      this.args = args;      
    }
    
    @Override
    public void generate() {
      code.newInstance(target, constructor, args);
    }
  }
  
  class InvokeVirtual<D, R> implements Instruction {
    final MethodId<D, R> method;
    final Local<? super R> target;
    final Local<? extends D> instance;
    final Local<?>[] args;
    
    InvokeVirtual(MethodId<D, R> method, Local<? super R> target, Local<? extends D> instance, Local<?>... args) {
      this.method = method;
      this.target = target;
      this.instance = instance;
      this.args = args;
    }
    
    @Override
    public void generate() {
      code.invokeVirtual(method, target, instance, args);      
    }
  }

  private final ReturnVoid RETURNVOID = new ReturnVoid();
  
  Code code;
  ArrayList<Instruction> insns = new ArrayList<Instruction>();
  
  public CodeProxy(Code code) {
    this.code = code;    
  }
  
  public void doGenerate() {
    for (Instruction insn : insns) {
      insn.generate();
    }    
  }
  
  /* * CODE API * */
  public <T> Local<T> newLocal(TypeId<T> type) {
    return code.newLocal(type);
  }

  public <T> Local<T> getParameter(int index, TypeId<T> type) {
    return code.getParameter(index, type);
  }

  public <T> Local<T> getThis(TypeId<T> type) {
    return code.getThis(type);
  }

  public void mark(Label label) {
  }

  public void jump(Label target) {
  }

  public void addCatchClause(TypeId<? extends Throwable> toCatch, Label catchClause) {
  }

  public Label removeCatchClause(TypeId<? extends Throwable> toCatch) {
    // TODO implement this (LabelProxy?)
    return null;
  }

  public void throwValue(Local<? extends Throwable> toThrow) {
  }

  public <T> void loadConstant(Local<T> target, T value) {
    insns.add(new LoadConstant<T>(target, value));
  }

  public <T> void move(Local<T> target, Local<T> source) {
  }

  // instructions: unary and binary

  public <T> void op(UnaryOp op, Local<T> target, Local<T> source) {
  }

  public <T> void op(BinaryOp op, Local<T> target, Local<T> a, Local<T> b) {
  }

  // instructions: branches

  public <T> void compare(Comparison comparison, Label trueLabel, Local<T> a, Local<T> b) {
  }

  public <T extends Number> void compareFloatingPoint(Local<Integer> target, 
                                                      Local<T> a, 
                                                      Local<T> b, 
                                                      int nanValue) {    
  }

  public void compareLongs(Local<Integer> target, Local<Long> a, Local<Long> b) {
  }

  // instructions: fields

  public <D, V> void iget(FieldId<D, V> fieldId, Local<V> target, Local<D> instance) {
    insns.add(new Iget<D,V>(fieldId, target, instance));    
  }

  public <D, V> void iput(FieldId<D, V> fieldId, Local<D> instance, Local<V> source) {
  }

  public <V> void sget(FieldId<?, V> fieldId, Local<V> target) {
  }

  public <V> void sput(FieldId<?, V> fieldId, Local<V> source) {
  }

  // instructions: invoke

  public <T> void newInstance(Local<T> target, MethodId<T, Void> constructor, Local<?>... args) {
    insns.add(new NewInstance<T>(target, constructor, args));    
  }

  public <R> void invokeStatic(MethodId<?, R> method, Local<? super R> target, Local<?>... args) {
  }

  public <D, R> void invokeVirtual(MethodId<D, R> method, Local<? super R> target,
          Local<? extends D> instance, Local<?>... args) {
    insns.add(new InvokeVirtual<D, R>(method, target, instance, args));
  }

  public <D, R> void invokeDirect(MethodId<D, R> method, Local<? super R> target,
          Local<? extends D> instance, Local<?>... args) {
  }

  public <D, R> void invokeSuper(MethodId<D, R> method, Local<? super R> target,
          Local<? extends D> instance, Local<?>... args) {
  }

  public <D, R> void invokeInterface(MethodId<D, R> method, Local<? super R> target,
          Local<? extends D> instance, Local<?>... args) {
  }

  // instructions: types

  public void instanceOfType(Local<?> target, Local<?> source, TypeId<?> type) {
  }

  public void cast(Local<?> target, Local<?> source) {
  }

  // instructions: arrays

  public <T> void arrayLength(Local<Integer> target, Local<T> array) {
  }

  public <T> void newArray(Local<T> target, Local<Integer> length) {
  }

  public void aget(Local<?> target, Local<?> array, Local<Integer> index) {
  }

  public void aput(Local<?> array, Local<Integer> index, Local<?> source) {
  }

  // instructions: return

  public void returnVoid() {
    insns.add(RETURNVOID);
  }

  public void returnValue(Local<?> result) {
  }

  // instructions; synchronized

  public void monitorEnter(Local<?> monitor) {
  }

  public void monitorExit(Local<?> monitor) {
  }
}