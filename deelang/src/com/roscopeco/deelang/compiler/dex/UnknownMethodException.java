package com.roscopeco.deelang.compiler.dex;

import com.roscopeco.deelang.compiler.CompilerError;

public class UnknownMethodException extends CompilerError {
  private static final long serialVersionUID = -8556281428943391312L;

  public UnknownMethodException() {
  }

  public UnknownMethodException(String arg0, Throwable arg1) {
    super(arg0, arg1);
  }

  public UnknownMethodException(String arg0) {
    super(arg0);
  }

  public UnknownMethodException(Throwable arg0) {
    super(arg0);
  }
}
