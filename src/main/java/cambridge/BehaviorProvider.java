package cambridge;

import cambridge.model.Attribute;
import cambridge.model.DynamicAttribute;

import java.util.Map;

/**
 * User: erdinc
 * Date: Nov 1, 2009
 * Time: 12:36:42 PM
 */
public interface BehaviorProvider<T extends TagBehavior> {
   public T get(DynamicAttribute keyAttribute, Map<AttributeKey, Attribute> attributes) throws ExpressionParsingException, BehaviorInstantiationException;
}
