package cambridge.behaviors;

import cambridge.*;
import cambridge.runtime.Super;
import cambridge.parser.expressions.Expression;
import cambridge.parser.model.Attribute;
import cambridge.parser.model.DynamicAttribute;
import cambridge.parser.model.Tag;
import org.antlr.runtime.RecognitionException;

import java.io.IOException;
import java.util.Map;

/**
 * User: erdinc
 * Date: Oct 31, 2009
 * Time: 7:18:33 PM
 */
public class ForeachBehavior extends IterativeTagBehavior {
   Expression iterable;

   public ForeachBehavior(Expression iterable) {
      this.iterable = iterable;
   }

   @Override
   public void next(Map<String, Object> properties, Tag tag, Appendable out) throws ExpressionEvaluationException, IOException {
      Object o = iterable.eval(properties);
      if (!(o instanceof Iterable)) {
         throw new ExpressionEvaluationException("Not iterable");
      }

      for (Object o1 : ((Iterable) o)) {
         properties.put("this", o1);
         tag.dumpTag(properties, out);
      }
   }

   public static BehaviorProvider<ForeachBehavior> getProvider() {
      return new BehaviorProvider<ForeachBehavior>() {
         @Override
         public ForeachBehavior get(DynamicAttribute keyAttribute, Map<AttributeKey, Attribute> attributes) throws RecognitionException, BehaviorInstantiationException {
            Expression e = keyAttribute.getExpression();
//
//            AttributeKey asKey = new AttributeKey(keyAttribute.getAttributeNameSpace(), "as");
//            Attribute as = attributes.get(asKey);
//            if (as == null) {
//               throw new BehaviorInstantiationException("Required attribute as is not found");
//            }

            return new ForeachBehavior(e);
         }
      };
   }
}