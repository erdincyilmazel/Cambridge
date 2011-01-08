package cambridge.parser.expressions;

import cambridge.ExpressionEvaluationException;
import cambridge.runtime.TemplateBindings;

/**
 * User: erdinc
 * Date: Oct 31, 2009
 * Time: 1:09:41 AM
 */
public class BooleanLiteral implements Expression {
   private final boolean value;

   public BooleanLiteral(boolean value) {
      this.value = value;
   }

   public Type getType(TemplateBindings bindings) throws ExpressionEvaluationException {
      return Type.Boolean;
   }

   public Object eval(TemplateBindings bindings) {
      return value;
   }

   public boolean asBoolean(TemplateBindings bindings) throws ExpressionEvaluationException {
      return value;
   }

   public int asInt(TemplateBindings bindings) throws ExpressionEvaluationException {
      return value ? 1 : 0;
   }

   public float asFloat(TemplateBindings bindings) throws ExpressionEvaluationException {
      return value ? 1 : 0;
   }

   public double asDouble(TemplateBindings bindings) throws ExpressionEvaluationException {
      return value ? 1 : 0;
   }

   public long asLong(TemplateBindings bindings) throws ExpressionEvaluationException {
      return 0;
   }

   public String asString(TemplateBindings bindings) throws ExpressionEvaluationException {
      return "" + value;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      BooleanLiteral that = (BooleanLiteral) o;

      return value == that.value;
   }

   @Override
   public int hashCode() {
      return (value ? 1 : 0);
   }
}
