package cambridge.behaviors;

import cambridge.User;
import cambridge.model.Fragment;
import cambridge.model.FragmentList;
import cambridge.model.TemplateDocument;
import cambridge.parser.TemplateParser;
import cambridge.parser.TemplateTokenizer;
import cambridge.runtime.DefaultTemplateBindings;
import org.junit.Test;

import java.io.StringWriter;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Erdinc Yilmazel
 * @since 1/25/11
 */
public class WithBehaviorTest {

   private final String out = "<div>friend1</div>";

   @Test
   public void testWithBehavior() throws Exception {
      TemplateTokenizer tokenizer = new TemplateTokenizer(ConditionalAttributeBehaviorTest.class.getResourceAsStream("withbehavior.html"));
      TemplateParser parser = new TemplateParser(tokenizer);
      Map<String, Object> bindings = new DefaultTemplateBindings();

      User user = new User("test", "test@test.com");
      bindings.put("user", user);

      TemplateDocument t = parser.parse();
      assertNotNull(t);
      FragmentList fragments = t.normalize();

      StringWriter builder = new StringWriter();

      for (Fragment f : fragments) {
         f.eval(bindings, builder);
      }

      assertEquals(out, builder.toString());
   }
}
