package cambridge;

import cambridge.model.Attribute;
import cambridge.model.AttributeKey;
import cambridge.model.DynamicAttribute;

import java.util.Map;

/**
 * BehaviorProvider is an interface for TagBehavior factories.
 * Classes that create an instance of TagBehavior should implement this interface
 * and register themselves with Cambridge singleton.
 *
 * @see Cambridge
 */
public interface BehaviorProvider<T extends TagBehavior> {
   /**
    * Creates an instance of a TagBehavior and returns it.
    *
    * @param keyAttribute The attribute that was mapped to the TagBehavior
    * @param attributes Other attributes of the same tag. If the behavior needs
    *       to use some other attribute values, they can access these using this map.
    * @param line Line number of the tag trying to initiate the behavior
    * @param col Column number of the tag trying to initiate the behavior
    * @return Created TagBehavior
    * @throws ExpressionParsingException If the expression passed as an attribute value can not be parsed
    * @throws BehaviorInstantiationException If there's been an error while creating the TagBehavior instance.
    */
   public T get(DynamicAttribute keyAttribute, Map<AttributeKey, Attribute> attributes, int line, int col) throws ExpressionParsingException, BehaviorInstantiationException;
}
