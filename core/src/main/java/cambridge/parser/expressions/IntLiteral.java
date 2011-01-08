package cambridge.parser.expressions;

import cambridge.ExpressionEvaluationException;
import cambridge.runtime.TemplateBindings;

/**
 * User: erdinc
 * Date: Oct 31, 2009
 * Time: 1:08:05 AM
 */
public class IntLiteral implements Expression {
   private final int value;

   public IntLiteral(int value) {
      this.value = value;
   }

   public Type getType(TemplateBindings bindings) throws ExpressionEvaluationException {
      return Type.Int;
   }

   public Integer eval(TemplateBindings bindings) {
      return value;
   }

   public boolean asBoolean(TemplateBindings bindings) throws ExpressionEvaluationException {
      return 0 != value;
   }

   public int asInt(TemplateBindings bindings) throws ExpressionEvaluationException {
      return value;
   }

   public float asFloat(TemplateBindings bindings) throws ExpressionEvaluationException {
      return value;
   }

   public double asDouble(TemplateBindings bindings) throws ExpressionEvaluationException {
      return value;
   }

   public long asLong(TemplateBindings bindings) throws ExpressionEvaluationException {
      return value;
   }

   public String asString(TemplateBindings bindings) throws ExpressionEvaluationException {
      return "" + value;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      IntLiteral that = (IntLiteral) o;

      return value == that.value;
   }

   @Override
   public int hashCode() {
      return value;
   }

   public String toString() {
      return "" + value;
   }
}
