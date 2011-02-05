package cambridge;

import cambridge.model.TemplateDocument;
import play.Play;
import play.exceptions.TemplateNotFoundException;
import play.vfs.VirtualFile;

import java.io.File;
import java.util.HashSet;

/**
 * User: erdincyilmazel
 * Date: 1/14/11
 * Time: 12:13 AM
 */
public class PlayTemplateLoader extends FileTemplateLoader {
  public TemplateFactory newTemplateFactory(String templatePath) throws TemplateLoadingException {
      return newTemplateFactory(templatePath, DefaultEncoding, null);
   }

   public TemplateFactory newTemplateFactory(String templatePath, String encoding) throws TemplateLoadingException {
      return newTemplateFactory(templatePath, encoding, null);
   }

   public TemplateFactory newTemplateFactory(String templatePath, TemplateModifier modifier) throws TemplateLoadingException {
      return newTemplateFactory(templatePath, DefaultEncoding, modifier);
   }

   public TemplateFactory newTemplateFactory(String templatePath, String encoding, TemplateModifier modifier) throws TemplateLoadingException {
      VirtualFile file = getTemplateFile(templatePath);
      TemplateDocument document = parseTemplate(file.getRealFile(), encoding);
      if (modifier != null) {
         modifier.modifyTemplate(document);
      }

      try {
         if (document.getIncludes() != null) {
            return new FileTemplateFactory(this, document.normalize(), file.getRealFile(), encoding, modifier, getFiles(document.getIncludes()), changeDetectionInterval);
         }

         return new FileTemplateFactory(this, document.normalize(), file.getRealFile(), encoding, modifier, null, changeDetectionInterval);
      } catch (BehaviorInstantiationException e) {
         throw new TemplateLoadingException(e);
      }
   }

   public TemplateDocument parseTemplate(String templatePath) throws TemplateLoadingException {
      VirtualFile file = getTemplateFile(templatePath);
      return parseTemplate(file.getRealFile(), DefaultEncoding);
   }

   public TemplateDocument parseTemplate(String templatePath, String encoding) throws TemplateLoadingException {
      VirtualFile file = getTemplateFile(templatePath);
      return parseTemplate(file.getRealFile(), encoding);
   }

   public HashSet<File> getFiles(HashSet<String> fileNames) {
      HashSet<File> files = new HashSet<File>();
      for (String s : fileNames) {
         VirtualFile f = getTemplateFile(s);
         if (f.exists()) {
            files.add(f.getRealFile());
         }
      }

      if (files.size() != 0) {
         return files;
      }

      return null;
   }

   private VirtualFile getTemplateFile(String path) {
      for (VirtualFile vf : Play.templatesPath) {
         if (vf == null) {
            continue;
         }
         VirtualFile tf = vf.child(path);
         if (tf.exists()) {
            return tf;
         }
      }

      VirtualFile tf = Play.getVirtualFile(path);
      if (tf != null && tf.exists()) {
         return tf;
      } else {
         throw new TemplateNotFoundException(path);
      }
   }
}
