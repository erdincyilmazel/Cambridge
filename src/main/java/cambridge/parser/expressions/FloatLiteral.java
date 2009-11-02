package cambridge.parser.expressions;

import cambridge.ExpressionEvaluationException;

import java.util.Map;

/**
 * User: erdinc
 * Date: Oct 31, 2009
 * Time: 1:08:36 AM
 */
public class FloatLiteral implements Expression {
   float value;

   public FloatLiteral(float value) {
      this.value = value;
   }

   @Override
   public Type getType(Map<String, Object> properties) throws ExpressionEvaluationException {
      return Type.Float;
   }

   @Override
   public Float eval(Map<String, Object> properties) {
      return value;
   }

   @Override
   public boolean asBoolean(Map<String, Object> properties) throws ExpressionEvaluationException {
      return 0 != value;
   }

   @Override
   public int asInt(Map<String, Object> properties) throws ExpressionEvaluationException {
      return (int) value;
   }

   @Override
   public float asFloat(Map<String, Object> properties) throws ExpressionEvaluationException {
      return value;
   }

   @Override
   public double asDouble(Map<String, Object> properties) throws ExpressionEvaluationException {
      return value;
   }

   @Override
   public long asLong(Map<String, Object> properties) throws ExpressionEvaluationException {
      return (long) value;
   }

   @Override
   public String asString(Map<String, Object> properties) throws ExpressionEvaluationException {
      return "" + value;
   }
}
