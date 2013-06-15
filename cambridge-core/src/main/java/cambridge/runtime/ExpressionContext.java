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
     *
     * @param name the variable's name
     * @return the value
     */
    Object get(String name);

    /**
     * Sets the value of a variable.
     *
     * @param name  the variable's name
     * @param value the variable's value
     */
    Object put(String name, Object value);

    /**
     * Removes a value from the context
     * @param name Variable to be removed
     * @return Returns the removed object
     */
    Object remove(String name);

    /**
     * Sets all the variables in the context from the provided map
     * @param variables The map of variable names to their values
     */
    void setVariables(Map<String, Object> variables);

    /**
     * @return Returns the context locale
     */
    public Locale getLocale();

    /**
     * Checks whether a variable is defined in this context.
     * <p>A variable may be defined with a null value; this method checks whether the
     * value is null or if the variable is undefined.</p>
     *
     * @param name the variable's name
     * @return true if it exists, false otherwise
     */
    boolean has(String name);

    /**
     * @return Returns the context as a map
     */
    public Map<String, Object> asMap();
}
