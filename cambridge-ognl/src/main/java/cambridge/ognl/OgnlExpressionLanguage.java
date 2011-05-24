package cambridge.ognl;

import cambridge.ExpressionLanguage;
import cambridge.ExpressionParsingException;
import cambridge.Expressions;
import cambridge.model.Expression;
import ognl.Ognl;
import ognl.OgnlException;

/**
 * @author Erdinc YILMAZEL
 * @since 2/1/11
 */
public class OgnlExpressionLanguage implements ExpressionLanguage {
   public static void register() {
      Expressions.registerExpressionLanguage("ognl", OgnlExpressionLanguage.class);
   }

   public Expression parse(String expressionString) throws ExpressionParsingException {

      try {
         return new OgnlExpression(Ognl.parseExpression(expressionString), expressionString);
      } catch (OgnlException e) {
         throw new ExpressionParsingException("Error parsing expression: " + expressionString, e);
      }
   }

   public String wrapExpressionAsList(String expr) {
      return "{" + expr + "}";
   }
}
