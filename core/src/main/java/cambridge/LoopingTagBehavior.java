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
      Object t = bindings.get(Expressions.CURRENT_OBJECT);
      Super ts = (Super) bindings.get(Expressions.PARENT_OBJECT);
      Iter iter = (Iter) bindings.get(Expressions.ITER_OBJECT);

      Super s = null;

      if (t != null) {
         s = new Super(t, ts, iter);
         bindings.put(Expressions.PARENT_OBJECT, s);
      }

      doExecute(bindings, tag, out);

      if (t != null) {
         bindings.put(Expressions.CURRENT_OBJECT, s.get());
         bindings.put(Expressions.PARENT_OBJECT, s.getSuper());
         bindings.put(Expressions.ITER_OBJECT, s.getIter());
      } else {
         bindings.put(Expressions.CURRENT_OBJECT, t);
         bindings.put(Expressions.PARENT_OBJECT, ts);
         bindings.put(Expressions.ITER_OBJECT, iter);
      }
   }

   protected abstract void doExecute(Map<String, Object> bindings, TagNode tag, Writer out) throws TemplateEvaluationException, IOException;
}
