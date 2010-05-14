package cambridge;

import cambridge.model.FragmentList;

import java.util.Locale;

/**
 * User: erdinc
 * Date: Nov 3, 2009
 * Time: 12:37:29 AM
 */
public abstract class TemplateFactory {
   protected FragmentList fragments;
   protected final TemplateLoader loader;

   public TemplateFactory(TemplateLoader loader, FragmentList fragments) {
      this.loader = loader;
      this.fragments = fragments;
   }

   public abstract Template createTemplate();

   public abstract Template createTemplate(Locale locale);
}
