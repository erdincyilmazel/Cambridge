package cambridge.parser.tokens;

/**
 * Cambridge expressions are returned as ExpressionToken objects from the tokenizer
 */
public class ExpressionToken extends Token {
   public ExpressionToken(int line, int c, String val, int nl, int nc) {
      super(line, c, val, nl, nc);
   }

   public TokenType getType() {
      return TokenType.EXPRESSION;
   }

   @Override
   public String getFormattedString() {
      return "${" + value + "}";
   }

   @Override
   public String getActualValue() {
      return "${" + value + "}";
   }
}
