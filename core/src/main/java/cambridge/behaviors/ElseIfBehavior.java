package cambridge.behaviors;

import cambridge.BehaviorProvider;
import cambridge.ConditionalTagBehavior;
import cambridge.ExpressionParsingException;
import cambridge.model.Attribute;
import cambridge.model.AttributeKey;
import cambridge.model.DynamicAttribute;
import cambridge.parser.expressions.Expression;

import java.util.Map;

/**
 * User: erdinc
 * Date: Jan 22 2011
 * Time: 01:20:01 PM
 */
public class ElseIfBehavior extends ConditionalTagBehavior {
   public ElseIfBehavior(Expression e) {
      super(e);
   }

   @Override
   public ConditionType getType() {
      return ConditionType.ALTERNATE;
   }

   @Override
   public String getValidationError() {
      return "Elseif behaviour without if";
   }

   public static BehaviorProvider<ElseIfBehavior> getProvider() {
      return new BehaviorProvider<ElseIfBehavior>() {
         public ElseIfBehavior get(DynamicAttribute keyAttribute, Map<AttributeKey, Attribute> attributes) throws ExpressionParsingException {
            return new ElseIfBehavior(keyAttribute.getExpression());
         }
      };
   }
}