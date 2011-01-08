package cambridge.runtime;

import java.util.Locale;
import java.util.Map;

/**
 * User: erdinc
 * Date: Nov 8, 2009
 * Time: 4:16:02 PM
 */
public interface TemplateBindings extends Map<String, Object> {
   public Locale getLocale();
}
