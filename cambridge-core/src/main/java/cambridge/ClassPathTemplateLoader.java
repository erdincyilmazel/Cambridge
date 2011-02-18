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
   public ClassPathTemplateLoader(Class c) {
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
   public TemplateFactory newTemplateFactory(String template) throws TemplateLoadingException {
      InputStream in = classLoader.getResourceAsStream(template);
      TemplateDocument doc = parseTemplate(in);
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
   public TemplateFactory newTemplateFactory(String template, String encoding) throws TemplateLoadingException {
      InputStream in = classLoader.getResourceAsStream(template);
      TemplateDocument doc = parseTemplate(in, encoding);
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
   public TemplateFactory newTemplateFactory(String template, TemplateModifier modifier) throws TemplateLoadingException {
      InputStream in = classLoader.getResourceAsStream(template);
      TemplateDocument doc = parseTemplate(in);
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
   public TemplateFactory newTemplateFactory(String template, String encoding, TemplateModifier modifier) throws TemplateLoadingException {
      InputStream in = classLoader.getResourceAsStream(template);
      TemplateDocument doc = parseTemplate(in, encoding);
      modifier.modifyTemplate(doc);
      try {
         FragmentList fragments = doc.normalize();
         return new ImmutableTemplateFactory(this, fragments);
      } catch (BehaviorInstantiationException e) {
         throw new TemplateLoadingException(e);
      }
   }


   public TemplateDocument parseTemplate(String template) throws TemplateLoadingException {
      InputStream in = classLoader.getResourceAsStream(template);
      return parseTemplate(in);
   }

   public TemplateDocument parseTemplate(String template, String encoding) throws TemplateLoadingException {
      InputStream in = classLoader.getResourceAsStream(template);
      return parseTemplate(in, encoding);
   }
}
