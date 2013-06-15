package cambridge;

import cambridge.model.Fragment;
import cambridge.model.FragmentList;
import cambridge.runtime.ExpressionContext;

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
      context = Expressions.getDefaultExpressionLanguage().createNewContext(locale);
   }

   public DynamicTemplate(FragmentList fragments) {
      this.fragments = fragments;
      context = Expressions.getDefaultExpressionLanguage().createNewContext();
   }

   public DynamicTemplate(FragmentList fragments, ExpressionContext context) {
      this.fragments = fragments;
      this.context = context;
   }

   private final ExpressionContext context;

   public void setProperty(String name, Object property) {
      context.set(name, property);
   }

   public void setAllProperties(Map<String, Object> properties) {
      context.setVariables(properties);
   }

   public void printTo(Writer out) throws IOException, TemplateEvaluationException {
      for (Fragment f : fragments) {
         f.eval(context, out);
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
         f.eval(context, writer);
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
