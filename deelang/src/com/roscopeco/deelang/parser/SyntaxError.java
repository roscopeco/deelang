package com.roscopeco.deelang.parser;

public class SyntaxError extends ParserError {

  /**
   * 
   */
  private static final long serialVersionUID = 9131457458625045733L;
  
  private final int pos;

  public SyntaxError(int pos, String message) {
    super(message);
    this.pos = pos;
  }

  public SyntaxError(int pos, String message, Throwable cause) {
    super(message, cause);
    this.pos = pos;
  }

  public int getPos() {
    return pos;
  }
}
