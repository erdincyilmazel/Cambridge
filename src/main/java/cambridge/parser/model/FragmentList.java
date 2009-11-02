package cambridge.parser.model;

import java.util.ArrayList;

/**
 * User: erdinc
 * Date: Oct 13, 2009
 * Time: 1:01:56 PM
 */
public class FragmentList extends ArrayList<Fragment> {
   public FragmentList() {
   }

   Fragment current;

   public FragmentList append(String contents) {
      if (!(current instanceof StaticFragment)) {
         if (current != null) {
            add(current);
         }
         current = new StaticFragment();
      }

      ((StaticFragment) current).append(contents);
      return this;
   }

   public void addFragment(Fragment f) {
      if (current != null) {
         add(current);
      }

      current = f;
   }

   public void pack() {
      if (current != null) {
         add(current);
      }
   }
}
