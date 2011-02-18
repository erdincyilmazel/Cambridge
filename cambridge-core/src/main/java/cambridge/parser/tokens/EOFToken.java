package cambridge.parser.tokens;

/**
 * Token to represent End Of File character
 */
public class EOFToken extends Token {
   public EOFToken(int line, int c, String val, int nl, int nc) {
      super(line, c, val, nl, nc);
   }

   public TokenType getType() {
      return TokenType.EOF;
   }


   @Override
   public String getFormattedString() {
      return "EOF";
   }
}
