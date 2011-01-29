package cambridge.runtime;

import java.util.Locale;

/**
 * User: erdinc
 * Date: Nov 8, 2009
 * Time: 5:13:18 PM
 */
public class EscapeFilter implements Filter {
   public String doFilter(Object o, String properties, Locale locale) {
      String str = o.toString();
      StringBuffer sb = new StringBuffer(str.length());
      // true if last char was blank
      boolean lastWasBlankChar = false;
      int len = str.length();
      char c;

      for (int i = 0; i < len; i++) {
         c = str.charAt(i);
         if (c == ' ') {
            // blank gets extra work,
            // this solves the problem you get if you replace all
            // blanks with &nbsp;, if you do that you loss
            // word breaking
            if (lastWasBlankChar) {
               lastWasBlankChar = false;
               sb.append("&nbsp;");
            } else {
               lastWasBlankChar = true;
               sb.append(' ');
            }
         } else {
            lastWasBlankChar = false;
            //
            // HTML Special Chars
            if (c == '"')
               sb.append("&quot;");
            else if (c == '&')
               sb.append("&amp;");
            else if (c == '<')
               sb.append("&lt;");
            else if (c == '>')
               sb.append("&gt;");
            else if (c == '\n')
               // Handle Newline
               sb.append("<br/>");
            else {
               int ci = 0xffff & c;
               if (ci < 160)
                  // nothing special only 7 Bit
                  sb.append(c);
               else {
                  // Not 7 Bit use the unicode system
                  sb.append("&#");
                  sb.append(Integer.toString(ci));
                  sb.append(';');
               }
            }
         }
      }
      return sb.toString();
   }
}