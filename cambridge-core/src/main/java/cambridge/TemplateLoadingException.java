package cambridge;

/**
 * @author Erdinc Yilmazel
 * Date: Nov 3, 2009
 * Time: 3:26:54 PM
 */
public class TemplateLoadingException extends RuntimeException {
   public TemplateLoadingException() {
   }

   public TemplateLoadingException(String message) {
      super(message);
   }

   public TemplateLoadingException(String message, Throwable cause) {
      super(message, cause);
   }

   public TemplateLoadingException(Throwable cause) {
      super(cause);
   }
}
