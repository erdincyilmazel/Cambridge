package cambridge.parser.tokens;

/**
 * Tokenizer returns a CommentToken when it sees a series of characters
 * starting with <!-- chars and ending with --> chars.
 */
public class CommentToken extends Token {
   public CommentToken(int line, int c, String val, int nl, int nc) {
      super(line, c, val, nl, nc);
   }

   public TokenType getType() {
      return TokenType.COMMENT;
   }
}
