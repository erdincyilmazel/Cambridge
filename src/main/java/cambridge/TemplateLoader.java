package cambridge;

import cambridge.model.TemplateDocument;

/**
 * User: erdinc
 * Date: Nov 6, 2009
 * Time: 11:35:46 PM
 */
public interface TemplateLoader {
   TemplateFactory newTemplateFactory(String template) throws TemplateLoadingException;

   TemplateFactory newTemplateFactory(String template, String encoding) throws TemplateLoadingException;

   TemplateFactory newTemplateFactory(String template, TemplateModifier modifier) throws TemplateLoadingException;

   TemplateFactory newTemplateFactory(String template, String encoding, TemplateModifier modifier) throws TemplateLoadingException;

   TemplateDocument parseTemplate(String template) throws TemplateLoadingException;

   TemplateDocument parseTemplate(String template, String encoding) throws TemplateLoadingException;
}
