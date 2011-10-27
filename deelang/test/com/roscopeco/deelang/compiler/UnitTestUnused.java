package com.roscopeco.deelang.compiler;

import static org.junit.Assert.*;

import org.junit.Test;

import com.roscopeco.deelang.compiler.Unused;

public class UnitTestUnused {

  @Test
  public void testIntToFromByteArray() {
    int i = Integer.MAX_VALUE;  
    assertEquals(i, Unused.byteArrayToInt(1, Unused.intToByteArray((byte)0, i)));

    i = Integer.MIN_VALUE;  
    assertEquals(i, Unused.byteArrayToInt(1, Unused.intToByteArray((byte)0, i)));
  }

  @Test
  public void testDoubleToFromByteArray() {
    double i = Double.MAX_VALUE;    
    assertEquals(i, Unused.byteArrayToDouble(1, Unused.doubleToByteArray((byte)0, i)), 0);

    i = Double.MIN_VALUE;    
    assertEquals(i, Unused.byteArrayToDouble(1, Unused.doubleToByteArray((byte)0, i)), 0);
  }

  @Test
  public void testStringToFromByteArray() {
    String i = "onetwothree";    
    assertEquals(i, Unused.byteArrayToString(1, Unused.stringToByteArray((byte)0, i)));

    i = "";    
    assertEquals(i, Unused.byteArrayToString(1, Unused.stringToByteArray((byte)0, i)));
  }

}
