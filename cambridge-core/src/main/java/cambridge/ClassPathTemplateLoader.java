package cambridge;

import cambridge.model.FragmentList;
import cambridge.model.TemplateDocument;

import java.io.InputStream;

/**
 * Template Loader to load templates from the classpath
 */
public class ClassPathTemplateLoader extends AbstractTemplateLoader {
   private final ClassLoader classLoader;

   /**
    * Creates a ClassPathTemplateLoader that will use the provided
    * class loader for template lookup
    *
    * @param classLoader Class loader to be used
    */
   public ClassPathTemplateLoader(ClassLoader classLoader) {
      this.classLoader = classLoader;
   }

   /**
    * Creates a ClassPathTemplateLoader that will use the class loader
    * of the provided Class.
    *
    * @param c The class that will be used to get a class loader from
    */
   public ClassPathTemplateLoader(Class<?> c) {
      classLoader = c.getClassLoader();
   }

   /**
    * Creates a new ClassPathTemplateLoader using the class loader
    * which loaded ClassPathTemplateLoader.class
    */
   public ClassPathTemplateLoader() {
      classLoader = ClassPathTemplateLoader.class.getClassLoader();
   }

   /**
    * Creates a new TemplateFactory
    * <p/>
    * The template lookup is made on the classpath. The template path
    * should be provided as com/yourcompany/packages/index.html
    *
    * @param template The template path
    * @return Returns the newly created TemplateFactory
    * @throws TemplateLoadingException
    */
   public TemplateFactory newTemplateFactory(String template, ExpressionLanguage expressionLanguage) throws TemplateLoadingException {
      InputStream in = classLoader.getResourceAsStream(template);
      TemplateDocument doc = parseTemplate(in, expressionLanguage);
      try {
         FragmentList fragments = doc.normalize();
         return new ImmutableTemplateFactory(this, fragments);
      } catch (BehaviorInstantiationException e) {
         throw new TemplateLoadingException(e);
      }
   }


   /**
    * Creates a new TemplateFactory
    * <p/>
    * The template lookup is made on the classpath. The template path
    * should be provided as com/yourcompany/packages/index.html
    *
    * @param template The template path
    * @param encoding The encoding to be used while parsing the template
    * @return Returns the newly created TemplateFactory
    * @throws TemplateLoadingException
    */
   public TemplateFactory newTemplateFactory(String template, String encoding, ExpressionLanguage expressionLanguage) throws TemplateLoadingException {
      InputStream in = classLoader.getResourceAsStream(template);
      TemplateDocument doc = parseTemplate(in, encoding, expressionLanguage);
      try {
         FragmentList fragments = doc.normalize();
         return new ImmutableTemplateFactory(this, fragments);
      } catch (BehaviorInstantiationException e) {
         throw new TemplateLoadingException(e);
      }
   }

   /**
    * Creates a new TemplateFactory
    * <p/>
    * The template lookup is made on the classpath. The template path
    * should be provided as com/yourcompany/packages/index.html
    * <p/>
    * This method also accepts a TemplateModifier which will be called
    * right after the template parsing finishes.
    *
    * @param template The template path
    * @param modifier The template modifier that will alter the structure of the template
    * @return Returns the newly created TemplateFactory
    * @throws TemplateLoadingException
    */
   public TemplateFactory newTemplateFactory(String template, TemplateModifier modifier, ExpressionLanguage expressionLanguage) throws TemplateLoadingException {
      InputStream in = classLoader.getResourceAsStream(template);
      TemplateDocument doc = parseTemplate(in, expressionLanguage);
      modifier.modifyTemplate(doc);
      try {
         FragmentList fragments = doc.normalize();
         return new ImmutableTemplateFactory(this, fragments);
      } catch (BehaviorInstantiationException e) {
         throw new TemplateLoadingException(e);
      }
   }

   /**
    * Creates a new TemplateFactory
    * <p/>
    * The template lookup is made on the classpath. The template path
    * should be provided as com/yourcompany/packages/index.html
    * <p/>
    * This method also accepts a TemplateModifier which will be called
    * right after the template parsing finishes.
    *
    * @param template The template path
    * @param encoding The encoding to be used while parsing the template
    * @param modifier The template modifier that will alter the structure of the template
    * @return Returns the newly created TemplateFactory
    * @throws TemplateLoadingException
    */
   public TemplateFactory newTemplateFactory(String template, String encoding, TemplateModifier modifier, ExpressionLanguage expressionLanguage) throws TemplateLoadingException {
      InputStream in = classLoader.getResourceAsStream(template);
      TemplateDocument doc = parseTemplate(in, encoding, expressionLanguage);
      modifier.modifyTemplate(doc);
      try {
         FragmentList fragments = doc.normalize();
         return new ImmutableTemplateFactory(this, fragments);
      } catch (BehaviorInstantiationException e) {
         throw new TemplateLoadingException(e);
      }
   }

   /**
    * <p>Parses the template in the specified template path and returns the TemplateDocument
    * which is the root node of the template object model</p>
    *
    * <p>This method uses systems default encoding while reading the file</p>
    *
    * @param templatePath Template path (Example: /com/example/xyz.html)
    * @return Returns the parsed template as a TemplateDocument object
    * @throws TemplateLoadingException Thrown if the template could not be parsed or loaded
    */
   public TemplateDocument parseTemplate(String templatePath, ExpressionLanguage expressionLanguage) throws TemplateLoadingException {
      InputStream in = classLoader.getResourceAsStream(templatePath);
      return parseTemplate(in, expressionLanguage);
   }

   /**
    * <p>Parses the template in the specified template path and returns the TemplateDocument
    * which is the root node of the template object model</p>
    *
    * <p>This method uses provided encoding while reading the file</p>
    *
    * @param templatePath Template path (Example: /com/example/xyz.html)
    * @param  encoding Template file character encoding
    * @return Returns the parsed template as a TemplateDocument object
    * @throws TemplateLoadingException Thrown if the template could not be parsed or loaded
    */
   public TemplateDocument parseTemplate(String templatePath, String encoding, ExpressionLanguage expressionLanguage) throws TemplateLoadingException {
      InputStream in = classLoader.getResourceAsStream(templatePath);
      return parseTemplate(in, encoding, expressionLanguage);
   }
}
