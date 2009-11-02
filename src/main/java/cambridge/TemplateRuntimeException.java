package cambridge;

/**
 * User: erdinc
 * Date: Nov 2, 2009
 * Time: 6:12:17 PM
 */
public class TemplateRuntimeException extends Exception {
   int line;
   int column;
   String tagName;

   public TemplateRuntimeException(String message, int line, int column) {
      super(message);
      this.line = line;
      this.column = column;
   }

   public TemplateRuntimeException(String message, int line, int column, String tagName) {
      super(message);
      this.line = line;
      this.column = column;
      this.tagName = tagName;
   }
}
