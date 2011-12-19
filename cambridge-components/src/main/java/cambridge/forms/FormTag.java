package cambridge.forms;

import cambridge.*;
import cambridge.model.Attribute;
import cambridge.model.DynamicAttribute;
import cambridge.model.Expression;
import cambridge.runtime.Iter;
import cambridge.runtime.Super;
import java.io.IOException;
import java.io.Writer;
import java.util.Map;

/**
 * @author Erdinc Yilmazel
 * Date: Nov 11, 2009
 * Time: 1:37:42 PM
 */
public class FormTag extends DynamicTag {
   public FormTag() {   
      hidden = true;
   }

   Expression formExpression;

   //action="${self.action}" name="${self.name}" method="${self.method}" enctype="${self.encType}"
   @Override
   public void init() throws TemplateParsingException {
      Attribute a = getAttribute(nameSpace, "form");
      if (!(a instanceof DynamicAttribute)) {
         throw new TemplateParsingException("The required attribute form for form element is not specified", getBeginLine(), getBeginColumn());
      }

      DynamicAttribute form = (DynamicAttribute) a;
      try {
         formExpression = form.getExpression();
      } catch (ExpressionParsingException e) {

         throw new TemplateParsingException("Error parsing expression for form tag", e, getBeginLine(), getBeginColumn());
      }
   }

   @Override
   public void execute(Map<String, Object> bindings, Writer out) throws IOException, TemplateEvaluationException {
      try {
         Object f = formExpression.eval(bindings);
         if (f instanceof Form) {
            Form form = (Form) f;

            Object t = bindings.get(Expressions.CURRENT_OBJECT);
            Super ts = (Super) bindings.get(Expressions.PARENT_OBJECT);
            Iter iter = (Iter) bindings.get(Expressions.ITER_OBJECT);

            Super s = null;

            if (t != null) {
               s = new Super(t, ts, iter);
               bindings.put(Expressions.PARENT_OBJECT, s);
            }

            bindings.put(Expressions.CURRENT_OBJECT, form);
            super.execute(bindings, out);

            if (t != null) {
               bindings.put(Expressions.CURRENT_OBJECT, s.get());
               bindings.put(Expressions.PARENT_OBJECT, s.getSuper());
               bindings.put(Expressions.ITER_OBJECT, s.getIter());
            } else {
               bindings.put(Expressions.CURRENT_OBJECT, t);
               bindings.put(Expressions.PARENT_OBJECT, ts);
               bindings.put(Expressions.ITER_OBJECT, iter);
            }

         }

      } catch (ExpressionEvaluationException e) {
         throw new TemplateEvaluationException(e, "Error evaluating expression", getBeginLine(), getBeginColumn());
      }
   }
}
