package com.roscopeco.deelang.compiler.dex;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.google.dexmaker.Code;
import com.google.dexmaker.Comparison;
import com.google.dexmaker.FieldId;
import com.google.dexmaker.Label;
import com.google.dexmaker.Local;
import com.google.dexmaker.MethodId;
import com.google.dexmaker.TypeId;
import com.roscopeco.deelang.compiler.dex.CodeProxy.Aget;
import com.roscopeco.deelang.compiler.dex.CodeProxy.Aput;
import com.roscopeco.deelang.compiler.dex.CodeProxy.Cast;
import com.roscopeco.deelang.compiler.dex.CodeProxy.Compare;
import com.roscopeco.deelang.compiler.dex.CodeProxy.Iget;
import com.roscopeco.deelang.compiler.dex.CodeProxy.Instruction;
import com.roscopeco.deelang.compiler.dex.CodeProxy.Invoke;
import com.roscopeco.deelang.compiler.dex.CodeProxy.Iput;
import com.roscopeco.deelang.compiler.dex.CodeProxy.Jump;
import com.roscopeco.deelang.compiler.dex.CodeProxy.LoadConstant;
import com.roscopeco.deelang.compiler.dex.CodeProxy.Mark;
import com.roscopeco.deelang.compiler.dex.CodeProxy.Move;
import com.roscopeco.deelang.compiler.dex.CodeProxy.NewArray;
import com.roscopeco.deelang.compiler.dex.CodeProxy.NewInstance;
import com.roscopeco.deelang.compiler.dex.CodeProxy.ReturnVoid;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ Code.class, Local.class, Instruction.class, FieldId.class, MethodId.class })
@SuppressWarnings("unchecked")
public class UnitTestCodeProxy {
  @Mock
  private Code mockCode;
  
  @Mock
  private Local<Object> mockLocal;
  
  @Mock
  private Local<Object> mockLocal2;
  
  @Mock
  private Local<Integer> mockIntLocal;
  
  @SuppressWarnings("rawtypes")
  @Mock
  private Local mockTarget;
  
  @SuppressWarnings("rawtypes")
  @Mock
  private Local mockInstance;
  
  @Mock
  private Instruction mockInsn;
  
  @Mock
  private FieldId<Object, Object> mockFieldId;
  
  @Mock
  private MethodId<Object, Void> mockCtorId;

  @Mock
  private MethodId<Object, Object> mockMethodId;
  
  private CodeProxy proxy;
  private Object object;
  private Label label;
  
  @Before
  public void setUp() {
    proxy = new CodeProxy(null, mockCode);
    object = new Object();
    label = new Label();
  }
  
  @Test
  public void testCodeProxy() {
    assertThat(proxy.code, is(mockCode));
  }

  @Test
  public void testDoGenerate() {    
    proxy.insns.add(mockInsn);
    proxy.doGenerate();       
    verify(mockInsn).generate();
  }

  @Test
  public void testNewLocal() {
    when(mockCode.newLocal(TypeId.OBJECT)).thenReturn(mockLocal);
    assertThat(proxy.newLocal(TypeId.OBJECT), is(mockLocal));
    
    assertThat(proxy.localsPool.size(), is(0));
  }

  @Test
  public void testFreeLocal() {
    when(mockCode.newLocal(TypeId.OBJECT)).thenReturn(mockLocal);
    when(mockLocal.getType()).thenReturn(TypeId.OBJECT);
    
    Local<Object> l = proxy.newLocal(TypeId.OBJECT);
    assertThat(proxy.localsPool.get(TypeId.OBJECT), is(nullValue()));
    proxy.freeLocal(l);
    assertThat(proxy.localsPool.get(TypeId.OBJECT).size(), is(1));
    l = proxy.newLocal(TypeId.OBJECT);
    assertThat(proxy.localsPool.get(TypeId.OBJECT).size(), is(0));
    
    // newLocal should only have been called once. Second local should
    // have come from the pool.
    verify(mockCode, times(1)).newLocal(TypeId.OBJECT);
  }

  @Test
  public void testGetParameter() {
    when(mockCode.getParameter(0, TypeId.OBJECT)).thenReturn(mockLocal);
    assertThat(proxy.getParameter(0, TypeId.OBJECT), is(mockLocal));    
  }

