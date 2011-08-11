package cambridge.model;

/**
 * Arbitrary text within a tag element
 */
public class TextTagPart implements TagPart {
    private String textContent;
    private final int line;
    private final int col;

    public TextTagPart(String textContent, int line, int col) {
        this.textContent = textContent;
        this.line = line;
        this.col = col;
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
        return textContent;
    }

    @Override
    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public boolean isWhiteSpace() {
        return whitespace;
    }

    public boolean preserveWhitespace() {
        return true;
    }

    public boolean whitespace;
}
