package cambridge.model;

import java.io.IOException;
import java.io.PrintStream;

/**
 * CommentNode class represents nodes within the documents which are valid
 * Html or Cambridge template comments.
 * <p/>
 * Comment blocks start with <!-- characters and end with --> characters.
 */
public class CommentNode extends TextNode {
   public String getSource() {
      return contents;
   }

   public void print(PrintStream out) throws IOException {
      out.print(contents);
   }

   @Override
   public boolean isDynamic() {
      return false;
   }

   @Override
   public void normalize(FragmentList f) {
      f.append(contents);
   }

   @Override
   public boolean normalizeUntil(TemplateNode reference, FragmentList f, boolean inclusive) {
      if(reference == this) {
         if(inclusive) {
            f.append(contents);
         }
         return true;
      } else {
         f.append(contents);
         return false;
      }
   }

   @Override
   public TagNode getElementById(String id) {
      return null;
   }
}
