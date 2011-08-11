package cambridge.parser.expressions;

import cambridge.ExpressionEvaluationException;
import cambridge.ExpressionParsingException;
import cambridge.Expressions;
import cambridge.model.Expression;
import cambridge.runtime.DefaultTemplateBindings;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * User: erdinc
 * Date: Apr 23, 2010
 * Time: 8:07:30 AM
 */
public class ExpressionTest {

   Map<String, Object> bindings;

   @Before
   public void setUp() {
      bindings = new DefaultTemplateBindings();

   }

   @Test
   public void testBoolean() {
      String expression = "true || false";
      try {
         Expression e = Expressions.parse(expression, 0, 0);
         //assertEquals("Testing type", CambridgeExpression.Type.Boolean, e.getType(bindings));
         assertTrue(e.asBoolean(bindings));
      } catch (ExpressionParsingException e) {
         e.printStackTrace();
      } catch (ExpressionEvaluationException e) {
         e.printStackTrace();
      }
   }

   @Test
   public void testList() {
      String expression = "['a', 'b', 213, aa]";
      try {
         Expression e = Expressions.parse(expression, 0, 0);
//         assertEquals("Testing type", CambridgeExpression.Type.Object, e.getType(bindings));
         assertTrue(e.eval(bindings) instanceof List);
         List l = (List) e.eval(bindings);
         assertEquals("a", l.get(0));
         assertEquals("b", l.get(1));
         assertEquals(213, l.get(2));
      } catch (ExpressionParsingException e) {
         e.printStackTrace();
      } catch (ExpressionEvaluationException e) {
         e.printStackTrace();
      }
   }
}
