package cambridge.model;

import cambridge.BehaviorInstantiationException;
import cambridge.Cambridge;
import cambridge.ConditionalTagBehavior;
import cambridge.DynamicAttributeKey;
import cambridge.ExpressionEvaluationException;
import cambridge.ExpressionParsingException;
import cambridge.LoopingTagBehavior;
import cambridge.ModifyingTagBehavior;
import cambridge.StaticBehavior;
import cambridge.TagBehavior;
import cambridge.TemplateEvaluationException;
import cambridge.TemplateLoader;
import cambridge.TemplateLoadingException;
import cambridge.TemplateParsingException;
import cambridge.behaviors.ForeachBehavior;
import cambridge.behaviors.IfBehavior;
import cambridge.parser.expressions.Expressions;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * User: erdincyilmazel
 * Date: Aug 17, 2008
 * Time: 8:12:49 PM
 */
public class TagNode extends TemplateNode implements Fragment, Tag, ModifyableTag {
   private String indent = "";
   private String tagName;
   protected String nameSpace;

   private String closeText;
   private String tagEndText;

   private ArrayList<TemplateNode> children;
   private ArrayList<TagPart> tagParts;
   private HashMap<AttributeKey, Attribute> attributes;

   private String id;

   private FragmentList fragments;

   private static final Pattern indentPattern = Pattern.compile(".*(\n[ \t]*)$");

   private ArrayList<ModifyingTagBehavior> modifyingBehaviors;
   private ConditionalTagBehavior conditionalBehavior;
   private LoopingTagBehavior looping;

   private boolean dynamic;
   protected boolean hidden;
   private boolean indented = true;

   public TagNode() {
   }

   public String getTextContents() {
      if (children.size() >= 1) {
         TemplateNode n = children.get(0);
         if (n instanceof TextNode) {
            return ((TextNode) n).getContents();
         }
      }

      return "";
   }

   public void removeChild(TemplateNode node) {
      if (children != null) {
         children.remove(node);
      }
   }

   public void replaceChild(TemplateNode search, TemplateNode replace) {
      if (children == null) {
         return;
      }

      int index = children.indexOf(search);
      if (index != -1) {
         children.set(index, replace);
      }
   }

   public void removeAllChildren() {
      children = null;
   }

   public void removeChild(int index) {
      if (children != null) {
         children.remove(index);
      }
   }

   public void addInclude(TemplateLoader loader, String template, String selector) {
      IncludeNode node = null;
      try {
         node = new IncludeNode(loader, template, selector);
      } catch (BehaviorInstantiationException e) {
         throw new TemplateLoadingException("Could not include " + template, e);
      }
      addChild(node);
   }

   public void addInclude(TemplateLoader loader, String template) {
      addInclude(loader, template, null);
   }

   public void insertChild(TemplateNode node) {
      children.add(0, node);
   }

   public void insertChild(TemplateNode node, int index) {
      children.add(index, node);
   }

   public void addChild(TemplateNode node) {
      if (children == null) children = new ArrayList<TemplateNode>();
      node.setParent(this);
      children.add(node);
   }

   public void setText(String text) {
      if (children == null) {
         children = new ArrayList<TemplateNode>();
      } else {
         children.clear();
      }

      children.add(new TextNode(text));
   }

