package cambridge;

import cambridge.parser.expressions.CambridgeExpressionLanguage;

import java.util.HashMap;

/**
 * Utility class to help with expression parsing.
 */
public class Expressions
{
    public static ExpressionLanguage cambridgeExpressionLanguage = new CambridgeExpressionLanguage();

    public static final String CURRENT_OBJECT = "self";
    public static final String PARENT_OBJECT = "parent";
    public static final String ITER_OBJECT = "iter";

    private static final HashMap<String, ExpressionLanguage> expressionLanguages = new HashMap<String, ExpressionLanguage>();
    private static final HashMap<String, Class<? extends ExpressionLanguage>> expressionLanguageClasses =
        new HashMap<String, Class<? extends ExpressionLanguage>>();

    static
    {
        expressionLanguages.put("cambridge", cambridgeExpressionLanguage);
    }

    /**
     * Registers a new expression language implementation. The instances of ExpressionLanguage implementations
     * are lazily initialized by the {@link #getExpressionLanguageByName(String)}  method.
     *
     * @param name  Name of the expression language
     * @param clazz The class implementing the Expression language.
     */
    public static synchronized void registerExpressionLanguage(String name, Class<? extends ExpressionLanguage> clazz)
    {
        expressionLanguageClasses.put(name, clazz);
    }

    /**
     * Initializes and returns an instance of Expression language for the given name.
     *
     * @param name Name of the expression language
     * @return Returns the instance of Expression language
     */
    public static synchronized ExpressionLanguage getExpressionLanguageByName(String name)
    {
        ExpressionLanguage language = expressionLanguages.get(name);
        if (language != null)
        {
            return language;
        }

        Class<? extends ExpressionLanguage> expressionLangClass = expressionLanguageClasses.get(name);

        if (expressionLangClass == null)
        {
            throw new RuntimeException("Unknown expression language: " + name);
        }

        try
        {
            language = expressionLangClass.newInstance();
            expressionLanguages.put(name, language);
            return language;
        }
        catch (Exception e)
        {
            throw new RuntimeException("Unable to initialize expression language " + name, e);
        }
    }
}
