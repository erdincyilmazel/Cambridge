package cambridge.behaviors;

import cambridge.BehaviorProvider;
import cambridge.ExpressionParsingException;
import cambridge.model.Attribute;
import cambridge.model.AttributeKey;
import cambridge.model.DynamicAttribute;

import java.util.Map;

/**
 * @author Erdinc Yilmazel
 * Date: Jan 22 2011
 * Time: 01:20:01 PM
 */
public class ElseBehavior extends ConditionalTagBehavior {

    public ElseBehavior(int line, int col) {
        super(line, col);
    }

    @Override
    public ConditionType getType() {
        return ConditionType.DEFAULT;
    }

    @Override
    public String getValidationError() {
        return "Else behaviour without if";
    }

    public static BehaviorProvider<ElseBehavior> getProvider() {
        return new BehaviorProvider<ElseBehavior>() {
            public ElseBehavior get(DynamicAttribute keyAttribute, Map<AttributeKey, Attribute> attributes, int line, int col) throws ExpressionParsingException {
                return new ElseBehavior(line, col);
            }
        };
    }
}