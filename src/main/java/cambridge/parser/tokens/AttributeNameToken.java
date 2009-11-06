package cambridge.parser.tokens;

/**
 * AttributeNameToken is returned by the Tokenizer when it encounters
 * a series of valid characters after a OpenTagToken.
 *
 * @see OpenTagToken
 */
public class AttributeNameToken extends Token {
   public AttributeNameToken(int line, int c, String val, int nl, int nc) {
      super(line, c, val, nl, nc);
   }

   public TokenType getType() {
      return TokenType.ATTRIBUTE_NAME;
   }

   public String getAttributeName() {
      String[] val = value.split(":");
      if (val.length == 1) return val[0];
      else return val[1];
   }

   public String getNameSpace() {
      String[] val = value.split(":");
      if (val.length == 1) return null;
      else return val[0];
   }

   public void setNameSpace(String n) {
      if(getNameSpace() == null) {
         value = n + ":" + value;
      }
   }
}
