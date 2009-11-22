package cambridge.behaviors;

import cambridge.*;
import cambridge.model.Attribute;
import cambridge.model.DynamicAttribute;
import cambridge.model.TagNode;
import cambridge.parser.expressions.Expression;
import cambridge.runtime.Iter;
import cambridge.runtime.TemplateProperties;

import java.io.IOException;
import java.util.Map;

/**
 * User: erdinc
 * Date: Nov 1, 2009
 * Time: 3:57:11 PM
 */
public class FromBehavior extends ExecutingTagBehavior {
   Expression from;
   Expression to;

   public FromBehavior(Expression from, Expression to) {
      this.from = from;
      this.to = to;
   }

   @Override
   public void doExecute(TemplateProperties properties, TagNode tag, Appendable out) throws TemplateRuntimeException, IOException {
      try {
         Iter iter = new Iter();
         for (int i = from.asInt(properties); i <= to.asInt(properties); i++) {
            properties.put("#this", i);
            properties.put("#iter", iter);
            tag.execute(properties, out);
            iter.next();
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
