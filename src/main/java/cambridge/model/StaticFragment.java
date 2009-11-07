package cambridge.model;

import java.io.IOException;
import java.util.Map;

/**
 * User: erdinc
 * Date: Oct 13, 2009
 * Time: 1:05:30 PM
 */
public class StaticFragment implements Fragment {
   StringBuilder contents;

   public StaticFragment(String text) {
      contents = new StringBuilder(text);
   }

   public StaticFragment() {
      contents = new StringBuilder();
   }

   public StaticFragment append(String c) {
      contents.append(c);
      return this;
   }

   public StaticFragment append(StringBuilder c) {
      contents.append(c);
      return this;
   }

   @Override
   public void eval(Map<String, Object> properties, Appendable out) throws IOException {
      out.append(contents);
   }
}
