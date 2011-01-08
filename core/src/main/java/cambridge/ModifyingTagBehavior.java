package cambridge;

import cambridge.model.ModifyableTag;
import cambridge.runtime.TemplateProperties;

/**
 * User: erdinc
 * Date: Nov 1, 2009
 * Time: 3:29:42 PM
 */
public interface ModifyingTagBehavior extends TagBehavior {
   public void modify(TemplateProperties properties, ModifyableTag tag) throws ExpressionEvaluationException;
}
