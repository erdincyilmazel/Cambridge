package cambridge.parser.model;

import cambridge.ExpressionParsingException;
import cambridge.parser.expressions.Expression;
import cambridge.parser.expressions.ExpressionLexer;
import cambridge.parser.expressions.ExpressionParser;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;

/**
 * Represents cambridge expressions that are used inside an HTML tag.
 */
public class ExpressionTagPart extends TagPart {
   private Expression expression;


   public ExpressionTagPart(String textContent) {
      super(textContent);
   }

   @Override
   public boolean isWhiteSpace() {
      return false;
   }

   public Expression parseExpression() throws ExpressionParsingException {
      if (expression == null) {
         try {
            ANTLRStringStream stream = new ANTLRStringStream(textContent);
            ExpressionLexer lexer = new ExpressionLexer(stream);
            TokenStream tokenStream = new CommonTokenStream(lexer);
            ExpressionParser parser = new ExpressionParser(tokenStream);
            expression = parser.compilationUnit();

            if (parser.getErrors() != null) {
               throw new ExpressionParsingException(parser.getErrors());
            }
         } catch (RecognitionException e) {
            throw new ExpressionParsingException(e);
         }
      }

      return expression;
   }
}
