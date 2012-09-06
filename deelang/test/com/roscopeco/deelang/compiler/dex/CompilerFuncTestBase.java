package com.roscopeco.deelang.compiler.dex;

import static org.junit.Assert.fail;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;

import com.googlecode.dex2jar.reader.DexFileReader;
import com.googlecode.dex2jar.util.Dump;
import com.googlecode.dex2jar.util.Dump.WriterManager;
import com.roscopeco.deelang.compiler.Compiler;
import com.roscopeco.deelang.compiler.CompilerError;
import com.roscopeco.deelang.parser.Parser;
import com.roscopeco.deelang.parser.ParserError;

public class CompilerFuncTestBase {
  /* dex\n035\0 */
  protected static final byte[] DEX_SIG = new byte[] { 100, 101, 120, 10, 48, 51, 53, 0 };
  
  DexCompilationUnit runTest(String code) throws ParserError, CompilerError {
    Compiler c = new Compiler();
    return (DexCompilationUnit) c.compile(
        new DexCompilationUnit(c, "UNITTESTS"), Parser.staticParse(code));
  }
  
  void runCodeComparisonTest(String code, String superClz, String... methods) throws ParserError, CompilerError {
    DexFileReader rdr = new DexFileReader(runTest(code).getCode());
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    
    rdr.accept(new Dump(new WriterManager() {
      @Override
      public PrintWriter get(String arg0) {
        return new PrintWriter(bos);
      }
    }));
    
    String result = bos.toString().replaceAll("\r", "");
    
    if (!result.contains(superClz)) {
      fail("Superclass '" + superClz + "' not found in\n\n" + result);
    }
    
    for (String method : methods) {
      if (!result.contains(method)) {
        fail("Didn't find\n\n" + method + "\n\n in\n\n" + result);
      }
    }
  }
}
