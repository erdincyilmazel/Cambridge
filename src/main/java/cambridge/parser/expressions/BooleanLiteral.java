package cambridge.parser.expressions;

import cambridge.ExpressionEvaluationException;
import cambridge.runtime.TemplateProperties;

/**
 * User: erdinc
 * Date: Oct 31, 2009
 * Time: 1:09:41 AM
 */
public class BooleanLiteral implements Expression {
   boolean value;

   public BooleanLiteral(boolean value) {
      this.value = value;
   }

   @Override
   public Type getType(TemplateProperties properties) throws ExpressionEvaluationException {
      return Type.Boolean;
   }

   @Override
   public Object eval(TemplateProperties properties) {
      return value;
   }

   @Override
   public boolean asBoolean(TemplateProperties properties) throws ExpressionEvaluationException {
      return value;
   }

   @Override
   public int asInt(TemplateProperties properties) throws ExpressionEvaluationException {
      return value ? 1 : 0;
   }

   @Override
   public float asFloat(TemplateProperties properties) throws ExpressionEvaluationException {
      return value ? 1 : 0;
   }

   @Override
   public double asDouble(TemplateProperties properties) throws ExpressionEvaluationException {
      return value ? 1 : 0;
   }

   @Override
   public long asLong(TemplateProperties properties) throws ExpressionEvaluationException {
      return 0;
   }

   @Override
   public String asString(TemplateProperties properties) throws ExpressionEvaluationException {
      return "" + value;
   }
}
