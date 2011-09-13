package cambridge;

import cambridge.model.Expression;
import cambridge.parser.expressions.CambridgeExpressionLanguage;

import java.util.HashMap;

/**
 * Utility class to help with expression parsing.
 */
public class Expressions {
   private static ExpressionLanguage cambridgeExpressionLanguage = new CambridgeExpressionLanguage();
   private static ExpressionLanguage defaultExpressionLanguage = cambridgeExpressionLanguage;

   public static final String CURRENT_OBJECT = "self";
   public static final String PARENT_OBJECT = "parent";
   public static final String ITER_OBJECT = "iter";

   private static final HashMap<String, ExpressionLanguage> expressionLanguages = new HashMap<String, ExpressionLanguage>();
   private static final HashMap<String, Class<? extends ExpressionLanguage>> expressionLanguageClasses =
      new HashMap<String, Class<? extends ExpressionLanguage>>();

   static {
      expressionLanguages.put("cambridge", new CambridgeExpressionLanguage());
   }

   /**
    * Parses the expression string using the default expression language engine and creates an Expression
    * object.
    *
    * @param ex Expression string to be parsed
    * @param line Line no of the expression on the template
    * @param column Column no of the expression on the template
    * @return Returns compiled expression object.
    * @throws ExpressionParsingException Thrown if the expression can not be parsed
    */
   public static Expression parse(String ex, int line, int column) throws ExpressionParsingException {
      return defaultExpressionLanguage.parse(ex, line, column);
   }

   /**
    * Parses the expression string using the default expression language engine and creates an Expression
    * object.
    *
    * @param ex Expression string to be parsed
    * @return Returns compiled expression object.
    * @throws ExpressionParsingException Thrown if the expression can not be parsed
    */
   public static Expression parse(String ex) throws ExpressionParsingException {
      return defaultExpressionLanguage.parse(ex, 0, 0);
   }

   /**
    * Parses the expression string using the expression language that is defined by the provided name.
    *
    * @param ex Expression string to be parsed
    * @param expressionLanguage The name of the expression language to be used.
    * @param line Line no of the expression on the template
    * @param column Column no of the expression on the template
    * @return Returns compiled expression object.
    * @throws ExpressionParsingException Thrown if the expression can not be parsed
    */
   public static Expression parse(String ex, String expressionLanguage, int line, int column) throws ExpressionParsingException {
      ExpressionLanguage language = getExpressionLanguageByName(expressionLanguage);
      return language.parse(ex, line, column);
   }

   /**
    * @return Returns the built in expression language implementation
    */
   public static ExpressionLanguage getDefaultExpressionLanguage() {
      return defaultExpressionLanguage;
   }

    /**
     * Changes the default expression language that is global
     * @param el Expression language
     */
   public static void setDefaultExpressionLanguage(ExpressionLanguage el) {
       defaultExpressionLanguage = el;
   }

   /**
    * Registers a new expression language implementation. The instances of ExpressionLanguage implementations
    * are lazily initialized by the {@link #getExpressionLanguageByName(String)}  method.
    * @param name Name of the expression language
    * @param clazz The class implementing the Expression language.
    */
   public static synchronized void registerExpressionLanguage(String name, Class<? extends ExpressionLanguage> clazz) {
      expressionLanguageClasses.put(name, clazz);
   }

   /**
    * Initializes and returns an instance of Expression language for the given name.
    * @param name Name of the expression language
    * @return Returns the instance of Expression language
    */
   public static synchronized ExpressionLanguage getExpressionLanguageByName(String name) {
      ExpressionLanguage language = expressionLanguages.get(name);
      if (language != null) {
         return language;
      }

      Class<? extends ExpressionLanguage> expressionLangClass = expressionLanguageClasses.get(name);

      if (expressionLangClass == null) {
         throw new RuntimeException("Unknown expression language: " + name);
      }

      try {
         language = expressionLangClass.newInstance();
         expressionLanguages.put(name, language);
         return language;
      } catch (Exception e) {
         throw new RuntimeException("Unable to initialize expression language " + name, e);
      }
   }
}
