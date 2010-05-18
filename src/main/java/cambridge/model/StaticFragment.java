package cambridge.model;

import cambridge.runtime.TemplateProperties;

import java.io.IOException;

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
      if(!packed) {
         contents.append(c);
      }
      return this;
   }

   public StaticFragment append(StringBuilder c) {
      if(!packed) {
         contents.append(c);
      }
      return this;
   }

   public void eval(TemplateProperties properties, Appendable out) throws IOException {
      out.append(packedContents);
   }

   public void pack() {
      if(!packed) {
         packedContents = contents.toString();
         contents.setLength(0);
         contents = null;
         packed = true;
      }
   }

   public String toString() {
      return contents.toString();
   }
}
