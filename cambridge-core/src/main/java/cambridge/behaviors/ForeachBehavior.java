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
import cambridge.runtime.ExpressionContext;
import cambridge.runtime.Iter;

import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Erdinc Yilmazel
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

    @SuppressWarnings("unchecked")
    @Override
    public void doExecute(ExpressionContext context, TagNode tag, Writer out) throws TemplateEvaluationException, IOException {
        try {
            Object o = iterable.eval(context);
            if (o == null) {
                return;
                //throw new TemplateEvaluationException("The provided expression value for foreach attribute is null", tag.getBeginLine(), tag.getBeginColumn(), tag.getTagName());
            }

            if (o instanceof Object[]) {
                iterateArray(context, tag, out, (Object[]) o);
            } else if (o instanceof Iterable) {
                iterateIterable(context, tag, out, (Iterable<Object>) o);
            } else if (o instanceof int[]) {
                iterateInt(context, tag, out, (int[]) o);
            } else if (o instanceof float[]) {
                iterateFloat(context, tag, out, (float[]) o);
            } else if (o instanceof double[]) {
                iterateDouble(context, tag, out, (double[]) o);
            } else if (o instanceof byte[]) {
                iterateByte(context, tag, out, (byte[]) o);
            } else if (o instanceof char[]) {
                iterateChar(context, tag, out, (char[]) o);
            } else if (o instanceof boolean[]) {
                iterateBoolean(context, tag, out, (boolean[]) o);
            } else {
                throw new TemplateEvaluationException(null, "The provided expression value of class " +
                        o.getClass().getName() + " for foreach attribute is not iterable, on line: "
                        + tag.getBeginLine() + ", column: " + tag.getBeginColumn(), tag.getBeginLine(), tag.getBeginColumn());
            }

        } catch (ExpressionEvaluationException e) {
            throw new TemplateEvaluationException(e, "Could not execute the expression: " + e.getMessage(), tag.getBeginLine(), tag.getBeginColumn(), tag.getTagName());
        }
    }

    private void iterateIterable(ExpressionContext context, TagNode tag, Writer out, Iterable<Object> o) throws IOException, TemplateEvaluationException {
        Iter iter = new Iter();
        context.put(getIterObjectName(), iter);
        Iterator<?> it = o.iterator();
        while (it.hasNext()) {
        	Object o1 = it.next();

        	if (!it.hasNext()) {
        		iter.setLast();
            }

            context.put(getCurrentObjectName(), o1);
            tag.execute(context, out);
            iter.next();
        }
    }

    private void iterateArray(ExpressionContext context, TagNode tag, Writer out, Object[] o) throws IOException, TemplateEvaluationException {
        Iter iter = new Iter();
        context.put(getIterObjectName(), iter);
        for (int i=0; i<o.length; i++) {
        	if (i == o.length-1)
        		iter.setLast();

            context.put(getCurrentObjectName(), o[i]);
            tag.execute(context, out);
            iter.next();
        }
    }

    private void iterateInt(ExpressionContext context, TagNode tag, Writer out, int[] o) throws IOException, TemplateEvaluationException {
        Iter iter = new Iter();
        context.put(getIterObjectName(), iter);
        for (int i=0; i<o.length; i++) {
        	if (i == o.length-1)
        		iter.setLast();

            context.put(getCurrentObjectName(), o[i]);
            tag.execute(context, out);
            iter.next();
        }
    }

    private void iterateFloat(ExpressionContext context, TagNode tag, Writer out, float[] o) throws IOException, TemplateEvaluationException {
        Iter iter = new Iter();
        context.put(getIterObjectName(), iter);
        for (int i=0; i<o.length; i++) {
        	if (i == o.length-1)
        		iter.setLast();

            context.put(getCurrentObjectName(), o[i]);
            tag.execute(context, out);
            iter.next();
        }
    }

    private void iterateDouble(ExpressionContext context, TagNode tag, Writer out, double[] o) throws IOException, TemplateEvaluationException {
        Iter iter = new Iter();
        context.put(getIterObjectName(), iter);
        for (int i=0; i<o.length; i++) {
        	if (i == o.length-1)
        		iter.setLast();

            context.put(getCurrentObjectName(), o[i]);
            tag.execute(context, out);
            iter.next();
        }
    }

    private void iterateByte(ExpressionContext context, TagNode tag, Writer out, byte[] o) throws IOException, TemplateEvaluationException {
        Iter iter = new Iter();
        context.put(getIterObjectName(), iter);
        for (int i=0; i<o.length; i++) {
        	if (i == o.length-1)
        		iter.setLast();

            context.put(getCurrentObjectName(), o[i]);
            tag.execute(context, out);
            iter.next();
        }
    }

    private void iterateChar(ExpressionContext context, TagNode tag, Writer out, char[] o) throws IOException, TemplateEvaluationException {
        Iter iter = new Iter();
        context.put(getIterObjectName(), iter);
        for (int i=0; i<o.length; i++) {
        	if (i == o.length-1)
        		iter.setLast();

            context.put(getCurrentObjectName(), o[i]);
            tag.execute(context, out);
            iter.next();
        }
    }

    private void iterateBoolean(ExpressionContext context, TagNode tag, Writer out, boolean[] o) throws IOException, TemplateEvaluationException {
        Iter iter = new Iter();
        context.put(getIterObjectName(), iter);
        for (int i=0; i<o.length; i++) {
        	if (i == o.length-1)
        		iter.setLast();

            context.put(getCurrentObjectName(), o[i]);
            tag.execute(context, out);
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
