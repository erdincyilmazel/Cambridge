package cambridge.parser.expressions;

import cambridge.ExpressionEvaluationException;
import cambridge.runtime.TemplateProperties;

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

   public Type getType(TemplateProperties globals) throws ExpressionEvaluationException;

   public Object eval(TemplateProperties globals) throws ExpressionEvaluationException;

   public boolean asBoolean(TemplateProperties globals) throws ExpressionEvaluationException;

   public int asInt(TemplateProperties globals) throws ExpressionEvaluationException;

   public float asFloat(TemplateProperties globals) throws ExpressionEvaluationException;

   public double asDouble(TemplateProperties globals) throws ExpressionEvaluationException;

   public long asLong(TemplateProperties globals) throws ExpressionEvaluationException;

   public String asString(TemplateProperties globals) throws ExpressionEvaluationException;
}
