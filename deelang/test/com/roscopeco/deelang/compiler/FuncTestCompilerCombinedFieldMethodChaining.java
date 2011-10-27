package com.roscopeco.deelang.compiler;

import org.junit.Test;

import com.roscopeco.deelang.Opcodes;

public class FuncTestCompilerCombinedFieldMethodChaining extends CompilerFuncTestBase {
  @Test
  public void testMemberAccessAfterMethod() throws CompilerError {
    runCodeLocalsAndPoolComparisonTest("Quux.qix().baz", new byte[] {
        Opcodes.LOAD,               0,
        Opcodes.INVOKEDYNAMIC,      0, 0, 0, 0, 0,
        Opcodes.GETFIELD,           0, 0, 0, 1
    }, new String[] {
        "Quux"
    }, new CompiledScript.ConstPoolEntry[] {
        new CompiledScript.ConstPoolMethod("qix"),
        new CompiledScript.ConstPoolField("baz")
    });
  }

  @Test
  public void testMethodAfterMemberAccess() throws CompilerError {
    runCodeLocalsAndPoolComparisonTest("Quux.baz.qix()", new byte[] {
        Opcodes.LOAD,               0,
        Opcodes.GETFIELD,           0, 0, 0, 0,
        Opcodes.INVOKEDYNAMIC,      0, 0, 0, 1, 0
    }, new String[] {
        "Quux"
    }, new CompiledScript.ConstPoolEntry[] {
        new CompiledScript.ConstPoolField("baz"),
        new CompiledScript.ConstPoolMethod("qix")
    });
  }

  @Test
  public void testMethodAfterMemberAccessAfterMethod() throws CompilerError {
    runCodeLocalsAndPoolComparisonTest("Quux.qix().baz.beez()", new byte[] {
        Opcodes.LOAD,               0,
        Opcodes.INVOKEDYNAMIC,      0, 0, 0, 0, 0,
        Opcodes.GETFIELD,           0, 0, 0, 1,
        Opcodes.INVOKEDYNAMIC,      0, 0, 0, 2, 0
    }, new String[] {
        "Quux"
    }, new CompiledScript.ConstPoolEntry[] {
        new CompiledScript.ConstPoolMethod("qix"),
        new CompiledScript.ConstPoolField("baz"),
        new CompiledScript.ConstPoolMethod("beez")
    });
  }
}
