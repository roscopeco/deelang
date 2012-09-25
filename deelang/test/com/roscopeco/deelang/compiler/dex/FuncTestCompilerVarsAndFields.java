package com.roscopeco.deelang.compiler.dex;

import org.junit.Test;

import com.roscopeco.deelang.compiler.CompilerError;
import com.roscopeco.deelang.parser.ParserError;

public class FuncTestCompilerVarsAndFields extends CompilerFuncTestBase {
  
  @Test
  public void testPlainIdentifierIsOptimizedAway() throws Throwable {
    runCodeComparisonTest("a", 
        "extends com.roscopeco.deelang.runtime.CompiledScript",
        "public final V run(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.Binding)\n"+
        "                this:v0   //DexCompiledScript__UUID__\n"+
        "                    :v1   //dee.lang.DeelangObject\n"+
        "                    :v2   //com.roscopeco.deelang.runtime.Binding\n"+
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
        "public final V run(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.Binding)\n"+
        "                this:v2   //DexCompiledScript__UUID__\n"+
        "                    :v3   //dee.lang.DeelangObject\n"+
        "                    :v4   //com.roscopeco.deelang.runtime.Binding\n"+
        "INVOKE_VIRTUAL      |     |TEMP=v3.baz()  //Lcom/roscopeco/deelang/compiler/dex/CompilerFuncTestBase$Foo;.baz()Ldee/lang/DeelangInteger;\n"+
        "MOVE_RESULT         |     |v0=TEMP\n"+
        "MOVE                |     |v1 = v0\n"+
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
        "public final V run(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.Binding)\n"+
        "                this:v5   //DexCompiledScript__UUID__\n"+
        "                    :v6   //dee.lang.DeelangObject\n"+
        "                    :v7   //com.roscopeco.deelang.runtime.Binding\n"+
        "CONST_STRING        |     |v1=\"b\"\n"+
        "INVOKE_INTERFACE    |     |TEMP=v7.getLocal(v1)  //Lcom/roscopeco/deelang/runtime/Binding;.getLocal(Ljava/lang/String;)Ljava/lang/Object;\n"+
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
        "public final V run(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.Binding)\n"+
        "                this:v3   //DexCompiledScript__UUID__\n"+
        "                    :v4   //dee.lang.DeelangObject\n"+
        "                    :v5   //com.roscopeco.deelang.runtime.Binding\n"+
        "CONST               |     |v1=0x00000003  // int:3   float:0.000000\n"+
        "NEW_INSTANCE        |     |v0=NEW Ldee/lang/DeelangInteger;\n"+
        "INVOKE_DIRECT       |     |v0.<init>(v5,v1)  //Ldee/lang/DeelangInteger;.<init>(Lcom/roscopeco/deelang/runtime/Binding;I)V\n"+
        "MOVE                |     |v2 = v0\n"+
        "INVOKE_VIRTUAL      |     |v4.foo(v2)  //Lcom/roscopeco/deelang/compiler/dex/CompilerFuncTestBase$Foo;.foo(Ldee/lang/DeelangInteger;)V\n"+
        "RETURN_VOID         |     |return");
  }
  
  @Test
  public void testLocalAssignmentChainedAssignment() throws Throwable {
    // TODO this one needs more testing, especially on a device. Not entirely
    //      sure if dalvik will like the way this shuffles the registers...
    //
    //      Also, it's doing a lot of useless moves...
    runCodeComparisonTest("a=b=1; bar(a); bar(b)", 
        "extends com.roscopeco.deelang.runtime.CompiledScript",
        "public final V run(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.Binding)\n"+
        "                this:v3   //DexCompiledScript__UUID__\n"+
        "                    :v4   //dee.lang.DeelangObject\n"+
        "                    :v5   //com.roscopeco.deelang.runtime.Binding\n"+
        "CONST               |     |v1=0x00000001  // int:1   float:0.000000\n"+
        "NEW_INSTANCE        |     |v0=NEW Ldee/lang/DeelangInteger;\n"+
        "INVOKE_DIRECT       |     |v0.<init>(v5,v1)  //Ldee/lang/DeelangInteger;.<init>(Lcom/roscopeco/deelang/runtime/Binding;I)V\n"+
        "MOVE                |     |v2 = v0\n"+
        "MOVE                |     |v0 = v2\n"+
        "INVOKE_VIRTUAL      |     |TEMP=v4.bar(v0)  //Lcom/roscopeco/deelang/compiler/dex/CompilerFuncTestBase$Foo;.bar(Ldee/lang/DeelangInteger;)Ldee/lang/DeelangInteger;\n"+
        "MOVE_RESULT         |     |v2=TEMP\n"+
        "INVOKE_VIRTUAL      |     |TEMP=v4.bar(v2)  //Lcom/roscopeco/deelang/compiler/dex/CompilerFuncTestBase$Foo;.bar(Ldee/lang/DeelangInteger;)Ldee/lang/DeelangInteger;\n"+
        "MOVE_RESULT         |     |v2=TEMP\n"+
        "RETURN_VOID         |     |return");
  }
  
