package cambridge.parser.expressions;

import cambridge.ExpressionEvaluationException;
import cambridge.runtime.ExpressionContext;


/**
 * @author Erdinc Yilmazel
 * Date: Oct 31, 2009
 * Time: 1:09:41 AM
 */
public class BooleanLiteral implements CambridgeExpression {
   private final boolean value;

   public BooleanLiteral(boolean value) {
      this.value = value;
   }

   public Type getType(ExpressionContext context) throws ExpressionEvaluationException {
      return Type.Boolean;
   }

   public Object eval(ExpressionContext context) {
      return value;
   }

   public boolean asBoolean(ExpressionContext context) throws ExpressionEvaluationException {
      return value;
   }

   public int asInt(ExpressionContext context) throws ExpressionEvaluationException {
      return value ? 1 : 0;
   }

   public float asFloat(ExpressionContext context) throws ExpressionEvaluationException {
      return value ? 1 : 0;
   }

   public double asDouble(ExpressionContext context) throws ExpressionEvaluationException {
      return value ? 1 : 0;
   }

   public long asLong(ExpressionContext context) throws ExpressionEvaluationException {
      return 0;
   }

   public String asString(ExpressionContext context) throws ExpressionEvaluationException {
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
