/* Main.g - Testbed/sandbox for DeeLang development...
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
package com.roscopeco.deelang;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.Tree;

import com.roscopeco.deelang.compiler.CompiledScript;
import com.roscopeco.deelang.compiler.Compiler;
import com.roscopeco.deelang.compiler.CompilerError;
import com.roscopeco.deelang.parser.Parser;
import com.roscopeco.deelang.runtime.DeeLangInteger;
import com.roscopeco.deelang.runtime.DeeLangObject;
import com.roscopeco.deelang.runtime.DeeLangString;
import com.roscopeco.deelang.vm.Context;
import com.roscopeco.deelang.vm.RuntimeError;
import com.roscopeco.deelang.vm.VM;

/**
 * Just a testbed/sandbox for use during development. NOT FOR INCLUSION IN DISTRIBUTION!
 * 
 * @author rosco
 * @created 21 Oct 2011
 */
public class Main {  
  static String code =
        "Quux.qix = 42\n" +
  		"Quux.foo(Quux.qix, bar(3+4), beezum) {\n" +
        "  booze() or {\n" +
  		"    puts(\"hello in orblock\")\n" +
        "  }\n" +
  		"}\n" + 
        "3.times() {\n" +
  		"  puts(\"Hello out of block\")\n"+
        "}\n";
  
  public static class BarObj extends DeeLangObject {
    public BarObj(Context ctx) {
      super(ctx);
    }
    
    public DeeLangString bar(DeeLangInteger i) {
      return new DeeLangString(getContext(), "BAR " + i);
    }
  }
  
  public static class FooObj extends DeeLangObject {
    public DeeLangObject qix;
    
    public FooObj(Context ctx) {
      super(ctx);
    }
    
    public void foo(DeeLangInteger i, DeeLangString s, DeeLangInteger j) throws RuntimeError {
      System.out.println("Foo called with [" + i + ", " + s + ", " + j + "]");
      System.out.println("Calling block...");
      DeeLangObject oldSelf = getContext().getSelf();
      getContext().setSelf(this);
      if (callBlock()) {
        System.out.println("Back - block executed");
      } else {
        System.out.println("Back - block not executed");
      }
      getContext().setSelf(oldSelf);
    }
    
    public void booze() throws RuntimeError {
      puts("IN BOOZE:");
      if (!callBlock()) {
        puts("Setting error flag");
        getContext().setErrorFlag();
      }
      puts("LEAVING BOOZE");
    }
    
    public void puts(DeeLangString s) {
      System.out.println("FooObj.puts: " + s);
    }
  }
    
  public static void main(String[] args) {
    if (args.length > 0) {
      StringBuffer sb = new StringBuffer();
      
      for (String arg : args) {
        sb.append(arg);
      }
      
      code = sb.toString();
    }
    
    Tree codeAST;
    CompiledScript script;
    
    System.out.println("Original code:\n"+code + "\n");
    
    try {
      codeAST = Parser.staticParse(code);
    } catch (RecognitionException e) {
      System.err.println("DeeLang Parser Exception: " + e);
      e.printStackTrace(System.err);
      Runtime.getRuntime().exit(-1);
      return;
    }
    
    try {
      script = Compiler.staticCompile(codeAST);
      System.out.println( ScriptDumper.dumpScript(script));
    } catch (CompilerError e) {
      System.err.println("DeeLang Compiler Exception: " + e);
      e.printStackTrace(System.err);
      Runtime.getRuntime().exit(-2);
      return;  
    }
        
    try {       
      VM vm = new VM();
      Context ctx = vm.createContext(script);
      ctx.setSelf(new BarObj(ctx));
      ctx.setLocal("Quux", new FooObj(ctx));
      ctx.setLocal("beezum", new DeeLangInteger(ctx, 10));
      vm.run(ctx);
      
      System.out.println("Finished exec: FooObj's qix field now = '" + ((FooObj)ctx.getLocal("Quux")).qix + "'");
    } catch (RuntimeError e) {
      System.err.println("DeeLang runtime exception: " + e);
      e.printStackTrace(System.err);
      Runtime.getRuntime().exit(-3);
      return;
    }
    
    /*
    try {
      result = Interpreter.staticInterpret(codeAST);
    } catch (DroidLangThrowable e) {
      System.err.println("DeeLang Runtime Exception: " + e);
      e.printStackTrace(System.err);
      Runtime.getRuntime().exit(-3);
      return;
    }
    */
    //System.out.println("Normal termination; Result = " + result);
  }
}
 