package cambridge.behaviors;

import cambridge.Expressions;
import cambridge.User;
import cambridge.model.Fragment;
import cambridge.model.FragmentList;
import cambridge.model.TemplateDocument;
import cambridge.parser.TemplateParser;
import cambridge.parser.TemplateTokenizer;
import cambridge.parser.expressions.MapExpressionContext;
import cambridge.runtime.ExpressionContext;
import org.junit.Test;

import java.io.StringWriter;
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
      TemplateParser parser = new TemplateParser(tokenizer, Expressions.cambridgeExpressionLanguage);
      ExpressionContext context = new MapExpressionContext();

      User user = new User("test", "test@test.com");
      context.put("user", user);

      TemplateDocument t = parser.parse();
      assertNotNull(t);
      FragmentList fragments = t.normalize();

      StringWriter builder = new StringWriter();

      for (Fragment f : fragments) {
         f.eval(context, builder);
      }

      assertEquals(out, builder.toString());
   }
}
