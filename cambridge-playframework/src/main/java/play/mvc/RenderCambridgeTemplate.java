package play.mvc;

import cambridge.PlayTemplateLoader;
import cambridge.Template;
import cambridge.TemplateFactory;
import play.exceptions.UnexpectedException;
import play.libs.MimeTypes;
import play.mvc.results.Result;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Erdinc Yilmazelyilmazel
 * Date: 1/7/11
 * Time: 10:48 PM
 */
public class RenderCambridgeTemplate extends Result {
   static ConcurrentHashMap<String, TemplateFactory> parsedTemplates = new ConcurrentHashMap<String, TemplateFactory>();
   static PlayTemplateLoader templateLoader = new PlayTemplateLoader();

   public static TemplateFactory getTemplateFactory(String templateName) {
      TemplateFactory factory = parsedTemplates.get(templateName);
      if (factory != null) {
         return factory;
      }

      factory = templateLoader.newTemplateFactory(templateName);

      TemplateFactory f = parsedTemplates.putIfAbsent(templateName, factory);

      return f == null ? factory : f;
   }

   String templateName;
   Map<String, Object> args;

   public RenderCambridgeTemplate(String templateName, Map<String, Object> args) {
      this.templateName = templateName;
      this.args = args;
   }

   @Override
   public void apply(Http.Request request, Http.Response response) {
      TemplateFactory tf = getTemplateFactory(templateName);

      final String contentType = MimeTypes.getContentType(templateName, "text/plain");

      Template template = tf.createTemplate(args);

      try {
         OutputStreamWriter out = new OutputStreamWriter(response.out);
         template.printTo(out);
         out.flush();
         setContentTypeIfNotSet(response, contentType);
      } catch (IOException e) {
         throw new UnexpectedException(e);
      }
   }
}
