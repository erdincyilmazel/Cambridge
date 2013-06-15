package cambridge;

import cambridge.model.TemplateDocument;

import java.io.File;
import java.util.HashSet;

/**
 * If you have a base directory where you put all your template files,
 * this TemplateLoader implementation can be used. All the templateName
 * parameters sent to this class's methods are considered relative to the
 * base template directory.
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

   public TemplateFactory newTemplateFactory(String template, ExpressionLanguage expressionLanguage) throws TemplateLoadingException {
      return newTemplateFactory(template, encoding, expressionLanguage);
   }

   public TemplateFactory newTemplateFactory(String template, String encoding, ExpressionLanguage expressionLanguage) throws TemplateLoadingException {
      File templateFile = new File(templateDirectory.getAbsolutePath() + fileSeperator + template);
      return newTemplateFactory(templateFile, encoding, expressionLanguage);
   }

   public TemplateFactory newTemplateFactory(String template, TemplateModifier modifier, ExpressionLanguage expressionLanguage) throws TemplateLoadingException {
      return newTemplateFactory(template, encoding, modifier, expressionLanguage);
   }

   public TemplateFactory newTemplateFactory(String template, String encoding, TemplateModifier modifier, ExpressionLanguage expressionLanguage) throws TemplateLoadingException {
      File templateFile = new File(templateDirectory.getAbsolutePath() + fileSeperator + template);
      return newTemplateFactory(templateFile, encoding, modifier, expressionLanguage);
   }

   @Override
   public TemplateDocument parseTemplate(String templateName, ExpressionLanguage expressionLanguage) throws TemplateLoadingException {
      File templateFile = new File(templateDirectory.getAbsolutePath() + fileSeperator + templateName);
      return parseTemplate(templateFile, expressionLanguage);
   }

   @Override
   public TemplateDocument parseTemplate(String templateName, String encoding, ExpressionLanguage expressionLanguage) throws TemplateLoadingException {
      File templateFile = new File(templateDirectory.getAbsolutePath() + fileSeperator + templateName);
      return parseTemplate(templateFile, encoding, expressionLanguage);
   }

   /**
    * Returns a Set of File objects for the given set of file names. The input set
    * should have relative paths to the base template directory.
    * @param fileNames Set of file names (Relative to the base template directory)
    * @return Returns a set of absolute File paths for the input file names.
    */
   public HashSet<File> getFiles(HashSet<String> fileNames) {
      HashSet<File> files = new HashSet<File>();
      for (String s : fileNames) {
         File f;
         if (s.startsWith("/")) {
            f = new File(s);
         } else {
            f = new File(templateDirectory.getAbsolutePath() + fileSeperator + s);
         }

         if (f.exists()) {
            files.add(f);
         }
      }

      if (files.size() != 0) {
         return files;
      }

      return null;
   }
}
