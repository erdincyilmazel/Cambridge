package cambridge.behaviors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.StringWriter;

import cambridge.Expressions;
import cambridge.parser.expressions.MapExpressionContext;
import cambridge.runtime.ExpressionContext;
import org.junit.Test;

import cambridge.model.Fragment;
import cambridge.model.FragmentList;
import cambridge.model.TemplateDocument;
import cambridge.parser.TemplateParser;
import cambridge.parser.TemplateTokenizer;

/**
 * @author Erdinc Yilmazel
 * Date: Nov 14, 2009
 * Time: 11:09:09 PM
 */
public class IfElseTest {

   private String first = "<div id=\"first\" class=\"first\">First</div>";
   private String second = "<div id=\"second\" class=\"second\">Second</div>";
   private String third = "<div id=\"third\" class=\"third\">Third</div>";
   private String f = "<div id=\"final\" class=\"final\">Final</div>";

   @Test
   public void testFirst() {
      try {
         TemplateTokenizer tokenizer = new TemplateTokenizer(IfElseTest.class.getResourceAsStream("ifelse.html"));
         TemplateParser parser = new TemplateParser(tokenizer, Expressions.cambridgeExpressionLanguage);
         ExpressionContext context = new MapExpressionContext();
         context.put("var1", true);

         TemplateDocument t = parser.parse();
         assertNotNull(t);
         FragmentList fragments = t.normalize();

         StringWriter builder = new StringWriter();

         for (Fragment f : fragments) {
            f.eval(context, builder);
         }

         assertEquals(first, builder.toString().trim());

      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   @Test
   public void testSecond() {
      try {
         TemplateTokenizer tokenizer = new TemplateTokenizer(IfElseTest.class.getResourceAsStream("ifelse.html"));
         TemplateParser parser = new TemplateParser(tokenizer, Expressions.cambridgeExpressionLanguage);
         ExpressionContext context = new MapExpressionContext();
         context.put("var2", true);

         TemplateDocument t = parser.parse();
         assertNotNull(t);
         FragmentList fragments = t.normalize();

         StringWriter builder = new StringWriter();

         for (Fragment f : fragments) {
            f.eval(context, builder);
         }

         assertEquals(second, builder.toString().trim());

      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   @Test
   public void testThird() {
      try {
         TemplateTokenizer tokenizer = new TemplateTokenizer(IfElseTest.class.getResourceAsStream("ifelse.html"));
         TemplateParser parser = new TemplateParser(tokenizer, Expressions.cambridgeExpressionLanguage);
         ExpressionContext context = new MapExpressionContext();
         context.put("var3", true);

         TemplateDocument t = parser.parse();
         assertNotNull(t);
         FragmentList fragments = t.normalize();

         StringWriter builder = new StringWriter();

         for (Fragment f : fragments) {
            f.eval(context, builder);
         }

         assertEquals(third, builder.toString().trim());

      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   @Test
   public void testFinal() {
      try {
         TemplateTokenizer tokenizer = new TemplateTokenizer(IfElseTest.class.getResourceAsStream("ifelse.html"));
         TemplateParser parser = new TemplateParser(tokenizer, Expressions.cambridgeExpressionLanguage);
         ExpressionContext context = new MapExpressionContext();

         TemplateDocument t = parser.parse();
         assertNotNull(t);
         FragmentList fragments = t.normalize();

         StringWriter builder = new StringWriter();

         for (Fragment f : fragments) {
            f.eval(context, builder);
         }

         assertEquals(f, builder.toString().trim());

      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}
