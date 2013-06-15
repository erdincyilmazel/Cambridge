package cambridge.runtime;

import java.util.Locale;
import java.util.Map;

/**
 * @author Erdinc Yilmazel (eyilmazel@tripadvisor.com)
 * @since 6/14/13
 */
public interface ExpressionContext
{
    /**
     * Gets the value of a variable.
     * @param name the variable's name
     * @return the value
     */
    Object get(String name);

    /**
     * Sets the value of a variable.
     * @param name the variable's name
     * @param value the variable's value
     */
    void set(String name, Object value);

    public Object remove(String name);

    void setVariables(Map<String, Object> variables);

    public Locale getLocale();

    /**
     * Checks whether a variable is defined in this context.
     * <p>A variable may be defined with a null value; this method checks whether the
     * value is null or if the variable is undefined.</p>
     * @param name the variable's name
     * @return true if it exists, false otherwise
     */
    boolean has(String name);

    public Map<String, Object> asMap();
}
