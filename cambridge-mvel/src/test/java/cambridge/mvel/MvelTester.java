package cambridge.mvel;

import cambridge.DirectoryTemplateLoader;
import cambridge.Expressions;
import cambridge.Template;
import cambridge.TemplateFactory;
import cambridge.TemplateLoadingException;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 * @author Erdinc Yilmazel
 * Date: Oct 13, 2009
 * Time: 11:48:01 AM
 */
public class MvelTester {

    public static class Erdinc {
        public static String hello() {
            return "Hello";
        }
    }

    public static void main(String[] args) {
        try {
            MvelExpressionLanguage mvel = new MvelExpressionLanguage();

            try {
                mvel.getParserConfiguration().addImport("format", String.class.getMethod("format", String.class, Object[].class));
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }

            Expressions.setDefaultExpressionLanguage("mvel", mvel);
            final DirectoryTemplateLoader loader = new DirectoryTemplateLoader(new File("."));
            final TemplateFactory f = loader.newTemplateFactory("test.html");
            Template template = f.createTemplate();


            Writer writer = new OutputStreamWriter(System.out);
            template.printTo(writer);
            writer.flush();
            System.out.flush();

        } catch (TemplateLoadingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

