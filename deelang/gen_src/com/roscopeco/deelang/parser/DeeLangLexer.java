// $ANTLR 3.4 /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g 2011-11-05 14:45:48

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
   *
	 * PORTIONS OF THIS LEXER ARE ADAPTED FROM THE JAVAFX LEXER GRAMMAR. 
	 * Portions copyright 2007-2009 Sun Microsystems, Inc.  All Rights Reserved.
   */
   import java.util.ArrayList;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class DeeLangLexer extends Lexer {
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

    public static final String MESSAGE_DLEXER_MALFORMED_HEX = "Malformed hex literal";
    public static final String MESSAGE_DLEXER_HEX_FLOAT = "Hex literals cannot be floating point";
    public static final String MESSAGE_DLEXER_HEX_MISSING = "Incomplete hex literal";
    public static final String MESSAGE_DLEXER_MALFORMED_OCTAL = "Malformed octal literal";
    public static final String MESSAGE_DLEXER_OCTAL_FLOAT = "Octal literals cannot be floating point";
    public static final String MESSAGE_DLEXER_MALFORMED_EXPONENT = "Malformed floating-point exponent";
    public static final String MESSAGE_DLEXER_LITERAL_OUT_OF_RANGE = "Number out of range";

    Log log = new Log();

    public static class Log {
      public static class Error { public int pos; public String error; }
      
      private ArrayList<Error> errors = new ArrayList<Error>();
      
      public boolean hasErrors() { return !errors.isEmpty(); }
      public Error getError(int i) { return errors.get(i); }
    	public final void error(int pos, String msg, Object... args) {
    		System.err.println(String.format("" + pos + ": " + msg, args));
    	}
    }

    public static int string2int(String s, int radix) throws NumberFormatException {
    	if (radix == 10) {
    		return Integer.parseInt(s, radix);
    	} else {
    		char[] cs = s.toCharArray();
    		int limit = Integer.MAX_VALUE / (radix / 2);
    		int n = 0;
    		for (int i = 0; i < cs.length; i++) {
    			int d = Character.digit(cs[i], radix);
    			if (n < 0 || n > limit || n * radix > Integer.MAX_VALUE - d)
    				throw new NumberFormatException();
    			n = n * radix + d;
    		}
    		return n;
    	}
    }

    protected boolean checkIntLiteralRange(String text, int pos, int radix,
    		boolean negative) {

    	// Value in terms of a long
    	//
    	long value = 0;

    	// Correct start position for error display
    	//
    	pos = pos - text.length() - (negative ? 1 : 0);

    	try {

    		// See if we can make a value out of this, however if this is a HEX literal then
    		// we want to coerce the value int o a negative integer of the top bit is set. So
    		// we use string2int rather than string2long.
    		//
    		value = string2int(text, radix);

    	} catch (Exception e) {

    		// Number form was too outrageous even for the converter
    		//
    		if (negative) {

    			log.error(pos, MESSAGE_DLEXER_LITERAL_OUT_OF_RANGE,
    					"small", new String("-" + text));

    		} else {
    			log.error(pos, MESSAGE_DLEXER_LITERAL_OUT_OF_RANGE, "big",
    					text);
    		}

    		return false;
    	}

    	return true;
    }


    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public DeeLangLexer() {} 
    public DeeLangLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public DeeLangLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "/home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g"; }

    // $ANTLR start "OR"
    public final void mOR() throws RecognitionException {
        try {
            int _type = OR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:331:3: ( 'or' )
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:331:5: 'or'
            {
            match("or"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OR"

    // $ANTLR start "POW"
    public final void mPOW() throws RecognitionException {
        try {
            int _type = POW;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:335:3: ( '^' )
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:335:5: '^'
            {
            match('^'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "POW"

    // $ANTLR start "MOD"
    public final void mMOD() throws RecognitionException {
        try {
            int _type = MOD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:339:3: ( '%' )
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:339:5: '%'
            {
            match('%'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MOD"

    // $ANTLR start "ADD"
    public final void mADD() throws RecognitionException {
        try {
            int _type = ADD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:343:3: ( '+' )
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:343:5: '+'
            {
            match('+'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ADD"

    // $ANTLR start "SUB"
    public final void mSUB() throws RecognitionException {
        try {
            int _type = SUB;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:347:3: ( '-' )
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:347:5: '-'
            {
            match('-'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SUB"

    // $ANTLR start "DIV"
    public final void mDIV() throws RecognitionException {
        try {
            int _type = DIV;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:351:3: ( '/' )
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:351:5: '/'
            {
            match('/'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DIV"

    // $ANTLR start "MUL"
    public final void mMUL() throws RecognitionException {
        try {
            int _type = MUL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:355:3: ( '*' )
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:355:5: '*'
            {
            match('*'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MUL"

    // $ANTLR start "NOT"
    public final void mNOT() throws RecognitionException {
        try {
            int _type = NOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:359:3: ( '!' )
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:359:5: '!'
            {
            match('!'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NOT"

    // $ANTLR start "ASSIGN"
    public final void mASSIGN() throws RecognitionException {
        try {
            int _type = ASSIGN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:363:3: ( '=' )
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:363:5: '='
            {
            match('='); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ASSIGN"

    // $ANTLR start "LPAREN"
    public final void mLPAREN() throws RecognitionException {
        try {
            int _type = LPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:367:3: ( '(' )
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:367:5: '('
            {
            match('('); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LPAREN"

    // $ANTLR start "RPAREN"
    public final void mRPAREN() throws RecognitionException {
        try {
            int _type = RPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:371:3: ( ')' )
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:371:5: ')'
            {
            match(')'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RPAREN"

    // $ANTLR start "LCURLY"
    public final void mLCURLY() throws RecognitionException {
        try {
            int _type = LCURLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:375:3: ( '{' )
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:375:5: '{'
            {
            match('{'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LCURLY"

    // $ANTLR start "RCURLY"
    public final void mRCURLY() throws RecognitionException {
        try {
            int _type = RCURLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:379:3: ( '}' )
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:379:5: '}'
            {
            match('}'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RCURLY"

    // $ANTLR start "COMMA"
    public final void mCOMMA() throws RecognitionException {
        try {
            int _type = COMMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:383:3: ( ',' )
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:383:5: ','
            {
            match(','); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMMA"

    // $ANTLR start "DOT"
    public final void mDOT() throws RecognitionException {
        try {
            int _type = DOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:387:3: ( '.' )
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:387:5: '.'
            {
            match('.'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DOT"

    // $ANTLR start "DOTDOT"
    public final void mDOTDOT() throws RecognitionException {
        try {
            int _type = DOTDOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:391:3: ( '..' )
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:391:5: '..'
            {
            match(".."); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DOTDOT"

    // $ANTLR start "IDENTIFIER"
    public final void mIDENTIFIER() throws RecognitionException {
        try {
            int _type = IDENTIFIER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:395:3: ( ID_LETTER ( ID_LETTER | '0' .. '9' )* )
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:395:5: ID_LETTER ( ID_LETTER | '0' .. '9' )*
            {
            mID_LETTER(); if (state.failed) return ;


            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:395:15: ( ID_LETTER | '0' .. '9' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='$'||(LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'Z')||LA1_0=='_'||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:
            	    {
            	    if ( input.LA(1)=='$'||(input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IDENTIFIER"

    // $ANTLR start "ID_LETTER"
    public final void mID_LETTER() throws RecognitionException {
        try {
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:401:3: ( '$' | 'A' .. 'Z' | 'a' .. 'z' | '_' )
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:
            {
            if ( input.LA(1)=='$'||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ID_LETTER"

    // $ANTLR start "CHARACTER_LITERAL"
    public final void mCHARACTER_LITERAL() throws RecognitionException {
        try {
            int _type = CHARACTER_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:407:3: ( '\\'' ( EscapeSequence |~ ( '\\'' | '\\\\' ) ) '\\'' )
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:407:5: '\\'' ( EscapeSequence |~ ( '\\'' | '\\\\' ) ) '\\''
            {
            match('\''); if (state.failed) return ;

            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:407:10: ( EscapeSequence |~ ( '\\'' | '\\\\' ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='\\') ) {
                alt2=1;
            }
            else if ( ((LA2_0 >= '\u0000' && LA2_0 <= '&')||(LA2_0 >= '(' && LA2_0 <= '[')||(LA2_0 >= ']' && LA2_0 <= '\uFFFF')) ) {
                alt2=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }
            switch (alt2) {
                case 1 :
                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:407:11: EscapeSequence
                    {
                    mEscapeSequence(); if (state.failed) return ;


                    }
                    break;
                case 2 :
                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:407:26: ~ ( '\\'' | '\\\\' )
                    {
                    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '&')||(input.LA(1) >= '(' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
                        input.consume();
                        state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;

            }


            match('\''); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CHARACTER_LITERAL"

    // $ANTLR start "STRING_LITERAL"
    public final void mSTRING_LITERAL() throws RecognitionException {
        try {
            int _type = STRING_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:411:3: ( '\"' ( EscapeSequence |~ ( '\\\\' | '\"' ) )* '\"' )
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:411:5: '\"' ( EscapeSequence |~ ( '\\\\' | '\"' ) )* '\"'
            {
            match('\"'); if (state.failed) return ;

            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:411:9: ( EscapeSequence |~ ( '\\\\' | '\"' ) )*
            loop3:
            do {
                int alt3=3;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='\\') ) {
                    alt3=1;
                }
                else if ( ((LA3_0 >= '\u0000' && LA3_0 <= '!')||(LA3_0 >= '#' && LA3_0 <= '[')||(LA3_0 >= ']' && LA3_0 <= '\uFFFF')) ) {
                    alt3=2;
                }


                switch (alt3) {
            	case 1 :
            	    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:411:10: EscapeSequence
            	    {
            	    mEscapeSequence(); if (state.failed) return ;


            	    }
            	    break;
            	case 2 :
            	    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:411:25: ~ ( '\\\\' | '\"' )
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            match('\"'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STRING_LITERAL"

    // $ANTLR start "TIME_LITERAL"
    public final void mTIME_LITERAL() throws RecognitionException {
        try {
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:448:13: ()
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:448:15: 
            {
            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "TIME_LITERAL"

    // $ANTLR start "DECIMAL_LITERAL"
    public final void mDECIMAL_LITERAL() throws RecognitionException {
        try {
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:458:16: ()
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:458:18: 
            {
            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DECIMAL_LITERAL"

    // $ANTLR start "OCTAL_LITERAL"
    public final void mOCTAL_LITERAL() throws RecognitionException {
        try {
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:465:14: ()
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:465:16: 
            {
            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OCTAL_LITERAL"

    // $ANTLR start "HEX_LITERAL"
    public final void mHEX_LITERAL() throws RecognitionException {
        try {
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:475:12: ()
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:475:14: 
            {
            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "HEX_LITERAL"

    // $ANTLR start "FLOATING_POINT_LITERAL"
    public final void mFLOATING_POINT_LITERAL() throws RecognitionException {
        try {
            int _type = FLOATING_POINT_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;

            // Indicates out of range digit
            //
            boolean rangeError = false;

            // First character of rule
            //
            int sPos = getCharIndex();

            // Is this going to be a negative numeric?
            //
            boolean negative = input.LT(-1) == '-';

            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:504:3: ( '0' ( ( 'x' | 'X' ) ( ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) | ( 'g' .. 'z' | 'G' .. 'Z' ) )+ |) | ( '0' .. '7' | '8' .. '9' )+ | ( 'm' ( 's' )? | 's' | 'h' ) |{...}? => '.' ( Digits ( Exponent )? ( ( 'm' ( 's' )? | 's' | 'h' ) |) |) |) | ( '1' .. '9' ) ( Digits )? ({...}? => ( ( '.' (~ ( 'a' .. 'd' | 'f' .. 'z' | 'A' .. 'D' | 'F' .. 'Z' ) ) )=> '.' ( Digits )? ( Exponent )? ( ( 'm' ( 's' )? | 's' | 'h' ) |) |) | ( ( 'm' ( 's' )? | 's' | 'h' ) | Exponent |) ) | '.' ( Digits ( Exponent )? ( ( 'm' ( 's' )? | 's' | 'h' ) |) | '.' |) )
            int alt31=3;
            switch ( input.LA(1) ) {
            case '0':
                {
                alt31=1;
                }
                break;
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                {
                alt31=2;
                }
                break;
            case '.':
                {
                alt31=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;

            }

            switch (alt31) {
                case 1 :
                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:510:3: '0' ( ( 'x' | 'X' ) ( ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) | ( 'g' .. 'z' | 'G' .. 'Z' ) )+ |) | ( '0' .. '7' | '8' .. '9' )+ | ( 'm' ( 's' )? | 's' | 'h' ) |{...}? => '.' ( Digits ( Exponent )? ( ( 'm' ( 's' )? | 's' | 'h' ) |) |) |)
                    {
                    match('0'); if (state.failed) return ;

                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:511:3: ( ( 'x' | 'X' ) ( ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) | ( 'g' .. 'z' | 'G' .. 'Z' ) )+ |) | ( '0' .. '7' | '8' .. '9' )+ | ( 'm' ( 's' )? | 's' | 'h' ) |{...}? => '.' ( Digits ( Exponent )? ( ( 'm' ( 's' )? | 's' | 'h' ) |) |) |)
                    int alt14=5;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0=='X'||LA14_0=='x') ) {
                        alt14=1;
                    }
                    else if ( ((LA14_0 >= '0' && LA14_0 <= '9')) ) {
                        alt14=2;
                    }
                    else if ( (LA14_0=='h'||LA14_0=='m'||LA14_0=='s') ) {
                        alt14=3;
                    }
                    else if ( (LA14_0=='.') && ((input.LA(2) != '.'))) {
                        alt14=4;
                    }
                    else {
                        alt14=5;
                    }
                    switch (alt14) {
                        case 1 :
                            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:512:5: ( 'x' | 'X' ) ( ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) | ( 'g' .. 'z' | 'G' .. 'Z' ) )+ |)
                            {
                            if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
                                input.consume();
                                state.failed=false;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return ;}
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                recover(mse);
                                throw mse;
                            }


                            if ( state.backtracking==0 ) {
                                 // Always set the type, so the parser is not confused
                                 //
                                 _type = HEX_LITERAL;
                                }

                            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:522:5: ( ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) | ( 'g' .. 'z' | 'G' .. 'Z' ) )+ |)
                            int alt5=2;
                            int LA5_0 = input.LA(1);

                            if ( ((LA5_0 >= '0' && LA5_0 <= '9')||(LA5_0 >= 'A' && LA5_0 <= 'Z')||(LA5_0 >= 'a' && LA5_0 <= 'z')) ) {
                                alt5=1;
                            }
                            else {
                                alt5=2;
                            }
                            switch (alt5) {
                                case 1 :
                                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:525:7: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) | ( 'g' .. 'z' | 'G' .. 'Z' ) )+
                                    {
                                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:525:7: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) | ( 'g' .. 'z' | 'G' .. 'Z' ) )+
                                    int cnt4=0;
                                    loop4:
                                    do {
                                        int alt4=3;
                                        int LA4_0 = input.LA(1);

                                        if ( ((LA4_0 >= '0' && LA4_0 <= '9')||(LA4_0 >= 'A' && LA4_0 <= 'F')||(LA4_0 >= 'a' && LA4_0 <= 'f')) ) {
                                            alt4=1;
                                        }
                                        else if ( ((LA4_0 >= 'G' && LA4_0 <= 'Z')||(LA4_0 >= 'g' && LA4_0 <= 'z')) ) {
                                            alt4=2;
                                        }


                                        switch (alt4) {
                                    	case 1 :
                                    	    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:526:9: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
                                    	    {
                                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F')||(input.LA(1) >= 'a' && input.LA(1) <= 'f') ) {
                                    	        input.consume();
                                    	        state.failed=false;
                                    	    }
                                    	    else {
                                    	        if (state.backtracking>0) {state.failed=true; return ;}
                                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                                    	        recover(mse);
                                    	        throw mse;
                                    	    }


                                    	    }
                                    	    break;
                                    	case 2 :
                                    	    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:532:9: ( 'g' .. 'z' | 'G' .. 'Z' )
                                    	    {
                                    	    if ( (input.LA(1) >= 'G' && input.LA(1) <= 'Z')||(input.LA(1) >= 'g' && input.LA(1) <= 'z') ) {
                                    	        input.consume();
                                    	        state.failed=false;
                                    	    }
                                    	    else {
                                    	        if (state.backtracking>0) {state.failed=true; return ;}
                                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                                    	        recover(mse);
                                    	        throw mse;
                                    	    }


                                    	    if ( state.backtracking==0 ) {
                                    	             rangeError = true; // Signal at least one bad digit
                                    	            }

                                    	    }
                                    	    break;

                                    	default :
                                    	    if ( cnt4 >= 1 ) break loop4;
                                    	    if (state.backtracking>0) {state.failed=true; return ;}
                                                EarlyExitException eee =
                                                    new EarlyExitException(4, input);
                                                throw eee;
                                        }
                                        cnt4++;
                                    } while (true);


                                    if ( state.backtracking==0 ) {
                                           setText(getText().substring(2, getText().length()));
                                           if (rangeError) {
                                           	// Error - malformed hex constant
                                           	//
                                           	log.error(sPos, MESSAGE_DLEXER_MALFORMED_HEX);
                                           	setText("0");
                                           } else {
                                           	if (!checkIntLiteralRange(getText(), getCharIndex(), 16, negative)) {
                                           		setText("0");
                                           	}
                                           }
                                          }

                                    }
                                    break;
                                case 2 :
                                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:588:7: 
                                    {
                                    if ( state.backtracking==0 ) {
                                            log.error(getCharIndex() - 1, MESSAGE_DLEXER_HEX_MISSING);
                                            setText("0");
                                           }

                                    }
                                    break;

                            }


                            }
                            break;
                        case 2 :
                            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:601:5: ( '0' .. '7' | '8' .. '9' )+
                            {
                            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:601:5: ( '0' .. '7' | '8' .. '9' )+
                            int cnt6=0;
                            loop6:
                            do {
                                int alt6=3;
                                int LA6_0 = input.LA(1);

                                if ( ((LA6_0 >= '0' && LA6_0 <= '7')) ) {
                                    alt6=1;
                                }
                                else if ( ((LA6_0 >= '8' && LA6_0 <= '9')) ) {
                                    alt6=2;
                                }


                                switch (alt6) {
                            	case 1 :
                            	    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:602:7: '0' .. '7'
                            	    {
                            	    matchRange('0','7'); if (state.failed) return ;

                            	    }
                            	    break;
                            	case 2 :
                            	    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:603:9: '8' .. '9'
                            	    {
                            	    matchRange('8','9'); if (state.failed) return ;

                            	    if ( state.backtracking==0 ) {
                            	                     rangeError = true; // Signal that at least one digit was wrong
                            	                    }

                            	    }
                            	    break;

                            	default :
                            	    if ( cnt6 >= 1 ) break loop6;
                            	    if (state.backtracking>0) {state.failed=true; return ;}
                                        EarlyExitException eee =
                                            new EarlyExitException(6, input);
                                        throw eee;
                                }
                                cnt6++;
                            } while (true);


                            if ( state.backtracking==0 ) {
                                 // Always set the type to octal, so the parser does not see
                                 // a lexing error, even though the compiler knows there is an
                                 // error.
                                 //
                                 _type = OCTAL_LITERAL;
                                 
                                 if (rangeError) {
                                 	log.error(sPos, MESSAGE_DLEXER_MALFORMED_OCTAL);
                                 	setText("0");
                                 } else {
                                 	if (!checkIntLiteralRange(getText(), getCharIndex(), 8, negative)) {
                                 		setText("0");
                                 	}
                                 }
                                }

                            }
                            break;
                        case 3 :
                            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:644:5: ( 'm' ( 's' )? | 's' | 'h' )
                            {
                            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:644:5: ( 'm' ( 's' )? | 's' | 'h' )
                            int alt8=3;
                            switch ( input.LA(1) ) {
                            case 'm':
                                {
                                alt8=1;
                                }
                                break;
                            case 's':
                                {
                                alt8=2;
                                }
                                break;
                            case 'h':
                                {
                                alt8=3;
                                }
                                break;
                            default:
                                if (state.backtracking>0) {state.failed=true; return ;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 8, 0, input);

                                throw nvae;

                            }

                            switch (alt8) {
                                case 1 :
                                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:645:7: 'm' ( 's' )?
                                    {
                                    match('m'); if (state.failed) return ;

                                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:645:11: ( 's' )?
                                    int alt7=2;
                                    int LA7_0 = input.LA(1);

                                    if ( (LA7_0=='s') ) {
                                        alt7=1;
                                    }
                                    switch (alt7) {
                                        case 1 :
                                            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:645:11: 's'
                                            {
                                            match('s'); if (state.failed) return ;

                                            }
                                            break;

                                    }


                                    }
                                    break;
                                case 2 :
                                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:646:9: 's'
                                    {
                                    match('s'); if (state.failed) return ;

                                    }
                                    break;
                                case 3 :
                                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:647:9: 'h'
                                    {
                                    match('h'); if (state.failed) return ;

                                    }
                                    break;

                            }


                            if ( state.backtracking==0 ) {
                                 _type = TIME_LITERAL;
                                }

                            }
                            break;
                        case 4 :
                            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:657:5: {...}? => '.' ( Digits ( Exponent )? ( ( 'm' ( 's' )? | 's' | 'h' ) |) |)
                            {
                            if ( !((input.LA(2) != '.')) ) {
                                if (state.backtracking>0) {state.failed=true; return ;}
                                throw new FailedPredicateException(input, "FLOATING_POINT_LITERAL", "input.LA(2) != '.'");
                            }

                            match('.'); if (state.failed) return ;

                            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:658:5: ( Digits ( Exponent )? ( ( 'm' ( 's' )? | 's' | 'h' ) |) |)
                            int alt13=2;
                            int LA13_0 = input.LA(1);

                            if ( ((LA13_0 >= '0' && LA13_0 <= '9')) ) {
                                alt13=1;
                            }
                            else {
                                alt13=2;
                            }
                            switch (alt13) {
                                case 1 :
                                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:661:7: Digits ( Exponent )? ( ( 'm' ( 's' )? | 's' | 'h' ) |)
                                    {
                                    mDigits(); if (state.failed) return ;


                                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:661:14: ( Exponent )?
                                    int alt9=2;
                                    int LA9_0 = input.LA(1);

                                    if ( (LA9_0=='E'||LA9_0=='e') ) {
                                        alt9=1;
                                    }
                                    switch (alt9) {
                                        case 1 :
                                            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:661:14: Exponent
                                            {
                                            mExponent(); if (state.failed) return ;


                                            }
                                            break;

                                    }


                                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:662:7: ( ( 'm' ( 's' )? | 's' | 'h' ) |)
                                    int alt12=2;
                                    int LA12_0 = input.LA(1);

                                    if ( (LA12_0=='h'||LA12_0=='m'||LA12_0=='s') ) {
                                        alt12=1;
                                    }
                                    else {
                                        alt12=2;
                                    }
                                    switch (alt12) {
                                        case 1 :
                                            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:663:9: ( 'm' ( 's' )? | 's' | 'h' )
                                            {
                                            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:663:9: ( 'm' ( 's' )? | 's' | 'h' )
                                            int alt11=3;
                                            switch ( input.LA(1) ) {
                                            case 'm':
                                                {
                                                alt11=1;
                                                }
                                                break;
                                            case 's':
                                                {
                                                alt11=2;
                                                }
                                                break;
                                            case 'h':
                                                {
                                                alt11=3;
                                                }
                                                break;
                                            default:
                                                if (state.backtracking>0) {state.failed=true; return ;}
                                                NoViableAltException nvae =
                                                    new NoViableAltException("", 11, 0, input);

                                                throw nvae;

                                            }

                                            switch (alt11) {
                                                case 1 :
                                                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:664:11: 'm' ( 's' )?
                                                    {
                                                    match('m'); if (state.failed) return ;

                                                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:664:15: ( 's' )?
                                                    int alt10=2;
                                                    int LA10_0 = input.LA(1);

                                                    if ( (LA10_0=='s') ) {
                                                        alt10=1;
                                                    }
                                                    switch (alt10) {
                                                        case 1 :
                                                            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:664:15: 's'
                                                            {
                                                            match('s'); if (state.failed) return ;

                                                            }
                                                            break;

                                                    }


                                                    }
                                                    break;
                                                case 2 :
                                                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:665:13: 's'
                                                    {
                                                    match('s'); if (state.failed) return ;

                                                    }
                                                    break;
                                                case 3 :
                                                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:666:13: 'h'
                                                    {
                                                    match('h'); if (state.failed) return ;

                                                    }
                                                    break;

                                            }


                                            if ( state.backtracking==0 ) {
                                                     _type = TIME_LITERAL;
                                                    }

                                            }
                                            break;
                                        case 2 :
                                            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:676:9: 
                                            {
                                            if ( state.backtracking==0 ) {
                                                      _type = FLOATING_POINT_LITERAL;
                                                     }

                                            }
                                            break;

                                    }


                                    }
                                    break;
                                case 2 :
                                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:684:7: 
                                    {
                                    if ( state.backtracking==0 ) {
                                            _type = FLOATING_POINT_LITERAL;
                                           }

                                    }
                                    break;

                            }


                            }
                            break;
                        case 5 :
                            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:693:5: 
                            {
                            if ( state.backtracking==0 ) {
                                  _type = DECIMAL_LITERAL;
                                  if (!checkIntLiteralRange(getText(), getCharIndex(), 10, negative)) {
                                  	setText("0");
                                  }
                                 }

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:705:3: ( '1' .. '9' ) ( Digits )? ({...}? => ( ( '.' (~ ( 'a' .. 'd' | 'f' .. 'z' | 'A' .. 'D' | 'F' .. 'Z' ) ) )=> '.' ( Digits )? ( Exponent )? ( ( 'm' ( 's' )? | 's' | 'h' ) |) |) | ( ( 'm' ( 's' )? | 's' | 'h' ) | Exponent |) )
                    {
                    if ( (input.LA(1) >= '1' && input.LA(1) <= '9') ) {
                        input.consume();
                        state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:705:14: ( Digits )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( ((LA15_0 >= '0' && LA15_0 <= '9')) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:705:14: Digits
                            {
                            mDigits(); if (state.failed) return ;


                            }
                            break;

                    }


                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:709:3: ({...}? => ( ( '.' (~ ( 'a' .. 'd' | 'f' .. 'z' | 'A' .. 'D' | 'F' .. 'Z' ) ) )=> '.' ( Digits )? ( Exponent )? ( ( 'm' ( 's' )? | 's' | 'h' ) |) |) | ( ( 'm' ( 's' )? | 's' | 'h' ) | Exponent |) )
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0=='.') && ((input.LA(2) != '.'))) {
                        alt25=1;
                    }
                    else if ( (LA25_0=='E'||LA25_0=='e'||LA25_0=='h'||LA25_0=='m'||LA25_0=='s') ) {
                        alt25=2;
                    }
                    else if ( ((input.LA(2) != '.')) ) {
                        alt25=1;
                    }
                    else if ( (true) ) {
                        alt25=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 25, 0, input);

                        throw nvae;

                    }
                    switch (alt25) {
                        case 1 :
                            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:710:5: {...}? => ( ( '.' (~ ( 'a' .. 'd' | 'f' .. 'z' | 'A' .. 'D' | 'F' .. 'Z' ) ) )=> '.' ( Digits )? ( Exponent )? ( ( 'm' ( 's' )? | 's' | 'h' ) |) |)
                            {
                            if ( !((input.LA(2) != '.')) ) {
                                if (state.backtracking>0) {state.failed=true; return ;}
                                throw new FailedPredicateException(input, "FLOATING_POINT_LITERAL", "input.LA(2) != '.'");
                            }

                            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:711:5: ( ( '.' (~ ( 'a' .. 'd' | 'f' .. 'z' | 'A' .. 'D' | 'F' .. 'Z' ) ) )=> '.' ( Digits )? ( Exponent )? ( ( 'm' ( 's' )? | 's' | 'h' ) |) |)
                            int alt21=2;
                            int LA21_0 = input.LA(1);

                            if ( (LA21_0=='.') && (synpred1_DeeLang())) {
                                alt21=1;
                            }
                            else {
                                alt21=2;
                            }
                            switch (alt21) {
                                case 1 :
                                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:720:7: ( '.' (~ ( 'a' .. 'd' | 'f' .. 'z' | 'A' .. 'D' | 'F' .. 'Z' ) ) )=> '.' ( Digits )? ( Exponent )? ( ( 'm' ( 's' )? | 's' | 'h' ) |)
                                    {
                                    match('.'); if (state.failed) return ;

                                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:731:16: ( Digits )?
                                    int alt16=2;
                                    int LA16_0 = input.LA(1);

                                    if ( ((LA16_0 >= '0' && LA16_0 <= '9')) ) {
                                        alt16=1;
                                    }
                                    switch (alt16) {
                                        case 1 :
                                            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:731:16: Digits
                                            {
                                            mDigits(); if (state.failed) return ;


                                            }
                                            break;

                                    }


                                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:731:24: ( Exponent )?
                                    int alt17=2;
                                    int LA17_0 = input.LA(1);

                                    if ( (LA17_0=='E'||LA17_0=='e') ) {
                                        alt17=1;
                                    }
                                    switch (alt17) {
                                        case 1 :
                                            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:731:24: Exponent
                                            {
                                            mExponent(); if (state.failed) return ;


                                            }
                                            break;

                                    }


                                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:732:7: ( ( 'm' ( 's' )? | 's' | 'h' ) |)
                                    int alt20=2;
                                    int LA20_0 = input.LA(1);

                                    if ( (LA20_0=='h'||LA20_0=='m'||LA20_0=='s') ) {
                                        alt20=1;
                                    }
                                    else {
                                        alt20=2;
                                    }
                                    switch (alt20) {
                                        case 1 :
                                            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:733:9: ( 'm' ( 's' )? | 's' | 'h' )
                                            {
                                            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:733:9: ( 'm' ( 's' )? | 's' | 'h' )
                                            int alt19=3;
                                            switch ( input.LA(1) ) {
                                            case 'm':
                                                {
                                                alt19=1;
                                                }
                                                break;
                                            case 's':
                                                {
                                                alt19=2;
                                                }
                                                break;
                                            case 'h':
                                                {
                                                alt19=3;
                                                }
                                                break;
                                            default:
                                                if (state.backtracking>0) {state.failed=true; return ;}
                                                NoViableAltException nvae =
                                                    new NoViableAltException("", 19, 0, input);

                                                throw nvae;

                                            }

                                            switch (alt19) {
                                                case 1 :
                                                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:734:11: 'm' ( 's' )?
                                                    {
                                                    match('m'); if (state.failed) return ;

                                                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:734:15: ( 's' )?
                                                    int alt18=2;
                                                    int LA18_0 = input.LA(1);

                                                    if ( (LA18_0=='s') ) {
                                                        alt18=1;
                                                    }
                                                    switch (alt18) {
                                                        case 1 :
                                                            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:734:15: 's'
                                                            {
                                                            match('s'); if (state.failed) return ;

                                                            }
                                                            break;

                                                    }


                                                    }
                                                    break;
                                                case 2 :
                                                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:735:13: 's'
                                                    {
                                                    match('s'); if (state.failed) return ;

                                                    }
                                                    break;
                                                case 3 :
                                                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:736:13: 'h'
                                                    {
                                                    match('h'); if (state.failed) return ;

                                                    }
                                                    break;

                                            }


                                            if ( state.backtracking==0 ) {
                                                     _type = TIME_LITERAL;
                                                    }

                                            }
                                            break;
                                        case 2 :
                                            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:746:9: 
                                            {
                                            if ( state.backtracking==0 ) {
                                                      _type = FLOATING_POINT_LITERAL;
                                                     }

                                            }
                                            break;

                                    }


                                    }
                                    break;
                                case 2 :
                                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:753:7: 
                                    {
                                    if ( state.backtracking==0 ) {
                                            _type = DECIMAL_LITERAL;
                                            if (!checkIntLiteralRange(getText(), getCharIndex(), 10, negative)) {
                                            	setText("0");
                                            }
                                           }

                                    }
                                    break;

                            }


                            }
                            break;
                        case 2 :
                            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:764:5: ( ( 'm' ( 's' )? | 's' | 'h' ) | Exponent |)
                            {
                            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:764:5: ( ( 'm' ( 's' )? | 's' | 'h' ) | Exponent |)
                            int alt24=3;
                            switch ( input.LA(1) ) {
                            case 'h':
                            case 'm':
                            case 's':
                                {
                                alt24=1;
                                }
                                break;
                            case 'E':
                            case 'e':
                                {
                                alt24=2;
                                }
                                break;
                            default:
                                alt24=3;
                            }

                            switch (alt24) {
                                case 1 :
                                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:765:7: ( 'm' ( 's' )? | 's' | 'h' )
                                    {
                                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:765:7: ( 'm' ( 's' )? | 's' | 'h' )
                                    int alt23=3;
                                    switch ( input.LA(1) ) {
                                    case 'm':
                                        {
                                        alt23=1;
                                        }
                                        break;
                                    case 's':
                                        {
                                        alt23=2;
                                        }
                                        break;
                                    case 'h':
                                        {
                                        alt23=3;
                                        }
                                        break;
                                    default:
                                        if (state.backtracking>0) {state.failed=true; return ;}
                                        NoViableAltException nvae =
                                            new NoViableAltException("", 23, 0, input);

                                        throw nvae;

                                    }

                                    switch (alt23) {
                                        case 1 :
                                            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:766:9: 'm' ( 's' )?
                                            {
                                            match('m'); if (state.failed) return ;

                                            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:766:13: ( 's' )?
                                            int alt22=2;
                                            int LA22_0 = input.LA(1);

                                            if ( (LA22_0=='s') ) {
                                                alt22=1;
                                            }
                                            switch (alt22) {
                                                case 1 :
                                                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:766:13: 's'
                                                    {
                                                    match('s'); if (state.failed) return ;

                                                    }
                                                    break;

                                            }


                                            }
                                            break;
                                        case 2 :
                                            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:767:11: 's'
                                            {
                                            match('s'); if (state.failed) return ;

                                            }
                                            break;
                                        case 3 :
                                            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:768:11: 'h'
                                            {
                                            match('h'); if (state.failed) return ;

                                            }
                                            break;

                                    }


                                    if ( state.backtracking==0 ) {
                                           _type = TIME_LITERAL;
                                          }

                                    }
                                    break;
                                case 2 :
                                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:774:9: Exponent
                                    {
                                    mExponent(); if (state.failed) return ;


                                    if ( state.backtracking==0 ) {
                                                     _type = FLOATING_POINT_LITERAL;
                                                    }

                                    }
                                    break;
                                case 3 :
                                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:782:7: 
                                    {
                                    if ( state.backtracking==0 ) {
                                            _type = DECIMAL_LITERAL;
                                            if (!checkIntLiteralRange(getText(), getCharIndex(), 10, negative)) {
                                            	setText("0");
                                            }
                                           }

                                    }
                                    break;

                            }


                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:790:5: '.' ( Digits ( Exponent )? ( ( 'm' ( 's' )? | 's' | 'h' ) |) | '.' |)
                    {
                    match('.'); if (state.failed) return ;

                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:791:3: ( Digits ( Exponent )? ( ( 'm' ( 's' )? | 's' | 'h' ) |) | '.' |)
                    int alt30=3;
                    switch ( input.LA(1) ) {
                    case '0':
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9':
                        {
                        alt30=1;
                        }
                        break;
                    case '.':
                        {
                        alt30=2;
                        }
                        break;
                    default:
                        alt30=3;
                    }

                    switch (alt30) {
                        case 1 :
                            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:793:5: Digits ( Exponent )? ( ( 'm' ( 's' )? | 's' | 'h' ) |)
                            {
                            mDigits(); if (state.failed) return ;


                            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:793:12: ( Exponent )?
                            int alt26=2;
                            int LA26_0 = input.LA(1);

                            if ( (LA26_0=='E'||LA26_0=='e') ) {
                                alt26=1;
                            }
                            switch (alt26) {
                                case 1 :
                                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:793:12: Exponent
                                    {
                                    mExponent(); if (state.failed) return ;


                                    }
                                    break;

                            }


                            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:794:5: ( ( 'm' ( 's' )? | 's' | 'h' ) |)
                            int alt29=2;
                            int LA29_0 = input.LA(1);

                            if ( (LA29_0=='h'||LA29_0=='m'||LA29_0=='s') ) {
                                alt29=1;
                            }
                            else {
                                alt29=2;
                            }
                            switch (alt29) {
                                case 1 :
                                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:795:7: ( 'm' ( 's' )? | 's' | 'h' )
                                    {
                                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:795:7: ( 'm' ( 's' )? | 's' | 'h' )
                                    int alt28=3;
                                    switch ( input.LA(1) ) {
                                    case 'm':
                                        {
                                        alt28=1;
                                        }
                                        break;
                                    case 's':
                                        {
                                        alt28=2;
                                        }
                                        break;
                                    case 'h':
                                        {
                                        alt28=3;
                                        }
                                        break;
                                    default:
                                        if (state.backtracking>0) {state.failed=true; return ;}
                                        NoViableAltException nvae =
                                            new NoViableAltException("", 28, 0, input);

                                        throw nvae;

                                    }

                                    switch (alt28) {
                                        case 1 :
                                            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:796:9: 'm' ( 's' )?
                                            {
                                            match('m'); if (state.failed) return ;

                                            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:796:13: ( 's' )?
                                            int alt27=2;
                                            int LA27_0 = input.LA(1);

                                            if ( (LA27_0=='s') ) {
                                                alt27=1;
                                            }
                                            switch (alt27) {
                                                case 1 :
                                                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:796:13: 's'
                                                    {
                                                    match('s'); if (state.failed) return ;

                                                    }
                                                    break;

                                            }


                                            }
                                            break;
                                        case 2 :
                                            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:797:11: 's'
                                            {
                                            match('s'); if (state.failed) return ;

                                            }
                                            break;
                                        case 3 :
                                            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:798:11: 'h'
                                            {
                                            match('h'); if (state.failed) return ;

                                            }
                                            break;

                                    }


                                    if ( state.backtracking==0 ) {
                                           _type = TIME_LITERAL;
                                          }

                                    }
                                    break;
                                case 2 :
                                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:808:7: 
                                    {
                                    if ( state.backtracking==0 ) {
                                            _type = FLOATING_POINT_LITERAL;
                                           }

                                    }
                                    break;

                            }


                            }
                            break;
                        case 2 :
                            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:816:5: '.'
                            {
                            match('.'); if (state.failed) return ;

                            if ( state.backtracking==0 ) {
                                      _type = DOTDOT; // Yes, it was ..
                                     }

                            }
                            break;
                        case 3 :
                            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:824:5: 
                            {
                            if ( state.backtracking==0 ) {
                                  _type = DOT;
                                 }

                            }
                            break;

                    }


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FLOATING_POINT_LITERAL"

    // $ANTLR start "Digits"
    public final void mDigits() throws RecognitionException {
        try {
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:833:3: ( ( '0' .. '9' )+ )
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:833:5: ( '0' .. '9' )+
            {
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:833:5: ( '0' .. '9' )+
            int cnt32=0;
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( ((LA32_0 >= '0' && LA32_0 <= '9')) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt32 >= 1 ) break loop32;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(32, input);
                        throw eee;
                }
                cnt32++;
            } while (true);


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Digits"

    // $ANTLR start "Exponent"
    public final void mExponent() throws RecognitionException {
        try {
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:838:3: ( ( 'e' | 'E' ) ( '+' | '-' )? ( Digits |) )
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:838:5: ( 'e' | 'E' ) ( '+' | '-' )? ( Digits |)
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:838:17: ( '+' | '-' )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0=='+'||LA33_0=='-') ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();
                        state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;

            }


            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:838:30: ( Digits |)
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( ((LA34_0 >= '0' && LA34_0 <= '9')) ) {
                alt34=1;
            }
            else {
                alt34=2;
            }
            switch (alt34) {
                case 1 :
                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:838:31: Digits
                    {
                    mDigits(); if (state.failed) return ;


                    }
                    break;
                case 2 :
                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:839:6: 
                    {
                    if ( state.backtracking==0 ) {
                          log.error(getCharIndex() - 1, MESSAGE_DLEXER_MALFORMED_EXPONENT);
                          setText("0.0");
                         }

                    }
                    break;

            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Exponent"

    // $ANTLR start "EscapeSequence"
    public final void mEscapeSequence() throws RecognitionException {
        try {
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:853:3: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | OctalEscape | UnicodeEscape )
            int alt35=3;
            int LA35_0 = input.LA(1);

            if ( (LA35_0=='\\') ) {
                switch ( input.LA(2) ) {
                case '\"':
                case '\'':
                case '\\':
                case 'b':
                case 'f':
                case 'n':
                case 'r':
                case 't':
                    {
                    alt35=1;
                    }
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                    {
                    alt35=2;
                    }
                    break;
                case 'u':
                    {
                    alt35=3;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 35, 1, input);

                    throw nvae;

                }

            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;

            }
            switch (alt35) {
                case 1 :
                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:853:5: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
                    {
                    match('\\'); if (state.failed) return ;

                    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
                        input.consume();
                        state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;
                case 2 :
                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:854:5: OctalEscape
                    {
                    mOctalEscape(); if (state.failed) return ;


                    }
                    break;
                case 3 :
                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:855:5: UnicodeEscape
                    {
                    mUnicodeEscape(); if (state.failed) return ;


                    }
                    break;

            }

        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "EscapeSequence"

    // $ANTLR start "OctalEscape"
    public final void mOctalEscape() throws RecognitionException {
        try {
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:860:3: ( '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) )
            int alt36=3;
            int LA36_0 = input.LA(1);

            if ( (LA36_0=='\\') ) {
                int LA36_1 = input.LA(2);

                if ( ((LA36_1 >= '0' && LA36_1 <= '3')) ) {
                    int LA36_2 = input.LA(3);

                    if ( ((LA36_2 >= '0' && LA36_2 <= '7')) ) {
                        int LA36_4 = input.LA(4);

                        if ( ((LA36_4 >= '0' && LA36_4 <= '7')) ) {
                            alt36=1;
                        }
                        else {
                            alt36=2;
                        }
                    }
                    else {
                        alt36=3;
                    }
                }
                else if ( ((LA36_1 >= '4' && LA36_1 <= '7')) ) {
                    int LA36_3 = input.LA(3);

                    if ( ((LA36_3 >= '0' && LA36_3 <= '7')) ) {
                        alt36=2;
                    }
                    else {
                        alt36=3;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 36, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;

            }
            switch (alt36) {
                case 1 :
                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:860:5: '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); if (state.failed) return ;

                    if ( (input.LA(1) >= '0' && input.LA(1) <= '3') ) {
                        input.consume();
                        state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                        state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                        state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;
                case 2 :
                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:861:5: '\\\\' ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); if (state.failed) return ;

                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                        state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                        state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;
                case 3 :
                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:862:5: '\\\\' ( '0' .. '7' )
                    {
                    match('\\'); if (state.failed) return ;

                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                        state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;

            }

        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OctalEscape"

    // $ANTLR start "HexDigit"
    public final void mHexDigit() throws RecognitionException {
        try {
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:867:3: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:
            {
            if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F')||(input.LA(1) >= 'a' && input.LA(1) <= 'f') ) {
                input.consume();
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "HexDigit"

    // $ANTLR start "UnicodeEscape"
    public final void mUnicodeEscape() throws RecognitionException {
        try {
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:874:3: ( '\\\\' 'u' HexDigit HexDigit HexDigit HexDigit )
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:874:5: '\\\\' 'u' HexDigit HexDigit HexDigit HexDigit
            {
            match('\\'); if (state.failed) return ;

            match('u'); if (state.failed) return ;

            mHexDigit(); if (state.failed) return ;


            mHexDigit(); if (state.failed) return ;


            mHexDigit(); if (state.failed) return ;


            mHexDigit(); if (state.failed) return ;


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "UnicodeEscape"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:877:3: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:877:5: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); if (state.failed) return ;



            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:877:10: ( options {greedy=false; } : . )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0=='*') ) {
                    int LA37_1 = input.LA(2);

                    if ( (LA37_1=='/') ) {
                        alt37=2;
                    }
                    else if ( ((LA37_1 >= '\u0000' && LA37_1 <= '.')||(LA37_1 >= '0' && LA37_1 <= '\uFFFF')) ) {
                        alt37=1;
                    }


                }
                else if ( ((LA37_0 >= '\u0000' && LA37_0 <= ')')||(LA37_0 >= '+' && LA37_0 <= '\uFFFF')) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:877:36: .
            	    {
            	    matchAny(); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);


            match("*/"); if (state.failed) return ;



            if ( state.backtracking==0 ) {
                                                      _channel = HIDDEN;
                                                     }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "LINE_COMMENT"
    public final void mLINE_COMMENT() throws RecognitionException {
        try {
            int _type = LINE_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:884:3: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:884:5: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
            {
            match("//"); if (state.failed) return ;



            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:884:10: (~ ( '\\n' | '\\r' ) )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( ((LA38_0 >= '\u0000' && LA38_0 <= '\t')||(LA38_0 >= '\u000B' && LA38_0 <= '\f')||(LA38_0 >= '\u000E' && LA38_0 <= '\uFFFF')) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop38;
                }
            } while (true);


            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:885:3: ( '\\r' )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0=='\r') ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:885:3: '\\r'
                    {
                    match('\r'); if (state.failed) return ;

                    }
                    break;

            }


            match('\n'); if (state.failed) return ;

            if ( state.backtracking==0 ) {
                         _channel = HIDDEN;
                        }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LINE_COMMENT"

    // $ANTLR start "TERMINATOR"
    public final void mTERMINATOR() throws RecognitionException {
        try {
            int _type = TERMINATOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:892:3: ( ( '\\r' )? '\\n' | ';' )
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0=='\n'||LA41_0=='\r') ) {
                alt41=1;
            }
            else if ( (LA41_0==';') ) {
                alt41=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;

            }
            switch (alt41) {
                case 1 :
                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:892:5: ( '\\r' )? '\\n'
                    {
                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:892:5: ( '\\r' )?
                    int alt40=2;
                    int LA40_0 = input.LA(1);

                    if ( (LA40_0=='\r') ) {
                        alt40=1;
                    }
                    switch (alt40) {
                        case 1 :
                            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:892:5: '\\r'
                            {
                            match('\r'); if (state.failed) return ;

                            }
                            break;

                    }


                    match('\n'); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:893:5: ';'
                    {
                    match(';'); if (state.failed) return ;

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "TERMINATOR"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:897:3: ( ( ' ' | '\\r' | '\\t' | '\\u000C' ) | '...' ( '\\r' )? '\\n' )
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0=='\t'||(LA43_0 >= '\f' && LA43_0 <= '\r')||LA43_0==' ') ) {
                alt43=1;
            }
            else if ( (LA43_0=='.') ) {
                alt43=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;

            }
            switch (alt43) {
                case 1 :
                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:897:5: ( ' ' | '\\r' | '\\t' | '\\u000C' )
                    {
                    if ( input.LA(1)=='\t'||(input.LA(1) >= '\f' && input.LA(1) <= '\r')||input.LA(1)==' ' ) {
                        input.consume();
                        state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    if ( state.backtracking==0 ) {
                       _channel = HIDDEN;
                      }

                    }
                    break;
                case 2 :
                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:902:5: '...' ( '\\r' )? '\\n'
                    {
                    match("..."); if (state.failed) return ;



                    // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:902:11: ( '\\r' )?
                    int alt42=2;
                    int LA42_0 = input.LA(1);

                    if ( (LA42_0=='\r') ) {
                        alt42=1;
                    }
                    switch (alt42) {
                        case 1 :
                            // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:902:11: '\\r'
                            {
                            match('\r'); if (state.failed) return ;

                            }
                            break;

                    }


                    match('\n'); if (state.failed) return ;

                    if ( state.backtracking==0 ) {
                                         _channel = HIDDEN;
                                        }

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WS"

    public void mTokens() throws RecognitionException {
        // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:1:8: ( OR | POW | MOD | ADD | SUB | DIV | MUL | NOT | ASSIGN | LPAREN | RPAREN | LCURLY | RCURLY | COMMA | DOT | DOTDOT | IDENTIFIER | CHARACTER_LITERAL | STRING_LITERAL | FLOATING_POINT_LITERAL | COMMENT | LINE_COMMENT | TERMINATOR | WS )
        int alt44=24;
        switch ( input.LA(1) ) {
        case 'o':
            {
            int LA44_1 = input.LA(2);

            if ( (LA44_1=='r') ) {
                int LA44_23 = input.LA(3);

                if ( (LA44_23=='$'||(LA44_23 >= '0' && LA44_23 <= '9')||(LA44_23 >= 'A' && LA44_23 <= 'Z')||LA44_23=='_'||(LA44_23 >= 'a' && LA44_23 <= 'z')) ) {
                    alt44=17;
                }
                else {
                    alt44=1;
                }
            }
            else {
                alt44=17;
            }
            }
            break;
        case '^':
            {
            alt44=2;
            }
            break;
        case '%':
            {
            alt44=3;
            }
            break;
        case '+':
            {
            alt44=4;
            }
            break;
        case '-':
            {
            alt44=5;
            }
            break;
        case '/':
            {
            switch ( input.LA(2) ) {
            case '*':
                {
                alt44=21;
                }
                break;
            case '/':
                {
                alt44=22;
                }
                break;
            default:
                alt44=6;
            }

            }
            break;
        case '*':
            {
            alt44=7;
            }
            break;
        case '!':
            {
            alt44=8;
            }
            break;
        case '=':
            {
            alt44=9;
            }
            break;
        case '(':
            {
            alt44=10;
            }
            break;
        case ')':
            {
            alt44=11;
            }
            break;
        case '{':
            {
            alt44=12;
            }
            break;
        case '}':
            {
            alt44=13;
            }
            break;
        case ',':
            {
            alt44=14;
            }
            break;
        case '.':
            {
            switch ( input.LA(2) ) {
            case '.':
                {
                int LA44_27 = input.LA(3);

                if ( (LA44_27=='.') ) {
                    alt44=24;
                }
                else {
                    alt44=16;
                }
                }
                break;
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                {
                alt44=20;
                }
                break;
            default:
                alt44=15;
            }

            }
            break;
        case '$':
        case 'A':
        case 'B':
        case 'C':
        case 'D':
        case 'E':
        case 'F':
        case 'G':
        case 'H':
        case 'I':
        case 'J':
        case 'K':
        case 'L':
        case 'M':
        case 'N':
        case 'O':
        case 'P':
        case 'Q':
        case 'R':
        case 'S':
        case 'T':
        case 'U':
        case 'V':
        case 'W':
        case 'X':
        case 'Y':
        case 'Z':
        case '_':
        case 'a':
        case 'b':
        case 'c':
        case 'd':
        case 'e':
        case 'f':
        case 'g':
        case 'h':
        case 'i':
        case 'j':
        case 'k':
        case 'l':
        case 'm':
        case 'n':
        case 'p':
        case 'q':
        case 'r':
        case 's':
        case 't':
        case 'u':
        case 'v':
        case 'w':
        case 'x':
        case 'y':
        case 'z':
            {
            alt44=17;
            }
            break;
        case '\'':
            {
            alt44=18;
            }
            break;
        case '\"':
            {
            alt44=19;
            }
            break;
        case '0':
        case '1':
        case '2':
        case '3':
        case '4':
        case '5':
        case '6':
        case '7':
        case '8':
        case '9':
            {
            alt44=20;
            }
            break;
        case '\r':
            {
            int LA44_20 = input.LA(2);

            if ( (LA44_20=='\n') ) {
                alt44=23;
            }
            else {
                alt44=24;
            }
            }
            break;
        case '\n':
        case ';':
            {
            alt44=23;
            }
            break;
        case '\t':
        case '\f':
        case ' ':
            {
            alt44=24;
            }
            break;
        default:
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 44, 0, input);

            throw nvae;

        }

        switch (alt44) {
            case 1 :
                // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:1:10: OR
                {
                mOR(); if (state.failed) return ;


                }
                break;
            case 2 :
                // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:1:13: POW
                {
                mPOW(); if (state.failed) return ;


                }
                break;
            case 3 :
                // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:1:17: MOD
                {
                mMOD(); if (state.failed) return ;


                }
                break;
            case 4 :
                // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:1:21: ADD
                {
                mADD(); if (state.failed) return ;


                }
                break;
            case 5 :
                // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:1:25: SUB
                {
                mSUB(); if (state.failed) return ;


                }
                break;
            case 6 :
                // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:1:29: DIV
                {
                mDIV(); if (state.failed) return ;


                }
                break;
            case 7 :
                // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:1:33: MUL
                {
                mMUL(); if (state.failed) return ;


                }
                break;
            case 8 :
                // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:1:37: NOT
                {
                mNOT(); if (state.failed) return ;


                }
                break;
            case 9 :
                // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:1:41: ASSIGN
                {
                mASSIGN(); if (state.failed) return ;


                }
                break;
            case 10 :
                // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:1:48: LPAREN
                {
                mLPAREN(); if (state.failed) return ;


                }
                break;
            case 11 :
                // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:1:55: RPAREN
                {
                mRPAREN(); if (state.failed) return ;


                }
                break;
            case 12 :
                // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:1:62: LCURLY
                {
                mLCURLY(); if (state.failed) return ;


                }
                break;
            case 13 :
                // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:1:69: RCURLY
                {
                mRCURLY(); if (state.failed) return ;


                }
                break;
            case 14 :
                // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:1:76: COMMA
                {
                mCOMMA(); if (state.failed) return ;


                }
                break;
            case 15 :
                // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:1:82: DOT
                {
                mDOT(); if (state.failed) return ;


                }
                break;
            case 16 :
                // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:1:86: DOTDOT
                {
                mDOTDOT(); if (state.failed) return ;


                }
                break;
            case 17 :
                // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:1:93: IDENTIFIER
                {
                mIDENTIFIER(); if (state.failed) return ;


                }
                break;
            case 18 :
                // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:1:104: CHARACTER_LITERAL
                {
                mCHARACTER_LITERAL(); if (state.failed) return ;


                }
                break;
            case 19 :
                // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:1:122: STRING_LITERAL
                {
                mSTRING_LITERAL(); if (state.failed) return ;


                }
                break;
            case 20 :
                // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:1:137: FLOATING_POINT_LITERAL
                {
                mFLOATING_POINT_LITERAL(); if (state.failed) return ;


                }
                break;
            case 21 :
                // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:1:160: COMMENT
                {
                mCOMMENT(); if (state.failed) return ;


                }
                break;
            case 22 :
                // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:1:168: LINE_COMMENT
                {
                mLINE_COMMENT(); if (state.failed) return ;


                }
                break;
            case 23 :
                // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:1:181: TERMINATOR
                {
                mTERMINATOR(); if (state.failed) return ;


                }
                break;
            case 24 :
                // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:1:192: WS
                {
                mWS(); if (state.failed) return ;


                }
                break;

        }

    }

    // $ANTLR start synpred1_DeeLang
    public final void synpred1_DeeLang_fragment() throws RecognitionException {
        // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:720:7: ( '.' (~ ( 'a' .. 'd' | 'f' .. 'z' | 'A' .. 'D' | 'F' .. 'Z' ) ) )
        // /home/rosco/workspace/deelang/src/com/roscopeco/deelang/parser/DeeLang.g:721:9: '.' (~ ( 'a' .. 'd' | 'f' .. 'z' | 'A' .. 'D' | 'F' .. 'Z' ) )
        {
        match('.'); if (state.failed) return ;

        if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '@')||input.LA(1)=='E'||(input.LA(1) >= '[' && input.LA(1) <= '`')||input.LA(1)=='e'||(input.LA(1) >= '{' && input.LA(1) <= '\uFFFF') ) {
            input.consume();
            state.failed=false;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            MismatchedSetException mse = new MismatchedSetException(null,input);
            recover(mse);
            throw mse;
        }


        }

    }
    // $ANTLR end synpred1_DeeLang

    public final boolean synpred1_DeeLang() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_DeeLang_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

}