package cambridge.jexl;

import org.apache.commons.jexl2.DebugInfo;
import org.apache.commons.jexl2.JexlEngine;
import org.apache.commons.jexl2.JexlException;

import cambridge.ExpressionLanguage;
import cambridge.ExpressionParsingException;
import cambridge.Expressions;
import cambridge.model.Expression;

/**
 * @author Jon Scott Stevens
 */
public class JexlExpressionLanguage implements ExpressionLanguage {
    public static void register() {
        Expressions.registerExpressionLanguage("jexl", JexlExpressionLanguage.class);
    }

    private JexlEngine engine = new JexlEngine();

    public JexlExpressionLanguage() {
        engine.setLenient(true);
        engine.setSilent(false);
    }

    public JexlEngine getEngine() {
        return engine;
    }

    public Expression parse(String expressionString, int line, int column) throws ExpressionParsingException {
        org.apache.commons.jexl2.Expression compiledExpression;
        try {
            DebugInfo debug = new DebugInfo(expressionString, line, column);
            compiledExpression = engine.createExpression(expressionString, debug);
        } catch (JexlException e) {
            throw new ExpressionParsingException(line, column, expressionString, e);
        }

        return new JEXLExpression(compiledExpression, expressionString, line, column);
    }

    public String wrapExpressionAsList(String expr) {
        return "[" + expr + "]";
    }
}
