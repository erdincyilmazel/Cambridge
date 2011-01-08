package cambridge;

import cambridge.model.Fragment;
import cambridge.model.FragmentList;
import cambridge.model.TemplateDocument;
import cambridge.parser.TemplateParser;
import cambridge.parser.TemplateTokenizer;
import cambridge.runtime.DefaultTemplateBindings;
import cambridge.runtime.TemplateBindings;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: erdinc
 * Date: May 18, 2010
 * Time: 9:17:38 AM
 */
public class SetDirectiveTest {
   @Test
   public void testSetDirective() throws Exception {
      TemplateTokenizer tokenizer = new TemplateTokenizer(ParserTest.class.getResourceAsStream("set.html"));
      TemplateParser parser = new TemplateParser(tokenizer);
      TemplateDocument doc = parser.parse();
      FragmentList fragmentList = doc.normalize();
      TemplateBindings prop = new DefaultTemplateBindings();
      StringBuilder out = new StringBuilder();
      for(Fragment f : fragmentList) {
         f.eval(prop, out);
      }

      assertEquals("Hello World", out.toString());
   }
}
