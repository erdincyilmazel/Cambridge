package cambridge;

import cambridge.model.TemplateDocument;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 * User: erdinc
 * Date: Oct 13, 2009
 * Time: 11:48:01 AM
 */
public class EditTester {

   public static void main(String[] args) {
      try {
         final DirectoryTemplateLoader loader = new DirectoryTemplateLoader(new File("."));
         final TemplateFactory f = loader.newTemplateFactory("grandchild.html", new TemplateModifier() {
            public void modifyTemplate(TemplateDocument doc) {

            }
         });

         Template template = f.createTemplate();
         template.setProperty("x", true);
         template.setProperty("y", false);
         Writer writer = new OutputStreamWriter(System.out);
         template.printTo(writer);
         writer.flush();
         System.out.flush();

      } catch (TemplateLoadingException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}
