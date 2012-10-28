package com.roscopeco.deelang.compiler.dex;

import org.junit.Test;

import com.roscopeco.deelang.compiler.CompilerError;
import com.roscopeco.deelang.parser.ParserError;

public class FuncTestCompilerVarsAndFields extends CompilerFuncTestBase {
  
  @Test
  public void testPlainIdentifierIsOptimizedAway() throws Throwable {
    runCodeComparisonTest("a", 
        "extends com.roscopeco.deelang.runtime.CompiledScript",
        "public final V run(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.DexBinding)\n"+
        "                this:v0   //com.roscopeco.deelang.runtime.DexCompiledScript__UUID__\n"+
        "                    :v1   //dee.lang.DeelangObject\n"+
        "                    :v2   //com.roscopeco.deelang.runtime.DexBinding\n"+
        // Should generate no code.
        "RETURN_VOID         |     |return");
  }
  
  @Test(expected=UnknownVariableException.class)
  public void testPlainIdentifierThrowsUnknownVariable() throws Throwable {
    runCodeComparisonTest("c", "");
  }

  /*  DUPLICATES TESTS IN FuncTestCompilerLiterals.java 
  @Test
  public void testLocalAssignmentFromLiteral() throws Throwable {
    runCodeComparisonTest("a=1", 
        "");
  }
  */
  
  @Test
  public void testLocalAssignmentFromMethod() throws Throwable {
    runCodeComparisonTest("a=baz()", 
        "extends com.roscopeco.deelang.runtime.CompiledScript",
        "public final V run(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.DexBinding)\n"+
        "                this:v4   //com.roscopeco.deelang.runtime.DexCompiledScript__UUID__\n"+
        "                    :v5   //dee.lang.DeelangObject\n"+
        "                    :v6   //com.roscopeco.deelang.runtime.DexBinding\n"+
        "MOVE                |     |v0 = v5\n"+
        "CHECK_CAST          |     |v0=(com.roscopeco.deelang.compiler.dex.CompilerFuncTestBase$Foo) v0\n"+
        "MOVE                |     |v1 = v0\n"+
        "INVOKE_VIRTUAL      |     |TEMP=v1.baz()  //Lcom/roscopeco/deelang/compiler/dex/CompilerFuncTestBase$Foo;.baz()Ldee/lang/DeelangInteger;\n"+
        "MOVE_RESULT         |     |v2=TEMP\n"+
        "MOVE                |     |v3 = v2\n"+
        "RETURN_VOID         |     |return");
  }
  
  @Test(expected=IllegalMethodCallException.class)
  public void testLocalAssignmentFromVoidMethodThrowsIllegalCall() throws Throwable {
    runCodeComparisonTest("a=voidy()", "");
  }
  
  @Test
  public void testLocalAssignmentFromLocal() throws Throwable {
    runCodeComparisonTest("a=b", 
        "extends com.roscopeco.deelang.runtime.CompiledScript",
        "public final V run(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.DexBinding)\n"+
        "                this:v5   //com.roscopeco.deelang.runtime.DexCompiledScript__UUID__\n"+
        "                    :v6   //dee.lang.DeelangObject\n"+
        "                    :v7   //com.roscopeco.deelang.runtime.DexBinding\n"+
        "CONST_STRING        |     |v1=\"b\"\n"+
        "INVOKE_VIRTUAL      |     |TEMP=v7.getLocal(v1)  //Ldee/lang/Binding;.getLocal(Ljava/lang/String;)Ljava/lang/Object;\n"+
        "MOVE_RESULT         |     |v2=TEMP\n"+
        "MOVE                |     |v0 = v2\n"+
        "CHECK_CAST          |     |v0=(com.roscopeco.deelang.compiler.dex.CompilerFuncTestBase$Foo) v0\n"+
        "MOVE                |     |v3 = v0\n"+
        "MOVE                |     |v4 = v3\n"+
        "RETURN_VOID         |     |return");
  }
  
