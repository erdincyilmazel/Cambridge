package cambridge.parser.model;

import cambridge.*;
import org.antlr.runtime.RecognitionException;

import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: erdincyilmazel
 * Date: Aug 17, 2008
 * Time: 8:12:49 PM
 */
public class Tag extends TemplateNode implements ParentNode, Fragment {
   String tagName;
   String nameSpace;

   String closeText;
   String tagEndText;

   ArrayList<TemplateNode> children;
   ArrayList<TagPart> tagParts;
   HashMap<AttributeKey, Attribute> attributes;

   String id;

   public Tag() {
   }

   public String getTextContent() {
      if (children.size() >= 1) {
         TemplateNode n = children.get(0);
         if (n instanceof TextNode) {
            return n.getSource();
         }
      }

      return "";
   }

   public void addChild(TemplateNode node) {
      if (children == null) children = new ArrayList<TemplateNode>();
      children.add(node);
   }

   public void addChildren(List<TemplateNode> nodes) {
      if (children == null) children = new ArrayList<TemplateNode>();
      children.addAll(nodes);
   }

   public ArrayList<TemplateNode> getChildren() {
      return children;
   }

   public boolean hasChildren() {
      return children != null;
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

   ArrayList<ModifyingTagBehavior> modifyingBehaviors;
   ArrayList<ConditionalTagBehavior> conditionalBehaviors;
   IterativeTagBehavior iterative;

   private void addTagPart(TagPart e) {
      if (tagParts == null) tagParts = new ArrayList<TagPart>();
      tagParts.add(e);
   }

   public void addText(TextTagPart t) {
      addTagPart(t);
   }

   public void addExpression(ExpressionTagPart e) {
      addTagPart(e);
   }

   public void addAttribute(Attribute a) throws BehaviorInstantiationException, RecognitionException {
      if (attributes == null) {
         attributes = new HashMap<AttributeKey, Attribute>();
      }

      AttributeKey key = new AttributeKey(a.getAttributeNameSpace(), a.getAttributeName());

      attributes.put(key, a);

      if ("id".equals(a.getAttributeName())) {
         id = a.getValue();
      }

      if (!a.isDynamic()) {
         tagParts.add((SimpleAttribute) a);
      } else {
         dynamic = true;
      }
   }

   public void removeTagPart(int e) {
      if (tagParts != null)
         tagParts.remove(e);
   }

   public String getCloseText() {
      return closeText;
   }

   public void setCloseText(String closeText) {
      this.closeText = closeText;
   }

   public String getTagName() {
      return tagName;
   }

   public void setTagName(String tagName) {
      this.tagName = tagName;
   }

   public String getNameSpace() {
      return nameSpace;
   }

   public void setNameSpace(String nameSpace) {
      this.nameSpace = nameSpace;
   }

   public String tagNameString;

   public void setTagNameString(String tn) {
      tagNameString = tn;
   }

   public String getTagNameString() {
      return tagNameString;
   }

   public String getTagEndText() {
      return tagEndText;
   }

   public void setTagEndText(String tagEndText) {
      this.tagEndText = tagEndText;
   }

   public String getSource() {
      StringBuilder builder = new StringBuilder();
      builder.append("<").append(tagName);

      if (tagParts != null) {
         builder.append(" ");
         for (TagPart t : tagParts) {
            builder.append(t.getTextContent());
         }
      }

      builder.append(tagEndText);

      if (children != null) {
         for (TemplateNode n : children) {
            builder.append(n.getSource());
         }
      }

      if (closeText != null) builder.append(closeText);
      return builder.toString();
   }

   public void print(PrintStream out) throws IOException {
      out.print("<");
      out.print(tagName);


      if (tagParts != null) {
         for (TagPart t : tagParts) {
            out.print(t.getTextContent());
         }
      }

      out.print(tagEndText);


      if (children != null) {
         for (TemplateNode n : children) {
            n.print(out);
         }
      }

      if (closeText != null) out.print(closeText);
   }

   Boolean dynamic;

   @Override
   public boolean isDynamic() {
      BehaviorBindings bindings = BehaviorBindings.getInstance();

      if (dynamic != null) {
         return dynamic;
      }

      if (nameSpace != null && bindings.isRegisteredNamespace(nameSpace)) {
         dynamic = true;
         return true;
      }

      return false;
   }

   private FragmentList fragments;

   @Override
   public void normalize(FragmentList f) throws RecognitionException, BehaviorInstantiationException {
      if (isDynamic()) {
         if (children == null) {
            f.addFragment(this);
         } else {
            fragments = new FragmentList();
            for (TemplateNode t : children) {
               t.normalize(fragments);
            }

            fragments.pack();

            f.addFragment(this);
         }

         assignBehaviors();
      } else {
         f.append("<").append(tagName);

         if (tagParts != null) {
            f.append(" ");
            for (TagPart t : tagParts) {
               f.append(t.getTextContent());
            }
         }

         f.append(tagEndText);

         if (children != null) {
            for (TemplateNode n : children) {
               n.normalize(f);
            }
         }

         if (closeText != null) {
            f.append(closeText);
         }
      }
   }

   @Override
   public Tag getElementById(String id) {
      if (this.id != null && this.id.equals(id)) {
         return this;
      }

      for (TemplateNode t : children) {
         Tag n = t.getElementById(id);
         if (n != null) {
            return n;
         }
      }
      return null;
   }

   public String toString() {
      return getBeginLine() + ":" + getBeginColumn() + " - " + getEndLine() + ":" + getEndColumn() + " - " + (nameSpace == null ? tagName : nameSpace + ":" + tagName);
   }

   @Override
   public void eval(Map<String, Object> properties, Appendable out) throws IOException, ExpressionEvaluationException {
      if (!isDynamic()) {
         printFragments(properties, out);
      } else {
         if (conditionsMet(properties)) {
            

            if (iterative == null) {
               dumpTag(properties, out);
            } else {
               iterative.iterate(properties, this, out);
            }
         }
      }
   }

   private boolean conditionsMet(Map<String, Object> properties) throws ExpressionEvaluationException {
      if(conditionalBehaviors == null) return true;
      for(ConditionalTagBehavior b : conditionalBehaviors) {
         if(!b.conditionMet(properties)) {
            return false;
         }
      }

      return true;
   }

   private void assignBehaviors() throws RecognitionException, BehaviorInstantiationException {
      BehaviorBindings bindings = BehaviorBindings.getInstance();
      for (AttributeKey key : attributes.keySet()) {
         TagBehavior behavior = bindings.getBehavior(key, attributes);
         if (behavior != null) {
            if (behavior instanceof ConditionalTagBehavior) {
               if(conditionalBehaviors == null) {
                  conditionalBehaviors = new ArrayList<ConditionalTagBehavior>();
               }

               conditionalBehaviors.add((ConditionalTagBehavior) behavior);
            }
            else if (behavior instanceof IterativeTagBehavior) {
               iterative = (IterativeTagBehavior) behavior;
            }
            else if (behavior instanceof ModifyingTagBehavior) {
               if (modifyingBehaviors == null) {
                  modifyingBehaviors = new ArrayList<ModifyingTagBehavior>();
               }

               modifyingBehaviors.add((ModifyingTagBehavior) behavior);
            }
         }
      }
   }

   public void dumpTag(Map<String, Object> properties, Appendable out) throws IOException, ExpressionEvaluationException {
      out.append("<").append(tagName);
      if (tagParts != null) {
         for (TagPart t : tagParts) {
            out.append(" ");
            out.append(t.getTextContent());
         }
      }

      out.append(tagEndText);

      printFragments(properties, out);

      if (closeText != null) {
         out.append(closeText);
      }
   }

   private void printFragments(Map<String, Object> properties, Appendable out) throws IOException, ExpressionEvaluationException {
      for (Fragment f : fragments) {
         f.eval(properties, out);
      }
   }

   public ArrayList<TagPart> getTagParts() {
      return tagParts;
   }

   public FragmentList getFragments() {
      return fragments;
   }
}
