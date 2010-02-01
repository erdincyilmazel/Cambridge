package cambridge;

/**
 * User: erdinc
 * Date: Oct 31, 2009
 * Time: 2:40:57 AM
 */
public class TemplateParsingException extends RuntimeException {
   int line;
   int col;

   public TemplateParsingException(String message, int line, int col) {
      super(message);
      this.line = line;
      this.col = col;
   }

   public TemplateParsingException(String message, Throwable cause, int line, int col) {
      super(message, cause);
      this.line = line;
      this.col = col;
   }

   public int getLine() {
      return line;
   }

   public int getCol() {
      return col;
   }
}
