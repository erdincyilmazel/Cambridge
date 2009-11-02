package cambridge.parser.tokens;

/**
 * Tokenizer returns this Token when it sees a close tag like "</a>
 */
public class CloseTagToken extends Token {
   public CloseTagToken(int line, int c, String val, int nl, int nc) {
      super(line, c, val, nl, nc);
   }

   public TokenType getType() {
      return TokenType.CLOSE_TAG;
   }

   String tagName;

   public String getTagName() {
      return tagName;
   }

   public void setTagName(String tagName) {
      this.tagName = tagName;
   }
}
