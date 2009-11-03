package cambridge.parser.expressions;

import cambridge.ExpressionParsingException;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;

/**
 * User: erdinc
 * Date: Nov 3, 2009
 * Time: 1:42:15 AM
 */
public class Expressions {
   public static Expression parse(String ex) throws ExpressionParsingException {
      try {
         ANTLRStringStream stream = new ANTLRStringStream(ex);
         ExpressionLexer lexer = new ExpressionLexer(stream);
         TokenStream tokenStream = new CommonTokenStream(lexer);
         ExpressionParser parser = new ExpressionParser(tokenStream);
         Expression e = parser.compilationUnit();

         if (parser.getErrors() != null) {
            throw new ExpressionParsingException(parser.getErrors());
         }

         return e;
      } catch (RecognitionException e) {
         throw new ExpressionParsingException(e);
      }
   }
}
