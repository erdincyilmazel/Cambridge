package cambridge.runtime;

import java.util.Locale;
import java.util.HashMap;

/**
 * User: erdinc
 * Date: Nov 8, 2009
 * Time: 5:11:59 PM
 */
public abstract class Filter {
   public static final HashMap<String, Filter> filters = new HashMap<String, Filter>();

   static {
      filters.put("lower", new LowerCaseFilter());
      filters.put("upper", new UpperCaseFilter());
      filters.put("escape", new EscapeFilter());
      filters.put("dateformat", new SimpleDateFormatFilter());
   }

   public static Filter getInstance(String name) {
      return filters.get(name.toLowerCase());
   }

   public abstract String doFilter(Object o, String properties, Locale locale);
}