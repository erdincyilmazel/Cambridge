package cambridge.runtime;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * User: erdinc
 * Date: Nov 8, 2009
 * Time: 5:16:47 PM
 */
public class SimpleDateFormatFilter implements Filter {
   String pattern;

   public String doFilter(Object o, Locale locale) {
      if (o instanceof Date) {
         SimpleDateFormat f = new SimpleDateFormat(pattern, locale);

         return f.format((Date) o);
      }
      return o.toString();
   }

   public void init(String parameters) {
      this.pattern = parameters;
   }
}
