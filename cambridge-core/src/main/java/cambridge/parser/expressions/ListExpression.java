package cambridge.parser.expressions;

import cambridge.ExpressionEvaluationException;
import cambridge.model.Expression;
import cambridge.runtime.ExpressionContext;

import java.util.ArrayList;

/**
 * @author Erdinc Yilmazel
 * Date: Apr 12, 2010
 * Time: 11:52:13 PM
 */
public class ListExpression extends ArrayList<CambridgeExpression> implements CambridgeExpression {
   public Type getType(ExpressionContext context) throws ExpressionEvaluationException {
      return Type.Object;
   }

   public Object eval(ExpressionContext context) throws ExpressionEvaluationException {
      ArrayList<Object> list = new ArrayList<Object>();
      for (Expression e : this) {
         list.add(e.eval(context));
      }
      return list;
   }

   public boolean asBoolean(ExpressionContext context) throws ExpressionEvaluationException {
      return false;
   }

   public int asInt(ExpressionContext context) throws ExpressionEvaluationException {
      return 0;
   }

   public float asFloat(ExpressionContext context) throws ExpressionEvaluationException {
      return 0;
   }

   public double asDouble(ExpressionContext context) throws ExpressionEvaluationException {
      return 0;
   }

   public long asLong(ExpressionContext context) throws ExpressionEvaluationException {
      return 0;
   }

   public String asString(ExpressionContext context) throws ExpressionEvaluationException {
      return toString();
   }
}
