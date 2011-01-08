package cambridge.runtime;

import cambridge.ExpressionEvaluationException;
import cambridge.parser.expressions.Expression;

import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.text.MessageFormat;

/**
 * User: erdinc
 * Date: Nov 9, 2009
 * Time: 11:58:12 PM
 */
public class ResourceBundleFunction extends FunctionRunner {
   @Override
   public Object eval(TemplateBindings p, Expression[] params) throws ExpressionEvaluationException {
      try {
         ResourceBundle bundle = ResourceBundle.getBundle("Cambridge", p.getLocale());

         if(params == null || params.length == 0) {
            return "";
         }

         if(params.length == 1) {
            return bundle.getString(params[0].asString(p));
         } else {
            String message = bundle.getString(params[0].asString(p));
            Object[] messageParams = new Object[params.length - 1];

            for(int i = 1; i < params.length; i++) {
               messageParams[i - 1] = params[i].eval(p);
            }

            return MessageFormat.format(message, messageParams);
         }
      } catch (MissingResourceException e) {
         return "";
      }
   }
}
