package cambridge.parser.expressions;

import cambridge.ExpressionEvaluationException;
import cambridge.runtime.TemplateProperties;

/**
 * User: erdinc
 * Date: Oct 31, 2009
 * Time: 1:09:57 AM
 */
public class NullLiteral implements Expression {
   public static NullLiteral instance = new NullLiteral();

   private NullLiteral() {
   }

   @Override
   public Type getType(TemplateProperties properties) throws ExpressionEvaluationException {
      return Type.Null;
   }

   @Override
   public Object eval(TemplateProperties properties) {
      return null;
   }

   @Override
   public boolean asBoolean(TemplateProperties properties) throws ExpressionEvaluationException {
      return false;
   }

   @Override
   public int asInt(TemplateProperties properties) throws ExpressionEvaluationException {
      return 0;
   }

   @Override
   public float asFloat(TemplateProperties properties) throws ExpressionEvaluationException {
      return 0;
   }

   @Override
   public double asDouble(TemplateProperties properties) throws ExpressionEvaluationException {
      return 0;
   }

   @Override
   public long asLong(TemplateProperties properties) throws ExpressionEvaluationException {
      return 0;
   }

   @Override
   public String asString(TemplateProperties properties) throws ExpressionEvaluationException {
      return "null";
   }
}
