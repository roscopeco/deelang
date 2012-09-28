package com.roscopeco.deelang.compiler.deevm;

import org.junit.Test;

import com.roscopeco.deelang.Opcodes;
import com.roscopeco.deelang.compiler.CompilerError;
import com.roscopeco.deelang.compiler.deevm.CompiledScript;
import com.roscopeco.deelang.parser.ParserError;

public class FuncTestCompilerMethodCalls extends CompilerFuncTestBase {

  @Test
  public void testBasicFuncCallNoArgs() throws ParserError, CompilerError {
    runCodeAndPoolComparisonTest("foo()", new byte[] {
        Opcodes.INVOKESELF_B,       0, 0  
    }, new CompiledScript.ConstPoolEntry[] {
        new CompiledScript.ConstPoolMethod("foo")
    });
  }

  @Test
  public void testBasicFuncCallOneArg() throws ParserError, CompilerError {
    runCodeAndPoolComparisonTest("foo(1)", new byte[] {
        Opcodes.IPUSHCONST_B,       1,
        Opcodes.INVOKESELF_B,       0, 1  
    }, new CompiledScript.ConstPoolEntry[] {
        new CompiledScript.ConstPoolMethod("foo"),
        new CompiledScript.ConstPoolInt(1)
    });
  }

  @Test
  public void testBasicFuncCallTwoArgs() throws ParserError, CompilerError {
    runCodeAndPoolComparisonTest("foo(1,2)", new byte[] {
        Opcodes.IPUSHCONST_B,       1,
        Opcodes.IPUSHCONST_B,       2,
        Opcodes.INVOKESELF_B,       0, 2  
    }, new CompiledScript.ConstPoolEntry[] {
        new CompiledScript.ConstPoolMethod("foo"),
        new CompiledScript.ConstPoolInt(1),
        new CompiledScript.ConstPoolInt(2)
    });
  }

  @Test
  public void testNestedFuncCallOneArg() throws ParserError, CompilerError {
    runCodeAndPoolComparisonTest("foo(bar(1))", new byte[] {
        Opcodes.IPUSHCONST_B,       2,
        Opcodes.INVOKESELF_B,       1, 1,
        Opcodes.INVOKESELF_B,       0, 1  
    }, new CompiledScript.ConstPoolEntry[] {
        new CompiledScript.ConstPoolMethod("foo"),
        new CompiledScript.ConstPoolMethod("bar"),
        new CompiledScript.ConstPoolInt(1)
    });
  }

  @Test
  public void testDoubleNestedFuncCallInnerTwoArgsInnerInnerOneArg() throws ParserError, CompilerError {
    runCodeAndPoolComparisonTest("foo(bar(1, baz(2)))", new byte[] {
        Opcodes.IPUSHCONST_B,       2,
        Opcodes.IPUSHCONST_B,       4,
        Opcodes.INVOKESELF_B,       3, 1,
        Opcodes.INVOKESELF_B,       1, 2,  
        Opcodes.INVOKESELF_B,       0, 1  
    }, new CompiledScript.ConstPoolEntry[] {
        new CompiledScript.ConstPoolMethod("foo"),
        new CompiledScript.ConstPoolMethod("bar"),
        new CompiledScript.ConstPoolInt(1),
        new CompiledScript.ConstPoolMethod("baz"),
        new CompiledScript.ConstPoolInt(2)
    });
  }
  
  @Test
  public void testBasicMethCallNoArgs() throws ParserError, CompilerError {
    runCodeLocalsAndPoolComparisonTest("foo.bar()", new byte[] {
        Opcodes.LOAD,               0,
        Opcodes.INVOKEDYNAMIC_B,    0, 0  
    }, new String[] {
        "foo"
    },  new CompiledScript.ConstPoolEntry[] {
        new CompiledScript.ConstPoolMethod("bar")
    });
  }

  @Test
  public void testBasicMethCallOneArg() throws ParserError, CompilerError {
    runCodeLocalsAndPoolComparisonTest("foo.bar(1)", new byte[] {
        Opcodes.LOAD,               0,
        Opcodes.IPUSHCONST_B,       1,
        Opcodes.INVOKEDYNAMIC_B,    0, 1  
    }, new String[] {
        "foo"
    }, new CompiledScript.ConstPoolEntry[] {
        new CompiledScript.ConstPoolMethod("bar"),
        new CompiledScript.ConstPoolInt(1)
    });
  }

