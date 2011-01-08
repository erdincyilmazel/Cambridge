package cambridge;

import cambridge.model.TemplateDocument;

import java.io.InputStream;

/**
 * User: erdinc
 * Date: Nov 6, 2009
 * Time: 11:35:46 PM
 */
public interface TemplateLoader {
   TemplateFactory newTemplateFactory(String templatePath) throws TemplateLoadingException;

   TemplateFactory newTemplateFactory(String templatePath, String encoding) throws TemplateLoadingException;

   TemplateFactory newTemplateFactory(String templatePath, TemplateModifier modifier) throws TemplateLoadingException;

   TemplateFactory newTemplateFactory(String templatePath, String encoding, TemplateModifier modifier) throws TemplateLoadingException;

   TemplateFactory parseAndCreateTemplateFactory(String templateSource) throws TemplateLoadingException;

   TemplateDocument parseTemplate(InputStream in) throws TemplateLoadingException;

   TemplateDocument parseTemplate(InputStream in, String encoding) throws TemplateLoadingException;

   TemplateDocument parseTemplate(String templatePath) throws TemplateLoadingException;

   TemplateDocument parseTemplate(String templatePath, String encoding) throws TemplateLoadingException;

   TemplateDocument parseAndCreateTemplateDocument(String templateSource) throws TemplateLoadingException;
}
