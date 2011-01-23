package cambridge.runtime;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * User: erdincyilmazel
 * Date: 1/7/11
 * Time: 10:18 PM
 */
public class DefaultTemplateBindings extends HashMap<String, Object> {
   public static final String LocaleVariable = "___LOCALE___";

   public DefaultTemplateBindings(Locale locale) {
      put(LocaleVariable, locale);
   }

   public DefaultTemplateBindings() {
      put(LocaleVariable, Locale.getDefault());
   }

   public Locale getLocale() {
      return (Locale) get(LocaleVariable);
   }

   public static Locale getLocaleFromBindings(Map<String, Object> bindings) {
      Locale locale = (Locale) bindings.get(LocaleVariable);
      if (locale == null) {
         locale = Locale.getDefault();
      }

      return locale;
   }
}
