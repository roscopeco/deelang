package com.roscopeco.deelang.compiler.dvm;

import org.junit.Test;

import com.roscopeco.deelang.Opcodes;
import com.roscopeco.deelang.compiler.CompilerError;
import com.roscopeco.deelang.compiler.dvm.CompiledScript;
import com.roscopeco.deelang.parser.ParserError;

public class FuncTestCompilerCombinedFieldMethodChaining extends CompilerFuncTestBase {
  @Test
  public void testMemberAccessAfterMethod() throws ParserError, CompilerError {
    runCodeLocalsAndPoolComparisonTest("Quux.qix().baz", new byte[] {
        Opcodes.LOAD,               0,
        Opcodes.INVOKEDYNAMIC_B,    0, 0,
        Opcodes.GETFIELD_B,         1
    }, new String[] {
        "Quux"
    }, new CompiledScript.ConstPoolEntry[] {
        new CompiledScript.ConstPoolMethod("qix"),
        new CompiledScript.ConstPoolField("baz")
    });
  }

  @Test
  public void testMethodAfterMemberAccess() throws ParserError, CompilerError {
    runCodeLocalsAndPoolComparisonTest("Quux.baz.qix()", new byte[] {
        Opcodes.LOAD,               0,
        Opcodes.GETFIELD_B,         0,
        Opcodes.INVOKEDYNAMIC_B,    1, 0
    }, new String[] {
        "Quux"
    }, new CompiledScript.ConstPoolEntry[] {
        new CompiledScript.ConstPoolField("baz"),
        new CompiledScript.ConstPoolMethod("qix")
    });
  }

  @Test
  public void testMethodAfterMemberAccessAfterMethod() throws ParserError, CompilerError {
    runCodeLocalsAndPoolComparisonTest("Quux.qix().baz.beez()", new byte[] {
        Opcodes.LOAD,               0,
        Opcodes.INVOKEDYNAMIC_B,    0, 0,
        Opcodes.GETFIELD_B,         1,
        Opcodes.INVOKEDYNAMIC_B,    2, 0
    }, new String[] {
        "Quux"
    }, new CompiledScript.ConstPoolEntry[] {
        new CompiledScript.ConstPoolMethod("qix"),
        new CompiledScript.ConstPoolField("baz"),
        new CompiledScript.ConstPoolMethod("beez")
    });
  }
}
