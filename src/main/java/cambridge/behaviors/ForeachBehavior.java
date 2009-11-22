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
 * Date: Oct 31, 2009
 * Time: 7:18:33 PM
 */
public class ForeachBehavior extends ExecutingTagBehavior {
   Expression iterable;

   public ForeachBehavior(Expression iterable) {
      this.iterable = iterable;
   }

   @Override
   public void doExecute(TemplateProperties properties, TagNode tag, Appendable out) throws TemplateRuntimeException, IOException {
      try {
         Object o = iterable.eval(properties);
         if (o == null) {
            return;
            //throw new TemplateRuntimeException("The provided expression value for foreach attribute is null", tag.getBeginLine(), tag.getBeginColumn(), tag.getTagName());
         }

         if (!(o instanceof Iterable)) {
            throw new TemplateRuntimeException("The provided expression value of class " + o.getClass().getName() + " for foreach attribute is not iterable", tag.getBeginLine(), tag.getBeginColumn());
         }

         Iter iter = new Iter();
         for (Object o1 : ((Iterable) o)) {
            properties.put("#this", o1);
            properties.put("#iter", iter);
            tag.execute(properties, out);
            iter.next();
         }
      } catch (ExpressionEvaluationException e) {
         throw new TemplateRuntimeException("Could not execute the expression: " + e.getMessage(), tag.getBeginLine(), tag.getBeginColumn(), tag.getTagName());
      }
   }

   public static BehaviorProvider<ForeachBehavior> getProvider() {
      return new BehaviorProvider<ForeachBehavior>() {
         @Override
         public ForeachBehavior get(DynamicAttribute keyAttribute, Map<AttributeKey, Attribute> attributes) throws ExpressionParsingException, BehaviorInstantiationException {
            Expression e = keyAttribute.getExpression();
            return new ForeachBehavior(e);
         }
      };
   }
}