package cambridge.runtime;

/**
 * User: erdinc
 * Date: Nov 4, 2009
 * Time: 1:14:40 AM
 */
public class Iter {
   private int row = 1;

   public boolean isFirst() {
      return row == 1;
   }

   public boolean isOdd() {
      return row % 2 == 1;
   }

   public boolean isEven() {
      return row % 2 == 0;
   }

   public int getRow() {
      return row;
   }

   public void next() {
      row++;
   }
}
