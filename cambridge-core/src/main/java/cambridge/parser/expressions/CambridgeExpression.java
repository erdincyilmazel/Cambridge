package cambridge.parser.expressions;

import cambridge.ExpressionEvaluationException;
import cambridge.model.Expression;
import cambridge.runtime.ExpressionContext;

/**
 * @author Erdinc YILMAZEL
 * @since 1/31/11
 */
public interface CambridgeExpression extends Expression {
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

   public Type getType(ExpressionContext context) throws ExpressionEvaluationException;
}
