package cambridge.model;

public class SimpleAttribute implements Attribute {
   private String textContent;
   private String attributeName;
   private String attributeNameSpace;
   private String value;

   public SimpleAttribute() {
   }

   public SimpleAttribute(String attributeName, String attributeNameSpace, String value) {
      this.attributeName = attributeName;
      this.attributeNameSpace = attributeNameSpace;
      this.value = value;
   }

   public SimpleAttribute(String attributeName, String value) {
      this(attributeName, null, value);
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

   public boolean containsExpressions() {
      return false;
   }

   public boolean isDynamic() {
      return false;
   }

   public String getNamespaceUri() {
      return null;
   }

   public void setTextContent(String textContent) {
      this.textContent = textContent;
   }

   public String getTextContent() {
      if (textContent != null) {
         return textContent;
      }

      return (attributeNameSpace == null ? "" : attributeNameSpace + ":") + attributeName + "=\"" + value.replaceAll("\"", "\\\"") + "\"";
   }

   public boolean isWhiteSpace() {
      return false;
   }

   public boolean preserveWhitespace() {
      return true;
   }
}