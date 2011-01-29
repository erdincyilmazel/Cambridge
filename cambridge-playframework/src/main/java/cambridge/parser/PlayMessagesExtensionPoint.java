package cambridge.parser;

import cambridge.model.ExtensionPoint;
import cambridge.parser.tokens.ExtensionToken;

import java.io.IOException;

/**
 * @author Erdinc YILMAZEL
 * @since 1/28/11
 */
public class PlayMessagesExtensionPoint implements ExtensionPoint {
   public String getTagOpener() {
      return "&{";
   }

   public ExtensionToken getToken(TemplateTokenizer tokenizer, int col, int line) throws IOException {
      StringBuilder builder = new StringBuilder();
      char c = tokenizer.nextChar();

      int state = 1;
      builder.append("[");
      while (state != 0) {
         if (c == '{') {
            state++;
         } else if (c == '}') {
            state--;
         }

         if (state == 0) {
            break;
         }

         builder.append(c);
         c = tokenizer.nextChar();
      }
      builder.append("]");

      return new PlayMessagesToken(line, col, builder.toString(), tokenizer.getLineNo(), tokenizer.getColumn(), builder.toString());
   }
}