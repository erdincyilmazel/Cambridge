package cambridge.parser.expressions;

import cambridge.ExpressionEvaluationException;

import java.util.Map;

/**
 * User: erdinc
 * Date: Oct 31, 2009
 * Time: 12:34:28 AM
 */
public interface Expression {
   public enum Type {
      Boolean,
      Int,
      Float,
      Double,
      Long,
      String,
      Null,
      Object
   }

   public enum Operator {
      ConditionalOr,
      ConditionalAnd,
      Or,
      And,
      XOr,
      Equal,
      NotEqual,
      LTE,
      GTE,
      LT,
      GT,
      SHIFT_LEFT,
      SHIFT_RIGHT,
      U_SHIFT_RIGHT,
      Plus,
      Minus,
      Times,
      Divide,
      Mod,
      Tilde,
      Not,
   }

   public Type getType(Map<String, Object> globals) throws ExpressionEvaluationException;

   public Object eval(Map<String, Object> globals) throws ExpressionEvaluationException;

   public boolean asBoolean(Map<String, Object> globals) throws ExpressionEvaluationException;

   public int asInt(Map<String, Object> globals) throws ExpressionEvaluationException;

   public float asFloat(Map<String, Object> globals) throws ExpressionEvaluationException;

   public double asDouble(Map<String, Object> globals) throws ExpressionEvaluationException;

   public long asLong(Map<String, Object> globals) throws ExpressionEvaluationException;

   public String asString(Map<String, Object> globals) throws ExpressionEvaluationException;
}
