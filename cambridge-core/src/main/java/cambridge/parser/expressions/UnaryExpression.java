package cambridge.parser.expressions;

import cambridge.ExpressionEvaluationException;
import cambridge.runtime.ExpressionContext;

/**
 * @author Erdinc Yilmazel
 * Date: Oct 31, 2009
 * Time: 12:35:27 AM
 */
public class UnaryExpression implements CambridgeExpression {
   private final Operator operator;
   private final CambridgeExpression expression;

   public UnaryExpression(Operator operator, CambridgeExpression expression) {
      this.operator = operator;
      this.expression = expression;
   }

   public Type getType(ExpressionContext context) throws ExpressionEvaluationException {
      if (operator == Operator.Not) {
         return Type.Boolean;
      }
      return Type.Int;
   }

   public Object eval(ExpressionContext context) throws ExpressionEvaluationException {
      switch (operator) {
         case Not:
            return !expression.asBoolean(context);
         case Tilde:
            return ~expression.asInt(context);
      }

      return null;
   }

   public boolean asBoolean(ExpressionContext context) throws ExpressionEvaluationException {
      if (operator == Operator.Not) {
         return !expression.asBoolean(context);
      }

      return ~expression.asInt(context) != 0;
   }

   public int asInt(ExpressionContext context) throws ExpressionEvaluationException {
      if (operator == Operator.Not) {
         return !expression.asBoolean(context) ? 1 : 0;
      }

      return ~expression.asInt(context);
   }

   public float asFloat(ExpressionContext context) throws ExpressionEvaluationException {
      if (operator == Operator.Not) {
         return !expression.asBoolean(context) ? 1 : 0;
      }

      return ~expression.asInt(context);
   }

   public double asDouble(ExpressionContext context) throws ExpressionEvaluationException {
      if (operator == Operator.Not) {
         return !expression.asBoolean(context) ? 1 : 0;
      }

      return ~expression.asInt(context);
   }

   public long asLong(ExpressionContext context) throws ExpressionEvaluationException {
      if (operator == Operator.Not) {
         return !expression.asBoolean(context) ? 1 : 0;
      }

      return ~expression.asInt(context);
   }

   public String asString(ExpressionContext context) throws ExpressionEvaluationException {
      if (operator == Operator.Not) {
         return !expression.asBoolean(context) ? "true" : "false";
      }

      return ~expression.asInt(context) + "";
   }
}
