package cambridge;

import cambridge.behaviors.AltAdderStaticBehavior;
import cambridge.behaviors.ConditionalAttributeBehavior;
import cambridge.behaviors.ElseBehavior;
import cambridge.behaviors.ElseIfBehavior;
import cambridge.behaviors.ForeachBehavior;
import cambridge.behaviors.FromBehavior;
import cambridge.behaviors.HideBehavior;
import cambridge.behaviors.IfBehavior;
import cambridge.behaviors.OverridesStaticBehavior;
import cambridge.behaviors.RepeatBehavior;
import cambridge.behaviors.SelectedBehavior;
import cambridge.behaviors.WhileBehavior;
import cambridge.behaviors.WithBehavior;
import cambridge.model.Attribute;
import cambridge.model.AttributeKey;
import cambridge.model.DynamicAttribute;
import cambridge.parser.expressions.FunctionRunner;
import cambridge.parser.expressions.IfFunction;
import cambridge.parser.expressions.ResourceBundleFunction;
import cambridge.parser.expressions.StaticMethodCaller;
import cambridge.runtime.Filter;
import cambridge.runtime.LowerCaseFilter;
import cambridge.runtime.SimpleDateFormatFilter;
import cambridge.runtime.UpperCaseFilter;
import cambridge.tags.DummyTag;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * <p>Cambridge is a singleton which holds mappings of names to behaviors, functions, filters
 * etc.</p>
 * <p/>
 * <p>If new behaviors are to be added or the default ones are to be overridden, this
 * can be achieved by getting an instance of Cambridge first</p>
 */
@SuppressWarnings("unchecked")
public class Cambridge {
    private static Cambridge instance;

    public static String DefaultNamespaceURI = "http://cambridge.googlecode.com";

    private final HashMap<String, FunctionRunner> functions = new HashMap<String, FunctionRunner>();
    private final HashMap<String, Class<? extends Filter>> filters = new HashMap<String, Class<? extends Filter>>();
    private final HashSet<String> namespaces;
    private final HashMap<String, String> namespaceMappings;
    private final HashMap<DynamicAttributeKey, BehaviorProvider> providers;
    private final HashMap<DynamicAttributeKey, Class<? extends StaticBehavior>> staticBehaviorClasses;
    private final HashMap<DynamicAttributeKey, StaticBehavior> staticBehaviors;
    private final HashMap<DynamicAttributeKey, Class<? extends DynamicTag>> dynamicTagClasses;
    private final HashMap<DynamicAttributeKey, DynamicTagProvider> dynamicTagProviders;

    /**
     * This is an internal class to support the builder pattern for binding behaviors
     */
    public class Bind {
        final DynamicAttributeKey k;

        Bind(DynamicAttributeKey k) {
            this.k = k;
        }

        public void to(BehaviorProvider provider) {
            providers.put(k, provider);
        }
    }

    /**
     * This is an internal class to support the builder pattern for binding static behaviors
     */
    public class BindStatic {
        final DynamicAttributeKey k;

        BindStatic(DynamicAttributeKey k) {
            this.k = k;
        }

        public void to(Class<? extends StaticBehavior> behaviorClass) {
            staticBehaviorClasses.put(k, behaviorClass);
        }
    }

    /**
     * This is an internal class to support the builder pattern for binding tags
     */
    public class BindTag {
        final DynamicAttributeKey[] keys;

        BindTag(DynamicAttributeKey[] k) {
            this.keys = k;
        }

        public void to(Class<? extends DynamicTag> tagClass) {
            for (DynamicAttributeKey k : keys) {
                dynamicTagClasses.put(k, tagClass);
            }
        }

        public void toProvider(DynamicTagProvider provider) {
            for (DynamicAttributeKey k : keys) {
                dynamicTagProviders.put(k, provider);
            }
        }
    }

