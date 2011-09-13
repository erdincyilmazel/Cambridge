package cambridge;

import cambridge.model.Expression;

/**
 * All the Expression language engines supported by Cambridge should provide an implementation
 * of this interface.
 *
 * @author Erdinc YILMAZEL
 * @since 1/31/11
 */
public interface ExpressionLanguage {
   /**
    * Parses the passed in text and returns a compiled Expression object.
    * @param expressionString The expression to be parsed.
    * @param line The line number which contains the expression. (Needed for better error reporting)
    * @param column The column number which contains the expression. (Needed for better error reporting)
    * @return Returns compiled Expression.
    * @throws ExpressionParsingException Might be thrown if something is wrong in expression syntax that is to be parsed.
    */
   public Expression parse(String expressionString, int line, int column) throws ExpressionParsingException;

   /**
    * Every expression language has a different way of defining list literals. This utility method
    * should be implemented by expression language providers that gets an expression string and wraps
    * it with some text that make it a list.
    *
    * For example, in built in expression language the list literals are written as ['a','b','c'].
    * Given the expression 'a', this method will return ['a'] in built in expression language.
    *
    * In OGNL, the lists are defined as { expression1, expression2 } so for the same example,
    * OGNLExpressionLanguage should return {'a'}
    *
    * @param expr The expression string
    * @return Returns another string that represents a list
    */
   public String wrapExpressionAsList(String expr);
}
