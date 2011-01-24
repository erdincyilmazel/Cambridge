package cambridge;

import cambridge.model.Tag;
import cambridge.model.TemplateDocument;
import cambridge.parser.TemplateParser;
import cambridge.parser.TemplateTokenizer;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * User: erdinc
 * Date: Nov 3, 2009
 * Time: 6:27:33 PM
 */
public class IncludeTest {
   @Test
   public void testInclude() {
      final DirectoryTemplateLoader loader = new DirectoryTemplateLoader(new File("."));

      try {
         TemplateFactory f = loader.newTemplateFactory("a.html", new TemplateModifier() {
            public void modifyTemplate(TemplateDocument doc) {
               try {
                  TemplateTokenizer tokenizer = new TemplateTokenizer(new InputStreamReader(new FileInputStream("b.html"), "UTF-8"));
                  TemplateParser parser = new TemplateParser(tokenizer);
                  TemplateDocument document = parser.parse();

                  Tag tag = document.getElementsByTagName("body").get(0);
                  Tag bodyTag = doc.getElementsByTagName("body").get(0);

                  bodyTag.addChildren(tag.getChildren());

               } catch (IOException e) {
                  e.printStackTrace();
               } catch (TemplateParsingException e) {
                  e.printStackTrace();
               }
            }
         });

         Template t = f.createTemplate();

         t.printTo(System.out);

      } catch (TemplateLoadingException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      } catch (TemplateEvaluationException e) {
         e.printStackTrace();
      }
   }
}