package cambridge.behaviors;

import cambridge.ExpressionEvaluationException;
import cambridge.TagBehavior;
import cambridge.model.Expression;

import java.util.Map;

/**
 * @author Erdinc Yilmazel
 * Date: Oct 31, 2009
 * Time: 7:10:31 PM
 */
public abstract class ConditionalTagBehavior implements TagBehavior {
    public enum ConditionType {
        FIRST,
        ALTERNATE,
        DEFAULT
    }

    final Expression expression;
    final int line;
    final int col;

    public ConditionalTagBehavior(Expression e, int line, int col) {
        expression = e;
        this.line = line;
        this.col = col;
    }

    public ConditionalTagBehavior(int line, int col) {
        this(null, line, col);
    }

    public boolean conditionMet(Map<String, Object> bindings) throws ExpressionEvaluationException {
        return expression == null || expression.asBoolean(bindings);
    }

    public abstract ConditionType getType();

    public abstract String getValidationError();

    public Expression getExpression() {
        return expression;
    }
}
