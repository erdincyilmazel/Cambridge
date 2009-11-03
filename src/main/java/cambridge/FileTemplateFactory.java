package cambridge;

import cambridge.model.FragmentList;
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
 * Time: 4:03:22 PM
 */
public class FileTemplateFactory extends TemplateFactory {
   File templateFile;
   String encoding;
   TemplateModifier modifier;

   long lastCheck;

   public FileTemplateFactory(FragmentList fragments, File templateFile, String encoding) {
      super(fragments);
      this.templateFile = templateFile;
      this.encoding = encoding;
      lastCheck = System.currentTimeMillis();
   }

   public FileTemplateFactory(FragmentList fragments, File templateFile, String encoding, TemplateModifier modifier) {
      super(fragments);
      this.templateFile = templateFile;
      this.encoding = encoding;
      this.modifier = modifier;
      lastCheck = System.currentTimeMillis();
   }

   @Override
   public Template createTemplate() {
      if (lastCheck + 10000 < System.currentTimeMillis() && templateFile.lastModified() > lastCheck) {
         try {
            TemplateTokenizer tokenizer = new TemplateTokenizer(new InputStreamReader(new FileInputStream(templateFile), encoding));
            TemplateParser parser = new TemplateParser(tokenizer);
            TemplateDocument doc = parser.parse();
            if (modifier != null) {
               modifier.modifyTemplate(doc);
            }
            fragments = doc.normalize();
            lastCheck = System.currentTimeMillis();
         } catch (IOException e) {
            throw new TemplateReloadingException(e);
         } catch (TemplateParsingException e) {
            throw new TemplateReloadingException(e);
         } catch (BehaviorInstantiationException e) {
            e.printStackTrace();
         }
      }

      return new DynamicTemplate(fragments);
   }
}
