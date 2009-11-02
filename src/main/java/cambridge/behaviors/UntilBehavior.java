package cambridge.behaviors;

import cambridge.*;
import cambridge.parser.expressions.Expression;
import cambridge.parser.model.Attribute;
import cambridge.parser.model.DynamicAttribute;
import cambridge.parser.model.Tag;
import org.antlr.runtime.RecognitionException;

import java.io.IOException;
import java.util.Map;


/**
 * User: erdinc
 * Date: Nov 1, 2009
 * Time: 2:36:22 PM
 */
public class UntilBehavior extends IterativeTagBehavior {
   Expression expression;

   public UntilBehavior(Expression expression) {
      this.expression = expression;
   }

   @Override
   public void iterate(Map<String, Object> properties, Tag tag, Appendable out) throws ExpressionEvaluationException, IOException {
      do {
         tag.dumpTag(properties, out);
      } while (!expression.asBoolean(properties));
   }

   public static BehaviorProvider<UntilBehavior> getProvider() {
      return new BehaviorProvider<UntilBehavior>() {
         @Override
         public UntilBehavior get(DynamicAttribute keyAttribute, Map<AttributeKey, Attribute> attributes) throws RecognitionException, BehaviorInstantiationException {
            return new UntilBehavior(keyAttribute.getExpression());
         }
      };
   }
}