package cambridge.parser.expressions;

import cambridge.ExpressionEvaluationException;
import cambridge.runtime.TemplateProperties;

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

   public Type getType(TemplateProperties properties) throws ExpressionEvaluationException {
      if (operator == Operator.Not) {
         return Type.Boolean;
      }
      return Type.Int;
   }

   public Object eval(TemplateProperties properties) throws ExpressionEvaluationException {
      switch (operator) {
         case Not:
            return !expression.asBoolean(properties);
         case Tilde:
            return ~expression.asInt(properties);
      }

      return null;
   }

   public boolean asBoolean(TemplateProperties properties) throws ExpressionEvaluationException {
      if (operator == Operator.Not) {
         return !expression.asBoolean(properties);
      }

      return ~expression.asInt(properties) != 0;
   }

   public int asInt(TemplateProperties properties) throws ExpressionEvaluationException {
      if (operator == Operator.Not) {
         return !expression.asBoolean(properties) ? 1 : 0;
      }

      return ~expression.asInt(properties);
   }

   public float asFloat(TemplateProperties properties) throws ExpressionEvaluationException {
      if (operator == Operator.Not) {
         return !expression.asBoolean(properties) ? 1 : 0;
      }

      return ~expression.asInt(properties);
   }

   public double asDouble(TemplateProperties properties) throws ExpressionEvaluationException {
      if (operator == Operator.Not) {
         return !expression.asBoolean(properties) ? 1 : 0;
      }

      return ~expression.asInt(properties);
   }

   public long asLong(TemplateProperties properties) throws ExpressionEvaluationException {
      if (operator == Operator.Not) {
         return !expression.asBoolean(properties) ? 1 : 0;
      }

      return ~expression.asInt(properties);
   }

   public String asString(TemplateProperties properties) throws ExpressionEvaluationException {
      if (operator == Operator.Not) {
         return !expression.asBoolean(properties) ? "true" : "false";
      }

      return ~expression.asInt(properties) + "";
   }
}
