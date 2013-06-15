package cambridge;

import cambridge.model.TemplateDocument;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;

/**
 * @author Erdinc Yilmazel
 * Date: Nov 3, 2009
 * Time: 3:20:20 PM
 */
public class FileTemplateLoader extends AbstractTemplateLoader {
   public FileTemplateLoader() {
      changeDetectionInterval = DefaultChangeDetectionInterval;
   }

   public FileTemplateLoader(int changeDetectionInterval) {
      this.changeDetectionInterval = changeDetectionInterval;
   }

   protected final int changeDetectionInterval;

   public TemplateFactory newTemplateFactory(File file, ExpressionLanguage expressionLanguage) throws TemplateLoadingException {
      return newTemplateFactory(file, DefaultEncoding, null, expressionLanguage);
   }

   public TemplateFactory newTemplateFactory(File file, String encoding, ExpressionLanguage expressionLanguage) throws TemplateLoadingException {
      return newTemplateFactory(file, encoding, null, expressionLanguage);
   }

   public TemplateFactory newTemplateFactory(File file, TemplateModifier modifier, ExpressionLanguage expressionLanguage) throws TemplateLoadingException {
      return newTemplateFactory(file, DefaultEncoding, modifier, expressionLanguage);
   }

   public TemplateFactory newTemplateFactory(File file, String encoding, TemplateModifier modifier, ExpressionLanguage expressionLanguage) throws TemplateLoadingException {
      TemplateDocument document = parseTemplate(file, encoding, expressionLanguage);
      if (modifier != null) {
         modifier.modifyTemplate(document);
      }

      try {
         if (document.getIncludes() != null) {
            return new FileTemplateFactory(this, document.normalize(), file, encoding, modifier, getFiles(document.getIncludes()), changeDetectionInterval);
         }

         return new FileTemplateFactory(this, document.normalize(), file, encoding, modifier, null, changeDetectionInterval);
      } catch (BehaviorInstantiationException e) {
         throw new TemplateLoadingException(e);
      }
   }

   public HashSet<File> getFiles(HashSet<String> fileNames) {
      HashSet<File> files = new HashSet<File>();
      for (String s : fileNames) {
         File f = new File(s);
         if (f.exists()) {
            files.add(f);
         }
      }

      if (files.size() != 0) {
         return files;
      }

      return null;
   }


   public TemplateDocument parseTemplate(File file, ExpressionLanguage expressionLanguage) throws TemplateLoadingException {
      return parseTemplate(file, DefaultEncoding, expressionLanguage);
   }

   public TemplateDocument parseTemplate(File file, String encoding, ExpressionLanguage expressionLanguage) throws TemplateLoadingException {
      try {
         return parseTemplate(new FileInputStream(file), encoding, expressionLanguage);
      } catch (FileNotFoundException e) {
         throw new TemplateLoadingException(e);
      }
   }

   public TemplateFactory newTemplateFactory(String template, ExpressionLanguage expressionLanguage) throws TemplateLoadingException {
      return newTemplateFactory(new File(template), expressionLanguage);
   }

   public TemplateFactory newTemplateFactory(String template, String encoding, ExpressionLanguage expressionLanguage) throws TemplateLoadingException {
      return newTemplateFactory(new File(template), encoding, expressionLanguage);
   }

   public TemplateFactory newTemplateFactory(String template, TemplateModifier modifier, ExpressionLanguage expressionLanguage) throws TemplateLoadingException {
      return newTemplateFactory(new File(template), modifier, expressionLanguage);
   }

   public TemplateFactory newTemplateFactory(String template, String encoding, TemplateModifier modifier, ExpressionLanguage expressionLanguage) throws TemplateLoadingException {
      return newTemplateFactory(new File(template), encoding, modifier, expressionLanguage);
   }

   public TemplateDocument parseTemplate(String templateFile, ExpressionLanguage expressionLanguage) throws TemplateLoadingException {
      return parseTemplate(new File(templateFile), expressionLanguage);
   }

   public TemplateDocument parseTemplate(String templateFile, String encoding, ExpressionLanguage expressionLanguage) throws TemplateLoadingException {
      return parseTemplate(new File(templateFile), encoding, expressionLanguage);
   }
}
