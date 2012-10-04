package com.roscopeco.deelang.compiler.dex;

import com.roscopeco.deelang.compiler.CompilerError;

public class UnknownFieldException extends CompilerError {
  private static final long serialVersionUID = -1362419132248145998L;

  public UnknownFieldException() {
  }

  public UnknownFieldException(String arg0, Throwable arg1) {
    super(arg0, arg1);
  }

  public UnknownFieldException(String arg0) {
    super(arg0);
  }

  public UnknownFieldException(Throwable arg0) {
    super(arg0);
  }
}
