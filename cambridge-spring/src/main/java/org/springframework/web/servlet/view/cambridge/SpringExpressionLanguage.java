package org.springframework.web.servlet.view.cambridge;

import cambridge.ExpressionLanguage;
import cambridge.ExpressionParsingException;
import cambridge.model.Expression;
import cambridge.parser.expressions.CambridgeExpressionParsingException;
import cambridge.runtime.ExpressionContext;
import org.springframework.expression.ParseException;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.util.Locale;

/**
 * @author Erdinc Yilmazel (eyilmazel@tripadvisor.com)
 * @since 6/14/13
 */
public class SpringExpressionLanguage implements ExpressionLanguage
{
    SpelExpressionParser parser = new SpelExpressionParser();

    @Override
    public Expression parse(String expressionString, int line, int column) throws ExpressionParsingException
    {
        try
        {
            org.springframework.expression.Expression expression = parser.parseExpression(expressionString);

            return new SpringExpression(expression);
        }
        catch (ParseException e)
        {
            throw new CambridgeExpressionParsingException(line, column, expressionString, e);
        }
    }

    @Override
    public String wrapExpressionAsList(String expr)
    {
        return "{" + expr + "}";
    }

    @Override
    public ExpressionContext createNewContext(Locale locale)
    {
        return new SpringExpressionContext(locale);
    }

    @Override
    public ExpressionContext createNewContext()
    {
        return new SpringExpressionContext(null);
    }
}