  @Test
  public void testGetThis() {
    when(mockCode.getThis(TypeId.OBJECT)).thenReturn(mockLocal);
    assertThat(proxy.getThis(TypeId.OBJECT), is(mockLocal));    
  }

  @Test
  public void testMark() {
    assertThat(proxy.insns.size(), is(0));
    proxy.mark(label);
    
    assertThat(proxy.insns.size(), is(1));
    
    Instruction i = proxy.insns.get(0);
    assertThat(i, is(instanceOf(Mark.class)));

    Mark ig = (Mark)i;
    assertThat(ig.label, is(label));
    
    i.generate();
    verify(mockCode).mark(label);
  }

  @Test
  public void testJump() {
    assertThat(proxy.insns.size(), is(0));
    proxy.jump(label);
    
    assertThat(proxy.insns.size(), is(1));
    
    Instruction i = proxy.insns.get(0);
    assertThat(i, is(instanceOf(Jump.class)));
    
    Jump ig = (Jump)i;

    assertThat(ig.label, is(label));
    
    i.generate();
    verify(mockCode).jump(label);
  }

  @Test
  public void testAddCatchClause() {
    // TODO implement this test
  }

  @Test
  public void testRemoveCatchClause() {
    // TODO implement this test
  }

  @Test
  public void testThrowValue() {
    // TODO implement this test
  }

  @Test
  public void testLoadConstant() {
    assertThat(proxy.insns.size(), is(0));
    proxy.loadConstant(mockLocal, object);
    
    assertThat(proxy.insns.size(), is(1));
    
    Instruction i = proxy.insns.get(0);
    assertThat(i, is(instanceOf(LoadConstant.class)));

    LoadConstant<Object> ig = (LoadConstant<Object>)i;
    
    assertThat(ig.target, is(mockLocal));
    assertThat(ig.value, is(object));
    
    ig.generate();
    verify(mockCode).loadConstant(mockLocal, object);
  }

  @Test
  public void testMove() {
    assertThat(proxy.insns.size(), is(0));
    proxy.move(mockLocal, mockLocal2);
    
    assertThat(proxy.insns.size(), is(1));
    
    Instruction i = proxy.insns.get(0);
    assertThat(i, is(instanceOf(Move.class)));

    Move<Object> ig = (Move<Object>)i;
    
    assertThat(ig.target, is(mockLocal));
    assertThat(ig.source, is(mockLocal2));
    
    ig.generate();
    verify(mockCode).move(mockLocal, mockLocal2);
  }

  @Test
  public void testOpUnaryOpLocalOfTLocalOfT() {
    // TODO implement this test
  }

  @Test
  public void testOpBinaryOpLocalOfTLocalOfTLocalOfT() {
    // TODO implement this test
  }

  @Test
  public void testCompare() {
    assertThat(proxy.insns.size(), is(0));
    proxy.compare(Comparison.EQ, label, mockLocal, mockLocal2);
    
    assertThat(proxy.insns.size(), is(1));
    
    Instruction i = proxy.insns.get(0);
    assertThat(i, is(instanceOf(Compare.class)));

    Compare<Object> ig = (Compare<Object>)i;
    assertThat(ig.comparison, is(Comparison.EQ));
    assertThat(ig.trueLabel, is(label));
    assertThat(ig.a, is(mockLocal));
    assertThat(ig.b, is(mockLocal2));
    
    ig.generate();
    verify(mockCode).compare(Comparison.EQ, label, mockLocal, mockLocal2);
  }

  @Test
  public void testCompareFloatingPoint() {
    // TODO implement this test
  }

  @Test
  public void testCompareLongs() {
    // TODO implement this test
  }

  @Test
  public void testIget() {
    assertThat(proxy.insns.size(), is(0));
    proxy.iget(mockFieldId, mockLocal, mockLocal2);
    
    assertThat(proxy.insns.size(), is(1));
    
    Instruction i = proxy.insns.get(0);
    assertThat(i, is(instanceOf(Iget.class)));

    Iget<Object, Object> ig = (Iget<Object, Object>)i;
    assertThat(ig.fieldId, is(mockFieldId));
    assertThat(ig.target, is(mockLocal));
    assertThat(ig.instance, is(mockLocal2));
    
    ig.generate();
    verify(mockCode).iget(mockFieldId, mockLocal, mockLocal2);
  }

