package cambridge;

import cambridge.model.AttributeFragment;
import cambridge.model.FragmentList;
import cambridge.model.Tag;
import cambridge.model.TemplateNode;
import cambridge.parser.expressions.Expression;
import cambridge.runtime.TemplateProperties;

import java.io.IOException;

/**
 * User: erdinc
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
   public void normalize(FragmentList f) throws BehaviorInstantiationException {
      f.addFragment(this);
   }

   @Override
   public boolean normalizeUntil(TemplateNode reference, FragmentList f, boolean inclusive) throws BehaviorInstantiationException {
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

   public void eval(TemplateProperties properties, Appendable out) throws IOException, TemplateEvaluationException {
      try {
         properties.put(varName, expression.eval(properties));
      } catch (ExpressionEvaluationException e) {
         throw new TemplateEvaluationException("Could not execute the expression: " + e.getMessage(), getBeginLine(), getBeginColumn());
      }
   }

   public void pack() {
   }
}