    /**
     * <p>Maps the provided function name to the Function implementation.</p>
     * <p/>
     * <p>These registered functions are only available if you use the built-in expression language.
     * If you decide to use MVEL or OGNL as your expression language, you should consult
     * the documentation of that project in defining functions</p>
     *
     * @param name   Function name
     * @param runner Function runner
     * @see FunctionRunner The implementation of a function
     */
    public void registerFunction(String name, FunctionRunner runner) {
        functions.put(name, runner);
    }

    /**
     * FunctionRunners are classes that implement a function in Cambridge Template Engine
     * Expression Language.
     * <p/>
     * This method returns the instance of a FunctionRunner by name. FunctionRunner implementations
     * should be thread safe.
     *
     * @param name Name of the FunctionRunner
     * @return Returns an instance of FunctionRunner if there is one with the name provided.
     *         Returns null otherwise.
     */
    public FunctionRunner getFunctionRunner(String name) {
        return functions.get(name);
    }

    /**
     * Registers an expression filter for the given name to be used in built in
     * Expression Language. Filters are used to format variable rendering.
     *
     * @param name   Name of the filter
     * @param filter Class implementing the filter
     */
    public void registerFilter(String name, Class<? extends Filter> filter) {
        filters.put(name.toLowerCase(), filter);
    }

    /**
     * Returns an instance of Filter by name. During template parsing/compilation
     * phase, an instance of Filter is created for each time it is used in a template.
     * The same Filter instance gets re-used throughout template document lifecycle.
     *
     * @param name Name of the filter to be returned.
     * @param line Line number on the template which tries to instantiate a filter instance
     * @param col Column number on the template which tries to instantiate a filter instance
     * @return Returns an instance of the Filter
     * @throws TemplateParsingException Might be thrown if the filter is unknown or can not be instantiated.
     */
    public Filter getFilter(String name, int line, int col) throws TemplateParsingException {
        try {
            String key = name.toLowerCase();
            Class<? extends Filter> filterClass = filters.get(key);

            if (filterClass == null)
            {
                throw new TemplateParsingException("Unknown filter: " + name, line, col);
            }

            return filterClass.newInstance();
        } catch (InstantiationException e) {
            throw new TemplateParsingException("Could not instantiate filter: " + name, e, line, col);
        } catch (IllegalAccessException e) {
            throw new TemplateParsingException("Could not instantiate filter: " + name, e, line, col);
        }
    }

    /**
     * Maps the specified namespace uri to provided name or names as default name for
     * the namespace uri.
     * <p/>
     * For cambridge template engine's built-in behaviors and tags, "a" is the default
     * namespace short name. If you create your own behaviors or tags, you can
     * use this method to map your namespace uri to a default namespace.
     * <p/>
     * Behavior libraries may also call this method to set default namespace for
     * the behaviors or tags that they provide.
     *
     * @param uri   URI of the behavior or tag
     * @param names List of names that may be used as default names.
     */
    public void mapNamespace(String uri, String... names) {
        for (String n : names) {
            namespaceMappings.put(n, uri);
        }
    }

    /**
     * Returns the namespace uri for the given name if there is a previously set
     * matching default name for the namespace uri.
     *
     * @param name Namespace name
     * @return Returns the URI if the provided name is the default name for a namespace
     */
    public String getDefaultNamespace(String name) {
        return namespaceMappings.get(name);
    }

    /**
     * Bind an attribute with the specified namespace uri and attribute name
     * to a dynamic behavior. The returned Bind object should be used to complete
     * the mapping to a Behavior Provider.
     *
     * @param uri       Namespace uri
     * @param attribute Attribute name
     * @return Returns a Bind object which will be used to map the namespace to a Behavior.
     */
    public Bind bind(String uri, String attribute) {
        DynamicAttributeKey key = new DynamicAttributeKey(uri, "", attribute);
        namespaces.add(uri);
        return new Bind(key);
    }

