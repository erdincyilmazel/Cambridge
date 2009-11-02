package cambridge.behaviors;

import cambridge.*;
import cambridge.parser.model.Tag;
import cambridge.parser.model.DynamicAttribute;
import cambridge.parser.model.Attribute;
import cambridge.parser.expressions.Expression;
import java.util.Map;
import java.io.IOException;

import org.antlr.runtime.RecognitionException;

/**
 * User: erdinc
 * Date: Nov 1, 2009
 * Time: 3:57:11 PM
 */
public class FromBehavior extends IterativeTagBehavior {
   Expression from;
   Expression to;
   String as;

   public FromBehavior(Expression from, Expression to, String as) {
      this.from = from;
      this.to = to;
      this.as = as;
   }

   @Override
   public void iterate(Map<String, Object> properties, Tag tag, Appendable out) throws ExpressionEvaluationException, IOException {
      for(int i = from.asInt(properties); i <= to.asInt(properties); i++) {
         properties.put(as, i);
         tag.dumpTag(properties, out);
      }
   }

   public static BehaviorProvider<FromBehavior> getProvider() {
      return new BehaviorProvider<FromBehavior>() {
         @Override
         public FromBehavior get(DynamicAttribute keyAttribute, Map<AttributeKey, Attribute> attributes) throws RecognitionException, BehaviorInstantiationException {
            Expression from = keyAttribute.getExpression();
            AttributeKey toKey = new AttributeKey(keyAttribute.getAttributeNameSpace(), "to");
            AttributeKey asKey = new AttributeKey(keyAttribute.getAttributeNameSpace(), "as");

            Attribute toAttribute = attributes.get(toKey);
            Attribute asAttribute = attributes.get(asKey);

            if(toAttribute == null || asAttribute == null || !(toAttribute instanceof DynamicAttribute)) {
               throw new BehaviorInstantiationException("Required parameters to and as should be set");
            }

            Expression to = ((DynamicAttribute) toAttribute).getExpression();

            return new FromBehavior(from, to, asAttribute.getValue());
         }
      };
   }
}
