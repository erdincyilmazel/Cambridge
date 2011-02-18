package cambridge.runtime;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;

/**
 * User: erdinc
 * Date: Nov 8, 2009
 * Time: 5:16:47 PM
 */
public class SimpleDateFormatFilter implements Filter {
   static class Format {
      final String pattern;
      final Locale locale;

      Format(String pattern, Locale locale) {
         this.pattern = pattern;
         this.locale = locale;
      }

      @Override
      public boolean equals(Object o) {
         if (this == o) return true;
         if (o == null || getClass() != o.getClass()) return false;

         Format format = (Format) o;

         return locale.equals(format.locale) && pattern.equals(format.pattern);
      }

      @Override
      public int hashCode() {
         int result = pattern.hashCode();
         result = 31 * result + locale.hashCode();
         return result;
      }
   }

   static ConcurrentHashMap<Format, SimpleDateFormat> formatCache = new ConcurrentHashMap<Format, SimpleDateFormat>();

   String pattern;


   public String doFilter(Object o, Locale locale) {
      if (o instanceof Date) {
         Format key = new Format(pattern, locale);
         SimpleDateFormat f = formatCache.get(key);
         if (f != null) {
            return f.format((Date) o);
         }

         f = new SimpleDateFormat(pattern, locale);
         formatCache.putIfAbsent(key, f);

         return f.format((Date) o);
      }
      return o.toString();
   }

   public void init(String parameters) {
      this.pattern = parameters;
   }
}
