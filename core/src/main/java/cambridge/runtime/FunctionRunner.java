package cambridge.runtime;

import cambridge.ExpressionEvaluationException;
import cambridge.parser.expressions.Expression;

import java.util.HashMap;

/**
 * User: erdinc
 * Date: Nov 9, 2009
 * Time: 11:53:59 PM
 */
public abstract class FunctionRunner {
   public abstract Object eval(TemplateBindings p, Expression[] params) throws ExpressionEvaluationException;
}
