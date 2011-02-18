package cambridge.runtime;

/**
 * User: erdinc
 * Date: Nov 2, 2009
 * Time: 1:26:57 PM
 */
public class Super {
   private final Object o;
   private final Super s;
   private final Iter iter;

   public Super(Object o, Super s, Iter i) {
      this.o = o;
      this.s = s;
      this.iter = i;
   }

   public Object get() {
      return o;
   }

   public Super getSuper() {
      return s;
   }

   public Iter getIter() {
      return iter;
   }
}
