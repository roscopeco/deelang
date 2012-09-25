package com.roscopeco.deelang.compiler.dex;

import org.junit.Test;

import com.roscopeco.deelang.compiler.CompilerError;
import com.roscopeco.deelang.parser.ParserError;

public class FuncTestCompilerArithmetic extends CompilerFuncTestBase {
  private void runComparison(String sumCode, String expMethod) throws ParserError, CompilerError {
    runCodeComparisonTest(sumCode, 
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
        "INVOKE_VIRTUAL      |     |TEMP=v0."+expMethod+"(v2)  //Ldee/lang/DeelangObject;."+expMethod+"(Ldee/lang/DeelangObject;)Ldee/lang/DeelangObject;\n"+
        "RETURN_VOID         |     |return");
  }

  @Test
  public void testLiteralLiteralAdd() throws ParserError, CompilerError {
    runComparison("1+2", "__opADD");
  }
  
  @Test
  public void testLiteralLiteralSub() throws ParserError, CompilerError {
    runComparison("1-2", "__opSUB");
  }
  
  @Test
  public void testLiteralLiteralMul() throws ParserError, CompilerError {
    runComparison("1*2", "__opMUL");
  }
  
  @Test
  public void testLiteralLiteralDiv() throws ParserError, CompilerError {
    runComparison("1/2", "__opDIV");
  }

  @Test
  public void testLiteralLiteralMod() throws ParserError, CompilerError {
    runComparison("1%2", "__opMOD");
  }

  @Test
  public void testLiteralLiteralPow() throws ParserError, CompilerError {
    runComparison("1^2", "__opPOW");
  }

  @Test
  public void testLiteralLiteralLiteralSum() throws ParserError, CompilerError {
    runCodeComparisonTest("1+2-3",
        "extends com.roscopeco.deelang.runtime.CompiledScript",
        "                this:v7   //DexCompiledScript__UUID__\n"+
        "                    :v8   //dee.lang.DeelangObject\n"+
        "                    :v9   //com.roscopeco.deelang.runtime.Binding\n"+
        "CONST               |     |v2=0x00000001  // int:1   float:0.000000\n"+
        "NEW_INSTANCE        |     |v1=NEW Ldee/lang/DeelangInteger;\n"+
        "INVOKE_DIRECT       |     |v1.<init>(v9,v2)  //Ldee/lang/DeelangInteger;.<init>(Lcom/roscopeco/deelang/runtime/Binding;I)V\n"+
        "CONST               |     |v2=0x00000002  // int:2   float:0.000000\n"+
        "NEW_INSTANCE        |     |v3=NEW Ldee/lang/DeelangInteger;\n"+
        "INVOKE_DIRECT       |     |v3.<init>(v9,v2)  //Ldee/lang/DeelangInteger;.<init>(Lcom/roscopeco/deelang/runtime/Binding;I)V\n"+
        "INVOKE_VIRTUAL      |     |TEMP=v1.__opADD(v3)  //Ldee/lang/DeelangObject;.__opADD(Ldee/lang/DeelangObject;)Ldee/lang/DeelangObject;\n"+
        "MOVE_RESULT         |     |v5=TEMP\n"+
        "MOVE                |     |v0 = v5\n"+
        "CHECK_CAST          |     |v0=(dee.lang.DeelangInteger) v0\n"+
        "MOVE                |     |v4 = v0\n"+
        "CONST               |     |v2=0x00000003  // int:3   float:0.000000\n"+
        "NEW_INSTANCE        |     |v6=NEW Ldee/lang/DeelangInteger;\n"+
        "INVOKE_DIRECT       |     |v6.<init>(v9,v2)  //Ldee/lang/DeelangInteger;.<init>(Lcom/roscopeco/deelang/runtime/Binding;I)V\n"+
        "INVOKE_VIRTUAL      |     |TEMP=v4.__opSUB(v6)  //Ldee/lang/DeelangObject;.__opSUB(Ldee/lang/DeelangObject;)Ldee/lang/DeelangObject;\n"+
        "RETURN_VOID         |     |return");
  }

  @Test
  public void testLiteralLiteralLiteralMulAddSum() throws ParserError, CompilerError {
    runCodeComparisonTest("1+2*3", 
        "extends com.roscopeco.deelang.runtime.CompiledScript",
        "public final V run(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.Binding)\n"+
        "                this:v7   //DexCompiledScript__UUID__\n"+
        "                    :v8   //dee.lang.DeelangObject\n"+
        "                    :v9   //com.roscopeco.deelang.runtime.Binding\n"+
        "CONST               |     |v2=0x00000001  // int:1   float:0.000000\n"+
        "NEW_INSTANCE        |     |v1=NEW Ldee/lang/DeelangInteger;\n"+
        "INVOKE_DIRECT       |     |v1.<init>(v9,v2)  //Ldee/lang/DeelangInteger;.<init>(Lcom/roscopeco/deelang/runtime/Binding;I)V\n"+
        "CONST               |     |v2=0x00000002  // int:2   float:0.000000\n"+
        "NEW_INSTANCE        |     |v3=NEW Ldee/lang/DeelangInteger;\n"+
        "INVOKE_DIRECT       |     |v3.<init>(v9,v2)  //Ldee/lang/DeelangInteger;.<init>(Lcom/roscopeco/deelang/runtime/Binding;I)V\n"+
        "CONST               |     |v2=0x00000003  // int:3   float:0.000000\n"+
        "NEW_INSTANCE        |     |v4=NEW Ldee/lang/DeelangInteger;\n"+
        "INVOKE_DIRECT       |     |v4.<init>(v9,v2)  //Ldee/lang/DeelangInteger;.<init>(Lcom/roscopeco/deelang/runtime/Binding;I)V\n"+
        "INVOKE_VIRTUAL      |     |TEMP=v3.__opMUL(v4)  //Ldee/lang/DeelangObject;.__opMUL(Ldee/lang/DeelangObject;)Ldee/lang/DeelangObject;\n"+
        "MOVE_RESULT         |     |v6=TEMP\n"+
        "MOVE                |     |v0 = v6\n"+
        "CHECK_CAST          |     |v0=(dee.lang.DeelangInteger) v0\n"+
        "MOVE                |     |v5 = v0\n"+
        "INVOKE_VIRTUAL      |     |TEMP=v1.__opADD(v5)  //Ldee/lang/DeelangObject;.__opADD(Ldee/lang/DeelangObject;)Ldee/lang/DeelangObject;\n"+
        "RETURN_VOID         |     |return");
  }

