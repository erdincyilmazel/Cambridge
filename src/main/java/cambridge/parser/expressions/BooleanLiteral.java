package cambridge.parser.expressions;

import cambridge.ExpressionEvaluationException;
import cambridge.runtime.TemplateProperties;

/**
 * User: erdinc
 * Date: Oct 31, 2009
 * Time: 1:09:41 AM
 */
public class BooleanLiteral implements Expression {
   private final boolean value;

   public BooleanLiteral(boolean value) {
      this.value = value;
   }

   public Type getType(TemplateProperties properties) throws ExpressionEvaluationException {
      return Type.Boolean;
   }

   public Object eval(TemplateProperties properties) {
      return value;
   }

   public boolean asBoolean(TemplateProperties properties) throws ExpressionEvaluationException {
      return value;
   }

   public int asInt(TemplateProperties properties) throws ExpressionEvaluationException {
      return value ? 1 : 0;
   }

   public float asFloat(TemplateProperties properties) throws ExpressionEvaluationException {
      return value ? 1 : 0;
   }

   public double asDouble(TemplateProperties properties) throws ExpressionEvaluationException {
      return value ? 1 : 0;
   }

   public long asLong(TemplateProperties properties) throws ExpressionEvaluationException {
      return 0;
   }

   public String asString(TemplateProperties properties) throws ExpressionEvaluationException {
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
