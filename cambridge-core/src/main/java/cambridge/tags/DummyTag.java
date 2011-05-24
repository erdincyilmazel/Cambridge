package cambridge.tags;

import cambridge.DynamicTag;

/**
 * User: erdinc
 * Date: Nov 6, 2009
 * Time: 12:07:33 AM
 */
public class DummyTag extends DynamicTag {
   public DummyTag() {
      setDynamic(true);
      setHidden(true);
      setIndented(true);
   }
}