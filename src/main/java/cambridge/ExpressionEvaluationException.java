package cambridge;

/**
 * User: erdinc
 * Date: Oct 31, 2009
 * Time: 5:31:31 PM
 */
public class ExpressionEvaluationException extends Exception {
   public ExpressionEvaluationException() {
   }

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
