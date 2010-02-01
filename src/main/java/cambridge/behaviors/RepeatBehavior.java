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
public class RepeatBehavior extends ExecutingTagBehavior {
   Expression number;

   public RepeatBehavior(Expression number) {
      this.number = number;
   }

   @Override
   public void doExecute(TemplateProperties properties, TagNode tag, Appendable out) throws TemplateEvaluationException, IOException {
      try {
         Iter iter = new Iter();
         int n = number.asInt(properties);
         for (int i = 0; i != n; i++) {
            properties.put("#this", i);
            properties.put("#iter", iter);
            tag.execute(properties, out);
            iter.next();
         }
      } catch (ExpressionEvaluationException e) {
         throw new TemplateEvaluationException("Could not execute the expression: " + e.getMessage(), tag.getBeginLine(), tag.getBeginColumn(), tag.getTagName());
      }
   }

   public static BehaviorProvider<RepeatBehavior> getProvider() {
      return new BehaviorProvider<RepeatBehavior>() {
         @Override
         public RepeatBehavior get(DynamicAttribute keyAttribute, Map<AttributeKey, Attribute> attributes) throws ExpressionParsingException, BehaviorInstantiationException {
            Expression number = keyAttribute.getExpression();
            return new RepeatBehavior(number);
         }
      };
   }
}