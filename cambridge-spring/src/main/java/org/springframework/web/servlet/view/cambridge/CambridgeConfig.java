package org.springframework.web.servlet.view.cambridge;

import cambridge.ExpressionLanguage;
import cambridge.TemplateFactory;
import cambridge.TemplateLoader;

/**
 * @author Erdinc Yilmazel (eyilmazel@tripadvisor.com)
 * @since 6/13/13
 */
public interface CambridgeConfig
{
    public TemplateFactory getTemplateFactory(String template);

    public TemplateLoader getTemplateLoader();

    public String getTemplateExtension();

    public String getExpressionLanguage();

    public ExpressionLanguage getExpressionLanguageImplementation();

    public String getTemplateEncoding();

    public int getChangeDetectionInterval();

    public String getTemplatePath();
}
