package cambridge.forms;

import cambridge.*;
import cambridge.model.Attribute;
import cambridge.model.DynamicAttribute;
import cambridge.parser.expressions.Expression;
import cambridge.runtime.Iter;
import cambridge.runtime.Super;
import cambridge.runtime.TemplateProperties;

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
   public void execute(TemplateProperties properties, Appendable out) throws IOException, TemplateEvaluationException {
      try {
         Object f = formExpression.eval(properties);
         if (f instanceof Form) {
            Form form = (Form) f;

            Object t = properties.get("#this");
            Super ts = (Super) properties.get("#super");
            Iter iter = (Iter) properties.get("#iter");

            Super s = null;

            if (t != null) {
               s = new Super(t, ts, iter);
               properties.put("#super", s);
            }

            properties.put("#this", form);
            super.execute(properties, out);

            if (t != null) {
               properties.put("#this", s.get());
               properties.put("#super", s.getSuper());
               properties.put("#iter", s.getIter());
            } else {
               properties.put("#this", t);
               properties.put("#super", ts);
               properties.put("#iter", iter);
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
