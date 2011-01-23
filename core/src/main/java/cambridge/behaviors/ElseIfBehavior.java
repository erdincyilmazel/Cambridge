package cambridge.behaviors;

import cambridge.AttributeKey;
import cambridge.BehaviorProvider;
import cambridge.ConditionalTagBehavior;
import cambridge.ExpressionEvaluationException;
import cambridge.ExpressionParsingException;
import cambridge.model.Attribute;
import cambridge.model.DynamicAttribute;
import cambridge.parser.expressions.Expression;
import cambridge.runtime.TemplateBindings;

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

   public static BehaviorProvider<ElseIfBehavior> getProvider() {
      return new BehaviorProvider<ElseIfBehavior>() {
         public ElseIfBehavior get(DynamicAttribute keyAttribute, Map<AttributeKey, Attribute> attributes) throws ExpressionParsingException {
            return new ElseIfBehavior(keyAttribute.getExpression());
         }
      };
   }
}