  @Test
  public void testLocalAssignmentAsMethodArg() throws Throwable {
    runCodeComparisonTest("foo(a=3)", 
        "extends com.roscopeco.deelang.runtime.CompiledScript",
        "public final V run(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.DexBinding)\n"+
        "                this:v5   //com.roscopeco.deelang.runtime.DexCompiledScript__UUID__\n"+
        "                    :v6   //dee.lang.DeelangObject\n"+
        "                    :v7   //com.roscopeco.deelang.runtime.DexBinding\n"+
        "MOVE                |     |v0 = v6\n"+
        "CHECK_CAST          |     |v0=(com.roscopeco.deelang.compiler.dex.CompilerFuncTestBase$Foo) v0\n"+
        "MOVE                |     |v1 = v0\n"+
        "CONST               |     |v3=0x00000003  // int:3   float:0.000000\n"+
        "NEW_INSTANCE        |     |v2=NEW Ldee/lang/DeelangInteger;\n"+
        "INVOKE_DIRECT       |     |v2.<init>(v7,v3)  //Ldee/lang/DeelangInteger;.<init>(Ldee/lang/Binding;I)V\n"+
        "MOVE                |     |v4 = v2\n"+
        "INVOKE_VIRTUAL      |     |v1.foo(v4)  //Lcom/roscopeco/deelang/compiler/dex/CompilerFuncTestBase$Foo;.foo(Ldee/lang/DeelangInteger;)V\n"+
        "RETURN_VOID         |     |return");
  }
  
  @Test
  public void testLocalAssignmentChainedAssignment() throws Throwable {
    // TODO This is doing a lot of useless moves...
    runCodeComparisonTest("a=b=1; bar(a); bar(b)", 
        "extends com.roscopeco.deelang.runtime.CompiledScript",
        "public final V run(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.DexBinding)\n"+
        "                this:v5   //com.roscopeco.deelang.runtime.DexCompiledScript__UUID__\n"+
        "                    :v6   //dee.lang.DeelangObject\n"+
        "                    :v7   //com.roscopeco.deelang.runtime.DexBinding\n"+
        "CONST               |     |v2=0x00000001  // int:1   float:0.000000\n"+
        "NEW_INSTANCE        |     |v1=NEW Ldee/lang/DeelangInteger;\n"+
        "INVOKE_DIRECT       |     |v1.<init>(v7,v2)  //Ldee/lang/DeelangInteger;.<init>(Ldee/lang/Binding;I)V\n"+
        "MOVE                |     |v3 = v1\n"+
        "MOVE                |     |v1 = v3\n"+
        "MOVE                |     |v0 = v6\n"+
        "CHECK_CAST          |     |v0=(com.roscopeco.deelang.compiler.dex.CompilerFuncTestBase$Foo) v0\n"+
        "MOVE                |     |v4 = v0\n"+
        "INVOKE_VIRTUAL      |     |TEMP=v4.bar(v1)  //Lcom/roscopeco/deelang/compiler/dex/CompilerFuncTestBase$Foo;.bar(Ldee/lang/DeelangInteger;)Ldee/lang/DeelangInteger;\n"+
        "MOVE_RESULT         |     |v3=TEMP\n"+
        "INVOKE_VIRTUAL      |     |TEMP=v4.bar(v3)  //Lcom/roscopeco/deelang/compiler/dex/CompilerFuncTestBase$Foo;.bar(Ldee/lang/DeelangInteger;)Ldee/lang/DeelangInteger;\n"+
        "MOVE_RESULT         |     |v3=TEMP\n"+
        "RETURN_VOID         |     |return");
  }

  /*
   * Cant optimize this at the moment - needed for chaining!
   *
  @Test
  public void testFieldFromLocalReceiverAccessIsOptimizedAway() throws Throwable {
    runCodeComparisonTest("foo.a", 
        "");
  }
  */

  @Test(expected=UnknownFieldException.class)
  public void testPrivateFieldFromLocalReceiverAccessThrows() throws Throwable {
    runCodeComparisonTest("foo.privField", 
        "");
  }

