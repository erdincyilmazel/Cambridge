package cambridge.runtime;

/**
 * User: erdinc
 * Date: Nov 2, 2009
 * Time: 1:26:57 PM
 */
public class Super {

   Object o;
   Object s;

   public Super(Object o) {
      this.o = o;
   }

   public Super(Object o, Object s) {
      this.o = o;
      this.s = s;
   }

   public Object get() {
      return o;
   }

   public Object getSuper() {
      return s;
   }
}
