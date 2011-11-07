/* DeeLang.java - Static entry points into Dee API.
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

import com.roscopeco.deelang.UnsupportedOperationException;
import com.roscopeco.deelang.compiler.CompiledScript;
import com.roscopeco.deelang.compiler.Compiler;
import com.roscopeco.deelang.compiler.CompilerError;
import com.roscopeco.deelang.compiler.ParseError;
import com.roscopeco.deelang.parser.Parser;
import com.roscopeco.deelang.parser.ParserError;
import com.roscopeco.deelang.vm.Context;
import com.roscopeco.deelang.vm.RuntimeError;
import com.roscopeco.deelang.vm.VM;

/**
 * Static easy-entry points into the Dee API. 
 * <br/>
 * This class provides static methods that wrap up the parsing,
 * compilation and execution of DeeLang scripts into single calls.
 * It is designed to cover the most common cases, so you don't 
 * have to worry about the internals too much...
 * 
 * @author rosco
 * @created 16 Oct 2011
 */
public final class DeeLang {
  /**
   * <p>Implementations of this inteface receive a callback 
   * when a VM context is created, before a script is run
   * by the {@link DeeLang.runScript} method.</p>
   * 
   * @author rosco
   */
  public interface ContextInitialiser {
    /**
     * <p>During the call to the implementation
     * should set the context's self and any local variables.</p>
     * 
     * @param context The new context. 
     */
    public void initContext(Context context);
  }
  
  private DeeLang() throws UnsupportedOperationException {
    throw new UnsupportedOperationException("Please don't do that :|");
  }
  
  /**
   * Compile the supplied Deelang code.
   * 
   * @param code The code to compile.
   * @return The {@link CompiledScript} for the supplied code.
   * 
   * @throws CompilerError To indicate a problem during compilation.
   */
  public static CompiledScript compileScript(String code) 
      throws CompilerError {
    try {
      return Compiler.staticCompile(Parser.staticParse(code));
    } catch (ParserError e) {
      throw new ParseError(e);
    }
  }
  
  /**
   * Run the supplied compiled script.
   * 
   * @param script The compiled script.
   * @param initialiser The context initialiser callback.
   * @throws CompilerError To indicate a problem during compilation.
   * @throws RuntimeError To indicate an error at runtime.
   */
  public static void runScript(CompiledScript script, ContextInitialiser initialiser) throws CompilerError, RuntimeError {
    VM vm = new VM();
    Context context = vm.createContext(script);
    initialiser.initContext(context);
    vm.run(context);
  }

  /**
   * Compiled and run the supplied DeeLang code.
   * 
   * @param code The code to run.
   * @param initialiser The context initialiser callback.
   * @throws CompilerError To indicate a problem during compilation.
   * @throws RuntimeError To indicate an error at runtime.
   */
  public static void runScript(String code, ContextInitialiser initialiser) throws CompilerError, RuntimeError {
    runScript(Compiler.staticCompile(code), initialiser);
  }
}
