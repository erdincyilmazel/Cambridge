package cambridge;

import cambridge.behaviors.*;
import cambridge.parser.model.Attribute;
import cambridge.parser.model.DynamicAttribute;
import org.antlr.runtime.RecognitionException;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * User: erdinc
 * Date: Oct 31, 2009
 * Time: 7:24:15 PM
 */
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
   }

   private HashSet<String> namespaces;

   public void setUp() {
      bind(DefaultNamespace, "if").to(IfBehavior.getProvider());
      bind(DefaultNamespace, "foreach").to(ForeachBehavior.getProvider());
      bind(DefaultNamespace, "while").to(WhileBehavior.getProvider());
      bind(DefaultNamespace, "until").to(UntilBehavior.getProvider());
      bind(DefaultNamespace, "from").to(FromBehavior.getProvider());
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

   public TagBehavior getBehavior(String namespace, String attribute, Map<AttributeKey, Attribute> attributes) throws BehaviorInstantiationException, RecognitionException {
      AttributeKey key = new AttributeKey(namespace, attribute);

      return getBehavior(key, attributes);
   }

   public TagBehavior getBehavior(AttributeKey key, Map<AttributeKey, Attribute> attributes) throws BehaviorInstantiationException, RecognitionException {
      BehaviorProvider provider = providers.get(key);

      if (provider != null) {
         return provider.get((DynamicAttribute) attributes.get(key), attributes);
      }

      return null;
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
      setUp();
   }
}
