package cambridge.behaviors;

import cambridge.BehaviorInstantiationException;
import cambridge.BehaviorProvider;
import cambridge.ExpressionEvaluationException;
import cambridge.ExpressionParsingException;
import cambridge.Expressions;
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
 * Date: Nov 1, 2009
 * Time: 3:57:11 PM
 */
public class RepeatBehavior extends LoopingTagBehavior {
    private final Expression number;

    public RepeatBehavior(Expression number, int line, int col) {
        super(line, col);
        this.number = number;
    }

    @Override
    public void doExecute(Map<String, Object> bindings, TagNode tag, Writer out) throws TemplateEvaluationException, IOException {
        try {
            Iter iter = new Iter();
            int n = number.asInt(bindings);
            for (int i = 0; i != n; i++) {
                bindings.put(Expressions.CURRENT_OBJECT, i);
                bindings.put(Expressions.ITER_OBJECT, iter);
                tag.execute(bindings, out);
                iter.next();
            }
        } catch (ExpressionEvaluationException e) {
            throw new TemplateEvaluationException(e, "Could not execute the expression: " +
                    e.getMessage() + ", on line: " + tag.getBeginLine() + ", column: " +
                    tag.getBeginColumn(), tag.getBeginLine(), tag.getBeginColumn(), tag.getTagName());
        }
    }

    public static BehaviorProvider<RepeatBehavior> getProvider() {
        return new BehaviorProvider<RepeatBehavior>() {
            public RepeatBehavior get(DynamicAttribute keyAttribute, Map<AttributeKey, Attribute> attributes, int line, int col) throws ExpressionParsingException, BehaviorInstantiationException {
                Expression number = keyAttribute.getExpression();
                return new RepeatBehavior(number, line, col);
            }
        };
    }
}