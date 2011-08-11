package cambridge.model;

/**
 * StaticAttribute are attributes which are registered with the {@link cambridge.Cambridge}
 * class and which is associated with a static behavior
 */
public class StaticAttribute implements Attribute {

    private String attributeName;
    private String attributeNameSpace;
    private String value;
    private final String namespaceUri;
    private final int line;
    private final int col;

    public StaticAttribute(String namespaceUri, int line, int column) {
        this.namespaceUri = namespaceUri;
        this.line = line;
        this.col = column;
    }

    public String getNamespaceUri() {
        return namespaceUri;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public String getAttributeNameSpace() {
        return attributeNameSpace;
    }

    public void setAttributeNameSpace(String attributeNameSpace) {
        this.attributeNameSpace = attributeNameSpace;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isDynamic() {
        return true;
    }

    public String getTextContent() {
        return value;
    }

    public void setTextContent(String textContent) {
    }

    @Override
    public int getLine() {
        return line;
    }

    @Override
    public int getColumn() {
        return col;
    }

    public boolean isWhiteSpace() {
        return false;
    }

    public boolean preserveWhitespace() {
        return false;
    }
}
