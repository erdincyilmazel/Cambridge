package cambridge.parser.expressions;

import cambridge.ExpressionEvaluationException;
import cambridge.runtime.TemplateProperties;

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

   public Type getType(TemplateProperties properties) throws ExpressionEvaluationException {
      return Type.Float;
   }

   public Float eval(TemplateProperties properties) {
      return value;
   }

   public boolean asBoolean(TemplateProperties properties) throws ExpressionEvaluationException {
      return 0 != value;
   }

   public int asInt(TemplateProperties properties) throws ExpressionEvaluationException {
      return (int) value;
   }

   public float asFloat(TemplateProperties properties) throws ExpressionEvaluationException {
      return value;
   }

   public double asDouble(TemplateProperties properties) throws ExpressionEvaluationException {
      return value;
   }

   public long asLong(TemplateProperties properties) throws ExpressionEvaluationException {
      return (long) value;
   }

   public String asString(TemplateProperties properties) throws ExpressionEvaluationException {
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
