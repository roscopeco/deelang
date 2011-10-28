package com.roscopeco.deelang.compiler;

import org.junit.Before;
import org.junit.Test;

import com.roscopeco.deelang.Opcodes;

public class FuncTestCompilerAssignment extends CompilerFuncTestBase {
  

  @Before
  public void setUp() throws Exception {
  }

  @Test // (expected = UnknownVariableException.class)
  public void testPlainIdentifier() throws Throwable {
    runCodeComparisonTest("a", new byte[] {
        Opcodes.LOAD,       0
    });
  }
  
  @Test
  public void testLocalAssignment() throws Throwable {
    runCodeComparisonTest("a=1", new byte[] {
        Opcodes.IPUSHCONST, 0, 0, 0, 0,
        Opcodes.STORE,      0
    });
  }
  
  @Test
  public void testFieldFromLocalReceiverAssignment() throws Throwable {
    runCodeLocalsAndPoolComparisonTest("Foo.a=1", new byte[] {
        Opcodes.LOAD,       0,
        Opcodes.IPUSHCONST, 0, 0, 0, 0,
        Opcodes.PUTFIELD,   0, 0, 0, 1
    }, new String[] {
        "Foo"
    }, new CompiledScript.ConstPoolEntry[] {
        new CompiledScript.ConstPoolInt(1),
        new CompiledScript.ConstPoolField("a")
    });
  }

  @Test
  public void testFieldFromMethodResultReceiverAssignment() throws Throwable {
    runCodeLocalsAndPoolComparisonTest("foo().a=1", new byte[] {
        Opcodes.INVOKESELF, 0, 0, 0, 0, 0,
        Opcodes.IPUSHCONST, 0, 0, 0, 1,
        Opcodes.PUTFIELD,   0, 0, 0, 2
    }, new String[] {
        
    }, new CompiledScript.ConstPoolEntry[] {
        new CompiledScript.ConstPoolMethod("foo"),
        new CompiledScript.ConstPoolInt(1),
        new CompiledScript.ConstPoolField("a")
    });
  }
  
  @Test
  public void testFieldFromChainedCallAssignment() throws Throwable {
    runCodeLocalsAndPoolComparisonTest("foo().bar.baz().a=1", new byte[] {
        Opcodes.INVOKESELF,     0, 0, 0, 0, 0,
        Opcodes.GETFIELD,       0, 0, 0, 1,
        Opcodes.INVOKEDYNAMIC,  0, 0, 0, 2, 0,
        Opcodes.IPUSHCONST,     0, 0, 0, 3,
        Opcodes.PUTFIELD,       0, 0, 0, 4
    }, new String[] {
        
    }, new CompiledScript.ConstPoolEntry[] {
        new CompiledScript.ConstPoolMethod("foo"),
        new CompiledScript.ConstPoolField("bar"),
        new CompiledScript.ConstPoolMethod("baz"),
        new CompiledScript.ConstPoolInt(1),
        new CompiledScript.ConstPoolField("a"),
    });
  }
}
