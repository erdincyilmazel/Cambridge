package cambridge.runtime;

/**
 * User: erdinc
 * Date: Oct 31, 2009
 * Time: 5:25:32 PM
 */
public class PropertyAccessException extends Exception {
   Object o;
   String property;

   public PropertyAccessException(String message, Object o, String property) {
      super(message);

      this.o = o;
      this.property = property;
   }
}
