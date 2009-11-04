// $ANTLR 3.2 Sep 23, 2009 12:02:23 /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g 2009-11-04 01:33:04

package cambridge.parser.expressions;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class ExpressionParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "IDENTIFIER", "INTLITERAL", "LONGLITERAL", "FLOATLITERAL", "DOUBLELITERAL", "STRINGLITERAL", "CHARLITERAL", "TRUE", "FALSE", "NULL", "IntegerNumber", "LongSuffix", "HexPrefix", "HexDigit", "Exponent", "NonIntegerNumber", "FloatSuffix", "DoubleSuffix", "EscapeSequence", "WS", "SUPER", "LPAREN", "RPAREN", "LBRACKET", "RBRACKET", "DOT", "EQ", "BANG", "TILDE", "EQEQ", "AMPAMP", "BARBAR", "PLUS", "SUB", "STAR", "SLASH", "AMP", "BAR", "CARET", "PERCENT", "BANGEQ", "GT", "LT", "LETTER", "JavaIDDigit", "'#super'", "'#this'", "'#iter'"
    };
    public static final int LT=46;
    public static final int STAR=38;
    public static final int IntegerNumber=14;
    public static final int LETTER=47;
    public static final int AMP=40;
    public static final int Exponent=18;
    public static final int SUB=37;
    public static final int EOF=-1;
    public static final int HexDigit=17;
    public static final int LPAREN=25;
    public static final int LBRACKET=27;
    public static final int RPAREN=26;
    public static final int T__51=51;
    public static final int SLASH=39;
    public static final int IDENTIFIER=4;
    public static final int NonIntegerNumber=19;
    public static final int FloatSuffix=20;
    public static final int CARET=42;
    public static final int TILDE=32;
    public static final int BANGEQ=44;
    public static final int BARBAR=35;
    public static final int PLUS=36;
    public static final int SUPER=24;
    public static final int RBRACKET=28;
    public static final int EQ=30;
    public static final int DOT=29;
    public static final int AMPAMP=34;
    public static final int T__50=50;
    public static final int EQEQ=33;
    public static final int HexPrefix=16;
    public static final int PERCENT=43;
    public static final int T__49=49;
    public static final int NULL=13;
    public static final int DOUBLELITERAL=8;
    public static final int BANG=31;
    public static final int INTLITERAL=5;
    public static final int TRUE=11;
    public static final int LongSuffix=15;
    public static final int LONGLITERAL=6;
    public static final int WS=23;
    public static final int DoubleSuffix=21;
    public static final int STRINGLITERAL=9;
    public static final int CHARLITERAL=10;
    public static final int JavaIDDigit=48;
    public static final int GT=45;
    public static final int FALSE=12;
    public static final int FLOATLITERAL=7;
    public static final int EscapeSequence=22;
    public static final int BAR=41;

    // delegates
    // delegators


        public ExpressionParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public ExpressionParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return ExpressionParser.tokenNames; }
    public String getGrammarFileName() { return "/Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g"; }


       ArrayList<RecognitionException> errors;

       @Override
       public void reportError(RecognitionException e) {
          if(errors == null) errors = new ArrayList<RecognitionException>();
          errors.add(e);
       }

       public ArrayList<RecognitionException> getErrors() {
          return errors;
       }



    // $ANTLR start "compilationUnit"
    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:39:1: compilationUnit returns [Expression value] : e= expression ;
    public final Expression compilationUnit() throws RecognitionException {
        Expression value = null;

        Expression e = null;


        try {
            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:43:5: (e= expression )
            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:43:9: e= expression
            {
            pushFollow(FOLLOW_expression_in_compilationUnit56);
            e=expression();

            state._fsp--;

            value = e;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return value;
    }
    // $ANTLR end "compilationUnit"


    // $ANTLR start "parExpression"
    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:46:1: parExpression returns [Expression value] : '(' e= expression ')' ;
    public final Expression parExpression() throws RecognitionException {
        Expression value = null;

        Expression e = null;


        try {
            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:47:5: ( '(' e= expression ')' )
            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:47:9: '(' e= expression ')'
            {
            match(input,LPAREN,FOLLOW_LPAREN_in_parExpression82); 
            pushFollow(FOLLOW_expression_in_parExpression86);
            e=expression();

            state._fsp--;

            match(input,RPAREN,FOLLOW_RPAREN_in_parExpression88); 
            value = e;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return value;
    }
    // $ANTLR end "parExpression"


    // $ANTLR start "expression"
    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:50:1: expression returns [Expression value] : l= conditionalAndExpression ( '||' r= conditionalAndExpression )* ;
    public final Expression expression() throws RecognitionException {
        Expression value = null;

        Expression l = null;

        Expression r = null;


        try {
            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:51:5: (l= conditionalAndExpression ( '||' r= conditionalAndExpression )* )
            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:51:9: l= conditionalAndExpression ( '||' r= conditionalAndExpression )*
            {
            pushFollow(FOLLOW_conditionalAndExpression_in_expression121);
            l=conditionalAndExpression();

            state._fsp--;

            value = l;
            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:52:9: ( '||' r= conditionalAndExpression )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==BARBAR) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:52:10: '||' r= conditionalAndExpression
            	    {
            	    match(input,BARBAR,FOLLOW_BARBAR_in_expression134); 
            	    pushFollow(FOLLOW_conditionalAndExpression_in_expression140);
            	    r=conditionalAndExpression();

            	    state._fsp--;

            	    value = new BinaryExpression(Expression.Operator.ConditionalOr, value, r);

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return value;
    }
    // $ANTLR end "expression"


    // $ANTLR start "conditionalAndExpression"
    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:56:1: conditionalAndExpression returns [Expression value] : l= inclusiveOrExpression ( '&&' r= inclusiveOrExpression )* ;
    public final Expression conditionalAndExpression() throws RecognitionException {
        Expression value = null;

        Expression l = null;

        Expression r = null;


        try {
            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:57:5: (l= inclusiveOrExpression ( '&&' r= inclusiveOrExpression )* )
            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:57:9: l= inclusiveOrExpression ( '&&' r= inclusiveOrExpression )*
            {
            pushFollow(FOLLOW_inclusiveOrExpression_in_conditionalAndExpression185);
            l=inclusiveOrExpression();

            state._fsp--;

            value = l;
            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:58:9: ( '&&' r= inclusiveOrExpression )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==AMPAMP) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:58:10: '&&' r= inclusiveOrExpression
            	    {
            	    match(input,AMPAMP,FOLLOW_AMPAMP_in_conditionalAndExpression198); 
            	    pushFollow(FOLLOW_inclusiveOrExpression_in_conditionalAndExpression204);
            	    r=inclusiveOrExpression();

            	    state._fsp--;

            	    value = new BinaryExpression(Expression.Operator.ConditionalAnd, value, r);

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return value;
    }
    // $ANTLR end "conditionalAndExpression"


    // $ANTLR start "inclusiveOrExpression"
    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:62:1: inclusiveOrExpression returns [Expression value] : l= exclusiveOrExpression ( '|' r= exclusiveOrExpression )* ;
    public final Expression inclusiveOrExpression() throws RecognitionException {
        Expression value = null;

        Expression l = null;

        Expression r = null;


        try {
            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:63:5: (l= exclusiveOrExpression ( '|' r= exclusiveOrExpression )* )
            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:63:9: l= exclusiveOrExpression ( '|' r= exclusiveOrExpression )*
            {
            pushFollow(FOLLOW_exclusiveOrExpression_in_inclusiveOrExpression249);
            l=exclusiveOrExpression();

            state._fsp--;

            value = l;
            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:64:9: ( '|' r= exclusiveOrExpression )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==BAR) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:64:10: '|' r= exclusiveOrExpression
            	    {
            	    match(input,BAR,FOLLOW_BAR_in_inclusiveOrExpression262); 
            	    pushFollow(FOLLOW_exclusiveOrExpression_in_inclusiveOrExpression268);
            	    r=exclusiveOrExpression();

            	    state._fsp--;

            	    value = new BinaryExpression(Expression.Operator.Or, value, r);

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return value;
    }
    // $ANTLR end "inclusiveOrExpression"


    // $ANTLR start "exclusiveOrExpression"
    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:68:1: exclusiveOrExpression returns [Expression value] : l= andExpression ( '^' r= andExpression )* ;
    public final Expression exclusiveOrExpression() throws RecognitionException {
        Expression value = null;

        Expression l = null;

        Expression r = null;


        try {
            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:69:5: (l= andExpression ( '^' r= andExpression )* )
            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:69:9: l= andExpression ( '^' r= andExpression )*
            {
            pushFollow(FOLLOW_andExpression_in_exclusiveOrExpression313);
            l=andExpression();

            state._fsp--;

            value = l;
            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:70:9: ( '^' r= andExpression )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==CARET) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:70:10: '^' r= andExpression
            	    {
            	    match(input,CARET,FOLLOW_CARET_in_exclusiveOrExpression326); 
            	    pushFollow(FOLLOW_andExpression_in_exclusiveOrExpression332);
            	    r=andExpression();

            	    state._fsp--;

            	    value = new BinaryExpression(Expression.Operator.XOr, value, r);

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return value;
    }
    // $ANTLR end "exclusiveOrExpression"


    // $ANTLR start "andExpression"
    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:74:1: andExpression returns [Expression value] : l= equalityExpression ( '&' r= equalityExpression )* ;
    public final Expression andExpression() throws RecognitionException {
        Expression value = null;

        Expression l = null;

        Expression r = null;


        try {
            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:75:5: (l= equalityExpression ( '&' r= equalityExpression )* )
            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:75:9: l= equalityExpression ( '&' r= equalityExpression )*
            {
            pushFollow(FOLLOW_equalityExpression_in_andExpression376);
            l=equalityExpression();

            state._fsp--;

            value = l;
            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:76:9: ( '&' r= equalityExpression )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==AMP) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:76:10: '&' r= equalityExpression
            	    {
            	    match(input,AMP,FOLLOW_AMP_in_andExpression389); 
            	    pushFollow(FOLLOW_equalityExpression_in_andExpression395);
            	    r=equalityExpression();

            	    state._fsp--;

            	    value = new BinaryExpression(Expression.Operator.And, value, r);

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return value;
    }
    // $ANTLR end "andExpression"


    // $ANTLR start "equalityExpression"
    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:80:1: equalityExpression returns [Expression value] : l= relationalExpression ( ( '==' | '!=' ) r= relationalExpression )* ;
    public final Expression equalityExpression() throws RecognitionException {
        Expression value = null;

        Expression l = null;

        Expression r = null;


        try {
            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:81:5: (l= relationalExpression ( ( '==' | '!=' ) r= relationalExpression )* )
            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:81:9: l= relationalExpression ( ( '==' | '!=' ) r= relationalExpression )*
            {
            pushFollow(FOLLOW_relationalExpression_in_equalityExpression440);
            l=relationalExpression();

            state._fsp--;

            value = l; Expression.Operator op = null;
            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:82:9: ( ( '==' | '!=' ) r= relationalExpression )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==EQEQ||LA7_0==BANGEQ) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:83:13: ( '==' | '!=' ) r= relationalExpression
            	    {
            	    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:83:13: ( '==' | '!=' )
            	    int alt6=2;
            	    int LA6_0 = input.LA(1);

            	    if ( (LA6_0==EQEQ) ) {
            	        alt6=1;
            	    }
            	    else if ( (LA6_0==BANGEQ) ) {
            	        alt6=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 6, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt6) {
            	        case 1 :
            	            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:83:17: '=='
            	            {
            	            match(input,EQEQ,FOLLOW_EQEQ_in_equalityExpression472); 
            	            op = Expression.Operator.Equal;

            	            }
            	            break;
            	        case 2 :
            	            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:84:17: '!='
            	            {
            	            match(input,BANGEQ,FOLLOW_BANGEQ_in_equalityExpression492); 
            	            op = Expression.Operator.NotEqual;

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_relationalExpression_in_equalityExpression526);
            	    r=relationalExpression();

            	    state._fsp--;

            	    value = new BinaryExpression(op, value, r);

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return value;
    }
    // $ANTLR end "equalityExpression"


    // $ANTLR start "relationalExpression"
    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:90:1: relationalExpression returns [Expression value] : l= shiftExpression (op= relationalOp r= shiftExpression )* ;
    public final Expression relationalExpression() throws RecognitionException {
        Expression value = null;

        Expression l = null;

        Expression.Operator op = null;

        Expression r = null;


        try {
            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:91:5: (l= shiftExpression (op= relationalOp r= shiftExpression )* )
            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:91:9: l= shiftExpression (op= relationalOp r= shiftExpression )*
            {
            pushFollow(FOLLOW_shiftExpression_in_relationalExpression566);
            l=shiftExpression();

            state._fsp--;

            value = l;
            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:92:9: (op= relationalOp r= shiftExpression )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>=GT && LA8_0<=LT)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:93:9: op= relationalOp r= shiftExpression
            	    {
            	    pushFollow(FOLLOW_relationalOp_in_relationalExpression592);
            	    op=relationalOp();

            	    state._fsp--;

            	    pushFollow(FOLLOW_shiftExpression_in_relationalExpression596);
            	    r=shiftExpression();

            	    state._fsp--;

            	    value = new BinaryExpression(op, value, r);

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return value;
    }
    // $ANTLR end "relationalExpression"


    // $ANTLR start "relationalOp"
    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:97:1: relationalOp returns [Expression.Operator value] : ( '<' '=' | '>' '=' | '<' | '>' );
    public final Expression.Operator relationalOp() throws RecognitionException {
        Expression.Operator value = null;

        try {
            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:98:5: ( '<' '=' | '>' '=' | '<' | '>' )
            int alt9=4;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==LT) ) {
                int LA9_1 = input.LA(2);

                if ( (LA9_1==EQ) ) {
                    alt9=1;
                }
                else if ( ((LA9_1>=IDENTIFIER && LA9_1<=NULL)||LA9_1==LPAREN||(LA9_1>=BANG && LA9_1<=TILDE)||(LA9_1>=49 && LA9_1<=51)) ) {
                    alt9=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA9_0==GT) ) {
                int LA9_2 = input.LA(2);

                if ( (LA9_2==EQ) ) {
                    alt9=2;
                }
                else if ( ((LA9_2>=IDENTIFIER && LA9_2<=NULL)||LA9_2==LPAREN||(LA9_2>=BANG && LA9_2<=TILDE)||(LA9_2>=49 && LA9_2<=51)) ) {
                    alt9=4;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:98:10: '<' '='
                    {
                    match(input,LT,FOLLOW_LT_in_relationalOp638); 
                    match(input,EQ,FOLLOW_EQ_in_relationalOp640); 
                    value = Expression.Operator.LTE;

                    }
                    break;
                case 2 :
                    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:99:10: '>' '='
                    {
                    match(input,GT,FOLLOW_GT_in_relationalOp653); 
                    match(input,EQ,FOLLOW_EQ_in_relationalOp655); 
                    value = Expression.Operator.GTE;

                    }
                    break;
                case 3 :
                    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:100:9: '<'
                    {
                    match(input,LT,FOLLOW_LT_in_relationalOp667); 
                    value = Expression.Operator.LT;

                    }
                    break;
                case 4 :
                    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:101:9: '>'
                    {
                    match(input,GT,FOLLOW_GT_in_relationalOp679); 
                    value = Expression.Operator.GT;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return value;
    }
    // $ANTLR end "relationalOp"


    // $ANTLR start "shiftExpression"
    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:104:1: shiftExpression returns [Expression value] : l= additiveExpression (op= shiftOp r= additiveExpression )* ;
    public final Expression shiftExpression() throws RecognitionException {
        Expression value = null;

        Expression l = null;

        Expression.Operator op = null;

        Expression r = null;


        try {
            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:105:5: (l= additiveExpression (op= shiftOp r= additiveExpression )* )
            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:105:9: l= additiveExpression (op= shiftOp r= additiveExpression )*
            {
            pushFollow(FOLLOW_additiveExpression_in_shiftExpression710);
            l=additiveExpression();

            state._fsp--;

            value = l;
            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:106:9: (op= shiftOp r= additiveExpression )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==LT) ) {
                    int LA10_1 = input.LA(2);

                    if ( (LA10_1==LT) ) {
                        alt10=1;
                    }


                }
                else if ( (LA10_0==GT) ) {
                    int LA10_2 = input.LA(2);

                    if ( (LA10_2==GT) ) {
                        alt10=1;
                    }


                }


                switch (alt10) {
            	case 1 :
            	    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:107:9: op= shiftOp r= additiveExpression
            	    {
            	    pushFollow(FOLLOW_shiftOp_in_shiftExpression736);
            	    op=shiftOp();

            	    state._fsp--;

            	    pushFollow(FOLLOW_additiveExpression_in_shiftExpression740);
            	    r=additiveExpression();

            	    state._fsp--;

            	    value = new BinaryExpression(op, value, r);

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return value;
    }
    // $ANTLR end "shiftExpression"


    // $ANTLR start "shiftOp"
    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:111:1: shiftOp returns [Expression.Operator value] : ( '<' '<' | '>' '>' '>' | '>' '>' );
    public final Expression.Operator shiftOp() throws RecognitionException {
        Expression.Operator value = null;

        try {
            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:112:5: ( '<' '<' | '>' '>' '>' | '>' '>' )
            int alt11=3;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==LT) ) {
                alt11=1;
            }
            else if ( (LA11_0==GT) ) {
                int LA11_2 = input.LA(2);

                if ( (LA11_2==GT) ) {
                    int LA11_3 = input.LA(3);

                    if ( (LA11_3==GT) ) {
                        alt11=2;
                    }
                    else if ( ((LA11_3>=IDENTIFIER && LA11_3<=NULL)||LA11_3==LPAREN||(LA11_3>=BANG && LA11_3<=TILDE)||(LA11_3>=49 && LA11_3<=51)) ) {
                        alt11=3;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 11, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:112:10: '<' '<'
                    {
                    match(input,LT,FOLLOW_LT_in_shiftOp779); 
                    match(input,LT,FOLLOW_LT_in_shiftOp781); 
                    value = Expression.Operator.SHIFT_LEFT;

                    }
                    break;
                case 2 :
                    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:113:10: '>' '>' '>'
                    {
                    match(input,GT,FOLLOW_GT_in_shiftOp794); 
                    match(input,GT,FOLLOW_GT_in_shiftOp796); 
                    match(input,GT,FOLLOW_GT_in_shiftOp798); 
                    value = Expression.Operator.U_SHIFT_RIGHT;

                    }
                    break;
                case 3 :
                    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:114:10: '>' '>'
                    {
                    match(input,GT,FOLLOW_GT_in_shiftOp811); 
                    match(input,GT,FOLLOW_GT_in_shiftOp813); 
                    value = Expression.Operator.SHIFT_RIGHT;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return value;
    }
    // $ANTLR end "shiftOp"


    // $ANTLR start "additiveExpression"
    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:117:1: additiveExpression returns [Expression value] : l= multiplicativeExpression ( ( '+' | '-' ) r= multiplicativeExpression )* ;
    public final Expression additiveExpression() throws RecognitionException {
        Expression value = null;

        Expression l = null;

        Expression r = null;


        try {
            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:118:5: (l= multiplicativeExpression ( ( '+' | '-' ) r= multiplicativeExpression )* )
            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:118:9: l= multiplicativeExpression ( ( '+' | '-' ) r= multiplicativeExpression )*
            {
            pushFollow(FOLLOW_multiplicativeExpression_in_additiveExpression844);
            l=multiplicativeExpression();

            state._fsp--;

            value = l; Expression.Operator op = null;
            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:119:9: ( ( '+' | '-' ) r= multiplicativeExpression )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>=PLUS && LA13_0<=SUB)) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:120:13: ( '+' | '-' ) r= multiplicativeExpression
            	    {
            	    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:120:13: ( '+' | '-' )
            	    int alt12=2;
            	    int LA12_0 = input.LA(1);

            	    if ( (LA12_0==PLUS) ) {
            	        alt12=1;
            	    }
            	    else if ( (LA12_0==SUB) ) {
            	        alt12=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 12, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt12) {
            	        case 1 :
            	            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:120:17: '+'
            	            {
            	            match(input,PLUS,FOLLOW_PLUS_in_additiveExpression876); 
            	            op = Expression.Operator.Plus;

            	            }
            	            break;
            	        case 2 :
            	            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:121:17: '-'
            	            {
            	            match(input,SUB,FOLLOW_SUB_in_additiveExpression896); 
            	            op = Expression.Operator.Minus;

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_multiplicativeExpression_in_additiveExpression931);
            	    r=multiplicativeExpression();

            	    state._fsp--;

            	    value = new BinaryExpression(op, value, r);

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return value;
    }
    // $ANTLR end "additiveExpression"


    // $ANTLR start "multiplicativeExpression"
    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:127:1: multiplicativeExpression returns [Expression value] : l= unaryExpressionNotPlusMinus ( ( '*' | '/' | '%' ) r= unaryExpressionNotPlusMinus )* ;
    public final Expression multiplicativeExpression() throws RecognitionException {
        Expression value = null;

        Expression l = null;

        Expression r = null;


        try {
            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:128:5: (l= unaryExpressionNotPlusMinus ( ( '*' | '/' | '%' ) r= unaryExpressionNotPlusMinus )* )
            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:129:9: l= unaryExpressionNotPlusMinus ( ( '*' | '/' | '%' ) r= unaryExpressionNotPlusMinus )*
            {
            pushFollow(FOLLOW_unaryExpressionNotPlusMinus_in_multiplicativeExpression983);
            l=unaryExpressionNotPlusMinus();

            state._fsp--;

            value = l; Expression.Operator op = null;
            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:130:9: ( ( '*' | '/' | '%' ) r= unaryExpressionNotPlusMinus )*
            loop15:
            do {
                int alt15=2;
                switch ( input.LA(1) ) {
                case STAR:
                    {
                    alt15=1;
                    }
                    break;
                case SLASH:
                    {
                    alt15=1;
                    }
                    break;
                case PERCENT:
                    {
                    alt15=1;
                    }
                    break;

                }

                switch (alt15) {
            	case 1 :
            	    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:131:13: ( '*' | '/' | '%' ) r= unaryExpressionNotPlusMinus
            	    {
            	    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:131:13: ( '*' | '/' | '%' )
            	    int alt14=3;
            	    switch ( input.LA(1) ) {
            	    case STAR:
            	        {
            	        alt14=1;
            	        }
            	        break;
            	    case SLASH:
            	        {
            	        alt14=2;
            	        }
            	        break;
            	    case PERCENT:
            	        {
            	        alt14=3;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 14, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt14) {
            	        case 1 :
            	            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:131:17: '*'
            	            {
            	            match(input,STAR,FOLLOW_STAR_in_multiplicativeExpression1016); 
            	            op = Expression.Operator.Times;

            	            }
            	            break;
            	        case 2 :
            	            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:132:17: '/'
            	            {
            	            match(input,SLASH,FOLLOW_SLASH_in_multiplicativeExpression1037); 
            	            op = Expression.Operator.Divide;

            	            }
            	            break;
            	        case 3 :
            	            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:133:17: '%'
            	            {
            	            match(input,PERCENT,FOLLOW_PERCENT_in_multiplicativeExpression1058); 
            	            op = Expression.Operator.Mod;

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_unaryExpressionNotPlusMinus_in_multiplicativeExpression1093);
            	    r=unaryExpressionNotPlusMinus();

            	    state._fsp--;

            	    value = new BinaryExpression(op, value, r);

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return value;
    }
    // $ANTLR end "multiplicativeExpression"


    // $ANTLR start "unaryExpressionNotPlusMinus"
    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:139:1: unaryExpressionNotPlusMinus returns [Expression value] : ( '~' l= multiplicativeExpression | '!' l= multiplicativeExpression | l= primary );
    public final Expression unaryExpressionNotPlusMinus() throws RecognitionException {
        Expression value = null;

        Expression l = null;


        try {
            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:140:5: ( '~' l= multiplicativeExpression | '!' l= multiplicativeExpression | l= primary )
            int alt16=3;
            switch ( input.LA(1) ) {
            case TILDE:
                {
                alt16=1;
                }
                break;
            case BANG:
                {
                alt16=2;
                }
                break;
            case IDENTIFIER:
            case INTLITERAL:
            case LONGLITERAL:
            case FLOATLITERAL:
            case DOUBLELITERAL:
            case STRINGLITERAL:
            case CHARLITERAL:
            case TRUE:
            case FALSE:
            case NULL:
            case LPAREN:
            case 49:
            case 50:
            case 51:
                {
                alt16=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:140:9: '~' l= multiplicativeExpression
                    {
                    match(input,TILDE,FOLLOW_TILDE_in_unaryExpressionNotPlusMinus1130); 
                    pushFollow(FOLLOW_multiplicativeExpression_in_unaryExpressionNotPlusMinus1134);
                    l=multiplicativeExpression();

                    state._fsp--;

                    value = new UnaryExpression(Expression.Operator.Tilde, l);

                    }
                    break;
                case 2 :
                    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:141:9: '!' l= multiplicativeExpression
                    {
                    match(input,BANG,FOLLOW_BANG_in_unaryExpressionNotPlusMinus1146); 
                    pushFollow(FOLLOW_multiplicativeExpression_in_unaryExpressionNotPlusMinus1150);
                    l=multiplicativeExpression();

                    state._fsp--;

                    value = new UnaryExpression(Expression.Operator.Not, l);

                    }
                    break;
                case 3 :
                    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:142:9: l= primary
                    {
                    pushFollow(FOLLOW_primary_in_unaryExpressionNotPlusMinus1164);
                    l=primary();

                    state._fsp--;

                    value = l;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return value;
    }
    // $ANTLR end "unaryExpressionNotPlusMinus"


    // $ANTLR start "primary"
    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:145:1: primary returns [Expression value] : (e= parExpression | '#super' (p= identifierSuffix )* | '#this' (p= identifierSuffix )* | '#iter' (p= identifierSuffix )* | IDENTIFIER (p= identifierSuffix )* | l= literal );
    public final Expression primary() throws RecognitionException {
        Expression value = null;

        Token IDENTIFIER1=null;
        Expression e = null;

        VarProperty p = null;

        Expression l = null;


        try {
            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:146:5: (e= parExpression | '#super' (p= identifierSuffix )* | '#this' (p= identifierSuffix )* | '#iter' (p= identifierSuffix )* | IDENTIFIER (p= identifierSuffix )* | l= literal )
            int alt21=6;
            switch ( input.LA(1) ) {
            case LPAREN:
                {
                alt21=1;
                }
                break;
            case 49:
                {
                alt21=2;
                }
                break;
            case 50:
                {
                alt21=3;
                }
                break;
            case 51:
                {
                alt21=4;
                }
                break;
            case IDENTIFIER:
                {
                alt21=5;
                }
                break;
            case INTLITERAL:
            case LONGLITERAL:
            case FLOATLITERAL:
            case DOUBLELITERAL:
            case STRINGLITERAL:
            case CHARLITERAL:
            case TRUE:
            case FALSE:
            case NULL:
                {
                alt21=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:146:9: e= parExpression
                    {
                    pushFollow(FOLLOW_parExpression_in_primary1192);
                    e=parExpression();

                    state._fsp--;

                    value = e;

                    }
                    break;
                case 2 :
                    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:147:9: '#super' (p= identifierSuffix )*
                    {
                    match(input,49,FOLLOW_49_in_primary1204); 
                    value = new VarExpression("#super");
                    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:147:58: (p= identifierSuffix )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==LBRACKET||LA17_0==DOT) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:147:59: p= identifierSuffix
                    	    {
                    	    pushFollow(FOLLOW_identifierSuffix_in_primary1211);
                    	    p=identifierSuffix();

                    	    state._fsp--;

                    	    ((VarExpression)value).addProperty(p);

                    	    }
                    	    break;

                    	default :
                    	    break loop17;
                        }
                    } while (true);


                    }
                    break;
                case 3 :
                    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:148:9: '#this' (p= identifierSuffix )*
                    {
                    match(input,50,FOLLOW_50_in_primary1225); 
                    value = new VarExpression("#this");
                    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:148:56: (p= identifierSuffix )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==LBRACKET||LA18_0==DOT) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:148:57: p= identifierSuffix
                    	    {
                    	    pushFollow(FOLLOW_identifierSuffix_in_primary1232);
                    	    p=identifierSuffix();

                    	    state._fsp--;

                    	    ((VarExpression)value).addProperty(p);

                    	    }
                    	    break;

                    	default :
                    	    break loop18;
                        }
                    } while (true);


                    }
                    break;
                case 4 :
                    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:149:9: '#iter' (p= identifierSuffix )*
                    {
                    match(input,51,FOLLOW_51_in_primary1246); 
                    value = new VarExpression("#iter");
                    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:149:56: (p= identifierSuffix )*
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==LBRACKET||LA19_0==DOT) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:149:57: p= identifierSuffix
                    	    {
                    	    pushFollow(FOLLOW_identifierSuffix_in_primary1253);
                    	    p=identifierSuffix();

                    	    state._fsp--;

                    	    ((VarExpression)value).addProperty(p);

                    	    }
                    	    break;

                    	default :
                    	    break loop19;
                        }
                    } while (true);


                    }
                    break;
                case 5 :
                    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:150:9: IDENTIFIER (p= identifierSuffix )*
                    {
                    IDENTIFIER1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_primary1267); 
                    value = new VarExpression((IDENTIFIER1!=null?IDENTIFIER1.getText():null));
                    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:150:68: (p= identifierSuffix )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==LBRACKET||LA20_0==DOT) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:150:69: p= identifierSuffix
                    	    {
                    	    pushFollow(FOLLOW_identifierSuffix_in_primary1274);
                    	    p=identifierSuffix();

                    	    state._fsp--;

                    	    ((VarExpression)value).addProperty(p);

                    	    }
                    	    break;

                    	default :
                    	    break loop20;
                        }
                    } while (true);


                    }
                    break;
                case 6 :
                    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:151:9: l= literal
                    {
                    pushFollow(FOLLOW_literal_in_primary1290);
                    l=literal();

                    state._fsp--;

                    value = l;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return value;
    }
    // $ANTLR end "primary"


    // $ANTLR start "identifierSuffix"
    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:154:1: identifierSuffix returns [VarProperty value] : ( '.' IDENTIFIER | '[' e= expression ']' );
    public final VarProperty identifierSuffix() throws RecognitionException {
        VarProperty value = null;

        Token IDENTIFIER2=null;
        Expression e = null;


        try {
            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:155:6: ( '.' IDENTIFIER | '[' e= expression ']' )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==DOT) ) {
                alt22=1;
            }
            else if ( (LA22_0==LBRACKET) ) {
                alt22=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:155:8: '.' IDENTIFIER
                    {
                    match(input,DOT,FOLLOW_DOT_in_identifierSuffix1318); 
                    IDENTIFIER2=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_identifierSuffix1320); 
                    value = new IdentifierVarProperty((IDENTIFIER2!=null?IDENTIFIER2.getText():null));

                    }
                    break;
                case 2 :
                    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:156:8: '[' e= expression ']'
                    {
                    match(input,LBRACKET,FOLLOW_LBRACKET_in_identifierSuffix1331); 
                    pushFollow(FOLLOW_expression_in_identifierSuffix1335);
                    e=expression();

                    state._fsp--;

                    match(input,RBRACKET,FOLLOW_RBRACKET_in_identifierSuffix1337); 
                    value = new MapVarProperty(e);

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return value;
    }
    // $ANTLR end "identifierSuffix"


    // $ANTLR start "literal"
    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:169:1: literal returns [Expression value] : ( INTLITERAL | LONGLITERAL | FLOATLITERAL | DOUBLELITERAL | STRINGLITERAL | CHARLITERAL | TRUE | FALSE | NULL );
    public final Expression literal() throws RecognitionException {
        Expression value = null;

        Token INTLITERAL3=null;
        Token LONGLITERAL4=null;
        Token FLOATLITERAL5=null;
        Token DOUBLELITERAL6=null;
        Token STRINGLITERAL7=null;
        Token CHARLITERAL8=null;

        try {
            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:170:5: ( INTLITERAL | LONGLITERAL | FLOATLITERAL | DOUBLELITERAL | STRINGLITERAL | CHARLITERAL | TRUE | FALSE | NULL )
            int alt23=9;
            switch ( input.LA(1) ) {
            case INTLITERAL:
                {
                alt23=1;
                }
                break;
            case LONGLITERAL:
                {
                alt23=2;
                }
                break;
            case FLOATLITERAL:
                {
                alt23=3;
                }
                break;
            case DOUBLELITERAL:
                {
                alt23=4;
                }
                break;
            case STRINGLITERAL:
                {
                alt23=5;
                }
                break;
            case CHARLITERAL:
                {
                alt23=6;
                }
                break;
            case TRUE:
                {
                alt23=7;
                }
                break;
            case FALSE:
                {
                alt23=8;
                }
                break;
            case NULL:
                {
                alt23=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:170:9: INTLITERAL
                    {
                    INTLITERAL3=(Token)match(input,INTLITERAL,FOLLOW_INTLITERAL_in_literal1370); 
                    value = new IntLiteral(Integer.parseInt((INTLITERAL3!=null?INTLITERAL3.getText():null)));

                    }
                    break;
                case 2 :
                    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:171:9: LONGLITERAL
                    {
                    LONGLITERAL4=(Token)match(input,LONGLITERAL,FOLLOW_LONGLITERAL_in_literal1382); 
                    value = new LongLiteral(Long.parseLong((LONGLITERAL4!=null?LONGLITERAL4.getText():null)));

                    }
                    break;
                case 3 :
                    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:172:9: FLOATLITERAL
                    {
                    FLOATLITERAL5=(Token)match(input,FLOATLITERAL,FOLLOW_FLOATLITERAL_in_literal1394); 
                    value = new FloatLiteral(Float.parseFloat((FLOATLITERAL5!=null?FLOATLITERAL5.getText():null)));

                    }
                    break;
                case 4 :
                    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:173:9: DOUBLELITERAL
                    {
                    DOUBLELITERAL6=(Token)match(input,DOUBLELITERAL,FOLLOW_DOUBLELITERAL_in_literal1406); 
                    value = new DoubleLiteral(Double.parseDouble((DOUBLELITERAL6!=null?DOUBLELITERAL6.getText():null)));

                    }
                    break;
                case 5 :
                    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:174:9: STRINGLITERAL
                    {
                    STRINGLITERAL7=(Token)match(input,STRINGLITERAL,FOLLOW_STRINGLITERAL_in_literal1418); 
                    value = new StringLiteral((STRINGLITERAL7!=null?STRINGLITERAL7.getText():null));

                    }
                    break;
                case 6 :
                    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:175:9: CHARLITERAL
                    {
                    CHARLITERAL8=(Token)match(input,CHARLITERAL,FOLLOW_CHARLITERAL_in_literal1430); 
                    value = new StringLiteral((CHARLITERAL8!=null?CHARLITERAL8.getText():null));

                    }
                    break;
                case 7 :
                    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:176:9: TRUE
                    {
                    match(input,TRUE,FOLLOW_TRUE_in_literal1442); 
                    value = new BooleanLiteral(true);

                    }
                    break;
                case 8 :
                    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:177:9: FALSE
                    {
                    match(input,FALSE,FOLLOW_FALSE_in_literal1454); 
                    value = new BooleanLiteral(false);

                    }
                    break;
                case 9 :
                    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:178:9: NULL
                    {
                    match(input,NULL,FOLLOW_NULL_in_literal1466); 
                    value = NullLiteral.instance;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return value;
    }
    // $ANTLR end "literal"

    // Delegated rules


 

    public static final BitSet FOLLOW_expression_in_compilationUnit56 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_parExpression82 = new BitSet(new long[]{0x000E000182003FF0L});
    public static final BitSet FOLLOW_expression_in_parExpression86 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_RPAREN_in_parExpression88 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_conditionalAndExpression_in_expression121 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_BARBAR_in_expression134 = new BitSet(new long[]{0x000E000182003FF0L});
    public static final BitSet FOLLOW_conditionalAndExpression_in_expression140 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_inclusiveOrExpression_in_conditionalAndExpression185 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_AMPAMP_in_conditionalAndExpression198 = new BitSet(new long[]{0x000E000182003FF0L});
    public static final BitSet FOLLOW_inclusiveOrExpression_in_conditionalAndExpression204 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_exclusiveOrExpression_in_inclusiveOrExpression249 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_BAR_in_inclusiveOrExpression262 = new BitSet(new long[]{0x000E000182003FF0L});
    public static final BitSet FOLLOW_exclusiveOrExpression_in_inclusiveOrExpression268 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_andExpression_in_exclusiveOrExpression313 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_CARET_in_exclusiveOrExpression326 = new BitSet(new long[]{0x000E000182003FF0L});
    public static final BitSet FOLLOW_andExpression_in_exclusiveOrExpression332 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_equalityExpression_in_andExpression376 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_AMP_in_andExpression389 = new BitSet(new long[]{0x000E000182003FF0L});
    public static final BitSet FOLLOW_equalityExpression_in_andExpression395 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_relationalExpression_in_equalityExpression440 = new BitSet(new long[]{0x0000100200000002L});
    public static final BitSet FOLLOW_EQEQ_in_equalityExpression472 = new BitSet(new long[]{0x000E000182003FF0L});
    public static final BitSet FOLLOW_BANGEQ_in_equalityExpression492 = new BitSet(new long[]{0x000E000182003FF0L});
    public static final BitSet FOLLOW_relationalExpression_in_equalityExpression526 = new BitSet(new long[]{0x0000100200000002L});
    public static final BitSet FOLLOW_shiftExpression_in_relationalExpression566 = new BitSet(new long[]{0x0000600000000002L});
    public static final BitSet FOLLOW_relationalOp_in_relationalExpression592 = new BitSet(new long[]{0x000E000182003FF0L});
    public static final BitSet FOLLOW_shiftExpression_in_relationalExpression596 = new BitSet(new long[]{0x0000600000000002L});
    public static final BitSet FOLLOW_LT_in_relationalOp638 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_EQ_in_relationalOp640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GT_in_relationalOp653 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_EQ_in_relationalOp655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LT_in_relationalOp667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GT_in_relationalOp679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_additiveExpression_in_shiftExpression710 = new BitSet(new long[]{0x0000600000000002L});
    public static final BitSet FOLLOW_shiftOp_in_shiftExpression736 = new BitSet(new long[]{0x000E000182003FF0L});
    public static final BitSet FOLLOW_additiveExpression_in_shiftExpression740 = new BitSet(new long[]{0x0000600000000002L});
    public static final BitSet FOLLOW_LT_in_shiftOp779 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_LT_in_shiftOp781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GT_in_shiftOp794 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_GT_in_shiftOp796 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_GT_in_shiftOp798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GT_in_shiftOp811 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_GT_in_shiftOp813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_multiplicativeExpression_in_additiveExpression844 = new BitSet(new long[]{0x0000003000000002L});
    public static final BitSet FOLLOW_PLUS_in_additiveExpression876 = new BitSet(new long[]{0x000E000182003FF0L});
    public static final BitSet FOLLOW_SUB_in_additiveExpression896 = new BitSet(new long[]{0x000E000182003FF0L});
    public static final BitSet FOLLOW_multiplicativeExpression_in_additiveExpression931 = new BitSet(new long[]{0x0000003000000002L});
    public static final BitSet FOLLOW_unaryExpressionNotPlusMinus_in_multiplicativeExpression983 = new BitSet(new long[]{0x000008C000000002L});
    public static final BitSet FOLLOW_STAR_in_multiplicativeExpression1016 = new BitSet(new long[]{0x000E000182003FF0L});
    public static final BitSet FOLLOW_SLASH_in_multiplicativeExpression1037 = new BitSet(new long[]{0x000E000182003FF0L});
    public static final BitSet FOLLOW_PERCENT_in_multiplicativeExpression1058 = new BitSet(new long[]{0x000E000182003FF0L});
    public static final BitSet FOLLOW_unaryExpressionNotPlusMinus_in_multiplicativeExpression1093 = new BitSet(new long[]{0x000008C000000002L});
    public static final BitSet FOLLOW_TILDE_in_unaryExpressionNotPlusMinus1130 = new BitSet(new long[]{0x000E000182003FF0L});
    public static final BitSet FOLLOW_multiplicativeExpression_in_unaryExpressionNotPlusMinus1134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BANG_in_unaryExpressionNotPlusMinus1146 = new BitSet(new long[]{0x000E000182003FF0L});
    public static final BitSet FOLLOW_multiplicativeExpression_in_unaryExpressionNotPlusMinus1150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_in_unaryExpressionNotPlusMinus1164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parExpression_in_primary1192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_primary1204 = new BitSet(new long[]{0x0000000028000002L});
    public static final BitSet FOLLOW_identifierSuffix_in_primary1211 = new BitSet(new long[]{0x0000000028000002L});
    public static final BitSet FOLLOW_50_in_primary1225 = new BitSet(new long[]{0x0000000028000002L});
    public static final BitSet FOLLOW_identifierSuffix_in_primary1232 = new BitSet(new long[]{0x0000000028000002L});
    public static final BitSet FOLLOW_51_in_primary1246 = new BitSet(new long[]{0x0000000028000002L});
    public static final BitSet FOLLOW_identifierSuffix_in_primary1253 = new BitSet(new long[]{0x0000000028000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_primary1267 = new BitSet(new long[]{0x0000000028000002L});
    public static final BitSet FOLLOW_identifierSuffix_in_primary1274 = new BitSet(new long[]{0x0000000028000002L});
    public static final BitSet FOLLOW_literal_in_primary1290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_identifierSuffix1318 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENTIFIER_in_identifierSuffix1320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_identifierSuffix1331 = new BitSet(new long[]{0x000E000182003FF0L});
    public static final BitSet FOLLOW_expression_in_identifierSuffix1335 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_RBRACKET_in_identifierSuffix1337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTLITERAL_in_literal1370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONGLITERAL_in_literal1382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOATLITERAL_in_literal1394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLELITERAL_in_literal1406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRINGLITERAL_in_literal1418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHARLITERAL_in_literal1430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_literal1442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_literal1454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_in_literal1466 = new BitSet(new long[]{0x0000000000000002L});

}