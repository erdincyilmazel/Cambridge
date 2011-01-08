package cambridge.runtime;

import java.util.Locale;

/**
 * User: erdinc
 * Date: Nov 8, 2009
 * Time: 5:13:18 PM
 */
public class LowerCaseFilter extends Filter {
   @Override
   public String doFilter(Object o, String properties, Locale locale) {
      return o.toString().toLowerCase(locale);
   }
}
