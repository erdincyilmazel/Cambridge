package cambridge.forms;

import cambridge.*;
import cambridge.model.Attribute;
import cambridge.model.DynamicAttribute;
import cambridge.parser.expressions.Expression;
import cambridge.runtime.Iter;
import cambridge.runtime.Super;
import cambridge.runtime.TemplateBindings;

import java.io.IOException;

/**
 * User: erdinc
 * Date: Nov 11, 2009
 * Time: 1:37:42 PM
 */
public class FormTag extends DynamicTag {
   public FormTag() {
      hidden = true;
   }

   Expression formExpression;

   //action="${#this.action}" name="${#this.name}" method="${#this.method}" enctype="${#this.encType}"
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
   public void execute(TemplateBindings bindings, Appendable out) throws IOException, TemplateEvaluationException {
      try {
         Object f = formExpression.eval(bindings);
         if (f instanceof Form) {
            Form form = (Form) f;

            Object t = bindings.get("#this");
            Super ts = (Super) bindings.get("#super");
            Iter iter = (Iter) bindings.get("#iter");

            Super s = null;

            if (t != null) {
               s = new Super(t, ts, iter);
               bindings.put("#super", s);
            }

            bindings.put("#this", form);
            super.execute(bindings, out);

            if (t != null) {
               bindings.put("#this", s.get());
               bindings.put("#super", s.getSuper());
               bindings.put("#iter", s.getIter());
            } else {
               bindings.put("#this", t);
               bindings.put("#super", ts);
               bindings.put("#iter", iter);
            }

         }

      } catch (ExpressionEvaluationException e) {
         throw new TemplateEvaluationException("Error evaluating expression", getBeginLine(), getBeginColumn());
      }
   }

   public static FormTag getInstance() {
      DynamicTagCreator creator = new DynamicTagCreator();
      try {
         return creator.createTag(FormTag.class.getResourceAsStream("form.html"), FormTag.class);
      } catch (TemplateLoadingException e) {
         e.printStackTrace();
      }

      return null;
   }
}
