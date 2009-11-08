package cambridge.parser.expressions;

import cambridge.ExpressionEvaluationException;
import cambridge.runtime.TemplateProperties;

import java.util.Map;

/**
 * User: erdinc
 * Date: Oct 31, 2009
 * Time: 12:34:49 AM
 */
public class BinaryExpression implements Expression {
   Operator operator;
   Expression left;
   Expression right;

   public BinaryExpression(Operator operator, Expression left, Expression right) {
      this.operator = operator;
      this.left = left;
      this.right = right;
   }

   @Override
   public Type getType(TemplateProperties properties) throws ExpressionEvaluationException {
      switch (operator) {
         case And:
            return Type.Int;
         case ConditionalAnd:
            return Type.Boolean;
         case ConditionalOr:
            return Type.Boolean;
         case Equal:
            return Type.Boolean;
         case GT:
            return Type.Boolean;
         case GTE:
            return Type.Boolean;
         case LT:
            return Type.Boolean;
         case LTE:
            return Type.Boolean;
         case Mod:
            return Type.Int;
         case Not:
            return Type.Boolean;
         case NotEqual:
            return Type.Boolean;
         case Or:
            return Type.Int;
         case SHIFT_LEFT:
            return Type.Int;
         case SHIFT_RIGHT:
            return Type.Int;
         case Tilde:
            return Type.Int;
         case U_SHIFT_RIGHT:
            return Type.Int;
         case XOr:
            return Type.Int;
         case Divide:
         case Minus:
         case Times:
            Type lt = left.getType(properties);
            Type rt = right.getType(properties);
            if (lt == Type.Double || rt == Type.Double) {
               return Type.Double;
            }
            if (lt == Type.Float || rt == Type.Float) {
               return Type.Float;
            }
            return Type.Int;
         case Plus:
            lt = left.getType(properties);
            rt = right.getType(properties);
            if (lt == Type.String || rt == Type.String) {
               return Type.String;
            }
            if (lt == Type.Double || rt == Type.Double) {
               return Type.Double;
            }
            if (lt == Type.Float || rt == Type.Float) {
               return Type.Float;
            }
            return Type.Int;

      }

      return Type.Null;
   }

   @Override
   public Object eval(TemplateProperties properties) throws ExpressionEvaluationException {
      switch (operator) {
         case And:
            return left.asInt(properties) & right.asInt(properties);
         case ConditionalAnd:
            return left.asBoolean(properties) && right.asBoolean(properties);
         case ConditionalOr:
            return left.asBoolean(properties) || right.asBoolean(properties);
         case Equal:
            return left == null && right == null || !(left == null || right == null) && left.eval(properties).equals(right.eval(properties));
         case GT:
            return left.asDouble(properties) > right.asDouble(properties);
         case GTE:
            return left.asDouble(properties) >= right.asDouble(properties);
         case LT:
            return left.asDouble(properties) < right.asDouble(properties);
         case LTE:
            return left.asDouble(properties) <= right.asDouble(properties);
         case Mod:
            return left.asInt(properties) % right.asInt(properties);
         case NotEqual:
            return !(left == null && right == null || !(left == null || right == null) && left.eval(properties).equals(right.eval(properties)));
         case Or:
            return left.asInt(properties) | right.asInt(properties);
         case SHIFT_LEFT:
            return left.asInt(properties) << right.asInt(properties);
         case SHIFT_RIGHT:
            return left.asInt(properties) >> right.asInt(properties);
         case U_SHIFT_RIGHT:
            return left.asInt(properties) >> right.asInt(properties);
         case XOr:
            return left.asInt(properties) ^ right.asInt(properties);
         case Plus:
            Type t = getType(properties);
            if (t == Type.String) {
               return left.asString(properties) + right.asString(properties);
            }
            if (t == Type.Double) {
               return left.asDouble(properties) + right.asDouble(properties);
            }
            if (t == Type.Float) {
               return left.asFloat(properties) + right.asFloat(properties);
            }
            return left.asInt(properties) + right.asInt(properties);
         case Minus:
            t = getType(properties);
            if (t == Type.Double) {
               return left.asDouble(properties) - right.asDouble(properties);
            }
            if (t == Type.Float) {
               return left.asFloat(properties) - right.asFloat(properties);
            }
            return left.asInt(properties) - right.asInt(properties);
         case Divide:
            t = getType(properties);
            if (t == Type.Double) {
               return left.asDouble(properties) / right.asDouble(properties);
            }
            if (t == Type.Float) {
               return left.asFloat(properties) / right.asFloat(properties);
            }
            return left.asInt(properties) / right.asInt(properties);
         case Times:
            t = getType(properties);
            if (t == Type.Double) {
               return left.asDouble(properties) * right.asDouble(properties);
            }
            if (t == Type.Float) {
               return left.asFloat(properties) * right.asFloat(properties);
            }
            return left.asInt(properties) * right.asInt(properties);
      }

      return null;
   }

