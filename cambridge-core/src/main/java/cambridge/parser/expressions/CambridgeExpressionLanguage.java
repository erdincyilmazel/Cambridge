package cambridge.parser.expressions;

import cambridge.ExpressionLanguage;
import cambridge.ExpressionParsingException;
import cambridge.model.Expression;
import cambridge.runtime.ExpressionContext;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;

import java.util.Locale;

/**
 * @author Erdinc YILMAZEL
 * @since 1/31/11
 */
public class CambridgeExpressionLanguage implements ExpressionLanguage {
   public Expression parse(String expressionString, int line, int column) throws ExpressionParsingException {
      try {
         ANTLRStringStream stream = new ANTLRStringStream(expressionString);
         ExpressionLexer lexer = new ExpressionLexer(stream);
         TokenStream tokenStream = new CommonTokenStream(lexer);
         ExpressionParser parser = new ExpressionParser(tokenStream);
         CambridgeExpression e = parser.compilationUnit();

         if (parser.getErrors() != null) {
            throw new CambridgeExpressionParsingException(line, column, expressionString, parser.getErrors());
         }

         return e;
      } catch (RecognitionException e) {
         throw new CambridgeExpressionParsingException(line, column, expressionString, e);
      }
   }

   public String wrapExpressionAsList(String expr) {
      return "[" + expr + "]";
   }

    @Override
    public ExpressionContext createNewContext(Locale locale)
    {
        return new MapExpressionContext(locale);
    }

    @Override
    public ExpressionContext createNewContext()
    {
        return new MapExpressionContext(null);
    }
}
