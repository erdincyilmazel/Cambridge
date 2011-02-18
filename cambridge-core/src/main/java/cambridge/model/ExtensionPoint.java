package cambridge.model;

import cambridge.parser.TemplateTokenizer;
import cambridge.parser.tokens.ExtensionToken;

import java.io.IOException;

/**
 * @author Erdinc YILMAZEL
 * @since 1/28/11
 */
public interface ExtensionPoint {
   public String getTagOpener();

   public ExtensionToken getToken(TemplateTokenizer tokenizer, int col, int line) throws IOException;
}
