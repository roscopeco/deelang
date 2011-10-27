/* Unused.java
 *
 * Copyright 2011 Ross Bamford (roscopeco AT gmail DOT com)
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License. 
 */
package com.roscopeco.deelang.compiler;

import java.nio.ByteBuffer;

/**
 * Last stop for unused static utility methods... If they continue
 * to be useless, they'll be deleted eventually...
 * 
 * @author rosco
 * @created 16 Oct 2011
 */
public class Unused {
  public static final byte[] intToByteArray(byte prefix, int value) {
    return new byte[] {
            prefix,
            (byte)(value >>> 24),
            (byte)(value >>> 16),
            (byte)(value >>> 8),
            (byte)value};
  }
  
  public static final byte[] doubleToByteArray(byte prefix, double value) {
    byte[] b = new byte[9];
    b[0] = prefix;
    ByteBuffer buf = ByteBuffer.wrap(b);
    buf.putDouble(1, value);
    return b;
  }
  
  public static final byte[] stringToByteArray(byte prefix, String value) {
    return value.getBytes();
  }
  
  public static final int byteArrayToInt(int index, byte[] b) {
    return (b[index] << 24)
            + ((b[index + 1] & 0xFF) << 16)
            + ((b[index + 2] & 0xFF) << 8)
            + (b[index + 3] & 0xFF);
  }
  
  public static final double byteArrayToDouble(int index, byte[] b) {
    ByteBuffer buf = ByteBuffer.wrap(b);
    return buf.getDouble(index);
  }
  
  public static final String byteArrayToString(int index, byte[] b) {
    return new String(b);
  }
}
