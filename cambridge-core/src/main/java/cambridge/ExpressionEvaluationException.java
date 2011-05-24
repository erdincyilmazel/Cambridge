package cambridge;

/**
 * This exception gets thrown if there is a problem evaluating an expression.
 */
public class ExpressionEvaluationException extends Exception {
   public ExpressionEvaluationException(String message) {
      super(message);
   }

   public ExpressionEvaluationException(String message, Throwable cause) {
      super(message, cause);
   }

   public ExpressionEvaluationException(Throwable cause) {
      super(cause);
   }
}
