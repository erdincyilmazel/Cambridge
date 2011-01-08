package cambridge.model;

/**
 * TagPart objects represent the elements within an HTML tag.
 * attributes, expressions or other texts within an html tag are
 * TagParts.
 */
public interface TagPart {
   public String getTextContent();

   public void setTextContent(String textContent);

   public abstract boolean isWhiteSpace();
}
