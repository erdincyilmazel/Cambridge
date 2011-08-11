package cambridge.model;

import cambridge.ExpressionEvaluationException;

import java.util.Map;

/**
 * User: erdinc
 * Date: Oct 31, 2009
 * Time: 12:34:28 AM
 */
public interface Expression {
    public Object eval(Map<String, Object> globals) throws ExpressionEvaluationException;

    public boolean asBoolean(Map<String, Object> globals) throws ExpressionEvaluationException;

    public int asInt(Map<String, Object> globals) throws ExpressionEvaluationException;

    public float asFloat(Map<String, Object> globals) throws ExpressionEvaluationException;

    public double asDouble(Map<String, Object> globals) throws ExpressionEvaluationException;

    public long asLong(Map<String, Object> globals) throws ExpressionEvaluationException;

    public String asString(Map<String, Object> globals) throws ExpressionEvaluationException;
}
