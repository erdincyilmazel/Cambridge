package cambridge.springwebmvc;

import cambridge.Template;
import cambridge.TemplateFactory;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.view.AbstractTemplateView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;
import java.util.Map;

/**
 * @author Erdinc YILMAZEL
 * @since 1/29/11
 */
public class CambridgeTemplateView extends AbstractTemplateView {
   TemplateFactory templateFactory;

   @Override
   protected void renderMergedTemplateModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
      exposeModelAsRequestAttributes(model, request);

      if (logger.isDebugEnabled()) {
         logger.debug("Rendering Cambridge template [" + getUrl() + "] in CambridgeTemplateView '" + getBeanName() + "'");
      }

      // Grab the locale-specific version of the template.
      Locale locale = RequestContextUtils.getLocale(request);

      Template template = templateFactory.createTemplate(locale);
      template.printTo(response.getWriter());
   }
}
