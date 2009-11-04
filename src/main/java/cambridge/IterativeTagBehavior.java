package cambridge;

import cambridge.model.TagNode;
import cambridge.runtime.Super;
import cambridge.runtime.Iter;

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

   public final void iterate(Map<String, Object> properties, TagNode tag, Appendable out) throws TemplateRuntimeException, IOException {
      Object t = properties.get("#this");
      Super ts = (Super) properties.get("#super");
      Iter iter = (Iter) properties.get("#iter");

      Super s = null;

      if (t != null) {
         s = new Super(t, ts, iter);
         properties.put("#super", s);
      }

      loop(properties, tag, out);

      if (t != null) {
         properties.put("#this", s.get());
         properties.put("#super", s.getSuper());
         properties.put("#iter", s.getIter());
      } else {
         properties.put("#this", t);
         properties.put("#super", ts);
         properties.put("#iter", iter);
      }
   }

   public abstract void loop(Map<String, Object> properties, TagNode tag, Appendable out) throws TemplateRuntimeException, IOException;
}
