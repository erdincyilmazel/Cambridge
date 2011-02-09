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
import cambridge.runtime.EscapeFilter;
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
 *
 * <p>If new behaviors are to be added or the default ones are to be overridden, this
 * can be achieved by getting an instance of Cambridge first</p>
 */
@SuppressWarnings("unchecked")
public class Cambridge {
   public static String DefaultNamespaceURI = "http://cambridge.googlecode.com";

   private final HashMap<String, FunctionRunner> functions = new HashMap<String, FunctionRunner>();
   private final HashMap<String, Class<? extends Filter>> filters = new HashMap<String, Class<? extends Filter>>();

   /**
    * <p>Maps the provided function name to the Function implementation.</p>
    *
    * <p>These registered functions are only available if you use the built-in expression language.
    * If you decide to use MVEL or OGNL as your expression language, you should consult
    * the documentation of that project in defining functions</p>
    *
    * @see FunctionRunner The implementation of a function
    * @param name Function name
    * @param runner Function runner
    */
   public void registerFunction(String name, FunctionRunner runner) {
      functions.put(name, runner);
   }

   public FunctionRunner getFunctionRunner(String name) {
      return functions.get(name);
   }

   public void registerFilter(String name, Class<? extends Filter> filter) {
      filters.put(name.toLowerCase(), filter);
   }

   public Filter getFilter(String name) {
      try {
         return filters.get(name.toLowerCase()).newInstance();
      } catch (InstantiationException e) {
         return null;
      } catch (IllegalAccessException e) {
         return null;
      }
   }

   public class Bind {
      final DynamicAttributeKey k;

      Bind(DynamicAttributeKey k) {
         this.k = k;
      }

      public void to(BehaviorProvider provider) {
         providers.put(k, provider);
      }
   }

   public class BindStatic {
      final DynamicAttributeKey k;

      BindStatic(DynamicAttributeKey k) {
         this.k = k;
      }

      public void to(Class<? extends StaticBehavior> behaviorClass) {
         staticBehaviorClasses.put(k, behaviorClass);
      }
   }

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
   }

   private final HashSet<String> namespaces;
   private final HashMap<String, String> namespaceMappings;

   public void mapNamespace(String uri, String... names) {
      for (String n : names) {
         namespaceMappings.put(n, uri);
      }
   }

   public String getDefaultNamespace(String uri) {
      return namespaceMappings.get(uri);
   }

   public void setUp() {
      mapNamespace(DefaultNamespaceURI, "a", "cambridge");

      registerFunction("text", new ResourceBundleFunction());
      registerFunction("if", new IfFunction());

      registerFilter("lower", LowerCaseFilter.class);
      registerFilter("upper", UpperCaseFilter.class);
      registerFilter("escape", EscapeFilter.class);
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

   public Bind bind(String uri, String attribute) {
      DynamicAttributeKey key = new DynamicAttributeKey(uri, "", attribute);
      namespaces.add(uri);
      return new Bind(key);
   }

   public BindStatic bindStatic(String uri, String attribute) {
      DynamicAttributeKey key = new DynamicAttributeKey(uri, "", attribute);
      namespaces.add(uri);
      return new BindStatic(key);
   }

   public BindTag bindTag(String uri, String... attribute) {
      namespaces.add(uri);

      DynamicAttributeKey[] keys = new DynamicAttributeKey[attribute.length];
      for (int i = 0; i < attribute.length; i++) {
         String a = attribute[i];
         keys[i] = new DynamicAttributeKey(uri, "", a);
      }

      return new BindTag(keys);
   }

   public boolean isRegisteredNamespace(String uri) {
      return namespaces.contains(uri);
   }

   private final HashMap<DynamicAttributeKey, BehaviorProvider> providers;
   private final HashMap<DynamicAttributeKey, Class<? extends StaticBehavior>> staticBehaviorClasses;
   private final HashMap<DynamicAttributeKey, StaticBehavior> staticBehaviors;
   private final HashMap<DynamicAttributeKey, Class<? extends DynamicTag>> dynamicTagClasses;

   public TagBehavior getBehavior(DynamicAttributeKey key, Map<AttributeKey, Attribute> attributes) throws BehaviorInstantiationException, ExpressionParsingException {
      BehaviorProvider provider = providers.get(key);

      if (provider != null) {
         return provider.get((DynamicAttribute) attributes.get(key.toAttributeKey()), attributes);
      }

      return null;
   }

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

   public DynamicTag getDynamicTag(DynamicAttributeKey key) {
      Class<? extends DynamicTag> clazz = dynamicTagClasses.get(key);
      if (clazz == null) {
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

   private static Cambridge instance;

   public static Cambridge getInstance() {
      if (instance == null) {
         instance = new Cambridge();
      }

      return instance;
   }

   public Cambridge() {
      namespaces = new HashSet<String>();
      namespaceMappings = new HashMap<String, String>();
      providers = new HashMap<DynamicAttributeKey, BehaviorProvider>();
      staticBehaviorClasses = new HashMap<DynamicAttributeKey, Class<? extends StaticBehavior>>();
      staticBehaviors = new HashMap<DynamicAttributeKey, StaticBehavior>();
      dynamicTagClasses = new HashMap<DynamicAttributeKey, Class<? extends DynamicTag>>();
      setUp();
   }
}
