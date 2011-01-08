package cambridge.behaviors;

import cambridge.*;
import cambridge.runtime.TemplateBindings;
import cambridge.parser.expressions.Expression;
import cambridge.model.Attribute;
import cambridge.model.DynamicAttribute;

import java.util.Map;

/**
 * User: erdinc
 * Date: Oct 31, 2009
 * Time: 10:27:01 AM
 */
public class IfBehavior extends ConditionalTagBehavior {
   private final Expression expression;

   public IfBehavior(Expression e) {
      expression = e;
   }

   @Override
   public boolean conditionMet(TemplateBindings bindings) throws ExpressionEvaluationException {
      return expression.asBoolean(bindings);
   }

   public static BehaviorProvider<IfBehavior> getProvider() {
      return new BehaviorProvider<IfBehavior>() {
         public IfBehavior get(DynamicAttribute keyAttribute, Map<AttributeKey, Attribute> attributes) throws ExpressionParsingException {
            return new IfBehavior(keyAttribute.getExpression());
         }
      };
   }
}