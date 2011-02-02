package cambridge.parser.expressions;

import cambridge.ExpressionEvaluationException;

import java.util.Map;


/**
 * User: erdinc
 * Date: Oct 31, 2009
 * Time: 1:09:57 AM
 */
public class NullLiteral implements CambridgeExpression {
   public static final NullLiteral instance = new NullLiteral();

   private NullLiteral() {
   }

   public Type getType(Map<String, Object> bindings) throws ExpressionEvaluationException {
      return Type.Null;
   }

   public Object eval(Map<String, Object> bindings) {
      return null;
   }

   public boolean asBoolean(Map<String, Object> bindings) throws ExpressionEvaluationException {
      return false;
   }

   public int asInt(Map<String, Object> bindings) throws ExpressionEvaluationException {
      return 0;
   }

   public float asFloat(Map<String, Object> bindings) throws ExpressionEvaluationException {
      return 0;
   }

   public double asDouble(Map<String, Object> bindings) throws ExpressionEvaluationException {
      return 0;
   }

   public long asLong(Map<String, Object> bindings) throws ExpressionEvaluationException {
      return 0;
   }

   public String asString(Map<String, Object> bindings) throws ExpressionEvaluationException {
      return "null";
   }
}
