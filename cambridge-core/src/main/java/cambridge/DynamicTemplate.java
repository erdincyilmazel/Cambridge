package cambridge;

import cambridge.model.Fragment;
import cambridge.model.FragmentList;
import cambridge.runtime.ExpressionContext;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

/**
 * Default Template implementation. The built in TemplateFactory classes creates an
 * instance of DynamicTemplate whenever needed.
 */
public class DynamicTemplate implements Template
{
    private final FragmentList fragments;
    private final ExpressionContext context;

    public DynamicTemplate(FragmentList fragments, ExpressionContext context)
    {
        this.fragments = fragments;
        this.context = context;
    }

    public void setProperty(String name, Object property)
    {
        context.put(name, property);
    }

    public void setAllProperties(Map<String, Object> properties)
    {
        context.setVariables(properties);
    }

    public void printTo(Writer out) throws IOException, TemplateEvaluationException
    {
        for (Fragment f : fragments)
        {
            f.eval(context, out);
        }
    }

    public void printBuffered(Writer out) throws IOException, TemplateEvaluationException
    {
        BufferedWriter writer;
        if (out instanceof BufferedWriter)
        {
            writer = (BufferedWriter) out;
        }
        else
        {
            writer = new BufferedWriter(out);
        }

        for (Fragment f : fragments)
        {
            f.eval(context, writer);
        }
    }

    public String asString() throws TemplateEvaluationException
    {
        StringWriter writer = new StringWriter();
        try
        {
            printTo(writer);
            return writer.toString();
        }
        catch (IOException e)
        {
            return "";
        }
    }

    @Override
    public ExpressionContext getContext()
    {
        return context;
    }
}
