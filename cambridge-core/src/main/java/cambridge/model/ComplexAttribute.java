package cambridge.model;

import java.util.ArrayList;

public class ComplexAttribute implements Attribute {
    private String textContent;
    String attributeName;
    String attributeNameSpace;
    private ArrayList<AttributeFragment> fragments;
    private final int line;
    private final int col;

    public ComplexAttribute(int line, int col) {
        this.line = line;
        this.col = col;
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
        return "";
    }

    public ArrayList<AttributeFragment> getFragments() {
        return fragments;
    }

    public void setFragments(ArrayList<AttributeFragment> fragments) {
        this.fragments = fragments;
    }

    public boolean containsExpressions() {
        return false;
    }

    private char quote;

    public char getQuote() {
        return quote;
    }

    public void setQuote(char quote) {
        this.quote = quote;
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

    @Override
    public int getLine() {
        return line;
    }

    @Override
    public int getColumn() {
        return col;
    }

    public String getTextContent() {
        if (textContent != null) {
            return textContent;
        }

        return "";
    }

    public boolean isWhiteSpace() {
        return false;
    }

    public boolean preserveWhitespace() {
        return true;
    }
}