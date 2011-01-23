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
public class ElseBehavior extends ConditionalTagBehavior {
   @Override
   public ConditionType getType() {
      return ConditionType.DEFAULT;
   }

   public static BehaviorProvider<ElseBehavior> getProvider() {
      return new BehaviorProvider<ElseBehavior>() {
         public ElseBehavior get(DynamicAttribute keyAttribute, Map<AttributeKey, Attribute> attributes) throws ExpressionParsingException {
            return new ElseBehavior();
         }
      };
   }
}