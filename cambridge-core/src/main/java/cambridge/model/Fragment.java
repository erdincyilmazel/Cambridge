package cambridge.model;

import cambridge.TemplateEvaluationException;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;

/**
 * @author Erdinc Yilmazel
 * Date: Oct 13, 2009
 * Time: 1:02:03 PM
 */
public interface Fragment {
   public abstract void eval(Map<String, Object> bindings, Writer out) throws IOException, TemplateEvaluationException;

   public void pack();
}
