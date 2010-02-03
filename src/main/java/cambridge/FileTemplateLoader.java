package cambridge;

import cambridge.model.TemplateDocument;
import cambridge.parser.TemplateParser;
import cambridge.parser.TemplateTokenizer;

import java.io.*;
import java.util.HashSet;

/**
 * User: erdinc
 * Date: Nov 3, 2009
 * Time: 3:20:20 PM
 */
public class FileTemplateLoader implements TemplateLoader {
   public static final String DefaultEncoding = "UTF-8";

   public TemplateFactory newTemplateFactory(File file) throws TemplateLoadingException {
      return newTemplateFactory(file, DefaultEncoding, null);
   }

   public TemplateFactory newTemplateFactory(File file, String encoding) throws TemplateLoadingException {
      return newTemplateFactory(file, encoding, null);
   }

   public TemplateFactory newTemplateFactory(File file, TemplateModifier modifier) throws TemplateLoadingException {
      return newTemplateFactory(file, DefaultEncoding, modifier);
   }

   public TemplateFactory newTemplateFactory(File file, String encoding, TemplateModifier modifier) throws TemplateLoadingException {
      TemplateDocument document = parseTemplate(file, encoding);
      if (modifier != null) {
         modifier.modifyTemplate(document);
      }

      try {
         if (document.getIncludes() != null) {
            return new FileTemplateFactory(this, document.normalize(), file, encoding, modifier, getFiles(document.getIncludes()));
         }

         return new FileTemplateFactory(this, document.normalize(), file, encoding, modifier);
      } catch (BehaviorInstantiationException e) {
         throw new TemplateLoadingException(e);
      }
   }

   public HashSet<File> getFiles(HashSet<String> fileNames) {
      HashSet<File> files = new HashSet<File>();
      for(String s : fileNames) {
         File f = new File(s);
         if(f.exists()) {
            files.add(f);
         }
      }

      if(files.size() != 0) {
         return files;
      }

      return null;
   }

   public TemplateDocument parseTemplate(InputStream in) throws TemplateLoadingException {
      return parseTemplate(in, DefaultEncoding);
   }

   public TemplateDocument parseTemplate(InputStream in, String encoding) throws TemplateLoadingException {
      TemplateTokenizer tokenizer = null;
      try {
         tokenizer = new TemplateTokenizer(new InputStreamReader(in, encoding));
         TemplateParser parser = new TemplateParser(tokenizer, this);
         return parser.parse();
      } catch (IOException e) {
         throw new TemplateLoadingException(e);
      } catch (TemplateParsingException e) {
         throw new TemplateLoadingException(e);
      } finally {
         if(tokenizer != null) {
            try {
               tokenizer.close();
            } catch (IOException e) {
               e.printStackTrace();
            }
         }
      }
   }

   public TemplateDocument parseTemplate(File file) throws TemplateLoadingException {
      return parseTemplate(file, DefaultEncoding);
   }

   public TemplateDocument parseTemplate(File file, String encoding) throws TemplateLoadingException {
      try {
         return parseTemplate(new FileInputStream(file), encoding);
      } catch (FileNotFoundException e) {
         throw new TemplateLoadingException(e);
      }
   }

   public TemplateFactory newTemplateFactory(String template) throws TemplateLoadingException {
      return newTemplateFactory(new File(template));
   }

   public TemplateFactory newTemplateFactory(String template, String encoding) throws TemplateLoadingException {
      return newTemplateFactory(new File(template), encoding);
   }

   public TemplateFactory newTemplateFactory(String template, TemplateModifier modifier) throws TemplateLoadingException {
      return newTemplateFactory(new File(template), modifier);
   }

   public TemplateFactory newTemplateFactory(String template, String encoding, TemplateModifier modifier) throws TemplateLoadingException {
      return newTemplateFactory(new File(template), encoding, modifier);
   }

   public TemplateDocument parseTemplate(String template) throws TemplateLoadingException {
      return parseTemplate(new File(template));
   }

   public TemplateDocument parseTemplate(String template, String encoding) throws TemplateLoadingException {
      return parseTemplate(new File(template), encoding);
   }
}
