package cambridge;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;

/**
 * Template is a lightweight object that holds the data model for template rendering.
 * Template objects are not thread safe, using a {@link TemplateFactory} you should create
 * a Template object every time before you render a page and throw the Template object away.
 *
 * TemplateFactories are thread safe and they represent the parsed/optimized template structure.
 * Once you have a TemplateFactory object, the cost of creating a Template object is almost
 * none.
 */
public interface Template {
   /**
    * Sets a value as a property in the template. The property that is set here becomes
    * available in the template file to be used in expressions.
    *
    * For instance if you set property "msg" to the string "Hello", ${msg} will render Hello in the template
    * @param name Property (Template variable) name
    * @param property Property value
    */
   public void setProperty(String name, Object property);

   /**
    * Adds all the values in the given map as template properties.
    * @param properties The property map that will be used to get values from.
    */
   public void setAllProperties(Map<String, Object> properties);

   /**
    * Renders the page writing to the given writer. If the passed in writer is not buffered,
    * you might want to call the alternate method {@link #printBuffered(java.io.Writer)} that creates
    * a BufferedWriter that wraps the Writer you passed in. Using a BufferedWriter generally gives
    * a better performance.
    *
    * @param out The writer to be used to output the template contents
    * @throws IOException Might be thrown in case of an IO problem
    * @throws TemplateEvaluationException This exception is thrown if something goes wrong in template rendering.
    */
   public void printTo(Writer out) throws IOException, TemplateEvaluationException;

   /**
    * Renders the page writing to the given writer. Unlike {@link #printTo(java.io.Writer)} method,
    * this method creates a BufferedWriter that wraps the Writer that you pass in.
    * Using a BufferedWriter generally gives a better performance.
    *
    * @param out The writer to be used to output the template contents
    * @throws IOException Might be thrown in case of an IO problem
    * @throws TemplateEvaluationException This exception is thrown if something goes wrong in template rendering.
    */
   public void printBuffered(Writer out) throws IOException, TemplateEvaluationException;

   /**
    * Renders the template into a String.
    * @return Returns the rendered template as a String
    * @throws TemplateEvaluationException This exception is thrown if something goes wrong in template rendering.
    */
   public String asString() throws TemplateEvaluationException;
}