  @Test
  public void testFieldFromLocalReceiverAccessAssignToLocal() throws Throwable {
    runCodeComparisonTest("a = foo.a", 
        "extends com.roscopeco.deelang.runtime.CompiledScript",
        "public final V run(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.DexBinding)\n"+
        "                this:v6   //com.roscopeco.deelang.runtime.DexCompiledScript__UUID__\n"+
        "                    :v7   //dee.lang.DeelangObject\n"+
        "                    :v8   //com.roscopeco.deelang.runtime.DexBinding\n"+
        "CONST_STRING        |     |v1=\"foo\"\n"+
        "INVOKE_VIRTUAL      |     |TEMP=v8.getLocal(v1)  //Ldee/lang/Binding;.getLocal(Ljava/lang/String;)Ljava/lang/Object;\n"+
        "MOVE_RESULT         |     |v2=TEMP\n"+
        "MOVE                |     |v0 = v2\n"+
        "CHECK_CAST          |     |v0=(com.roscopeco.deelang.compiler.dex.CompilerFuncTestBase$Foo) v0\n"+
        "MOVE                |     |v3 = v0\n"+
        "IGET                |     |v4=v3.a  //Lcom/roscopeco/deelang/compiler/dex/CompilerFuncTestBase$Foo;.a Ldee/lang/DeelangInteger;\n"+
        "MOVE                |     |v5 = v4\n"+
        "RETURN_VOID         |     |return");
  }

  @Test
  public void testFieldFromLocalReceiverAccessAsMethodArg() throws Throwable {
    runCodeComparisonTest("foo(foo.a)",
        "extends com.roscopeco.deelang.runtime.CompiledScript",
        "public final V run(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.DexBinding)\n"+
        "                this:v6   //com.roscopeco.deelang.runtime.DexCompiledScript__UUID__\n"+
        "                    :v7   //dee.lang.DeelangObject\n"+
        "                    :v8   //com.roscopeco.deelang.runtime.DexBinding\n"+
        "MOVE                |     |v0 = v7\n"+
        "CHECK_CAST          |     |v0=(com.roscopeco.deelang.compiler.dex.CompilerFuncTestBase$Foo) v0\n"+
        "MOVE                |     |v1 = v0\n"+
        "CONST_STRING        |     |v2=\"foo\"\n"+
        "INVOKE_VIRTUAL      |     |TEMP=v8.getLocal(v2)  //Ldee/lang/Binding;.getLocal(Ljava/lang/String;)Ljava/lang/Object;\n"+
        "MOVE_RESULT         |     |v3=TEMP\n"+
        "MOVE                |     |v0 = v3\n"+
        "CHECK_CAST          |     |v0=(com.roscopeco.deelang.compiler.dex.CompilerFuncTestBase$Foo) v0\n"+
        "MOVE                |     |v4 = v0\n"+
        "IGET                |     |v5=v4.a  //Lcom/roscopeco/deelang/compiler/dex/CompilerFuncTestBase$Foo;.a Ldee/lang/DeelangInteger;\n"+
        "INVOKE_VIRTUAL      |     |v1.foo(v5)  //Lcom/roscopeco/deelang/compiler/dex/CompilerFuncTestBase$Foo;.foo(Ldee/lang/DeelangInteger;)V\n"+
        "RETURN_VOID         |     |return");
  }

  @Test
  public void testFieldFromMethodCallAccessAssignToLocal() throws Throwable {
    runCodeComparisonTest("a = boo().a", 
        "extends com.roscopeco.deelang.runtime.CompiledScript",
        "public final V run(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.DexBinding)\n"+
        "                this:v5   //com.roscopeco.deelang.runtime.DexCompiledScript__UUID__\n"+
        "                    :v6   //dee.lang.DeelangObject\n"+
        "                    :v7   //com.roscopeco.deelang.runtime.DexBinding\n"+
        "MOVE                |     |v0 = v6\n"+
        "CHECK_CAST          |     |v0=(com.roscopeco.deelang.compiler.dex.CompilerFuncTestBase$Foo) v0\n"+
        "MOVE                |     |v1 = v0\n"+
        "INVOKE_VIRTUAL      |     |TEMP=v1.boo()  //Lcom/roscopeco/deelang/compiler/dex/CompilerFuncTestBase$Foo;.boo()Lcom/roscopeco/deelang/compiler/dex/CompilerFuncTestBase$Foo;\n"+
        "MOVE_RESULT         |     |v2=TEMP\n"+
        "IGET                |     |v3=v2.a  //Lcom/roscopeco/deelang/compiler/dex/CompilerFuncTestBase$Foo;.a Ldee/lang/DeelangInteger;\n"+
        "MOVE                |     |v4 = v3\n"+
        "RETURN_VOID         |     |return");
  }
  
