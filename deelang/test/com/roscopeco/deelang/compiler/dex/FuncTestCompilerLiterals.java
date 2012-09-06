package com.roscopeco.deelang.compiler.dex;

import org.junit.Before;
import org.junit.Test;

import com.roscopeco.deelang.compiler.CompilerError;
import com.roscopeco.deelang.parser.ParserError;

public class FuncTestCompilerLiterals extends CompilerFuncTestBase {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void testIntegerLiteral() throws ParserError, CompilerError {
    runCodeComparisonTest("1", 
        "extends com.roscopeco.deelang.compiler.dex.CompiledScript",
        new String[] {        
            "public V run()\n" +
            "                this:v3   //DexCompiledScript\n" +
            "CONST               |     |v0=0x00000001  // int:1   float:0.000000\n" +
            "IGET                |     |v2=v3.binding  //LDexCompiledScript;.binding Lcom/roscopeco/deelang/runtime/Binding;\n" +
            "NEW_INSTANCE        |     |v1=NEW Ldee/lang/DeelangInteger;\n" +
            "INVOKE_DIRECT       |     |v1.<init>(v2,v0)  //Ldee/lang/DeelangInteger;.<init>(Lcom/roscopeco/deelang/runtime/Binding;I)V\n" +
            "RETURN_VOID         |     |return"
    });
  }

  @Test
  public void testHexLiteral() throws ParserError, CompilerError {
    runCodeComparisonTest("0xF",
        "extends com.roscopeco.deelang.compiler.dex.CompiledScript",
        new String[] {        
            "public V run()\n" +
            "                this:v3   //DexCompiledScript\n" +
            "CONST               |     |v0=0x0000000f  // int:15   float:0.000000\n" +
            "IGET                |     |v2=v3.binding  //LDexCompiledScript;.binding Lcom/roscopeco/deelang/runtime/Binding;\n" +
            "NEW_INSTANCE        |     |v1=NEW Ldee/lang/DeelangInteger;\n" +
            "INVOKE_DIRECT       |     |v1.<init>(v2,v0)  //Ldee/lang/DeelangInteger;.<init>(Lcom/roscopeco/deelang/runtime/Binding;I)V\n" +
            "RETURN_VOID         |     |return"
    });

  }

  @Test
  public void testOctalLiteral() throws ParserError, CompilerError {
    runCodeComparisonTest("010",
        "extends com.roscopeco.deelang.compiler.dex.CompiledScript",
        new String[] {        
            "public V run()\n" +
            "                this:v3   //DexCompiledScript\n" +
            "CONST               |     |v0=0x00000008  // int:8   float:0.000000\n" +
            "IGET                |     |v2=v3.binding  //LDexCompiledScript;.binding Lcom/roscopeco/deelang/runtime/Binding;\n" +
            "NEW_INSTANCE        |     |v1=NEW Ldee/lang/DeelangInteger;\n" +
            "INVOKE_DIRECT       |     |v1.<init>(v2,v0)  //Ldee/lang/DeelangInteger;.<init>(Lcom/roscopeco/deelang/runtime/Binding;I)V\n" +
            "RETURN_VOID         |     |return"
    });

  }

  @Test
  public void testFloatLiteral() throws ParserError, CompilerError {
    runCodeComparisonTest("1.2", 
        "extends com.roscopeco.deelang.compiler.dex.CompiledScript",
        new String[] {        
            "public V run()\n" +
            "                this:v4   //DexCompiledScript\n" +
            "CONST               |     |v0=0x3ff3333333333333  // long:4608083138725491507   double:1.200000\n" +
            "IGET                |     |v3=v4.binding  //LDexCompiledScript;.binding Lcom/roscopeco/deelang/runtime/Binding;\n" +
            "NEW_INSTANCE        |     |v2=NEW Ldee/lang/DeelangFloat;\n" +
            "INVOKE_DIRECT       |     |v2.<init>(v3,v0)  //Ldee/lang/DeelangFloat;.<init>(Lcom/roscopeco/deelang/runtime/Binding;D)V\n" +
            "RETURN_VOID         |     |return"
    });

  }
  
  @Test
  public void testCharLiteral() throws ParserError, CompilerError {
    // treated as a string...
    runCodeComparisonTest("'o'", 
        "extends com.roscopeco.deelang.compiler.dex.CompiledScript",
        new String[] {        
            "public V run()\n" +
            "                this:v1   //DexCompiledScript\n" +
            "CONST_STRING        |     |v0=\"o\"\n" +
            "RETURN_VOID         |     |return"
    });

  }
  
  @Test
  public void testStringLiteral() throws ParserError, CompilerError {
    runCodeComparisonTest("\"onetwothree\"", 
        "extends com.roscopeco.deelang.compiler.dex.CompiledScript",
        new String[] {        
            "public V run()\n" +
            "                this:v1   //DexCompiledScript\n" +
            "CONST_STRING        |     |v0=\"onetwothree\"\n" +
            "RETURN_VOID         |     |return"
    });

  }
}
