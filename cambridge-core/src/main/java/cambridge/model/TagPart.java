package cambridge.model;

/**
 * TagPart objects represent the elements within an HTML tag.
 * attributes, expressions or other texts within an html tag are
 * TagParts.
 */
public interface TagPart {
    public int getLine();

    public int getColumn();

    public String getTextContent();

    public void setTextContent(String textContent);

    public boolean isWhiteSpace();

    public boolean preserveWhitespace();
}
