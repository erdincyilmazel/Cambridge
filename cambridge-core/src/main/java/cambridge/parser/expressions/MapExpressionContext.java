package cambridge.parser.expressions;

import cambridge.runtime.ExpressionContext;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * @author Erdinc Yilmazel (eyilmazel@tripadvisor.com)
 * @since 6/15/13
 */
public class MapExpressionContext extends HashMap<String, Object> implements ExpressionContext
{
    private final Locale locale;

    public MapExpressionContext()
    {
        locale = null;
    }

    public MapExpressionContext(Locale locale)
    {
        this.locale = locale;
    }

    @Override
    public Object get(String name)
    {
        return super.get(name);
    }

    @Override
    public Object remove(String name)
    {
        return super.remove(name);
    }

    @Override
    public void setVariables(Map<String, Object> variables)
    {
        super.putAll(variables);
    }

    @Override
    public Locale getLocale()
    {
        return locale;
    }

    @Override
    public boolean has(String name)
    {
        return super.containsKey(name);
    }

    @Override
    public Map<String, Object> asMap()
    {
        return this;
    }
}
