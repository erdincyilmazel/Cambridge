package cambridge.model;

import cambridge.Cambridge;
import cambridge.ExpressionEvaluationException;
import cambridge.ExpressionParsingException;
import cambridge.TemplateEvaluationException;
import cambridge.runtime.DefaultTemplateBindings;
import cambridge.runtime.EscapeFilter;
import cambridge.runtime.Filter;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;

/**
 * Represents cambridge expressions that are used inside an HTML tag.
 */
public class ExpressionTagPart implements TagPart, Fragment {
   String textContent;
   private Expression expression;
   private boolean raw;

   ArrayList<Filter> filters;

   public void setFilters(ArrayList<String> f) {
      filters = new ArrayList<Filter>();
      for (String s : f) {
         String name;
         String params;

         int i = s.indexOf(':');
         if (i != -1) {
            name = s.substring(0, i);
            params = s.substring(i + 1).trim();
         } else {
            name = s;
            params = null;
         }

         Filter filter = Cambridge.getInstance().getFilter(name);
         if (filter != null) {
            filter.init(params);
            filters.add(filter);
         }
      }

      if (filters.size() == 0) {
         filters = null;
      }
   }

   public ExpressionTagPart(String textContent, Expression expression, boolean raw) throws ExpressionParsingException {
      this.textContent = textContent;
      this.expression = expression;
      this.raw = raw;
   }

   public boolean isWhiteSpace() {
      return false;
   }

   public void eval(Map<String, Object> bindings, Writer out) throws IOException, TemplateEvaluationException {
      try {
         Object value = expression.eval(bindings);
         if (value != null) {
            Locale locale = (Locale) bindings.get(DefaultTemplateBindings.LocaleVariable);
            if (locale == null) {
               locale = Locale.getDefault();
            }
            String str = applyFilters(value, locale);
            if (raw) {
               out.write(str);
            } else {
               out.write(EscapeFilter.doFilter(str));
            }
         }
      } catch (ExpressionEvaluationException e) {
         throw new TemplateEvaluationException(e);
      }
   }

   public void pack() {
   }

   private String applyFilters(Object o, Locale locale) {
      if (filters == null) return o.toString();
      Object val = o;
      for (int i = 0; i < filters.size(); i++) {
         Filter f = filters.get(i);
         if (i == 0) {
            val = f.doFilter(o, locale);
         } else {
            val = f.doFilter(val, locale);
         }
      }

      return val.toString();
   }

   public String getTextContent() {
      return textContent;
   }

   public void setTextContent(String textContent) {
      this.textContent = textContent;
   }
}
