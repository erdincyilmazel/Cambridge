package cambridge;

import cambridge.model.FragmentList;

import java.util.Locale;

/**
 * @author Erdinc Yilmazel
 *         Date: May 19, 2010
 *         Time: 9:03:28 AM
 */
class ImmutableTemplateFactory extends TemplateFactory
{
    public ImmutableTemplateFactory(TemplateLoader loader, FragmentList fragments)
    {
        super(loader, fragments);
    }

    @Override
    public Template createTemplate()
    {
        return new DynamicTemplate(fragments, fragments.getExpressionLanguage().createNewContext());
    }

    @Override
    public Template createTemplate(Locale locale)
    {
        return new DynamicTemplate(fragments, fragments.getExpressionLanguage().createNewContext(locale));
    }
}
