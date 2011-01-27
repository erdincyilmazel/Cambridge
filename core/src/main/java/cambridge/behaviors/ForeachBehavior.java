package cambridge.behaviors;

import cambridge.model.AttributeKey;
import cambridge.BehaviorInstantiationException;
import cambridge.BehaviorProvider;
import cambridge.ExpressionEvaluationException;
import cambridge.ExpressionParsingException;
import cambridge.LoopingTagBehavior;
import cambridge.TemplateEvaluationException;
import cambridge.model.Attribute;
import cambridge.model.DynamicAttribute;
import cambridge.model.TagNode;
import cambridge.parser.expressions.Expression;
import cambridge.runtime.Iter;

import java.io.IOException;
import java.util.Map;

/**
 * User: erdinc
 * Date: Oct 31, 2009
 * Time: 7:18:33 PM
 */
public class ForeachBehavior extends LoopingTagBehavior {
   private final Expression iterable;

   public ForeachBehavior(Expression iterable) {
      this.iterable = iterable;
   }

   @Override
   public void doExecute(Map<String, Object> bindings, TagNode tag, Appendable out) throws TemplateEvaluationException, IOException {
      try {
         Object o = iterable.eval(bindings);
         if (o == null) {
            return;
            //throw new TemplateEvaluationException("The provided expression value for foreach attribute is null", tag.getBeginLine(), tag.getBeginColumn(), tag.getTagName());
         }

         if (o instanceof Object[]) {
            iterateArray(bindings, tag, out, (Object[]) o);
         } else if (o instanceof Iterable) {
            iterateIterable(bindings, tag, out, (Iterable) o);
         } else if (o instanceof int[]) {
            iterateInt(bindings, tag, out, (int[]) o);
         } else if (o instanceof float[]) {
            iterateFloat(bindings, tag, out, (float[]) o);
         } else if (o instanceof double[]) {
            iterateDouble(bindings, tag, out, (double[]) o);
         } else if (o instanceof byte[]) {
            iterateByte(bindings, tag, out, (byte[]) o);
         } else if (o instanceof char[]) {
            iterateChar(bindings, tag, out, (char[]) o);
         } else if (o instanceof boolean[]) {
            iterateBoolean(bindings, tag, out, (boolean[]) o);
         } else {
            throw new TemplateEvaluationException("The provided expression value of class " + o.getClass().getName() + " for foreach attribute is not iterable", tag.getBeginLine(), tag.getBeginColumn());
         }

      } catch (ExpressionEvaluationException e) {
         throw new TemplateEvaluationException("Could not execute the expression: " + e.getMessage(), tag.getBeginLine(), tag.getBeginColumn(), tag.getTagName());
      }
   }

   private void iterateIterable(Map<String, Object> bindings, TagNode tag, Appendable out, Iterable o) throws IOException, TemplateEvaluationException {
      Iter iter = new Iter();
      for (Object o1 : o) {
         bindings.put("#this", o1);
         bindings.put("#iter", iter);
         tag.execute(bindings, out);
         iter.next();
      }
   }

   private void iterateArray(Map<String, Object> bindings, TagNode tag, Appendable out, Object[] o) throws IOException, TemplateEvaluationException {
      Iter iter = new Iter();
      for (Object o1 : o) {
         bindings.put("#this", o1);
         bindings.put("#iter", iter);
         tag.execute(bindings, out);
         iter.next();
      }
   }

   private void iterateInt(Map<String, Object> bindings, TagNode tag, Appendable out, int[] o) throws IOException, TemplateEvaluationException {
      Iter iter = new Iter();
      for (int o1 : o) {
         bindings.put("#this", o1);
         bindings.put("#iter", iter);
         tag.execute(bindings, out);
         iter.next();
      }
   }

   private void iterateFloat(Map<String, Object> bindings, TagNode tag, Appendable out, float[] o) throws IOException, TemplateEvaluationException {
      Iter iter = new Iter();
      for (float o1 : o) {
         bindings.put("#this", o1);
         bindings.put("#iter", iter);
         tag.execute(bindings, out);
         iter.next();
      }
   }

   private void iterateDouble(Map<String, Object> bindings, TagNode tag, Appendable out, double[] o) throws IOException, TemplateEvaluationException {
      Iter iter = new Iter();
      for (double o1 : o) {
         bindings.put("#this", o1);
         bindings.put("#iter", iter);
         tag.execute(bindings, out);
         iter.next();
      }
   }

   private void iterateByte(Map<String, Object> bindings, TagNode tag, Appendable out, byte[] o) throws IOException, TemplateEvaluationException {
      Iter iter = new Iter();
      for (byte o1 : o) {
         bindings.put("#this", o1);
         bindings.put("#iter", iter);
         tag.execute(bindings, out);
         iter.next();
      }
   }

   private void iterateChar(Map<String, Object> bindings, TagNode tag, Appendable out, char[] o) throws IOException, TemplateEvaluationException {
      Iter iter = new Iter();
      for (char o1 : o) {
         bindings.put("#this", o1);
         bindings.put("#iter", iter);
         tag.execute(bindings, out);
         iter.next();
      }
   }

   private void iterateBoolean(Map<String, Object> bindings, TagNode tag, Appendable out, boolean[] o) throws IOException, TemplateEvaluationException {
      Iter iter = new Iter();
      for (boolean o1 : o) {
         bindings.put("#this", o1);
         bindings.put("#iter", iter);
         tag.execute(bindings, out);
         iter.next();
      }
   }

   public static BehaviorProvider<ForeachBehavior> getProvider() {
      return new BehaviorProvider<ForeachBehavior>() {
         public ForeachBehavior get(DynamicAttribute keyAttribute, Map<AttributeKey, Attribute> attributes) throws ExpressionParsingException, BehaviorInstantiationException {
            Expression e = keyAttribute.getExpression();
            return new ForeachBehavior(e);
         }
      };
   }
}