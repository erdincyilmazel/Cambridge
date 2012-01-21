package cambridge.parser.expressions;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Map;

import cambridge.ExpressionEvaluationException;

/**
 * Author: Erdinc Yilmazel
 * Date: 9/12/11
 */
public class StaticMethodCaller extends FunctionRunner {
    Method method;

    public StaticMethodCaller(Method method) {
        if ((method.getModifiers() & Modifier.STATIC) == 0) {
            throw new IllegalArgumentException(method.toString() + " should be static");
        }
        method.setAccessible(true);
        this.method = method;
    }

    @Override
    public Object eval(Map<String, Object> bindings, CambridgeExpression[] params) throws ExpressionEvaluationException {
        Class<?>[] parameterTypes = method.getParameterTypes();
        if (parameterTypes != null && (params == null || parameterTypes.length != params.length)) {
            throw new ExpressionEvaluationException("Invalid number of parameters provided for calling static method " + method.toString());
        }

        try {
            if (params == null || params.length == 0) {
                return method.invoke(null);
            }

            Object[] args = new Object[params.length];

            for (int i = 0, paramsLength = params.length; i < paramsLength; i++) {
                CambridgeExpression e = params[i];

                args[i] = e.eval(bindings);
                if (method.isVarArgs() && i == params.length - 1 && parameterTypes != null && !(parameterTypes[i].isAssignableFrom(args[i].getClass()))) {
                    args[i] = new Object[] {args[i]};
                }
            }

            return method.invoke(null, args);

        } catch (Exception e) {
            throw new ExpressionEvaluationException("Error calling static method " + method.toString(), e);
        }
    }
}
