package cambridge.model;

import cambridge.BehaviorInstantiationException;
import cambridge.Cambridge;
import cambridge.DynamicAttributeKey;
import cambridge.TemplateLoader;
import cambridge.TemplateLoadingException;

import java.util.ArrayList;

/**
 * @author Erdinc Yilmazel
 * @since 1/24/11
 */
public class ExtendsDirective extends TemplateNode {
   private TemplateDocument extendedDocument;
   private TagNode extendedTag;

   public ExtendsDirective(TemplateLoader templateLoader, String fileName, String selector) throws TemplateLoadingException, BehaviorInstantiationException {
      extendedDocument = templateLoader.parseTemplate(fileName);
      if (selector != null) {
         extendedTag = extendedDocument.locateTag(selector);
      }
   }

   public void extend(TemplateDocument doc, FragmentList f) throws BehaviorInstantiationException {
      ParentNode extended;
      if (extendedTag == null) {
         extended = extendedDocument;
//
//         if (extendedDocument.getChildren().size() > 0 && extendedDocument.getChildren().get(0) instanceof ExtendsDirective) {
//            extendedDocument.getChildren().get(0).normalize(extendedDocument, f);
//         }
      } else {
         extended = extendedTag;
      }

      ArrayList<TemplateNode> children = doc.getChildren();
      for (TemplateNode node : children) {
         if (node instanceof Tag) {
            Tag tag = (Tag) node;
            Tag overriden = null;

            Attribute overrides = tag.getDynamicAttribute(new DynamicAttributeKey(Cambridge.DefaultNamespaceURI, "a", "overrides"));
            if (overrides != null) {
               overriden = extendedDocument.locateTag(overrides.getValue());
            } else {
               Attribute id = tag.getAttribute("id");
               if (id != null) {
                  overriden = extended.getElementById(id.getValue());
               }
            }
            if (overriden != null) {
               overriden.getParent().replaceChild((TemplateNode) overriden, (TemplateNode) tag);
            }
         }
      }

      if (extendedTag != null) {
         extendedTag.normalize(extendedDocument, f);
      } else {
         f.addAll(extendedDocument.normalize());
      }
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
}
