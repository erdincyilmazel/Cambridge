package cambridge.parser.model;

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

   public boolean whitespace;
}
