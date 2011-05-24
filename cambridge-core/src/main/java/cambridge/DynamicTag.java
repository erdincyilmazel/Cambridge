package cambridge;

import cambridge.model.TagNode;

/**
 * If you want you write a custom tag that will be rendered with the custom
 * logic that you define, you should extend DynamicTag and override the TagNode
 * methods that you want.
 *
 * The dynamic tag implementation that you created needs to be registered with the
 * Cambridge singleton by invoking the bindTag method.
 *
 * This class is for advanced used only and should be only needed if you want to write a tag library.
 */
public abstract class DynamicTag extends TagNode {
   /**
    * This method gets called by the Cambridge Template parser for initialization.
    * When the parser locates the closing element for this tag, the init method gets invoked. So during initialization,
    * you can be sure that you can access all the attributes and inner elements of the tag.
    * @throws TemplateParsingException If the dynamic tag is missing some required attributes or has some other issues,
    * this exception can be thrown.
    */
   public void init() throws TemplateParsingException {
      // You don't have to implement this method if the implementation class doesn't need initialization.
   }
}
