package cambridge;

import cambridge.model.TemplateDocument;
import cambridge.parser.TemplateParser;
import cambridge.parser.TemplateTokenizer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * User: erdinc
 * Date: Nov 3, 2009
 * Time: 3:20:20 PM
 */
public class FileTemplateLoader {
   public static final String DefaultEncoding = "UTF-8";

   public static TemplateFactory newTemplateFactory(File file) throws TemplateLoadingException {
      return newTemplateFactory(file, DefaultEncoding);
   }

   public static TemplateFactory newTemplateFactory(File file, String encoding) throws TemplateLoadingException {
      try {
         TemplateTokenizer tokenizer = new TemplateTokenizer(new InputStreamReader(new FileInputStream(file), encoding));
         TemplateParser parser = new TemplateParser(tokenizer);
         TemplateDocument document = parser.parse();
         return new FileTemplateFactory(document.normalize(), file, encoding);
      } catch (TemplateParsingException e) {
         throw new TemplateLoadingException(e);
      } catch (BehaviorInstantiationException e) {
         throw new TemplateLoadingException(e);
      } catch (IOException e) {
         throw new TemplateLoadingException(e);
      }
   }

   public static TemplateFactory newTemplateFactory(File file, TemplateModifier modifier) throws TemplateLoadingException {
      return newTemplateFactory(file, DefaultEncoding, modifier);
   }

   public static TemplateFactory newTemplateFactory(File file, String encoding, TemplateModifier modifier) throws TemplateLoadingException {
      try {
         TemplateTokenizer tokenizer = new TemplateTokenizer(new InputStreamReader(new FileInputStream(file), encoding));
         TemplateParser parser = new TemplateParser(tokenizer);
         TemplateDocument document = parser.parse();

         modifier.modifyTemplate(document);

         return new FileTemplateFactory(document.normalize(), file, encoding, modifier);
      } catch (TemplateParsingException e) {
         throw new TemplateLoadingException(e);
      } catch (BehaviorInstantiationException e) {
         throw new TemplateLoadingException(e);
      } catch (IOException e) {
         throw new TemplateLoadingException(e);
      }
   }

   public static TemplateDocument parseTemplate(File file, String encoding) throws TemplateLoadingException {
      try {
         TemplateTokenizer tokenizer = new TemplateTokenizer(new InputStreamReader(new FileInputStream(file), encoding));
         TemplateParser parser = new TemplateParser(tokenizer);
         return parser.parse();
      } catch (IOException e) {
         throw new TemplateLoadingException(e);
      } catch (TemplateParsingException e) {
         throw new TemplateLoadingException(e);
      }
   }

   public static TemplateDocument parseTemplate(File file) throws TemplateLoadingException {
      return parseTemplate(file, DefaultEncoding);
   }

   public static TemplateFactory newTemplateFactory(File file, TemplateLoader loader) throws TemplateLoadingException {
      return newTemplateFactory(file, DefaultEncoding, loader);
   }

   public static TemplateFactory newTemplateFactory(File file, String encoding, TemplateLoader loader) throws TemplateLoadingException {
      try {
         TemplateTokenizer tokenizer = new TemplateTokenizer(new InputStreamReader(new FileInputStream(file), encoding));
         TemplateParser parser = new TemplateParser(tokenizer, loader);
         TemplateDocument document = parser.parse();
         return new FileTemplateFactory(document.normalize(), file, encoding);
      } catch (TemplateParsingException e) {
         throw new TemplateLoadingException(e);
      } catch (BehaviorInstantiationException e) {
         throw new TemplateLoadingException(e);
      } catch (IOException e) {
         throw new TemplateLoadingException(e);
      }
   }

   public static TemplateFactory newTemplateFactory(File file, TemplateLoader loader, TemplateModifier modifier) throws TemplateLoadingException {
      return newTemplateFactory(file, DefaultEncoding, loader, modifier);
   }

   public static TemplateFactory newTemplateFactory(File file, String encoding, TemplateLoader loader, TemplateModifier modifier) throws TemplateLoadingException {
      try {
         TemplateTokenizer tokenizer = new TemplateTokenizer(new InputStreamReader(new FileInputStream(file), encoding));
         TemplateParser parser = new TemplateParser(tokenizer, loader);
         TemplateDocument document = parser.parse();

         modifier.modifyTemplate(document);

         return new FileTemplateFactory(document.normalize(), file, encoding, modifier);
      } catch (TemplateParsingException e) {
         throw new TemplateLoadingException(e);
      } catch (BehaviorInstantiationException e) {
         throw new TemplateLoadingException(e);
      } catch (IOException e) {
         throw new TemplateLoadingException(e);
      }
   }

   public static TemplateDocument parseTemplate(File file, String encoding, TemplateLoader loader) throws TemplateLoadingException {
      try {
         TemplateTokenizer tokenizer = new TemplateTokenizer(new InputStreamReader(new FileInputStream(file), encoding));
         TemplateParser parser = new TemplateParser(tokenizer, loader);
         return parser.parse();
      } catch (IOException e) {
         throw new TemplateLoadingException(e);
      } catch (TemplateParsingException e) {
         throw new TemplateLoadingException(e);
      }
   }

   public static TemplateDocument parseTemplate(File file, TemplateLoader loader) throws TemplateLoadingException {
      return parseTemplate(file, DefaultEncoding, loader);
   }
}
