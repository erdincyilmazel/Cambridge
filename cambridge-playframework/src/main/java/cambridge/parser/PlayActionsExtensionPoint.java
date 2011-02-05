package cambridge.parser;

import cambridge.model.ExtensionPoint;
import cambridge.parser.tokens.ExtensionToken;

import java.io.IOException;

/**
 * @author Erdinc YILMAZEL
 * @since 1/28/11
 */
public class PlayActionsExtensionPoint implements ExtensionPoint {
   boolean absolute;

   public PlayActionsExtensionPoint(boolean absolute) {
      this.absolute = absolute;
   }

   public String getTagOpener() {
      return absolute ? "@@{" : "@{";
   }

   public ExtensionToken getToken(TemplateTokenizer tokenizer, int col, int line) throws IOException {
      StringBuilder builder = new StringBuilder();
      char c = tokenizer.nextChar();
      c = eatWhitespace(tokenizer, c);

      String controller = null;
      String action = null;

      if (c == '\'') {
         c = tokenizer.nextChar();
      }

      while (Character.isLetterOrDigit(c)) {
         builder.append(c);
         c = tokenizer.nextChar();
      }

      if (c == '\'') {
         c = tokenizer.nextChar();
      }

      controller = builder.toString();
      builder.setLength(0);
      c = eatWhitespace(tokenizer, c);

      if (c == '.') {
         c = tokenizer.nextChar();
         c = eatWhitespace(tokenizer, c);

         if (Character.isLetter(c)) {
            builder.append(c);
            c = tokenizer.nextChar();
            while (Character.isLetterOrDigit(c)) {
               builder.append(c);
               c = tokenizer.nextChar();
            }

            action = builder.toString();
            builder.setLength(0);

            eatWhitespace(tokenizer, c);
         }
      }

      if (c == '(') {
         int state = 1;
         c = tokenizer.nextChar();
         while (state != 0) {
            builder.append(c);
            c = tokenizer.nextChar();
            if (c == ')') {
               state--;
            } else if (c == '(') {
               state++;
            }
         }
      }

      while (c != '}') {
         c = tokenizer.nextChar();
      }

      if (action == null) {
         action = controller;
         controller = null;
      }

      return new PlayActionToken(line, col, builder.toString(), tokenizer.getLineNo(), tokenizer.getColumn(), controller, action, builder.toString(), absolute);
   }

   private char eatWhitespace(TemplateTokenizer tokenizer, char c) throws IOException {
      // Consume whitespace
      while (Character.isWhitespace(c)) {
         c = tokenizer.nextChar();
      }

      return c;
   }
}