package cambridge;

import cambridge.model.TagNode;
import cambridge.runtime.Iter;
import cambridge.runtime.Super;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;

/**
 * User: erdinc
 * Date: Oct 31, 2009
 * Time: 7:16:27 PM
 */
public abstract class LoopingTagBehavior implements TagBehavior {
   protected LoopingTagBehavior() {
   }

   public final void execute(Map<String, Object> bindings, TagNode tag, Writer out) throws TemplateEvaluationException, IOException {
      Object t = bindings.get(getCurrentObjectName());
      Super ts = (Super) bindings.get(getParentObjectName());
      Iter iter = (Iter) bindings.get(getIterObjectName());

      Super s = null;

      if (t != null) {
         s = new Super(t, ts, iter);
         bindings.put(getParentObjectName(), s);
      }

      doExecute(bindings, tag, out);

      if (t != null) {
         bindings.put(getCurrentObjectName(), s.get());
         bindings.put(getParentObjectName(), s.getSuper());
         bindings.put(getIterObjectName(), s.getIter());
      } else {
         bindings.put(getCurrentObjectName(), t);
         bindings.put(getParentObjectName(), ts);
         bindings.put(getIterObjectName(), iter);
      }
   }

   protected abstract void doExecute(Map<String, Object> bindings, TagNode tag, Writer out) throws TemplateEvaluationException, IOException;

   public String getCurrentObjectName() {
      return Expressions.CURRENT_OBJECT;
   }

   public String getParentObjectName() {
      return Expressions.PARENT_OBJECT;
   }

   public String getIterObjectName() {
      return Expressions.ITER_OBJECT;
   }
}
