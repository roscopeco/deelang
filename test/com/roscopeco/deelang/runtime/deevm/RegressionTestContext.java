package com.roscopeco.deelang.runtime.deevm;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import com.roscopeco.deelang.compiler.CompilerError;
import com.roscopeco.deelang.parser.ParserError;
import com.roscopeco.deelang.runtime.deevm.RuntimeContext;

public class RegressionTestContext extends RegressionTestBase {
  
  @Test
  public void testIsBlockNextDoesntChokeAtEndOfInput() throws ParserError, CompilerError {
    RuntimeContext ctx = createContext("1");  
    ctx.vm.run(ctx);
    assertThat(ctx.isBlockNext(), is(false));
  }

}
