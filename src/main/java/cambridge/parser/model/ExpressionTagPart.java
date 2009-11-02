package cambridge.parser.model;

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

   public Expression parseExpression() throws RecognitionException {
      if (expression == null) {
         ANTLRStringStream stream = new ANTLRStringStream(textContent);
         ExpressionLexer lexer = new ExpressionLexer(stream);
         TokenStream tokenStream = new CommonTokenStream(lexer);
         ExpressionParser parser = new ExpressionParser(tokenStream);
         expression = parser.compilationUnit();
      }

      return expression;
   }
}
