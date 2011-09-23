package cambridge.model;

import cambridge.BehaviorInstantiationException;
import cambridge.ClassPathTemplateLoader;
import cambridge.Expressions;
import cambridge.TemplateEvaluationException;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

/**
 * @author Erdinc Yilmazelyilmazel
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
   void normalize(TemplateDocument doc, FragmentList fList) throws BehaviorInstantiationException {
      fList.addFragment(this);
   }

   @Override
   boolean normalizeUntil(TemplateDocument doc, TemplateNode reference, FragmentList f, boolean inclusive) throws BehaviorInstantiationException {
      if (reference == this) {
         if (inclusive) {
            normalize(doc, f);
         }
         return true;
      } else {
         normalize(doc, f);
         return false;
      }
   }

   @Override
   public Tag getElementById(String id) {
      return null;
   }

   public void eval(Map<String, Object> bindings, Writer out) throws IOException, TemplateEvaluationException {
      ArrayList<DebugElement> elements = new ArrayList<DebugElement>();
      Set<Map.Entry<String, Object>> entries = bindings.entrySet();

      for (Map.Entry<String, Object> e : entries) {
         String key = e.getKey();
         Object value = e.getValue();
         if (Expressions.CURRENT_OBJECT.equals(key) || Expressions.PARENT_OBJECT.equals(key) || Expressions.ITER_OBJECT.equals(key)) {
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

      bindings.put("___DebugAllValues___", elements);
      for (Fragment f : debugTemplate) {
         f.eval(bindings, out);
      }

      bindings.remove("___DebugAllValues___");
   }

   public void pack() {
   }
}
