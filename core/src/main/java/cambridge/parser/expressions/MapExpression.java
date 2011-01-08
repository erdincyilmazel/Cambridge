package cambridge.parser.expressions;

import cambridge.ExpressionEvaluationException;
import cambridge.runtime.TemplateBindings;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * User: Erdinc
 * Date: Apr 12, 2010
 * Time: 11:53:23 PM
 */
public class MapExpression extends HashMap<String, Object> implements Expression, Iterable<MapExpression.MapEntry> {
   public Type getType(TemplateBindings globals) throws ExpressionEvaluationException {
      return Type.Object;
   }

   public Object eval(TemplateBindings globals) throws ExpressionEvaluationException {
      return this;
   }

   public boolean asBoolean(TemplateBindings globals) throws ExpressionEvaluationException {
      return false;
   }

   public int asInt(TemplateBindings globals) throws ExpressionEvaluationException {
      return 0;
   }

   public float asFloat(TemplateBindings globals) throws ExpressionEvaluationException {
      return 0;
   }

   public double asDouble(TemplateBindings globals) throws ExpressionEvaluationException {
      return 0;
   }

   public long asLong(TemplateBindings globals) throws ExpressionEvaluationException {
      return 0;
   }

   public String asString(TemplateBindings globals) throws ExpressionEvaluationException {
      return toString();
   }

   public class MapEntry {
      final String key;
      final Object value;

      MapEntry(String key, Object value) {
         this.key = key;
         this.value = value;
      }

      public String getKey() {
         return key;
      }

      public Object getValue() {
         return value;
      }
   }

   class MapExpressionIterator implements Iterator<MapEntry> {
      final Iterator<Map.Entry<String, Object>> entryIterator;

      public MapExpressionIterator() {
         Set<Map.Entry<String,Object>> entries = MapExpression.this.entrySet();
         entryIterator = entries.iterator();
      }

      public boolean hasNext() {
         return entryIterator.hasNext();
      }

      public MapEntry next() {
         Map.Entry<String, Object> e = entryIterator.next();
         return new MapEntry(e.getKey(), e.getValue());
      }

      public void remove() {
      }
   }

   public Iterator<MapEntry> iterator() {
      return new MapExpressionIterator();
   }
}
