package cambridge.parser;

import cambridge.ExpressionLanguage;
import cambridge.TemplateParsingException;
import cambridge.model.ExtensionNode;
import cambridge.parser.tokens.ExtensionToken;

/**
 * @author Erdinc YILMAZEL
 * @since 1/28/11
 */
public class PlayActionToken extends ExtensionToken {
   String controller;
   String action;
   String expressions;
   boolean absolute;

   public PlayActionToken(int line, int c, String val, int nl, int nc, String controller, String action, String expressions, boolean absolute) {
      super(line, c, val, nl, nc);
      this.controller = controller;
      this.action = action;
      this.expressions = expressions;
      this.absolute = absolute;
   }

   @Override
   public ExtensionNode createNode(ExpressionLanguage language) throws TemplateParsingException {
      return new PlayActionExtensionNode(language, controller, action, expressions, absolute);
   }
}
