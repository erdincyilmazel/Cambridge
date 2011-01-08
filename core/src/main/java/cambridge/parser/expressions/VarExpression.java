package cambridge.parser.expressions;

import cambridge.ExpressionEvaluationException;
import cambridge.runtime.PropertyAccessException;
import cambridge.runtime.PropertyUtils;
import cambridge.runtime.TemplateBindings;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * User: erdinc
 * Date: Oct 31, 2009
 * Time: 1:29:09 AM
 */
public class VarExpression implements Expression {
   private final String varName;
   private ArrayList<VarProperty> properties;

   public VarExpression(String varName) {
      this.varName = varName;
   }

   public void addProperty(VarProperty p) {
      if (properties == null) {
         properties = new ArrayList<VarProperty>();
      }

      properties.add(p);
   }

   public Type getType(TemplateBindings bindings) throws ExpressionEvaluationException {
      Object o = eval(bindings);
      if (o instanceof Boolean) {
         return Type.Boolean;
      }
      if (o instanceof Integer) {
         return Type.Int;
      }
      if (o instanceof Long) {
         return Type.Long;
      }
      if (o instanceof Float) {
         return Type.Float;
      }
      if (o instanceof Double) {
         return Type.Double;
      }
      if (o instanceof String) {
         return Type.String;
      }
      return o == null ? Type.Null : Type.Object;
   }

   public Object eval(TemplateBindings p) throws ExpressionEvaluationException {
      PropertyUtils utils = PropertyUtils.instance();
      if (properties == null) {
         return p.get(varName);
      }

      Object object = p.get(varName);
      if (object == null) {
         return null;
      }
      for (VarProperty property : properties) {
         if (property instanceof IdentifierVarProperty) {
            IdentifierVarProperty id = (IdentifierVarProperty) property;
            try {
               object = utils.getBeanProperty(object, id.name);
            } catch (PropertyAccessException e) {
               throw new ExpressionEvaluationException(e.getMessage());
            }
         } else {
            MapVarProperty m = (MapVarProperty) property;
            if (object instanceof Map) {
               object = ((Map) object).get(m.expression.eval(p));
            } else if (object instanceof List) {
               object = ((List) object).get(m.expression.asInt(p));
            }
         }
      }

      return object;
   }

   public boolean asBoolean(TemplateBindings bindings) throws ExpressionEvaluationException {
      Object o = eval(bindings);

      if (o instanceof Boolean) {
         return (Boolean) o;
      }
      if (o instanceof Number) {
         return ((Number) o).intValue() != 0;
      }
      return o instanceof String && !"".equals(o);
   }

   public int asInt(TemplateBindings bindings) throws ExpressionEvaluationException {
      Object o = eval(bindings);
      if (o instanceof Number) {
         return ((Number) o).intValue();
      }
      return 0;
   }

   public float asFloat(TemplateBindings bindings) throws ExpressionEvaluationException {
      Object o = eval(bindings);
      if (o instanceof Number) {
         return ((Number) o).floatValue();
      }

      return 0;
   }

   public double asDouble(TemplateBindings bindings) throws ExpressionEvaluationException {
      Object o = eval(bindings);
      if (o instanceof Number) {
         return ((Number) o).doubleValue();
      }
      return 0;
   }

   public long asLong(TemplateBindings bindings) throws ExpressionEvaluationException {
      Object o = eval(bindings);
      if (o instanceof Number) {
         return ((Number) o).longValue();
      }
      return 0;
   }

   public String asString(TemplateBindings bindings) throws ExpressionEvaluationException {
      return eval(bindings).toString();
   }
}
