package com.roscopeco.deelang.compiler.dex;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.google.dexmaker.Code;
import com.google.dexmaker.FieldId;
import com.google.dexmaker.Local;
import com.google.dexmaker.MethodId;
import com.google.dexmaker.TypeId;
import com.roscopeco.deelang.compiler.dex.CodeProxy.Iget;
import com.roscopeco.deelang.compiler.dex.CodeProxy.Instruction;
import com.roscopeco.deelang.compiler.dex.CodeProxy.LoadConstant;
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
  private Instruction mockInsn;
  
  @Mock
  private FieldId<Object, Object> mockFieldId;
  
  @Mock
  private MethodId<Object, Void> mockMethodId;
  
  private CodeProxy proxy;
  private Object object;
  
  @Before
  public void setUp() {
    proxy = new CodeProxy(mockCode);
    object = new Object();
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
    assertThat(mockCode.newLocal(TypeId.OBJECT), is(mockLocal));    
  }

  @Test
  public void testGetParameter() {
    when(mockCode.getParameter(0, TypeId.OBJECT)).thenReturn(mockLocal);
    assertThat(mockCode.getParameter(0, TypeId.OBJECT), is(mockLocal));    
  }

  @Test
  public void testGetThis() {
    when(mockCode.getThis(TypeId.OBJECT)).thenReturn(mockLocal);
    assertThat(mockCode.getThis(TypeId.OBJECT), is(mockLocal));    
  }

  @Test
  public void testMark() {
    fail("Not yet implemented");
  }

  @Test
  public void testJump() {
    fail("Not yet implemented");
  }

  @Test
  public void testAddCatchClause() {
    fail("Not yet implemented");
  }

  @Test
  public void testRemoveCatchClause() {
    fail("Not yet implemented");
  }

  @Test
  public void testThrowValue() {
    fail("Not yet implemented");
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
    fail("Not yet implemented");
  }

  @Test
  public void testOpUnaryOpLocalOfTLocalOfT() {
    fail("Not yet implemented");
  }

  @Test
  public void testOpBinaryOpLocalOfTLocalOfTLocalOfT() {
    fail("Not yet implemented");
  }

  @Test
  public void testCompare() {
    fail("Not yet implemented");
  }

  @Test
  public void testCompareFloatingPoint() {
    fail("Not yet implemented");
  }

  @Test
  public void testCompareLongs() {
    fail("Not yet implemented");
  }

  @Test
  public void testIget() {
    assertThat(proxy.insns.size(), is(0));
    proxy.iget(mockFieldId, mockLocal, mockLocal2);
    
    assertThat(proxy.insns.size(), is(1));
    
    Instruction i = proxy.insns.get(0);
    assertThat(i, is(instanceOf(Iget.class)));

    Iget<Object, Object> ig = (Iget<Object, Object>)i;  
    assertThat(ig.target, is(mockLocal));
    assertThat(ig.target, is(mockLocal));
    assertThat(ig.instance, is(mockLocal2));
    
    ig.generate();
    verify(mockCode).iget(mockFieldId, mockLocal, mockLocal2);
  }

  @Test
  public void testIput() {
    fail("Not yet implemented");
  }

  @Test
  public void testSget() {
    fail("Not yet implemented");
  }

  @Test
  public void testSput() {
    fail("Not yet implemented");
  }
  
  @Test
  public void testNewInstance() {
    assertThat(proxy.insns.size(), is(0));
    proxy.newInstance(mockLocal, mockMethodId);
    
    assertThat(proxy.insns.size(), is(1));
    
    Instruction i = proxy.insns.get(0);
    assertThat(i, is(instanceOf(NewInstance.class)));

    NewInstance<Object> ig = (NewInstance<Object>)i;
    
    assertThat(ig.target, is(mockLocal));
    assertThat(ig.constructor, is(mockMethodId));
    assertThat(ig.args.length, is(0));
    
    ig.generate();
    verify(mockCode).newInstance(mockLocal, mockMethodId);
    
    // test with 1 arg
    proxy.newInstance(mockLocal, mockMethodId, mockLocal2);
    ig = (NewInstance<Object>)proxy.insns.get(1);
    ig.generate();
    verify(mockCode).newInstance(mockLocal, mockMethodId, mockLocal2);    

    // test with 2 args
    proxy.newInstance(mockLocal, mockMethodId, mockLocal2, mockLocal);
    ig = (NewInstance<Object>)proxy.insns.get(2);
    ig.generate();
    verify(mockCode).newInstance(mockLocal, mockMethodId, mockLocal2, mockLocal);    
  }

  @Test
  public void testInvokeStatic() {
    fail("Not yet implemented");
  }

  @Test
  public void testInvokeVirtual() {
    fail("Not yet implemented");
  }

  @Test
  public void testInvokeDirect() {
    fail("Not yet implemented");
  }

  @Test
  public void testInvokeSuper() {
    fail("Not yet implemented");
  }

  @Test
  public void testInvokeInterface() {
    fail("Not yet implemented");
  }

  @Test
  public void testInstanceOfType() {
    fail("Not yet implemented");
  }

  @Test
  public void testCast() {
    fail("Not yet implemented");
  }

  @Test
  public void testArrayLength() {
    fail("Not yet implemented");
  }

  @Test
  public void testNewArray() {
    fail("Not yet implemented");
  }

  @Test
  public void testAget() {
    fail("Not yet implemented");
  }

  @Test
  public void testAput() {
    fail("Not yet implemented");
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
    fail("Not yet implemented");
  }

  @Test
  public void testMonitorEnter() {
    fail("Not yet implemented");
  }

  @Test
  public void testMonitorExit() {
    fail("Not yet implemented");
  }

}
