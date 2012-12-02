package com.roscopeco.deelang.runtime.deevm;

import org.junit.Before;
import org.junit.Test;

import com.roscopeco.deelang.compiler.Compiler;
import com.roscopeco.deelang.compiler.deevm.DVMCompilationUnit;
import com.roscopeco.deelang.runtime.deevm.RuntimeContext;
import com.roscopeco.deelang.runtime.deevm.VM;
import com.roscopeco.deelang.runtime.dex.DexBinding;

import dee.lang.Binding;
import dee.lang.DeelangInteger;
import dee.lang.DeelangObject;

public class RegressionTestStackUnderflowOnMultipleRunAssignLocalMethodCallWithBinExprArg
    extends RegressionTestBase {
  public static final class Foo extends DeelangObject {
    public Foo(Binding binding) {
      super(binding);
    }

    public DeelangInteger timesTwo(DeelangInteger i) {
      return new DeelangInteger(getBinding(), i.getInteger() * 2);
    }
  }

  private static final String CODE = "a = foo.timesTwo(3+2)";

  com.roscopeco.deelang.compiler.deevm.CompiledScript deevmScript;
  DexBinding dexBinding;
  VM deevm = new VM();
  RuntimeContext deeContext;

  @Before
  public void setUp() throws Exception {
    Compiler c = new Compiler();
    deevmScript = c.compile(new DVMCompilationUnit(), CODE).buildScript();
    deeContext = deevm.createContext(deevmScript);
    deeContext.setSelf(new DeelangObject(deeContext));
    deeContext.setLocal("foo", new Foo(deeContext));
  }

  @Test
  public void testBenchmark() {
    System.out.println("About to run test");
    for (int i = 0; i < 2; i++) { 
      deevm.run(deeContext);
    }
  }
}
