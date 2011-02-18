package cambridge.behaviors;

import cambridge.BehaviorProvider;
import cambridge.ConditionalTagBehavior;
import cambridge.ExpressionParsingException;
import cambridge.model.Attribute;
import cambridge.model.AttributeKey;
import cambridge.model.DynamicAttribute;
import cambridge.model.Expression;

import java.util.Map;

/**
 * User: erdinc
 * Date: Oct 31, 2009
 * Time: 10:27:01 AM
 */
public class IfBehavior extends ConditionalTagBehavior {
   public IfBehavior(Expression e) {
      super(e);
   }

   @Override
   public ConditionType getType() {
      return ConditionalTagBehavior.ConditionType.FIRST;
   }

   @Override
   public String getValidationError() {
      return "";
   }

   public static BehaviorProvider<IfBehavior> getProvider() {
      return new BehaviorProvider<IfBehavior>() {
         public IfBehavior get(DynamicAttribute keyAttribute, Map<AttributeKey, Attribute> attributes) throws ExpressionParsingException {
            return new IfBehavior(keyAttribute.getExpression());
         }
      };
   }
}