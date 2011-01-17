package cambridge;

import cambridge.model.TemplateDocument;

import java.io.File;
import java.util.HashSet;

/**
 * User: erdinc
 * Date: Nov 3, 2009
 * Time: 6:15:47 PM
 */
public class DirectoryTemplateLoader extends FileTemplateLoader {
   private final File templateDirectory;
   private final String encoding;

   private static String fileSeperator = System.getProperty("file.separator");

   public DirectoryTemplateLoader(File templateDirectory) {
      this(templateDirectory, FileTemplateLoader.DefaultEncoding, DefaultChangeDetectionInterval);
   }

   public DirectoryTemplateLoader(File templateDirectory, String defaultEncoding) {
      this(templateDirectory, defaultEncoding, DefaultChangeDetectionInterval);
   }

   public DirectoryTemplateLoader(File templateDirectory, String defaultEncoding, int changeDetectionInterval) {
      super(changeDetectionInterval);
      this.templateDirectory = templateDirectory;
      if (!templateDirectory.isDirectory()) {
         throw new RuntimeException(templateDirectory + " is not a directory");
      }

      encoding = defaultEncoding;
   }

   public TemplateFactory newTemplateFactory(String template) throws TemplateLoadingException {
      return newTemplateFactory(template, encoding);
   }

   public TemplateFactory newTemplateFactory(String template, String encoding) throws TemplateLoadingException {
      File templateFile = new File(templateDirectory.getAbsolutePath() + fileSeperator + template);
      return newTemplateFactory(templateFile, encoding);
   }

   public TemplateFactory newTemplateFactory(String template, TemplateModifier modifier) throws TemplateLoadingException {
      return newTemplateFactory(template, encoding, modifier);
   }

   public TemplateFactory newTemplateFactory(String template, String encoding, TemplateModifier modifier) throws TemplateLoadingException {
      File templateFile = new File(templateDirectory.getAbsolutePath() + fileSeperator + template);
      return newTemplateFactory(templateFile, encoding, modifier);
   }

   @Override
   public TemplateDocument parseTemplate(String template) throws TemplateLoadingException {
      File templateFile = new File(templateDirectory.getAbsolutePath() + fileSeperator + template);
      return parseTemplate(templateFile);
   }

   @Override
   public TemplateDocument parseTemplate(String template, String encoding) throws TemplateLoadingException {
      File templateFile = new File(templateDirectory.getAbsolutePath() + fileSeperator + template);
      return parseTemplate(templateFile, encoding);
   }

   public HashSet<File> getFiles(HashSet<String> fileNames) {
      HashSet<File> files = new HashSet<File>();
      for(String s : fileNames) {
         File f;
         if(s.startsWith("/")) {
            f = new File(s);
         } else {
            f = new File(templateDirectory.getAbsolutePath() + fileSeperator + s);
         }

         if(f.exists()) {
            files.add(f);
         }
      }

      if(files.size() != 0) {
         return files;
      }

      return null;
   }
}
