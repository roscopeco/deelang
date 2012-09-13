package com.roscopeco.deelang.compiler.dex;

import static org.junit.Assert.fail;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.util.regex.Pattern;

import com.googlecode.dex2jar.reader.DexFileReader;
import com.googlecode.dex2jar.util.Dump;
import com.googlecode.dex2jar.util.Dump.WriterManager;
import com.roscopeco.deelang.compiler.Compiler;
import com.roscopeco.deelang.compiler.CompilerError;
import com.roscopeco.deelang.parser.Parser;
import com.roscopeco.deelang.parser.ParserError;
import com.roscopeco.deelang.runtime.Binding;
import com.roscopeco.deelang.runtime.CompiledScript;
import com.roscopeco.deelang.runtime.HashBinding;

import dee.lang.DeelangInteger;
import dee.lang.DeelangObject;
import dee.lang.DeelangString;

/**
 * Base class for functional tests on the DEX compiler.
 * 
 * When running tests, if the functest-print-dex system property is set,
 * this will also dump the generated dex code to STDOUT.
 * 
 * You can set this property using the -D java commandline switch,
 * e.g. java -Dfunctest-print-dex -cp {classpath} TestRunner
 * 
 * @author Rosco
 */
public class CompilerFuncTestBase {
  public static final class Foo extends DeelangObject {
    public Foo(Binding binding) {
      super(binding);
    }
    
    public DeelangObject foo() { return null; }  
    public void foo(DeelangInteger a) { }
    public void foo(DeelangInteger a, DeelangInteger b) { }
    public DeelangInteger bar(DeelangInteger a) { return a; }
    public DeelangInteger bar(DeelangInteger a, DeelangInteger b) { return a; }
    public DeelangInteger bar(DeelangInteger a, DeelangString b) { return a; }
    public DeelangInteger baz() { return null; }
    public Foo boo() { return this; }
    public void voidy() { }
    public DeelangString baz(DeelangInteger a) { return new DeelangString(getBinding(), "BAZ"); }
    public DeelangInteger quux(DeelangInteger a) { return a; }
  }
  
  public Binding getTestBinding() {
    HashBinding b = new HashBinding();
    b.setSelf(new Foo(b));
    b.setLocal("foo", b.getSelf());
    b.setLocal("a", b.getSelf());
    b.setLocal("b", b.getSelf());
    return b;
  }
  
  DexCompilationUnit runTest(String code, Class<? extends CompiledScript> superClz, Binding binding) throws ParserError, CompilerError {
    Compiler c = new Compiler();
    return c.compile(new DexCompilationUnit("UNITTESTS", superClz, binding), Parser.staticParse(code));
  }
  
  DexCompilationUnit runTest(String code, Class<? extends CompiledScript> superClz) throws ParserError, CompilerError {
    Compiler c = new Compiler();
    return c.compile(new DexCompilationUnit("UNITTESTS", superClz, getTestBinding()), Parser.staticParse(code));
  }
  
  DexCompilationUnit runTest(String code) throws ParserError, CompilerError {
    Compiler c = new Compiler();
    return c.compile(new DexCompilationUnit("UNITTESTS", getTestBinding()), Parser.staticParse(code));
  }
  
  DexCompilationUnit runTest(String code, Binding binding) throws ParserError, CompilerError {
    Compiler c = new Compiler();
    return c.compile(new DexCompilationUnit("UNITTESTS", binding), Parser.staticParse(code));
  }
  
  void runCodeComparisonTest(String code, Binding binding, Class<? extends CompiledScript> superClz, 
      String expectSuper, String... methods) throws ParserError, CompilerError {
    
    // Test here rather than passing default through from non-superClz overload,
    // to check that the non-superClz constructor on CompUnit handles this correctly.
    DexFileReader rdr;
    if (superClz == null) {
      rdr = new DexFileReader(runTest(code).getCode());
    } else {
      rdr = new DexFileReader(runTest(code, superClz).getCode());      
    }
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    
    rdr.accept(new Dump(new WriterManager() {
      @Override
      public PrintWriter get(String arg0) {
        return new PrintWriter(bos);
      }
    }));
    
    if (System.getProperty("functest-print-dex") != null) {
      System.out.println(bos.toString());
    }
    
    String result = bos.toString().replaceAll("\r", "");
    
    if (!result.contains(expectSuper)) {
      fail("Superclass '" + expectSuper + "' not found in\n\n" + result);
    }
    
    for (String method : methods) {
      String methodrx = java.util.regex.Pattern.quote(method).replaceAll("__UUID__", "\\\\E[0-9a-f\\\\-]+\\\\Q");
      Pattern p = Pattern.compile(methodrx, Pattern.MULTILINE);
      if (!p.matcher(result).find()) {
        fail("Didn't find\n\n" + method + "\n\n in\n\n" + result);
      }
    }
  }
  
  void runCodeComparisonTest(String code, String expectSuper, String... methods) 
      throws ParserError, CompilerError {
    this.runCodeComparisonTest(code, null, null, expectSuper, methods);
  }
  
  void runCodeComparisonTest(String code, Binding binding, String expectSuper, String... methods) 
      throws ParserError, CompilerError {
    this.runCodeComparisonTest(code, binding, null, expectSuper, methods);
  }
}
