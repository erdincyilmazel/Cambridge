package cambridge.parser.expressions;

import cambridge.ExpressionEvaluationException;
import cambridge.runtime.TemplateProperties;

/**
 * User: erdinc
 * Date: Oct 31, 2009
 * Time: 1:09:06 AM
 */
public class DoubleLiteral implements Expression {
   double value;

   public DoubleLiteral(double value) {
      this.value = value;
   }

   @Override
   public Type getType(TemplateProperties properties) throws ExpressionEvaluationException {
      return Type.Double;
   }

   @Override
   public Object eval(TemplateProperties properties) {
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
      return value;
   }

   @Override
   public long asLong(TemplateProperties properties) throws ExpressionEvaluationException {
      return (long) value;
   }

   @Override
   public String asString(TemplateProperties properties) throws ExpressionEvaluationException {
      return "" + value;
   }
}
