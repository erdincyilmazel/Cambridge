package cambridge;

import cambridge.model.FragmentList;
import cambridge.model.Tag;
import cambridge.model.TemplateNode;

/**
 * User: erdinc
 * Date: May 18, 2010
 * Time: 9:35:44 AM
 */
public class NamespaceDirective extends TemplateNode {
   private final String name;
   private final String uri;

   public NamespaceDirective(String name, String uri) {
      this.name = name;
      this.uri = uri;
   }

   @Override
   public void normalize(FragmentList f) throws BehaviorInstantiationException {
      //
   }

   @Override
   public boolean normalizeUntil(TemplateNode reference, FragmentList f, boolean inclusive) throws BehaviorInstantiationException {
      return false;
   }

   @Override
   public Tag getElementById(String id) {
      return null;
   }

   @Override
   public String toString() {
      return "NamespaceDirective{" +
         "name='" + name + '\'' +
         ", uri='" + uri + '\'' +
         '}';
   }
}
