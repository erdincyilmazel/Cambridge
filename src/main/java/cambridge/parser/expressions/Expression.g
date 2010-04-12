grammar Expression; 
 
@header {
package cambridge.parser.expressions;
}

@lexer::header {
package cambridge.parser.expressions;
}

@members {
   ArrayList<RecognitionException> errors;

   @Override
   public void reportError(RecognitionException e) {
      if(errors == null) errors = new ArrayList<RecognitionException>();
      errors.add(e);
   }

   public ArrayList<RecognitionException> getErrors() {
      return errors;
   }
}

@lexer::members {
   ArrayList<RecognitionException> errors;

   @Override
   public void reportError(RecognitionException e) {
      if(errors == null) errors = new ArrayList<RecognitionException>();
      errors.add(e);
   }

   public ArrayList<RecognitionException> getErrors() {
      return errors;
   }
}

/********************************************************************************************
                          Parser section
*********************************************************************************************/
compilationUnit returns [Expression value]
    :   e=expression {$value = e;}
    ;
    
mapExpression returns [MapExpression value]
	 :	  '{' i=IDENTIFIER ':' e=expression {$value = new MapExpression(); $value.put(i.getText(), e);} (',' id=IDENTIFIER ':' x=expression  {$value.put(id.getText(), x);})* '}'
	 ;

listExpression returns [ListExpression value]
    :	  '[' e=expression {$value = new ListExpression(); $value.add(e); } (',' x=expression {$value.add(x);})* ']'
    ;

parExpression returns [Expression value]
    :   '(' e=expression ')' {$value = e;}
    ;

function returns [Expression value]
    :   IDENTIFIER '(' e=expression
    {$value = new FunctionExpression($IDENTIFIER.text);
    ArrayList<Expression> params = new ArrayList<Expression>();
    params.add(e);
    } (',' f=expression { params.add(f);})* ')' {((FunctionExpression)$value).setParameters(params);}
    ;
    
expression returns [Expression value]
    :   l = conditionalAndExpression {$value = l;}
        ('||' r = conditionalAndExpression {$value = new BinaryExpression(Expression.Operator.ConditionalOr, $value, r);}
        )*
    ;
     
conditionalAndExpression returns [Expression value]
    :   l = inclusiveOrExpression {$value = l;}
        ('&&' r = inclusiveOrExpression {$value = new BinaryExpression(Expression.Operator.ConditionalAnd, $value, r);}
        )*
    ;
     
inclusiveOrExpression returns [Expression value]
    :   l = exclusiveOrExpression {$value = l;}
        ('|' r = exclusiveOrExpression {$value = new BinaryExpression(Expression.Operator.Or, $value, r);}
        )*
    ;
     
exclusiveOrExpression returns [Expression value]
    :   l = andExpression {$value = l;}
        ('^' r = andExpression {$value = new BinaryExpression(Expression.Operator.XOr, $value, r);}
        )*
    ;
    
andExpression returns [Expression value]
    :   l = equalityExpression {$value = l;}
        ('&' r = equalityExpression {$value = new BinaryExpression(Expression.Operator.And, $value, r);}
        )* 
    ;
    
equalityExpression returns [Expression value]
    :   l = relationalExpression {$value = l; Expression.Operator op = null;}
        (  
            (   '==' {op = Expression.Operator.Equal;}
            |   '!=' {op = Expression.Operator.NotEqual;}
            )
            r = relationalExpression {$value = new BinaryExpression(op, $value, r);}
        )*
    ;

relationalExpression returns [Expression value]
    :   l = shiftExpression {$value = l;}
        (
        op = relationalOp r=shiftExpression  {$value = new BinaryExpression(op, $value, r);}
        )*
    ;
    
relationalOp returns [Expression.Operator value]
    :    '<' '=' {$value = Expression.Operator.LTE;}
    |    '>' '=' {$value = Expression.Operator.GTE;}
    |   '<' {$value = Expression.Operator.LT;}
    |   '>' {$value = Expression.Operator.GT;}
    ;
    
shiftExpression returns [Expression value]
    :   l=additiveExpression {$value = l;}
        (
        op = shiftOp r=additiveExpression {$value = new BinaryExpression(op, $value, r);}
        )*
    ; 
 
