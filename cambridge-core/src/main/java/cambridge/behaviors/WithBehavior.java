package cambridge.behaviors;

import cambridge.BehaviorInstantiationException;
import cambridge.BehaviorProvider;
import cambridge.ExpressionEvaluationException;
import cambridge.ExpressionParsingException;
import cambridge.LoopingTagBehavior;
import cambridge.TemplateEvaluationException;
import cambridge.model.Attribute;
import cambridge.model.AttributeKey;
import cambridge.model.DynamicAttribute;
import cambridge.model.Expression;
import cambridge.model.TagNode;
import cambridge.runtime.ExpressionContext;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;

/**
 * @author Erdinc Yilmazel
 * @since 1/25/11
 */
public class WithBehavior extends LoopingTagBehavior {
    private final Expression expression;
    private final String currentObjectName;

    public WithBehavior(Expression expression, String currentObjectName, int line, int col) {
        super(line, col);
        this.expression = expression;
        this.currentObjectName = currentObjectName;
    }

    @Override
    public String getCurrentObjectName() {
        if (currentObjectName == null) {
            return super.getCurrentObjectName();
        }

        return currentObjectName;
    }

    @Override
    protected void doExecute(ExpressionContext context, TagNode tag, Writer out) throws TemplateEvaluationException, IOException {
        try {
            context.set(getCurrentObjectName(), expression.eval(context));
            tag.execute(context, out);
        } catch (ExpressionEvaluationException e) {
            throw new TemplateEvaluationException(e, "Could not execute the expression: " +
                    e.getMessage() + ", on line: " + tag.getBeginLine() + ", column: " +
                    tag.getBeginColumn(), tag.getBeginLine(), tag.getBeginColumn(), tag.getTagName());
        }
    }

    public static BehaviorProvider<WithBehavior> getProvider() {
        return new BehaviorProvider<WithBehavior>() {
            public WithBehavior get(DynamicAttribute keyAttribute, Map<AttributeKey, Attribute> attributes, int line, int col) throws ExpressionParsingException, BehaviorInstantiationException {

                AttributeKey asKey = new AttributeKey(keyAttribute.getAttributeNameSpace(), "as");
                Attribute asAttribute = attributes.get(asKey);

                return new WithBehavior(keyAttribute.getExpression(), asAttribute == null ? null : asAttribute.getValue(), line, col);
            }
        };
    }
}
