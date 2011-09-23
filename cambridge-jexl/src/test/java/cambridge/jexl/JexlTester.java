package cambridge.jexl;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import cambridge.DirectoryTemplateLoader;
import cambridge.Expressions;
import cambridge.Template;
import cambridge.TemplateFactory;
import cambridge.TemplateLoadingException;

/**
 * @author Jon Stevens
 */
public class JexlTester {

    public static class Erdinc {
        public static String hello() {
            return "Hello";
        }
        public static String format(String foo, String[] objects) {
            return String.format(foo, (Object[])objects);
        }
    }

    public static void main(String[] args) {
        try {
            JexlExpressionLanguage jexl = new JexlExpressionLanguage();

        	Map<String, Object> funcs = new HashMap<String, Object>();
        	funcs.put(null, Erdinc.class);
            jexl.getEngine().setFunctions(funcs);

            Expressions.setDefaultExpressionLanguage("jexl", jexl);
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

