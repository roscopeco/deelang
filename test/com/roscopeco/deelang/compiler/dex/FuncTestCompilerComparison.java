package com.roscopeco.deelang.compiler.dex;

import org.junit.Test;

import com.roscopeco.deelang.compiler.CompilerError;
import com.roscopeco.deelang.parser.ParserError;

public class FuncTestCompilerComparison extends CompilerFuncTestBase {
  private void runComparison(String sumCode, String expMethod) throws ParserError, CompilerError {
    runCodeComparisonTest(sumCode, 
        "extends com.roscopeco.deelang.runtime.dex.CompiledScript",
        "public final V run(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.dex.DexBinding)\n"+
        "                this:v3   //com.roscopeco.deelang.runtime.dex.DexCompiledScript__UUID__\n"+
        "                    :v4   //dee.lang.DeelangObject\n"+
        "                    :v5   //com.roscopeco.deelang.runtime.dex.DexBinding\n"+
        "CONST               |     |v1=0x00000001  // int:1   float:0.000000\n"+
        "NEW_INSTANCE        |     |v0=NEW Ldee/lang/DeelangInteger;\n"+
        "INVOKE_DIRECT       |     |v0.<init>(v5,v1)  //Ldee/lang/DeelangInteger;.<init>(Ldee/lang/Binding;I)V\n"+
        "CONST               |     |v1=0x00000002  // int:2   float:0.000000\n"+
        "NEW_INSTANCE        |     |v2=NEW Ldee/lang/DeelangInteger;\n"+
        "INVOKE_DIRECT       |     |v2.<init>(v5,v1)  //Ldee/lang/DeelangInteger;.<init>(Ldee/lang/Binding;I)V\n"+
        "INVOKE_VIRTUAL      |     |TEMP=v0."+expMethod+"(v2)  //Ldee/lang/DeelangObject;."+expMethod+"(Ldee/lang/DeelangObject;)Ldee/lang/DeelangBoolean;\n"+
        "RETURN_VOID         |     |return");
  }

  @Test
  public void testLiteralLiteralLt() throws ParserError, CompilerError {
    runComparison("1<2", "__opLT");
  }
  
  @Test
  public void testLiteralLiteralGt() throws ParserError, CompilerError {
    runComparison("1>2", "__opGT");
  }
  
  @Test
  public void testLiteralLiteralEql() throws ParserError, CompilerError {
    runComparison("1==2", "__opEQL");
  }
  
  @Test
  public void testLiteralLiteralNeq() throws ParserError, CompilerError {
    runComparison("1!=2", "__opNEQ");
  }

  @Test
  public void testLiteralLiteralEqlAssignment() throws ParserError, CompilerError {
    // TODO this could be more efficient with registers....
    runCodeComparisonTest("a = 1==2", 
        "extends com.roscopeco.deelang.runtime.dex.CompiledScript",
        "public final V run(dee.lang.DeelangObject,com.roscopeco.deelang.runtime.dex.DexBinding)\n"+
        "                this:v5   //com.roscopeco.deelang.runtime.dex.DexCompiledScript__UUID__\n"+
        "                    :v6   //dee.lang.DeelangObject\n"+
        "                    :v7   //com.roscopeco.deelang.runtime.dex.DexBinding\n"+
        "CONST               |     |v1=0x00000001  // int:1   float:0.000000\n"+
        "NEW_INSTANCE        |     |v0=NEW Ldee/lang/DeelangInteger;\n"+
        "INVOKE_DIRECT       |     |v0.<init>(v7,v1)  //Ldee/lang/DeelangInteger;.<init>(Ldee/lang/Binding;I)V\n"+
        "CONST               |     |v1=0x00000002  // int:2   float:0.000000\n"+
        "NEW_INSTANCE        |     |v2=NEW Ldee/lang/DeelangInteger;\n"+
        "INVOKE_DIRECT       |     |v2.<init>(v7,v1)  //Ldee/lang/DeelangInteger;.<init>(Ldee/lang/Binding;I)V\n"+
        "INVOKE_VIRTUAL      |     |TEMP=v0.__opEQL(v2)  //Ldee/lang/DeelangObject;.__opEQL(Ldee/lang/DeelangObject;)Ldee/lang/DeelangBoolean;\n"+
        "MOVE_RESULT         |     |v3=TEMP\n"+
        "MOVE                |     |v4 = v3\n"+
        "RETURN_VOID         |     |return");
  }
  
}
