// $ANTLR 3.2 Sep 23, 2009 12:02:23 /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g 2011-01-28 00:23:06

package cambridge.parser.expressions;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class ExpressionParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "IDENTIFIER", "INTLITERAL", "LONGLITERAL", "FLOATLITERAL", "DOUBLELITERAL", "STRINGLITERAL", "CHARLITERAL", "TRUE", "FALSE", "NULL", "RANGELITERAL", "IntegerNumber", "LongSuffix", "HexPrefix", "HexDigit", "Exponent", "NonIntegerNumber", "FloatSuffix", "DoubleSuffix", "EscapeSequence", "WS", "SUPER", "LPAREN", "RPAREN", "LBRACKET", "RBRACKET", "DOT", "EQ", "BANG", "TILDE", "EQEQ", "AMPAMP", "BARBAR", "PLUS", "SUB", "STAR", "SLASH", "AMP", "BAR", "CARET", "PERCENT", "BANGEQ", "GT", "LT", "LETTER", "JavaIDDigit", "'{'", "':'", "','", "'}'", "'#super'", "'#this'", "'#iter'"
    };
    public static final int LT=47;
    public static final int STAR=39;
    public static final int IntegerNumber=15;
    public static final int LETTER=48;
    public static final int AMP=41;
    public static final int Exponent=19;
    public static final int SUB=38;
    public static final int EOF=-1;
    public static final int HexDigit=18;
    public static final int LPAREN=26;
    public static final int T__55=55;
    public static final int LBRACKET=28;
    public static final int T__56=56;
    public static final int RANGELITERAL=14;
    public static final int RPAREN=27;
    public static final int SLASH=40;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int IDENTIFIER=4;
    public static final int NonIntegerNumber=20;
    public static final int FloatSuffix=21;
    public static final int CARET=43;
    public static final int TILDE=33;
    public static final int BANGEQ=45;
    public static final int PLUS=37;
    public static final int BARBAR=36;
    public static final int SUPER=25;
    public static final int RBRACKET=29;
    public static final int EQ=31;
    public static final int DOT=30;
    public static final int AMPAMP=35;
    public static final int T__50=50;
    public static final int EQEQ=34;
    public static final int HexPrefix=17;
    public static final int PERCENT=44;
    public static final int NULL=13;
    public static final int DOUBLELITERAL=8;
    public static final int BANG=32;
    public static final int INTLITERAL=5;
    public static final int TRUE=11;
    public static final int LONGLITERAL=6;
    public static final int LongSuffix=16;
    public static final int WS=24;
    public static final int DoubleSuffix=22;
    public static final int STRINGLITERAL=9;
    public static final int CHARLITERAL=10;
    public static final int JavaIDDigit=49;
    public static final int GT=46;
    public static final int FALSE=12;
    public static final int FLOATLITERAL=7;
    public static final int EscapeSequence=23;
    public static final int BAR=42;

    // delegates
    // delegators


        public ExpressionParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public ExpressionParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return ExpressionParser.tokenNames; }
    public String getGrammarFileName() { return "/Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g"; }


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
    // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:39:1: compilationUnit returns [Expression value] : e= expression ;
    public final Expression compilationUnit() throws RecognitionException {
        Expression value = null;

        Expression e = null;


        try {
            // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:43:5: (e= expression )
            // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:43:9: e= expression
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


    // $ANTLR start "mapExpression"
    // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:46:1: mapExpression returns [MapExpression value] : '{' i= IDENTIFIER ':' e= expression ( ',' id= IDENTIFIER ':' x= expression )* '}' ;
    public final MapExpression mapExpression() throws RecognitionException {
        MapExpression value = null;

        Token i=null;
        Token id=null;
        Expression e = null;

        Expression x = null;


        try {
            // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:47:3: ( '{' i= IDENTIFIER ':' e= expression ( ',' id= IDENTIFIER ':' x= expression )* '}' )
            // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:47:7: '{' i= IDENTIFIER ':' e= expression ( ',' id= IDENTIFIER ':' x= expression )* '}'
            {
            match(input,50,FOLLOW_50_in_mapExpression83); 
            i=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_mapExpression87); 
            match(input,51,FOLLOW_51_in_mapExpression89); 
            pushFollow(FOLLOW_expression_in_mapExpression93);
            e=expression();

            state._fsp--;

            value = new MapExpression(); value.put(i.getText(), e);
            // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:47:101: ( ',' id= IDENTIFIER ':' x= expression )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==52) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:47:102: ',' id= IDENTIFIER ':' x= expression
            	    {
            	    match(input,52,FOLLOW_52_in_mapExpression98); 
            	    id=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_mapExpression102); 
            	    match(input,51,FOLLOW_51_in_mapExpression104); 
            	    pushFollow(FOLLOW_expression_in_mapExpression108);
            	    x=expression();

            	    state._fsp--;

            	    value.put(id.getText(), x);

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            match(input,53,FOLLOW_53_in_mapExpression115); 

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
    // $ANTLR end "mapExpression"


    // $ANTLR start "listExpression"
    // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:50:1: listExpression returns [ListExpression value] : '[' e= expression ( ',' x= expression )* ']' ;
    public final ListExpression listExpression() throws RecognitionException {
        ListExpression value = null;

        Expression e = null;

        Expression x = null;


        try {
            // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:51:5: ( '[' e= expression ( ',' x= expression )* ']' )
            // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:51:9: '[' e= expression ( ',' x= expression )* ']'
            {
            match(input,LBRACKET,FOLLOW_LBRACKET_in_listExpression136); 
            pushFollow(FOLLOW_expression_in_listExpression140);
            e=expression();

            state._fsp--;

            value = new ListExpression(); value.add(e); 
            // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:51:75: ( ',' x= expression )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==52) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:51:76: ',' x= expression
            	    {
            	    match(input,52,FOLLOW_52_in_listExpression145); 
            	    pushFollow(FOLLOW_expression_in_listExpression149);
            	    x=expression();

            	    state._fsp--;

            	    value.add(x);

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            match(input,RBRACKET,FOLLOW_RBRACKET_in_listExpression155); 

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
    // $ANTLR end "listExpression"


    // $ANTLR start "parExpression"
    // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:54:1: parExpression returns [Expression value] : '(' e= expression ')' ;
    public final Expression parExpression() throws RecognitionException {
        Expression value = null;

        Expression e = null;


        try {
            // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:55:5: ( '(' e= expression ')' )
            // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:55:9: '(' e= expression ')'
            {
            match(input,LPAREN,FOLLOW_LPAREN_in_parExpression178); 
            pushFollow(FOLLOW_expression_in_parExpression182);
            e=expression();

            state._fsp--;

            match(input,RPAREN,FOLLOW_RPAREN_in_parExpression184); 
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
    // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:58:1: function returns [Expression value] : IDENTIFIER '(' e= expression ( ',' f= expression )* ')' ;
    public final Expression function() throws RecognitionException {
        Expression value = null;

        Token IDENTIFIER1=null;
        Expression e = null;

        Expression f = null;


        try {
            // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:59:5: ( IDENTIFIER '(' e= expression ( ',' f= expression )* ')' )
            // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:59:9: IDENTIFIER '(' e= expression ( ',' f= expression )* ')'
            {
            IDENTIFIER1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_function209); 
            match(input,LPAREN,FOLLOW_LPAREN_in_function211); 
            pushFollow(FOLLOW_expression_in_function215);
            e=expression();

            state._fsp--;

            value = new FunctionExpression((IDENTIFIER1!=null?IDENTIFIER1.getText():null));
                ArrayList<Expression> params = new ArrayList<Expression>();
                params.add(e);
                
            // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:63:7: ( ',' f= expression )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==52) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:63:8: ',' f= expression
            	    {
            	    match(input,52,FOLLOW_52_in_function224); 
            	    pushFollow(FOLLOW_expression_in_function228);
            	    f=expression();

            	    state._fsp--;

            	     params.add(f);

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            match(input,RPAREN,FOLLOW_RPAREN_in_function234); 
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
    // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:66:1: expression returns [Expression value] : l= conditionalAndExpression ( '||' r= conditionalAndExpression )* ;
    public final Expression expression() throws RecognitionException {
        Expression value = null;

        Expression l = null;

        Expression r = null;


        try {
            // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:67:5: (l= conditionalAndExpression ( '||' r= conditionalAndExpression )* )
            // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:67:9: l= conditionalAndExpression ( '||' r= conditionalAndExpression )*
            {
            pushFollow(FOLLOW_conditionalAndExpression_in_expression267);
            l=conditionalAndExpression();

            state._fsp--;

            value = l;
            // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:68:9: ( '||' r= conditionalAndExpression )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==BARBAR) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:68:10: '||' r= conditionalAndExpression
            	    {
            	    match(input,BARBAR,FOLLOW_BARBAR_in_expression280); 
            	    pushFollow(FOLLOW_conditionalAndExpression_in_expression286);
            	    r=conditionalAndExpression();

            	    state._fsp--;

            	    value = new BinaryExpression(Expression.Operator.ConditionalOr, value, r);

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
    // $ANTLR end "expression"


    // $ANTLR start "conditionalAndExpression"
    // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:72:1: conditionalAndExpression returns [Expression value] : l= inclusiveOrExpression ( '&&' r= inclusiveOrExpression )* ;
    public final Expression conditionalAndExpression() throws RecognitionException {
        Expression value = null;

        Expression l = null;

        Expression r = null;


        try {
            // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:73:5: (l= inclusiveOrExpression ( '&&' r= inclusiveOrExpression )* )
            // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:73:9: l= inclusiveOrExpression ( '&&' r= inclusiveOrExpression )*
            {
            pushFollow(FOLLOW_inclusiveOrExpression_in_conditionalAndExpression331);
            l=inclusiveOrExpression();

            state._fsp--;

            value = l;
            // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:74:9: ( '&&' r= inclusiveOrExpression )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==AMPAMP) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:74:10: '&&' r= inclusiveOrExpression
            	    {
            	    match(input,AMPAMP,FOLLOW_AMPAMP_in_conditionalAndExpression344); 
            	    pushFollow(FOLLOW_inclusiveOrExpression_in_conditionalAndExpression350);
            	    r=inclusiveOrExpression();

            	    state._fsp--;

            	    value = new BinaryExpression(Expression.Operator.ConditionalAnd, value, r);

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
    // $ANTLR end "conditionalAndExpression"


    // $ANTLR start "inclusiveOrExpression"
    // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:78:1: inclusiveOrExpression returns [Expression value] : l= exclusiveOrExpression ( '|' r= exclusiveOrExpression )* ;
    public final Expression inclusiveOrExpression() throws RecognitionException {
        Expression value = null;

        Expression l = null;

        Expression r = null;


        try {
            // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:79:5: (l= exclusiveOrExpression ( '|' r= exclusiveOrExpression )* )
            // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:79:9: l= exclusiveOrExpression ( '|' r= exclusiveOrExpression )*
            {
            pushFollow(FOLLOW_exclusiveOrExpression_in_inclusiveOrExpression395);
            l=exclusiveOrExpression();

            state._fsp--;

            value = l;
            // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:80:9: ( '|' r= exclusiveOrExpression )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==BAR) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:80:10: '|' r= exclusiveOrExpression
            	    {
            	    match(input,BAR,FOLLOW_BAR_in_inclusiveOrExpression408); 
            	    pushFollow(FOLLOW_exclusiveOrExpression_in_inclusiveOrExpression414);
            	    r=exclusiveOrExpression();

            	    state._fsp--;

            	    value = new BinaryExpression(Expression.Operator.Or, value, r);

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
    // $ANTLR end "inclusiveOrExpression"


    // $ANTLR start "exclusiveOrExpression"
    // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:84:1: exclusiveOrExpression returns [Expression value] : l= andExpression ( '^' r= andExpression )* ;
    public final Expression exclusiveOrExpression() throws RecognitionException {
        Expression value = null;

        Expression l = null;

        Expression r = null;


        try {
            // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:85:5: (l= andExpression ( '^' r= andExpression )* )
            // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:85:9: l= andExpression ( '^' r= andExpression )*
            {
            pushFollow(FOLLOW_andExpression_in_exclusiveOrExpression459);
            l=andExpression();

            state._fsp--;

            value = l;
            // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:86:9: ( '^' r= andExpression )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==CARET) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:86:10: '^' r= andExpression
            	    {
            	    match(input,CARET,FOLLOW_CARET_in_exclusiveOrExpression472); 
            	    pushFollow(FOLLOW_andExpression_in_exclusiveOrExpression478);
            	    r=andExpression();

            	    state._fsp--;

            	    value = new BinaryExpression(Expression.Operator.XOr, value, r);

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
    // $ANTLR end "exclusiveOrExpression"


    // $ANTLR start "andExpression"
    // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:90:1: andExpression returns [Expression value] : l= equalityExpression ( '&' r= equalityExpression )* ;
    public final Expression andExpression() throws RecognitionException {
        Expression value = null;

        Expression l = null;

        Expression r = null;


        try {
            // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:91:5: (l= equalityExpression ( '&' r= equalityExpression )* )
            // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:91:9: l= equalityExpression ( '&' r= equalityExpression )*
            {
            pushFollow(FOLLOW_equalityExpression_in_andExpression522);
            l=equalityExpression();

            state._fsp--;

            value = l;
            // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:92:9: ( '&' r= equalityExpression )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==AMP) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:92:10: '&' r= equalityExpression
            	    {
            	    match(input,AMP,FOLLOW_AMP_in_andExpression535); 
            	    pushFollow(FOLLOW_equalityExpression_in_andExpression541);
            	    r=equalityExpression();

            	    state._fsp--;

            	    value = new BinaryExpression(Expression.Operator.And, value, r);

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
    // $ANTLR end "andExpression"


    // $ANTLR start "equalityExpression"
    // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:96:1: equalityExpression returns [Expression value] : l= relationalExpression ( ( '==' | '!=' ) r= relationalExpression )* ;
    public final Expression equalityExpression() throws RecognitionException {
        Expression value = null;

        Expression l = null;

        Expression r = null;


        try {
            // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:97:5: (l= relationalExpression ( ( '==' | '!=' ) r= relationalExpression )* )
            // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:97:9: l= relationalExpression ( ( '==' | '!=' ) r= relationalExpression )*
            {
            pushFollow(FOLLOW_relationalExpression_in_equalityExpression586);
            l=relationalExpression();

            state._fsp--;

            value = l; Expression.Operator op = null;
            // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:98:9: ( ( '==' | '!=' ) r= relationalExpression )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==EQEQ||LA10_0==BANGEQ) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:99:13: ( '==' | '!=' ) r= relationalExpression
            	    {
            	    // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:99:13: ( '==' | '!=' )
            	    int alt9=2;
            	    int LA9_0 = input.LA(1);

            	    if ( (LA9_0==EQEQ) ) {
            	        alt9=1;
            	    }
            	    else if ( (LA9_0==BANGEQ) ) {
            	        alt9=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 9, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt9) {
            	        case 1 :
            	            // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:99:17: '=='
            	            {
            	            match(input,EQEQ,FOLLOW_EQEQ_in_equalityExpression618); 
            	            op = Expression.Operator.Equal;

            	            }
            	            break;
            	        case 2 :
            	            // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:100:17: '!='
            	            {
            	            match(input,BANGEQ,FOLLOW_BANGEQ_in_equalityExpression638); 
            	            op = Expression.Operator.NotEqual;

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_relationalExpression_in_equalityExpression672);
            	    r=relationalExpression();

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
    // $ANTLR end "equalityExpression"


    // $ANTLR start "relationalExpression"
    // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:106:1: relationalExpression returns [Expression value] : l= shiftExpression (op= relationalOp r= shiftExpression )* ;
    public final Expression relationalExpression() throws RecognitionException {
        Expression value = null;

        Expression l = null;

        Expression.Operator op = null;

        Expression r = null;


        try {
            // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:107:5: (l= shiftExpression (op= relationalOp r= shiftExpression )* )
            // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:107:9: l= shiftExpression (op= relationalOp r= shiftExpression )*
            {
            pushFollow(FOLLOW_shiftExpression_in_relationalExpression712);
            l=shiftExpression();

            state._fsp--;

            value = l;
            // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:108:9: (op= relationalOp r= shiftExpression )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>=GT && LA11_0<=LT)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:109:9: op= relationalOp r= shiftExpression
            	    {
            	    pushFollow(FOLLOW_relationalOp_in_relationalExpression738);
            	    op=relationalOp();

            	    state._fsp--;

            	    pushFollow(FOLLOW_shiftExpression_in_relationalExpression742);
            	    r=shiftExpression();

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
    // $ANTLR end "relationalExpression"


    // $ANTLR start "relationalOp"
    // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:113:1: relationalOp returns [Expression.Operator value] : ( '<' '=' | '>' '=' | '<' | '>' );
    public final Expression.Operator relationalOp() throws RecognitionException {
        Expression.Operator value = null;

        try {
            // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:114:5: ( '<' '=' | '>' '=' | '<' | '>' )
            int alt12=4;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==LT) ) {
                int LA12_1 = input.LA(2);

                if ( (LA12_1==EQ) ) {
                    alt12=1;
                }
                else if ( ((LA12_1>=IDENTIFIER && LA12_1<=RANGELITERAL)||LA12_1==LPAREN||LA12_1==LBRACKET||(LA12_1>=BANG && LA12_1<=TILDE)||LA12_1==50||(LA12_1>=54 && LA12_1<=56)) ) {
                    alt12=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA12_0==GT) ) {
                int LA12_2 = input.LA(2);

                if ( (LA12_2==EQ) ) {
                    alt12=2;
                }
                else if ( ((LA12_2>=IDENTIFIER && LA12_2<=RANGELITERAL)||LA12_2==LPAREN||LA12_2==LBRACKET||(LA12_2>=BANG && LA12_2<=TILDE)||LA12_2==50||(LA12_2>=54 && LA12_2<=56)) ) {
                    alt12=4;
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
                    // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:114:10: '<' '='
                    {
                    match(input,LT,FOLLOW_LT_in_relationalOp784); 
                    match(input,EQ,FOLLOW_EQ_in_relationalOp786); 
                    value = Expression.Operator.LTE;

                    }
                    break;
                case 2 :
                    // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:115:10: '>' '='
                    {
                    match(input,GT,FOLLOW_GT_in_relationalOp799); 
                    match(input,EQ,FOLLOW_EQ_in_relationalOp801); 
                    value = Expression.Operator.GTE;

                    }
                    break;
                case 3 :
                    // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:116:9: '<'
                    {
                    match(input,LT,FOLLOW_LT_in_relationalOp813); 
                    value = Expression.Operator.LT;

                    }
                    break;
                case 4 :
                    // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:117:9: '>'
                    {
                    match(input,GT,FOLLOW_GT_in_relationalOp825); 
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
    // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:120:1: shiftExpression returns [Expression value] : l= additiveExpression (op= shiftOp r= additiveExpression )* ;
    public final Expression shiftExpression() throws RecognitionException {
        Expression value = null;

        Expression l = null;

        Expression.Operator op = null;

        Expression r = null;


        try {
            // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:121:5: (l= additiveExpression (op= shiftOp r= additiveExpression )* )
            // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:121:9: l= additiveExpression (op= shiftOp r= additiveExpression )*
            {
            pushFollow(FOLLOW_additiveExpression_in_shiftExpression856);
            l=additiveExpression();

            state._fsp--;

            value = l;
            // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:122:9: (op= shiftOp r= additiveExpression )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==LT) ) {
                    int LA13_1 = input.LA(2);

                    if ( (LA13_1==LT) ) {
                        alt13=1;
                    }


                }
                else if ( (LA13_0==GT) ) {
                    int LA13_2 = input.LA(2);

                    if ( (LA13_2==GT) ) {
                        alt13=1;
                    }


                }


                switch (alt13) {
            	case 1 :
            	    // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:123:9: op= shiftOp r= additiveExpression
            	    {
            	    pushFollow(FOLLOW_shiftOp_in_shiftExpression882);
            	    op=shiftOp();

            	    state._fsp--;

            	    pushFollow(FOLLOW_additiveExpression_in_shiftExpression886);
            	    r=additiveExpression();

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
    // $ANTLR end "shiftExpression"


    // $ANTLR start "shiftOp"
    // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:127:1: shiftOp returns [Expression.Operator value] : ( '<' '<' | '>' '>' '>' | '>' '>' );
    public final Expression.Operator shiftOp() throws RecognitionException {
        Expression.Operator value = null;

        try {
            // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:128:5: ( '<' '<' | '>' '>' '>' | '>' '>' )
            int alt14=3;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==LT) ) {
                alt14=1;
            }
            else if ( (LA14_0==GT) ) {
                int LA14_2 = input.LA(2);

                if ( (LA14_2==GT) ) {
                    int LA14_3 = input.LA(3);

                    if ( (LA14_3==GT) ) {
                        alt14=2;
                    }
                    else if ( ((LA14_3>=IDENTIFIER && LA14_3<=RANGELITERAL)||LA14_3==LPAREN||LA14_3==LBRACKET||(LA14_3>=BANG && LA14_3<=TILDE)||LA14_3==50||(LA14_3>=54 && LA14_3<=56)) ) {
                        alt14=3;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 14, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 14, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:128:10: '<' '<'
                    {
                    match(input,LT,FOLLOW_LT_in_shiftOp925); 
                    match(input,LT,FOLLOW_LT_in_shiftOp927); 
                    value = Expression.Operator.SHIFT_LEFT;

                    }
                    break;
                case 2 :
                    // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:129:10: '>' '>' '>'
                    {
                    match(input,GT,FOLLOW_GT_in_shiftOp940); 
                    match(input,GT,FOLLOW_GT_in_shiftOp942); 
                    match(input,GT,FOLLOW_GT_in_shiftOp944); 
                    value = Expression.Operator.U_SHIFT_RIGHT;

                    }
                    break;
                case 3 :
                    // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:130:10: '>' '>'
                    {
                    match(input,GT,FOLLOW_GT_in_shiftOp957); 
                    match(input,GT,FOLLOW_GT_in_shiftOp959); 
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
    // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:133:1: additiveExpression returns [Expression value] : l= multiplicativeExpression ( ( '+' | '-' ) r= multiplicativeExpression )* ;
    public final Expression additiveExpression() throws RecognitionException {
        Expression value = null;

        Expression l = null;

        Expression r = null;


        try {
            // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:134:5: (l= multiplicativeExpression ( ( '+' | '-' ) r= multiplicativeExpression )* )
            // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:134:9: l= multiplicativeExpression ( ( '+' | '-' ) r= multiplicativeExpression )*
            {
            pushFollow(FOLLOW_multiplicativeExpression_in_additiveExpression990);
            l=multiplicativeExpression();

            state._fsp--;

            value = l; Expression.Operator op = null;
            // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:135:9: ( ( '+' | '-' ) r= multiplicativeExpression )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0>=PLUS && LA16_0<=SUB)) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:136:13: ( '+' | '-' ) r= multiplicativeExpression
            	    {
            	    // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:136:13: ( '+' | '-' )
            	    int alt15=2;
            	    int LA15_0 = input.LA(1);

            	    if ( (LA15_0==PLUS) ) {
            	        alt15=1;
            	    }
            	    else if ( (LA15_0==SUB) ) {
            	        alt15=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 15, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt15) {
            	        case 1 :
            	            // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:136:17: '+'
            	            {
            	            match(input,PLUS,FOLLOW_PLUS_in_additiveExpression1022); 
            	            op = Expression.Operator.Plus;

            	            }
            	            break;
            	        case 2 :
            	            // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:137:17: '-'
            	            {
            	            match(input,SUB,FOLLOW_SUB_in_additiveExpression1042); 
            	            op = Expression.Operator.Minus;

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_multiplicativeExpression_in_additiveExpression1077);
            	    r=multiplicativeExpression();

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
    // $ANTLR end "additiveExpression"


    // $ANTLR start "multiplicativeExpression"
    // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:143:1: multiplicativeExpression returns [Expression value] : l= unaryExpressionNotPlusMinus ( ( '*' | '/' | '%' ) r= unaryExpressionNotPlusMinus )* ;
    public final Expression multiplicativeExpression() throws RecognitionException {
        Expression value = null;

        Expression l = null;

        Expression r = null;


        try {
            // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:144:5: (l= unaryExpressionNotPlusMinus ( ( '*' | '/' | '%' ) r= unaryExpressionNotPlusMinus )* )
            // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:145:9: l= unaryExpressionNotPlusMinus ( ( '*' | '/' | '%' ) r= unaryExpressionNotPlusMinus )*
            {
            pushFollow(FOLLOW_unaryExpressionNotPlusMinus_in_multiplicativeExpression1129);
            l=unaryExpressionNotPlusMinus();

            state._fsp--;

            value = l; Expression.Operator op = null;
            // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:146:9: ( ( '*' | '/' | '%' ) r= unaryExpressionNotPlusMinus )*
            loop18:
            do {
                int alt18=2;
                switch ( input.LA(1) ) {
                case STAR:
                    {
                    alt18=1;
                    }
                    break;
                case SLASH:
                    {
                    alt18=1;
                    }
                    break;
                case PERCENT:
                    {
                    alt18=1;
                    }
                    break;

                }

                switch (alt18) {
            	case 1 :
            	    // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:147:13: ( '*' | '/' | '%' ) r= unaryExpressionNotPlusMinus
            	    {
            	    // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:147:13: ( '*' | '/' | '%' )
            	    int alt17=3;
            	    switch ( input.LA(1) ) {
            	    case STAR:
            	        {
            	        alt17=1;
            	        }
            	        break;
            	    case SLASH:
            	        {
            	        alt17=2;
            	        }
            	        break;
            	    case PERCENT:
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
            	            // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:147:17: '*'
            	            {
            	            match(input,STAR,FOLLOW_STAR_in_multiplicativeExpression1162); 
            	            op = Expression.Operator.Times;

            	            }
            	            break;
            	        case 2 :
            	            // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:148:17: '/'
            	            {
            	            match(input,SLASH,FOLLOW_SLASH_in_multiplicativeExpression1183); 
            	            op = Expression.Operator.Divide;

            	            }
            	            break;
            	        case 3 :
            	            // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:149:17: '%'
            	            {
            	            match(input,PERCENT,FOLLOW_PERCENT_in_multiplicativeExpression1204); 
            	            op = Expression.Operator.Mod;

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_unaryExpressionNotPlusMinus_in_multiplicativeExpression1239);
            	    r=unaryExpressionNotPlusMinus();

            	    state._fsp--;

            	    value = new BinaryExpression(op, value, r);

            	    }
            	    break;

            	default :
            	    break loop18;
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
    // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:155:1: unaryExpressionNotPlusMinus returns [Expression value] : ( '~' l= multiplicativeExpression | '!' l= multiplicativeExpression | l= primary );
    public final Expression unaryExpressionNotPlusMinus() throws RecognitionException {
        Expression value = null;

        Expression l = null;


        try {
            // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:156:5: ( '~' l= multiplicativeExpression | '!' l= multiplicativeExpression | l= primary )
            int alt19=3;
            switch ( input.LA(1) ) {
            case TILDE:
                {
                alt19=1;
                }
                break;
            case BANG:
                {
                alt19=2;
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
            case RANGELITERAL:
            case LPAREN:
            case LBRACKET:
            case 50:
            case 54:
            case 55:
            case 56:
                {
                alt19=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:156:9: '~' l= multiplicativeExpression
                    {
                    match(input,TILDE,FOLLOW_TILDE_in_unaryExpressionNotPlusMinus1276); 
                    pushFollow(FOLLOW_multiplicativeExpression_in_unaryExpressionNotPlusMinus1280);
                    l=multiplicativeExpression();

                    state._fsp--;

                    value = new UnaryExpression(Expression.Operator.Tilde, l);

                    }
                    break;
                case 2 :
                    // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:157:9: '!' l= multiplicativeExpression
                    {
                    match(input,BANG,FOLLOW_BANG_in_unaryExpressionNotPlusMinus1292); 
                    pushFollow(FOLLOW_multiplicativeExpression_in_unaryExpressionNotPlusMinus1296);
                    l=multiplicativeExpression();

                    state._fsp--;

                    value = new UnaryExpression(Expression.Operator.Not, l);

                    }
                    break;
                case 3 :
                    // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:158:9: l= primary
                    {
                    pushFollow(FOLLOW_primary_in_unaryExpressionNotPlusMinus1310);
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
    // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:161:1: primary returns [Expression value] : (e= parExpression | e= listExpression | e= mapExpression | e= function | '#super' (p= identifierSuffix )* | '#this' (p= identifierSuffix )* | '#iter' (p= identifierSuffix )* | IDENTIFIER (p= identifierSuffix )* | l= literal );
    public final Expression primary() throws RecognitionException {
        Expression value = null;

        Token IDENTIFIER2=null;
        Expression e = null;

        VarProperty p = null;

        Expression l = null;


        try {
            // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:162:5: (e= parExpression | e= listExpression | e= mapExpression | e= function | '#super' (p= identifierSuffix )* | '#this' (p= identifierSuffix )* | '#iter' (p= identifierSuffix )* | IDENTIFIER (p= identifierSuffix )* | l= literal )
            int alt24=9;
            alt24 = dfa24.predict(input);
            switch (alt24) {
                case 1 :
                    // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:162:9: e= parExpression
                    {
                    pushFollow(FOLLOW_parExpression_in_primary1338);
                    e=parExpression();

                    state._fsp--;

                    value = e;

                    }
                    break;
                case 2 :
                    // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:163:9: e= listExpression
                    {
                    pushFollow(FOLLOW_listExpression_in_primary1352);
                    e=listExpression();

                    state._fsp--;

                    value = e;

                    }
                    break;
                case 3 :
                    // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:164:7: e= mapExpression
                    {
                    pushFollow(FOLLOW_mapExpression_in_primary1364);
                    e=mapExpression();

                    state._fsp--;

                    value = e;

                    }
                    break;
                case 4 :
                    // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:165:9: e= function
                    {
                    pushFollow(FOLLOW_function_in_primary1378);
                    e=function();

                    state._fsp--;

                    value = e;

                    }
                    break;
                case 5 :
                    // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:166:9: '#super' (p= identifierSuffix )*
                    {
                    match(input,54,FOLLOW_54_in_primary1390); 
                    value = new VarExpression("#super");
                    // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:166:58: (p= identifierSuffix )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==LBRACKET||LA20_0==DOT) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:166:59: p= identifierSuffix
                    	    {
                    	    pushFollow(FOLLOW_identifierSuffix_in_primary1397);
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
                    // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:167:9: '#this' (p= identifierSuffix )*
                    {
                    match(input,55,FOLLOW_55_in_primary1411); 
                    value = new VarExpression("#this");
                    // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:167:56: (p= identifierSuffix )*
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0==LBRACKET||LA21_0==DOT) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:167:57: p= identifierSuffix
                    	    {
                    	    pushFollow(FOLLOW_identifierSuffix_in_primary1418);
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
                    // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:168:9: '#iter' (p= identifierSuffix )*
                    {
                    match(input,56,FOLLOW_56_in_primary1432); 
                    value = new VarExpression("#iter");
                    // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:168:56: (p= identifierSuffix )*
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==LBRACKET||LA22_0==DOT) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:168:57: p= identifierSuffix
                    	    {
                    	    pushFollow(FOLLOW_identifierSuffix_in_primary1439);
                    	    p=identifierSuffix();

                    	    state._fsp--;

                    	    ((VarExpression)value).addProperty(p);

                    	    }
                    	    break;

                    	default :
                    	    break loop22;
                        }
                    } while (true);


                    }
                    break;
                case 8 :
                    // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:169:9: IDENTIFIER (p= identifierSuffix )*
                    {
                    IDENTIFIER2=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_primary1453); 
                    value = new VarExpression((IDENTIFIER2!=null?IDENTIFIER2.getText():null));
                    // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:169:68: (p= identifierSuffix )*
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==LBRACKET||LA23_0==DOT) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:169:69: p= identifierSuffix
                    	    {
                    	    pushFollow(FOLLOW_identifierSuffix_in_primary1460);
                    	    p=identifierSuffix();

                    	    state._fsp--;

                    	    ((VarExpression)value).addProperty(p);

                    	    }
                    	    break;

                    	default :
                    	    break loop23;
                        }
                    } while (true);


                    }
                    break;
                case 9 :
                    // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:170:9: l= literal
                    {
                    pushFollow(FOLLOW_literal_in_primary1476);
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
    // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:173:1: identifierSuffix returns [VarProperty value] : ( '.' IDENTIFIER | '[' e= expression ']' );
    public final VarProperty identifierSuffix() throws RecognitionException {
        VarProperty value = null;

        Token IDENTIFIER3=null;
        Expression e = null;


        try {
            // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:174:6: ( '.' IDENTIFIER | '[' e= expression ']' )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==DOT) ) {
                alt25=1;
            }
            else if ( (LA25_0==LBRACKET) ) {
                alt25=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:174:8: '.' IDENTIFIER
                    {
                    match(input,DOT,FOLLOW_DOT_in_identifierSuffix1504); 
                    IDENTIFIER3=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_identifierSuffix1506); 
                    value = new IdentifierVarProperty((IDENTIFIER3!=null?IDENTIFIER3.getText():null));

                    }
                    break;
                case 2 :
                    // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:175:8: '[' e= expression ']'
                    {
                    match(input,LBRACKET,FOLLOW_LBRACKET_in_identifierSuffix1517); 
                    pushFollow(FOLLOW_expression_in_identifierSuffix1521);
                    e=expression();

                    state._fsp--;

                    match(input,RBRACKET,FOLLOW_RBRACKET_in_identifierSuffix1523); 
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
    // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:188:1: literal returns [Expression value] : ( INTLITERAL | LONGLITERAL | FLOATLITERAL | DOUBLELITERAL | STRINGLITERAL | CHARLITERAL | TRUE | FALSE | NULL | RANGELITERAL );
    public final Expression literal() throws RecognitionException {
        Expression value = null;

        Token INTLITERAL4=null;
        Token LONGLITERAL5=null;
        Token FLOATLITERAL6=null;
        Token DOUBLELITERAL7=null;
        Token STRINGLITERAL8=null;
        Token CHARLITERAL9=null;
        Token RANGELITERAL10=null;

        try {
            // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:189:5: ( INTLITERAL | LONGLITERAL | FLOATLITERAL | DOUBLELITERAL | STRINGLITERAL | CHARLITERAL | TRUE | FALSE | NULL | RANGELITERAL )
            int alt26=10;
            switch ( input.LA(1) ) {
            case INTLITERAL:
                {
                alt26=1;
                }
                break;
            case LONGLITERAL:
                {
                alt26=2;
                }
                break;
            case FLOATLITERAL:
                {
                alt26=3;
                }
                break;
            case DOUBLELITERAL:
                {
                alt26=4;
                }
                break;
            case STRINGLITERAL:
                {
                alt26=5;
                }
                break;
            case CHARLITERAL:
                {
                alt26=6;
                }
                break;
            case TRUE:
                {
                alt26=7;
                }
                break;
            case FALSE:
                {
                alt26=8;
                }
                break;
            case NULL:
                {
                alt26=9;
                }
                break;
            case RANGELITERAL:
                {
                alt26=10;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }

            switch (alt26) {
                case 1 :
                    // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:189:9: INTLITERAL
                    {
                    INTLITERAL4=(Token)match(input,INTLITERAL,FOLLOW_INTLITERAL_in_literal1556); 
                    value = new IntLiteral(Integer.parseInt((INTLITERAL4!=null?INTLITERAL4.getText():null)));

                    }
                    break;
                case 2 :
                    // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:190:9: LONGLITERAL
                    {
                    LONGLITERAL5=(Token)match(input,LONGLITERAL,FOLLOW_LONGLITERAL_in_literal1568); 
                    value = new LongLiteral(Long.parseLong((LONGLITERAL5!=null?LONGLITERAL5.getText():null)));

                    }
                    break;
                case 3 :
                    // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:191:9: FLOATLITERAL
                    {
                    FLOATLITERAL6=(Token)match(input,FLOATLITERAL,FOLLOW_FLOATLITERAL_in_literal1580); 
                    value = new FloatLiteral(Float.parseFloat((FLOATLITERAL6!=null?FLOATLITERAL6.getText():null)));

                    }
                    break;
                case 4 :
                    // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:192:9: DOUBLELITERAL
                    {
                    DOUBLELITERAL7=(Token)match(input,DOUBLELITERAL,FOLLOW_DOUBLELITERAL_in_literal1592); 
                    value = new DoubleLiteral(Double.parseDouble((DOUBLELITERAL7!=null?DOUBLELITERAL7.getText():null)));

                    }
                    break;
                case 5 :
                    // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:193:9: STRINGLITERAL
                    {
                    STRINGLITERAL8=(Token)match(input,STRINGLITERAL,FOLLOW_STRINGLITERAL_in_literal1604); 
                    value = StringLiteral.fromText((STRINGLITERAL8!=null?STRINGLITERAL8.getText():null));

                    }
                    break;
                case 6 :
                    // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:194:9: CHARLITERAL
                    {
                    CHARLITERAL9=(Token)match(input,CHARLITERAL,FOLLOW_CHARLITERAL_in_literal1616); 
                    value = StringLiteral.fromText((CHARLITERAL9!=null?CHARLITERAL9.getText():null));

                    }
                    break;
                case 7 :
                    // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:195:9: TRUE
                    {
                    match(input,TRUE,FOLLOW_TRUE_in_literal1628); 
                    value = new BooleanLiteral(true);

                    }
                    break;
                case 8 :
                    // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:196:9: FALSE
                    {
                    match(input,FALSE,FOLLOW_FALSE_in_literal1640); 
                    value = new BooleanLiteral(false);

                    }
                    break;
                case 9 :
                    // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:197:9: NULL
                    {
                    match(input,NULL,FOLLOW_NULL_in_literal1652); 
                    value = NullLiteral.instance;

                    }
                    break;
                case 10 :
                    // /Users/erdincyilmazel/projects/cambridge/core/src/main/java/cambridge/parser/expressions/Expression.g:198:9: RANGELITERAL
                    {
                    RANGELITERAL10=(Token)match(input,RANGELITERAL,FOLLOW_RANGELITERAL_in_literal1664); 
                    value = Range.fromString((RANGELITERAL10!=null?RANGELITERAL10.getText():null));

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


    protected DFA24 dfa24 = new DFA24(this);
    static final String DFA24_eotS =
        "\13\uffff";
    static final String DFA24_eofS =
        "\4\uffff\1\12\6\uffff";
    static final String DFA24_minS =
        "\1\4\3\uffff\1\32\6\uffff";
    static final String DFA24_maxS =
        "\1\70\3\uffff\1\65\6\uffff";
    static final String DFA24_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\uffff\1\5\1\6\1\7\1\11\1\4\1\10";
    static final String DFA24_specialS =
        "\13\uffff}>";
    static final String[] DFA24_transitionS = {
            "\1\4\12\10\13\uffff\1\1\1\uffff\1\2\25\uffff\1\3\3\uffff\1\5"+
            "\1\6\1\7",
            "",
            "",
            "",
            "\1\11\4\12\3\uffff\16\12\4\uffff\2\12",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA24_eot = DFA.unpackEncodedString(DFA24_eotS);
    static final short[] DFA24_eof = DFA.unpackEncodedString(DFA24_eofS);
    static final char[] DFA24_min = DFA.unpackEncodedStringToUnsignedChars(DFA24_minS);
    static final char[] DFA24_max = DFA.unpackEncodedStringToUnsignedChars(DFA24_maxS);
    static final short[] DFA24_accept = DFA.unpackEncodedString(DFA24_acceptS);
    static final short[] DFA24_special = DFA.unpackEncodedString(DFA24_specialS);
    static final short[][] DFA24_transition;

    static {
        int numStates = DFA24_transitionS.length;
        DFA24_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA24_transition[i] = DFA.unpackEncodedString(DFA24_transitionS[i]);
        }
    }

    class DFA24 extends DFA {

        public DFA24(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 24;
            this.eot = DFA24_eot;
            this.eof = DFA24_eof;
            this.min = DFA24_min;
            this.max = DFA24_max;
            this.accept = DFA24_accept;
            this.special = DFA24_special;
            this.transition = DFA24_transition;
        }
        public String getDescription() {
            return "161:1: primary returns [Expression value] : (e= parExpression | e= listExpression | e= mapExpression | e= function | '#super' (p= identifierSuffix )* | '#this' (p= identifierSuffix )* | '#iter' (p= identifierSuffix )* | IDENTIFIER (p= identifierSuffix )* | l= literal );";
        }
    }
 

    public static final BitSet FOLLOW_expression_in_compilationUnit56 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_mapExpression83 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENTIFIER_in_mapExpression87 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_mapExpression89 = new BitSet(new long[]{0x01C4000314007FF0L});
    public static final BitSet FOLLOW_expression_in_mapExpression93 = new BitSet(new long[]{0x0030000000000000L});
    public static final BitSet FOLLOW_52_in_mapExpression98 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENTIFIER_in_mapExpression102 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_mapExpression104 = new BitSet(new long[]{0x01C4000314007FF0L});
    public static final BitSet FOLLOW_expression_in_mapExpression108 = new BitSet(new long[]{0x0030000000000000L});
    public static final BitSet FOLLOW_53_in_mapExpression115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_listExpression136 = new BitSet(new long[]{0x01C4000314007FF0L});
    public static final BitSet FOLLOW_expression_in_listExpression140 = new BitSet(new long[]{0x0010000020000000L});
    public static final BitSet FOLLOW_52_in_listExpression145 = new BitSet(new long[]{0x01C4000314007FF0L});
    public static final BitSet FOLLOW_expression_in_listExpression149 = new BitSet(new long[]{0x0010000020000000L});
    public static final BitSet FOLLOW_RBRACKET_in_listExpression155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_parExpression178 = new BitSet(new long[]{0x01C4000314007FF0L});
    public static final BitSet FOLLOW_expression_in_parExpression182 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_RPAREN_in_parExpression184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_function209 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_LPAREN_in_function211 = new BitSet(new long[]{0x01C4000314007FF0L});
    public static final BitSet FOLLOW_expression_in_function215 = new BitSet(new long[]{0x0010000008000000L});
    public static final BitSet FOLLOW_52_in_function224 = new BitSet(new long[]{0x01C4000314007FF0L});
    public static final BitSet FOLLOW_expression_in_function228 = new BitSet(new long[]{0x0010000008000000L});
    public static final BitSet FOLLOW_RPAREN_in_function234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_conditionalAndExpression_in_expression267 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_BARBAR_in_expression280 = new BitSet(new long[]{0x01C4000314007FF0L});
    public static final BitSet FOLLOW_conditionalAndExpression_in_expression286 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_inclusiveOrExpression_in_conditionalAndExpression331 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_AMPAMP_in_conditionalAndExpression344 = new BitSet(new long[]{0x01C4000314007FF0L});
    public static final BitSet FOLLOW_inclusiveOrExpression_in_conditionalAndExpression350 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_exclusiveOrExpression_in_inclusiveOrExpression395 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_BAR_in_inclusiveOrExpression408 = new BitSet(new long[]{0x01C4000314007FF0L});
    public static final BitSet FOLLOW_exclusiveOrExpression_in_inclusiveOrExpression414 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_andExpression_in_exclusiveOrExpression459 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_CARET_in_exclusiveOrExpression472 = new BitSet(new long[]{0x01C4000314007FF0L});
    public static final BitSet FOLLOW_andExpression_in_exclusiveOrExpression478 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_equalityExpression_in_andExpression522 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_AMP_in_andExpression535 = new BitSet(new long[]{0x01C4000314007FF0L});
    public static final BitSet FOLLOW_equalityExpression_in_andExpression541 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_relationalExpression_in_equalityExpression586 = new BitSet(new long[]{0x0000200400000002L});
    public static final BitSet FOLLOW_EQEQ_in_equalityExpression618 = new BitSet(new long[]{0x01C4000314007FF0L});
    public static final BitSet FOLLOW_BANGEQ_in_equalityExpression638 = new BitSet(new long[]{0x01C4000314007FF0L});
    public static final BitSet FOLLOW_relationalExpression_in_equalityExpression672 = new BitSet(new long[]{0x0000200400000002L});
    public static final BitSet FOLLOW_shiftExpression_in_relationalExpression712 = new BitSet(new long[]{0x0000C00000000002L});
    public static final BitSet FOLLOW_relationalOp_in_relationalExpression738 = new BitSet(new long[]{0x01C4000314007FF0L});
    public static final BitSet FOLLOW_shiftExpression_in_relationalExpression742 = new BitSet(new long[]{0x0000C00000000002L});
    public static final BitSet FOLLOW_LT_in_relationalOp784 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_EQ_in_relationalOp786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GT_in_relationalOp799 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_EQ_in_relationalOp801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LT_in_relationalOp813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GT_in_relationalOp825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_additiveExpression_in_shiftExpression856 = new BitSet(new long[]{0x0000C00000000002L});
    public static final BitSet FOLLOW_shiftOp_in_shiftExpression882 = new BitSet(new long[]{0x01C4000314007FF0L});
    public static final BitSet FOLLOW_additiveExpression_in_shiftExpression886 = new BitSet(new long[]{0x0000C00000000002L});
    public static final BitSet FOLLOW_LT_in_shiftOp925 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_LT_in_shiftOp927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GT_in_shiftOp940 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_GT_in_shiftOp942 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_GT_in_shiftOp944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GT_in_shiftOp957 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_GT_in_shiftOp959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_multiplicativeExpression_in_additiveExpression990 = new BitSet(new long[]{0x0000006000000002L});
    public static final BitSet FOLLOW_PLUS_in_additiveExpression1022 = new BitSet(new long[]{0x01C4000314007FF0L});
    public static final BitSet FOLLOW_SUB_in_additiveExpression1042 = new BitSet(new long[]{0x01C4000314007FF0L});
    public static final BitSet FOLLOW_multiplicativeExpression_in_additiveExpression1077 = new BitSet(new long[]{0x0000006000000002L});
    public static final BitSet FOLLOW_unaryExpressionNotPlusMinus_in_multiplicativeExpression1129 = new BitSet(new long[]{0x0000118000000002L});
    public static final BitSet FOLLOW_STAR_in_multiplicativeExpression1162 = new BitSet(new long[]{0x01C4000314007FF0L});
    public static final BitSet FOLLOW_SLASH_in_multiplicativeExpression1183 = new BitSet(new long[]{0x01C4000314007FF0L});
    public static final BitSet FOLLOW_PERCENT_in_multiplicativeExpression1204 = new BitSet(new long[]{0x01C4000314007FF0L});
    public static final BitSet FOLLOW_unaryExpressionNotPlusMinus_in_multiplicativeExpression1239 = new BitSet(new long[]{0x0000118000000002L});
    public static final BitSet FOLLOW_TILDE_in_unaryExpressionNotPlusMinus1276 = new BitSet(new long[]{0x01C4000314007FF0L});
    public static final BitSet FOLLOW_multiplicativeExpression_in_unaryExpressionNotPlusMinus1280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BANG_in_unaryExpressionNotPlusMinus1292 = new BitSet(new long[]{0x01C4000314007FF0L});
    public static final BitSet FOLLOW_multiplicativeExpression_in_unaryExpressionNotPlusMinus1296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_in_unaryExpressionNotPlusMinus1310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parExpression_in_primary1338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_listExpression_in_primary1352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mapExpression_in_primary1364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_in_primary1378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_primary1390 = new BitSet(new long[]{0x0000000050000002L});
    public static final BitSet FOLLOW_identifierSuffix_in_primary1397 = new BitSet(new long[]{0x0000000050000002L});
    public static final BitSet FOLLOW_55_in_primary1411 = new BitSet(new long[]{0x0000000050000002L});
    public static final BitSet FOLLOW_identifierSuffix_in_primary1418 = new BitSet(new long[]{0x0000000050000002L});
    public static final BitSet FOLLOW_56_in_primary1432 = new BitSet(new long[]{0x0000000050000002L});
    public static final BitSet FOLLOW_identifierSuffix_in_primary1439 = new BitSet(new long[]{0x0000000050000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_primary1453 = new BitSet(new long[]{0x0000000050000002L});
    public static final BitSet FOLLOW_identifierSuffix_in_primary1460 = new BitSet(new long[]{0x0000000050000002L});
    public static final BitSet FOLLOW_literal_in_primary1476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_identifierSuffix1504 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENTIFIER_in_identifierSuffix1506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_identifierSuffix1517 = new BitSet(new long[]{0x01C4000314007FF0L});
    public static final BitSet FOLLOW_expression_in_identifierSuffix1521 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_RBRACKET_in_identifierSuffix1523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTLITERAL_in_literal1556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONGLITERAL_in_literal1568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOATLITERAL_in_literal1580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLELITERAL_in_literal1592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRINGLITERAL_in_literal1604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHARLITERAL_in_literal1616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_literal1628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_literal1640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_in_literal1652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RANGELITERAL_in_literal1664 = new BitSet(new long[]{0x0000000000000002L});

}