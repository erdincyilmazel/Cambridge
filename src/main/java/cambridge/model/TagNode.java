package cambridge.model;

import cambridge.*;
import cambridge.parser.expressions.Expressions;
import cambridge.behaviors.IfBehavior;
import cambridge.behaviors.ForeachBehavior;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * User: erdincyilmazel
 * Date: Aug 17, 2008
 * Time: 8:12:49 PM
 */
public class TagNode extends TemplateNode implements Fragment, Tag {
   String indent = "";
   String tagName;
   String nameSpace;

   String closeText;
   String tagEndText;

   ArrayList<TemplateNode> children;
   ArrayList<TagPart> tagParts;
   HashMap<AttributeKey, Attribute> attributes;

   String id;

   private FragmentList fragments;

   static Pattern indentPattern = Pattern.compile(".*(\n[ \t]*)$");

   ArrayList<ModifyingTagBehavior> modifyingBehaviors;
   ArrayList<ConditionalTagBehavior> conditionalBehaviors;
   IterativeTagBehavior iterative;

   Boolean dynamic;

   public TagNode() {
   }

   public String getTextContent() {
      if (children.size() >= 1) {
         TemplateNode n = children.get(0);
         if (n instanceof TextNode) {
            return ((TextNode) n).getContents();
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

   @Override
   public ArrayList<Tag> getElementsByTagName(String tagName) {
      ArrayList<Tag> list = new ArrayList<Tag>();
      for (TemplateNode t : children) {
         t.addElementsbyTagName(tagName, list);
      }

      return list;
   }

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

   public Tag addAttribute(Attribute a) {
      if (attributes == null) {
         attributes = new HashMap<AttributeKey, Attribute>();
      }

      AttributeKey key = new AttributeKey(a.getAttributeNameSpace(), a.getAttributeName());

      attributes.put(key, a);

      if ("id".equals(a.getAttributeName())) {
         id = a.getValue();
      }

      BehaviorBindings bindings = BehaviorBindings.getInstance();

      if (!a.isDynamic()) {
         tagParts.add((SimpleAttribute) a);
      } else {
         if (bindings.getStaticBehavior(key) == null) {
            dynamic = true;
         }
      }

      return this;
   }

   public boolean hasAttribute(String namespace, String attributeName) {
      AttributeKey key = new AttributeKey(namespace, attributeName);
      return attributes.containsKey(key);
   }

   public Attribute getAttribute(String namespace, String attributeName) {
      return attributes.get(new AttributeKey(namespace, attributeName));
   }

   public boolean hasAttribute(String attributeName) {
      AttributeKey key = new AttributeKey(null, attributeName);
      return attributes.containsKey(key);
   }

   public Attribute getAttribute(String attributeName) {
      return attributes.get(new AttributeKey(null, attributeName));
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

   @Override
   public void normalize(FragmentList f) throws TemplateParsingException, BehaviorInstantiationException {
      if (attributes != null) {
         BehaviorBindings bindings = BehaviorBindings.getInstance();
         for (AttributeKey key : attributes.keySet()) {
            StaticBehavior sb = bindings.getStaticBehavior(key);
            if (sb != null) {
               sb.modify(this);
            }
         }
      }

      if (isDynamic()) {
         assignBehaviors();

         if (f.current instanceof StaticFragment) {
            StaticFragment st = (StaticFragment) f.current;
            Matcher matcher = indentPattern.matcher(st.contents);
            if (matcher.find()) {
               indent = matcher.group(1);
               int length = st.contents.length();
               st.contents.delete(length - indent.length(), length);
            }
         }

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
      } else {
         f.append("<");
         if (nameSpace != null) {
            f.append(nameSpace).append(":");
         }
         f.append(tagName);

         if (tagParts != null) {
            boolean whiteSpace = false;
            for (TagPart t : tagParts) {
               if (!t.isWhiteSpace()) {
                  if (!whiteSpace) {
                     f.append(" ");
                  }
                  whiteSpace = false;
               } else {
                  whiteSpace = true;
               }
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

   @Override
   public Tag addCondition(String expression) throws ExpressionParsingException {
      addBehavior(new IfBehavior(Expressions.parse(expression)));
      return this;
   }

   @Override
   public Tag setExpression(String expression) throws ExpressionParsingException {
      addChild(new ExpressionNode(expression));
      return this;
   }

   @Override
   public Tag iterateOver(String expression) throws ExpressionParsingException {
      addBehavior(new ForeachBehavior(Expressions.parse(expression)));
      return this;
   }

   public String toString() {
      return getBeginLine() + ":" + getBeginColumn() + " - " + getEndLine() + ":" + getEndColumn() + " - " + (nameSpace == null ? tagName : nameSpace + ":" + tagName);
   }

   @Override
   public void eval(Map<String, Object> properties, Appendable out) throws IOException, TemplateRuntimeException {
      try {
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
      } catch (ExpressionEvaluationException e) {
         throw new TemplateRuntimeException("Could not execute the expression: " + e.getMessage(), getBeginLine(), getBeginColumn(), getTagName());
      }
   }

   public ArrayList<TagPart> getTagParts() {
      return tagParts;
   }

   public void dumpTag(Map<String, Object> properties, Appendable out) throws IOException, TemplateRuntimeException {
      out.append(indent);
      out.append("<");
      if (nameSpace != null) {
         out.append(nameSpace).append(":");
      }
      out.append(tagName);
      if (tagParts != null) {
         boolean whiteSpace = false;
         for (TagPart t : tagParts) {
            if (!t.isWhiteSpace()) {
               if (!whiteSpace) {
                  out.append(" ");
               }
               whiteSpace = false;
            } else {
               whiteSpace = true;
            }
            out.append(t.getTextContent());
         }
      }

      out.append(tagEndText);

      printFragments(properties, out);

      if (closeText != null) {
         out.append(closeText);
      }
   }

   @Override
   void addElementsbyTagName(String tagName, ArrayList<Tag> tags) {
      if (tagName.equals(this.tagName)) {
         tags.add(this);
      }

      for (TemplateNode t : children) {
         t.addElementsbyTagName(tagName, tags);
      }
   }

   private boolean conditionsMet(Map<String, Object> properties) throws ExpressionEvaluationException {
      if (conditionalBehaviors == null) return true;
      for (ConditionalTagBehavior b : conditionalBehaviors) {
         if (!b.conditionMet(properties)) {
            return false;
         }
      }

      return true;
   }

   private void assignBehaviors() throws TemplateParsingException, BehaviorInstantiationException {
      BehaviorBindings bindings = BehaviorBindings.getInstance();
      for (AttributeKey key : attributes.keySet()) {
         TagBehavior behavior;
         try {
            behavior = bindings.getBehavior(key, attributes);
         } catch (ExpressionParsingException e) {
            throw new TemplateParsingException("Error in parsing expression", e, getBeginLine(), getBeginColumn());
         }
         if (behavior != null) {
            addBehavior(behavior);
         }
      }
   }

   public Tag addBehavior(TagBehavior behavior) {
      if (behavior instanceof ConditionalTagBehavior) {
         if (conditionalBehaviors == null) {
            conditionalBehaviors = new ArrayList<ConditionalTagBehavior>();
         }

         conditionalBehaviors.add((ConditionalTagBehavior) behavior);
      } else if (behavior instanceof IterativeTagBehavior) {
         iterative = (IterativeTagBehavior) behavior;
      } else if (behavior instanceof ModifyingTagBehavior) {
         if (modifyingBehaviors == null) {
            modifyingBehaviors = new ArrayList<ModifyingTagBehavior>();
         }

         modifyingBehaviors.add((ModifyingTagBehavior) behavior);
      }

      return this;
   }

   private void printFragments(Map<String, Object> properties, Appendable out) throws IOException, TemplateRuntimeException {
      if (fragments != null) {
         for (Fragment f : fragments) {
            f.eval(properties, out);
         }
      }
   }
}
