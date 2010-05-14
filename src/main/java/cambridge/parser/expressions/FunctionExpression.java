package cambridge.parser.expressions;

import cambridge.ExpressionEvaluationException;
import cambridge.runtime.TemplateProperties;
import cambridge.runtime.FunctionRunner;

import java.util.ArrayList;

/**
 * User: erdinc
 * Date: Oct 31, 2009
 * Time: 1:29:09 AM
 */
public class FunctionExpression implements Expression {
   private final String functionName;
   private Expression[] parameters;
   private final FunctionRunner runner;

   public FunctionExpression(String functionName) {
      this.functionName = functionName;
      runner = FunctionRunner.getInstance(functionName);
   }

   public void setParameters(ArrayList<Expression> params) {
      parameters = params.toArray(new Expression[params.size()]);
   }

   public Type getType(TemplateProperties properties) throws ExpressionEvaluationException {
      Object o = eval(properties);
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

   public Object eval(TemplateProperties p) throws ExpressionEvaluationException {
      if(runner == null) {
         throw new ExpressionEvaluationException("Unknown function " + functionName);
      }
      return runner.eval(p, parameters);
   }

   public boolean asBoolean(TemplateProperties properties) throws ExpressionEvaluationException {
      Object o = eval(properties);
      return o instanceof Boolean && (Boolean) o;
   }

   public int asInt(TemplateProperties properties) throws ExpressionEvaluationException {
      Object o = eval(properties);
      if (o instanceof Number) {
         return ((Number) o).intValue();
      }
      return 0;
   }

   public float asFloat(TemplateProperties properties) throws ExpressionEvaluationException {
      Object o = eval(properties);
      if (o instanceof Number) {
         return ((Number) o).floatValue();
      }

      return 0;
   }

   public double asDouble(TemplateProperties properties) throws ExpressionEvaluationException {
      Object o = eval(properties);
      if (o instanceof Number) {
         return ((Number) o).doubleValue();
      }
      return 0;
   }

   public long asLong(TemplateProperties properties) throws ExpressionEvaluationException {
      Object o = eval(properties);
      if (o instanceof Number) {
         return ((Number) o).longValue();
      }
      return 0;
   }

   public String asString(TemplateProperties properties) throws ExpressionEvaluationException {
      return eval(properties).toString();
   }
}