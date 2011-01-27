package cambridge.behaviors;

import cambridge.BehaviorInstantiationException;
import cambridge.BehaviorProvider;
import cambridge.ExpressionEvaluationException;
import cambridge.ExpressionParsingException;
import cambridge.LoopingTagBehavior;
import cambridge.TemplateEvaluationException;
import cambridge.model.Attribute;
import cambridge.model.AttributeKey;
import cambridge.model.DynamicAttribute;
import cambridge.model.TagNode;
import cambridge.parser.expressions.Expression;

import java.io.IOException;
import java.util.Map;

/**
 * @author Erdinc Yilmazel
 * @since 1/25/11
 */
public class WithBehavior extends LoopingTagBehavior {
   private final Expression expression;

   public WithBehavior(Expression expression) {
      this.expression = expression;
   }

   @Override
   protected void doExecute(Map<String, Object> bindings, TagNode tag, Appendable out) throws TemplateEvaluationException, IOException {
      try {
         bindings.put("#this", expression.eval(bindings));
         tag.execute(bindings, out);
      } catch (ExpressionEvaluationException e) {
         throw new TemplateEvaluationException("Could not execute the expression: " + e.getMessage(), tag.getBeginLine(), tag.getBeginColumn(), tag.getTagName());
      }
   }


   public static BehaviorProvider<WithBehavior> getProvider() {
      return new BehaviorProvider<WithBehavior>() {
         public WithBehavior get(DynamicAttribute keyAttribute, Map<AttributeKey, Attribute> attributes) throws ExpressionParsingException, BehaviorInstantiationException {
            return new WithBehavior(keyAttribute.getExpression());
         }
      };
   }
}