  @Test
  public void testFieldFromLocalReceiverAssignment() throws Throwable {
    runCodeComparisonTest("foo.a=1", 
        "");
  }

  @Test
  public void testFieldFromMethodResultReceiverAssignment() throws Throwable {
    runCodeComparisonTest("foo().a=1", "");
  }
  
  @Test
  public void testFieldFromChainedCallAssignment() throws Throwable {
    runCodeComparisonTest("foo().bar.baz().a=1", "");
  }
  
  @Test
  public void testLocalsBindCorrectlyFromLiterals() throws ParserError, CompilerError {
    runCodeComparisonTest("a=1; b=2; bar(a)", 
        "extends com.roscopeco.deelang.runtime.CompiledScript",
            "public final V run(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.Binding)\n"+
            "                this:v4   //DexCompiledScript__UUID__\n"+
            "                    :v5   //dee.lang.DeelangObject\n"+
            "                    :v6   //com.roscopeco.deelang.runtime.Binding\n"+
            "CONST               |     |v1=0x00000001  // int:1   float:0.000000\n"+
            "NEW_INSTANCE        |     |v0=NEW Ldee/lang/DeelangInteger;\n"+
            "INVOKE_DIRECT       |     |v0.<init>(v6,v1)  //Ldee/lang/DeelangInteger;.<init>(Lcom/roscopeco/deelang/runtime/Binding;I)V\n"+
            "MOVE                |     |v2 = v0\n"+
            "CONST               |     |v1=0x00000002  // int:2   float:0.000000\n"+
            "NEW_INSTANCE        |     |v0=NEW Ldee/lang/DeelangInteger;\n"+
            "INVOKE_DIRECT       |     |v0.<init>(v6,v1)  //Ldee/lang/DeelangInteger;.<init>(Lcom/roscopeco/deelang/runtime/Binding;I)V\n"+
            "MOVE                |     |v3 = v0\n"+
            "INVOKE_VIRTUAL      |     |TEMP=v5.bar(v2)  //Lcom/roscopeco/deelang/compiler/dex/CompilerFuncTestBase$Foo;.bar(Ldee/lang/DeelangInteger;)Ldee/lang/DeelangInteger;\n"+
            "MOVE_RESULT         |     |v0=TEMP\n"+
            "RETURN_VOID         |     |return"
    );

  }
  @Test
  public void testLocalsBindCorrectlyFromMethods() throws Throwable {
    runCodeComparisonTest("a=baz(); b = 2; bar(a)", 
        "extends com.roscopeco.deelang.runtime.CompiledScript",
        "public final V run(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.Binding)\n"+
        "                this:v4   //DexCompiledScript__UUID__\n"+
        "                    :v5   //dee.lang.DeelangObject\n"+
        "                    :v6   //com.roscopeco.deelang.runtime.Binding\n"+
        "INVOKE_VIRTUAL      |     |TEMP=v5.baz()  //Lcom/roscopeco/deelang/compiler/dex/CompilerFuncTestBase$Foo;.baz()Ldee/lang/DeelangInteger;\n"+
        "MOVE_RESULT         |     |v0=TEMP\n"+
        "MOVE                |     |v1 = v0\n"+
        "CONST               |     |v2=0x00000002  // int:2   float:0.000000\n"+
        "NEW_INSTANCE        |     |v0=NEW Ldee/lang/DeelangInteger;\n"+
        "INVOKE_DIRECT       |     |v0.<init>(v6,v2)  //Ldee/lang/DeelangInteger;.<init>(Lcom/roscopeco/deelang/runtime/Binding;I)V\n"+
        "MOVE                |     |v3 = v0\n"+
        "INVOKE_VIRTUAL      |     |TEMP=v5.bar(v1)  //Lcom/roscopeco/deelang/compiler/dex/CompilerFuncTestBase$Foo;.bar(Ldee/lang/DeelangInteger;)Ldee/lang/DeelangInteger;\n"+
        "MOVE_RESULT         |     |v0=TEMP\n"+
        "RETURN_VOID         |     |return");
  }
}