  @Test
  public void testBasicMethCallTwoArgs() throws ParserError, CompilerError {
    runCodeLocalsAndPoolComparisonTest("foo.bar(1,2)", new byte[] {
        Opcodes.LOAD,               0,
        Opcodes.IPUSHCONST_B,       1,
        Opcodes.IPUSHCONST_B,       2,
        Opcodes.INVOKEDYNAMIC_B,    0, 2  
    }, new String[] {
        "foo"
    }, new CompiledScript.ConstPoolEntry[] {
        new CompiledScript.ConstPoolMethod("bar"),
        new CompiledScript.ConstPoolInt(1),
        new CompiledScript.ConstPoolInt(2)
    });
  }

  @Test
  public void testNestedMethToFuncCallOneArg() throws ParserError, CompilerError {
    runCodeLocalsAndPoolComparisonTest("foo.bar(quux(1))", new byte[] {
        Opcodes.LOAD,               0,
        Opcodes.IPUSHCONST_B,       2,
        Opcodes.INVOKESELF_B,       1, 1,
        Opcodes.INVOKEDYNAMIC_B,    0, 1  
    }, new String[] {
        "foo"
    }, new CompiledScript.ConstPoolEntry[] {
        new CompiledScript.ConstPoolMethod("bar"),
        new CompiledScript.ConstPoolMethod("quux"),
        new CompiledScript.ConstPoolInt(1)
    });
  }

  @Test
  public void testChainedMethodCall() throws ParserError, CompilerError {
    runCodeLocalsAndPoolComparisonTest("Foo.bar().baz()", new byte[] {
        Opcodes.LOAD,               0,
        Opcodes.INVOKEDYNAMIC_B,    0, 0,
        Opcodes.INVOKEDYNAMIC_B,    1, 0
    }, new String[] {
        "Foo"
    }, new CompiledScript.ConstPoolEntry[] {
        new CompiledScript.ConstPoolMethod("bar"),
        new CompiledScript.ConstPoolMethod("baz")
    });
  }
  
  /* ******** BLOCKS ******* */
  /* NOTE: The following test makes sure empty blocks are optimized out */
  @Test
  public void testMethodCallNoArgsWithEmptyBlockGetsOptimizedAway() throws ParserError, CompilerError {
    runCodeLocalsAndPoolComparisonTest("bar() { }", new byte[] {
        Opcodes.INVOKESELF_B,         0, 0
    }, new String[] {
    }, new CompiledScript.ConstPoolEntry[] {
        new CompiledScript.ConstPoolMethod("bar"),
    });
  }

  @Test
  public void testMethodCallNoArgsWithSingleInsnBlock() throws ParserError, CompilerError {
    runCodeLocalsAndPoolComparisonTest("bar() { baz }", new byte[] {
        Opcodes.INVOKESELF_B,         0, 0,
        Opcodes.JUMP_B,               4,
        Opcodes.ENTERBLOCK_B,         2,
        Opcodes.LOAD,                 0
    }, new String[] {
        "baz"
    }, new CompiledScript.ConstPoolEntry[] {
        new CompiledScript.ConstPoolMethod("bar"),
    });
  }

  @Test
  public void testMethodCallNoArgsWithTwoInsnBlock() throws ParserError, CompilerError {
    runCodeLocalsAndPoolComparisonTest("bar() { baz; bee; }", new byte[] {
        Opcodes.INVOKESELF_B,         0, 0,
        Opcodes.JUMP_B,               6,
        Opcodes.ENTERBLOCK_B,         4,
        Opcodes.LOAD,                 0,
        Opcodes.LOAD,                 1
    }, new String[] {
        "baz",
        "bee"
    }, new CompiledScript.ConstPoolEntry[] {
        new CompiledScript.ConstPoolMethod("bar"),
    });
  }

  @Test
  public void testMethodCallNoArgsWithMoreThanTwoInsnBlock() throws ParserError, CompilerError {
    runCodeLocalsAndPoolComparisonTest("bar() { baz; bee; foo; quux; qix }", new byte[] {
        Opcodes.INVOKESELF_B,         0, 0,
        Opcodes.JUMP_B,               12,
        Opcodes.ENTERBLOCK_B,         10,
        Opcodes.LOAD,                 0,
        Opcodes.LOAD,                 1,
        Opcodes.LOAD,                 2,
        Opcodes.LOAD,                 3,
        Opcodes.LOAD,                 4,
    }, new String[] {
        "baz",
        "bee",
        "foo",
        "quux",
        "qix"
    }, new CompiledScript.ConstPoolEntry[] {
        new CompiledScript.ConstPoolMethod("bar"),
    });
  }
}
