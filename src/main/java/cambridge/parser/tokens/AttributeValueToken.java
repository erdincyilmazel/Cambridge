package cambridge.parser.tokens;

/**
 * This token is returned when the Tokenizer sees an attribute value
 * within a tag. The attribute value can be in double quotes, single quotes
 * or no quotes.
 */
public class AttributeValueToken extends Token {
   public AttributeValueToken(int line, int c, String val, int nl, int nc) {
      super(line, c, val, nl, nc);
   }

   public TokenType getType() {
      return TokenType.ATTRIBUTE_VALUE;
   }

   public static int NO_QUOTES = -1;
   public static int DOUBLE_QUOTES = -2;
   public static int SINGLE_QUOTES = -3;

   int quotes = NO_QUOTES;

   public int getQuotes() {
      return quotes;
   }

   public void setQuotes(int quotes) {
      this.quotes = quotes;
   }

   @Override
   public String getFormattedString() {
      if (quotes == NO_QUOTES) return value;
      if (quotes == SINGLE_QUOTES) return "'" + value + "'";
      return "\"" + value + "\"";
   }

   @Override
   public String getActualValue() {
      return getFormattedString();
   }
}
