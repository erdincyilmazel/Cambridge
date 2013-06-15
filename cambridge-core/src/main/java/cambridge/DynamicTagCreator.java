package cambridge;

import cambridge.model.TagNode;
import cambridge.model.TemplateDocument;
import cambridge.model.TemplateNode;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * This is a utility class that can be used to create a DynamicTag instance after parsing a template file
 * which contains only one root tag. This class is to be used by tag library authors only.
 *
 * See FormTag class in components module as an example usage of this utility.
 *
 * Lets say in your template file, whenever you use <pre>&lt;c:loginBox/&gt;</pre> you want the template engine to render
 * a different html. If you have a {@link DynamicTag} implementation class LoginBox, in that class, you can
 * use DynamicTagCreator to parse the login box template, and create an instance of LoginBox for you.
 * Every html element defined in your loginBox template, becomes an inner element of the LoginBox tag
 * instance that gets generated for you.
 */
public class DynamicTagCreator {
   private final FileTemplateLoader loader;

   public DynamicTagCreator() {
      loader = new FileTemplateLoader();
   }

   /**
    * Parses the template reading from the provided input stream and generates an instance of the TagNode
    * class that gets passed in. The html elements defined in the template file becomes inner elements
    * of the created TagNode. It then returns the TagNode object that gets created.
    *
    * @param in InputStream to read the template from.
    * @param cl The TagNode implementation class.
    * @return Returns the newly created tag node object which contains the template contents.
    * @throws TemplateLoadingException Might be thrown if there is a problem in parsing the provided template.
    */
   public <T extends TagNode> T createTag(InputStream in, Class<T> cl, ExpressionLanguage expressionLanguage) throws TemplateLoadingException {
      TemplateDocument doc = loader.parseTemplate(in, expressionLanguage);
      ArrayList<TemplateNode> nodes = doc.getChildren();

      try {
         T tag = cl.newInstance();
         tag.addChildren(nodes);
         return tag;
      } catch (InstantiationException e) {
         e.printStackTrace();
      } catch (IllegalAccessException e) {
         e.printStackTrace();
      }

      return null;
   }

   /**
    * Parses the template reading from the provided template file and generates an instance of the TagNode
    * class that gets passed in. The html elements defined in the template file becomes inner elements
    * of the created TagNode. It then returns the TagNode object that gets created.
    *
    * @param tagTemplate Template file
    * @param cl The TagNode implementation class.
    * @return Returns the newly created tag node object which contains the template contents.
    * @throws TemplateLoadingException Might be thrown if there is a problem in parsing the provided template.
    */
   public <T extends TagNode> T createTag(File tagTemplate, Class<T> cl, ExpressionLanguage expressionLanguage) throws TemplateLoadingException {
      TemplateDocument doc = loader.parseTemplate(tagTemplate, expressionLanguage);
      ArrayList<TemplateNode> nodes = doc.getChildren();

      try {
         T tag = cl.newInstance();
         tag.addChildren(nodes);
         return tag;
      } catch (InstantiationException e) {
         e.printStackTrace();
      } catch (IllegalAccessException e) {
         e.printStackTrace();
      }

      return null;
   }
}
