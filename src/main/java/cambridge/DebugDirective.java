package cambridge;

import cambridge.model.*;
import cambridge.runtime.TemplateProperties;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

/**
 * User: erdincyilmazel
 * Date: 1/7/11
 * Time: 4:44 PM
 */
public class DebugDirective extends TemplateNode implements AttributeFragment {

   private static FragmentList debugTemplate;

   static {
      ClassPathTemplateLoader templateLoader = new ClassPathTemplateLoader(DebugDirective.class);
      TemplateDocument templateDocument = templateLoader.parseTemplate("cambridge/debug.html");
      try {
         debugTemplate = templateDocument.normalize();
      } catch (BehaviorInstantiationException e) {
         e.printStackTrace();
      }
   }

   public static class DebugElement {
      final String key;
      final Object value;
      final String type;

      DebugElement(String key, Object value, String type) {
         this.key = key;
         this.value = value;
         this.type = type;
      }

      public String getKey() {
         return key;
      }

      public Object getValue() {
         return value;
      }

      public String getType() {
         return type;
      }
   }

   public DebugDirective() {

   }

   @Override
   public void normalize(FragmentList fList) throws BehaviorInstantiationException {
      fList.add(this);
   }

   @Override
   public boolean normalizeUntil(TemplateNode reference, FragmentList f, boolean inclusive) throws BehaviorInstantiationException {
      if (reference == this) {
         if (inclusive) {
            normalize(f);
         }
         return true;
      } else {
         normalize(f);
         return false;
      }
   }

   @Override
   public Tag getElementById(String id) {
      return null;
   }

   public void eval(TemplateProperties properties, Appendable out) throws IOException, TemplateEvaluationException {
      ArrayList<DebugElement> elements = new ArrayList<DebugElement>();
      Set<Map.Entry<String,Object>> entries = properties.entrySet();

      for (Map.Entry<String, Object> e : entries) {
         String key = e.getKey();
         Object value = e.getValue();
         if ("#this".equals(key) || "#super".equals(key) || "#iter".equals(key)) {
            if (value != null) {
               elements.add(new DebugElement(key, value, value.getClass().getName()));
            }
         } else {
            if (value != null) {
               elements.add(new DebugElement(key, value, value.getClass().getName()));
            } else {
               elements.add(new DebugElement(key, "", "<NULL>"));
            }
         }
      }

      properties.put("___DebugAllValues___", elements);
      for (Fragment f : debugTemplate) {
         f.eval(properties, out);
      }

      properties.remove("___DebugAllValues___");
   }

   public void pack() {
   }
}
