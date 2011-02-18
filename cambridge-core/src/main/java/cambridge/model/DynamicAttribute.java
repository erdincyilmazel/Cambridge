package cambridge.model;

import cambridge.ExpressionParsingException;

/**
 * DynamicAttributes are attributes which are registered with the {@link cambridge.Cambridge}
 * class and which carry a dynamic behavior on.
 */
public class DynamicAttribute implements Attribute {

   private String attributeName;
   private String attributeNameSpace;
   private String value;
   private final String namespaceUri;
   private Expression expression;

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

   public void setValue(String value, Expression expression) {
      this.value = value;
      this.expression = expression;
   }

   public boolean isDynamic() {
      return true;
   }

   public String getTextContent() {
      return value;
   }

   public void setTextContent(String textContent) {
   }

   public Expression getExpression() throws ExpressionParsingException {
      return expression;
   }

   public boolean isWhiteSpace() {
      return false;
   }
}
