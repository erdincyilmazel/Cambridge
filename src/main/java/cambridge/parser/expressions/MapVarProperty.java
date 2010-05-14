package cambridge.parser.expressions;

/**
 * User: erdinc
 * Date: Oct 31, 2009
 * Time: 1:31:05 AM
 */
class MapVarProperty implements VarProperty {
   final Expression expression;

   public MapVarProperty(Expression expression) {
      this.expression = expression;
   }
}
