package cambridge.parser.expressions;

import cambridge.ExpressionEvaluationException;
import cambridge.runtime.ExpressionContext;


/**
 * @author Erdinc Yilmazel
 * Date: Oct 31, 2009
 * Time: 1:09:57 AM
 */
public class NullLiteral implements CambridgeExpression {
   public static final NullLiteral instance = new NullLiteral();

   private NullLiteral() {
   }

   public Type getType(ExpressionContext context) throws ExpressionEvaluationException {
      return Type.Null;
   }

   public Object eval(ExpressionContext context) {
      return null;
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
      return "null";
   }
}
