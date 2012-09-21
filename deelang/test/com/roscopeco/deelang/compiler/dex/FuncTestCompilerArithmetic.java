package com.roscopeco.deelang.compiler.dex;

import org.junit.Test;

import com.roscopeco.deelang.compiler.CompilerError;
import com.roscopeco.deelang.parser.ParserError;

public class FuncTestCompilerArithmetic extends CompilerFuncTestBase {
  private void runComparison(String sumCode, String expMethod) throws ParserError, CompilerError {
    runCodeComparisonTest(sumCode, 
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
        "                this:v5   //DexCompiledScript__UUID__\n"+
        "                    :v6   //dee.lang.DeelangObject\n"+
        "                    :v7   //com.roscopeco.deelang.runtime.Binding\n"+
        "CONST               |     |v1=0x00000001  // int:1   float:0.000000\n"+
        "NEW_INSTANCE        |     |v0=NEW Ldee/lang/DeelangInteger;\n"+
        "INVOKE_DIRECT       |     |v0.<init>(v7,v1)  //Ldee/lang/DeelangInteger;.<init>(Lcom/roscopeco/deelang/runtime/Binding;I)V\n"+
        "CONST               |     |v1=0x00000002  // int:2   float:0.000000\n"+
        "NEW_INSTANCE        |     |v2=NEW Ldee/lang/DeelangInteger;\n"+
        "INVOKE_DIRECT       |     |v2.<init>(v7,v1)  //Ldee/lang/DeelangInteger;.<init>(Lcom/roscopeco/deelang/runtime/Binding;I)V\n"+
        "INVOKE_VIRTUAL      |     |TEMP=v0.__opADD(v2)  //Ldee/lang/DeelangObject;.__opADD(Ldee/lang/DeelangObject;)Ldee/lang/DeelangObject;\n"+
        "MOVE_RESULT         |     |v3=TEMP\n"+
        "CONST               |     |v1=0x00000003  // int:3   float:0.000000\n"+
        "NEW_INSTANCE        |     |v4=NEW Ldee/lang/DeelangInteger;\n"+
        "INVOKE_DIRECT       |     |v4.<init>(v7,v1)  //Ldee/lang/DeelangInteger;.<init>(Lcom/roscopeco/deelang/runtime/Binding;I)V\n"+
        "INVOKE_VIRTUAL      |     |TEMP=v3.__opSUB(v4)  //Ldee/lang/DeelangObject;.__opSUB(Ldee/lang/DeelangObject;)Ldee/lang/DeelangObject;\n"+
        "RETURN_VOID         |     |return");
  }

  @Test
  public void testLiteralLiteralLiteralMulAddSum() throws ParserError, CompilerError {
    runCodeComparisonTest("1+2*3", 
        "extends com.roscopeco.deelang.runtime.CompiledScript",
        "public V run(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.Binding)\n"+
        "                this:v5   //DexCompiledScript__UUID__\n"+
        "                    :v6   //dee.lang.DeelangObject\n"+
        "                    :v7   //com.roscopeco.deelang.runtime.Binding\n"+
        "CONST               |     |v1=0x00000001  // int:1   float:0.000000\n"+
        "NEW_INSTANCE        |     |v0=NEW Ldee/lang/DeelangInteger;\n"+
        "INVOKE_DIRECT       |     |v0.<init>(v7,v1)  //Ldee/lang/DeelangInteger;.<init>(Lcom/roscopeco/deelang/runtime/Binding;I)V\n"+
        "CONST               |     |v1=0x00000002  // int:2   float:0.000000\n"+
        "NEW_INSTANCE        |     |v2=NEW Ldee/lang/DeelangInteger;\n"+
        "INVOKE_DIRECT       |     |v2.<init>(v7,v1)  //Ldee/lang/DeelangInteger;.<init>(Lcom/roscopeco/deelang/runtime/Binding;I)V\n"+
        "CONST               |     |v1=0x00000003  // int:3   float:0.000000\n"+
        "NEW_INSTANCE        |     |v3=NEW Ldee/lang/DeelangInteger;\n"+
        "INVOKE_DIRECT       |     |v3.<init>(v7,v1)  //Ldee/lang/DeelangInteger;.<init>(Lcom/roscopeco/deelang/runtime/Binding;I)V\n"+
        "INVOKE_VIRTUAL      |     |TEMP=v2.__opMUL(v3)  //Ldee/lang/DeelangObject;.__opMUL(Ldee/lang/DeelangObject;)Ldee/lang/DeelangObject;\n"+
        "MOVE_RESULT         |     |v4=TEMP\n"+
        "INVOKE_VIRTUAL      |     |TEMP=v0.__opADD(v4)  //Ldee/lang/DeelangObject;.__opADD(Ldee/lang/DeelangObject;)Ldee/lang/DeelangObject;\n"+
        "RETURN_VOID         |     |return");
  }

  @Test
  public void testLiteralLiteralLiteralMulAddSumExplicitPrecedence() throws ParserError, CompilerError {
    runCodeComparisonTest("(1+2)*3",
        "extends com.roscopeco.deelang.runtime.CompiledScript",
        "public V run(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.Binding)\n"+
        "                this:v5   //DexCompiledScript__UUID__\n"+
        "                    :v6   //dee.lang.DeelangObject\n"+
        "                    :v7   //com.roscopeco.deelang.runtime.Binding\n"+
        "CONST               |     |v1=0x00000001  // int:1   float:0.000000\n"+
        "NEW_INSTANCE        |     |v0=NEW Ldee/lang/DeelangInteger;\n"+
        "INVOKE_DIRECT       |     |v0.<init>(v7,v1)  //Ldee/lang/DeelangInteger;.<init>(Lcom/roscopeco/deelang/runtime/Binding;I)V\n"+
        "CONST               |     |v1=0x00000002  // int:2   float:0.000000\n"+
        "NEW_INSTANCE        |     |v2=NEW Ldee/lang/DeelangInteger;\n"+
        "INVOKE_DIRECT       |     |v2.<init>(v7,v1)  //Ldee/lang/DeelangInteger;.<init>(Lcom/roscopeco/deelang/runtime/Binding;I)V\n"+
        "INVOKE_VIRTUAL      |     |TEMP=v0.__opADD(v2)  //Ldee/lang/DeelangObject;.__opADD(Ldee/lang/DeelangObject;)Ldee/lang/DeelangObject;\n"+
        "MOVE_RESULT         |     |v3=TEMP\n"+
        "CONST               |     |v1=0x00000003  // int:3   float:0.000000\n"+
        "NEW_INSTANCE        |     |v4=NEW Ldee/lang/DeelangInteger;\n"+
        "INVOKE_DIRECT       |     |v4.<init>(v7,v1)  //Ldee/lang/DeelangInteger;.<init>(Lcom/roscopeco/deelang/runtime/Binding;I)V\n"+
        "INVOKE_VIRTUAL      |     |TEMP=v3.__opMUL(v4)  //Ldee/lang/DeelangObject;.__opMUL(Ldee/lang/DeelangObject;)Ldee/lang/DeelangObject;\n"+
        "RETURN_VOID         |     |return");
  }
  
  /* TODO More tests (e.g. vars/methods in arithmetic) */
}
