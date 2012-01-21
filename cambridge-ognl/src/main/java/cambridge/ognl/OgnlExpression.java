package cambridge.ognl;

import java.util.Map;

import ognl.Ognl;
import ognl.OgnlException;
import cambridge.ExpressionEvaluationException;
import cambridge.model.Expression;

/**
 * @author Erdinc YILMAZEL
 * @since 2/1/11
 */
public class OgnlExpression implements Expression {
   final Object parsedExpression;
   final String expression;

   public OgnlExpression(Object parsedExpression, String expression) {
      this.parsedExpression = parsedExpression;
      this.expression = expression;
   }

   public Object eval(Map<String, Object> globals) throws ExpressionEvaluationException {
      try {
         return Ognl.getValue(parsedExpression, globals, (Object) globals);
      } catch (OgnlException e) {
         throw new ExpressionEvaluationException("Error evaluating expression: " + expression, e);
      }
   }

   public boolean asBoolean(Map<String, Object> bindings) throws ExpressionEvaluationException {
      Object o = eval(bindings);

      if (o instanceof Boolean) {
         return (Boolean) o;
      }
      if (o instanceof Number) {
         return ((Number) o).intValue() != 0;
      }
      return o instanceof String && !"".equals(o);
   }

   public int asInt(Map<String, Object> bindings) throws ExpressionEvaluationException {
      Object o = eval(bindings);
      if (o instanceof Number) {
         return ((Number) o).intValue();
      }
      return 0;
   }

   public float asFloat(Map<String, Object> bindings) throws ExpressionEvaluationException {
      Object o = eval(bindings);
      if (o instanceof Number) {
         return ((Number) o).floatValue();
      }

      return 0;
   }

   public double asDouble(Map<String, Object> bindings) throws ExpressionEvaluationException {
      Object o = eval(bindings);
      if (o instanceof Number) {
         return ((Number) o).doubleValue();
      }
      return 0;
   }

   public long asLong(Map<String, Object> bindings) throws ExpressionEvaluationException {
      Object o = eval(bindings);
      if (o instanceof Number) {
         return ((Number) o).longValue();
      }
      return 0;
   }

   public String asString(Map<String, Object> bindings) throws ExpressionEvaluationException {
      return eval(bindings).toString();
   }
}
