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
 * This is a TagPart to represent tag attributes in the Template.
 * If the namespace of the TagPart is the agean namespace then a subclass of
 * this ExpressionAttributeTagPart is created by the parser instead.
 *
 * @see TagPart
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

   @Override
   public boolean isDynamic() {
      return true;
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
}
