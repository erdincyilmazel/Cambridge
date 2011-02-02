package cambridge;

/**
 * User: erdinc
 * Date: Nov 2, 2009
 * Time: 6:44:14 PM
 */
public class ExpressionParsingException extends RuntimeException {
   String expression;

   public ExpressionParsingException(String expression, Throwable cause) {
      super("Error parsing expression: " + expression, cause);
      this.expression = expression;
   }

   public ExpressionParsingException(String expression) {
      super("Error parsing expression: " + expression);
   }

   public String getExpression() {
      return expression;
   }
}
