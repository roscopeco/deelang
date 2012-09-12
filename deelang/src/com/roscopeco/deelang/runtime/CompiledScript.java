package com.roscopeco.deelang.runtime;

import java.lang.reflect.InvocationTargetException;

import com.roscopeco.deelang.compiler.CompilerBug;

import dee.lang.DeelangObject;
import dee.lang.DeelangRuntimeException;


public abstract class CompiledScript implements Runnable {
  protected final Binding binding;
  
  public static <T extends CompiledScript> T newInstance(Class<T> clz, Binding b) {
    try {
      return clz.getConstructor(Binding.class).newInstance(b);
    } catch (InvocationTargetException e) {
      throw new DeelangRuntimeException(new CompilerBug("Exception thrown by generated <init>", e));
    } catch (IllegalAccessException e) {
      throw new DeelangRuntimeException(new CompilerBug("Generated <init> is not accessible", e));
    } catch (NoSuchMethodException e) {
      throw new DeelangRuntimeException(new CompilerBug("<init> was not generated", e));
    } catch (InstantiationException e) {
      throw new DeelangRuntimeException("Cannot instantiate script class", e);
    }    
  }
  
  public CompiledScript(Binding binding) {
    this.binding = binding;
  }
  
  public Binding getBinding() {
    return binding;
  }
  
  public void run() {
    run(binding.getSelf(), binding);    
  }
  
  /**
   * The script implementation.
   * 
   * The compiler creates an implementation of this method with the
   * compiled script code. 
   * 
   * @param self The <code>self</code> object (should be <code>binding.getSelf()</code>). 
   * @param binding The {@link Binding} to use for the run.
   */
  protected abstract void run(DeelangObject self, Binding binding);
}
