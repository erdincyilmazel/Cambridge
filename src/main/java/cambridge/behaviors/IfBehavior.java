package cambridge.behaviors;

import cambridge.AttributeKey;
import cambridge.BehaviorProvider;
import cambridge.ConditionalTagBehavior;
import cambridge.ExpressionEvaluationException;
import cambridge.parser.expressions.Expression;
import cambridge.parser.model.Attribute;
import cambridge.parser.model.DynamicAttribute;
import org.antlr.runtime.RecognitionException;

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
   public boolean conditionMet(Map<String, Object> properties) throws ExpressionEvaluationException {
      return expression.asBoolean(properties);
   }

   public static BehaviorProvider<IfBehavior> getProvider() {
      return new BehaviorProvider<IfBehavior>() {
         @Override
         public IfBehavior get(DynamicAttribute keyAttribute, Map<AttributeKey, Attribute> attributes) throws RecognitionException {
            return new IfBehavior(keyAttribute.getExpression());
         }
      };
   }
}