shiftOp returns [Expression.Operator value]
    :    '<' '<' {$value = Expression.Operator.SHIFT_LEFT;}
    |    '>' '>' '>' {$value = Expression.Operator.U_SHIFT_RIGHT;}
    |    '>' '>' {$value = Expression.Operator.SHIFT_RIGHT;}
    ; 
 
additiveExpression returns [Expression value]
    :   l = multiplicativeExpression {$value = l; Expression.Operator op = null;}
        (  
            (   '+' {op = Expression.Operator.Plus;}
            |   '-'  {op = Expression.Operator.Minus;}
            )
            r = multiplicativeExpression {$value = new BinaryExpression(op, $value, r);}
         )*
    ;
    
multiplicativeExpression returns [Expression value]
    :	
        l = unaryExpressionNotPlusMinus  {$value = l; Expression.Operator op = null;}
        (  
            (   '*'  {op = Expression.Operator.Times;}
            |   '/'  {op = Expression.Operator.Divide;}
            |   '%'  {op = Expression.Operator.Mod;}
            )
            r = unaryExpressionNotPlusMinus {$value = new BinaryExpression(op, $value, r);}
        )*
    ; 

unaryExpressionNotPlusMinus returns [Expression value]
    :   '~' l=multiplicativeExpression {$value = new UnaryExpression(Expression.Operator.Tilde, l);}
    |   '!' l=multiplicativeExpression {$value = new UnaryExpression(Expression.Operator.Not, l);}
    |   l=primary {$value = l;}
    ; 

primary returns [Expression value]
    :   e=parExpression {$value = e;}
    |   e=listExpression {$value = e;}
    |	  e=mapExpression {$value = e;}
    |   e=function {$value = e;}
    |   '#super' {$value = new VarExpression("#super");} (p=identifierSuffix {((VarExpression)$value).addProperty(p);})*
    |   '#this' {$value = new VarExpression("#this");} (p=identifierSuffix {((VarExpression)$value).addProperty(p);})*
    |   '#iter' {$value = new VarExpression("#iter");} (p=identifierSuffix {((VarExpression)$value).addProperty(p);})*
    |   IDENTIFIER {$value = new VarExpression($IDENTIFIER.text);} (p=identifierSuffix {((VarExpression)$value).addProperty(p);})*
    |   l=literal {$value = l;}
    ;
    
identifierSuffix returns [VarProperty value]
    	:	'.' IDENTIFIER {$value = new IdentifierVarProperty($IDENTIFIER.text);}
    	|	'[' e=expression ']' {$value = new MapVarProperty(e);}
    	;	
/* 
identifierSuffix
    :	
    ('[' expression ']')+
    ; 
 
selector 
    :   '.' IDENTIFIER
    |   '[' expression ']'
    ; */
    
literal returns [Expression value]
    :   INTLITERAL {$value = new IntLiteral(Integer.parseInt($INTLITERAL.text));}
    |   LONGLITERAL {$value = new LongLiteral(Long.parseLong($LONGLITERAL.text));}
    |   FLOATLITERAL {$value = new FloatLiteral(Float.parseFloat($FLOATLITERAL.text));}
    |   DOUBLELITERAL {$value = new DoubleLiteral(Double.parseDouble($DOUBLELITERAL.text));}
    |   STRINGLITERAL {$value = new StringLiteral($STRINGLITERAL.text);}
    |   CHARLITERAL {$value = new StringLiteral($CHARLITERAL.text);}
    |   TRUE {$value = new BooleanLiteral(true);}
    |   FALSE {$value = new BooleanLiteral(false);}
    |   NULL {$value = NullLiteral.instance;}
    |   RANGELITERAL {$value = Range.fromString($RANGELITERAL.text);}
    ; 
 
 
/********************************************************************************************
                  Lexer section
*********************************************************************************************/ 
LONGLITERAL
    :   IntegerNumber LongSuffix
    ;

RANGELITERAL
	 :   IntegerNumber '..' IntegerNumber
	 ; 
   
INTLITERAL
    :   IntegerNumber
    ;
   
fragment
IntegerNumber
    :   '0'
    |   '1'..'9' ('0'..'9')*   
    |   '0' ('0'..'7')+        
    |   HexPrefix HexDigit+       
    ; 
fragment
HexPrefix
    :   '0x' | '0X'
    ;
       
fragment
HexDigit
    :   ('0'..'9'|'a'..'f'|'A'..'F')
    ; 
