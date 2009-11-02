package cambridge.parser.expressions;

import cambridge.ExpressionEvaluationException;

import java.util.Map;

/**
 * User: erdinc
 * Date: Oct 31, 2009
 * Time: 1:08:21 AM
 */
public class LongLiteral implements Expression {
   long value;

   public LongLiteral(long value) {
      this.value = value;
   }

   @Override
   public Type getType(Map<String, Object> properties) throws ExpressionEvaluationException {
      return Type.Long;
   }

   @Override
   public Long eval(Map<String, Object> properties) {
      return value;
   }

   @Override
   public boolean asBoolean(Map<String, Object> properties) throws ExpressionEvaluationException {
      return value != 0;
   }

   @Override
   public int asInt(Map<String, Object> properties) throws ExpressionEvaluationException {
      return (int) value;
   }

   @Override
   public float asFloat(Map<String, Object> properties) throws ExpressionEvaluationException {
      return (float) value;
   }

   @Override
   public double asDouble(Map<String, Object> properties) throws ExpressionEvaluationException {
      return (double) value;
   }

   @Override
   public long asLong(Map<String, Object> properties) throws ExpressionEvaluationException {
      return value;
   }

   @Override
   public String asString(Map<String, Object> properties) throws ExpressionEvaluationException {
      return "" + value;
   }
}
