package cambridge;

/**
 * This exception gets thrown during template parsing if there is a problem with an expression
 * syntax. This exception generally gets wrapped in a {@link TemplateParsingException}
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
