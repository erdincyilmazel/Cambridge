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
import java.util.List;

/**
 * User: erdinc
 * Date: Oct 13, 2009
 * Time: 11:48:01 AM
 */
public class Cambridge {
   public Template getTemplate(String file, String encoding) throws IOException {
      TemplateTokenizer tokenizer = new TemplateTokenizer(new InputStreamReader(new FileInputStream(file), encoding));
      TemplateParser parser = new TemplateParser(tokenizer);

      TemplateModel model;
      try {
         model = parser.parse();
         FragmentList fragments = model.normalize();
         return new DynamicTemplate(fragments);
      } catch (TemplateParsingException e) {

         System.err.println(e.getMessage() + " line: " + e.getLine() + " col: " + e.getCol());
         if (e.getCause() != null) {
            System.err.println("Cause: " + e.getCause().getMessage());
            //e.getCause().printStackTrace();
         }
      } catch (BehaviorInstantiationException e) {
         System.err.println(e.getMessage());
      }


      return null;
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

      int count1;
      int count2;

      public int getCount1() {
         return count1;
      }

      public int getCount2() {
         return count2;
      }

      public boolean isCountValid() {
         return count1++ < 10;
      }

      public boolean isCount2Valid() {
         return !(count2++ < 10);
      }

      public List<Friend> getFriends() {
         ArrayList<Friend> friends = new ArrayList<Friend>();
         friends.add(new Friend("friend1"));
         friends.add(new Friend("friend2"));
         friends.add(new Friend("friend3"));
         friends.add(new Friend("friend4"));
         friends.add(new Friend("friend5"));

         return friends;
      }
   }

   static class Friend {
      String name;

      Friend(String name) {
         this.name = name;
      }

      public String getName() {
         return name;
      }
   }

   public static void main(String[] args) {
      try {
         Cambridge c = new Cambridge();
         Template t = c.getTemplate("kitchensink.html", "UTF-8");
         if (t != null) {
            t.setProperty("user", new User("erdinc", "erdinc@yilmazel.com"));
            t.setProperty("value", false);

            ArrayList<User> users = new ArrayList<User>();
            users.add(new User("bahar", "email@email.com"));
            users.add(new User("melike", "email@email.com"));
            users.add(new User("ahmet", "email@email.com"));
            users.add(new User("x", "email@email.com"));
            users.add(new User("y", "email@email.com"));

            t.setProperty("users", users);

            t.printTo(System.out);
         }
      } catch (IOException e) {
         e.printStackTrace();
      } catch (TemplateRuntimeException e) {
         e.printStackTrace();
      }
   }
}