  @Test
  public void testIput() {
    assertThat(proxy.insns.size(), is(0));
    proxy.iput(mockFieldId, mockLocal, mockLocal2);
    
    assertThat(proxy.insns.size(), is(1));
    
    Instruction i = proxy.insns.get(0);
    assertThat(i, is(instanceOf(Iput.class)));

    Iput<Object, Object> ig = (Iput<Object, Object>)i;  
    assertThat(ig.fieldId, is(mockFieldId));
    assertThat(ig.instance, is(mockLocal));
    assertThat(ig.source, is(mockLocal2));
    
    ig.generate();
    verify(mockCode).iput(mockFieldId, mockLocal, mockLocal2);
  }

  @Test
  public void testSget() {
    // TODO implement this test
  }

  @Test
  public void testSput() {
    // TODO implement this test
  }
  
  @Test
  public void testNewInstance() {
    assertThat(proxy.insns.size(), is(0));
    proxy.newInstance(mockLocal, mockCtorId);
    
    assertThat(proxy.insns.size(), is(1));
    
    Instruction i = proxy.insns.get(0);
    assertThat(i, is(instanceOf(NewInstance.class)));

    NewInstance<Object> ig = (NewInstance<Object>)i;
    
    assertThat(ig.target, is(mockLocal));
    assertThat(ig.constructor, is(mockCtorId));
    assertThat(ig.args.length, is(0));
    
    ig.generate();
    verify(mockCode).newInstance(mockLocal, mockCtorId);
    
    // test with 1 arg
    proxy.newInstance(mockLocal, mockCtorId, mockLocal2);
    ig = (NewInstance<Object>)proxy.insns.get(1);
    ig.generate();
    verify(mockCode).newInstance(mockLocal, mockCtorId, mockLocal2);    

    // test with 2 args
    proxy.newInstance(mockLocal, mockCtorId, mockLocal2, mockLocal);
    ig = (NewInstance<Object>)proxy.insns.get(2);
    ig.generate();
    verify(mockCode).newInstance(mockLocal, mockCtorId, mockLocal2, mockLocal);    
  }

  @Test
  public void testInvokeStatic() {
    assertThat(proxy.insns.size(), is(0));
    proxy.invokeStatic(mockMethodId, mockTarget);
    
    assertThat(proxy.insns.size(), is(1));
    
    Instruction i = proxy.insns.get(0);
    assertThat(i, is(instanceOf(Invoke.class)));

    Invoke<Object, Object> ig = (Invoke<Object, Object>)i;
    
    assertThat(ig.kind, is(Invoke.KIND_STATIC));
    assertThat(ig.method, is(mockMethodId));
    assertThat(ig.target, is(mockTarget));
    assertThat(ig.instance, is(nullValue()));    
    assertThat(ig.args.length, is(0));
    
    ig.generate();
    verify(mockCode).invokeStatic(mockMethodId, mockTarget);
    
    // test with 1 arg
    proxy.invokeStatic(mockMethodId, mockTarget, mockLocal);
    ig = (Invoke<Object, Object>)proxy.insns.get(1);
    ig.generate();
    verify(mockCode).invokeStatic(mockMethodId, mockTarget, mockLocal);    

    // test with 2 args
    proxy.invokeStatic(mockMethodId, mockTarget, mockLocal, mockLocal2);
    ig = (Invoke<Object, Object>)proxy.insns.get(2);
    ig.generate();
    verify(mockCode).invokeStatic(mockMethodId, mockTarget, mockLocal, mockLocal2);    
  }

