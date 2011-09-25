package cambridge.parser;

import cambridge.BehaviorInstantiationException;
import cambridge.Cambridge;
import cambridge.DynamicAttributeKey;
import cambridge.DynamicTag;
import cambridge.ExpressionLanguage;
import cambridge.ExpressionParsingException;
import cambridge.Expressions;
import cambridge.TemplateLoader;
import cambridge.TemplateLoadingException;
import cambridge.TemplateParsingException;
import cambridge.model.Attribute;
import cambridge.model.AttributeFragment;
import cambridge.model.CommentNode;
import cambridge.model.ComplexAttribute;
import cambridge.model.DebugDirective;
import cambridge.model.DynamicAttribute;
import cambridge.model.Expression;
import cambridge.model.ExpressionLanguageDirective;
import cambridge.model.ExpressionNode;
import cambridge.model.ExpressionTagPart;
import cambridge.model.ExtendsDirective;
import cambridge.model.ExtensionNode;
import cambridge.model.ExtensionPoint;
import cambridge.model.IncludeNode;
import cambridge.model.NamespaceDirective;
import cambridge.model.SetDirective;
import cambridge.model.SimpleAttribute;
import cambridge.model.StaticAttribute;
import cambridge.model.StaticFragment;
import cambridge.model.TagNode;
import cambridge.model.TagPart;
import cambridge.model.TemplateDocument;
import cambridge.model.TemplateNode;
import cambridge.model.TextNode;
import cambridge.model.TextTagPart;
import cambridge.parser.tokens.AttributeNameToken;
import cambridge.parser.tokens.AttributeValueToken;
import cambridge.parser.tokens.CloseTagToken;
import cambridge.parser.tokens.ExpressionToken;
import cambridge.parser.tokens.ExtensionToken;
import cambridge.parser.tokens.OpenTagToken;
import cambridge.parser.tokens.ParserDirectiveToken;
import cambridge.parser.tokens.Token;
import cambridge.parser.tokens.TokenType;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * TemplateParser creates a Template Model object by parsing a template document
 * in cambridge template format. It can also parse regular HTML documents too.
 * <p/>
 * It requires an TemplateTokenizer object to do the parsing and the generated
 * Template object represents a tree of nodes in the parsed document that is
 * similar to a DOM tree.
 *
 * @see cambridge.model.TemplateDocument
 * @see TemplateTokenizer
 */
public class TemplateParser {

    private final TemplateTokenizer tokenizer;

    private TemplateLoader templateLoader;

    public TemplateParser(TemplateTokenizer tokenizer) {
        this.tokenizer = tokenizer;
        this.expressionLanguage = Expressions.getDefaultExpressionLanguage();
    }

    public TemplateParser(TemplateTokenizer tokenizer, TemplateLoader loader) {
        this(tokenizer);
        this.templateLoader = loader;
    }

    private final static int BUFFER_SIZE = 5;
    private final static int maxPeek = 3;
    private static ArrayList<ExtensionPoint> extensionPoints;

    private final Token[] buf = new Token[BUFFER_SIZE];

    private int readIndex = -1; // The last read index
    private int writeIndex = -1; // The last written index
    private boolean firstTag = true;
    private Token currentToken;
    private List<TemplateNode> matchedNodes = new ArrayList<TemplateNode>();
    private TemplateDocument template;
    private HashMap<String, String> namespaceMappings;

    private ExpressionLanguage expressionLanguage;

    public ExpressionLanguage getExpressionLanguage() {
        return expressionLanguage;
    }

    private int getIndex(int no) {
        return no % BUFFER_SIZE;
    }

    private void fillBuffer() throws IOException {
        Token tok;
        while (tokenizer.hasMoreTokens()) {
            tok = tokenizer.nextToken();
            writeIndex++;
            buf[getIndex(writeIndex)] = tok;

            if (readIndex == -1) {
                if (writeIndex == BUFFER_SIZE - 1) break;
            } else {
                if (writeIndex - readIndex == maxPeek) break;
            }
        }
    }

