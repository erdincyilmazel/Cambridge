package cambridge;

import cambridge.model.AttributeKey;

/**
 * DynamicAttributeKey is a simple java bean to identify a dynamic tag attribute.
 *
 * It holds the attribute namespace uri, attribute name and the namespace short name (Eg: a: )
 */
public class DynamicAttributeKey {
   private final String uri;
   private final String attribute;
   private final String namespace;

   public DynamicAttributeKey(String uri, String namespace, String attribute) {
      if (uri == null || namespace == null) {
         throw new IllegalArgumentException("URI or namespace can not be null");
      }
      this.uri = uri;
      this.namespace = namespace;
      this.attribute = attribute;
   }

   public AttributeKey toAttributeKey() {
      return new AttributeKey(namespace, attribute);
   }

   public String getNamespace() {
      return namespace;
   }

   public String getUri() {
      return uri;
   }

   public String getAttribute() {
      return attribute;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      DynamicAttributeKey that = (DynamicAttributeKey) o;

      return attribute.equals(that.attribute) && uri.equals(that.uri);
   }

   @Override
   public int hashCode() {
      int result = uri.hashCode();
      result = 31 * result + attribute.hashCode();
      return result;
   }
}
