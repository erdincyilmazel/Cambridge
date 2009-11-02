package cambridge.parser.tokens;

/**
 * A token that represents white space
 */
public class WSToken extends Token {
   public WSToken(int line, int c, String val, int nl, int nc) {
      super(line, c, val, nl, nc);
   }

   public TokenType getType() {
      return TokenType.WS;
   }

   @Override
   public String getFormattedString() {
      return value.replace("\t", "\\t");
   }
}
