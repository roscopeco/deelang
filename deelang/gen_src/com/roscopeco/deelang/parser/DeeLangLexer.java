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


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class DeeLangLexer extends Lexer {
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
    public String getGrammarFileName() { return "C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g"; }

    // $ANTLR start "OR"
    public final void mOR() throws RecognitionException {
        try {
            int _type = OR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:228:5: ( 'or' )
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:228:9: 'or'
            {
            match("or"); 



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
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:230:5: ( '^' )
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:230:9: '^'
            {
            match('^'); 

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
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:231:5: ( '%' )
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:231:9: '%'
            {
            match('%'); 

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
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:232:5: ( '+' )
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:232:9: '+'
            {
            match('+'); 

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
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:233:5: ( '-' )
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:233:9: '-'
            {
            match('-'); 

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
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:234:5: ( '/' )
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:234:9: '/'
            {
            match('/'); 

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
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:235:5: ( '*' )
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:235:9: '*'
            {
            match('*'); 

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
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:236:5: ( '!' )
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:236:9: '!'
            {
            match('!'); 

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
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:239:5: ( '=' )
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:239:9: '='
            {
            match('='); 

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
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:243:5: ( '(' )
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:243:9: '('
            {
            match('('); 

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
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:247:5: ( ')' )
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:247:9: ')'
            {
            match(')'); 

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
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:251:5: ( '{' )
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:251:9: '{'
            {
            match('{'); 

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
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:255:5: ( '}' )
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:255:9: '}'
            {
            match('}'); 

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
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:259:5: ( ',' )
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:259:9: ','
            {
            match(','); 

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
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:262:5: ( '.' )
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:262:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DOT"

    // $ANTLR start "IDENTIFIER"
    public final void mIDENTIFIER() throws RecognitionException {
        try {
            int _type = IDENTIFIER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:265:3: ( ID_LETTER ( ID_LETTER | '0' .. '9' )* )
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:265:5: ID_LETTER ( ID_LETTER | '0' .. '9' )*
            {
            mID_LETTER(); 


            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:265:15: ( ID_LETTER | '0' .. '9' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='$'||(LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'Z')||LA1_0=='_'||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:
            	    {
            	    if ( input.LA(1)=='$'||(input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
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
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:271:3: ( '$' | 'A' .. 'Z' | 'a' .. 'z' | '_' )
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:
            {
            if ( input.LA(1)=='$'||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
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
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:277:5: ( '\\'' ( EscapeSequence |~ ( '\\'' | '\\\\' ) ) '\\'' )
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:277:9: '\\'' ( EscapeSequence |~ ( '\\'' | '\\\\' ) ) '\\''
            {
            match('\''); 

            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:277:14: ( EscapeSequence |~ ( '\\'' | '\\\\' ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='\\') ) {
                alt2=1;
            }
            else if ( ((LA2_0 >= '\u0000' && LA2_0 <= '&')||(LA2_0 >= '(' && LA2_0 <= '[')||(LA2_0 >= ']' && LA2_0 <= '\uFFFF')) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }
            switch (alt2) {
                case 1 :
                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:277:16: EscapeSequence
                    {
                    mEscapeSequence(); 


                    }
                    break;
                case 2 :
                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:277:33: ~ ( '\\'' | '\\\\' )
                    {
                    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '&')||(input.LA(1) >= '(' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;

            }


            match('\''); 

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
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:281:5: ( '\"' ( EscapeSequence |~ ( '\\\\' | '\"' ) )* '\"' )
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:281:8: '\"' ( EscapeSequence |~ ( '\\\\' | '\"' ) )* '\"'
            {
            match('\"'); 

            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:281:12: ( EscapeSequence |~ ( '\\\\' | '\"' ) )*
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
            	    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:281:14: EscapeSequence
            	    {
            	    mEscapeSequence(); 


            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:281:31: ~ ( '\\\\' | '\"' )
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	    }
            	    else {
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


            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STRING_LITERAL"

    // $ANTLR start "HEX_LITERAL"
    public final void mHEX_LITERAL() throws RecognitionException {
        try {
            int _type = HEX_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:290:13: ( '0' ( 'x' | 'X' ) ( HexDigit )+ ( IntegerTypeSuffix )? )
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:290:15: '0' ( 'x' | 'X' ) ( HexDigit )+ ( IntegerTypeSuffix )?
            {
            match('0'); 

            if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:290:29: ( HexDigit )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0 >= '0' && LA4_0 <= '9')||(LA4_0 >= 'A' && LA4_0 <= 'F')||(LA4_0 >= 'a' && LA4_0 <= 'f')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F')||(input.LA(1) >= 'a' && input.LA(1) <= 'f') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:290:39: ( IntegerTypeSuffix )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='L'||LA5_0=='U'||LA5_0=='l'||LA5_0=='u') ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:290:39: IntegerTypeSuffix
                    {
                    mIntegerTypeSuffix(); 


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "HEX_LITERAL"

    // $ANTLR start "DECIMAL_LITERAL"
    public final void mDECIMAL_LITERAL() throws RecognitionException {
        try {
            int _type = DECIMAL_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:292:17: ( ( '0' | '1' .. '9' ( '0' .. '9' )* ) ( IntegerTypeSuffix )? )
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:292:19: ( '0' | '1' .. '9' ( '0' .. '9' )* ) ( IntegerTypeSuffix )?
            {
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:292:19: ( '0' | '1' .. '9' ( '0' .. '9' )* )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='0') ) {
                alt7=1;
            }
            else if ( ((LA7_0 >= '1' && LA7_0 <= '9')) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;

            }
            switch (alt7) {
                case 1 :
                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:292:20: '0'
                    {
                    match('0'); 

                    }
                    break;
                case 2 :
                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:292:26: '1' .. '9' ( '0' .. '9' )*
                    {
                    matchRange('1','9'); 

                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:292:35: ( '0' .. '9' )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( ((LA6_0 >= '0' && LA6_0 <= '9')) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);


                    }
                    break;

            }


            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:292:46: ( IntegerTypeSuffix )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='L'||LA8_0=='U'||LA8_0=='l'||LA8_0=='u') ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:292:46: IntegerTypeSuffix
                    {
                    mIntegerTypeSuffix(); 


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DECIMAL_LITERAL"

    // $ANTLR start "OCTAL_LITERAL"
    public final void mOCTAL_LITERAL() throws RecognitionException {
        try {
            int _type = OCTAL_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:294:15: ( '0' ( '0' .. '7' )+ ( IntegerTypeSuffix )? )
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:294:17: '0' ( '0' .. '7' )+ ( IntegerTypeSuffix )?
            {
            match('0'); 

            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:294:21: ( '0' .. '7' )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0 >= '0' && LA9_0 <= '7')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt9 >= 1 ) break loop9;
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
            } while (true);


            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:294:33: ( IntegerTypeSuffix )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='L'||LA10_0=='U'||LA10_0=='l'||LA10_0=='u') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:294:33: IntegerTypeSuffix
                    {
                    mIntegerTypeSuffix(); 


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OCTAL_LITERAL"

    // $ANTLR start "HexDigit"
    public final void mHexDigit() throws RecognitionException {
        try {
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:298:10: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:
            {
            if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F')||(input.LA(1) >= 'a' && input.LA(1) <= 'f') ) {
                input.consume();
            }
            else {
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

    // $ANTLR start "IntegerTypeSuffix"
    public final void mIntegerTypeSuffix() throws RecognitionException {
        try {
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:302:3: ( ( 'l' | 'L' ) | ( 'u' | 'U' ) ( 'l' | 'L' )? )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0=='L'||LA12_0=='l') ) {
                alt12=1;
            }
            else if ( (LA12_0=='U'||LA12_0=='u') ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;

            }
            switch (alt12) {
                case 1 :
                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:302:5: ( 'l' | 'L' )
                    {
                    if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:303:5: ( 'u' | 'U' ) ( 'l' | 'L' )?
                    {
                    if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:303:16: ( 'l' | 'L' )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0=='L'||LA11_0=='l') ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:
                            {
                            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                                input.consume();
                            }
                            else {
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                recover(mse);
                                throw mse;
                            }


                            }
                            break;

                    }


                    }
                    break;

            }

        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IntegerTypeSuffix"

    // $ANTLR start "FLOATING_POINT_LITERAL"
    public final void mFLOATING_POINT_LITERAL() throws RecognitionException {
        try {
            int _type = FLOATING_POINT_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:306:5: ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( Exponent )? ( FloatTypeSuffix )? | '.' ( '0' .. '9' )+ ( Exponent )? ( FloatTypeSuffix )? | ( '0' .. '9' )+ ( Exponent )? ( FloatTypeSuffix )? )
            int alt23=3;
            alt23 = dfa23.predict(input);
            switch (alt23) {
                case 1 :
                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:306:9: ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( Exponent )? ( FloatTypeSuffix )?
                    {
                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:306:9: ( '0' .. '9' )+
                    int cnt13=0;
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( ((LA13_0 >= '0' && LA13_0 <= '9')) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt13 >= 1 ) break loop13;
                                EarlyExitException eee =
                                    new EarlyExitException(13, input);
                                throw eee;
                        }
                        cnt13++;
                    } while (true);


                    match('.'); 

                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:306:25: ( '0' .. '9' )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( ((LA14_0 >= '0' && LA14_0 <= '9')) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);


                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:306:37: ( Exponent )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0=='E'||LA15_0=='e') ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:306:37: Exponent
                            {
                            mExponent(); 


                            }
                            break;

                    }


                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:306:47: ( FloatTypeSuffix )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0=='D'||LA16_0=='F'||LA16_0=='d'||LA16_0=='f') ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:
                            {
                            if ( input.LA(1)=='D'||input.LA(1)=='F'||input.LA(1)=='d'||input.LA(1)=='f' ) {
                                input.consume();
                            }
                            else {
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                recover(mse);
                                throw mse;
                            }


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:307:9: '.' ( '0' .. '9' )+ ( Exponent )? ( FloatTypeSuffix )?
                    {
                    match('.'); 

                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:307:13: ( '0' .. '9' )+
                    int cnt17=0;
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( ((LA17_0 >= '0' && LA17_0 <= '9')) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt17 >= 1 ) break loop17;
                                EarlyExitException eee =
                                    new EarlyExitException(17, input);
                                throw eee;
                        }
                        cnt17++;
                    } while (true);


                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:307:25: ( Exponent )?
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0=='E'||LA18_0=='e') ) {
                        alt18=1;
                    }
                    switch (alt18) {
                        case 1 :
                            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:307:25: Exponent
                            {
                            mExponent(); 


                            }
                            break;

                    }


                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:307:35: ( FloatTypeSuffix )?
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0=='D'||LA19_0=='F'||LA19_0=='d'||LA19_0=='f') ) {
                        alt19=1;
                    }
                    switch (alt19) {
                        case 1 :
                            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:
                            {
                            if ( input.LA(1)=='D'||input.LA(1)=='F'||input.LA(1)=='d'||input.LA(1)=='f' ) {
                                input.consume();
                            }
                            else {
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                recover(mse);
                                throw mse;
                            }


                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:308:9: ( '0' .. '9' )+ ( Exponent )? ( FloatTypeSuffix )?
                    {
                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:308:9: ( '0' .. '9' )+
                    int cnt20=0;
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( ((LA20_0 >= '0' && LA20_0 <= '9')) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt20 >= 1 ) break loop20;
                                EarlyExitException eee =
                                    new EarlyExitException(20, input);
                                throw eee;
                        }
                        cnt20++;
                    } while (true);


                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:308:21: ( Exponent )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0=='E'||LA21_0=='e') ) {
                        alt21=1;
                    }
                    switch (alt21) {
                        case 1 :
                            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:308:21: Exponent
                            {
                            mExponent(); 


                            }
                            break;

                    }


                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:308:31: ( FloatTypeSuffix )?
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( (LA22_0=='D'||LA22_0=='F'||LA22_0=='d'||LA22_0=='f') ) {
                        alt22=1;
                    }
                    switch (alt22) {
                        case 1 :
                            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:
                            {
                            if ( input.LA(1)=='D'||input.LA(1)=='F'||input.LA(1)=='d'||input.LA(1)=='f' ) {
                                input.consume();
                            }
                            else {
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                recover(mse);
                                throw mse;
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

    // $ANTLR start "Exponent"
    public final void mExponent() throws RecognitionException {
        try {
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:313:10: ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:313:12: ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:313:22: ( '+' | '-' )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0=='+'||LA24_0=='-') ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;

            }


            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:313:33: ( '0' .. '9' )+
            int cnt25=0;
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( ((LA25_0 >= '0' && LA25_0 <= '9')) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt25 >= 1 ) break loop25;
                        EarlyExitException eee =
                            new EarlyExitException(25, input);
                        throw eee;
                }
                cnt25++;
            } while (true);


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Exponent"

    // $ANTLR start "FloatTypeSuffix"
    public final void mFloatTypeSuffix() throws RecognitionException {
        try {
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:316:17: ( ( 'f' | 'F' | 'd' | 'D' ) )
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:
            {
            if ( input.LA(1)=='D'||input.LA(1)=='F'||input.LA(1)=='d'||input.LA(1)=='f' ) {
                input.consume();
            }
            else {
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
    // $ANTLR end "FloatTypeSuffix"

    // $ANTLR start "EscapeSequence"
    public final void mEscapeSequence() throws RecognitionException {
        try {
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:320:5: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' | '/' ) | OctalEscape | UnicodeEscape )
            int alt26=3;
            int LA26_0 = input.LA(1);

            if ( (LA26_0=='\\') ) {
                switch ( input.LA(2) ) {
                case '\"':
                case '\'':
                case '/':
                case '\\':
                case 'b':
                case 'f':
                case 'n':
                case 'r':
                case 't':
                    {
                    alt26=1;
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
                    alt26=2;
                    }
                    break;
                case 'u':
                    {
                    alt26=3;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 26, 1, input);

                    throw nvae;

                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;

            }
            switch (alt26) {
                case 1 :
                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:320:9: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' | '/' )
                    {
                    match('\\'); 

                    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='/'||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:321:9: OctalEscape
                    {
                    mOctalEscape(); 


                    }
                    break;
                case 3 :
                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:322:9: UnicodeEscape
                    {
                    mUnicodeEscape(); 


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
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:327:5: ( '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) )
            int alt27=3;
            int LA27_0 = input.LA(1);

            if ( (LA27_0=='\\') ) {
                int LA27_1 = input.LA(2);

                if ( ((LA27_1 >= '0' && LA27_1 <= '3')) ) {
                    int LA27_2 = input.LA(3);

                    if ( ((LA27_2 >= '0' && LA27_2 <= '7')) ) {
                        int LA27_4 = input.LA(4);

                        if ( ((LA27_4 >= '0' && LA27_4 <= '7')) ) {
                            alt27=1;
                        }
                        else {
                            alt27=2;
                        }
                    }
                    else {
                        alt27=3;
                    }
                }
                else if ( ((LA27_1 >= '4' && LA27_1 <= '7')) ) {
                    int LA27_3 = input.LA(3);

                    if ( ((LA27_3 >= '0' && LA27_3 <= '7')) ) {
                        alt27=2;
                    }
                    else {
                        alt27=3;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 27, 1, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;

            }
            switch (alt27) {
                case 1 :
                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:327:9: '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); 

                    if ( (input.LA(1) >= '0' && input.LA(1) <= '3') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:328:9: '\\\\' ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); 

                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;
                case 3 :
                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:329:9: '\\\\' ( '0' .. '7' )
                    {
                    match('\\'); 

                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
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

    // $ANTLR start "UnicodeEscape"
    public final void mUnicodeEscape() throws RecognitionException {
        try {
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:334:5: ( '\\\\' 'u' HexDigit HexDigit HexDigit HexDigit )
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:334:9: '\\\\' 'u' HexDigit HexDigit HexDigit HexDigit
            {
            match('\\'); 

            match('u'); 

            mHexDigit(); 


            mHexDigit(); 


            mHexDigit(); 


            mHexDigit(); 


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
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:336:5: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:336:9: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 



            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:336:14: ( options {greedy=false; } : . )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0=='*') ) {
                    int LA28_1 = input.LA(2);

                    if ( (LA28_1=='/') ) {
                        alt28=2;
                    }
                    else if ( ((LA28_1 >= '\u0000' && LA28_1 <= '.')||(LA28_1 >= '0' && LA28_1 <= '\uFFFF')) ) {
                        alt28=1;
                    }


                }
                else if ( ((LA28_0 >= '\u0000' && LA28_0 <= ')')||(LA28_0 >= '+' && LA28_0 <= '\uFFFF')) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:336:42: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);


            match("*/"); 



            _channel=HIDDEN;

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
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:340:5: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:340:7: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
            {
            match("//"); 



            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:340:12: (~ ( '\\n' | '\\r' ) )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( ((LA29_0 >= '\u0000' && LA29_0 <= '\t')||(LA29_0 >= '\u000B' && LA29_0 <= '\f')||(LA29_0 >= '\u000E' && LA29_0 <= '\uFFFF')) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);


            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:340:26: ( '\\r' )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0=='\r') ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:340:26: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }


            match('\n'); 

            _channel=HIDDEN;

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
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:344:3: ( ( '\\r' )? '\\n' | ';' )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0=='\n'||LA32_0=='\r') ) {
                alt32=1;
            }
            else if ( (LA32_0==';') ) {
                alt32=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;

            }
            switch (alt32) {
                case 1 :
                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:344:5: ( '\\r' )? '\\n'
                    {
                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:344:5: ( '\\r' )?
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0=='\r') ) {
                        alt31=1;
                    }
                    switch (alt31) {
                        case 1 :
                            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:344:5: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }


                    match('\n'); 

                    }
                    break;
                case 2 :
                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:345:5: ';'
                    {
                    match(';'); 

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
            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:348:5: ( ( ' ' | '\\r' | '\\t' | '\\u000C' ) | '...' ( '\\r' )? '\\n' )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0=='\t'||(LA34_0 >= '\f' && LA34_0 <= '\r')||LA34_0==' ') ) {
                alt34=1;
            }
            else if ( (LA34_0=='.') ) {
                alt34=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;

            }
            switch (alt34) {
                case 1 :
                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:348:8: ( ' ' | '\\r' | '\\t' | '\\u000C' )
                    {
                    if ( input.LA(1)=='\t'||(input.LA(1) >= '\f' && input.LA(1) <= '\r')||input.LA(1)==' ' ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    _channel=HIDDEN;

                    }
                    break;
                case 2 :
                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:349:8: '...' ( '\\r' )? '\\n'
                    {
                    match("..."); 



                    // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:349:14: ( '\\r' )?
                    int alt33=2;
                    int LA33_0 = input.LA(1);

                    if ( (LA33_0=='\r') ) {
                        alt33=1;
                    }
                    switch (alt33) {
                        case 1 :
                            // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:349:14: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }


                    match('\n'); 

                    _channel=HIDDEN;

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
        // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:1:8: ( OR | POW | MOD | ADD | SUB | DIV | MUL | NOT | ASSIGN | LPAREN | RPAREN | LCURLY | RCURLY | COMMA | DOT | IDENTIFIER | CHARACTER_LITERAL | STRING_LITERAL | HEX_LITERAL | DECIMAL_LITERAL | OCTAL_LITERAL | FLOATING_POINT_LITERAL | COMMENT | LINE_COMMENT | TERMINATOR | WS )
        int alt35=26;
        alt35 = dfa35.predict(input);
        switch (alt35) {
            case 1 :
                // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:1:10: OR
                {
                mOR(); 


                }
                break;
            case 2 :
                // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:1:13: POW
                {
                mPOW(); 


                }
                break;
            case 3 :
                // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:1:17: MOD
                {
                mMOD(); 


                }
                break;
            case 4 :
                // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:1:21: ADD
                {
                mADD(); 


                }
                break;
            case 5 :
                // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:1:25: SUB
                {
                mSUB(); 


                }
                break;
            case 6 :
                // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:1:29: DIV
                {
                mDIV(); 


                }
                break;
            case 7 :
                // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:1:33: MUL
                {
                mMUL(); 


                }
                break;
            case 8 :
                // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:1:37: NOT
                {
                mNOT(); 


                }
                break;
            case 9 :
                // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:1:41: ASSIGN
                {
                mASSIGN(); 


                }
                break;
            case 10 :
                // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:1:48: LPAREN
                {
                mLPAREN(); 


                }
                break;
            case 11 :
                // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:1:55: RPAREN
                {
                mRPAREN(); 


                }
                break;
            case 12 :
                // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:1:62: LCURLY
                {
                mLCURLY(); 


                }
                break;
            case 13 :
                // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:1:69: RCURLY
                {
                mRCURLY(); 


                }
                break;
            case 14 :
                // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:1:76: COMMA
                {
                mCOMMA(); 


                }
                break;
            case 15 :
                // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:1:82: DOT
                {
                mDOT(); 


                }
                break;
            case 16 :
                // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:1:86: IDENTIFIER
                {
                mIDENTIFIER(); 


                }
                break;
            case 17 :
                // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:1:97: CHARACTER_LITERAL
                {
                mCHARACTER_LITERAL(); 


                }
                break;
            case 18 :
                // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:1:115: STRING_LITERAL
                {
                mSTRING_LITERAL(); 


                }
                break;
            case 19 :
                // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:1:130: HEX_LITERAL
                {
                mHEX_LITERAL(); 


                }
                break;
            case 20 :
                // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:1:142: DECIMAL_LITERAL
                {
                mDECIMAL_LITERAL(); 


                }
                break;
            case 21 :
                // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:1:158: OCTAL_LITERAL
                {
                mOCTAL_LITERAL(); 


                }
                break;
            case 22 :
                // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:1:172: FLOATING_POINT_LITERAL
                {
                mFLOATING_POINT_LITERAL(); 


                }
                break;
            case 23 :
                // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:1:195: COMMENT
                {
                mCOMMENT(); 


                }
                break;
            case 24 :
                // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:1:203: LINE_COMMENT
                {
                mLINE_COMMENT(); 


                }
                break;
            case 25 :
                // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:1:216: TERMINATOR
                {
                mTERMINATOR(); 


                }
                break;
            case 26 :
                // C:\\Users\\chantelle\\workspace\\deelang\\src\\com\\roscopeco\\deelang\\parser\\DeeLang.g:1:227: WS
                {
                mWS(); 


                }
                break;

        }

    }


    protected DFA23 dfa23 = new DFA23(this);
    protected DFA35 dfa35 = new DFA35(this);
    static final String DFA23_eotS =
        "\1\uffff\1\4\3\uffff";
    static final String DFA23_eofS =
        "\5\uffff";
    static final String DFA23_minS =
        "\2\56\3\uffff";
    static final String DFA23_maxS =
        "\2\71\3\uffff";
    static final String DFA23_acceptS =
        "\2\uffff\1\2\1\1\1\3";
    static final String DFA23_specialS =
        "\5\uffff}>";
    static final String[] DFA23_transitionS = {
            "\1\2\1\uffff\12\1",
            "\1\3\1\uffff\12\1",
            "",
            "",
            ""
    };

    static final short[] DFA23_eot = DFA.unpackEncodedString(DFA23_eotS);
    static final short[] DFA23_eof = DFA.unpackEncodedString(DFA23_eofS);
    static final char[] DFA23_min = DFA.unpackEncodedStringToUnsignedChars(DFA23_minS);
    static final char[] DFA23_max = DFA.unpackEncodedStringToUnsignedChars(DFA23_maxS);
    static final short[] DFA23_accept = DFA.unpackEncodedString(DFA23_acceptS);
    static final short[] DFA23_special = DFA.unpackEncodedString(DFA23_specialS);
    static final short[][] DFA23_transition;

    static {
        int numStates = DFA23_transitionS.length;
        DFA23_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA23_transition[i] = DFA.unpackEncodedString(DFA23_transitionS[i]);
        }
    }

    class DFA23 extends DFA {

        public DFA23(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 23;
            this.eot = DFA23_eot;
            this.eof = DFA23_eof;
            this.min = DFA23_min;
            this.max = DFA23_max;
            this.accept = DFA23_accept;
            this.special = DFA23_special;
            this.transition = DFA23_transition;
        }
        public String getDescription() {
            return "305:1: FLOATING_POINT_LITERAL : ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( Exponent )? ( FloatTypeSuffix )? | '.' ( '0' .. '9' )+ ( Exponent )? ( FloatTypeSuffix )? | ( '0' .. '9' )+ ( Exponent )? ( FloatTypeSuffix )? );";
        }
    }
    static final String DFA35_eotS =
        "\1\uffff\1\20\4\uffff\1\33\10\uffff\1\34\3\uffff\2\37\1\27\2\uffff"+
        "\1\42\7\uffff\1\43\1\37\2\uffff";
    static final String DFA35_eofS =
        "\44\uffff";
    static final String DFA35_minS =
        "\1\11\1\162\4\uffff\1\52\10\uffff\1\56\3\uffff\2\56\1\12\2\uffff"+
        "\1\44\7\uffff\2\56\2\uffff";
    static final String DFA35_maxS =
        "\1\175\1\162\4\uffff\1\57\10\uffff\1\71\3\uffff\1\170\1\146\1\12"+
        "\2\uffff\1\172\7\uffff\2\146\2\uffff";
    static final String DFA35_acceptS =
        "\2\uffff\1\2\1\3\1\4\1\5\1\uffff\1\7\1\10\1\11\1\12\1\13\1\14\1"+
        "\15\1\16\1\uffff\1\20\1\21\1\22\3\uffff\1\31\1\32\1\uffff\1\27\1"+
        "\30\1\6\1\17\1\26\1\23\1\24\2\uffff\1\1\1\25";
    static final String DFA35_specialS =
        "\44\uffff}>";
    static final String[] DFA35_transitionS = {
            "\1\27\1\26\1\uffff\1\27\1\25\22\uffff\1\27\1\10\1\22\1\uffff"+
            "\1\20\1\3\1\uffff\1\21\1\12\1\13\1\7\1\4\1\16\1\5\1\17\1\6\1"+
            "\23\11\24\1\uffff\1\26\1\uffff\1\11\3\uffff\32\20\3\uffff\1"+
            "\2\1\20\1\uffff\16\20\1\1\13\20\1\14\1\uffff\1\15",
            "\1\30",
            "",
            "",
            "",
            "",
            "\1\31\4\uffff\1\32",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\27\1\uffff\12\35",
            "",
            "",
            "",
            "\1\35\1\uffff\10\40\2\35\12\uffff\3\35\21\uffff\1\36\13\uffff"+
            "\3\35\21\uffff\1\36",
            "\1\35\1\uffff\12\41\12\uffff\3\35\35\uffff\3\35",
            "\1\26",
            "",
            "",
            "\1\20\13\uffff\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32"+
            "\20",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\35\1\uffff\10\40\2\35\12\uffff\3\35\35\uffff\3\35",
            "\1\35\1\uffff\12\41\12\uffff\3\35\35\uffff\3\35",
            "",
            ""
    };

    static final short[] DFA35_eot = DFA.unpackEncodedString(DFA35_eotS);
    static final short[] DFA35_eof = DFA.unpackEncodedString(DFA35_eofS);
    static final char[] DFA35_min = DFA.unpackEncodedStringToUnsignedChars(DFA35_minS);
    static final char[] DFA35_max = DFA.unpackEncodedStringToUnsignedChars(DFA35_maxS);
    static final short[] DFA35_accept = DFA.unpackEncodedString(DFA35_acceptS);
    static final short[] DFA35_special = DFA.unpackEncodedString(DFA35_specialS);
    static final short[][] DFA35_transition;

    static {
        int numStates = DFA35_transitionS.length;
        DFA35_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA35_transition[i] = DFA.unpackEncodedString(DFA35_transitionS[i]);
        }
    }

    class DFA35 extends DFA {

        public DFA35(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 35;
            this.eot = DFA35_eot;
            this.eof = DFA35_eof;
            this.min = DFA35_min;
            this.max = DFA35_max;
            this.accept = DFA35_accept;
            this.special = DFA35_special;
            this.transition = DFA35_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( OR | POW | MOD | ADD | SUB | DIV | MUL | NOT | ASSIGN | LPAREN | RPAREN | LCURLY | RCURLY | COMMA | DOT | IDENTIFIER | CHARACTER_LITERAL | STRING_LITERAL | HEX_LITERAL | DECIMAL_LITERAL | OCTAL_LITERAL | FLOATING_POINT_LITERAL | COMMENT | LINE_COMMENT | TERMINATOR | WS );";
        }
    }
 

}