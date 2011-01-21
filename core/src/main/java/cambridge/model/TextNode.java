package cambridge.model;

/**
 * Notes to represent arbitrary text within the documents.
 */
public class TextNode extends TemplateNode {
   String contents;

   public TextNode() {

   }

   public TextNode(String contents) {
      this.contents = contents;
   }

   public String getContents() {
      return contents;
   }

   public void setContents(String contents) {
      this.contents = contents;
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

   public String toString() {
      return contents + " @ " + getBeginLine() + ":" + getBeginColumn() + " - " + getEndLine() + ":" + getEndColumn();
   }
}