    /**
     * Bind an attribute with the specified namespace uri and the attribute name
     * as a static behavior. The returned BindStatic object should be used to
     * complete the mapping to class that implements {@link StaticBehavior}
     *
     * @param uri       Namespace uri
     * @param attribute Attribute name
     * @return Returns a BindStatic object which will be used to map the namespace to a StaticBehavior class.
     */
    public BindStatic bindStatic(String uri, String attribute) {
        DynamicAttributeKey key = new DynamicAttributeKey(uri, "", attribute);
        namespaces.add(uri);
        return new BindStatic(key);
    }

    /**
     * Checks if there is a static behavior that is defined for the supplied namespace
     * uri and the attribute name.
     *
     * @param uri       Namespace uri
     * @param attribute Attribute name
     * @return Returns true if the attribute is defined as a static behavior attribute.
     */
    public boolean isStaticAttribute(String uri, String attribute) {
        DynamicAttributeKey key = new DynamicAttributeKey(uri, "", attribute);
        return staticBehaviorClasses.containsKey(key);
    }

    /**
     * Binds a tag which has the supplied namespace uri and the provided tag name
     * or names (Multiple tag names may be used as aliases) to a class that extends
     * {@link DynamicTag}.
     *
     * @param uri     Namespace uri
     * @param tagName Name of the tag with aliases
     * @return Returns a BindTag object that should be used to complete the mapping to the Tag class.
     */
    public BindTag bindTag(String uri, String... tagName) {
        namespaces.add(uri);

        DynamicAttributeKey[] keys = new DynamicAttributeKey[tagName.length];
        for (int i = 0; i < tagName.length; i++) {
            String a = tagName[i];
            keys[i] = new DynamicAttributeKey(uri, "", a);
        }

        return new BindTag(keys);
    }

    /**
     * Checks if the supplied uri has been registered for a tag behavior or tag.
     *
     * @param uri Namespace uri
     * @return Returns true if the namespace uri has been registered
     */
    public boolean isRegisteredNamespace(String uri) {
        return namespaces.contains(uri);
    }

    /**
     * Using the BehaviorProvider that is registered for a specific namespace uri and attribute name
     * that is supplied (as a DynamicAttributeKey object), this method creates a new instance of the
     * TagBehavior and returns it. This method is called internally while template parsing occurs.
     *
     * @param key        The attribute key which identifies the attribute with the namespace uri and attribute name.
     * @param attributes Other attributes of the tag that has this dynamic attribute.
     * @param line       Line number of the tag attribute that is initiating this behavior
     * @param col        Column number of the tag attribute that is initiating this behavior
     * @return Returns an instance of TagBehavior for the matching behavior implementation.
     * @throws BehaviorInstantiationException
     * @throws ExpressionParsingException
     */
    public TagBehavior getBehavior(DynamicAttributeKey key, Map<AttributeKey, Attribute> attributes, int line, int col) throws BehaviorInstantiationException, ExpressionParsingException {
        BehaviorProvider provider = providers.get(key);

        if (provider != null) {
            return provider.get((DynamicAttribute) attributes.get(key.toAttributeKey()), attributes, line, col);
        }

        return null;
    }

    /**
     * If there is any static behavior assigned to the supplied DynamicAttributeKey object,
     * this method creates and returns an instance of that.
     * <p/>
     * If there is no static behavior associated with the supplied key, it returns null.
     *
     * @param key Dynamic attribute key (Namespace uri + attribute name)
     * @return Returns a new instance of StaticBehavior for the supplied static attribute.
     */
    public StaticBehavior getStaticBehavior(DynamicAttributeKey key) {
        StaticBehavior b = staticBehaviors.get(key);
        if (b != null) {
            return b;
        }

        Class<? extends StaticBehavior> clazz = staticBehaviorClasses.get(key);
        if (clazz == null) {
            return null;
        }

        try {
            b = clazz.newInstance();
            staticBehaviors.put(key, b);
            return b;
        } catch (InstantiationException e) {
            return null;
        } catch (IllegalAccessException e) {
            return null;
        }
    }

