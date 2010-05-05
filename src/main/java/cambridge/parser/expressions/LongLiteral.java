package cambridge.parser.expressions;

import cambridge.ExpressionEvaluationException;
import cambridge.runtime.TemplateProperties;

/**
 * User: erdinc
 * Date: Oct 31, 2009
 * Time: 1:08:21 AM
 */
public class LongLiteral implements Expression {
   long value;

   public LongLiteral(long value) {
      this.value = value;
   }

   public Type getType(TemplateProperties properties) throws ExpressionEvaluationException {
      return Type.Long;
   }

   public Long eval(TemplateProperties properties) {
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
      return (double) value;
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

      LongLiteral that = (LongLiteral) o;

      return value == that.value;
   }

   @Override
   public int hashCode() {
      return (int) (value ^ (value >>> 32));
   }
}
