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
  
  @Test
  public void testNestedFuncCallOneArg() throws ParserError, CompilerError {
    runCodeComparisonTest("foo(bar(1))", 
        "extends com.roscopeco.deelang.runtime.CompiledScript",
        "public V run(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.Binding)\n"+
        "                this:v3   //DexCompiledScript__UUID__\n"+
        "                    :v4   //dee.lang.DeelangObject\n"+
        "                    :v5   //com.roscopeco.deelang.runtime.Binding\n"+
        "CONST               |     |v1=0x00000001  // int:1   float:0.000000\n"+
        "NEW_INSTANCE        |     |v0=NEW Ldee/lang/DeelangInteger;\n"+
        "INVOKE_DIRECT       |     |v0.<init>(v5,v1)  //Ldee/lang/DeelangInteger;.<init>(Lcom/roscopeco/deelang/runtime/Binding;I)V\n"+
        "INVOKE_VIRTUAL      |     |TEMP=v4.bar(v0)  //Lcom/roscopeco/deelang/compiler/dex/CompilerFuncTestBase$Foo;.bar(Ldee/lang/DeelangInteger;)Ldee/lang/DeelangInteger;\n"+
        "MOVE_RESULT         |     |v2=TEMP\n"+
        "INVOKE_VIRTUAL      |     |v4.foo(v2)  //Lcom/roscopeco/deelang/compiler/dex/CompilerFuncTestBase$Foo;.foo(Ldee/lang/DeelangInteger;)V\n"+
        "RETURN_VOID         |     |return");
  }

  @Test
  public void testDoubleNestedFuncCallInnerTwoArgsInnerInnerOneArg() throws ParserError, CompilerError {
    runCodeComparisonTest("foo(bar(1, baz(2)))", 
        "extends com.roscopeco.deelang.runtime.CompiledScript",
        "public V run(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.Binding)\n"+
        "                this:v4   //DexCompiledScript__UUID__\n"+
        "                    :v5   //dee.lang.DeelangObject\n"+
        "                    :v6   //com.roscopeco.deelang.runtime.Binding\n"+
        "CONST               |     |v1=0x00000001  // int:1   float:0.000000\n"+
        "NEW_INSTANCE        |     |v0=NEW Ldee/lang/DeelangInteger;\n"+
        "INVOKE_DIRECT       |     |v0.<init>(v6,v1)  //Ldee/lang/DeelangInteger;.<init>(Lcom/roscopeco/deelang/runtime/Binding;I)V\n"+
        "CONST               |     |v1=0x00000002  // int:2   float:0.000000\n"+
        "NEW_INSTANCE        |     |v2=NEW Ldee/lang/DeelangInteger;\n"+
        "INVOKE_DIRECT       |     |v2.<init>(v6,v1)  //Ldee/lang/DeelangInteger;.<init>(Lcom/roscopeco/deelang/runtime/Binding;I)V\n"+
        "INVOKE_VIRTUAL      |     |TEMP=v5.baz(v2)  //Lcom/roscopeco/deelang/compiler/dex/CompilerFuncTestBase$Foo;.baz(Ldee/lang/DeelangInteger;)Ldee/lang/DeelangString;\n"+
        "MOVE_RESULT         |     |v3=TEMP\n"+
        "INVOKE_VIRTUAL      |     |TEMP=v5.bar(v0,v3)  //Lcom/roscopeco/deelang/compiler/dex/CompilerFuncTestBase$Foo;.bar(Ldee/lang/DeelangInteger;Ldee/lang/DeelangString;)Ldee/lang/DeelangInteger;\n"+
        "MOVE_RESULT         |     |v2=TEMP\n"+
        "INVOKE_VIRTUAL      |     |v5.foo(v2)  //Lcom/roscopeco/deelang/compiler/dex/CompilerFuncTestBase$Foo;.foo(Ldee/lang/DeelangInteger;)V\n"+
        "RETURN_VOID         |     |return");
  }
  
  @Test
  public void testBasicMethCallNoArgs() throws ParserError, CompilerError {
    runCodeComparisonTest("foo.foo()", 
        "extends com.roscopeco.deelang.runtime.CompiledScript",
        "public V run(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.Binding)\n"+
        "                this:v5   //DexCompiledScript__UUID__\n"+
        "                    :v6   //dee.lang.DeelangObject\n"+
        "                    :v7   //com.roscopeco.deelang.runtime.Binding\n"+
        "CONST_STRING        |     |v1=\"foo\"\n"+
        "INVOKE_INTERFACE    |     |TEMP=v7.getLocal(v1)  //Lcom/roscopeco/deelang/runtime/Binding;.getLocal(Ljava/lang/String;)Ljava/lang/Object;\n"+
        "MOVE_RESULT         |     |v2=TEMP\n"+
        "MOVE                |     |v0 = v2\n"+
        "CHECK_CAST          |     |v0=(com.roscopeco.deelang.compiler.dex.CompilerFuncTestBase$Foo) v0\n"+
        "MOVE                |     |v3 = v0\n"+
        "INVOKE_VIRTUAL      |     |TEMP=v3.foo()  //Lcom/roscopeco/deelang/compiler/dex/CompilerFuncTestBase$Foo;.foo()Ldee/lang/DeelangObject;\n"+
        "MOVE_RESULT         |     |v4=TEMP\n"+
        "RETURN_VOID         |     |return");
    }
  
  @Test
  public void testBasicMethCallOneArg() throws ParserError, CompilerError {
    runCodeComparisonTest("foo.bar(1)",
        "extends com.roscopeco.deelang.runtime.CompiledScript",
        "public V run(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.Binding)\n"+
        "                this:v7   //DexCompiledScript__UUID__\n"+
        "                    :v8   //dee.lang.DeelangObject\n"+
        "                    :v9   //com.roscopeco.deelang.runtime.Binding\n"+
        "CONST_STRING        |     |v1=\"foo\"\n"+
        "INVOKE_INTERFACE    |     |TEMP=v9.getLocal(v1)  //Lcom/roscopeco/deelang/runtime/Binding;.getLocal(Ljava/lang/String;)Ljava/lang/Object;\n"+
        "MOVE_RESULT         |     |v2=TEMP\n"+
        "MOVE                |     |v0 = v2\n"+
        "CHECK_CAST          |     |v0=(com.roscopeco.deelang.compiler.dex.CompilerFuncTestBase$Foo) v0\n"+
        "MOVE                |     |v3 = v0\n"+
        "CONST               |     |v5=0x00000001  // int:1   float:0.000000\n"+
        "NEW_INSTANCE        |     |v4=NEW Ldee/lang/DeelangInteger;\n"+
        "INVOKE_DIRECT       |     |v4.<init>(v9,v5)  //Ldee/lang/DeelangInteger;.<init>(Lcom/roscopeco/deelang/runtime/Binding;I)V\n"+
        "INVOKE_VIRTUAL      |     |TEMP=v3.bar(v4)  //Lcom/roscopeco/deelang/compiler/dex/CompilerFuncTestBase$Foo;.bar(Ldee/lang/DeelangInteger;)Ldee/lang/DeelangInteger;\n"+
        "MOVE_RESULT         |     |v6=TEMP\n"+
        "RETURN_VOID         |     |return");
  }

  @Test
  public void testBasicMethCallTwoArgs() throws ParserError, CompilerError {
    runCodeComparisonTest("foo.bar(1,2)", 
        "extends com.roscopeco.deelang.runtime.CompiledScript",
        "public V run(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.Binding)\n"+
        "                this:v8   //DexCompiledScript__UUID__\n"+
        "                    :v9   //dee.lang.DeelangObject\n"+
        "                    :v10   //com.roscopeco.deelang.runtime.Binding\n"+
        "CONST_STRING        |     |v1=\"foo\"\n"+
        "INVOKE_INTERFACE    |     |TEMP=v10.getLocal(v1)  //Lcom/roscopeco/deelang/runtime/Binding;.getLocal(Ljava/lang/String;)Ljava/lang/Object;\n"+
        "MOVE_RESULT         |     |v2=TEMP\n"+
        "MOVE                |     |v0 = v2\n"+
        "CHECK_CAST          |     |v0=(com.roscopeco.deelang.compiler.dex.CompilerFuncTestBase$Foo) v0\n"+
        "MOVE                |     |v3 = v0\n"+
        "CONST               |     |v5=0x00000001  // int:1   float:0.000000\n"+
        "NEW_INSTANCE        |     |v4=NEW Ldee/lang/DeelangInteger;\n"+
        "INVOKE_DIRECT       |     |v4.<init>(v10,v5)  //Ldee/lang/DeelangInteger;.<init>(Lcom/roscopeco/deelang/runtime/Binding;I)V\n"+
        "CONST               |     |v5=0x00000002  // int:2   float:0.000000\n"+
        "NEW_INSTANCE        |     |v6=NEW Ldee/lang/DeelangInteger;\n"+
        "INVOKE_DIRECT       |     |v6.<init>(v10,v5)  //Ldee/lang/DeelangInteger;.<init>(Lcom/roscopeco/deelang/runtime/Binding;I)V\n"+
        "INVOKE_VIRTUAL      |     |TEMP=v3.bar(v4,v6)  //Lcom/roscopeco/deelang/compiler/dex/CompilerFuncTestBase$Foo;.bar(Ldee/lang/DeelangInteger;Ldee/lang/DeelangInteger;)Ldee/lang/DeelangInteger;\n"+
        "MOVE_RESULT         |     |v7=TEMP\n"+
        "RETURN_VOID         |     |return");
  }

  @Test
  public void testNestedMethToFuncCallOneArg() throws ParserError, CompilerError {
    runCodeComparisonTest("foo.bar(quux(1))",
        "extends com.roscopeco.deelang.runtime.CompiledScript",
        "public V run(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.Binding)\n"+
        "                this:v7   //DexCompiledScript__UUID__\n"+
        "                    :v8   //dee.lang.DeelangObject\n"+
        "                    :v9   //com.roscopeco.deelang.runtime.Binding\n"+
        "CONST_STRING        |     |v1=\"foo\"\n"+
        "INVOKE_INTERFACE    |     |TEMP=v9.getLocal(v1)  //Lcom/roscopeco/deelang/runtime/Binding;.getLocal(Ljava/lang/String;)Ljava/lang/Object;\n"+
        "MOVE_RESULT         |     |v2=TEMP\n"+
        "MOVE                |     |v0 = v2\n"+
        "CHECK_CAST          |     |v0=(com.roscopeco.deelang.compiler.dex.CompilerFuncTestBase$Foo) v0\n"+
        "MOVE                |     |v3 = v0\n"+
        "CONST               |     |v5=0x00000001  // int:1   float:0.000000\n"+
        "NEW_INSTANCE        |     |v4=NEW Ldee/lang/DeelangInteger;\n"+
        "INVOKE_DIRECT       |     |v4.<init>(v9,v5)  //Ldee/lang/DeelangInteger;.<init>(Lcom/roscopeco/deelang/runtime/Binding;I)V\n"+
        "INVOKE_VIRTUAL      |     |TEMP=v8.quux(v4)  //Lcom/roscopeco/deelang/compiler/dex/CompilerFuncTestBase$Foo;.quux(Ldee/lang/DeelangInteger;)Ldee/lang/DeelangInteger;\n"+
        "MOVE_RESULT         |     |v6=TEMP\n"+
        "INVOKE_VIRTUAL      |     |TEMP=v3.bar(v6)  //Lcom/roscopeco/deelang/compiler/dex/CompilerFuncTestBase$Foo;.bar(Ldee/lang/DeelangInteger;)Ldee/lang/DeelangInteger;\n"+
        "MOVE_RESULT         |     |v4=TEMP\n"+
        "RETURN_VOID         |     |return");
  }

  @Test
  public void testChainedMethodCall() throws ParserError, CompilerError {
    runCodeComparisonTest("foo.boo().baz()", "" +
        "extends com.roscopeco.deelang.runtime.CompiledScript",
        "public V run(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.Binding)\n"+
        "                this:v6   //DexCompiledScript__UUID__\n"+
        "                    :v7   //dee.lang.DeelangObject\n"+
        "                    :v8   //com.roscopeco.deelang.runtime.Binding\n"+
        "CONST_STRING        |     |v1=\"foo\"\n"+
        "INVOKE_INTERFACE    |     |TEMP=v8.getLocal(v1)  //Lcom/roscopeco/deelang/runtime/Binding;.getLocal(Ljava/lang/String;)Ljava/lang/Object;\n"+
        "MOVE_RESULT         |     |v2=TEMP\n"+
        "MOVE                |     |v0 = v2\n"+
        "CHECK_CAST          |     |v0=(com.roscopeco.deelang.compiler.dex.CompilerFuncTestBase$Foo) v0\n"+
        "MOVE                |     |v3 = v0\n"+
        "INVOKE_VIRTUAL      |     |TEMP=v3.boo()  //Lcom/roscopeco/deelang/compiler/dex/CompilerFuncTestBase$Foo;.boo()Lcom/roscopeco/deelang/compiler/dex/CompilerFuncTestBase$Foo;\n"+
        "MOVE_RESULT         |     |v4=TEMP\n"+
        "INVOKE_VIRTUAL      |     |TEMP=v4.baz()  //Lcom/roscopeco/deelang/compiler/dex/CompilerFuncTestBase$Foo;.baz()Ldee/lang/DeelangInteger;\n"+
        "MOVE_RESULT         |     |v5=TEMP\n"+
        "RETURN_VOID         |     |return");
  }
  
  // TODO more tests needed:
  /*
   * foo.bar().baz(quux().qix())
   * foo.field.bar()
   */
}
