package com.roscopeco.deelang.vm;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import com.roscopeco.deelang.compiler.CompilerError;

public class RegressionTestContext extends RegressionTestBase {
  
  @Test
  public void testIsBlockNextDoesntChokeAtEndOfInput() throws CompilerError {
    Context ctx = createContext("1");  
    ctx.vm.run(ctx);
    assertThat(ctx.isBlockNext(), is(false));
  }

}