  @Test
  public void testFieldFromChainedCallAccessAssignToLocal() throws Throwable {
    runCodeComparisonTest("a = boo().bar.boo2().a", 
        "extends com.roscopeco.deelang.runtime.CompiledScript",
        "public final V run(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.DexBinding)\n"+
        "                this:v7   //com.roscopeco.deelang.runtime.DexCompiledScript__UUID__\n"+
        "                    :v8   //dee.lang.DeelangObject\n"+
        "                    :v9   //com.roscopeco.deelang.runtime.DexBinding\n"+
        "MOVE                |     |v0 = v8\n"+
        "CHECK_CAST          |     |v0=(com.roscopeco.deelang.compiler.dex.CompilerFuncTestBase$Foo) v0\n"+
        "MOVE                |     |v1 = v0\n"+
        "INVOKE_VIRTUAL      |     |TEMP=v1.boo()  //Lcom/roscopeco/deelang/compiler/dex/CompilerFuncTestBase$Foo;.boo()Lcom/roscopeco/deelang/compiler/dex/CompilerFuncTestBase$Foo;\n"+
        "MOVE_RESULT         |     |v2=TEMP\n"+
        "IGET                |     |v3=v2.bar  //Lcom/roscopeco/deelang/compiler/dex/CompilerFuncTestBase$Foo;.bar Lcom/roscopeco/deelang/compiler/dex/CompilerFuncTestBase$Foo;\n"+
        "INVOKE_VIRTUAL      |     |TEMP=v3.boo2()  //Lcom/roscopeco/deelang/compiler/dex/CompilerFuncTestBase$Foo;.boo2()Lcom/roscopeco/deelang/compiler/dex/CompilerFuncTestBase$Foo;\n"+
        "MOVE_RESULT         |     |v4=TEMP\n"+
        "IGET                |     |v5=v4.a  //Lcom/roscopeco/deelang/compiler/dex/CompilerFuncTestBase$Foo;.a Ldee/lang/DeelangInteger;\n"+
        "MOVE                |     |v6 = v5\n"+
        "RETURN_VOID         |     |return");
  }

  @Test
  public void testFieldFromLocalReceiverAssignment() throws Throwable {
    runCodeComparisonTest("foo.a=1", 
        "extends com.roscopeco.deelang.runtime.CompiledScript",
        "");
  }

  @Test
  public void testFieldFromMethodResultReceiverAssignment() throws Throwable {
    runCodeComparisonTest("boo().a=1", 
        "extends com.roscopeco.deelang.runtime.CompiledScript",
        "public final V run(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.DexBinding)\n"+
        "                this:v5   //com.roscopeco.deelang.runtime.DexCompiledScript__UUID__\n"+
        "                    :v6   //dee.lang.DeelangObject\n"+
        "                    :v7   //com.roscopeco.deelang.runtime.DexBinding\n"+
        "MOVE                |     |v0 = v6\n"+
        "CHECK_CAST          |     |v0=(com.roscopeco.deelang.compiler.dex.CompilerFuncTestBase$Foo) v0\n"+
        "MOVE                |     |v1 = v0\n"+
        "INVOKE_VIRTUAL      |     |TEMP=v1.boo()  //Lcom/roscopeco/deelang/compiler/dex/CompilerFuncTestBase$Foo;.boo()Lcom/roscopeco/deelang/compiler/dex/CompilerFuncTestBase$Foo;\n"+
        "MOVE_RESULT         |     |v2=TEMP\n"+
        "CONST               |     |v4=0x00000001  // int:1   float:0.000000\n"+
        "NEW_INSTANCE        |     |v3=NEW Ldee/lang/DeelangInteger;\n"+
        "INVOKE_DIRECT       |     |v3.<init>(v7,v4)  //Ldee/lang/DeelangInteger;.<init>(Ldee/lang/Binding;I)V\n"+
        "IPUT                |     |v2.a=v3  //Lcom/roscopeco/deelang/compiler/dex/CompilerFuncTestBase$Foo;.a Ldee/lang/DeelangInteger;\n"+
        "RETURN_VOID         |     |return");
  }
  
