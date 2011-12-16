package play.mvc;

import play.classloading.enhancers.LocalvariablesNamesEnhancer;
import play.data.binding.Unbinder;
import play.exceptions.ActionNotFoundException;
import play.exceptions.NoRouteFoundException;
import play.exceptions.PlayException;
import play.exceptions.UnexpectedException;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Erdinc YILMAZEL
 * @since 1/28/11
 */
public class ActionRoute {

    /*
      * play 1.2.3 requires this parameter - probably should pass it in.  appears for data annotations according to
      *
      * https://github.com/playframework/play/blob/master/framework/src/play/data/binding/Unbinder.java
      */
    private static Annotation[] annotations = null;

    public static Router.ActionDefinition invoke(String controller, String name, Object param, boolean absolute) {
        try {
            if (controller == null) {
                controller = Http.Request.current().controller;
            }
            String action = controller + "." + name;
            if (action.endsWith(".call")) {
                action = action.substring(0, action.length() - 5);
            }
            try {
                Map<String, Object> r = new HashMap<String, Object>();
                Method actionMethod = (Method) ActionInvoker.getActionMethod(action)[1];
                String[] names = (String[]) actionMethod.getDeclaringClass().getDeclaredField("$" + actionMethod.getName() + LocalvariablesNamesEnhancer.LocalVariablesNamesTracer.computeMethodHash(actionMethod.getParameterTypes())).get(null);
                if (param instanceof Object[]) {
                    // too many parameters versus action, possibly a developer error. we must warn him.
                    if (names.length < ((Object[]) param).length) {
                        throw new NoRouteFoundException(action, null);
                    }
                    for (int i = 0; i < ((Object[]) param).length; i++) {
                        if (((Object[]) param)[i] instanceof Router.ActionDefinition && ((Object[]) param)[i] != null) {
                            Unbinder.unBind(r, ((Object[]) param)[i].toString(), i < names.length ? names[i] : "", annotations);
                        } else if (isSimpleParam(actionMethod.getParameterTypes()[i])) {
                            if (((Object[]) param)[i] != null) {
                                Unbinder.unBind(r, ((Object[]) param)[i].toString(), i < names.length ? names[i] : "", annotations);
                            }
                        } else {
                            Unbinder.unBind(r, ((Object[]) param)[i], i < names.length ? names[i] : "", annotations);
                        }
                    }
                }
                Router.ActionDefinition def = Router.reverse(action, r);
                if (absolute) {
                    def.absolute();
                }
                return def;
            } catch (ActionNotFoundException e) {
                throw new NoRouteFoundException(action, null);
            }
        } catch (Exception e) {
            if (e instanceof PlayException) {
                throw (PlayException) e;
            }
            throw new UnexpectedException(e);
        }
    }

    private static boolean isSimpleParam(Class type) {
        return Number.class.isAssignableFrom(type) || type.equals(String.class) || type.isPrimitive();
    }
}
