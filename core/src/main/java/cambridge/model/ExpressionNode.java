package cambridge.model;

import cambridge.ExpressionEvaluationException;
import cambridge.ExpressionParsingException;
import cambridge.TemplateEvaluationException;
import cambridge.parser.expressions.Expression;
import cambridge.parser.expressions.ExpressionLexer;
import cambridge.parser.expressions.ExpressionParser;
import cambridge.runtime.DefaultTemplateBindings;
import cambridge.runtime.Filter;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;

import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;

/**
 * ExpressionNodes are nodes within the documents that are
 * valid cambridge template expressions. Expression nodes
 */
public class ExpressionNode extends TemplateNode implements AttributeFragment {
   final String value;
   Expression expression;

   ArrayList<F> filters;

   class F {
      final Filter filter;
      final String parameters;

      F(Filter filter, String parameters) {
         this.filter = filter;
         this.parameters = parameters;
      }
   }

   public ExpressionNode(String value) throws ExpressionParsingException {
      this.value = value;
      try {
         ANTLRStringStream stream = new ANTLRStringStream(value);
         ExpressionLexer lexer = new ExpressionLexer(stream);
         TokenStream tokenStream = new CommonTokenStream(lexer);
         ExpressionParser parser = new ExpressionParser(tokenStream);
         expression = parser.compilationUnit();
         if (parser.getErrors() != null) {
            throw new ExpressionParsingException(parser.getErrors());
         }
      } catch (RecognitionException e) {
         throw new ExpressionParsingException(e);
      }
   }

   public void setFilters(ArrayList<String> f) {
      filters = new ArrayList<F>();
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

         Filter filter = Filter.getInstance(name);
         if (filter != null) {
            filters.add(new F(filter, params));
         }
      }

      if(filters.size() == 0) {
         filters = null;
      }
   }

   public String getSource() {
      return "${" + value + "}";
   }

   public void print(PrintStream out) {
      out.print("${");
      out.print(value);
      out.print("}");
   }

   @Override
   public void normalize(FragmentList f) {
      f.addFragment(this);
   }

   @Override
   public boolean normalizeUntil(TemplateNode reference, FragmentList f, boolean inclusive) {
      if (reference == this) {
         if (inclusive) {
            f.addFragment(this);
         }
         return true;
      } else {
         f.addFragment(this);
         return false;
      }
   }

   @Override
   public TagNode getElementById(String id) {
      return null;
   }

   public void eval(Map<String, Object> bindings, Appendable out) throws IOException, TemplateEvaluationException {
      try {
         Object value = expression.eval(bindings);
         if (value != null) {
            out.append(applyFilters(value, DefaultTemplateBindings.getLocaleFromBindings(bindings)));
         }
      } catch (ExpressionEvaluationException e) {
         throw new TemplateEvaluationException("Could not execute the expression: " + e.getMessage(), getBeginLine(), getBeginColumn(), value);
      }
   }

   public void pack() {
   }

   public String toString() {
      return getSource();
   }

   private String applyFilters(Object o, Locale locale) {
      if (filters == null) return o.toString();
      String val = "";
      for (int i = 0; i < filters.size(); i++) {
         F f = filters.get(i);
         if (i == 0) {
            val = f.filter.doFilter(o, f.parameters, locale);
         } else {
            val = f.filter.doFilter(val, f.parameters, locale);
         }
      }

      return val;
   }
}
