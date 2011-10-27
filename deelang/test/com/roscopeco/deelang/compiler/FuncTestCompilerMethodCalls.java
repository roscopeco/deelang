package com.roscopeco.deelang.compiler;

import org.junit.Test;

import com.roscopeco.deelang.Opcodes;
import com.roscopeco.deelang.compiler.CompiledScript;
import com.roscopeco.deelang.compiler.CompilerError;

public class FuncTestCompilerMethodCalls extends CompilerFuncTestBase {

  @Test
  public void testBasicFuncCallNoArgs() throws CompilerError {
    runCodeAndPoolComparisonTest("foo()", new byte[] {
        Opcodes.INVOKESELF,         0, 0, 0, 0, 0  
    }, new CompiledScript.ConstPoolEntry[] {
        new CompiledScript.ConstPoolMethod("foo")
    });
  }

  @Test
  public void testBasicFuncCallOneArg() throws CompilerError {
    runCodeAndPoolComparisonTest("foo(1)", new byte[] {
        Opcodes.IPUSHCONST,         0, 0, 0, 1,
        Opcodes.INVOKESELF,         0, 0, 0, 0, 1  
    }, new CompiledScript.ConstPoolEntry[] {
        new CompiledScript.ConstPoolMethod("foo"),
        new CompiledScript.ConstPoolInt(1)
    });
  }

  @Test
  public void testBasicFuncCallTwoArgs() throws CompilerError {
    runCodeAndPoolComparisonTest("foo(1,2)", new byte[] {
        Opcodes.IPUSHCONST,         0, 0, 0, 1,
        Opcodes.IPUSHCONST,         0, 0, 0, 2,
        Opcodes.INVOKESELF,         0, 0, 0, 0, 2  
    }, new CompiledScript.ConstPoolEntry[] {
        new CompiledScript.ConstPoolMethod("foo"),
        new CompiledScript.ConstPoolInt(1),
        new CompiledScript.ConstPoolInt(2)
    });
  }

  @Test
  public void testNestedFuncCallOneArg() throws CompilerError {
    runCodeAndPoolComparisonTest("foo(bar(1))", new byte[] {
        Opcodes.IPUSHCONST,         0, 0, 0, 2,
        Opcodes.INVOKESELF,         0, 0, 0, 1, 1,
        Opcodes.INVOKESELF,         0, 0, 0, 0, 1  
    }, new CompiledScript.ConstPoolEntry[] {
        new CompiledScript.ConstPoolMethod("foo"),
        new CompiledScript.ConstPoolMethod("bar"),
        new CompiledScript.ConstPoolInt(1)
    });
  }

  @Test
  public void testDoubleNestedFuncCallInnerTwoArgsInnerInnerOneArg() throws CompilerError {
    runCodeAndPoolComparisonTest("foo(bar(1, baz(2)))", new byte[] {
        Opcodes.IPUSHCONST,         0, 0, 0, 2,
        Opcodes.IPUSHCONST,         0, 0, 0, 4,
        Opcodes.INVOKESELF,         0, 0, 0, 3, 1,
        Opcodes.INVOKESELF,         0, 0, 0, 1, 2,  
        Opcodes.INVOKESELF,         0, 0, 0, 0, 1  
    }, new CompiledScript.ConstPoolEntry[] {
        new CompiledScript.ConstPoolMethod("foo"),
        new CompiledScript.ConstPoolMethod("bar"),
        new CompiledScript.ConstPoolInt(1),
        new CompiledScript.ConstPoolMethod("baz"),
        new CompiledScript.ConstPoolInt(2)
    });
  }
  
  @Test
  public void testBasicMethCallNoArgs() throws CompilerError {
    runCodeLocalsAndPoolComparisonTest("foo.bar()", new byte[] {
        Opcodes.LOAD,               0,
        Opcodes.INVOKEDYNAMIC,      0, 0, 0, 0, 0  
    }, new String[] {
        "foo"
    },  new CompiledScript.ConstPoolEntry[] {
        new CompiledScript.ConstPoolMethod("bar")
    });
  }

  @Test
  public void testBasicMethCallOneArg() throws CompilerError {
    runCodeLocalsAndPoolComparisonTest("foo.bar(1)", new byte[] {
        Opcodes.LOAD,               0,
        Opcodes.IPUSHCONST,         0, 0, 0, 1,
        Opcodes.INVOKEDYNAMIC,      0, 0, 0, 0, 1  
    }, new String[] {
        "foo"
    }, new CompiledScript.ConstPoolEntry[] {
        new CompiledScript.ConstPoolMethod("bar"),
        new CompiledScript.ConstPoolInt(1)
    });
  }

  @Test
  public void testBasicMethCallTwoArgs() throws CompilerError {
    runCodeLocalsAndPoolComparisonTest("foo.bar(1,2)", new byte[] {
        Opcodes.LOAD,               0,
        Opcodes.IPUSHCONST,         0, 0, 0, 1,
        Opcodes.IPUSHCONST,         0, 0, 0, 2,
        Opcodes.INVOKEDYNAMIC,      0, 0, 0, 0, 2  
    }, new String[] {
        "foo"
    }, new CompiledScript.ConstPoolEntry[] {
        new CompiledScript.ConstPoolMethod("bar"),
        new CompiledScript.ConstPoolInt(1),
        new CompiledScript.ConstPoolInt(2)
    });
  }

  @Test
  public void testNestedMethToFuncCallOneArg() throws CompilerError {
    runCodeLocalsAndPoolComparisonTest("foo.bar(quux(1))", new byte[] {
        Opcodes.LOAD,               0,
        Opcodes.IPUSHCONST,         0, 0, 0, 2,
        Opcodes.INVOKESELF,         0, 0, 0, 1, 1,
        Opcodes.INVOKEDYNAMIC,      0, 0, 0, 0, 1  
    }, new String[] {
        "foo"
    }, new CompiledScript.ConstPoolEntry[] {
        new CompiledScript.ConstPoolMethod("bar"),
        new CompiledScript.ConstPoolMethod("quux"),
        new CompiledScript.ConstPoolInt(1)
    });
  }

  @Test
  public void testChainedMethodCall() throws CompilerError {
    runCodeLocalsAndPoolComparisonTest("Foo.bar().baz()", new byte[] {
        Opcodes.LOAD,               0,
        Opcodes.INVOKEDYNAMIC,      0, 0, 0, 0, 0,
        Opcodes.INVOKEDYNAMIC,      0, 0, 0, 1, 0
    }, new String[] {
        "Foo"
    }, new CompiledScript.ConstPoolEntry[] {
        new CompiledScript.ConstPoolMethod("bar"),
        new CompiledScript.ConstPoolMethod("baz")
    });
  }
}
