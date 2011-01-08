package cambridge;

import java.io.IOException;
import java.util.Map;

/**
 * User: erdinc
 * Date: Oct 13, 2009
 * Time: 11:42:52 AM
 */
public interface Template {
   public void setProperty(String name, Object property);

   public void setAllProperties(Map<String, Object> properties);

   public void clearProperties();

   public void printTo(Appendable out) throws IOException, TemplateEvaluationException;

   public String asString() throws TemplateEvaluationException;
}
