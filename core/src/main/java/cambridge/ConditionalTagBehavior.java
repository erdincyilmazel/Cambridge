package cambridge;

import cambridge.parser.expressions.Expression;
import cambridge.runtime.TemplateBindings;

/**
 * User: erdinc
 * Date: Oct 31, 2009
 * Time: 7:10:31 PM
 */
public abstract class ConditionalTagBehavior implements TagBehavior {
   public enum ConditionType {
      FIRST,
      ALTERNATE,
      DEFAULT
   }

   final Expression expression;

   public ConditionalTagBehavior(Expression e) {
      expression = e;
   }

   public ConditionalTagBehavior() {
      expression = null;
   }

   public boolean conditionMet(TemplateBindings bindings) throws ExpressionEvaluationException {
      return expression == null || expression.asBoolean(bindings);
   }

   public abstract ConditionType getType();

   public Expression getExpression() {
      return expression;
   }
}
