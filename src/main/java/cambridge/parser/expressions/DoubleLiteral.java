package cambridge.parser.expressions;

import cambridge.ExpressionEvaluationException;
import cambridge.runtime.TemplateProperties;

/**
 * User: erdinc
 * Date: Oct 31, 2009
 * Time: 1:09:06 AM
 */
public class DoubleLiteral implements Expression {
   private final double value;

   public DoubleLiteral(double value) {
      this.value = value;
   }

   public Type getType(TemplateProperties properties) throws ExpressionEvaluationException {
      return Type.Double;
   }

   public Object eval(TemplateProperties properties) {
      return value;
   }

   public boolean asBoolean(TemplateProperties properties) throws ExpressionEvaluationException {
      return value != 0;
   }

   public int asInt(TemplateProperties properties) throws ExpressionEvaluationException {
      return (int) value;
   }

   public float asFloat(TemplateProperties properties) throws ExpressionEvaluationException {
      return (float) value;
   }

   public double asDouble(TemplateProperties properties) throws ExpressionEvaluationException {
      return value;
   }

   public long asLong(TemplateProperties properties) throws ExpressionEvaluationException {
      return (long) value;
   }

   public String asString(TemplateProperties properties) throws ExpressionEvaluationException {
      return "" + value;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      DoubleLiteral that = (DoubleLiteral) o;

      return Double.compare(that.value, value) == 0;
   }

   @Override
   public int hashCode() {
      long temp = value != +0.0d ? Double.doubleToLongBits(value) : 0L;
      return (int) (temp ^ (temp >>> 32));
   }
}
