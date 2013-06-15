package cambridge.behaviors;

import cambridge.BehaviorInstantiationException;
import cambridge.BehaviorProvider;
import cambridge.ExpressionEvaluationException;
import cambridge.ExpressionParsingException;
import cambridge.Expressions;
import cambridge.LoopingTagBehavior;
import cambridge.TemplateEvaluationException;
import cambridge.model.Attribute;
import cambridge.model.AttributeKey;
import cambridge.model.DynamicAttribute;
import cambridge.model.Expression;
import cambridge.model.TagNode;
import cambridge.runtime.ExpressionContext;
import cambridge.runtime.Iter;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;


/**
 * @author Erdinc Yilmazel
 * Date: Nov 1, 2009
 * Time: 2:36:22 PM
 */
public class WhileBehavior extends LoopingTagBehavior {
    private final Expression expression;

    public WhileBehavior(Expression expression, int line, int col) {
        super(line, col);
        this.expression = expression;
    }

    @Override
    public void doExecute(ExpressionContext context, TagNode tag, Writer out) throws TemplateEvaluationException, IOException {
        try {
            Iter iter = new Iter();
            while (expression.asBoolean(context)) {
                context.set(Expressions.ITER_OBJECT, iter);
                tag.execute(context, out);
                iter.next();
            }
        } catch (ExpressionEvaluationException e) {
            throw new TemplateEvaluationException(e, "Could not execute the expression: " +
                    e.getMessage() + ", on line: " + tag.getBeginLine() + ", column: " +
                    tag.getBeginColumn(), tag.getBeginLine(), tag.getBeginColumn(), tag.getTagName());
        }
    }

    public static BehaviorProvider<WhileBehavior> getProvider() {
        return new BehaviorProvider<WhileBehavior>() {
            public WhileBehavior get(DynamicAttribute keyAttribute, Map<AttributeKey, Attribute> attributes, int line, int col) throws ExpressionParsingException, BehaviorInstantiationException {
                return new WhileBehavior(keyAttribute.getExpression(), line, col);
            }
        };
    }
}
