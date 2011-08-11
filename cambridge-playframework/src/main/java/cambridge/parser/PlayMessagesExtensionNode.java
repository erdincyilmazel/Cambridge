package cambridge.parser;

import cambridge.ExpressionEvaluationException;
import cambridge.ExpressionLanguage;
import cambridge.TemplateEvaluationException;
import cambridge.model.Expression;
import cambridge.model.ExtensionNode;
import play.i18n.Messages;

import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.Map;

/**
 * @author Erdinc YILMAZEL
 * @since 1/28/11
 */
public class PlayMessagesExtensionNode extends ExtensionNode {
    Expression expression;
    String expr;

    public PlayMessagesExtensionNode(ExpressionLanguage language, String expr) {
        expression = language.parse(language.wrapExpressionAsList(expr), getBeginLine(), getBeginColumn());
        this.expr = expr;
    }

    public void eval(Map<String, Object> bindings, Writer out) throws IOException, TemplateEvaluationException {
        try {
            Object list = expression.eval(bindings);
            if (list instanceof List) {
                List l = (List) list;
                if (l.size() > 1) {
                    Object message = l.get(0);
                    Object[] params = new Object[l.size() - 1];

                    for (int i = 0; i < params.length; i++) {
                        params[i] = l.get(i);
                    }

                    out.write(Messages.get(message, params));
                }
            }
        } catch (ExpressionEvaluationException e) {
            throw new TemplateEvaluationException(e, "Could not execute the expression: " + expr +
                    ", on line: " + getBeginLine() + ", column: " + getBeginColumn(), getBeginLine(), getBeginColumn());
        }
    }
}
