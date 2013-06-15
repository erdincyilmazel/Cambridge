package cambridge.parser.expressions;

import cambridge.ExpressionEvaluationException;
import cambridge.runtime.ExpressionContext;
import cambridge.runtime.PropertyAccessException;
import cambridge.runtime.PropertyUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Erdinc Yilmazel
 * Date: Oct 31, 2009
 * Time: 1:29:09 AM
 */
public class VarExpression implements CambridgeExpression {
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

   public Type getType(ExpressionContext context) throws ExpressionEvaluationException {
      Object o = eval(context);
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

   public Object eval(ExpressionContext context) throws ExpressionEvaluationException {
      if (properties == null) {
         return context.get(varName);
      }

      PropertyUtils utils = PropertyUtils.instance();

      Object object = context.get(varName);
      if (object == null) {
         return null;
      }
      for (VarProperty property : properties) {
         if (property instanceof IdentifierVarProperty) {
            IdentifierVarProperty id = (IdentifierVarProperty) property;
            try {
               object = utils.getBeanProperty(object, id.name);
            } catch (PropertyAccessException e) {
               throw new ExpressionEvaluationException(e);
            }
         } else {
            MapVarProperty m = (MapVarProperty) property;
            if (object instanceof Map) {
               object = ((Map<?,?>) object).get(m.expression.eval(context));
            } else if (object instanceof List) {
               object = ((List<?>) object).get(m.expression.asInt(context));
            } else if (object instanceof Object[]) {
               object = ((Object[]) object)[m.expression.asInt(context)];
            }
         }
      }

      return object;
   }

   public boolean asBoolean(ExpressionContext context) throws ExpressionEvaluationException {
      Object o = eval(context);

      if (o instanceof Boolean) {
         return (Boolean) o;
      }
      if (o instanceof Number) {
         return ((Number) o).intValue() != 0;
      }
      if (o instanceof String) {
          return !"".equals(o);
      }

      return o != null;
   }

   public int asInt(ExpressionContext context) throws ExpressionEvaluationException {
      Object o = eval(context);
      if (o instanceof Number) {
         return ((Number) o).intValue();
      }
      return 0;
   }

   public float asFloat(ExpressionContext context) throws ExpressionEvaluationException {
      Object o = eval(context);
      if (o instanceof Number) {
         return ((Number) o).floatValue();
      }

      return 0;
   }

   public double asDouble(ExpressionContext context) throws ExpressionEvaluationException {
      Object o = eval(context);
      if (o instanceof Number) {
         return ((Number) o).doubleValue();
      }
      return 0;
   }

   public long asLong(ExpressionContext context) throws ExpressionEvaluationException {
      Object o = eval(context);
      if (o instanceof Number) {
         return ((Number) o).longValue();
      }
      return 0;
   }

   public String asString(ExpressionContext context) throws ExpressionEvaluationException {
      return eval(context).toString();
   }
}