    void nextToken() throws IOException {
        if (readIndex + (BUFFER_SIZE - maxPeek) == writeIndex && buf[getIndex(writeIndex)].getType() != TokenType.EOF) {
            fillBuffer();
        }

        currentToken = buf[getIndex(++readIndex)];
    }

    Token peek(int p) {
        if (p > maxPeek) throw new IllegalArgumentException("Can not peek " + p + " tokens");
        return buf[getIndex(readIndex + p)];
    }

    public static void registerExtensionPoint(ExtensionPoint ep) {
        if (extensionPoints == null) {
            extensionPoints = new ArrayList<ExtensionPoint>();
        }
        extensionPoints.add(ep);
    }

    static ArrayList<ExtensionPoint> getExtensionPoints() {
        return extensionPoints;
    }

    private String getNamespaceUri(String name) {
        if (name == null) {
            return null;
        }

        if (namespaceMappings != null) {
            String uri = namespaceMappings.get(name);
            if (uri != null) {
                return uri;
            }
        }

        return Cambridge.getInstance().getDefaultNamespace(name);
    }

    private void putNamespaceMapping(String name, String uri) {
        if (namespaceMappings == null) {
            namespaceMappings = new HashMap<String, String>();
        }

        namespaceMappings.put(name, uri);
    }

    public TemplateDocument parse() throws IOException, TemplateParsingException {
        template = new TemplateDocument();
        fillBuffer();
        nextToken();

        while (currentToken.getType() != TokenType.EOF) {
            getNode();

            nextToken();
        }

        template.addChildren(matchedNodes);

        return template;
    }

    private void getNode() throws IOException, TemplateParsingException {
        TemplateNode node;
        switch (currentToken.getType()) {
            case COMMENT:
                node = new CommentNode();
                CommentNode comment = (CommentNode) node;
                comment.setContents(currentToken.getValue());
                node.setBeginLine(currentToken.getLineNo());
                node.setBeginColumn(currentToken.getColumn());
                node.setEndLine(peek(1).getLineNo());
                node.setEndColumn(peek(1).getColumn());
                matchedNodes.add(node);
                break;
            case CDATA:
            case DOC_TYPE:
            case EOL:
            case STRING:
            case WS:
                node = textNode();
                matchedNodes.add(node);
                break;
            case EXPRESSION:
                node = expression();
                matchedNodes.add(node);
                break;
            case EXTENSION:
                ExtensionToken tok = (ExtensionToken) currentToken;
                node = tok.createNode(expressionLanguage);
                matchedNodes.add(node);
                break;
            case OPEN_TAG:
                node = tag();
                matchedNodes.add(node);
                break;
            case PARSER_DIRECTIVE:
                node = parserDirective();
                if (node != null) {
                    matchedNodes.add(node);
                }
                break;
            case CLOSE_TAG:
                CloseTagToken token = (CloseTagToken) currentToken;
                TagNode tag = null;
                int openIndex = -1;
                for (int i = matchedNodes.size() - 1; i != -1; i--) {
                    TemplateNode n = matchedNodes.get(i);
                    if (n instanceof TagNode) {
                        TagNode tn = (TagNode) n;
                        if (tn.getEndLine() == 0 && tn.getEndColumn() == 0 && tn.tagNameString.equals(token.getTagName())) {
                            tag = tn;
                            openIndex = i;
                            break;
                        }
                    }
                }

                if (openIndex != -1 && tag != null) {
                    ArrayList<TemplateNode> sub = new ArrayList<TemplateNode>();
                    for (int i = openIndex + 1; i < matchedNodes.size(); i++) {
                        TemplateNode n = matchedNodes.get(i);
                        n.setParent(tag);
                        sub.add(n);
                    }

                    tag.addChildren(sub);

                    matchedNodes.removeAll(sub);
                    tag.setCloseText(token.getActualValue());
                    tag.setEndLine(peek(1).getLineNo());
                    tag.setEndColumn(peek(1).getColumn());
                } else {
                    node = new TextNode();
                    TextNode text = (TextNode) node;
                    text.setContents(currentToken.getValue());
                    text.setBeginLine(currentToken.getLineNo());
                    text.setBeginColumn(currentToken.getColumn());
                    text.setEndLine(peek(1).getLineNo());
                    text.setEndColumn(peek(1).getColumn());
                    matchedNodes.add(node);
                }

                break;
            default:
                throw new RuntimeException("TemplateParser error, invalid token: " + currentToken);
                //return null;
        }
    }

