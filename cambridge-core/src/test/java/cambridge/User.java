package cambridge;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Erdinc Yilmazel
 * Date: Nov 3, 2009
 * Time: 6:05:40 PM
 */
public class User {
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
