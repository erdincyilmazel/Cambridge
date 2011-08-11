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

import java.util.Map;

/**
 * User: erdinc
 * Date: Nov 7, 2009
 * Time: 8:36:59 PM
 */
public class SelectedBehavior extends ModifyingTagBehavior {
    private final Expression expression;

    public SelectedBehavior(Expression expression, int line, int col) {
        super(line, col);
        this.expression = expression;
    }

    public void modify(Map<String, Object> bindings, ModifyableTag tag) throws ExpressionEvaluationException {
        if (expression.asBoolean(bindings)) {
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
