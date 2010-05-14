package cambridge.runtime;

import java.util.HashMap;
import java.util.Locale;

/**
 * User: erdinc
 * Date: Nov 8, 2009
 * Time: 4:16:02 PM
 */
public class TemplateProperties extends HashMap<String, Object> {
   private final Locale locale;

   public Locale getLocale() {
      return locale;
   }

   public TemplateProperties(Locale locale) {
      this.locale = locale;
   }

   public TemplateProperties() {
      locale = Locale.getDefault();
   }
}
