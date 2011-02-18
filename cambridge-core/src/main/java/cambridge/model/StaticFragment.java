package cambridge.model;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;

/**
 * User: erdinc
 * Date: Oct 13, 2009
 * Time: 1:05:30 PM
 */
public class StaticFragment implements AttributeFragment {
   StringBuffer contents;
   private String packedContents;
   private boolean packed;

   public StaticFragment(String text) {
      contents = new StringBuffer(text);
   }

   public StaticFragment() {
      contents = new StringBuffer();
   }

   public StaticFragment append(String c) {
      if (!packed) {
         contents.append(c);
      }
      return this;
   }

   public StaticFragment append(StringBuilder c) {
      if (!packed) {
         contents.append(c);
      }
      return this;
   }

   public void eval(Map<String, Object> bindings, Writer out) throws IOException {
      out.write(packedContents);
   }

   public void pack() {
      if (!packed) {
         packedContents = contents.toString();
         contents.setLength(0);
         contents = null;
         packed = true;
      }
   }

   public String toString() {
      if (packed) {
         return packedContents;
      } else {
         return contents.toString();
      }
   }

   public boolean isWhitespace() {
      if (packed) {
         return packedContents == null
            || packedContents.equals("")
            || packedContents.matches("\\s+");
      }

      String c = contents.toString();
      return c == null
         || c.equals("")
         || c.matches("\\s+");
   }
}
