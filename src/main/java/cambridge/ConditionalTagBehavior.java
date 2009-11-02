package cambridge;

import java.util.Map;

/**
 * User: erdinc
 * Date: Oct 31, 2009
 * Time: 7:10:31 PM
 */
public abstract class ConditionalTagBehavior implements TagBehavior {
   public abstract boolean conditionMet(Map<String, Object> properties) throws ExpressionEvaluationException;
}
