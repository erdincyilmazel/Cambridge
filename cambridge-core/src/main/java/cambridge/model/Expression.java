package cambridge.model;

import cambridge.ExpressionEvaluationException;
import cambridge.runtime.ExpressionContext;

/**
 * @author Erdinc Yilmazel
 * Date: Oct 31, 2009
 * Time: 12:34:28 AM
 */
public interface Expression {
    public Object eval(ExpressionContext context) throws ExpressionEvaluationException;

    public boolean asBoolean(ExpressionContext context) throws ExpressionEvaluationException;

    public int asInt(ExpressionContext context) throws ExpressionEvaluationException;

    public float asFloat(ExpressionContext context) throws ExpressionEvaluationException;

    public double asDouble(ExpressionContext context) throws ExpressionEvaluationException;

    public long asLong(ExpressionContext context) throws ExpressionEvaluationException;

    public String asString(ExpressionContext context) throws ExpressionEvaluationException;
}
