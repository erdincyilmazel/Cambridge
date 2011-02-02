package cambridge.parser.expressions;

import cambridge.ExpressionEvaluationException;

import java.util.Map;


/**
 * An CambridgeExpression with two operands
 */
public class BinaryExpression implements CambridgeExpression {
   private final Operator operator;
   private final CambridgeExpression left;
   private final CambridgeExpression right;

   public BinaryExpression(Operator operator, CambridgeExpression left, CambridgeExpression right) {
      this.operator = operator;
      this.left = left;
      this.right = right;
   }

   public Type getType(Map<String, Object> bindings) throws ExpressionEvaluationException {
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
            Type lt = left.getType(bindings);
            Type rt = right.getType(bindings);
            if (lt == Type.Double || rt == Type.Double) {
               return Type.Double;
            }
            if (lt == Type.Float || rt == Type.Float) {
               return Type.Float;
            }
            return Type.Int;
         case Plus:
            lt = left.getType(bindings);
            rt = right.getType(bindings);
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

   public Object eval(Map<String, Object> bindings) throws ExpressionEvaluationException {
      switch (operator) {
         case And:
            return left.asInt(bindings) & right.asInt(bindings);
         case ConditionalAnd:
            return left.asBoolean(bindings) && right.asBoolean(bindings);
         case ConditionalOr:
            return left.asBoolean(bindings) || right.asBoolean(bindings);
         case Equal:
            return left == null && right == null || !(left == null || right == null) && left.eval(bindings).equals(right.eval(bindings));
         case GT:
            return left.asDouble(bindings) > right.asDouble(bindings);
         case GTE:
            return left.asDouble(bindings) >= right.asDouble(bindings);
         case LT:
            return left.asDouble(bindings) < right.asDouble(bindings);
         case LTE:
            return left.asDouble(bindings) <= right.asDouble(bindings);
         case Mod:
            return left.asInt(bindings) % right.asInt(bindings);
         case NotEqual:
            return !(left == null && right == null || !(left == null || right == null) && left.eval(bindings).equals(right.eval(bindings)));
         case Or:
            return left.asInt(bindings) | right.asInt(bindings);
         case SHIFT_LEFT:
            return left.asInt(bindings) << right.asInt(bindings);
         case SHIFT_RIGHT:
            return left.asInt(bindings) >> right.asInt(bindings);
         case U_SHIFT_RIGHT:
            return left.asInt(bindings) >> right.asInt(bindings);
         case XOr:
            return left.asInt(bindings) ^ right.asInt(bindings);
         case Plus:
            Type t = getType(bindings);
            if (t == Type.String) {
               return left.asString(bindings) + right.asString(bindings);
            }
            if (t == Type.Double) {
               return left.asDouble(bindings) + right.asDouble(bindings);
            }
            if (t == Type.Float) {
               return left.asFloat(bindings) + right.asFloat(bindings);
            }
            return left.asInt(bindings) + right.asInt(bindings);
         case Minus:
            t = getType(bindings);
            if (t == Type.Double) {
               return left.asDouble(bindings) - right.asDouble(bindings);
            }
            if (t == Type.Float) {
               return left.asFloat(bindings) - right.asFloat(bindings);
            }
            return left.asInt(bindings) - right.asInt(bindings);
         case Divide:
            t = getType(bindings);
            if (t == Type.Double) {
               return left.asDouble(bindings) / right.asDouble(bindings);
            }
            if (t == Type.Float) {
               return left.asFloat(bindings) / right.asFloat(bindings);
            }
            return left.asInt(bindings) / right.asInt(bindings);
         case Times:
            t = getType(bindings);
            if (t == Type.Double) {
               return left.asDouble(bindings) * right.asDouble(bindings);
            }
            if (t == Type.Float) {
               return left.asFloat(bindings) * right.asFloat(bindings);
            }
            return left.asInt(bindings) * right.asInt(bindings);
      }

      return null;
   }

   public boolean asBoolean(Map<String, Object> bindings) throws ExpressionEvaluationException {
      switch (operator) {
         case And:
            return (left.asInt(bindings) & right.asInt(bindings)) != 0;
         case ConditionalAnd:
            return left.asBoolean(bindings) && right.asBoolean(bindings);
         case ConditionalOr:
            return left.asBoolean(bindings) || right.asBoolean(bindings);
         case Equal:
            return areEqual(bindings);
         case GT:
            return left.asDouble(bindings) > right.asDouble(bindings);
         case GTE:
            return left.asDouble(bindings) >= right.asDouble(bindings);
         case LT:
            return left.asDouble(bindings) < right.asDouble(bindings);
         case LTE:
            return left.asDouble(bindings) <= right.asDouble(bindings);
         case Mod:
            return (left.asInt(bindings) % right.asInt(bindings)) != 0;
         case NotEqual:
            return !areEqual(bindings);
         case Or:
            return (left.asInt(bindings) | right.asInt(bindings)) != 0;
         case SHIFT_LEFT:
            return (left.asInt(bindings) << right.asInt(bindings)) != 0;
         case SHIFT_RIGHT:
            return (left.asInt(bindings) >> right.asInt(bindings)) != 0;
         case U_SHIFT_RIGHT:
            return (left.asInt(bindings) >> right.asInt(bindings)) != 0;
         case XOr:
            return (left.asInt(bindings) ^ right.asInt(bindings)) != 0;
         case Plus:
            Type t = getType(bindings);
            if (t == Type.String) {
               return !(left.asString(bindings) + right.asString(bindings)).equals("");
            }
            if (t == Type.Double) {
               return (left.asDouble(bindings) + right.asDouble(bindings)) != 0;
            }
            if (t == Type.Float) {
               return (left.asFloat(bindings) + right.asFloat(bindings)) != 0;
            }
            return (left.asInt(bindings) + right.asInt(bindings)) != 0;
         case Minus:
            t = getType(bindings);
            if (t == Type.Double) {
               return (left.asDouble(bindings) - right.asDouble(bindings)) != 0;
            }
            if (t == Type.Float) {
               return (left.asFloat(bindings) - right.asFloat(bindings)) != 0;
            }
            return (left.asInt(bindings) - right.asInt(bindings)) != 0;
         case Divide:
            t = getType(bindings);
            if (t == Type.Double) {
               return (left.asDouble(bindings) / right.asDouble(bindings)) != 0;
            }
            if (t == Type.Float) {
               return (left.asFloat(bindings) / right.asFloat(bindings)) != 0;
            }
            return (left.asInt(bindings) / right.asInt(bindings)) != 0;
         case Times:
            t = getType(bindings);
            if (t == Type.Double) {
               return (left.asDouble(bindings) * right.asDouble(bindings)) != 0;
            }
            if (t == Type.Float) {
               return (left.asFloat(bindings) * right.asFloat(bindings)) != 0;
            }
            return (left.asInt(bindings) * right.asInt(bindings)) != 0;
      }

      return false;
   }

   private boolean areEqual(Map<String, Object> bindings) throws ExpressionEvaluationException {
      Object l = left.eval(bindings);
      Object r = right.eval(bindings);

      return l == null && r == null || !(l == null || r == null) && l.equals(r);
   }

   public int asInt(Map<String, Object> bindings) throws ExpressionEvaluationException {
      switch (operator) {
         case And:
            return left.asInt(bindings) & right.asInt(bindings);
         case ConditionalAnd:
            return (left.asBoolean(bindings) && right.asBoolean(bindings)) ? 1 : 0;
         case ConditionalOr:
            return (left.asBoolean(bindings) || right.asBoolean(bindings)) ? 1 : 0;
         case Equal:
            return (left == null && right == null || !(left == null || right == null) && left.eval(bindings).equals(right.eval(bindings))) ? 1 : 0;
         case GT:
            return (left.asDouble(bindings) > right.asDouble(bindings)) ? 1 : 0;
         case GTE:
            return (left.asDouble(bindings) >= right.asDouble(bindings)) ? 1 : 0;
         case LT:
            return (left.asDouble(bindings) < right.asDouble(bindings)) ? 1 : 0;
         case LTE:
            return (left.asDouble(bindings) <= right.asDouble(bindings)) ? 1 : 0;
         case Mod:
            return left.asInt(bindings) % right.asInt(bindings);
         case NotEqual:
            return (left == null && right == null || !(left == null || right == null) && left.eval(bindings).equals(right.eval(bindings))) ? 0 : 1;
         case Or:
            return left.asInt(bindings) | right.asInt(bindings);
         case SHIFT_LEFT:
            return left.asInt(bindings) << right.asInt(bindings);
         case SHIFT_RIGHT:
            return left.asInt(bindings) >> right.asInt(bindings);
         case U_SHIFT_RIGHT:
            return left.asInt(bindings) >> right.asInt(bindings);
         case XOr:
            return left.asInt(bindings) ^ right.asInt(bindings);
         case Plus:
            Type t = getType(bindings);
            if (t == Type.String) {
               return Integer.parseInt(left.asString(bindings) + right.asString(bindings));
            }
            if (t == Type.Double) {
               return (int) (left.asDouble(bindings) + right.asDouble(bindings));
            }
            if (t == Type.Float) {
               return (int) (left.asFloat(bindings) + right.asFloat(bindings));
            }
            return left.asInt(bindings) + right.asInt(bindings);
         case Minus:
            t = getType(bindings);
            if (t == Type.Double) {
               return (int) (left.asDouble(bindings) - right.asDouble(bindings));
            }
            if (t == Type.Float) {
               return (int) (left.asFloat(bindings) - right.asFloat(bindings));
            }
            return left.asInt(bindings) - right.asInt(bindings);
         case Divide:
            t = getType(bindings);
            if (t == Type.Double) {
               return (int) (left.asDouble(bindings) / right.asDouble(bindings));
            }
            if (t == Type.Float) {
               return (int) (left.asFloat(bindings) / right.asFloat(bindings));
            }
            return left.asInt(bindings) / right.asInt(bindings);
         case Times:
            t = getType(bindings);
            if (t == Type.Double) {
               return (int) (left.asDouble(bindings) * right.asDouble(bindings));
            }
            if (t == Type.Float) {
               return (int) (left.asFloat(bindings) * right.asFloat(bindings));
            }
            return left.asInt(bindings) * right.asInt(bindings);
      }

      return 0;
   }

   public float asFloat(Map<String, Object> bindings) throws ExpressionEvaluationException {
      switch (operator) {
         case And:
            return left.asInt(bindings) & right.asInt(bindings);
         case ConditionalAnd:
            return (left.asBoolean(bindings) && right.asBoolean(bindings)) ? 1 : 0;
         case ConditionalOr:
            return (left.asBoolean(bindings) || right.asBoolean(bindings)) ? 1 : 0;
         case Equal:
            return (left == null && right == null || !(left == null || right == null) && left.eval(bindings).equals(right.eval(bindings))) ? 1 : 0;
         case GT:
            return (left.asDouble(bindings) > right.asDouble(bindings)) ? 1 : 0;
         case GTE:
            return (left.asDouble(bindings) >= right.asDouble(bindings)) ? 1 : 0;
         case LT:
            return (left.asDouble(bindings) < right.asDouble(bindings)) ? 1 : 0;
         case LTE:
            return (left.asDouble(bindings) <= right.asDouble(bindings)) ? 1 : 0;
         case Mod:
            return left.asInt(bindings) % right.asInt(bindings);
         case NotEqual:
            return (left == null && right == null || !(left == null || right == null) && left.eval(bindings).equals(right.eval(bindings))) ? 0 : 1;
         case Or:
            return left.asInt(bindings) | right.asInt(bindings);
         case SHIFT_LEFT:
            return left.asInt(bindings) << right.asInt(bindings);
         case SHIFT_RIGHT:
            return left.asInt(bindings) >> right.asInt(bindings);
         case U_SHIFT_RIGHT:
            return left.asInt(bindings) >> right.asInt(bindings);
         case XOr:
            return left.asInt(bindings) ^ right.asInt(bindings);
         case Plus:
            Type t = getType(bindings);
            if (t == Type.String) {
               return Integer.parseInt(left.asString(bindings) + right.asString(bindings));
            }
            if (t == Type.Double) {
               return (float) (left.asDouble(bindings) + right.asDouble(bindings));
            }
            if (t == Type.Float) {
               return (left.asFloat(bindings) + right.asFloat(bindings));
            }
            return left.asInt(bindings) + right.asInt(bindings);
         case Minus:
            t = getType(bindings);
            if (t == Type.Double) {
               return (float) (left.asDouble(bindings) - right.asDouble(bindings));
            }
            if (t == Type.Float) {
               return (left.asFloat(bindings) - right.asFloat(bindings));
            }
            return left.asInt(bindings) - right.asInt(bindings);
         case Divide:
            t = getType(bindings);
            if (t == Type.Double) {
               return (float) (left.asDouble(bindings) / right.asDouble(bindings));
            }
            if (t == Type.Float) {
               return (left.asFloat(bindings) / right.asFloat(bindings));
            }
            return left.asInt(bindings) / right.asInt(bindings);
         case Times:
            t = getType(bindings);
            if (t == Type.Double) {
               return (float) (left.asDouble(bindings) * right.asDouble(bindings));
            }
            if (t == Type.Float) {
               return (left.asFloat(bindings) * right.asFloat(bindings));
            }
            return left.asInt(bindings) * right.asInt(bindings);
      }

      return 0;
   }

   public double asDouble(Map<String, Object> bindings) throws ExpressionEvaluationException {
      switch (operator) {
         case And:
            return left.asInt(bindings) & right.asInt(bindings);
         case ConditionalAnd:
            return (left.asBoolean(bindings) && right.asBoolean(bindings)) ? 1 : 0;
         case ConditionalOr:
            return (left.asBoolean(bindings) || right.asBoolean(bindings)) ? 1 : 0;
         case Equal:
            return (left == null && right == null || !(left == null || right == null) && left.eval(bindings).equals(right.eval(bindings))) ? 1 : 0;
         case GT:
            return (left.asDouble(bindings) > right.asDouble(bindings)) ? 1 : 0;
         case GTE:
            return (left.asDouble(bindings) >= right.asDouble(bindings)) ? 1 : 0;
         case LT:
            return (left.asDouble(bindings) < right.asDouble(bindings)) ? 1 : 0;
         case LTE:
            return (left.asDouble(bindings) <= right.asDouble(bindings)) ? 1 : 0;
         case Mod:
            return left.asInt(bindings) % right.asInt(bindings);
         case NotEqual:
            return (left == null && right == null || !(left == null || right == null) && left.eval(bindings).equals(right.eval(bindings))) ? 0 : 1;
         case Or:
            return left.asInt(bindings) | right.asInt(bindings);
         case SHIFT_LEFT:
            return left.asInt(bindings) << right.asInt(bindings);
         case SHIFT_RIGHT:
            return left.asInt(bindings) >> right.asInt(bindings);
         case U_SHIFT_RIGHT:
            return left.asInt(bindings) >> right.asInt(bindings);
         case XOr:
            return left.asInt(bindings) ^ right.asInt(bindings);
         case Plus:
            Type t = getType(bindings);
            if (t == Type.String) {
               return Integer.parseInt(left.asString(bindings) + right.asString(bindings));
            }
            if (t == Type.Double) {
               return (left.asDouble(bindings) + right.asDouble(bindings));
            }
            if (t == Type.Float) {
               return (left.asFloat(bindings) + right.asFloat(bindings));
            }
            return left.asInt(bindings) + right.asInt(bindings);
         case Minus:
            t = getType(bindings);
            if (t == Type.Double) {
               return (left.asDouble(bindings) - right.asDouble(bindings));
            }
            if (t == Type.Float) {
               return (left.asFloat(bindings) - right.asFloat(bindings));
            }
            return left.asInt(bindings) - right.asInt(bindings);
         case Divide:
            t = getType(bindings);
            if (t == Type.Double) {
               return (left.asDouble(bindings) / right.asDouble(bindings));
            }
            if (t == Type.Float) {
               return (left.asFloat(bindings) / right.asFloat(bindings));
            }
            return left.asInt(bindings) / right.asInt(bindings);
         case Times:
            t = getType(bindings);
            if (t == Type.Double) {
               return (left.asDouble(bindings) * right.asDouble(bindings));
            }
            if (t == Type.Float) {
               return (left.asFloat(bindings) * right.asFloat(bindings));
            }
            return left.asInt(bindings) * right.asInt(bindings);
      }

      return 0;
   }

   public long asLong(Map<String, Object> bindings) throws ExpressionEvaluationException {
      switch (operator) {
         case And:
            return left.asInt(bindings) & right.asInt(bindings);
         case ConditionalAnd:
            return (left.asBoolean(bindings) && right.asBoolean(bindings)) ? 1 : 0;
         case ConditionalOr:
            return (left.asBoolean(bindings) || right.asBoolean(bindings)) ? 1 : 0;
         case Equal:
            return (left == null && right == null || !(left == null || right == null) && left.eval(bindings).equals(right.eval(bindings))) ? 1 : 0;
         case GT:
            return (left.asDouble(bindings) > right.asDouble(bindings)) ? 1 : 0;
         case GTE:
            return (left.asDouble(bindings) >= right.asDouble(bindings)) ? 1 : 0;
         case LT:
            return (left.asDouble(bindings) < right.asDouble(bindings)) ? 1 : 0;
         case LTE:
            return (left.asDouble(bindings) <= right.asDouble(bindings)) ? 1 : 0;
         case Mod:
            return left.asInt(bindings) % right.asInt(bindings);
         case NotEqual:
            return (left == null && right == null || !(left == null || right == null) && left.eval(bindings).equals(right.eval(bindings))) ? 0 : 1;
         case Or:
            return left.asInt(bindings) | right.asInt(bindings);
         case SHIFT_LEFT:
            return left.asInt(bindings) << right.asInt(bindings);
         case SHIFT_RIGHT:
            return left.asInt(bindings) >> right.asInt(bindings);
         case U_SHIFT_RIGHT:
            return left.asInt(bindings) >> right.asInt(bindings);
         case XOr:
            return left.asInt(bindings) ^ right.asInt(bindings);
         case Plus:
            Type t = getType(bindings);
            if (t == Type.String) {
               return Integer.parseInt(left.asString(bindings) + right.asString(bindings));
            }
            if (t == Type.Double) {
               return (long) (left.asDouble(bindings) + right.asDouble(bindings));
            }
            if (t == Type.Float) {
               return (long) (left.asFloat(bindings) + right.asFloat(bindings));
            }
            return left.asInt(bindings) + right.asInt(bindings);
         case Minus:
            t = getType(bindings);
            if (t == Type.Double) {
               return (long) (left.asDouble(bindings) - right.asDouble(bindings));
            }
            if (t == Type.Float) {
               return (long) (left.asFloat(bindings) - right.asFloat(bindings));
            }
            return left.asInt(bindings) - right.asInt(bindings);
         case Divide:
            t = getType(bindings);
            if (t == Type.Double) {
               return (long) (left.asDouble(bindings) / right.asDouble(bindings));
            }
            if (t == Type.Float) {
               return (long) (left.asFloat(bindings) / right.asFloat(bindings));
            }
            return left.asInt(bindings) / right.asInt(bindings);
         case Times:
            t = getType(bindings);
            if (t == Type.Double) {
               return (long) (left.asDouble(bindings) * right.asDouble(bindings));
            }
            if (t == Type.Float) {
               return (long) (left.asFloat(bindings) * right.asFloat(bindings));
            }
            return left.asInt(bindings) * right.asInt(bindings);
      }
      return 0;
   }

   public String asString(Map<String, Object> bindings) throws ExpressionEvaluationException {
      switch (operator) {
         case And:
            return "" + (left.asInt(bindings) & right.asInt(bindings));
         case ConditionalAnd:
            return "" + (left.asBoolean(bindings) && right.asBoolean(bindings));
         case ConditionalOr:
            return "" + (left.asBoolean(bindings) || right.asBoolean(bindings));
         case Equal:
            return "" + (left == null && right == null || !(left == null || right == null) && left.eval(bindings).equals(right.eval(bindings)));
         case GT:
            return "" + (left.asDouble(bindings) > right.asDouble(bindings));
         case GTE:
            return "" + (left.asDouble(bindings) >= right.asDouble(bindings));
         case LT:
            return "" + (left.asDouble(bindings) < right.asDouble(bindings));
         case LTE:
            return "" + (left.asDouble(bindings) <= right.asDouble(bindings));
         case Mod:
            return "" + (left.asInt(bindings) % right.asInt(bindings));
         case NotEqual:
            return "" + (!(left == null && right == null || !(left == null || right == null) && left.eval(bindings).equals(right.eval(bindings))));
         case Or:
            return "" + (left.asInt(bindings) | right.asInt(bindings));
         case SHIFT_LEFT:
            return "" + (left.asInt(bindings) << right.asInt(bindings));
         case SHIFT_RIGHT:
            return "" + (left.asInt(bindings) >> right.asInt(bindings));
         case U_SHIFT_RIGHT:
            return "" + (left.asInt(bindings) >> right.asInt(bindings));
         case XOr:
            return "" + (left.asInt(bindings) ^ right.asInt(bindings));
         case Plus:
            Type t = getType(bindings);
            if (t == Type.String) {
               return left.asString(bindings) + right.asString(bindings);
            }
            if (t == Type.Double) {
               return "" + (left.asDouble(bindings) + right.asDouble(bindings));
            }
            if (t == Type.Float) {
               return "" + (left.asFloat(bindings) + right.asFloat(bindings));
            }
            return "" + (left.asInt(bindings) + right.asInt(bindings));
         case Minus:
            t = getType(bindings);
            if (t == Type.Double) {
               return "" + (left.asDouble(bindings) - right.asDouble(bindings));
            }
            if (t == Type.Float) {
               return "" + (left.asFloat(bindings) - right.asFloat(bindings));
            }
            return "" + (left.asInt(bindings) - right.asInt(bindings));
         case Divide:
            t = getType(bindings);
            if (t == Type.Double) {
               return "" + (left.asDouble(bindings) / right.asDouble(bindings));
            }
            if (t == Type.Float) {
               return "" + (left.asFloat(bindings) / right.asFloat(bindings));
            }
            return "" + (left.asInt(bindings) / right.asInt(bindings));
         case Times:
            t = getType(bindings);
            if (t == Type.Double) {
               return "" + (left.asDouble(bindings) * right.asDouble(bindings));
            }
            if (t == Type.Float) {
               return "" + (left.asFloat(bindings) * right.asFloat(bindings));
            }
            return "" + (left.asInt(bindings) * right.asInt(bindings));
      }

      return null;
   }
}
