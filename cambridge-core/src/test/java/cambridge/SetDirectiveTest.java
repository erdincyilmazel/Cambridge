package cambridge;

import cambridge.model.Fragment;
import cambridge.model.FragmentList;
import cambridge.model.TemplateDocument;
import cambridge.parser.TemplateParser;
import cambridge.parser.TemplateTokenizer;
import cambridge.parser.expressions.MapExpressionContext;
import org.junit.Test;

import java.io.StringWriter;

import static org.junit.Assert.assertEquals;

/**
 * @author Erdinc Yilmazel
 * Date: May 18, 2010
 * Time: 9:17:38 AM
 */
public class SetDirectiveTest {
   @Test
   public void testSetDirective() throws Exception {
      TemplateTokenizer tokenizer = new TemplateTokenizer(ParserTest.class.getResourceAsStream("set.html"));
      TemplateParser parser = new TemplateParser(tokenizer, Expressions.cambridgeExpressionLanguage);
      TemplateDocument doc = parser.parse();
      FragmentList fragmentList = doc.normalize();
      MapExpressionContext context = new MapExpressionContext();
      StringWriter out = new StringWriter();
      for (Fragment f : fragmentList) {
         f.eval(context, out);
      }

      assertEquals("Hello World", out.toString());
   }
}
