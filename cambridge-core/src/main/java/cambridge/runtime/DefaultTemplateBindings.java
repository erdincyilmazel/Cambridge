package cambridge.runtime;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * @author Erdinc Yilmazelyilmazel
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

   public static Locale getLocaleFromBindings(Map<String, Object> bindings) {
      Locale locale = (Locale) bindings.get(LocaleVariable);
      if (locale == null) {
         locale = Locale.getDefault();
      }

      return locale;
   }
}
