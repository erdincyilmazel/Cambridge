package cambridge.parser.expressions;

import cambridge.ExpressionEvaluationException;

import java.util.Map;

/**
 * User: erdinc
 * Date: Oct 31, 2009
 * Time: 1:07:43 AM
 */
public class StringLiteral implements Expression {
   String value;

   public StringLiteral(String value) {
      if (value.length() <= 2) {
         this.value = "";
      } else {
         this.value = value.substring(1, value.length() - 1);
      }
   }

   @Override
   public Type getType(Map<String, Object> properties) throws ExpressionEvaluationException {
      return Type.String;
   }

   @Override
   public String eval(Map<String, Object> properties) {
      return value;
   }

   @Override
   public boolean asBoolean(Map<String, Object> properties) throws ExpressionEvaluationException {
      return !value.equals("");
   }

   @Override
   public int asInt(Map<String, Object> properties) throws ExpressionEvaluationException {
      try {
         return Integer.parseInt(value);
      } catch (NumberFormatException e) {
         return 0;
      }
   }

   @Override
   public float asFloat(Map<String, Object> properties) throws ExpressionEvaluationException {
      try {
         return Float.parseFloat(value);
      } catch (NumberFormatException e) {
         return 0;
      }
   }

   @Override
   public double asDouble(Map<String, Object> properties) throws ExpressionEvaluationException {
      try {
         return Double.parseDouble(value);
      } catch (NumberFormatException e) {
         return 0;
      }
   }

   @Override
   public long asLong(Map<String, Object> properties) throws ExpressionEvaluationException {
      try {
         return Long.parseLong(value);
      } catch (NumberFormatException e) {
         return 0;
      }
   }

   @Override
   public String asString(Map<String, Object> properties) throws ExpressionEvaluationException {
      return value;
   }
}