    private ExpressionNode expression() throws TemplateParsingException {
        try {
            ExpressionToken tok = (ExpressionToken) currentToken;
            ExpressionNode node = new ExpressionNode(currentToken.value, expressionLanguage.parse(currentToken.value, currentToken.getLineNo(), currentToken.getColumn()), tok.isRawExpression());
            node.setBeginLine(currentToken.getLineNo());
            node.setBeginColumn(currentToken.getColumn());
            String[] lines = node.getSource().split("\n");

            node.setEndLine(currentToken.getLineNo() + lines.length);

            if (lines.length == 0)
            {
                node.setEndColumn(currentToken.getColumn() + node.getSource().length());
            }
            else
            {
                node.setEndColumn(currentToken.getColumn() + lines[lines.length - 1].replaceAll("\r", "").length());
            }

            if (tok.getFilters() != null) {
                node.setFilters(tok.getFilters());
            }

            return node;
        } catch (ExpressionParsingException e) {
            throw new TemplateParsingException("Error parsing expression", e, currentToken.getLineNo(), currentToken.getColumn());
        }
    }

    private TagNode tag() throws IOException, TemplateParsingException {
        OpenTagToken token = (OpenTagToken) currentToken;

        Cambridge bindings = Cambridge.getInstance();

        TagNode node = null;

        if (token.getNameSpace() != null) {
            String namespaceUri = getNamespaceUri(token.getNameSpace());
            if (namespaceUri != null) {
                node = bindings.getDynamicTag(new DynamicAttributeKey(namespaceUri, token.getNameSpace(), token.getTagName()));
            }
        }

        boolean dynamicTag = true;
        if (node == null) {
            node = new TagNode();
            dynamicTag = false;
        }

        node.setBeginLine(token.getLineNo());
        node.setBeginColumn(token.getColumn());
        node.setTagName(token.getTagName());
        node.setNameSpace(token.getNameSpace());
        node.setTagNameString(token.value);

        // Match the open tag
        while (peek(1).getType() != TokenType.EOF) {
            nextToken();
            switch (currentToken.getType()) {
                case WS:
                case EOL:
                    TextTagPart e = new TextTagPart(currentToken.getActualValue(), currentToken.getLineNo(), currentToken.getColumn());
                    e.whitespace = true;
                    node.addText(e);
                    break;
                case TAG_STRING:
                case ASSIGN:
                    node.addText(new TextTagPart(currentToken.getActualValue(), currentToken.getLineNo(), currentToken.getColumn()));
                    break;
                case ATTRIBUTE_NAME:
                    AttributeNameToken tok = (AttributeNameToken) currentToken;

                    if (dynamicTag && tok.getNameSpace() == null) {
                        tok.setNameSpace(node.getNameSpace());
                    }

                    Attribute element = null;
                    StringBuilder textContent = new StringBuilder();
                    textContent.append(tok.getActualValue());
                    boolean dynamic = false;
                    boolean staticAttribute = false;

                    String namespaceUri = getNamespaceUri(tok.getNameSpace());
                    if (namespaceUri != null && bindings.isRegisteredNamespace(namespaceUri)) {

                        dynamic = true;
                        if (bindings.isStaticAttribute(namespaceUri, tok.getAttributeName())) {
                            staticAttribute = true;
                            element = new StaticAttribute(namespaceUri, tok.getLineNo(), tok.getColumn());
                        } else {
                            element = new DynamicAttribute(namespaceUri, tok.getLineNo(), tok.getColumn());
                        }
                    }

                    while (true) {
                        if (peek(1).getType() == TokenType.EOF
                                || peek(1).getType() == TokenType.TAG_END
                                || peek(1).getType() == TokenType.EXPRESSION
                                || peek(1).getType() == TokenType.EXTENSION
                                || peek(1).getType() == TokenType.ATTRIBUTE_NAME
                                ) {
                            break;
                        }
                        nextToken();

                        boolean exitLoop = false;
                        switch (currentToken.getType()) {
                            case WS:
                            case EOL:
                            case ASSIGN:
                                textContent.append(currentToken.getActualValue());
                                break;
                            case ATTRIBUTE_VALUE:
                                textContent.append(currentToken.getActualValue());

                                if (dynamic) {
                                    if (staticAttribute) {
                                        ((StaticAttribute) element).setValue(currentToken.value);
                                    } else {
                                        ((DynamicAttribute) element).setValue(currentToken.value, expressionLanguage.parse(currentToken.value, currentToken.getLineNo(), currentToken.getColumn()));
                                    }

                                    exitLoop = true;
                                    break;
                                }

                                TemplateTokenizer at = new TemplateTokenizer(new StringReader(currentToken.getValue()));

                                ArrayList<AttributeFragment> fragments = new ArrayList<AttributeFragment>();
                                while (at.hasMoreTokens()) {
                                    Token attrToken = at.nextToken();
                                    switch (attrToken.getType()) {
                                        case EXPRESSION:
                                            ExpressionToken expTok = (ExpressionToken) attrToken;
                                            try {
                                                ExpressionNode expNode = new ExpressionNode(attrToken.value, expressionLanguage.parse(attrToken.value, attrToken.getLineNo(), attrToken.getColumn()), expTok.isRawExpression());

                                                if (expTok.getFilters() != null) {
                                                    expNode.setFilters(expTok.getFilters());
                                                }
                                                fragments.add(expNode);
                                            } catch (ExpressionParsingException e1) {
                                                throw new TemplateParsingException("Error parsing expression", e1, currentToken.getLineNo(), currentToken.getColumn());
                                            }

                                            break;
                                        case EXTENSION:
                                            ExtensionToken extensionToken = (ExtensionToken) attrToken;
                                            ExtensionNode extensionNode = extensionToken.createNode(expressionLanguage);
                                            fragments.add(extensionNode);
                                            break;
                                        case WS:
                                        case STRING:
                                            StaticFragment st = new StaticFragment(attrToken.value);
                                            fragments.add(st);
                                            break;
                                    }
                                }

                                if (fragments.size() == 0 || fragments.size() == 1 && fragments.get(0) instanceof StaticFragment) {
                                    element = new SimpleAttribute(currentToken.getLineNo(), currentToken.getColumn());
                                    ((SimpleAttribute) element).setValue(currentToken.value);
                                } else {
                                    element = new ComplexAttribute(currentToken.getLineNo(), currentToken.getColumn());
                                    ((ComplexAttribute) element).setFragments(fragments);
                                    AttributeValueToken aTok = (AttributeValueToken) currentToken;
                                    if (aTok.getQuotes() == -2) {
                                        ((ComplexAttribute) element).setQuote('"');
                                    } else if (aTok.getQuotes() == -3) {
                                        ((ComplexAttribute) element).setQuote('\'');
                                    }
                                }

                                exitLoop = true;
                                break;
                        }

                        if (exitLoop) break;
                    }

                    if (element == null) {
                        throw new TemplateParsingException("Error parsing template file. Unterminated tag?", currentToken.getLineNo(), currentToken.getColumn());
                    }

                    element.setAttributeName(tok.getAttributeName());
                    element.setAttributeNameSpace(tok.getNameSpace());
                    element.setTextContent(textContent.toString());


                    int s = node.getTagParts().size();
                    if (s > 0) {
                        TagPart te = node.getTagParts().get(s - 1);
                        if (te instanceof TextTagPart) {
                            if (te.isWhiteSpace()) {
                                node.getTagParts().remove(s - 1);
                            }
                        }
                    }

                    if (firstTag && "xmlns".equalsIgnoreCase(element.getAttributeNameSpace())) {
                        putNamespaceMapping(element.getAttributeName(), element.getValue());
                    }

                    node.addAttribute(element);
                    break;
                case EXPRESSION:
                    try {

                        ExpressionToken t = (ExpressionToken) currentToken;
                        ExpressionTagPart p = new ExpressionTagPart(currentToken.value,
                                expressionLanguage.parse(currentToken.value, currentToken.getLineNo(), currentToken.getColumn()),
                                t.isRawExpression(), currentToken.getLineNo(), currentToken.getColumn());

                        if (t.getFilters() != null) {
                            p.setFilters(t.getFilters());
                        }

                        node.addExpression(p);

                    } catch (ExpressionParsingException e1) {
                        throw new TemplateParsingException("Error parsing expression", e1, currentToken.getLineNo(), currentToken.getColumn());
                    }
                    break;
                case EXTENSION:
                    ExtensionToken extensionToken = (ExtensionToken) currentToken;
                    ExtensionNode extensionTagPart = extensionToken.createNode(expressionLanguage);
                    node.addTagPart(extensionTagPart);
                    break;
                case TAG_END:
                    node.setTagEndText(currentToken.getActualValue());
                    break;
            }

            if (currentToken.getType() == TokenType.TAG_END) {
                if (currentToken.getValue().equals("/>")) {
                    node.setEndLine(peek(1).getLineNo());
                    node.setEndColumn(peek(1).getColumn());

                    if (dynamicTag) {
                        ((DynamicTag) node).init();
                    }
                    firstTag = false;
                    return node;
                } else {
                    break;
                }
            }
        }

        if (dynamicTag) {
            ((DynamicTag) node).init();
        }

        firstTag = false;
        return node;
    }

