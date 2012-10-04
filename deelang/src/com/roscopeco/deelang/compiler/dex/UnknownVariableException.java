package com.roscopeco.deelang.compiler.dex;

import com.roscopeco.deelang.compiler.CompilerError;

public class UnknownVariableException extends CompilerError {
  private static final long serialVersionUID = 3503116832410812195L;

  public UnknownVariableException() {
  }

  public UnknownVariableException(String arg0, Throwable arg1) {
    super("Unknown variable '" + arg0 + "'", arg1);
  }

  public UnknownVariableException(String arg0) {
    super("Unknown variable '" + arg0 + "'");
  }

  public UnknownVariableException(Throwable arg0) {
    super(arg0);
  }
}
