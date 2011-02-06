package cambridge.benchmarking;


import cambridge.DirectoryTemplateLoader;
import cambridge.Template;
import cambridge.TemplateFactory;
import cambridge.mvel.MvelExpressionLanguage;
import cambridge.ognl.OgnlExpressionLanguage;
import freemarker.ext.beans.BeansWrapper;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

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

      writer = new BufferedWriter(new OutputStreamWriter(System.out));
   }

   public Benchmarking(DataModel model, String outputFile) {
      this.model = model;
      try {

         writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile)));
      } catch (FileNotFoundException ex) {
         Logger.getLogger(Benchmarking.class.getName()).log(Level.SEVERE, null, ex);
      }
   }

   public void renderCambridge(int loop, String expressionLanguage) {
      DirectoryTemplateLoader templateLoader = new DirectoryTemplateLoader(
         new File("src/main/cambridgetemplates/" + expressionLanguage), "utf-8", -1);

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

   public void renderVelocityTemplate(int loop) {

      Velocity.setProperty(Velocity.RESOURCE_LOADER, "file");
      Velocity.setProperty(Velocity.FILE_RESOURCE_LOADER_CACHE, true);
      Velocity.setProperty(Velocity.FILE_RESOURCE_LOADER_PATH, "/Users/erdincyilmazel/projects/cambridge/samples/benchmarking/src/main/velocitytemplates");
      Velocity.init();

      for (int i = 0; i < loop; i++) {
         VelocityContext context = new VelocityContext();

         DataModel.User loggedInUser = model.getLoggedInUser();
         context.put("title", "Entries");
         context.put("loggedInUser", loggedInUser);
         context.put("entries", model.getEntries());

         org.apache.velocity.Template template = Velocity.getTemplate("skeleton.vm");

         template.merge(context, writer);
         try {
            writer.flush();
         } catch (IOException e) {
            e.printStackTrace();
         }
      }
   }

   static class Timer {
      long start;
      long stop;

      public void start() {
         start = System.currentTimeMillis();
      }

      public long elapsed() {
         return System.currentTimeMillis() - start;
      }
   }

   public static void main(String[] args) {
      MvelExpressionLanguage.register();
      OgnlExpressionLanguage.register();
      int iterations = 1;
      System.err.println("Preparing random data...");
      DataModel dataModel = new DataModel(100, 1000, 1500);
      System.err.println("Done.");

      Benchmarking benchmarking;

      if (args.length == 0) {
         iterations = 100;
      } else {
         iterations = Integer.parseInt(args[0]);
      }

      benchmarking = new Benchmarking(dataModel);

      Timer timer = new Timer();
      timer.start();
      benchmarking.renderCambridge(iterations, "simple");

      try {
         Thread.sleep(500);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }

      long cambridgeSimple = timer.elapsed();

      System.err.println();
      System.err.println("--------------------------------------------------------");
      System.err.println("--------------------------------------------------------");
      System.err.println();

      timer.start();
      benchmarking.renderCambridge(iterations, "mvel");

      try {
         Thread.sleep(500);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }

      long cambridgeMvel = timer.elapsed();

      System.err.println();
      System.err.println("--------------------------------------------------------");
      System.err.println("--------------------------------------------------------");
      System.err.println();

      timer.start();
      benchmarking.renderCambridge(iterations, "ognl");

      try {
         Thread.sleep(500);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }

      long cambridgeOgnl = timer.elapsed();

      System.err.println();
      System.err.println("--------------------------------------------------------");
      System.err.println("--------------------------------------------------------");
      System.err.println();

      try {
         Thread.sleep(500);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }

      timer.start();
      benchmarking.renderFreemarkerTemplate(iterations);
      long freemarkerElapsed = timer.elapsed();

      System.err.println();
      System.err.println("--------------------------------------------------------");
      System.err.println("--------------------------------------------------------");
      System.err.println();

      try {
         Thread.sleep(500);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }

      timer.start();
      benchmarking.renderVelocityTemplate(iterations);
      long velocityElapsed = timer.elapsed();

      System.err.println();
      System.err.println("--------------------------------------------------------");
      System.err.println("--------------------------------------------------------");
      System.err.println();

      System.err.println("Cambridge Simple took :" + (cambridgeSimple) + " ms");
      System.err.println("Cambridge Mvel took :" + (cambridgeMvel) + " ms");
      System.err.println("Cambridge Ognl took :" + (cambridgeOgnl) + " ms");
      System.err.println("Freemarker took :" + (freemarkerElapsed) + " ms");
      System.err.println("Velocity took :" + (velocityElapsed) + " ms");
   }
}
