package cambridge.parser.expressions;

import cambridge.ExpressionEvaluationException;
import cambridge.runtime.TemplateBindings;

/**
 * User: erdinc
 * Date: Oct 31, 2009
 * Time: 1:08:36 AM
 */
public class FloatLiteral implements Expression {
   private final float value;

   public FloatLiteral(float value) {
      this.value = value;
   }

   public Type getType(TemplateBindings bindings) throws ExpressionEvaluationException {
      return Type.Float;
   }

   public Float eval(TemplateBindings bindings) {
      return value;
   }

   public boolean asBoolean(TemplateBindings bindings) throws ExpressionEvaluationException {
      return 0 != value;
   }

   public int asInt(TemplateBindings bindings) throws ExpressionEvaluationException {
      return (int) value;
   }

   public float asFloat(TemplateBindings bindings) throws ExpressionEvaluationException {
      return value;
   }

   public double asDouble(TemplateBindings bindings) throws ExpressionEvaluationException {
      return value;
   }

   public long asLong(TemplateBindings bindings) throws ExpressionEvaluationException {
      return (long) value;
   }

   public String asString(TemplateBindings bindings) throws ExpressionEvaluationException {
      return "" + value;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      FloatLiteral that = (FloatLiteral) o;

      return Float.compare(that.value, value) == 0;
   }

   @Override
   public int hashCode() {
      return (value != +0.0f ? Float.floatToIntBits(value) : 0);
   }
}
