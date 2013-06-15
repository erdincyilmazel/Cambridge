package cambridge.parser.expressions;

import cambridge.ExpressionEvaluationException;
import cambridge.model.Expression;
import cambridge.runtime.ExpressionContext;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Erdinc Yilmazel (eyilmazel@tripadvisor.com)
 * @since 6/15/13
 */
public class CambridgeExpressionLanguageTest
{
    CambridgeExpressionLanguage expressionLanguage = new CambridgeExpressionLanguage();

    public static class Sample
    {
        String name;
        int id;
        Sample2 sample2;

        public String getName()
        {
            return name;
        }

        public void setName(String name)
        {
            this.name = name;
        }

        public int getId()
        {
            return id;
        }

        public void setId(int id)
        {
            this.id = id;
        }

        public Sample2 getSample2()
        {
            return sample2;
        }

        public void setSample2(Sample2 sample2)
        {
            this.sample2 = sample2;
        }

        @Override
        public boolean equals(Object o)
        {
            if (this == o)
            {
                return true;
            }
            if (o == null || getClass() != o.getClass())
            {
                return false;
            }

            Sample sample = (Sample) o;

            if (id != sample.id)
            {
                return false;
            }
            if (name != null ? !name.equals(sample.name) : sample.name != null)
            {
                return false;
            }
            if (sample2 != null ? !sample2.equals(sample.sample2) : sample.sample2 != null)
            {
                return false;
            }

            return true;
        }

        @Override
        public int hashCode()
        {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + id;
            result = 31 * result + (sample2 != null ? sample2.hashCode() : 0);
            return result;
        }
    }

    public static class Sample2
    {
        String x;
        Date y;

        public String getX()
        {
            return x;
        }

        public void setX(String x)
        {
            this.x = x;
        }

        public Date getY()
        {
            return y;
        }

        public void setY(Date y)
        {
            this.y = y;
        }

        @Override
        public boolean equals(Object o)
        {
            if (this == o)
            {
                return true;
            }
            if (o == null || getClass() != o.getClass())
            {
                return false;
            }

            Sample2 sample2 = (Sample2) o;

            if (x != null ? !x.equals(sample2.x) : sample2.x != null)
            {
                return false;
            }
            if (y != null ? !y.equals(sample2.y) : sample2.y != null)
            {
                return false;
            }

            return true;
        }

        @Override
        public int hashCode()
        {
            int result = x != null ? x.hashCode() : 0;
            result = 31 * result + (y != null ? y.hashCode() : 0);
            return result;
        }
    }

    Sample sample;
    Sample2 sample2;

    @Before
    public void setUp()
    {
        sample = new Sample();
        sample.name = "Cambridge";
        sample.id = 100;

        sample2 = new Sample2();
        sample2.x = "x";
        sample2.y = new Date();

        sample.sample2 = sample2;
    }

    @Test
    public void testSimple() throws ExpressionEvaluationException
    {
        ExpressionContext context = expressionLanguage.createNewContext();
        Expression expression = expressionLanguage.parse("5 + 8", 1, 1);

        Object result = expression.eval(context);
        assertEquals("Testing simple arithmetic", 13, result);
    }

    @Test
    public void testComplexArithmetic() throws ExpressionEvaluationException
    {
        ExpressionContext context = expressionLanguage.createNewContext();
        assertEquals("Testing simple arithmetic", 20494, expressionLanguage.parse("(891 * 23 + 12 / 8)", 1, 1).eval(context));
        assertEquals("Testing simple arithmetic", 20494.5, expressionLanguage.parse("(891 * 23 + 12.0 / 8)", 1, 1).eval(context));
        assertEquals("Testing simple arithmetic", 4.5, expressionLanguage.parse("(891 * 23 + 12.0 / 8) % 10", 1, 1).eval(context));
    }

    @Test
    public void testVariableAccess() throws Exception
    {
        ExpressionContext context = expressionLanguage.createNewContext();
        context.set("name", "Cambridge");
        Expression expression = expressionLanguage.parse("name", 1, 1);

        Object result = expression.eval(context);
        assertEquals("Testing variable access", "Cambridge", result);
    }

    @Test
    public void testBean() throws Exception
    {
        ExpressionContext context = expressionLanguage.createNewContext();
        context.set("sample", sample);
        Expression expression = expressionLanguage.parse("sample", 1, 1);

        Object result = expression.eval(context);
        assertEquals("Testing variable access", sample, result);
        assertTrue("Testing variable access", sample == result);

        assertEquals("Testing bean name", "Cambridge", expressionLanguage.parse("sample.name", 1, 1).eval(context));
        assertEquals("Testing bean id", 100, expressionLanguage.parse("sample.id", 1, 1).eval(context));
        assertEquals("Testing property chain", "x", expressionLanguage.parse("sample.sample2.x", 1, 1).eval(context));
    }
}
