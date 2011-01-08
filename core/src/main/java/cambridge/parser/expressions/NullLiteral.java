package cambridge.parser.expressions;

import cambridge.ExpressionEvaluationException;
import cambridge.runtime.TemplateBindings;

/**
 * User: erdinc
 * Date: Oct 31, 2009
 * Time: 1:09:57 AM
 */
public class NullLiteral implements Expression {
   public static final NullLiteral instance = new NullLiteral();

   private NullLiteral() {
   }

   public Type getType(TemplateBindings bindings) throws ExpressionEvaluationException {
      return Type.Null;
   }

   public Object eval(TemplateBindings bindings) {
      return null;
   }

   public boolean asBoolean(TemplateBindings bindings) throws ExpressionEvaluationException {
      return false;
   }

   public int asInt(TemplateBindings bindings) throws ExpressionEvaluationException {
      return 0;
   }

   public float asFloat(TemplateBindings bindings) throws ExpressionEvaluationException {
      return 0;
   }

   public double asDouble(TemplateBindings bindings) throws ExpressionEvaluationException {
      return 0;
   }

   public long asLong(TemplateBindings bindings) throws ExpressionEvaluationException {
      return 0;
   }

   public String asString(TemplateBindings bindings) throws ExpressionEvaluationException {
      return "null";
   }
}
