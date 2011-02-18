package cambridge.model;

import cambridge.parser.TemplateTokenizer;
import cambridge.parser.tokens.Token;

import java.io.IOException;

/**
 * @author Erdinc YILMAZEL
 * @since 1/28/11
 */
public interface TokenGenerator {
   public Token getToken(TemplateTokenizer tokenizer, int col, int line) throws IOException;
}