    /**
     * Creates and returns an instance of DynamicTag for the supplied dynamic attribute
     * key. If there is no dynamic tag associated with the supplied key, returns null.
     *
     * @param key Dynamic attribute key.
     * @return Returns a new instance of DynamicTag for the supplied key.
     */
    public DynamicTag getDynamicTag(DynamicAttributeKey key) {
        Class<? extends DynamicTag> clazz = dynamicTagClasses.get(key);
        if (clazz == null) {
            DynamicTagProvider provider = dynamicTagProviders.get(key);

            if (provider != null) {
                return provider.getInstance();
            }

            return null;
        }

        try {
            return clazz.newInstance();
        } catch (IllegalAccessException e) {
            return null;
        } catch (InstantiationException e) {
            return null;
        }
    }

    /**
     * @return Returns the Cambridge singleton.
     */
    public static Cambridge getInstance() {
        if (instance != null) {
            return instance;
        }

        synchronized (Cambridge.class) {
            if (instance == null) {
                instance = new Cambridge();
            }

            return instance;
        }
    }

    /**
     * Initializes the internal collections and sets up the default/built-in behaviors and tags.
     */
    protected Cambridge() {
        namespaces = new HashSet<String>();
        namespaceMappings = new HashMap<String, String>();
        providers = new HashMap<DynamicAttributeKey, BehaviorProvider>();
        staticBehaviorClasses = new HashMap<DynamicAttributeKey, Class<? extends StaticBehavior>>();
        staticBehaviors = new HashMap<DynamicAttributeKey, StaticBehavior>();
        dynamicTagClasses = new HashMap<DynamicAttributeKey, Class<? extends DynamicTag>>();
        dynamicTagProviders = new HashMap<DynamicAttributeKey, DynamicTagProvider>();

        /**
         * Setup defaults.
         */
        mapNamespace(DefaultNamespaceURI, "a", "cambridge");

        registerFunction("text", new ResourceBundleFunction());
        registerFunction("if", new IfFunction());

        try {
            registerFunction("format", new StaticMethodCaller(String.class.getMethod("format", String.class, Object[].class)));
        } catch (NoSuchMethodException e) {
            // Never going to happen
        }

        registerFilter("lower", LowerCaseFilter.class);
        registerFilter("upper", UpperCaseFilter.class);
        registerFilter("dateformat", SimpleDateFormatFilter.class);

        bind(DefaultNamespaceURI, "if").to(IfBehavior.getProvider());
        bind(DefaultNamespaceURI, "elseif").to(ElseIfBehavior.getProvider());
        bind(DefaultNamespaceURI, "else").to(ElseBehavior.getProvider());
        bind(DefaultNamespaceURI, "foreach").to(ForeachBehavior.getProvider());
        bind(DefaultNamespaceURI, "while").to(WhileBehavior.getProvider());
        bind(DefaultNamespaceURI, "with").to(WithBehavior.getProvider());
        bind(DefaultNamespaceURI, "from").to(FromBehavior.getProvider());
        bind(DefaultNamespaceURI, "repeat").to(RepeatBehavior.getProvider());
        bind(DefaultNamespaceURI, "selectedIf").to(SelectedBehavior.getProvider());
        bind(DefaultNamespaceURI, "next").to(ConditionalAttributeBehavior.getProvider());
        bindStatic(DefaultNamespaceURI, "addAlt").to(AltAdderStaticBehavior.class);
        bindStatic(DefaultNamespaceURI, "hide").to(HideBehavior.class);
        bindStatic(DefaultNamespaceURI, "overrides").to(OverridesStaticBehavior.class);
        bindTag(DefaultNamespaceURI, "hidden", "span").to(DummyTag.class);
    }
}
