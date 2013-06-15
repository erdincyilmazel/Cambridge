package org.springframework.web.servlet.view.cambridge;

import cambridge.ExpressionEvaluationException;
import cambridge.model.Expression;
import cambridge.runtime.ExpressionContext;
import org.springframework.expression.EvaluationContext;

/**
 * @author Erdinc Yilmazel (eyilmazel@tripadvisor.com)
 * @since 6/14/13
 */
public class SpringExpression implements Expression
{
    final org.springframework.expression.Expression expression;

    public SpringExpression(org.springframework.expression.Expression expression)
    {
        this.expression = expression;
    }

    @Override
    public Object eval(ExpressionContext context) throws ExpressionEvaluationException
    {
        EvaluationContext evaluationContext = (EvaluationContext) context;
        return expression.getValue(evaluationContext);
    }

    @Override
    public boolean asBoolean(ExpressionContext context) throws ExpressionEvaluationException
    {
        EvaluationContext evaluationContext = (EvaluationContext) context;
        return expression.getValue(evaluationContext, Boolean.class);
    }

    @Override
    public int asInt(ExpressionContext context) throws ExpressionEvaluationException
    {
        EvaluationContext evaluationContext = (EvaluationContext) context;
        return expression.getValue(evaluationContext, Integer.class);
    }

    @Override
    public float asFloat(ExpressionContext context) throws ExpressionEvaluationException
    {
        EvaluationContext evaluationContext = (EvaluationContext) context;
        return expression.getValue(evaluationContext, Float.class);
    }

    @Override
    public double asDouble(ExpressionContext context) throws ExpressionEvaluationException
    {
        EvaluationContext evaluationContext = (EvaluationContext) context;
        return expression.getValue(evaluationContext, Double.class);
    }

    @Override
    public long asLong(ExpressionContext context) throws ExpressionEvaluationException
    {
        EvaluationContext evaluationContext = (EvaluationContext) context;
        return expression.getValue(evaluationContext, Long.class);
    }

    @Override
    public String asString(ExpressionContext context) throws ExpressionEvaluationException
    {
        EvaluationContext evaluationContext = (EvaluationContext) context;
        return expression.getValue(evaluationContext, String.class);
    }
}
