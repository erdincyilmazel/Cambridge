package cambridge.parser.tokens;

/**
 * AssignToken is returned by the tokenizer when it is in a Tag context and
 * it an Assign char (=) after an attribute name. (AttributeNameToken)
 * <p/>
 * Example: <a href =
 *
 * @see AttributeNameToken
 */
public class AssignToken extends Token {
   public AssignToken(int line, int c, String val, int nl, int nc) {
      super(line, c, val, nl, nc);
   }


   public TokenType getType() {
      return TokenType.ASSIGN;
   }
}
