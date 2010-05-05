package cambridge.model;

import cambridge.ExpressionParsingException;
import cambridge.parser.expressions.Expression;
import cambridge.parser.expressions.ExpressionLexer;
import cambridge.parser.expressions.ExpressionParser;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;

/**
 * DynamicAttributes are attributes which are registered with the {@link cambridge.Behaviors}
 * class and which carry a dynamic behavior on.
 */
public class DynamicAttribute implements Attribute {

   String attributeName;
   String attributeNameSpace;
   String value;

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
      return value;
   }

   public void setValue(String value) {
      this.value = value;
   }

   public boolean isDynamic() {
      return true;
   }

   public String getTextContent() {
      return value;
   }

   public void setTextContent(String textContent) {
   }

   private Expression expression;

   public Expression getExpression() throws ExpressionParsingException {
      if (expression == null) {
         try {
            ANTLRStringStream stream = new ANTLRStringStream(value);
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

   public boolean isWhiteSpace() {
      return false;
   }
}
