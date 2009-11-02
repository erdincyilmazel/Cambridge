package cambridge;

import cambridge.parser.model.Tag;

import java.io.IOException;
import java.util.Map;

/**
 * User: erdinc
 * Date: Oct 31, 2009
 * Time: 7:16:27 PM
 */
public abstract class IterativeTagBehavior implements TagBehavior {
   public IterativeTagBehavior() {
   }

   public abstract void iterate(Map<String, Object> properties, Tag tag, Appendable out) throws ExpressionEvaluationException, IOException;
}
