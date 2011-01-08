package cambridge.runtime;

import java.util.HashMap;
import java.util.Locale;

/**
 * User: erdincyilmazel
 * Date: 1/7/11
 * Time: 10:18 PM
 */
public class DefaultTemplateBindings extends HashMap<String, Object> implements TemplateBindings {
   Locale locale;

   public DefaultTemplateBindings(Locale locale) {
      this.locale = locale;
   }

   public DefaultTemplateBindings() {
      locale = Locale.getDefault();
   }

   public Locale getLocale() {
      return locale;
   }
}
