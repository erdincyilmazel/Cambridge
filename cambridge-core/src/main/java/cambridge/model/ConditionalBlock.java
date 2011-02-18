package cambridge.model;

import cambridge.ExpressionEvaluationException;
import cambridge.TemplateEvaluationException;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Map;

/**
 * @author Erdinc Yilmazel
 * @since 1/21/11
 */
public class ConditionalBlock implements Fragment {

   private static class Condition {
      final Expression expression;
      final TagNode tag;

      Condition(Expression expression, TagNode tag) {
         this.expression = expression;
         this.tag = tag;
      }
   }

   public TagNode getFirstTag() {
      return firstCondition.tag;
   }

   public TagNode getLastTag() {
      if (defaultCondition != null) {
         return defaultCondition;
      }

      if (alternateConditions != null) {
         return alternateConditions.get(alternateConditions.size() - 1).tag;
      }

      return null;
   }

   Condition firstCondition;
   ArrayList<Condition> alternateConditions;
   TagNode defaultCondition;

   public ConditionalBlock(TagNode firstTag) {
      this.firstCondition = new Condition(firstTag.getConditionalBehavior().getExpression(), firstTag);
      firstTag.removeConditionalBehavior();
   }

   public void addAlternateCondition(TagNode tag) {
      if (alternateConditions == null) {
         alternateConditions = new ArrayList<Condition>();
      }

      alternateConditions.add(new Condition(tag.getConditionalBehavior().getExpression(), tag));
      tag.removeConditionalBehavior();
   }

   public void setDefaultCondition(TagNode tag) {
      defaultCondition = tag;
      tag.removeConditionalBehavior();
   }

   public boolean isComplete() {
      return alternateConditions != null
         || defaultCondition != null;
   }

   public void eval(Map<String, Object> bindings, Writer out) throws IOException, TemplateEvaluationException {
      if (firstCondition == null) {
         return;
      }

      try {
         if (firstCondition.expression.asBoolean(bindings)) {
            firstCondition.tag.eval(bindings, out);
            return;
         }

         if (alternateConditions == null && defaultCondition == null) {
            return;
         }

         if (alternateConditions != null) {
            for (Condition c : alternateConditions) {
               if (c.expression.asBoolean(bindings)) {
                  c.tag.eval(bindings, out);
                  return;
               }
            }
         }

         if (defaultCondition != null) {
            defaultCondition.eval(bindings, out);
         }
      } catch (ExpressionEvaluationException e) {
         e.printStackTrace();
      }
   }

   public void pack() {
      firstCondition.tag.pack();
      if (alternateConditions != null) {
         for (Condition c : alternateConditions) {
            c.tag.pack();
         }
      }

      if (defaultCondition != null) {
         defaultCondition.pack();
      }
   }
}
