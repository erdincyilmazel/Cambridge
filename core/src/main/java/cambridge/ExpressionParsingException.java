package cambridge;

import org.antlr.runtime.RecognitionException;

import java.util.List;

/**
 * User: erdinc
 * Date: Nov 2, 2009
 * Time: 6:44:14 PM
 */
public class ExpressionParsingException extends RuntimeException {
   List<RecognitionException> errors;
   String expression;

   public ExpressionParsingException(String expression, Throwable cause) {
      super("Error parsing expression: " + expression, cause);
      this.expression = expression;
   }

   public ExpressionParsingException(String expression, List<RecognitionException> errors) {
      super("Error parsing expression: " + expression, errors.get(errors.size() - 1));
      this.errors = errors;
      this.expression = expression;
   }

   public List<RecognitionException> getErrors() {
      return errors;
   }

   public String getExpression() {
      return expression;
   }
}
