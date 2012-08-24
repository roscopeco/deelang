/* BytecodeInputStream.java
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
package com.roscopeco.deelang.vm;

import java.io.IOException;
import java.io.InputStream;

/**
 * A custom <code>InputStream</code> that wraps a byte array,
 * and gives access to the program counter.
 * 
 * @author rosco
 * @created 23 Oct 2011
 *
 */
public class BytecodeInputStream extends InputStream {
  private final byte[] code;
  private final int codeLen;
  private int pc;
  private int mark;
  private int readleft;
  
  public BytecodeInputStream(byte[] code) {
    this.code = code;
    this.codeLen = code.length;
    this.pc = 0;
  }

  @Override
  public int available() throws IOException {
    return codeLen - pc;
  }

  @Override
  public synchronized void mark(int readlimit) {
    mark = pc;
    readleft = readlimit;
  }

  @Override
  public boolean markSupported() {
    return true;
  }

  @Override
  public int read() throws IOException {
    if (pc >= codeLen) { 
      return -1;
    } else {
      byte b = code[pc++];
      
      if (mark > -1) {
        if (--readleft < 0) {
          // invalidate mark
          mark = -1;
        }
      }
      
      return b;
    }
  }

  @Override
  public synchronized void reset() throws IOException {
    if (mark > -1) {
      pc = mark;
    } else {
      pc = 0;
    }
  }

  @Override
  public long skip(long n) throws IOException {
    pc += n;
    return n;
  }
  
  public int getPc() {
    return pc;
  }
  
  public void setPc(int pc) {
    this.pc = pc;
  }
}
