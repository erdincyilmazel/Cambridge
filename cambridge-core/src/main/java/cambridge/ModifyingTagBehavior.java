package cambridge;

import cambridge.model.ModifyableTag;
import cambridge.runtime.ExpressionContext;

import java.util.Map;

/**
 * @author Erdinc Yilmazel
 * Date: Nov 1, 2009
 * Time: 3:29:42 PM
 */
public abstract class ModifyingTagBehavior implements TagBehavior {
    protected final int line;
    protected final int col;

    protected ModifyingTagBehavior(int line, int col) {
        this.line = line;
        this.col = col;
    }

    public int getLine() {
        return line;
    }

    public int getCol() {
        return col;
    }

    public abstract void modify(ExpressionContext context, ModifyableTag tag) throws ExpressionEvaluationException;
}
