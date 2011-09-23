package cambridge;

import cambridge.model.Fragment;
import cambridge.model.FragmentList;
import cambridge.model.TemplateDocument;
import cambridge.runtime.DefaultTemplateBindings;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 * @author Erdinc Yilmazel
 * Date: Nov 6, 2009
 * Time: 2:07:51 PM
 */
public class FragmentSelectorTest {
   @Test
   public void testSelect() {
      final DirectoryTemplateLoader loader = new DirectoryTemplateLoader(new File("."));
      try {
         loader.newTemplateFactory("a.html", new TemplateModifier() {
            public void modifyTemplate(TemplateDocument doc) {
               try {
                  FragmentList fragmentList = doc.select("except #s");

                  Writer writer = new OutputStreamWriter(System.out);
                  for (Fragment f : fragmentList) {
                     f.eval(new DefaultTemplateBindings(), writer);
                  }

               } catch (BehaviorInstantiationException e) {
                  e.printStackTrace();
               } catch (IOException e) {
                  e.printStackTrace();
               } catch (TemplateEvaluationException e) {
                  e.printStackTrace();
               }
            }
         });
      } catch (TemplateLoadingException e) {
         e.printStackTrace();
      }
   }
}