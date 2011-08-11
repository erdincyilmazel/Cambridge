package cambridge.behaviors;

import cambridge.BehaviorInstantiationException;
import cambridge.BehaviorProvider;
import cambridge.ExpressionEvaluationException;
import cambridge.ExpressionParsingException;
import cambridge.LoopingTagBehavior;
import cambridge.TemplateEvaluationException;
import cambridge.model.Attribute;
import cambridge.model.AttributeKey;
import cambridge.model.DynamicAttribute;
import cambridge.model.Expression;
import cambridge.model.TagNode;
import cambridge.runtime.Iter;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;

/**
 * User: erdinc
 * Date: Oct 31, 2009
 * Time: 7:18:33 PM
 */
public class ForeachBehavior extends LoopingTagBehavior {
    private final Expression iterable;
    private final String currentObjectName;
    private final String iterObjectName;

    public ForeachBehavior(Expression iterable, String currentObjectName, String iterObjectName, int line, int col) {
        super(line, col);
        this.iterable = iterable;
        this.currentObjectName = currentObjectName;
        this.iterObjectName = iterObjectName;
    }

    @Override
    public String getCurrentObjectName() {
        if (currentObjectName == null) {
            return super.getCurrentObjectName();
        }

        return currentObjectName;
    }

    @Override
    public String getIterObjectName() {
        if (iterObjectName == null) {
            return super.getIterObjectName();
        }

        return iterObjectName;
    }

    @Override
    public void doExecute(Map<String, Object> bindings, TagNode tag, Writer out) throws TemplateEvaluationException, IOException {
        try {
            Object o = iterable.eval(bindings);
            if (o == null) {
                return;
                //throw new TemplateEvaluationException("The provided expression value for foreach attribute is null", tag.getBeginLine(), tag.getBeginColumn(), tag.getTagName());
            }

            if (o instanceof Object[]) {
                iterateArray(bindings, tag, out, (Object[]) o);
            } else if (o instanceof Iterable) {
                iterateIterable(bindings, tag, out, (Iterable) o);
            } else if (o instanceof int[]) {
                iterateInt(bindings, tag, out, (int[]) o);
            } else if (o instanceof float[]) {
                iterateFloat(bindings, tag, out, (float[]) o);
            } else if (o instanceof double[]) {
                iterateDouble(bindings, tag, out, (double[]) o);
            } else if (o instanceof byte[]) {
                iterateByte(bindings, tag, out, (byte[]) o);
            } else if (o instanceof char[]) {
                iterateChar(bindings, tag, out, (char[]) o);
            } else if (o instanceof boolean[]) {
                iterateBoolean(bindings, tag, out, (boolean[]) o);
            } else {
                throw new TemplateEvaluationException(null, "The provided expression value of class " +
                        o.getClass().getName() + " for foreach attribute is not iterable, on line: "
                        + tag.getBeginLine() + ", column: " + tag.getBeginColumn(), tag.getBeginLine(), tag.getBeginColumn());
            }

        } catch (ExpressionEvaluationException e) {
            throw new TemplateEvaluationException(e, "Could not execute the expression: " + e.getMessage(), tag.getBeginLine(), tag.getBeginColumn(), tag.getTagName());
        }
    }

    private void iterateIterable(Map<String, Object> bindings, TagNode tag, Writer out, Iterable o) throws IOException, TemplateEvaluationException {
        Iter iter = new Iter();
        bindings.put(getIterObjectName(), iter);
        for (Object o1 : o) {
            bindings.put(getCurrentObjectName(), o1);
            tag.execute(bindings, out);
            iter.next();
        }
    }

    private void iterateArray(Map<String, Object> bindings, TagNode tag, Writer out, Object[] o) throws IOException, TemplateEvaluationException {
        Iter iter = new Iter();
        bindings.put(getIterObjectName(), iter);
        for (Object o1 : o) {
            bindings.put(getCurrentObjectName(), o1);
            tag.execute(bindings, out);
            iter.next();
        }
    }

    private void iterateInt(Map<String, Object> bindings, TagNode tag, Writer out, int[] o) throws IOException, TemplateEvaluationException {
        Iter iter = new Iter();
        bindings.put(getIterObjectName(), iter);
        for (int o1 : o) {
            bindings.put(getCurrentObjectName(), o1);
            tag.execute(bindings, out);
            iter.next();
        }
    }

    private void iterateFloat(Map<String, Object> bindings, TagNode tag, Writer out, float[] o) throws IOException, TemplateEvaluationException {
        Iter iter = new Iter();
        bindings.put(getIterObjectName(), iter);
        for (float o1 : o) {
            bindings.put(getCurrentObjectName(), o1);
            tag.execute(bindings, out);
            iter.next();
        }
    }

    private void iterateDouble(Map<String, Object> bindings, TagNode tag, Writer out, double[] o) throws IOException, TemplateEvaluationException {
        Iter iter = new Iter();
        bindings.put(getIterObjectName(), iter);
        for (double o1 : o) {
            bindings.put(getCurrentObjectName(), o1);
            tag.execute(bindings, out);
            iter.next();
        }
    }

    private void iterateByte(Map<String, Object> bindings, TagNode tag, Writer out, byte[] o) throws IOException, TemplateEvaluationException {
        Iter iter = new Iter();
        bindings.put(getIterObjectName(), iter);
        for (byte o1 : o) {
            bindings.put(getCurrentObjectName(), o1);
            tag.execute(bindings, out);
            iter.next();
        }
    }

    private void iterateChar(Map<String, Object> bindings, TagNode tag, Writer out, char[] o) throws IOException, TemplateEvaluationException {
        Iter iter = new Iter();
        bindings.put(getIterObjectName(), iter);
        for (char o1 : o) {
            bindings.put(getCurrentObjectName(), o1);
            tag.execute(bindings, out);
            iter.next();
        }
    }

    private void iterateBoolean(Map<String, Object> bindings, TagNode tag, Writer out, boolean[] o) throws IOException, TemplateEvaluationException {
        Iter iter = new Iter();
        bindings.put(getIterObjectName(), iter);
        for (boolean o1 : o) {
            bindings.put(getCurrentObjectName(), o1);
            tag.execute(bindings, out);
            iter.next();
        }
    }

    public static BehaviorProvider<ForeachBehavior> getProvider() {
        return new BehaviorProvider<ForeachBehavior>() {
            public ForeachBehavior get(DynamicAttribute keyAttribute, Map<AttributeKey, Attribute> attributes, int line, int col) throws ExpressionParsingException, BehaviorInstantiationException {

                AttributeKey asKey = new AttributeKey(keyAttribute.getAttributeNameSpace(), "as");
                Attribute asAttribute = attributes.get(asKey);

                AttributeKey iterKey = new AttributeKey(keyAttribute.getAttributeNameSpace(), "iter");
                Attribute iterAttribute = attributes.get(iterKey);

                Expression e = keyAttribute.getExpression();
                return new ForeachBehavior(e, asAttribute == null ? null : asAttribute.getValue(), iterAttribute == null ? null : iterAttribute.getValue(), line, col);
            }
        };
    }
}