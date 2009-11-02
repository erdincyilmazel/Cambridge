package cambridge.parser.expressions;

import cambridge.ExpressionEvaluationException;

import java.util.Map;

/**
 * User: erdinc
 * Date: Oct 31, 2009
 * Time: 1:09:41 AM
 */
public class BooleanLiteral implements Expression {
   boolean value;

   public BooleanLiteral(boolean value) {
      this.value = value;
   }

   @Override
   public Type getType(Map<String, Object> properties) throws ExpressionEvaluationException {
      return Type.Boolean;
   }

   @Override
   public Object eval(Map<String, Object> properties) {
      return value;
   }

   @Override
   public boolean asBoolean(Map<String, Object> properties) throws ExpressionEvaluationException {
      return value;
   }

   @Override
   public int asInt(Map<String, Object> properties) throws ExpressionEvaluationException {
      return value ? 1 : 0;
   }

   @Override
   public float asFloat(Map<String, Object> properties) throws ExpressionEvaluationException {
      return value ? 1 : 0;
   }

   @Override
   public double asDouble(Map<String, Object> properties) throws ExpressionEvaluationException {
      return value ? 1 : 0;
   }

   @Override
   public long asLong(Map<String, Object> properties) throws ExpressionEvaluationException {
      return 0;
   }

   @Override
   public String asString(Map<String, Object> properties) throws ExpressionEvaluationException {
      return "" + value;
   }
}
