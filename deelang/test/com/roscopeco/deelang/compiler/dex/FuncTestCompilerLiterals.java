package com.roscopeco.deelang.compiler.dex;

import org.junit.Test;

import com.roscopeco.deelang.compiler.CompilerError;
import com.roscopeco.deelang.parser.ParserError;

public class FuncTestCompilerLiterals extends CompilerFuncTestBase {

  @Test
  public void testIntegerLiteral() throws ParserError, CompilerError {
    runCodeComparisonTest("1", 
        "extends com.roscopeco.deelang.runtime.CompiledScript",
            "public V run(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.Binding)\n"+
            "                this:v2   //DexCompiledScript__UUID__\n"+
            "                    :v3   //dee.lang.DeelangObject\n"+
            "                    :v4   //com.roscopeco.deelang.runtime.Binding\n"+
            "CONST               |     |v1=0x00000001  // int:1   float:0.000000\n"+
            "NEW_INSTANCE        |     |v0=NEW Ldee/lang/DeelangInteger;\n"+
            "INVOKE_DIRECT       |     |v0.<init>(v4,v1)  //Ldee/lang/DeelangInteger;.<init>(Lcom/roscopeco/deelang/runtime/Binding;I)V\n"+
            "RETURN_VOID         |     |return"
    );
  }

  @Test
  public void testHexLiteral() throws ParserError, CompilerError {
    runCodeComparisonTest("0xF",
        "extends com.roscopeco.deelang.runtime.CompiledScript",
            "public V run(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.Binding)\n"+
            "                this:v2   //DexCompiledScript__UUID__\n"+
            "                    :v3   //dee.lang.DeelangObject\n"+
            "                    :v4   //com.roscopeco.deelang.runtime.Binding\n"+
            "CONST               |     |v1=0x0000000f  // int:15   float:0.000000\n"+
            "NEW_INSTANCE        |     |v0=NEW Ldee/lang/DeelangInteger;\n"+
            "INVOKE_DIRECT       |     |v0.<init>(v4,v1)  //Ldee/lang/DeelangInteger;.<init>(Lcom/roscopeco/deelang/runtime/Binding;I)V\n"+
            "RETURN_VOID         |     |return"
    );
  }

  @Test
  public void testOctalLiteral() throws ParserError, CompilerError {
    runCodeComparisonTest("010",
        "extends com.roscopeco.deelang.runtime.CompiledScript",
            "public V run(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.Binding)\n"+
            "                this:v2   //DexCompiledScript__UUID__\n"+
            "                    :v3   //dee.lang.DeelangObject\n"+
            "                    :v4   //com.roscopeco.deelang.runtime.Binding\n"+
            "CONST               |     |v1=0x00000008  // int:8   float:0.000000\n"+
            "NEW_INSTANCE        |     |v0=NEW Ldee/lang/DeelangInteger;\n"+
            "INVOKE_DIRECT       |     |v0.<init>(v4,v1)  //Ldee/lang/DeelangInteger;.<init>(Lcom/roscopeco/deelang/runtime/Binding;I)V\n"+
            "RETURN_VOID         |     |return"
    );

  }

  @Test
  public void testFloatLiteral() throws ParserError, CompilerError {
    runCodeComparisonTest("1.2", 
        "extends com.roscopeco.deelang.runtime.CompiledScript",
            "public V run(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.Binding)\n"+
            "                this:v3   //DexCompiledScript__UUID__\n"+
            "                    :v4   //dee.lang.DeelangObject\n"+
            "                    :v5   //com.roscopeco.deelang.runtime.Binding\n"+
            "CONST               |     |v1=0x3ff3333333333333  // long:4608083138725491507   double:1.200000\n" +
            "NEW_INSTANCE        |     |v0=NEW Ldee/lang/DeelangFloat;\n"+
            "INVOKE_DIRECT       |     |v0.<init>(v5,v1)  //Ldee/lang/DeelangFloat;.<init>(Lcom/roscopeco/deelang/runtime/Binding;D)V\n"+
            "RETURN_VOID         |     |return"
    );

  }
  
  @Test
  public void testCharLiteral() throws ParserError, CompilerError {
    // treated as a string...
    runCodeComparisonTest("'o'", 
        "extends com.roscopeco.deelang.runtime.CompiledScript",
            "public V run(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.Binding)\n"+
            "                this:v2   //DexCompiledScript__UUID__\n"+
            "                    :v3   //dee.lang.DeelangObject\n"+
            "                    :v4   //com.roscopeco.deelang.runtime.Binding\n"+
            "CONST_STRING        |     |v1=\"o\"\n"+
            "NEW_INSTANCE        |     |v0=NEW Ldee/lang/DeelangString;\n"+
            "INVOKE_DIRECT       |     |v0.<init>(v4,v1)  //Ldee/lang/DeelangString;.<init>(Lcom/roscopeco/deelang/runtime/Binding;Ljava/lang/String;)V\n"+
            "RETURN_VOID         |     |return"
    );

  }
  
  @Test
  public void testStringLiteral() throws ParserError, CompilerError {
    runCodeComparisonTest("\"onetwothree\"", 
        "extends com.roscopeco.deelang.runtime.CompiledScript",
        "public V run(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.Binding)\n"+
        "                this:v2   //DexCompiledScript__UUID__\n"+
        "                    :v3   //dee.lang.DeelangObject\n"+
        "                    :v4   //com.roscopeco.deelang.runtime.Binding\n"+
        "CONST_STRING        |     |v1=\"onetwothree\"\n"+
        "NEW_INSTANCE        |     |v0=NEW Ldee/lang/DeelangString;\n"+
        "INVOKE_DIRECT       |     |v0.<init>(v4,v1)  //Ldee/lang/DeelangString;.<init>(Lcom/roscopeco/deelang/runtime/Binding;Ljava/lang/String;)V\n"+
        "RETURN_VOID         |     |return"
    );

  }
}
