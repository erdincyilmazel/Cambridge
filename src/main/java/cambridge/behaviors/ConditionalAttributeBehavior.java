package cambridge.behaviors;

import cambridge.*;
import cambridge.parser.expressions.Expression;
import cambridge.model.ModifyableTag;
import cambridge.model.DynamicAttribute;
import cambridge.model.Attribute;
import cambridge.model.TagPart;
import cambridge.runtime.TemplateProperties;

import java.util.Map;

/**
 * User: erdinc
 * Date: Nov 1, 2009
 * Time: 3:04:10 PM
 */
public class ConditionalAttributeBehavior implements ModifyingTagBehavior {
   Expression expression;
   DynamicAttribute attribute;

   public ConditionalAttributeBehavior(Expression expression, DynamicAttribute attribute) {
      this.expression = expression;
      this.attribute = attribute;
   }

   @Override
   public void modify(TemplateProperties properties, ModifyableTag tag) throws ExpressionEvaluationException {
      if(!expression.asBoolean(properties)) {
         int remove = -1;
         boolean next = false;
         for (int i = 0; i < tag.getTagParts().size(); i++) {
            TagPart t = tag.getTagParts().get(i);
            if (t == attribute) {
               next = true;
            } else {
               if (next) {
                  if (t instanceof Attribute) {
                     Attribute a = (Attribute) t;
                     if (!a.isDynamic()) {
                        remove = i;
                     }
                  }
               }
            }
         }

         if(remove != -1) {
            tag.getTagParts().remove(remove);
         }
      }
   }

   public static BehaviorProvider<ConditionalAttributeBehavior> getProvider() {
      return new BehaviorProvider<ConditionalAttributeBehavior>() {
         @Override
         public ConditionalAttributeBehavior get(DynamicAttribute keyAttribute, Map<AttributeKey, Attribute> attributes) throws ExpressionParsingException, BehaviorInstantiationException {
            return new ConditionalAttributeBehavior(keyAttribute.getExpression(), keyAttribute);
         }
      };
   }
}