   @Override
   public boolean asBoolean(TemplateProperties properties) throws ExpressionEvaluationException {
      switch (operator) {
         case And:
            return (left.asInt(properties) & right.asInt(properties)) != 0;
         case ConditionalAnd:
            return left.asBoolean(properties) && right.asBoolean(properties);
         case ConditionalOr:
            return left.asBoolean(properties) || right.asBoolean(properties);
         case Equal:
            return areEqual(properties);

         case GT:
            return left.asDouble(properties) > right.asDouble(properties);
         case GTE:
            return left.asDouble(properties) >= right.asDouble(properties);
         case LT:
            return left.asDouble(properties) < right.asDouble(properties);
         case LTE:
            return left.asDouble(properties) <= right.asDouble(properties);
         case Mod:
            return (left.asInt(properties) % right.asInt(properties)) != 0;
         case NotEqual:
            return !areEqual(properties);
         case Or:
            return (left.asInt(properties) | right.asInt(properties)) != 0;
         case SHIFT_LEFT:
            return (left.asInt(properties) << right.asInt(properties)) != 0;
         case SHIFT_RIGHT:
            return (left.asInt(properties) >> right.asInt(properties)) != 0;
         case U_SHIFT_RIGHT:
            return (left.asInt(properties) >> right.asInt(properties)) != 0;
         case XOr:
            return (left.asInt(properties) ^ right.asInt(properties)) != 0;
         case Plus:
            Type t = getType(properties);
            if (t == Type.String) {
               return !(left.asString(properties) + right.asString(properties)).equals("");
            }
            if (t == Type.Double) {
               return (left.asDouble(properties) + right.asDouble(properties)) != 0;
            }
            if (t == Type.Float) {
               return (left.asFloat(properties) + right.asFloat(properties)) != 0;
            }
            return (left.asInt(properties) + right.asInt(properties)) != 0;
         case Minus:
            t = getType(properties);
            if (t == Type.Double) {
               return (left.asDouble(properties) - right.asDouble(properties)) != 0;
            }
            if (t == Type.Float) {
               return (left.asFloat(properties) - right.asFloat(properties)) != 0;
            }
            return (left.asInt(properties) - right.asInt(properties)) != 0;
         case Divide:
            t = getType(properties);
            if (t == Type.Double) {
               return (left.asDouble(properties) / right.asDouble(properties)) != 0;
            }
            if (t == Type.Float) {
               return (left.asFloat(properties) / right.asFloat(properties)) != 0;
            }
            return (left.asInt(properties) / right.asInt(properties)) != 0;
         case Times:
            t = getType(properties);
            if (t == Type.Double) {
               return (left.asDouble(properties) * right.asDouble(properties)) != 0;
            }
            if (t == Type.Float) {
               return (left.asFloat(properties) * right.asFloat(properties)) != 0;
            }
            return (left.asInt(properties) * right.asInt(properties)) != 0;
      }

      return false;
   }

