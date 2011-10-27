// $ANTLR 3.4 C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g 2011-10-27 23:15:10

  package com.roscopeco.deelang.parser;

  /* ******** GENERATED FILE - DO NOT EDIT! ********* */
	/* Copyright 2011 Ross Bamford (roscopeco AT gmail DOT com)
	 *
	 *  Licensed under the Apache License, Version 2.0 (the "License");
	 *  you may not use this file except in compliance with the License.
	 *  You may obtain a copy of the License at
	 *
	 *      http://www.apache.org/licenses/LICENSE-2.0
	 *
	 *  Unless required by applicable law or agreed to in writing, software
	 *  distributed under the License is distributed on an "AS IS" BASIS,
	 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	 *  See the License for the specific language governing permissions and
	 *  limitations under the License. 
	 */
  
  import org.antlr.runtime.Parser;  


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;


@SuppressWarnings({"all", "warnings", "unchecked"})
public class DeeLangParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ADD", "ARGS", "ASSIGN", "ASSIGN_LOCAL", "ASSIGN_RECEIVER", "BLOCK", "CHAIN", "CHARACTER_LITERAL", "COMMA", "COMMENT", "DECIMAL_LITERAL", "DIV", "DOT", "EscapeSequence", "Exponent", "FIELD_ACCESS", "FLOATING_POINT_LITERAL", "FloatTypeSuffix", "HEX_LITERAL", "HexDigit", "IDENTIFIER", "ID_LETTER", "IntegerTypeSuffix", "LCURLY", "LINE_COMMENT", "LPAREN", "LVALUE", "METHOD_CALL", "MOD", "MUL", "NOT", "OCTAL_LITERAL", "OR", "ORBLOCK", "OctalEscape", "POW", "RCURLY", "RPAREN", "SELF", "STRING_LITERAL", "SUB", "TERMINATOR", "UnicodeEscape", "WS"
    };

    public static final int EOF=-1;
    public static final int ADD=4;
    public static final int ARGS=5;
    public static final int ASSIGN=6;
    public static final int ASSIGN_LOCAL=7;
    public static final int ASSIGN_RECEIVER=8;
    public static final int BLOCK=9;
    public static final int CHAIN=10;
    public static final int CHARACTER_LITERAL=11;
    public static final int COMMA=12;
    public static final int COMMENT=13;
    public static final int DECIMAL_LITERAL=14;
    public static final int DIV=15;
    public static final int DOT=16;
    public static final int EscapeSequence=17;
    public static final int Exponent=18;
    public static final int FIELD_ACCESS=19;
    public static final int FLOATING_POINT_LITERAL=20;
    public static final int FloatTypeSuffix=21;
    public static final int HEX_LITERAL=22;
    public static final int HexDigit=23;
    public static final int IDENTIFIER=24;
    public static final int ID_LETTER=25;
    public static final int IntegerTypeSuffix=26;
    public static final int LCURLY=27;
    public static final int LINE_COMMENT=28;
    public static final int LPAREN=29;
    public static final int LVALUE=30;
    public static final int METHOD_CALL=31;
    public static final int MOD=32;
    public static final int MUL=33;
    public static final int NOT=34;
    public static final int OCTAL_LITERAL=35;
    public static final int OR=36;
    public static final int ORBLOCK=37;
    public static final int OctalEscape=38;
    public static final int POW=39;
    public static final int RCURLY=40;
    public static final int RPAREN=41;
    public static final int SELF=42;
    public static final int STRING_LITERAL=43;
    public static final int SUB=44;
    public static final int TERMINATOR=45;
    public static final int UnicodeEscape=46;
    public static final int WS=47;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public DeeLangParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public DeeLangParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
        this.state.ruleMemo = new HashMap[58+1];
         

    }

protected TreeAdaptor adaptor = new CommonTreeAdaptor();

