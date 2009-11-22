package cambridge;

import cambridge.model.TagNode;
import cambridge.runtime.Iter;
import cambridge.runtime.Super;
import cambridge.runtime.TemplateProperties;

import java.io.IOException;

/**
 * User: erdinc
 * Date: Oct 31, 2009
 * Time: 7:16:27 PM
 */
public abstract class ExecutingTagBehavior implements TagBehavior {
   public ExecutingTagBehavior() {
   }

   public final void execute(TemplateProperties properties, TagNode tag, Appendable out) throws TemplateRuntimeException, IOException {
      Object t = properties.get("#this");
      Super ts = (Super) properties.get("#super");
      Iter iter = (Iter) properties.get("#iter");

      Super s = null;

      if (t != null) {
         s = new Super(t, ts, iter);
         properties.put("#super", s);
      }

      doExecute(properties, tag, out);

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

   public abstract void doExecute(TemplateProperties properties, TagNode tag, Appendable out) throws TemplateRuntimeException, IOException;
}
