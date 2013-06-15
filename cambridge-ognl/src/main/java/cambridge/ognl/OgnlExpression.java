package cambridge.ognl;

import cambridge.ExpressionEvaluationException;
import cambridge.model.Expression;
import cambridge.runtime.ExpressionContext;
import ognl.Ognl;
import ognl.OgnlException;

import java.util.Map;

/**
 * @author Erdinc YILMAZEL
 * @since 2/1/11
 */
public class OgnlExpression implements Expression
{
    final Object parsedExpression;
    final String expression;

    public OgnlExpression(Object parsedExpression, String expression)
    {
        this.parsedExpression = parsedExpression;
        this.expression = expression;
    }

    public Object eval(ExpressionContext context) throws ExpressionEvaluationException
    {
        try
        {
            Map<String, Object> globals = context.asMap();
            return Ognl.getValue(parsedExpression, globals, globals);
        }
        catch (OgnlException e)
        {
            throw new ExpressionEvaluationException("Error evaluating expression: " + expression, e);
        }
    }

    public boolean asBoolean(ExpressionContext context) throws ExpressionEvaluationException
    {
        try
        {
            Map<String, Object> globals = context.asMap();
            return (Boolean) Ognl.getValue(parsedExpression, globals, globals, Boolean.class);
        }
        catch (OgnlException e)
        {
            throw new ExpressionEvaluationException("Error evaluating expression: " + expression, e);
        }
    }

    public int asInt(ExpressionContext context) throws ExpressionEvaluationException
    {
        try
        {
            Map<String, Object> globals = context.asMap();
            return (Integer) Ognl.getValue(parsedExpression, globals, globals, Integer.class);
        }
        catch (OgnlException e)
        {
            throw new ExpressionEvaluationException("Error evaluating expression: " + expression, e);
        }
    }

    public float asFloat(ExpressionContext context) throws ExpressionEvaluationException
    {
        try
        {
            Map<String, Object> globals = context.asMap();
            return (Float) Ognl.getValue(parsedExpression, globals, globals, Float.class);
        }
        catch (OgnlException e)
        {
            throw new ExpressionEvaluationException("Error evaluating expression: " + expression, e);
        }
    }

    public double asDouble(ExpressionContext context) throws ExpressionEvaluationException
    {
        try
        {
            Map<String, Object> globals = context.asMap();
            return (Double) Ognl.getValue(parsedExpression, globals, globals, Double.class);
        }
        catch (OgnlException e)
        {
            throw new ExpressionEvaluationException("Error evaluating expression: " + expression, e);
        }
    }

    public long asLong(ExpressionContext context) throws ExpressionEvaluationException
    {
        try
        {
            Map<String, Object> globals = context.asMap();
            return (Long) Ognl.getValue(parsedExpression, globals, globals, Long.class);
        }
        catch (OgnlException e)
        {
            throw new ExpressionEvaluationException("Error evaluating expression: " + expression, e);
        }
    }

    public String asString(ExpressionContext context) throws ExpressionEvaluationException
    {
        return eval(context).toString();
    }
}
