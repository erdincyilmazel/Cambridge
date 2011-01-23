package cambridge.runtime;

import cambridge.ExpressionEvaluationException;
import cambridge.parser.expressions.Expression;

import java.util.Map;

/**
 * User: erdincyilmazel
 * Date: 1/7/11
 * Time: 12:41 AM
 */
public class IfFunction extends FunctionRunner {
   @Override
   public Object eval(Map<String, Object> p, Expression[] params) throws ExpressionEvaluationException {
      if(params.length != 3) {
         throw new ExpressionEvaluationException("Invalid number of arguments for if statement");
      }

      return params[0].asBoolean(p) ? params[1].eval(p) : params[2].eval(p);
   }
}
