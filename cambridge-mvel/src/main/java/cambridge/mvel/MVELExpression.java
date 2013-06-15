package cambridge.mvel;

import cambridge.ExpressionEvaluationException;
import cambridge.model.Expression;
import cambridge.runtime.ExpressionContext;
import org.mvel2.MVEL;

import java.io.Serializable;

/**
 * @author Erdinc YILMAZEL
 * @since 2/1/11
 */
public class MVELExpression implements Expression {
    final Serializable compiledExpression;
    final String expression;
    final int line;
    final int col;

    public MVELExpression(Serializable compiledExpression, String expression, int line, int col) {
        this.compiledExpression = compiledExpression;
        this.expression = expression;
        this.line = line;
        this.col = col;
    }

    public Object eval(ExpressionContext context) throws ExpressionEvaluationException {
        //VariableResolverFactory factory = new MapVariableResolverFactory(globals);
        try {
            return MVEL.executeExpression(compiledExpression, context.asMap());
        } catch (Exception e) {
            throw new ExpressionEvaluationException("Error evaluating exception on line: " + line + ", column: " + col + ", expression: " + expression, e);
        }
    }

    public boolean asBoolean(ExpressionContext context) throws ExpressionEvaluationException {
        Object o = eval(context);

        if (o instanceof Boolean) {
            return (Boolean) o;
        }
        if (o instanceof Number) {
            return ((Number) o).intValue() != 0;
        }
        return o instanceof String && !"".equals(o);
    }

    public int asInt(ExpressionContext context) throws ExpressionEvaluationException {
        Object o = eval(context);
        if (o instanceof Number) {
            return ((Number) o).intValue();
        }
        return 0;
    }

    public float asFloat(ExpressionContext context) throws ExpressionEvaluationException {
        Object o = eval(context);
        if (o instanceof Number) {
            return ((Number) o).floatValue();
        }

        return 0;
    }

    public double asDouble(ExpressionContext context) throws ExpressionEvaluationException {
        Object o = eval(context);
        if (o instanceof Number) {
            return ((Number) o).doubleValue();
        }
        return 0;
    }

    public long asLong(ExpressionContext context) throws ExpressionEvaluationException {
        Object o = eval(context);
        if (o instanceof Number) {
            return ((Number) o).longValue();
        }
        return 0;
    }

    public String asString(ExpressionContext context) throws ExpressionEvaluationException {
        return eval(context).toString();
    }
}
