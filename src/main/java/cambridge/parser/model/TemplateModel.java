package cambridge.parser.model;

import org.antlr.runtime.RecognitionException;

import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import cambridge.BehaviorInstantiationException;

/**
 * User: eyilmazel
 * Date: Aug 17, 2008
 * Time: 5:00:35 PM
 */

/**
 * TemplateModel is a list of TempleteNodes
 * <p/>
 * A TemplateNode is a node in a Template file which can contain
 * other nodes.
 */
public class TemplateModel implements ParentNode {
   ArrayList<TemplateNode> children;

   public TemplateModel() {
      children = new ArrayList<TemplateNode>();
   }

   public void addChild(TemplateNode node) {
      children.add(node);
   }

   public void addChildren(List<TemplateNode> nodes) {
      children.addAll(nodes);
   }

   public ArrayList<TemplateNode> getChildren() {
      return children;
   }

   public boolean hasChildren() {
      return children != null;
   }

   /**
    * Returns the original source of the template
    *
    * @return Source code of the template file
    */
   public String getSource() {
      StringBuilder builder = new StringBuilder();
      for (TemplateNode t : children) {
         builder.append(t.getSource());
      }

      return builder.toString();
   }

   public Tag getElementById(String id) {
      for (TemplateNode t : children) {
         Tag n = t.getElementById(id);
         if (n != null) {
            return n;
         }
      }

      return null;
   }

   /**
    * Writes the original source of the template to the supplied writer
    *
    * @param out Stream that will be used
    * @throws java.io.IOException Thrown in case of an io error
    */
   public void print(PrintStream out) throws IOException {
      for (TemplateNode t : children) {
         t.print(out);
      }
   }

   public TemplateNode getPreviousChild(TemplateNode node) {
      if (children == null) return null;
      int i = children.indexOf(node);
      if (i > 0) {
         return children.get(i - 1);
      }
      return null;
   }

   public TemplateNode getNextChild(TemplateNode node) {
      if (children == null) return null;
      int i = children.indexOf(node);
      if (i + 1 < children.size()) {
         return children.get(i + 1);
      }
      return null;
   }

   public FragmentList normalize() throws RecognitionException, BehaviorInstantiationException {
      FragmentList list = new FragmentList();
      for (TemplateNode t : children) {
         t.normalize(list);
      }
      list.pack();
      return list;
   }
}
