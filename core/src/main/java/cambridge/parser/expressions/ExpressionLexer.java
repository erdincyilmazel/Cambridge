// $ANTLR 3.2 Sep 23, 2009 12:02:23 C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g 2010-04-13 00:10:23

package cambridge.parser.expressions;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class ExpressionLexer extends Lexer {
    public static final int LT=47;
    public static final int STAR=39;
    public static final int IntegerNumber=15;
    public static final int AMP=41;
    public static final int LETTER=48;
    public static final int Exponent=19;
    public static final int SUB=38;
    public static final int EOF=-1;
    public static final int HexDigit=18;
    public static final int LPAREN=26;
    public static final int LBRACKET=28;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int RPAREN=27;
    public static final int RANGELITERAL=14;
    public static final int T__51=51;
    public static final int SLASH=40;
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
    public static final int LongSuffix=16;
    public static final int LONGLITERAL=6;
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

       ArrayList<RecognitionException> errors;

       @Override
       public void reportError(RecognitionException e) {
          if(errors == null) errors = new ArrayList<RecognitionException>();
          errors.add(e);
       }

       public ArrayList<RecognitionException> getErrors() {
          return errors;
       }


    // delegates
    // delegators

    public ExpressionLexer() {;} 
    public ExpressionLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public ExpressionLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g"; }

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:20:7: ( '{' )
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:20:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__50"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException {
        try {
            int _type = T__51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:21:7: ( ':' )
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:21:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__51"

    // $ANTLR start "T__52"
    public final void mT__52() throws RecognitionException {
        try {
            int _type = T__52;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:22:7: ( ',' )
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:22:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__52"

    // $ANTLR start "T__53"
    public final void mT__53() throws RecognitionException {
        try {
            int _type = T__53;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:23:7: ( '}' )
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:23:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__53"

    // $ANTLR start "T__54"
    public final void mT__54() throws RecognitionException {
        try {
            int _type = T__54;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:24:7: ( '#super' )
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:24:9: '#super'
            {
            match("#super"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__54"

    // $ANTLR start "T__55"
    public final void mT__55() throws RecognitionException {
        try {
            int _type = T__55;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:25:7: ( '#this' )
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:25:9: '#this'
            {
            match("#this"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__55"

    // $ANTLR start "T__56"
    public final void mT__56() throws RecognitionException {
        try {
            int _type = T__56;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:26:7: ( '#iter' )
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:26:9: '#iter'
            {
            match("#iter"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__56"

    // $ANTLR start "LONGLITERAL"
    public final void mLONGLITERAL() throws RecognitionException {
        try {
            int _type = LONGLITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:206:5: ( IntegerNumber LongSuffix )
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:206:9: IntegerNumber LongSuffix
            {
            mIntegerNumber(); 
            mLongSuffix(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LONGLITERAL"

    // $ANTLR start "RANGELITERAL"
    public final void mRANGELITERAL() throws RecognitionException {
        try {
            int _type = RANGELITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:210:3: ( IntegerNumber '..' IntegerNumber )
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:210:7: IntegerNumber '..' IntegerNumber
            {
            mIntegerNumber(); 
            match(".."); 

            mIntegerNumber(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RANGELITERAL"

    // $ANTLR start "INTLITERAL"
    public final void mINTLITERAL() throws RecognitionException {
        try {
            int _type = INTLITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:214:5: ( IntegerNumber )
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:214:9: IntegerNumber
            {
            mIntegerNumber(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INTLITERAL"

    // $ANTLR start "IntegerNumber"
    public final void mIntegerNumber() throws RecognitionException {
        try {
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:219:5: ( '0' | '1' .. '9' ( '0' .. '9' )* | '0' ( '0' .. '7' )+ | HexPrefix ( HexDigit )+ )
            int alt4=4;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='0') ) {
                switch ( input.LA(2) ) {
                case 'X':
                case 'x':
                    {
                    alt4=4;
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
                    alt4=3;
                    }
                    break;
                default:
                    alt4=1;}

            }
            else if ( ((LA4_0>='1' && LA4_0<='9')) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:219:9: '0'
                    {
                    match('0'); 

                    }
                    break;
                case 2 :
                    // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:220:9: '1' .. '9' ( '0' .. '9' )*
                    {
                    matchRange('1','9'); 
                    // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:220:18: ( '0' .. '9' )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( ((LA1_0>='0' && LA1_0<='9')) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:220:19: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop1;
                        }
                    } while (true);


                    }
                    break;
                case 3 :
                    // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:221:9: '0' ( '0' .. '7' )+
                    {
                    match('0'); 
                    // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:221:13: ( '0' .. '7' )+
                    int cnt2=0;
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( ((LA2_0>='0' && LA2_0<='7')) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:221:14: '0' .. '7'
                    	    {
                    	    matchRange('0','7'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt2 >= 1 ) break loop2;
                                EarlyExitException eee =
                                    new EarlyExitException(2, input);
                                throw eee;
                        }
                        cnt2++;
                    } while (true);


                    }
                    break;
                case 4 :
                    // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:222:9: HexPrefix ( HexDigit )+
                    {
                    mHexPrefix(); 
                    // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:222:19: ( HexDigit )+
                    int cnt3=0;
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( ((LA3_0>='0' && LA3_0<='9')||(LA3_0>='A' && LA3_0<='F')||(LA3_0>='a' && LA3_0<='f')) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:222:19: HexDigit
                    	    {
                    	    mHexDigit(); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt3 >= 1 ) break loop3;
                                EarlyExitException eee =
                                    new EarlyExitException(3, input);
                                throw eee;
                        }
                        cnt3++;
                    } while (true);


                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "IntegerNumber"

    // $ANTLR start "HexPrefix"
    public final void mHexPrefix() throws RecognitionException {
        try {
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:226:5: ( '0x' | '0X' )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='0') ) {
                int LA5_1 = input.LA(2);

                if ( (LA5_1=='x') ) {
                    alt5=1;
                }
                else if ( (LA5_1=='X') ) {
                    alt5=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:226:9: '0x'
                    {
                    match("0x"); 


                    }
                    break;
                case 2 :
                    // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:226:16: '0X'
                    {
                    match("0X"); 


                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "HexPrefix"

    // $ANTLR start "HexDigit"
    public final void mHexDigit() throws RecognitionException {
        try {
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:231:5: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:231:9: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
            {
            if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "HexDigit"

    // $ANTLR start "LongSuffix"
    public final void mLongSuffix() throws RecognitionException {
        try {
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:235:5: ( 'l' | 'L' )
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:
            {
            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "LongSuffix"

    // $ANTLR start "NonIntegerNumber"
    public final void mNonIntegerNumber() throws RecognitionException {
        try {
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:240:5: ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( Exponent )? | '.' ( '0' .. '9' )+ ( Exponent )? | ( '0' .. '9' )+ Exponent | ( '0' .. '9' )+ | HexPrefix ( HexDigit )* ( () | ( '.' ( HexDigit )* ) ) ( 'p' | 'P' ) ( '+' | '-' )? ( '0' .. '9' )+ )
            int alt18=5;
            alt18 = dfa18.predict(input);
            switch (alt18) {
                case 1 :
                    // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:240:9: ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( Exponent )?
                    {
                    // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:240:9: ( '0' .. '9' )+
                    int cnt6=0;
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( ((LA6_0>='0' && LA6_0<='9')) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:240:10: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt6 >= 1 ) break loop6;
                                EarlyExitException eee =
                                    new EarlyExitException(6, input);
                                throw eee;
                        }
                        cnt6++;
                    } while (true);

                    match('.'); 
                    // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:240:27: ( '0' .. '9' )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( ((LA7_0>='0' && LA7_0<='9')) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:240:28: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);

                    // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:240:41: ( Exponent )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0=='E'||LA8_0=='e') ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:240:41: Exponent
                            {
                            mExponent(); 

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:241:9: '.' ( '0' .. '9' )+ ( Exponent )?
                    {
                    match('.'); 
                    // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:241:13: ( '0' .. '9' )+
                    int cnt9=0;
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( ((LA9_0>='0' && LA9_0<='9')) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:241:15: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

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

                    // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:241:29: ( Exponent )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0=='E'||LA10_0=='e') ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:241:29: Exponent
                            {
                            mExponent(); 

                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:242:9: ( '0' .. '9' )+ Exponent
                    {
                    // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:242:9: ( '0' .. '9' )+
                    int cnt11=0;
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( ((LA11_0>='0' && LA11_0<='9')) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:242:10: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt11 >= 1 ) break loop11;
                                EarlyExitException eee =
                                    new EarlyExitException(11, input);
                                throw eee;
                        }
                        cnt11++;
                    } while (true);

                    mExponent(); 

                    }
                    break;
                case 4 :
                    // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:243:9: ( '0' .. '9' )+
                    {
                    // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:243:9: ( '0' .. '9' )+
                    int cnt12=0;
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( ((LA12_0>='0' && LA12_0<='9')) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:243:10: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt12 >= 1 ) break loop12;
                                EarlyExitException eee =
                                    new EarlyExitException(12, input);
                                throw eee;
                        }
                        cnt12++;
                    } while (true);


                    }
                    break;
                case 5 :
                    // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:245:9: HexPrefix ( HexDigit )* ( () | ( '.' ( HexDigit )* ) ) ( 'p' | 'P' ) ( '+' | '-' )? ( '0' .. '9' )+
                    {
                    mHexPrefix(); 
                    // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:245:19: ( HexDigit )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( ((LA13_0>='0' && LA13_0<='9')||(LA13_0>='A' && LA13_0<='F')||(LA13_0>='a' && LA13_0<='f')) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:245:20: HexDigit
                    	    {
                    	    mHexDigit(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);

                    // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:246:9: ( () | ( '.' ( HexDigit )* ) )
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0=='P'||LA15_0=='p') ) {
                        alt15=1;
                    }
                    else if ( (LA15_0=='.') ) {
                        alt15=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 15, 0, input);

                        throw nvae;
                    }
                    switch (alt15) {
                        case 1 :
                            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:246:14: ()
                            {
                            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:246:14: ()
                            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:246:15: 
                            {
                            }


                            }
                            break;
                        case 2 :
                            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:247:14: ( '.' ( HexDigit )* )
                            {
                            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:247:14: ( '.' ( HexDigit )* )
                            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:247:15: '.' ( HexDigit )*
                            {
                            match('.'); 
                            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:247:19: ( HexDigit )*
                            loop14:
                            do {
                                int alt14=2;
                                int LA14_0 = input.LA(1);

                                if ( ((LA14_0>='0' && LA14_0<='9')||(LA14_0>='A' && LA14_0<='F')||(LA14_0>='a' && LA14_0<='f')) ) {
                                    alt14=1;
                                }


                                switch (alt14) {
                            	case 1 :
                            	    // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:247:20: HexDigit
                            	    {
                            	    mHexDigit(); 

                            	    }
                            	    break;

                            	default :
                            	    break loop14;
                                }
                            } while (true);


                            }


                            }
                            break;

                    }

                    if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}

                    // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:250:9: ( '+' | '-' )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0=='+'||LA16_0=='-') ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:
                            {
                            if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                                input.consume();

                            }
                            else {
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                recover(mse);
                                throw mse;}


                            }
                            break;

                    }

                    // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:251:9: ( '0' .. '9' )+
                    int cnt17=0;
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( ((LA17_0>='0' && LA17_0<='9')) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:251:11: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

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


                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "NonIntegerNumber"

    // $ANTLR start "Exponent"
    public final void mExponent() throws RecognitionException {
        try {
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:256:5: ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:256:9: ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:256:23: ( '+' | '-' )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0=='+'||LA19_0=='-') ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }

            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:256:38: ( '0' .. '9' )+
            int cnt20=0;
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( ((LA20_0>='0' && LA20_0<='9')) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:256:40: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

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


            }

        }
        finally {
        }
    }
    // $ANTLR end "Exponent"

    // $ANTLR start "FloatSuffix"
    public final void mFloatSuffix() throws RecognitionException {
        try {
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:261:5: ( 'f' | 'F' )
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:
            {
            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "FloatSuffix"

    // $ANTLR start "DoubleSuffix"
    public final void mDoubleSuffix() throws RecognitionException {
        try {
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:265:5: ( 'd' | 'D' )
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:
            {
            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "DoubleSuffix"

    // $ANTLR start "FLOATLITERAL"
    public final void mFLOATLITERAL() throws RecognitionException {
        try {
            int _type = FLOATLITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:269:5: ( NonIntegerNumber FloatSuffix )
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:269:9: NonIntegerNumber FloatSuffix
            {
            mNonIntegerNumber(); 
            mFloatSuffix(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FLOATLITERAL"

    // $ANTLR start "DOUBLELITERAL"
    public final void mDOUBLELITERAL() throws RecognitionException {
        try {
            int _type = DOUBLELITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:273:5: ( NonIntegerNumber ( DoubleSuffix )? )
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:273:9: NonIntegerNumber ( DoubleSuffix )?
            {
            mNonIntegerNumber(); 
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:273:26: ( DoubleSuffix )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0=='D'||LA21_0=='d') ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:273:26: DoubleSuffix
                    {
                    mDoubleSuffix(); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DOUBLELITERAL"

    // $ANTLR start "CHARLITERAL"
    public final void mCHARLITERAL() throws RecognitionException {
        try {
            int _type = CHARLITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:277:5: ( '\\'' ( EscapeSequence | ~ ( '\\'' | '\\\\' | '\\r' | '\\n' ) )* '\\'' )
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:277:9: '\\'' ( EscapeSequence | ~ ( '\\'' | '\\\\' | '\\r' | '\\n' ) )* '\\''
            {
            match('\''); 
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:278:9: ( EscapeSequence | ~ ( '\\'' | '\\\\' | '\\r' | '\\n' ) )*
            loop22:
            do {
                int alt22=3;
                int LA22_0 = input.LA(1);

                if ( (LA22_0=='\\') ) {
                    alt22=1;
                }
                else if ( ((LA22_0>='\u0000' && LA22_0<='\t')||(LA22_0>='\u000B' && LA22_0<='\f')||(LA22_0>='\u000E' && LA22_0<='&')||(LA22_0>='(' && LA22_0<='[')||(LA22_0>=']' && LA22_0<='\uFFFF')) ) {
                    alt22=2;
                }


                switch (alt22) {
            	case 1 :
            	    // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:278:13: EscapeSequence
            	    {
            	    mEscapeSequence(); 

            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:279:13: ~ ( '\\'' | '\\\\' | '\\r' | '\\n' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CHARLITERAL"

    // $ANTLR start "STRINGLITERAL"
    public final void mSTRINGLITERAL() throws RecognitionException {
        try {
            int _type = STRINGLITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:285:5: ( '\"' ( EscapeSequence | ~ ( '\\\\' | '\"' | '\\r' | '\\n' ) )* '\"' )
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:285:9: '\"' ( EscapeSequence | ~ ( '\\\\' | '\"' | '\\r' | '\\n' ) )* '\"'
            {
            match('\"'); 
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:286:9: ( EscapeSequence | ~ ( '\\\\' | '\"' | '\\r' | '\\n' ) )*
            loop23:
            do {
                int alt23=3;
                int LA23_0 = input.LA(1);

                if ( (LA23_0=='\\') ) {
                    alt23=1;
                }
                else if ( ((LA23_0>='\u0000' && LA23_0<='\t')||(LA23_0>='\u000B' && LA23_0<='\f')||(LA23_0>='\u000E' && LA23_0<='!')||(LA23_0>='#' && LA23_0<='[')||(LA23_0>=']' && LA23_0<='\uFFFF')) ) {
                    alt23=2;
                }


                switch (alt23) {
            	case 1 :
            	    // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:286:13: EscapeSequence
            	    {
            	    mEscapeSequence(); 

            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:287:13: ~ ( '\\\\' | '\"' | '\\r' | '\\n' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STRINGLITERAL"

    // $ANTLR start "EscapeSequence"
    public final void mEscapeSequence() throws RecognitionException {
        try {
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:294:5: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' | ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | ( '0' .. '7' ) ( '0' .. '7' ) | ( '0' .. '7' ) ) )
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:294:9: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' | ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | ( '0' .. '7' ) ( '0' .. '7' ) | ( '0' .. '7' ) )
            {
            match('\\'); 
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:294:14: ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' | ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | ( '0' .. '7' ) ( '0' .. '7' ) | ( '0' .. '7' ) )
            int alt24=11;
            alt24 = dfa24.predict(input);
            switch (alt24) {
                case 1 :
                    // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:295:18: 'b'
                    {
                    match('b'); 

                    }
                    break;
                case 2 :
                    // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:296:18: 't'
                    {
                    match('t'); 

                    }
                    break;
                case 3 :
                    // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:297:18: 'n'
                    {
                    match('n'); 

                    }
                    break;
                case 4 :
                    // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:298:18: 'f'
                    {
                    match('f'); 

                    }
                    break;
                case 5 :
                    // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:299:18: 'r'
                    {
                    match('r'); 

                    }
                    break;
                case 6 :
                    // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:300:18: '\\\"'
                    {
                    match('\"'); 

                    }
                    break;
                case 7 :
                    // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:301:18: '\\''
                    {
                    match('\''); 

                    }
                    break;
                case 8 :
                    // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:302:18: '\\\\'
                    {
                    match('\\'); 

                    }
                    break;
                case 9 :
                    // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:304:18: ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:304:18: ( '0' .. '3' )
                    // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:304:19: '0' .. '3'
                    {
                    matchRange('0','3'); 

                    }

                    // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:304:29: ( '0' .. '7' )
                    // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:304:30: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }

                    // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:304:40: ( '0' .. '7' )
                    // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:304:41: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;
                case 10 :
                    // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:306:18: ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:306:18: ( '0' .. '7' )
                    // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:306:19: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }

                    // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:306:29: ( '0' .. '7' )
                    // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:306:30: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;
                case 11 :
                    // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:308:18: ( '0' .. '7' )
                    {
                    // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:308:18: ( '0' .. '7' )
                    // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:308:19: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;

            }


            }

        }
        finally {
        }
    }
    // $ANTLR end "EscapeSequence"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:312:5: ( ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' ) )
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:312:9: ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' )
            {
            if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||(input.LA(1)>='\f' && input.LA(1)<='\r')||input.LA(1)==' ' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


                            skip();
                        

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "TRUE"
    public final void mTRUE() throws RecognitionException {
        try {
            int _type = TRUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:325:5: ( 'true' )
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:325:9: 'true'
            {
            match("true"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TRUE"

    // $ANTLR start "FALSE"
    public final void mFALSE() throws RecognitionException {
        try {
            int _type = FALSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:328:5: ( 'false' )
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:328:9: 'false'
            {
            match("false"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FALSE"

    // $ANTLR start "NULL"
    public final void mNULL() throws RecognitionException {
        try {
            int _type = NULL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:331:5: ( 'null' )
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:331:9: 'null'
            {
            match("null"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NULL"

    // $ANTLR start "SUPER"
    public final void mSUPER() throws RecognitionException {
        try {
            int _type = SUPER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:334:5: ( 'super' )
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:334:9: 'super'
            {
            match("super"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SUPER"

    // $ANTLR start "LPAREN"
    public final void mLPAREN() throws RecognitionException {
        try {
            int _type = LPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:337:5: ( '(' )
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:337:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LPAREN"

    // $ANTLR start "RPAREN"
    public final void mRPAREN() throws RecognitionException {
        try {
            int _type = RPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:340:5: ( ')' )
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:340:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RPAREN"

    // $ANTLR start "LBRACKET"
    public final void mLBRACKET() throws RecognitionException {
        try {
            int _type = LBRACKET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:343:5: ( '[' )
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:343:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LBRACKET"

    // $ANTLR start "RBRACKET"
    public final void mRBRACKET() throws RecognitionException {
        try {
            int _type = RBRACKET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:346:5: ( ']' )
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:346:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RBRACKET"

    // $ANTLR start "DOT"
    public final void mDOT() throws RecognitionException {
        try {
            int _type = DOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:349:5: ( '.' )
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:349:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DOT"

    // $ANTLR start "EQ"
    public final void mEQ() throws RecognitionException {
        try {
            int _type = EQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:352:5: ( '=' )
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:352:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EQ"

    // $ANTLR start "BANG"
    public final void mBANG() throws RecognitionException {
        try {
            int _type = BANG;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:355:5: ( '!' )
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:355:9: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BANG"

    // $ANTLR start "TILDE"
    public final void mTILDE() throws RecognitionException {
        try {
            int _type = TILDE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:358:5: ( '~' )
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:358:9: '~'
            {
            match('~'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TILDE"

    // $ANTLR start "EQEQ"
    public final void mEQEQ() throws RecognitionException {
        try {
            int _type = EQEQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:361:5: ( '==' )
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:361:9: '=='
            {
            match("=="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EQEQ"

    // $ANTLR start "AMPAMP"
    public final void mAMPAMP() throws RecognitionException {
        try {
            int _type = AMPAMP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:364:5: ( '&&' )
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:364:9: '&&'
            {
            match("&&"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AMPAMP"

    // $ANTLR start "BARBAR"
    public final void mBARBAR() throws RecognitionException {
        try {
            int _type = BARBAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:367:5: ( '||' )
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:367:9: '||'
            {
            match("||"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BARBAR"

    // $ANTLR start "PLUS"
    public final void mPLUS() throws RecognitionException {
        try {
            int _type = PLUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:370:5: ( '+' )
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:370:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PLUS"

    // $ANTLR start "SUB"
    public final void mSUB() throws RecognitionException {
        try {
            int _type = SUB;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:373:5: ( '-' )
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:373:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SUB"

    // $ANTLR start "STAR"
    public final void mSTAR() throws RecognitionException {
        try {
            int _type = STAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:376:5: ( '*' )
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:376:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STAR"

    // $ANTLR start "SLASH"
    public final void mSLASH() throws RecognitionException {
        try {
            int _type = SLASH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:379:5: ( '/' )
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:379:9: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SLASH"

    // $ANTLR start "AMP"
    public final void mAMP() throws RecognitionException {
        try {
            int _type = AMP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:382:5: ( '&' )
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:382:9: '&'
            {
            match('&'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AMP"

    // $ANTLR start "BAR"
    public final void mBAR() throws RecognitionException {
        try {
            int _type = BAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:385:5: ( '|' )
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:385:9: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BAR"

    // $ANTLR start "CARET"
    public final void mCARET() throws RecognitionException {
        try {
            int _type = CARET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:388:5: ( '^' )
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:388:9: '^'
            {
            match('^'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CARET"

    // $ANTLR start "PERCENT"
    public final void mPERCENT() throws RecognitionException {
        try {
            int _type = PERCENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:391:5: ( '%' )
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:391:9: '%'
            {
            match('%'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PERCENT"

    // $ANTLR start "BANGEQ"
    public final void mBANGEQ() throws RecognitionException {
        try {
            int _type = BANGEQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:394:5: ( '!=' )
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:394:9: '!='
            {
            match("!="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BANGEQ"

    // $ANTLR start "GT"
    public final void mGT() throws RecognitionException {
        try {
            int _type = GT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:397:5: ( '>' )
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:397:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GT"

    // $ANTLR start "LT"
    public final void mLT() throws RecognitionException {
        try {
            int _type = LT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:400:5: ( '<' )
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:400:9: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LT"

    // $ANTLR start "IDENTIFIER"
    public final void mIDENTIFIER() throws RecognitionException {
        try {
            int _type = IDENTIFIER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:404:5: ( LETTER ( LETTER | JavaIDDigit )* )
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:404:9: LETTER ( LETTER | JavaIDDigit )*
            {
            mLETTER(); 
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:404:16: ( LETTER | JavaIDDigit )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0=='$'||(LA25_0>='0' && LA25_0<='9')||(LA25_0>='A' && LA25_0<='Z')||LA25_0=='_'||(LA25_0>='a' && LA25_0<='z')||(LA25_0>='\u00C0' && LA25_0<='\u00D6')||(LA25_0>='\u00D8' && LA25_0<='\u00F6')||(LA25_0>='\u00F8' && LA25_0<='\u1FFF')||(LA25_0>='\u3040' && LA25_0<='\u318F')||(LA25_0>='\u3300' && LA25_0<='\u337F')||(LA25_0>='\u3400' && LA25_0<='\u3D2D')||(LA25_0>='\u4E00' && LA25_0<='\u9FFF')||(LA25_0>='\uF900' && LA25_0<='\uFAFF')) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:
            	    {
            	    if ( input.LA(1)=='$'||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z')||(input.LA(1)>='\u00C0' && input.LA(1)<='\u00D6')||(input.LA(1)>='\u00D8' && input.LA(1)<='\u00F6')||(input.LA(1)>='\u00F8' && input.LA(1)<='\u1FFF')||(input.LA(1)>='\u3040' && input.LA(1)<='\u318F')||(input.LA(1)>='\u3300' && input.LA(1)<='\u337F')||(input.LA(1)>='\u3400' && input.LA(1)<='\u3D2D')||(input.LA(1)>='\u4E00' && input.LA(1)<='\u9FFF')||(input.LA(1)>='\uF900' && input.LA(1)<='\uFAFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IDENTIFIER"

    // $ANTLR start "LETTER"
    public final void mLETTER() throws RecognitionException {
        try {
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:409:5: ( '\\u0024' | '\\u0041' .. '\\u005a' | '\\u005f' | '\\u0061' .. '\\u007a' | '\\u00c0' .. '\\u00d6' | '\\u00d8' .. '\\u00f6' | '\\u00f8' .. '\\u00ff' | '\\u0100' .. '\\u1fff' | '\\u3040' .. '\\u318f' | '\\u3300' .. '\\u337f' | '\\u3400' .. '\\u3d2d' | '\\u4e00' .. '\\u9fff' | '\\uf900' .. '\\ufaff' )
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:
            {
            if ( input.LA(1)=='$'||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z')||(input.LA(1)>='\u00C0' && input.LA(1)<='\u00D6')||(input.LA(1)>='\u00D8' && input.LA(1)<='\u00F6')||(input.LA(1)>='\u00F8' && input.LA(1)<='\u1FFF')||(input.LA(1)>='\u3040' && input.LA(1)<='\u318F')||(input.LA(1)>='\u3300' && input.LA(1)<='\u337F')||(input.LA(1)>='\u3400' && input.LA(1)<='\u3D2D')||(input.LA(1)>='\u4E00' && input.LA(1)<='\u9FFF')||(input.LA(1)>='\uF900' && input.LA(1)<='\uFAFF') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "LETTER"

    // $ANTLR start "JavaIDDigit"
    public final void mJavaIDDigit() throws RecognitionException {
        try {
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:426:5: ( '\\u0030' .. '\\u0039' | '\\u0660' .. '\\u0669' | '\\u06f0' .. '\\u06f9' | '\\u0966' .. '\\u096f' | '\\u09e6' .. '\\u09ef' | '\\u0a66' .. '\\u0a6f' | '\\u0ae6' .. '\\u0aef' | '\\u0b66' .. '\\u0b6f' | '\\u0be7' .. '\\u0bef' | '\\u0c66' .. '\\u0c6f' | '\\u0ce6' .. '\\u0cef' | '\\u0d66' .. '\\u0d6f' | '\\u0e50' .. '\\u0e59' | '\\u0ed0' .. '\\u0ed9' | '\\u1040' .. '\\u1049' )
            // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:
            {
            if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='\u0660' && input.LA(1)<='\u0669')||(input.LA(1)>='\u06F0' && input.LA(1)<='\u06F9')||(input.LA(1)>='\u0966' && input.LA(1)<='\u096F')||(input.LA(1)>='\u09E6' && input.LA(1)<='\u09EF')||(input.LA(1)>='\u0A66' && input.LA(1)<='\u0A6F')||(input.LA(1)>='\u0AE6' && input.LA(1)<='\u0AEF')||(input.LA(1)>='\u0B66' && input.LA(1)<='\u0B6F')||(input.LA(1)>='\u0BE7' && input.LA(1)<='\u0BEF')||(input.LA(1)>='\u0C66' && input.LA(1)<='\u0C6F')||(input.LA(1)>='\u0CE6' && input.LA(1)<='\u0CEF')||(input.LA(1)>='\u0D66' && input.LA(1)<='\u0D6F')||(input.LA(1)>='\u0E50' && input.LA(1)<='\u0E59')||(input.LA(1)>='\u0ED0' && input.LA(1)<='\u0ED9')||(input.LA(1)>='\u1040' && input.LA(1)<='\u1049') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "JavaIDDigit"

    public void mTokens() throws RecognitionException {
        // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:1:8: ( T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | LONGLITERAL | RANGELITERAL | INTLITERAL | FLOATLITERAL | DOUBLELITERAL | CHARLITERAL | STRINGLITERAL | WS | TRUE | FALSE | NULL | SUPER | LPAREN | RPAREN | LBRACKET | RBRACKET | DOT | EQ | BANG | TILDE | EQEQ | AMPAMP | BARBAR | PLUS | SUB | STAR | SLASH | AMP | BAR | CARET | PERCENT | BANGEQ | GT | LT | IDENTIFIER )
        int alt26=42;
        alt26 = dfa26.predict(input);
        switch (alt26) {
            case 1 :
                // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:1:10: T__50
                {
                mT__50(); 

                }
                break;
            case 2 :
                // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:1:16: T__51
                {
                mT__51(); 

                }
                break;
            case 3 :
                // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:1:22: T__52
                {
                mT__52(); 

                }
                break;
            case 4 :
                // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:1:28: T__53
                {
                mT__53(); 

                }
                break;
            case 5 :
                // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:1:34: T__54
                {
                mT__54(); 

                }
                break;
            case 6 :
                // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:1:40: T__55
                {
                mT__55(); 

                }
                break;
            case 7 :
                // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:1:46: T__56
                {
                mT__56(); 

                }
                break;
            case 8 :
                // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:1:52: LONGLITERAL
                {
                mLONGLITERAL(); 

                }
                break;
            case 9 :
                // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:1:64: RANGELITERAL
                {
                mRANGELITERAL(); 

                }
                break;
            case 10 :
                // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:1:77: INTLITERAL
                {
                mINTLITERAL(); 

                }
                break;
            case 11 :
                // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:1:88: FLOATLITERAL
                {
                mFLOATLITERAL(); 

                }
                break;
            case 12 :
                // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:1:101: DOUBLELITERAL
                {
                mDOUBLELITERAL(); 

                }
                break;
            case 13 :
                // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:1:115: CHARLITERAL
                {
                mCHARLITERAL(); 

                }
                break;
            case 14 :
                // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:1:127: STRINGLITERAL
                {
                mSTRINGLITERAL(); 

                }
                break;
            case 15 :
                // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:1:141: WS
                {
                mWS(); 

                }
                break;
            case 16 :
                // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:1:144: TRUE
                {
                mTRUE(); 

                }
                break;
            case 17 :
                // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:1:149: FALSE
                {
                mFALSE(); 

                }
                break;
            case 18 :
                // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:1:155: NULL
                {
                mNULL(); 

                }
                break;
            case 19 :
                // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:1:160: SUPER
                {
                mSUPER(); 

                }
                break;
            case 20 :
                // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:1:166: LPAREN
                {
                mLPAREN(); 

                }
                break;
            case 21 :
                // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:1:173: RPAREN
                {
                mRPAREN(); 

                }
                break;
            case 22 :
                // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:1:180: LBRACKET
                {
                mLBRACKET(); 

                }
                break;
            case 23 :
                // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:1:189: RBRACKET
                {
                mRBRACKET(); 

                }
                break;
            case 24 :
                // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:1:198: DOT
                {
                mDOT(); 

                }
                break;
            case 25 :
                // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:1:202: EQ
                {
                mEQ(); 

                }
                break;
            case 26 :
                // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:1:205: BANG
                {
                mBANG(); 

                }
                break;
            case 27 :
                // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:1:210: TILDE
                {
                mTILDE(); 

                }
                break;
            case 28 :
                // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:1:216: EQEQ
                {
                mEQEQ(); 

                }
                break;
            case 29 :
                // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:1:221: AMPAMP
                {
                mAMPAMP(); 

                }
                break;
            case 30 :
                // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:1:228: BARBAR
                {
                mBARBAR(); 

                }
                break;
            case 31 :
                // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:1:235: PLUS
                {
                mPLUS(); 

                }
                break;
            case 32 :
                // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:1:240: SUB
                {
                mSUB(); 

                }
                break;
            case 33 :
                // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:1:244: STAR
                {
                mSTAR(); 

                }
                break;
            case 34 :
                // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:1:249: SLASH
                {
                mSLASH(); 

                }
                break;
            case 35 :
                // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:1:255: AMP
                {
                mAMP(); 

                }
                break;
            case 36 :
                // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:1:259: BAR
                {
                mBAR(); 

                }
                break;
            case 37 :
                // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:1:263: CARET
                {
                mCARET(); 

                }
                break;
            case 38 :
                // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:1:269: PERCENT
                {
                mPERCENT(); 

                }
                break;
            case 39 :
                // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:1:277: BANGEQ
                {
                mBANGEQ(); 

                }
                break;
            case 40 :
                // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:1:284: GT
                {
                mGT(); 

                }
                break;
            case 41 :
                // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:1:287: LT
                {
                mLT(); 

                }
                break;
            case 42 :
                // C:\\Users\\Erdinc\\Projects\\cambridge\\src\\main\\java\\cambridge\\parser\\expressions\\Expression.g:1:290: IDENTIFIER
                {
                mIDENTIFIER(); 

                }
                break;

        }

    }


    protected DFA18 dfa18 = new DFA18(this);
    protected DFA24 dfa24 = new DFA24(this);
    protected DFA26 dfa26 = new DFA26(this);
    static final String DFA18_eotS =
        "\1\uffff\1\7\1\uffff\1\7\4\uffff";
    static final String DFA18_eofS =
        "\10\uffff";
    static final String DFA18_minS =
        "\2\56\1\uffff\1\56\4\uffff";
    static final String DFA18_maxS =
        "\1\71\1\170\1\uffff\1\145\4\uffff";
    static final String DFA18_acceptS =
        "\2\uffff\1\2\1\uffff\1\5\1\1\1\3\1\4";
    static final String DFA18_specialS =
        "\10\uffff}>";
    static final String[] DFA18_transitionS = {
            "\1\2\1\uffff\1\1\11\3",
            "\1\5\1\uffff\12\3\13\uffff\1\6\22\uffff\1\4\14\uffff\1\6\22"+
            "\uffff\1\4",
            "",
            "\1\5\1\uffff\12\3\13\uffff\1\6\37\uffff\1\6",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA18_eot = DFA.unpackEncodedString(DFA18_eotS);
    static final short[] DFA18_eof = DFA.unpackEncodedString(DFA18_eofS);
    static final char[] DFA18_min = DFA.unpackEncodedStringToUnsignedChars(DFA18_minS);
    static final char[] DFA18_max = DFA.unpackEncodedStringToUnsignedChars(DFA18_maxS);
    static final short[] DFA18_accept = DFA.unpackEncodedString(DFA18_acceptS);
    static final short[] DFA18_special = DFA.unpackEncodedString(DFA18_specialS);
    static final short[][] DFA18_transition;

    static {
        int numStates = DFA18_transitionS.length;
        DFA18_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA18_transition[i] = DFA.unpackEncodedString(DFA18_transitionS[i]);
        }
    }

    class DFA18 extends DFA {

        public DFA18(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 18;
            this.eot = DFA18_eot;
            this.eof = DFA18_eof;
            this.min = DFA18_min;
            this.max = DFA18_max;
            this.accept = DFA18_accept;
            this.special = DFA18_special;
            this.transition = DFA18_transition;
        }
        public String getDescription() {
            return "238:1: fragment NonIntegerNumber : ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( Exponent )? | '.' ( '0' .. '9' )+ ( Exponent )? | ( '0' .. '9' )+ Exponent | ( '0' .. '9' )+ | HexPrefix ( HexDigit )* ( () | ( '.' ( HexDigit )* ) ) ( 'p' | 'P' ) ( '+' | '-' )? ( '0' .. '9' )+ );";
        }
    }
    static final String DFA24_eotS =
        "\11\uffff\2\13\1\uffff\1\15\2\uffff";
    static final String DFA24_eofS =
        "\17\uffff";
    static final String DFA24_minS =
        "\1\42\10\uffff\2\60\1\uffff\1\60\2\uffff";
    static final String DFA24_maxS =
        "\1\164\10\uffff\2\67\1\uffff\1\67\2\uffff";
    static final String DFA24_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\2\uffff\1\13\1\uffff"+
        "\1\12\1\11";
    static final String DFA24_specialS =
        "\17\uffff}>";
    static final String[] DFA24_transitionS = {
            "\1\6\4\uffff\1\7\10\uffff\4\11\4\12\44\uffff\1\10\5\uffff\1"+
            "\1\3\uffff\1\4\7\uffff\1\3\3\uffff\1\5\1\uffff\1\2",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\10\14",
            "\10\15",
            "",
            "\10\16",
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
            return "294:14: ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' | ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | ( '0' .. '7' ) ( '0' .. '7' ) | ( '0' .. '7' ) )";
        }
    }
    static final String DFA26_eotS =
        "\6\uffff\2\50\1\61\3\uffff\4\41\4\uffff\1\67\1\71\1\uffff\1\73"+
        "\1\75\16\uffff\1\50\2\uffff\1\51\1\uffff\1\51\2\uffff\1\50\1\51"+
        "\1\uffff\4\41\10\uffff\1\50\2\uffff\1\51\1\uffff\1\51\1\uffff\1"+
        "\51\2\uffff\4\41\2\uffff\1\51\2\uffff\1\51\1\uffff\1\51\1\130\1"+
        "\41\1\132\1\41\1\uffff\1\134\1\uffff\1\135\2\uffff";
    static final String DFA26_eofS =
        "\136\uffff";
    static final String DFA26_minS =
        "\1\11\4\uffff\1\151\2\56\1\60\3\uffff\1\162\1\141\2\165\4\uffff"+
        "\2\75\1\uffff\1\46\1\174\14\uffff\3\56\2\uffff\1\56\1\53\1\56\2"+
        "\uffff\1\56\1\60\1\uffff\1\165\2\154\1\160\10\uffff\1\56\1\53\4"+
        "\60\1\uffff\1\60\2\53\1\145\1\163\1\154\1\145\1\56\7\60\1\44\1\145"+
        "\1\44\1\162\1\uffff\1\44\1\uffff\1\44\2\uffff";
    static final String DFA26_maxS =
        "\1\ufaff\4\uffff\1\164\1\170\1\154\1\71\3\uffff\1\162\1\141\2\165"+
        "\4\uffff\2\75\1\uffff\1\46\1\174\14\uffff\2\160\1\154\2\uffff\1"+
        "\146\1\71\1\146\2\uffff\1\154\1\146\1\uffff\1\165\2\154\1\160\10"+
        "\uffff\1\160\1\71\1\160\1\146\1\71\1\146\1\uffff\1\146\2\71\1\145"+
        "\1\163\1\154\1\145\1\160\1\71\1\146\1\160\1\71\1\146\1\71\1\146"+
        "\1\ufaff\1\145\1\ufaff\1\162\1\uffff\1\ufaff\1\uffff\1\ufaff\2\uffff";
    static final String DFA26_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\4\uffff\1\15\1\16\1\17\4\uffff\1\24\1"+
        "\25\1\26\1\27\2\uffff\1\33\2\uffff\1\37\1\40\1\41\1\42\1\45\1\46"+
        "\1\50\1\51\1\52\1\5\1\6\1\7\3\uffff\1\12\1\14\3\uffff\1\13\1\10"+
        "\2\uffff\1\30\4\uffff\1\34\1\31\1\47\1\32\1\35\1\43\1\36\1\44\6"+
        "\uffff\1\11\23\uffff\1\20\1\uffff\1\22\1\uffff\1\21\1\23";
    static final String DFA26_specialS =
        "\136\uffff}>";
    static final String[] DFA26_transitionS = {
            "\2\13\1\uffff\2\13\22\uffff\1\13\1\25\1\12\1\5\1\41\1\36\1"+
            "\27\1\11\1\20\1\21\1\33\1\31\1\3\1\32\1\10\1\34\1\6\11\7\1\2"+
            "\1\uffff\1\40\1\24\1\37\2\uffff\32\41\1\22\1\uffff\1\23\1\35"+
            "\1\41\1\uffff\5\41\1\15\7\41\1\16\4\41\1\17\1\14\6\41\1\1\1"+
            "\30\1\4\1\26\101\uffff\27\41\1\uffff\37\41\1\uffff\u1f08\41"+
            "\u1040\uffff\u0150\41\u0170\uffff\u0080\41\u0080\uffff\u092e"+
            "\41\u10d2\uffff\u5200\41\u5900\uffff\u0200\41",
            "",
            "",
            "",
            "",
            "\1\44\11\uffff\1\42\1\43",
            "\1\54\1\uffff\10\47\2\52\12\uffff\1\51\1\53\1\55\5\uffff\1"+
            "\56\13\uffff\1\46\13\uffff\1\51\1\53\1\55\5\uffff\1\56\13\uffff"+
            "\1\45",
            "\1\54\1\uffff\12\57\12\uffff\1\51\1\53\1\55\5\uffff\1\56\27"+
            "\uffff\1\51\1\53\1\55\5\uffff\1\56",
            "\12\60",
            "",
            "",
            "",
            "\1\62",
            "\1\63",
            "\1\64",
            "\1\65",
            "",
            "",
            "",
            "",
            "\1\66",
            "\1\70",
            "",
            "\1\72",
            "\1\74",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\100\1\uffff\12\76\7\uffff\6\76\11\uffff\1\77\20\uffff\6"+
            "\76\11\uffff\1\77",
            "\1\100\1\uffff\12\76\7\uffff\6\76\11\uffff\1\77\20\uffff\6"+
            "\76\11\uffff\1\77",
            "\1\54\1\uffff\10\47\2\52\12\uffff\1\51\1\53\1\55\5\uffff\1"+
            "\56\27\uffff\1\51\1\53\1\55\5\uffff\1\56",
            "",
            "",
            "\1\101\1\uffff\12\52\13\uffff\1\53\1\55\36\uffff\1\53\1\55",
            "\1\102\1\uffff\1\102\2\uffff\12\103",
            "\1\104\1\uffff\12\105\13\uffff\1\106\1\55\36\uffff\1\106\1"+
            "\55",
            "",
            "",
            "\1\54\1\uffff\12\57\12\uffff\1\51\1\53\1\55\5\uffff\1\56\27"+
            "\uffff\1\51\1\53\1\55\5\uffff\1\56",
            "\12\60\13\uffff\1\107\1\55\36\uffff\1\107\1\55",
            "",
            "\1\110",
            "\1\111",
            "\1\112",
            "\1\113",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\114\1\uffff\12\76\7\uffff\6\76\5\uffff\1\56\3\uffff\1\77"+
            "\20\uffff\6\76\5\uffff\1\56\3\uffff\1\77",
            "\1\115\1\uffff\1\115\2\uffff\12\116",
            "\12\117\7\uffff\6\117\11\uffff\1\77\20\uffff\6\117\11\uffff"+
            "\1\77",
            "\12\105\13\uffff\1\106\1\55\36\uffff\1\106\1\55",
            "\12\103",
            "\12\103\14\uffff\1\55\37\uffff\1\55",
            "",
            "\12\105\13\uffff\1\106\1\55\36\uffff\1\106\1\55",
            "\1\120\1\uffff\1\120\2\uffff\12\121",
            "\1\122\1\uffff\1\122\2\uffff\12\123",
            "\1\124",
            "\1\125",
            "\1\126",
            "\1\127",
            "\1\104\1\uffff\12\117\7\uffff\6\117\11\uffff\1\77\20\uffff"+
            "\6\117\11\uffff\1\77",
            "\12\116",
            "\12\116\14\uffff\1\55\37\uffff\1\55",
            "\12\117\7\uffff\6\117\11\uffff\1\77\20\uffff\6\117\11\uffff"+
            "\1\77",
            "\12\121",
            "\12\121\14\uffff\1\55\37\uffff\1\55",
            "\12\123",
            "\12\123\14\uffff\1\55\37\uffff\1\55",
            "\1\41\13\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32"+
            "\41\105\uffff\27\41\1\uffff\37\41\1\uffff\u1f08\41\u1040\uffff"+
            "\u0150\41\u0170\uffff\u0080\41\u0080\uffff\u092e\41\u10d2\uffff"+
            "\u5200\41\u5900\uffff\u0200\41",
            "\1\131",
            "\1\41\13\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32"+
            "\41\105\uffff\27\41\1\uffff\37\41\1\uffff\u1f08\41\u1040\uffff"+
            "\u0150\41\u0170\uffff\u0080\41\u0080\uffff\u092e\41\u10d2\uffff"+
            "\u5200\41\u5900\uffff\u0200\41",
            "\1\133",
            "",
            "\1\41\13\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32"+
            "\41\105\uffff\27\41\1\uffff\37\41\1\uffff\u1f08\41\u1040\uffff"+
            "\u0150\41\u0170\uffff\u0080\41\u0080\uffff\u092e\41\u10d2\uffff"+
            "\u5200\41\u5900\uffff\u0200\41",
            "",
            "\1\41\13\uffff\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32"+
            "\41\105\uffff\27\41\1\uffff\37\41\1\uffff\u1f08\41\u1040\uffff"+
            "\u0150\41\u0170\uffff\u0080\41\u0080\uffff\u092e\41\u10d2\uffff"+
            "\u5200\41\u5900\uffff\u0200\41",
            "",
            ""
    };

    static final short[] DFA26_eot = DFA.unpackEncodedString(DFA26_eotS);
    static final short[] DFA26_eof = DFA.unpackEncodedString(DFA26_eofS);
    static final char[] DFA26_min = DFA.unpackEncodedStringToUnsignedChars(DFA26_minS);
    static final char[] DFA26_max = DFA.unpackEncodedStringToUnsignedChars(DFA26_maxS);
    static final short[] DFA26_accept = DFA.unpackEncodedString(DFA26_acceptS);
    static final short[] DFA26_special = DFA.unpackEncodedString(DFA26_specialS);
    static final short[][] DFA26_transition;

    static {
        int numStates = DFA26_transitionS.length;
        DFA26_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA26_transition[i] = DFA.unpackEncodedString(DFA26_transitionS[i]);
        }
    }

    class DFA26 extends DFA {

        public DFA26(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 26;
            this.eot = DFA26_eot;
            this.eof = DFA26_eof;
            this.min = DFA26_min;
            this.max = DFA26_max;
            this.accept = DFA26_accept;
            this.special = DFA26_special;
            this.transition = DFA26_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | LONGLITERAL | RANGELITERAL | INTLITERAL | FLOATLITERAL | DOUBLELITERAL | CHARLITERAL | STRINGLITERAL | WS | TRUE | FALSE | NULL | SUPER | LPAREN | RPAREN | LBRACKET | RBRACKET | DOT | EQ | BANG | TILDE | EQEQ | AMPAMP | BARBAR | PLUS | SUB | STAR | SLASH | AMP | BAR | CARET | PERCENT | BANGEQ | GT | LT | IDENTIFIER );";
        }
    }
 

}