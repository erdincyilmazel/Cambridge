package cambridge.janino;

import java.util.Map;

import org.codehaus.janino.CompileException;
import org.codehaus.janino.ExpressionEvaluator;

import cambridge.ExpressionEvaluationException;
import cambridge.model.Expression;
import org.codehaus.janino.Parser;
import org.codehaus.janino.Scanner;

/**
 * @author Tom Carchrae
 *
 *         See http://docs.codehaus.org/display/JANINO/Basic#Basic-
 *         expressionevaluator
 */
public class JaninoExpression implements Expression {
	private static final boolean PRINT_ERRORS = false;
	final String expression;
	final int line;
	final int col;
	ExpressionEvaluator expressionEvaluator;
	private String[] parameterNames;
	private Class<?>[] parameterTypes;
	private Boolean isValue;

	public JaninoExpression(String expression, int line, int col) {
		this.expression = expression;
		this.line = line;
		this.col = col;
	}

	public Object eval(Map<String, Object> globals)
			throws ExpressionEvaluationException {
		try {
			if (expressionEvaluator == null && isValue == null)
				compileExpressionEvaluator(globals);

			// don't bother compiling expressions when returning values
			if (isValue)
				return globals.get(expression);

			return expressionEvaluator.evaluate(getArguments(globals));
		} catch (Exception e) {
			throw new ExpressionEvaluationException(getErrorMsg(), e);
		}
	}

	private String getErrorMsg() {
		return "Error evaluating exception on line: " + line + ", column: "
				+ col + ", expression: " + expression;
	}

	private Object[] getArguments(Map<String, Object> globals) {
		Object[] arguments = new Object[parameterNames.length];
		for (int i = 0; i < parameterNames.length; i++) {
			String name = parameterNames[i];
			Object argument = globals.get(name);
			if (argument != null) {
				if (!parameterTypes[i].isAssignableFrom(argument.getClass())) {
					if (PRINT_ERRORS) System.err.println("Wrong argument type passed for "
							+ parameterNames[i] + ".  Expecting "
							+ parameterTypes[i].getName() + " but got "
							+ argument.getClass().getName());
				}
			}
			arguments[i] = argument;
		}
		return arguments;
	}

	private void compileExpressionEvaluator(Map<String, Object> globals)
			throws Scanner.ScanException, CompileException, Parser.ParseException {

		if (globals.containsKey(expression)) {
			isValue=true;
		}
		else {
			isValue=false;

			/**
			 * FIXME: is it possible to figure out a return type? Does it
			 * matter? Only possible issue I can see is performance hit from
			 * Autoboxing primitives. The fix would be to create an
			 * expressionEvaluator for each of the asX methods below. Note that
			 * this might make the ExpressionEvaluator more brittle, eg, error
			 * when you return 1 and it wanted a double (eg, 1.0) - the use of
			 * (Number).doubleValue() avoids this
			 */
			Class<?> expressionType = Object.class;

			/**
			 * TODO: is there an optimization to check the expression and avoid
			 * passing names that are not in the expression?
			 */
			parameterNames = new String[globals.size()];
			parameterTypes = new Class[globals.size()];
			int i = 0;
			for (String name : globals.keySet()) {
				parameterNames[i] = name;
				Object object = globals.get(name);
				if (object != null)
					parameterTypes[i] = object.getClass();
				else {
					if (PRINT_ERRORS) System.err
							.println(getErrorMsg()
									+ " - null value passed as argument, cannot detect class so using Object.class");
					parameterTypes[i] = Object.class;
				}
				i++;
			}
			expressionEvaluator = new ExpressionEvaluator(expression,
					expressionType, parameterNames, parameterTypes);
		}
	}

	public boolean asBoolean(Map<String, Object> bindings)
			throws ExpressionEvaluationException {
		Object o = eval(bindings);

		if (o instanceof Boolean) {
			return (Boolean) o;
		}
		if (o instanceof Number) {
			return ((Number) o).intValue() != 0;
		}
		return o instanceof String && !"".equals(o);
	}

	public int asInt(Map<String, Object> bindings)
			throws ExpressionEvaluationException {
		Object o = eval(bindings);
		if (o instanceof Number) {
			return ((Number) o).intValue();
		}
		return 0;
	}

	public float asFloat(Map<String, Object> bindings)
			throws ExpressionEvaluationException {
		Object o = eval(bindings);
		if (o instanceof Number) {
			return ((Number) o).floatValue();
		}

		return 0;
	}

	public double asDouble(Map<String, Object> bindings)
			throws ExpressionEvaluationException {
		Object o = eval(bindings);
		if (o instanceof Number) {
			return ((Number) o).doubleValue();
		}
		return 0;
	}

	public long asLong(Map<String, Object> bindings)
			throws ExpressionEvaluationException {
		Object o = eval(bindings);
		if (o instanceof Number) {
			return ((Number) o).longValue();
		}
		return 0;
	}

	public String asString(Map<String, Object> bindings)
			throws ExpressionEvaluationException {
		return eval(bindings).toString();
	}
}
