package cambridge.runtime;

import java.util.Locale;

/**
 * @author Erdinc Yilmazel
 * @since 1/27/11
 */
public class RawFilter implements Filter {
   public void init(String parameters) {
   }

   public String doFilter(Object o, Locale locale) {
      return o.toString();
   }
}
