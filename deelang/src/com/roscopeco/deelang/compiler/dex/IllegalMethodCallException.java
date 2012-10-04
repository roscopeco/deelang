package com.roscopeco.deelang.compiler.dex;

import com.roscopeco.deelang.compiler.CompilerError;

public class IllegalMethodCallException extends CompilerError {
  private static final long serialVersionUID = -6942054880043067067L;

  public IllegalMethodCallException() {
  }

  public IllegalMethodCallException(String arg0, Throwable arg1) {
    super("Illegal method call: '" + arg0 + "'", arg1);
  }

  public IllegalMethodCallException(String arg0) {
    super("Illegal method call: '" + arg0 + "'");
  }

  public IllegalMethodCallException(Throwable arg0) {
    super(arg0);
  }
}
