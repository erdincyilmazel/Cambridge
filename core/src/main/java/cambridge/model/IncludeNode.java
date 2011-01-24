package cambridge.model;

import cambridge.BehaviorInstantiationException;
import cambridge.TemplateLoader;
import cambridge.TemplateLoadingException;

/**
 * User: erdinc
 * Date: Nov 6, 2009
 * Time: 6:45:33 PM
 */
public class IncludeNode extends TemplateNode {

   private FragmentList fragments;

   public IncludeNode(TemplateLoader templateLoader, String fileName) throws TemplateLoadingException, BehaviorInstantiationException {
      this(templateLoader, fileName, null);
   }

   public IncludeNode(TemplateLoader templateLoader, String fileName, String selector) throws TemplateLoadingException, BehaviorInstantiationException {
      TemplateDocument doc = templateLoader.parseTemplate(fileName);
      if (selector != null) {
         fragments = doc.select(selector);
      } else {
         fragments = doc.normalize();
      }
   }

   @Override
   public void normalize(TemplateDocument doc, FragmentList list) throws BehaviorInstantiationException {
      for (Fragment f : fragments) {
         if (f instanceof StaticFragment) {
            list.append(f.toString());
         } else {
            list.addFragment(f);
         }
      }
   }

   @Override
   public boolean normalizeUntil(TemplateDocument doc, TemplateNode reference, FragmentList f, boolean inclusive) throws BehaviorInstantiationException {
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
}