   private boolean areEqual(TemplateProperties properties) throws ExpressionEvaluationException {
      Object l = left.eval(properties);
      Object r = right.eval(properties);

      return l == null && r == null || !(l == null || r == null) && l.equals(r);
   }

   @Override
   public int asInt(TemplateProperties properties) throws ExpressionEvaluationException {
      switch (operator) {
         case And:
            return left.asInt(properties) & right.asInt(properties);
         case ConditionalAnd:
            return (left.asBoolean(properties) && right.asBoolean(properties)) ? 1 : 0;
         case ConditionalOr:
            return (left.asBoolean(properties) || right.asBoolean(properties)) ? 1 : 0;
         case Equal:
            return (left == null && right == null || !(left == null || right == null) && left.eval(properties).equals(right.eval(properties))) ? 1 : 0;
         case GT:
            return (left.asDouble(properties) > right.asDouble(properties)) ? 1 : 0;
         case GTE:
            return (left.asDouble(properties) >= right.asDouble(properties)) ? 1 : 0;
         case LT:
            return (left.asDouble(properties) < right.asDouble(properties)) ? 1 : 0;
         case LTE:
            return (left.asDouble(properties) <= right.asDouble(properties)) ? 1 : 0;
         case Mod:
            return left.asInt(properties) % right.asInt(properties);
         case NotEqual:
            return (left == null && right == null || !(left == null || right == null) && left.eval(properties).equals(right.eval(properties))) ? 0 : 1;
         case Or:
            return left.asInt(properties) | right.asInt(properties);
         case SHIFT_LEFT:
            return left.asInt(properties) << right.asInt(properties);
         case SHIFT_RIGHT:
            return left.asInt(properties) >> right.asInt(properties);
         case U_SHIFT_RIGHT:
            return left.asInt(properties) >> right.asInt(properties);
         case XOr:
            return left.asInt(properties) ^ right.asInt(properties);
         case Plus:
            Type t = getType(properties);
            if (t == Type.String) {
               return Integer.parseInt(left.asString(properties) + right.asString(properties));
            }
            if (t == Type.Double) {
               return (int) (left.asDouble(properties) + right.asDouble(properties));
            }
            if (t == Type.Float) {
               return (int) (left.asFloat(properties) + right.asFloat(properties));
            }
            return left.asInt(properties) + right.asInt(properties);
         case Minus:
            t = getType(properties);
            if (t == Type.Double) {
               return (int) (left.asDouble(properties) - right.asDouble(properties));
            }
            if (t == Type.Float) {
               return (int) (left.asFloat(properties) - right.asFloat(properties));
            }
            return left.asInt(properties) - right.asInt(properties);
         case Divide:
            t = getType(properties);
            if (t == Type.Double) {
               return (int) (left.asDouble(properties) / right.asDouble(properties));
            }
            if (t == Type.Float) {
               return (int) (left.asFloat(properties) / right.asFloat(properties));
            }
            return left.asInt(properties) / right.asInt(properties);
         case Times:
            t = getType(properties);
            if (t == Type.Double) {
               return (int) (left.asDouble(properties) * right.asDouble(properties));
            }
            if (t == Type.Float) {
               return (int) (left.asFloat(properties) * right.asFloat(properties));
            }
            return left.asInt(properties) * right.asInt(properties);
      }

      return 0;
   }

