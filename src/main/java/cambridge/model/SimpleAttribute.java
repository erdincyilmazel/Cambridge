package cambridge.model;

public class SimpleAttribute extends TagPart implements Attribute {
   String attributeName;
   String attributeNameSpace;
   String value;

   public SimpleAttribute() {
   }

   public SimpleAttribute(String attributeName, String attributeNameSpace, String value) {
      this.attributeName = attributeName;
      this.attributeNameSpace = attributeNameSpace;
      this.value = value;
   }

   public SimpleAttribute(String attributeName, String value) {
      this.attributeName = attributeName;
      this.value = value;
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

   @Override
   public boolean isDynamic() {
      return false;
   }

   @Override
   public String getTextContent() {
      if (textContent != null) {
         return textContent;
      }

      return (attributeNameSpace == null ? "" : attributeNameSpace + ":") + attributeName + "=\"" + value.replaceAll("\"", "\\\"") + "\"";
   }

   @Override
   public boolean isWhiteSpace() {
      return false;
   }
}