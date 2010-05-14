package cambridge.model;

/**
 * Arbitrary text within a tag element
 */
public class TextTagPart implements TagPart {
   private String textContent;

   public TextTagPart(String textContent) {
      this.textContent = textContent;
   }

   public String getTextContent() {
      return textContent;
   }

   public void setTextContent(String textContent) {
      this.textContent = textContent;
   }

   public boolean isWhiteSpace() {
      return whitespace;
   }

   public boolean whitespace;
}
