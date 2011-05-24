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
 * Default Template implementation. The built in TemplateFactory classes creates an
 * instance of DynamicTemplate whenever needed.
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

   public void printBuffered(Writer out) throws IOException, TemplateEvaluationException {
      BufferedWriter writer;
      if (out instanceof BufferedWriter) {
         writer = (BufferedWriter) out;
      } else {
         writer = new BufferedWriter(out);
      }

      for (Fragment f : fragments) {
         f.eval(bindings, writer);
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