  @Test
  public void testFieldFromChainedCallAssignment() throws Throwable {
    runCodeComparisonTest("boo().bar.boo2().a=1", 
        "extends com.roscopeco.deelang.runtime.CompiledScript",
        "public final V run(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.DexBinding)\n"+
        "                this:v5   //com.roscopeco.deelang.runtime.DexCompiledScript__UUID__\n"+
        "                    :v6   //dee.lang.DeelangObject\n"+
        "                    :v7   //com.roscopeco.deelang.runtime.DexBinding\n"+
        "MOVE                |     |v0 = v6\n"+
        "CHECK_CAST          |     |v0=(com.roscopeco.deelang.compiler.dex.CompilerFuncTestBase$Foo) v0\n"+
        "MOVE                |     |v1 = v0\n"+
        "INVOKE_VIRTUAL      |     |TEMP=v1.boo()  //Lcom/roscopeco/deelang/compiler/dex/CompilerFuncTestBase$Foo;.boo()Lcom/roscopeco/deelang/compiler/dex/CompilerFuncTestBase$Foo;\n"+
        "MOVE_RESULT         |     |v2=TEMP\n"+
        "IGET                |     |v2=v2.bar  //Lcom/roscopeco/deelang/compiler/dex/CompilerFuncTestBase$Foo;.bar Lcom/roscopeco/deelang/compiler/dex/CompilerFuncTestBase$Foo;\n"+
        "INVOKE_VIRTUAL      |     |TEMP=v2.boo2()  //Lcom/roscopeco/deelang/compiler/dex/CompilerFuncTestBase$Foo;.boo2()Lcom/roscopeco/deelang/compiler/dex/CompilerFuncTestBase$Foo;\n"+
        "MOVE_RESULT         |     |v2=TEMP\n"+
        "CONST               |     |v4=0x00000001  // int:1   float:0.000000\n"+
        "NEW_INSTANCE        |     |v3=NEW Ldee/lang/DeelangInteger;\n"+
        "INVOKE_DIRECT       |     |v3.<init>(v7,v4)  //Ldee/lang/DeelangInteger;.<init>(Ldee/lang/Binding;I)V\n"+
        "IPUT                |     |v2.a=v3  //Lcom/roscopeco/deelang/compiler/dex/CompilerFuncTestBase$Foo;.a Ldee/lang/DeelangInteger;\n"+
        "RETURN_VOID         |     |return");
  }
  
  @Test
  public void testFieldAssignmentAsMethodArg() throws Throwable {
    runCodeComparisonTest("foo(foo.a=1)", 
        "extends com.roscopeco.deelang.runtime.CompiledScript",
        "public final V run(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.DexBinding)\n"+
        "                this:v7   //com.roscopeco.deelang.runtime.DexCompiledScript__UUID__\n"+
        "                    :v8   //dee.lang.DeelangObject\n"+
        "                    :v9   //com.roscopeco.deelang.runtime.DexBinding\n"+
        "MOVE                |     |v0 = v8\n"+
        "CHECK_CAST          |     |v0=(com.roscopeco.deelang.compiler.dex.CompilerFuncTestBase$Foo) v0\n"+
        "MOVE                |     |v1 = v0\n"+
        "CONST_STRING        |     |v2=\"foo\"\n"+
        "INVOKE_VIRTUAL      |     |TEMP=v9.getLocal(v2)  //Ldee/lang/Binding;.getLocal(Ljava/lang/String;)Ljava/lang/Object;\n"+
        "MOVE_RESULT         |     |v3=TEMP\n"+
        "MOVE                |     |v0 = v3\n"+
        "CHECK_CAST          |     |v0=(com.roscopeco.deelang.compiler.dex.CompilerFuncTestBase$Foo) v0\n"+
        "MOVE                |     |v4 = v0\n"+
        "CONST               |     |v6=0x00000001  // int:1   float:0.000000\n"+
        "NEW_INSTANCE        |     |v5=NEW Ldee/lang/DeelangInteger;\n"+
        "INVOKE_DIRECT       |     |v5.<init>(v9,v6)  //Ldee/lang/DeelangInteger;.<init>(Ldee/lang/Binding;I)V\n"+
        "IPUT                |     |v4.a=v5  //Lcom/roscopeco/deelang/compiler/dex/CompilerFuncTestBase$Foo;.a Ldee/lang/DeelangInteger;\n"+
        "INVOKE_VIRTUAL      |     |v1.foo(v5)  //Lcom/roscopeco/deelang/compiler/dex/CompilerFuncTestBase$Foo;.foo(Ldee/lang/DeelangInteger;)V\n"+
        "RETURN_VOID         |     |return");
  }

