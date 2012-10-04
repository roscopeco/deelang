/* DeeLang.g - ANTLR Combined grammar for DeeLang.
 *
 * Copyright 2011, 2012 Ross Bamford (roscopeco AT gmail DOT com)
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
 * PORTIONS OF THIS GRAMMAR ARE ADAPTED FROM THE JAVAFX LEXER GRAMMAR. 
 * Portions copyright 2007-2009 Sun Microsystems, Inc.  All Rights Reserved.
  
 */
grammar DeeLang;

options {
  output       = AST;
  ASTLabelType = CommonTree; // type of $stat.tree ref etc...
  backtrack    = true;
  memoize      = true; // TODO is this really wanted in embedded environment (uses more mem...)?
}

tokens {
  ASSIGN;
  METHOD_CALL;
  ARGS;
  ARG;
  BLOCK;
  ORBLOCK;
  SELF;
  CHAIN;
  ASSIGN_FIELD;
  ASSIGN_LOCAL;
  FIELD_ACCESS;
}

@parser::header {
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
}

@lexer::header {
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
}

@parser::members {
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
}

@lexer::members {
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
}

@rulecatch {
// throw exceptions rather than silently failing...
	catch (RecognitionException e) {
	  throw e;
	}
}

start_rule
  :  script
  ;

script
  : statement+
  | EOF!
  ;

statement
  : expr terminator!
  ;

block_statement
  : expr
  ;

expr
  : assign_expr
  | math_expr
  ;

assign_expr
  : class_identifier chained_call_or_field_expr* DOT id=IDENTIFIER ASSIGN expr
    -> class_identifier chained_call_or_field_expr*
      ^(ASSIGN_FIELD CHAIN $id expr)
  | ci=class_identifier ASSIGN expr
    -> ^(ASSIGN_FIELD IDENTIFIER[$ci.tree.getChild(0).getText()] IDENTIFIER[$ci.tree.getChild(1).getText()] expr)
  | meth_call chained_call_or_field_expr* DOT id=IDENTIFIER ASSIGN expr
    -> meth_call chained_call_or_field_expr*
      ^(ASSIGN_FIELD CHAIN $id expr)
  | LPAREN e1=expr RPAREN chained_call_or_field_expr* DOT id=IDENTIFIER ASSIGN e2=expr
    -> $e1 chained_call_or_field_expr*
      ^(ASSIGN_FIELD CHAIN $id $e2)
  | id=IDENTIFIER ASSIGN expr
    -> ^(ASSIGN_LOCAL IDENTIFIER expr)
  ;

math_expr
  : mult_expr ((ADD^|SUB^) mult_expr)*
  ;

mult_expr
  : pow_expr ((MUL^| DIV^| MOD^) pow_expr)*
  ;

pow_expr
  : unary_expr ((POW^) unary_expr)*
  ;

unary_expr
  : NOT? atom
  ;

meth_call
@init {
boolean explicitReceiver = false;
}
  : (IDENTIFIER DOT {explicitReceiver = true;})? func_call_expr
    -> {explicitReceiver}?
      ^(METHOD_CALL IDENTIFIER func_call_expr)
    -> ^(METHOD_CALL SELF func_call_expr)
  | literal DOT func_call_expr
    -> ^(METHOD_CALL literal func_call_expr)
  ;

fragment
chained_call_or_field_expr
  : chained_field_expr
  | chained_meth_call_expr
  ;

fragment
chained_meth_call_expr
  : DOT func_call_expr -> ^(METHOD_CALL CHAIN func_call_expr)
  ;

fragment
chained_field_expr
  : DOT IDENTIFIER -> ^(FIELD_ACCESS CHAIN IDENTIFIER)
  ;

fragment
func_call_expr
  : IDENTIFIER^ argument_list block? orblock?
  ;

fragment
block
  : LCURLY TERMINATOR* (block_statement (TERMINATOR block_statement)*)? TERMINATOR* RCURLY
    -> ^(BLOCK block_statement*)
  ;

fragment
orblock
  : OR LCURLY TERMINATOR* (block_statement (TERMINATOR block_statement)*)? TERMINATOR* RCURLY
    -> ^(ORBLOCK block_statement*)
  ;

