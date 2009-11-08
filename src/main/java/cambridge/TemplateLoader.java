package cambridge;

import cambridge.model.TemplateDocument;

import java.io.File;
import java.util.HashSet;

/**
 * User: erdinc
 * Date: Nov 6, 2009
 * Time: 11:35:46 PM
 */
public interface TemplateLoader {
   TemplateFactory newTemplateFactory(File template) throws TemplateLoadingException;

   TemplateFactory newTemplateFactory(File template, String encoding) throws TemplateLoadingException;

   TemplateFactory newTemplateFactory(File template, TemplateModifier modifier) throws TemplateLoadingException;

   TemplateFactory newTemplateFactory(File template, String encoding, TemplateModifier modifier) throws TemplateLoadingException;

   TemplateDocument parseTemplate(File template) throws TemplateLoadingException;

   TemplateDocument parseTemplate(File template, String encoding) throws TemplateLoadingException;
   
   TemplateFactory newTemplateFactory(String template) throws TemplateLoadingException;

   TemplateFactory newTemplateFactory(String template, String encoding) throws TemplateLoadingException;

   TemplateFactory newTemplateFactory(String template, TemplateModifier modifier) throws TemplateLoadingException;

   TemplateFactory newTemplateFactory(String template, String encoding, TemplateModifier modifier) throws TemplateLoadingException;

   TemplateDocument parseTemplate(String template) throws TemplateLoadingException;

   TemplateDocument parseTemplate(String template, String encoding) throws TemplateLoadingException;

   HashSet<File> getFiles(HashSet<String> fileNames);
}
