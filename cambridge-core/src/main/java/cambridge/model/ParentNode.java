package cambridge.model;

import java.util.ArrayList;
import java.util.List;

/**
 * A parent node is a container of other nodes (TemplateNode)
 *
 * @see TemplateNode
 */
public interface ParentNode {
   /**
    * Adds a new child to this node
    *
    * @param node The node that will be added
    */
   public void addChild(TemplateNode node);

   public void setText(String text);

   public void addChildren(List<TemplateNode> nodes);

   public ArrayList<TemplateNode> getChildren();

   public boolean hasChildren();

   public TemplateNode getPreviousChild(TemplateNode node);

   public TemplateNode getNextChild(TemplateNode node);

   public ArrayList<Tag> getElementsByTagName(String tagName);

   public Tag getElementById(String id);

   public void removeChild(TemplateNode node);

   public void replaceChild(TemplateNode search, TemplateNode replace);

   public void removeAllChildren();
}
