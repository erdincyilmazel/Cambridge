package cambridge;

import cambridge.model.Expression;

import java.util.Map;

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

   public boolean conditionMet(Map<String, Object> bindings) throws ExpressionEvaluationException {
      return expression == null || expression.asBoolean(bindings);
   }

   public abstract ConditionType getType();

   public abstract String getValidationError();

   public Expression getExpression() {
      return expression;
   }
}
