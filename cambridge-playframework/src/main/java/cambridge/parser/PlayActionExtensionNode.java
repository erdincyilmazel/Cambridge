package cambridge.parser;

import cambridge.ExpressionEvaluationException;
import cambridge.ExpressionLanguage;
import cambridge.TemplateEvaluationException;
import cambridge.model.Expression;
import cambridge.model.ExtensionNode;
import play.mvc.ActionRoute;

import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.Map;

/**
 * @author Erdinc YILMAZEL
 * @since 1/28/11
 */
public class PlayActionExtensionNode extends ExtensionNode {
   String controller;
   String action;
   Expression expression;
   String expr;
   boolean absolute;

   public PlayActionExtensionNode(ExpressionLanguage language, String controller, String action, String expr, boolean absolute) {
      this.controller = controller;
      this.action = action;
      this.expr = expr;
      this.absolute = absolute;
      if (expr != null && !"".equals(expr)) {
         expression = language.parse(language.wrapExpressionAsList(expr));
      }
   }

   public void eval(Map<String, Object> bindings, Writer out) throws IOException, TemplateEvaluationException {
      Object param;
      try {
         param = expression.eval(bindings);
         if (expression instanceof List) {
            param = ((List) param).toArray();
         }
      } catch (ExpressionEvaluationException ex) {
         throw new TemplateEvaluationException("Could not execute the expression: " + ex.getMessage(), getBeginLine(), getBeginColumn(), expr);
      }

      out.write(ActionRoute.invoke(controller, action, param, absolute).toString());
   }
}
