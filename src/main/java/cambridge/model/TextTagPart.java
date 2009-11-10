package cambridge.model;

/**
 * Arbitrary text within a tag element
 */
public class TextTagPart extends TagPart {
   public TextTagPart(String textContent) {
      super(textContent);
   }

   @Override
   public boolean isWhiteSpace() {
      return whitespace;
   }

   @Override
   public boolean containsExpressions() {
      return false;
   }

   public boolean whitespace;
}
