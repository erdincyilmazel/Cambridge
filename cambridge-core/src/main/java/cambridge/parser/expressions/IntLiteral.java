package cambridge.parser.expressions;

import cambridge.ExpressionEvaluationException;
import cambridge.runtime.ExpressionContext;

/**
 * @author Erdinc Yilmazel
 * Date: Oct 31, 2009
 * Time: 1:08:05 AM
 */
public class IntLiteral implements CambridgeExpression {
   private final int value;

   public IntLiteral(int value) {
      this.value = value;
   }

   public Type getType(ExpressionContext context) throws ExpressionEvaluationException {
      return Type.Int;
   }

   public Integer eval(ExpressionContext context) {
      return value;
   }

   public boolean asBoolean(ExpressionContext context) throws ExpressionEvaluationException {
      return 0 != value;
   }

   public int asInt(ExpressionContext context) throws ExpressionEvaluationException {
      return value;
   }

   public float asFloat(ExpressionContext context) throws ExpressionEvaluationException {
      return value;
   }

   public double asDouble(ExpressionContext context) throws ExpressionEvaluationException {
      return value;
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
