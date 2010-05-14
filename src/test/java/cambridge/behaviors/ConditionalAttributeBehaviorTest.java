package cambridge.behaviors;

import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import cambridge.parser.TemplateTokenizer;
import cambridge.parser.TemplateParser;
import cambridge.TemplateParsingException;
import cambridge.BehaviorInstantiationException;
import cambridge.TemplateEvaluationException;
import cambridge.runtime.TemplateProperties;
import cambridge.model.TemplateDocument;
import cambridge.model.FragmentList;
import cambridge.model.Fragment;

import java.io.IOException;

/**
 * User: erdinc
 * Date: Nov 14, 2009
 * Time: 11:09:09 PM
 */
public class ConditionalAttributeBehaviorTest {
   private String output = "<div id=\"id\">test</div>";

   @Test
   public void test() {
      try {
         TemplateTokenizer tokenizer = new TemplateTokenizer(ConditionalAttributeBehaviorTest.class.getResourceAsStream("conditionalattribute.html"));
         TemplateParser parser = new TemplateParser(tokenizer);
         TemplateProperties properties = new TemplateProperties();
         properties.put("condition", true);

         TemplateDocument t = parser.parse();
         assertNotNull(t);
         FragmentList fragments = t.normalize();

         StringBuilder builder = new StringBuilder();

         for (Fragment f : fragments) {
            f.eval(properties, builder);
         }

         assertEquals(output, builder.toString());

      } catch (IOException e) {
         e.printStackTrace();
      } catch (TemplateParsingException e) {
         e.printStackTrace();
      } catch (BehaviorInstantiationException e) {
         e.printStackTrace();
      } catch (TemplateEvaluationException e) {
         e.printStackTrace();
      }
   }
}