    private TemplateNode parserDirective() throws TemplateParsingException {
        ParserDirectiveToken tok = (ParserDirectiveToken) currentToken;
        if ("include".equalsIgnoreCase(tok.getDirective()) && templateLoader != null) {
            return parseIncludeNode(tok);
        }
        if ("set".equalsIgnoreCase(tok.getDirective())) {
            return parseSetDirective(tok);
        }
        if ("namespace".equalsIgnoreCase(tok.getDirective())) {
            return parseNamespaceDirective(tok);
        }
        if ("expressionLanguage".equalsIgnoreCase(tok.getDirective())) {
            return parseExpressionLanguageDirective(tok);
        }
        if ("debug".equalsIgnoreCase(tok.getDirective())) {
            return new DebugDirective();
        }
        if ("extend".equalsIgnoreCase(tok.getDirective()) || "extends".equalsIgnoreCase(tok.getDirective())) {
            if (template.hasChildren()) {
                throw new TemplateParsingException("extend directive should be the first element of the template", tok.getLineNo(), tok.getColumn());
            }

            return parseExtendsDirective(tok);
        }

        return null;
    }

    private static final Pattern setDirectivePattern = Pattern.compile("(\\w+)\\s?=(.*)");

    private TemplateNode parseSetDirective(ParserDirectiveToken tok) {
        String args = tok.getArgs();
        if (args == null) {
            throw new TemplateParsingException("Invalid set directive", currentToken.getLineNo(), currentToken.getColumn());
        }

        Matcher matcher = setDirectivePattern.matcher(args);
        if (!matcher.find()) {
            throw new TemplateParsingException("Invalid set directive", currentToken.getLineNo(), currentToken.getColumn());
        }

        String varName = matcher.group(1);
        String expression = matcher.group(2);

        Expression ex = expressionLanguage.parse(expression, currentToken.getLineNo(), currentToken.getColumn());

        return new SetDirective(varName, ex);
    }

