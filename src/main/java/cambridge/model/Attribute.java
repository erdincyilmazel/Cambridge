package cambridge.model;

/**
 * User: erdinc
 * Date: Nov 1, 2009
 * Time: 1:35:21 PM
 */
public interface Attribute {
   String getAttributeName();

   void setAttributeName(String attributeName);

   String getAttributeNameSpace();

   void setAttributeNameSpace(String attributeNameSpace);

   String getValue();

   void setValue(String value);

   public boolean isDynamic();
}
