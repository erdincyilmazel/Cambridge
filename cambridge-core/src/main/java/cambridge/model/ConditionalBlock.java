package cambridge.model;

import cambridge.ExpressionEvaluationException;
import cambridge.TemplateEvaluationException;
import cambridge.runtime.ExpressionContext;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

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

   public void eval(ExpressionContext context, Writer out) throws IOException, TemplateEvaluationException {
      if (firstCondition == null) {
         return;
      }

      try {
         if (firstCondition.expression.asBoolean(context)) {
            firstCondition.tag.eval(context, out);
            return;
         }

         if (alternateConditions == null && defaultCondition == null) {
            return;
         }

         if (alternateConditions != null) {
            for (Condition c : alternateConditions) {
               if (c.expression.asBoolean(context)) {
                  c.tag.eval(context, out);
                  return;
               }
            }
         }

         if (defaultCondition != null) {
            defaultCondition.eval(context, out);
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
