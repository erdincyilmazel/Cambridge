package cambridge.model;

import cambridge.TemplateEvaluationException;
import cambridge.runtime.TemplateBindings;

import java.io.IOException;

/**
 * User: erdinc
 * Date: Oct 13, 2009
 * Time: 1:02:03 PM
 */
public interface Fragment {
   public abstract void eval(TemplateBindings bindings, Appendable out) throws IOException, TemplateEvaluationException;
   public void pack();
}
