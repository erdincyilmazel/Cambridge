package org.springframework.web.servlet.view.cambridge;

import cambridge.Template;
import cambridge.TemplateFactory;
import cambridge.runtime.ExpressionContext;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContextException;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.view.AbstractTemplateView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;
import java.util.Map;

/**
 * @author Erdinc Yilmazel (eyilmazel@tripadvisor.com)
 * @since 6/13/13
 */
public class CambridgeView extends AbstractTemplateView
{
    CambridgeConfig cambridgeConfig;

    public CambridgeConfig getCambridgeConfig()
    {
        return cambridgeConfig;
    }

    public void setCambridgeConfig(CambridgeConfig cambridgeConfig)
    {
        this.cambridgeConfig = cambridgeConfig;
    }

    @Override
    protected void renderMergedTemplateModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String url = getUrl();

        String templateExtension = cambridgeConfig.getTemplateExtension();
        if (!url.endsWith(templateExtension))
        {
            url = url + "." + templateExtension;
        }

        Locale locale = RequestContextUtils.getLocale(request);

        TemplateFactory templateFactory = cambridgeConfig.getTemplateFactory(url);
        SpringExpressionLanguage expressionLanguage = cambridgeConfig.getExpressionLanguage();
        ExpressionContext context = expressionLanguage.createNewContext(locale);
        context.setVariables(model);
        Template template = templateFactory.createTemplate(context);

        template.printTo(response.getWriter());
    }

    @Override
    protected void initServletContext(ServletContext servletContext)
    {
        if (cambridgeConfig == null)
        {
            cambridgeConfig = autodetectConfiguration();
        }
    }

    @Override
    protected void initApplicationContext() throws BeansException
    {
        super.initApplicationContext();
    }

    protected CambridgeConfig autodetectConfiguration() throws BeansException
    {
        try
        {
            return BeanFactoryUtils.beanOfTypeIncludingAncestors(
                getApplicationContext(), CambridgeConfig.class, true, false);
        }
        catch (NoSuchBeanDefinitionException ex)
        {
            throw new ApplicationContextException(
                "Must define a single FreeMarkerConfig bean in this web application context " +
                    "(may be inherited): FreeMarkerConfigurer is the usual implementation. " +
                    "This bean may be given any name.", ex);
        }
    }
}
