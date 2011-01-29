package play.mvc;

import cambridge.ExpressionEvaluationException;
import cambridge.parser.expressions.Expression;
import cambridge.runtime.FunctionRunner;
import play.classloading.enhancers.LocalvariablesNamesEnhancer;
import play.data.binding.Unbinder;
import play.exceptions.ActionNotFoundException;
import play.exceptions.NoRouteFoundException;
import play.exceptions.PlayException;
import play.exceptions.UnexpectedException;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Erdinc Yilmazel
 * @since 1/27/11
 */
public class ActionFunction extends FunctionRunner {
   /*
   @('Clients.showAccounts', 23423)
    */

   boolean absolute;

   public ActionFunction(boolean absolute) {
      this.absolute = absolute;
   }

   @Override
   public Object eval(Map<String, Object> p, Expression[] params) throws ExpressionEvaluationException {
      if (params == null || params.length == 0) {
         throw new ExpressionEvaluationException("Action name error");
      }

      String call = params[0].asString(p);
      String[] action = call.split("\\.");
      String controller = null;
      String name = null;
      if (action.length == 2) {
         controller = action[0];
         name = action[1];
      } else {
         name = action[0];
      }

      Object[] param = null;
      if (params.length > 1) {
         param = new Object[params.length - 1];
         for (int i = 1; i < param.length; i++) {
            param[i - 1] = params[i].eval(p);
         }
      }

      return ActionRoute.invoke(controller, name, param, absolute);
   }
}
