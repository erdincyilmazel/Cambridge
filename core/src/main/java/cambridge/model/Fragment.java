package cambridge.model;

import cambridge.TemplateEvaluationException;
import java.io.IOException;
import java.util.Map;

/**
 * User: erdinc
 * Date: Oct 13, 2009
 * Time: 1:02:03 PM
 */
public interface Fragment {
   public abstract void eval(Map<String, Object> bindings, Appendable out) throws IOException, TemplateEvaluationException;
   public void pack();
}
