package cambridge.springwebmvc;

import org.springframework.web.servlet.view.AbstractTemplateViewResolver;

/**
 * @author Erdinc YILMAZEL
 * @since 1/29/11
 */
public class CambridgeTemplateViewResolver extends AbstractTemplateViewResolver {
   public CambridgeTemplateViewResolver() {
      setViewClass(requiredViewClass());
   }

   /**
    * Requires {@link org.springframework.web.servlet.view.freemarker.FreeMarkerView}.
    */
   @Override
   protected Class requiredViewClass() {
      return CambridgeTemplateView.class;
   }
}
