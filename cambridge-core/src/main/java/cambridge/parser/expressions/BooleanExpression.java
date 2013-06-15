package cambridge.parser.expressions;

import cambridge.ExpressionEvaluationException;
import cambridge.runtime.ExpressionContext;


/**
 * An CambridgeExpression with two operands
 */
public class BooleanExpression implements CambridgeExpression {
   private final Operator operator;
   private final CambridgeExpression left;
   private final CambridgeExpression right;

   public BooleanExpression(Operator operator, CambridgeExpression left, CambridgeExpression right) {
      this.operator = operator;
      this.left = left;
      this.right = right;
   }

   public Type getType(ExpressionContext context) throws ExpressionEvaluationException {
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
            return Type.Double;
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
            Type lt = left.getType(context);
            Type rt = right.getType(context);
            if (lt == Type.Double || rt == Type.Double) {
               return Type.Double;
            }
            if (lt == Type.Float || rt == Type.Float) {
               return Type.Float;
            }
            return Type.Int;
         case Plus:
            lt = left.getType(context);
            rt = right.getType(context);
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

   public Object eval(ExpressionContext context) throws ExpressionEvaluationException {
      switch (operator) {
         case And:
            return left.asInt(context) & right.asInt(context);
         case ConditionalAnd:
            return left.asBoolean(context) && right.asBoolean(context);
         case ConditionalOr:
            return left.asBoolean(context) || right.asBoolean(context);
         case Equal:
            return left == null && right == null || !(left == null || right == null) && left.eval(context).equals(right.eval(context));
         case GT:
            return left.asDouble(context) > right.asDouble(context);
         case GTE:
            return left.asDouble(context) >= right.asDouble(context);
         case LT:
            return left.asDouble(context) < right.asDouble(context);
         case LTE:
            return left.asDouble(context) <= right.asDouble(context);
         case Mod:
            return left.asDouble(context) % right.asDouble(context);
         case NotEqual:
            return !(left == null && right == null || !(left == null || right == null) && left.eval(context).equals(right.eval(context)));
         case Or:
            return left.asInt(context) | right.asInt(context);
         case SHIFT_LEFT:
            return left.asInt(context) << right.asInt(context);
         case SHIFT_RIGHT:
            return left.asInt(context) >> right.asInt(context);
         case U_SHIFT_RIGHT:
            return left.asInt(context) >> right.asInt(context);
         case XOr:
            return left.asInt(context) ^ right.asInt(context);
         case Plus:
            Type t = getType(context);
            if (t == Type.String) {
               return left.asString(context) + right.asString(context);
            }
            if (t == Type.Double) {
               return left.asDouble(context) + right.asDouble(context);
            }
            if (t == Type.Float) {
               return left.asFloat(context) + right.asFloat(context);
            }
            return left.asInt(context) + right.asInt(context);
         case Minus:
            t = getType(context);
            if (t == Type.Double) {
               return left.asDouble(context) - right.asDouble(context);
            }
            if (t == Type.Float) {
               return left.asFloat(context) - right.asFloat(context);
            }
            return left.asInt(context) - right.asInt(context);
         case Divide:
            t = getType(context);
            if (t == Type.Double) {
               return left.asDouble(context) / right.asDouble(context);
            }
            if (t == Type.Float) {
               return left.asFloat(context) / right.asFloat(context);
            }
            return left.asInt(context) / right.asInt(context);
         case Times:
            t = getType(context);
            if (t == Type.Double) {
               return left.asDouble(context) * right.asDouble(context);
            }
            if (t == Type.Float) {
               return left.asFloat(context) * right.asFloat(context);
            }
            return left.asInt(context) * right.asInt(context);
      }

      return null;
   }

   public boolean asBoolean(ExpressionContext context) throws ExpressionEvaluationException {
      switch (operator) {
         case And:
            return (left.asInt(context) & right.asInt(context)) != 0;
         case ConditionalAnd:
            return left.asBoolean(context) && right.asBoolean(context);
         case ConditionalOr:
            return left.asBoolean(context) || right.asBoolean(context);
         case Equal:
            return areEqual(context);
         case GT:
            return left.asDouble(context) > right.asDouble(context);
         case GTE:
            return left.asDouble(context) >= right.asDouble(context);
         case LT:
            return left.asDouble(context) < right.asDouble(context);
         case LTE:
            return left.asDouble(context) <= right.asDouble(context);
         case Mod:
            return (left.asDouble(context) % right.asDouble(context)) != 0;
         case NotEqual:
            return !areEqual(context);
         case Or:
            return (left.asInt(context) | right.asInt(context)) != 0;
         case SHIFT_LEFT:
            return (left.asInt(context) << right.asInt(context)) != 0;
         case SHIFT_RIGHT:
            return (left.asInt(context) >> right.asInt(context)) != 0;
         case U_SHIFT_RIGHT:
            return (left.asInt(context) >> right.asInt(context)) != 0;
         case XOr:
            return (left.asInt(context) ^ right.asInt(context)) != 0;
         case Plus:
            Type t = getType(context);
            if (t == Type.String) {
               return !(left.asString(context) + right.asString(context)).equals("");
            }
            if (t == Type.Double) {
               return (left.asDouble(context) + right.asDouble(context)) != 0;
            }
            if (t == Type.Float) {
               return (left.asFloat(context) + right.asFloat(context)) != 0;
            }
            return (left.asInt(context) + right.asInt(context)) != 0;
         case Minus:
            t = getType(context);
            if (t == Type.Double) {
               return (left.asDouble(context) - right.asDouble(context)) != 0;
            }
            if (t == Type.Float) {
               return (left.asFloat(context) - right.asFloat(context)) != 0;
            }
            return (left.asInt(context) - right.asInt(context)) != 0;
         case Divide:
            t = getType(context);
            if (t == Type.Double) {
               return (left.asDouble(context) / right.asDouble(context)) != 0;
            }
            if (t == Type.Float) {
               return (left.asFloat(context) / right.asFloat(context)) != 0;
            }
            return (left.asInt(context) / right.asInt(context)) != 0;
         case Times:
            t = getType(context);
            if (t == Type.Double) {
               return (left.asDouble(context) * right.asDouble(context)) != 0;
            }
            if (t == Type.Float) {
               return (left.asFloat(context) * right.asFloat(context)) != 0;
            }
            return (left.asInt(context) * right.asInt(context)) != 0;
      }

      return false;
   }

   private boolean areEqual(ExpressionContext context) throws ExpressionEvaluationException {
      Object l = left.eval(context);
      Object r = right.eval(context);

      return l == null && r == null || !(l == null || r == null) && l.equals(r);
   }

   public int asInt(ExpressionContext context) throws ExpressionEvaluationException {
      switch (operator) {
         case And:
            return left.asInt(context) & right.asInt(context);
         case ConditionalAnd:
            return (left.asBoolean(context) && right.asBoolean(context)) ? 1 : 0;
         case ConditionalOr:
            return (left.asBoolean(context) || right.asBoolean(context)) ? 1 : 0;
         case Equal:
            return (left == null && right == null || !(left == null || right == null) && left.eval(context).equals(right.eval(context))) ? 1 : 0;
         case GT:
            return (left.asDouble(context) > right.asDouble(context)) ? 1 : 0;
         case GTE:
            return (left.asDouble(context) >= right.asDouble(context)) ? 1 : 0;
         case LT:
            return (left.asDouble(context) < right.asDouble(context)) ? 1 : 0;
         case LTE:
            return (left.asDouble(context) <= right.asDouble(context)) ? 1 : 0;
         case Mod:
            return (int) (left.asDouble(context) % right.asDouble(context));
         case NotEqual:
            return (left == null && right == null || !(left == null || right == null) && left.eval(context).equals(right.eval(context))) ? 0 : 1;
         case Or:
            return left.asInt(context) | right.asInt(context);
         case SHIFT_LEFT:
            return left.asInt(context) << right.asInt(context);
         case SHIFT_RIGHT:
            return left.asInt(context) >> right.asInt(context);
         case U_SHIFT_RIGHT:
            return left.asInt(context) >> right.asInt(context);
         case XOr:
            return left.asInt(context) ^ right.asInt(context);
         case Plus:
            Type t = getType(context);
            if (t == Type.String) {
               return Integer.parseInt(left.asString(context) + right.asString(context));
            }
            if (t == Type.Double) {
               return (int) (left.asDouble(context) + right.asDouble(context));
            }
            if (t == Type.Float) {
               return (int) (left.asFloat(context) + right.asFloat(context));
            }
            return left.asInt(context) + right.asInt(context);
         case Minus:
            t = getType(context);
            if (t == Type.Double) {
               return (int) (left.asDouble(context) - right.asDouble(context));
            }
            if (t == Type.Float) {
               return (int) (left.asFloat(context) - right.asFloat(context));
            }
            return left.asInt(context) - right.asInt(context);
         case Divide:
            t = getType(context);
            if (t == Type.Double) {
               return (int) (left.asDouble(context) / right.asDouble(context));
            }
            if (t == Type.Float) {
               return (int) (left.asFloat(context) / right.asFloat(context));
            }
            return left.asInt(context) / right.asInt(context);
         case Times:
            t = getType(context);
            if (t == Type.Double) {
               return (int) (left.asDouble(context) * right.asDouble(context));
            }
            if (t == Type.Float) {
               return (int) (left.asFloat(context) * right.asFloat(context));
            }
            return left.asInt(context) * right.asInt(context);
      }

      return 0;
   }

   public float asFloat(ExpressionContext context) throws ExpressionEvaluationException {
      switch (operator) {
         case And:
            return left.asInt(context) & right.asInt(context);
         case ConditionalAnd:
            return (left.asBoolean(context) && right.asBoolean(context)) ? 1 : 0;
         case ConditionalOr:
            return (left.asBoolean(context) || right.asBoolean(context)) ? 1 : 0;
         case Equal:
            return (left == null && right == null || !(left == null || right == null) && left.eval(context).equals(right.eval(context))) ? 1 : 0;
         case GT:
            return (left.asDouble(context) > right.asDouble(context)) ? 1 : 0;
         case GTE:
            return (left.asDouble(context) >= right.asDouble(context)) ? 1 : 0;
         case LT:
            return (left.asDouble(context) < right.asDouble(context)) ? 1 : 0;
         case LTE:
            return (left.asDouble(context) <= right.asDouble(context)) ? 1 : 0;
         case Mod:
            return (float) (left.asDouble(context) % right.asDouble(context));
         case NotEqual:
            return (left == null && right == null || !(left == null || right == null) && left.eval(context).equals(right.eval(context))) ? 0 : 1;
         case Or:
            return left.asInt(context) | right.asInt(context);
         case SHIFT_LEFT:
            return left.asInt(context) << right.asInt(context);
         case SHIFT_RIGHT:
            return left.asInt(context) >> right.asInt(context);
         case U_SHIFT_RIGHT:
            return left.asInt(context) >> right.asInt(context);
         case XOr:
            return left.asInt(context) ^ right.asInt(context);
         case Plus:
            Type t = getType(context);
            if (t == Type.String) {
               return Integer.parseInt(left.asString(context) + right.asString(context));
            }
            if (t == Type.Double) {
               return (float) (left.asDouble(context) + right.asDouble(context));
            }
            if (t == Type.Float) {
               return (left.asFloat(context) + right.asFloat(context));
            }
            return left.asInt(context) + right.asInt(context);
         case Minus:
            t = getType(context);
            if (t == Type.Double) {
               return (float) (left.asDouble(context) - right.asDouble(context));
            }
            if (t == Type.Float) {
               return (left.asFloat(context) - right.asFloat(context));
            }
            return left.asInt(context) - right.asInt(context);
         case Divide:
            t = getType(context);
            if (t == Type.Double) {
               return (float) (left.asDouble(context) / right.asDouble(context));
            }
            if (t == Type.Float) {
               return (left.asFloat(context) / right.asFloat(context));
            }
            return left.asInt(context) / right.asInt(context);
         case Times:
            t = getType(context);
            if (t == Type.Double) {
               return (float) (left.asDouble(context) * right.asDouble(context));
            }
            if (t == Type.Float) {
               return (left.asFloat(context) * right.asFloat(context));
            }
            return left.asInt(context) * right.asInt(context);
      }

      return 0;
   }

   public double asDouble(ExpressionContext context) throws ExpressionEvaluationException {
      switch (operator) {
         case And:
            return left.asInt(context) & right.asInt(context);
         case ConditionalAnd:
            return (left.asBoolean(context) && right.asBoolean(context)) ? 1 : 0;
         case ConditionalOr:
            return (left.asBoolean(context) || right.asBoolean(context)) ? 1 : 0;
         case Equal:
            return (left == null && right == null || !(left == null || right == null) && left.eval(context).equals(right.eval(context))) ? 1 : 0;
         case GT:
            return (left.asDouble(context) > right.asDouble(context)) ? 1 : 0;
         case GTE:
            return (left.asDouble(context) >= right.asDouble(context)) ? 1 : 0;
         case LT:
            return (left.asDouble(context) < right.asDouble(context)) ? 1 : 0;
         case LTE:
            return (left.asDouble(context) <= right.asDouble(context)) ? 1 : 0;
         case Mod:
            return left.asDouble(context) % right.asDouble(context);
         case NotEqual:
            return (left == null && right == null || !(left == null || right == null) && left.eval(context).equals(right.eval(context))) ? 0 : 1;
         case Or:
            return left.asInt(context) | right.asInt(context);
         case SHIFT_LEFT:
            return left.asInt(context) << right.asInt(context);
         case SHIFT_RIGHT:
            return left.asInt(context) >> right.asInt(context);
         case U_SHIFT_RIGHT:
            return left.asInt(context) >> right.asInt(context);
         case XOr:
            return left.asInt(context) ^ right.asInt(context);
         case Plus:
            Type t = getType(context);
            if (t == Type.String) {
               return Integer.parseInt(left.asString(context) + right.asString(context));
            }
            if (t == Type.Double) {
               return (left.asDouble(context) + right.asDouble(context));
            }
            if (t == Type.Float) {
               return (left.asFloat(context) + right.asFloat(context));
            }
            return left.asInt(context) + right.asInt(context);
         case Minus:
            t = getType(context);
            if (t == Type.Double) {
               return (left.asDouble(context) - right.asDouble(context));
            }
            if (t == Type.Float) {
               return (left.asFloat(context) - right.asFloat(context));
            }
            return left.asInt(context) - right.asInt(context);
         case Divide:
            t = getType(context);
            if (t == Type.Double) {
               return (left.asDouble(context) / right.asDouble(context));
            }
            if (t == Type.Float) {
               return (left.asFloat(context) / right.asFloat(context));
            }
            return left.asInt(context) / right.asInt(context);
         case Times:
            t = getType(context);
            if (t == Type.Double) {
               return (left.asDouble(context) * right.asDouble(context));
            }
            if (t == Type.Float) {
               return (left.asFloat(context) * right.asFloat(context));
            }
            return left.asInt(context) * right.asInt(context);
      }

      return 0;
   }

   public long asLong(ExpressionContext context) throws ExpressionEvaluationException {
      switch (operator) {
         case And:
            return left.asInt(context) & right.asInt(context);
         case ConditionalAnd:
            return (left.asBoolean(context) && right.asBoolean(context)) ? 1 : 0;
         case ConditionalOr:
            return (left.asBoolean(context) || right.asBoolean(context)) ? 1 : 0;
         case Equal:
            return (left == null && right == null || !(left == null || right == null) && left.eval(context).equals(right.eval(context))) ? 1 : 0;
         case GT:
            return (left.asDouble(context) > right.asDouble(context)) ? 1 : 0;
         case GTE:
            return (left.asDouble(context) >= right.asDouble(context)) ? 1 : 0;
         case LT:
            return (left.asDouble(context) < right.asDouble(context)) ? 1 : 0;
         case LTE:
            return (left.asDouble(context) <= right.asDouble(context)) ? 1 : 0;
         case Mod:
            return (long) (left.asDouble(context) % right.asDouble(context));
         case NotEqual:
            return (left == null && right == null || !(left == null || right == null) && left.eval(context).equals(right.eval(context))) ? 0 : 1;
         case Or:
            return left.asInt(context) | right.asInt(context);
         case SHIFT_LEFT:
            return left.asInt(context) << right.asInt(context);
         case SHIFT_RIGHT:
            return left.asInt(context) >> right.asInt(context);
         case U_SHIFT_RIGHT:
            return left.asInt(context) >> right.asInt(context);
         case XOr:
            return left.asInt(context) ^ right.asInt(context);
         case Plus:
            Type t = getType(context);
            if (t == Type.String) {
               return Integer.parseInt(left.asString(context) + right.asString(context));
            }
            if (t == Type.Double) {
               return (long) (left.asDouble(context) + right.asDouble(context));
            }
            if (t == Type.Float) {
               return (long) (left.asFloat(context) + right.asFloat(context));
            }
            return left.asInt(context) + right.asInt(context);
         case Minus:
            t = getType(context);
            if (t == Type.Double) {
               return (long) (left.asDouble(context) - right.asDouble(context));
            }
            if (t == Type.Float) {
               return (long) (left.asFloat(context) - right.asFloat(context));
            }
            return left.asInt(context) - right.asInt(context);
         case Divide:
            t = getType(context);
            if (t == Type.Double) {
               return (long) (left.asDouble(context) / right.asDouble(context));
            }
            if (t == Type.Float) {
               return (long) (left.asFloat(context) / right.asFloat(context));
            }
            return left.asInt(context) / right.asInt(context);
         case Times:
            t = getType(context);
            if (t == Type.Double) {
               return (long) (left.asDouble(context) * right.asDouble(context));
            }
            if (t == Type.Float) {
               return (long) (left.asFloat(context) * right.asFloat(context));
            }
            return left.asInt(context) * right.asInt(context);
      }
      return 0;
   }

   public String asString(ExpressionContext context) throws ExpressionEvaluationException {
      switch (operator) {
         case And:
            return "" + (left.asInt(context) & right.asInt(context));
         case ConditionalAnd:
            return "" + (left.asBoolean(context) && right.asBoolean(context));
         case ConditionalOr:
            return "" + (left.asBoolean(context) || right.asBoolean(context));
         case Equal:
            return "" + (left == null && right == null || !(left == null || right == null) && left.eval(context).equals(right.eval(context)));
         case GT:
            return "" + (left.asDouble(context) > right.asDouble(context));
         case GTE:
            return "" + (left.asDouble(context) >= right.asDouble(context));
         case LT:
            return "" + (left.asDouble(context) < right.asDouble(context));
         case LTE:
            return "" + (left.asDouble(context) <= right.asDouble(context));
         case Mod:
            return "" + (left.asDouble(context) % right.asDouble(context));
         case NotEqual:
            return "" + (!(left == null && right == null || !(left == null || right == null) && left.eval(context).equals(right.eval(context))));
         case Or:
            return "" + (left.asInt(context) | right.asInt(context));
         case SHIFT_LEFT:
            return "" + (left.asInt(context) << right.asInt(context));
         case SHIFT_RIGHT:
            return "" + (left.asInt(context) >> right.asInt(context));
         case U_SHIFT_RIGHT:
            return "" + (left.asInt(context) >> right.asInt(context));
         case XOr:
            return "" + (left.asInt(context) ^ right.asInt(context));
         case Plus:
            Type t = getType(context);
            if (t == Type.String) {
               return left.asString(context) + right.asString(context);
            }
            if (t == Type.Double) {
               return "" + (left.asDouble(context) + right.asDouble(context));
            }
            if (t == Type.Float) {
               return "" + (left.asFloat(context) + right.asFloat(context));
            }
            return "" + (left.asInt(context) + right.asInt(context));
         case Minus:
            t = getType(context);
            if (t == Type.Double) {
               return "" + (left.asDouble(context) - right.asDouble(context));
            }
            if (t == Type.Float) {
               return "" + (left.asFloat(context) - right.asFloat(context));
            }
            return "" + (left.asInt(context) - right.asInt(context));
         case Divide:
            t = getType(context);
            if (t == Type.Double) {
               return "" + (left.asDouble(context) / right.asDouble(context));
            }
            if (t == Type.Float) {
               return "" + (left.asFloat(context) / right.asFloat(context));
            }
            return "" + (left.asInt(context) / right.asInt(context));
         case Times:
            t = getType(context);
            if (t == Type.Double) {
               return "" + (left.asDouble(context) * right.asDouble(context));
            }
            if (t == Type.Float) {
               return "" + (left.asFloat(context) * right.asFloat(context));
            }
            return "" + (left.asInt(context) * right.asInt(context));
      }

      return null;
   }
}
