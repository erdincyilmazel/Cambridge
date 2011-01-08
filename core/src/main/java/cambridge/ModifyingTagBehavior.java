package cambridge;

import cambridge.model.ModifyableTag;
import cambridge.runtime.TemplateBindings;

/**
 * User: erdinc
 * Date: Nov 1, 2009
 * Time: 3:29:42 PM
 */
public interface ModifyingTagBehavior extends TagBehavior {
   public void modify(TemplateBindings bindings, ModifyableTag tag) throws ExpressionEvaluationException;
}
