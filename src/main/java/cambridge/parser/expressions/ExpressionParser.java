// $ANTLR 3.2 Sep 23, 2009 12:02:23 /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g 2009-11-10 00:05:42

package cambridge.parser.expressions;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class ExpressionParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "IDENTIFIER", "INTLITERAL", "LONGLITERAL", "FLOATLITERAL", "DOUBLELITERAL", "STRINGLITERAL", "CHARLITERAL", "TRUE", "FALSE", "NULL", "IntegerNumber", "LongSuffix", "HexPrefix", "HexDigit", "Exponent", "NonIntegerNumber", "FloatSuffix", "DoubleSuffix", "EscapeSequence", "WS", "SUPER", "LPAREN", "RPAREN", "LBRACKET", "RBRACKET", "DOT", "EQ", "BANG", "TILDE", "EQEQ", "AMPAMP", "BARBAR", "PLUS", "SUB", "STAR", "SLASH", "AMP", "BAR", "CARET", "PERCENT", "BANGEQ", "GT", "LT", "LETTER", "JavaIDDigit", "','", "'#super'", "'#this'", "'#iter'"
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
    public static final int T__52=52;
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


    // $ANTLR start "function"
    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:50:1: function returns [Expression value] : IDENTIFIER '(' e= expression ( ',' f= expression )* ')' ;
    public final Expression function() throws RecognitionException {
        Expression value = null;

        Token IDENTIFIER1=null;
        Expression e = null;

        Expression f = null;


        try {
            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:51:5: ( IDENTIFIER '(' e= expression ( ',' f= expression )* ')' )
            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:51:9: IDENTIFIER '(' e= expression ( ',' f= expression )* ')'
            {
            IDENTIFIER1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_function113); 
            match(input,LPAREN,FOLLOW_LPAREN_in_function115); 
            pushFollow(FOLLOW_expression_in_function119);
            e=expression();

            state._fsp--;

            value = new FunctionExpression((IDENTIFIER1!=null?IDENTIFIER1.getText():null));
                ArrayList<Expression> params = new ArrayList<Expression>();
                params.add(e);
                
            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:55:7: ( ',' f= expression )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==49) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:55:8: ',' f= expression
            	    {
            	    match(input,49,FOLLOW_49_in_function128); 
            	    pushFollow(FOLLOW_expression_in_function132);
            	    f=expression();

            	    state._fsp--;

            	     params.add(f);

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            match(input,RPAREN,FOLLOW_RPAREN_in_function138); 
            ((FunctionExpression)value).setParameters(params);

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
    // $ANTLR end "function"


    // $ANTLR start "expression"
    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:58:1: expression returns [Expression value] : l= conditionalAndExpression ( '||' r= conditionalAndExpression )* ;
    public final Expression expression() throws RecognitionException {
        Expression value = null;

        Expression l = null;

        Expression r = null;


        try {
            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:59:5: (l= conditionalAndExpression ( '||' r= conditionalAndExpression )* )
            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:59:9: l= conditionalAndExpression ( '||' r= conditionalAndExpression )*
            {
            pushFollow(FOLLOW_conditionalAndExpression_in_expression171);
            l=conditionalAndExpression();

            state._fsp--;

            value = l;
            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:60:9: ( '||' r= conditionalAndExpression )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==BARBAR) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:60:10: '||' r= conditionalAndExpression
            	    {
            	    match(input,BARBAR,FOLLOW_BARBAR_in_expression184); 
            	    pushFollow(FOLLOW_conditionalAndExpression_in_expression190);
            	    r=conditionalAndExpression();

            	    state._fsp--;

            	    value = new BinaryExpression(Expression.Operator.ConditionalOr, value, r);

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
    // $ANTLR end "expression"


    // $ANTLR start "conditionalAndExpression"
    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:64:1: conditionalAndExpression returns [Expression value] : l= inclusiveOrExpression ( '&&' r= inclusiveOrExpression )* ;
    public final Expression conditionalAndExpression() throws RecognitionException {
        Expression value = null;

        Expression l = null;

        Expression r = null;


        try {
            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:65:5: (l= inclusiveOrExpression ( '&&' r= inclusiveOrExpression )* )
            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:65:9: l= inclusiveOrExpression ( '&&' r= inclusiveOrExpression )*
            {
            pushFollow(FOLLOW_inclusiveOrExpression_in_conditionalAndExpression235);
            l=inclusiveOrExpression();

            state._fsp--;

            value = l;
            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:66:9: ( '&&' r= inclusiveOrExpression )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==AMPAMP) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:66:10: '&&' r= inclusiveOrExpression
            	    {
            	    match(input,AMPAMP,FOLLOW_AMPAMP_in_conditionalAndExpression248); 
            	    pushFollow(FOLLOW_inclusiveOrExpression_in_conditionalAndExpression254);
            	    r=inclusiveOrExpression();

            	    state._fsp--;

            	    value = new BinaryExpression(Expression.Operator.ConditionalAnd, value, r);

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
    // $ANTLR end "conditionalAndExpression"


    // $ANTLR start "inclusiveOrExpression"
    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:70:1: inclusiveOrExpression returns [Expression value] : l= exclusiveOrExpression ( '|' r= exclusiveOrExpression )* ;
    public final Expression inclusiveOrExpression() throws RecognitionException {
        Expression value = null;

        Expression l = null;

        Expression r = null;


        try {
            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:71:5: (l= exclusiveOrExpression ( '|' r= exclusiveOrExpression )* )
            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:71:9: l= exclusiveOrExpression ( '|' r= exclusiveOrExpression )*
            {
            pushFollow(FOLLOW_exclusiveOrExpression_in_inclusiveOrExpression299);
            l=exclusiveOrExpression();

            state._fsp--;

            value = l;
            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:72:9: ( '|' r= exclusiveOrExpression )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==BAR) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:72:10: '|' r= exclusiveOrExpression
            	    {
            	    match(input,BAR,FOLLOW_BAR_in_inclusiveOrExpression312); 
            	    pushFollow(FOLLOW_exclusiveOrExpression_in_inclusiveOrExpression318);
            	    r=exclusiveOrExpression();

            	    state._fsp--;

            	    value = new BinaryExpression(Expression.Operator.Or, value, r);

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
    // $ANTLR end "inclusiveOrExpression"


    // $ANTLR start "exclusiveOrExpression"
    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:76:1: exclusiveOrExpression returns [Expression value] : l= andExpression ( '^' r= andExpression )* ;
    public final Expression exclusiveOrExpression() throws RecognitionException {
        Expression value = null;

        Expression l = null;

        Expression r = null;


        try {
            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:77:5: (l= andExpression ( '^' r= andExpression )* )
            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:77:9: l= andExpression ( '^' r= andExpression )*
            {
            pushFollow(FOLLOW_andExpression_in_exclusiveOrExpression363);
            l=andExpression();

            state._fsp--;

            value = l;
            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:78:9: ( '^' r= andExpression )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==CARET) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:78:10: '^' r= andExpression
            	    {
            	    match(input,CARET,FOLLOW_CARET_in_exclusiveOrExpression376); 
            	    pushFollow(FOLLOW_andExpression_in_exclusiveOrExpression382);
            	    r=andExpression();

            	    state._fsp--;

            	    value = new BinaryExpression(Expression.Operator.XOr, value, r);

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
    // $ANTLR end "exclusiveOrExpression"


    // $ANTLR start "andExpression"
    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:82:1: andExpression returns [Expression value] : l= equalityExpression ( '&' r= equalityExpression )* ;
    public final Expression andExpression() throws RecognitionException {
        Expression value = null;

        Expression l = null;

        Expression r = null;


        try {
            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:83:5: (l= equalityExpression ( '&' r= equalityExpression )* )
            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:83:9: l= equalityExpression ( '&' r= equalityExpression )*
            {
            pushFollow(FOLLOW_equalityExpression_in_andExpression426);
            l=equalityExpression();

            state._fsp--;

            value = l;
            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:84:9: ( '&' r= equalityExpression )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==AMP) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:84:10: '&' r= equalityExpression
            	    {
            	    match(input,AMP,FOLLOW_AMP_in_andExpression439); 
            	    pushFollow(FOLLOW_equalityExpression_in_andExpression445);
            	    r=equalityExpression();

            	    state._fsp--;

            	    value = new BinaryExpression(Expression.Operator.And, value, r);

            	    }
            	    break;

            	default :
            	    break loop6;
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
    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:88:1: equalityExpression returns [Expression value] : l= relationalExpression ( ( '==' | '!=' ) r= relationalExpression )* ;
    public final Expression equalityExpression() throws RecognitionException {
        Expression value = null;

        Expression l = null;

        Expression r = null;


        try {
            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:89:5: (l= relationalExpression ( ( '==' | '!=' ) r= relationalExpression )* )
            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:89:9: l= relationalExpression ( ( '==' | '!=' ) r= relationalExpression )*
            {
            pushFollow(FOLLOW_relationalExpression_in_equalityExpression490);
            l=relationalExpression();

            state._fsp--;

            value = l; Expression.Operator op = null;
            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:90:9: ( ( '==' | '!=' ) r= relationalExpression )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==EQEQ||LA8_0==BANGEQ) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:91:13: ( '==' | '!=' ) r= relationalExpression
            	    {
            	    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:91:13: ( '==' | '!=' )
            	    int alt7=2;
            	    int LA7_0 = input.LA(1);

            	    if ( (LA7_0==EQEQ) ) {
            	        alt7=1;
            	    }
            	    else if ( (LA7_0==BANGEQ) ) {
            	        alt7=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 7, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt7) {
            	        case 1 :
            	            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:91:17: '=='
            	            {
            	            match(input,EQEQ,FOLLOW_EQEQ_in_equalityExpression522); 
            	            op = Expression.Operator.Equal;

            	            }
            	            break;
            	        case 2 :
            	            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:92:17: '!='
            	            {
            	            match(input,BANGEQ,FOLLOW_BANGEQ_in_equalityExpression542); 
            	            op = Expression.Operator.NotEqual;

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_relationalExpression_in_equalityExpression576);
            	    r=relationalExpression();

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
    // $ANTLR end "equalityExpression"


    // $ANTLR start "relationalExpression"
    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:98:1: relationalExpression returns [Expression value] : l= shiftExpression (op= relationalOp r= shiftExpression )* ;
    public final Expression relationalExpression() throws RecognitionException {
        Expression value = null;

        Expression l = null;

        Expression.Operator op = null;

        Expression r = null;


        try {
            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:99:5: (l= shiftExpression (op= relationalOp r= shiftExpression )* )
            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:99:9: l= shiftExpression (op= relationalOp r= shiftExpression )*
            {
            pushFollow(FOLLOW_shiftExpression_in_relationalExpression616);
            l=shiftExpression();

            state._fsp--;

            value = l;
            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:100:9: (op= relationalOp r= shiftExpression )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>=GT && LA9_0<=LT)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:101:9: op= relationalOp r= shiftExpression
            	    {
            	    pushFollow(FOLLOW_relationalOp_in_relationalExpression642);
            	    op=relationalOp();

            	    state._fsp--;

            	    pushFollow(FOLLOW_shiftExpression_in_relationalExpression646);
            	    r=shiftExpression();

            	    state._fsp--;

            	    value = new BinaryExpression(op, value, r);

            	    }
            	    break;

            	default :
            	    break loop9;
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
    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:105:1: relationalOp returns [Expression.Operator value] : ( '<' '=' | '>' '=' | '<' | '>' );
    public final Expression.Operator relationalOp() throws RecognitionException {
        Expression.Operator value = null;

        try {
            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:106:5: ( '<' '=' | '>' '=' | '<' | '>' )
            int alt10=4;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==LT) ) {
                int LA10_1 = input.LA(2);

                if ( (LA10_1==EQ) ) {
                    alt10=1;
                }
                else if ( ((LA10_1>=IDENTIFIER && LA10_1<=NULL)||LA10_1==LPAREN||(LA10_1>=BANG && LA10_1<=TILDE)||(LA10_1>=50 && LA10_1<=52)) ) {
                    alt10=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 10, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA10_0==GT) ) {
                int LA10_2 = input.LA(2);

                if ( (LA10_2==EQ) ) {
                    alt10=2;
                }
                else if ( ((LA10_2>=IDENTIFIER && LA10_2<=NULL)||LA10_2==LPAREN||(LA10_2>=BANG && LA10_2<=TILDE)||(LA10_2>=50 && LA10_2<=52)) ) {
                    alt10=4;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 10, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:106:10: '<' '='
                    {
                    match(input,LT,FOLLOW_LT_in_relationalOp688); 
                    match(input,EQ,FOLLOW_EQ_in_relationalOp690); 
                    value = Expression.Operator.LTE;

                    }
                    break;
                case 2 :
                    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:107:10: '>' '='
                    {
                    match(input,GT,FOLLOW_GT_in_relationalOp703); 
                    match(input,EQ,FOLLOW_EQ_in_relationalOp705); 
                    value = Expression.Operator.GTE;

                    }
                    break;
                case 3 :
                    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:108:9: '<'
                    {
                    match(input,LT,FOLLOW_LT_in_relationalOp717); 
                    value = Expression.Operator.LT;

                    }
                    break;
                case 4 :
                    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:109:9: '>'
                    {
                    match(input,GT,FOLLOW_GT_in_relationalOp729); 
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
    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:112:1: shiftExpression returns [Expression value] : l= additiveExpression (op= shiftOp r= additiveExpression )* ;
    public final Expression shiftExpression() throws RecognitionException {
        Expression value = null;

        Expression l = null;

        Expression.Operator op = null;

        Expression r = null;


        try {
            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:113:5: (l= additiveExpression (op= shiftOp r= additiveExpression )* )
            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:113:9: l= additiveExpression (op= shiftOp r= additiveExpression )*
            {
            pushFollow(FOLLOW_additiveExpression_in_shiftExpression760);
            l=additiveExpression();

            state._fsp--;

            value = l;
            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:114:9: (op= shiftOp r= additiveExpression )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==LT) ) {
                    int LA11_1 = input.LA(2);

                    if ( (LA11_1==LT) ) {
                        alt11=1;
                    }


                }
                else if ( (LA11_0==GT) ) {
                    int LA11_2 = input.LA(2);

                    if ( (LA11_2==GT) ) {
                        alt11=1;
                    }


                }


                switch (alt11) {
            	case 1 :
            	    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:115:9: op= shiftOp r= additiveExpression
            	    {
            	    pushFollow(FOLLOW_shiftOp_in_shiftExpression786);
            	    op=shiftOp();

            	    state._fsp--;

            	    pushFollow(FOLLOW_additiveExpression_in_shiftExpression790);
            	    r=additiveExpression();

            	    state._fsp--;

            	    value = new BinaryExpression(op, value, r);

            	    }
            	    break;

            	default :
            	    break loop11;
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
    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:119:1: shiftOp returns [Expression.Operator value] : ( '<' '<' | '>' '>' '>' | '>' '>' );
    public final Expression.Operator shiftOp() throws RecognitionException {
        Expression.Operator value = null;

        try {
            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:120:5: ( '<' '<' | '>' '>' '>' | '>' '>' )
            int alt12=3;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==LT) ) {
                alt12=1;
            }
            else if ( (LA12_0==GT) ) {
                int LA12_2 = input.LA(2);

                if ( (LA12_2==GT) ) {
                    int LA12_3 = input.LA(3);

                    if ( (LA12_3==GT) ) {
                        alt12=2;
                    }
                    else if ( ((LA12_3>=IDENTIFIER && LA12_3<=NULL)||LA12_3==LPAREN||(LA12_3>=BANG && LA12_3<=TILDE)||(LA12_3>=50 && LA12_3<=52)) ) {
                        alt12=3;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 12, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:120:10: '<' '<'
                    {
                    match(input,LT,FOLLOW_LT_in_shiftOp829); 
                    match(input,LT,FOLLOW_LT_in_shiftOp831); 
                    value = Expression.Operator.SHIFT_LEFT;

                    }
                    break;
                case 2 :
                    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:121:10: '>' '>' '>'
                    {
                    match(input,GT,FOLLOW_GT_in_shiftOp844); 
                    match(input,GT,FOLLOW_GT_in_shiftOp846); 
                    match(input,GT,FOLLOW_GT_in_shiftOp848); 
                    value = Expression.Operator.U_SHIFT_RIGHT;

                    }
                    break;
                case 3 :
                    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:122:10: '>' '>'
                    {
                    match(input,GT,FOLLOW_GT_in_shiftOp861); 
                    match(input,GT,FOLLOW_GT_in_shiftOp863); 
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
    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:125:1: additiveExpression returns [Expression value] : l= multiplicativeExpression ( ( '+' | '-' ) r= multiplicativeExpression )* ;
    public final Expression additiveExpression() throws RecognitionException {
        Expression value = null;

        Expression l = null;

        Expression r = null;


        try {
            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:126:5: (l= multiplicativeExpression ( ( '+' | '-' ) r= multiplicativeExpression )* )
            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:126:9: l= multiplicativeExpression ( ( '+' | '-' ) r= multiplicativeExpression )*
            {
            pushFollow(FOLLOW_multiplicativeExpression_in_additiveExpression894);
            l=multiplicativeExpression();

            state._fsp--;

            value = l; Expression.Operator op = null;
            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:127:9: ( ( '+' | '-' ) r= multiplicativeExpression )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0>=PLUS && LA14_0<=SUB)) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:128:13: ( '+' | '-' ) r= multiplicativeExpression
            	    {
            	    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:128:13: ( '+' | '-' )
            	    int alt13=2;
            	    int LA13_0 = input.LA(1);

            	    if ( (LA13_0==PLUS) ) {
            	        alt13=1;
            	    }
            	    else if ( (LA13_0==SUB) ) {
            	        alt13=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 13, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt13) {
            	        case 1 :
            	            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:128:17: '+'
            	            {
            	            match(input,PLUS,FOLLOW_PLUS_in_additiveExpression926); 
            	            op = Expression.Operator.Plus;

            	            }
            	            break;
            	        case 2 :
            	            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:129:17: '-'
            	            {
            	            match(input,SUB,FOLLOW_SUB_in_additiveExpression946); 
            	            op = Expression.Operator.Minus;

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_multiplicativeExpression_in_additiveExpression981);
            	    r=multiplicativeExpression();

            	    state._fsp--;

            	    value = new BinaryExpression(op, value, r);

            	    }
            	    break;

            	default :
            	    break loop14;
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
    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:135:1: multiplicativeExpression returns [Expression value] : l= unaryExpressionNotPlusMinus ( ( '*' | '/' | '%' ) r= unaryExpressionNotPlusMinus )* ;
    public final Expression multiplicativeExpression() throws RecognitionException {
        Expression value = null;

        Expression l = null;

        Expression r = null;


        try {
            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:136:5: (l= unaryExpressionNotPlusMinus ( ( '*' | '/' | '%' ) r= unaryExpressionNotPlusMinus )* )
            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:137:9: l= unaryExpressionNotPlusMinus ( ( '*' | '/' | '%' ) r= unaryExpressionNotPlusMinus )*
            {
            pushFollow(FOLLOW_unaryExpressionNotPlusMinus_in_multiplicativeExpression1033);
            l=unaryExpressionNotPlusMinus();

            state._fsp--;

            value = l; Expression.Operator op = null;
            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:138:9: ( ( '*' | '/' | '%' ) r= unaryExpressionNotPlusMinus )*
            loop16:
            do {
                int alt16=2;
                switch ( input.LA(1) ) {
                case STAR:
                    {
                    alt16=1;
                    }
                    break;
                case SLASH:
                    {
                    alt16=1;
                    }
                    break;
                case PERCENT:
                    {
                    alt16=1;
                    }
                    break;

                }

                switch (alt16) {
            	case 1 :
            	    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:139:13: ( '*' | '/' | '%' ) r= unaryExpressionNotPlusMinus
            	    {
            	    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:139:13: ( '*' | '/' | '%' )
            	    int alt15=3;
            	    switch ( input.LA(1) ) {
            	    case STAR:
            	        {
            	        alt15=1;
            	        }
            	        break;
            	    case SLASH:
            	        {
            	        alt15=2;
            	        }
            	        break;
            	    case PERCENT:
            	        {
            	        alt15=3;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 15, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt15) {
            	        case 1 :
            	            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:139:17: '*'
            	            {
            	            match(input,STAR,FOLLOW_STAR_in_multiplicativeExpression1066); 
            	            op = Expression.Operator.Times;

            	            }
            	            break;
            	        case 2 :
            	            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:140:17: '/'
            	            {
            	            match(input,SLASH,FOLLOW_SLASH_in_multiplicativeExpression1087); 
            	            op = Expression.Operator.Divide;

            	            }
            	            break;
            	        case 3 :
            	            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:141:17: '%'
            	            {
            	            match(input,PERCENT,FOLLOW_PERCENT_in_multiplicativeExpression1108); 
            	            op = Expression.Operator.Mod;

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_unaryExpressionNotPlusMinus_in_multiplicativeExpression1143);
            	    r=unaryExpressionNotPlusMinus();

            	    state._fsp--;

            	    value = new BinaryExpression(op, value, r);

            	    }
            	    break;

            	default :
            	    break loop16;
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
    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:147:1: unaryExpressionNotPlusMinus returns [Expression value] : ( '~' l= multiplicativeExpression | '!' l= multiplicativeExpression | l= primary );
    public final Expression unaryExpressionNotPlusMinus() throws RecognitionException {
        Expression value = null;

        Expression l = null;


        try {
            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:148:5: ( '~' l= multiplicativeExpression | '!' l= multiplicativeExpression | l= primary )
            int alt17=3;
            switch ( input.LA(1) ) {
            case TILDE:
                {
                alt17=1;
                }
                break;
            case BANG:
                {
                alt17=2;
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
            case 50:
            case 51:
            case 52:
                {
                alt17=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:148:9: '~' l= multiplicativeExpression
                    {
                    match(input,TILDE,FOLLOW_TILDE_in_unaryExpressionNotPlusMinus1180); 
                    pushFollow(FOLLOW_multiplicativeExpression_in_unaryExpressionNotPlusMinus1184);
                    l=multiplicativeExpression();

                    state._fsp--;

                    value = new UnaryExpression(Expression.Operator.Tilde, l);

                    }
                    break;
                case 2 :
                    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:149:9: '!' l= multiplicativeExpression
                    {
                    match(input,BANG,FOLLOW_BANG_in_unaryExpressionNotPlusMinus1196); 
                    pushFollow(FOLLOW_multiplicativeExpression_in_unaryExpressionNotPlusMinus1200);
                    l=multiplicativeExpression();

                    state._fsp--;

                    value = new UnaryExpression(Expression.Operator.Not, l);

                    }
                    break;
                case 3 :
                    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:150:9: l= primary
                    {
                    pushFollow(FOLLOW_primary_in_unaryExpressionNotPlusMinus1214);
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
    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:153:1: primary returns [Expression value] : (e= parExpression | e= function | '#super' (p= identifierSuffix )* | '#this' (p= identifierSuffix )* | '#iter' (p= identifierSuffix )* | IDENTIFIER (p= identifierSuffix )* | l= literal );
    public final Expression primary() throws RecognitionException {
        Expression value = null;

        Token IDENTIFIER2=null;
        Expression e = null;

        VarProperty p = null;

        Expression l = null;


        try {
            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:154:5: (e= parExpression | e= function | '#super' (p= identifierSuffix )* | '#this' (p= identifierSuffix )* | '#iter' (p= identifierSuffix )* | IDENTIFIER (p= identifierSuffix )* | l= literal )
            int alt22=7;
            switch ( input.LA(1) ) {
            case LPAREN:
                {
                alt22=1;
                }
                break;
            case IDENTIFIER:
                {
                int LA22_2 = input.LA(2);

                if ( (LA22_2==LPAREN) ) {
                    alt22=2;
                }
                else if ( (LA22_2==EOF||(LA22_2>=RPAREN && LA22_2<=DOT)||(LA22_2>=EQEQ && LA22_2<=LT)||LA22_2==49) ) {
                    alt22=6;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 22, 2, input);

                    throw nvae;
                }
                }
                break;
            case 50:
                {
                alt22=3;
                }
                break;
            case 51:
                {
                alt22=4;
                }
                break;
            case 52:
                {
                alt22=5;
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
                alt22=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:154:9: e= parExpression
                    {
                    pushFollow(FOLLOW_parExpression_in_primary1242);
                    e=parExpression();

                    state._fsp--;

                    value = e;

                    }
                    break;
                case 2 :
                    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:155:9: e= function
                    {
                    pushFollow(FOLLOW_function_in_primary1256);
                    e=function();

                    state._fsp--;

                    value = e;

                    }
                    break;
                case 3 :
                    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:156:9: '#super' (p= identifierSuffix )*
                    {
                    match(input,50,FOLLOW_50_in_primary1268); 
                    value = new VarExpression("#super");
                    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:156:58: (p= identifierSuffix )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==LBRACKET||LA18_0==DOT) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:156:59: p= identifierSuffix
                    	    {
                    	    pushFollow(FOLLOW_identifierSuffix_in_primary1275);
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
                    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:157:9: '#this' (p= identifierSuffix )*
                    {
                    match(input,51,FOLLOW_51_in_primary1289); 
                    value = new VarExpression("#this");
                    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:157:56: (p= identifierSuffix )*
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==LBRACKET||LA19_0==DOT) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:157:57: p= identifierSuffix
                    	    {
                    	    pushFollow(FOLLOW_identifierSuffix_in_primary1296);
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
                    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:158:9: '#iter' (p= identifierSuffix )*
                    {
                    match(input,52,FOLLOW_52_in_primary1310); 
                    value = new VarExpression("#iter");
                    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:158:56: (p= identifierSuffix )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==LBRACKET||LA20_0==DOT) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:158:57: p= identifierSuffix
                    	    {
                    	    pushFollow(FOLLOW_identifierSuffix_in_primary1317);
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
                    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:159:9: IDENTIFIER (p= identifierSuffix )*
                    {
                    IDENTIFIER2=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_primary1331); 
                    value = new VarExpression((IDENTIFIER2!=null?IDENTIFIER2.getText():null));
                    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:159:68: (p= identifierSuffix )*
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0==LBRACKET||LA21_0==DOT) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:159:69: p= identifierSuffix
                    	    {
                    	    pushFollow(FOLLOW_identifierSuffix_in_primary1338);
                    	    p=identifierSuffix();

                    	    state._fsp--;

                    	    ((VarExpression)value).addProperty(p);

                    	    }
                    	    break;

                    	default :
                    	    break loop21;
                        }
                    } while (true);


                    }
                    break;
                case 7 :
                    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:160:9: l= literal
                    {
                    pushFollow(FOLLOW_literal_in_primary1354);
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
    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:163:1: identifierSuffix returns [VarProperty value] : ( '.' IDENTIFIER | '[' e= expression ']' );
    public final VarProperty identifierSuffix() throws RecognitionException {
        VarProperty value = null;

        Token IDENTIFIER3=null;
        Expression e = null;


        try {
            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:164:6: ( '.' IDENTIFIER | '[' e= expression ']' )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==DOT) ) {
                alt23=1;
            }
            else if ( (LA23_0==LBRACKET) ) {
                alt23=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:164:8: '.' IDENTIFIER
                    {
                    match(input,DOT,FOLLOW_DOT_in_identifierSuffix1382); 
                    IDENTIFIER3=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_identifierSuffix1384); 
                    value = new IdentifierVarProperty((IDENTIFIER3!=null?IDENTIFIER3.getText():null));

                    }
                    break;
                case 2 :
                    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:165:8: '[' e= expression ']'
                    {
                    match(input,LBRACKET,FOLLOW_LBRACKET_in_identifierSuffix1395); 
                    pushFollow(FOLLOW_expression_in_identifierSuffix1399);
                    e=expression();

                    state._fsp--;

                    match(input,RBRACKET,FOLLOW_RBRACKET_in_identifierSuffix1401); 
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
    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:178:1: literal returns [Expression value] : ( INTLITERAL | LONGLITERAL | FLOATLITERAL | DOUBLELITERAL | STRINGLITERAL | CHARLITERAL | TRUE | FALSE | NULL );
    public final Expression literal() throws RecognitionException {
        Expression value = null;

        Token INTLITERAL4=null;
        Token LONGLITERAL5=null;
        Token FLOATLITERAL6=null;
        Token DOUBLELITERAL7=null;
        Token STRINGLITERAL8=null;
        Token CHARLITERAL9=null;

        try {
            // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:179:5: ( INTLITERAL | LONGLITERAL | FLOATLITERAL | DOUBLELITERAL | STRINGLITERAL | CHARLITERAL | TRUE | FALSE | NULL )
            int alt24=9;
            switch ( input.LA(1) ) {
            case INTLITERAL:
                {
                alt24=1;
                }
                break;
            case LONGLITERAL:
                {
                alt24=2;
                }
                break;
            case FLOATLITERAL:
                {
                alt24=3;
                }
                break;
            case DOUBLELITERAL:
                {
                alt24=4;
                }
                break;
            case STRINGLITERAL:
                {
                alt24=5;
                }
                break;
            case CHARLITERAL:
                {
                alt24=6;
                }
                break;
            case TRUE:
                {
                alt24=7;
                }
                break;
            case FALSE:
                {
                alt24=8;
                }
                break;
            case NULL:
                {
                alt24=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }

            switch (alt24) {
                case 1 :
                    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:179:9: INTLITERAL
                    {
                    INTLITERAL4=(Token)match(input,INTLITERAL,FOLLOW_INTLITERAL_in_literal1434); 
                    value = new IntLiteral(Integer.parseInt((INTLITERAL4!=null?INTLITERAL4.getText():null)));

                    }
                    break;
                case 2 :
                    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:180:9: LONGLITERAL
                    {
                    LONGLITERAL5=(Token)match(input,LONGLITERAL,FOLLOW_LONGLITERAL_in_literal1446); 
                    value = new LongLiteral(Long.parseLong((LONGLITERAL5!=null?LONGLITERAL5.getText():null)));

                    }
                    break;
                case 3 :
                    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:181:9: FLOATLITERAL
                    {
                    FLOATLITERAL6=(Token)match(input,FLOATLITERAL,FOLLOW_FLOATLITERAL_in_literal1458); 
                    value = new FloatLiteral(Float.parseFloat((FLOATLITERAL6!=null?FLOATLITERAL6.getText():null)));

                    }
                    break;
                case 4 :
                    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:182:9: DOUBLELITERAL
                    {
                    DOUBLELITERAL7=(Token)match(input,DOUBLELITERAL,FOLLOW_DOUBLELITERAL_in_literal1470); 
                    value = new DoubleLiteral(Double.parseDouble((DOUBLELITERAL7!=null?DOUBLELITERAL7.getText():null)));

                    }
                    break;
                case 5 :
                    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:183:9: STRINGLITERAL
                    {
                    STRINGLITERAL8=(Token)match(input,STRINGLITERAL,FOLLOW_STRINGLITERAL_in_literal1482); 
                    value = new StringLiteral((STRINGLITERAL8!=null?STRINGLITERAL8.getText():null));

                    }
                    break;
                case 6 :
                    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:184:9: CHARLITERAL
                    {
                    CHARLITERAL9=(Token)match(input,CHARLITERAL,FOLLOW_CHARLITERAL_in_literal1494); 
                    value = new StringLiteral((CHARLITERAL9!=null?CHARLITERAL9.getText():null));

                    }
                    break;
                case 7 :
                    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:185:9: TRUE
                    {
                    match(input,TRUE,FOLLOW_TRUE_in_literal1506); 
                    value = new BooleanLiteral(true);

                    }
                    break;
                case 8 :
                    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:186:9: FALSE
                    {
                    match(input,FALSE,FOLLOW_FALSE_in_literal1518); 
                    value = new BooleanLiteral(false);

                    }
                    break;
                case 9 :
                    // /Users/erdinc/Projects/cambridge/src/main/java/cambridge/parser/expressions/Expression.g:187:9: NULL
                    {
                    match(input,NULL,FOLLOW_NULL_in_literal1530); 
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
    public static final BitSet FOLLOW_LPAREN_in_parExpression82 = new BitSet(new long[]{0x001C000182003FF0L});
    public static final BitSet FOLLOW_expression_in_parExpression86 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_RPAREN_in_parExpression88 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_function113 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_LPAREN_in_function115 = new BitSet(new long[]{0x001C000182003FF0L});
    public static final BitSet FOLLOW_expression_in_function119 = new BitSet(new long[]{0x0002000004000000L});
    public static final BitSet FOLLOW_49_in_function128 = new BitSet(new long[]{0x001C000182003FF0L});
    public static final BitSet FOLLOW_expression_in_function132 = new BitSet(new long[]{0x0002000004000000L});
    public static final BitSet FOLLOW_RPAREN_in_function138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_conditionalAndExpression_in_expression171 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_BARBAR_in_expression184 = new BitSet(new long[]{0x001C000182003FF0L});
    public static final BitSet FOLLOW_conditionalAndExpression_in_expression190 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_inclusiveOrExpression_in_conditionalAndExpression235 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_AMPAMP_in_conditionalAndExpression248 = new BitSet(new long[]{0x001C000182003FF0L});
    public static final BitSet FOLLOW_inclusiveOrExpression_in_conditionalAndExpression254 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_exclusiveOrExpression_in_inclusiveOrExpression299 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_BAR_in_inclusiveOrExpression312 = new BitSet(new long[]{0x001C000182003FF0L});
    public static final BitSet FOLLOW_exclusiveOrExpression_in_inclusiveOrExpression318 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_andExpression_in_exclusiveOrExpression363 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_CARET_in_exclusiveOrExpression376 = new BitSet(new long[]{0x001C000182003FF0L});
    public static final BitSet FOLLOW_andExpression_in_exclusiveOrExpression382 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_equalityExpression_in_andExpression426 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_AMP_in_andExpression439 = new BitSet(new long[]{0x001C000182003FF0L});
    public static final BitSet FOLLOW_equalityExpression_in_andExpression445 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_relationalExpression_in_equalityExpression490 = new BitSet(new long[]{0x0000100200000002L});
    public static final BitSet FOLLOW_EQEQ_in_equalityExpression522 = new BitSet(new long[]{0x001C000182003FF0L});
    public static final BitSet FOLLOW_BANGEQ_in_equalityExpression542 = new BitSet(new long[]{0x001C000182003FF0L});
    public static final BitSet FOLLOW_relationalExpression_in_equalityExpression576 = new BitSet(new long[]{0x0000100200000002L});
    public static final BitSet FOLLOW_shiftExpression_in_relationalExpression616 = new BitSet(new long[]{0x0000600000000002L});
    public static final BitSet FOLLOW_relationalOp_in_relationalExpression642 = new BitSet(new long[]{0x001C000182003FF0L});
    public static final BitSet FOLLOW_shiftExpression_in_relationalExpression646 = new BitSet(new long[]{0x0000600000000002L});
    public static final BitSet FOLLOW_LT_in_relationalOp688 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_EQ_in_relationalOp690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GT_in_relationalOp703 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_EQ_in_relationalOp705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LT_in_relationalOp717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GT_in_relationalOp729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_additiveExpression_in_shiftExpression760 = new BitSet(new long[]{0x0000600000000002L});
    public static final BitSet FOLLOW_shiftOp_in_shiftExpression786 = new BitSet(new long[]{0x001C000182003FF0L});
    public static final BitSet FOLLOW_additiveExpression_in_shiftExpression790 = new BitSet(new long[]{0x0000600000000002L});
    public static final BitSet FOLLOW_LT_in_shiftOp829 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_LT_in_shiftOp831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GT_in_shiftOp844 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_GT_in_shiftOp846 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_GT_in_shiftOp848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GT_in_shiftOp861 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_GT_in_shiftOp863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_multiplicativeExpression_in_additiveExpression894 = new BitSet(new long[]{0x0000003000000002L});
    public static final BitSet FOLLOW_PLUS_in_additiveExpression926 = new BitSet(new long[]{0x001C000182003FF0L});
    public static final BitSet FOLLOW_SUB_in_additiveExpression946 = new BitSet(new long[]{0x001C000182003FF0L});
    public static final BitSet FOLLOW_multiplicativeExpression_in_additiveExpression981 = new BitSet(new long[]{0x0000003000000002L});
    public static final BitSet FOLLOW_unaryExpressionNotPlusMinus_in_multiplicativeExpression1033 = new BitSet(new long[]{0x000008C000000002L});
    public static final BitSet FOLLOW_STAR_in_multiplicativeExpression1066 = new BitSet(new long[]{0x001C000182003FF0L});
    public static final BitSet FOLLOW_SLASH_in_multiplicativeExpression1087 = new BitSet(new long[]{0x001C000182003FF0L});
    public static final BitSet FOLLOW_PERCENT_in_multiplicativeExpression1108 = new BitSet(new long[]{0x001C000182003FF0L});
    public static final BitSet FOLLOW_unaryExpressionNotPlusMinus_in_multiplicativeExpression1143 = new BitSet(new long[]{0x000008C000000002L});
    public static final BitSet FOLLOW_TILDE_in_unaryExpressionNotPlusMinus1180 = new BitSet(new long[]{0x001C000182003FF0L});
    public static final BitSet FOLLOW_multiplicativeExpression_in_unaryExpressionNotPlusMinus1184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BANG_in_unaryExpressionNotPlusMinus1196 = new BitSet(new long[]{0x001C000182003FF0L});
    public static final BitSet FOLLOW_multiplicativeExpression_in_unaryExpressionNotPlusMinus1200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_in_unaryExpressionNotPlusMinus1214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parExpression_in_primary1242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_in_primary1256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_primary1268 = new BitSet(new long[]{0x0000000028000002L});
    public static final BitSet FOLLOW_identifierSuffix_in_primary1275 = new BitSet(new long[]{0x0000000028000002L});
    public static final BitSet FOLLOW_51_in_primary1289 = new BitSet(new long[]{0x0000000028000002L});
    public static final BitSet FOLLOW_identifierSuffix_in_primary1296 = new BitSet(new long[]{0x0000000028000002L});
    public static final BitSet FOLLOW_52_in_primary1310 = new BitSet(new long[]{0x0000000028000002L});
    public static final BitSet FOLLOW_identifierSuffix_in_primary1317 = new BitSet(new long[]{0x0000000028000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_primary1331 = new BitSet(new long[]{0x0000000028000002L});
    public static final BitSet FOLLOW_identifierSuffix_in_primary1338 = new BitSet(new long[]{0x0000000028000002L});
    public static final BitSet FOLLOW_literal_in_primary1354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_identifierSuffix1382 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENTIFIER_in_identifierSuffix1384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_identifierSuffix1395 = new BitSet(new long[]{0x001C000182003FF0L});
    public static final BitSet FOLLOW_expression_in_identifierSuffix1399 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_RBRACKET_in_identifierSuffix1401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTLITERAL_in_literal1434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONGLITERAL_in_literal1446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOATLITERAL_in_literal1458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLELITERAL_in_literal1470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRINGLITERAL_in_literal1482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHARLITERAL_in_literal1494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_literal1506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_literal1518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_in_literal1530 = new BitSet(new long[]{0x0000000000000002L});

}