package cambridge;

import cambridge.model.Fragment;
import cambridge.model.FragmentList;
import cambridge.runtime.DefaultTemplateBindings;

import java.io.IOException;
import java.util.Locale;
import java.util.Map;

/**
 * User: erdinc
 * Date: Oct 13, 2009
 * Time: 3:38:35 PM
 */
public class DynamicTemplate implements Template {

   private final FragmentList fragments;

   public DynamicTemplate(FragmentList fragments, Locale locale) {
      this.fragments = fragments;
      bindings = new DefaultTemplateBindings(locale);
   }

   public DynamicTemplate(FragmentList fragments) {
      this.fragments = fragments;
      bindings = new DefaultTemplateBindings();
   }

   public DynamicTemplate(FragmentList fragments, Map<String, Object> bindings) {
      this.fragments = fragments;
      this.bindings = bindings;
   }

   private final Map<String, Object> bindings;

   public void setProperty(String name, Object property) {
      bindings.put(name, property);
   }

   public void setAllProperties(Map<String, Object> properties) {
      bindings.putAll(properties);
   }

   public void clearProperties() {
      bindings.clear();
   }

   public void printTo(Appendable out) throws IOException, TemplateEvaluationException {
      bindings.remove("#this");
      bindings.remove("#super");
      bindings.remove("#iter");
      for (Fragment f : fragments) {
         f.eval(bindings, out);
      }
   }

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
