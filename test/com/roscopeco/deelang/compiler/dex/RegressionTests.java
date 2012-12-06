package com.roscopeco.deelang.compiler.dex;

import org.junit.Test;

import com.roscopeco.deelang.compiler.CompilerError;
import com.roscopeco.deelang.parser.ParserError;

public class RegressionTests extends CompilerFuncTestBase {
  @Test
  public void BUG0001_testFuncWithSubclassedArg() throws ParserError, CompilerError {
    runCodeComparisonTest("msg = \"str\"; checkSubclassArgBinding(msg)", 
        "extends com.roscopeco.deelang.runtime.dex.CompiledScript",
        "public final V run(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.dex.DexBinding)\n"+
        "                this:v5   //com.roscopeco.deelang.runtime.dex.DexCompiledScript__UUID__\n"+
        "                    :v6   //dee.lang.DeelangObject\n"+
        "                    :v7   //com.roscopeco.deelang.runtime.dex.DexBinding\n"+
        "CONST_STRING        |     |v2=\"str\"\n"+
        "NEW_INSTANCE        |     |v1=NEW Ldee/lang/DeelangString;\n"+
        "INVOKE_DIRECT       |     |v1.<init>(v7,v2)  //Ldee/lang/DeelangString;.<init>(Ldee/lang/Binding;Ljava/lang/String;)V\n"+
        "MOVE                |     |v3 = v1\n"+
        "MOVE                |     |v0 = v6\n"+
        "CHECK_CAST          |     |v0=(com.roscopeco.deelang.compiler.dex.CompilerFuncTestBase$Foo) v0\n"+
        "MOVE                |     |v4 = v0\n"+
        "INVOKE_VIRTUAL      |     |v4.checkSubclassArgBinding(v3)  //Lcom/roscopeco/deelang/compiler/dex/CompilerFuncTestBase$Foo;.checkSubclassArgBinding(Ldee/lang/DeelangObject;)V\n"+
        "RETURN_VOID         |     |return");
  }
}
