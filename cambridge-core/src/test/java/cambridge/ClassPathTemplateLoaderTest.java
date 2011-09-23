package cambridge;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Erdinc Yilmazel
 * Date: May 19, 2010
 * Time: 9:10:52 AM
 */
public class ClassPathTemplateLoaderTest {
   static ClassPathTemplateLoader loader;

   @BeforeClass
   public static void setUp() {
      loader = new ClassPathTemplateLoader(ClassPathTemplateLoaderTest.class.getClassLoader());
   }

   @Test
   public void testLoad() {
      TemplateFactory factory = loader.newTemplateFactory("cambridge/basic.html");
      assertNotNull(factory);
      Template t = factory.createTemplate();
      assertEquals("<div class=\"\">xxx</div>", t.asString());
   }
}
