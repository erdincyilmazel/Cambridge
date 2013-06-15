package cambridge.janino;


import cambridge.ExpressionLanguage;
import cambridge.ExpressionParsingException;
import cambridge.Expressions;
import cambridge.model.Expression;
import cambridge.parser.expressions.MapExpressionContext;
import cambridge.runtime.ExpressionContext;

import java.util.Locale;

/**
 * @author Tom Carchrae
 * 
 * See http://docs.codehaus.org/display/JANINO/Home for more about Janino and its limitations
 * 
 */
public class JaninoExpressionLanguage implements ExpressionLanguage {
	
    public static void register() {
        Expressions.registerExpressionLanguage("janino", JaninoExpressionLanguage.class);
    }

    public Expression parse(String expressionString, int line, int column) throws ExpressionParsingException {
        return new JaninoExpression(expressionString, line, column);
    }

    public String wrapExpressionAsList(String expr) {
    	//TODO: Check this.  Might require this to be { } instead.  Not clear 
    	System.err.println("Check wrapExpressionAsList: " + expr);
        return "[" + expr + "]";
    }

    @Override
    public ExpressionContext createNewContext(Locale locale)
    {
        return new MapExpressionContext(locale);
    }

    @Override
    public ExpressionContext createNewContext()
    {
        return new MapExpressionContext();
    }
}
