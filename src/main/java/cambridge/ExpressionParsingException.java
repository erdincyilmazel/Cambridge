package cambridge;

import org.antlr.runtime.RecognitionException;

import java.util.List;

/**
 * User: erdinc
 * Date: Nov 2, 2009
 * Time: 6:44:14 PM
 */
public class ExpressionParsingException extends Exception {
   List<RecognitionException> errors;

   public ExpressionParsingException(Throwable cause) {
      super(cause);
   }

   public ExpressionParsingException(List<RecognitionException> errors) {
      super(errors.get(errors.size() - 1));
      this.errors = errors;
   }
}
