package com.roscopeco.deelang;

public class UnsupportedOperationException extends Exception {

  /**
   * 
   */
  private static final long serialVersionUID = 905395975032282240L;

  public UnsupportedOperationException() {
  }

  public UnsupportedOperationException(String message) {
    super(message);
  }

  public UnsupportedOperationException(Throwable cause) {
    super(cause);
  }

  public UnsupportedOperationException(String message, Throwable cause) {
    super(message, cause);
  }

}
