package cambridge;

import cambridge.model.Attribute;
import cambridge.model.ComplexAttribute;
import cambridge.model.ExpressionNode;
import cambridge.model.Fragment;
import cambridge.model.FragmentList;
import cambridge.model.StaticFragment;
import cambridge.model.TagNode;
import cambridge.model.TemplateDocument;
import cambridge.parser.TemplateParser;
import cambridge.parser.TemplateTokenizer;
import cambridge.parser.expressions.MapExpressionContext;
import cambridge.runtime.ExpressionContext;
import org.junit.Test;

import java.io.IOException;
import java.io.StringWriter;

import static org.junit.Assert.*;

/**
 * @author Erdinc Yilmazel
 * Date: Oct 13, 2009
 * Time: 10:55:06 AM
 */
public class ComplexAttributeTest {
   @Test
   public void testBasic() {
      try {
         TemplateTokenizer tokenizer = new TemplateTokenizer(ParserTest.class.getResourceAsStream("basic.html"));
         TemplateParser parser = new TemplateParser(tokenizer);

         ExpressionContext context = new MapExpressionContext();
         context.set("class", "test");
         TemplateDocument t = parser.parse();

         assertNotNull(t);

         Attribute a = t.locateTag("/div").getAttribute("class");
         assertTrue(a instanceof ComplexAttribute);

         ComplexAttribute c = (ComplexAttribute) a;

         assertEquals(1, c.getFragments().size());

         assertTrue(c.getFragments().get(0) instanceof ExpressionNode);

         ExpressionNode node = (ExpressionNode) c.getFragments().get(0);

         assertEquals("${class}", node.getSource());

         StringWriter builder = new StringWriter();

         FragmentList fragmentList = t.normalize();

         assertEquals(3, fragmentList.size());

         assertTrue(fragmentList.get(0) instanceof StaticFragment);
         assertTrue(fragmentList.get(1) instanceof ExpressionNode);
         assertTrue(fragmentList.get(2) instanceof StaticFragment);

         for (Fragment f : fragmentList) {
            f.eval(context, builder);
         }

         assertEquals("<div class=\"test\">xxx</div>", builder.toString());

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

   @Test
   public void testComplex() {
      try {
         TemplateTokenizer tokenizer = new TemplateTokenizer(ParserTest.class.getResourceAsStream("complex.html"));
         TemplateParser parser = new TemplateParser(tokenizer);
         ExpressionContext context = new MapExpressionContext();
         context.set("a", "AAA");
         context.set("b", "BBB");
         TemplateDocument t = parser.parse();

         assertNotNull(t);

         Attribute a = t.locateTag("/div").getAttribute("id");
         assertTrue(a instanceof ComplexAttribute);

         ComplexAttribute c = (ComplexAttribute) a;

         assertEquals(4, c.getFragments().size());

         assertTrue(c.getFragments().get(0) instanceof ExpressionNode);
         assertTrue(c.getFragments().get(1) instanceof StaticFragment);
         assertTrue(c.getFragments().get(2) instanceof StaticFragment);
         assertTrue(c.getFragments().get(3) instanceof ExpressionNode);

         ExpressionNode node1 = (ExpressionNode) c.getFragments().get(0);
         StaticFragment st = (StaticFragment) c.getFragments().get(1);
         StaticFragment st2 = (StaticFragment) c.getFragments().get(2);
         ExpressionNode node2 = (ExpressionNode) c.getFragments().get(3);

         assertEquals("${a}", node1.getSource());
         assertEquals(" ", st.toString());
         assertEquals("and ", st2.toString());
         assertEquals("${b}", node2.getSource());

         StringWriter builder = new StringWriter();

         FragmentList fragmentList = t.normalize();

         assertEquals(5, fragmentList.size());

         assertTrue(fragmentList.get(0) instanceof StaticFragment);
         assertTrue(fragmentList.get(1) instanceof ExpressionNode);
         assertTrue(fragmentList.get(2) instanceof StaticFragment);
         assertTrue(fragmentList.get(3) instanceof ExpressionNode);
         assertTrue(fragmentList.get(4) instanceof StaticFragment);

         for (Fragment f : fragmentList) {
            f.eval(context, builder);
         }

         assertEquals("<div id=\"AAA and BBB\"></div>", builder.toString());

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

   @Test
   public void testDymnamic() {
      try {
         TemplateTokenizer tokenizer = new TemplateTokenizer(ParserTest.class.getResourceAsStream("dynamic.html"));
         TemplateParser parser = new TemplateParser(tokenizer);
         ExpressionContext context = new MapExpressionContext();

         context.set("style", "style");

         TemplateDocument t = parser.parse();

         assertNotNull(t);

         Attribute a = t.locateTag("/div").getAttribute("style");
         assertTrue(a instanceof ComplexAttribute);

         ComplexAttribute c = (ComplexAttribute) a;

         assertEquals(1, c.getFragments().size());

         assertTrue(c.getFragments().get(0) instanceof ExpressionNode);

         ExpressionNode node1 = (ExpressionNode) c.getFragments().get(0);

         assertEquals("${style}", node1.getSource());

         StringWriter builder = new StringWriter();

         FragmentList fragmentList = t.normalize();

         assertEquals(1, fragmentList.size());

         assertTrue(fragmentList.get(0) instanceof TagNode);

         for (Fragment f : fragmentList) {
            f.eval(context, builder);
         }

         assertEquals("<div style=\"style\"></div>", builder.toString());

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