   public void addChildren(List<TemplateNode> nodes) {
      if (children == null) children = new ArrayList<TemplateNode>();
      for (TemplateNode n : nodes) {
         n.setParent(this);
         children.add(n);
      }
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

   public ArrayList<Tag> getElementsByTagName(String tagName) {
      ArrayList<Tag> list = new ArrayList<Tag>();
      if (children != null) {
         for (TemplateNode t : children) {
            t.addElementsbyTagName(tagName, list);
         }
      }

      return list;
   }

   public void addTagPart(TagPart e) {
      if (tagParts == null) tagParts = new ArrayList<TagPart>();
      tagParts.add(e);
   }

   public void setTagParts(ArrayList<TagPart> tagParts) {
      this.tagParts = tagParts;
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

      Cambridge bindings = Cambridge.getInstance();

      tagParts.add(a);

      if (a.isDynamic()) {
         DynamicAttributeKey attributeKey = new DynamicAttributeKey(a.getNamespaceUri(), a.getAttributeNameSpace(), a.getAttributeName());
         if (bindings.getStaticBehavior(attributeKey) == null) {
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

   public Attribute getDynamicAttribute(DynamicAttributeKey key) {
      for (Attribute a : attributes.values()) {
         if (a.getAttributeName().equals(key.getAttribute()) &&
            key.getUri().equals(a.getNamespaceUri())) {
            return a;
         }
      }

      return null;
   }

   public List<Attribute> getAttributes() {
      return null;
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

   public void setDynamic(Boolean dynamic) {
      this.dynamic = dynamic;
   }

   public boolean isDynamic() {
      return dynamic;
   }

   boolean normalizeUntil(TemplateDocument doc, TemplateNode reference, FragmentList f, boolean inclusive) throws BehaviorInstantiationException {
      if (reference == this) {
         if (inclusive) {
            normalize(doc, f);
         }
         return true;
      } else {
         if (attributes != null) {
            Cambridge bindings = Cambridge.getInstance();
            boolean remove = false;
            HashSet<AttributeKey> staticAttributes = new HashSet<AttributeKey>();

            for (Attribute a : attributes.values()) {
               if (a.isDynamic()) {
                  DynamicAttributeKey key = new DynamicAttributeKey(a.getNamespaceUri(), a.getAttributeNameSpace(), a.getAttributeName());
                  StaticBehavior sb = bindings.getStaticBehavior(key);
                  if (sb != null) {
                     sb.modify(doc, a.getValue(), this);
                     staticAttributes.add(new AttributeKey(a.getAttributeNameSpace(), a.getAttributeName()));
                     if (sb.shouldRemove()) {
                        remove = true;
                     }
                  }
               }
            }

            for (AttributeKey key : staticAttributes) {
               attributes.remove(key);
            }

            if (remove) {
               return false;
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
                  if (t.normalizeUntil(doc, reference, fragments, inclusive)) {
                     fragments.pack();
                     f.addFragment(this);
                     return true;
                  }
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
                  if (t instanceof ExpressionTagPart) {
                     f.addFragment((ExpressionTagPart) t);
                  } else {
                     if (!t.isWhiteSpace()) {
                        if (!whiteSpace) {
                           f.append(" ");
                        }
                        whiteSpace = false;
                     } else {
                        whiteSpace = true;
                     }
                     if (t instanceof Attribute) {
                        if (t instanceof SimpleAttribute) {
                           f.append(t.getTextContent());
                        } else if (t instanceof ComplexAttribute) {
                           ComplexAttribute a = (ComplexAttribute) t;
                           if (a.attributeNameSpace != null) {
                              f.append(a.attributeNameSpace).append(":");
                           }

                           f.append(a.attributeName).append("=");
                           char q = a.getQuote();
                           if (q != 0) {
                              f.append("" + q);
                           }

                           for (AttributeFragment af : a.getFragments()) {
                              if (af instanceof StaticFragment) {
                                 f.append(((StaticFragment) af).contents.toString());
                              } else {
                                 f.addFragment(af);
                              }
                           }

                           if (q != 0) {
                              f.append("" + q);
                           }
                        }
                     } else {
                        f.append(t.getTextContent());
                     }
                  }
               }
            }

            f.append(tagEndText);

            if (children != null) {
               for (TemplateNode n : children) {
                  if (n.normalizeUntil(doc, reference, f, inclusive)) {
                     return true;
                  }
               }
            }

            if (closeText != null) {
               f.append(closeText);
            }
         }
         return false;
      }
   }

   @Override
   void normalize(TemplateDocument doc, FragmentList f) throws BehaviorInstantiationException {
      if (attributes != null) {
         Cambridge bindings = Cambridge.getInstance();
         boolean remove = false;
         HashSet<AttributeKey> staticAttributes = new HashSet<AttributeKey>();

         for (Attribute a : attributes.values()) {
            if (a.isDynamic()) {
               DynamicAttributeKey key = new DynamicAttributeKey(a.getNamespaceUri(), a.getAttributeNameSpace(), a.getAttributeName());
               StaticBehavior sb = bindings.getStaticBehavior(key);
               if (sb != null) {
                  sb.modify(doc, a.getValue(), this);
                  staticAttributes.add(new AttributeKey(a.getAttributeNameSpace(), a.getAttributeName()));
                  if (sb.shouldRemove()) {
                     remove = true;
                  }
               }
            }
         }

         for (AttributeKey key : staticAttributes) {
            attributes.remove(key);
         }

         if (remove) {
            return;
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
               t.normalize(doc, fragments);
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
               if (t instanceof ExpressionTagPart) {
                  f.addFragment((ExpressionTagPart) t);
               } else {
                  if (!t.isWhiteSpace()) {
                     if (!whiteSpace) {
                        f.append(" ");
                     }
                     whiteSpace = false;
                  } else {
                     whiteSpace = true;
                  }

                  if (t instanceof Attribute) {
                     if (t instanceof SimpleAttribute) {
                        f.append(t.getTextContent());
                     } else if (t instanceof ComplexAttribute) {
                        ComplexAttribute a = (ComplexAttribute) t;
                        if (a.attributeNameSpace != null) {
                           f.append(a.attributeNameSpace).append(":");
                        }

                        f.append(a.attributeName).append("=");
                        char q = a.getQuote();
                        if (q != 0) {
                           f.append("" + q);
                        }

                        for (AttributeFragment af : a.getFragments()) {
                           if (af instanceof StaticFragment) {
                              f.append(((StaticFragment) af).contents.toString());
                           } else {
                              f.addFragment(af);
                           }
                        }

                        if (q != 0) {
                           f.append("" + q);
                        }
                     }
                  } else {
                     f.append(t.getTextContent());
                  }
               }
            }
         }

         f.append(tagEndText);

         if (children != null) {
            for (TemplateNode n : children) {
               n.normalize(doc, f);
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

      if (children != null) {
         for (TemplateNode t : children) {
            Tag n = t.getElementById(id);
            if (n != null) {
               return n;
            }
         }
      }
      return null;
   }

   public Tag addCondition(String expression) throws ExpressionParsingException {
      addBehavior(new IfBehavior(Expressions.parse(expression)));
      return this;
   }

   public Tag addExpression(String expression) throws ExpressionParsingException {
      addChild(new ExpressionNode(expression));
      return this;
   }

   public Tag iterateOver(String expression) throws ExpressionParsingException {
      addBehavior(new ForeachBehavior(Expressions.parse(expression)));
      return this;
   }

   public String toString() {
      return "<" + (nameSpace == null ? tagName : nameSpace + ":" + tagName) + "> @ " + getBeginLine() + ":" + getBeginColumn() + " - " + getEndLine() + ":" + getEndColumn();
   }

   @SuppressWarnings("unchecked")
   public void eval(Map<String, Object> bindings, Writer out) throws IOException, TemplateEvaluationException {
      try {
         if (!isDynamic()) {
            printFragments(bindings, out);
         } else {
            if (conditionsMet(bindings)) {
               if (looping == null) {
                  execute(bindings, out);
               } else {
                  looping.execute(bindings, this, out);
               }
            }
         }
      } catch (ExpressionEvaluationException e) {
         throw new TemplateEvaluationException("Could not execute the expression: " + e.getMessage(), getBeginLine(), getBeginColumn(), getTagName());
      }
   }

   public void pack() {
   }

   public ArrayList<TagPart> getTagParts() {
      return tagParts;
   }

   public String getIndent() {
      return indent;
   }

   public void setIndent(String indent) {
      this.indent = indent;
   }

   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public boolean isHidden() {
      return hidden;
   }

   public void setHidden(boolean hidden) {
      this.hidden = hidden;
   }

   public boolean isIndented() {
      return indented;
   }

   public void setIndented(boolean indented) {
      this.indented = indented;
   }

   class ModifyableCopy implements ModifyableTag {
      ArrayList<TagPart> tagParts;
      FragmentList fragments;

      ModifyableCopy(ArrayList<TagPart> tagParts, FragmentList fragments) {
         this.tagParts = tagParts;
         this.fragments = fragments;
      }

      public ArrayList<TagPart> getTagParts() {
         return tagParts;
      }

      public void setTagParts(ArrayList<TagPart> tagParts) {
         this.tagParts = tagParts;
      }

      public FragmentList getFragments() {
         return fragments;
      }

      public void setFragments(FragmentList fragments) {
         this.fragments = fragments;
      }
   }

   @SuppressWarnings("unchecked")
   public void execute(Map<String, Object> bindings, Writer out) throws IOException, TemplateEvaluationException {
      ModifyableTag tag;
      if (modifyingBehaviors != null) {
         tag = new ModifyableCopy(tagParts == null ? null : (ArrayList) tagParts.clone(), fragments == null ? null : (FragmentList) fragments.clone());

         for (ModifyingTagBehavior b : modifyingBehaviors) {
            try {
               b.modify(bindings, tag);
            } catch (ExpressionEvaluationException e) {
               throw new TemplateEvaluationException("Could not execute the expression: " + e.getMessage(), getBeginLine(), getBeginColumn(), getTagName());
            }
         }
      } else {
         tag = this;
      }

      if (indented) {
         out.write(indent);
      }

      if (!hidden) {
         out.write("<");
         if (nameSpace != null) {
            out.write(nameSpace);
            out.write(":");
         }
         out.write(tagName);
         if (tag.getTagParts() != null) {
            boolean whiteSpace = false;
            for (TagPart t : tag.getTagParts()) {
               if (t instanceof ExpressionTagPart) {
                  ((ExpressionTagPart) t).eval(bindings, out);
               } else {
                  if (!(t instanceof DynamicAttribute)) {
                     if (!t.isWhiteSpace()) {
                        if (!whiteSpace) {
                           out.write(" ");
                        }
                        whiteSpace = false;
                     } else {
                        whiteSpace = true;
                     }
                  }

                  if (t instanceof Attribute) {
                     if (t instanceof SimpleAttribute) {
                        out.write(t.getTextContent());
                     } else if (t instanceof ComplexAttribute) {
                        ComplexAttribute a = (ComplexAttribute) t;
                        if (a.attributeNameSpace != null) {
                           out.write(a.attributeNameSpace);
                           out.write(":");
                        }

                        out.write(a.attributeName);
                        out.write("=");
                        char q = a.getQuote();
                        if (q != 0) {
                           out.write("" + q);
                        }

                        for (AttributeFragment af : a.getFragments()) {
                           if (af instanceof StaticFragment) {
                              out.write(((StaticFragment) af).contents.toString());
                           } else if (af instanceof ExpressionNode) {
                              ExpressionNode ex = (ExpressionNode) af;
                              ex.eval(bindings, out);
                           }
                        }

                        if (q != 0) {
                           out.write("" + q);
                        }
                     }
                  } else {
                     out.write(t.getTextContent());
                  }
               }
            }
         }

         out.write(tagEndText);
      }

      if (tag.getFragments() != null) {
         for (Fragment f : tag.getFragments()) {
            f.eval(bindings, out);
         }
      }

      if (!hidden && closeText != null) {
         out.write(closeText);
      }
   }

   @Override
   void addElementsbyTagName(String tagName, ArrayList<Tag> tags) {
      if (tagName.equals(this.tagName)) {
         tags.add(this);
      }
      if (children != null) {
         for (TemplateNode t : children) {
            t.addElementsbyTagName(tagName, tags);
         }
      }
   }

   private boolean conditionsMet(Map<String, Object> bindings) throws ExpressionEvaluationException {
      return conditionalBehavior == null || conditionalBehavior.conditionMet(bindings);
   }

   private void assignBehaviors() throws BehaviorInstantiationException {
      Cambridge bindings = Cambridge.getInstance();
      if (attributes != null) {
         for (Attribute a : attributes.values()) {
            if (a.isDynamic()) {
               DynamicAttributeKey key = new DynamicAttributeKey(a.getNamespaceUri(), a.getAttributeNameSpace(), a.getAttributeName());
               TagBehavior behavior;
               try {
                  behavior = bindings.getBehavior(key, attributes);
               } catch (ExpressionParsingException e) {
                  throw new BehaviorInstantiationException("Error in parsing expression", e, getBeginLine(), getBeginColumn());
               }
               if (behavior != null) {
                  addBehavior(behavior);
               }
            }
         }
      }
   }

   public Tag addBehavior(TagBehavior behavior) {
      dynamic = true;
      if (behavior instanceof ConditionalTagBehavior) {
         if (conditionalBehavior != null) {
            throw new TemplateParsingException("Only one conditional behaviour be assigned to a tag. Tag: " + toString(), getBeginLine(), getBeginColumn());
         }
         conditionalBehavior = (ConditionalTagBehavior) behavior;
      } else if (behavior instanceof LoopingTagBehavior) {
         if (looping != null) {
            throw new TemplateParsingException("Only one looping behaviour be assigned to a tag. Tag: " + toString(), getBeginLine(), getBeginColumn());
         }
         looping = (LoopingTagBehavior) behavior;
      } else if (behavior instanceof ModifyingTagBehavior) {
         if (modifyingBehaviors == null) {
            modifyingBehaviors = new ArrayList<ModifyingTagBehavior>();
         }

         modifyingBehaviors.add((ModifyingTagBehavior) behavior);
      }

      return this;
   }

   public ConditionalTagBehavior getConditionalBehavior() {
      return conditionalBehavior;
   }

   public void removeConditionalBehavior() {
      conditionalBehavior = null;
   }

   public ArrayList<Tag> getChildrenByTagName(String tagName) {
      ArrayList<Tag> tags = new ArrayList<Tag>();
      for (TemplateNode t : children) {
         if ((t instanceof Tag) && tagName.equals(((Tag) t).getTagName())) {
            tags.add((Tag) t);
         }
      }

      return tags;
   }

   public Tag get(String tagName, int index) {
      if (children == null) {
         return null;
      }
      Tag tag = null;
      int j = 0;
      for (TemplateNode t : children) {
         if ((t instanceof Tag) && tagName.equals(((Tag) t).getTagName())) {
            if (j == index) {
               return (Tag) t;
            } else {
               tag = (Tag) t;
               j++;
            }
         }
      }

      if (index == -1) {
         return tag;
      }

      return null;
   }

   public Tag getFirst(String tagName) {
      return get(tagName, 0);
   }

   public Tag getLast(String tagName) {
      return get(tagName, -1);
   }

   private void printFragments(Map<String, Object> bindings, Writer out) throws IOException, TemplateEvaluationException {
      if (fragments != null) {
         for (Fragment f : fragments) {
            f.eval(bindings, out);
         }
      }
   }

   public FragmentList getFragments() {
      return fragments;
   }

   public void setFragments(FragmentList fragments) {
      this.fragments = fragments;
   }
}
