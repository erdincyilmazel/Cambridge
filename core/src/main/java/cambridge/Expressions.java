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
   private static ExpressionLanguage cambridgeExpressionLanguage = new CambridgeExpressionLanguage();

   public static final String CURRENT_OBJECT = "self";
   public static final String PARENT_OBJECT = "parent";
   public static final String ITER_OBJECT = "iter";

   private static final HashMap<String, ExpressionLanguage> expressionLanguages = new HashMap<String, ExpressionLanguage>();
   private static final HashMap<String, Class<? extends ExpressionLanguage>> expressionLanguageClasses =
      new HashMap<String, Class<? extends ExpressionLanguage>>();

   static {
      expressionLanguages.put("cambridge", new CambridgeExpressionLanguage());
   }

   public static Expression parse(String ex) throws ExpressionParsingException {
      return cambridgeExpressionLanguage.parse(ex);
   }

   public static Expression parse(String ex, String expressionLanguage) throws ExpressionParsingException {
      ExpressionLanguage language = getExpressionLanguageByName(expressionLanguage);
      return language.parse(ex);
   }

   public static ExpressionLanguage getDefaultExpressionLanguage() {
      return cambridgeExpressionLanguage;
   }

   public static synchronized void registerExpressionLanguage(String name, Class<? extends ExpressionLanguage> clazz) {
      expressionLanguageClasses.put(name, clazz);
   }

   public static synchronized ExpressionLanguage getExpressionLanguageByName(String name) throws ExpressionParsingException {
      ExpressionLanguage language = expressionLanguages.get(name);
      if (language != null) {
         return language;
      }

      Class<? extends ExpressionLanguage> expressionLangClass = expressionLanguageClasses.get(name);

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
