package cambridge.behaviors;

import cambridge.*;
import cambridge.parser.expressions.Expression;
import cambridge.parser.model.Attribute;
import cambridge.parser.model.DynamicAttribute;
import cambridge.parser.model.Tag;

import java.io.IOException;
import java.util.Map;

/**
 * User: erdinc
 * Date: Nov 1, 2009
 * Time: 3:57:11 PM
 */
public class FromBehavior extends IterativeTagBehavior {
   Expression from;
   Expression to;

   public FromBehavior(Expression from, Expression to) {
      this.from = from;
      this.to = to;
   }

   @Override
   public void next(Map<String, Object> properties, Tag tag, Appendable out) throws TemplateRuntimeException, IOException {
      try {
         for (int i = from.asInt(properties); i <= to.asInt(properties); i++) {
            properties.put("this", i);
            tag.dumpTag(properties, out);
         }
      } catch (ExpressionEvaluationException e) {
         throw new TemplateRuntimeException("Could not execute the expression: " + e.getMessage(), tag.getBeginLine(), tag.getBeginColumn(), tag.getTagName());
      }
   }

   public static BehaviorProvider<FromBehavior> getProvider() {
      return new BehaviorProvider<FromBehavior>() {
         @Override
         public FromBehavior get(DynamicAttribute keyAttribute, Map<AttributeKey, Attribute> attributes) throws ExpressionParsingException, BehaviorInstantiationException {
            Expression from = keyAttribute.getExpression();
            AttributeKey toKey = new AttributeKey(keyAttribute.getAttributeNameSpace(), "to");

            Attribute toAttribute = attributes.get(toKey);

            if (toAttribute == null || !(toAttribute instanceof DynamicAttribute)) {
               throw new BehaviorInstantiationException("Required parameters to is not set");
            }

            Expression to = ((DynamicAttribute) toAttribute).getExpression();

            return new FromBehavior(from, to);
         }
      };
   }
}
