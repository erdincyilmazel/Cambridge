package cambridge.parser.expressions;

import cambridge.ExpressionEvaluationException;
import cambridge.runtime.ExpressionContext;


/**
 * @author Erdinc Yilmazel
 * Date: Nov 9, 2009
 * Time: 11:53:59 PM
 */
public abstract class FunctionRunner {
   public abstract Object eval(ExpressionContext context, CambridgeExpression[] params) throws ExpressionEvaluationException;
}
