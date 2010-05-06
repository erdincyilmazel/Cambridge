package simplewebapp.model;

/**
 * User: erdinc
 * Date: May 6, 2010
 * Time: 8:51:53 AM
 */
public class User {
   String userName;
   String email;

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
   }
}