public void setTreeAdaptor(TreeAdaptor adaptor) {
    this.adaptor = adaptor;
}
public TreeAdaptor getTreeAdaptor() {
    return adaptor;
}
    public String[] getTokenNames() { return DeeLangParser.tokenNames; }
    public String getGrammarFileName() { return "C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g"; }


      /* throw exceptions rather than silently failing... */
    	protected void mismatch(IntStream input, int ttype, BitSet follow)
    	  throws RecognitionException
    	{
    	  throw new MismatchedTokenException(ttype, input);
    	}

    	@Override
    	public Object recoverFromMismatchedSet(IntStream input, RecognitionException e, BitSet follow)
    	  throws RecognitionException
    	{
    	  throw e;
    	}
    	
    	@Override 
    	protected Object recoverFromMismatchedToken(IntStream input, int 
    	ttype, BitSet follow) throws RecognitionException { 
    	    if (ttype == RPAREN) { 
    	        throw new UnwantedTokenException(); // ("Invalid input in argument list"); 
    	    } 
    	    return super.recoverFromMismatchedToken(input, ttype, follow); 
    	} 



    public static class start_rule_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "start_rule"
    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:116:1: start_rule : script ;
    public final DeeLangParser.start_rule_return start_rule() throws RecognitionException {
        DeeLangParser.start_rule_return retval = new DeeLangParser.start_rule_return();
        retval.start = input.LT(1);

        int start_rule_StartIndex = input.index();

        CommonTree root_0 = null;

        DeeLangParser.script_return script1 =null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return retval; }

            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:117:3: ( script )
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:117:7: script
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_script_in_start_rule157);
            script1=script();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, script1.getTree());

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        	// throw exceptions rather than silently failing...
        	catch (RecognitionException e) {
        	  throw e;
        	}

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 1, start_rule_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "start_rule"


    public static class script_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "script"
    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:120:1: script : ( ( statement )+ | EOF !);
    public final DeeLangParser.script_return script() throws RecognitionException {
        DeeLangParser.script_return retval = new DeeLangParser.script_return();
        retval.start = input.LT(1);

        int script_StartIndex = input.index();

        CommonTree root_0 = null;

        Token EOF3=null;
        DeeLangParser.statement_return statement2 =null;


        CommonTree EOF3_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return retval; }

            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:121:3: ( ( statement )+ | EOF !)
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==CHARACTER_LITERAL||LA2_0==DECIMAL_LITERAL||LA2_0==FLOATING_POINT_LITERAL||LA2_0==HEX_LITERAL||LA2_0==IDENTIFIER||LA2_0==LPAREN||(LA2_0 >= NOT && LA2_0 <= OCTAL_LITERAL)||LA2_0==STRING_LITERAL) ) {
                alt2=1;
            }
            else if ( (LA2_0==EOF) ) {
                alt2=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }
            switch (alt2) {
                case 1 :
                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:121:7: ( statement )+
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:121:7: ( statement )+
                    int cnt1=0;
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==CHARACTER_LITERAL||LA1_0==DECIMAL_LITERAL||LA1_0==FLOATING_POINT_LITERAL||LA1_0==HEX_LITERAL||LA1_0==IDENTIFIER||LA1_0==LPAREN||(LA1_0 >= NOT && LA1_0 <= OCTAL_LITERAL)||LA1_0==STRING_LITERAL) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:121:7: statement
                    	    {
                    	    pushFollow(FOLLOW_statement_in_script172);
                    	    statement2=statement();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement2.getTree());

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt1 >= 1 ) break loop1;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(1, input);
                                throw eee;
                        }
                        cnt1++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:122:7: EOF !
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    EOF3=(Token)match(input,EOF,FOLLOW_EOF_in_script181); if (state.failed) return retval;

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        	// throw exceptions rather than silently failing...
        	catch (RecognitionException e) {
        	  throw e;
        	}

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 2, script_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "script"


    public static class statement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "statement"
    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:125:1: statement : expr terminator !;
    public final DeeLangParser.statement_return statement() throws RecognitionException {
        DeeLangParser.statement_return retval = new DeeLangParser.statement_return();
        retval.start = input.LT(1);

        int statement_StartIndex = input.index();

        CommonTree root_0 = null;

        DeeLangParser.expr_return expr4 =null;

        DeeLangParser.terminator_return terminator5 =null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return retval; }

            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:126:3: ( expr terminator !)
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:126:7: expr terminator !
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_expr_in_statement197);
            expr4=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expr4.getTree());

            pushFollow(FOLLOW_terminator_in_statement199);
            terminator5=terminator();

            state._fsp--;
            if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        	// throw exceptions rather than silently failing...
        	catch (RecognitionException e) {
        	  throw e;
        	}

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 3, statement_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "statement"


    public static class block_statement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "block_statement"
    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:129:1: block_statement : expr ;
    public final DeeLangParser.block_statement_return block_statement() throws RecognitionException {
        DeeLangParser.block_statement_return retval = new DeeLangParser.block_statement_return();
        retval.start = input.LT(1);

        int block_statement_StartIndex = input.index();

        CommonTree root_0 = null;

        DeeLangParser.expr_return expr6 =null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return retval; }

            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:130:3: ( expr )
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:130:7: expr
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_expr_in_block_statement217);
            expr6=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expr6.getTree());

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        	// throw exceptions rather than silently failing...
        	catch (RecognitionException e) {
        	  throw e;
        	}

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 4, block_statement_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "block_statement"


    public static class expr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "expr"
    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:133:1: expr : ( assign_expr | math_expr );
    public final DeeLangParser.expr_return expr() throws RecognitionException {
        DeeLangParser.expr_return retval = new DeeLangParser.expr_return();
        retval.start = input.LT(1);

        int expr_StartIndex = input.index();

        CommonTree root_0 = null;

        DeeLangParser.assign_expr_return assign_expr7 =null;

        DeeLangParser.math_expr_return math_expr8 =null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return retval; }

            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:134:3: ( assign_expr | math_expr )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==IDENTIFIER) ) {
                switch ( input.LA(2) ) {
                case DOT:
                    {
                    int LA3_3 = input.LA(3);

                    if ( (LA3_3==IDENTIFIER) ) {
                        int LA3_5 = input.LA(4);

                        if ( (LA3_5==ASSIGN) ) {
                            alt3=1;
                        }
                        else if ( (LA3_5==EOF||LA3_5==ADD||LA3_5==COMMA||(LA3_5 >= DIV && LA3_5 <= DOT)||LA3_5==LPAREN||(LA3_5 >= MOD && LA3_5 <= MUL)||(LA3_5 >= POW && LA3_5 <= RPAREN)||(LA3_5 >= SUB && LA3_5 <= TERMINATOR)) ) {
                            alt3=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 3, 5, input);

                            throw nvae;

                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 3, 3, input);

                        throw nvae;

                    }
                    }
                    break;
                case ASSIGN:
                    {
                    alt3=1;
                    }
                    break;
                case EOF:
                case ADD:
                case COMMA:
                case DIV:
                case LPAREN:
                case MOD:
                case MUL:
                case POW:
                case RCURLY:
                case RPAREN:
                case SUB:
                case TERMINATOR:
                    {
                    alt3=2;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 1, input);

                    throw nvae;

                }

            }
            else if ( (LA3_0==CHARACTER_LITERAL||LA3_0==DECIMAL_LITERAL||LA3_0==FLOATING_POINT_LITERAL||LA3_0==HEX_LITERAL||LA3_0==LPAREN||(LA3_0 >= NOT && LA3_0 <= OCTAL_LITERAL)||LA3_0==STRING_LITERAL) ) {
                alt3=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;

            }
            switch (alt3) {
                case 1 :
                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:134:7: assign_expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_assign_expr_in_expr236);
                    assign_expr7=assign_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, assign_expr7.getTree());

                    }
                    break;
                case 2 :
                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:135:7: math_expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_math_expr_in_expr244);
                    math_expr8=math_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, math_expr8.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        	// throw exceptions rather than silently failing...
        	catch (RecognitionException e) {
        	  throw e;
        	}

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 5, expr_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "expr"


    public static class assign_expr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "assign_expr"
    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:138:1: assign_expr : (rec= IDENTIFIER DOT )? id= IDENTIFIER ASSIGN expr -> {explicitReceiver}? ^( ASSIGN ASSIGN_RECEIVER[$rec.getText()] LVALUE[$id.getText()] expr ) -> ^( ASSIGN ASSIGN_LOCAL LVALUE[$id.getText()] expr ) ;
    public final DeeLangParser.assign_expr_return assign_expr() throws RecognitionException {
        DeeLangParser.assign_expr_return retval = new DeeLangParser.assign_expr_return();
        retval.start = input.LT(1);

        int assign_expr_StartIndex = input.index();

        CommonTree root_0 = null;

        Token rec=null;
        Token id=null;
        Token DOT9=null;
        Token ASSIGN10=null;
        DeeLangParser.expr_return expr11 =null;


        CommonTree rec_tree=null;
        CommonTree id_tree=null;
        CommonTree DOT9_tree=null;
        CommonTree ASSIGN10_tree=null;
        RewriteRuleTokenStream stream_DOT=new RewriteRuleTokenStream(adaptor,"token DOT");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");
        RewriteRuleTokenStream stream_ASSIGN=new RewriteRuleTokenStream(adaptor,"token ASSIGN");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        boolean explicitReceiver=false;
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return retval; }

            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:140:3: ( (rec= IDENTIFIER DOT )? id= IDENTIFIER ASSIGN expr -> {explicitReceiver}? ^( ASSIGN ASSIGN_RECEIVER[$rec.getText()] LVALUE[$id.getText()] expr ) -> ^( ASSIGN ASSIGN_LOCAL LVALUE[$id.getText()] expr ) )
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:140:7: (rec= IDENTIFIER DOT )? id= IDENTIFIER ASSIGN expr
            {
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:140:7: (rec= IDENTIFIER DOT )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==IDENTIFIER) ) {
                int LA4_1 = input.LA(2);

                if ( (LA4_1==DOT) ) {
                    alt4=1;
                }
            }
            switch (alt4) {
                case 1 :
                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:140:8: rec= IDENTIFIER DOT
                    {
                    rec=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_assign_expr269); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENTIFIER.add(rec);


                    DOT9=(Token)match(input,DOT,FOLLOW_DOT_in_assign_expr271); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DOT.add(DOT9);


                    if ( state.backtracking==0 ) {explicitReceiver=true;}

                    }
                    break;

            }


            id=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_assign_expr279); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENTIFIER.add(id);


            ASSIGN10=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_assign_expr281); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ASSIGN.add(ASSIGN10);


            pushFollow(FOLLOW_expr_in_assign_expr283);
            expr11=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_expr.add(expr11.getTree());

            // AST REWRITE
            // elements: expr, ASSIGN, expr, ASSIGN
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 140:80: -> {explicitReceiver}? ^( ASSIGN ASSIGN_RECEIVER[$rec.getText()] LVALUE[$id.getText()] expr )
            if (explicitReceiver) {
                // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:140:103: ^( ASSIGN ASSIGN_RECEIVER[$rec.getText()] LVALUE[$id.getText()] expr )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                stream_ASSIGN.nextNode()
                , root_1);

                adaptor.addChild(root_1, 
                (CommonTree)adaptor.create(ASSIGN_RECEIVER, rec.getText())
                );

                adaptor.addChild(root_1, 
                (CommonTree)adaptor.create(LVALUE, id.getText())
                );

                adaptor.addChild(root_1, stream_expr.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            else // 140:172: -> ^( ASSIGN ASSIGN_LOCAL LVALUE[$id.getText()] expr )
            {
                // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:140:175: ^( ASSIGN ASSIGN_LOCAL LVALUE[$id.getText()] expr )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                stream_ASSIGN.nextNode()
                , root_1);

                adaptor.addChild(root_1, 
                (CommonTree)adaptor.create(ASSIGN_LOCAL, "ASSIGN_LOCAL")
                );

                adaptor.addChild(root_1, 
                (CommonTree)adaptor.create(LVALUE, id.getText())
                );

                adaptor.addChild(root_1, stream_expr.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        	// throw exceptions rather than silently failing...
        	catch (RecognitionException e) {
        	  throw e;
        	}

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 6, assign_expr_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "assign_expr"


    public static class math_expr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "math_expr"
    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:143:1: math_expr : mult_expr ( ( ADD ^| SUB ^) mult_expr )* ;
    public final DeeLangParser.math_expr_return math_expr() throws RecognitionException {
        DeeLangParser.math_expr_return retval = new DeeLangParser.math_expr_return();
        retval.start = input.LT(1);

        int math_expr_StartIndex = input.index();

        CommonTree root_0 = null;

        Token ADD13=null;
        Token SUB14=null;
        DeeLangParser.mult_expr_return mult_expr12 =null;

        DeeLangParser.mult_expr_return mult_expr15 =null;


        CommonTree ADD13_tree=null;
        CommonTree SUB14_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return retval; }

            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:144:3: ( mult_expr ( ( ADD ^| SUB ^) mult_expr )* )
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:144:7: mult_expr ( ( ADD ^| SUB ^) mult_expr )*
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_mult_expr_in_math_expr327);
            mult_expr12=mult_expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, mult_expr12.getTree());

            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:144:17: ( ( ADD ^| SUB ^) mult_expr )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==ADD||LA6_0==SUB) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:144:18: ( ADD ^| SUB ^) mult_expr
            	    {
            	    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:144:18: ( ADD ^| SUB ^)
            	    int alt5=2;
            	    int LA5_0 = input.LA(1);

            	    if ( (LA5_0==ADD) ) {
            	        alt5=1;
            	    }
            	    else if ( (LA5_0==SUB) ) {
            	        alt5=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 5, 0, input);

            	        throw nvae;

            	    }
            	    switch (alt5) {
            	        case 1 :
            	            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:144:19: ADD ^
            	            {
            	            ADD13=(Token)match(input,ADD,FOLLOW_ADD_in_math_expr331); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            ADD13_tree = 
            	            (CommonTree)adaptor.create(ADD13)
            	            ;
            	            root_0 = (CommonTree)adaptor.becomeRoot(ADD13_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:144:24: SUB ^
            	            {
            	            SUB14=(Token)match(input,SUB,FOLLOW_SUB_in_math_expr334); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            SUB14_tree = 
            	            (CommonTree)adaptor.create(SUB14)
            	            ;
            	            root_0 = (CommonTree)adaptor.becomeRoot(SUB14_tree, root_0);
            	            }

            	            }
            	            break;

            	    }


            	    pushFollow(FOLLOW_mult_expr_in_math_expr338);
            	    mult_expr15=mult_expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, mult_expr15.getTree());

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        	// throw exceptions rather than silently failing...
        	catch (RecognitionException e) {
        	  throw e;
        	}

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 7, math_expr_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "math_expr"


    public static class mult_expr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "mult_expr"
    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:147:1: mult_expr : pow_expr ( ( MUL ^| DIV ^| MOD ^) pow_expr )* ;
    public final DeeLangParser.mult_expr_return mult_expr() throws RecognitionException {
        DeeLangParser.mult_expr_return retval = new DeeLangParser.mult_expr_return();
        retval.start = input.LT(1);

        int mult_expr_StartIndex = input.index();

        CommonTree root_0 = null;

        Token MUL17=null;
        Token DIV18=null;
        Token MOD19=null;
        DeeLangParser.pow_expr_return pow_expr16 =null;

        DeeLangParser.pow_expr_return pow_expr20 =null;


        CommonTree MUL17_tree=null;
        CommonTree DIV18_tree=null;
        CommonTree MOD19_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return retval; }

            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:148:3: ( pow_expr ( ( MUL ^| DIV ^| MOD ^) pow_expr )* )
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:148:7: pow_expr ( ( MUL ^| DIV ^| MOD ^) pow_expr )*
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_pow_expr_in_mult_expr356);
            pow_expr16=pow_expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, pow_expr16.getTree());

            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:148:16: ( ( MUL ^| DIV ^| MOD ^) pow_expr )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==DIV||(LA8_0 >= MOD && LA8_0 <= MUL)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:148:17: ( MUL ^| DIV ^| MOD ^) pow_expr
            	    {
            	    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:148:17: ( MUL ^| DIV ^| MOD ^)
            	    int alt7=3;
            	    switch ( input.LA(1) ) {
            	    case MUL:
            	        {
            	        alt7=1;
            	        }
            	        break;
            	    case DIV:
            	        {
            	        alt7=2;
            	        }
            	        break;
            	    case MOD:
            	        {
            	        alt7=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 7, 0, input);

            	        throw nvae;

            	    }

            	    switch (alt7) {
            	        case 1 :
            	            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:148:18: MUL ^
            	            {
            	            MUL17=(Token)match(input,MUL,FOLLOW_MUL_in_mult_expr360); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            MUL17_tree = 
            	            (CommonTree)adaptor.create(MUL17)
            	            ;
            	            root_0 = (CommonTree)adaptor.becomeRoot(MUL17_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:148:23: DIV ^
            	            {
            	            DIV18=(Token)match(input,DIV,FOLLOW_DIV_in_mult_expr363); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            DIV18_tree = 
            	            (CommonTree)adaptor.create(DIV18)
            	            ;
            	            root_0 = (CommonTree)adaptor.becomeRoot(DIV18_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:148:28: MOD ^
            	            {
            	            MOD19=(Token)match(input,MOD,FOLLOW_MOD_in_mult_expr366); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            MOD19_tree = 
            	            (CommonTree)adaptor.create(MOD19)
            	            ;
            	            root_0 = (CommonTree)adaptor.becomeRoot(MOD19_tree, root_0);
            	            }

            	            }
            	            break;

            	    }


            	    pushFollow(FOLLOW_pow_expr_in_mult_expr370);
            	    pow_expr20=pow_expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, pow_expr20.getTree());

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        	// throw exceptions rather than silently failing...
        	catch (RecognitionException e) {
        	  throw e;
        	}

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 8, mult_expr_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "mult_expr"


    public static class pow_expr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "pow_expr"
    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:151:1: pow_expr : unary_expr ( ( POW ^) unary_expr )* ;
    public final DeeLangParser.pow_expr_return pow_expr() throws RecognitionException {
        DeeLangParser.pow_expr_return retval = new DeeLangParser.pow_expr_return();
        retval.start = input.LT(1);

        int pow_expr_StartIndex = input.index();

        CommonTree root_0 = null;

        Token POW22=null;
        DeeLangParser.unary_expr_return unary_expr21 =null;

        DeeLangParser.unary_expr_return unary_expr23 =null;


        CommonTree POW22_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return retval; }

            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:152:3: ( unary_expr ( ( POW ^) unary_expr )* )
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:152:7: unary_expr ( ( POW ^) unary_expr )*
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_unary_expr_in_pow_expr392);
            unary_expr21=unary_expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, unary_expr21.getTree());

            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:152:18: ( ( POW ^) unary_expr )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==POW) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:152:19: ( POW ^) unary_expr
            	    {
            	    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:152:19: ( POW ^)
            	    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:152:20: POW ^
            	    {
            	    POW22=(Token)match(input,POW,FOLLOW_POW_in_pow_expr396); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    POW22_tree = 
            	    (CommonTree)adaptor.create(POW22)
            	    ;
            	    root_0 = (CommonTree)adaptor.becomeRoot(POW22_tree, root_0);
            	    }

            	    }


            	    pushFollow(FOLLOW_unary_expr_in_pow_expr400);
            	    unary_expr23=unary_expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, unary_expr23.getTree());

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        	// throw exceptions rather than silently failing...
        	catch (RecognitionException e) {
        	  throw e;
        	}

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 9, pow_expr_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "pow_expr"


    public static class unary_expr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "unary_expr"
    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:155:1: unary_expr : ( NOT )? atom ;
    public final DeeLangParser.unary_expr_return unary_expr() throws RecognitionException {
        DeeLangParser.unary_expr_return retval = new DeeLangParser.unary_expr_return();
        retval.start = input.LT(1);

        int unary_expr_StartIndex = input.index();

        CommonTree root_0 = null;

        Token NOT24=null;
        DeeLangParser.atom_return atom25 =null;


        CommonTree NOT24_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return retval; }

            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:156:3: ( ( NOT )? atom )
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:156:7: ( NOT )? atom
            {
            root_0 = (CommonTree)adaptor.nil();


            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:156:7: ( NOT )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==NOT) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:156:7: NOT
                    {
                    NOT24=(Token)match(input,NOT,FOLLOW_NOT_in_unary_expr419); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NOT24_tree = 
                    (CommonTree)adaptor.create(NOT24)
                    ;
                    adaptor.addChild(root_0, NOT24_tree);
                    }

                    }
                    break;

            }


            pushFollow(FOLLOW_atom_in_unary_expr422);
            atom25=atom();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, atom25.getTree());

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        	// throw exceptions rather than silently failing...
        	catch (RecognitionException e) {
        	  throw e;
        	}

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 10, unary_expr_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "unary_expr"


    public static class meth_call_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "meth_call"
    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:159:1: meth_call : ( ( IDENTIFIER DOT )? func_call_expr -> {explicitReceiver}? ^( METHOD_CALL IDENTIFIER func_call_expr ) -> ^( METHOD_CALL SELF func_call_expr ) | literal DOT func_call_expr -> ^( METHOD_CALL literal func_call_expr ) );
    public final DeeLangParser.meth_call_return meth_call() throws RecognitionException {
        DeeLangParser.meth_call_return retval = new DeeLangParser.meth_call_return();
        retval.start = input.LT(1);

        int meth_call_StartIndex = input.index();

        CommonTree root_0 = null;

        Token IDENTIFIER26=null;
        Token DOT27=null;
        Token DOT30=null;
        DeeLangParser.func_call_expr_return func_call_expr28 =null;

        DeeLangParser.literal_return literal29 =null;

        DeeLangParser.func_call_expr_return func_call_expr31 =null;


        CommonTree IDENTIFIER26_tree=null;
        CommonTree DOT27_tree=null;
        CommonTree DOT30_tree=null;
        RewriteRuleTokenStream stream_DOT=new RewriteRuleTokenStream(adaptor,"token DOT");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");
        RewriteRuleSubtreeStream stream_func_call_expr=new RewriteRuleSubtreeStream(adaptor,"rule func_call_expr");
        RewriteRuleSubtreeStream stream_literal=new RewriteRuleSubtreeStream(adaptor,"rule literal");
        boolean explicitReceiver=false;
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return retval; }

            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:161:3: ( ( IDENTIFIER DOT )? func_call_expr -> {explicitReceiver}? ^( METHOD_CALL IDENTIFIER func_call_expr ) -> ^( METHOD_CALL SELF func_call_expr ) | literal DOT func_call_expr -> ^( METHOD_CALL literal func_call_expr ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==IDENTIFIER) ) {
                alt12=1;
            }
            else if ( (LA12_0==CHARACTER_LITERAL||LA12_0==DECIMAL_LITERAL||LA12_0==FLOATING_POINT_LITERAL||LA12_0==HEX_LITERAL||LA12_0==OCTAL_LITERAL||LA12_0==STRING_LITERAL) ) {
                alt12=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;

            }
            switch (alt12) {
                case 1 :
                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:161:7: ( IDENTIFIER DOT )? func_call_expr
                    {
                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:161:7: ( IDENTIFIER DOT )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==IDENTIFIER) ) {
                        int LA11_1 = input.LA(2);

                        if ( (LA11_1==DOT) ) {
                            alt11=1;
                        }
                    }
                    switch (alt11) {
                        case 1 :
                            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:161:8: IDENTIFIER DOT
                            {
                            IDENTIFIER26=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_meth_call443); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_IDENTIFIER.add(IDENTIFIER26);


                            DOT27=(Token)match(input,DOT,FOLLOW_DOT_in_meth_call445); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_DOT.add(DOT27);


                            if ( state.backtracking==0 ) {explicitReceiver=true;}

                            }
                            break;

                    }


                    pushFollow(FOLLOW_func_call_expr_in_meth_call451);
                    func_call_expr28=func_call_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_func_call_expr.add(func_call_expr28.getTree());

                    // AST REWRITE
                    // elements: func_call_expr, IDENTIFIER, func_call_expr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 161:65: -> {explicitReceiver}? ^( METHOD_CALL IDENTIFIER func_call_expr )
                    if (explicitReceiver) {
                        // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:161:88: ^( METHOD_CALL IDENTIFIER func_call_expr )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(METHOD_CALL, "METHOD_CALL")
                        , root_1);

                        adaptor.addChild(root_1, 
                        stream_IDENTIFIER.nextNode()
                        );

                        adaptor.addChild(root_1, stream_func_call_expr.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    else // 161:129: -> ^( METHOD_CALL SELF func_call_expr )
                    {
                        // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:161:132: ^( METHOD_CALL SELF func_call_expr )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(METHOD_CALL, "METHOD_CALL")
                        , root_1);

                        adaptor.addChild(root_1, 
                        (CommonTree)adaptor.create(SELF, "SELF")
                        );

                        adaptor.addChild(root_1, stream_func_call_expr.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 2 :
                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:162:7: literal DOT func_call_expr
                    {
                    pushFollow(FOLLOW_literal_in_meth_call482);
                    literal29=literal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_literal.add(literal29.getTree());

                    DOT30=(Token)match(input,DOT,FOLLOW_DOT_in_meth_call484); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DOT.add(DOT30);


                    pushFollow(FOLLOW_func_call_expr_in_meth_call486);
                    func_call_expr31=func_call_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_func_call_expr.add(func_call_expr31.getTree());

                    // AST REWRITE
                    // elements: func_call_expr, literal
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 162:34: -> ^( METHOD_CALL literal func_call_expr )
                    {
                        // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:162:37: ^( METHOD_CALL literal func_call_expr )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(METHOD_CALL, "METHOD_CALL")
                        , root_1);

                        adaptor.addChild(root_1, stream_literal.nextTree());

                        adaptor.addChild(root_1, stream_func_call_expr.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        	// throw exceptions rather than silently failing...
        	catch (RecognitionException e) {
        	  throw e;
        	}

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 11, meth_call_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "meth_call"


    public static class chained_call_or_field_expr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "chained_call_or_field_expr"
    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:166:1: fragment chained_call_or_field_expr : ( chained_field_expr | chained_meth_call_expr );
    public final DeeLangParser.chained_call_or_field_expr_return chained_call_or_field_expr() throws RecognitionException {
        DeeLangParser.chained_call_or_field_expr_return retval = new DeeLangParser.chained_call_or_field_expr_return();
        retval.start = input.LT(1);

        int chained_call_or_field_expr_StartIndex = input.index();

        CommonTree root_0 = null;

        DeeLangParser.chained_field_expr_return chained_field_expr32 =null;

        DeeLangParser.chained_meth_call_expr_return chained_meth_call_expr33 =null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return retval; }

            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:167:5: ( chained_field_expr | chained_meth_call_expr )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==DOT) ) {
                int LA13_1 = input.LA(2);

                if ( (LA13_1==IDENTIFIER) ) {
                    int LA13_2 = input.LA(3);

                    if ( (LA13_2==EOF||LA13_2==ADD||LA13_2==COMMA||(LA13_2 >= DIV && LA13_2 <= DOT)||(LA13_2 >= MOD && LA13_2 <= MUL)||(LA13_2 >= POW && LA13_2 <= RPAREN)||(LA13_2 >= SUB && LA13_2 <= TERMINATOR)) ) {
                        alt13=1;
                    }
                    else if ( (LA13_2==LPAREN) ) {
                        alt13=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 13, 2, input);

                        throw nvae;

                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;

            }
            switch (alt13) {
                case 1 :
                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:167:7: chained_field_expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_chained_field_expr_in_chained_call_or_field_expr516);
                    chained_field_expr32=chained_field_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, chained_field_expr32.getTree());

                    }
                    break;
                case 2 :
                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:168:7: chained_meth_call_expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_chained_meth_call_expr_in_chained_call_or_field_expr524);
                    chained_meth_call_expr33=chained_meth_call_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, chained_meth_call_expr33.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        	// throw exceptions rather than silently failing...
        	catch (RecognitionException e) {
        	  throw e;
        	}

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 12, chained_call_or_field_expr_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "chained_call_or_field_expr"


    public static class chained_meth_call_expr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "chained_meth_call_expr"
    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:172:1: fragment chained_meth_call_expr : DOT func_call_expr -> ^( METHOD_CALL CHAIN func_call_expr ) ;
    public final DeeLangParser.chained_meth_call_expr_return chained_meth_call_expr() throws RecognitionException {
        DeeLangParser.chained_meth_call_expr_return retval = new DeeLangParser.chained_meth_call_expr_return();
        retval.start = input.LT(1);

        int chained_meth_call_expr_StartIndex = input.index();

        CommonTree root_0 = null;

        Token DOT34=null;
        DeeLangParser.func_call_expr_return func_call_expr35 =null;


        CommonTree DOT34_tree=null;
        RewriteRuleTokenStream stream_DOT=new RewriteRuleTokenStream(adaptor,"token DOT");
        RewriteRuleSubtreeStream stream_func_call_expr=new RewriteRuleSubtreeStream(adaptor,"rule func_call_expr");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return retval; }

            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:173:4: ( DOT func_call_expr -> ^( METHOD_CALL CHAIN func_call_expr ) )
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:173:6: DOT func_call_expr
            {
            DOT34=(Token)match(input,DOT,FOLLOW_DOT_in_chained_meth_call_expr546); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_DOT.add(DOT34);


            pushFollow(FOLLOW_func_call_expr_in_chained_meth_call_expr548);
            func_call_expr35=func_call_expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_func_call_expr.add(func_call_expr35.getTree());

            // AST REWRITE
            // elements: func_call_expr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 173:25: -> ^( METHOD_CALL CHAIN func_call_expr )
            {
                // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:173:28: ^( METHOD_CALL CHAIN func_call_expr )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(METHOD_CALL, "METHOD_CALL")
                , root_1);

                adaptor.addChild(root_1, 
                (CommonTree)adaptor.create(CHAIN, "CHAIN")
                );

                adaptor.addChild(root_1, stream_func_call_expr.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        	// throw exceptions rather than silently failing...
        	catch (RecognitionException e) {
        	  throw e;
        	}

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 13, chained_meth_call_expr_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "chained_meth_call_expr"


    public static class chained_field_expr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "chained_field_expr"
    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:177:1: fragment chained_field_expr : DOT IDENTIFIER -> ^( FIELD_ACCESS CHAIN IDENTIFIER ) ;
    public final DeeLangParser.chained_field_expr_return chained_field_expr() throws RecognitionException {
        DeeLangParser.chained_field_expr_return retval = new DeeLangParser.chained_field_expr_return();
        retval.start = input.LT(1);

        int chained_field_expr_StartIndex = input.index();

        CommonTree root_0 = null;

        Token DOT36=null;
        Token IDENTIFIER37=null;

        CommonTree DOT36_tree=null;
        CommonTree IDENTIFIER37_tree=null;
        RewriteRuleTokenStream stream_DOT=new RewriteRuleTokenStream(adaptor,"token DOT");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return retval; }

            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:178:5: ( DOT IDENTIFIER -> ^( FIELD_ACCESS CHAIN IDENTIFIER ) )
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:178:7: DOT IDENTIFIER
            {
            DOT36=(Token)match(input,DOT,FOLLOW_DOT_in_chained_field_expr575); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_DOT.add(DOT36);


            IDENTIFIER37=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_chained_field_expr577); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENTIFIER.add(IDENTIFIER37);


            // AST REWRITE
            // elements: IDENTIFIER
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 178:22: -> ^( FIELD_ACCESS CHAIN IDENTIFIER )
            {
                // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:178:25: ^( FIELD_ACCESS CHAIN IDENTIFIER )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(FIELD_ACCESS, "FIELD_ACCESS")
                , root_1);

                adaptor.addChild(root_1, 
                (CommonTree)adaptor.create(CHAIN, "CHAIN")
                );

                adaptor.addChild(root_1, 
                stream_IDENTIFIER.nextNode()
                );

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        	// throw exceptions rather than silently failing...
        	catch (RecognitionException e) {
        	  throw e;
        	}

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 14, chained_field_expr_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "chained_field_expr"


    public static class func_call_expr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "func_call_expr"
    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:182:1: fragment func_call_expr : IDENTIFIER ^ argument_list ( block )? ( orblock )? ;
    public final DeeLangParser.func_call_expr_return func_call_expr() throws RecognitionException {
        DeeLangParser.func_call_expr_return retval = new DeeLangParser.func_call_expr_return();
        retval.start = input.LT(1);

        int func_call_expr_StartIndex = input.index();

        CommonTree root_0 = null;

        Token IDENTIFIER38=null;
        DeeLangParser.argument_list_return argument_list39 =null;

        DeeLangParser.block_return block40 =null;

        DeeLangParser.orblock_return orblock41 =null;


        CommonTree IDENTIFIER38_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return retval; }

            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:183:3: ( IDENTIFIER ^ argument_list ( block )? ( orblock )? )
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:183:7: IDENTIFIER ^ argument_list ( block )? ( orblock )?
            {
            root_0 = (CommonTree)adaptor.nil();


            IDENTIFIER38=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_func_call_expr606); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER38_tree = 
            (CommonTree)adaptor.create(IDENTIFIER38)
            ;
            root_0 = (CommonTree)adaptor.becomeRoot(IDENTIFIER38_tree, root_0);
            }

            pushFollow(FOLLOW_argument_list_in_func_call_expr609);
            argument_list39=argument_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, argument_list39.getTree());

            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:183:33: ( block )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==LCURLY) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:183:33: block
                    {
                    pushFollow(FOLLOW_block_in_func_call_expr611);
                    block40=block();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, block40.getTree());

                    }
                    break;

            }


            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:183:40: ( orblock )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==OR) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:183:40: orblock
                    {
                    pushFollow(FOLLOW_orblock_in_func_call_expr614);
                    orblock41=orblock();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, orblock41.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        	// throw exceptions rather than silently failing...
        	catch (RecognitionException e) {
        	  throw e;
        	}

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 15, func_call_expr_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "func_call_expr"


    public static class block_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "block"
    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:187:1: fragment block : LCURLY ( TERMINATOR )* ( block_statement ( TERMINATOR block_statement )* )? RCURLY -> ^( BLOCK ( block_statement ( TERMINATOR block_statement )* )? ) ;
    public final DeeLangParser.block_return block() throws RecognitionException {
        DeeLangParser.block_return retval = new DeeLangParser.block_return();
        retval.start = input.LT(1);

        int block_StartIndex = input.index();

        CommonTree root_0 = null;

        Token LCURLY42=null;
        Token TERMINATOR43=null;
        Token TERMINATOR45=null;
        Token RCURLY47=null;
        DeeLangParser.block_statement_return block_statement44 =null;

        DeeLangParser.block_statement_return block_statement46 =null;


        CommonTree LCURLY42_tree=null;
        CommonTree TERMINATOR43_tree=null;
        CommonTree TERMINATOR45_tree=null;
        CommonTree RCURLY47_tree=null;
        RewriteRuleTokenStream stream_LCURLY=new RewriteRuleTokenStream(adaptor,"token LCURLY");
        RewriteRuleTokenStream stream_TERMINATOR=new RewriteRuleTokenStream(adaptor,"token TERMINATOR");
        RewriteRuleTokenStream stream_RCURLY=new RewriteRuleTokenStream(adaptor,"token RCURLY");
        RewriteRuleSubtreeStream stream_block_statement=new RewriteRuleSubtreeStream(adaptor,"rule block_statement");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return retval; }

            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:188:3: ( LCURLY ( TERMINATOR )* ( block_statement ( TERMINATOR block_statement )* )? RCURLY -> ^( BLOCK ( block_statement ( TERMINATOR block_statement )* )? ) )
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:188:7: LCURLY ( TERMINATOR )* ( block_statement ( TERMINATOR block_statement )* )? RCURLY
            {
            LCURLY42=(Token)match(input,LCURLY,FOLLOW_LCURLY_in_block640); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LCURLY.add(LCURLY42);


            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:188:14: ( TERMINATOR )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==TERMINATOR) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:188:14: TERMINATOR
            	    {
            	    TERMINATOR43=(Token)match(input,TERMINATOR,FOLLOW_TERMINATOR_in_block642); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_TERMINATOR.add(TERMINATOR43);


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);


            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:188:26: ( block_statement ( TERMINATOR block_statement )* )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==CHARACTER_LITERAL||LA18_0==DECIMAL_LITERAL||LA18_0==FLOATING_POINT_LITERAL||LA18_0==HEX_LITERAL||LA18_0==IDENTIFIER||LA18_0==LPAREN||(LA18_0 >= NOT && LA18_0 <= OCTAL_LITERAL)||LA18_0==STRING_LITERAL) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:188:27: block_statement ( TERMINATOR block_statement )*
                    {
                    pushFollow(FOLLOW_block_statement_in_block646);
                    block_statement44=block_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_block_statement.add(block_statement44.getTree());

                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:188:43: ( TERMINATOR block_statement )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==TERMINATOR) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:188:44: TERMINATOR block_statement
                    	    {
                    	    TERMINATOR45=(Token)match(input,TERMINATOR,FOLLOW_TERMINATOR_in_block649); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_TERMINATOR.add(TERMINATOR45);


                    	    pushFollow(FOLLOW_block_statement_in_block651);
                    	    block_statement46=block_statement();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_block_statement.add(block_statement46.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop17;
                        }
                    } while (true);


                    }
                    break;

            }


            RCURLY47=(Token)match(input,RCURLY,FOLLOW_RCURLY_in_block657); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RCURLY.add(RCURLY47);


            // AST REWRITE
            // elements: TERMINATOR, block_statement, block_statement
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 188:82: -> ^( BLOCK ( block_statement ( TERMINATOR block_statement )* )? )
            {
                // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:188:85: ^( BLOCK ( block_statement ( TERMINATOR block_statement )* )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(BLOCK, "BLOCK")
                , root_1);

                // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:188:93: ( block_statement ( TERMINATOR block_statement )* )?
                if ( stream_TERMINATOR.hasNext()||stream_block_statement.hasNext()||stream_block_statement.hasNext() ) {
                    adaptor.addChild(root_1, stream_block_statement.nextTree());

                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:188:110: ( TERMINATOR block_statement )*
                    while ( stream_TERMINATOR.hasNext()||stream_block_statement.hasNext() ) {
                        adaptor.addChild(root_1, 
                        stream_TERMINATOR.nextNode()
                        );

                        adaptor.addChild(root_1, stream_block_statement.nextTree());

                    }
                    stream_TERMINATOR.reset();
                    stream_block_statement.reset();

                }
                stream_TERMINATOR.reset();
                stream_block_statement.reset();
                stream_block_statement.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        	// throw exceptions rather than silently failing...
        	catch (RecognitionException e) {
        	  throw e;
        	}

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 16, block_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "block"


    public static class orblock_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "orblock"
    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:192:1: fragment orblock : OR LCURLY ( TERMINATOR )* ( block_statement ( TERMINATOR block_statement )* )? RCURLY -> ^( ORBLOCK ( block_statement ( TERMINATOR block_statement )* )? ) ;
    public final DeeLangParser.orblock_return orblock() throws RecognitionException {
        DeeLangParser.orblock_return retval = new DeeLangParser.orblock_return();
        retval.start = input.LT(1);

        int orblock_StartIndex = input.index();

        CommonTree root_0 = null;

        Token OR48=null;
        Token LCURLY49=null;
        Token TERMINATOR50=null;
        Token TERMINATOR52=null;
        Token RCURLY54=null;
        DeeLangParser.block_statement_return block_statement51 =null;

        DeeLangParser.block_statement_return block_statement53 =null;


        CommonTree OR48_tree=null;
        CommonTree LCURLY49_tree=null;
        CommonTree TERMINATOR50_tree=null;
        CommonTree TERMINATOR52_tree=null;
        CommonTree RCURLY54_tree=null;
        RewriteRuleTokenStream stream_LCURLY=new RewriteRuleTokenStream(adaptor,"token LCURLY");
        RewriteRuleTokenStream stream_TERMINATOR=new RewriteRuleTokenStream(adaptor,"token TERMINATOR");
        RewriteRuleTokenStream stream_OR=new RewriteRuleTokenStream(adaptor,"token OR");
        RewriteRuleTokenStream stream_RCURLY=new RewriteRuleTokenStream(adaptor,"token RCURLY");
        RewriteRuleSubtreeStream stream_block_statement=new RewriteRuleSubtreeStream(adaptor,"rule block_statement");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return retval; }

            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:193:3: ( OR LCURLY ( TERMINATOR )* ( block_statement ( TERMINATOR block_statement )* )? RCURLY -> ^( ORBLOCK ( block_statement ( TERMINATOR block_statement )* )? ) )
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:193:7: OR LCURLY ( TERMINATOR )* ( block_statement ( TERMINATOR block_statement )* )? RCURLY
            {
            OR48=(Token)match(input,OR,FOLLOW_OR_in_orblock694); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_OR.add(OR48);


            LCURLY49=(Token)match(input,LCURLY,FOLLOW_LCURLY_in_orblock696); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LCURLY.add(LCURLY49);


            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:193:17: ( TERMINATOR )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==TERMINATOR) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:193:17: TERMINATOR
            	    {
            	    TERMINATOR50=(Token)match(input,TERMINATOR,FOLLOW_TERMINATOR_in_orblock698); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_TERMINATOR.add(TERMINATOR50);


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);


            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:193:29: ( block_statement ( TERMINATOR block_statement )* )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==CHARACTER_LITERAL||LA21_0==DECIMAL_LITERAL||LA21_0==FLOATING_POINT_LITERAL||LA21_0==HEX_LITERAL||LA21_0==IDENTIFIER||LA21_0==LPAREN||(LA21_0 >= NOT && LA21_0 <= OCTAL_LITERAL)||LA21_0==STRING_LITERAL) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:193:30: block_statement ( TERMINATOR block_statement )*
                    {
                    pushFollow(FOLLOW_block_statement_in_orblock702);
                    block_statement51=block_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_block_statement.add(block_statement51.getTree());

                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:193:46: ( TERMINATOR block_statement )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==TERMINATOR) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:193:47: TERMINATOR block_statement
                    	    {
                    	    TERMINATOR52=(Token)match(input,TERMINATOR,FOLLOW_TERMINATOR_in_orblock705); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_TERMINATOR.add(TERMINATOR52);


                    	    pushFollow(FOLLOW_block_statement_in_orblock707);
                    	    block_statement53=block_statement();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_block_statement.add(block_statement53.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop20;
                        }
                    } while (true);


                    }
                    break;

            }


            RCURLY54=(Token)match(input,RCURLY,FOLLOW_RCURLY_in_orblock713); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RCURLY.add(RCURLY54);


            // AST REWRITE
            // elements: block_statement, block_statement, TERMINATOR
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 193:85: -> ^( ORBLOCK ( block_statement ( TERMINATOR block_statement )* )? )
            {
                // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:193:88: ^( ORBLOCK ( block_statement ( TERMINATOR block_statement )* )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ORBLOCK, "ORBLOCK")
                , root_1);

                // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:193:98: ( block_statement ( TERMINATOR block_statement )* )?
                if ( stream_block_statement.hasNext()||stream_block_statement.hasNext()||stream_TERMINATOR.hasNext() ) {
                    adaptor.addChild(root_1, stream_block_statement.nextTree());

                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:193:115: ( TERMINATOR block_statement )*
                    while ( stream_block_statement.hasNext()||stream_TERMINATOR.hasNext() ) {
                        adaptor.addChild(root_1, 
                        stream_TERMINATOR.nextNode()
                        );

                        adaptor.addChild(root_1, stream_block_statement.nextTree());

                    }
                    stream_block_statement.reset();
                    stream_TERMINATOR.reset();

                }
                stream_block_statement.reset();
                stream_block_statement.reset();
                stream_TERMINATOR.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        	// throw exceptions rather than silently failing...
        	catch (RecognitionException e) {
        	  throw e;
        	}

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 17, orblock_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "orblock"


    public static class argument_list_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "argument_list"
    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:197:1: fragment argument_list : LPAREN ( expr ( COMMA expr )* )? RPAREN -> ( ^( ARGS expr ( expr )* ) )? ;
    public final DeeLangParser.argument_list_return argument_list() throws RecognitionException {
        DeeLangParser.argument_list_return retval = new DeeLangParser.argument_list_return();
        retval.start = input.LT(1);

        int argument_list_StartIndex = input.index();

        CommonTree root_0 = null;

        Token LPAREN55=null;
        Token COMMA57=null;
        Token RPAREN59=null;
        DeeLangParser.expr_return expr56 =null;

        DeeLangParser.expr_return expr58 =null;


        CommonTree LPAREN55_tree=null;
        CommonTree COMMA57_tree=null;
        CommonTree RPAREN59_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return retval; }

            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:198:3: ( LPAREN ( expr ( COMMA expr )* )? RPAREN -> ( ^( ARGS expr ( expr )* ) )? )
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:198:7: LPAREN ( expr ( COMMA expr )* )? RPAREN
            {
            LPAREN55=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_argument_list750); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN55);


            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:198:14: ( expr ( COMMA expr )* )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==CHARACTER_LITERAL||LA23_0==DECIMAL_LITERAL||LA23_0==FLOATING_POINT_LITERAL||LA23_0==HEX_LITERAL||LA23_0==IDENTIFIER||LA23_0==LPAREN||(LA23_0 >= NOT && LA23_0 <= OCTAL_LITERAL)||LA23_0==STRING_LITERAL) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:198:15: expr ( COMMA expr )*
                    {
                    pushFollow(FOLLOW_expr_in_argument_list753);
                    expr56=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(expr56.getTree());

                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:198:20: ( COMMA expr )*
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==COMMA) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:198:21: COMMA expr
                    	    {
                    	    COMMA57=(Token)match(input,COMMA,FOLLOW_COMMA_in_argument_list756); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA57);


                    	    pushFollow(FOLLOW_expr_in_argument_list758);
                    	    expr58=expr();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_expr.add(expr58.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop22;
                        }
                    } while (true);


                    }
                    break;

            }


            RPAREN59=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_argument_list764); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN59);


            // AST REWRITE
            // elements: expr, expr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 198:43: -> ( ^( ARGS expr ( expr )* ) )?
            {
                // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:198:46: ( ^( ARGS expr ( expr )* ) )?
                if ( stream_expr.hasNext()||stream_expr.hasNext() ) {
                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:198:46: ^( ARGS expr ( expr )* )
                    {
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    root_1 = (CommonTree)adaptor.becomeRoot(
                    (CommonTree)adaptor.create(ARGS, "ARGS")
                    , root_1);

                    adaptor.addChild(root_1, stream_expr.nextTree());

                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:198:58: ( expr )*
                    while ( stream_expr.hasNext() ) {
                        adaptor.addChild(root_1, stream_expr.nextTree());

                    }
                    stream_expr.reset();

                    adaptor.addChild(root_0, root_1);
                    }

                }
                stream_expr.reset();
                stream_expr.reset();

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        	// throw exceptions rather than silently failing...
        	catch (RecognitionException e) {
        	  throw e;
        	}

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 18, argument_list_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "argument_list"


    public static class class_identifier_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "class_identifier"
    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:201:1: class_identifier : rec= IDENTIFIER DOT id= IDENTIFIER -> ^( FIELD_ACCESS $rec $id) ;
    public final DeeLangParser.class_identifier_return class_identifier() throws RecognitionException {
        DeeLangParser.class_identifier_return retval = new DeeLangParser.class_identifier_return();
        retval.start = input.LT(1);

        int class_identifier_StartIndex = input.index();

        CommonTree root_0 = null;

        Token rec=null;
        Token id=null;
        Token DOT60=null;

        CommonTree rec_tree=null;
        CommonTree id_tree=null;
        CommonTree DOT60_tree=null;
        RewriteRuleTokenStream stream_DOT=new RewriteRuleTokenStream(adaptor,"token DOT");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return retval; }

            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:202:3: (rec= IDENTIFIER DOT id= IDENTIFIER -> ^( FIELD_ACCESS $rec $id) )
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:202:9: rec= IDENTIFIER DOT id= IDENTIFIER
            {
            rec=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_class_identifier797); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENTIFIER.add(rec);


            DOT60=(Token)match(input,DOT,FOLLOW_DOT_in_class_identifier799); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_DOT.add(DOT60);


            id=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_class_identifier803); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENTIFIER.add(id);


            // AST REWRITE
            // elements: rec, id
            // token labels: id, rec
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleTokenStream stream_id=new RewriteRuleTokenStream(adaptor,"token id",id);
            RewriteRuleTokenStream stream_rec=new RewriteRuleTokenStream(adaptor,"token rec",rec);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 202:42: -> ^( FIELD_ACCESS $rec $id)
            {
                // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:202:45: ^( FIELD_ACCESS $rec $id)
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(FIELD_ACCESS, "FIELD_ACCESS")
                , root_1);

                adaptor.addChild(root_1, stream_rec.nextNode());

                adaptor.addChild(root_1, stream_id.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        	// throw exceptions rather than silently failing...
        	catch (RecognitionException e) {
        	  throw e;
        	}

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 19, class_identifier_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "class_identifier"


    public static class literal_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "literal"
    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:205:1: literal : ( DECIMAL_LITERAL | OCTAL_LITERAL | HEX_LITERAL | FLOATING_POINT_LITERAL | STRING_LITERAL | CHARACTER_LITERAL );
    public final DeeLangParser.literal_return literal() throws RecognitionException {
        DeeLangParser.literal_return retval = new DeeLangParser.literal_return();
        retval.start = input.LT(1);

        int literal_StartIndex = input.index();

        CommonTree root_0 = null;

        Token set61=null;

        CommonTree set61_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return retval; }

            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:206:3: ( DECIMAL_LITERAL | OCTAL_LITERAL | HEX_LITERAL | FLOATING_POINT_LITERAL | STRING_LITERAL | CHARACTER_LITERAL )
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            set61=(Token)input.LT(1);

            if ( input.LA(1)==CHARACTER_LITERAL||input.LA(1)==DECIMAL_LITERAL||input.LA(1)==FLOATING_POINT_LITERAL||input.LA(1)==HEX_LITERAL||input.LA(1)==OCTAL_LITERAL||input.LA(1)==STRING_LITERAL ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(set61)
                );
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        	// throw exceptions rather than silently failing...
        	catch (RecognitionException e) {
        	  throw e;
        	}

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 20, literal_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "literal"


    public static class atom_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "atom"
    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:215:1: atom : ( literal | IDENTIFIER | class_identifier ( chained_call_or_field_expr )* | meth_call ( chained_call_or_field_expr )* | LPAREN ! expr RPAREN !);
    public final DeeLangParser.atom_return atom() throws RecognitionException {
        DeeLangParser.atom_return retval = new DeeLangParser.atom_return();
        retval.start = input.LT(1);

        int atom_StartIndex = input.index();

        CommonTree root_0 = null;

        Token IDENTIFIER63=null;
        Token LPAREN68=null;
        Token RPAREN70=null;
        DeeLangParser.literal_return literal62 =null;

        DeeLangParser.class_identifier_return class_identifier64 =null;

        DeeLangParser.chained_call_or_field_expr_return chained_call_or_field_expr65 =null;

        DeeLangParser.meth_call_return meth_call66 =null;

        DeeLangParser.chained_call_or_field_expr_return chained_call_or_field_expr67 =null;

        DeeLangParser.expr_return expr69 =null;


        CommonTree IDENTIFIER63_tree=null;
        CommonTree LPAREN68_tree=null;
        CommonTree RPAREN70_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 21) ) { return retval; }

            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:216:3: ( literal | IDENTIFIER | class_identifier ( chained_call_or_field_expr )* | meth_call ( chained_call_or_field_expr )* | LPAREN ! expr RPAREN !)
            int alt26=5;
            switch ( input.LA(1) ) {
            case CHARACTER_LITERAL:
            case DECIMAL_LITERAL:
            case FLOATING_POINT_LITERAL:
            case HEX_LITERAL:
            case OCTAL_LITERAL:
            case STRING_LITERAL:
                {
                int LA26_1 = input.LA(2);

                if ( (LA26_1==EOF||LA26_1==ADD||LA26_1==COMMA||LA26_1==DIV||(LA26_1 >= MOD && LA26_1 <= MUL)||(LA26_1 >= POW && LA26_1 <= RPAREN)||(LA26_1 >= SUB && LA26_1 <= TERMINATOR)) ) {
                    alt26=1;
                }
                else if ( (LA26_1==DOT) ) {
                    alt26=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 26, 1, input);

                    throw nvae;

                }
                }
                break;
            case IDENTIFIER:
                {
                switch ( input.LA(2) ) {
                case DOT:
                    {
                    int LA26_6 = input.LA(3);

                    if ( (LA26_6==IDENTIFIER) ) {
                        int LA26_8 = input.LA(4);

                        if ( (LA26_8==EOF||LA26_8==ADD||LA26_8==COMMA||(LA26_8 >= DIV && LA26_8 <= DOT)||(LA26_8 >= MOD && LA26_8 <= MUL)||(LA26_8 >= POW && LA26_8 <= RPAREN)||(LA26_8 >= SUB && LA26_8 <= TERMINATOR)) ) {
                            alt26=3;
                        }
                        else if ( (LA26_8==LPAREN) ) {
                            alt26=4;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 26, 8, input);

                            throw nvae;

                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 26, 6, input);

                        throw nvae;

                    }
                    }
                    break;
                case EOF:
                case ADD:
                case COMMA:
                case DIV:
                case MOD:
                case MUL:
                case POW:
                case RCURLY:
                case RPAREN:
                case SUB:
                case TERMINATOR:
                    {
                    alt26=2;
                    }
                    break;
                case LPAREN:
                    {
                    alt26=4;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 26, 2, input);

                    throw nvae;

                }

                }
                break;
            case LPAREN:
                {
                alt26=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;

            }

            switch (alt26) {
                case 1 :
                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:216:9: literal
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_literal_in_atom902);
                    literal62=literal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, literal62.getTree());

                    }
                    break;
                case 2 :
                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:217:9: IDENTIFIER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    IDENTIFIER63=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_atom912); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER63_tree = 
                    (CommonTree)adaptor.create(IDENTIFIER63)
                    ;
                    adaptor.addChild(root_0, IDENTIFIER63_tree);
                    }

                    }
                    break;
                case 3 :
                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:218:9: class_identifier ( chained_call_or_field_expr )*
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_class_identifier_in_atom922);
                    class_identifier64=class_identifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, class_identifier64.getTree());

                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:218:26: ( chained_call_or_field_expr )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==DOT) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:218:27: chained_call_or_field_expr
                    	    {
                    	    pushFollow(FOLLOW_chained_call_or_field_expr_in_atom925);
                    	    chained_call_or_field_expr65=chained_call_or_field_expr();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, chained_call_or_field_expr65.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop24;
                        }
                    } while (true);


                    }
                    break;
                case 4 :
                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:219:9: meth_call ( chained_call_or_field_expr )*
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_meth_call_in_atom937);
                    meth_call66=meth_call();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, meth_call66.getTree());

                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:219:19: ( chained_call_or_field_expr )*
                    loop25:
                    do {
                        int alt25=2;
                        int LA25_0 = input.LA(1);

                        if ( (LA25_0==DOT) ) {
                            alt25=1;
                        }


                        switch (alt25) {
                    	case 1 :
                    	    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:219:20: chained_call_or_field_expr
                    	    {
                    	    pushFollow(FOLLOW_chained_call_or_field_expr_in_atom940);
                    	    chained_call_or_field_expr67=chained_call_or_field_expr();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, chained_call_or_field_expr67.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop25;
                        }
                    } while (true);


                    }
                    break;
                case 5 :
                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:220:9: LPAREN ! expr RPAREN !
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    LPAREN68=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_atom952); if (state.failed) return retval;

                    pushFollow(FOLLOW_expr_in_atom955);
                    expr69=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expr69.getTree());

                    RPAREN70=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_atom957); if (state.failed) return retval;

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        	// throw exceptions rather than silently failing...
        	catch (RecognitionException e) {
        	  throw e;
        	}

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 21, atom_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "atom"


    public static class terminator_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "terminator"
    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:223:1: terminator : ( TERMINATOR | EOF );
    public final DeeLangParser.terminator_return terminator() throws RecognitionException {
        DeeLangParser.terminator_return retval = new DeeLangParser.terminator_return();
        retval.start = input.LT(1);

        int terminator_StartIndex = input.index();

        CommonTree root_0 = null;

        Token set71=null;

        CommonTree set71_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 22) ) { return retval; }

            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:224:3: ( TERMINATOR | EOF )
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            set71=(Token)input.LT(1);

            if ( input.LA(1)==EOF||input.LA(1)==TERMINATOR ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(set71)
                );
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        	// throw exceptions rather than silently failing...
        	catch (RecognitionException e) {
        	  throw e;
        	}

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 22, terminator_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "terminator"

    // Delegated rules


 

    public static final BitSet FOLLOW_script_in_start_rule157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_script172 = new BitSet(new long[]{0x0000080C21504802L});
    public static final BitSet FOLLOW_EOF_in_script181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_statement197 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_terminator_in_statement199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_block_statement217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assign_expr_in_expr236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_math_expr_in_expr244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_assign_expr269 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_DOT_in_assign_expr271 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_assign_expr279 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ASSIGN_in_assign_expr281 = new BitSet(new long[]{0x0000080C21504800L});
    public static final BitSet FOLLOW_expr_in_assign_expr283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mult_expr_in_math_expr327 = new BitSet(new long[]{0x0000100000000012L});
    public static final BitSet FOLLOW_ADD_in_math_expr331 = new BitSet(new long[]{0x0000080C21504800L});
    public static final BitSet FOLLOW_SUB_in_math_expr334 = new BitSet(new long[]{0x0000080C21504800L});
    public static final BitSet FOLLOW_mult_expr_in_math_expr338 = new BitSet(new long[]{0x0000100000000012L});
    public static final BitSet FOLLOW_pow_expr_in_mult_expr356 = new BitSet(new long[]{0x0000000300008002L});
    public static final BitSet FOLLOW_MUL_in_mult_expr360 = new BitSet(new long[]{0x0000080C21504800L});
    public static final BitSet FOLLOW_DIV_in_mult_expr363 = new BitSet(new long[]{0x0000080C21504800L});
    public static final BitSet FOLLOW_MOD_in_mult_expr366 = new BitSet(new long[]{0x0000080C21504800L});
    public static final BitSet FOLLOW_pow_expr_in_mult_expr370 = new BitSet(new long[]{0x0000000300008002L});
    public static final BitSet FOLLOW_unary_expr_in_pow_expr392 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_POW_in_pow_expr396 = new BitSet(new long[]{0x0000080C21504800L});
    public static final BitSet FOLLOW_unary_expr_in_pow_expr400 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_NOT_in_unary_expr419 = new BitSet(new long[]{0x0000080821504800L});
    public static final BitSet FOLLOW_atom_in_unary_expr422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_meth_call443 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_DOT_in_meth_call445 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_func_call_expr_in_meth_call451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_meth_call482 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_DOT_in_meth_call484 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_func_call_expr_in_meth_call486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_chained_field_expr_in_chained_call_or_field_expr516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_chained_meth_call_expr_in_chained_call_or_field_expr524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_chained_meth_call_expr546 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_func_call_expr_in_chained_meth_call_expr548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_chained_field_expr575 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_chained_field_expr577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_func_call_expr606 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_argument_list_in_func_call_expr609 = new BitSet(new long[]{0x0000001008000002L});
    public static final BitSet FOLLOW_block_in_func_call_expr611 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_orblock_in_func_call_expr614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LCURLY_in_block640 = new BitSet(new long[]{0x0000290C21504800L});
    public static final BitSet FOLLOW_TERMINATOR_in_block642 = new BitSet(new long[]{0x0000290C21504800L});
    public static final BitSet FOLLOW_block_statement_in_block646 = new BitSet(new long[]{0x0000210000000000L});
    public static final BitSet FOLLOW_TERMINATOR_in_block649 = new BitSet(new long[]{0x0000080C21504800L});
    public static final BitSet FOLLOW_block_statement_in_block651 = new BitSet(new long[]{0x0000210000000000L});
    public static final BitSet FOLLOW_RCURLY_in_block657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OR_in_orblock694 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_LCURLY_in_orblock696 = new BitSet(new long[]{0x0000290C21504800L});
    public static final BitSet FOLLOW_TERMINATOR_in_orblock698 = new BitSet(new long[]{0x0000290C21504800L});
    public static final BitSet FOLLOW_block_statement_in_orblock702 = new BitSet(new long[]{0x0000210000000000L});
    public static final BitSet FOLLOW_TERMINATOR_in_orblock705 = new BitSet(new long[]{0x0000080C21504800L});
    public static final BitSet FOLLOW_block_statement_in_orblock707 = new BitSet(new long[]{0x0000210000000000L});
    public static final BitSet FOLLOW_RCURLY_in_orblock713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_argument_list750 = new BitSet(new long[]{0x00000A0C21504800L});
    public static final BitSet FOLLOW_expr_in_argument_list753 = new BitSet(new long[]{0x0000020000001000L});
    public static final BitSet FOLLOW_COMMA_in_argument_list756 = new BitSet(new long[]{0x0000080C21504800L});
    public static final BitSet FOLLOW_expr_in_argument_list758 = new BitSet(new long[]{0x0000020000001000L});
    public static final BitSet FOLLOW_RPAREN_in_argument_list764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_class_identifier797 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_DOT_in_class_identifier799 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_class_identifier803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_atom902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_atom912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_class_identifier_in_atom922 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_chained_call_or_field_expr_in_atom925 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_meth_call_in_atom937 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_chained_call_or_field_expr_in_atom940 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_LPAREN_in_atom952 = new BitSet(new long[]{0x0000080C21504800L});
    public static final BitSet FOLLOW_expr_in_atom955 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_RPAREN_in_atom957 = new BitSet(new long[]{0x0000000000000002L});

}