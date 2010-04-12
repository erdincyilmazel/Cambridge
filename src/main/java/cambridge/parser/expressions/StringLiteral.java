package cambridge.parser.expressions;

import cambridge.ExpressionEvaluationException;
import cambridge.runtime.TemplateProperties;

/**
 * User: erdinc
 * Date: Oct 31, 2009
 * Time: 1:07:43 AM
 */
public class StringLiteral implements Expression {
   String value;

   public StringLiteral(String value) {
      value = value.replaceAll("\\\\n", "\n").replaceAll("\\\\t", "\t").replaceAll("\\\\r", "\r");

      if (value.length() <= 2) {
         this.value = "";
      } else {
         this.value = value.substring(1, value.length() - 1);
      }
   }

   public Type getType(TemplateProperties properties) throws ExpressionEvaluationException {
      return Type.String;
   }

   public String eval(TemplateProperties properties) {
      return value;
   }

   public boolean asBoolean(TemplateProperties properties) throws ExpressionEvaluationException {
      return !value.equals("");
   }

   public int asInt(TemplateProperties properties) throws ExpressionEvaluationException {
      try {
         return Integer.parseInt(value);
      } catch (NumberFormatException e) {
         return 0;
      }
   }

   public float asFloat(TemplateProperties properties) throws ExpressionEvaluationException {
      try {
         return Float.parseFloat(value);
      } catch (NumberFormatException e) {
         return 0;
      }
   }

   public double asDouble(TemplateProperties properties) throws ExpressionEvaluationException {
      try {
         return Double.parseDouble(value);
      } catch (NumberFormatException e) {
         return 0;
      }
   }

   public long asLong(TemplateProperties properties) throws ExpressionEvaluationException {
      try {
         return Long.parseLong(value);
      } catch (NumberFormatException e) {
         return 0;
      }
   }

   public String asString(TemplateProperties properties) throws ExpressionEvaluationException {
      return value;
   }

   public String toString() {
      return value;
   }
}
