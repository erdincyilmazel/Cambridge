package cambridge;

/**
 * User: erdinc
 * Date: Nov 1, 2009
 * Time: 1:15:50 PM
 */
public class AttributeKey {
   private final String namespace;
   private final String attribute;

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      AttributeKey that = (AttributeKey) o;

      return attribute.equals(that.attribute) && !(namespace != null ? !namespace.equals(that.namespace) : that.namespace != null);
   }

   @Override
   public int hashCode() {
      int result = namespace != null ? namespace.hashCode() : 0;
      result = 31 * result + attribute.hashCode();
      return result;
   }

   public AttributeKey(String namespace, String attribute) {
      this.namespace = namespace;
      this.attribute = attribute;
   }
}
