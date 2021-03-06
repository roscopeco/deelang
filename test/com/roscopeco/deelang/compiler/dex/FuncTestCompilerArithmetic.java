package com.roscopeco.deelang.compiler.dex;

import org.junit.Test;

import com.roscopeco.deelang.compiler.CompilerError;
import com.roscopeco.deelang.parser.ParserError;

public class FuncTestCompilerArithmetic extends CompilerFuncTestBase {
  private void runComparison(String sumCode, String expMethod) throws ParserError, CompilerError {
    runCodeComparisonTest(sumCode, 
        "extends com.roscopeco.deelang.runtime.dex.CompiledScript",
        "public final V run(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.dex.DexBinding)\n"+
        "                this:v6   //com.roscopeco.deelang.runtime.dex.DexCompiledScript__UUID__\n"+
        "                    :v7   //dee.lang.DeelangObject\n"+
        "                    :v8   //com.roscopeco.deelang.runtime.dex.DexBinding\n"+
        "CONST               |     |v2=0x00000001  // int:1   float:0.000000\n"+
        "NEW_INSTANCE        |     |v1=NEW Ldee/lang/DeelangInteger;\n"+
        "INVOKE_DIRECT       |     |v1.<init>(v8,v2)  //Ldee/lang/DeelangInteger;.<init>(Ldee/lang/Binding;I)V\n"+
        "CONST               |     |v2=0x00000002  // int:2   float:0.000000\n"+
        "NEW_INSTANCE        |     |v3=NEW Ldee/lang/DeelangInteger;\n"+
        "INVOKE_DIRECT       |     |v3.<init>(v8,v2)  //Ldee/lang/DeelangInteger;.<init>(Ldee/lang/Binding;I)V\n"+
        "INVOKE_VIRTUAL      |     |TEMP=v1." + expMethod + "(v3)  //Ldee/lang/DeelangObject;." + expMethod + "(Ldee/lang/DeelangObject;)Ldee/lang/DeelangObject;\n"+
        "MOVE_RESULT         |     |v5=TEMP\n"+
        "MOVE                |     |v0 = v5\n"+
        "CHECK_CAST          |     |v0=(dee.lang.DeelangInteger) v0\n"+
        "MOVE                |     |v4 = v0\n"+
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
        "extends com.roscopeco.deelang.runtime.dex.CompiledScript",
        "                this:v8   //com.roscopeco.deelang.runtime.dex.DexCompiledScript__UUID__\n"+
        "                    :v9   //dee.lang.DeelangObject\n"+
        "                    :v10   //com.roscopeco.deelang.runtime.dex.DexBinding\n"+
        "CONST               |     |v2=0x00000001  // int:1   float:0.000000\n"+
        "NEW_INSTANCE        |     |v1=NEW Ldee/lang/DeelangInteger;\n"+
        "INVOKE_DIRECT       |     |v1.<init>(v10,v2)  //Ldee/lang/DeelangInteger;.<init>(Ldee/lang/Binding;I)V\n"+
        "CONST               |     |v2=0x00000002  // int:2   float:0.000000\n"+
        "NEW_INSTANCE        |     |v3=NEW Ldee/lang/DeelangInteger;\n"+
        "INVOKE_DIRECT       |     |v3.<init>(v10,v2)  //Ldee/lang/DeelangInteger;.<init>(Ldee/lang/Binding;I)V\n"+
        "INVOKE_VIRTUAL      |     |TEMP=v1.__opADD(v3)  //Ldee/lang/DeelangObject;.__opADD(Ldee/lang/DeelangObject;)Ldee/lang/DeelangObject;\n"+
        "MOVE_RESULT         |     |v5=TEMP\n"+
        "MOVE                |     |v0 = v5\n"+
        "CHECK_CAST          |     |v0=(dee.lang.DeelangInteger) v0\n"+
        "MOVE                |     |v4 = v0\n"+
        "CONST               |     |v2=0x00000003  // int:3   float:0.000000\n"+
        "NEW_INSTANCE        |     |v6=NEW Ldee/lang/DeelangInteger;\n"+
        "INVOKE_DIRECT       |     |v6.<init>(v10,v2)  //Ldee/lang/DeelangInteger;.<init>(Ldee/lang/Binding;I)V\n"+
        "INVOKE_VIRTUAL      |     |TEMP=v4.__opSUB(v6)  //Ldee/lang/DeelangObject;.__opSUB(Ldee/lang/DeelangObject;)Ldee/lang/DeelangObject;\n"+
        "MOVE_RESULT         |     |v5=TEMP\n"+
        "MOVE                |     |v0 = v5\n"+
        "CHECK_CAST          |     |v0=(dee.lang.DeelangInteger) v0\n"+
        "MOVE                |     |v7 = v0\n"+
        "RETURN_VOID         |     |return");
  }

