package cambridge;

import cambridge.model.Expression;
import cambridge.parser.expressions.CambridgeExpressionLanguage;

import java.util.Map;

/**
 * User: erdinc
 * Date: Nov 3, 2009
 * Time: 1:42:15 AM
 */
public class Expressions {
   public static ExpressionLanguage expressionLanguage = new CambridgeExpressionLanguage();

   public static final String CURRENT_OBJECT = "self";
   public static final String PARENT_OBJECT = "super";
   public static final String ITER_OBJECT = "iter";

   public static Expression parse(String ex) throws ExpressionParsingException {
      return expressionLanguage.parse(ex);
   }
}
