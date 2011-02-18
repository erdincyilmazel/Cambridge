package cambridge;

/**
 * User: erdinc
 * Date: Nov 3, 2009
 * Time: 5:59:39 PM
 */
public class TemplateReloadingException extends RuntimeException {
   public TemplateReloadingException() {
   }

   public TemplateReloadingException(String message) {
      super(message);
   }

   public TemplateReloadingException(String message, Throwable cause) {
      super(message, cause);
   }

   public TemplateReloadingException(Throwable cause) {
      super(cause);
   }
}
