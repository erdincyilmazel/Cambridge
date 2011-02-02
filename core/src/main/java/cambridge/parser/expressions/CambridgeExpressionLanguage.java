package cambridge.parser.expressions;

import cambridge.ExpressionLanguage;
import cambridge.ExpressionParsingException;
import cambridge.model.Expression;
import cambridge.runtime.Iter;
import cambridge.runtime.Super;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;

import java.util.Map;

/**
 * @author Erdinc YILMAZEL
 * @since 1/31/11
 */
public class CambridgeExpressionLanguage implements ExpressionLanguage {
   public Expression parse(String ex) throws ExpressionParsingException {
      try {
         ANTLRStringStream stream = new ANTLRStringStream(ex);
         ExpressionLexer lexer = new ExpressionLexer(stream);
         TokenStream tokenStream = new CommonTokenStream(lexer);
         ExpressionParser parser = new ExpressionParser(tokenStream);
         CambridgeExpression e = parser.compilationUnit();

         if (parser.getErrors() != null) {
            throw new CambridgeExpressionParsingException(ex, parser.getErrors());
         }

         return e;
      } catch (RecognitionException e) {
         throw new CambridgeExpressionParsingException(ex, e);
      }
   }
}
