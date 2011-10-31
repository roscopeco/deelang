/* DeeLang.g - ANTLR Combined grammar for DeeLang.
 *
 * Copyright 2011 Ross Bamford (roscopeco AT gmail DOT com)
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

grammar DeeLang;

options {
    output=AST;
    ASTLabelType=CommonTree; // type of $stat.tree ref etc...
    backtrack=true;
    memoize=true;     // TODO is this really wanted in embedded environment (uses more mem...)?
}

tokens {
  ASSIGN;
  METHOD_CALL;
  ARGS;
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
   */
}

@parser::members {
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

}

@rulecatch {
	// throw exceptions rather than silently failing...
	catch (RecognitionException e) {
	  throw e;
	}
}

start_rule
  :   script
  ;

script
  :   statement+
  |   EOF!
  ;

statement
  :   expr terminator!
  ;
  
block_statement
  :   expr
  ;
    
expr
  :   assign_expr
  |   math_expr
  ;
  
assign_expr
  :   class_identifier chained_call_or_field_expr* DOT id=IDENTIFIER ASSIGN expr -> class_identifier chained_call_or_field_expr* ^(ASSIGN_FIELD $id expr)
  |   ci = class_identifier ASSIGN expr -> IDENTIFIER[$ci.tree.getChild(0).getText()] ^(ASSIGN_FIELD IDENTIFIER[$ci.tree.getChild(1).getText()] expr)
  |   meth_call chained_call_or_field_expr* DOT id=IDENTIFIER ASSIGN expr -> meth_call chained_call_or_field_expr* ^(ASSIGN_FIELD $id expr)
  |   LPAREN e1=expr RPAREN chained_call_or_field_expr* DOT id=IDENTIFIER ASSIGN e2=expr -> $e1 chained_call_or_field_expr* ^(ASSIGN_FIELD $id $e2)
  |   id=IDENTIFIER ASSIGN expr -> ^(ASSIGN_LOCAL IDENTIFIER expr)
  ;

math_expr
  :   mult_expr ((ADD^|SUB^) mult_expr)*
  ; 

mult_expr
  :   pow_expr ((MUL^|DIV^|MOD^) pow_expr)*
  ; 
    
pow_expr
  :   unary_expr ((POW^) unary_expr)*
  ;
  
unary_expr
  :   NOT? atom
  ;

meth_call
@init {boolean explicitReceiver=false;}
  :   (IDENTIFIER DOT {explicitReceiver=true;})? func_call_expr -> {explicitReceiver}? ^(METHOD_CALL IDENTIFIER func_call_expr) -> ^(METHOD_CALL SELF func_call_expr) 
  |   literal DOT func_call_expr -> ^(METHOD_CALL literal func_call_expr) 
  ;
  
fragment
chained_call_or_field_expr
    : chained_field_expr
    | chained_meth_call_expr
    ;
    
fragment
chained_meth_call_expr
  	:	DOT func_call_expr -> ^(METHOD_CALL CHAIN func_call_expr)
	;
	
fragment
chained_field_expr
    : DOT IDENTIFIER -> ^(FIELD_ACCESS CHAIN IDENTIFIER)
    ;

fragment
func_call_expr
  :   IDENTIFIER^ argument_list block? orblock?
  ; 
       
fragment
block
  :   LCURLY TERMINATOR* (block_statement (TERMINATOR block_statement)*)? TERMINATOR* RCURLY -> ^(BLOCK block_statement*)
  ;
  
fragment
orblock
  :   OR LCURLY TERMINATOR* (block_statement (TERMINATOR block_statement)*)? TERMINATOR* RCURLY -> ^(ORBLOCK block_statement*)
  ;
  
fragment
argument_list
  :   LPAREN (expr (COMMA expr)*)? RPAREN -> ^(ARGS expr expr*)?
  ;
  
class_identifier
  :     rec=IDENTIFIER DOT id=IDENTIFIER -> ^(FIELD_ACCESS $rec $id)
  ;

literal
  :     DECIMAL_LITERAL
  |     OCTAL_LITERAL
  |     HEX_LITERAL
  |     FLOATING_POINT_LITERAL
//  |     REGEXP_LITERAL
  |     STRING_LITERAL
  |     CHARACTER_LITERAL
  ;
  
atom
  :     literal
  |     IDENTIFIER
  |     class_identifier (chained_call_or_field_expr)*
  |     meth_call (chained_call_or_field_expr)*
  |     LPAREN! expr RPAREN!
  ;
  
terminator
  :     TERMINATOR
  |     EOF
  ;

OR  :   'or';

POW :   '^' ;
MOD :   '%' ;
ADD :   '+' ;
SUB :   '-' ;
DIV :   '/' ;
MUL :   '*' ;
NOT :   '!' ;

ASSIGN
    :   '='
    ;
    
LPAREN
    :   '('
    ;
    
RPAREN
    :   ')'
    ;
    
LCURLY
    :   '{'
    ;
    
RCURLY
    :   '}'
    ;
    
COMMA
    :   ','
    ;
    
DOT :   '.' ;

IDENTIFIER
  : ID_LETTER (ID_LETTER|'0'..'9')*
  ;
  
fragment
ID_LETTER
  : '$'
  | 'A'..'Z'
  | 'a'..'z'
  | '_'
  ;

CHARACTER_LITERAL
    :   '\'' ( EscapeSequence | ~('\''|'\\') ) '\''
    ;

STRING_LITERAL
    :  '"' ( EscapeSequence | ~('\\'|'"') )* '"'
    ;

/*
REGEXP_LITERAL
    :  '/' ( EscapeSequence | ~('\\'|'"') )* '/'
    ;
*/

HEX_LITERAL : '0' ('x'|'X') HexDigit+ IntegerTypeSuffix? ;

DECIMAL_LITERAL : ('0' | '1'..'9' '0'..'9'*) IntegerTypeSuffix? ;

OCTAL_LITERAL : '0' ('0'..'7')+ IntegerTypeSuffix? ;

fragment
HexDigit : ('0'..'9'|'a'..'f'|'A'..'F') ;

fragment
IntegerTypeSuffix
  : ('l'|'L')
  | ('u'|'U')  ('l'|'L')?
  ;

FLOATING_POINT_LITERAL
    :   ('0'..'9')+ '.' ('0'..'9')* Exponent? FloatTypeSuffix?
    |   '.' ('0'..'9')+ Exponent? FloatTypeSuffix?
    |   ('0'..'9')+ Exponent? FloatTypeSuffix?
  ;

fragment
Exponent : ('e'|'E') ('+'|'-')? ('0'..'9')+ ;

fragment
FloatTypeSuffix : ('f'|'F'|'d'|'D') ;

fragment
EscapeSequence
    :   '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\'|'/')
    |   OctalEscape
    |   UnicodeEscape
    ;

fragment
OctalEscape
    :   '\\' ('0'..'3') ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7')
    ;

fragment
UnicodeEscape
    :   '\\' 'u' HexDigit HexDigit HexDigit HexDigit
    ;
COMMENT
    :   '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;}
    ;

LINE_COMMENT
    : '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;}
    ;
        
TERMINATOR 
  : '\r'? '\n' 
  | ';'
  ;

WS  :  (' '|'\r'|'\t'|'\u000C') {$channel=HIDDEN;}
    |  '...' '\r'? '\n'  {$channel=HIDDEN;}
    ;
