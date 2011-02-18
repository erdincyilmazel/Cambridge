package cambridge.parser.tokens;

/**
 * > character that is used after the open tag token and following attributes.
 */
public class TagEndToken extends Token {
   public TagEndToken(int line, int c, String val, int nl, int nc) {
      super(line, c, val, nl, nc);
   }

   public TokenType getType() {
      return TokenType.TAG_END;
   }
}
