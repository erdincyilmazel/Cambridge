package cambridge.model;

import cambridge.BehaviorInstantiationException;
import cambridge.ExpressionLanguage;
import cambridge.TemplateLoader;
import cambridge.TemplateLoadingException;

/**
 * @author Erdinc Yilmazel
 *         Date: Nov 6, 2009
 *         Time: 6:45:33 PM
 */
public class IncludeNode extends TemplateNode
{

    private FragmentList fragments;

    public IncludeNode(TemplateLoader templateLoader, String fileName, ExpressionLanguage expressionLanguage) throws TemplateLoadingException, BehaviorInstantiationException
    {
        this(templateLoader, fileName, expressionLanguage, null);
    }

    public IncludeNode(TemplateLoader templateLoader, String fileName, ExpressionLanguage expressionLanguage, String selector) throws TemplateLoadingException, BehaviorInstantiationException
    {
        TemplateDocument doc = templateLoader.parseTemplate(fileName, expressionLanguage);
        if (selector != null)
        {
            fragments = doc.select(selector);
        }
        else
        {
            fragments = doc.normalize();
        }
    }

    @Override
    void normalize(TemplateDocument doc, FragmentList list) throws BehaviorInstantiationException
    {
        for (Fragment f : fragments)
        {
            if (f instanceof StaticFragment)
            {
                list.append(f.toString());
            }
            else
            {
                list.addFragment(f);
            }
        }
    }

    @Override
    public boolean normalizeUntil(TemplateDocument doc, TemplateNode reference, FragmentList f, boolean inclusive) throws BehaviorInstantiationException
    {
        if (reference == this)
        {
            if (inclusive)
            {
                normalize(doc, f);
            }
            return true;
        }
        else
        {
            normalize(doc, f);
            return false;
        }
    }

    @Override
    public Tag getElementById(String id)
    {
        return null;
    }
}
