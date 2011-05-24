package cambridge.parser.expressions;

import cambridge.ExpressionLanguage;
import cambridge.ExpressionParsingException;
import cambridge.model.Expression;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;

/**
 * @author Erdinc YILMAZEL
 * @since 1/31/11
 */
public class CambridgeExpressionLanguage implements ExpressionLanguage {
   public Expression parse(String expressionString) throws ExpressionParsingException {
      try {
         ANTLRStringStream stream = new ANTLRStringStream(expressionString);
         ExpressionLexer lexer = new ExpressionLexer(stream);
         TokenStream tokenStream = new CommonTokenStream(lexer);
         ExpressionParser parser = new ExpressionParser(tokenStream);
         CambridgeExpression e = parser.compilationUnit();

         if (parser.getErrors() != null) {
            throw new CambridgeExpressionParsingException(expressionString, parser.getErrors());
         }

         return e;
      } catch (RecognitionException e) {
         throw new CambridgeExpressionParsingException(expressionString, e);
      }
   }

   public String wrapExpressionAsList(String expr) {
      return "[" + expr + "]";
   }
}
