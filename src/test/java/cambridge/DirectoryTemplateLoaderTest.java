package cambridge;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

import cambridge.model.TemplateDocument;
import cambridge.model.TextNode;

/**
 * User: erdinc
 * Date: Nov 3, 2009
 * Time: 6:27:33 PM
 */
public class DirectoryTemplateLoaderTest {
   @Test
   public void testLoad() {
      DirectoryTemplateLoader loader = new DirectoryTemplateLoader(new File("."));
      try {
         TemplateFactory f = loader.newTemplateFactory("kitchensink.html", new TemplateModifier() {
            @Override
            public void modifyTemplate(TemplateDocument doc) {
               doc.getElementById("email").addChild(new TextNode("Erdinc"));
            }
         });
         Template t = f.createTemplate();

         t.printTo(System.out);
         
      } catch (TemplateLoadingException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      } catch (TemplateRuntimeException e) {
         e.printStackTrace();
      }
   }
}
