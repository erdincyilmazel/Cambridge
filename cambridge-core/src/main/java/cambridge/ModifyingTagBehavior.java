package cambridge;

import cambridge.model.ModifyableTag;

import java.util.Map;

/**
 * User: erdinc
 * Date: Nov 1, 2009
 * Time: 3:29:42 PM
 */
public abstract class ModifyingTagBehavior implements TagBehavior {
   public abstract void modify(Map<String, Object> bindings, ModifyableTag tag) throws ExpressionEvaluationException;
}
