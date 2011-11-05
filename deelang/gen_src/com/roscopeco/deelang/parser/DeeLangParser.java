// $ANTLR 3.4 /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g 2011-11-05 14:45:47

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ADD", "ARGS", "ASSIGN", "ASSIGN_FIELD", "ASSIGN_LOCAL", "BLOCK", "CHAIN", "CHARACTER_LITERAL", "COMMA", "COMMENT", "DECIMAL_LITERAL", "DIV", "DOT", "DOTDOT", "Digits", "EscapeSequence", "Exponent", "FIELD_ACCESS", "FLOATING_POINT_LITERAL", "HEX_LITERAL", "HexDigit", "IDENTIFIER", "ID_LETTER", "LCURLY", "LINE_COMMENT", "LPAREN", "METHOD_CALL", "MOD", "MUL", "NOT", "OCTAL_LITERAL", "OR", "ORBLOCK", "OctalEscape", "POW", "RCURLY", "RPAREN", "SELF", "STRING_LITERAL", "SUB", "TERMINATOR", "TIME_LITERAL", "UnicodeEscape", "WS"
    };

    public static final int EOF=-1;
    public static final int ADD=4;
    public static final int ARGS=5;
    public static final int ASSIGN=6;
    public static final int ASSIGN_FIELD=7;
    public static final int ASSIGN_LOCAL=8;
    public static final int BLOCK=9;
    public static final int CHAIN=10;
    public static final int CHARACTER_LITERAL=11;
    public static final int COMMA=12;
    public static final int COMMENT=13;
    public static final int DECIMAL_LITERAL=14;
    public static final int DIV=15;
    public static final int DOT=16;
    public static final int DOTDOT=17;
    public static final int Digits=18;
    public static final int EscapeSequence=19;
    public static final int Exponent=20;
    public static final int FIELD_ACCESS=21;
    public static final int FLOATING_POINT_LITERAL=22;
    public static final int HEX_LITERAL=23;
    public static final int HexDigit=24;
    public static final int IDENTIFIER=25;
    public static final int ID_LETTER=26;
    public static final int LCURLY=27;
    public static final int LINE_COMMENT=28;
    public static final int LPAREN=29;
    public static final int METHOD_CALL=30;
    public static final int MOD=31;
    public static final int MUL=32;
    public static final int NOT=33;
    public static final int OCTAL_LITERAL=34;
    public static final int OR=35;
    public static final int ORBLOCK=36;
    public static final int OctalEscape=37;
    public static final int POW=38;
    public static final int RCURLY=39;
    public static final int RPAREN=40;
    public static final int SELF=41;
    public static final int STRING_LITERAL=42;
    public static final int SUB=43;
    public static final int TERMINATOR=44;
    public static final int TIME_LITERAL=45;
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
        this.state.ruleMemo = new HashMap[66+1];
         

    }

protected TreeAdaptor adaptor = new CommonTreeAdaptor();