fragment
LongSuffix
    :   'l' | 'L'
    ; 
 
fragment
NonIntegerNumber
    :   ('0' .. '9')+ '.' ('0' .. '9')* Exponent? 
    |   '.' ( '0' .. '9' )+ Exponent? 
    |   ('0' .. '9')+ Exponent 
    |   ('0' .. '9')+
    |  
        HexPrefix (HexDigit )*
        (    ()
        |    ('.' (HexDigit )* )
        )
        ( 'p' | 'P' )
        ( '+' | '-' )?
        ( '0' .. '9' )+
        ;
       
fragment
Exponent   
    :   ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+
    ;
   
fragment
FloatSuffix
    :   'f' | 'F'
    ;      
fragment
DoubleSuffix
    :   'd' | 'D'
    ;
       
FLOATLITERAL
    :   NonIntegerNumber FloatSuffix
    ;
   
DOUBLELITERAL
    :   NonIntegerNumber DoubleSuffix?
    ;
    
CHARLITERAL
    :   '\''
        (   EscapeSequence
        |   ~( '\'' | '\\' | '\r' | '\n' )
        )*
        '\''
    ;

STRINGLITERAL
    :   '"'
        (   EscapeSequence
        |   ~( '\\' | '"' | '\r' | '\n' )       
        )*
        '"'
    ;
    
fragment
EscapeSequence
    :   '\\' (
                 'b'
             |   't'
             |   'n'
             |   'f'
             |   'r'
             |   '\"'
             |   '\''
             |   '\\'
             |      
                 ('0'..'3') ('0'..'7') ('0'..'7')
             |      
                 ('0'..'7') ('0'..'7')
             |      
                 ('0'..'7')
             )         
;      
WS 
    :   (
             ' '
        |    '\r'
        |    '\t'
        |    '\u000C'
        |    '\n'
        )
            {
                skip();
            }         
    ;

TRUE
    :   'true'
    ; 
FALSE
    :   'false'
    ; 
NULL
    :   'null'
    ;
SUPER
    :   'super'
    ;
LPAREN
    :   '('
    ; 
RPAREN
    :   ')'
    ; 
LBRACKET
    :   '['
    ; 
RBRACKET
    :   ']'
    ; 
DOT
    :   '.'
    ;
EQ
    :   '='
    ; 
BANG
    :   '!'
    ; 
TILDE
    :   '~'
    ; 
EQEQ
    :   '=='
    ; 
AMPAMP
    :   '&&'
    ; 
BARBAR
    :   '||'
    ; 
PLUS
    :   '+'
    ; 
SUB
    :   '-'
    ; 
STAR
    :   '*'
    ; 
SLASH
    :   '/'
    ; 
AMP
    :   '&'
    ; 
BAR
    :   '|'
    ; 
CARET
    :   '^'
    ; 
PERCENT
    :   '%'
    ; 
BANGEQ
    :   '!='
    ; 
GT
    :   '>'
    ; 
LT
    :   '<'
    ;       

IDENTIFIER 
    :   LETTER (LETTER|JavaIDDigit)*
    ;

fragment
LETTER
    :  '\u0024' |
       '\u0041'..'\u005a' |
       '\u005f' |
       '\u0061'..'\u007a' |
       '\u00c0'..'\u00d6' |
       '\u00d8'..'\u00f6' |
       '\u00f8'..'\u00ff' |
       '\u0100'..'\u1fff' |
       '\u3040'..'\u318f' |
       '\u3300'..'\u337f' |
       '\u3400'..'\u3d2d' |
       '\u4e00'..'\u9fff' |
       '\uf900'..'\ufaff'
    ;

fragment
JavaIDDigit
    :  '\u0030'..'\u0039' |
       '\u0660'..'\u0669' |
       '\u06f0'..'\u06f9' |
       '\u0966'..'\u096f' |
       '\u09e6'..'\u09ef' |
       '\u0a66'..'\u0a6f' |
       '\u0ae6'..'\u0aef' |
       '\u0b66'..'\u0b6f' |
       '\u0be7'..'\u0bef' |
       '\u0c66'..'\u0c6f' |
       '\u0ce6'..'\u0cef' |
       '\u0d66'..'\u0d6f' |
       '\u0e50'..'\u0e59' |
       '\u0ed0'..'\u0ed9' |
       '\u1040'..'\u1049'
   ;