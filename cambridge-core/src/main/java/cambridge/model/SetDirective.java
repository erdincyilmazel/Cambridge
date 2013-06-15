package cambridge.model;

import cambridge.BehaviorInstantiationException;
import cambridge.ExpressionEvaluationException;
import cambridge.TemplateEvaluationException;
import cambridge.runtime.ExpressionContext;

import java.io.IOException;
import java.io.Writer;

/**
 * @author Erdinc Yilmazel
 * Date: May 18, 2010
 * Time: 9:35:44 AM
 */
public class SetDirective extends TemplateNode implements AttributeFragment {
   private final String varName;
   private final Expression expression;

   public SetDirective(String varName, Expression expression) {
      this.varName = varName;
      this.expression = expression;
   }

   @Override
   void normalize(TemplateDocument doc, FragmentList f) throws BehaviorInstantiationException {
      f.addFragment(this);
   }

   @Override
   public boolean normalizeUntil(TemplateDocument doc, TemplateNode reference, FragmentList f, boolean inclusive) throws BehaviorInstantiationException {
      if (reference == this) {
         if (inclusive) {
            f.addFragment(this);
         }
         return true;
      } else {
         f.addFragment(this);
         return false;
      }
   }

   @Override
   public Tag getElementById(String id) {
      return null;
   }

   public void eval(ExpressionContext context, Writer out) throws IOException, TemplateEvaluationException {
      try {
         context.put(varName, expression.eval(context));
      } catch (ExpressionEvaluationException e) {
         throw new TemplateEvaluationException(e, "Could not execute the expression: " + expression.toString() + " on line: " + getBeginLine() + ", column: " + getBeginColumn(), getBeginLine(), getBeginColumn());
      }
   }

   public void pack() {
   }
}
