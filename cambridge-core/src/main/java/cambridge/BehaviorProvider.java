package cambridge;

import cambridge.model.Attribute;
import cambridge.model.AttributeKey;
import cambridge.model.DynamicAttribute;

import java.util.Map;

/**
 * User: erdinc
 * Date: Nov 1, 2009
 * Time: 12:36:42 PM
 */
public interface BehaviorProvider<T extends TagBehavior> {
   /**
    * Creates an instance of a TagBehavior. The TagBehavior implementations
    * should also provide a BehaviorProvider which will create
    * an instance of the TagBehavior when needed.
    *
    * @param keyAttribute The attribute that was mapped to the TagBehavior
    * @param attributes Other attributes of the same tag. If the behavior needs
    *       to use some other attribute values, they can access these using this map.
    * @return Created TagBehavior
    * @throws ExpressionParsingException If the expression passed as an attribute value can not be parsed
    * @throws BehaviorInstantiationException If there's been an error while creating the TagBehavior instance.
    */
   public T get(DynamicAttribute keyAttribute, Map<AttributeKey, Attribute> attributes) throws ExpressionParsingException, BehaviorInstantiationException;
}
