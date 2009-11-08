package cambridge;

import cambridge.model.ModifyableTag;

import java.util.Map;

/**
 * User: erdinc
 * Date: Nov 1, 2009
 * Time: 3:29:42 PM
 */
public interface ModifyingTagBehavior extends TagBehavior {
   public void modify(Map<String, Object> properties, ModifyableTag tag) throws ExpressionEvaluationException;
}
