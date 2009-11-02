package cambridge.parser.tokens;

/**
 * A token is a unit of text that obeys certain rules and that
 * is consumed by the parser
 */
public abstract class Token {
   public String value;
   int lineNo;
   int column;
   int nextLine;
   int nextCol;

   public Token(int line, int c, String val, int nl, int nc) {
      lineNo = line;
      column = c;
      value = val;
      nextLine = nl;
      nextCol = nc;
   }

   public int getColumn() {
      return column;
   }

   public int getLineNo() {
      return lineNo;
   }

   public String getValue() {
      return value;
   }

   public String toString() {
      return getType() + " line: " + lineNo + " column: " + getColumn()
         + " value: \"" + getFormattedString() + "\" nextLine: " + nextLine
         + " nextColumn: " + nextCol;
   }

   public abstract TokenType getType();

   public String getFormattedString() {
      return value;
   }

   public String getActualValue() {
      return value;
   }
}
