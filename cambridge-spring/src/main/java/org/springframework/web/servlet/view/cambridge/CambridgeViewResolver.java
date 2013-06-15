package org.springframework.web.servlet.view.cambridge;

import org.springframework.web.servlet.view.AbstractTemplateViewResolver;

/**
 * @author Erdinc Yilmazel (eyilmazel@tripadvisor.com)
 * @since 6/13/13
 */
public class CambridgeViewResolver extends AbstractTemplateViewResolver
{
    public CambridgeViewResolver()
    {
        setViewClass(requiredViewClass());
    }

    @Override
    protected Class requiredViewClass()
    {
        return CambridgeView.class;
    }
}
