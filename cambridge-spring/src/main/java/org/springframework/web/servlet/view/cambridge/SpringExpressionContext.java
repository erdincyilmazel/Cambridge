package org.springframework.web.servlet.view.cambridge;

import cambridge.runtime.ExpressionContext;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.Locale;
import java.util.Map;

/**
* @author Erdinc Yilmazel (eyilmazel@tripadvisor.com)
* @since 6/15/13
*/
public class SpringExpressionContext extends StandardEvaluationContext implements ExpressionContext
{
    Locale locale;

    public SpringExpressionContext()
    {
    }

    public SpringExpressionContext(Locale locale)
    {
        this.locale = locale;
    }

    @Override
    public Object get(String name)
    {
        return lookupVariable(name);
    }

    @Override
    public Object put(String name, Object value)
    {
        setVariable(name, value);
        return value;
    }

    @Override
    public Object remove(String name)
    {
        Object existing = lookupVariable(name);
        setVariable(name, null);
        return existing;
    }

    @Override
    public Locale getLocale()
    {
        return locale;
    }

    @Override
    public boolean has(String name)
    {
        return lookupVariable(name) != null;
    }

    @Override
    public Map<String, Object> asMap()
    {
        return null;
    }
}
