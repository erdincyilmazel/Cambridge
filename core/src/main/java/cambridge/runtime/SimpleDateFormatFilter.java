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
   public String doFilter(Object o, String properties, Locale locale) {
      if (o instanceof Date) {
         SimpleDateFormat format = new SimpleDateFormat(properties, locale);
         return format.format((Date) o);
      }
      return o.toString();
   }
}
