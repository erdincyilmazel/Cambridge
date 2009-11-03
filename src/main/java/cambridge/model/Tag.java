package cambridge.model;

import cambridge.ExpressionParsingException;
import cambridge.TagBehavior;

/**
 * User: erdinc
 * Date: Nov 3, 2009
 * Time: 1:23:53 AM
 */
public interface Tag extends ParentNode {
   public void setParent(ParentNode parent);

   public ParentNode getParent();

   public TemplateNode getPreviousSibling();

   public TemplateNode getNextSibling();

   public int getBeginLine();

   public int getBeginColumn();

   public int getEndLine();

   public int getEndColumn();

   public abstract boolean isDynamic();

   public abstract Tag getElementById(String id);

   public Tag addCondition(String expression) throws ExpressionParsingException;

   public Tag setExpression(String expression) throws ExpressionParsingException;

   public Tag iterateOver(String expression) throws ExpressionParsingException;

   public Tag addAttribute(Attribute a);

   public Tag addBehavior(TagBehavior behavior);
}
