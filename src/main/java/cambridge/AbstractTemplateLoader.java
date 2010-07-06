package cambridge;

import cambridge.model.FragmentList;
import cambridge.model.TemplateDocument;
import cambridge.parser.TemplateParser;
import cambridge.parser.TemplateTokenizer;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;

/**
 * User: erdinc
 * Date: May 18, 2010
 * Time: 7:08:57 PM
 */
abstract class AbstractTemplateLoader implements TemplateLoader {
   public static final String DefaultEncoding = "UTF-8";

   public TemplateFactory parseAndCreateTemplateFactory(String templateSource) throws TemplateLoadingException {
      TemplateDocument doc = parseAndCreateTemplateDocument(templateSource);
      try {
         FragmentList fragments = doc.normalize();
         return new ImmutableTemplateFactory(this, fragments);
      } catch (BehaviorInstantiationException e) {
         throw new TemplateLoadingException(e);
      }
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
         if (tokenizer != null) {
            try {
               tokenizer.close();
            } catch (IOException e) {
               e.printStackTrace();
            }
         }
      }
   }

   public TemplateDocument parseAndCreateTemplateDocument(String source) throws TemplateLoadingException {
      TemplateTokenizer tokenizer = null;
      try {
         tokenizer = new TemplateTokenizer(new StringReader(source));
         TemplateParser parser = new TemplateParser(tokenizer, this);
         return parser.parse();
      } catch (IOException e) {
         throw new TemplateLoadingException(e);
      } catch (TemplateParsingException e) {
         throw new TemplateLoadingException(e);
      } finally {
         if (tokenizer != null) {
            try {
               tokenizer.close();
            } catch (IOException e) {
               e.printStackTrace();
            }
         }
      }
   }
}
