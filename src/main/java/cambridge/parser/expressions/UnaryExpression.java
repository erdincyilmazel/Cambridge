package cambridge.parser.expressions;

import cambridge.ExpressionEvaluationException;

import java.util.Map;

/**
 * User: erdinc
 * Date: Oct 31, 2009
 * Time: 12:35:27 AM
 */
public class UnaryExpression implements Expression {
   Operator operator;
   Expression expression;

   public UnaryExpression(Operator operator, Expression expression) {
      this.operator = operator;
      this.expression = expression;
   }

   @Override
   public Type getType(Map<String, Object> properties) throws ExpressionEvaluationException {
      if (operator == Operator.Not) {
         return Type.Boolean;
      }
      return Type.Int;
   }

   @Override
   public Object eval(Map<String, Object> properties) throws ExpressionEvaluationException {
      switch (operator) {
         case Not:
            return !expression.asBoolean(properties);
         case Tilde:
            return ~expression.asInt(properties);
      }

      return null;
   }

   @Override
   public boolean asBoolean(Map<String, Object> properties) throws ExpressionEvaluationException {
      if (operator == Operator.Not) {
         return !expression.asBoolean(properties);
      }

      return ~expression.asInt(properties) != 0;
   }

   @Override
   public int asInt(Map<String, Object> properties) throws ExpressionEvaluationException {
      if (operator == Operator.Not) {
         return !expression.asBoolean(properties) ? 1 : 0;
      }

      return ~expression.asInt(properties);
   }

   @Override
   public float asFloat(Map<String, Object> properties) throws ExpressionEvaluationException {
      if (operator == Operator.Not) {
         return !expression.asBoolean(properties) ? 1 : 0;
      }

      return ~expression.asInt(properties);
   }

   @Override
   public double asDouble(Map<String, Object> properties) throws ExpressionEvaluationException {
      if (operator == Operator.Not) {
         return !expression.asBoolean(properties) ? 1 : 0;
      }

      return ~expression.asInt(properties);
   }

   @Override
   public long asLong(Map<String, Object> properties) throws ExpressionEvaluationException {
      if (operator == Operator.Not) {
         return !expression.asBoolean(properties) ? 1 : 0;
      }

      return ~expression.asInt(properties);
   }

   @Override
   public String asString(Map<String, Object> properties) throws ExpressionEvaluationException {
      if (operator == Operator.Not) {
         return !expression.asBoolean(properties) ? "true" : "false";
      }

      return ~expression.asInt(properties) + "";
   }
}
