package cambridge.runtime;

import java.util.Locale;

/**
 * User: erdinc
 * Date: Nov 8, 2009
 * Time: 5:13:18 PM
 */
public class LowerCaseFilter implements Filter {
   public String doFilter(Object o, Locale locale) {
      return o.toString().toLowerCase(locale);
   }

   public void init(String parameters) {
   }
}
