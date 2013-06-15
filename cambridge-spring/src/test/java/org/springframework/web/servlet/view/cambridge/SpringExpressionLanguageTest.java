package org.springframework.web.servlet.view.cambridge;

import cambridge.model.Expression;
import cambridge.runtime.ExpressionContext;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Erdinc Yilmazel (eyilmazel@tripadvisor.com)
 * @since 6/14/13
 */
public class SpringExpressionLanguageTest
{
    SpringExpressionLanguage language = new SpringExpressionLanguage();

    @Test
    public void testParseSimple() throws Exception
    {
        ExpressionContext context = language.createNewContext();
        Expression expression = language.parse("5 + 8", 1, 1);

        int i = expression.asInt(context);
        assertEquals(13, i);
    }

    @Test
    public void testParseVariable() throws Exception
    {
        ExpressionContext context = language.createNewContext();
        context.set("name", "Cambridge");
        Expression expression = language.parse("#name", 1, 1);

        String name = expression.asString(context);
        assertEquals(name, "Cambridge");
    }
}
