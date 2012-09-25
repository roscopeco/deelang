package com.roscopeco.deelang.compiler.dex;

import org.junit.Test;

import com.roscopeco.deelang.compiler.CompilerError;
import com.roscopeco.deelang.parser.ParserError;

public class FuncTestCompilerMethodCalls extends CompilerFuncTestBase {
  @Test
  public void testBasicFuncCallNoArgs() throws ParserError, CompilerError {
    runCodeComparisonTest("foo()", 
        "extends com.roscopeco.deelang.runtime.CompiledScript",
        "public final V run(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.Binding)\n"+
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
        "public final V run(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.Binding)\n"+
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
        "public final V run(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.Binding)\n"+
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
        "public final V run(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.Binding)\n"+
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
        "public final V run(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.Binding)\n"+
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
        "public final V run(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.Binding)\n"+
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
        "public final V run(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.Binding)\n"+
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
        "public final V run(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.Binding)\n"+
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
        "public final V run(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.Binding)\n"+
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
        "public final V run(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.Binding)\n"+
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
  
  @Test
  public void testBasicFuncNoArgsCallWithBlock() throws ParserError, CompilerError {
    runCodeComparisonTest("blockNoArgs() { voidy() }", 
        "extends com.roscopeco.deelang.runtime.CompiledScript",
        "public final V run(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.Binding)\n"+
        "                this:v3   //DexCompiledScript__UUID__\n"+
        "                    :v4   //dee.lang.DeelangObject\n"+
        "                    :v5   //com.roscopeco.deelang.runtime.Binding\n"+
        "CONST               |     |v1=0x00000000  // int:0   float:0.000000\n"+
        "NEW_ARRAY           |     |v2=new java.lang.Object[][v1]\n"+
        "NEW_INSTANCE        |     |v0=NEW Lcom/roscopeco/deelang/runtime/DexCompiledScript__UUID__$block0;\n"+
        "INVOKE_DIRECT       |     |v0.<init>(v4,v5,v2)  //Lcom/roscopeco/deelang/runtime/DexCompiledScript__UUID__$block0;.<init>(Ldee/lang/DeelangObject;Lcom/roscopeco/deelang/runtime/Binding;[Ljava/lang/Object;)V\n"+
        "INVOKE_VIRTUAL      |     |v4.blockNoArgs(v0)  //Lcom/roscopeco/deelang/compiler/dex/CompilerFuncTestBase$Foo;.blockNoArgs(Lcom/roscopeco/deelang/runtime/Block;)V\n"+
        "RETURN_VOID         |     |return",
        
        "extends com.roscopeco.deelang.runtime.Block",
        "public final V invoke(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.Binding,java.lang.Object[],java.lang.Object[])\n"+
        "                this:v1   //com.roscopeco.deelang.runtime.DexCompiledScript__UUID__$block0\n"+
        "                    :v2   //dee.lang.DeelangObject\n"+
        "                    :v3   //com.roscopeco.deelang.runtime.Binding\n"+
        "                    :v4   //java.lang.Object[]\n"+
        "                    :v5   //java.lang.Object[]\n"+
        "INVOKE_VIRTUAL      |     |v2.voidy()  //Lcom/roscopeco/deelang/compiler/dex/CompilerFuncTestBase$Foo;.voidy()V\n"+
        "RETURN_VOID         |     |return");
  }

  @Test
  public void testBasicMethCallNoArgsWithBlock() throws ParserError, CompilerError {
    runCodeComparisonTest("foo.blockNoArgs() { foo.voidy() }", 
        "extends com.roscopeco.deelang.runtime.CompiledScript",
        "public final V run(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.Binding)\n"+
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
        "NEW_ARRAY           |     |v6=new java.lang.Object[][v5]\n"+
        "CONST               |     |v5=0x00000000  // int:0   float:0.000000\n"+
        "APUT                |     |v6[v5]=v3\n"+
        "NEW_INSTANCE        |     |v4=NEW Lcom/roscopeco/deelang/runtime/DexCompiledScript__UUID__$block0;\n"+
        "INVOKE_DIRECT       |     |v4.<init>(v8,v9,v6)  //Lcom/roscopeco/deelang/runtime/DexCompiledScript__UUID__$block0;.<init>(Ldee/lang/DeelangObject;Lcom/roscopeco/deelang/runtime/Binding;[Ljava/lang/Object;)V\n"+
        "INVOKE_VIRTUAL      |     |v3.blockNoArgs(v4)  //Lcom/roscopeco/deelang/compiler/dex/CompilerFuncTestBase$Foo;.blockNoArgs(Lcom/roscopeco/deelang/runtime/Block;)V\n"+
        "RETURN_VOID         |     |return",
        
        "extends com.roscopeco.deelang.runtime.Block",
        "public final V invoke(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.Binding,java.lang.Object[],java.lang.Object[])\n"+
        "                this:v4   //com.roscopeco.deelang.runtime.DexCompiledScript__UUID__$block0\n"+
        "                    :v5   //dee.lang.DeelangObject\n"+
        "                    :v6   //com.roscopeco.deelang.runtime.Binding\n"+
        "                    :v7   //java.lang.Object[]\n"+
        "                    :v8   //java.lang.Object[]\n"+
        "CONST               |     |v2=0x00000000  // int:0   float:0.000000\n"+
        "AGET                |     |v3=v7[v2]\n"+
        "MOVE                |     |v0 = v3\n"+
        "CHECK_CAST          |     |v0=(com.roscopeco.deelang.compiler.dex.CompilerFuncTestBase$Foo) v0\n"+
        "MOVE                |     |v1 = v0\n"+
        "INVOKE_VIRTUAL      |     |v1.voidy()  //Lcom/roscopeco/deelang/compiler/dex/CompilerFuncTestBase$Foo;.voidy()V\n"+
        "RETURN_VOID         |     |return");
  }
  
  @Test
  public void testBlockConstructorIsCorrect() throws ParserError, CompilerError {
    runCodeComparisonTest("blockNoArgs() { voidy() }", 
        "extends com.roscopeco.deelang.runtime.Block",
        "//Lcom/roscopeco/deelang/runtime/DexCompiledScript__UUID__$block0;.<init>(Ldee/lang/DeelangObject;Lcom/roscopeco/deelang/runtime/Binding;[Ljava/lang/Object;)V\n"+
        "public V <init>(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.Binding,java.lang.Object[])\n"+
        "                this:v0   //com.roscopeco.deelang.runtime.DexCompiledScript__UUID__$block0\n"+
        "                    :v1   //dee.lang.DeelangObject\n"+
        "                    :v2   //com.roscopeco.deelang.runtime.Binding\n"+
        "                    :v3   //java.lang.Object[]\n"+
        "INVOKE_DIRECT       |     |v0.<init>(v1,v2,v3)  //Lcom/roscopeco/deelang/runtime/Block;.<init>(Ldee/lang/DeelangObject;Lcom/roscopeco/deelang/runtime/Binding;[Ljava/lang/Object;)V\n"+
        "RETURN_VOID         |     |return");        
  }
  
  @Test
  public void testBasicMethCallWithArgsWithBlock() throws ParserError, CompilerError {
    runCodeComparisonTest("foo.blockOneArg(1) { foo.voidy() }", 
        "extends com.roscopeco.deelang.runtime.CompiledScript",
        "public final V run(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.Binding)\n"+
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
        "CONST               |     |v5=0x00000001  // int:1   float:0.000000\n"+
        "NEW_ARRAY           |     |v7=new java.lang.Object[][v5]\n"+
        "CONST               |     |v5=0x00000000  // int:0   float:0.000000\n"+
        "APUT                |     |v7[v5]=v3\n"+
        "NEW_INSTANCE        |     |v6=NEW Lcom/roscopeco/deelang/runtime/DexCompiledScript__UUID__$block0;\n"+
        "INVOKE_DIRECT       |     |v6.<init>(v9,v10,v7)  //Lcom/roscopeco/deelang/runtime/DexCompiledScript__UUID__$block0;.<init>(Ldee/lang/DeelangObject;Lcom/roscopeco/deelang/runtime/Binding;[Ljava/lang/Object;)V\n"+
        "INVOKE_VIRTUAL      |     |v3.blockOneArg(v6,v4)  //Lcom/roscopeco/deelang/compiler/dex/CompilerFuncTestBase$Foo;.blockOneArg(Lcom/roscopeco/deelang/runtime/Block;Ldee/lang/DeelangInteger;)V\n"+
        "RETURN_VOID         |     |return",
        
        "extends com.roscopeco.deelang.runtime.Block",
        "public final V invoke(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.Binding,java.lang.Object[],java.lang.Object[])\n"+
        "                this:v4   //com.roscopeco.deelang.runtime.DexCompiledScript__UUID__$block0\n"+
        "                    :v5   //dee.lang.DeelangObject\n"+
        "                    :v6   //com.roscopeco.deelang.runtime.Binding\n"+
        "                    :v7   //java.lang.Object[]\n"+
        "                    :v8   //java.lang.Object[]\n"+
        "CONST               |     |v2=0x00000000  // int:0   float:0.000000\n"+
        "AGET                |     |v3=v7[v2]\n"+
        "MOVE                |     |v0 = v3\n"+
        "CHECK_CAST          |     |v0=(com.roscopeco.deelang.compiler.dex.CompilerFuncTestBase$Foo) v0\n"+
        "MOVE                |     |v1 = v0\n"+
        "INVOKE_VIRTUAL      |     |v1.voidy()  //Lcom/roscopeco/deelang/compiler/dex/CompilerFuncTestBase$Foo;.voidy()V\n"+
        "RETURN_VOID         |     |return");
  }
  
  @Test
  public void testBasicMethCallNoArgsWithBlockModifiyingLoadedLocal() throws ParserError, CompilerError {
    runCodeComparisonTest("a = 2; foo.blockNoArgs() { a = 1 }", 
        "extends com.roscopeco.deelang.runtime.CompiledScript",
        "public final V run(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.Binding)\n"+
        "                this:v9   //DexCompiledScript__UUID__\n"+
        "                    :v10   //dee.lang.DeelangObject\n"+
        "                    :v11   //com.roscopeco.deelang.runtime.Binding\n"+
        "CONST               |     |v2=0x00000002  // int:2   float:0.000000\n"+
        "NEW_INSTANCE        |     |v1=NEW Ldee/lang/DeelangInteger;\n"+
        "INVOKE_DIRECT       |     |v1.<init>(v11,v2)  //Ldee/lang/DeelangInteger;.<init>(Lcom/roscopeco/deelang/runtime/Binding;I)V\n"+
        "MOVE                |     |v3 = v1\n"+
        "CONST_STRING        |     |v4=\"foo\"\n"+
        "INVOKE_INTERFACE    |     |TEMP=v11.getLocal(v4)  //Lcom/roscopeco/deelang/runtime/Binding;.getLocal(Ljava/lang/String;)Ljava/lang/Object;\n"+
        "MOVE_RESULT         |     |v5=TEMP\n"+
        "MOVE                |     |v0 = v5\n"+
        "CHECK_CAST          |     |v0=(com.roscopeco.deelang.compiler.dex.CompilerFuncTestBase$Foo) v0\n"+
        "MOVE                |     |v6 = v0\n"+
        "CONST               |     |v2=0x00000001  // int:1   float:0.000000\n"+
        "NEW_ARRAY           |     |v8=new java.lang.Object[][v2]\n"+
        "CONST               |     |v2=0x00000000  // int:0   float:0.000000\n"+
        "APUT                |     |v8[v2]=v3\n"+
        "NEW_INSTANCE        |     |v7=NEW Lcom/roscopeco/deelang/runtime/DexCompiledScript__UUID__$block0;\n"+
        "INVOKE_DIRECT       |     |v7.<init>(v10,v11,v8)  //Lcom/roscopeco/deelang/runtime/DexCompiledScript__UUID__$block0;.<init>(Ldee/lang/DeelangObject;Lcom/roscopeco/deelang/runtime/Binding;[Ljava/lang/Object;)V\n"+
        "INVOKE_VIRTUAL      |     |v6.blockNoArgs(v7)  //Lcom/roscopeco/deelang/compiler/dex/CompilerFuncTestBase$Foo;.blockNoArgs(Lcom/roscopeco/deelang/runtime/Block;)V\n"+
        "CONST               |     |v2=0x00000000  // int:0   float:0.000000\n"+
        "AGET                |     |v5=v8[v2]\n"+
        "MOVE                |     |v0 = v5\n"+
        "CHECK_CAST          |     |v0=(dee.lang.DeelangInteger) v0\n"+
        "MOVE                |     |v3 = v0\n"+
        "RETURN_VOID         |     |return",
        
        "extends com.roscopeco.deelang.runtime.Block",
        "public final V invoke(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.Binding,java.lang.Object[],java.lang.Object[])\n"+
        "                this:v5   //com.roscopeco.deelang.runtime.DexCompiledScript__UUID__$block0\n"+
        "                    :v6   //dee.lang.DeelangObject\n"+
        "                    :v7   //com.roscopeco.deelang.runtime.Binding\n"+
        "                    :v8   //java.lang.Object[]\n"+
        "                    :v9   //java.lang.Object[]\n"+
        "CONST               |     |v2=0x00000000  // int:0   float:0.000000\n"+
        "AGET                |     |v4=v8[v2]\n"+
        "MOVE                |     |v0 = v4\n"+
        "CHECK_CAST          |     |v0=(dee.lang.DeelangInteger) v0\n"+
        "MOVE                |     |v3 = v0\n"+
        "CONST               |     |v2=0x00000001  // int:1   float:0.000000\n"+
        "NEW_INSTANCE        |     |v1=NEW Ldee/lang/DeelangInteger;\n"+
        "INVOKE_DIRECT       |     |v1.<init>(v7,v2)  //Ldee/lang/DeelangInteger;.<init>(Lcom/roscopeco/deelang/runtime/Binding;I)V\n"+
        "MOVE                |     |v3 = v1\n"+
        "CONST               |     |v2=0x00000000  // int:0   float:0.000000\n"+
        "APUT                |     |v8[v2]=v3\n"+
        "RETURN_VOID         |     |return");
  }

  @Test
  public void testREGRESSIONBasicMethCallNoArgsWithBlockModifiyingLocalDoesntMissLastStatement() throws ParserError, CompilerError {
    runCodeComparisonTest("a = 2; foo.blockNoArgs() { a = 1 ; bar(a) }", 
        "extends com.roscopeco.deelang.runtime.CompiledScript",
        "public final V run(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.Binding)\n"+
        "                this:v9   //DexCompiledScript__UUID__\n"+
        "                    :v10   //dee.lang.DeelangObject\n"+
        "                    :v11   //com.roscopeco.deelang.runtime.Binding\n"+
        "CONST               |     |v2=0x00000002  // int:2   float:0.000000\n"+
        "NEW_INSTANCE        |     |v1=NEW Ldee/lang/DeelangInteger;\n"+
        "INVOKE_DIRECT       |     |v1.<init>(v11,v2)  //Ldee/lang/DeelangInteger;.<init>(Lcom/roscopeco/deelang/runtime/Binding;I)V\n"+
        "MOVE                |     |v3 = v1\n"+
        "CONST_STRING        |     |v4=\"foo\"\n"+
        "INVOKE_INTERFACE    |     |TEMP=v11.getLocal(v4)  //Lcom/roscopeco/deelang/runtime/Binding;.getLocal(Ljava/lang/String;)Ljava/lang/Object;\n"+
        "MOVE_RESULT         |     |v5=TEMP\n"+
        "MOVE                |     |v0 = v5\n"+
        "CHECK_CAST          |     |v0=(com.roscopeco.deelang.compiler.dex.CompilerFuncTestBase$Foo) v0\n"+
        "MOVE                |     |v6 = v0\n"+
        "CONST               |     |v2=0x00000001  // int:1   float:0.000000\n"+
        "NEW_ARRAY           |     |v8=new java.lang.Object[][v2]\n"+
        "CONST               |     |v2=0x00000000  // int:0   float:0.000000\n"+
        "APUT                |     |v8[v2]=v3\n"+
        "NEW_INSTANCE        |     |v7=NEW Lcom/roscopeco/deelang/runtime/DexCompiledScript__UUID__$block0;\n"+
        "INVOKE_DIRECT       |     |v7.<init>(v10,v11,v8)  //Lcom/roscopeco/deelang/runtime/DexCompiledScript__UUID__$block0;.<init>(Ldee/lang/DeelangObject;Lcom/roscopeco/deelang/runtime/Binding;[Ljava/lang/Object;)V\n"+
        "INVOKE_VIRTUAL      |     |v6.blockNoArgs(v7)  //Lcom/roscopeco/deelang/compiler/dex/CompilerFuncTestBase$Foo;.blockNoArgs(Lcom/roscopeco/deelang/runtime/Block;)V\n"+
        "CONST               |     |v2=0x00000000  // int:0   float:0.000000\n"+
        "AGET                |     |v5=v8[v2]\n"+
        "MOVE                |     |v0 = v5\n"+
        "CHECK_CAST          |     |v0=(dee.lang.DeelangInteger) v0\n"+
        "MOVE                |     |v3 = v0\n"+
        "RETURN_VOID         |     |return",
        
        "extends com.roscopeco.deelang.runtime.Block",
        "public final V invoke(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.Binding,java.lang.Object[],java.lang.Object[])\n"+
        "                this:v5   //com.roscopeco.deelang.runtime.DexCompiledScript__UUID__$block0\n"+
        "                    :v6   //dee.lang.DeelangObject\n"+
        "                    :v7   //com.roscopeco.deelang.runtime.Binding\n"+
        "                    :v8   //java.lang.Object[]\n"+
        "                    :v9   //java.lang.Object[]\n"+
        "CONST               |     |v2=0x00000000  // int:0   float:0.000000\n"+
        "AGET                |     |v4=v8[v2]\n"+
        "MOVE                |     |v0 = v4\n"+
        "CHECK_CAST          |     |v0=(dee.lang.DeelangInteger) v0\n"+
        "MOVE                |     |v3 = v0\n"+
        "CONST               |     |v2=0x00000001  // int:1   float:0.000000\n"+
        "NEW_INSTANCE        |     |v1=NEW Ldee/lang/DeelangInteger;\n"+
        "INVOKE_DIRECT       |     |v1.<init>(v7,v2)  //Ldee/lang/DeelangInteger;.<init>(Lcom/roscopeco/deelang/runtime/Binding;I)V\n"+
        "MOVE                |     |v3 = v1\n"+
        "INVOKE_VIRTUAL      |     |TEMP=v6.bar(v3)  //Lcom/roscopeco/deelang/compiler/dex/CompilerFuncTestBase$Foo;.bar(Ldee/lang/DeelangInteger;)Ldee/lang/DeelangInteger;\n"+
        "MOVE_RESULT         |     |v1=TEMP\n"+
        "CONST               |     |v2=0x00000000  // int:0   float:0.000000\n"+
        "APUT                |     |v8[v2]=v3\n"+
        "RETURN_VOID         |     |return");
  }
  
  @Test
  public void testLiteralMethodCallInt() throws ParserError, CompilerError {
    runCodeComparisonTest("1.toS()", 
        "extends com.roscopeco.deelang.runtime.CompiledScript",
        "public final V run(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.Binding)\n"+
        "                this:v3   //DexCompiledScript__UUID__\n"+
        "                    :v4   //dee.lang.DeelangObject\n"+
        "                    :v5   //com.roscopeco.deelang.runtime.Binding\n"+
        "CONST               |     |v1=0x00000001  // int:1   float:0.000000\n"+
        "NEW_INSTANCE        |     |v0=NEW Ldee/lang/DeelangInteger;\n"+
        "INVOKE_DIRECT       |     |v0.<init>(v5,v1)  //Ldee/lang/DeelangInteger;.<init>(Lcom/roscopeco/deelang/runtime/Binding;I)V\n"+
        "INVOKE_VIRTUAL      |     |TEMP=v0.toS()  //Ldee/lang/DeelangObject;.toS()Ldee/lang/DeelangString;\n"+
        "MOVE_RESULT         |     |v2=TEMP\n"+
        "RETURN_VOID         |     |return");
    }

  @Test
  public void testLiteralMethodCallString() throws ParserError, CompilerError {
    runCodeComparisonTest("\"foo\".toS()", 
        "extends com.roscopeco.deelang.runtime.CompiledScript",
        "public final V run(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.Binding)\n"+
        "                this:v3   //DexCompiledScript__UUID__\n"+
        "                    :v4   //dee.lang.DeelangObject\n"+
        "                    :v5   //com.roscopeco.deelang.runtime.Binding\n"+
        "CONST_STRING        |     |v1=\"foo\"\n"+
        "NEW_INSTANCE        |     |v0=NEW Ldee/lang/DeelangString;\n"+
        "INVOKE_DIRECT       |     |v0.<init>(v5,v1)  //Ldee/lang/DeelangString;.<init>(Lcom/roscopeco/deelang/runtime/Binding;Ljava/lang/String;)V\n"+
        "INVOKE_VIRTUAL      |     |TEMP=v0.toS()  //Ldee/lang/DeelangString;.toS()Ldee/lang/DeelangString;\n"+
        "MOVE_RESULT         |     |v2=TEMP\n"+
        "RETURN_VOID         |     |return");
    }

  // TODO more tests needed:
  /*
   * foo.bar().baz(quux().qix())
   * foo.field.bar()
   * 
   * Also, this case (should now work):
   * someLocal = 1
   * foo(someLocal)
   * (... more stuff that allocs registers...)
   * (... check somelocal wasn't freed with arg registers ...)
   */
}
