package cambridge.model;

import cambridge.BehaviorInstantiationException;
import cambridge.ExpressionLanguage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * User: eyilmazel
 * Date: Aug 17, 2008
 * Time: 5:00:35 PM
 */

/**
 * TemplateModel is a tree of TempleteNodes
 * <p/>
 * A TemplateNode is a node in a Template file which can contain
 * other nodes.
 */
public class TemplateDocument implements ParentNode
{
    private final ExpressionLanguage expressionLanguage;
    private final ArrayList<TemplateNode> children;
    private HashSet<String> includes;

    public void addInclude(String include)
    {
        if (includes == null)
        {
            includes = new HashSet<String>();
        }

        includes.add(include);
    }

    public HashSet<String> getIncludes()
    {
        return includes;
    }

    public TemplateDocument(ExpressionLanguage expressionLanguage)
    {
        this.children = new ArrayList<TemplateNode>();
        this.expressionLanguage = expressionLanguage;
    }

    public ExpressionLanguage getExpressionLanguage()
    {
        return expressionLanguage;
    }

    public void removeChild(TemplateNode node)
    {
        children.remove(node);
    }

    public void replaceChild(TemplateNode search, TemplateNode replace)
    {
        int index = children.indexOf(search);
        if (index != -1)
        {
            children.set(index, replace);
        }
    }

    public void removeAllChildren()
    {
        children.clear();
    }

    public void insertChild(int index, TemplateNode node)
    {
        node.setParent(this);
        children.add(index, node);
    }

    public void addChild(TemplateNode node)
    {
        node.setParent(this);
        children.add(node);
    }

    public void setText(String text)
    {
        children.clear();
        children.add(new TextNode(text));
    }

    public void addChildren(List<TemplateNode> nodes)
    {
        for (TemplateNode n : nodes)
        {
            n.setParent(this);
            children.add(n);
        }
    }

    public ArrayList<TemplateNode> getChildren()
    {
        return children;
    }

    public boolean hasChildren()
    {
        return children != null && children.size() != 0;
    }

    public Tag getElementById(String id)
    {
        for (TemplateNode t : children)
        {
            Tag n = t.getElementById(id);
            if (n != null)
            {
                return n;
            }
        }

        return null;
    }

    public ArrayList<Tag> getElementsByTagName(String tagName)
    {
        ArrayList<Tag> tags = new ArrayList<Tag>();

        for (TemplateNode t : children)
        {
            t.addElementsbyTagName(tagName, tags);
        }

        return tags;
    }

    public ArrayList<Tag> getChildrenByTagName(String tagName)
    {
        ArrayList<Tag> tags = new ArrayList<Tag>();
        for (TemplateNode t : children)
        {
            if ((t instanceof Tag) && tagName.equals(((Tag) t).getTagName()))
            {
                tags.add((Tag) t);
            }
        }

        return tags;
    }

    public Tag getTag(String tagName, int index)
    {
        Tag tag = null;
        int j = 0;
        for (TemplateNode t : children)
        {
            if ((t instanceof Tag) && tagName.equals(((Tag) t).getTagName()))
            {
                if (j == index)
                {
                    return (Tag) t;
                }
                else
                {
                    tag = (Tag) t;
                    j++;
                }
            }
        }

        if (index == -1)
        {
            return tag;
        }

        return null;
    }

    public Tag getFirstTag(String tagName)
    {
        return getTag(tagName, 0);
    }

    public Tag getLastTag(String tagName)
    {
        return getTag(tagName, -1);
    }

    public TemplateNode getPreviousChild(TemplateNode node)
    {
        if (children == null)
        {
            return null;
        }
        int i = children.indexOf(node);
        if (i > 0)
        {
            return children.get(i - 1);
        }
        return null;
    }

    public TemplateNode getNextChild(TemplateNode node)
    {
        if (children == null)
        {
            return null;
        }
        int i = children.indexOf(node);
        if (i + 1 < children.size())
        {
            return children.get(i + 1);
        }
        return null;
    }

    public FragmentList normalize() throws BehaviorInstantiationException
    {
        FragmentList list = new FragmentList(expressionLanguage);
        if (children.size() > 0 && children.get(0) instanceof ExtendsDirective)
        {
            ((ExtendsDirective) children.get(0)).extend(this, list, true);
        }
        else
        {
            for (TemplateNode t : children)
            {
                t.normalize(this, list);
            }
        }
        list.pack();
        return list;
    }

    public FragmentList normalizeUntil(TemplateNode n, boolean inclusive) throws BehaviorInstantiationException
    {
        FragmentList list = new FragmentList(expressionLanguage);
        for (TemplateNode t : children)
        {
            if (t.normalizeUntil(this, n, list, inclusive))
            {
                break;
            }
        }
        list.pack();
        return list;
    }

    public static final Pattern selectorPattern = Pattern.compile("(before|after|until|from|except|inside)?\\s*(((/|#)([^/#\\s]+)(\\[\\d+\\])?)+)$");
    private static final Pattern indexPattern = Pattern.compile("([^/#\\s]+)\\[(\\d+)\\]");

