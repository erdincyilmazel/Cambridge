package cambridge.model;

import cambridge.ExpressionParsingException;
import cambridge.Expressions;

/**
 * DynamicAttributes are attributes which are registered with the {@link cambridge.Cambridge}
 * class and which carry a dynamic behavior on.
 */
public class DynamicAttribute implements Attribute {

   private String attributeName;
   private String attributeNameSpace;
   private String value;
   private final String namespaceUri;

   public DynamicAttribute(String namespaceUri) {
      this.namespaceUri = namespaceUri;
   }

   public String getNamespaceUri() {
      return namespaceUri;
   }

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
         expression = Expressions.parse(value);
      }
      return expression;
   }

   public boolean isWhiteSpace() {
      return false;
   }
}
