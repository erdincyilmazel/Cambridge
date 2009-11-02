package cambridge.parser.model;

/**
 * Arbitrary text within a tag element
 */
public class TextTagPart extends TagPart {
   public TextTagPart(String textContent) {
      super(textContent);
   }

   public boolean whitespace;

   public boolean isWhitespace() {
      return whitespace;
   }
}
