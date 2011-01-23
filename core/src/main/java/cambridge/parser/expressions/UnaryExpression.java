package cambridge.parser.expressions;

import cambridge.ExpressionEvaluationException;
import java.util.Map;

/**
 * User: erdinc
 * Date: Oct 31, 2009
 * Time: 12:35:27 AM
 */
public class UnaryExpression implements Expression {
   private final Operator operator;
   private final Expression expression;

   public UnaryExpression(Operator operator, Expression expression) {
      this.operator = operator;
      this.expression = expression;
   }

   public Type getType(Map<String, Object> bindings) throws ExpressionEvaluationException {
      if (operator == Operator.Not) {
         return Type.Boolean;
      }
      return Type.Int;
   }

   public Object eval(Map<String, Object> bindings) throws ExpressionEvaluationException {
      switch (operator) {
         case Not:
            return !expression.asBoolean(bindings);
         case Tilde:
            return ~expression.asInt(bindings);
      }

      return null;
   }

   public boolean asBoolean(Map<String, Object> bindings) throws ExpressionEvaluationException {
      if (operator == Operator.Not) {
         return !expression.asBoolean(bindings);
      }

      return ~expression.asInt(bindings) != 0;
   }

   public int asInt(Map<String, Object> bindings) throws ExpressionEvaluationException {
      if (operator == Operator.Not) {
         return !expression.asBoolean(bindings) ? 1 : 0;
      }

      return ~expression.asInt(bindings);
   }

   public float asFloat(Map<String, Object> bindings) throws ExpressionEvaluationException {
      if (operator == Operator.Not) {
         return !expression.asBoolean(bindings) ? 1 : 0;
      }

      return ~expression.asInt(bindings);
   }

   public double asDouble(Map<String, Object> bindings) throws ExpressionEvaluationException {
      if (operator == Operator.Not) {
         return !expression.asBoolean(bindings) ? 1 : 0;
      }

      return ~expression.asInt(bindings);
   }

   public long asLong(Map<String, Object> bindings) throws ExpressionEvaluationException {
      if (operator == Operator.Not) {
         return !expression.asBoolean(bindings) ? 1 : 0;
      }

      return ~expression.asInt(bindings);
   }

   public String asString(Map<String, Object> bindings) throws ExpressionEvaluationException {
      if (operator == Operator.Not) {
         return !expression.asBoolean(bindings) ? "true" : "false";
      }

      return ~expression.asInt(bindings) + "";
   }
}
