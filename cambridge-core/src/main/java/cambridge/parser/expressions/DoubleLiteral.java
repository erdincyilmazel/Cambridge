package cambridge.parser.expressions;

import cambridge.ExpressionEvaluationException;
import cambridge.runtime.ExpressionContext;

/**
 * @author Erdinc Yilmazel
 * Date: Oct 31, 2009
 * Time: 1:09:06 AM
 */
public class DoubleLiteral implements CambridgeExpression {
   private final double value;

   public DoubleLiteral(double value) {
      this.value = value;
   }

   public Type getType(ExpressionContext context) throws ExpressionEvaluationException {
      return Type.Double;
   }

   public Object eval(ExpressionContext context) {
      return value;
   }

   public boolean asBoolean(ExpressionContext context) throws ExpressionEvaluationException {
      return value != 0;
   }

   public int asInt(ExpressionContext context) throws ExpressionEvaluationException {
      return (int) value;
   }

   public float asFloat(ExpressionContext context) throws ExpressionEvaluationException {
      return (float) value;
   }

   public double asDouble(ExpressionContext context) throws ExpressionEvaluationException {
      return value;
   }

   public long asLong(ExpressionContext context) throws ExpressionEvaluationException {
      return (long) value;
   }

   public String asString(ExpressionContext context) throws ExpressionEvaluationException {
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
