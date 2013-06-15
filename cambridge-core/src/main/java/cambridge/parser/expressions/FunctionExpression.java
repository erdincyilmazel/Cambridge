package cambridge.parser.expressions;

import cambridge.Cambridge;
import cambridge.ExpressionEvaluationException;
import cambridge.runtime.ExpressionContext;

import java.util.ArrayList;

/**
 * @author Erdinc Yilmazel
 * Date: Oct 31, 2009
 * Time: 1:29:09 AM
 */
public class FunctionExpression implements CambridgeExpression {
   private final String functionName;
   private CambridgeExpression[] parameters;
   private final FunctionRunner runner;

   public FunctionExpression(String functionName) {
      this.functionName = functionName;
      runner = Cambridge.getInstance().getFunctionRunner(functionName);
   }

   public void setParameters(ArrayList<CambridgeExpression> params) {
      parameters = params.toArray(new CambridgeExpression[params.size()]);
   }

   public Type getType(ExpressionContext context) throws ExpressionEvaluationException {
      Object o = eval(context);
      if (o instanceof Boolean) {
         return Type.Boolean;
      }
      if (o instanceof Integer) {
         return Type.Int;
      }
      if (o instanceof Long) {
         return Type.Long;
      }
      if (o instanceof Float) {
         return Type.Float;
      }
      if (o instanceof Double) {
         return Type.Double;
      }
      if (o instanceof String) {
         return Type.String;
      }
      return o == null ? Type.Null : Type.Object;
   }

   public Object eval(ExpressionContext context) throws ExpressionEvaluationException {
      if (runner == null) {
         throw new ExpressionEvaluationException("Unknown function " + functionName);
      }
      return runner.eval(context, parameters);
   }

   public boolean asBoolean(ExpressionContext context) throws ExpressionEvaluationException {
      Object o = eval(context);
      return o instanceof Boolean && (Boolean) o;
   }

   public int asInt(ExpressionContext context) throws ExpressionEvaluationException {
      Object o = eval(context);
      if (o instanceof Number) {
         return ((Number) o).intValue();
      }
      return 0;
   }

   public float asFloat(ExpressionContext context) throws ExpressionEvaluationException {
      Object o = eval(context);
      if (o instanceof Number) {
         return ((Number) o).floatValue();
      }

      return 0;
   }

   public double asDouble(ExpressionContext context) throws ExpressionEvaluationException {
      Object o = eval(context);
      if (o instanceof Number) {
         return ((Number) o).doubleValue();
      }
      return 0;
   }

   public long asLong(ExpressionContext context) throws ExpressionEvaluationException {
      Object o = eval(context);
      if (o instanceof Number) {
         return ((Number) o).longValue();
      }
      return 0;
   }

   public String asString(ExpressionContext context) throws ExpressionEvaluationException {
      return eval(context).toString();
   }
}