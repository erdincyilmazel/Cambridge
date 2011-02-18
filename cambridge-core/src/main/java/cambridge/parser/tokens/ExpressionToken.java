package cambridge.parser.tokens;

import java.util.ArrayList;

/**
 * Cambridge expressions are returned as ExpressionToken objects from the tokenizer
 */
public class ExpressionToken extends Token {
   public ExpressionToken(int line, int c, String val, int nl, int nc, boolean raw) {
      super(line, c, val, nl, nc);
      this.rawExpression = raw;
   }

   public ExpressionToken(int line, int c, String val, int nl, int nc, boolean raw, ArrayList<String> filters) {
      super(line, c, val, nl, nc);
      this.filters = filters;
      this.rawExpression = true;
   }

   boolean rawExpression;

   private ArrayList<String> filters;

   public ArrayList<String> getFilters() {
      return filters;
   }

   public TokenType getType() {
      return TokenType.EXPRESSION;
   }

   public boolean isRawExpression() {
      return rawExpression;
   }

   @Override
   public String getFormattedString() {
      if (filters == null) {
         return (rawExpression ? "%{" : "${") + value + "}";
      } else {
         StringBuilder builder = new StringBuilder();
         builder.append((rawExpression ? "%{" : "${")).append(value).append("}").append("(");
         for (int i = 0; i < filters.size(); i++) {
            String s = filters.get(i);
            if (i != 0) {
               builder.append("|");
            }

            builder.append(s);
         }

         builder.append(")");
         return builder.toString();
      }
   }

   @Override
   public String getActualValue() {
      return getFormattedString();
   }
}
