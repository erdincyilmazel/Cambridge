package cambridge.parser;

import cambridge.parser.tokens.AssignToken;
import cambridge.parser.tokens.AttributeNameToken;
import cambridge.parser.tokens.AttributeValueToken;
import cambridge.parser.tokens.CDATAToken;
import cambridge.parser.tokens.CloseTagToken;
import cambridge.parser.tokens.CommentToken;
import cambridge.parser.tokens.DocTypeToken;
import cambridge.parser.tokens.EOFToken;
import cambridge.parser.tokens.EOLToken;
import cambridge.parser.tokens.ExpressionToken;
import cambridge.parser.tokens.OpenTagToken;
import cambridge.parser.tokens.ParserDirectiveToken;
import cambridge.parser.tokens.StringToken;
import cambridge.parser.tokens.TagEndToken;
import cambridge.parser.tokens.TagStringToken;
import cambridge.parser.tokens.Token;
import cambridge.parser.tokens.WSToken;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;


/**
 * The tokenizer reads from an InputStream or Reader and generates
 * tokens that will be consumed by an TemplateParser.
 * <p/>
 * The generated tokens are objects of type Token and every Token
 * has a TokenType.
 *
 * @see cambridge.parser.tokens.Token
 * @see cambridge.parser.tokens.TokenType
 * @see TemplateParser
 */
public class TemplateTokenizer extends Tokenizer {
   public TemplateTokenizer(Reader reader) throws IOException {
      super(reader);
   }

   public TemplateTokenizer(InputStream in) throws IOException {
      super(in);
   }

   void setDirective(String property, String value) {
      if ("consumeScriptTag".equals(property)) {
         consumeScriptTag = "true".equals(value);
      }
   }

   private boolean consumeScriptTag = true;

   enum State {
      INITIAL_STATE,
      TAG, // After <X
      TAG_EXPECTING_ATT_VALUE,
      TAG_EXPECTING_SQ,
      TAG_EXPECTING_DQ
   }

   private String currentTag;

   private State state = State.INITIAL_STATE;

   public Token nextToken() throws IOException {
      int col = getColumn();
      int line = getLineNo();
      char c = nextChar();

      if (c == Tokenizer.EOL) {
         state = State.INITIAL_STATE;
         return new EOFToken(line, col, null, getLineNo(), 0);

         // END OF LINE
      } else if (c == '\r') {
         if (peek(1) == '\n') {
            nextChar();
            return new EOLToken(line, col, "\r\n", getLineNo(), 0);
         }
         return new EOLToken(line, col, "\r", line + 1, 0);
      } else if (c == '\n') {
         return new EOLToken(line, col, "\n", line + 1, 0);

         // WHITE SPACE
      } else if (Character.isWhitespace(c)) {
         StringBuilder builder = new StringBuilder();
         builder.append(c);
         char peek = peek(1);
         while (Character.isWhitespace(peek) && peek != '\r' && peek != '\n') {
            builder.append(nextChar());
            peek = peek(1);
         }

         return new WSToken(line, col, builder.toString(), getLineNo(), getColumn());
      }

      if (state == State.INITIAL_STATE) {
         return initialStateHandler(c, col, line);
      } else if (state == State.TAG) {
         return tagHandler(c, col, line);
      } else if (state == State.TAG_EXPECTING_ATT_VALUE) {
         return expectingAttributeValueHandler(c, col, line);
      } else if (state == State.TAG_EXPECTING_DQ) {
         return expectingDQHandler(c, col, line);
      } else if (state == State.TAG_EXPECTING_SQ) {
         return expectingSQHandler(c, col, line);
      }

      return new StringToken(line, col, "" + c, getLineNo(), getColumn());
   }

   private Token expectingSQHandler(char c, int col, int line) throws IOException {
      if (c == '\'') {
         state = State.TAG;

         AttributeValueToken tok = new AttributeValueToken(line, col, "", getLineNo(), getColumn());
         tok.setQuotes(AttributeValueToken.SINGLE_QUOTES);
         return tok;
      }
      StringBuilder builder = new StringBuilder();

      builder.append(c);
      while (true) {
         c = nextChar();
         if (c == Tokenizer.EOL || c == '\'') break;

         if (c == '\\' && peek(1) == '\'') {
            nextChar();
            builder.append("'");
         } else {
            builder.append(c);
         }
      }

      state = State.TAG;
      AttributeValueToken tok = new AttributeValueToken(line, col, builder.toString(), getLineNo(), getColumn());
      tok.setQuotes(AttributeValueToken.SINGLE_QUOTES);
      return tok;
   }

