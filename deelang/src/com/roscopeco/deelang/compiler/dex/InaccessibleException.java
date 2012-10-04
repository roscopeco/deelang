package com.roscopeco.deelang.compiler.dex;

import com.roscopeco.deelang.compiler.CompilerError;

public class InaccessibleException extends CompilerError {
  private static final long serialVersionUID = -409732755659805062L;

  public InaccessibleException() {
  }

  public InaccessibleException(String arg0, Throwable arg1) {
    super(arg0, arg1);
  }

  public InaccessibleException(String arg0) {
    super(arg0);
  }

  public InaccessibleException(Throwable arg0) {
    super(arg0);
  }
}
