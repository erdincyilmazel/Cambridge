package cambridge.benchmarking;


import cambridge.DirectoryTemplateLoader;
import cambridge.Expressions;
import cambridge.Template;
import cambridge.TemplateFactory;
import cambridge.mvel.MvelExpressionLanguage;
import cambridge.ognl.OgnlExpressionLanguage;
import cambridge.parser.expressions.CambridgeExpressionLanguage;
import freemarker.ext.beans.BeansWrapper;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Erdinc YILMAZEL
 * @since 1/30/11
 */
public class Benchmarking {
   DataModel model;
   BufferedWriter writer;

   public Benchmarking(DataModel model) {
      this.model = model;
//      try {
//
//         writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("/dev/null")));
//      } catch (FileNotFoundException ex) {
//         Logger.getLogger(Benchmarking.class.getName()).log(Level.SEVERE, null, ex);
//      }

      writer = new BufferedWriter(new OutputStreamWriter(System.out));
   }

   public void renderCambridge(int loop) {
      DirectoryTemplateLoader templateLoader = new DirectoryTemplateLoader(
         new File("src/main/cambridgetemplates"), "utf-8", -1);

      TemplateFactory tf = templateLoader.newTemplateFactory("skeleton.html");

      for (int i = 0; i < loop; i++) {
         Template template = tf.createTemplate();
         DataModel.User loggedInUser = model.getLoggedInUser();
         template.setProperty("title", "Entries");
         template.setProperty("loggedInUser", loggedInUser);
         template.setProperty("entries", model.getEntries());
         try {
            template.printTo(writer);
            writer.flush();
         } catch (IOException e) {
            e.printStackTrace();
         }
      }
   }

   public void renderFreemarkerTemplate(int loop) {
      Configuration cfg = new Configuration();
      try {
         cfg.setDirectoryForTemplateLoading(
            new File("src/main/freemarkertemplates"));
      } catch (IOException e) {
         e.printStackTrace();
      }

      cfg.setObjectWrapper(new BeansWrapper());

      for (int i = 0; i < loop; i++) {
         try {
            freemarker.template.Template template = cfg.getTemplate("skeleton.ftl", "utf-8");
            HashMap<String, Object> data = new HashMap<String, Object>();

            DataModel.User loggedInUser = model.getLoggedInUser();
            data.put("title", "Entries");
            data.put("loggedInUser", loggedInUser);
            data.put("entries", model.getEntries());

            template.process(data, writer);
            writer.flush();
         } catch (IOException e) {
            e.printStackTrace();
         } catch (TemplateException e) {
            e.printStackTrace();
         }
      }
   }

   public static void main(String[] args) {
      System.err.println("Preparing random data...");
      Benchmarking benchmarking = new Benchmarking(new DataModel(100, 1000, 1500));
      System.err.println("Done.");

      long start = System.currentTimeMillis();
      benchmarking.renderCambridge(10);
      long end = System.currentTimeMillis();

      try {
         Thread.sleep(1000);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }

      long cambridgeElapsed = end - start;

      System.err.println("--------------------------------------------------------");
      System.err.println("--------------------------------------------------------");
      System.err.println("--------------------------------------------------------");
      System.err.println("--------------------------------------------------------");
      System.err.println("--------------------------------------------------------");
      System.err.println("--------------------------------------------------------");
      System.err.println("--------------------------------------------------------");
      System.err.println("--------------------------------------------------------");
      System.err.println("--------------------------------------------------------");

      try {
         Thread.sleep(1000);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }

      start = System.currentTimeMillis();
      benchmarking.renderFreemarkerTemplate(10);
      end = System.currentTimeMillis();

      System.err.println("Cambridge took :" + (cambridgeElapsed) + " ms");
      System.err.println("Freemarker took :" + (end - start) + " ms");
   }
}
