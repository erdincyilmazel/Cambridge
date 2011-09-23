package simplewebapp.servlets;

import cambridge.*;
import cambridge.model.Tag;
import cambridge.model.TemplateDocument;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * @author Erdinc Yilmazel
 * Date: May 6, 2010
 * Time: 8:50:52 AM
 */
public class IndexServlet extends HttpServlet {

   private TemplateFactory tf;


   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      Template t = tf.createTemplate();
      t.setProperty("message", "Hello World");
      t.printTo(resp.getWriter());
   }

   @Override
   public void init(ServletConfig config) throws ServletException {
      ServletContext ctx = config.getServletContext();
      File templateDir = new File(ctx.getRealPath("/WEB-INF/templates"));
      TemplateLoader loader = new DirectoryTemplateLoader(templateDir, "UTF-8");
      tf = loader.newTemplateFactory("index.html", new TemplateModifier() {
         public void modifyTemplate(TemplateDocument doc) {
            Tag li = doc.getElementsByTagName("li").get(1);
            try {
               li.addExpression(Expressions.parse("message"));
            } catch (ExpressionParsingException e) {
               e.printStackTrace();
            }
         }
      });
   }

}
