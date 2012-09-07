package com.roscopeco.deelang.compiler.dex;

import org.junit.Test;

import com.roscopeco.deelang.compiler.CompilerError;
import com.roscopeco.deelang.parser.ParserError;

public class FuncTestCompilerMethodCalls extends CompilerFuncTestBase {
  @Test
  public void testBasicFuncCallNoArgs() throws ParserError, CompilerError {
    runCodeComparisonTest("foo()", 
        "extends com.roscopeco.deelang.runtime.CompiledScript",
        "public V run(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.Binding)\n"+
        "                this:v1   //DexCompiledScript__UUID__\n"+
        "                    :v2   //dee.lang.DeelangObject\n"+
        "                    :v3   //com.roscopeco.deelang.runtime.Binding\n"+
        "INVOKE_VIRTUAL      |     |TEMP=v2.foo()  //Lcom/roscopeco/deelang/compiler/dex/CompilerFuncTestBase$Foo;.foo()Ldee/lang/DeelangObject;\n"+
        "MOVE_RESULT         |     |v0=TEMP\n"+
        "RETURN_VOID         |     |return");
  }

  @Test
  public void testBasicFuncCallOneArg() throws ParserError, CompilerError {
    runCodeComparisonTest("foo(1)", 
        "extends com.roscopeco.deelang.runtime.CompiledScript",
        "public V run(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.Binding)\n"+
        "                this:v2   //DexCompiledScript__UUID__\n"+
        "                    :v3   //dee.lang.DeelangObject\n"+
        "                    :v4   //com.roscopeco.deelang.runtime.Binding\n"+
        "CONST               |     |v1=0x00000001  // int:1   float:0.000000\n"+
        "NEW_INSTANCE        |     |v0=NEW Ldee/lang/DeelangInteger;\n"+
        "INVOKE_DIRECT       |     |v0.<init>(v4,v1)  //Ldee/lang/DeelangInteger;.<init>(Lcom/roscopeco/deelang/runtime/Binding;I)V\n"+
        "INVOKE_VIRTUAL      |     |v3.foo(v0)  //Lcom/roscopeco/deelang/compiler/dex/CompilerFuncTestBase$Foo;.foo(Ldee/lang/DeelangInteger;)V\n"+
        "RETURN_VOID         |     |return");
  }

  @Test
  public void testBasicFuncCallTwoArgs() throws ParserError, CompilerError {
    runCodeComparisonTest("foo(1,2)", 
        "extends com.roscopeco.deelang.runtime.CompiledScript",
        "public V run(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.Binding)\n"+
        "                this:v3   //DexCompiledScript__UUID__\n"+
        "                    :v4   //dee.lang.DeelangObject\n"+
        "                    :v5   //com.roscopeco.deelang.runtime.Binding\n"+
        "CONST               |     |v1=0x00000001  // int:1   float:0.000000\n"+
        "NEW_INSTANCE        |     |v0=NEW Ldee/lang/DeelangInteger;\n"+
        "INVOKE_DIRECT       |     |v0.<init>(v5,v1)  //Ldee/lang/DeelangInteger;.<init>(Lcom/roscopeco/deelang/runtime/Binding;I)V\n"+
        "CONST               |     |v1=0x00000002  // int:2   float:0.000000\n"+
        "NEW_INSTANCE        |     |v2=NEW Ldee/lang/DeelangInteger;\n"+
        "INVOKE_DIRECT       |     |v2.<init>(v5,v1)  //Ldee/lang/DeelangInteger;.<init>(Lcom/roscopeco/deelang/runtime/Binding;I)V\n"+
        "INVOKE_VIRTUAL      |     |v4.foo(v0,v2)  //Lcom/roscopeco/deelang/compiler/dex/CompilerFuncTestBase$Foo;.foo(Ldee/lang/DeelangInteger;Ldee/lang/DeelangInteger;)V\n"+
        "RETURN_VOID         |     |return");
  }
}
