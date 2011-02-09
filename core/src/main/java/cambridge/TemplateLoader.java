package cambridge;

import cambridge.model.TemplateDocument;

import java.io.InputStream;

/**
 * User: erdinc
 * Date: Nov 6, 2009
 * Time: 11:35:46 PM
 */
public interface TemplateLoader {
   /**
    * <p>Creates a TemplateFactory for the file in the given path.</p>
    *
    * <p>A template factory is a thread safe, reusable object that creates
    * {@link Template} objects. Typically you create a TemplateFactory for each of your
    * template files and keep references to these objects throughout your application
    * life cycle. You don't need to create a TemplateFactory for the same template
    * file more than once unless you explicitly want a fresh copy</p>
    *
    * @param templatePath Template name or full path. Depends on the implementation
    * @return A template factory which holds a parsed/normalized template structure.
    * @throws TemplateLoadingException Thrown if template could not be loaded or parsed.
    */
   TemplateFactory newTemplateFactory(String templatePath) throws TemplateLoadingException;

   /**
    * <p>Creates a TemplateFactory for the file in the given path. The template parser
    * uses the supplied encoding to read the file</p>
    *
    * <p>A template factory is a thread safe, reusable object that creates
    * {@link Template} objects. Typically you create a TemplateFactory for each of your
    * template files and keep references to these objects throughout your application
    * life cycle. You don't need to create a TemplateFactory for the same template
    * file more than once unless you explicitly want a fresh copy</p>
    *
    * @param templatePath Template name or full path. Depends on the implementation
    * @param encoding Input file encoding
    * @return A template factory which holds a parsed/normalized template structure.
    * @throws TemplateLoadingException Thrown if template could not be loaded or parsed.
    */
   TemplateFactory newTemplateFactory(String templatePath, String encoding) throws TemplateLoadingException;

   /**
    * <p>Creates a TemplateFactory for the file in the given path. After the template file is
    * parsed, the created {@link TemplateDocument} object which is a DOM like tree of nodes and elements
    * is passed to the supplied TemplateModifier for modification</p>
    *
    * <p>A typical usage of this method is by writing an anonymous TemplateModifier:</p>
    * <pre>
    * templateLoader.newTemplateFactory("index.html", new TemplateModifier() {
    *    public void modifyTemplate(TemplateDocument doc) {
    *       doc.getElementById('main').setText("Hello World");
    *    }
    * }
    * </pre>
    * <p>
    * After the modification, the TemplateDocument gets normalized and a TemplateFactory
    * gets created.
    * </p>
    *
    * <p>A template factory is a thread safe, reusable object that creates
    * {@link Template} objects. Typically you create a TemplateFactory for each of your
    * template files and keep references to these objects throughout your application
    * life cycle. You don't need to create a TemplateFactory for the same template
    * file more than once unless you explicitly want a fresh copy</p>
    *
    * @param templatePath Template name or full path. Depends on the implementation
    * @param modifier The modifier that will modify the parsed template model
    * @return A template factory which holds a parsed/normalized template structure.
    * @see TemplateModifier
    * @throws TemplateLoadingException Thrown if template could not be loaded or parsed.
    */
   TemplateFactory newTemplateFactory(String templatePath, TemplateModifier modifier) throws TemplateLoadingException;

   /**
    * <p>Creates a TemplateFactory for the file in the given path. The template parser
    * uses the supplied encoding to read the file. After the template file is
    * parsed, the created {@link TemplateDocument} object which is a DOM like tree of nodes and elements
    * is passed to the supplied TemplateModifier for modification</p>
    *
    * <p>A typical usage of this method is by writing an anonymous TemplateModifier:</p>
    * <pre>
    * templateLoader.newTemplateFactory("index.html", new TemplateModifier() {
    *    public void modifyTemplate(TemplateDocument doc) {
    *       doc.getElementById('main').setText("Hello World");
    *    }
    * }
    * </pre>
    * <p>
    * After the modification, the TemplateDocument gets normalized and a TemplateFactory
    * gets created.
    * </p>
    *
    * <p>A template factory is a thread safe, reusable object that creates
    * {@link Template} objects. Typically you create a TemplateFactory for each of your
    * template files and keep references to these objects throughout your application
    * life cycle. You don't need to create a TemplateFactory for the same template
    * file more than once unless you explicitly want a fresh copy</p>
    *
    * @param templatePath Template name or full path. Depends on the implementation
    * @param encoding Input file encoding
    * @param modifier The modifier that will modify the parsed template model
    * @return A template factory which holds a parsed/normalized template structure.
    * @see TemplateModifier
    * @throws TemplateLoadingException Thrown if template could not be loaded or parsed.
    */
   TemplateFactory newTemplateFactory(String templatePath, String encoding, TemplateModifier modifier) throws TemplateLoadingException;

   /**
    * <p>Creates a TemplateFactory after parsing the supplied template text.</p>
    *
    * @param templateSource The template source to be parsed.
    * @return A template factory which holds a parsed/normalized template structure.
    * @throws TemplateLoadingException Thrown if the template could not be parsed
    */
   TemplateFactory parseAndCreateTemplateFactory(String templateSource) throws TemplateLoadingException;

   /**
    * <p>Parses the template reading from the supplied input stream and returns the
    * TemplateDocument which contains the document model tree.</p>
    *
    * <p>This method uses systems default encoding to read the characters from the input stream</p>
    *
    * @param in Input stream to be read from.
    * @return Returns the parsed template as a TemplateDocument object
    * @throws TemplateLoadingException Thrown if the template could not be parsed
    */
   TemplateDocument parseTemplate(InputStream in) throws TemplateLoadingException;

   /**
    * <p>Parses the template reading from the supplied input stream and returns the
    * TemplateDocument which is the root node of template object model.</p>
    *
    * <p>This method uses supplied encoding to read the characters from the input stream</p>
    *
    * @param in Input stream to be read from.
    * @param encoding The encoding that will be used while reading from input stream
    * @return Returns the parsed template as a TemplateDocument object
    * @throws TemplateLoadingException Thrown if the template could not be parsed
    */
   TemplateDocument parseTemplate(InputStream in, String encoding) throws TemplateLoadingException;

   /**
    * <p>Parses the template in the specified template path and returns the TemplateDocument
    * which is the root node of the template object model</p>
    *
    * <p>This method uses systems default encoding while reading the file</p>
    *
    * @param templatePath Template path
    * @return Returns the parsed template as a TemplateDocument object
    * @throws TemplateLoadingException Thrown if the template could not be parsed or loaded
    */
   TemplateDocument parseTemplate(String templatePath) throws TemplateLoadingException;

   /**
    * <p>Parses the template in the specified template path and returns the TemplateDocument
    * which is the root node of the template object model</p>
    *
    * <p>This method uses the supplied encoding while reading the file</p>
    *
    * @param templatePath Template path
    * @param encoding Encoding to be used while reading the template file
    * @return Returns the parsed template as a TemplateDocument object
    * @throws TemplateLoadingException Thrown if the template could not be parsed or loaded
    */
   TemplateDocument parseTemplate(String templatePath, String encoding) throws TemplateLoadingException;

   /**
    * <p>Parses the supplied template source code and returns a TemplateDocument
    * which is the root node of the template object model</p>
    * @param templateSource The template source code to be parsed
    * @return Returns the parsed template as a TemplateDocument object
    * @throws TemplateLoadingException Thrown if the template could not be parsed or loaded
    */
   TemplateDocument parseAndCreateTemplateDocument(String templateSource) throws TemplateLoadingException;
}