fragment
argument_list
  : LPAREN (argument (COMMA argument)*)? RPAREN -> ^(ARGS argument argument*)?
  ;
  
fragment
argument
  : expr
    -> ^(ARG expr)
  ; 

class_identifier
  : rec=IDENTIFIER DOT id=IDENTIFIER -> ^(FIELD_ACCESS $rec $id)
  ;

literal
  : DECIMAL_LITERAL
  | OCTAL_LITERAL
  | HEX_LITERAL
  | FLOATING_POINT_LITERAL
  | STRING_LITERAL
  | CHARACTER_LITERAL
  ;

atom
  : literal
  | IDENTIFIER
  | class_identifier (chained_call_or_field_expr)*
  | meth_call (chained_call_or_field_expr)*
  | LPAREN! expr RPAREN!
  ;

terminator
  : TERMINATOR
  | EOF
  ;

OR
  : 'or'
  ;

POW
  : '^'
  ;

MOD
  : '%'
  ;

ADD
  : '+'
  ;

SUB
  : '-'
  ;

DIV
  : '/'
  ;

MUL
  : '*'
  ;

NOT
  : '!'
  ;

ASSIGN
  : '='
  ;

LPAREN
  : '('
  ;

RPAREN
  : ')'
  ;

LCURLY
  : '{'
  ;

RCURLY
  : '}'
  ;

COMMA
  : ','
  ;

DOT
  : '.'
  ;

DOTDOT
  : '..'
  ;

IDENTIFIER
  : ID_LETTER (ID_LETTER | '0'..'9')*
  ;

fragment
ID_LETTER
  : '$'
  | 'A'..'Z'
  | 'a'..'z'
  | '_'
  ;

CHARACTER_LITERAL
  : '\'' (EscapeSequence|~('\''| '\\'))'\''
  ;

STRING_LITERAL
  : '"' (EscapeSequence|~('\\'| '"'))* '"'
  ;



/* ******************************************************************** */
/* THE FOLLOWING NUMERIC LITERAL CODE IS ADAPTED FROM THE JAVAFX PARSER */
/* AND FALLS UNDER THE FOLLOWING COPYRIGHT:                             */
/*
 * Copyright 2007-2009 Sun Microsystems, Inc.  All Rights Reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Sun Microsystems, Inc., 4150 Network Circle, Santa Clara,
 * CA 95054 USA or visit www.sun.com if you need additional information or
 * have any questions.
 */
// Time literals are self evident in meaning and are currently
// recognized by the lexer. This may change as in some cases
// trying to do too much in the lexer results in lexing errors
// that are difficult to recover from.
//
fragment
TIME_LITERAL: ;

// Decimal literals may not have leading zeros unless
// they are just the constant 0. They are integer only.
// In order to do more accurate error processing, these
// numeric literlas may merge into one rule that overrides
// the type.
//

fragment
DECIMAL_LITERAL: ;

// Octal literals are preceeded by a leading zero and must be followed
// by one or more valid octal digits.
//

fragment
OCTAL_LITERAL: ;

// Hex literals are preceded by 0X or 0x and must have one or
// more valid hex digits following them. The problem with specifying
// it like this is that a string such as 0x will cause a lexing error
// rather than a parse or semantic error, which is probably better
// and so this may change (see comments assocaited with DECIMAL_LITERAL)
//

fragment
HEX_LITERAL: ;

// ------------------------------------------------------------
// This rule is in fact the proxy rule for all types of numeric
// literals. ANTLR lexers are LL recognizers rather than pattern
// matchers such as flex. Hence we want to hand craft this rule
// to guide it through all the possible combinatsion of digits and
// dots in the most efficent way.
//
// This rule presents all the decision points in definite order,
// giving the scanner little hard work to do to select the
// correct token to match. The fragment rules above (TIME_LITERAL, DOTDOT
// and so on), are essentially just there to create the token
// types.
//

