package cambridge.parser.tokens;

/**
 * Tokens in the form of <!--$   -->.
 * <p/>
 * They can be used to change the attributes and behavior of the parser and the tokenizer.
 */
public class ParserDirectiveToken extends Token {
   public ParserDirectiveToken(int line, int c, String val, int nl, int nc, String directive, String args) {
      super(line, c, val, nl, nc);
      this.directive = directive;
      this.args = args;
   }

   private final String directive;
   private final String args;

   public String getDirective() {
      return directive;
   }

   public String getArgs() {
      return args;
   }

   public TokenType getType() {
      return TokenType.PARSER_DIRECTIVE;
   }

   private String trailingSpace;

   public void setTrailingSpace(String space) {
      trailingSpace = space;
   }

   public String getActualValue() {
      if (trailingSpace != null) return value + trailingSpace;
      return value;
   }
}
