package com.roscopeco.deelang.parser;

public class ParserError extends Exception {

  /**
   * 
   */
  private static final long serialVersionUID = -1738595534668314196L;

  public ParserError() {
  }

  public ParserError(String message) {
    super(message);
  }

  public ParserError(Throwable cause) {
    super(cause);
  }

  public ParserError(String message, Throwable cause) {
    super(message, cause);
  }

}