   @Override
   public float asFloat(TemplateProperties properties) throws ExpressionEvaluationException {
      switch (operator) {
         case And:
            return left.asInt(properties) & right.asInt(properties);
         case ConditionalAnd:
            return (left.asBoolean(properties) && right.asBoolean(properties)) ? 1 : 0;
         case ConditionalOr:
            return (left.asBoolean(properties) || right.asBoolean(properties)) ? 1 : 0;
         case Equal:
            return (left == null && right == null || !(left == null || right == null) && left.eval(properties).equals(right.eval(properties))) ? 1 : 0;
         case GT:
            return (left.asDouble(properties) > right.asDouble(properties)) ? 1 : 0;
         case GTE:
            return (left.asDouble(properties) >= right.asDouble(properties)) ? 1 : 0;
         case LT:
            return (left.asDouble(properties) < right.asDouble(properties)) ? 1 : 0;
         case LTE:
            return (left.asDouble(properties) <= right.asDouble(properties)) ? 1 : 0;
         case Mod:
            return left.asInt(properties) % right.asInt(properties);
         case NotEqual:
            return (left == null && right == null || !(left == null || right == null) && left.eval(properties).equals(right.eval(properties))) ? 0 : 1;
         case Or:
            return left.asInt(properties) | right.asInt(properties);
         case SHIFT_LEFT:
            return left.asInt(properties) << right.asInt(properties);
         case SHIFT_RIGHT:
            return left.asInt(properties) >> right.asInt(properties);
         case U_SHIFT_RIGHT:
            return left.asInt(properties) >> right.asInt(properties);
         case XOr:
            return left.asInt(properties) ^ right.asInt(properties);
         case Plus:
            Type t = getType(properties);
            if (t == Type.String) {
               return Integer.parseInt(left.asString(properties) + right.asString(properties));
            }
            if (t == Type.Double) {
               return (float) (left.asDouble(properties) + right.asDouble(properties));
            }
            if (t == Type.Float) {
               return (left.asFloat(properties) + right.asFloat(properties));
            }
            return left.asInt(properties) + right.asInt(properties);
         case Minus:
            t = getType(properties);
            if (t == Type.Double) {
               return (float) (left.asDouble(properties) - right.asDouble(properties));
            }
            if (t == Type.Float) {
               return (left.asFloat(properties) - right.asFloat(properties));
            }
            return left.asInt(properties) - right.asInt(properties);
         case Divide:
            t = getType(properties);
            if (t == Type.Double) {
               return (float) (left.asDouble(properties) / right.asDouble(properties));
            }
            if (t == Type.Float) {
               return (left.asFloat(properties) / right.asFloat(properties));
            }
            return left.asInt(properties) / right.asInt(properties);
         case Times:
            t = getType(properties);
            if (t == Type.Double) {
               return (float) (left.asDouble(properties) * right.asDouble(properties));
            }
            if (t == Type.Float) {
               return (left.asFloat(properties) * right.asFloat(properties));
            }
            return left.asInt(properties) * right.asInt(properties);
      }

      return 0;
   }

