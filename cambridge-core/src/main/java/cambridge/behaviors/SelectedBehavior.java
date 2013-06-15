package cambridge.behaviors;

import cambridge.BehaviorInstantiationException;
import cambridge.BehaviorProvider;
import cambridge.ExpressionEvaluationException;
import cambridge.ExpressionParsingException;
import cambridge.ModifyingTagBehavior;
import cambridge.model.Attribute;
import cambridge.model.AttributeKey;
import cambridge.model.DynamicAttribute;
import cambridge.model.Expression;
import cambridge.model.ModifyableTag;
import cambridge.model.SimpleAttribute;
import cambridge.runtime.ExpressionContext;

import java.util.Map;

/**
 * @author Erdinc Yilmazel
 * Date: Nov 7, 2009
 * Time: 8:36:59 PM
 */
public class SelectedBehavior extends ModifyingTagBehavior {
    private final Expression expression;

    public SelectedBehavior(Expression expression, int line, int col) {
        super(line, col);
        this.expression = expression;
    }

    public void modify(ExpressionContext context, ModifyableTag tag) throws ExpressionEvaluationException {
        if (expression.asBoolean(context)) {
            tag.getTagParts().add(new SimpleAttribute("selected", "selected", getLine(), getCol()));
        }
    }

    public static BehaviorProvider<SelectedBehavior> getProvider() {
        return new BehaviorProvider<SelectedBehavior>() {
            public SelectedBehavior get(DynamicAttribute keyAttribute, Map<AttributeKey, Attribute> attributes, int line, int col) throws ExpressionParsingException, BehaviorInstantiationException {
                return new SelectedBehavior(keyAttribute.getExpression(), line, col);
            }
        };
    }
}
