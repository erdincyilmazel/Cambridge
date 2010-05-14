package cambridge.parser.expressions;

import cambridge.ExpressionEvaluationException;
import cambridge.runtime.TemplateProperties;

/**
 * User: erdinc
 * Date: Oct 31, 2009
 * Time: 1:09:57 AM
 */
public class NullLiteral implements Expression {
   public static final NullLiteral instance = new NullLiteral();

   private NullLiteral() {
   }

   public Type getType(TemplateProperties properties) throws ExpressionEvaluationException {
      return Type.Null;
   }

   public Object eval(TemplateProperties properties) {
      return null;
   }

   public boolean asBoolean(TemplateProperties properties) throws ExpressionEvaluationException {
      return false;
   }

   public int asInt(TemplateProperties properties) throws ExpressionEvaluationException {
      return 0;
   }

   public float asFloat(TemplateProperties properties) throws ExpressionEvaluationException {
      return 0;
   }

   public double asDouble(TemplateProperties properties) throws ExpressionEvaluationException {
      return 0;
   }

   public long asLong(TemplateProperties properties) throws ExpressionEvaluationException {
      return 0;
   }

   public String asString(TemplateProperties properties) throws ExpressionEvaluationException {
      return "null";
   }
}