  @Test
  public void testLiteralLiteralLiteralMulAddSum() throws ParserError, CompilerError {
    runCodeComparisonTest("1+2*3", 
        "extends com.roscopeco.deelang.runtime.dex.CompiledScript",
        "public final V run(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.dex.DexBinding)\n"+
        "                this:v8   //com.roscopeco.deelang.runtime.dex.DexCompiledScript__UUID__\n"+
        "                    :v9   //dee.lang.DeelangObject\n"+
        "                    :v10   //com.roscopeco.deelang.runtime.dex.DexBinding\n"+
        "CONST               |     |v2=0x00000001  // int:1   float:0.000000\n"+
        "NEW_INSTANCE        |     |v1=NEW Ldee/lang/DeelangInteger;\n"+
        "INVOKE_DIRECT       |     |v1.<init>(v10,v2)  //Ldee/lang/DeelangInteger;.<init>(Ldee/lang/Binding;I)V\n"+
        "CONST               |     |v2=0x00000002  // int:2   float:0.000000\n"+
        "NEW_INSTANCE        |     |v3=NEW Ldee/lang/DeelangInteger;\n"+
        "INVOKE_DIRECT       |     |v3.<init>(v10,v2)  //Ldee/lang/DeelangInteger;.<init>(Ldee/lang/Binding;I)V\n"+
        "CONST               |     |v2=0x00000003  // int:3   float:0.000000\n"+
        "NEW_INSTANCE        |     |v4=NEW Ldee/lang/DeelangInteger;\n"+
        "INVOKE_DIRECT       |     |v4.<init>(v10,v2)  //Ldee/lang/DeelangInteger;.<init>(Ldee/lang/Binding;I)V\n"+
        "INVOKE_VIRTUAL      |     |TEMP=v3.__opMUL(v4)  //Ldee/lang/DeelangObject;.__opMUL(Ldee/lang/DeelangObject;)Ldee/lang/DeelangObject;\n"+
        "MOVE_RESULT         |     |v6=TEMP\n"+
        "MOVE                |     |v0 = v6\n"+
        "CHECK_CAST          |     |v0=(dee.lang.DeelangInteger) v0\n"+
        "MOVE                |     |v5 = v0\n"+
        "INVOKE_VIRTUAL      |     |TEMP=v1.__opADD(v5)  //Ldee/lang/DeelangObject;.__opADD(Ldee/lang/DeelangObject;)Ldee/lang/DeelangObject;\n"+
        "MOVE_RESULT         |     |v6=TEMP\n"+
        "MOVE                |     |v0 = v6\n"+
        "CHECK_CAST          |     |v0=(dee.lang.DeelangInteger) v0\n"+
        "MOVE                |     |v7 = v0\n"+
        "RETURN_VOID         |     |return");
  }

  @Test
  public void testLiteralLiteralAddAsMethodArg() throws ParserError, CompilerError {
    runCodeComparisonTest("bar(3+2)",
        "extends com.roscopeco.deelang.runtime.dex.CompiledScript",
        "public final V run(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.dex.DexBinding)\n"+
        "                this:v8   //com.roscopeco.deelang.runtime.dex.DexCompiledScript__UUID__\n"+
        "                    :v9   //dee.lang.DeelangObject\n"+
        "                    :v10   //com.roscopeco.deelang.runtime.dex.DexBinding\n"+
        "MOVE                |     |v0 = v9\n"+
        "CHECK_CAST          |     |v0=(com.roscopeco.deelang.compiler.dex.CompilerFuncTestBase$Foo) v0\n"+
        "MOVE                |     |v1 = v0\n"+
        "CONST               |     |v3=0x00000003  // int:3   float:0.000000\n"+
        "NEW_INSTANCE        |     |v2=NEW Ldee/lang/DeelangInteger;\n"+
        "INVOKE_DIRECT       |     |v2.<init>(v10,v3)  //Ldee/lang/DeelangInteger;.<init>(Ldee/lang/Binding;I)V\n"+
        "CONST               |     |v3=0x00000002  // int:2   float:0.000000\n"+
        "NEW_INSTANCE        |     |v4=NEW Ldee/lang/DeelangInteger;\n"+
        "INVOKE_DIRECT       |     |v4.<init>(v10,v3)  //Ldee/lang/DeelangInteger;.<init>(Ldee/lang/Binding;I)V\n"+
        "INVOKE_VIRTUAL      |     |TEMP=v2.__opADD(v4)  //Ldee/lang/DeelangObject;.__opADD(Ldee/lang/DeelangObject;)Ldee/lang/DeelangObject;\n"+
        "MOVE_RESULT         |     |v6=TEMP\n"+
        "MOVE                |     |v0 = v6\n"+
        "CHECK_CAST          |     |v0=(dee.lang.DeelangInteger) v0\n"+
        "MOVE                |     |v5 = v0\n"+
        "INVOKE_VIRTUAL      |     |TEMP=v1.bar(v5)  //Lcom/roscopeco/deelang/compiler/dex/CompilerFuncTestBase$Foo;.bar(Ldee/lang/DeelangInteger;)Ldee/lang/DeelangInteger;\n"+
        "MOVE_RESULT         |     |v7=TEMP\n"+
        "RETURN_VOID         |     |return");
  }
  
