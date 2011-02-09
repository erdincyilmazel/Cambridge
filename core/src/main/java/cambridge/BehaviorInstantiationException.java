package cambridge;

/**
 * BehaviorInstantiationException is thrown when the behavior that is associated
 * with a tag could not be initialized. This usually means the expression in the
 * corresponding tag attribute could not be parsed
 */
public class BehaviorInstantiationException extends Exception {
   public BehaviorInstantiationException() {
   }

   public BehaviorInstantiationException(String message) {
      super(message);
   }

   public BehaviorInstantiationException(String message, Throwable cause) {
      super(message, cause);
   }

   public BehaviorInstantiationException(Throwable cause) {
      super(cause);
   }

   private int line;
   private int col;

   /**
    * Returns the column number of the tag element which caused the problem
    * @return Column number
    */
   public int getCol() {
      return col;
   }

   /**
    * Returns the line number of the tag element which caused the problem
    * @return Line number
    */
   public int getLine() {
      return line;
   }

   public BehaviorInstantiationException(String message, Throwable cause, int line, int col) {
      super(message, cause);
      this.line = line;
      this.col = col;
   }
}