    private static final Pattern namespaceDirectivePattern = Pattern.compile("(\\w+)\\s?=\"([^\"]+)\"");

    private TemplateNode parseNamespaceDirective(ParserDirectiveToken tok) {
        String args = tok.getArgs();
        if (args == null) {
            throw new TemplateParsingException("Invalid namespace directive", currentToken.getLineNo(), currentToken.getColumn());
        }

        Matcher matcher = namespaceDirectivePattern.matcher(args);
        if (!matcher.find()) {
            throw new TemplateParsingException("Invalid namespace directive", currentToken.getLineNo(), currentToken.getColumn());
        }

        String name = matcher.group(1);
        String uri = matcher.group(2);

        putNamespaceMapping(name, uri);

        return new NamespaceDirective(name, uri);
    }

    private TemplateNode parseExpressionLanguageDirective(ParserDirectiveToken tok) {
        String args = tok.getArgs();
        if (args == null || args.trim().equals("")) {
            throw new TemplateParsingException("Invalid expression language directive", currentToken.getLineNo(), currentToken.getColumn());
        }

        expressionLanguage = Expressions.getExpressionLanguageByName(args.trim());
        return new ExpressionLanguageDirective(args.trim());
    }

    private TemplateNode parseIncludeNode(ParserDirectiveToken tok) {
        if (tok.getArgs() == null) {
            throw new TemplateParsingException("Invalid include directive", currentToken.getLineNo(), currentToken.getColumn());
        }
        Matcher matcher = TemplateDocument.selectorPattern.matcher(tok.getArgs());

        String fileName = matcher.replaceAll("").trim();
        String selector = null;
        matcher.reset();
        if (matcher.find()) {
            selector = matcher.group(0);
        }

        try {
            template.addInclude(fileName);
            return new IncludeNode(templateLoader, fileName, selector);
        } catch (TemplateLoadingException e) {
            throw new TemplateParsingException("Could not load the include", e, currentToken.getLineNo(), currentToken.getColumn());
        } catch (BehaviorInstantiationException e) {
            throw new TemplateParsingException("Could not load the include", e, currentToken.getLineNo(), currentToken.getColumn());
        }
    }

