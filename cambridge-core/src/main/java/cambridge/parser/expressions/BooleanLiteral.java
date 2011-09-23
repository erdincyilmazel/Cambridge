package cambridge.parser.expressions;

import cambridge.ExpressionEvaluationException;

import java.util.Map;

/**
 * @author Erdinc Yilmazel
 * Date: Oct 31, 2009
 * Time: 1:09:41 AM
 */
public class BooleanLiteral implements CambridgeExpression {
   private final boolean value;

   public BooleanLiteral(boolean value) {
      this.value = value;
   }

   public Type getType(Map<String, Object> bindings) throws ExpressionEvaluationException {
      return Type.Boolean;
   }

   public Object eval(Map<String, Object> bindings) {
      return value;
   }

   public boolean asBoolean(Map<String, Object> bindings) throws ExpressionEvaluationException {
      return value;
   }

   public int asInt(Map<String, Object> bindings) throws ExpressionEvaluationException {
      return value ? 1 : 0;
   }

   public float asFloat(Map<String, Object> bindings) throws ExpressionEvaluationException {
      return value ? 1 : 0;
   }

   public double asDouble(Map<String, Object> bindings) throws ExpressionEvaluationException {
      return value ? 1 : 0;
   }

   public long asLong(Map<String, Object> bindings) throws ExpressionEvaluationException {
      return 0;
   }

   public String asString(Map<String, Object> bindings) throws ExpressionEvaluationException {
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
