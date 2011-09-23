package cambridge.behaviors;

import cambridge.BehaviorProvider;
import cambridge.ExpressionParsingException;
import cambridge.model.Attribute;
import cambridge.model.AttributeKey;
import cambridge.model.DynamicAttribute;
import cambridge.model.Expression;

import java.util.Map;

/**
 * @author Erdinc Yilmazel
 * Date: Oct 31, 2009
 * Time: 10:27:01 AM
 */
public class IfBehavior extends ConditionalTagBehavior {
   public IfBehavior(Expression e, int line, int col) {
      super(e, line, col);
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
         public IfBehavior get(DynamicAttribute keyAttribute, Map<AttributeKey, Attribute> attributes, int line, int col) throws ExpressionParsingException {
            return new IfBehavior(keyAttribute.getExpression(), line, col);
         }
      };
   }
}