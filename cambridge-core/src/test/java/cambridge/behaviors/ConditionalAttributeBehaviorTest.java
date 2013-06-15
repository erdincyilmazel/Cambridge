package cambridge.behaviors;

import cambridge.BehaviorInstantiationException;
import cambridge.TemplateEvaluationException;
import cambridge.TemplateParsingException;
import cambridge.model.Fragment;
import cambridge.model.FragmentList;
import cambridge.model.TemplateDocument;
import cambridge.parser.TemplateParser;
import cambridge.parser.TemplateTokenizer;
import cambridge.parser.expressions.MapExpressionContext;
import cambridge.runtime.ExpressionContext;
import org.junit.Test;

import java.io.IOException;
import java.io.StringWriter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Erdinc Yilmazel
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
         ExpressionContext context = new MapExpressionContext();
         context.set("condition", true);

         TemplateDocument t = parser.parse();
         assertNotNull(t);
         FragmentList fragments = t.normalize();

         StringWriter builder = new StringWriter();

         for (Fragment f : fragments) {
            f.eval(context, builder);
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
