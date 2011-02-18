package cambridge.parser.expressions;

/**
 * User: erdinc
 * Date: Oct 31, 2009
 * Time: 1:30:47 AM
 */
class IdentifierVarProperty implements VarProperty {
   final String name;

   public IdentifierVarProperty(String name) {
      this.name = name;
   }

   public String toString() {
      return name;
   }
}