   private Token expectingDQHandler(char c, int col, int line) throws IOException {
      StringBuilder builder = new StringBuilder();

      if (c == '"') {
         state = State.TAG;
         AttributeValueToken tok = new AttributeValueToken(line, col, "", getLineNo(), getColumn());
         tok.setQuotes(AttributeValueToken.DOUBLE_QUOTES);
         return tok;
      }
//
//      if (c == '$' && peek(1) == '{') {
//         return expressionToken(col, line);
//      }

      builder.append(c);
      while (true) {
         c = nextChar();
         if (c == Tokenizer.EOL || c == '"') break;

         if (c == '\\' && peek(1) == '"') {
            nextChar();
            builder.append("\"");
         } else {
//            if (c == '$' && peek(1) == '{') {
//               return expressionToken(col, line);
//            }
//
//            if (peek(1) == '$' && peek(2) == '{') {
//               builder.append(c);
//               break;
//            }
            builder.append(c);
         }
      }

      state = State.TAG;

      AttributeValueToken tok = new AttributeValueToken(line, col, builder.toString(), getLineNo(), getColumn());
      tok.setQuotes(AttributeValueToken.DOUBLE_QUOTES);
      return tok;
   }

   private Token expectingAttributeValueHandler(char c, int col, int line) throws IOException {
      if (c == '\'') {
         state = State.TAG_EXPECTING_SQ;
         return expectingSQHandler(nextChar(), col, line);
      }
      if (c == '"') {
         state = State.TAG_EXPECTING_DQ;
         return expectingDQHandler(nextChar(), col, line);
      }
      if (c == '$' && peek(1) == '{') {
         return expressionToken(col, line);
      }
      if (c == '>') {
         state = State.INITIAL_STATE;
         return new TagEndToken(line, col, ">", getLineNo(), getColumn());
      }

      StringBuilder builder = new StringBuilder();

      while (true) {
         char peek = peek(1);
         builder.append(c);
         if (Character.isWhitespace(peek) || peek == Tokenizer.EOL || peek == '>' || peek == '=' || peek == '"' || peek == '\'') {
            break;
         }


         //builder.append(peek);
         c = nextChar();
      }

      state = State.TAG;
      AttributeValueToken tok = new AttributeValueToken(line, col, builder.toString(), getLineNo(), getColumn());
      tok.setQuotes(AttributeValueToken.NO_QUOTES);
      return tok;
   }

   private Token expressionToken(int col, int line) throws IOException {
      char c;
      nextChar(); // Consume {
      StringBuilder builder = new StringBuilder();
      c = nextChar();
      while (c != '}') {
         builder.append(c);
         c = nextChar();
      }

      if (peek(1) == '(') {
         nextChar();
         c = nextChar();
         ArrayList<String> filters = new ArrayList<String>();
         StringBuilder filter = new StringBuilder();
         while (c != ')') {
            if (c == '|') {
               if (filter.length() != 0) {
                  filters.add(filter.toString());
               }
               filter.setLength(0);
            } else {
               filter.append(c);
            }
            c = nextChar();
         }

         if (filter.length() != 0 && filters.size() == 0) {
            filters.add(filter.toString());
         }

         return new ExpressionToken(line, col, builder.toString(), getLineNo(), getColumn(), filters);
      }

      return new ExpressionToken(line, col, builder.toString(), getLineNo(), getColumn());
   }

   private Token tagHandler(char c, int col, int line) throws IOException {
      if (c == '/') {
         if (peek(1) == '>') {
            nextChar();
            state = State.INITIAL_STATE;

            currentTag = null;

            return new TagEndToken(line, col, "/>", getLineNo(), getColumn());
         } else {
            return new TagStringToken(line, col, "/", getLineNo(), getColumn());
         }

         // TAG END
      } else if (c == '>') {
         state = State.INITIAL_STATE;
         return new TagEndToken(line, col, ">", getLineNo(), getColumn());
      } else if (c == '$' && peek(1) == '{') {
         return expressionToken(col, line);
      } else if (c == '=') {
         state = State.TAG_EXPECTING_ATT_VALUE;
         return new AssignToken(line, col, "=", getLineNo(), getColumn());
         // ATTRIBUTES -- Somewhere betweeen <X and >
      } else if (CharUtil.isName(c)) {
         // These characters should not be here...

         if (c == '\'') {
            return new TagStringToken(line, col, "'", getLineNo(), getColumn());
         }
         if (c == '"') {
            return new TagStringToken(line, col, "\"", getLineNo(), getColumn());
         }

         StringBuilder builder = new StringBuilder();
         char peek = peek(1);
         builder.append(c);
         while (CharUtil.isNameChar(peek)) {
            builder.append(nextChar());
            peek = peek(1);
         }

         return new AttributeNameToken(line, col, builder.toString(), getLineNo(), getColumn());
      } else {
         StringBuilder builder = new StringBuilder();
         builder.append(c);
         while (!Character.isWhitespace(peek(1)) && peek(1) != '>' && !CharUtil.isName(peek(1))) {
            builder.append(nextChar());
         }


         return new TagStringToken(line, col, builder.toString(), getLineNo(), getColumn());
      }
   }

