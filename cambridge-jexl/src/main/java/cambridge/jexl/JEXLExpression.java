package cambridge.jexl;

import java.util.Map;

import org.apache.commons.jexl2.MapContext;

import cambridge.ExpressionEvaluationException;
import cambridge.model.Expression;

/**
 * @author Jon Scott Stevens
 */
public class JEXLExpression implements Expression {
    final org.apache.commons.jexl2.Expression compiledExpression;
    final String expression;
    final int line;
    final int col;

    public JEXLExpression(org.apache.commons.jexl2.Expression compiledExpression, String expression, int line, int col) {
        this.compiledExpression = compiledExpression;
        this.expression = expression;
        this.line = line;
        this.col = col;
    }

    public Object eval(Map<String, Object> globals) throws ExpressionEvaluationException {
        try {
        	return this.compiledExpression.evaluate(new MapContext(globals));
        } catch (Exception e) {
            throw new ExpressionEvaluationException("Error evaluating exception on line: " + line + ", column: " + col + ", expression: " + expression, e);
        }
    }

    public boolean asBoolean(Map<String, Object> bindings) throws ExpressionEvaluationException {
        Object o = eval(bindings);

        if (o instanceof Boolean) {
            return (Boolean) o;
        }
        if (o instanceof Number) {
            return ((Number) o).intValue() != 0;
        }
        return o instanceof String && !"".equals(o);
    }

    public int asInt(Map<String, Object> bindings) throws ExpressionEvaluationException {
        Object o = eval(bindings);
        if (o instanceof Number) {
            return ((Number) o).intValue();
        }
        return 0;
    }

    public float asFloat(Map<String, Object> bindings) throws ExpressionEvaluationException {
        Object o = eval(bindings);
        if (o instanceof Number) {
            return ((Number) o).floatValue();
        }

        return 0;
    }

    public double asDouble(Map<String, Object> bindings) throws ExpressionEvaluationException {
        Object o = eval(bindings);
        if (o instanceof Number) {
            return ((Number) o).doubleValue();
        }
        return 0;
    }

    public long asLong(Map<String, Object> bindings) throws ExpressionEvaluationException {
        Object o = eval(bindings);
        if (o instanceof Number) {
            return ((Number) o).longValue();
        }
        return 0;
    }

    public String asString(Map<String, Object> bindings) throws ExpressionEvaluationException {
        return eval(bindings).toString();
    }
}
