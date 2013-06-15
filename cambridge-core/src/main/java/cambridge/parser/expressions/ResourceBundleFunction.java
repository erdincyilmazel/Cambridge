package cambridge.parser.expressions;

import cambridge.ExpressionEvaluationException;
import cambridge.runtime.ExpressionContext;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * @author Erdinc Yilmazel
 * Date: Nov 9, 2009
 * Time: 11:58:12 PM
 */
public class ResourceBundleFunction extends FunctionRunner {
   @Override
   public Object eval(ExpressionContext context, CambridgeExpression[] params) throws ExpressionEvaluationException {
      try {
         ResourceBundle bundle = ResourceBundle.getBundle("Cambridge", context.getLocale());

         if (params == null || params.length == 0) {
            return "";
         }

         if (params.length == 1) {
            return bundle.getString(params[0].asString(context));
         } else {
            String message = bundle.getString(params[0].asString(context));
            Object[] messageParams = new Object[params.length - 1];

            for (int i = 1; i < params.length; i++) {
               messageParams[i - 1] = params[i].eval(context);
            }

            return MessageFormat.format(message, messageParams);
         }
      } catch (MissingResourceException e) {
         return "";
      }
   }
}
