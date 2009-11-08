package cambridge;

import cambridge.model.FragmentList;

/**
 * User: erdinc
 * Date: Nov 3, 2009
 * Time: 12:37:29 AM
 */
public class TemplateFactory {
   protected FragmentList fragments;
   protected TemplateLoader loader;

   public TemplateFactory(TemplateLoader loader, FragmentList fragments) {
      this.loader = loader;
      this.fragments = fragments;
   }

   public Template createTemplate() {
      return new DynamicTemplate(fragments);
   }
}
