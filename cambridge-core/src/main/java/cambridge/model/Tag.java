package cambridge.model;

import cambridge.DynamicAttributeKey;
import cambridge.ExpressionParsingException;
import cambridge.TagBehavior;

import java.util.ArrayList;

/**
 * @author Erdinc Yilmazel
 * Date: Nov 3, 2009
 * Time: 1:23:53 AM
 */
public interface Tag extends ParentNode {

   public ParentNode getParent();

   public TemplateNode getPreviousSibling();

   public TemplateNode getNextSibling();

   public int getBeginLine();

   public int getBeginColumn();

   public int getEndLine();

   public int getEndColumn();

   public String getTagName();

   public String getNameSpace();

   public String getTextContents();

   public abstract boolean isDynamic();

   public abstract Tag getElementById(String id);

   /**
    * Associates an IfBehavior with the tag using the provided expression
    *
    * @param expression The expression to be evaluated
    * @return Returns the same Tag object
    * @throws ExpressionParsingException Thrown if the supplied expression can not be parsed
    */
   public Tag addCondition(Expression expression) throws ExpressionParsingException;

   /**
    * Appends an expression node as a child of the Tag
    *
    * @param expression The expression to be added
    * @return Returns the same Tag object
    * @throws ExpressionParsingException Thrown if the supplied expression can not be parsed
    */
   public Tag addExpression(Expression expression) throws ExpressionParsingException;

   /**
    * Associates an iterative behavior with the tag. The value that will be iterated
    * over should be the result of the expression that is passed
    *
    * @param expression The expression which will result a Collection object when evaluated
    * @return Returns the same Tag object
    * @throws ExpressionParsingException Thrown if the supplied expression can not be parsed
    */
   public Tag iterateOver(Expression expression, String as) throws ExpressionParsingException;

   public Tag addAttribute(Attribute a);

   public Tag addBehavior(TagBehavior behavior);

   public ArrayList<Tag> getChildrenByTagName(String tagName);

   public Tag get(String tagName, int index);

   public Tag getFirst(String tagName);

   public Tag getLast(String tagName);

   public boolean hasAttribute(String attribute);

   public Attribute getAttribute(String attribute);

   public Attribute getDynamicAttribute(DynamicAttributeKey key);
}
