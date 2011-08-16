package cambridge.model;

import cambridge.Cambridge;
import cambridge.ExpressionEvaluationException;
import cambridge.ExpressionParsingException;
import cambridge.TemplateEvaluationException;
import cambridge.runtime.DefaultTemplateBindings;
import cambridge.runtime.EscapeFilter;
import cambridge.runtime.Filter;

import java.io.IOException;
import java.io.PrintStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;

/**
 * ExpressionNodes are nodes within the documents that are
 * valid cambridge template expressions. Expression nodes
 */
public class ExpressionNode extends TemplateNode implements AttributeFragment {
    final String value;
    boolean raw;
    Expression expression;

    ArrayList<Filter> filters;

    public ExpressionNode(String value, Expression expression) throws ExpressionParsingException {
        this(value, expression, false);
    }

    public ExpressionNode(String value, Expression expression, boolean raw) throws ExpressionParsingException {
        this.value = value;
        this.expression = expression;
        this.raw = raw;
    }

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

            Filter filter = Cambridge.getInstance().getFilter(name, getBeginLine(), getBeginColumn());
            if (filter != null) {
                filter.init(params);
                filters.add(filter);
            }
        }

        if (filters.size() == 0) {
            filters = null;
        }
    }

    public String getSource() {
        return (raw ? "%{" : "${") + value + "}";
    }

    public void print(PrintStream out) {
        out.print((raw ? "%{" : "${"));
        out.print(value);
        out.print("}");
    }

    @Override
    void normalize(TemplateDocument doc, FragmentList f) {
        f.addFragment(this);
    }

    @Override
    boolean normalizeUntil(TemplateDocument doc, TemplateNode reference, FragmentList f, boolean inclusive) {
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

    public void eval(Map<String, Object> bindings, Writer out) throws IOException, TemplateEvaluationException {
        try {
            Object value = expression.eval(bindings);
            if (value != null) {
                String str = applyFilters(value, DefaultTemplateBindings.getLocaleFromBindings(bindings));
                if (raw) {
                    out.write(str);
                } else {
                    out.write(EscapeFilter.doFilter(str));
                }
            }
        } catch (ExpressionEvaluationException e) {
            throw new TemplateEvaluationException(e, "Could not execute the expression: " +
                    e.getMessage() + ", on line: " + getBeginLine() + ", column: " +
                    getBeginColumn(), getBeginLine(), getBeginColumn(), value);
        }
    }

    public void pack() {
    }

    public String toString() {
        return getSource();
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
}
