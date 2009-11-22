package cambridge;

import cambridge.model.TemplateDocument;
import cambridge.model.TemplateNode;
import cambridge.model.TagNode;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * User: erdinc
 * Date: Nov 11, 2009
 * Time: 1:43:02 PM
 */
public class DynamicTagCreator {
   FileTemplateLoader loader;

   public DynamicTagCreator() {
      loader = new FileTemplateLoader();
   }

   public <T extends TagNode> T createTag(InputStream in, Class<T> cl) throws TemplateLoadingException {
      TemplateDocument doc = loader.parseTemplate(in);
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

   public <T extends TagNode> T createTag(File tagTemplate, Class<T> cl) throws TemplateLoadingException {
      TemplateDocument doc = loader.parseTemplate(tagTemplate);
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
