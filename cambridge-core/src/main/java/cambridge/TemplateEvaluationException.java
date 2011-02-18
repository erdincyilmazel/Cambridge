package cambridge;

/**
 * User: erdinc
 * Date: Nov 2, 2009
 * Time: 6:12:17 PM
 */
public class TemplateEvaluationException extends RuntimeException {
   private int line;
   private int column;
   private String tagName;

   public TemplateEvaluationException(String message, int line, int column) {
      super(message);
      this.line = line;
      this.column = column;
   }

   public TemplateEvaluationException(String message, int line, int column, String tagName) {
      super(message);
      this.line = line;
      this.column = column;
      this.tagName = tagName;
   }

   public TemplateEvaluationException(Throwable cause) {
      super(cause);
   }
}
