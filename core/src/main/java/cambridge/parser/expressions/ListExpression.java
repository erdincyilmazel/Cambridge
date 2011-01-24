package cambridge.parser.expressions;

import cambridge.ExpressionEvaluationException;

import java.util.ArrayList;
import java.util.Map;

/**
 * User: Erdinc
 * Date: Apr 12, 2010
 * Time: 11:52:13 PM
 */
public class ListExpression extends ArrayList implements Expression {
   public Type getType(Map<String, Object> globals) throws ExpressionEvaluationException {
      return Type.Object;
   }

   public Object eval(Map<String, Object> globals) throws ExpressionEvaluationException {
      return this;
   }

   public boolean asBoolean(Map<String, Object> globals) throws ExpressionEvaluationException {
      return false;
   }

   public int asInt(Map<String, Object> globals) throws ExpressionEvaluationException {
      return 0;
   }

   public float asFloat(Map<String, Object> globals) throws ExpressionEvaluationException {
      return 0;
   }

   public double asDouble(Map<String, Object> globals) throws ExpressionEvaluationException {
      return 0;
   }

   public long asLong(Map<String, Object> globals) throws ExpressionEvaluationException {
      return 0;
   }

   public String asString(Map<String, Object> globals) throws ExpressionEvaluationException {
      return toString();
   }
}
