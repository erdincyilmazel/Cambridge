package cambridge.runtime;

import cambridge.ExpressionEvaluationException;

/**
 * User: erdinc
 * Date: Oct 31, 2009
 * Time: 5:25:32 PM
 */
public class PropertyAccessException extends ExpressionEvaluationException {
   Object o;
   String property;

   public PropertyAccessException(String message, Object o, String property) {
      super(message);
      this.o = o;
      this.property = property;
   }

   public PropertyAccessException(String message, Throwable cause, Object o, String property) {
      super(message, cause);
      this.o = o;
      this.property = property;
   }

   public PropertyAccessException(Throwable cause, Object o, String property) {
      super(cause);
      this.o = o;
      this.property = property;
   }
}
