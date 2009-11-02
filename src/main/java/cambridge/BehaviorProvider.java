package cambridge;

import cambridge.parser.model.DynamicAttribute;
import cambridge.parser.model.Attribute;

import java.util.Map;

import org.antlr.runtime.RecognitionException;

/**
 * User: erdinc
 * Date: Nov 1, 2009
 * Time: 12:36:42 PM
 */
public interface BehaviorProvider<T extends TagBehavior>{
   public T get(DynamicAttribute keyAttribute, Map<AttributeKey, Attribute> attributes) throws RecognitionException, BehaviorInstantiationException;
}
