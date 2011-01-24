package cambridge.behaviors;

import cambridge.AttributeKey;
import cambridge.BehaviorInstantiationException;
import cambridge.BehaviorProvider;
import cambridge.ExpressionEvaluationException;
import cambridge.ExpressionParsingException;
import cambridge.LoopingTagBehavior;
import cambridge.TemplateEvaluationException;
import cambridge.model.Attribute;
import cambridge.model.DynamicAttribute;
import cambridge.model.TagNode;
import cambridge.parser.expressions.Expression;
import cambridge.runtime.Iter;

import java.io.IOException;
import java.util.Map;

/**
 * User: erdinc
 * Date: Nov 1, 2009
 * Time: 3:57:11 PM
 */
public class FromBehavior extends LoopingTagBehavior {
   private final Expression from;
   private final Expression to;

   public FromBehavior(Expression from, Expression to) {
      this.from = from;
      this.to = to;
   }

   @Override
   public void doExecute(Map<String, Object> bindings, TagNode tag, Appendable out) throws TemplateEvaluationException, IOException {
      try {
         Iter iter = new Iter();
         for (int i = from.asInt(bindings); i <= to.asInt(bindings); i++) {
            bindings.put("#this", i);
            bindings.put("#iter", iter);
            tag.execute(bindings, out);
            iter.next();
         }
      } catch (ExpressionEvaluationException e) {
         throw new TemplateEvaluationException("Could not execute the expression: " + e.getMessage(), tag.getBeginLine(), tag.getBeginColumn(), tag.getTagName());
      }
   }

   public static BehaviorProvider<FromBehavior> getProvider() {
      return new BehaviorProvider<FromBehavior>() {
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
