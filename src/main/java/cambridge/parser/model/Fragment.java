package cambridge.parser.model;

import cambridge.TemplateRuntimeException;

import java.io.IOException;
import java.util.Map;

/**
 * User: erdinc
 * Date: Oct 13, 2009
 * Time: 1:02:03 PM
 */
public interface Fragment {
   public abstract void eval(Map<String, Object> properties, Appendable out) throws IOException, TemplateRuntimeException;
}
