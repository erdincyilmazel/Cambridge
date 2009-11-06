package cambridge;

/**
 * User: erdinc
 * Date: Nov 1, 2009
 * Time: 1:20:40 AM
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

   int line;
   int col;

   public BehaviorInstantiationException(String message, Throwable cause, int line, int col) {
      super(message, cause);
      this.line = line;
      this.col = col;
   }
}
