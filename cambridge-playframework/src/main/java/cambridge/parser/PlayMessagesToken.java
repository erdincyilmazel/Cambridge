package cambridge.parser;

import cambridge.ExpressionLanguage;
import cambridge.TemplateParsingException;
import cambridge.model.ExtensionNode;
import cambridge.parser.tokens.ExtensionToken;

/**
 * @author Erdinc YILMAZEL
 * @since 1/28/11
 */
public class PlayMessagesToken extends ExtensionToken {
   String expressions;

   public PlayMessagesToken(int line, int c, String val, int nl, int nc, String expressions) {
      super(line, c, val, nl, nc);
      this.expressions = expressions;
   }

   @Override
   public ExtensionNode createNode(ExpressionLanguage language) throws TemplateParsingException {
      return new PlayMessagesExtensionNode(language, expressions);
   }
}
