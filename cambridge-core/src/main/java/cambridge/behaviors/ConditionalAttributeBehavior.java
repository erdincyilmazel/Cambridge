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
import cambridge.model.TagPart;

import java.util.Map;

/**
 * @author Erdinc Yilmazel
 * Date: Nov 1, 2009
 * Time: 3:04:10 PM
 */
public class ConditionalAttributeBehavior extends ModifyingTagBehavior {
    private final Expression expression;
    private final DynamicAttribute attribute;

    public ConditionalAttributeBehavior(Expression expression, DynamicAttribute attribute, int line, int col) {
        super(line, col);
        this.expression = expression;
        this.attribute = attribute;
    }

    public void modify(Map<String, Object> bindings, ModifyableTag tag) throws ExpressionEvaluationException {
        if (!expression.asBoolean(bindings)) {
            int remove = -1;
            boolean next = false;
            for (int i = 0; i < tag.getTagParts().size(); i++) {
                TagPart t = tag.getTagParts().get(i);
                if (t == attribute) {
                    next = true;
                } else {
                    if (next) {
                        if (t instanceof Attribute) {
                            Attribute a = (Attribute) t;
                            if (!a.isDynamic()) {
                                remove = i;
                            }
                        }
                    }
                }
            }

            if (remove != -1) {
                tag.getTagParts().remove(remove);
            }
        }
    }

    public static BehaviorProvider<ConditionalAttributeBehavior> getProvider() {
        return new BehaviorProvider<ConditionalAttributeBehavior>() {
            public ConditionalAttributeBehavior get(DynamicAttribute keyAttribute, Map<AttributeKey, Attribute> attributes, int line, int col) throws ExpressionParsingException, BehaviorInstantiationException {
                return new ConditionalAttributeBehavior(keyAttribute.getExpression(), keyAttribute, line, col);
            }
        };
    }

    @Override
    public String toString() {
        return "ConditionalAttributeBehavior{" +
                "expression=" + expression +
                ", attribute=" + attribute +
                ", line=" + line +
                ", col=" + col +
                '}';
    }
}
