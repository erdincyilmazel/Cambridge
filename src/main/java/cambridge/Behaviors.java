package cambridge;

import cambridge.behaviors.*;
import cambridge.model.Attribute;
import cambridge.model.DynamicAttribute;
import cambridge.tags.DummyTag;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * User: erdinc
 * Date: Oct 31, 2009
 * Time: 7:24:15 PM
 */
@SuppressWarnings("unchecked")
public class Behaviors {
   public static String DefaultNamespace = "a";

   class Bind {
      AttributeKey k;

      Bind(AttributeKey k) {
         this.k = k;
      }

      public void to(BehaviorProvider provider) {
         providers.put(k, provider);
      }
   }

   class BindStatic {
      AttributeKey k;

      BindStatic(AttributeKey k) {
         this.k = k;
      }

      public void to(Class<? extends StaticBehavior> behaviorClass) {
         staticBehaviorClasses.put(k, behaviorClass);
      }
   }

   class BindTag {
      AttributeKey[] keys;

      BindTag(AttributeKey[] k) {
         this.keys = k;
      }

      public void to(Class<? extends DynamicTag> tagClass) {
         for (AttributeKey k : keys) {
            dynamicTagClasses.put(k, tagClass);
         }
      }
   }

   private HashSet<String> namespaces;

   public void setUp() {
      bind(DefaultNamespace, "if").to(IfBehavior.getProvider());
      bind(DefaultNamespace, "foreach").to(ForeachBehavior.getProvider());
      bind(DefaultNamespace, "while").to(WhileBehavior.getProvider());
      bind(DefaultNamespace, "from").to(FromBehavior.getProvider());
      bind(DefaultNamespace, "repeat").to(RepeatBehavior.getProvider());
      bind(DefaultNamespace, "selectedIf").to(SelectedBehavior.getProvider());
      bindStatic(DefaultNamespace, "addAlt").to(AltAdderStaticBehavior.class);
      bindStatic(DefaultNamespace, "hide").to(HideBehavior.class);
      bindTag(DefaultNamespace, "dummy", "span").to(DummyTag.class);
   }

   public Bind bind(String namespace, String attribute) {
      AttributeKey key = new AttributeKey(namespace, attribute);
      namespaces.add(namespace);
      return new Bind(key);
   }

   public BindStatic bindStatic(String namespace, String attribute) {
      AttributeKey key = new AttributeKey(namespace, attribute);
      namespaces.add(namespace);
      return new BindStatic(key);
   }

   public BindTag bindTag(String namespace, String... attribute) {
      namespaces.add(namespace);

      AttributeKey[] keys = new AttributeKey[attribute.length];
      for (int i = 0; i < attribute.length; i++) {
         String a = attribute[i];
         keys[i] = new AttributeKey(namespace, a);
      }

      return new BindTag(keys);
   }

   public boolean isRegisteredNamespace(String n) {
      return namespaces.contains(n);
   }

   private HashMap<AttributeKey, BehaviorProvider> providers;
   private HashMap<AttributeKey, Class<? extends StaticBehavior>> staticBehaviorClasses;
   private HashMap<AttributeKey, StaticBehavior> staticBehaviors;
   private HashMap<AttributeKey, Class<? extends DynamicTag>> dynamicTagClasses;

   public TagBehavior getBehavior(String namespace, String attribute, Map<AttributeKey, Attribute> attributes) throws BehaviorInstantiationException, ExpressionParsingException {
      AttributeKey key = new AttributeKey(namespace, attribute);

      return getBehavior(key, attributes);
   }

   public TagBehavior getBehavior(AttributeKey key, Map<AttributeKey, Attribute> attributes) throws BehaviorInstantiationException, ExpressionParsingException {
      BehaviorProvider provider = providers.get(key);

      if (provider != null) {
         return provider.get((DynamicAttribute) attributes.get(key), attributes);
      }

      return null;
   }

   public StaticBehavior getStaticBehavior(AttributeKey key) {
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

   public DynamicTag getDynamicTag(AttributeKey key) {
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

   static Behaviors instance;

   public static Behaviors getInstance() {
      if (instance == null) {
         instance = new Behaviors();
      }

      return instance;
   }

   public static void registerInstance(Behaviors b) {
      instance = b;
   }

   private Behaviors() {
      namespaces = new HashSet<String>();
      providers = new HashMap<AttributeKey, BehaviorProvider>();
      staticBehaviorClasses = new HashMap<AttributeKey, Class<? extends StaticBehavior>>();
      staticBehaviors = new HashMap<AttributeKey, StaticBehavior>();
      dynamicTagClasses = new HashMap<AttributeKey, Class<? extends DynamicTag>>();
      setUp();
   }
}
