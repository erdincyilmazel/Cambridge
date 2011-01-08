package simplewebapp.servlets;

import cambridge.DirectoryTemplateLoader;
import cambridge.Template;
import cambridge.TemplateFactory;
import cambridge.TemplateLoader;
import simplewebapp.model.User;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * User: erdinc
 * Date: May 6, 2010
 * Time: 9:11:28 AM
 */
public class UsersServlet extends HttpServlet {

   TemplateFactory tf;

   ArrayList<User> users;

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      Template t = tf.createTemplate();
      t.setProperty("users", users);
      t.printTo(resp.getWriter());
   }

   @Override
   public void init(ServletConfig config) throws ServletException {
      initData();

      ServletContext ctx = config.getServletContext();
      File templateDir = new File(ctx.getRealPath("/WEB-INF/templates"));
      TemplateLoader loader = new DirectoryTemplateLoader(templateDir, "UTF-8");
      tf = loader.newTemplateFactory("users.html");
   }


   private void initData() {
      users = new ArrayList<User>();
      users.add(new User("user1", "user1@domain.com"));
      users.add(new User("user2", "user2@domain.com"));
      users.add(new User("user3", "user3@domain.com"));
      users.add(new User("user4", "user4@domain.com"));
      users.add(new User("user5", "user5@domain.com"));
      users.add(new User("user6", "user6@domain.com"));
   }
}
