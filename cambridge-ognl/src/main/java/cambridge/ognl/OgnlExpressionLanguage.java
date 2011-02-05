package cambridge.ognl;

import cambridge.ExpressionLanguage;
import cambridge.ExpressionParsingException;
import cambridge.model.Expression;
import ognl.Ognl;
import ognl.OgnlException;

/**
 * @author Erdinc YILMAZEL
 * @since 2/1/11
 */
public class OgnlExpressionLanguage implements ExpressionLanguage {
   public Expression parse(String value) throws ExpressionParsingException {
      try {
         return new OgnlExpression(Ognl.parseExpression(value), value);
      } catch (OgnlException e) {
         throw new ExpressionParsingException("Error parsing expression: " + value, e);
      }
   }

   public String wrapExpressionAsList(String expr) {
      return "{" + expr + "}";
   }
}
