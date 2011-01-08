package cambridge.parser.expressions;

import cambridge.ExpressionEvaluationException;
import cambridge.runtime.TemplateBindings;
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

   public Type getType(TemplateBindings bindings) throws ExpressionEvaluationException {
      Object o = eval(bindings);
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

   public Object eval(TemplateBindings p) throws ExpressionEvaluationException {
      if(runner == null) {
         throw new ExpressionEvaluationException("Unknown function " + functionName);
      }
      return runner.eval(p, parameters);
   }

   public boolean asBoolean(TemplateBindings bindings) throws ExpressionEvaluationException {
      Object o = eval(bindings);
      return o instanceof Boolean && (Boolean) o;
   }

   public int asInt(TemplateBindings bindings) throws ExpressionEvaluationException {
      Object o = eval(bindings);
      if (o instanceof Number) {
         return ((Number) o).intValue();
      }
      return 0;
   }

   public float asFloat(TemplateBindings bindings) throws ExpressionEvaluationException {
      Object o = eval(bindings);
      if (o instanceof Number) {
         return ((Number) o).floatValue();
      }

      return 0;
   }

   public double asDouble(TemplateBindings bindings) throws ExpressionEvaluationException {
      Object o = eval(bindings);
      if (o instanceof Number) {
         return ((Number) o).doubleValue();
      }
      return 0;
   }

   public long asLong(TemplateBindings bindings) throws ExpressionEvaluationException {
      Object o = eval(bindings);
      if (o instanceof Number) {
         return ((Number) o).longValue();
      }
      return 0;
   }

   public String asString(TemplateBindings bindings) throws ExpressionEvaluationException {
      return eval(bindings).toString();
   }
}