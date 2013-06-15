package cambridge;

import cambridge.model.FragmentList;
import cambridge.model.IncludeNode;
import cambridge.model.StaticFragment;
import cambridge.model.TemplateDocument;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * @author Erdinc Yilmazel
 * Date: Nov 3, 2009
 * Time: 6:27:33 PM
 */
public class DirectoryTemplateLoaderTest {
   @Test
   public void testLoad() {
      final DirectoryTemplateLoader loader = new DirectoryTemplateLoader(new File("."));

      try {
         TemplateFactory f = loader.newTemplateFactory("kitchensink.html", new TemplateModifier() {
            public void modifyTemplate(TemplateDocument doc) {

               FragmentList list = new FragmentList(Expressions.cambridgeExpressionLanguage);
               list.add(new StaticFragment("This is a test"));

               try {
                  doc.getElementById("email").addChild(new IncludeNode(loader, "a.html", Expressions.cambridgeExpressionLanguage, "#s"));
               } catch (TemplateLoadingException e) {
                  e.printStackTrace();
               } catch (BehaviorInstantiationException e) {
                  e.printStackTrace();
               }

               //doc.getElementById("email").addChild(new TextNode("Erdinc"));
            }
         }, Expressions.cambridgeExpressionLanguage);
         Template t = f.createTemplate();

         t.printTo(new OutputStreamWriter(System.out));

      } catch (TemplateLoadingException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      } catch (TemplateEvaluationException e) {
         e.printStackTrace();
      }
   }
}
