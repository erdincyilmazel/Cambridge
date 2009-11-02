package cambridge;

/**
 * User: erdinc
 * Date: Oct 13, 2009
 * Time: 11:51:56 AM
 */
public class User {
   String userName;
   String email;
   int id;

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

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }
}
