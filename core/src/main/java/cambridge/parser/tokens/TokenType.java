package cambridge.parser.tokens;

/**
 * Types of tokens
 */
public enum TokenType {
   DOC_TYPE,
   PARSER_DIRECTIVE,
   COMMENT,
   OPEN_TAG,
   TAG_END,
   CLOSE_TAG,
   ASSIGN,
   EOF,
   EOL,
   WS,
   STRING, // Strings outside a tag element
   TAG_STRING, // Strings inside a tag element
   CDATA,
   ATTRIBUTE_NAME,
   ATTRIBUTE_VALUE,
   EXPRESSION
}
