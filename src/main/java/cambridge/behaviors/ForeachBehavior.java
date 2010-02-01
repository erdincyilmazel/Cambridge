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
   public void doExecute(TemplateProperties properties, TagNode tag, Appendable out) throws TemplateEvaluationException, IOException {
      try {
         Object o = iterable.eval(properties);
         if (o == null) {
            return;
            //throw new TemplateEvaluationException("The provided expression value for foreach attribute is null", tag.getBeginLine(), tag.getBeginColumn(), tag.getTagName());
         }

         if (o instanceof Object[]) {
            iterateArray(properties, tag, out, (Object[]) o);
         } else if (o instanceof Iterable) {
            iterateIterable(properties, tag, out, (Iterable) o);
         } else if (o instanceof int[]) {
            iterateInt(properties, tag, out, (int[]) o);
         } else if (o instanceof float[]) {
            iterateFloat(properties, tag, out, (float[]) o);
         } else if (o instanceof double[]) {
            iterateDouble(properties, tag, out, (double[]) o);
         } else if (o instanceof byte[]) {
            iterateByte(properties, tag, out, (byte[]) o);
         } else if (o instanceof char[]) {
            iterateChar(properties, tag, out, (char[]) o);
         } else if (o instanceof boolean[]) {
            iterateBoolean(properties, tag, out, (boolean[]) o);
         } else {
            throw new TemplateEvaluationException("The provided expression value of class " + o.getClass().getName() + " for foreach attribute is not iterable", tag.getBeginLine(), tag.getBeginColumn());
         }

      } catch (ExpressionEvaluationException e) {
         throw new TemplateEvaluationException("Could not execute the expression: " + e.getMessage(), tag.getBeginLine(), tag.getBeginColumn(), tag.getTagName());
      }
   }

   private void iterateIterable(TemplateProperties properties, TagNode tag, Appendable out, Iterable o) throws IOException, TemplateEvaluationException {
      Iter iter = new Iter();
      for (Object o1 : o) {
         properties.put("#this", o1);
         properties.put("#iter", iter);
         tag.execute(properties, out);
         iter.next();
      }
   }

   private void iterateArray(TemplateProperties properties, TagNode tag, Appendable out, Object[] o) throws IOException, TemplateEvaluationException {
      Iter iter = new Iter();
      for (Object o1 : o) {
         properties.put("#this", o1);
         properties.put("#iter", iter);
         tag.execute(properties, out);
         iter.next();
      }
   }

   private void iterateInt(TemplateProperties properties, TagNode tag, Appendable out, int[] o) throws IOException, TemplateEvaluationException {
      Iter iter = new Iter();
      for (int o1 : o) {
         properties.put("#this", o1);
         properties.put("#iter", iter);
         tag.execute(properties, out);
         iter.next();
      }
   }

   private void iterateFloat(TemplateProperties properties, TagNode tag, Appendable out, float[] o) throws IOException, TemplateEvaluationException {
      Iter iter = new Iter();
      for (float o1 : o) {
         properties.put("#this", o1);
         properties.put("#iter", iter);
         tag.execute(properties, out);
         iter.next();
      }
   }

   private void iterateDouble(TemplateProperties properties, TagNode tag, Appendable out, double[] o) throws IOException, TemplateEvaluationException {
      Iter iter = new Iter();
      for (double o1 : o) {
         properties.put("#this", o1);
         properties.put("#iter", iter);
         tag.execute(properties, out);
         iter.next();
      }
   }

   private void iterateByte(TemplateProperties properties, TagNode tag, Appendable out, byte[] o) throws IOException, TemplateEvaluationException {
      Iter iter = new Iter();
      for (byte o1 : o) {
         properties.put("#this", o1);
         properties.put("#iter", iter);
         tag.execute(properties, out);
         iter.next();
      }
   }

   private void iterateChar(TemplateProperties properties, TagNode tag, Appendable out, char[] o) throws IOException, TemplateEvaluationException {
      Iter iter = new Iter();
      for (char o1 : o) {
         properties.put("#this", o1);
         properties.put("#iter", iter);
         tag.execute(properties, out);
         iter.next();
      }
   }

   private void iterateBoolean(TemplateProperties properties, TagNode tag, Appendable out, boolean[] o) throws IOException, TemplateEvaluationException {
      Iter iter = new Iter();
      for (boolean o1 : o) {
         properties.put("#this", o1);
         properties.put("#iter", iter);
         tag.execute(properties, out);
         iter.next();
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

   public static void main(String[] args) {
      int[] a = {2, 3};
      System.out.println(a instanceof int[]);
   }
}