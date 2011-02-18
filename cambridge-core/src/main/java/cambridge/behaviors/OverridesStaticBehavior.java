package cambridge.behaviors;

import cambridge.StaticBehavior;
import cambridge.model.TagNode;
import cambridge.model.TemplateDocument;

/**
 * @author Erdinc Yilmazel
 * @since 1/27/11
 */
public class OverridesStaticBehavior implements StaticBehavior {
   public void modify(TemplateDocument doc, String value, TagNode t) {
   }

   public boolean shouldRemove() {
      return false;
   }
}
