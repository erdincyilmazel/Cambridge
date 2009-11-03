package cambridge.behaviors;

import cambridge.StaticBehavior;
import cambridge.model.SimpleAttribute;
import cambridge.model.TagNode;

/**
 * User: erdinc
 * Date: Nov 2, 2009
 * Time: 3:59:27 PM
 */
public class AltAdderStaticBehavior implements StaticBehavior {
   @Override
   public void modify(TagNode t) {
      if (t.getTagName().equalsIgnoreCase("img")) {
         if (!t.hasAttribute("alt")) {
            t.addAttribute(new SimpleAttribute("alt", ""));
         }
      }
   }
}
