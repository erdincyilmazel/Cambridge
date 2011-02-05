package cambridge;

import cambridge.model.Expression;
import cambridge.parser.expressions.CambridgeExpressionLanguage;

import java.util.HashMap;

/**
 * User: erdinc
 * Date: Nov 3, 2009
 * Time: 1:42:15 AM
 */
public class Expressions {
   private static ExpressionLanguage expressionLanguage = new CambridgeExpressionLanguage();

   public static final String CURRENT_OBJECT = "self";
   public static final String PARENT_OBJECT = "pafent";
   public static final String ITER_OBJECT = "iter";

   private static final HashMap<String, ExpressionLanguage> expressionLanguages = new HashMap<String, ExpressionLanguage>();
   private static final HashMap<String, Class<ExpressionLanguage>> expressionLanguageClasses = new HashMap<String, Class<ExpressionLanguage>>();

   static {
      expressionLanguages.put("Cambridge", new CambridgeExpressionLanguage());
   }

   public static Expression parse(String ex) throws ExpressionParsingException {
      return expressionLanguage.parse(ex);
   }

   public static ExpressionLanguage getDefaultExpressionLanguage() {
      return expressionLanguage;
   }

   public static synchronized ExpressionLanguage getExpressionLanguageByName(String name) throws ExpressionParsingException {
      ExpressionLanguage language = expressionLanguages.get(name);
      if (language != null) {
         return language;
      }

      Class<ExpressionLanguage> expressionLangClass = expressionLanguageClasses.get(name);

      if (expressionLangClass == null) {
         throw new ExpressionParsingException("Unknown expression language: " + name);
      }

      try {
         language = expressionLangClass.newInstance();
         expressionLanguages.put(name, language);
         return language;
      } catch (Exception e) {
         throw new ExpressionParsingException("Unable to initialize expression language " + name, e);
      }
   }
}
