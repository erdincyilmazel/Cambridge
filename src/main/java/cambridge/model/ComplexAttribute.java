package cambridge.model;

import java.util.ArrayList;

public class ComplexAttribute implements Attribute {
   String textContent;
   String attributeName;
   String attributeNameSpace;
   ArrayList<AttributeFragment> fragments;

   public ComplexAttribute() {
   }

   public ComplexAttribute(String attributeName, String attributeNameSpace, ArrayList<AttributeFragment> fragments) {
      this.attributeName = attributeName;
      this.attributeNameSpace = attributeNameSpace;
      this.fragments = fragments;
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
      return "";
   }

   public ArrayList<AttributeFragment> getFragments() {
      return fragments;
   }

   public void setFragments(ArrayList<AttributeFragment> fragments) {
      this.fragments = fragments;
   }

   public boolean containsExpressions() {
      return false;
   }

   char quote;

   public char getQuote() {
      return quote;
   }

   public void setQuote(char quote) {
      this.quote = quote;
   }

   public boolean isDynamic() {
      return false;
   }

   public void setTextContent(String textContent) {
      this.textContent = textContent;
   }

   public String getTextContent() {
      if (textContent != null) {
         return textContent;
      }

      return "";
   }

   public boolean isWhiteSpace() {
      return false;
   }
}