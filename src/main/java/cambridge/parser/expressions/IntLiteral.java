package cambridge.parser.expressions;

import cambridge.ExpressionEvaluationException;
import cambridge.runtime.TemplateProperties;

/**
 * User: erdinc
 * Date: Oct 31, 2009
 * Time: 1:08:05 AM
 */
public class IntLiteral implements Expression {
   int value;

   public IntLiteral(int value) {
      this.value = value;
   }

   public Type getType(TemplateProperties properties) throws ExpressionEvaluationException {
      return Type.Int;
   }

   public Integer eval(TemplateProperties properties) {
      return value;
   }

   public boolean asBoolean(TemplateProperties properties) throws ExpressionEvaluationException {
      return 0 != value;
   }

   public int asInt(TemplateProperties properties) throws ExpressionEvaluationException {
      return value;
   }

   public float asFloat(TemplateProperties properties) throws ExpressionEvaluationException {
      return value;
   }

   public double asDouble(TemplateProperties properties) throws ExpressionEvaluationException {
      return value;
   }

   public long asLong(TemplateProperties properties) throws ExpressionEvaluationException {
      return value;
   }

   public String asString(TemplateProperties properties) throws ExpressionEvaluationException {
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
