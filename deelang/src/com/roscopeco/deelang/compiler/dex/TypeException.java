package com.roscopeco.deelang.compiler.dex;

import com.roscopeco.deelang.compiler.CompilerError;

public class TypeException extends CompilerError {
  private static final long serialVersionUID = 800485933989812308L;

  public TypeException() {
  }

  public TypeException(String arg0, Throwable arg1) {
    super(arg0, arg1);
  }

  public TypeException(String arg0) {
    super(arg0);
  }

  public TypeException(Throwable arg0) {
    super(arg0);
  }
}
