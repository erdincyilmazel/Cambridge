package cambridge;

import java.io.IOException;

/**
 * User: erdinc
 * Date: Oct 13, 2009
 * Time: 11:42:52 AM
 */
public interface Template {
   public void setProperty(String name, Object property);

   public void printTo(Appendable out) throws IOException, TemplateRuntimeException;

   public String asString() throws TemplateRuntimeException;
}