  @Test
  public void testInvokeVirtual() {
    assertThat(proxy.insns.size(), is(0));
    proxy.invokeVirtual(mockMethodId, mockTarget, mockInstance);
    
    assertThat(proxy.insns.size(), is(1));
    
    Instruction i = proxy.insns.get(0);
    assertThat(i, is(instanceOf(Invoke.class)));

    Invoke<Object, Object> ig = (Invoke<Object, Object>)i;
    
    assertThat(ig.kind, is(Invoke.KIND_VIRTUAL));
    assertThat(ig.method, is(mockMethodId));
    assertThat(ig.target, is(mockTarget));
    assertThat(ig.instance, is(mockInstance));    
    assertThat(ig.args.length, is(0));
    
    ig.generate();
    verify(mockCode).invokeVirtual(mockMethodId, mockTarget, mockInstance);
    
    // test with 1 arg
    proxy.invokeVirtual(mockMethodId, mockTarget, mockInstance, mockLocal);
    ig = (Invoke<Object, Object>)proxy.insns.get(1);
    ig.generate();
    verify(mockCode).invokeVirtual(mockMethodId, mockTarget, mockInstance, mockLocal);    

    // test with 2 args
    proxy.invokeVirtual(mockMethodId, mockTarget, mockInstance, mockLocal, mockLocal2);
    ig = (Invoke<Object, Object>)proxy.insns.get(2);
    ig.generate();
    verify(mockCode).invokeVirtual(mockMethodId, mockTarget, mockInstance, mockLocal, mockLocal2);    
  }

  @Test
  public void testInvokeDirect() {
    assertThat(proxy.insns.size(), is(0));
    proxy.invokeDirect(mockMethodId, mockTarget, mockInstance);
    
    assertThat(proxy.insns.size(), is(1));
    
    Instruction i = proxy.insns.get(0);
    assertThat(i, is(instanceOf(Invoke.class)));

    Invoke<Object, Object> ig = (Invoke<Object, Object>)i;
    
    assertThat(ig.kind, is(Invoke.KIND_DIRECT));
    assertThat(ig.method, is(mockMethodId));
    assertThat(ig.target, is(mockTarget));
    assertThat(ig.instance, is(mockInstance));    
    assertThat(ig.args.length, is(0));
    
    ig.generate();
    verify(mockCode).invokeDirect(mockMethodId, mockTarget, mockInstance);
    
    // test with 1 arg
    proxy.invokeDirect(mockMethodId, mockTarget, mockInstance, mockLocal);
    ig = (Invoke<Object, Object>)proxy.insns.get(1);
    ig.generate();
    verify(mockCode).invokeDirect(mockMethodId, mockTarget, mockInstance, mockLocal);    

    // test with 2 args
    proxy.invokeDirect(mockMethodId, mockTarget, mockInstance, mockLocal, mockLocal2);
    ig = (Invoke<Object, Object>)proxy.insns.get(2);
    ig.generate();
    verify(mockCode).invokeDirect(mockMethodId, mockTarget, mockInstance, mockLocal, mockLocal2);    
  }

  @Test
  public void testInvokeSuper() {
    assertThat(proxy.insns.size(), is(0));
    proxy.invokeSuper(mockMethodId, mockTarget, mockInstance);
    
    assertThat(proxy.insns.size(), is(1));
    
    Instruction i = proxy.insns.get(0);
    assertThat(i, is(instanceOf(Invoke.class)));

    Invoke<Object, Object> ig = (Invoke<Object, Object>)i;
    
    assertThat(ig.kind, is(Invoke.KIND_SUPER));
    assertThat(ig.method, is(mockMethodId));
    assertThat(ig.target, is(mockTarget));
    assertThat(ig.instance, is(mockInstance));    
    assertThat(ig.args.length, is(0));
    
    ig.generate();
    verify(mockCode).invokeSuper(mockMethodId, mockTarget, mockInstance);
    
    // test with 1 arg
    proxy.invokeSuper(mockMethodId, mockTarget, mockInstance, mockLocal);
    ig = (Invoke<Object, Object>)proxy.insns.get(1);
    ig.generate();
    verify(mockCode).invokeSuper(mockMethodId, mockTarget, mockInstance, mockLocal);    

    // test with 2 args
    proxy.invokeSuper(mockMethodId, mockTarget, mockInstance, mockLocal, mockLocal2);
    ig = (Invoke<Object, Object>)proxy.insns.get(2);
    ig.generate();
    verify(mockCode).invokeSuper(mockMethodId, mockTarget, mockInstance, mockLocal, mockLocal2);    
  }

