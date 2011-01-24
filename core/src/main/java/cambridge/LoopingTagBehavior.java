package cambridge;

import cambridge.model.TagNode;
import cambridge.runtime.Iter;
import cambridge.runtime.Super;

import java.io.IOException;
import java.util.Map;

/**
 * User: erdinc
 * Date: Oct 31, 2009
 * Time: 7:16:27 PM
 */
public abstract class LoopingTagBehavior implements TagBehavior {
   protected LoopingTagBehavior() {
   }

   public final void execute(Map<String, Object> bindings, TagNode tag, Appendable out) throws TemplateEvaluationException, IOException {
      Object t = bindings.get("#this");
      Super ts = (Super) bindings.get("#super");
      Iter iter = (Iter) bindings.get("#iter");

      Super s = null;

      if (t != null) {
         s = new Super(t, ts, iter);
         bindings.put("#super", s);
      }

      doExecute(bindings, tag, out);

      if (t != null) {
         bindings.put("#this", s.get());
         bindings.put("#super", s.getSuper());
         bindings.put("#iter", s.getIter());
      } else {
         bindings.put("#this", t);
         bindings.put("#super", ts);
         bindings.put("#iter", iter);
      }
   }

   protected abstract void doExecute(Map<String, Object> bindings, TagNode tag, Appendable out) throws TemplateEvaluationException, IOException;
}
