package cambridge;

import cambridge.model.TagNode;
import cambridge.model.TemplateDocument;

/**
 * User: erdinc
 * Date: Nov 2, 2009
 * Time: 3:49:35 PM
 */
public interface StaticBehavior {
   public void modify(TemplateDocument doc, String value, TagNode t);

   public boolean shouldRemove();
}
