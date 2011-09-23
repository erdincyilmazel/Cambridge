package cambridge.runtime;

import java.util.Locale;

/**
 * @author Erdinc Yilmazel
 * Date: Nov 8, 2009
 * Time: 5:13:18 PM
 */
public class UpperCaseFilter implements Filter {
   public void init(String parameters) {
   }

   public String doFilter(Object o, Locale locale) {
      return o.toString().toUpperCase(locale);
   }
}