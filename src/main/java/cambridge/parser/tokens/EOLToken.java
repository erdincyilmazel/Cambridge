package cambridge.parser.tokens;

/**
 * Token to represent new line and carriage return characters or both.
 * <p/>
 * \n
 * \r
 * \r\n
 */
public class EOLToken extends Token {
   public EOLToken(int line, int c, String val, int nl, int nc) {
      super(line, c, val, nl, nc);
   }

   public TokenType getType() {
      return TokenType.EOL;
   }

   @Override
   public String getFormattedString() {
      return value.replace("\n", "\\n").replace("\r", "\\r");
   }
}