  @Test(expected=TypeException.class)
  public void testFieldFromIncompatibleTypeAssignment() throws Throwable {
    runCodeComparisonTest("foo.a=\"Hello\"", "");
  }
  
  @Test
  public void testLocalsBindCorrectlyFromLiterals() throws ParserError, CompilerError {
    runCodeComparisonTest("a=1; b=2; bar(a)", 
        "extends com.roscopeco.deelang.runtime.CompiledScript",
            "public final V run(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.DexBinding)\n"+
            "                this:v6   //com.roscopeco.deelang.runtime.DexCompiledScript__UUID__\n"+
            "                    :v7   //dee.lang.DeelangObject\n"+
            "                    :v8   //com.roscopeco.deelang.runtime.DexBinding\n"+
            "CONST               |     |v2=0x00000001  // int:1   float:0.000000\n"+
            "NEW_INSTANCE        |     |v1=NEW Ldee/lang/DeelangInteger;\n"+
            "INVOKE_DIRECT       |     |v1.<init>(v8,v2)  //Ldee/lang/DeelangInteger;.<init>(Ldee/lang/Binding;I)V\n"+
            "MOVE                |     |v3 = v1\n"+
            "CONST               |     |v2=0x00000002  // int:2   float:0.000000\n"+
            "NEW_INSTANCE        |     |v1=NEW Ldee/lang/DeelangInteger;\n"+
            "INVOKE_DIRECT       |     |v1.<init>(v8,v2)  //Ldee/lang/DeelangInteger;.<init>(Ldee/lang/Binding;I)V\n"+
            "MOVE                |     |v4 = v1\n"+
            "MOVE                |     |v0 = v7\n"+
            "CHECK_CAST          |     |v0=(com.roscopeco.deelang.compiler.dex.CompilerFuncTestBase$Foo) v0\n"+
            "MOVE                |     |v5 = v0\n"+
            "INVOKE_VIRTUAL      |     |TEMP=v5.bar(v3)  //Lcom/roscopeco/deelang/compiler/dex/CompilerFuncTestBase$Foo;.bar(Ldee/lang/DeelangInteger;)Ldee/lang/DeelangInteger;\n"+
            "MOVE_RESULT         |     |v1=TEMP\n"+
            "RETURN_VOID         |     |return"
    );

  }
  @Test
  public void testLocalsBindCorrectlyFromMethods() throws Throwable {
    runCodeComparisonTest("a=baz(); b = 2; bar(a)", 
        "extends com.roscopeco.deelang.runtime.CompiledScript",
        "public final V run(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.DexBinding)\n"+
        "                this:v6   //com.roscopeco.deelang.runtime.DexCompiledScript__UUID__\n"+
        "                    :v7   //dee.lang.DeelangObject\n"+
        "                    :v8   //com.roscopeco.deelang.runtime.DexBinding\n"+
        "MOVE                |     |v0 = v7\n"+
        "CHECK_CAST          |     |v0=(com.roscopeco.deelang.compiler.dex.CompilerFuncTestBase$Foo) v0\n"+
        "MOVE                |     |v1 = v0\n"+
        "INVOKE_VIRTUAL      |     |TEMP=v1.baz()  //Lcom/roscopeco/deelang/compiler/dex/CompilerFuncTestBase$Foo;.baz()Ldee/lang/DeelangInteger;\n"+
        "MOVE_RESULT         |     |v2=TEMP\n"+
        "MOVE                |     |v3 = v2\n"+
        "CONST               |     |v4=0x00000002  // int:2   float:0.000000\n"+
        "NEW_INSTANCE        |     |v2=NEW Ldee/lang/DeelangInteger;\n"+
        "INVOKE_DIRECT       |     |v2.<init>(v8,v4)  //Ldee/lang/DeelangInteger;.<init>(Ldee/lang/Binding;I)V\n"+
        "MOVE                |     |v5 = v2\n"+
        "INVOKE_VIRTUAL      |     |TEMP=v1.bar(v3)  //Lcom/roscopeco/deelang/compiler/dex/CompilerFuncTestBase$Foo;.bar(Ldee/lang/DeelangInteger;)Ldee/lang/DeelangInteger;\n"+
        "MOVE_RESULT         |     |v2=TEMP\n"+
        "RETURN_VOID         |     |return");
  }
}
