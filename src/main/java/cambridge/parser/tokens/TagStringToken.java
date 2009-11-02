package cambridge.parser.tokens;

/**
 * Arbitrary text within a tag
 */
public class TagStringToken extends Token {
   public TagStringToken(int line, int c, String val, int nl, int nc) {
      super(line, c, val, nl, nc);
   }

   public TokenType getType() {
      return TokenType.TAG_STRING;
   }
}
