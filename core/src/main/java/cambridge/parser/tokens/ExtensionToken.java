package cambridge.parser.tokens;

import cambridge.TemplateParsingException;
import cambridge.model.ExtensionNode;

/**
 * Cambridge expressions are returned as ExpressionToken objects from the tokenizer
 */
public abstract class ExtensionToken extends Token {
   public ExtensionToken(int line, int c, String val, int nl, int nc) {
      super(line, c, val, nl, nc);
   }

   public final TokenType getType() {
      return TokenType.EXTENSION;
   }

   @Override
   public String getActualValue() {
      return getFormattedString();
   }

   public abstract ExtensionNode createNode() throws TemplateParsingException;
}
