package cambridge.behaviors;

import cambridge.*;
import cambridge.model.Attribute;
import cambridge.model.DynamicAttribute;
import cambridge.model.TagNode;
import cambridge.parser.expressions.Expression;

import java.io.IOException;
import java.util.Map;


/**
 * User: erdinc
 * Date: Nov 1, 2009
 * Time: 2:36:22 PM
 */
public class WhileBehavior extends IterativeTagBehavior {
   Expression expression;

   public WhileBehavior(Expression expression) {
      this.expression = expression;
   }

   @Override
   public void loop(Map<String, Object> properties, TagNode tag, Appendable out) throws TemplateRuntimeException, IOException {
      try {
         while (expression.asBoolean(properties)) {
            tag.executeTag(properties, out);
         }
      } catch (ExpressionEvaluationException e) {
         throw new TemplateRuntimeException("Could not execute the expression: " + e.getMessage(), tag.getBeginLine(), tag.getBeginColumn(), tag.getTagName());
      }
   }

   public static BehaviorProvider<WhileBehavior> getProvider() {
      return new BehaviorProvider<WhileBehavior>() {
         @Override
         public WhileBehavior get(DynamicAttribute keyAttribute, Map<AttributeKey, Attribute> attributes) throws ExpressionParsingException, BehaviorInstantiationException {
            return new WhileBehavior(keyAttribute.getExpression());
         }
      };
   }
}
