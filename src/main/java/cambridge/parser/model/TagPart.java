package cambridge.parser.model;

/**
 * TagPart objects represent the elements within an HTML tag.
 * attributes, expressions or other texts within an html tag are
 * TagParts.
 */
public abstract class TagPart {
   String textContent;

   public TagPart() {
   }

   public TagPart(String textContent) {
      this.textContent = textContent;
   }

   public String getTextContent() {
      return textContent;
   }

   public void setTextContent(String textContent) {
      this.textContent = textContent;
   }
}