    public TagNode locateTag(String selector)
    {
        StringTokenizer tokenizer = new StringTokenizer(selector, "/#", true);

        boolean idSearch = "#".equals(tokenizer.nextToken());
        String search = tokenizer.nextToken();
        Tag tag;

        if (idSearch)
        {
            tag = getElementById(search);
        }
        else
        {
            Matcher m = indexPattern.matcher(search);
            if (m.find())
            {
                tag = getTag(m.group(1), Integer.parseInt(m.group(2)));
            }
            else
            {
                tag = getFirstTag(search);
            }
        }

        if (tag == null)
        {
            return null;
        }

        while (tokenizer.hasMoreElements())
        {
            idSearch = "#".equals(tokenizer.nextToken());
            search = tokenizer.nextToken();

            if (tag == null)
            {
                return null;
            }

            if (idSearch)
            {
                tag = tag.getElementById(search);
            }
            else
            {
                Matcher m = indexPattern.matcher(search);
                if (m.find())
                {
                    tag = tag.get(m.group(1), Integer.parseInt(m.group(2)));
                }
                else
                {
                    tag = tag.getFirst(search);
                }
            }
        }

        return (TagNode) tag;
    }

    public enum Selector
    {
        Default(""),
        Before("before"),
        Until("until"),
        After("after"),
        From("from"),
        Except("except"),
        Inside("inside");

        final String s;

        Selector(String s)
        {
            this.s = s;
        }

        public static Selector get(String s)
        {
            if (s == null)
            {
                return Default;
            }
            for (Selector selector : values())
            {
                if (s.equalsIgnoreCase(selector.s))
                {
                    return selector;
                }
            }

            return Default;
        }
    }

    public FragmentList select(Selector selector, TemplateNode node) throws BehaviorInstantiationException
    {
        if (node == null)
        {
            return new FragmentList(expressionLanguage);
        }

        switch (selector)
        {
            case After:
                FragmentList ret = new FragmentList(expressionLanguage);

                while (true)
                {
                    ParentNode parent = node.getParent();
                    if (parent == null)
                    {
                        break;
                    }
                    boolean found = false;
                    for (TemplateNode n : parent.getChildren())
                    {
                        if (found)
                        {
                            n.normalize(this, ret);
                        }

                        if (n == node)
                        {
                            found = true;
                        }
                    }

                    if (parent instanceof TagNode)
                    {
                        ret.append(((TagNode) parent).getCloseText());
                        node = (TagNode) parent;
                    }
                    else
                    {
                        break;
                    }
                }

                ret.pack();
                return ret;
            case From:
                ret = new FragmentList(expressionLanguage);
                node.normalize(this, ret);
                while (true)
                {
                    ParentNode parent = node.getParent();
                    if (parent == null)
                    {
                        break;
                    }
                    boolean found = false;
                    for (TemplateNode n : parent.getChildren())
                    {
                        if (found)
                        {
                            n.normalize(this, ret);
                        }

                        if (n == node)
                        {
                            found = true;
                        }
                    }

                    if (parent instanceof TagNode)
                    {
                        ret.append(((TagNode) parent).getCloseText());
                        node = (TagNode) parent;
                    }
                    else
                    {
                        break;
                    }
                }

                ret.pack();
                return ret;
            case Before:
                return normalizeUntil(node, false);
            case Until:
                return normalizeUntil(node, true);
            case Default:
                ret = new FragmentList(expressionLanguage);
                node.normalize(this, ret);
                ret.pack();
                return ret;
            case Except:
                ret = new FragmentList(expressionLanguage);
                FragmentList before = normalizeUntil(node, false);
                ret.addAll(before);

                while (true)
                {
                    ParentNode parent = node.getParent();
                    if (parent == null)
                    {
                        break;
                    }
                    boolean found = false;
                    for (TemplateNode n : parent.getChildren())
                    {
                        if (found)
                        {
                            n.normalize(this, ret);
                        }

                        if (n == node)
                        {
                            found = true;
                        }
                    }

                    if (parent instanceof TagNode)
                    {
                        ret.append(((TagNode) parent).getCloseText());
                        node = (TagNode) parent;
                    }
                    else
                    {
                        break;
                    }
                }

                ret.pack();
                return ret;
            case Inside:
                ret = new FragmentList(expressionLanguage);
                if (node instanceof ParentNode)
                {
                    for (TemplateNode t : ((ParentNode) node).getChildren())
                    {
                        t.normalize(this, ret);
                    }
                }
                ret.pack();
                return ret;
        }

        return new FragmentList(expressionLanguage);
    }

    public FragmentList select(String query) throws SelectorParsingException, BehaviorInstantiationException
    {
        Matcher matcher = selectorPattern.matcher(query);
        if (!matcher.find())
        {
            throw new SelectorParsingException("Could not parse the selector query: " + query);
        }

        String q = matcher.group(2);

        Selector selector = Selector.get(matcher.group(1));

        TemplateNode node = locateTag(q);

        return select(selector, node);
    }
}