  @Test
  public void testLiteralLiteralAddAsMethodArg() throws ParserError, CompilerError {
    runCodeComparisonTest("bar(3+2)",
        "extends com.roscopeco.deelang.runtime.CompiledScript",
        "public final V run(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.Binding)\n"+
        "                this:v7   //DexCompiledScript__UUID__\n"+
        "                    :v8   //dee.lang.DeelangObject\n"+
        "                    :v9   //com.roscopeco.deelang.runtime.Binding\n"+
        "CONST               |     |v2=0x00000003  // int:3   float:0.000000\n"+
        "NEW_INSTANCE        |     |v1=NEW Ldee/lang/DeelangInteger;\n"+
        "INVOKE_DIRECT       |     |v1.<init>(v9,v2)  //Ldee/lang/DeelangInteger;.<init>(Lcom/roscopeco/deelang/runtime/Binding;I)V\n"+
        "CONST               |     |v2=0x00000002  // int:2   float:0.000000\n"+
        "NEW_INSTANCE        |     |v3=NEW Ldee/lang/DeelangInteger;\n"+
        "INVOKE_DIRECT       |     |v3.<init>(v9,v2)  //Ldee/lang/DeelangInteger;.<init>(Lcom/roscopeco/deelang/runtime/Binding;I)V\n"+
        "INVOKE_VIRTUAL      |     |TEMP=v1.__opADD(v3)  //Ldee/lang/DeelangObject;.__opADD(Ldee/lang/DeelangObject;)Ldee/lang/DeelangObject;\n"+
        "MOVE_RESULT         |     |v5=TEMP\n"+
        "MOVE                |     |v0 = v5\n"+
        "CHECK_CAST          |     |v0=(dee.lang.DeelangInteger) v0\n"+
        "MOVE                |     |v4 = v0\n"+
        "INVOKE_VIRTUAL      |     |TEMP=v8.bar(v4)  //Lcom/roscopeco/deelang/compiler/dex/CompilerFuncTestBase$Foo;.bar(Ldee/lang/DeelangInteger;)Ldee/lang/DeelangInteger;\n"+
        "MOVE_RESULT         |     |v6=TEMP");
  }
  
  @Test
  public void testLiteralLiteralLiteralMulAddSumExplicitPrecedence() throws ParserError, CompilerError {
    runCodeComparisonTest("(1+2)*3",
        "extends com.roscopeco.deelang.runtime.CompiledScript",
        "public final V run(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.Binding)\n"+
        "                this:v7   //DexCompiledScript__UUID__\n"+
        "                    :v8   //dee.lang.DeelangObject\n"+
        "                    :v9   //com.roscopeco.deelang.runtime.Binding\n"+
        "CONST               |     |v2=0x00000001  // int:1   float:0.000000\n"+
        "NEW_INSTANCE        |     |v1=NEW Ldee/lang/DeelangInteger;\n"+
        "INVOKE_DIRECT       |     |v1.<init>(v9,v2)  //Ldee/lang/DeelangInteger;.<init>(Lcom/roscopeco/deelang/runtime/Binding;I)V\n"+
        "CONST               |     |v2=0x00000002  // int:2   float:0.000000\n"+
        "NEW_INSTANCE        |     |v3=NEW Ldee/lang/DeelangInteger;\n"+
        "INVOKE_DIRECT       |     |v3.<init>(v9,v2)  //Ldee/lang/DeelangInteger;.<init>(Lcom/roscopeco/deelang/runtime/Binding;I)V\n"+
        "INVOKE_VIRTUAL      |     |TEMP=v1.__opADD(v3)  //Ldee/lang/DeelangObject;.__opADD(Ldee/lang/DeelangObject;)Ldee/lang/DeelangObject;\n"+
        "MOVE_RESULT         |     |v5=TEMP\n"+
        "MOVE                |     |v0 = v5\n"+
        "CHECK_CAST          |     |v0=(dee.lang.DeelangInteger) v0\n"+
        "MOVE                |     |v4 = v0\n"+
        "CONST               |     |v2=0x00000003  // int:3   float:0.000000\n"+
        "NEW_INSTANCE        |     |v6=NEW Ldee/lang/DeelangInteger;\n"+
        "INVOKE_DIRECT       |     |v6.<init>(v9,v2)  //Ldee/lang/DeelangInteger;.<init>(Lcom/roscopeco/deelang/runtime/Binding;I)V\n"+
        "INVOKE_VIRTUAL      |     |TEMP=v4.__opMUL(v6)  //Ldee/lang/DeelangObject;.__opMUL(Ldee/lang/DeelangObject;)Ldee/lang/DeelangObject;\n"+
        "RETURN_VOID         |     |return");
  }
  
  /* TODO More tests (e.g. vars/methods in arithmetic) */
}