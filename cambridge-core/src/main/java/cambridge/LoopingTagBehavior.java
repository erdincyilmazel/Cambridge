package cambridge;

import cambridge.model.TagNode;
import cambridge.runtime.ExpressionContext;
import cambridge.runtime.Iter;
import cambridge.runtime.Super;

import java.io.IOException;
import java.io.Writer;

/**
 * @author Erdinc Yilmazel
 * Date: Oct 31, 2009
 * Time: 7:16:27 PM
 */
public abstract class LoopingTagBehavior implements TagBehavior {
    protected final int line;
    protected final int col;

    protected LoopingTagBehavior(int line, int col) {
        this.line = line;
        this.col = col;
    }

    public final void execute(ExpressionContext context, TagNode tag, Writer out) throws TemplateEvaluationException, IOException {
        Object t = context.get(getCurrentObjectName());
        Super ts = (Super) context.get(getParentObjectName());
        Iter iter = (Iter) context.get(getIterObjectName());

        Super s = null;

        if (t != null) {
            s = new Super(t, ts, iter);
            context.set(getParentObjectName(), s);
        }

        doExecute(context, tag, out);

        if (t != null) {
            context.set(getCurrentObjectName(), s.get());
            context.set(getParentObjectName(), s.getSuper());
            context.set(getIterObjectName(), s.getIter());
        } else {
            context.set(getCurrentObjectName(), t);
            context.set(getParentObjectName(), ts);
            context.set(getIterObjectName(), iter);
        }
    }

    protected abstract void doExecute(ExpressionContext context, TagNode tag, Writer out) throws TemplateEvaluationException, IOException;

    public String getCurrentObjectName() {
        return Expressions.CURRENT_OBJECT;
    }

    public String getParentObjectName() {
        return Expressions.PARENT_OBJECT;
    }

    public String getIterObjectName() {
        return Expressions.ITER_OBJECT;
    }

    public int getLine() {
        return line;
    }

    public int getCol() {
        return col;
    }
}
