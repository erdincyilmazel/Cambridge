package cambridge.behaviors;

import cambridge.BehaviorInstantiationException;
import cambridge.BehaviorProvider;
import cambridge.ExpressionEvaluationException;
import cambridge.ExpressionParsingException;
import cambridge.Expressions;
import cambridge.LoopingTagBehavior;
import cambridge.TemplateEvaluationException;
import cambridge.model.Attribute;
import cambridge.model.AttributeKey;
import cambridge.model.DynamicAttribute;
import cambridge.model.Expression;
import cambridge.model.TagNode;
import cambridge.runtime.Iter;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;


/**
 * User: erdinc
 * Date: Nov 1, 2009
 * Time: 2:36:22 PM
 */
public class WhileBehavior extends LoopingTagBehavior {
   private final Expression expression;

   public WhileBehavior(Expression expression) {
      this.expression = expression;
   }

   @Override
   public void doExecute(Map<String, Object> bindings, TagNode tag, Writer out) throws TemplateEvaluationException, IOException {
      try {
         Iter iter = new Iter();
         while (expression.asBoolean(bindings)) {
            bindings.put(Expressions.ITER_OBJECT, iter);
            tag.execute(bindings, out);
            iter.next();
         }
      } catch (ExpressionEvaluationException e) {
         throw new TemplateEvaluationException("Could not execute the expression: " + e.getMessage(), tag.getBeginLine(), tag.getBeginColumn(), tag.getTagName());
      }
   }

   public static BehaviorProvider<WhileBehavior> getProvider() {
      return new BehaviorProvider<WhileBehavior>() {
         public WhileBehavior get(DynamicAttribute keyAttribute, Map<AttributeKey, Attribute> attributes) throws ExpressionParsingException, BehaviorInstantiationException {
            return new WhileBehavior(keyAttribute.getExpression());
         }
      };
   }
}
