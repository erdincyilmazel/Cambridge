package cambridge.ognl;

import cambridge.ExpressionLanguage;
import cambridge.ExpressionParsingException;
import cambridge.Expressions;
import cambridge.model.Expression;
import cambridge.parser.expressions.MapExpressionContext;
import cambridge.runtime.ExpressionContext;
import ognl.Ognl;
import ognl.OgnlException;

import java.util.Locale;

/**
 * @author Erdinc YILMAZEL
 * @since 2/1/11
 */
public class OgnlExpressionLanguage implements ExpressionLanguage {

    public static void register() {
        Expressions.registerExpressionLanguage("ognl", OgnlExpressionLanguage.class);
    }

    public Expression parse(String expressionString, int line, int col) throws ExpressionParsingException {

        try {
            return new OgnlExpression(Ognl.parseExpression(expressionString), expressionString);
        } catch (OgnlException e) {
            throw new ExpressionParsingException(line, col, "Error parsing expression on line: " + line + ", column: " + col + ", expression: " + expressionString, e);
        }
    }

    public String wrapExpressionAsList(String expr) {
        return "{" + expr + "}";
    }

    @Override
    public ExpressionContext createNewContext(Locale locale)
    {
        return new MapExpressionContext(locale);
    }

    @Override
    public ExpressionContext createNewContext()
    {
        return new MapExpressionContext();
    }
}
