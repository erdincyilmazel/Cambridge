package cambridge.model;

/**
 * @author Erdinc YILMAZEL
 * @since 1/28/11
 *
 */
public abstract class ExtensionNode extends TemplateNode implements AttributeFragment, TagPart, Fragment {
   final public void pack() {
   }

   @Override
   final void normalize(TemplateDocument doc, FragmentList f) {
      f.addFragment(this);
   }

   @Override
   final boolean normalizeUntil(TemplateDocument doc, TemplateNode reference, FragmentList f, boolean inclusive) {
      if (reference == this) {
         if (inclusive) {
            f.addFragment(this);
         }
         return true;
      } else {
         f.addFragment(this);
         return false;
      }
   }

   @Override
   final public Tag getElementById(String id) {
      return null;
   }

   String textContent;
   public String getTextContent() {
      return textContent;
   }

   public void setTextContent(String textContent) {
      this.textContent = textContent;
   }

   public boolean isWhiteSpace() {
      return false;
   }
}
