package cambridge.model;

import cambridge.TemplateEvaluationException;
import cambridge.runtime.ExpressionContext;

import java.io.IOException;
import java.io.Writer;

/**
 * @author Erdinc Yilmazel
 * Date: Oct 13, 2009
 * Time: 1:02:03 PM
 */
public interface Fragment {
   public abstract void eval(ExpressionContext context, Writer out) throws IOException, TemplateEvaluationException;

   public void pack();
}
