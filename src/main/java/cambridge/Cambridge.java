package cambridge;

import cambridge.parser.TemplateParser;
import cambridge.parser.TemplateTokenizer;
import cambridge.parser.model.FragmentList;
import cambridge.parser.model.TemplateModel;
import cambridge.runtime.DynamicTemplate;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.antlr.runtime.RecognitionException;

/**
 * User: erdinc
 * Date: Oct 13, 2009
 * Time: 11:48:01 AM
 */
public class Cambridge {
   public Template getTemplate(String file, String encoding) throws IOException, TemplateParsingException, RecognitionException, BehaviorInstantiationException {
      TemplateTokenizer tokenizer = new TemplateTokenizer(new InputStreamReader(new FileInputStream(file), encoding));
      TemplateParser parser = new TemplateParser(tokenizer);

      TemplateModel model = parser.parse();

      FragmentList fragments = model.normalize();

      return new DynamicTemplate(fragments);
   }

   static class User {
      String userName;
      String email;
      boolean loggedIn;
      boolean admin;

      public String getUserName() {
         return userName;
      }

      public void setUserName(String userName) {
         this.userName = userName;
      }

      public String getEmail() {
         return email;
      }

      public void setEmail(String email) {
         this.email = email;
      }

      public User(String userName, String email) {
         this.userName = userName;
         this.email = email;
         admin = true;
      }

      public boolean isLoggedIn() {
         return loggedIn;
      }

      public void setLoggedIn(boolean loggedIn) {
         this.loggedIn = loggedIn;
      }

      public boolean isAdmin() {
         return admin;
      }

      public void setAdmin(boolean admin) {
         this.admin = admin;
      }
   }

   public static void main(String[] args) {
      try {
         Cambridge c = new Cambridge();
         Template t = c.getTemplate("custom.html", "UTF-8");
         t.setProperty("user", new User("erdinc", "erdinc@yilmazel.com"));
         t.setProperty("erdinc", false);

         ArrayList<User> users = new ArrayList<User>();
         users.add(new User("bahar", "email@email.com"));
         users.add(new User("melike", "email@email.com"));
         users.add(new User("ahmet", "email@email.com"));
         users.add(new User("x", "email@email.com"));
         users.add(new User("y", "email@email.com"));

         t.setProperty("users", users);

         t.printTo(System.out);
         t.printTo(System.out);
         t.printTo(System.out);
         t.printTo(System.out);
         t.printTo(System.out);
         t.printTo(System.out);
         t.printTo(System.out);
         t.printTo(System.out);
         t.printTo(System.out);
         t.printTo(System.out);
         t.printTo(System.out);
         t.printTo(System.out);
         t.printTo(System.out);
         t.printTo(System.out);
      } catch (IOException e) {
         e.printStackTrace();
      } catch (TemplateParsingException e) {
         e.printStackTrace();
      } catch (ExpressionEvaluationException e) {
         e.printStackTrace();
      } catch (RecognitionException e) {
         e.printStackTrace();
      } catch (BehaviorInstantiationException e) {
         e.printStackTrace();
      }
   }
}
