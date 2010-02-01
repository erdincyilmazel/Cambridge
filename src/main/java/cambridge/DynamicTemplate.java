package cambridge;

import cambridge.model.Fragment;
import cambridge.model.FragmentList;
import cambridge.runtime.TemplateProperties;

import java.io.IOException;
import java.util.Locale;

/**
 * User: erdinc
 * Date: Oct 13, 2009
 * Time: 3:38:35 PM
 */
public class DynamicTemplate implements Template {

   final FragmentList fragments;

   public DynamicTemplate(FragmentList fragments, Locale locale) {
      this.fragments = fragments;
      properties = new TemplateProperties(locale);
   }

   public DynamicTemplate(FragmentList fragments) {
      this.fragments = fragments;
      properties = new TemplateProperties();
   }

   TemplateProperties properties;

   @Override
   public void setProperty(String name, Object property) {
      properties.put(name, property);
   }

   @Override
   public void printTo(Appendable out) throws IOException, TemplateEvaluationException {
      properties.put("this", null);
      properties.put("super", null);
      for (Fragment f : fragments) {
         f.eval(properties, out);
      }
   }

   @Override
   public String asString() throws TemplateEvaluationException {
      StringBuilder builder = new StringBuilder();
      try {
         printTo(builder);
         return builder.toString();
      } catch (IOException e) {
         return "";
      }
   }
}
