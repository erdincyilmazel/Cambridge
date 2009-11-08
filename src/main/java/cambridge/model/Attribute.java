package cambridge.model;

/**
 * <p>There are two known types of Attributes.
 *
 * These are
 * <ul>
 * <li>{@link DynamicAttribute}</li><li>{@link SimpleAttribute}</li></ul></p>
 *
 * <p>For an attribute to be parsed as a DynamicAttribute, it should have a namespace portion and the attribute
 * name should be registered with the {@link cambridge.Behaviors} class</p>
 */
public interface Attribute {
   /**
    * Returns the name of the attribute
    * @return Attribute name
    */
   String getAttributeName();

   /**
    * Sets the attribute name.
    * @param attributeName The attribute name
    */
   void setAttributeName(String attributeName);

   /**
    * If the a namespace is defined for the attribute, this method returns it,
    * otherwise it returns null
    *
    * @return Returns attribute namespace
    */
   String getAttributeNameSpace();

   /**
    * Sets the attribute namespace
    * @param attributeNameSpace Attribute namespace
    */
   void setAttributeNameSpace(String attributeNameSpace);

   /**
    * <p>Returns the attribute value.</p>
    *
    * <p>This returns the part of the attribute that is after the = character.
    * If the value is defined within quotes or double quotes, they are ignored.</p>
    *
    * @return The value of the attribute
    */
   String getValue();

   /**
    * Sets the value of the Attribute
    * @param value Attribute value
    */
   void setValue(String value);

   /**
    * If this attribute type is registered with the {@link cambridge.Behaviors} class, it should
    * return true.
    * @return Returns if this attribute holds a dynamic behavior
    */
   public boolean isDynamic();
}