   @Override
   public double asDouble(TemplateProperties properties) throws ExpressionEvaluationException {
      switch (operator) {
         case And:
            return left.asInt(properties) & right.asInt(properties);
         case ConditionalAnd:
            return (left.asBoolean(properties) && right.asBoolean(properties)) ? 1 : 0;
         case ConditionalOr:
            return (left.asBoolean(properties) || right.asBoolean(properties)) ? 1 : 0;
         case Equal:
            return (left == null && right == null || !(left == null || right == null) && left.eval(properties).equals(right.eval(properties))) ? 1 : 0;
         case GT:
            return (left.asDouble(properties) > right.asDouble(properties)) ? 1 : 0;
         case GTE:
            return (left.asDouble(properties) >= right.asDouble(properties)) ? 1 : 0;
         case LT:
            return (left.asDouble(properties) < right.asDouble(properties)) ? 1 : 0;
         case LTE:
            return (left.asDouble(properties) <= right.asDouble(properties)) ? 1 : 0;
         case Mod:
            return left.asInt(properties) % right.asInt(properties);
         case NotEqual:
            return (left == null && right == null || !(left == null || right == null) && left.eval(properties).equals(right.eval(properties))) ? 0 : 1;
         case Or:
            return left.asInt(properties) | right.asInt(properties);
         case SHIFT_LEFT:
            return left.asInt(properties) << right.asInt(properties);
         case SHIFT_RIGHT:
            return left.asInt(properties) >> right.asInt(properties);
         case U_SHIFT_RIGHT:
            return left.asInt(properties) >> right.asInt(properties);
         case XOr:
            return left.asInt(properties) ^ right.asInt(properties);
         case Plus:
            Type t = getType(properties);
            if (t == Type.String) {
               return Integer.parseInt(left.asString(properties) + right.asString(properties));
            }
            if (t == Type.Double) {
               return (left.asDouble(properties) + right.asDouble(properties));
            }
            if (t == Type.Float) {
               return (left.asFloat(properties) + right.asFloat(properties));
            }
            return left.asInt(properties) + right.asInt(properties);
         case Minus:
            t = getType(properties);
            if (t == Type.Double) {
               return (left.asDouble(properties) - right.asDouble(properties));
            }
            if (t == Type.Float) {
               return (left.asFloat(properties) - right.asFloat(properties));
            }
            return left.asInt(properties) - right.asInt(properties);
         case Divide:
            t = getType(properties);
            if (t == Type.Double) {
               return (left.asDouble(properties) / right.asDouble(properties));
            }
            if (t == Type.Float) {
               return (left.asFloat(properties) / right.asFloat(properties));
            }
            return left.asInt(properties) / right.asInt(properties);
         case Times:
            t = getType(properties);
            if (t == Type.Double) {
               return (left.asDouble(properties) * right.asDouble(properties));
            }
            if (t == Type.Float) {
               return (left.asFloat(properties) * right.asFloat(properties));
            }
            return left.asInt(properties) * right.asInt(properties);
      }

      return 0;
   }

   @Override
   public long asLong(TemplateProperties properties) throws ExpressionEvaluationException {
      switch (operator) {
         case And:
            return left.asInt(properties) & right.asInt(properties);
         case ConditionalAnd:
            return (left.asBoolean(properties) && right.asBoolean(properties)) ? 1 : 0;
         case ConditionalOr:
            return (left.asBoolean(properties) || right.asBoolean(properties)) ? 1 : 0;
         case Equal:
            return (left == null && right == null || !(left == null || right == null) && left.eval(properties).equals(right.eval(properties))) ? 1 : 0;
         case GT:
            return (left.asDouble(properties) > right.asDouble(properties)) ? 1 : 0;
         case GTE:
            return (left.asDouble(properties) >= right.asDouble(properties)) ? 1 : 0;
         case LT:
            return (left.asDouble(properties) < right.asDouble(properties)) ? 1 : 0;
         case LTE:
            return (left.asDouble(properties) <= right.asDouble(properties)) ? 1 : 0;
         case Mod:
            return left.asInt(properties) % right.asInt(properties);
         case NotEqual:
            return (left == null && right == null || !(left == null || right == null) && left.eval(properties).equals(right.eval(properties))) ? 0 : 1;
         case Or:
            return left.asInt(properties) | right.asInt(properties);
         case SHIFT_LEFT:
            return left.asInt(properties) << right.asInt(properties);
         case SHIFT_RIGHT:
            return left.asInt(properties) >> right.asInt(properties);
         case U_SHIFT_RIGHT:
            return left.asInt(properties) >> right.asInt(properties);
         case XOr:
            return left.asInt(properties) ^ right.asInt(properties);
         case Plus:
            Type t = getType(properties);
            if (t == Type.String) {
               return Integer.parseInt(left.asString(properties) + right.asString(properties));
            }
            if (t == Type.Double) {
               return (long) (left.asDouble(properties) + right.asDouble(properties));
            }
            if (t == Type.Float) {
               return (long) (left.asFloat(properties) + right.asFloat(properties));
            }
            return left.asInt(properties) + right.asInt(properties);
         case Minus:
            t = getType(properties);
            if (t == Type.Double) {
               return (long) (left.asDouble(properties) - right.asDouble(properties));
            }
            if (t == Type.Float) {
               return (long) (left.asFloat(properties) - right.asFloat(properties));
            }
            return left.asInt(properties) - right.asInt(properties);
         case Divide:
            t = getType(properties);
            if (t == Type.Double) {
               return (long) (left.asDouble(properties) / right.asDouble(properties));
            }
            if (t == Type.Float) {
               return (long) (left.asFloat(properties) / right.asFloat(properties));
            }
            return left.asInt(properties) / right.asInt(properties);
         case Times:
            t = getType(properties);
            if (t == Type.Double) {
               return (long) (left.asDouble(properties) * right.asDouble(properties));
            }
            if (t == Type.Float) {
               return (long) (left.asFloat(properties) * right.asFloat(properties));
            }
            return left.asInt(properties) * right.asInt(properties);
      }
      return 0;
   }

