package cambridge;

import cambridge.parser.TemplateParser;
import cambridge.parser.TemplateTokenizer;
import cambridge.model.FragmentList;
import cambridge.model.TemplateModel;
import org.junit.After;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * User: erdinc
 * Date: Oct 13, 2009
 * Time: 10:55:06 AM
 */
public class ParserTest {
   TemplateTokenizer tokenizer;
   TemplateParser parser;

   @Before
   public void setUp() {
      try {
         tokenizer = new TemplateTokenizer(TokenizerTest.class.getResourceAsStream("custom.html"));
         parser = new TemplateParser(tokenizer);
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   @Test
   public void test() {
      try {
         TemplateModel t = parser.parse();
         FragmentList f = t.normalize();
         String source = t.getSource();
         assertNotNull(t);
         t.print(System.out);

      } catch (IOException e) {
         e.printStackTrace();
      } catch (TemplateParsingException e) {
         e.printStackTrace();
      } catch (BehaviorInstantiationException e) {
         e.printStackTrace();
      }
   }

   @After
   public void clean() {
      try {
         tokenizer.close();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}