  @Test
  public void testLiteralLiteralLiteralMulAddSumExplicitPrecedence() throws ParserError, CompilerError {
    runCodeComparisonTest("(1+2)*3",
        "extends com.roscopeco.deelang.runtime.dex.CompiledScript",
        "public final V run(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.dex.DexBinding)\n"+
        "                this:v8   //com.roscopeco.deelang.runtime.dex.DexCompiledScript__UUID__\n"+
        "                    :v9   //dee.lang.DeelangObject\n"+
        "                    :v10   //com.roscopeco.deelang.runtime.dex.DexBinding\n"+
        "CONST               |     |v2=0x00000001  // int:1   float:0.000000\n"+
        "NEW_INSTANCE        |     |v1=NEW Ldee/lang/DeelangInteger;\n"+
        "INVOKE_DIRECT       |     |v1.<init>(v10,v2)  //Ldee/lang/DeelangInteger;.<init>(Ldee/lang/Binding;I)V\n"+
        "CONST               |     |v2=0x00000002  // int:2   float:0.000000\n"+
        "NEW_INSTANCE        |     |v3=NEW Ldee/lang/DeelangInteger;\n"+
        "INVOKE_DIRECT       |     |v3.<init>(v10,v2)  //Ldee/lang/DeelangInteger;.<init>(Ldee/lang/Binding;I)V\n"+
        "INVOKE_VIRTUAL      |     |TEMP=v1.__opADD(v3)  //Ldee/lang/DeelangObject;.__opADD(Ldee/lang/DeelangObject;)Ldee/lang/DeelangObject;\n"+
        "MOVE_RESULT         |     |v5=TEMP\n"+
        "MOVE                |     |v0 = v5\n"+
        "CHECK_CAST          |     |v0=(dee.lang.DeelangInteger) v0\n"+
        "MOVE                |     |v4 = v0\n"+
        "CONST               |     |v2=0x00000003  // int:3   float:0.000000\n"+
        "NEW_INSTANCE        |     |v6=NEW Ldee/lang/DeelangInteger;\n"+
        "INVOKE_DIRECT       |     |v6.<init>(v10,v2)  //Ldee/lang/DeelangInteger;.<init>(Ldee/lang/Binding;I)V\n"+
        "INVOKE_VIRTUAL      |     |TEMP=v4.__opMUL(v6)  //Ldee/lang/DeelangObject;.__opMUL(Ldee/lang/DeelangObject;)Ldee/lang/DeelangObject;\n"+
        "MOVE_RESULT         |     |v5=TEMP\n"+
        "MOVE                |     |v0 = v5\n"+
        "CHECK_CAST          |     |v0=(dee.lang.DeelangInteger) v0\n"+
        "MOVE                |     |v7 = v0\n"+
        "RETURN_VOID         |     |return");
  }
  
