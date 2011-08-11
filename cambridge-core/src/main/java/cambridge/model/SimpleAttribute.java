package cambridge.model;

public class SimpleAttribute implements Attribute {
    private String textContent;
    private String attributeName;
    private String attributeNameSpace;
    private String value;
    private final int line;
    private final int col;

    public SimpleAttribute(int line, int col) {
        this.line = line;
        this.col = col;
    }

    public SimpleAttribute(String attributeName, String attributeNameSpace, String value, int line, int col) {
        this(line, col);
        this.attributeName = attributeName;
        this.attributeNameSpace = attributeNameSpace;
        this.value = value;
    }

    public SimpleAttribute(String attributeName, String value, int line, int col) {
        this(attributeName, null, value, line, col);
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

    public boolean containsExpressions() {
        return false;
    }

    public boolean isDynamic() {
        return false;
    }

    public String getNamespaceUri() {
        return null;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public String getTextContent() {
        if (textContent != null) {
            return textContent;
        }

        return (attributeNameSpace == null ? "" : attributeNameSpace + ":") + attributeName + "=\"" + value.replaceAll("\"", "\\\"") + "\"";
    }

    public boolean isWhiteSpace() {
        return false;
    }

    public boolean preserveWhitespace() {
        return true;
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return col;
    }
}