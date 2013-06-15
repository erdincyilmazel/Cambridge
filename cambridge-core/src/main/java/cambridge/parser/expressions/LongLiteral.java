package cambridge.parser.expressions;

import cambridge.ExpressionEvaluationException;
import cambridge.runtime.ExpressionContext;

/**
 * @author Erdinc Yilmazel
 * Date: Oct 31, 2009
 * Time: 1:08:21 AM
 */
public class LongLiteral implements CambridgeExpression {
   private final long value;

   public LongLiteral(long value) {
      this.value = value;
   }

   public Type getType(ExpressionContext context) throws ExpressionEvaluationException {
      return Type.Long;
   }

   public Long eval(ExpressionContext context) {
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
      return (double) value;
   }

   public long asLong(ExpressionContext context) throws ExpressionEvaluationException {
      return value;
   }

   public String asString(ExpressionContext context) throws ExpressionEvaluationException {
      return "" + value;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      LongLiteral that = (LongLiteral) o;

      return value == that.value;
   }

   @Override
   public int hashCode() {
      return (int) (value ^ (value >>> 32));
   }
}
