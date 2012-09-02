/* JarTest.java - Testbed for the different jars...
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
package com.roscopeco.deelang.jartest;

import com.roscopeco.deelang.compiler.CompiledScript;
import com.roscopeco.deelang.compiler.Compiler;
import com.roscopeco.deelang.compiler.CompilerError;
import com.roscopeco.deelang.parser.ParserError;
import com.roscopeco.deelang.vm.RuntimeContext;
import com.roscopeco.deelang.vm.RuntimeError;
import com.roscopeco.deelang.vm.VM;

import deelang.DeeLangInteger;
import deelang.DeeLangObject;

public class JarTest {  
  static String code =
      "Quux.qix = 42\n" +
  		"3.times() { Quux.qix = Quux.qix + beezum }\n";
  
  public static class QuuxObj extends DeeLangObject {
    public DeeLangInteger qix;
    
    public QuuxObj(RuntimeContext ctx) {
      super(ctx);
    }
  }
    
  public static void main(String[] args) throws ParserError {
    CompiledScript script;
    
    try {
      script = Compiler.staticCompile(code);
    } catch (CompilerError e) {
      System.err.println("DeeLang Compiler Exception: " + e);
      e.printStackTrace(System.err);
      Runtime.getRuntime().exit(-2);
      return;  
    }
        
    try {
      QuuxObj quux;
      VM vm = new VM();
      RuntimeContext ctx = vm.createContext(script);
      ctx.setSelf(new DeeLangObject(ctx));
      ctx.setLocal("Quux", quux = new QuuxObj(ctx));
      ctx.setLocal("beezum", new DeeLangInteger(ctx, 10));
      vm.run(ctx);
      
      if (quux.qix.getInteger() != 72) {
        // failed
        System.out.println("Quux.qix at end is " + quux.qix + ", not 72 as expected");
        Runtime.getRuntime().exit(-3);
      } else {
        System.out.println("Passed; Quux.qix at end is 72");
      }
    } catch (RuntimeError e) {
      System.err.println("DeeLang runtime exception: " + e);
      e.printStackTrace(System.err);
      Runtime.getRuntime().exit(-3);
      return;
    }
  }
}
 
