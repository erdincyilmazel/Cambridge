package cambridge.parser;

import cambridge.ExpressionEvaluationException;
import cambridge.TemplateEvaluationException;
import cambridge.model.ExtensionNode;
import cambridge.parser.expressions.Expression;
import cambridge.parser.expressions.Expressions;
import cambridge.parser.expressions.ListExpression;
import play.mvc.ActionRoute;
import java.io.IOException;
import java.util.Map;

/**
 * @author Erdinc YILMAZEL
 * @since 1/28/11
 */
public class PlayActionExtensionNode extends ExtensionNode {
   String controller;
   String action;
   Expression expression;

   public PlayActionExtensionNode(String controller, String action, String expr) {
      this.controller = controller;
      this.action = action;
      expression = Expressions.parse(expr);
   }

   public void eval(Map<String, Object> bindings, Appendable out) throws IOException, TemplateEvaluationException {
      Object param = null;
      try {
         if (expression instanceof ListExpression) {
            ListExpression e = (ListExpression) expression;

            Object[] p = new Object[e.size()];
            for (int i = 0; i < p.length; i++) {
               p[i] = e.get(i).eval(bindings);
            }
            param = p;
         } else {
            param = expression.eval(bindings);
         }
      } catch (ExpressionEvaluationException e1) {
         e1.printStackTrace();
      }

      out.append(ActionRoute.invoke(controller, action, param, false).toString());
   }
}
