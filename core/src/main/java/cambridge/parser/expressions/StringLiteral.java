package cambridge.parser.expressions;

import cambridge.ExpressionEvaluationException;
import cambridge.runtime.TemplateBindings;

/**
 * User: erdinc
 * Date: Oct 31, 2009
 * Time: 1:07:43 AM
 */
public class StringLiteral implements Expression {
   private final String value;

   public StringLiteral(String value) {
      this.value = value;
   }

   public static StringLiteral fromText(String value) {
      value = value.replaceAll("\\\\n", "\n").replaceAll("\\\\t", "\t").replaceAll("\\\\r", "\r");

      if (value.length() <= 2) {
         return new StringLiteral("");
      } else {
         return new StringLiteral(value.substring(1, value.length() - 1));
      }
   }

   public Type getType(TemplateBindings bindings) throws ExpressionEvaluationException {
      return Type.String;
   }

   public String eval(TemplateBindings bindings) {
      return value;
   }

   public boolean asBoolean(TemplateBindings bindings) throws ExpressionEvaluationException {
      return !value.equals("");
   }

   public int asInt(TemplateBindings bindings) throws ExpressionEvaluationException {
      try {
         return Integer.parseInt(value);
      } catch (NumberFormatException e) {
         return 0;
      }
   }

   public float asFloat(TemplateBindings bindings) throws ExpressionEvaluationException {
      try {
         return Float.parseFloat(value);
      } catch (NumberFormatException e) {
         return 0;
      }
   }

   public double asDouble(TemplateBindings bindings) throws ExpressionEvaluationException {
      try {
         return Double.parseDouble(value);
      } catch (NumberFormatException e) {
         return 0;
      }
   }

   public long asLong(TemplateBindings bindings) throws ExpressionEvaluationException {
      try {
         return Long.parseLong(value);
      } catch (NumberFormatException e) {
         return 0;
      }
   }

   public String asString(TemplateBindings bindings) throws ExpressionEvaluationException {
      return value;
   }

   public String toString() {
      return value;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      StringLiteral that = (StringLiteral) o;

      return !(value != null ? !value.equals(that.value) : that.value != null);
   }

   @Override
   public int hashCode() {
      return value != null ? value.hashCode() : 0;
   }
}
