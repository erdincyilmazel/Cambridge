package cambridge.parser.expressions;

import cambridge.ExpressionEvaluationException;

import java.util.Map;

/**
 * User: erdinc
 * Date: Oct 31, 2009
 * Time: 1:08:05 AM
 */
public class IntLiteral implements Expression {
   private final int value;

   public IntLiteral(int value) {
      this.value = value;
   }

   public Type getType(Map<String, Object> bindings) throws ExpressionEvaluationException {
      return Type.Int;
   }

   public Integer eval(Map<String, Object> bindings) {
      return value;
   }

   public boolean asBoolean(Map<String, Object> bindings) throws ExpressionEvaluationException {
      return 0 != value;
   }

   public int asInt(Map<String, Object> bindings) throws ExpressionEvaluationException {
      return value;
   }

   public float asFloat(Map<String, Object> bindings) throws ExpressionEvaluationException {
      return value;
   }

   public double asDouble(Map<String, Object> bindings) throws ExpressionEvaluationException {
      return value;
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

      IntLiteral that = (IntLiteral) o;

      return value == that.value;
   }

   @Override
   public int hashCode() {
      return value;
   }

   public String toString() {
      return "" + value;
   }
}
