package cambridge.parser.expressions;

import cambridge.ExpressionEvaluationException;

import java.util.Map;

/**
 * @author Erdinc Yilmazel
 * Date: Oct 31, 2009
 * Time: 1:08:21 AM
 */
public class LongLiteral implements CambridgeExpression {
   private final long value;

   public LongLiteral(long value) {
      this.value = value;
   }

   public Type getType(Map<String, Object> bindings) throws ExpressionEvaluationException {
      return Type.Long;
   }

   public Long eval(Map<String, Object> bindings) {
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
      return (double) value;
   }

   public long asLong(Map<String, Object> bindings) throws ExpressionEvaluationException {
      return value;
   }

   public String asString(Map<String, Object> bindings) throws ExpressionEvaluationException {
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
