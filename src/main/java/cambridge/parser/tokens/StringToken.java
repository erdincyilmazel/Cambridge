package cambridge.parser.tokens;

/**
 * A token to represent generic text
 */
public class StringToken extends Token {
   public StringToken(int line, int c, String val, int nl, int nc) {
      super(line, c, val, nl, nc);
   }

   public TokenType getType() {
      return TokenType.STRING;
   }
}
