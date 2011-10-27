// $ANTLR 3.4 C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g 2011-10-27 02:55:18

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ADD", "ARGS", "ASSIGN", "ASSIGN_LOCAL", "ASSIGN_RECEIVER", "BLOCK", "CHARACTER_LITERAL", "COMMA", "COMMENT", "DECIMAL_LITERAL", "DIV", "DOT", "EscapeSequence", "Exponent", "FIELD_ACCESS", "FLOATING_POINT_LITERAL", "FloatTypeSuffix", "HEX_LITERAL", "HexDigit", "IDENTIFIER", "ID_LETTER", "IntegerTypeSuffix", "LCURLY", "LINE_COMMENT", "LPAREN", "LVALUE", "METHOD_CALL", "MOD", "MUL", "NOT", "OCTAL_LITERAL", "OR", "ORBLOCK", "OctalEscape", "POW", "RCURLY", "RPAREN", "SELF", "STRING_LITERAL", "SUB", "TERMINATOR", "UnicodeEscape", "WS"
    };

    public static final int EOF=-1;
    public static final int ADD=4;
    public static final int ARGS=5;
    public static final int ASSIGN=6;
    public static final int ASSIGN_LOCAL=7;
    public static final int ASSIGN_RECEIVER=8;
    public static final int BLOCK=9;
    public static final int CHARACTER_LITERAL=10;
    public static final int COMMA=11;
    public static final int COMMENT=12;
    public static final int DECIMAL_LITERAL=13;
    public static final int DIV=14;
    public static final int DOT=15;
    public static final int EscapeSequence=16;
    public static final int Exponent=17;
    public static final int FIELD_ACCESS=18;
    public static final int FLOATING_POINT_LITERAL=19;
    public static final int FloatTypeSuffix=20;
    public static final int HEX_LITERAL=21;
    public static final int HexDigit=22;
    public static final int IDENTIFIER=23;
    public static final int ID_LETTER=24;
    public static final int IntegerTypeSuffix=25;
    public static final int LCURLY=26;
    public static final int LINE_COMMENT=27;
    public static final int LPAREN=28;
    public static final int LVALUE=29;
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
    public static final int UnicodeEscape=45;
    public static final int WS=46;

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
        this.state.ruleMemo = new HashMap[49+1];
         

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
    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:115:1: start_rule : script ;
    public final DeeLangParser.start_rule_return start_rule() throws RecognitionException {
        DeeLangParser.start_rule_return retval = new DeeLangParser.start_rule_return();
        retval.start = input.LT(1);

        int start_rule_StartIndex = input.index();

        CommonTree root_0 = null;

        DeeLangParser.script_return script1 =null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return retval; }

            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:116:3: ( script )
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:116:7: script
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_script_in_start_rule152);
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
    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:119:1: script : ( ( statement )+ | EOF !);
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

            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:120:3: ( ( statement )+ | EOF !)
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
                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:120:7: ( statement )+
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:120:7: ( statement )+
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
                    	    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:120:7: statement
                    	    {
                    	    pushFollow(FOLLOW_statement_in_script167);
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
                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:121:7: EOF !
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    EOF3=(Token)match(input,EOF,FOLLOW_EOF_in_script176); if (state.failed) return retval;

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
    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:124:1: statement : expr terminator !;
    public final DeeLangParser.statement_return statement() throws RecognitionException {
        DeeLangParser.statement_return retval = new DeeLangParser.statement_return();
        retval.start = input.LT(1);

        int statement_StartIndex = input.index();

        CommonTree root_0 = null;

        DeeLangParser.expr_return expr4 =null;

        DeeLangParser.terminator_return terminator5 =null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return retval; }

            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:125:3: ( expr terminator !)
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:125:7: expr terminator !
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_expr_in_statement192);
            expr4=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expr4.getTree());

            pushFollow(FOLLOW_terminator_in_statement194);
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


    public static class expr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "expr"
    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:128:1: expr : ( assign_expr | math_expr );
    public final DeeLangParser.expr_return expr() throws RecognitionException {
        DeeLangParser.expr_return retval = new DeeLangParser.expr_return();
        retval.start = input.LT(1);

        int expr_StartIndex = input.index();

        CommonTree root_0 = null;

        DeeLangParser.assign_expr_return assign_expr6 =null;

        DeeLangParser.math_expr_return math_expr7 =null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return retval; }

            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:129:3: ( assign_expr | math_expr )
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
                        else if ( (LA3_5==EOF||LA3_5==ADD||LA3_5==COMMA||LA3_5==DIV||LA3_5==LPAREN||(LA3_5 >= MOD && LA3_5 <= MUL)||LA3_5==POW||LA3_5==RPAREN||(LA3_5 >= SUB && LA3_5 <= TERMINATOR)) ) {
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
                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:129:7: assign_expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_assign_expr_in_expr214);
                    assign_expr6=assign_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, assign_expr6.getTree());

                    }
                    break;
                case 2 :
                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:130:7: math_expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_math_expr_in_expr222);
                    math_expr7=math_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, math_expr7.getTree());

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
            if ( state.backtracking>0 ) { memoize(input, 4, expr_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "expr"


    public static class assign_expr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "assign_expr"
    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:133:1: assign_expr : (rec= IDENTIFIER DOT )? id= IDENTIFIER ASSIGN expr -> {explicitReceiver}? ^( ASSIGN ASSIGN_RECEIVER[$rec.getText()] LVALUE[$id.getText()] expr ) -> ^( ASSIGN ASSIGN_LOCAL LVALUE[$id.getText()] expr ) ;
    public final DeeLangParser.assign_expr_return assign_expr() throws RecognitionException {
        DeeLangParser.assign_expr_return retval = new DeeLangParser.assign_expr_return();
        retval.start = input.LT(1);

        int assign_expr_StartIndex = input.index();

        CommonTree root_0 = null;

        Token rec=null;
        Token id=null;
        Token DOT8=null;
        Token ASSIGN9=null;
        DeeLangParser.expr_return expr10 =null;


        CommonTree rec_tree=null;
        CommonTree id_tree=null;
        CommonTree DOT8_tree=null;
        CommonTree ASSIGN9_tree=null;
        RewriteRuleTokenStream stream_DOT=new RewriteRuleTokenStream(adaptor,"token DOT");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");
        RewriteRuleTokenStream stream_ASSIGN=new RewriteRuleTokenStream(adaptor,"token ASSIGN");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        boolean explicitReceiver=false;
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return retval; }

            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:135:3: ( (rec= IDENTIFIER DOT )? id= IDENTIFIER ASSIGN expr -> {explicitReceiver}? ^( ASSIGN ASSIGN_RECEIVER[$rec.getText()] LVALUE[$id.getText()] expr ) -> ^( ASSIGN ASSIGN_LOCAL LVALUE[$id.getText()] expr ) )
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:135:7: (rec= IDENTIFIER DOT )? id= IDENTIFIER ASSIGN expr
            {
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:135:7: (rec= IDENTIFIER DOT )?
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
                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:135:8: rec= IDENTIFIER DOT
                    {
                    rec=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_assign_expr247); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENTIFIER.add(rec);


                    DOT8=(Token)match(input,DOT,FOLLOW_DOT_in_assign_expr249); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DOT.add(DOT8);


                    if ( state.backtracking==0 ) {explicitReceiver=true;}

                    }
                    break;

            }


            id=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_assign_expr257); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENTIFIER.add(id);


            ASSIGN9=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_assign_expr259); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ASSIGN.add(ASSIGN9);


            pushFollow(FOLLOW_expr_in_assign_expr261);
            expr10=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_expr.add(expr10.getTree());

            // AST REWRITE
            // elements: expr, expr, ASSIGN, ASSIGN
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 135:80: -> {explicitReceiver}? ^( ASSIGN ASSIGN_RECEIVER[$rec.getText()] LVALUE[$id.getText()] expr )
            if (explicitReceiver) {
                // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:135:103: ^( ASSIGN ASSIGN_RECEIVER[$rec.getText()] LVALUE[$id.getText()] expr )
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

            else // 135:172: -> ^( ASSIGN ASSIGN_LOCAL LVALUE[$id.getText()] expr )
            {
                // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:135:175: ^( ASSIGN ASSIGN_LOCAL LVALUE[$id.getText()] expr )
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
            if ( state.backtracking>0 ) { memoize(input, 5, assign_expr_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "assign_expr"


    public static class math_expr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "math_expr"
    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:138:1: math_expr : mult_expr ( ( ADD ^| SUB ^) mult_expr )* ;
    public final DeeLangParser.math_expr_return math_expr() throws RecognitionException {
        DeeLangParser.math_expr_return retval = new DeeLangParser.math_expr_return();
        retval.start = input.LT(1);

        int math_expr_StartIndex = input.index();

        CommonTree root_0 = null;

        Token ADD12=null;
        Token SUB13=null;
        DeeLangParser.mult_expr_return mult_expr11 =null;

        DeeLangParser.mult_expr_return mult_expr14 =null;


        CommonTree ADD12_tree=null;
        CommonTree SUB13_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return retval; }

            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:139:3: ( mult_expr ( ( ADD ^| SUB ^) mult_expr )* )
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:139:7: mult_expr ( ( ADD ^| SUB ^) mult_expr )*
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_mult_expr_in_math_expr305);
            mult_expr11=mult_expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, mult_expr11.getTree());

            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:139:17: ( ( ADD ^| SUB ^) mult_expr )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==ADD||LA6_0==SUB) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:139:18: ( ADD ^| SUB ^) mult_expr
            	    {
            	    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:139:18: ( ADD ^| SUB ^)
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
            	            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:139:19: ADD ^
            	            {
            	            ADD12=(Token)match(input,ADD,FOLLOW_ADD_in_math_expr309); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            ADD12_tree = 
            	            (CommonTree)adaptor.create(ADD12)
            	            ;
            	            root_0 = (CommonTree)adaptor.becomeRoot(ADD12_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:139:24: SUB ^
            	            {
            	            SUB13=(Token)match(input,SUB,FOLLOW_SUB_in_math_expr312); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            SUB13_tree = 
            	            (CommonTree)adaptor.create(SUB13)
            	            ;
            	            root_0 = (CommonTree)adaptor.becomeRoot(SUB13_tree, root_0);
            	            }

            	            }
            	            break;

            	    }


            	    pushFollow(FOLLOW_mult_expr_in_math_expr316);
            	    mult_expr14=mult_expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, mult_expr14.getTree());

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
            if ( state.backtracking>0 ) { memoize(input, 6, math_expr_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "math_expr"


    public static class mult_expr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "mult_expr"
    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:142:1: mult_expr : pow_expr ( ( MUL ^| DIV ^| MOD ^) pow_expr )* ;
    public final DeeLangParser.mult_expr_return mult_expr() throws RecognitionException {
        DeeLangParser.mult_expr_return retval = new DeeLangParser.mult_expr_return();
        retval.start = input.LT(1);

        int mult_expr_StartIndex = input.index();

        CommonTree root_0 = null;

        Token MUL16=null;
        Token DIV17=null;
        Token MOD18=null;
        DeeLangParser.pow_expr_return pow_expr15 =null;

        DeeLangParser.pow_expr_return pow_expr19 =null;


        CommonTree MUL16_tree=null;
        CommonTree DIV17_tree=null;
        CommonTree MOD18_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return retval; }

            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:143:3: ( pow_expr ( ( MUL ^| DIV ^| MOD ^) pow_expr )* )
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:143:7: pow_expr ( ( MUL ^| DIV ^| MOD ^) pow_expr )*
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_pow_expr_in_mult_expr334);
            pow_expr15=pow_expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, pow_expr15.getTree());

            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:143:16: ( ( MUL ^| DIV ^| MOD ^) pow_expr )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==DIV||(LA8_0 >= MOD && LA8_0 <= MUL)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:143:17: ( MUL ^| DIV ^| MOD ^) pow_expr
            	    {
            	    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:143:17: ( MUL ^| DIV ^| MOD ^)
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
            	            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:143:18: MUL ^
            	            {
            	            MUL16=(Token)match(input,MUL,FOLLOW_MUL_in_mult_expr338); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            MUL16_tree = 
            	            (CommonTree)adaptor.create(MUL16)
            	            ;
            	            root_0 = (CommonTree)adaptor.becomeRoot(MUL16_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:143:23: DIV ^
            	            {
            	            DIV17=(Token)match(input,DIV,FOLLOW_DIV_in_mult_expr341); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            DIV17_tree = 
            	            (CommonTree)adaptor.create(DIV17)
            	            ;
            	            root_0 = (CommonTree)adaptor.becomeRoot(DIV17_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:143:28: MOD ^
            	            {
            	            MOD18=(Token)match(input,MOD,FOLLOW_MOD_in_mult_expr344); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            MOD18_tree = 
            	            (CommonTree)adaptor.create(MOD18)
            	            ;
            	            root_0 = (CommonTree)adaptor.becomeRoot(MOD18_tree, root_0);
            	            }

            	            }
            	            break;

            	    }


            	    pushFollow(FOLLOW_pow_expr_in_mult_expr348);
            	    pow_expr19=pow_expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, pow_expr19.getTree());

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
            if ( state.backtracking>0 ) { memoize(input, 7, mult_expr_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "mult_expr"


    public static class pow_expr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "pow_expr"
    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:146:1: pow_expr : unary_expr ( ( POW ^) unary_expr )* ;
    public final DeeLangParser.pow_expr_return pow_expr() throws RecognitionException {
        DeeLangParser.pow_expr_return retval = new DeeLangParser.pow_expr_return();
        retval.start = input.LT(1);

        int pow_expr_StartIndex = input.index();

        CommonTree root_0 = null;

        Token POW21=null;
        DeeLangParser.unary_expr_return unary_expr20 =null;

        DeeLangParser.unary_expr_return unary_expr22 =null;


        CommonTree POW21_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return retval; }

            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:147:3: ( unary_expr ( ( POW ^) unary_expr )* )
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:147:7: unary_expr ( ( POW ^) unary_expr )*
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_unary_expr_in_pow_expr370);
            unary_expr20=unary_expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, unary_expr20.getTree());

            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:147:18: ( ( POW ^) unary_expr )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==POW) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:147:19: ( POW ^) unary_expr
            	    {
            	    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:147:19: ( POW ^)
            	    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:147:20: POW ^
            	    {
            	    POW21=(Token)match(input,POW,FOLLOW_POW_in_pow_expr374); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    POW21_tree = 
            	    (CommonTree)adaptor.create(POW21)
            	    ;
            	    root_0 = (CommonTree)adaptor.becomeRoot(POW21_tree, root_0);
            	    }

            	    }


            	    pushFollow(FOLLOW_unary_expr_in_pow_expr378);
            	    unary_expr22=unary_expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, unary_expr22.getTree());

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
            if ( state.backtracking>0 ) { memoize(input, 8, pow_expr_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "pow_expr"


    public static class unary_expr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "unary_expr"
    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:150:1: unary_expr : ( NOT )? atom ;
    public final DeeLangParser.unary_expr_return unary_expr() throws RecognitionException {
        DeeLangParser.unary_expr_return retval = new DeeLangParser.unary_expr_return();
        retval.start = input.LT(1);

        int unary_expr_StartIndex = input.index();

        CommonTree root_0 = null;

        Token NOT23=null;
        DeeLangParser.atom_return atom24 =null;


        CommonTree NOT23_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return retval; }

            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:151:3: ( ( NOT )? atom )
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:151:7: ( NOT )? atom
            {
            root_0 = (CommonTree)adaptor.nil();


            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:151:7: ( NOT )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==NOT) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:151:7: NOT
                    {
                    NOT23=(Token)match(input,NOT,FOLLOW_NOT_in_unary_expr397); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NOT23_tree = 
                    (CommonTree)adaptor.create(NOT23)
                    ;
                    adaptor.addChild(root_0, NOT23_tree);
                    }

                    }
                    break;

            }


            pushFollow(FOLLOW_atom_in_unary_expr400);
            atom24=atom();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, atom24.getTree());

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
            if ( state.backtracking>0 ) { memoize(input, 9, unary_expr_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "unary_expr"


    public static class meth_call_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "meth_call"
    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:154:1: meth_call : ( ( IDENTIFIER DOT )? func_call_expr -> {explicitReceiver}? ^( METHOD_CALL IDENTIFIER func_call_expr ) -> ^( METHOD_CALL SELF func_call_expr ) | literal DOT func_call_expr -> ^( METHOD_CALL literal func_call_expr ) );
    public final DeeLangParser.meth_call_return meth_call() throws RecognitionException {
        DeeLangParser.meth_call_return retval = new DeeLangParser.meth_call_return();
        retval.start = input.LT(1);

        int meth_call_StartIndex = input.index();

        CommonTree root_0 = null;

        Token IDENTIFIER25=null;
        Token DOT26=null;
        Token DOT29=null;
        DeeLangParser.func_call_expr_return func_call_expr27 =null;

        DeeLangParser.literal_return literal28 =null;

        DeeLangParser.func_call_expr_return func_call_expr30 =null;


        CommonTree IDENTIFIER25_tree=null;
        CommonTree DOT26_tree=null;
        CommonTree DOT29_tree=null;
        RewriteRuleTokenStream stream_DOT=new RewriteRuleTokenStream(adaptor,"token DOT");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");
        RewriteRuleSubtreeStream stream_func_call_expr=new RewriteRuleSubtreeStream(adaptor,"rule func_call_expr");
        RewriteRuleSubtreeStream stream_literal=new RewriteRuleSubtreeStream(adaptor,"rule literal");
        boolean explicitReceiver=false;
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return retval; }

            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:156:3: ( ( IDENTIFIER DOT )? func_call_expr -> {explicitReceiver}? ^( METHOD_CALL IDENTIFIER func_call_expr ) -> ^( METHOD_CALL SELF func_call_expr ) | literal DOT func_call_expr -> ^( METHOD_CALL literal func_call_expr ) )
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
                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:156:7: ( IDENTIFIER DOT )? func_call_expr
                    {
                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:156:7: ( IDENTIFIER DOT )?
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
                            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:156:8: IDENTIFIER DOT
                            {
                            IDENTIFIER25=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_meth_call421); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_IDENTIFIER.add(IDENTIFIER25);


                            DOT26=(Token)match(input,DOT,FOLLOW_DOT_in_meth_call423); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_DOT.add(DOT26);


                            if ( state.backtracking==0 ) {explicitReceiver=true;}

                            }
                            break;

                    }


                    pushFollow(FOLLOW_func_call_expr_in_meth_call429);
                    func_call_expr27=func_call_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_func_call_expr.add(func_call_expr27.getTree());

                    // AST REWRITE
                    // elements: func_call_expr, func_call_expr, IDENTIFIER
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 156:65: -> {explicitReceiver}? ^( METHOD_CALL IDENTIFIER func_call_expr )
                    if (explicitReceiver) {
                        // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:156:88: ^( METHOD_CALL IDENTIFIER func_call_expr )
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

                    else // 156:129: -> ^( METHOD_CALL SELF func_call_expr )
                    {
                        // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:156:132: ^( METHOD_CALL SELF func_call_expr )
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
                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:157:7: literal DOT func_call_expr
                    {
                    pushFollow(FOLLOW_literal_in_meth_call460);
                    literal28=literal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_literal.add(literal28.getTree());

                    DOT29=(Token)match(input,DOT,FOLLOW_DOT_in_meth_call462); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DOT.add(DOT29);


                    pushFollow(FOLLOW_func_call_expr_in_meth_call464);
                    func_call_expr30=func_call_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_func_call_expr.add(func_call_expr30.getTree());

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
                    // 157:34: -> ^( METHOD_CALL literal func_call_expr )
                    {
                        // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:157:37: ^( METHOD_CALL literal func_call_expr )
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
            if ( state.backtracking>0 ) { memoize(input, 10, meth_call_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "meth_call"


    public static class func_call_expr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "func_call_expr"
    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:161:1: fragment func_call_expr : IDENTIFIER ^ argument_list ( block )? ( orblock )? ;
    public final DeeLangParser.func_call_expr_return func_call_expr() throws RecognitionException {
        DeeLangParser.func_call_expr_return retval = new DeeLangParser.func_call_expr_return();
        retval.start = input.LT(1);

        int func_call_expr_StartIndex = input.index();

        CommonTree root_0 = null;

        Token IDENTIFIER31=null;
        DeeLangParser.argument_list_return argument_list32 =null;

        DeeLangParser.block_return block33 =null;

        DeeLangParser.orblock_return orblock34 =null;


        CommonTree IDENTIFIER31_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return retval; }

            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:162:3: ( IDENTIFIER ^ argument_list ( block )? ( orblock )? )
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:162:7: IDENTIFIER ^ argument_list ( block )? ( orblock )?
            {
            root_0 = (CommonTree)adaptor.nil();


            IDENTIFIER31=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_func_call_expr492); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER31_tree = 
            (CommonTree)adaptor.create(IDENTIFIER31)
            ;
            root_0 = (CommonTree)adaptor.becomeRoot(IDENTIFIER31_tree, root_0);
            }

            pushFollow(FOLLOW_argument_list_in_func_call_expr495);
            argument_list32=argument_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, argument_list32.getTree());

            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:162:33: ( block )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==LCURLY) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:162:33: block
                    {
                    pushFollow(FOLLOW_block_in_func_call_expr497);
                    block33=block();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, block33.getTree());

                    }
                    break;

            }


            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:162:40: ( orblock )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==OR) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:162:40: orblock
                    {
                    pushFollow(FOLLOW_orblock_in_func_call_expr500);
                    orblock34=orblock();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, orblock34.getTree());

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
            if ( state.backtracking>0 ) { memoize(input, 11, func_call_expr_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "func_call_expr"


    public static class block_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "block"
    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:166:1: fragment block : LCURLY ( TERMINATOR )? ( statement )* RCURLY -> ^( BLOCK ( statement )* ) ;
    public final DeeLangParser.block_return block() throws RecognitionException {
        DeeLangParser.block_return retval = new DeeLangParser.block_return();
        retval.start = input.LT(1);

        int block_StartIndex = input.index();

        CommonTree root_0 = null;

        Token LCURLY35=null;
        Token TERMINATOR36=null;
        Token RCURLY38=null;
        DeeLangParser.statement_return statement37 =null;


        CommonTree LCURLY35_tree=null;
        CommonTree TERMINATOR36_tree=null;
        CommonTree RCURLY38_tree=null;
        RewriteRuleTokenStream stream_LCURLY=new RewriteRuleTokenStream(adaptor,"token LCURLY");
        RewriteRuleTokenStream stream_TERMINATOR=new RewriteRuleTokenStream(adaptor,"token TERMINATOR");
        RewriteRuleTokenStream stream_RCURLY=new RewriteRuleTokenStream(adaptor,"token RCURLY");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return retval; }

            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:167:3: ( LCURLY ( TERMINATOR )? ( statement )* RCURLY -> ^( BLOCK ( statement )* ) )
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:167:7: LCURLY ( TERMINATOR )? ( statement )* RCURLY
            {
            LCURLY35=(Token)match(input,LCURLY,FOLLOW_LCURLY_in_block527); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LCURLY.add(LCURLY35);


            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:167:14: ( TERMINATOR )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==TERMINATOR) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:167:14: TERMINATOR
                    {
                    TERMINATOR36=(Token)match(input,TERMINATOR,FOLLOW_TERMINATOR_in_block529); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_TERMINATOR.add(TERMINATOR36);


                    }
                    break;

            }


            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:167:26: ( statement )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==CHARACTER_LITERAL||LA16_0==DECIMAL_LITERAL||LA16_0==FLOATING_POINT_LITERAL||LA16_0==HEX_LITERAL||LA16_0==IDENTIFIER||LA16_0==LPAREN||(LA16_0 >= NOT && LA16_0 <= OCTAL_LITERAL)||LA16_0==STRING_LITERAL) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:167:26: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_block532);
            	    statement37=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_statement.add(statement37.getTree());

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);


            RCURLY38=(Token)match(input,RCURLY,FOLLOW_RCURLY_in_block535); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RCURLY.add(RCURLY38);


            // AST REWRITE
            // elements: statement
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 167:44: -> ^( BLOCK ( statement )* )
            {
                // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:167:47: ^( BLOCK ( statement )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(BLOCK, "BLOCK")
                , root_1);

                // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:167:55: ( statement )*
                while ( stream_statement.hasNext() ) {
                    adaptor.addChild(root_1, stream_statement.nextTree());

                }
                stream_statement.reset();

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
            if ( state.backtracking>0 ) { memoize(input, 12, block_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "block"


    public static class orblock_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "orblock"
    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:171:1: fragment orblock : OR LCURLY ( TERMINATOR )? ( statement )* RCURLY -> ^( ORBLOCK ( statement )* ) ;
    public final DeeLangParser.orblock_return orblock() throws RecognitionException {
        DeeLangParser.orblock_return retval = new DeeLangParser.orblock_return();
        retval.start = input.LT(1);

        int orblock_StartIndex = input.index();

        CommonTree root_0 = null;

        Token OR39=null;
        Token LCURLY40=null;
        Token TERMINATOR41=null;
        Token RCURLY43=null;
        DeeLangParser.statement_return statement42 =null;


        CommonTree OR39_tree=null;
        CommonTree LCURLY40_tree=null;
        CommonTree TERMINATOR41_tree=null;
        CommonTree RCURLY43_tree=null;
        RewriteRuleTokenStream stream_LCURLY=new RewriteRuleTokenStream(adaptor,"token LCURLY");
        RewriteRuleTokenStream stream_TERMINATOR=new RewriteRuleTokenStream(adaptor,"token TERMINATOR");
        RewriteRuleTokenStream stream_OR=new RewriteRuleTokenStream(adaptor,"token OR");
        RewriteRuleTokenStream stream_RCURLY=new RewriteRuleTokenStream(adaptor,"token RCURLY");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return retval; }

            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:172:3: ( OR LCURLY ( TERMINATOR )? ( statement )* RCURLY -> ^( ORBLOCK ( statement )* ) )
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:172:7: OR LCURLY ( TERMINATOR )? ( statement )* RCURLY
            {
            OR39=(Token)match(input,OR,FOLLOW_OR_in_orblock563); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_OR.add(OR39);


            LCURLY40=(Token)match(input,LCURLY,FOLLOW_LCURLY_in_orblock565); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LCURLY.add(LCURLY40);


            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:172:17: ( TERMINATOR )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==TERMINATOR) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:172:17: TERMINATOR
                    {
                    TERMINATOR41=(Token)match(input,TERMINATOR,FOLLOW_TERMINATOR_in_orblock567); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_TERMINATOR.add(TERMINATOR41);


                    }
                    break;

            }


            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:172:29: ( statement )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==CHARACTER_LITERAL||LA18_0==DECIMAL_LITERAL||LA18_0==FLOATING_POINT_LITERAL||LA18_0==HEX_LITERAL||LA18_0==IDENTIFIER||LA18_0==LPAREN||(LA18_0 >= NOT && LA18_0 <= OCTAL_LITERAL)||LA18_0==STRING_LITERAL) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:172:29: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_orblock570);
            	    statement42=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_statement.add(statement42.getTree());

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);


            RCURLY43=(Token)match(input,RCURLY,FOLLOW_RCURLY_in_orblock573); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RCURLY.add(RCURLY43);


            // AST REWRITE
            // elements: statement
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 172:47: -> ^( ORBLOCK ( statement )* )
            {
                // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:172:50: ^( ORBLOCK ( statement )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ORBLOCK, "ORBLOCK")
                , root_1);

                // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:172:60: ( statement )*
                while ( stream_statement.hasNext() ) {
                    adaptor.addChild(root_1, stream_statement.nextTree());

                }
                stream_statement.reset();

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
            if ( state.backtracking>0 ) { memoize(input, 13, orblock_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "orblock"


    public static class argument_list_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "argument_list"
    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:176:1: fragment argument_list : LPAREN ( expr ( COMMA expr )* )? RPAREN -> ( ^( ARGS expr ( expr )* ) )? ;
    public final DeeLangParser.argument_list_return argument_list() throws RecognitionException {
        DeeLangParser.argument_list_return retval = new DeeLangParser.argument_list_return();
        retval.start = input.LT(1);

        int argument_list_StartIndex = input.index();

        CommonTree root_0 = null;

        Token LPAREN44=null;
        Token COMMA46=null;
        Token RPAREN48=null;
        DeeLangParser.expr_return expr45 =null;

        DeeLangParser.expr_return expr47 =null;


        CommonTree LPAREN44_tree=null;
        CommonTree COMMA46_tree=null;
        CommonTree RPAREN48_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return retval; }

            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:177:3: ( LPAREN ( expr ( COMMA expr )* )? RPAREN -> ( ^( ARGS expr ( expr )* ) )? )
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:177:7: LPAREN ( expr ( COMMA expr )* )? RPAREN
            {
            LPAREN44=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_argument_list601); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN44);


            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:177:14: ( expr ( COMMA expr )* )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==CHARACTER_LITERAL||LA20_0==DECIMAL_LITERAL||LA20_0==FLOATING_POINT_LITERAL||LA20_0==HEX_LITERAL||LA20_0==IDENTIFIER||LA20_0==LPAREN||(LA20_0 >= NOT && LA20_0 <= OCTAL_LITERAL)||LA20_0==STRING_LITERAL) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:177:15: expr ( COMMA expr )*
                    {
                    pushFollow(FOLLOW_expr_in_argument_list604);
                    expr45=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(expr45.getTree());

                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:177:20: ( COMMA expr )*
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==COMMA) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:177:21: COMMA expr
                    	    {
                    	    COMMA46=(Token)match(input,COMMA,FOLLOW_COMMA_in_argument_list607); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA46);


                    	    pushFollow(FOLLOW_expr_in_argument_list609);
                    	    expr47=expr();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_expr.add(expr47.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop19;
                        }
                    } while (true);


                    }
                    break;

            }


            RPAREN48=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_argument_list615); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN48);


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
            // 177:43: -> ( ^( ARGS expr ( expr )* ) )?
            {
                // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:177:46: ( ^( ARGS expr ( expr )* ) )?
                if ( stream_expr.hasNext()||stream_expr.hasNext() ) {
                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:177:46: ^( ARGS expr ( expr )* )
                    {
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    root_1 = (CommonTree)adaptor.becomeRoot(
                    (CommonTree)adaptor.create(ARGS, "ARGS")
                    , root_1);

                    adaptor.addChild(root_1, stream_expr.nextTree());

                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:177:58: ( expr )*
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
            if ( state.backtracking>0 ) { memoize(input, 14, argument_list_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "argument_list"


    public static class class_identifier_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "class_identifier"
    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:180:1: class_identifier : rec= IDENTIFIER DOT id= IDENTIFIER -> ^( FIELD_ACCESS $rec $id) ;
    public final DeeLangParser.class_identifier_return class_identifier() throws RecognitionException {
        DeeLangParser.class_identifier_return retval = new DeeLangParser.class_identifier_return();
        retval.start = input.LT(1);

        int class_identifier_StartIndex = input.index();

        CommonTree root_0 = null;

        Token rec=null;
        Token id=null;
        Token DOT49=null;

        CommonTree rec_tree=null;
        CommonTree id_tree=null;
        CommonTree DOT49_tree=null;
        RewriteRuleTokenStream stream_DOT=new RewriteRuleTokenStream(adaptor,"token DOT");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return retval; }

            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:181:3: (rec= IDENTIFIER DOT id= IDENTIFIER -> ^( FIELD_ACCESS $rec $id) )
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:181:9: rec= IDENTIFIER DOT id= IDENTIFIER
            {
            rec=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_class_identifier648); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENTIFIER.add(rec);


            DOT49=(Token)match(input,DOT,FOLLOW_DOT_in_class_identifier650); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_DOT.add(DOT49);


            id=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_class_identifier654); if (state.failed) return retval; 
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
            // 181:42: -> ^( FIELD_ACCESS $rec $id)
            {
                // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:181:45: ^( FIELD_ACCESS $rec $id)
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
            if ( state.backtracking>0 ) { memoize(input, 15, class_identifier_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "class_identifier"


    public static class literal_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "literal"
    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:184:1: literal : ( DECIMAL_LITERAL | OCTAL_LITERAL | HEX_LITERAL | FLOATING_POINT_LITERAL | STRING_LITERAL | CHARACTER_LITERAL );
    public final DeeLangParser.literal_return literal() throws RecognitionException {
        DeeLangParser.literal_return retval = new DeeLangParser.literal_return();
        retval.start = input.LT(1);

        int literal_StartIndex = input.index();

        CommonTree root_0 = null;

        Token set50=null;

        CommonTree set50_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return retval; }

            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:185:3: ( DECIMAL_LITERAL | OCTAL_LITERAL | HEX_LITERAL | FLOATING_POINT_LITERAL | STRING_LITERAL | CHARACTER_LITERAL )
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            set50=(Token)input.LT(1);

            if ( input.LA(1)==CHARACTER_LITERAL||input.LA(1)==DECIMAL_LITERAL||input.LA(1)==FLOATING_POINT_LITERAL||input.LA(1)==HEX_LITERAL||input.LA(1)==OCTAL_LITERAL||input.LA(1)==STRING_LITERAL ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(set50)
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
            if ( state.backtracking>0 ) { memoize(input, 16, literal_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "literal"


    public static class atom_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "atom"
    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:194:1: atom : ( literal | meth_call | IDENTIFIER | class_identifier | LPAREN ! expr RPAREN !);
    public final DeeLangParser.atom_return atom() throws RecognitionException {
        DeeLangParser.atom_return retval = new DeeLangParser.atom_return();
        retval.start = input.LT(1);

        int atom_StartIndex = input.index();

        CommonTree root_0 = null;

        Token IDENTIFIER53=null;
        Token LPAREN55=null;
        Token RPAREN57=null;
        DeeLangParser.literal_return literal51 =null;

        DeeLangParser.meth_call_return meth_call52 =null;

        DeeLangParser.class_identifier_return class_identifier54 =null;

        DeeLangParser.expr_return expr56 =null;


        CommonTree IDENTIFIER53_tree=null;
        CommonTree LPAREN55_tree=null;
        CommonTree RPAREN57_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return retval; }

            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:195:3: ( literal | meth_call | IDENTIFIER | class_identifier | LPAREN ! expr RPAREN !)
            int alt21=5;
            switch ( input.LA(1) ) {
            case CHARACTER_LITERAL:
            case DECIMAL_LITERAL:
            case FLOATING_POINT_LITERAL:
            case HEX_LITERAL:
            case OCTAL_LITERAL:
            case STRING_LITERAL:
                {
                int LA21_1 = input.LA(2);

                if ( (LA21_1==EOF||LA21_1==ADD||LA21_1==COMMA||LA21_1==DIV||(LA21_1 >= MOD && LA21_1 <= MUL)||LA21_1==POW||LA21_1==RPAREN||(LA21_1 >= SUB && LA21_1 <= TERMINATOR)) ) {
                    alt21=1;
                }
                else if ( (LA21_1==DOT) ) {
                    alt21=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 21, 1, input);

                    throw nvae;

                }
                }
                break;
            case IDENTIFIER:
                {
                switch ( input.LA(2) ) {
                case DOT:
                    {
                    int LA21_6 = input.LA(3);

                    if ( (LA21_6==IDENTIFIER) ) {
                        int LA21_8 = input.LA(4);

                        if ( (LA21_8==EOF||LA21_8==ADD||LA21_8==COMMA||LA21_8==DIV||(LA21_8 >= MOD && LA21_8 <= MUL)||LA21_8==POW||LA21_8==RPAREN||(LA21_8 >= SUB && LA21_8 <= TERMINATOR)) ) {
                            alt21=4;
                        }
                        else if ( (LA21_8==LPAREN) ) {
                            alt21=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 21, 8, input);

                            throw nvae;

                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 21, 6, input);

                        throw nvae;

                    }
                    }
                    break;
                case LPAREN:
                    {
                    alt21=2;
                    }
                    break;
                case EOF:
                case ADD:
                case COMMA:
                case DIV:
                case MOD:
                case MUL:
                case POW:
                case RPAREN:
                case SUB:
                case TERMINATOR:
                    {
                    alt21=3;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 21, 2, input);

                    throw nvae;

                }

                }
                break;
            case LPAREN:
                {
                alt21=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;

            }

            switch (alt21) {
                case 1 :
                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:195:9: literal
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_literal_in_atom753);
                    literal51=literal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, literal51.getTree());

                    }
                    break;
                case 2 :
                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:196:9: meth_call
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_meth_call_in_atom763);
                    meth_call52=meth_call();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, meth_call52.getTree());

                    }
                    break;
                case 3 :
                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:197:9: IDENTIFIER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    IDENTIFIER53=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_atom773); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER53_tree = 
                    (CommonTree)adaptor.create(IDENTIFIER53)
                    ;
                    adaptor.addChild(root_0, IDENTIFIER53_tree);
                    }

                    }
                    break;
                case 4 :
                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:198:9: class_identifier
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_class_identifier_in_atom783);
                    class_identifier54=class_identifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, class_identifier54.getTree());

                    }
                    break;
                case 5 :
                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:199:9: LPAREN ! expr RPAREN !
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    LPAREN55=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_atom793); if (state.failed) return retval;

                    pushFollow(FOLLOW_expr_in_atom796);
                    expr56=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expr56.getTree());

                    RPAREN57=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_atom798); if (state.failed) return retval;

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
            if ( state.backtracking>0 ) { memoize(input, 17, atom_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "atom"


    public static class terminator_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "terminator"
    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:202:1: terminator : ( TERMINATOR | EOF );
    public final DeeLangParser.terminator_return terminator() throws RecognitionException {
        DeeLangParser.terminator_return retval = new DeeLangParser.terminator_return();
        retval.start = input.LT(1);

        int terminator_StartIndex = input.index();

        CommonTree root_0 = null;

        Token set58=null;

        CommonTree set58_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return retval; }

            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:203:3: ( TERMINATOR | EOF )
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            set58=(Token)input.LT(1);

            if ( input.LA(1)==EOF||input.LA(1)==TERMINATOR ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(set58)
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
            if ( state.backtracking>0 ) { memoize(input, 18, terminator_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "terminator"

    // Delegated rules


 

    public static final BitSet FOLLOW_script_in_start_rule152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_script167 = new BitSet(new long[]{0x0000040610A82402L});
    public static final BitSet FOLLOW_EOF_in_script176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_statement192 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_terminator_in_statement194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assign_expr_in_expr214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_math_expr_in_expr222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_assign_expr247 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_DOT_in_assign_expr249 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_assign_expr257 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ASSIGN_in_assign_expr259 = new BitSet(new long[]{0x0000040610A82400L});
    public static final BitSet FOLLOW_expr_in_assign_expr261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mult_expr_in_math_expr305 = new BitSet(new long[]{0x0000080000000012L});
    public static final BitSet FOLLOW_ADD_in_math_expr309 = new BitSet(new long[]{0x0000040610A82400L});
    public static final BitSet FOLLOW_SUB_in_math_expr312 = new BitSet(new long[]{0x0000040610A82400L});
    public static final BitSet FOLLOW_mult_expr_in_math_expr316 = new BitSet(new long[]{0x0000080000000012L});
    public static final BitSet FOLLOW_pow_expr_in_mult_expr334 = new BitSet(new long[]{0x0000000180004002L});
    public static final BitSet FOLLOW_MUL_in_mult_expr338 = new BitSet(new long[]{0x0000040610A82400L});
    public static final BitSet FOLLOW_DIV_in_mult_expr341 = new BitSet(new long[]{0x0000040610A82400L});
    public static final BitSet FOLLOW_MOD_in_mult_expr344 = new BitSet(new long[]{0x0000040610A82400L});
    public static final BitSet FOLLOW_pow_expr_in_mult_expr348 = new BitSet(new long[]{0x0000000180004002L});
    public static final BitSet FOLLOW_unary_expr_in_pow_expr370 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_POW_in_pow_expr374 = new BitSet(new long[]{0x0000040610A82400L});
    public static final BitSet FOLLOW_unary_expr_in_pow_expr378 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_NOT_in_unary_expr397 = new BitSet(new long[]{0x0000040410A82400L});
    public static final BitSet FOLLOW_atom_in_unary_expr400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_meth_call421 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_DOT_in_meth_call423 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_func_call_expr_in_meth_call429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_meth_call460 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_DOT_in_meth_call462 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_func_call_expr_in_meth_call464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_func_call_expr492 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_argument_list_in_func_call_expr495 = new BitSet(new long[]{0x0000000804000002L});
    public static final BitSet FOLLOW_block_in_func_call_expr497 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_orblock_in_func_call_expr500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LCURLY_in_block527 = new BitSet(new long[]{0x0000148610A82400L});
    public static final BitSet FOLLOW_TERMINATOR_in_block529 = new BitSet(new long[]{0x0000048610A82400L});
    public static final BitSet FOLLOW_statement_in_block532 = new BitSet(new long[]{0x0000048610A82400L});
    public static final BitSet FOLLOW_RCURLY_in_block535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OR_in_orblock563 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_LCURLY_in_orblock565 = new BitSet(new long[]{0x0000148610A82400L});
    public static final BitSet FOLLOW_TERMINATOR_in_orblock567 = new BitSet(new long[]{0x0000048610A82400L});
    public static final BitSet FOLLOW_statement_in_orblock570 = new BitSet(new long[]{0x0000048610A82400L});
    public static final BitSet FOLLOW_RCURLY_in_orblock573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_argument_list601 = new BitSet(new long[]{0x0000050610A82400L});
    public static final BitSet FOLLOW_expr_in_argument_list604 = new BitSet(new long[]{0x0000010000000800L});
    public static final BitSet FOLLOW_COMMA_in_argument_list607 = new BitSet(new long[]{0x0000040610A82400L});
    public static final BitSet FOLLOW_expr_in_argument_list609 = new BitSet(new long[]{0x0000010000000800L});
    public static final BitSet FOLLOW_RPAREN_in_argument_list615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_class_identifier648 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_DOT_in_class_identifier650 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_class_identifier654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_atom753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_meth_call_in_atom763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_atom773 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_class_identifier_in_atom783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_atom793 = new BitSet(new long[]{0x0000040610A82400L});
    public static final BitSet FOLLOW_expr_in_atom796 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_RPAREN_in_atom798 = new BitSet(new long[]{0x0000000000000002L});

}