  @Test
  public void testInvokeInterface() {
    assertThat(proxy.insns.size(), is(0));
    proxy.invokeInterface(mockMethodId, mockTarget, mockInstance);
    
    assertThat(proxy.insns.size(), is(1));
    
    Instruction i = proxy.insns.get(0);
    assertThat(i, is(instanceOf(Invoke.class)));

    Invoke<Object, Object> ig = (Invoke<Object, Object>)i;
    
    assertThat(ig.kind, is(Invoke.KIND_INTERFACE));
    assertThat(ig.method, is(mockMethodId));
    assertThat(ig.target, is(mockTarget));
    assertThat(ig.instance, is(mockInstance));    
    assertThat(ig.args.length, is(0));
    
    ig.generate();
    verify(mockCode).invokeInterface(mockMethodId, mockTarget, mockInstance);
    
    // test with 1 arg
    proxy.invokeInterface(mockMethodId, mockTarget, mockInstance, mockLocal);
    ig = (Invoke<Object, Object>)proxy.insns.get(1);
    ig.generate();
    verify(mockCode).invokeInterface(mockMethodId, mockTarget, mockInstance, mockLocal);    

    // test with 2 args
    proxy.invokeInterface(mockMethodId, mockTarget, mockInstance, mockLocal, mockLocal2);
    ig = (Invoke<Object, Object>)proxy.insns.get(2);
    ig.generate();
    verify(mockCode).invokeInterface(mockMethodId, mockTarget, mockInstance, mockLocal, mockLocal2);    
  }

  @Test
  public void testInstanceOfType() {
    // TODO implement this test
  }

  @Test
  public void testCast() {
    assertThat(proxy.insns.size(), is(0));
    proxy.cast(mockTarget, mockInstance);
    
    assertThat(proxy.insns.size(), is(1));
    
    Instruction i = proxy.insns.get(0);
    assertThat(i, is(instanceOf(Cast.class)));

    Cast ig = (Cast)i;
    
    assertThat(ig.target, is(mockTarget));
    assertThat(ig.source, is(mockInstance));    
    
    ig.generate();
    verify(mockCode).cast(mockTarget, mockInstance);
  }

  @Test
  public void testArrayLength() {
    // TODO implement this test
  }

  @Test
  public void testNewArray() {
    assertThat(proxy.insns.size(), is(0));
    proxy.newArray(mockTarget, mockIntLocal);
    
    assertThat(proxy.insns.size(), is(1));
    
    Instruction i = proxy.insns.get(0);
    assertThat(i, is(instanceOf(NewArray.class)));

    NewArray ig = (NewArray)i;
    
    assertThat(ig.target, is(mockTarget));
    assertThat(ig.length, is(mockIntLocal));
    
    ig.generate();
    verify(mockCode).newArray(mockTarget, mockIntLocal);
  }

  @Test
  public void testAget() {
    assertThat(proxy.insns.size(), is(0));
    proxy.aget(mockTarget, mockInstance, mockIntLocal);
    
    assertThat(proxy.insns.size(), is(1));
    
    Instruction i = proxy.insns.get(0);
    assertThat(i, is(instanceOf(Aget.class)));

    Aget ig = (Aget)i;
    
    assertThat(ig.target, is(mockTarget));
    assertThat(ig.array, is(mockInstance));
    assertThat(ig.index, is(mockIntLocal));
    
    ig.generate();
    verify(mockCode).aget(mockTarget, mockInstance, mockIntLocal);
  }

  @Test
  public void testAput() {
    assertThat(proxy.insns.size(), is(0));
    proxy.aput(mockInstance, mockIntLocal, mockTarget);
    
    assertThat(proxy.insns.size(), is(1));
    
    Instruction i = proxy.insns.get(0);
    assertThat(i, is(instanceOf(Aput.class)));

    Aput ig = (Aput)i;
    
    assertThat(ig.array, is(mockInstance));
    assertThat(ig.index, is(mockIntLocal));
    assertThat(ig.source, is(mockTarget));
    
    ig.generate();
    verify(mockCode).aput(mockInstance, mockIntLocal, mockTarget);
  }

  @Test
  public void testReturnVoid() {
    assertThat(proxy.insns.size(), is(0));
    proxy.returnVoid();
    
    assertThat(proxy.insns.size(), is(1));
    
    Instruction i = proxy.insns.get(0);
    assertThat(i, is(instanceOf(ReturnVoid.class)));

    i.generate();
    verify(mockCode).returnVoid();
  }

  @Test
  public void testReturnValue() {
    // TODO implement this test
  }

  @Test
  public void testMonitorEnter() {
    // TODO implement this test
  }

  @Test
  public void testMonitorExit() {
    // TODO implement this test
  }

}
