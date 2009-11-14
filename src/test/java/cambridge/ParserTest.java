package cambridge;

import cambridge.model.Fragment;
import cambridge.model.FragmentList;
import cambridge.model.TemplateDocument;
import cambridge.parser.TemplateParser;
import cambridge.parser.TemplateTokenizer;
import cambridge.runtime.TemplateProperties;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

/**
 * User: erdinc
 * Date: Oct 13, 2009
 * Time: 10:55:06 AM
 */
public class ParserTest {

   String output = "<!DOCTYPE html>\n" +
      "<html>\n" +
      "<body>\n" +
      "\n" +
      "<div>Simple expression simple</div>\n" +
      "\n" +
      "<div id=\"test\">Expression Attribute</div>\n" +
      "\n" +
      "<div class=\"x\">Expression inside tag</div>\n" +
      "\n" +
      "<div>Condition true</div>\n" +
      "\n" +
      "\n" +
      "   <div>1</div>\n" +
      "   <div>2</div>\n" +
      "   <div>3</div>\n" +
      "\n" +
      "<div id=\"test2\">Complex</div>\n" +
      "\n" +
      "</body>\n" +
      "</html>";

   @Test
   public void testFull() {
      try {
         TemplateTokenizer tokenizer = new TemplateTokenizer(TokenizerTest.class.getResourceAsStream("full.html"));
         TemplateParser parser = new TemplateParser(tokenizer);
         TemplateDocument t = parser.parse();
         FragmentList fragments = t.normalize();
         TemplateProperties p = new TemplateProperties();
         p.put("var", "simple");
         p.put("id", "test");
         p.put("exp", "class=\"x\"");
         ArrayList<Integer> list = new ArrayList<Integer>();
         list.add(1);
         list.add(2);
         list.add(3);
         p.put("list", list);
         p.put("condition", true);

         assertNotNull(t);

         StringBuilder builder = new StringBuilder();

         for (Fragment f : fragments) {
            f.eval(p, builder);
         }

         assertEquals(output, builder.toString());

      } catch (IOException e) {
         e.printStackTrace();
      } catch (TemplateParsingException e) {
         e.printStackTrace();
      } catch (BehaviorInstantiationException e) {
         e.printStackTrace();
      } catch (TemplateRuntimeException e) {
         e.printStackTrace();
      }
   }
}