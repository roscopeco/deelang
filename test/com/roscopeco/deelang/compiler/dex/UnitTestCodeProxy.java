package com.roscopeco.deelang.compiler.dex;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.powermock.api.mockito.PowerMockito.when;

import org.junit.Before;
import org.junit.Ignore;
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

// TODO unignore this once tooling catches up with Java 9+
@Ignore
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
    this.proxy = new CodeProxy(null, this.mockCode);
    this.object = new Object();
    this.label = new Label();
  }

  @Test
  public void testCodeProxy() {
    assertThat(this.proxy.code, is(this.mockCode));
  }

  @Test
  public void testDoGenerate() {
    this.proxy.insns.add(this.mockInsn);
    this.proxy.doGenerate();
    verify(this.mockInsn).generate();
  }

  @Test
  public void testNewLocal() {
    when(this.mockCode.newLocal(TypeId.OBJECT)).thenReturn(this.mockLocal);
    assertThat(this.proxy.newLocal(TypeId.OBJECT), is(this.mockLocal));

    assertThat(this.proxy.localsPool.size(), is(0));
  }

  @Test
  public void testFreeLocal() {
    when(this.mockCode.newLocal(TypeId.OBJECT)).thenReturn(this.mockLocal);
    when(this.mockLocal.getType()).thenReturn(TypeId.OBJECT);

    Local<Object> l = this.proxy.newLocal(TypeId.OBJECT);
    assertThat(this.proxy.localsPool.get(TypeId.OBJECT), is(nullValue()));
    this.proxy.freeLocal(l);
    assertThat(this.proxy.localsPool.get(TypeId.OBJECT).size(), is(1));
    l = this.proxy.newLocal(TypeId.OBJECT);
    assertThat(this.proxy.localsPool.get(TypeId.OBJECT).size(), is(0));

    // newLocal should only have been called once. Second local should
    // have come from the pool.
    verify(this.mockCode, times(1)).newLocal(TypeId.OBJECT);
  }

  @Test
  public void testGetParameter() {
    when(this.mockCode.getParameter(0, TypeId.OBJECT)).thenReturn(this.mockLocal);
    assertThat(this.proxy.getParameter(0, TypeId.OBJECT), is(this.mockLocal));
  }

  @Test
  public void testGetThis() {
    when(this.mockCode.getThis(TypeId.OBJECT)).thenReturn(this.mockLocal);
    assertThat(this.proxy.getThis(TypeId.OBJECT), is(this.mockLocal));
  }

  @Test
  public void testMark() {
    assertThat(this.proxy.insns.size(), is(0));
    this.proxy.mark(this.label);

    assertThat(this.proxy.insns.size(), is(1));

    final Instruction i = this.proxy.insns.get(0);
    assertThat(i, is(instanceOf(Mark.class)));

    final Mark ig = (Mark)i;
    assertThat(ig.label, is(this.label));

    i.generate();
    verify(this.mockCode).mark(this.label);
  }

  @Test
  public void testJump() {
    assertThat(this.proxy.insns.size(), is(0));
    this.proxy.jump(this.label);

    assertThat(this.proxy.insns.size(), is(1));

    final Instruction i = this.proxy.insns.get(0);
    assertThat(i, is(instanceOf(Jump.class)));

    final Jump ig = (Jump)i;

    assertThat(ig.label, is(this.label));

    i.generate();
    verify(this.mockCode).jump(this.label);
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
    assertThat(this.proxy.insns.size(), is(0));
    this.proxy.loadConstant(this.mockLocal, this.object);

    assertThat(this.proxy.insns.size(), is(1));

    final Instruction i = this.proxy.insns.get(0);
    assertThat(i, is(instanceOf(LoadConstant.class)));

    final LoadConstant<Object> ig = (LoadConstant<Object>)i;

    assertThat(ig.target, is(this.mockLocal));
    assertThat(ig.value, is(this.object));

    ig.generate();
    verify(this.mockCode).loadConstant(this.mockLocal, this.object);
  }

  @Test
  public void testMove() {
    assertThat(this.proxy.insns.size(), is(0));
    this.proxy.move(this.mockLocal, this.mockLocal2);

    assertThat(this.proxy.insns.size(), is(1));

    final Instruction i = this.proxy.insns.get(0);
    assertThat(i, is(instanceOf(Move.class)));

    final Move<Object> ig = (Move<Object>)i;

    assertThat(ig.target, is(this.mockLocal));
    assertThat(ig.source, is(this.mockLocal2));

    ig.generate();
    verify(this.mockCode).move(this.mockLocal, this.mockLocal2);
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
    assertThat(this.proxy.insns.size(), is(0));
    this.proxy.compare(Comparison.EQ, this.label, this.mockLocal, this.mockLocal2);

    assertThat(this.proxy.insns.size(), is(1));

    final Instruction i = this.proxy.insns.get(0);
    assertThat(i, is(instanceOf(Compare.class)));

    final Compare<Object> ig = (Compare<Object>)i;
    assertThat(ig.comparison, is(Comparison.EQ));
    assertThat(ig.trueLabel, is(this.label));
    assertThat(ig.a, is(this.mockLocal));
    assertThat(ig.b, is(this.mockLocal2));

    ig.generate();
    verify(this.mockCode).compare(Comparison.EQ, this.label, this.mockLocal, this.mockLocal2);
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
    assertThat(this.proxy.insns.size(), is(0));
    this.proxy.iget(this.mockFieldId, this.mockLocal, this.mockLocal2);

    assertThat(this.proxy.insns.size(), is(1));

    final Instruction i = this.proxy.insns.get(0);
    assertThat(i, is(instanceOf(Iget.class)));

    final Iget<Object, Object> ig = (Iget<Object, Object>)i;
    assertThat(ig.fieldId, is(this.mockFieldId));
    assertThat(ig.target, is(this.mockLocal));
    assertThat(ig.instance, is(this.mockLocal2));

    ig.generate();
    verify(this.mockCode).iget(this.mockFieldId, this.mockLocal, this.mockLocal2);
  }

  @Test
  public void testIput() {
    assertThat(this.proxy.insns.size(), is(0));
    this.proxy.iput(this.mockFieldId, this.mockLocal, this.mockLocal2);

    assertThat(this.proxy.insns.size(), is(1));

    final Instruction i = this.proxy.insns.get(0);
    assertThat(i, is(instanceOf(Iput.class)));

    final Iput<Object, Object> ig = (Iput<Object, Object>)i;
    assertThat(ig.fieldId, is(this.mockFieldId));
    assertThat(ig.instance, is(this.mockLocal));
    assertThat(ig.source, is(this.mockLocal2));

    ig.generate();
    verify(this.mockCode).iput(this.mockFieldId, this.mockLocal, this.mockLocal2);
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
    assertThat(this.proxy.insns.size(), is(0));
    this.proxy.newInstance(this.mockLocal, this.mockCtorId);

    assertThat(this.proxy.insns.size(), is(1));

    final Instruction i = this.proxy.insns.get(0);
    assertThat(i, is(instanceOf(NewInstance.class)));

    NewInstance<Object> ig = (NewInstance<Object>)i;

    assertThat(ig.target, is(this.mockLocal));
    assertThat(ig.constructor, is(this.mockCtorId));
    assertThat(ig.args.length, is(0));

    ig.generate();
    verify(this.mockCode).newInstance(this.mockLocal, this.mockCtorId);

    // test with 1 arg
    this.proxy.newInstance(this.mockLocal, this.mockCtorId, this.mockLocal2);
    ig = (NewInstance<Object>)this.proxy.insns.get(1);
    ig.generate();
    verify(this.mockCode).newInstance(this.mockLocal, this.mockCtorId, this.mockLocal2);

    // test with 2 args
    this.proxy.newInstance(this.mockLocal, this.mockCtorId, this.mockLocal2, this.mockLocal);
    ig = (NewInstance<Object>)this.proxy.insns.get(2);
    ig.generate();
    verify(this.mockCode).newInstance(this.mockLocal, this.mockCtorId, this.mockLocal2, this.mockLocal);
  }

  @Test
  public void testInvokeStatic() {
    assertThat(this.proxy.insns.size(), is(0));
    this.proxy.invokeStatic(this.mockMethodId, this.mockTarget);

    assertThat(this.proxy.insns.size(), is(1));

    final Instruction i = this.proxy.insns.get(0);
    assertThat(i, is(instanceOf(Invoke.class)));

    Invoke<Object, Object> ig = (Invoke<Object, Object>)i;

    assertThat(ig.kind, is(Invoke.KIND_STATIC));
    assertThat(ig.method, is(this.mockMethodId));
    assertThat(ig.target, is(this.mockTarget));
    assertThat(ig.instance, is(nullValue()));
    assertThat(ig.args.length, is(0));

    ig.generate();
    verify(this.mockCode).invokeStatic(this.mockMethodId, this.mockTarget);

    // test with 1 arg
    this.proxy.invokeStatic(this.mockMethodId, this.mockTarget, this.mockLocal);
    ig = (Invoke<Object, Object>)this.proxy.insns.get(1);
    ig.generate();
    verify(this.mockCode).invokeStatic(this.mockMethodId, this.mockTarget, this.mockLocal);

    // test with 2 args
    this.proxy.invokeStatic(this.mockMethodId, this.mockTarget, this.mockLocal, this.mockLocal2);
    ig = (Invoke<Object, Object>)this.proxy.insns.get(2);
    ig.generate();
    verify(this.mockCode).invokeStatic(this.mockMethodId, this.mockTarget, this.mockLocal, this.mockLocal2);
  }

  @Test
  public void testInvokeVirtual() {
    assertThat(this.proxy.insns.size(), is(0));
    this.proxy.invokeVirtual(this.mockMethodId, this.mockTarget, this.mockInstance);

    assertThat(this.proxy.insns.size(), is(1));

    final Instruction i = this.proxy.insns.get(0);
    assertThat(i, is(instanceOf(Invoke.class)));

    Invoke<Object, Object> ig = (Invoke<Object, Object>)i;

    assertThat(ig.kind, is(Invoke.KIND_VIRTUAL));
    assertThat(ig.method, is(this.mockMethodId));
    assertThat(ig.target, is(this.mockTarget));
    assertThat(ig.instance, is(this.mockInstance));
    assertThat(ig.args.length, is(0));

    ig.generate();
    verify(this.mockCode).invokeVirtual(this.mockMethodId, this.mockTarget, this.mockInstance);

    // test with 1 arg
    this.proxy.invokeVirtual(this.mockMethodId, this.mockTarget, this.mockInstance, this.mockLocal);
    ig = (Invoke<Object, Object>)this.proxy.insns.get(1);
    ig.generate();
    verify(this.mockCode).invokeVirtual(this.mockMethodId, this.mockTarget, this.mockInstance, this.mockLocal);

    // test with 2 args
    this.proxy.invokeVirtual(this.mockMethodId, this.mockTarget, this.mockInstance, this.mockLocal, this.mockLocal2);
    ig = (Invoke<Object, Object>)this.proxy.insns.get(2);
    ig.generate();
    verify(this.mockCode).invokeVirtual(this.mockMethodId, this.mockTarget, this.mockInstance, this.mockLocal, this.mockLocal2);
  }

  @Test
  public void testInvokeDirect() {
    assertThat(this.proxy.insns.size(), is(0));
    this.proxy.invokeDirect(this.mockMethodId, this.mockTarget, this.mockInstance);

    assertThat(this.proxy.insns.size(), is(1));

    final Instruction i = this.proxy.insns.get(0);
    assertThat(i, is(instanceOf(Invoke.class)));

    Invoke<Object, Object> ig = (Invoke<Object, Object>)i;

    assertThat(ig.kind, is(Invoke.KIND_DIRECT));
    assertThat(ig.method, is(this.mockMethodId));
    assertThat(ig.target, is(this.mockTarget));
    assertThat(ig.instance, is(this.mockInstance));
    assertThat(ig.args.length, is(0));

    ig.generate();
    verify(this.mockCode).invokeDirect(this.mockMethodId, this.mockTarget, this.mockInstance);

    // test with 1 arg
    this.proxy.invokeDirect(this.mockMethodId, this.mockTarget, this.mockInstance, this.mockLocal);
    ig = (Invoke<Object, Object>)this.proxy.insns.get(1);
    ig.generate();
    verify(this.mockCode).invokeDirect(this.mockMethodId, this.mockTarget, this.mockInstance, this.mockLocal);

    // test with 2 args
    this.proxy.invokeDirect(this.mockMethodId, this.mockTarget, this.mockInstance, this.mockLocal, this.mockLocal2);
    ig = (Invoke<Object, Object>)this.proxy.insns.get(2);
    ig.generate();
    verify(this.mockCode).invokeDirect(this.mockMethodId, this.mockTarget, this.mockInstance, this.mockLocal, this.mockLocal2);
  }

  @Test
  public void testInvokeSuper() {
    assertThat(this.proxy.insns.size(), is(0));
    this.proxy.invokeSuper(this.mockMethodId, this.mockTarget, this.mockInstance);

    assertThat(this.proxy.insns.size(), is(1));

    final Instruction i = this.proxy.insns.get(0);
    assertThat(i, is(instanceOf(Invoke.class)));

    Invoke<Object, Object> ig = (Invoke<Object, Object>)i;

    assertThat(ig.kind, is(Invoke.KIND_SUPER));
    assertThat(ig.method, is(this.mockMethodId));
    assertThat(ig.target, is(this.mockTarget));
    assertThat(ig.instance, is(this.mockInstance));
    assertThat(ig.args.length, is(0));

    ig.generate();
    verify(this.mockCode).invokeSuper(this.mockMethodId, this.mockTarget, this.mockInstance);

    // test with 1 arg
    this.proxy.invokeSuper(this.mockMethodId, this.mockTarget, this.mockInstance, this.mockLocal);
    ig = (Invoke<Object, Object>)this.proxy.insns.get(1);
    ig.generate();
    verify(this.mockCode).invokeSuper(this.mockMethodId, this.mockTarget, this.mockInstance, this.mockLocal);

    // test with 2 args
    this.proxy.invokeSuper(this.mockMethodId, this.mockTarget, this.mockInstance, this.mockLocal, this.mockLocal2);
    ig = (Invoke<Object, Object>)this.proxy.insns.get(2);
    ig.generate();
    verify(this.mockCode).invokeSuper(this.mockMethodId, this.mockTarget, this.mockInstance, this.mockLocal, this.mockLocal2);
  }

  @Test
  public void testInvokeInterface() {
    assertThat(this.proxy.insns.size(), is(0));
    this.proxy.invokeInterface(this.mockMethodId, this.mockTarget, this.mockInstance);

    assertThat(this.proxy.insns.size(), is(1));

    final Instruction i = this.proxy.insns.get(0);
    assertThat(i, is(instanceOf(Invoke.class)));

    Invoke<Object, Object> ig = (Invoke<Object, Object>)i;

    assertThat(ig.kind, is(Invoke.KIND_INTERFACE));
    assertThat(ig.method, is(this.mockMethodId));
    assertThat(ig.target, is(this.mockTarget));
    assertThat(ig.instance, is(this.mockInstance));
    assertThat(ig.args.length, is(0));

    ig.generate();
    verify(this.mockCode).invokeInterface(this.mockMethodId, this.mockTarget, this.mockInstance);

    // test with 1 arg
    this.proxy.invokeInterface(this.mockMethodId, this.mockTarget, this.mockInstance, this.mockLocal);
    ig = (Invoke<Object, Object>)this.proxy.insns.get(1);
    ig.generate();
    verify(this.mockCode).invokeInterface(this.mockMethodId, this.mockTarget, this.mockInstance, this.mockLocal);

    // test with 2 args
    this.proxy.invokeInterface(this.mockMethodId, this.mockTarget, this.mockInstance, this.mockLocal, this.mockLocal2);
    ig = (Invoke<Object, Object>)this.proxy.insns.get(2);
    ig.generate();
    verify(this.mockCode).invokeInterface(this.mockMethodId, this.mockTarget, this.mockInstance, this.mockLocal, this.mockLocal2);
  }

  @Test
  public void testInstanceOfType() {
    // TODO implement this test
  }

  @Test
  public void testCast() {
    assertThat(this.proxy.insns.size(), is(0));
    this.proxy.cast(this.mockTarget, this.mockInstance);

    assertThat(this.proxy.insns.size(), is(1));

    final Instruction i = this.proxy.insns.get(0);
    assertThat(i, is(instanceOf(Cast.class)));

    final Cast ig = (Cast)i;

    assertThat(ig.target, is(this.mockTarget));
    assertThat(ig.source, is(this.mockInstance));

    ig.generate();
    verify(this.mockCode).cast(this.mockTarget, this.mockInstance);
  }

  @Test
  public void testArrayLength() {
    // TODO implement this test
  }

  @Test
  public void testNewArray() {
    assertThat(this.proxy.insns.size(), is(0));
    this.proxy.newArray(this.mockTarget, this.mockIntLocal);

    assertThat(this.proxy.insns.size(), is(1));

    final Instruction i = this.proxy.insns.get(0);
    assertThat(i, is(instanceOf(NewArray.class)));

    final NewArray ig = (NewArray)i;

    assertThat(ig.target, is(this.mockTarget));
    assertThat(ig.length, is(this.mockIntLocal));

    ig.generate();
    verify(this.mockCode).newArray(this.mockTarget, this.mockIntLocal);
  }

  @Test
  public void testAget() {
    assertThat(this.proxy.insns.size(), is(0));
    this.proxy.aget(this.mockTarget, this.mockInstance, this.mockIntLocal);

    assertThat(this.proxy.insns.size(), is(1));

    final Instruction i = this.proxy.insns.get(0);
    assertThat(i, is(instanceOf(Aget.class)));

    final Aget ig = (Aget)i;

    assertThat(ig.target, is(this.mockTarget));
    assertThat(ig.array, is(this.mockInstance));
    assertThat(ig.index, is(this.mockIntLocal));

    ig.generate();
    verify(this.mockCode).aget(this.mockTarget, this.mockInstance, this.mockIntLocal);
  }

  @Test
  public void testAput() {
    assertThat(this.proxy.insns.size(), is(0));
    this.proxy.aput(this.mockInstance, this.mockIntLocal, this.mockTarget);

    assertThat(this.proxy.insns.size(), is(1));

    final Instruction i = this.proxy.insns.get(0);
    assertThat(i, is(instanceOf(Aput.class)));

    final Aput ig = (Aput)i;

    assertThat(ig.array, is(this.mockInstance));
    assertThat(ig.index, is(this.mockIntLocal));
    assertThat(ig.source, is(this.mockTarget));

    ig.generate();
    verify(this.mockCode).aput(this.mockInstance, this.mockIntLocal, this.mockTarget);
  }

  @Test
  public void testReturnVoid() {
    assertThat(this.proxy.insns.size(), is(0));
    this.proxy.returnVoid();

    assertThat(this.proxy.insns.size(), is(1));

    final Instruction i = this.proxy.insns.get(0);
    assertThat(i, is(instanceOf(ReturnVoid.class)));

    i.generate();
    verify(this.mockCode).returnVoid();
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
