package cambridge.parser.expressions;

import cambridge.ExpressionEvaluationException;

import java.util.Map;

/**
 * User: erdinc
 * Date: Oct 31, 2009
 * Time: 1:09:06 AM
 */
public class DoubleLiteral implements Expression {
   private final double value;

   public DoubleLiteral(double value) {
      this.value = value;
   }

   public Type getType(Map<String, Object> bindings) throws ExpressionEvaluationException {
      return Type.Double;
   }

   public Object eval(Map<String, Object> bindings) {
      return value;
   }

   public boolean asBoolean(Map<String, Object> bindings) throws ExpressionEvaluationException {
      return value != 0;
   }

   public int asInt(Map<String, Object> bindings) throws ExpressionEvaluationException {
      return (int) value;
   }

   public float asFloat(Map<String, Object> bindings) throws ExpressionEvaluationException {
      return (float) value;
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

      DoubleLiteral that = (DoubleLiteral) o;

      return Double.compare(that.value, value) == 0;
   }

   @Override
   public int hashCode() {
      long temp = value != +0.0d ? Double.doubleToLongBits(value) : 0L;
      return (int) (temp ^ (temp >>> 32));
   }
}
