package cambridge;

import cambridge.model.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/**
 * User: erdinc
 * Date: Oct 13, 2009
 * Time: 11:48:01 AM
 */
public class Cambridge {

   public static void main(String[] args) {
      try {

         final DirectoryTemplateLoader loader = new DirectoryTemplateLoader(new File("."));
                
         final TemplateFactory f = loader.newTemplateFactory("kitchensink.html", new TemplateModifier() {
            @Override
            public void modifyTemplate(TemplateDocument doc) {

               TagNode node = doc.locateTag("/html/head");
               TagNode html = doc.locateTag("/html");

               html.removeChild(node);

               try {
                  html.insertChild(new IncludeFragment(loader, "a.html", "/html/head"));
               } catch (TemplateLoadingException e) {
                  e.printStackTrace();
               } catch (BehaviorInstantiationException e) {
                  e.printStackTrace();
               }

               doc.getElementById("email").addChild(new TextNode("cambridge rocks"));
               try {
                  doc.getElementById("email").addChild(new ExpressionNode("user.email"));
               } catch (ExpressionParsingException e) {
                  e.printStackTrace();
               }
            }
         });

         Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
               while (true) {

                  long start = System.currentTimeMillis();

                  Template t = f.createTemplate(new Locale("TR"));

                  t.setProperty("user", new User("erdinc", "erdinc@yilmazel.com"));
                  t.setProperty("value", false);

                  ArrayList<User> users = new ArrayList<User>();
                  users.add(new User("bahar", "email@email.com"));
                  users.add(new User("melike", "email@email.com"));
                  users.add(new User("ahmet", "email@email.com"));
                  users.add(new User("x", "email@email.com"));
                  users.add(new User("y", "email@email.com"));
                  t.setProperty("users", users);
                  t.setProperty("date", new Date());

                  try {
                     t.printTo(System.out);
                  } catch (IOException e) {
                     e.printStackTrace();
                  } catch (TemplateRuntimeException e) {
                     e.printStackTrace();
                  }

                  System.out.println("-----------------------------------------------------------------");
                  System.out.println("Rendered in " + (System.currentTimeMillis() - start) + " milliseconds");

                  try {
                     Thread.sleep(5000);
                  } catch (InterruptedException e) {
                     e.printStackTrace();
                  }
               }
            }
         });

         thread.start();

         BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
         reader.readLine();

         System.exit(0);

      } catch (TemplateLoadingException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}
