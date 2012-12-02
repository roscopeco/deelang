package com.roscopeco.deelang.compiler.dex;

import org.junit.Test;

import com.roscopeco.deelang.compiler.CompilerError;
import com.roscopeco.deelang.parser.ParserError;

public class FuncTestCompilerLiterals extends CompilerFuncTestBase {
  @Test
  public void testUnusedLiteralIsOptmizedAway() throws ParserError, CompilerError {
    runCodeComparisonTest("1", 
        "extends com.roscopeco.deelang.runtime.dex.CompiledScript",
            "public final V run(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.dex.DexBinding)\n"+
            "                this:v0   //com.roscopeco.deelang.runtime.dex.DexCompiledScript__UUID__\n"+
            "                    :v1   //dee.lang.DeelangObject\n"+
            "                    :v2   //com.roscopeco.deelang.runtime.dex.DexBinding\n"+
            "RETURN_VOID         |     |return"
    );
  }

  @Test
  public void testIntegerLiteral() throws ParserError, CompilerError {
    runCodeComparisonTest("a=1", 
        "extends com.roscopeco.deelang.runtime.dex.CompiledScript",
            "public final V run(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.dex.DexBinding)\n"+
            "                this:v3   //com.roscopeco.deelang.runtime.dex.DexCompiledScript__UUID__\n"+
            "                    :v4   //dee.lang.DeelangObject\n"+
            "                    :v5   //com.roscopeco.deelang.runtime.dex.DexBinding\n"+
            "CONST               |     |v1=0x00000001  // int:1   float:0.000000\n"+
            "NEW_INSTANCE        |     |v0=NEW Ldee/lang/DeelangInteger;\n"+
            "INVOKE_DIRECT       |     |v0.<init>(v5,v1)  //Ldee/lang/DeelangInteger;.<init>(Ldee/lang/Binding;I)V\n"+
            "MOVE                |     |v2 = v0\n"+
            "RETURN_VOID         |     |return"
    );
  }

  @Test
  public void testHexLiteral() throws ParserError, CompilerError {
    runCodeComparisonTest("a=0xF",
        "extends com.roscopeco.deelang.runtime.dex.CompiledScript",
            "public final V run(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.dex.DexBinding)\n"+
            "                this:v3   //com.roscopeco.deelang.runtime.dex.DexCompiledScript__UUID__\n"+
            "                    :v4   //dee.lang.DeelangObject\n"+
            "                    :v5   //com.roscopeco.deelang.runtime.dex.DexBinding\n"+
            "CONST               |     |v1=0x0000000f  // int:15   float:0.000000\n"+
            "NEW_INSTANCE        |     |v0=NEW Ldee/lang/DeelangInteger;\n"+
            "INVOKE_DIRECT       |     |v0.<init>(v5,v1)  //Ldee/lang/DeelangInteger;.<init>(Ldee/lang/Binding;I)V\n"+
            "MOVE                |     |v2 = v0\n"+
            "RETURN_VOID         |     |return"
    );
  }

  @Test
  public void testOctalLiteral() throws ParserError, CompilerError {
    runCodeComparisonTest("a=010",
        "extends com.roscopeco.deelang.runtime.dex.CompiledScript",
            "public final V run(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.dex.DexBinding)\n"+
            "                this:v3   //com.roscopeco.deelang.runtime.dex.DexCompiledScript__UUID__\n"+
            "                    :v4   //dee.lang.DeelangObject\n"+
            "                    :v5   //com.roscopeco.deelang.runtime.dex.DexBinding\n"+
            "CONST               |     |v1=0x00000008  // int:8   float:0.000000\n"+
            "NEW_INSTANCE        |     |v0=NEW Ldee/lang/DeelangInteger;\n"+
            "INVOKE_DIRECT       |     |v0.<init>(v5,v1)  //Ldee/lang/DeelangInteger;.<init>(Ldee/lang/Binding;I)V\n"+
            "MOVE                |     |v2 = v0\n"+
            "RETURN_VOID         |     |return"
    );

  }

  @Test
  public void testFloatLiteral() throws ParserError, CompilerError {
    runCodeComparisonTest("a=1.2", 
        "extends com.roscopeco.deelang.runtime.dex.CompiledScript",
            "public final V run(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.dex.DexBinding)\n"+
            "                this:v4   //com.roscopeco.deelang.runtime.dex.DexCompiledScript__UUID__\n"+
            "                    :v5   //dee.lang.DeelangObject\n"+
            "                    :v6   //com.roscopeco.deelang.runtime.dex.DexBinding\n"+
            "CONST               |     |v1=0x3ff3333333333333  // long:4608083138725491507   double:1.200000\n" +
            "NEW_INSTANCE        |     |v0=NEW Ldee/lang/DeelangFloat;\n"+
            "INVOKE_DIRECT       |     |v0.<init>(v6,v1)  //Ldee/lang/DeelangFloat;.<init>(Ldee/lang/Binding;D)V\n"+
            "MOVE                |     |v3 = v0\n"+
            "RETURN_VOID         |     |return"
    );

  }
  
  @Test
  public void testCharLiteral() throws ParserError, CompilerError {
    // treated as a string...
    runCodeComparisonTest("a='o'", 
        "extends com.roscopeco.deelang.runtime.dex.CompiledScript",
            "public final V run(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.dex.DexBinding)\n"+
            "                this:v3   //com.roscopeco.deelang.runtime.dex.DexCompiledScript__UUID__\n"+
            "                    :v4   //dee.lang.DeelangObject\n"+
            "                    :v5   //com.roscopeco.deelang.runtime.dex.DexBinding\n"+
            "CONST_STRING        |     |v1=\"o\"\n"+
            "NEW_INSTANCE        |     |v0=NEW Ldee/lang/DeelangString;\n"+
            "INVOKE_DIRECT       |     |v0.<init>(v5,v1)  //Ldee/lang/DeelangString;.<init>(Ldee/lang/Binding;Ljava/lang/String;)V\n"+
            "MOVE                |     |v2 = v0\n"+
            "RETURN_VOID         |     |return"
    );

  }
  
  @Test
  public void testStringLiteral() throws ParserError, CompilerError {
    runCodeComparisonTest("a=\"onetwothree\"", 
        "extends com.roscopeco.deelang.runtime.dex.CompiledScript",
        "public final V run(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.dex.DexBinding)\n"+
        "                this:v3   //com.roscopeco.deelang.runtime.dex.DexCompiledScript__UUID__\n"+
        "                    :v4   //dee.lang.DeelangObject\n"+
        "                    :v5   //com.roscopeco.deelang.runtime.dex.DexBinding\n"+
        "CONST_STRING        |     |v1=\"onetwothree\"\n"+
        "NEW_INSTANCE        |     |v0=NEW Ldee/lang/DeelangString;\n"+
        "INVOKE_DIRECT       |     |v0.<init>(v5,v1)  //Ldee/lang/DeelangString;.<init>(Ldee/lang/Binding;Ljava/lang/String;)V\n"+
        "MOVE                |     |v2 = v0\n"+
        "RETURN_VOID         |     |return"
    );

  }
}
