package cambridge.behaviors;

import cambridge.StaticBehavior;
import cambridge.model.TagNode;

/**
 * User: erdinc
 * Date: Nov 5, 2009
 * Time: 5:53:51 PM
 */
public class HideBehavior implements StaticBehavior {
   @Override
   public void modify(TagNode t) {
      t.setDynamic(true);
      t.setHidden(true);
   }
}