  public void doChainedSumTest(String op, String opMethod) throws ParserError, CompilerError {
    runCodeComparisonTest("1" + op + "boo().bar.boo2().a",
        "extends com.roscopeco.deelang.runtime.dex.CompiledScript",
        "public final V run(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.dex.DexBinding)\n"+
        "                this:v7   //com.roscopeco.deelang.runtime.dex.DexCompiledScript__UUID__\n"+
"                    :v8   //dee.lang.DeelangObject\n"+
"                    :v9   //com.roscopeco.deelang.runtime.dex.DexBinding\n"+
"CONST               |     |v2=0x00000001  // int:1   float:0.000000\n"+
"NEW_INSTANCE        |     |v1=NEW Ldee/lang/DeelangInteger;\n"+
"INVOKE_DIRECT       |     |v1.<init>(v9,v2)  //Ldee/lang/DeelangInteger;.<init>(Ldee/lang/Binding;I)V\n"+
"MOVE                |     |v0 = v8\n"+
"CHECK_CAST          |     |v0=(com.roscopeco.deelang.compiler.dex.CompilerFuncTestBase$Foo) v0\n"+
"MOVE                |     |v3 = v0\n"+
"INVOKE_VIRTUAL      |     |TEMP=v3.boo()  //Lcom/roscopeco/deelang/compiler/dex/CompilerFuncTestBase$Foo;.boo()Lcom/roscopeco/deelang/compiler/dex/CompilerFuncTestBase$Foo;\n"+
"MOVE_RESULT         |     |v4=TEMP\n"+
"IGET                |     |v4=v4.bar  //Lcom/roscopeco/deelang/compiler/dex/CompilerFuncTestBase$Foo;.bar Lcom/roscopeco/deelang/compiler/dex/CompilerFuncTestBase$Foo;\n"+
"INVOKE_VIRTUAL      |     |TEMP=v4.boo2()  //Lcom/roscopeco/deelang/compiler/dex/CompilerFuncTestBase$Foo;.boo2()Lcom/roscopeco/deelang/compiler/dex/CompilerFuncTestBase$Foo;\n"+
"MOVE_RESULT         |     |v4=TEMP\n"+
"IGET                |     |v5=v4.a  //Lcom/roscopeco/deelang/compiler/dex/CompilerFuncTestBase$Foo;.a Ldee/lang/DeelangInteger;\n"+
"INVOKE_VIRTUAL      |     |TEMP=v1." + opMethod + "(v5)  //Ldee/lang/DeelangObject;." + opMethod + "(Ldee/lang/DeelangObject;)Ldee/lang/DeelangObject;\n"+
"MOVE_RESULT         |     |v6=TEMP\n"+
"MOVE                |     |v0 = v6\n"+
"CHECK_CAST          |     |v0=(dee.lang.DeelangInteger) v0\n"+
"MOVE                |     |v5 = v0\n"+
"RETURN_VOID         |     |return");
  }
  
  @Test
  public void REGRESSIONaddWithChainedField() throws ParserError, CompilerError {
    doChainedSumTest("+", "__opADD");
  }
  
  @Test
  public void REGRESSIONsubWithChainedField() throws ParserError, CompilerError {
    doChainedSumTest("-", "__opSUB");
  }
  
  @Test
  public void REGRESSIONmulWithChainedField() throws ParserError, CompilerError {
    doChainedSumTest("*", "__opMUL");
  }
  
  @Test
  public void REGRESSIONdivWithChainedField() throws ParserError, CompilerError {
    doChainedSumTest("/", "__opDIV");
  }
  
  @Test
  public void REGRESSIONmodWithChainedField() throws ParserError, CompilerError {
    doChainedSumTest("%", "__opMOD");
  }
  
  @Test
  public void REGRESSIONpowWithChainedField() throws ParserError, CompilerError {
    doChainedSumTest("^", "__opPOW");
  }
  
  @Test
  public void REGRESSIONassignArithmeticResultLocal() throws ParserError, CompilerError {
    // TODO this case is wasteful with registers, generating a *lot* of unnecessary moves...
    runCodeComparisonTest("a = 1+2", 
        "extends com.roscopeco.deelang.runtime.dex.CompiledScript",
        "public final V run(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.dex.DexBinding)\n"+
        "                this:v7   //com.roscopeco.deelang.runtime.dex.DexCompiledScript__UUID__\n"+
        "                    :v8   //dee.lang.DeelangObject\n"+
        "                    :v9   //com.roscopeco.deelang.runtime.dex.DexBinding\n"+
        "CONST               |     |v2=0x00000001  // int:1   float:0.000000\n"+
        "NEW_INSTANCE        |     |v1=NEW Ldee/lang/DeelangInteger;\n"+
        "INVOKE_DIRECT       |     |v1.<init>(v9,v2)  //Ldee/lang/DeelangInteger;.<init>(Ldee/lang/Binding;I)V\n"+
        "CONST               |     |v2=0x00000002  // int:2   float:0.000000\n"+
        "NEW_INSTANCE        |     |v3=NEW Ldee/lang/DeelangInteger;\n"+
        "INVOKE_DIRECT       |     |v3.<init>(v9,v2)  //Ldee/lang/DeelangInteger;.<init>(Ldee/lang/Binding;I)V\n"+
        "INVOKE_VIRTUAL      |     |TEMP=v1.__opADD(v3)  //Ldee/lang/DeelangObject;.__opADD(Ldee/lang/DeelangObject;)Ldee/lang/DeelangObject;\n"+
        "MOVE_RESULT         |     |v5=TEMP\n"+
        "MOVE                |     |v0 = v5\n"+
        "CHECK_CAST          |     |v0=(dee.lang.DeelangInteger) v0\n"+
        "MOVE                |     |v4 = v0\n"+
        "MOVE                |     |v6 = v4\n"+
        "RETURN_VOID         |     |return");
  }

  /* TODO More tests (e.g. vars/methods in arithmetic) */
}
