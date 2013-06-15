package cambridge.parser.expressions;

import cambridge.ExpressionEvaluationException;
import cambridge.runtime.ExpressionContext;

/**
 * @author Erdinc Yilmazelyilmazel
 * Date: 1/7/11
 * Time: 12:41 AM
 */
public class IfFunction extends FunctionRunner {
   @Override
   public Object eval(ExpressionContext context, CambridgeExpression[] params) throws ExpressionEvaluationException {
      if (params.length != 3) {
         throw new ExpressionEvaluationException("Invalid number of arguments for if statement");
      }

      return params[0].asBoolean(context) ? params[1].eval(context) : params[2].eval(context);
   }
}
