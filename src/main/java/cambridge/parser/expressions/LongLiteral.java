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

   @Override
   public Type getType(TemplateProperties properties) throws ExpressionEvaluationException {
      return Type.Long;
   }

   @Override
   public Long eval(TemplateProperties properties) {
      return value;
   }

   @Override
   public boolean asBoolean(TemplateProperties properties) throws ExpressionEvaluationException {
      return value != 0;
   }

   @Override
   public int asInt(TemplateProperties properties) throws ExpressionEvaluationException {
      return (int) value;
   }

   @Override
   public float asFloat(TemplateProperties properties) throws ExpressionEvaluationException {
      return (float) value;
   }

   @Override
   public double asDouble(TemplateProperties properties) throws ExpressionEvaluationException {
      return (double) value;
   }

   @Override
   public long asLong(TemplateProperties properties) throws ExpressionEvaluationException {
      return value;
   }

   @Override
   public String asString(TemplateProperties properties) throws ExpressionEvaluationException {
      return "" + value;
   }
}
