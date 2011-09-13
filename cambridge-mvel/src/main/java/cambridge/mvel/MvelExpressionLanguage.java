package cambridge.mvel;

import cambridge.ExpressionLanguage;
import cambridge.ExpressionParsingException;
import cambridge.Expressions;
import cambridge.model.Expression;
import org.mvel2.MVEL;
import org.mvel2.ParserContext;

import java.io.Serializable;

/**
 * @author Erdinc YILMAZEL
 * @since 2/1/11
 */
public class MvelExpressionLanguage implements ExpressionLanguage {
    public static void register() {
        Expressions.registerExpressionLanguage("mvel", MvelExpressionLanguage.class);
    }
    
    ParserContext context = ParserContext.create();

    public ParserContext getParserContext() {
        return context;
    }

    public Expression parse(String expressionString, int line, int column) throws ExpressionParsingException {
        Serializable compiledExpression = MVEL.compileExpression(expressionString, context);

        return new MVELExpression(compiledExpression, expressionString, line, column);
    }

    public String wrapExpressionAsList(String expr) {
        return "[" + expr + "]";
    }
}
