package cambridge;

import cambridge.model.FragmentList;

import java.util.Locale;
import java.util.Map;

/**
 * @author Erdinc Yilmazel
 * Date: May 19, 2010
 * Time: 9:03:28 AM
 */
class ImmutableTemplateFactory extends TemplateFactory {
   public ImmutableTemplateFactory(TemplateLoader loader, FragmentList fragments) {
      super(loader, fragments);
   }

   @Override
   public Template createTemplate() {
      return new DynamicTemplate(fragments);
   }

   @Override
   public Template createTemplate(Locale locale) {
      return new DynamicTemplate(fragments, locale);
   }

   @Override
   public Template createTemplate(Map<String, Object> bindings) {
      return new DynamicTemplate(fragments, bindings);
   }
}
