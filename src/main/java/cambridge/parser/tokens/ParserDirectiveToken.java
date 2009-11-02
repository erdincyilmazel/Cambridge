package cambridge.parser.tokens;

/**
 * Tokens in the form of <!--$   -->.
 * The parser directives are written in properties file syntax.
 * <p/>
 * They can be used to change the attributes and behavior of the parser and the tokenizer.
 */
public class ParserDirectiveToken extends Token {
   public ParserDirectiveToken(int line, int c, String val, int nl, int nc) {
      super(line, c, val, nl, nc);
   }

   public TokenType getType() {
      return TokenType.PARSER_DIRECTIVE;
   }

   String trailingSpace;

   public void setTrailingSpace(String space) {
      trailingSpace = space;
   }

   public String getActualValue() {
      if (trailingSpace != null) return value + trailingSpace;
      return value;
   }
}
