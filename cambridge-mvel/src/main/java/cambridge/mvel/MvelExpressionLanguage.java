package cambridge.mvel;

import cambridge.ExpressionLanguage;
import cambridge.ExpressionParsingException;
import cambridge.Expressions;
import cambridge.model.Expression;
import org.mvel2.MVEL;
import org.mvel2.ParserConfiguration;
import org.mvel2.ParserContext;

import java.io.Serializable;
import java.util.Map;

/**
 * @author Erdinc YILMAZEL
 * @since 2/1/11
 */
public class MvelExpressionLanguage implements ExpressionLanguage {
    public static void register() {
        Expressions.registerExpressionLanguage("mvel", MvelExpressionLanguage.class);
    }
    
    ParserConfiguration configuration = new ParserConfiguration();

    public ParserConfiguration getParserConfiguration() {
        return configuration;
    }

    public Expression parse(String expressionString, int line, int column) throws ExpressionParsingException {
        ParserContext ctx = new ParserContext(configuration);

        Serializable compiledExpression = MVEL.compileExpression(expressionString, ctx);

        return new MVELExpression(compiledExpression, expressionString, line, column);
    }

    public String wrapExpressionAsList(String expr) {
        return "[" + expr + "]";
    }
}
