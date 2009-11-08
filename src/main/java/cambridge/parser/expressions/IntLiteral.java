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

   @Override
   public Type getType(TemplateProperties properties) throws ExpressionEvaluationException {
      return Type.Int;
   }

   @Override
   public Integer eval(TemplateProperties properties) {
      return value;
   }

   @Override
   public boolean asBoolean(TemplateProperties properties) throws ExpressionEvaluationException {
      return 0 != value;
   }

   @Override
   public int asInt(TemplateProperties properties) throws ExpressionEvaluationException {
      return value;
   }

   @Override
   public float asFloat(TemplateProperties properties) throws ExpressionEvaluationException {
      return value;
   }

   @Override
   public double asDouble(TemplateProperties properties) throws ExpressionEvaluationException {
      return value;
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
