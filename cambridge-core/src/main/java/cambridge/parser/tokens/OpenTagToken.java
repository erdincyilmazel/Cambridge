package cambridge.parser.tokens;

/**
 * This token is returned from the tokenizer when it encounters
 * a tag opener like <a
 */
public class OpenTagToken extends Token {
   public OpenTagToken(int line, int c, String val, int nl, int nc) {
      super(line, c, val, nl, nc);
   }

   public TokenType getType() {
      return TokenType.OPEN_TAG;
   }

   public String getActualValue() {
      return "<" + value;
   }

   public String getTagName() {
      String[] val = value.split(":");
      if (val.length == 1) return val[0];
      else return val[1];
   }

   public String getNameSpace() {
      String[] val = value.split(":");
      if (val.length == 1) return null;
      else return val[0];
   }
}
