package cambridge.parser.expressions;

import cambridge.ExpressionEvaluationException;
import cambridge.ExpressionParsingException;
import cambridge.runtime.TemplateProperties;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * User: erdinc
 * Date: Apr 23, 2010
 * Time: 8:07:30 AM
 */
public class ExpressionTest {

   TemplateProperties properties;

   @Before
   public void setUp() {
      properties = new TemplateProperties();

   }

   @Test
   public void testBoolean() {
      String expression = "true || false";
      try {
         Expression e = Expressions.parse(expression);
         assertEquals("Testing type", Expression.Type.Boolean, e.getType(properties));
         assertTrue(e.asBoolean(properties));
      } catch (ExpressionParsingException e) {
         e.printStackTrace();
      } catch (ExpressionEvaluationException e) {
         e.printStackTrace();
      }
   }

   @Test
   public void testList() {
      String expression = "['a', 'b', 213]";
      try {
         Expression e = Expressions.parse(expression);
         assertEquals("Testing type", Expression.Type.Object, e.getType(properties));
         assertTrue(e.eval(properties) instanceof List);
         List l = (List) e.eval(properties);
         assertEquals(new StringLiteral("a"), l.get(0));
         assertEquals(new StringLiteral("b"), l.get(1));
         assertEquals(new IntLiteral(213), l.get(2));
      } catch (ExpressionParsingException e) {
         e.printStackTrace();
      } catch (ExpressionEvaluationException e) {
         e.printStackTrace();
      }
   }
}