FLOATING_POINT_LITERAL
@init {
// Indicates out of range digit
//
boolean rangeError = false;

// First character of rule
//
int sPos = getCharIndex();

// Is this going to be a negative numeric?
//
boolean negative = input.LT(-1) == '-';
}
  :
  // A leading zero can either be a decimal literal
  // (if it is the sole component) or introduces
  // an octal or hexadecimal number. Time sequences
  // are also possible for the single '0' digit.
  //
  '0'
  (
    (
      'x'
      | 'X'
    ) // Hex literal indicated
    
    {
     // Always set the type, so the parser is not confused
     //
     $type = HEX_LITERAL;
    }
    (
      // We consume any letters and digits that follow 0x
      // and control the error that we issue.
      (
        (
          '0'..'9'
          | 'a'..'f'
          | 'A'..'F'
        ) // Valid Hex
        |
        (
          'g'..'z'
          | 'G'..'Z'
        ) // Invalid hex
        
        {
         rangeError = true; // Signal at least one bad digit
        }
      )+
      
      {
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
      /*( COMMENTED OUT to allow method calls on hex literals, e.g. 0x14.foo()
        // Hex numbers cannot be floating point, but catch this here
        // rather than mismatch it.
        //
        {input.LA(2) != '.' && input.LA(2) != '('}?=> 
                               {
                                sPos = getCharIndex();
                               } '.'
        (
          (
            '0'..'9'
            | 'a'..'f'
            | 'A'..'F'
          ) // Valid Hex
          |
          (
            'g'..'z'
            | 'G'..'Z'
          ) // Invalid hex
        )*
        
        {
         // Error - malformed hex constant
         //
         log.error(sPos, MESSAGE_DLEXER_HEX_FLOAT);
         setText("0");
        }
        |
      )*/
      |

       // If no digits follow 0x then it is an error
      //
      {
        log.error(getCharIndex() - 1, MESSAGE_DLEXER_HEX_MISSING);
        setText("0");
       }
    )
    |

    // Digits indicate an octal sequence
    // but we allow a match for any standard ASCII digit
    // and issue a controlled error, rather than allow
    // the lexer to throw mismatch errors. This is much nicer
    // for users.
    //
    (
      '0'..'7' // Valid octal digit
      | '8'..'9' // Invalid octal digit
      {
                 rangeError = true; // Signal that at least one digit was wrong
                }
    )+
    
    {
     // Always set the type to octal, so the parser does not see
     // a lexing error, even though the compiler knows there is an
     // error.
     //
     $type = OCTAL_LITERAL;
     
     if (rangeError) {
     	log.error(sPos, MESSAGE_DLEXER_MALFORMED_OCTAL);
     	setText("0");
     } else {
     	if (!checkIntLiteralRange(getText(), getCharIndex(), 8, negative)) {
     		setText("0");
     	}
     }
    }
    /*(
      // Octal numbers cannot be floating point, but catch this here
      // rather than mismatch it.
      //
      {input.LA(2) != '.'}?=> 
                             {
                              sPos = getCharIndex();
                             } '.' Digits? 
                                          {
                                           log.error(sPos, MESSAGE_DLEXER_OCTAL_FLOAT);
                                           setText("0");
                                          }
      |
    )*/
    |

    // Time sequence specifier means this was 0 length time
    // in whatever units.
    //
    (
      'm' 's'?
      | 's'
      | 'h'
    )
    
    {
     $type = TIME_LITERAL;
    }
    |

    // We can of course have 0.nnnnn
    //
    {input.LA(2) != '.'}?=> '.'
    (
      // Decimal, but possibly time
      //
      Digits Exponent?
      (
        (
          'm' 's'?
          | 's'
          | 'h'
        )
        
        {
         $type = TIME_LITERAL;
        }
        |

         // Just 0.nnn
        //
        {
          $type = FLOATING_POINT_LITERAL;
         }
      )
      |

       // Just 0.
      //
      {
        $type = FLOATING_POINT_LITERAL;
       }
    )
    |

     // If there were no following digits or adornments or range follows
    // then this was just Zero
    //
    {
      $type = DECIMAL_LITERAL;
      if (!checkIntLiteralRange(getText(), getCharIndex(), 10, negative)) {
      	setText("0");
      }
     }
  )
  |

  // Leading non zero digits can only be base 10, but might
  // be a floating point or a time,
  //
  ('1'..'9') Digits?

  // Numeric so far, resolve float and times
  //
  (
    {input.LA(2) != '.'}?=>
    (
      // HAving determined that this is not a range, we check to
      // see that it looks like something that shoudl be a float.
      // We can have an expression such as 1.intVal() and so that
      // needs to be '1' '.' 'intVal' '(' ')'
      // Note that 1.exxxx will always find an erroneous scientific
      // notation, but then if anyone is dumb enough to define a method beginning
      // with 'e' or 'E' for an integer literal, then all bets are off.
      //
      (
        '.'
        (
          ~(
            'a'..'d'
            | 'f'..'z'
            | 'A'..'D'
            | 'F'..'Z'
           )
        )
      )
        => '.' Digits? Exponent?
      (
        (
          'm' 's'?
          | 's'
          | 'h'
        )
        
        {
         $type = TIME_LITERAL;
        }
        |

         // Just n.nnn
        //
        {
          $type = FLOATING_POINT_LITERAL;
         }
      )
      |
       // Just n, possibly followed by something like .intValue()
      //
      {
        $type = DECIMAL_LITERAL;
        if (!checkIntLiteralRange(getText(), getCharIndex(), 10, negative)) {
        	setText("0");
        }
       }
    )
    |

    // Just a decimal literal
    //
    (
      (
        'm' 's'?
        | 's'
        | 'h'
      )
      
      {
       $type = TIME_LITERAL;
      }
      | Exponent 
                {
                 $type = FLOATING_POINT_LITERAL;
                }
      |

       // Just n, possibly followed by something like .intValue()
      //
      {
        $type = DECIMAL_LITERAL;
        if (!checkIntLiteralRange(getText(), getCharIndex(), 10, negative)) {
        	setText("0");
        }
       }
    )
  )
  | '.'
  ( // Float, but is it a time?
    //
    Digits Exponent?
    (
      (
        'm' 's'?
        | 's'
        | 'h'
      )
      
      {
       $type = TIME_LITERAL;
      }
      |

       // Just  floating point
      //
      {
        $type = FLOATING_POINT_LITERAL;
       }
    )
    |

         // Is it a range specifer?
    //
    '.' 
         {
          $type = DOTDOT; // Yes, it was ..
         }
    |

     // It was just a single .
    //
    {
      $type = DOT;
     }
  )
  ;

fragment
Digits
  : ('0'..'9')+
  ;

fragment
Exponent
  : ('e' | 'E') ('+' | '-')? (Digits|
     {
      log.error(getCharIndex() - 1, MESSAGE_DLEXER_MALFORMED_EXPONENT);
      setText("0.0");
     }
  )
  ;
/* ******************************************************************** */
/* END OF JAVAFX ADAPTED CODE                                           */
/* ******************************************************************** */



fragment
EscapeSequence
  : '\\' ('b' | 't' | 'n' | 'f' | 'r' | '\"' | '\'' | '\\')
  | OctalEscape
  | UnicodeEscape
  ;

fragment
OctalEscape
  : '\\' ('0'..'3') ('0'..'7') ('0'..'7')
  | '\\' ('0'..'7') ('0'..'7')
  | '\\' ('0'..'7')
  ;

fragment
HexDigit
  : '0'..'9'
  | 'a'..'f'
  | 'A'..'F'
  ;

fragment
UnicodeEscape
  : '\\' 'u' HexDigit HexDigit HexDigit HexDigit
  ;

COMMENT
  : '/*' (options {greedy=false;}: .)* '*/' 
                                         {
                                          $channel = HIDDEN;
                                         }
  ;

LINE_COMMENT
  : '//' ~('\n' | '\r')*
  '\r'? '\n' 
            {
             $channel = HIDDEN;
            }
  ;

TERMINATOR
  : '\r'? '\n'
  | ';' '\r'? '\n'?
  ;

WS
  : (' ' | '\r' | '\t' | '\u000C' )
  
  {
   $channel = HIDDEN;
  }
  | '...' '\r'? '\n' 
                    {
                     $channel = HIDDEN;
                    }
  ;
