package cambridge.parser.expressions;

import cambridge.ExpressionEvaluationException;
import cambridge.runtime.TemplateBindings;

/**
 * User: erdinc
 * Date: Oct 31, 2009
 * Time: 1:08:21 AM
 */
public class LongLiteral implements Expression {
   private final long value;

   public LongLiteral(long value) {
      this.value = value;
   }

   public Type getType(TemplateBindings bindings) throws ExpressionEvaluationException {
      return Type.Long;
   }

   public Long eval(TemplateBindings bindings) {
      return value;
   }

   public boolean asBoolean(TemplateBindings bindings) throws ExpressionEvaluationException {
      return value != 0;
   }

   public int asInt(TemplateBindings bindings) throws ExpressionEvaluationException {
      return (int) value;
   }

   public float asFloat(TemplateBindings bindings) throws ExpressionEvaluationException {
      return (float) value;
   }

   public double asDouble(TemplateBindings bindings) throws ExpressionEvaluationException {
      return (double) value;
   }

   public long asLong(TemplateBindings bindings) throws ExpressionEvaluationException {
      return value;
   }

   public String asString(TemplateBindings bindings) throws ExpressionEvaluationException {
      return "" + value;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      LongLiteral that = (LongLiteral) o;

      return value == that.value;
   }

   @Override
   public int hashCode() {
      return (int) (value ^ (value >>> 32));
   }
}
