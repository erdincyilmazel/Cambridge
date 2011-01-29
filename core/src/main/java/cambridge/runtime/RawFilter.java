package cambridge.runtime;

import java.util.Locale;

/**
 * @author Erdinc Yilmazel
 * @since 1/27/11
 */
public class RawFilter implements Filter {
   public String doFilter(Object o, String properties, Locale locale) {
      return o.toString();
   }
}
