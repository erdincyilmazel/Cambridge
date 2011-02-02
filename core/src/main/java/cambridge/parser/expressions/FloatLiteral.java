package cambridge.parser.expressions;

import cambridge.ExpressionEvaluationException;

import java.util.Map;

/**
 * User: erdinc
 * Date: Oct 31, 2009
 * Time: 1:08:36 AM
 */
public class FloatLiteral implements CambridgeExpression {
   private final float value;

   public FloatLiteral(float value) {
      this.value = value;
   }

   public Type getType(Map<String, Object> bindings) throws ExpressionEvaluationException {
      return Type.Float;
   }

   public Float eval(Map<String, Object> bindings) {
      return value;
   }

   public boolean asBoolean(Map<String, Object> bindings) throws ExpressionEvaluationException {
      return 0 != value;
   }

   public int asInt(Map<String, Object> bindings) throws ExpressionEvaluationException {
      return (int) value;
   }

   public float asFloat(Map<String, Object> bindings) throws ExpressionEvaluationException {
      return value;
   }

   public double asDouble(Map<String, Object> bindings) throws ExpressionEvaluationException {
      return value;
   }

   public long asLong(Map<String, Object> bindings) throws ExpressionEvaluationException {
      return (long) value;
   }

   public String asString(Map<String, Object> bindings) throws ExpressionEvaluationException {
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
