package cambridge.model;

import cambridge.BehaviorInstantiationException;

/**
 * @author Erdinc Yilmazel
 * Date: May 18, 2010
 * Time: 9:35:44 AM
 */
public class ExpressionLanguageDirective extends TemplateNode {
   private final String name;

   public ExpressionLanguageDirective(String name) {
      this.name = name;
   }

   @Override
   void normalize(TemplateDocument doc, FragmentList f) throws BehaviorInstantiationException {

   }

   @Override
   boolean normalizeUntil(TemplateDocument doc, TemplateNode reference, FragmentList f, boolean inclusive) throws BehaviorInstantiationException {
      return false;
   }

   @Override
   public Tag getElementById(String id) {
      return null;
   }

   @Override
   public String toString() {
      return "ExpressionLanguageDirective{" +
         "name='" + name + '\'' +
         '}';
   }
}
