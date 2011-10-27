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

import org.antlr.runtime.RecognitionException;

import com.roscopeco.deelang.UnsupportedOperationException;
import com.roscopeco.deelang.compiler.CompiledScript;
import com.roscopeco.deelang.compiler.Compiler;
import com.roscopeco.deelang.compiler.CompilerError;
import com.roscopeco.deelang.parser.Parser;

/**
 * Static easy-entry points into the Dee API. 
 * <br/>
 * This class provides static methods that wrap up the parsing and
 * compilation of DeeLang scripts into single calls. It is 
 * designed to cover the most common cases, so you don't have to
 * worry about the internals too much...
 * 
 * @author rosco
 * @created 16 Oct 2011
 */
public final class DeeLang {
  private DeeLang() throws UnsupportedOperationException {
    throw new UnsupportedOperationException("Please don't do that :|");
  }
  
  public static CompiledScript compileScript(String code) 
      throws RecognitionException, CompilerError {
    return Compiler.staticCompile(Parser.staticParse(code));
  }
  
  public static void runScript(String code) throws UnsupportedOperationException {
    throw new UnsupportedOperationException("Not yet implemented");
  }
}