    private TemplateNode parseExtendsDirective(ParserDirectiveToken tok) {
        if (tok.getArgs() == null) {
            throw new TemplateParsingException("Invalid extend directive", currentToken.getLineNo(), currentToken.getColumn());
        }
        Matcher matcher = TemplateDocument.selectorPattern.matcher(tok.getArgs());

        String fileName = matcher.replaceAll("").trim();
        String selector = null;
        matcher.reset();
        if (matcher.find()) {
            selector = matcher.group(0);
        }

        try {
            template.addInclude(fileName);
            return new ExtendsDirective(templateLoader, fileName, selector);
        } catch (TemplateLoadingException e) {
            throw new TemplateParsingException("Could not load the extended template", e, currentToken.getLineNo(), currentToken.getColumn());
        } catch (BehaviorInstantiationException e) {
            throw new TemplateParsingException("Could not load the extended template", e, currentToken.getLineNo(), currentToken.getColumn());
        }
    }

    /**
     * Matches textNodes
     *
     * @return TextNode
     * @throws java.io.IOException .
     */
    private TextNode textNode() throws IOException {
        StringBuilder builder = new StringBuilder();
        TextNode node = new TextNode();
        node.setBeginLine(currentToken.getLineNo());
        node.setBeginColumn(currentToken.getColumn());
        while (true) {
            builder.append(currentToken.getValue());

            TokenType type = peek(1).getType();
            if (type == TokenType.CDATA
                    || type == TokenType.DOC_TYPE || type == TokenType.EOL
                    || type == TokenType.STRING || type == TokenType.WS) {
                nextToken();
            } else {
                node.setEndLine(peek(1).getLineNo());
                node.setEndColumn(peek(1).getColumn());
                break;
            }
        }

        node.setContents(builder.toString());
        return node;
    }
}
