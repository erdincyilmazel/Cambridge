package cambridge.parser.expressions;

import cambridge.ExpressionEvaluationException;
import cambridge.runtime.TemplateBindings;

import java.util.ArrayList;

/**
 * User: Erdinc
 * Date: Apr 12, 2010
 * Time: 11:52:13 PM
 */
public class ListExpression extends ArrayList implements Expression {
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
}
