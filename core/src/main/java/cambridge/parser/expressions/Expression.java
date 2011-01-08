package cambridge.parser.expressions;

import cambridge.ExpressionEvaluationException;
import cambridge.runtime.TemplateBindings;

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

   public Type getType(TemplateBindings globals) throws ExpressionEvaluationException;

   public Object eval(TemplateBindings globals) throws ExpressionEvaluationException;

   public boolean asBoolean(TemplateBindings globals) throws ExpressionEvaluationException;

   public int asInt(TemplateBindings globals) throws ExpressionEvaluationException;

   public float asFloat(TemplateBindings globals) throws ExpressionEvaluationException;

   public double asDouble(TemplateBindings globals) throws ExpressionEvaluationException;

   public long asLong(TemplateBindings globals) throws ExpressionEvaluationException;

   public String asString(TemplateBindings globals) throws ExpressionEvaluationException;
}
