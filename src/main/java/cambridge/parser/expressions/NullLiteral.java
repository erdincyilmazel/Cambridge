package cambridge.parser.expressions;

import cambridge.ExpressionEvaluationException;

import java.util.Map;

/**
 * User: erdinc
 * Date: Oct 31, 2009
 * Time: 1:09:57 AM
 */
public class NullLiteral implements Expression {
   public static NullLiteral instance = new NullLiteral();

   private NullLiteral() {
   }

   @Override
   public Type getType(Map<String, Object> properties) throws ExpressionEvaluationException {
      return Type.Null;
   }

   @Override
   public Object eval(Map<String, Object> properties) {
      return null;
   }

   @Override
   public boolean asBoolean(Map<String, Object> properties) throws ExpressionEvaluationException {
      return false;
   }

   @Override
   public int asInt(Map<String, Object> properties) throws ExpressionEvaluationException {
      return 0;
   }

   @Override
   public float asFloat(Map<String, Object> properties) throws ExpressionEvaluationException {
      return 0;
   }

   @Override
   public double asDouble(Map<String, Object> properties) throws ExpressionEvaluationException {
      return 0;
   }

   @Override
   public long asLong(Map<String, Object> properties) throws ExpressionEvaluationException {
      return 0;
   }

   @Override
   public String asString(Map<String, Object> properties) throws ExpressionEvaluationException {
      return "null";
   }
}
