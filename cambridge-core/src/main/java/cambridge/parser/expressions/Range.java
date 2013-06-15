package cambridge.parser.expressions;

import cambridge.ExpressionEvaluationException;
import cambridge.runtime.ExpressionContext;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Erdinc Yilmazel
 * Date: Apr 12, 2010
 * Time: 11:00:39 PM
 */
public class Range implements Iterable<Integer>, CambridgeExpression {
   private int min;
   private int max;

   public Range(int min, int max) {
      if (max < min) {
         throw new IllegalArgumentException("Invalid range");
      }

      this.min = min;
      this.max = max;
   }

   public Type getType( ExpressionContext context) throws ExpressionEvaluationException {
      return Type.Object;
   }

   public Object eval( ExpressionContext context) throws ExpressionEvaluationException {
      return this;
   }

   public boolean asBoolean( ExpressionContext context) throws ExpressionEvaluationException {
      return true;
   }

   public int asInt( ExpressionContext context) throws ExpressionEvaluationException {
      return min;
   }

   public float asFloat( ExpressionContext context) throws ExpressionEvaluationException {
      return min;
   }

   public double asDouble( ExpressionContext context) throws ExpressionEvaluationException {
      return min;
   }

   public long asLong( ExpressionContext context) throws ExpressionEvaluationException {
      return min;
   }

   public String asString( ExpressionContext context) throws ExpressionEvaluationException {
      return toString();
   }

   class RangeIterator implements Iterator<Integer> {
      int current;

      public RangeIterator() {
         current = min;
      }

      public boolean hasNext() {
         return current <= max;
      }

      public Integer next() {
         return current++;
      }

      public void remove() {
      }
   }

   public static Range fromString(String str) {
      String[] parts = str.split("\\.\\.");
      if (parts.length != 2) {
         throw new RuntimeException("Could not parse " + str);
      }

      return new Range(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
   }

   public Iterator<Integer> iterator() {
      return new RangeIterator();
   }

   public String toString() {
      return min + ".." + max;
   }

   public List<Integer> toList() {
      ArrayList<Integer> ret = new ArrayList<Integer>(max - min + 1);
      for (int i = min; i <= max; i++) {
         ret.add(i);
      }

      return ret;
   }

   public int[] toArray() {
      int[] ret = new int[max - min + 1];
      for (int i = 0; i < ret.length; i++) {
         ret[i] = min + i;
      }

      return ret;
   }
}
