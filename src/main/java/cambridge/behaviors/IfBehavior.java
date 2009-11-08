package cambridge.behaviors;

import cambridge.*;
import cambridge.runtime.TemplateProperties;
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
   Expression expression;

   public IfBehavior(Expression e) {
      expression = e;
   }

   @Override
   public boolean conditionMet(TemplateProperties properties) throws ExpressionEvaluationException {
      return expression.asBoolean(properties);
   }

   public static BehaviorProvider<IfBehavior> getProvider() {
      return new BehaviorProvider<IfBehavior>() {
         @Override
         public IfBehavior get(DynamicAttribute keyAttribute, Map<AttributeKey, Attribute> attributes) throws ExpressionParsingException {
            return new IfBehavior(keyAttribute.getExpression());
         }
      };
   }
}