   @Override
   public String asString(TemplateProperties properties) throws ExpressionEvaluationException {
      switch (operator) {
         case And:
            return "" + (left.asInt(properties) & right.asInt(properties));
         case ConditionalAnd:
            return "" + (left.asBoolean(properties) && right.asBoolean(properties));
         case ConditionalOr:
            return "" + (left.asBoolean(properties) || right.asBoolean(properties));
         case Equal:
            return "" + (left == null && right == null || !(left == null || right == null) && left.eval(properties).equals(right.eval(properties)));
         case GT:
            return "" + (left.asDouble(properties) > right.asDouble(properties));
         case GTE:
            return "" + (left.asDouble(properties) >= right.asDouble(properties));
         case LT:
            return "" + (left.asDouble(properties) < right.asDouble(properties));
         case LTE:
            return "" + (left.asDouble(properties) <= right.asDouble(properties));
         case Mod:
            return "" + (left.asInt(properties) % right.asInt(properties));
         case NotEqual:
            return "" + (!(left == null && right == null || !(left == null || right == null) && left.eval(properties).equals(right.eval(properties))));
         case Or:
            return "" + (left.asInt(properties) | right.asInt(properties));
         case SHIFT_LEFT:
            return "" + (left.asInt(properties) << right.asInt(properties));
         case SHIFT_RIGHT:
            return "" + (left.asInt(properties) >> right.asInt(properties));
         case U_SHIFT_RIGHT:
            return "" + (left.asInt(properties) >> right.asInt(properties));
         case XOr:
            return "" + (left.asInt(properties) ^ right.asInt(properties));
         case Plus:
            Type t = getType(properties);
            if (t == Type.String) {
               return left.asString(properties) + right.asString(properties);
            }
            if (t == Type.Double) {
               return "" + (left.asDouble(properties) + right.asDouble(properties));
            }
            if (t == Type.Float) {
               return "" + (left.asFloat(properties) + right.asFloat(properties));
            }
            return "" + (left.asInt(properties) + right.asInt(properties));
         case Minus:
            t = getType(properties);
            if (t == Type.Double) {
               return "" + (left.asDouble(properties) - right.asDouble(properties));
            }
            if (t == Type.Float) {
               return "" + (left.asFloat(properties) - right.asFloat(properties));
            }
            return "" + (left.asInt(properties) - right.asInt(properties));
         case Divide:
            t = getType(properties);
            if (t == Type.Double) {
               return "" + (left.asDouble(properties) / right.asDouble(properties));
            }
            if (t == Type.Float) {
               return "" + (left.asFloat(properties) / right.asFloat(properties));
            }
            return "" + (left.asInt(properties) / right.asInt(properties));
         case Times:
            t = getType(properties);
            if (t == Type.Double) {
               return "" + (left.asDouble(properties) * right.asDouble(properties));
            }
            if (t == Type.Float) {
               return "" + (left.asFloat(properties) * right.asFloat(properties));
            }
            return "" + (left.asInt(properties) * right.asInt(properties));
      }

      return null;
   }
}
