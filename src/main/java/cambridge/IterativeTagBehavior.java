package cambridge;

import cambridge.parser.model.Tag;
import cambridge.runtime.Super;

import java.io.IOException;
import java.util.Map;

/**
 * User: erdinc
 * Date: Oct 31, 2009
 * Time: 7:16:27 PM
 */
public abstract class IterativeTagBehavior implements TagBehavior {
   public IterativeTagBehavior() {
   }

   public final void iterate(Map<String, Object> properties, Tag tag, Appendable out) throws TemplateRuntimeException, IOException {
      Object t = properties.get("this");
      Object ts = properties.get("super");
      Super s = null;

      if (t != null) {
         s = new Super(t, ts);
         properties.put("super", s);
      }

      next(properties, tag, out);

      if (t != null) {
         properties.put("this", s.get());
         properties.put("super", s.getSuper());
      } else {
         properties.put("this", t);
         properties.put("super", ts);
      }
   }

   public abstract void next(Map<String, Object> properties, Tag tag, Appendable out) throws TemplateRuntimeException, IOException;
}
