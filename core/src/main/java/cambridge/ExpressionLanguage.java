package cambridge;

import cambridge.model.Expression;

import java.util.Map;

/**
 * @author Erdinc YILMAZEL
 * @since 1/31/11
 */
public interface ExpressionLanguage {
   public Expression parse(String value) throws ExpressionParsingException;

   public String wrapExpressionAsList(String expr);
}
