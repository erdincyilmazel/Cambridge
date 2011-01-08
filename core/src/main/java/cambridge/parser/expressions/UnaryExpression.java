package cambridge.parser.expressions;

import cambridge.ExpressionEvaluationException;
import cambridge.runtime.TemplateBindings;

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

   public Type getType(TemplateBindings bindings) throws ExpressionEvaluationException {
      if (operator == Operator.Not) {
         return Type.Boolean;
      }
      return Type.Int;
   }

   public Object eval(TemplateBindings bindings) throws ExpressionEvaluationException {
      switch (operator) {
         case Not:
            return !expression.asBoolean(bindings);
         case Tilde:
            return ~expression.asInt(bindings);
      }

      return null;
   }

   public boolean asBoolean(TemplateBindings bindings) throws ExpressionEvaluationException {
      if (operator == Operator.Not) {
         return !expression.asBoolean(bindings);
      }

      return ~expression.asInt(bindings) != 0;
   }

   public int asInt(TemplateBindings bindings) throws ExpressionEvaluationException {
      if (operator == Operator.Not) {
         return !expression.asBoolean(bindings) ? 1 : 0;
      }

      return ~expression.asInt(bindings);
   }

   public float asFloat(TemplateBindings bindings) throws ExpressionEvaluationException {
      if (operator == Operator.Not) {
         return !expression.asBoolean(bindings) ? 1 : 0;
      }

      return ~expression.asInt(bindings);
   }

   public double asDouble(TemplateBindings bindings) throws ExpressionEvaluationException {
      if (operator == Operator.Not) {
         return !expression.asBoolean(bindings) ? 1 : 0;
      }

      return ~expression.asInt(bindings);
   }

   public long asLong(TemplateBindings bindings) throws ExpressionEvaluationException {
      if (operator == Operator.Not) {
         return !expression.asBoolean(bindings) ? 1 : 0;
      }

      return ~expression.asInt(bindings);
   }

   public String asString(TemplateBindings bindings) throws ExpressionEvaluationException {
      if (operator == Operator.Not) {
         return !expression.asBoolean(bindings) ? "true" : "false";
      }

      return ~expression.asInt(bindings) + "";
   }
}
