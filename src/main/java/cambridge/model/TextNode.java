package cambridge.model;

import java.io.IOException;
import java.io.PrintStream;

/**
 * Notes to represent arbitrary text within the documents.
 */
public class TextNode extends TemplateNode {
   String contents;

   public TextNode() {

   }

   public String getContents() {
      return contents;
   }

   public void setContents(String contents) {
      this.contents = contents;
   }

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
   public Tag getElementById(String id) {
      return null;
   }

   public String toString() {
      return getBeginLine() + ":" + getBeginColumn() + " - " + getEndLine() + ":" + getEndColumn() + " - " + contents;
   }
}
