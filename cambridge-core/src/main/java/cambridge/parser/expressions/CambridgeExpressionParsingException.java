package cambridge.parser.expressions;

import cambridge.ExpressionParsingException;
import org.antlr.runtime.RecognitionException;

import java.util.List;

/**
 * @author Erdinc YILMAZEL
 * @since 1/31/11
 */
public class CambridgeExpressionParsingException extends ExpressionParsingException {
    List<RecognitionException> errors;

    public CambridgeExpressionParsingException(int line, int column, String expression, Throwable cause) {
        super(line, column, expression, cause);
    }

    public CambridgeExpressionParsingException(int line, int column, String expression, List<RecognitionException> errors) {
        super(line, column, expression);
        this.errors = errors;
    }

    public List<RecognitionException> getErrors() {
        return errors;
    }
}
