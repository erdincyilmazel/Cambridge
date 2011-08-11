package cambridge;

/**
 * User: erdinc
 * Date: Nov 2, 2009
 * Time: 6:12:17 PM
 */
public class TemplateEvaluationException extends RuntimeException {
    private int line;
    private int column;
    private String tagName;

    public TemplateEvaluationException(Throwable cause, String message, int line, int column) {
        super(message, cause);
        this.line = line;
        this.column = column;
    }

    public TemplateEvaluationException(Throwable cause, String message, int line, int column, String tagName) {
        super(message, cause);
        this.line = line;
        this.column = column;
        this.tagName = tagName;
    }

    public TemplateEvaluationException(Throwable cause, int line, int column) {
        super(cause);
        this.line = line;
        this.column = column;
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }

    public String getTagName() {
        return tagName;
    }
}
