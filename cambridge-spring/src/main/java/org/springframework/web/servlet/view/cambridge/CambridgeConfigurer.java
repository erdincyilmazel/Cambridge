package org.springframework.web.servlet.view.cambridge;

import cambridge.DirectoryTemplateLoader;
import cambridge.ExpressionLanguage;
import cambridge.Expressions;
import cambridge.TemplateFactory;
import cambridge.TemplateLoader;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Erdinc Yilmazel (eyilmazel@tripadvisor.com)
 * @since 6/13/13
 */
public class CambridgeConfigurer implements CambridgeConfig, InitializingBean, ServletContextAware
{
    private String templateEncoding = "utf-8";
    private String templatePath;
    private int changeDetectionInterval = 5000;
    private String templateExtension = "html";
    private String expressionLanguage = "spel";
    private ServletContext servletContext;
    private TemplateLoader templateLoader;
    private ConcurrentHashMap<String, TemplateFactory> cachedTemplates = new ConcurrentHashMap<String, TemplateFactory>();
    private ExpressionLanguage exp;

    @Override
    public void afterPropertiesSet() throws Exception
    {
        Expressions.registerExpressionLanguage(expressionLanguage, SpringExpressionLanguage.class);
        templateLoader = new DirectoryTemplateLoader(new File(servletContext.getRealPath(templatePath)), templateEncoding, changeDetectionInterval);
        exp = Expressions.getExpressionLanguageByName(expressionLanguage);
    }

    @Override
    public void setServletContext(ServletContext servletContext)
    {
        this.servletContext = servletContext;
    }

    public void setTemplatePath(String templatePath)
    {
        this.templatePath = templatePath;
    }

    public String getTemplatePath()
    {
        return templatePath;
    }

    public String getTemplateEncoding()
    {
        return templateEncoding;
    }

    public void setTemplateEncoding(String templateEncoding)
    {
        this.templateEncoding = templateEncoding;
    }

    public int getChangeDetectionInterval()
    {
        return changeDetectionInterval;
    }

    public void setChangeDetectionInterval(int changeDetectionInterval)
    {
        this.changeDetectionInterval = changeDetectionInterval;
    }

    public String getTemplateExtension()
    {
        return templateExtension;
    }

    public void setTemplateExtension(String templateExtension)
    {
        this.templateExtension = templateExtension;
    }

    public TemplateLoader getTemplateLoader()
    {
        return templateLoader;
    }

    public ExpressionLanguage getExpressionLanguage()
    {
        return exp;
    }

    public void setExpressionLanguage(String expressionLanguage)
    {
        this.expressionLanguage = expressionLanguage;
    }

    @Override
    public TemplateFactory getTemplateFactory(String template)
    {
        TemplateFactory templateFactory = cachedTemplates.get(template);
        if (templateFactory != null)
        {
            return templateFactory;
        }

        templateFactory = templateLoader.newTemplateFactory(template, exp);

        cachedTemplates.putIfAbsent(template, templateFactory);
        return templateFactory;
    }
}
