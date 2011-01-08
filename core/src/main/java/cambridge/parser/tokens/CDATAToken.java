package cambridge.parser.tokens;

/**
 * This token represents CDATA blocks within the parsed document
 */
public class CDATAToken extends Token {
   public CDATAToken(int line, int c, String val, int nl, int nc) {
      super(line, c, val, nl, nc);
   }

   public TokenType getType() {
      return TokenType.CDATA;
   }
}
