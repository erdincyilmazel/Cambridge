package cambridge.behaviors;

import cambridge.StaticBehavior;
import cambridge.model.TagNode;
import cambridge.model.TemplateDocument;

/**
 * @author Erdinc Yilmazel
 * Date: Nov 5, 2009
 * Time: 5:53:51 PM
 */
public class HideBehavior implements StaticBehavior {
   public void modify(TemplateDocument doc, String value, TagNode t) {
      t.setDynamic(true);
      t.setHidden(true);
   }

   public boolean shouldRemove() {
      return false;
   }
}