public void setTreeAdaptor(TreeAdaptor adaptor) {
    this.adaptor = adaptor;
}
public TreeAdaptor getTreeAdaptor() {
    return adaptor;
}
    public String[] getTokenNames() { return DeeLangParser.tokenNames; }
    public String getGrammarFileName() { return "/home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g"; }


    /* throw exceptions rather than silently failing... */
    protected void mismatch(IntStream input, int ttype, BitSet follow)
    		throws RecognitionException {
    	throw new MismatchedTokenException(ttype, input);
    }

    @Override
    public Object recoverFromMismatchedSet(IntStream input, RecognitionException e,
    		BitSet follow) throws RecognitionException {
    	throw e;
    }

    @Override
    protected Object recoverFromMismatchedToken(IntStream input, int ttype,
    		BitSet follow) throws RecognitionException {
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
    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:199:1: start_rule : script ;
    public final DeeLangParser.start_rule_return start_rule() throws RecognitionException {
        DeeLangParser.start_rule_return retval = new DeeLangParser.start_rule_return();
        retval.start = input.LT(1);

        int start_rule_StartIndex = input.index();

        CommonTree root_0 = null;

        DeeLangParser.script_return script1 =null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return retval; }

            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:200:3: ( script )
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:200:6: script
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_script_in_start_rule169);
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
    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:203:1: script : ( ( statement )+ | EOF !);
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

            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:204:3: ( ( statement )+ | EOF !)
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==CHARACTER_LITERAL||LA2_0==DECIMAL_LITERAL||(LA2_0 >= FLOATING_POINT_LITERAL && LA2_0 <= HEX_LITERAL)||LA2_0==IDENTIFIER||LA2_0==LPAREN||(LA2_0 >= NOT && LA2_0 <= OCTAL_LITERAL)||LA2_0==STRING_LITERAL) ) {
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
                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:204:5: ( statement )+
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:204:5: ( statement )+
                    int cnt1=0;
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==CHARACTER_LITERAL||LA1_0==DECIMAL_LITERAL||(LA1_0 >= FLOATING_POINT_LITERAL && LA1_0 <= HEX_LITERAL)||LA1_0==IDENTIFIER||LA1_0==LPAREN||(LA1_0 >= NOT && LA1_0 <= OCTAL_LITERAL)||LA1_0==STRING_LITERAL) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:204:5: statement
                    	    {
                    	    pushFollow(FOLLOW_statement_in_script182);
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
                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:205:5: EOF !
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    EOF3=(Token)match(input,EOF,FOLLOW_EOF_in_script189); if (state.failed) return retval;

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
    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:208:1: statement : expr terminator !;
    public final DeeLangParser.statement_return statement() throws RecognitionException {
        DeeLangParser.statement_return retval = new DeeLangParser.statement_return();
        retval.start = input.LT(1);

        int statement_StartIndex = input.index();

        CommonTree root_0 = null;

        DeeLangParser.expr_return expr4 =null;

        DeeLangParser.terminator_return terminator5 =null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return retval; }

            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:209:3: ( expr terminator !)
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:209:5: expr terminator !
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_expr_in_statement203);
            expr4=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expr4.getTree());

            pushFollow(FOLLOW_terminator_in_statement205);
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
    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:212:1: block_statement : expr ;
    public final DeeLangParser.block_statement_return block_statement() throws RecognitionException {
        DeeLangParser.block_statement_return retval = new DeeLangParser.block_statement_return();
        retval.start = input.LT(1);

        int block_statement_StartIndex = input.index();

        CommonTree root_0 = null;

        DeeLangParser.expr_return expr6 =null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return retval; }

            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:213:3: ( expr )
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:213:5: expr
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_expr_in_block_statement219);
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
    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:216:1: expr : ( assign_expr | math_expr );
    public final DeeLangParser.expr_return expr() throws RecognitionException {
        DeeLangParser.expr_return retval = new DeeLangParser.expr_return();
        retval.start = input.LT(1);

        int expr_StartIndex = input.index();

        CommonTree root_0 = null;

        DeeLangParser.assign_expr_return assign_expr7 =null;

        DeeLangParser.math_expr_return math_expr8 =null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return retval; }

            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:217:3: ( assign_expr | math_expr )
            int alt3=2;
            switch ( input.LA(1) ) {
            case IDENTIFIER:
                {
                int LA3_1 = input.LA(2);

                if ( (synpred3_DeeLang()) ) {
                    alt3=1;
                }
                else if ( (true) ) {
                    alt3=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 1, input);

                    throw nvae;

                }
                }
                break;
            case CHARACTER_LITERAL:
            case DECIMAL_LITERAL:
            case FLOATING_POINT_LITERAL:
            case HEX_LITERAL:
            case OCTAL_LITERAL:
            case STRING_LITERAL:
                {
                int LA3_2 = input.LA(2);

                if ( (synpred3_DeeLang()) ) {
                    alt3=1;
                }
                else if ( (true) ) {
                    alt3=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 2, input);

                    throw nvae;

                }
                }
                break;
            case LPAREN:
                {
                int LA3_3 = input.LA(2);

                if ( (synpred3_DeeLang()) ) {
                    alt3=1;
                }
                else if ( (true) ) {
                    alt3=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 3, input);

                    throw nvae;

                }
                }
                break;
            case NOT:
                {
                alt3=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;

            }

            switch (alt3) {
                case 1 :
                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:217:5: assign_expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_assign_expr_in_expr232);
                    assign_expr7=assign_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, assign_expr7.getTree());

                    }
                    break;
                case 2 :
                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:218:5: math_expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_math_expr_in_expr238);
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
    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:221:1: assign_expr : ( class_identifier ( chained_call_or_field_expr )* DOT id= IDENTIFIER ASSIGN expr -> class_identifier ( chained_call_or_field_expr )* ^( ASSIGN_FIELD $id expr ) |ci= class_identifier ASSIGN expr -> IDENTIFIER[$ci.tree.getChild(0).getText()] ^( ASSIGN_FIELD IDENTIFIER[$ci.tree.getChild(1).getText()] expr ) | meth_call ( chained_call_or_field_expr )* DOT id= IDENTIFIER ASSIGN expr -> meth_call ( chained_call_or_field_expr )* ^( ASSIGN_FIELD $id expr ) | LPAREN e1= expr RPAREN ( chained_call_or_field_expr )* DOT id= IDENTIFIER ASSIGN e2= expr -> $e1 ( chained_call_or_field_expr )* ^( ASSIGN_FIELD $id $e2) |id= IDENTIFIER ASSIGN expr -> ^( ASSIGN_LOCAL IDENTIFIER expr ) );
    public final DeeLangParser.assign_expr_return assign_expr() throws RecognitionException {
        DeeLangParser.assign_expr_return retval = new DeeLangParser.assign_expr_return();
        retval.start = input.LT(1);

        int assign_expr_StartIndex = input.index();

        CommonTree root_0 = null;

        Token id=null;
        Token DOT11=null;
        Token ASSIGN12=null;
        Token ASSIGN14=null;
        Token DOT18=null;
        Token ASSIGN19=null;
        Token LPAREN21=null;
        Token RPAREN22=null;
        Token DOT24=null;
        Token ASSIGN25=null;
        Token ASSIGN26=null;
        DeeLangParser.class_identifier_return ci =null;

        DeeLangParser.expr_return e1 =null;

        DeeLangParser.expr_return e2 =null;

        DeeLangParser.class_identifier_return class_identifier9 =null;

        DeeLangParser.chained_call_or_field_expr_return chained_call_or_field_expr10 =null;

        DeeLangParser.expr_return expr13 =null;

        DeeLangParser.expr_return expr15 =null;

        DeeLangParser.meth_call_return meth_call16 =null;

        DeeLangParser.chained_call_or_field_expr_return chained_call_or_field_expr17 =null;

        DeeLangParser.expr_return expr20 =null;

        DeeLangParser.chained_call_or_field_expr_return chained_call_or_field_expr23 =null;

        DeeLangParser.expr_return expr27 =null;


        CommonTree id_tree=null;
        CommonTree DOT11_tree=null;
        CommonTree ASSIGN12_tree=null;
        CommonTree ASSIGN14_tree=null;
        CommonTree DOT18_tree=null;
        CommonTree ASSIGN19_tree=null;
        CommonTree LPAREN21_tree=null;
        CommonTree RPAREN22_tree=null;
        CommonTree DOT24_tree=null;
        CommonTree ASSIGN25_tree=null;
        CommonTree ASSIGN26_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_DOT=new RewriteRuleTokenStream(adaptor,"token DOT");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleTokenStream stream_ASSIGN=new RewriteRuleTokenStream(adaptor,"token ASSIGN");
        RewriteRuleSubtreeStream stream_class_identifier=new RewriteRuleSubtreeStream(adaptor,"rule class_identifier");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        RewriteRuleSubtreeStream stream_chained_call_or_field_expr=new RewriteRuleSubtreeStream(adaptor,"rule chained_call_or_field_expr");
        RewriteRuleSubtreeStream stream_meth_call=new RewriteRuleSubtreeStream(adaptor,"rule meth_call");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return retval; }

            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:222:3: ( class_identifier ( chained_call_or_field_expr )* DOT id= IDENTIFIER ASSIGN expr -> class_identifier ( chained_call_or_field_expr )* ^( ASSIGN_FIELD $id expr ) |ci= class_identifier ASSIGN expr -> IDENTIFIER[$ci.tree.getChild(0).getText()] ^( ASSIGN_FIELD IDENTIFIER[$ci.tree.getChild(1).getText()] expr ) | meth_call ( chained_call_or_field_expr )* DOT id= IDENTIFIER ASSIGN expr -> meth_call ( chained_call_or_field_expr )* ^( ASSIGN_FIELD $id expr ) | LPAREN e1= expr RPAREN ( chained_call_or_field_expr )* DOT id= IDENTIFIER ASSIGN e2= expr -> $e1 ( chained_call_or_field_expr )* ^( ASSIGN_FIELD $id $e2) |id= IDENTIFIER ASSIGN expr -> ^( ASSIGN_LOCAL IDENTIFIER expr ) )
            int alt7=5;
            switch ( input.LA(1) ) {
            case IDENTIFIER:
                {
                switch ( input.LA(2) ) {
                case DOT:
                    {
                    int LA7_4 = input.LA(3);

                    if ( (LA7_4==IDENTIFIER) ) {
                        switch ( input.LA(4) ) {
                        case DOT:
                            {
                            alt7=1;
                            }
                            break;
                        case ASSIGN:
                            {
                            alt7=2;
                            }
                            break;
                        case LPAREN:
                            {
                            alt7=3;
                            }
                            break;
                        default:
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 7, 6, input);

                            throw nvae;

                        }

                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 4, input);

                        throw nvae;

                    }
                    }
                    break;
                case ASSIGN:
                    {
                    alt7=5;
                    }
                    break;
                case LPAREN:
                    {
                    alt7=3;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 1, input);

                    throw nvae;

                }

                }
                break;
            case CHARACTER_LITERAL:
            case DECIMAL_LITERAL:
            case FLOATING_POINT_LITERAL:
            case HEX_LITERAL:
            case OCTAL_LITERAL:
            case STRING_LITERAL:
                {
                alt7=3;
                }
                break;
            case LPAREN:
                {
                alt7=4;
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
                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:222:5: class_identifier ( chained_call_or_field_expr )* DOT id= IDENTIFIER ASSIGN expr
                    {
                    pushFollow(FOLLOW_class_identifier_in_assign_expr251);
                    class_identifier9=class_identifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_class_identifier.add(class_identifier9.getTree());

                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:222:22: ( chained_call_or_field_expr )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==DOT) ) {
                            int LA4_1 = input.LA(2);

                            if ( (LA4_1==IDENTIFIER) ) {
                                int LA4_2 = input.LA(3);

                                if ( (LA4_2==DOT||LA4_2==LPAREN) ) {
                                    alt4=1;
                                }


                            }


                        }


                        switch (alt4) {
                    	case 1 :
                    	    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:222:22: chained_call_or_field_expr
                    	    {
                    	    pushFollow(FOLLOW_chained_call_or_field_expr_in_assign_expr253);
                    	    chained_call_or_field_expr10=chained_call_or_field_expr();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_chained_call_or_field_expr.add(chained_call_or_field_expr10.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);


                    DOT11=(Token)match(input,DOT,FOLLOW_DOT_in_assign_expr256); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DOT.add(DOT11);


                    id=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_assign_expr260); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENTIFIER.add(id);


                    ASSIGN12=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_assign_expr262); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ASSIGN.add(ASSIGN12);


                    pushFollow(FOLLOW_expr_in_assign_expr264);
                    expr13=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(expr13.getTree());

                    // AST REWRITE
                    // elements: class_identifier, id, chained_call_or_field_expr, expr
                    // token labels: id
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_id=new RewriteRuleTokenStream(adaptor,"token id",id);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 223:5: -> class_identifier ( chained_call_or_field_expr )* ^( ASSIGN_FIELD $id expr )
                    {
                        adaptor.addChild(root_0, stream_class_identifier.nextTree());

                        // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:223:25: ( chained_call_or_field_expr )*
                        while ( stream_chained_call_or_field_expr.hasNext() ) {
                            adaptor.addChild(root_0, stream_chained_call_or_field_expr.nextTree());

                        }
                        stream_chained_call_or_field_expr.reset();

                        // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:224:7: ^( ASSIGN_FIELD $id expr )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(ASSIGN_FIELD, "ASSIGN_FIELD")
                        , root_1);

                        adaptor.addChild(root_1, stream_id.nextNode());

                        adaptor.addChild(root_1, stream_expr.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 2 :
                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:225:5: ci= class_identifier ASSIGN expr
                    {
                    pushFollow(FOLLOW_class_identifier_in_assign_expr298);
                    ci=class_identifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_class_identifier.add(ci.getTree());

                    ASSIGN14=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_assign_expr300); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ASSIGN.add(ASSIGN14);


                    pushFollow(FOLLOW_expr_in_assign_expr302);
                    expr15=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(expr15.getTree());

                    // AST REWRITE
                    // elements: expr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 226:5: -> IDENTIFIER[$ci.tree.getChild(0).getText()] ^( ASSIGN_FIELD IDENTIFIER[$ci.tree.getChild(1).getText()] expr )
                    {
                        adaptor.addChild(root_0, 
                        (CommonTree)adaptor.create(IDENTIFIER, (ci!=null?((CommonTree)ci.tree):null).getChild(0).getText())
                        );

                        // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:227:7: ^( ASSIGN_FIELD IDENTIFIER[$ci.tree.getChild(1).getText()] expr )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(ASSIGN_FIELD, "ASSIGN_FIELD")
                        , root_1);

                        adaptor.addChild(root_1, 
                        (CommonTree)adaptor.create(IDENTIFIER, (ci!=null?((CommonTree)ci.tree):null).getChild(1).getText())
                        );

                        adaptor.addChild(root_1, stream_expr.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 3 :
                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:228:5: meth_call ( chained_call_or_field_expr )* DOT id= IDENTIFIER ASSIGN expr
                    {
                    pushFollow(FOLLOW_meth_call_in_assign_expr332);
                    meth_call16=meth_call();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_meth_call.add(meth_call16.getTree());

                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:228:15: ( chained_call_or_field_expr )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==DOT) ) {
                            int LA5_1 = input.LA(2);

                            if ( (LA5_1==IDENTIFIER) ) {
                                int LA5_2 = input.LA(3);

                                if ( (LA5_2==DOT||LA5_2==LPAREN) ) {
                                    alt5=1;
                                }


                            }


                        }


                        switch (alt5) {
                    	case 1 :
                    	    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:228:15: chained_call_or_field_expr
                    	    {
                    	    pushFollow(FOLLOW_chained_call_or_field_expr_in_assign_expr334);
                    	    chained_call_or_field_expr17=chained_call_or_field_expr();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_chained_call_or_field_expr.add(chained_call_or_field_expr17.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);


                    DOT18=(Token)match(input,DOT,FOLLOW_DOT_in_assign_expr337); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DOT.add(DOT18);


                    id=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_assign_expr341); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENTIFIER.add(id);


                    ASSIGN19=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_assign_expr343); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ASSIGN.add(ASSIGN19);


                    pushFollow(FOLLOW_expr_in_assign_expr345);
                    expr20=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(expr20.getTree());

                    // AST REWRITE
                    // elements: meth_call, expr, id, chained_call_or_field_expr
                    // token labels: id
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_id=new RewriteRuleTokenStream(adaptor,"token id",id);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 229:5: -> meth_call ( chained_call_or_field_expr )* ^( ASSIGN_FIELD $id expr )
                    {
                        adaptor.addChild(root_0, stream_meth_call.nextTree());

                        // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:229:18: ( chained_call_or_field_expr )*
                        while ( stream_chained_call_or_field_expr.hasNext() ) {
                            adaptor.addChild(root_0, stream_chained_call_or_field_expr.nextTree());

                        }
                        stream_chained_call_or_field_expr.reset();

                        // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:230:7: ^( ASSIGN_FIELD $id expr )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(ASSIGN_FIELD, "ASSIGN_FIELD")
                        , root_1);

                        adaptor.addChild(root_1, stream_id.nextNode());

                        adaptor.addChild(root_1, stream_expr.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 4 :
                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:231:5: LPAREN e1= expr RPAREN ( chained_call_or_field_expr )* DOT id= IDENTIFIER ASSIGN e2= expr
                    {
                    LPAREN21=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_assign_expr377); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN21);


                    pushFollow(FOLLOW_expr_in_assign_expr381);
                    e1=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(e1.getTree());

                    RPAREN22=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_assign_expr383); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN22);


                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:231:27: ( chained_call_or_field_expr )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==DOT) ) {
                            int LA6_1 = input.LA(2);

                            if ( (LA6_1==IDENTIFIER) ) {
                                int LA6_2 = input.LA(3);

                                if ( (LA6_2==DOT||LA6_2==LPAREN) ) {
                                    alt6=1;
                                }


                            }


                        }


                        switch (alt6) {
                    	case 1 :
                    	    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:231:27: chained_call_or_field_expr
                    	    {
                    	    pushFollow(FOLLOW_chained_call_or_field_expr_in_assign_expr385);
                    	    chained_call_or_field_expr23=chained_call_or_field_expr();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_chained_call_or_field_expr.add(chained_call_or_field_expr23.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);


                    DOT24=(Token)match(input,DOT,FOLLOW_DOT_in_assign_expr388); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DOT.add(DOT24);


                    id=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_assign_expr392); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENTIFIER.add(id);


                    ASSIGN25=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_assign_expr394); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ASSIGN.add(ASSIGN25);


                    pushFollow(FOLLOW_expr_in_assign_expr398);
                    e2=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(e2.getTree());

                    // AST REWRITE
                    // elements: id, e2, chained_call_or_field_expr, e1
                    // token labels: id
                    // rule labels: retval, e1, e2
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_id=new RewriteRuleTokenStream(adaptor,"token id",id);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_e1=new RewriteRuleSubtreeStream(adaptor,"rule e1",e1!=null?e1.tree:null);
                    RewriteRuleSubtreeStream stream_e2=new RewriteRuleSubtreeStream(adaptor,"rule e2",e2!=null?e2.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 232:5: -> $e1 ( chained_call_or_field_expr )* ^( ASSIGN_FIELD $id $e2)
                    {
                        adaptor.addChild(root_0, stream_e1.nextTree());

                        // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:232:12: ( chained_call_or_field_expr )*
                        while ( stream_chained_call_or_field_expr.hasNext() ) {
                            adaptor.addChild(root_0, stream_chained_call_or_field_expr.nextTree());

                        }
                        stream_chained_call_or_field_expr.reset();

                        // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:233:7: ^( ASSIGN_FIELD $id $e2)
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(ASSIGN_FIELD, "ASSIGN_FIELD")
                        , root_1);

                        adaptor.addChild(root_1, stream_id.nextNode());

                        adaptor.addChild(root_1, stream_e2.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 5 :
                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:234:5: id= IDENTIFIER ASSIGN expr
                    {
                    id=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_assign_expr434); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENTIFIER.add(id);


                    ASSIGN26=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_assign_expr436); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ASSIGN.add(ASSIGN26);


                    pushFollow(FOLLOW_expr_in_assign_expr438);
                    expr27=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(expr27.getTree());

                    // AST REWRITE
                    // elements: expr, IDENTIFIER
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 235:5: -> ^( ASSIGN_LOCAL IDENTIFIER expr )
                    {
                        // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:235:8: ^( ASSIGN_LOCAL IDENTIFIER expr )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(ASSIGN_LOCAL, "ASSIGN_LOCAL")
                        , root_1);

                        adaptor.addChild(root_1, 
                        stream_IDENTIFIER.nextNode()
                        );

                        adaptor.addChild(root_1, stream_expr.nextTree());

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
    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:238:1: math_expr : mult_expr ( ( ADD ^| SUB ^) mult_expr )* ;
    public final DeeLangParser.math_expr_return math_expr() throws RecognitionException {
        DeeLangParser.math_expr_return retval = new DeeLangParser.math_expr_return();
        retval.start = input.LT(1);

        int math_expr_StartIndex = input.index();

        CommonTree root_0 = null;

        Token ADD29=null;
        Token SUB30=null;
        DeeLangParser.mult_expr_return mult_expr28 =null;

        DeeLangParser.mult_expr_return mult_expr31 =null;


        CommonTree ADD29_tree=null;
        CommonTree SUB30_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return retval; }

            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:239:3: ( mult_expr ( ( ADD ^| SUB ^) mult_expr )* )
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:239:5: mult_expr ( ( ADD ^| SUB ^) mult_expr )*
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_mult_expr_in_math_expr465);
            mult_expr28=mult_expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, mult_expr28.getTree());

            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:239:15: ( ( ADD ^| SUB ^) mult_expr )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==ADD||LA9_0==SUB) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:239:16: ( ADD ^| SUB ^) mult_expr
            	    {
            	    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:239:16: ( ADD ^| SUB ^)
            	    int alt8=2;
            	    int LA8_0 = input.LA(1);

            	    if ( (LA8_0==ADD) ) {
            	        alt8=1;
            	    }
            	    else if ( (LA8_0==SUB) ) {
            	        alt8=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 8, 0, input);

            	        throw nvae;

            	    }
            	    switch (alt8) {
            	        case 1 :
            	            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:239:17: ADD ^
            	            {
            	            ADD29=(Token)match(input,ADD,FOLLOW_ADD_in_math_expr469); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            ADD29_tree = 
            	            (CommonTree)adaptor.create(ADD29)
            	            ;
            	            root_0 = (CommonTree)adaptor.becomeRoot(ADD29_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:239:22: SUB ^
            	            {
            	            SUB30=(Token)match(input,SUB,FOLLOW_SUB_in_math_expr472); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            SUB30_tree = 
            	            (CommonTree)adaptor.create(SUB30)
            	            ;
            	            root_0 = (CommonTree)adaptor.becomeRoot(SUB30_tree, root_0);
            	            }

            	            }
            	            break;

            	    }


            	    pushFollow(FOLLOW_mult_expr_in_math_expr476);
            	    mult_expr31=mult_expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, mult_expr31.getTree());

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
    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:242:1: mult_expr : pow_expr ( ( MUL ^| DIV ^| MOD ^) pow_expr )* ;
    public final DeeLangParser.mult_expr_return mult_expr() throws RecognitionException {
        DeeLangParser.mult_expr_return retval = new DeeLangParser.mult_expr_return();
        retval.start = input.LT(1);

        int mult_expr_StartIndex = input.index();

        CommonTree root_0 = null;

        Token MUL33=null;
        Token DIV34=null;
        Token MOD35=null;
        DeeLangParser.pow_expr_return pow_expr32 =null;

        DeeLangParser.pow_expr_return pow_expr36 =null;


        CommonTree MUL33_tree=null;
        CommonTree DIV34_tree=null;
        CommonTree MOD35_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return retval; }

            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:243:3: ( pow_expr ( ( MUL ^| DIV ^| MOD ^) pow_expr )* )
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:243:5: pow_expr ( ( MUL ^| DIV ^| MOD ^) pow_expr )*
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_pow_expr_in_mult_expr491);
            pow_expr32=pow_expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, pow_expr32.getTree());

            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:243:14: ( ( MUL ^| DIV ^| MOD ^) pow_expr )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==DIV||(LA11_0 >= MOD && LA11_0 <= MUL)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:243:15: ( MUL ^| DIV ^| MOD ^) pow_expr
            	    {
            	    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:243:15: ( MUL ^| DIV ^| MOD ^)
            	    int alt10=3;
            	    switch ( input.LA(1) ) {
            	    case MUL:
            	        {
            	        alt10=1;
            	        }
            	        break;
            	    case DIV:
            	        {
            	        alt10=2;
            	        }
            	        break;
            	    case MOD:
            	        {
            	        alt10=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 10, 0, input);

            	        throw nvae;

            	    }

            	    switch (alt10) {
            	        case 1 :
            	            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:243:16: MUL ^
            	            {
            	            MUL33=(Token)match(input,MUL,FOLLOW_MUL_in_mult_expr495); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            MUL33_tree = 
            	            (CommonTree)adaptor.create(MUL33)
            	            ;
            	            root_0 = (CommonTree)adaptor.becomeRoot(MUL33_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:243:22: DIV ^
            	            {
            	            DIV34=(Token)match(input,DIV,FOLLOW_DIV_in_mult_expr499); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            DIV34_tree = 
            	            (CommonTree)adaptor.create(DIV34)
            	            ;
            	            root_0 = (CommonTree)adaptor.becomeRoot(DIV34_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:243:28: MOD ^
            	            {
            	            MOD35=(Token)match(input,MOD,FOLLOW_MOD_in_mult_expr503); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            MOD35_tree = 
            	            (CommonTree)adaptor.create(MOD35)
            	            ;
            	            root_0 = (CommonTree)adaptor.becomeRoot(MOD35_tree, root_0);
            	            }

            	            }
            	            break;

            	    }


            	    pushFollow(FOLLOW_pow_expr_in_mult_expr507);
            	    pow_expr36=pow_expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, pow_expr36.getTree());

            	    }
            	    break;

            	default :
            	    break loop11;
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
    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:246:1: pow_expr : unary_expr ( ( POW ^) unary_expr )* ;
    public final DeeLangParser.pow_expr_return pow_expr() throws RecognitionException {
        DeeLangParser.pow_expr_return retval = new DeeLangParser.pow_expr_return();
        retval.start = input.LT(1);

        int pow_expr_StartIndex = input.index();

        CommonTree root_0 = null;

        Token POW38=null;
        DeeLangParser.unary_expr_return unary_expr37 =null;

        DeeLangParser.unary_expr_return unary_expr39 =null;


        CommonTree POW38_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return retval; }

            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:247:3: ( unary_expr ( ( POW ^) unary_expr )* )
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:247:5: unary_expr ( ( POW ^) unary_expr )*
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_unary_expr_in_pow_expr522);
            unary_expr37=unary_expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, unary_expr37.getTree());

            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:247:16: ( ( POW ^) unary_expr )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==POW) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:247:17: ( POW ^) unary_expr
            	    {
            	    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:247:17: ( POW ^)
            	    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:247:18: POW ^
            	    {
            	    POW38=(Token)match(input,POW,FOLLOW_POW_in_pow_expr526); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    POW38_tree = 
            	    (CommonTree)adaptor.create(POW38)
            	    ;
            	    root_0 = (CommonTree)adaptor.becomeRoot(POW38_tree, root_0);
            	    }

            	    }


            	    pushFollow(FOLLOW_unary_expr_in_pow_expr530);
            	    unary_expr39=unary_expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, unary_expr39.getTree());

            	    }
            	    break;

            	default :
            	    break loop12;
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
    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:250:1: unary_expr : ( NOT )? atom ;
    public final DeeLangParser.unary_expr_return unary_expr() throws RecognitionException {
        DeeLangParser.unary_expr_return retval = new DeeLangParser.unary_expr_return();
        retval.start = input.LT(1);

        int unary_expr_StartIndex = input.index();

        CommonTree root_0 = null;

        Token NOT40=null;
        DeeLangParser.atom_return atom41 =null;


        CommonTree NOT40_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return retval; }

            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:251:3: ( ( NOT )? atom )
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:251:5: ( NOT )? atom
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:251:5: ( NOT )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==NOT) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:251:5: NOT
                    {
                    NOT40=(Token)match(input,NOT,FOLLOW_NOT_in_unary_expr545); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NOT40_tree = 
                    (CommonTree)adaptor.create(NOT40)
                    ;
                    adaptor.addChild(root_0, NOT40_tree);
                    }

                    }
                    break;

            }


            pushFollow(FOLLOW_atom_in_unary_expr548);
            atom41=atom();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, atom41.getTree());

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
    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:254:1: meth_call : ( ( IDENTIFIER DOT )? func_call_expr -> {explicitReceiver}? ^( METHOD_CALL IDENTIFIER func_call_expr ) -> ^( METHOD_CALL SELF func_call_expr ) | literal DOT func_call_expr -> ^( METHOD_CALL literal func_call_expr ) );
    public final DeeLangParser.meth_call_return meth_call() throws RecognitionException {
        DeeLangParser.meth_call_return retval = new DeeLangParser.meth_call_return();
        retval.start = input.LT(1);

        int meth_call_StartIndex = input.index();

        CommonTree root_0 = null;

        Token IDENTIFIER42=null;
        Token DOT43=null;
        Token DOT46=null;
        DeeLangParser.func_call_expr_return func_call_expr44 =null;

        DeeLangParser.literal_return literal45 =null;

        DeeLangParser.func_call_expr_return func_call_expr47 =null;


        CommonTree IDENTIFIER42_tree=null;
        CommonTree DOT43_tree=null;
        CommonTree DOT46_tree=null;
        RewriteRuleTokenStream stream_DOT=new RewriteRuleTokenStream(adaptor,"token DOT");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");
        RewriteRuleSubtreeStream stream_func_call_expr=new RewriteRuleSubtreeStream(adaptor,"rule func_call_expr");
        RewriteRuleSubtreeStream stream_literal=new RewriteRuleSubtreeStream(adaptor,"rule literal");

        boolean explicitReceiver = false;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return retval; }

            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:258:3: ( ( IDENTIFIER DOT )? func_call_expr -> {explicitReceiver}? ^( METHOD_CALL IDENTIFIER func_call_expr ) -> ^( METHOD_CALL SELF func_call_expr ) | literal DOT func_call_expr -> ^( METHOD_CALL literal func_call_expr ) )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==IDENTIFIER) ) {
                alt15=1;
            }
            else if ( (LA15_0==CHARACTER_LITERAL||LA15_0==DECIMAL_LITERAL||(LA15_0 >= FLOATING_POINT_LITERAL && LA15_0 <= HEX_LITERAL)||LA15_0==OCTAL_LITERAL||LA15_0==STRING_LITERAL) ) {
                alt15=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;

            }
            switch (alt15) {
                case 1 :
                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:258:5: ( IDENTIFIER DOT )? func_call_expr
                    {
                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:258:5: ( IDENTIFIER DOT )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==IDENTIFIER) ) {
                        int LA14_1 = input.LA(2);

                        if ( (LA14_1==DOT) ) {
                            alt14=1;
                        }
                    }
                    switch (alt14) {
                        case 1 :
                            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:258:6: IDENTIFIER DOT
                            {
                            IDENTIFIER42=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_meth_call567); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_IDENTIFIER.add(IDENTIFIER42);


                            DOT43=(Token)match(input,DOT,FOLLOW_DOT_in_meth_call569); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_DOT.add(DOT43);


                            if ( state.backtracking==0 ) {explicitReceiver = true;}

                            }
                            break;

                    }


                    pushFollow(FOLLOW_func_call_expr_in_meth_call575);
                    func_call_expr44=func_call_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_func_call_expr.add(func_call_expr44.getTree());

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
                    // 259:5: -> {explicitReceiver}? ^( METHOD_CALL IDENTIFIER func_call_expr )
                    if (explicitReceiver) {
                        // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:260:7: ^( METHOD_CALL IDENTIFIER func_call_expr )
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

                    else // 261:5: -> ^( METHOD_CALL SELF func_call_expr )
                    {
                        // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:261:8: ^( METHOD_CALL SELF func_call_expr )
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
                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:262:5: literal DOT func_call_expr
                    {
                    pushFollow(FOLLOW_literal_in_meth_call617);
                    literal45=literal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_literal.add(literal45.getTree());

                    DOT46=(Token)match(input,DOT,FOLLOW_DOT_in_meth_call619); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DOT.add(DOT46);


                    pushFollow(FOLLOW_func_call_expr_in_meth_call621);
                    func_call_expr47=func_call_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_func_call_expr.add(func_call_expr47.getTree());

                    // AST REWRITE
                    // elements: literal, func_call_expr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 263:5: -> ^( METHOD_CALL literal func_call_expr )
                    {
                        // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:263:8: ^( METHOD_CALL literal func_call_expr )
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
    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:267:1: fragment chained_call_or_field_expr : ( chained_field_expr | chained_meth_call_expr );
    public final DeeLangParser.chained_call_or_field_expr_return chained_call_or_field_expr() throws RecognitionException {
        DeeLangParser.chained_call_or_field_expr_return retval = new DeeLangParser.chained_call_or_field_expr_return();
        retval.start = input.LT(1);

        int chained_call_or_field_expr_StartIndex = input.index();

        CommonTree root_0 = null;

        DeeLangParser.chained_field_expr_return chained_field_expr48 =null;

        DeeLangParser.chained_meth_call_expr_return chained_meth_call_expr49 =null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return retval; }

            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:268:3: ( chained_field_expr | chained_meth_call_expr )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==DOT) ) {
                int LA16_1 = input.LA(2);

                if ( (LA16_1==IDENTIFIER) ) {
                    int LA16_2 = input.LA(3);

                    if ( (LA16_2==EOF||LA16_2==ADD||LA16_2==COMMA||(LA16_2 >= DIV && LA16_2 <= DOT)||(LA16_2 >= MOD && LA16_2 <= MUL)||(LA16_2 >= POW && LA16_2 <= RPAREN)||(LA16_2 >= SUB && LA16_2 <= TERMINATOR)) ) {
                        alt16=1;
                    }
                    else if ( (LA16_2==LPAREN) ) {
                        alt16=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 16, 2, input);

                        throw nvae;

                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 16, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;

            }
            switch (alt16) {
                case 1 :
                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:268:5: chained_field_expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_chained_field_expr_in_chained_call_or_field_expr650);
                    chained_field_expr48=chained_field_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, chained_field_expr48.getTree());

                    }
                    break;
                case 2 :
                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:269:5: chained_meth_call_expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_chained_meth_call_expr_in_chained_call_or_field_expr656);
                    chained_meth_call_expr49=chained_meth_call_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, chained_meth_call_expr49.getTree());

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
    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:273:1: fragment chained_meth_call_expr : DOT func_call_expr -> ^( METHOD_CALL CHAIN func_call_expr ) ;
    public final DeeLangParser.chained_meth_call_expr_return chained_meth_call_expr() throws RecognitionException {
        DeeLangParser.chained_meth_call_expr_return retval = new DeeLangParser.chained_meth_call_expr_return();
        retval.start = input.LT(1);

        int chained_meth_call_expr_StartIndex = input.index();

        CommonTree root_0 = null;

        Token DOT50=null;
        DeeLangParser.func_call_expr_return func_call_expr51 =null;


        CommonTree DOT50_tree=null;
        RewriteRuleTokenStream stream_DOT=new RewriteRuleTokenStream(adaptor,"token DOT");
        RewriteRuleSubtreeStream stream_func_call_expr=new RewriteRuleSubtreeStream(adaptor,"rule func_call_expr");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return retval; }

            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:274:3: ( DOT func_call_expr -> ^( METHOD_CALL CHAIN func_call_expr ) )
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:274:5: DOT func_call_expr
            {
            DOT50=(Token)match(input,DOT,FOLLOW_DOT_in_chained_meth_call_expr671); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_DOT.add(DOT50);


            pushFollow(FOLLOW_func_call_expr_in_chained_meth_call_expr673);
            func_call_expr51=func_call_expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_func_call_expr.add(func_call_expr51.getTree());

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
            // 274:24: -> ^( METHOD_CALL CHAIN func_call_expr )
            {
                // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:274:27: ^( METHOD_CALL CHAIN func_call_expr )
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
    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:278:1: fragment chained_field_expr : DOT IDENTIFIER -> ^( FIELD_ACCESS CHAIN IDENTIFIER ) ;
    public final DeeLangParser.chained_field_expr_return chained_field_expr() throws RecognitionException {
        DeeLangParser.chained_field_expr_return retval = new DeeLangParser.chained_field_expr_return();
        retval.start = input.LT(1);

        int chained_field_expr_StartIndex = input.index();

        CommonTree root_0 = null;

        Token DOT52=null;
        Token IDENTIFIER53=null;

        CommonTree DOT52_tree=null;
        CommonTree IDENTIFIER53_tree=null;
        RewriteRuleTokenStream stream_DOT=new RewriteRuleTokenStream(adaptor,"token DOT");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return retval; }

            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:279:3: ( DOT IDENTIFIER -> ^( FIELD_ACCESS CHAIN IDENTIFIER ) )
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:279:5: DOT IDENTIFIER
            {
            DOT52=(Token)match(input,DOT,FOLLOW_DOT_in_chained_field_expr698); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_DOT.add(DOT52);


            IDENTIFIER53=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_chained_field_expr700); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENTIFIER.add(IDENTIFIER53);


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
            // 279:20: -> ^( FIELD_ACCESS CHAIN IDENTIFIER )
            {
                // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:279:23: ^( FIELD_ACCESS CHAIN IDENTIFIER )
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
    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:283:1: fragment func_call_expr : IDENTIFIER ^ argument_list ( block )? ( orblock )? ;
    public final DeeLangParser.func_call_expr_return func_call_expr() throws RecognitionException {
        DeeLangParser.func_call_expr_return retval = new DeeLangParser.func_call_expr_return();
        retval.start = input.LT(1);

        int func_call_expr_StartIndex = input.index();

        CommonTree root_0 = null;

        Token IDENTIFIER54=null;
        DeeLangParser.argument_list_return argument_list55 =null;

        DeeLangParser.block_return block56 =null;

        DeeLangParser.orblock_return orblock57 =null;


        CommonTree IDENTIFIER54_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return retval; }

            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:284:3: ( IDENTIFIER ^ argument_list ( block )? ( orblock )? )
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:284:5: IDENTIFIER ^ argument_list ( block )? ( orblock )?
            {
            root_0 = (CommonTree)adaptor.nil();


            IDENTIFIER54=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_func_call_expr725); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER54_tree = 
            (CommonTree)adaptor.create(IDENTIFIER54)
            ;
            root_0 = (CommonTree)adaptor.becomeRoot(IDENTIFIER54_tree, root_0);
            }

            pushFollow(FOLLOW_argument_list_in_func_call_expr728);
            argument_list55=argument_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, argument_list55.getTree());

            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:284:31: ( block )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==LCURLY) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:284:31: block
                    {
                    pushFollow(FOLLOW_block_in_func_call_expr730);
                    block56=block();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, block56.getTree());

                    }
                    break;

            }


            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:284:38: ( orblock )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==OR) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:284:38: orblock
                    {
                    pushFollow(FOLLOW_orblock_in_func_call_expr733);
                    orblock57=orblock();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, orblock57.getTree());

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
    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:288:1: fragment block : LCURLY ( TERMINATOR )* ( block_statement ( TERMINATOR block_statement )* )? ( TERMINATOR )* RCURLY -> ^( BLOCK ( block_statement )* ) ;
    public final DeeLangParser.block_return block() throws RecognitionException {
        DeeLangParser.block_return retval = new DeeLangParser.block_return();
        retval.start = input.LT(1);

        int block_StartIndex = input.index();

        CommonTree root_0 = null;

        Token LCURLY58=null;
        Token TERMINATOR59=null;
        Token TERMINATOR61=null;
        Token TERMINATOR63=null;
        Token RCURLY64=null;
        DeeLangParser.block_statement_return block_statement60 =null;

        DeeLangParser.block_statement_return block_statement62 =null;


        CommonTree LCURLY58_tree=null;
        CommonTree TERMINATOR59_tree=null;
        CommonTree TERMINATOR61_tree=null;
        CommonTree TERMINATOR63_tree=null;
        CommonTree RCURLY64_tree=null;
        RewriteRuleTokenStream stream_LCURLY=new RewriteRuleTokenStream(adaptor,"token LCURLY");
        RewriteRuleTokenStream stream_TERMINATOR=new RewriteRuleTokenStream(adaptor,"token TERMINATOR");
        RewriteRuleTokenStream stream_RCURLY=new RewriteRuleTokenStream(adaptor,"token RCURLY");
        RewriteRuleSubtreeStream stream_block_statement=new RewriteRuleSubtreeStream(adaptor,"rule block_statement");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return retval; }

            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:289:3: ( LCURLY ( TERMINATOR )* ( block_statement ( TERMINATOR block_statement )* )? ( TERMINATOR )* RCURLY -> ^( BLOCK ( block_statement )* ) )
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:289:5: LCURLY ( TERMINATOR )* ( block_statement ( TERMINATOR block_statement )* )? ( TERMINATOR )* RCURLY
            {
            LCURLY58=(Token)match(input,LCURLY,FOLLOW_LCURLY_in_block749); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LCURLY.add(LCURLY58);


            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:289:12: ( TERMINATOR )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==TERMINATOR) ) {
                    int LA19_2 = input.LA(2);

                    if ( (synpred23_DeeLang()) ) {
                        alt19=1;
                    }


                }


                switch (alt19) {
            	case 1 :
            	    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:289:12: TERMINATOR
            	    {
            	    TERMINATOR59=(Token)match(input,TERMINATOR,FOLLOW_TERMINATOR_in_block751); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_TERMINATOR.add(TERMINATOR59);


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);


            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:289:24: ( block_statement ( TERMINATOR block_statement )* )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==CHARACTER_LITERAL||LA21_0==DECIMAL_LITERAL||(LA21_0 >= FLOATING_POINT_LITERAL && LA21_0 <= HEX_LITERAL)||LA21_0==IDENTIFIER||LA21_0==LPAREN||(LA21_0 >= NOT && LA21_0 <= OCTAL_LITERAL)||LA21_0==STRING_LITERAL) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:289:25: block_statement ( TERMINATOR block_statement )*
                    {
                    pushFollow(FOLLOW_block_statement_in_block755);
                    block_statement60=block_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_block_statement.add(block_statement60.getTree());

                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:289:41: ( TERMINATOR block_statement )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==TERMINATOR) ) {
                            int LA20_1 = input.LA(2);

                            if ( (LA20_1==CHARACTER_LITERAL||LA20_1==DECIMAL_LITERAL||(LA20_1 >= FLOATING_POINT_LITERAL && LA20_1 <= HEX_LITERAL)||LA20_1==IDENTIFIER||LA20_1==LPAREN||(LA20_1 >= NOT && LA20_1 <= OCTAL_LITERAL)||LA20_1==STRING_LITERAL) ) {
                                alt20=1;
                            }


                        }


                        switch (alt20) {
                    	case 1 :
                    	    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:289:42: TERMINATOR block_statement
                    	    {
                    	    TERMINATOR61=(Token)match(input,TERMINATOR,FOLLOW_TERMINATOR_in_block758); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_TERMINATOR.add(TERMINATOR61);


                    	    pushFollow(FOLLOW_block_statement_in_block760);
                    	    block_statement62=block_statement();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_block_statement.add(block_statement62.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop20;
                        }
                    } while (true);


                    }
                    break;

            }


            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:289:73: ( TERMINATOR )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==TERMINATOR) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:289:73: TERMINATOR
            	    {
            	    TERMINATOR63=(Token)match(input,TERMINATOR,FOLLOW_TERMINATOR_in_block766); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_TERMINATOR.add(TERMINATOR63);


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);


            RCURLY64=(Token)match(input,RCURLY,FOLLOW_RCURLY_in_block769); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RCURLY.add(RCURLY64);


            // AST REWRITE
            // elements: block_statement
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 290:5: -> ^( BLOCK ( block_statement )* )
            {
                // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:290:8: ^( BLOCK ( block_statement )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(BLOCK, "BLOCK")
                , root_1);

                // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:290:16: ( block_statement )*
                while ( stream_block_statement.hasNext() ) {
                    adaptor.addChild(root_1, stream_block_statement.nextTree());

                }
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
    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:294:1: fragment orblock : OR LCURLY ( TERMINATOR )* ( block_statement ( TERMINATOR block_statement )* )? ( TERMINATOR )* RCURLY -> ^( ORBLOCK ( block_statement )* ) ;
    public final DeeLangParser.orblock_return orblock() throws RecognitionException {
        DeeLangParser.orblock_return retval = new DeeLangParser.orblock_return();
        retval.start = input.LT(1);

        int orblock_StartIndex = input.index();

        CommonTree root_0 = null;

        Token OR65=null;
        Token LCURLY66=null;
        Token TERMINATOR67=null;
        Token TERMINATOR69=null;
        Token TERMINATOR71=null;
        Token RCURLY72=null;
        DeeLangParser.block_statement_return block_statement68 =null;

        DeeLangParser.block_statement_return block_statement70 =null;


        CommonTree OR65_tree=null;
        CommonTree LCURLY66_tree=null;
        CommonTree TERMINATOR67_tree=null;
        CommonTree TERMINATOR69_tree=null;
        CommonTree TERMINATOR71_tree=null;
        CommonTree RCURLY72_tree=null;
        RewriteRuleTokenStream stream_LCURLY=new RewriteRuleTokenStream(adaptor,"token LCURLY");
        RewriteRuleTokenStream stream_TERMINATOR=new RewriteRuleTokenStream(adaptor,"token TERMINATOR");
        RewriteRuleTokenStream stream_OR=new RewriteRuleTokenStream(adaptor,"token OR");
        RewriteRuleTokenStream stream_RCURLY=new RewriteRuleTokenStream(adaptor,"token RCURLY");
        RewriteRuleSubtreeStream stream_block_statement=new RewriteRuleSubtreeStream(adaptor,"rule block_statement");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return retval; }

            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:295:3: ( OR LCURLY ( TERMINATOR )* ( block_statement ( TERMINATOR block_statement )* )? ( TERMINATOR )* RCURLY -> ^( ORBLOCK ( block_statement )* ) )
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:295:5: OR LCURLY ( TERMINATOR )* ( block_statement ( TERMINATOR block_statement )* )? ( TERMINATOR )* RCURLY
            {
            OR65=(Token)match(input,OR,FOLLOW_OR_in_orblock797); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_OR.add(OR65);


            LCURLY66=(Token)match(input,LCURLY,FOLLOW_LCURLY_in_orblock799); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LCURLY.add(LCURLY66);


            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:295:15: ( TERMINATOR )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==TERMINATOR) ) {
                    int LA23_2 = input.LA(2);

                    if ( (synpred27_DeeLang()) ) {
                        alt23=1;
                    }


                }


                switch (alt23) {
            	case 1 :
            	    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:295:15: TERMINATOR
            	    {
            	    TERMINATOR67=(Token)match(input,TERMINATOR,FOLLOW_TERMINATOR_in_orblock801); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_TERMINATOR.add(TERMINATOR67);


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);


            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:295:27: ( block_statement ( TERMINATOR block_statement )* )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==CHARACTER_LITERAL||LA25_0==DECIMAL_LITERAL||(LA25_0 >= FLOATING_POINT_LITERAL && LA25_0 <= HEX_LITERAL)||LA25_0==IDENTIFIER||LA25_0==LPAREN||(LA25_0 >= NOT && LA25_0 <= OCTAL_LITERAL)||LA25_0==STRING_LITERAL) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:295:28: block_statement ( TERMINATOR block_statement )*
                    {
                    pushFollow(FOLLOW_block_statement_in_orblock805);
                    block_statement68=block_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_block_statement.add(block_statement68.getTree());

                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:295:44: ( TERMINATOR block_statement )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==TERMINATOR) ) {
                            int LA24_1 = input.LA(2);

                            if ( (LA24_1==CHARACTER_LITERAL||LA24_1==DECIMAL_LITERAL||(LA24_1 >= FLOATING_POINT_LITERAL && LA24_1 <= HEX_LITERAL)||LA24_1==IDENTIFIER||LA24_1==LPAREN||(LA24_1 >= NOT && LA24_1 <= OCTAL_LITERAL)||LA24_1==STRING_LITERAL) ) {
                                alt24=1;
                            }


                        }


                        switch (alt24) {
                    	case 1 :
                    	    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:295:45: TERMINATOR block_statement
                    	    {
                    	    TERMINATOR69=(Token)match(input,TERMINATOR,FOLLOW_TERMINATOR_in_orblock808); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_TERMINATOR.add(TERMINATOR69);


                    	    pushFollow(FOLLOW_block_statement_in_orblock810);
                    	    block_statement70=block_statement();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_block_statement.add(block_statement70.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop24;
                        }
                    } while (true);


                    }
                    break;

            }


            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:295:76: ( TERMINATOR )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==TERMINATOR) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:295:76: TERMINATOR
            	    {
            	    TERMINATOR71=(Token)match(input,TERMINATOR,FOLLOW_TERMINATOR_in_orblock816); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_TERMINATOR.add(TERMINATOR71);


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);


            RCURLY72=(Token)match(input,RCURLY,FOLLOW_RCURLY_in_orblock819); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RCURLY.add(RCURLY72);


            // AST REWRITE
            // elements: block_statement
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 296:5: -> ^( ORBLOCK ( block_statement )* )
            {
                // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:296:8: ^( ORBLOCK ( block_statement )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ORBLOCK, "ORBLOCK")
                , root_1);

                // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:296:18: ( block_statement )*
                while ( stream_block_statement.hasNext() ) {
                    adaptor.addChild(root_1, stream_block_statement.nextTree());

                }
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
    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:300:1: fragment argument_list : LPAREN ( expr ( COMMA expr )* )? RPAREN -> ( ^( ARGS expr ( expr )* ) )? ;
    public final DeeLangParser.argument_list_return argument_list() throws RecognitionException {
        DeeLangParser.argument_list_return retval = new DeeLangParser.argument_list_return();
        retval.start = input.LT(1);

        int argument_list_StartIndex = input.index();

        CommonTree root_0 = null;

        Token LPAREN73=null;
        Token COMMA75=null;
        Token RPAREN77=null;
        DeeLangParser.expr_return expr74 =null;

        DeeLangParser.expr_return expr76 =null;


        CommonTree LPAREN73_tree=null;
        CommonTree COMMA75_tree=null;
        CommonTree RPAREN77_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return retval; }

            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:301:3: ( LPAREN ( expr ( COMMA expr )* )? RPAREN -> ( ^( ARGS expr ( expr )* ) )? )
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:301:5: LPAREN ( expr ( COMMA expr )* )? RPAREN
            {
            LPAREN73=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_argument_list847); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN73);


            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:301:12: ( expr ( COMMA expr )* )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==CHARACTER_LITERAL||LA28_0==DECIMAL_LITERAL||(LA28_0 >= FLOATING_POINT_LITERAL && LA28_0 <= HEX_LITERAL)||LA28_0==IDENTIFIER||LA28_0==LPAREN||(LA28_0 >= NOT && LA28_0 <= OCTAL_LITERAL)||LA28_0==STRING_LITERAL) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:301:13: expr ( COMMA expr )*
                    {
                    pushFollow(FOLLOW_expr_in_argument_list850);
                    expr74=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(expr74.getTree());

                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:301:18: ( COMMA expr )*
                    loop27:
                    do {
                        int alt27=2;
                        int LA27_0 = input.LA(1);

                        if ( (LA27_0==COMMA) ) {
                            alt27=1;
                        }


                        switch (alt27) {
                    	case 1 :
                    	    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:301:19: COMMA expr
                    	    {
                    	    COMMA75=(Token)match(input,COMMA,FOLLOW_COMMA_in_argument_list853); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA75);


                    	    pushFollow(FOLLOW_expr_in_argument_list855);
                    	    expr76=expr();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_expr.add(expr76.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop27;
                        }
                    } while (true);


                    }
                    break;

            }


            RPAREN77=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_argument_list861); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN77);


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
            // 301:41: -> ( ^( ARGS expr ( expr )* ) )?
            {
                // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:301:44: ( ^( ARGS expr ( expr )* ) )?
                if ( stream_expr.hasNext()||stream_expr.hasNext() ) {
                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:301:44: ^( ARGS expr ( expr )* )
                    {
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    root_1 = (CommonTree)adaptor.becomeRoot(
                    (CommonTree)adaptor.create(ARGS, "ARGS")
                    , root_1);

                    adaptor.addChild(root_1, stream_expr.nextTree());

                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:301:56: ( expr )*
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
    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:304:1: class_identifier : rec= IDENTIFIER DOT id= IDENTIFIER -> ^( FIELD_ACCESS $rec $id) ;
    public final DeeLangParser.class_identifier_return class_identifier() throws RecognitionException {
        DeeLangParser.class_identifier_return retval = new DeeLangParser.class_identifier_return();
        retval.start = input.LT(1);

        int class_identifier_StartIndex = input.index();

        CommonTree root_0 = null;

        Token rec=null;
        Token id=null;
        Token DOT78=null;

        CommonTree rec_tree=null;
        CommonTree id_tree=null;
        CommonTree DOT78_tree=null;
        RewriteRuleTokenStream stream_DOT=new RewriteRuleTokenStream(adaptor,"token DOT");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return retval; }

            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:305:3: (rec= IDENTIFIER DOT id= IDENTIFIER -> ^( FIELD_ACCESS $rec $id) )
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:305:5: rec= IDENTIFIER DOT id= IDENTIFIER
            {
            rec=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_class_identifier888); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENTIFIER.add(rec);


            DOT78=(Token)match(input,DOT,FOLLOW_DOT_in_class_identifier890); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_DOT.add(DOT78);


            id=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_class_identifier894); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENTIFIER.add(id);


            // AST REWRITE
            // elements: id, rec
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
            // 305:38: -> ^( FIELD_ACCESS $rec $id)
            {
                // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:305:41: ^( FIELD_ACCESS $rec $id)
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
    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:308:1: literal : ( DECIMAL_LITERAL | OCTAL_LITERAL | HEX_LITERAL | FLOATING_POINT_LITERAL | STRING_LITERAL | CHARACTER_LITERAL );
    public final DeeLangParser.literal_return literal() throws RecognitionException {
        DeeLangParser.literal_return retval = new DeeLangParser.literal_return();
        retval.start = input.LT(1);

        int literal_StartIndex = input.index();

        CommonTree root_0 = null;

        Token set79=null;

        CommonTree set79_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return retval; }

            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:309:3: ( DECIMAL_LITERAL | OCTAL_LITERAL | HEX_LITERAL | FLOATING_POINT_LITERAL | STRING_LITERAL | CHARACTER_LITERAL )
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            set79=(Token)input.LT(1);

            if ( input.LA(1)==CHARACTER_LITERAL||input.LA(1)==DECIMAL_LITERAL||(input.LA(1) >= FLOATING_POINT_LITERAL && input.LA(1) <= HEX_LITERAL)||input.LA(1)==OCTAL_LITERAL||input.LA(1)==STRING_LITERAL ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(set79)
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
    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:317:1: atom : ( literal | IDENTIFIER | class_identifier ( chained_call_or_field_expr )* | meth_call ( chained_call_or_field_expr )* | LPAREN ! expr RPAREN !);
    public final DeeLangParser.atom_return atom() throws RecognitionException {
        DeeLangParser.atom_return retval = new DeeLangParser.atom_return();
        retval.start = input.LT(1);

        int atom_StartIndex = input.index();

        CommonTree root_0 = null;

        Token IDENTIFIER81=null;
        Token LPAREN86=null;
        Token RPAREN88=null;
        DeeLangParser.literal_return literal80 =null;

        DeeLangParser.class_identifier_return class_identifier82 =null;

        DeeLangParser.chained_call_or_field_expr_return chained_call_or_field_expr83 =null;

        DeeLangParser.meth_call_return meth_call84 =null;

        DeeLangParser.chained_call_or_field_expr_return chained_call_or_field_expr85 =null;

        DeeLangParser.expr_return expr87 =null;


        CommonTree IDENTIFIER81_tree=null;
        CommonTree LPAREN86_tree=null;
        CommonTree RPAREN88_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 21) ) { return retval; }

            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:318:3: ( literal | IDENTIFIER | class_identifier ( chained_call_or_field_expr )* | meth_call ( chained_call_or_field_expr )* | LPAREN ! expr RPAREN !)
            int alt31=5;
            switch ( input.LA(1) ) {
            case CHARACTER_LITERAL:
            case DECIMAL_LITERAL:
            case FLOATING_POINT_LITERAL:
            case HEX_LITERAL:
            case OCTAL_LITERAL:
            case STRING_LITERAL:
                {
                int LA31_1 = input.LA(2);

                if ( (LA31_1==EOF||LA31_1==ADD||LA31_1==COMMA||LA31_1==DIV||(LA31_1 >= MOD && LA31_1 <= MUL)||(LA31_1 >= POW && LA31_1 <= RPAREN)||(LA31_1 >= SUB && LA31_1 <= TERMINATOR)) ) {
                    alt31=1;
                }
                else if ( (LA31_1==DOT) ) {
                    alt31=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 31, 1, input);

                    throw nvae;

                }
                }
                break;
            case IDENTIFIER:
                {
                switch ( input.LA(2) ) {
                case DOT:
                    {
                    int LA31_6 = input.LA(3);

                    if ( (LA31_6==IDENTIFIER) ) {
                        int LA31_8 = input.LA(4);

                        if ( (LA31_8==EOF||LA31_8==ADD||LA31_8==COMMA||(LA31_8 >= DIV && LA31_8 <= DOT)||(LA31_8 >= MOD && LA31_8 <= MUL)||(LA31_8 >= POW && LA31_8 <= RPAREN)||(LA31_8 >= SUB && LA31_8 <= TERMINATOR)) ) {
                            alt31=3;
                        }
                        else if ( (LA31_8==LPAREN) ) {
                            alt31=4;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 31, 8, input);

                            throw nvae;

                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 31, 6, input);

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
                    alt31=2;
                    }
                    break;
                case LPAREN:
                    {
                    alt31=4;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 31, 2, input);

                    throw nvae;

                }

                }
                break;
            case LPAREN:
                {
                alt31=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;

            }

            switch (alt31) {
                case 1 :
                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:318:5: literal
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_literal_in_atom962);
                    literal80=literal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, literal80.getTree());

                    }
                    break;
                case 2 :
                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:319:5: IDENTIFIER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    IDENTIFIER81=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_atom968); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER81_tree = 
                    (CommonTree)adaptor.create(IDENTIFIER81)
                    ;
                    adaptor.addChild(root_0, IDENTIFIER81_tree);
                    }

                    }
                    break;
                case 3 :
                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:320:5: class_identifier ( chained_call_or_field_expr )*
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_class_identifier_in_atom974);
                    class_identifier82=class_identifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, class_identifier82.getTree());

                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:320:22: ( chained_call_or_field_expr )*
                    loop29:
                    do {
                        int alt29=2;
                        int LA29_0 = input.LA(1);

                        if ( (LA29_0==DOT) ) {
                            alt29=1;
                        }


                        switch (alt29) {
                    	case 1 :
                    	    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:320:23: chained_call_or_field_expr
                    	    {
                    	    pushFollow(FOLLOW_chained_call_or_field_expr_in_atom977);
                    	    chained_call_or_field_expr83=chained_call_or_field_expr();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, chained_call_or_field_expr83.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop29;
                        }
                    } while (true);


                    }
                    break;
                case 4 :
                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:321:5: meth_call ( chained_call_or_field_expr )*
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_meth_call_in_atom985);
                    meth_call84=meth_call();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, meth_call84.getTree());

                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:321:15: ( chained_call_or_field_expr )*
                    loop30:
                    do {
                        int alt30=2;
                        int LA30_0 = input.LA(1);

                        if ( (LA30_0==DOT) ) {
                            alt30=1;
                        }


                        switch (alt30) {
                    	case 1 :
                    	    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:321:16: chained_call_or_field_expr
                    	    {
                    	    pushFollow(FOLLOW_chained_call_or_field_expr_in_atom988);
                    	    chained_call_or_field_expr85=chained_call_or_field_expr();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, chained_call_or_field_expr85.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop30;
                        }
                    } while (true);


                    }
                    break;
                case 5 :
                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:322:5: LPAREN ! expr RPAREN !
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    LPAREN86=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_atom996); if (state.failed) return retval;

                    pushFollow(FOLLOW_expr_in_atom999);
                    expr87=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expr87.getTree());

                    RPAREN88=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_atom1001); if (state.failed) return retval;

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
    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:325:1: terminator : ( TERMINATOR | EOF );
    public final DeeLangParser.terminator_return terminator() throws RecognitionException {
        DeeLangParser.terminator_return retval = new DeeLangParser.terminator_return();
        retval.start = input.LT(1);

        int terminator_StartIndex = input.index();

        CommonTree root_0 = null;

        Token set89=null;

        CommonTree set89_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 22) ) { return retval; }

            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:326:3: ( TERMINATOR | EOF )
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            set89=(Token)input.LT(1);

            if ( input.LA(1)==EOF||input.LA(1)==TERMINATOR ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(set89)
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

    // $ANTLR start synpred3_DeeLang
    public final void synpred3_DeeLang_fragment() throws RecognitionException {
        // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:217:5: ( assign_expr )
        // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:217:5: assign_expr
        {
        pushFollow(FOLLOW_assign_expr_in_synpred3_DeeLang232);
        assign_expr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred3_DeeLang

    // $ANTLR start synpred23_DeeLang
    public final void synpred23_DeeLang_fragment() throws RecognitionException {
        // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:289:12: ( TERMINATOR )
        // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:289:12: TERMINATOR
        {
        match(input,TERMINATOR,FOLLOW_TERMINATOR_in_synpred23_DeeLang751); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred23_DeeLang

    // $ANTLR start synpred27_DeeLang
    public final void synpred27_DeeLang_fragment() throws RecognitionException {
        // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:295:15: ( TERMINATOR )
        // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:295:15: TERMINATOR
        {
        match(input,TERMINATOR,FOLLOW_TERMINATOR_in_synpred27_DeeLang801); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred27_DeeLang

    // Delegated rules

    public final boolean synpred23_DeeLang() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred23_DeeLang_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred27_DeeLang() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred27_DeeLang_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_DeeLang() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_DeeLang_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_script_in_start_rule169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_script182 = new BitSet(new long[]{0x0000040622C04802L});
    public static final BitSet FOLLOW_EOF_in_script189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_statement203 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_terminator_in_statement205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_block_statement219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assign_expr_in_expr232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_math_expr_in_expr238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_class_identifier_in_assign_expr251 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_chained_call_or_field_expr_in_assign_expr253 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_DOT_in_assign_expr256 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_assign_expr260 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ASSIGN_in_assign_expr262 = new BitSet(new long[]{0x0000040622C04800L});
    public static final BitSet FOLLOW_expr_in_assign_expr264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_class_identifier_in_assign_expr298 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ASSIGN_in_assign_expr300 = new BitSet(new long[]{0x0000040622C04800L});
    public static final BitSet FOLLOW_expr_in_assign_expr302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_meth_call_in_assign_expr332 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_chained_call_or_field_expr_in_assign_expr334 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_DOT_in_assign_expr337 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_assign_expr341 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ASSIGN_in_assign_expr343 = new BitSet(new long[]{0x0000040622C04800L});
    public static final BitSet FOLLOW_expr_in_assign_expr345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_assign_expr377 = new BitSet(new long[]{0x0000040622C04800L});
    public static final BitSet FOLLOW_expr_in_assign_expr381 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_RPAREN_in_assign_expr383 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_chained_call_or_field_expr_in_assign_expr385 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_DOT_in_assign_expr388 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_assign_expr392 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ASSIGN_in_assign_expr394 = new BitSet(new long[]{0x0000040622C04800L});
    public static final BitSet FOLLOW_expr_in_assign_expr398 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_assign_expr434 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ASSIGN_in_assign_expr436 = new BitSet(new long[]{0x0000040622C04800L});
    public static final BitSet FOLLOW_expr_in_assign_expr438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mult_expr_in_math_expr465 = new BitSet(new long[]{0x0000080000000012L});
    public static final BitSet FOLLOW_ADD_in_math_expr469 = new BitSet(new long[]{0x0000040622C04800L});
    public static final BitSet FOLLOW_SUB_in_math_expr472 = new BitSet(new long[]{0x0000040622C04800L});
    public static final BitSet FOLLOW_mult_expr_in_math_expr476 = new BitSet(new long[]{0x0000080000000012L});
    public static final BitSet FOLLOW_pow_expr_in_mult_expr491 = new BitSet(new long[]{0x0000000180008002L});
    public static final BitSet FOLLOW_MUL_in_mult_expr495 = new BitSet(new long[]{0x0000040622C04800L});
    public static final BitSet FOLLOW_DIV_in_mult_expr499 = new BitSet(new long[]{0x0000040622C04800L});
    public static final BitSet FOLLOW_MOD_in_mult_expr503 = new BitSet(new long[]{0x0000040622C04800L});
    public static final BitSet FOLLOW_pow_expr_in_mult_expr507 = new BitSet(new long[]{0x0000000180008002L});
    public static final BitSet FOLLOW_unary_expr_in_pow_expr522 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_POW_in_pow_expr526 = new BitSet(new long[]{0x0000040622C04800L});
    public static final BitSet FOLLOW_unary_expr_in_pow_expr530 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_NOT_in_unary_expr545 = new BitSet(new long[]{0x0000040422C04800L});
    public static final BitSet FOLLOW_atom_in_unary_expr548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_meth_call567 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_DOT_in_meth_call569 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_func_call_expr_in_meth_call575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_meth_call617 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_DOT_in_meth_call619 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_func_call_expr_in_meth_call621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_chained_field_expr_in_chained_call_or_field_expr650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_chained_meth_call_expr_in_chained_call_or_field_expr656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_chained_meth_call_expr671 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_func_call_expr_in_chained_meth_call_expr673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_chained_field_expr698 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_chained_field_expr700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_func_call_expr725 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_argument_list_in_func_call_expr728 = new BitSet(new long[]{0x0000000808000002L});
    public static final BitSet FOLLOW_block_in_func_call_expr730 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_orblock_in_func_call_expr733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LCURLY_in_block749 = new BitSet(new long[]{0x0000148622C04800L});
    public static final BitSet FOLLOW_TERMINATOR_in_block751 = new BitSet(new long[]{0x0000148622C04800L});
    public static final BitSet FOLLOW_block_statement_in_block755 = new BitSet(new long[]{0x0000108000000000L});
    public static final BitSet FOLLOW_TERMINATOR_in_block758 = new BitSet(new long[]{0x0000040622C04800L});
    public static final BitSet FOLLOW_block_statement_in_block760 = new BitSet(new long[]{0x0000108000000000L});
    public static final BitSet FOLLOW_TERMINATOR_in_block766 = new BitSet(new long[]{0x0000108000000000L});
    public static final BitSet FOLLOW_RCURLY_in_block769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OR_in_orblock797 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_LCURLY_in_orblock799 = new BitSet(new long[]{0x0000148622C04800L});
    public static final BitSet FOLLOW_TERMINATOR_in_orblock801 = new BitSet(new long[]{0x0000148622C04800L});
    public static final BitSet FOLLOW_block_statement_in_orblock805 = new BitSet(new long[]{0x0000108000000000L});
    public static final BitSet FOLLOW_TERMINATOR_in_orblock808 = new BitSet(new long[]{0x0000040622C04800L});
    public static final BitSet FOLLOW_block_statement_in_orblock810 = new BitSet(new long[]{0x0000108000000000L});
    public static final BitSet FOLLOW_TERMINATOR_in_orblock816 = new BitSet(new long[]{0x0000108000000000L});
    public static final BitSet FOLLOW_RCURLY_in_orblock819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_argument_list847 = new BitSet(new long[]{0x0000050622C04800L});
    public static final BitSet FOLLOW_expr_in_argument_list850 = new BitSet(new long[]{0x0000010000001000L});
    public static final BitSet FOLLOW_COMMA_in_argument_list853 = new BitSet(new long[]{0x0000040622C04800L});
    public static final BitSet FOLLOW_expr_in_argument_list855 = new BitSet(new long[]{0x0000010000001000L});
    public static final BitSet FOLLOW_RPAREN_in_argument_list861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_class_identifier888 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_DOT_in_class_identifier890 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_class_identifier894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_atom962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_atom968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_class_identifier_in_atom974 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_chained_call_or_field_expr_in_atom977 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_meth_call_in_atom985 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_chained_call_or_field_expr_in_atom988 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_LPAREN_in_atom996 = new BitSet(new long[]{0x0000040622C04800L});
    public static final BitSet FOLLOW_expr_in_atom999 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_RPAREN_in_atom1001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assign_expr_in_synpred3_DeeLang232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TERMINATOR_in_synpred23_DeeLang751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TERMINATOR_in_synpred27_DeeLang801 = new BitSet(new long[]{0x0000000000000002L});

}