package cambridge;

import cambridge.behaviors.*;
import cambridge.parser.model.Attribute;
import cambridge.parser.model.DynamicAttribute;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * User: erdinc
 * Date: Oct 31, 2009
 * Time: 7:24:15 PM
 */
@SuppressWarnings("unchecked")
public class BehaviorBindings {
   public static String DefaultNamespace = "a";

   class Bind {
      AttributeKey k;

      Bind(AttributeKey k) {
         this.k = k;
      }

      public void to(BehaviorProvider provider) {
         providers.put(k, provider);
      }

      public void to(Class<? extends StaticBehavior> behaviorClass) {
         staticBehaviorClasses.put(k, behaviorClass);
      }
   }

   private HashSet<String> namespaces;

   public void setUp() {
      bind(DefaultNamespace, "if").to(IfBehavior.getProvider());
      bind(DefaultNamespace, "foreach").to(ForeachBehavior.getProvider());
      bind(DefaultNamespace, "while").to(WhileBehavior.getProvider());
      bind(DefaultNamespace, "from").to(FromBehavior.getProvider());
      bind(DefaultNamespace, "addAlt").to(AltAdderStaticBehavior.class);
   }

   public Bind bind(String namespace, String attribute) {
      AttributeKey key = new AttributeKey(namespace, attribute);
      namespaces.add(namespace);
      return new Bind(key);
   }

   public boolean isRegisteredNamespace(String n) {
      return namespaces.contains(n);
   }

   private HashMap<AttributeKey, BehaviorProvider> providers;
   private HashMap<AttributeKey, Class<? extends StaticBehavior>> staticBehaviorClasses;
   private HashMap<AttributeKey, StaticBehavior> staticBehaviors;

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

   static BehaviorBindings instance;

   public static BehaviorBindings getInstance() {
      if (instance == null) {
         instance = new BehaviorBindings();
      }

      return instance;
   }

   public static void registerInstance(BehaviorBindings b) {
      instance = b;
   }

   private BehaviorBindings() {
      namespaces = new HashSet<String>();
      providers = new HashMap<AttributeKey, BehaviorProvider>();
      staticBehaviorClasses = new HashMap<AttributeKey, Class<? extends StaticBehavior>>();
      staticBehaviors = new HashMap<AttributeKey, StaticBehavior>();
      setUp();
   }
}
