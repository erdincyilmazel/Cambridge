package cambridge.jexl;

import cambridge.parser.expressions.MapExpressionContext;
import org.apache.commons.jexl2.JexlContext;

import java.util.Locale;

/**
 * @author Erdinc Yilmazel (eyilmazel@tripadvisor.com)
 * @since 6/15/13
 */
public class JexlExpressionContext extends MapExpressionContext implements JexlContext
{
    public JexlExpressionContext()
    {
    }

    public JexlExpressionContext(Locale locale)
    {
        super(locale);
    }
}