   private Token initialStateHandler(char c, int col, int line) throws IOException {
      // TAGS, COMMENTS, PARSER DIRECTIVES AND DOCTYPES
      if (c == '<') {
         StringBuilder builder = new StringBuilder();
         // COMMENTS, PARSER DIRECTIVES AND DOCTYPES

         if (peek(1) == '!') {
            builder.append(c);
            c = nextChar();
            if (peek(1) == '-' && peek(2) == '-' && peek(3) == '$') {
               nextChar(2);
               // Comment block
               builder.append("!--");

               String directive = null;
               String args;

               while (true) {
                  if (peek(1) == Tokenizer.EOL) {
                     return new CommentToken(line, col, builder.toString(), getLineNo(), getColumn());
                  }

                  if (directive == null && Character.isWhitespace(peek(1))) {
                     directive = builder.substring(5);
                  }

                  if (peek(1) == '-' && peek(2) == '-' && peek(3) == '>') {
                     args = builder.substring(5 + directive.length() + 1).trim();
                     break;
                  }
                  builder.append(nextChar());
               }
               nextChar(3);

               builder.append("-->");

               ParserDirectiveToken tok = new ParserDirectiveToken(line, col, builder.toString(), getLineNo(), getColumn(), directive, args);
               if (peek(1) == '\r') {
                  if (peek(2) == '\n') {
                     nextChar(2);
                     tok.setTrailingSpace("\r\n");
                  } else {
                     tok.setTrailingSpace("\r");
                     nextChar();
                  }
               } else if (peek(1) == '\n') {
                  tok.setTrailingSpace("\n");
                  nextChar();
               }
               return tok;
            } else if (peek(1) == '-' && peek(2) == '-') {
               nextChar(2);
               // Comment block
               builder.append("!--");

               while (true) {
                  if (peek(1) == Tokenizer.EOL) {
                     return new CommentToken(line, col, builder.toString(), getLineNo(), getColumn());
                  }
                  if (peek(1) == '-' && peek(2) == '-' && peek(3) == '>') break;
                  builder.append(nextChar());
               }
               nextChar(3);
               builder.append("-->");
               return new CommentToken(line, col, builder.toString(), getLineNo(), getColumn());


               // CDATA Blocks
            } else if ("[CDATA[".equals(peekString(7))) {
               c = nextChar(7);
               builder.append("![CDATA");
               while (true) {
                  builder.append(c);
                  if (peek(1) == Tokenizer.EOL) {
                     return new CDATAToken(line, col, builder.toString(), getLineNo(), getColumn());
                  } else {
                     if (peek(1) == ']' && peek(2) == ']' && peek(3) == '>') {
                        builder.append("]]>");
                        break;
                     }
                  }
                  c = nextChar();
               }
               nextChar(3);
               return new CDATAToken(line, col, builder.toString(), getLineNo(), getColumn());

               // DOCTYPE DECLARATIONS
            } else {
               while (c != '>') {
                  builder.append(c);
                  c = nextChar();
               }
               builder.append(c);
               return new DocTypeToken(line, col, builder.toString(), getLineNo(), getColumn());
            }
            // TAG CLOSE </X>
         } else if (peek(1) == '/') {
            builder.append(c);
            c = nextChar();
            String tagName = null;
            while (c != '>') {
               builder.append(c);
               c = nextChar();

               if (tagName == null && (Character.isWhitespace(c) || c == '>')) {
                  tagName = builder.substring(2).toLowerCase();
               }
            }

            builder.append(c);

            state = State.INITIAL_STATE;
            CloseTagToken tok = new CloseTagToken(line, col, builder.toString(), getLineNo(), getColumn());

            tok.setTagName(tagName);

            return tok;
            // OPEN TAG <X
         } else if (CharUtil.isLetter((int) peek(1))) {
            c = nextChar();
            builder.append(c);
            c = peek(1);

            // TAG
            // @todo tum valid karakter range'leri girilmeli
            while (CharUtil.isNameChar((int) c)) {
               builder.append(nextChar());
               c = peek(1);
            }
            currentTag = builder.substring(0).toLowerCase();
            state = State.TAG;
            return new OpenTagToken(line, col, builder.toString(), getLineNo(), getColumn());
         } else {
            builder.append(c);
            return new StringToken(line, col, builder.toString(), getLineNo(), getColumn());
         }
         // Expression
      } else if (c == '$' && peek(1) == '{') {
         return expressionToken(col, line);
      } else {
         StringBuilder builder = new StringBuilder();
         builder.append(c);

         if (consumeScriptTag && "script".equals(currentTag)) {
            while (true) {
               if (peek(1) == Tokenizer.EOL
                  || ("</script".equalsIgnoreCase(peekString(8)))
                  || (peek(1) == '$' && peek(2) == '{')) {
                  break;
               }
               builder.append(nextChar());
            }
         } else {
            while (true) {
               if (peek(1) == Tokenizer.EOL
                  || (peek(1) == '<' && CharUtil.isName(peek(2)))
                  || (peek(1) == '<' && peek(2) == '!')
                  || (peek(1) == '<' && peek(2) == '/' && CharUtil.isName(peek(3)))
                  || (peek(1) == '$' && peek(2) == '{')) {
                  break;
               }
               builder.append(nextChar());
            }
         }

         return new StringToken(line, col, builder.toString(), getLineNo(), getColumn());
      }
   }
}
