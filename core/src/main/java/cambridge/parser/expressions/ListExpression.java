package cambridge.parser.expressions;

import cambridge.ExpressionEvaluationException;
import cambridge.runtime.TemplateProperties;

import java.util.ArrayList;

/**
 * User: Erdinc
 * Date: Apr 12, 2010
 * Time: 11:52:13 PM
 */
public class ListExpression extends ArrayList implements Expression {
   public Type getType(TemplateProperties globals) throws ExpressionEvaluationException {
      return Type.Object;
   }

   public Object eval(TemplateProperties globals) throws ExpressionEvaluationException {
      return this;
   }

   public boolean asBoolean(TemplateProperties globals) throws ExpressionEvaluationException {
      return false;
   }

   public int asInt(TemplateProperties globals) throws ExpressionEvaluationException {
      return 0;
   }

   public float asFloat(TemplateProperties globals) throws ExpressionEvaluationException {
      return 0;
   }

   public double asDouble(TemplateProperties globals) throws ExpressionEvaluationException {
      return 0;
   }

   public long asLong(TemplateProperties globals) throws ExpressionEvaluationException {
      return 0;
   }

   public String asString(TemplateProperties globals) throws ExpressionEvaluationException {
      return toString();
   }
}
