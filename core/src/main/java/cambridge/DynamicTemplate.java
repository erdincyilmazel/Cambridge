package cambridge;

import cambridge.model.Fragment;
import cambridge.model.FragmentList;
import cambridge.runtime.DefaultTemplateBindings;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
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

   public void printTo(Writer out) throws IOException, TemplateEvaluationException {
      for (Fragment f : fragments) {
         f.eval(bindings, out);
      }
   }

   public void printTo(Writer out, boolean buffered) throws IOException, TemplateEvaluationException {
      if (buffered) {
         BufferedWriter writer = new BufferedWriter(out);
         for (Fragment f : fragments) {
            f.eval(bindings, writer);
         }
      } else {
         printTo(out);
      }
   }

   public String asString() throws TemplateEvaluationException {
      StringWriter writer = new StringWriter();
      try {
         printTo(writer);
         return writer.toString();
      } catch (IOException e) {
         return "";
      }
   }
}
