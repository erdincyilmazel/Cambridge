package cambridge.parser.expressions;

import cambridge.ExpressionEvaluationException;
import cambridge.runtime.TemplateBindings;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * User: Erdinc
 * Date: Apr 12, 2010
 * Time: 11:00:39 PM
 */
public class Range implements Iterable<Integer>, Expression {
   private int min;
   private int max;

   public Range(int min, int max) {
      if(max < min) {
         throw new IllegalArgumentException("Invalid range");
      }

      this.min = min;
      this.max = max;
   }

   public Type getType(TemplateBindings globals) throws ExpressionEvaluationException {
      return Type.Object;
   }

   public Object eval(TemplateBindings globals) throws ExpressionEvaluationException {
      return this;
   }

   public boolean asBoolean(TemplateBindings globals) throws ExpressionEvaluationException {
      return true;
   }

   public int asInt(TemplateBindings globals) throws ExpressionEvaluationException {
      return min;
   }

   public float asFloat(TemplateBindings globals) throws ExpressionEvaluationException {
      return min;
   }

   public double asDouble(TemplateBindings globals) throws ExpressionEvaluationException {
      return min;
   }

   public long asLong(TemplateBindings globals) throws ExpressionEvaluationException {
      return min;
   }

   public String asString(TemplateBindings globals) throws ExpressionEvaluationException {
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
      if(parts.length != 2) {
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
      for(int i = min; i <= max; i++) {
         ret.add(i);
      }

      return ret;
   }

   public int[] toArray() {
      int[] ret = new int[max - min + 1];
      for(int i = 0; i < ret.length; i++) {
         ret[i] = min + i;
      }

      return ret;
   }
}
